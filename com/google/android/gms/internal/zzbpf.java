package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbla.zza;
import com.google.firebase.database.DatabaseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzbpf {
    public static int zza(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe, zzbos com_google_android_gms_internal_zzbos2, zzbpe com_google_android_gms_internal_zzbpe2) {
        int compareTo = com_google_android_gms_internal_zzbpe.compareTo(com_google_android_gms_internal_zzbpe2);
        return compareTo != 0 ? compareTo : com_google_android_gms_internal_zzbos.zzi(com_google_android_gms_internal_zzbos2);
    }

    public static zzbpe zza(Object obj, zzbpe com_google_android_gms_internal_zzbpe) throws DatabaseException {
        try {
            Map map;
            Object obj2;
            List list;
            Map hashMap;
            int i;
            String str;
            zzbpe zzar;
            Map hashMap2;
            if (obj instanceof Map) {
                map = (Map) obj;
                if (map.containsKey(".priority")) {
                    com_google_android_gms_internal_zzbpe = zzbpi.zzas(map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj2 = map.get(".value");
                    if (obj2 == null) {
                        return zzbox.zzZp();
                    }
                    if (obj2 instanceof String) {
                        return new zzbpk((String) obj2, com_google_android_gms_internal_zzbpe);
                    }
                    if (obj2 instanceof Long) {
                        return new zzbpc((Long) obj2, com_google_android_gms_internal_zzbpe);
                    }
                    if (obj2 instanceof Integer) {
                        return new zzbpc(Long.valueOf((long) ((Integer) obj2).intValue()), com_google_android_gms_internal_zzbpe);
                    }
                    if (obj2 instanceof Double) {
                        return new zzbow((Double) obj2, com_google_android_gms_internal_zzbpe);
                    }
                    if (obj2 instanceof Boolean) {
                        return new zzbor((Boolean) obj2, com_google_android_gms_internal_zzbpe);
                    }
                    if (!(obj2 instanceof Map) || (obj2 instanceof List)) {
                        if (obj2 instanceof Map) {
                            list = (List) obj2;
                            hashMap = new HashMap(list.size());
                            for (i = 0; i < list.size(); i++) {
                                str = i;
                                zzar = zzar(list.get(i));
                                if (!zzar.isEmpty()) {
                                    hashMap.put(zzbos.zzjb(str), zzar);
                                }
                            }
                            map = hashMap;
                        } else {
                            map = (Map) obj2;
                            if (map.containsKey(".sv")) {
                                return new zzbov(map, com_google_android_gms_internal_zzbpe);
                            }
                            hashMap2 = new HashMap(map.size());
                            for (String str2 : map.keySet()) {
                                if (!str2.startsWith(".")) {
                                    zzar = zzar(map.get(str2));
                                    if (!zzar.isEmpty()) {
                                        hashMap2.put(zzbos.zzjb(str2), zzar);
                                    }
                                }
                            }
                            map = hashMap2;
                        }
                        return map.isEmpty() ? zzbox.zzZp() : new zzbot(zza.zzb(map, zzbot.zzcgP), com_google_android_gms_internal_zzbpe);
                    } else {
                        String str3 = "Failed to parse node with class ";
                        String valueOf = String.valueOf(obj2.getClass().toString());
                        throw new DatabaseException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                }
            }
            obj2 = obj;
            if (obj2 == null) {
                return zzbox.zzZp();
            }
            if (obj2 instanceof String) {
                return new zzbpk((String) obj2, com_google_android_gms_internal_zzbpe);
            }
            if (obj2 instanceof Long) {
                return new zzbpc((Long) obj2, com_google_android_gms_internal_zzbpe);
            }
            if (obj2 instanceof Integer) {
                return new zzbpc(Long.valueOf((long) ((Integer) obj2).intValue()), com_google_android_gms_internal_zzbpe);
            }
            if (obj2 instanceof Double) {
                return new zzbow((Double) obj2, com_google_android_gms_internal_zzbpe);
            }
            if (obj2 instanceof Boolean) {
                return new zzbor((Boolean) obj2, com_google_android_gms_internal_zzbpe);
            }
            if (obj2 instanceof Map) {
            }
            if (obj2 instanceof Map) {
                list = (List) obj2;
                hashMap = new HashMap(list.size());
                for (i = 0; i < list.size(); i++) {
                    str = i;
                    zzar = zzar(list.get(i));
                    if (!zzar.isEmpty()) {
                        hashMap.put(zzbos.zzjb(str), zzar);
                    }
                }
                map = hashMap;
            } else {
                map = (Map) obj2;
                if (map.containsKey(".sv")) {
                    return new zzbov(map, com_google_android_gms_internal_zzbpe);
                }
                hashMap2 = new HashMap(map.size());
                for (String str22 : map.keySet()) {
                    if (!str22.startsWith(".")) {
                        zzar = zzar(map.get(str22));
                        if (!zzar.isEmpty()) {
                            hashMap2.put(zzbos.zzjb(str22), zzar);
                        }
                    }
                }
                map = hashMap2;
            }
            if (map.isEmpty()) {
            }
        } catch (Throwable e) {
            throw new DatabaseException("Failed to parse node", e);
        }
    }

    public static zzbpe zzar(Object obj) throws DatabaseException {
        return zza(obj, zzbpi.zzZB());
    }
}
