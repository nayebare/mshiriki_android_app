package com.google.android.gms.fitness.data;

import com.google.android.gms.internal.zzani;
import com.google.android.gms.internal.zzanj;
import java.util.concurrent.TimeUnit;

class zzf implements zzani<DataPoint, DataType> {
    public static final zzf zzaRa;

    static {
        zzaRa = new zzf();
    }

    private zzf() {
    }

    public /* synthetic */ Object zzB(Object obj) {
        return zzb((DataPoint) obj);
    }

    public zzanj<DataType> zzBi() {
        return zzg.zzaRb;
    }

    public /* synthetic */ String zzC(Object obj) {
        return zza((DataPoint) obj);
    }

    public long zza(DataPoint dataPoint, TimeUnit timeUnit) {
        return dataPoint.getEndTime(timeUnit) - dataPoint.getStartTime(timeUnit);
    }

    public String zza(DataPoint dataPoint) {
        return dataPoint.getDataType().getName();
    }

    public boolean zza(DataPoint dataPoint, int i) {
        return dataPoint.zzgp(i).isSet();
    }

    public /* synthetic */ double zzb(Object obj, int i) {
        return zzc((DataPoint) obj, i);
    }

    public int zzb(DataPoint dataPoint, int i) {
        return dataPoint.zzgp(i).asInt();
    }

    public DataType zzb(DataPoint dataPoint) {
        return dataPoint.getDataType();
    }

    public double zzc(DataPoint dataPoint, int i) {
        return (double) dataPoint.zzgp(i).asFloat();
    }

    public /* synthetic */ int zzc(Object obj, int i) {
        return zzb((DataPoint) obj, i);
    }

    public /* synthetic */ boolean zzd(Object obj, int i) {
        return zza((DataPoint) obj, i);
    }
}
