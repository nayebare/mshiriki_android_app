package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PutDataRequest extends zza {
    public static final Creator<PutDataRequest> CREATOR;
    public static final String WEAR_URI_SCHEME = "wear";
    private static final long zzbQX;
    private static final Random zzbQY;
    private final Uri mUri;
    final int mVersionCode;
    private final Bundle zzbQZ;
    private long zzbRa;
    private byte[] zzbeh;

    static {
        CREATOR = new zzh();
        zzbQX = TimeUnit.MINUTES.toMillis(30);
        zzbQY = new SecureRandom();
    }

    private PutDataRequest(int i, Uri uri) {
        this(i, uri, new Bundle(), null, zzbQX);
    }

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr, long j) {
        this.mVersionCode = i;
        this.mUri = uri;
        this.zzbQZ = bundle;
        this.zzbQZ.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzbeh = bArr;
        this.zzbRa = j;
    }

    public static PutDataRequest create(String str) {
        return zzy(zziq(str));
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        PutDataRequest zzy = zzy(dataItem.getUri());
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                String str = "Cannot create an asset for a put request without a digest: ";
                String valueOf = String.valueOf((String) entry.getKey());
                throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
            zzy.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        zzy.setData(dataItem.getData());
        return zzy;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!str.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(zzbQY.nextLong());
        return new PutDataRequest(2, zziq(stringBuilder.toString()));
    }

    private static Uri zziq(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest zzy(Uri uri) {
        return new PutDataRequest(2, uri);
    }

    public Asset getAsset(String str) {
        return (Asset) this.zzbQZ.getParcelable(str);
    }

    public Map<String, Asset> getAssets() {
        Map hashMap = new HashMap();
        for (String str : this.zzbQZ.keySet()) {
            hashMap.put(str, (Asset) this.zzbQZ.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzbeh;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String str) {
        return this.zzbQZ.containsKey(str);
    }

    public boolean isUrgent() {
        return this.zzbRa == 0;
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        zzac.zzw(str);
        zzac.zzw(asset);
        this.zzbQZ.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        this.zzbQZ.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zzbeh = bArr;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzbRa = 0;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable("DataMap", 3));
    }

    public String toString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        String valueOf = String.valueOf(this.zzbeh == null ? "null" : Integer.valueOf(this.zzbeh.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 7).append("dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.zzbQZ.size());
        valueOf = String.valueOf(this.mUri);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 6).append(", uri=").append(valueOf).toString());
        stringBuilder.append(", syncDeadline=" + this.zzbRa);
        if (z) {
            stringBuilder.append("]\n  assets: ");
            for (String valueOf2 : this.zzbQZ.keySet()) {
                String valueOf3 = String.valueOf(this.zzbQZ.getParcelable(valueOf2));
                stringBuilder.append(new StringBuilder((String.valueOf(valueOf2).length() + 7) + String.valueOf(valueOf3).length()).append("\n    ").append(valueOf2).append(": ").append(valueOf3).toString());
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public Bundle zzSE() {
        return this.zzbQZ;
    }

    public long zzSF() {
        return this.zzbRa;
    }
}
