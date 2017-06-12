package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzaob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest extends zza {
    public static final Creator<DataTypeCreateRequest> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final List<Field> zzaVr;
    private final zzaob zzaVs;

    public static class Builder {
        private String mName;
        private List<Field> zzaVr;

        public Builder() {
            this.zzaVr = new ArrayList();
        }

        public Builder addField(Field field) {
            if (!this.zzaVr.contains(field)) {
                this.zzaVr.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            boolean z = (str == null || str.isEmpty()) ? false : true;
            zzac.zzb(z, (Object) "Invalid name specified");
            return addField(Field.zzn(str, i));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            zzac.zza(this.mName != null, (Object) "Must set the name");
            if (this.zzaVr.isEmpty()) {
                z = false;
            }
            zzac.zza(z, (Object) "Must specify the data fields");
            return new DataTypeCreateRequest();
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }
    }

    static {
        CREATOR = new zzm();
    }

    DataTypeCreateRequest(int i, String str, List<Field> list, IBinder iBinder) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzaVr = Collections.unmodifiableList(list);
        this.zzaVs = zzaob.zza.zzcs(iBinder);
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzaVr, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzaob com_google_android_gms_internal_zzaob) {
        this(dataTypeCreateRequest.mName, dataTypeCreateRequest.zzaVr, com_google_android_gms_internal_zzaob);
    }

    public DataTypeCreateRequest(String str, List<Field> list, zzaob com_google_android_gms_internal_zzaob) {
        this.mVersionCode = 3;
        this.mName = str;
        this.zzaVr = Collections.unmodifiableList(list);
        this.zzaVs = com_google_android_gms_internal_zzaob;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return zzaa.equal(this.mName, dataTypeCreateRequest.mName) && zzaa.equal(this.zzaVr, dataTypeCreateRequest.zzaVr);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) obj));
    }

    public IBinder getCallbackBinder() {
        return this.zzaVs == null ? null : this.zzaVs.asBinder();
    }

    public List<Field> getFields() {
        return this.zzaVr;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.mName, this.zzaVr);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("name", this.mName).zzg("fields", this.zzaVr).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
