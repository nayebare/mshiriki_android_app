package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey extends zza {
    public static final Creator<CustomPropertyKey> CREATOR;
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
    private static final Pattern zzaNp;
    final int mVersionCode;
    final int mVisibility;
    final String zzAH;

    static {
        CREATOR = new zzc();
        zzaNp = Pattern.compile("[\\w.!@$%^&*()/-]+");
    }

    CustomPropertyKey(int i, String str, int i2) {
        boolean z = true;
        zzac.zzb((Object) str, (Object) "key");
        zzac.zzb(zzaNp.matcher(str).matches(), (Object) "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if (!(i2 == 0 || i2 == PRIVATE)) {
            z = false;
        }
        zzac.zzb(z, (Object) "visibility must be either PUBLIC or PRIVATE");
        this.mVersionCode = i;
        this.zzAH = str;
        this.mVisibility = i2;
    }

    public CustomPropertyKey(String str, int i) {
        this(PRIVATE, str, i);
    }

    public static CustomPropertyKey fromJson(JSONObject jSONObject) throws JSONException {
        return new CustomPropertyKey(jSONObject.getString("key"), jSONObject.getInt("visibility"));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPropertyKey)) {
            return false;
        }
        CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
        if (!(customPropertyKey.getKey().equals(this.zzAH) && customPropertyKey.getVisibility() == this.mVisibility)) {
            z = false;
        }
        return z;
    }

    public String getKey() {
        return this.zzAH;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        String str = this.zzAH;
        return new StringBuilder(String.valueOf(str).length() + 11).append(str).append(this.mVisibility).toString().hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put("visibility", getVisibility());
        return jSONObject;
    }

    public String toString() {
        String str = this.zzAH;
        return new StringBuilder(String.valueOf(str).length() + 31).append("CustomPropertyKey(").append(str).append(",").append(this.mVisibility).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
