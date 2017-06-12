package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class Subscription extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<Subscription> CREATOR;
    private final int mVersionCode;
    private final DataSource zzaRJ;
    private final DataType zzaRK;
    private final long zzaTN;
    private final int zzaTO;

    public static class zza {
        private DataSource zzaRJ;
        private DataType zzaRK;
        private long zzaTN;
        private int zzaTO;

        public zza() {
            this.zzaTN = -1;
            this.zzaTO = 2;
        }

        public Subscription zzBM() {
            boolean z = false;
            boolean z2 = (this.zzaRJ == null && this.zzaRK == null) ? false : true;
            zzac.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzaRK == null || this.zzaRJ == null || this.zzaRK.equals(this.zzaRJ.getDataType())) {
                z = true;
            }
            zzac.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new Subscription();
        }

        public zza zzb(DataSource dataSource) {
            this.zzaRJ = dataSource;
            return this;
        }

        public zza zzd(DataType dataType) {
            this.zzaRK = dataType;
            return this;
        }
    }

    static {
        CREATOR = new zzae();
    }

    Subscription(int i, DataSource dataSource, DataType dataType, long j, int i2) {
        this.mVersionCode = i;
        this.zzaRJ = dataSource;
        this.zzaRK = dataType;
        this.zzaTN = j;
        this.zzaTO = i2;
    }

    private Subscription(zza com_google_android_gms_fitness_data_Subscription_zza) {
        this.mVersionCode = 1;
        this.zzaRK = com_google_android_gms_fitness_data_Subscription_zza.zzaRK;
        this.zzaRJ = com_google_android_gms_fitness_data_Subscription_zza.zzaRJ;
        this.zzaTN = com_google_android_gms_fitness_data_Subscription_zza.zzaTN;
        this.zzaTO = com_google_android_gms_fitness_data_Subscription_zza.zzaTO;
    }

    private boolean zza(Subscription subscription) {
        return zzaa.equal(this.zzaRJ, subscription.zzaRJ) && zzaa.equal(this.zzaRK, subscription.zzaRK) && this.zzaTN == subscription.zzaTN && this.zzaTO == subscription.zzaTO;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Subscription) && zza((Subscription) obj));
    }

    public int getAccuracyMode() {
        return this.zzaTO;
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaRJ, this.zzaRJ, Long.valueOf(this.zzaTN), Integer.valueOf(this.zzaTO));
    }

    public String toDebugString() {
        String str = "Subscription{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.zzaRJ == null ? this.zzaRK.getName() : this.zzaRJ.toDebugString();
        return String.format(str, objArr);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("dataSource", this.zzaRJ).zzg("dataType", this.zzaRK).zzg("samplingIntervalMicros", Long.valueOf(this.zzaTN)).zzg("accuracyMode", Integer.valueOf(this.zzaTO)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public long zzBK() {
        return this.zzaTN;
    }

    public DataType zzBL() {
        return this.zzaRK == null ? this.zzaRJ.getDataType() : this.zzaRK;
    }
}
