package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzbmy {
    private final List<String> zzcel;
    private int zzcem;

    private zzbmy(zzbmj com_google_android_gms_internal_zzbmj) throws DatabaseException {
        int i = 0;
        this.zzcel = new ArrayList();
        this.zzcem = 0;
        Iterator it = com_google_android_gms_internal_zzbmj.iterator();
        while (it.hasNext()) {
            this.zzcel.add(((zzbos) it.next()).asString());
        }
        this.zzcem = Math.max(1, this.zzcel.size());
        while (i < this.zzcel.size()) {
            this.zzcem = zza((CharSequence) this.zzcel.get(i)) + this.zzcem;
            i++;
        }
        zzSQ();
    }

    private void zzSQ() throws DatabaseException {
        if (this.zzcem > 768) {
            String valueOf = String.valueOf("Data has a key path longer than 768 bytes (");
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append(this.zzcem).append(").").toString());
        } else if (this.zzcel.size() > 32) {
            String valueOf2 = String.valueOf("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
            String valueOf3 = String.valueOf(zzXH());
            throw new DatabaseException(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }

    private String zzXG() {
        String str = (String) this.zzcel.remove(this.zzcel.size() - 1);
        this.zzcem -= zza(str);
        if (this.zzcel.size() > 0) {
            this.zzcem--;
        }
        return str;
    }

    private String zzXH() {
        if (this.zzcel.size() == 0) {
            return BuildConfig.FLAVOR;
        }
        String valueOf = String.valueOf(zze("/", this.zzcel));
        return new StringBuilder(String.valueOf(valueOf).length() + 10).append("in path '").append(valueOf).append("'").toString();
    }

    private static int zza(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= '\u007f') {
                i2++;
            } else if (charAt <= '\u07ff') {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    public static void zza(zzbmj com_google_android_gms_internal_zzbmj, Object obj) throws DatabaseException {
        new zzbmy(com_google_android_gms_internal_zzbmj).zzap(obj);
    }

    private void zzap(Object obj) throws DatabaseException {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    zzja(str);
                    zzap(map.get(str));
                    zzXG();
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                zzja(Integer.toString(i));
                zzap(list.get(i));
                zzXG();
            }
        }
    }

    private static String zze(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuilder.append(str);
            }
            stringBuilder.append((String) list.get(i));
        }
        return stringBuilder.toString();
    }

    private void zzja(String str) throws DatabaseException {
        if (this.zzcel.size() > 0) {
            this.zzcem++;
        }
        this.zzcel.add(str);
        this.zzcem += zza(str);
        zzSQ();
    }
}
