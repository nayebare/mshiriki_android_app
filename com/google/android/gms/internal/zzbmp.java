package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.internal.zzbmr.zzb;
import com.google.android.gms.internal.zzbot.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class zzbmp {

    /* renamed from: com.google.android.gms.internal.zzbmp.1 */
    class C12331 implements zzb {
        final /* synthetic */ zzbmr zzcdr;
        final /* synthetic */ Map zzcds;

        C12331(zzbmr com_google_android_gms_internal_zzbmr, Map map) {
            this.zzcdr = com_google_android_gms_internal_zzbmr;
            this.zzcds = map;
        }

        public void zzf(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
            this.zzcdr.zzh(com_google_android_gms_internal_zzbmj, zzbmp.zza(com_google_android_gms_internal_zzbpe, this.zzcds));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbmp.2 */
    class C12342 extends zza {
        final /* synthetic */ Map zzcds;
        final /* synthetic */ zzbmq zzcdt;

        C12342(Map map, zzbmq com_google_android_gms_internal_zzbmq) {
            this.zzcds = map;
            this.zzcdt = com_google_android_gms_internal_zzbmq;
        }

        public void zzb(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
            zzbpe zza = zzbmp.zza(com_google_android_gms_internal_zzbpe, this.zzcds);
            if (zza != com_google_android_gms_internal_zzbpe) {
                this.zzcdt.zzg(new zzbmj(com_google_android_gms_internal_zzbos.asString()), zza);
            }
        }
    }

    public static zzbma zza(zzbma com_google_android_gms_internal_zzbma, Map<String, Object> map) {
        zzbma zzWE = zzbma.zzWE();
        Iterator it = com_google_android_gms_internal_zzbma.iterator();
        zzbma com_google_android_gms_internal_zzbma2 = zzWE;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            com_google_android_gms_internal_zzbma2 = com_google_android_gms_internal_zzbma2.zze((zzbmj) entry.getKey(), zza((zzbpe) entry.getValue(), (Map) map));
        }
        return com_google_android_gms_internal_zzbma2;
    }

    public static zzbmr zza(zzbmr com_google_android_gms_internal_zzbmr, Map<String, Object> map) {
        zzbmr com_google_android_gms_internal_zzbmr2 = new zzbmr();
        com_google_android_gms_internal_zzbmr.zza(new zzbmj(BuildConfig.FLAVOR), new C12331(com_google_android_gms_internal_zzbmr2, map));
        return com_google_android_gms_internal_zzbmr2;
    }

    public static zzbpe zza(zzbpe com_google_android_gms_internal_zzbpe, Map<String, Object> map) {
        Object value = com_google_android_gms_internal_zzbpe.zzZe().getValue();
        if (value instanceof Map) {
            Map map2 = (Map) value;
            if (map2.containsKey(".sv")) {
                value = map.get((String) map2.get(".sv"));
            }
        }
        zzbpe zzas = zzbpi.zzas(value);
        if (com_google_android_gms_internal_zzbpe.zzZd()) {
            value = zza(com_google_android_gms_internal_zzbpe.getValue(), (Map) map);
            return (value.equals(com_google_android_gms_internal_zzbpe.getValue()) && zzas.equals(com_google_android_gms_internal_zzbpe.zzZe())) ? com_google_android_gms_internal_zzbpe : zzbpf.zza(value, zzas);
        } else if (com_google_android_gms_internal_zzbpe.isEmpty()) {
            return com_google_android_gms_internal_zzbpe;
        } else {
            zzbot com_google_android_gms_internal_zzbot = (zzbot) com_google_android_gms_internal_zzbpe;
            zzbmq com_google_android_gms_internal_zzbmq = new zzbmq(com_google_android_gms_internal_zzbot);
            com_google_android_gms_internal_zzbot.zza(new C12342(map, com_google_android_gms_internal_zzbmq));
            return !com_google_android_gms_internal_zzbmq.zzXv().zzZe().equals(zzas) ? com_google_android_gms_internal_zzbmq.zzXv().zzg(zzas) : com_google_android_gms_internal_zzbmq.zzXv();
        }
    }

    public static Object zza(Object obj, Map<String, Object> map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(".sv")) {
            return obj;
        }
        String str = (String) map2.get(".sv");
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static Map<String, Object> zza(zzbpy com_google_android_gms_internal_zzbpy) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(com_google_android_gms_internal_zzbpy.zzZY()));
        return hashMap;
    }
}
