package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult extends zza implements Result {
    public static final Creator<DataReadResult> CREATOR;
    private final int mVersionCode;
    private final List<DataSet> zzaQX;
    private final List<Bucket> zzaWo;
    private int zzaWp;
    private final List<DataSource> zzaWq;
    private final List<DataType> zzaWr;
    private final Status zzahq;

    static {
        CREATOR = new zzc();
    }

    DataReadResult(int i, List<RawDataSet> list, Status status, List<RawBucket> list2, int i2, List<DataSource> list3, List<DataType> list4) {
        this.mVersionCode = i;
        this.zzahq = status;
        this.zzaWp = i2;
        this.zzaWq = list3;
        this.zzaWr = list4;
        this.zzaQX = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.zzaQX.add(new DataSet(dataSet, list3));
        }
        this.zzaWo = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.zzaWo.add(new Bucket(bucket, list3));
        }
    }

    public DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.mVersionCode = 5;
        this.zzaQX = list;
        this.zzahq = status;
        this.zzaWo = list2;
        this.zzaWp = 1;
        this.zzaWq = new ArrayList();
        this.zzaWr = new ArrayList();
    }

    public static DataReadResult zza(Status status, List<DataType> list, List<DataSource> list2) {
        List arrayList = new ArrayList();
        for (DataSource create : list2) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : list) {
            arrayList.add(DataSet.create(new Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                for (DataSet zza : bucket.getDataSets()) {
                    zza(zza, bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzaWo.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzahq.equals(dataReadResult.zzahq) && zzaa.equal(this.zzaQX, dataReadResult.zzaQX) && zzaa.equal(this.zzaWo, dataReadResult.zzaWo);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && zzc((DataReadResult) obj));
    }

    public List<Bucket> getBuckets() {
        return this.zzaWo;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzaQX) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        return DataSet.create(dataSource);
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzaQX) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        return DataSet.create(new Builder().setDataType(dataType).setType(1).build());
    }

    public List<DataSet> getDataSets() {
        return this.zzaQX;
    }

    public Status getStatus() {
        return this.zzahq;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzahq, this.zzaQX, this.zzaWo);
    }

    public String toString() {
        Object obj;
        zzaa.zza zzg = zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzahq);
        String str = "dataSets";
        if (this.zzaQX.size() > 5) {
            obj = this.zzaQX.size() + " data sets";
        } else {
            obj = this.zzaQX;
        }
        zzg = zzg.zzg(str, obj);
        str = "buckets";
        if (this.zzaWo.size() > 5) {
            obj = this.zzaWo.size() + " buckets";
        } else {
            obj = this.zzaWo;
        }
        return zzg.zzg(str, obj).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    List<DataSource> zzBr() {
        return this.zzaWq;
    }

    public int zzCC() {
        return this.zzaWp;
    }

    List<RawBucket> zzCD() {
        List<RawBucket> arrayList = new ArrayList(this.zzaWo.size());
        for (Bucket rawBucket : this.zzaWo) {
            arrayList.add(new RawBucket(rawBucket, this.zzaWq, this.zzaWr));
        }
        return arrayList;
    }

    List<RawDataSet> zzCE() {
        List<RawDataSet> arrayList = new ArrayList(this.zzaQX.size());
        for (DataSet rawDataSet : this.zzaQX) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzaWq, this.zzaWr));
        }
        return arrayList;
    }

    List<DataType> zzCF() {
        return this.zzaWr;
    }

    public void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zzaQX);
        }
        for (Bucket zza2 : dataReadResult.getBuckets()) {
            zza(zza2, this.zzaWo);
        }
    }
}
