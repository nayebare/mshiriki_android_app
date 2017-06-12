package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzf;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace extends zza implements ReflectedParcelable {
    public static final Creator<DriveSpace> CREATOR;
    public static final DriveSpace zzaJA;
    public static final DriveSpace zzaJB;
    public static final Set<DriveSpace> zzaJC;
    public static final String zzaJD;
    private static final Pattern zzaJE;
    public static final DriveSpace zzaJz;
    private final String mName;
    final int mVersionCode;

    static {
        CREATOR = new zzj();
        zzaJz = new DriveSpace("DRIVE");
        zzaJA = new DriveSpace("APP_DATA_FOLDER");
        zzaJB = new DriveSpace("PHOTOS");
        zzaJC = zzf.zza(zzaJz, zzaJA, zzaJB);
        zzaJD = TextUtils.join(",", zzaJC.toArray());
        zzaJE = Pattern.compile("[A-Z0-9_]*");
    }

    DriveSpace(int i, String str) {
        this.mVersionCode = i;
        this.mName = (String) zzac.zzw(str);
    }

    private DriveSpace(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        return (obj == null || obj.getClass() != DriveSpace.class) ? false : this.mName.equals(((DriveSpace) obj).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
