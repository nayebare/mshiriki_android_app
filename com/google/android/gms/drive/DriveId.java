package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzahm;
import com.google.android.gms.internal.zzaho;
import com.google.android.gms.internal.zzahp;
import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzalf;
import com.google.android.gms.internal.zzalg;
import com.google.android.gms.internal.zzbus;
import com.google.android.gms.internal.zzbut;

public class DriveId extends zza implements ReflectedParcelable {
    public static final Creator<DriveId> CREATOR;
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final long zzaJe;
    private volatile String zzaJg;
    final String zzaJv;
    final long zzaJw;
    final int zzaJx;
    private volatile String zzaJy;

    static {
        CREATOR = new zzh();
    }

    DriveId(int i, String str, long j, long j2, int i2) {
        boolean z = false;
        this.zzaJg = null;
        this.zzaJy = null;
        this.mVersionCode = i;
        this.zzaJv = str;
        zzac.zzas(!BuildConfig.FLAVOR.equals(str));
        if (!(str == null && j == -1)) {
            z = true;
        }
        zzac.zzas(z);
        this.zzaJw = j;
        this.zzaJe = j2;
        this.zzaJx = i2;
    }

    public DriveId(String str, long j, long j2, int i) {
        this(RESOURCE_TYPE_FOLDER, str, j, j2, i);
    }

    public static DriveId decodeFromString(String str) {
        boolean startsWith = str.startsWith("DriveId:");
        String str2 = "Invalid DriveId: ";
        String valueOf = String.valueOf(str);
        zzac.zzb(startsWith, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return zzt(Base64.decode(str.substring("DriveId:".length()), 10));
    }

    public static DriveId zzdH(String str) {
        zzac.zzw(str);
        return new DriveId(str, -1, -1, RESOURCE_TYPE_UNKNOWN);
    }

    static DriveId zzt(byte[] bArr) {
        try {
            zzalf zzu = zzalf.zzu(bArr);
            return new DriveId(zzu.versionCode, BuildConfig.FLAVOR.equals(zzu.zzaNi) ? null : zzu.zzaNi, zzu.zzaNj, zzu.zzaNg, zzu.zzaNk);
        } catch (zzbus e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzzE() {
        zzalg com_google_android_gms_internal_zzalg = new zzalg();
        com_google_android_gms_internal_zzalg.zzaNj = this.zzaJw;
        com_google_android_gms_internal_zzalg.zzaNg = this.zzaJe;
        return zzbut.zzf(com_google_android_gms_internal_zzalg);
    }

    public DriveFile asDriveFile() {
        if (this.zzaJx != RESOURCE_TYPE_FOLDER) {
            return new zzahm(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.zzaJx != 0) {
            return new zzaho(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        return this.zzaJx == RESOURCE_TYPE_FOLDER ? asDriveFolder() : this.zzaJx == 0 ? asDriveFile() : new zzahr(this);
    }

    public final String encodeToString() {
        if (this.zzaJg == null) {
            String encodeToString = Base64.encodeToString(zzzy(), 10);
            String valueOf = String.valueOf("DriveId:");
            encodeToString = String.valueOf(encodeToString);
            this.zzaJg = encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
        }
        return this.zzaJg;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzaJe != this.zzaJe) {
            return false;
        }
        if (driveId.zzaJw == -1 && this.zzaJw == -1) {
            return driveId.zzaJv.equals(this.zzaJv);
        }
        if (this.zzaJv == null || driveId.zzaJv == null) {
            if (driveId.zzaJw != this.zzaJw) {
                z = false;
            }
            return z;
        } else if (driveId.zzaJw != this.zzaJw) {
            return false;
        } else {
            if (driveId.zzaJv.equals(this.zzaJv)) {
                return true;
            }
            zzahp.zzE("DriveId", "Unexpected unequal resourceId for same DriveId object.");
            return false;
        }
    }

    public String getResourceId() {
        return this.zzaJv;
    }

    public int getResourceType() {
        return this.zzaJx;
    }

    public int hashCode() {
        if (this.zzaJw == -1) {
            return this.zzaJv.hashCode();
        }
        String valueOf = String.valueOf(String.valueOf(this.zzaJe));
        String valueOf2 = String.valueOf(String.valueOf(this.zzaJw));
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzaJy == null) {
            this.zzaJy = Base64.encodeToString(zzzE(), 10);
        }
        return this.zzaJy;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    final byte[] zzzy() {
        zzalf com_google_android_gms_internal_zzalf = new zzalf();
        com_google_android_gms_internal_zzalf.versionCode = this.mVersionCode;
        com_google_android_gms_internal_zzalf.zzaNi = this.zzaJv == null ? BuildConfig.FLAVOR : this.zzaJv;
        com_google_android_gms_internal_zzalf.zzaNj = this.zzaJw;
        com_google_android_gms_internal_zzalf.zzaNg = this.zzaJe;
        com_google_android_gms_internal_zzalf.zzaNk = this.zzaJx;
        return zzbut.zzf(com_google_android_gms_internal_zzalf);
    }
}
