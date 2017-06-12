package com.google.android.gms.fitness.data;

import com.google.android.gms.internal.zzanj;

class zzg implements zzanj<DataType> {
    public static final zzg zzaRb;

    static {
        zzaRb = new zzg();
    }

    private zzg() {
    }

    private Field zzd(DataType dataType, int i) {
        return (Field) dataType.getFields().get(i);
    }

    public /* synthetic */ int zzD(Object obj) {
        return zzb((DataType) obj);
    }

    public /* synthetic */ String zzE(Object obj) {
        return zza((DataType) obj);
    }

    public String zza(DataType dataType) {
        return dataType.getName();
    }

    public String zza(DataType dataType, int i) {
        return zzd(dataType, i).getName();
    }

    public int zzb(DataType dataType) {
        return dataType.getFields().size();
    }

    public boolean zzb(DataType dataType, int i) {
        return Boolean.TRUE.equals(zzd(dataType, i).isOptional());
    }

    public int zzc(DataType dataType, int i) {
        return zzd(dataType, i).getFormat();
    }

    public /* synthetic */ int zze(Object obj, int i) {
        return zzc((DataType) obj, i);
    }

    public boolean zzea(String str) {
        return zzl.zzeb(str) != null;
    }

    public /* synthetic */ boolean zzf(Object obj, int i) {
        return zzb((DataType) obj, i);
    }

    public /* synthetic */ String zzg(Object obj, int i) {
        return zza((DataType) obj, i);
    }
}
