package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.database.DatabaseException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.protocol.HTTP;

public class zzbky implements zzbno {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Charset zzavy;
    private final SQLiteDatabase zzbYw;
    private final zzbop zzbYx;
    private boolean zzbYy;
    private long zzbYz;

    /* renamed from: com.google.android.gms.internal.zzbky.1 */
    class C11851 implements com.google.android.gms.internal.zzbns.zza<Void, Integer> {
        final /* synthetic */ zzbns zzbYA;

        C11851(zzbky com_google_android_gms_internal_zzbky, zzbns com_google_android_gms_internal_zzbns) {
            this.zzbYA = com_google_android_gms_internal_zzbns;
        }

        public Integer zza(zzbmj com_google_android_gms_internal_zzbmj, Void voidR, Integer num) {
            return Integer.valueOf(this.zzbYA.zzK(com_google_android_gms_internal_zzbmj) == null ? num.intValue() + 1 : num.intValue());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbky.2 */
    class C11862 implements com.google.android.gms.internal.zzbns.zza<Void, Void> {
        final /* synthetic */ zzbns zzbYA;
        final /* synthetic */ List zzbYB;
        final /* synthetic */ zzbmj zzbYC;
        final /* synthetic */ zzbpe zzbYD;

        C11862(zzbky com_google_android_gms_internal_zzbky, zzbns com_google_android_gms_internal_zzbns, List list, zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
            this.zzbYA = com_google_android_gms_internal_zzbns;
            this.zzbYB = list;
            this.zzbYC = com_google_android_gms_internal_zzbmj;
            this.zzbYD = com_google_android_gms_internal_zzbpe;
        }

        public Void zza(zzbmj com_google_android_gms_internal_zzbmj, Void voidR, Void voidR2) {
            if (this.zzbYA.zzK(com_google_android_gms_internal_zzbmj) == null) {
                this.zzbYB.add(new zzbqd(this.zzbYC.zzh(com_google_android_gms_internal_zzbmj), this.zzbYD.zzO(com_google_android_gms_internal_zzbmj)));
            }
            return null;
        }
    }

    private static class zza extends SQLiteOpenHelper {
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !zzbky.class.desiredAssertionStatus();
        }

        public zza(Context context, String str) {
            super(context, str, null, 2);
        }

        private void zzc(SQLiteDatabase sQLiteDatabase, String str) {
            String str2 = "DROP TABLE IF EXISTS ";
            String valueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (!$assertionsDisabled && i2 != 2) {
                throw new AssertionError("Why is onUpgrade() called with a different version?");
            } else if (i <= 1) {
                zzc(sQLiteDatabase, "serverCache");
                sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
                zzc(sQLiteDatabase, "complete");
                sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            } else {
                throw new AssertionError("We don't handle upgrading to " + i2);
            }
        }
    }

    static {
        $assertionsDisabled = !zzbky.class.desiredAssertionStatus();
        zzavy = Charset.forName(HTTP.UTF_8);
    }

