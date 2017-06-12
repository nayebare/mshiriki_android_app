package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzang;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint extends zza implements ReflectedParcelable {
    public static final Creator<DataPoint> CREATOR;
    private final int versionCode;
    private final DataSource zzaQJ;
    private long zzaRc;
    private long zzaRd;
    private final Value[] zzaRe;
    private DataSource zzaRf;
    private long zzaRg;
    private long zzaRh;

    static {
        CREATOR = new zzh();
    }

    DataPoint(int i, DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3, long j4) {
        this.versionCode = i;
        this.zzaQJ = dataSource;
        this.zzaRf = dataSource2;
        this.zzaRc = j;
        this.zzaRd = j2;
        this.zzaRe = valueArr;
        this.zzaRg = j3;
        this.zzaRh = j4;
    }

    private DataPoint(DataSource dataSource) {
        this.versionCode = 4;
        this.zzaQJ = (DataSource) zzac.zzb((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzaRe = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.zzaRe[i] = new Value(format.getFormat());
            i++;
        }
    }

    public DataPoint(DataSource dataSource, DataSource dataSource2, RawDataPoint rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzaTA), 0), zza(Long.valueOf(rawDataPoint.zzaTB), 0), rawDataPoint.zzaTC, dataSource2, zza(Long.valueOf(rawDataPoint.zzaTF), 0), zza(Long.valueOf(rawDataPoint.zzaTG), 0));
    }

    DataPoint(List<DataSource> list, RawDataPoint rawDataPoint) {
        this(zzc(list, rawDataPoint.zzaTD), zzc(list, rawDataPoint.zzaTE), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        return intent == null ? null : (DataPoint) zzd.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private boolean zzBj() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    private static long zza(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private static DataSource zzc(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private boolean zzc(DataPoint dataPoint) {
        return zzaa.equal(this.zzaQJ, dataPoint.zzaQJ) && this.zzaRc == dataPoint.zzaRc && this.zzaRd == dataPoint.zzaRd && Arrays.equals(this.zzaRe, dataPoint.zzaRe) && zzaa.equal(getOriginalDataSource(), dataPoint.getOriginalDataSource());
    }

    private void zzgq(int i) {
        zzac.zzb(i == getDataType().getFields().size(), "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(getDataType().getFields().size()), getDataType().getFields());
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataPoint) && zzc((DataPoint) obj));
    }

    public DataSource getDataSource() {
        return this.zzaQJ;
    }

    public DataType getDataType() {
        return this.zzaQJ.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaRc, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.zzaRf != null ? this.zzaRf : this.zzaQJ;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaRd, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaRc, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.zzaRc;
    }

    public Value getValue(Field field) {
        return this.zzaRe[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaQJ, Long.valueOf(this.zzaRc), Long.valueOf(this.zzaRd));
    }

    public DataPoint setFloatValues(float... fArr) {
        zzgq(fArr.length);
        for (int i = 0; i < fArr.length; i++) {
            this.zzaRe[i].setFloat(fArr[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... iArr) {
        zzgq(iArr.length);
        for (int i = 0; i < iArr.length; i++) {
            this.zzaRe[i].setInt(iArr[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long j, long j2, TimeUnit timeUnit) {
        this.zzaRd = timeUnit.toNanos(j);
        this.zzaRc = timeUnit.toNanos(j2);
        return this;
    }

    public DataPoint setTimestamp(long j, TimeUnit timeUnit) {
        this.zzaRc = timeUnit.toNanos(j);
        if (zzBj() && zzang.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzaRc = zzang.zza(this.zzaRc, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zzaRe);
        objArr[1] = Long.valueOf(this.zzaRd);
        objArr[2] = Long.valueOf(this.zzaRc);
        objArr[3] = Long.valueOf(this.zzaRg);
        objArr[4] = Long.valueOf(this.zzaRh);
        objArr[5] = this.zzaQJ.toDebugString();
        objArr[6] = this.zzaRf != null ? this.zzaRf.toDebugString() : "N/A";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public Value[] zzBk() {
        return this.zzaRe;
    }

    public DataSource zzBl() {
        return this.zzaRf;
    }

    public long zzBm() {
        return this.zzaRg;
    }

    public long zzBn() {
        return this.zzaRh;
    }

    public void zzBo() {
        zzac.zzb(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        zzac.zzb(this.zzaRc > 0, "Data point does not have the timestamp set: %s", this);
        zzac.zzb(this.zzaRd <= this.zzaRc, "Data point with start time greater than end time found: %s", this);
    }

    public long zzBp() {
        return this.zzaRd;
    }

    public Value zzgp(int i) {
        DataType dataType = getDataType();
        if (i >= 0 && i < dataType.getFields().size()) {
            return this.zzaRe[i];
        }
        throw new IllegalArgumentException(String.format("fieldIndex %s is out of range for %s", new Object[]{Integer.valueOf(i), dataType}));
    }
}
