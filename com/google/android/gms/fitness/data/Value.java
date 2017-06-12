package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzm;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Value extends zza {
    public static final Creator<Value> CREATOR;
    private final int format;
    private float value;
    private final int versionCode;
    private String zzaFy;
    private boolean zzaTP;
    private Map<String, MapValue> zzaTQ;
    private int[] zzaTR;
    private float[] zzaTS;
    private byte[] zzaTT;

    static {
        CREATOR = new zzaf();
    }

    public Value(int i) {
        this(3, i, false, 0.0f, null, null, null, null, null);
    }

    Value(int i, int i2, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        this.versionCode = i;
        this.format = i2;
        this.zzaTP = z;
        this.value = f;
        this.zzaFy = str;
        this.zzaTQ = zzB(bundle);
        this.zzaTR = iArr;
        this.zzaTS = fArr;
        this.zzaTT = bArr;
    }

    private static Map<String, MapValue> zzB(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        Map<String, MapValue> arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, (MapValue) bundle.getParcelable(str));
        }
        return arrayMap;
    }

    private boolean zza(Value value) {
        if (this.format != value.format || this.zzaTP != value.zzaTP) {
            return false;
        }
        switch (this.format) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return asInt() == value.asInt();
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return this.value == value.value;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return zzaa.equal(this.zzaFy, value.zzaFy);
            case Dimension.UNIT_IN /*4*/:
                return zzaa.equal(this.zzaTQ, value.zzaTQ);
            case Dimension.UNIT_MM /*5*/:
                return Arrays.equals(this.zzaTR, value.zzaTR);
            case BuyButtonText.LOGO_ONLY /*6*/:
                return Arrays.equals(this.zzaTS, value.zzaTS);
            case BuyButtonText.DONATE_WITH /*7*/:
                return Arrays.equals(this.zzaTT, value.zzaTT);
            default:
                return this.value == value.value;
        }
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzac.zza(this.format == 2, (Object) "Value is not in float format");
        return this.value;
    }

    public int asInt() {
        boolean z = true;
        if (this.format != 1) {
            z = false;
        }
        zzac.zza(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.value);
    }

    public String asString() {
        zzac.zza(this.format == 3, (Object) "Value is not in string format");
        return this.zzaFy;
    }

    public void clearKey(String str) {
        zzac.zza(this.format == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzaTQ != null) {
            this.zzaTQ.remove(str);
        }
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && zza((Value) obj));
    }

    public int getFormat() {
        return this.format;
    }

    @Nullable
    public Float getKeyValue(String str) {
        zzac.zza(this.format == 4, (Object) "Value is not in float map format");
        return (this.zzaTQ == null || !this.zzaTQ.containsKey(str)) ? null : Float.valueOf(((MapValue) this.zzaTQ.get(str)).asFloat());
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Float.valueOf(this.value), this.zzaFy, this.zzaTQ, this.zzaTR, this.zzaTS, this.zzaTT);
    }

    public boolean isSet() {
        return this.zzaTP;
    }

    public void setActivity(String str) {
        setInt(FitnessActivities.zzdY(str));
    }

    public void setFloat(float f) {
        zzac.zza(this.format == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzaTP = true;
        this.value = f;
    }

    public void setInt(int i) {
        zzac.zza(this.format == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzaTP = true;
        this.value = Float.intBitsToFloat(i);
    }

    public void setKeyValue(String str, float f) {
        zzac.zza(this.format == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzaTP = true;
        if (this.zzaTQ == null) {
            this.zzaTQ = new HashMap();
        }
        this.zzaTQ.put(str, MapValue.zzd(f));
    }

    public void setString(String str) {
        zzac.zza(this.format == 3, (Object) "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzaTP = true;
        this.zzaFy = str;
    }

    public String toString() {
        if (!this.zzaTP) {
            return "unset";
        }
        switch (this.format) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return Integer.toString(asInt());
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return Float.toString(this.value);
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return this.zzaFy;
            case Dimension.UNIT_IN /*4*/:
                return new TreeMap(this.zzaTQ).toString();
            case Dimension.UNIT_MM /*5*/:
                return Arrays.toString(this.zzaTR);
            case BuyButtonText.LOGO_ONLY /*6*/:
                return Arrays.toString(this.zzaTS);
            case BuyButtonText.DONATE_WITH /*7*/:
                return zzm.zza(this.zzaTT, 0, this.zzaTT.length, false);
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }

    float zzBI() {
        return this.value;
    }

    String zzBN() {
        return this.zzaFy;
    }

    Bundle zzBO() {
        if (this.zzaTQ == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzaTQ.size());
        for (Entry entry : this.zzaTQ.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        return bundle;
    }

    int[] zzBP() {
        return this.zzaTR;
    }

    float[] zzBQ() {
        return this.zzaTS;
    }

    byte[] zzBR() {
        return this.zzaTT;
    }
}
