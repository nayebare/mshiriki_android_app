package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class zzann {
    public static final Set<String> zzaTV;
    private static final zzann zzaTY;
    private final Map<String, Map<String, zza>> zzaTW;
    private final Map<String, zza> zzaTX;

    public static class zza {
        private final double zzaTZ;
        private final double zzaUa;

        private zza(double d, double d2) {
            this.zzaTZ = d;
            this.zzaUa = d2;
        }

        public boolean zzg(double d) {
            return d >= this.zzaTZ && d <= this.zzaUa;
        }
    }

    static {
        zzaTV = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"altitude", "duration", "food_item", "meal_type", "repetitions", "resistance", "resistance_type", "debug_session", "google.android.fitness.SessionV2"})));
        zzaTY = new zzann();
    }

    private zzann() {
        Map hashMap = new HashMap();
        hashMap.put("latitude", new zza(90.0d, null));
        hashMap.put("longitude", new zza(180.0d, null));
        hashMap.put("accuracy", new zza(10000.0d, null));
        hashMap.put("bpm", new zza(1000.0d, null));
        hashMap.put("altitude", new zza(100000.0d, null));
        hashMap.put("percentage", new zza(100.0d, null));
        hashMap.put("confidence", new zza(100.0d, null));
        hashMap.put("duration", new zza(9.223372036854776E18d, null));
        hashMap.put("height", new zza(3.0d, null));
        hashMap.put("weight", new zza(1000.0d, null));
        hashMap.put("speed", new zza(11000.0d, null));
        this.zzaTX = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put("com.google.step_count.delta", zzg("steps", new zza(1.0E-8d, null)));
        hashMap.put("com.google.calories.consumed", zzg(Field.NUTRIENT_CALORIES, new zza(1.0E-6d, null)));
        hashMap.put("com.google.calories.expended", zzg(Field.NUTRIENT_CALORIES, new zza(5.555555555555555E-10d, null)));
        hashMap.put("com.google.distance.delta", zzg("distance", new zza(1.0E-7d, null)));
        this.zzaTW = Collections.unmodifiableMap(hashMap);
    }

    public static zzann zzBT() {
        return zzaTY;
    }

    private static <K, V> Map<K, V> zzg(K k, V v) {
        Map<K, V> hashMap = new HashMap();
        hashMap.put(k, v);
        return hashMap;
    }

    zza zzJ(String str, String str2) {
        Map map = (Map) this.zzaTW.get(str);
        return map != null ? (zza) map.get(str2) : null;
    }

    zza zzen(String str) {
        return (zza) this.zzaTX.get(str);
    }
}
