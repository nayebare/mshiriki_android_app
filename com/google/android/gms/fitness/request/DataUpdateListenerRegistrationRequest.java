package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzaos;

public class DataUpdateListenerRegistrationRequest extends zza {
    public static final Creator<DataUpdateListenerRegistrationRequest> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private DataSource zzaRJ;
    private DataType zzaRK;
    private final zzaos zzaUS;

    public static class Builder {
        private PendingIntent mPendingIntent;
        private DataSource zzaRJ;
        private DataType zzaRK;

        public DataUpdateListenerRegistrationRequest build() {
            boolean z = (this.zzaRJ == null && this.zzaRK == null) ? false : true;
            zzac.zza(z, (Object) "Set either dataSource or dataTYpe");
            zzac.zzb(this.mPendingIntent, (Object) "pendingIntent must be set");
            return new DataUpdateListenerRegistrationRequest();
        }

        public Builder setDataSource(DataSource dataSource) throws NullPointerException {
            zzac.zzw(dataSource);
            this.zzaRJ = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            zzac.zzw(dataType);
            this.zzaRK = dataType;
            return this;
        }

        public Builder setPendingIntent(PendingIntent pendingIntent) {
            zzac.zzw(pendingIntent);
            this.mPendingIntent = pendingIntent;
            return this;
        }
    }

    static {
        CREATOR = new zzp();
    }

    DataUpdateListenerRegistrationRequest(int i, DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaRJ = dataSource;
        this.zzaRK = dataType;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    public DataUpdateListenerRegistrationRequest(DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = 1;
        this.zzaRJ = dataSource;
        this.zzaRK = dataType;
        this.mPendingIntent = pendingIntent;
        this.zzaUS = zzaos.zza.zzcJ(iBinder);
    }

    private DataUpdateListenerRegistrationRequest(Builder builder) {
        this(builder.zzaRJ, builder.zzaRK, builder.mPendingIntent, null);
    }

    public DataUpdateListenerRegistrationRequest(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest, IBinder iBinder) {
        this(dataUpdateListenerRegistrationRequest.zzaRJ, dataUpdateListenerRegistrationRequest.zzaRK, dataUpdateListenerRegistrationRequest.mPendingIntent, iBinder);
    }

    private boolean zzb(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return zzaa.equal(this.zzaRJ, dataUpdateListenerRegistrationRequest.zzaRJ) && zzaa.equal(this.zzaRK, dataUpdateListenerRegistrationRequest.zzaRK) && zzaa.equal(this.mPendingIntent, dataUpdateListenerRegistrationRequest.mPendingIntent);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataUpdateListenerRegistrationRequest) && zzb((DataUpdateListenerRegistrationRequest) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaUS == null ? null : this.zzaUS.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzaRJ;
    }

    public DataType getDataType() {
        return this.zzaRK;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaRJ, this.zzaRK, this.mPendingIntent);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("dataSource", this.zzaRJ).zzg("dataType", this.zzaRK).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
