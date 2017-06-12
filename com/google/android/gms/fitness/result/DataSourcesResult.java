package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult extends zza implements Result {
    public static final Creator<DataSourcesResult> CREATOR;
    private final int versionCode;
    private final List<DataSource> zzaWv;
    private final Status zzagv;

    static {
        CREATOR = new zzf();
    }

    DataSourcesResult(int i, List<DataSource> list, Status status) {
        this.versionCode = i;
        this.zzaWv = Collections.unmodifiableList(list);
        this.zzagv = status;
    }

    public DataSourcesResult(List<DataSource> list, Status status) {
        this.versionCode = 3;
        this.zzaWv = Collections.unmodifiableList(list);
        this.zzagv = status;
    }

    public static DataSourcesResult zzad(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult dataSourcesResult) {
        return this.zzagv.equals(dataSourcesResult.zzagv) && zzaa.equal(this.zzaWv, dataSourcesResult.zzaWv);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSourcesResult) && zzb((DataSourcesResult) obj));
    }

    public List<DataSource> getDataSources() {
        return this.zzaWv;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        List arrayList = new ArrayList();
        for (DataSource dataSource : this.zzaWv) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzagv;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzagv, this.zzaWv);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzagv).zzg("dataSources", this.zzaWv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