    public zzbky(Context context, zzbmc com_google_android_gms_internal_zzbmc, String str) {
        this.zzbYz = 0;
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.zzbYx = com_google_android_gms_internal_zzbmc.zziW("Persistence");
            this.zzbYw = zzJ(context, encode);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private SQLiteDatabase zzJ(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new zza(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (Throwable e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private byte[] zzS(List<byte[]> list) {
        int i = 0;
        for (byte[] length : list) {
            i = length.length + i;
        }
        Object obj = new byte[i];
        i = 0;
        for (byte[] length2 : list) {
            System.arraycopy(length2, 0, obj, i, length2.length);
            i = length2.length + i;
        }
        return obj;
    }

    private zzbpe zzT(byte[] bArr) {
        try {
            return zzbpf.zzar(zzbpx.zzjg(new String(bArr, zzavy)));
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Could not deserialize node: ";
            String valueOf = String.valueOf(new String(bArr, zzavy));
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
    }

    private void zzVi() {
        zzbqg.zzb(this.zzbYy, "Transaction expected to already be in progress.");
    }

    private int zza(zzbmj com_google_android_gms_internal_zzbmj, List<String> list, int i) {
        int i2 = i + 1;
        String zzc = zzc(com_google_android_gms_internal_zzbmj);
        if (((String) list.get(i)).startsWith(zzc)) {
            while (i2 < list.size() && ((String) list.get(i2)).equals(zza(com_google_android_gms_internal_zzbmj, i2 - i))) {
                i2++;
            }
            if (i2 < list.size()) {
                String str = (String) list.get(i2);
                String valueOf = String.valueOf(zzc);
                zzc = String.valueOf(".part-");
                if (str.startsWith(zzc.length() != 0 ? valueOf.concat(zzc) : new String(valueOf))) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i2 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private int zza(String str, zzbmj com_google_android_gms_internal_zzbmj) {
        String zziH = zziH(zzc(com_google_android_gms_internal_zzbmj));
        return this.zzbYw.delete(str, "path >= ? AND path < ?", new String[]{r1, zziH});
    }

    private Cursor zza(zzbmj com_google_android_gms_internal_zzbmj, String[] strArr) {
        String zzc = zzc(com_google_android_gms_internal_zzbmj);
        String zziH = zziH(zzc);
        String[] strArr2 = new String[(com_google_android_gms_internal_zzbmj.size() + 3)];
        String valueOf = String.valueOf(zzb(com_google_android_gms_internal_zzbmj, strArr2));
        String valueOf2 = String.valueOf(" OR (path > ? AND path < ?)");
        valueOf2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        strArr2[com_google_android_gms_internal_zzbmj.size() + 1] = zzc;
        strArr2[com_google_android_gms_internal_zzbmj.size() + 2] = zziH;
        return this.zzbYw.query("serverCache", strArr, valueOf2, strArr2, null, null, "path");
    }

    private String zza(zzbmj com_google_android_gms_internal_zzbmj, int i) {
        String valueOf = String.valueOf(zzc(com_google_android_gms_internal_zzbmj));
        String valueOf2 = String.valueOf(String.format(".part-%04d", new Object[]{Integer.valueOf(i)}));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private void zza(zzbmj com_google_android_gms_internal_zzbmj, long j, String str, byte[] bArr) {
        zzVi();
        this.zzbYw.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length >= AccessibilityNodeInfoCompat.ACTION_EXPAND) {
            List zzd = zzd(bArr, (int) AccessibilityNodeInfoCompat.ACTION_EXPAND);
            for (int i = 0; i < zzd.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(j));
                contentValues.put("path", zzc(com_google_android_gms_internal_zzbmj));
                contentValues.put("type", str);
                contentValues.put("part", Integer.valueOf(i));
                contentValues.put("node", (byte[]) zzd.get(i));
                this.zzbYw.insertWithOnConflict("writes", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", Long.valueOf(j));
        contentValues2.put("path", zzc(com_google_android_gms_internal_zzbmj));
        contentValues2.put("type", str);
        contentValues2.put("part", null);
        contentValues2.put("node", bArr);
        this.zzbYw.insertWithOnConflict("writes", null, contentValues2, 5);
    }

    private void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbmj com_google_android_gms_internal_zzbmj2, zzbns<Long> com_google_android_gms_internal_zzbns_java_lang_Long, zzbns<Long> com_google_android_gms_internal_zzbns_java_lang_Long2, zzbnp com_google_android_gms_internal_zzbnp, List<zzbqd<zzbmj, zzbpe>> list) {
        if (com_google_android_gms_internal_zzbns_java_lang_Long.getValue() != null) {
            if (((Integer) com_google_android_gms_internal_zzbnp.zza(Integer.valueOf(0), new C11851(this, com_google_android_gms_internal_zzbns_java_lang_Long2))).intValue() > 0) {
                zzbmj zzh = com_google_android_gms_internal_zzbmj.zzh(com_google_android_gms_internal_zzbmj2);
                if (this.zzbYx.zzYT()) {
                    this.zzbYx.zzi(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(r0), zzh}), new Object[0]);
                }
                com_google_android_gms_internal_zzbnp.zza(null, new C11862(this, com_google_android_gms_internal_zzbns_java_lang_Long2, list, com_google_android_gms_internal_zzbmj2, zzb(zzh)));
                return;
            }
            return;
        }
        Iterator it = com_google_android_gms_internal_zzbns_java_lang_Long.zzYe().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzbos com_google_android_gms_internal_zzbos = (zzbos) entry.getKey();
            zzbnp zzd = com_google_android_gms_internal_zzbnp.zzd((zzbos) entry.getKey());
            zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbmj2.zza(com_google_android_gms_internal_zzbos), (zzbns) entry.getValue(), com_google_android_gms_internal_zzbns_java_lang_Long2.zze(com_google_android_gms_internal_zzbos), zzd, list);
        }
    }

    private void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            i = 0;
            i2 = 0;
            for (zzbpd com_google_android_gms_internal_zzbpd : com_google_android_gms_internal_zzbpe) {
                i2 += zza("serverCache", com_google_android_gms_internal_zzbmj.zza(com_google_android_gms_internal_zzbpd.zzZz()));
                i = zzc(com_google_android_gms_internal_zzbmj.zza(com_google_android_gms_internal_zzbpd.zzZz()), com_google_android_gms_internal_zzbpd.zzUY()) + i;
            }
        } else {
            i2 = zza("serverCache", com_google_android_gms_internal_zzbmj);
            i = zzc(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe);
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), com_google_android_gms_internal_zzbmj.toString(), Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    private byte[] zzad(Object obj) {
        try {
            return zzbpx.zzat(obj).getBytes(zzavy);
        } catch (Throwable e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private zzbpe zzb(zzbmj com_google_android_gms_internal_zzbmj) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor zza = zza(com_google_android_gms_internal_zzbmj, new String[]{"path", "value"});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (zza.moveToNext()) {
            try {
                arrayList.add(zza.getString(0));
                arrayList2.add(zza.getBlob(1));
            } finally {
                zza.close();
            }
        }
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        zzbpe zzZp = zzbox.zzZp();
        Object obj = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < arrayList2.size()) {
            int zza2;
            zzbmj com_google_android_gms_internal_zzbmj2;
            zzbpe zzT;
            Object obj2;
            zzbpe com_google_android_gms_internal_zzbpe;
            if (((String) arrayList.get(i)).endsWith(".part-0000")) {
                String str = (String) arrayList.get(i);
                zzbmj com_google_android_gms_internal_zzbmj3 = new zzbmj(str.substring(0, str.length() - ".part-0000".length()));
                zza2 = zza(com_google_android_gms_internal_zzbmj3, arrayList, i);
                if (this.zzbYx.zzYT()) {
                    this.zzbYx.zzi("Loading split node with " + zza2 + " parts.", new Object[0]);
                }
                byte[] zzS = zzS(arrayList2.subList(i, i + zza2));
                zza2 = (i + zza2) - 1;
                com_google_android_gms_internal_zzbmj2 = com_google_android_gms_internal_zzbmj3;
                zzT = zzT(zzS);
            } else {
                zzbpe zzT2 = zzT((byte[]) arrayList2.get(i));
                zzbmj com_google_android_gms_internal_zzbmj4 = new zzbmj((String) arrayList.get(i));
                zzT = zzT2;
                zza2 = i;
                com_google_android_gms_internal_zzbmj2 = com_google_android_gms_internal_zzbmj4;
            }
            if (com_google_android_gms_internal_zzbmj2.zzXl() != null && com_google_android_gms_internal_zzbmj2.zzXl().zzZa()) {
                hashMap.put(com_google_android_gms_internal_zzbmj2, zzT);
                obj2 = obj;
                com_google_android_gms_internal_zzbpe = zzZp;
            } else if (com_google_android_gms_internal_zzbmj2.zzi(com_google_android_gms_internal_zzbmj)) {
                zzbqg.zzb(obj == null, "Descendants of path must come after ancestors.");
                Object obj3 = obj;
                com_google_android_gms_internal_zzbpe = zzT.zzO(zzbmj.zza(com_google_android_gms_internal_zzbmj2, com_google_android_gms_internal_zzbmj));
                obj2 = obj3;
            } else if (com_google_android_gms_internal_zzbmj.zzi(com_google_android_gms_internal_zzbmj2)) {
                obj2 = 1;
                com_google_android_gms_internal_zzbpe = zzZp.zzl(zzbmj.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbmj2), zzT);
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{com_google_android_gms_internal_zzbmj2, com_google_android_gms_internal_zzbmj}));
            }
            i = zza2 + 1;
            zzZp = com_google_android_gms_internal_zzbpe;
            obj = obj2;
        }
        for (Entry entry : hashMap.entrySet()) {
            zzZp = zzZp.zzl(zzbmj.zza(com_google_android_gms_internal_zzbmj, (zzbmj) entry.getKey()), (zzbpe) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(zzbqb.zzu(zzZp)), com_google_android_gms_internal_zzbmj, Long.valueOf(currentTimeMillis7), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis6)}), new Object[0]);
        }
        return zzZp;
    }

    private static String zzb(zzbmj com_google_android_gms_internal_zzbmj, String[] strArr) {
        if ($assertionsDisabled || strArr.length >= com_google_android_gms_internal_zzbmj.size() + 1) {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder("(");
            while (!com_google_android_gms_internal_zzbmj.isEmpty()) {
                stringBuilder.append("path");
                stringBuilder.append(" = ? OR ");
                strArr[i] = zzc(com_google_android_gms_internal_zzbmj);
                com_google_android_gms_internal_zzbmj = com_google_android_gms_internal_zzbmj.zzXk();
                i++;
            }
            stringBuilder.append("path");
            stringBuilder.append(" = ?)");
            strArr[i] = zzc(zzbmj.zzXf());
            return stringBuilder.toString();
        }
        throw new AssertionError();
    }

    private int zzc(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        long zzt = zzbqb.zzt(com_google_android_gms_internal_zzbpe);
        if (!(com_google_android_gms_internal_zzbpe instanceof zzbot) || zzt <= PlaybackStateCompat.ACTION_PREPARE) {
            zzd(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe);
            return 1;
        }
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{com_google_android_gms_internal_zzbmj, Long.valueOf(zzt), Integer.valueOf(AccessibilityNodeInfoCompat.ACTION_COPY)}), new Object[0]);
        }
        int i = 0;
        for (zzbpd com_google_android_gms_internal_zzbpd : com_google_android_gms_internal_zzbpe) {
            i = zzc(com_google_android_gms_internal_zzbmj.zza(com_google_android_gms_internal_zzbpd.zzZz()), com_google_android_gms_internal_zzbpd.zzUY()) + i;
        }
        if (!com_google_android_gms_internal_zzbpe.zzZe().isEmpty()) {
            zzd(com_google_android_gms_internal_zzbmj.zza(zzbos.zzYY()), com_google_android_gms_internal_zzbpe.zzZe());
            i++;
        }
        zzd(com_google_android_gms_internal_zzbmj, zzbox.zzZp());
        return i + 1;
    }

    private static String zzc(zzbmj com_google_android_gms_internal_zzbmj) {
        return com_google_android_gms_internal_zzbmj.isEmpty() ? "/" : String.valueOf(com_google_android_gms_internal_zzbmj.toString()).concat("/");
    }

    private static List<byte[]> zzd(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        List<byte[]> arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int min = Math.min(i, bArr.length - (i2 * i));
            Object obj = new byte[min];
            System.arraycopy(bArr, i2 * i, obj, 0, min);
            arrayList.add(obj);
        }
        return arrayList;
    }

    private void zzd(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        byte[] zzad = zzad(com_google_android_gms_internal_zzbpe.getValue(true));
        if (zzad.length >= AccessibilityNodeInfoCompat.ACTION_EXPAND) {
            List zzd = zzd(zzad, (int) AccessibilityNodeInfoCompat.ACTION_EXPAND);
            if (this.zzbYx.zzYT()) {
                this.zzbYx.zzi("Saving huge leaf node with " + zzd.size() + " parts.", new Object[0]);
            }
            for (int i = 0; i < zzd.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("path", zza(com_google_android_gms_internal_zzbmj, i));
                contentValues.put("value", (byte[]) zzd.get(i));
                this.zzbYw.insertWithOnConflict("serverCache", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("path", zzc(com_google_android_gms_internal_zzbmj));
        contentValues2.put("value", zzad);
        this.zzbYw.insertWithOnConflict("serverCache", null, contentValues2, 5);
    }

    private static String zziH(String str) {
        if ($assertionsDisabled || str.endsWith("/")) {
            String valueOf = String.valueOf(str.substring(0, str.length() - 1));
            return new StringBuilder(String.valueOf(valueOf).length() + 1).append(valueOf).append('0').toString();
        }
        throw new AssertionError("Path keys must end with a '/'");
    }

    private String zzp(Collection<Long> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (obj == null) {
                stringBuilder.append(",");
            }
            stringBuilder.append(longValue2);
            obj = null;
        }
        return stringBuilder.toString();
    }

    public void beginTransaction() {
        zzbqg.zzb(!this.zzbYy, "runInTransaction called when an existing transaction is already in progress.");
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi("Starting transaction.", new Object[0]);
        }
        this.zzbYw.beginTransaction();
        this.zzbYy = true;
        this.zzbYz = System.currentTimeMillis();
    }

    public void endTransaction() {
        this.zzbYw.endTransaction();
        this.zzbYy = false;
        long currentTimeMillis = System.currentTimeMillis() - this.zzbYz;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void setTransactionSuccessful() {
        this.zzbYw.setTransactionSuccessful();
    }

    public List<zzbmx> zzVe() {
        String[] strArr = new String[]{"id", "path", "type", "part", "node"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzbYw.query("writes", strArr, null, null, null, null, "id, part");
        List<zzbmx> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                byte[] blob;
                Object com_google_android_gms_internal_zzbmx;
                long j = query.getLong(0);
                zzbmj com_google_android_gms_internal_zzbmj = new zzbmj(query.getString(1));
                String string = query.getString(2);
                if (query.isNull(3)) {
                    blob = query.getBlob(4);
                } else {
                    List arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(query.getBlob(4));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } while (query.getLong(0) == j);
                    query.moveToPrevious();
                    blob = zzS(arrayList2);
                }
                Object zzjg = zzbpx.zzjg(new String(blob, zzavy));
                if ("o".equals(string)) {
                    com_google_android_gms_internal_zzbmx = new zzbmx(j, com_google_android_gms_internal_zzbmj, zzbpf.zzar(zzjg), true);
                } else if ("m".equals(string)) {
                    com_google_android_gms_internal_zzbmx = new zzbmx(j, com_google_android_gms_internal_zzbmj, zzbma.zzaA((Map) zzjg));
                } else {
                    String str = "Got invalid write type: ";
                    String valueOf = String.valueOf(string);
                    throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                arrayList.add(com_google_android_gms_internal_zzbmx);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public long zzVf() {
        long j = null;
        Cursor rawQuery = this.zzbYw.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{"value", "path", "serverCache"}), null);
        try {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                return j;
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    public List<zzbnq> zzVg() {
        String[] strArr = new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzbYw.query("trackedQueries", strArr, null, null, null, null, "id");
        List<zzbnq> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzbnq(query.getLong(0), zzboe.zzb(new zzbmj(query.getString(1)), zzbpx.zzjf(query.getString(2))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public void zzVh() {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzbYw.delete("writes", null, null);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Deleted %d (all) write(s) in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public zzbpe zza(zzbmj com_google_android_gms_internal_zzbmj) {
        return zzb(com_google_android_gms_internal_zzbmj);
    }

    public void zza(long j, Set<zzbos> set) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        this.zzbYw.delete("trackedKeys", "id = ?", new String[]{valueOf});
        for (zzbos com_google_android_gms_internal_zzbos : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_google_android_gms_internal_zzbos.asString());
            this.zzbYw.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(long j, Set<zzbos> set, Set<zzbos> set2) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id = ? AND key = ?";
        String valueOf = String.valueOf(j);
        for (zzbos com_google_android_gms_internal_zzbos : set2) {
            this.zzbYw.delete("trackedKeys", str, new String[]{valueOf, com_google_android_gms_internal_zzbos.asString()});
        }
        for (zzbos com_google_android_gms_internal_zzbos2 : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_google_android_gms_internal_zzbos2.asString());
            this.zzbYw.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = com_google_android_gms_internal_zzbma.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            i += zza("serverCache", com_google_android_gms_internal_zzbmj.zzh((zzbmj) entry.getKey()));
            i2 = zzc(com_google_android_gms_internal_zzbmj.zzh((zzbmj) entry.getKey()), (zzbpe) entry.getValue()) + i2;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), com_google_android_gms_internal_zzbmj.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbma com_google_android_gms_internal_zzbma, long j) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        zzbmj com_google_android_gms_internal_zzbmj2 = com_google_android_gms_internal_zzbmj;
        long j2 = j;
        zza(com_google_android_gms_internal_zzbmj2, j2, "m", zzad(com_google_android_gms_internal_zzbma.zzaZ(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbnp com_google_android_gms_internal_zzbnp) {
        if (com_google_android_gms_internal_zzbnp.zzXY()) {
            zzVi();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor zza = zza(com_google_android_gms_internal_zzbmj, new String[]{"rowid", "path"});
            zzbns com_google_android_gms_internal_zzbns = new zzbns(null);
            zzbns com_google_android_gms_internal_zzbns2 = new zzbns(null);
            while (zza.moveToNext()) {
                long j = zza.getLong(0);
                zzbmj com_google_android_gms_internal_zzbmj2 = new zzbmj(zza.getString(1));
                zzbop com_google_android_gms_internal_zzbop;
                String valueOf;
                String valueOf2;
                if (com_google_android_gms_internal_zzbmj.zzi(com_google_android_gms_internal_zzbmj2)) {
                    zzbmj zza2 = zzbmj.zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbmj2);
                    if (com_google_android_gms_internal_zzbnp.zzw(zza2)) {
                        com_google_android_gms_internal_zzbns = com_google_android_gms_internal_zzbns.zzb(zza2, Long.valueOf(j));
                    } else if (com_google_android_gms_internal_zzbnp.zzx(zza2)) {
                        com_google_android_gms_internal_zzbns2 = com_google_android_gms_internal_zzbns2.zzb(zza2, Long.valueOf(j));
                    } else {
                        com_google_android_gms_internal_zzbop = this.zzbYx;
                        valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
                        valueOf2 = String.valueOf(com_google_android_gms_internal_zzbmj2);
                        com_google_android_gms_internal_zzbop.warn(new StringBuilder((String.valueOf(valueOf).length() + 88) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" and have data at ").append(valueOf2).append(" that isn't marked for pruning or keeping. Ignoring.").toString());
                    }
                } else {
                    com_google_android_gms_internal_zzbop = this.zzbYx;
                    valueOf = String.valueOf(com_google_android_gms_internal_zzbmj);
                    valueOf2 = String.valueOf(com_google_android_gms_internal_zzbmj2);
                    com_google_android_gms_internal_zzbop.warn(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" but we have data stored higher up at ").append(valueOf2).append(". Ignoring.").toString());
                }
            }
            int i = 0;
            int i2 = 0;
            if (!com_google_android_gms_internal_zzbns.isEmpty()) {
                List<zzbqd> arrayList = new ArrayList();
                zza(com_google_android_gms_internal_zzbmj, zzbmj.zzXf(), com_google_android_gms_internal_zzbns, com_google_android_gms_internal_zzbns2, com_google_android_gms_internal_zzbnp, arrayList);
                Collection values = com_google_android_gms_internal_zzbns.values();
                String valueOf3 = String.valueOf(zzp(values));
                this.zzbYw.delete("serverCache", new StringBuilder(String.valueOf(valueOf3).length() + 11).append("rowid IN (").append(valueOf3).append(")").toString(), null);
                for (zzbqd com_google_android_gms_internal_zzbqd : arrayList) {
                    zzc(com_google_android_gms_internal_zzbmj.zzh((zzbmj) com_google_android_gms_internal_zzbqd.getFirst()), (zzbpe) com_google_android_gms_internal_zzbqd.zzZZ());
                }
                i = values.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.zzbYx.zzYT()) {
                this.zzbYx.zzi(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}), new Object[0]);
            }
        }
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        zzVi();
        zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe, false);
    }

    public void zza(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe, long j) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        zzbmj com_google_android_gms_internal_zzbmj2 = com_google_android_gms_internal_zzbmj;
        long j2 = j;
        zza(com_google_android_gms_internal_zzbmj2, j2, "o", zzad(com_google_android_gms_internal_zzbpe.getValue(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzbnq com_google_android_gms_internal_zzbnq) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(com_google_android_gms_internal_zzbnq.id));
        contentValues.put("path", zzc(com_google_android_gms_internal_zzbnq.zzcfe.zzVc()));
        contentValues.put("queryParams", com_google_android_gms_internal_zzbnq.zzcfe.zzYG().zzYE());
        contentValues.put("lastUse", Long.valueOf(com_google_android_gms_internal_zzbnq.zzcff));
        contentValues.put("complete", Boolean.valueOf(com_google_android_gms_internal_zzbnq.zzcfg));
        contentValues.put("active", Boolean.valueOf(com_google_android_gms_internal_zzbnq.zzcfh));
        this.zzbYw.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void zzaA(long j) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzbYw.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void zzaB(long j) {
        zzVi();
        String valueOf = String.valueOf(j);
        this.zzbYw.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.zzbYw.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    public void zzaC(long j) {
        zzVi();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.valueOf(false));
        contentValues.put("lastUse", Long.valueOf(j));
        this.zzbYw.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public Set<zzbos> zzaD(long j) {
        return zzg(Collections.singleton(Long.valueOf(j)));
    }

    public void zzb(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        zzVi();
        zza(com_google_android_gms_internal_zzbmj, com_google_android_gms_internal_zzbpe, true);
    }

    public Set<zzbos> zzg(Set<Long> set) {
        String[] strArr = new String[]{"key"};
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf("id IN (");
        String valueOf2 = String.valueOf(zzp(set));
        Cursor query = this.zzbYw.query(true, "trackedKeys", strArr, new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append(valueOf2).append(")").toString(), null, null, null, null, null);
        Set<zzbos> hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(zzbos.zzjb(query.getString(0)));
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbYx.zzYT()) {
            this.zzbYx.zzi(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return hashSet;
    }
}
