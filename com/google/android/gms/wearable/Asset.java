package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;

public class Asset extends zza implements ReflectedParcelable {
    public static final Creator<Asset> CREATOR;
    final int mVersionCode;
    public Uri uri;
    private String zzbQN;
    public ParcelFileDescriptor zzbQO;
    private byte[] zzbeh;

    static {
        CREATOR = new zze();
    }

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.mVersionCode = i;
        this.zzbeh = bArr;
        this.zzbQN = str;
        this.zzbQO = parcelFileDescriptor;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] bArr) {
        if (bArr != null) {
            return new Asset(1, bArr, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(1, null, null, parcelFileDescriptor, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String str) {
        if (str != null) {
            return new Asset(1, null, str, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(1, null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return Arrays.equals(this.zzbeh, asset.zzbeh) && zzaa.equal(this.zzbQN, asset.zzbQN) && zzaa.equal(this.zzbQO, asset.zzbQO) && zzaa.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzbeh;
    }

    public String getDigest() {
        return this.zzbQN;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzbQO;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this.zzbeh, this.zzbQN, this.zzbQO, this.uri});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzbQN == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.zzbQN);
        }
        if (this.zzbeh != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.zzbeh.length);
        }
        if (this.zzbQO != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.zzbQO);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i | 1);
    }
}
