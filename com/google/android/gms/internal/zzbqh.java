package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.games.quest.Quests;
import com.google.firebase.database.DatabaseException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzbqh {
    private static final Pattern zzciC;
    private static final Pattern zzciD;

    static {
        zzciC = Pattern.compile("[\\[\\]\\.#$]");
        zzciD = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");
    }

    private static boolean zzP(zzbmj com_google_android_gms_internal_zzbmj) {
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        return zzXi == null || !zzXi.asString().startsWith(".");
    }

    public static void zzQ(zzbmj com_google_android_gms_internal_zzbmj) throws DatabaseException {
        if (!zzP(com_google_android_gms_internal_zzbmj)) {
            String str = "Invalid write location: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj.toString());
            throw new DatabaseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public static void zzav(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.containsKey(".sv")) {
                for (Entry entry : map.entrySet()) {
                    zzjr((String) entry.getKey());
                    zzav(entry.getValue());
                }
            }
        } else if (obj instanceof List) {
            for (Object zzav : (List) obj) {
                zzav(zzav);
            }
        }
    }

    public static Map<zzbmj, zzbpe> zzc(zzbmj com_google_android_gms_internal_zzbmj, Map<String, Object> map) throws DatabaseException {
        Map treeMap = new TreeMap();
        for (Entry entry : map.entrySet()) {
            zzbmj com_google_android_gms_internal_zzbmj2 = new zzbmj((String) entry.getKey());
            Object value = entry.getValue();
            zzbmy.zza(com_google_android_gms_internal_zzbmj.zzh(com_google_android_gms_internal_zzbmj2), value);
            String asString = !com_google_android_gms_internal_zzbmj2.isEmpty() ? com_google_android_gms_internal_zzbmj2.zzXl().asString() : BuildConfig.FLAVOR;
            if (asString.equals(".sv") || asString.equals(".value")) {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj2);
                throw new DatabaseException(new StringBuilder((String.valueOf(valueOf).length() + 40) + String.valueOf(asString).length()).append("Path '").append(valueOf).append("' contains disallowed child name: ").append(asString).toString());
            } else if (!asString.equals(".priority") || zzbpi.zzq(zzbpf.zzar(value))) {
                zzav(value);
                treeMap.put(com_google_android_gms_internal_zzbmj2, zzbpf.zzar(value));
            } else {
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzbmj2);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 83).append("Path '").append(valueOf2).append("' contains invalid priority (must be a string, double, ServerValue, or null).").toString());
            }
        }
        zzbmj com_google_android_gms_internal_zzbmj3 = null;
        for (zzbmj com_google_android_gms_internal_zzbmj4 : treeMap.keySet()) {
            boolean z = com_google_android_gms_internal_zzbmj3 == null || com_google_android_gms_internal_zzbmj3.zzj(com_google_android_gms_internal_zzbmj4) < 0;
            zzbqg.zzaW(z);
            if (com_google_android_gms_internal_zzbmj3 == null || !com_google_android_gms_internal_zzbmj3.zzi(com_google_android_gms_internal_zzbmj4)) {
                com_google_android_gms_internal_zzbmj3 = com_google_android_gms_internal_zzbmj4;
            } else {
                valueOf2 = String.valueOf(com_google_android_gms_internal_zzbmj3);
                asString = String.valueOf(com_google_android_gms_internal_zzbmj4);
                throw new DatabaseException(new StringBuilder((String.valueOf(valueOf2).length() + 42) + String.valueOf(asString).length()).append("Path '").append(valueOf2).append("' is an ancestor of '").append(asString).append("' in an update.").toString());
            }
        }
        return treeMap;
    }

    private static boolean zzjl(String str) {
        return !zzciC.matcher(str).find();
    }

    public static void zzjm(String str) throws DatabaseException {
        if (!zzjl(str)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + Quests.SELECT_COMPLETED_UNCLAIMED).append("Invalid Firebase Database path: ").append(str).append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void zzjn(String str) throws DatabaseException {
        if (str.startsWith(".info")) {
            zzjm(str.substring(5));
        } else if (str.startsWith("/.info")) {
            zzjm(str.substring(6));
        } else {
            zzjm(str);
        }
    }

    private static boolean zzjo(String str) {
        return str != null && str.length() > 0 && (str.equals(".value") || str.equals(".priority") || !(str.startsWith(".") || zzciD.matcher(str).find()));
    }

    private static boolean zzjp(String str) {
        return str.equals(".info") || !zzciD.matcher(str).find();
    }

    public static void zzjq(String str) throws DatabaseException {
        if (str != null && !zzjp(str)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void zzjr(String str) throws DatabaseException {
        if (!zzjo(str)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
        }
    }
}
