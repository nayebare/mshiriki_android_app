package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzanm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet extends zza implements ReflectedParcelable {
    public static final Creator<DataSet> CREATOR;
    private final int versionCode;
    private final DataType zzaQI;
    private final DataSource zzaQJ;
    private final List<DataPoint> zzaRi;
    private final List<DataSource> zzaRj;
    private boolean zzaRk;

    static {
        CREATOR = new zzi();
    }

    DataSet(int i, DataSource dataSource, DataType dataType, List<RawDataPoint> list, List<DataSource> list2, boolean z) {
        List singletonList;
        this.zzaRk = false;
        this.versionCode = i;
        this.zzaQJ = dataSource;
        this.zzaQI = dataSource.getDataType();
        this.zzaRk = z;
        this.zzaRi = new ArrayList(list.size());
        if (i < 2) {
            singletonList = Collections.singletonList(dataSource);
        }
        this.zzaRj = singletonList;
        for (RawDataPoint dataPoint : list) {
            this.zzaRi.add(new DataPoint(this.zzaRj, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzaRk = false;
        this.versionCode = 3;
        this.zzaQJ = (DataSource) zzac.zzw(dataSource);
        this.zzaQI = dataSource.getDataType();
        this.zzaRi = new ArrayList();
        this.zzaRj = new ArrayList();
        this.zzaRj.add(this.zzaQJ);
    }

    public DataSet(RawDataSet rawDataSet, List<DataSource> list) {
        this.zzaRk = false;
        this.versionCode = 3;
        this.zzaQJ = (DataSource) zzd(list, rawDataSet.zzaTD);
        this.zzaQI = this.zzaQJ.getDataType();
        this.zzaRj = list;
        this.zzaRk = rawDataSet.zzaQZ;
        List<RawDataPoint> list2 = rawDataSet.zzaTI;
        this.zzaRi = new ArrayList(list2.size());
        for (RawDataPoint dataPoint : list2) {
            this.zzaRi.add(new DataPoint(this.zzaRj, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzac.zzb((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzaa.equal(getDataType(), dataSet.getDataType()) && zzaa.equal(this.zzaQJ, dataSet.zzaQJ) && zzaa.equal(this.zzaRi, dataSet.zzaRi) && this.zzaRk == dataSet.zzaRk;
    }

    private static <T> T zzd(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    public static void zze(DataPoint dataPoint) throws IllegalArgumentException {
        String zza = zzanm.zza(dataPoint, zzf.zzaRa);
        if (zza != null) {
            String valueOf = String.valueOf(dataPoint);
            Log.w("Fitness", new StringBuilder(String.valueOf(valueOf).length() + 20).append("Invalid data point: ").append(valueOf).toString());
            throw new IllegalArgumentException(zza);
        }
    }

    public void add(DataPoint dataPoint) {
        Object[] objArr = new Object[]{dataPoint.getDataSource(), this.zzaQJ};
        zzac.zzb(dataPoint.getDataSource().getStreamIdentifier().equals(this.zzaQJ.getStreamIdentifier()), "Conflicting data sources found %s vs %s", objArr);
        dataPoint.zzBo();
        zze(dataPoint);
        zzd(dataPoint);
    }

    public void addAll(Iterable<DataPoint> iterable) {
        for (DataPoint add : iterable) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzaQJ);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataSet) && zza((DataSet) obj));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzaRi);
    }

    public DataSource getDataSource() {
        return this.zzaQJ;
    }

    public DataType getDataType() {
        return this.zzaQJ.getDataType();
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaQJ);
    }

    public boolean isEmpty() {
        return this.zzaRi.isEmpty();
    }

    public String toString() {
        List zzBq = zzBq();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzaQJ.toDebugString();
        if (this.zzaRi.size() >= 10) {
            zzBq = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzaRi.size()), zzBq.subList(0, 5)});
        }
        objArr[1] = zzBq;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    List<RawDataPoint> zzA(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.zzaRi.size());
        for (DataPoint rawDataPoint : this.zzaRi) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public boolean zzBh() {
        return this.zzaRk;
    }

    List<RawDataPoint> zzBq() {
        return zzA(this.zzaRj);
    }

    List<DataSource> zzBr() {
        return this.zzaRj;
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzd : iterable) {
            zzd(zzd);
        }
    }

    public void zzd(DataPoint dataPoint) {
        this.zzaRi.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzaRj.contains(originalDataSource)) {
            this.zzaRj.add(originalDataSource);
        }
    }
}
