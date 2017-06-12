package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzbmj implements Comparable<zzbmj>, Iterable<zzbos> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final zzbmj zzccd;
    private final int end;
    private final int start;
    private final zzbos[] zzccc;

    /* renamed from: com.google.android.gms.internal.zzbmj.1 */
    class C12161 implements Iterator<zzbos> {
        int offset;
        final /* synthetic */ zzbmj zzcce;

        C12161(zzbmj com_google_android_gms_internal_zzbmj) {
            this.zzcce = com_google_android_gms_internal_zzbmj;
            this.offset = this.zzcce.start;
        }

        public boolean hasNext() {
            return this.offset < this.zzcce.end;
        }

        public /* synthetic */ Object next() {
            return zzXm();
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove component from immutable Path!");
        }

        public zzbos zzXm() {
            if (hasNext()) {
                zzbos com_google_android_gms_internal_zzbos = this.zzcce.zzccc[this.offset];
                this.offset++;
                return com_google_android_gms_internal_zzbos;
            }
            throw new NoSuchElementException("No more elements.");
        }
    }

    static {
        $assertionsDisabled = !zzbmj.class.desiredAssertionStatus();
        zzccd = new zzbmj(BuildConfig.FLAVOR);
    }

    public zzbmj(String str) {
        String[] split = str.split("/");
        int i = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i++;
            }
        }
        this.zzccc = new zzbos[i];
        int length2 = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            String str2 = split[i2];
            if (str2.length() > 0) {
                i = i3 + 1;
                this.zzccc[i3] = zzbos.zzjb(str2);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.start = 0;
        this.end = this.zzccc.length;
    }

    public zzbmj(List<String> list) {
        this.zzccc = new zzbos[list.size()];
        int i = 0;
        for (String zzjb : list) {
            int i2 = i + 1;
            this.zzccc[i] = zzbos.zzjb(zzjb);
            i = i2;
        }
        this.start = 0;
        this.end = list.size();
    }

    public zzbmj(zzbos... com_google_android_gms_internal_zzbosArr) {
        this.zzccc = (zzbos[]) Arrays.copyOf(com_google_android_gms_internal_zzbosArr, com_google_android_gms_internal_zzbosArr.length);
        this.start = 0;
        this.end = com_google_android_gms_internal_zzbosArr.length;
        int length = com_google_android_gms_internal_zzbosArr.length;
        int i = 0;
        while (i < length) {
            zzbos com_google_android_gms_internal_zzbos = com_google_android_gms_internal_zzbosArr[i];
            if ($assertionsDisabled || com_google_android_gms_internal_zzbos != null) {
                i++;
            } else {
                throw new AssertionError("Can't construct a path with a null value!");
            }
        }
    }

    private zzbmj(zzbos[] com_google_android_gms_internal_zzbosArr, int i, int i2) {
        this.zzccc = com_google_android_gms_internal_zzbosArr;
        this.start = i;
        this.end = i2;
    }

    public static zzbmj zzXf() {
        return zzccd;
    }

    public static zzbmj zza(zzbmj com_google_android_gms_internal_zzbmj, zzbmj com_google_android_gms_internal_zzbmj2) {
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        zzbos zzXi2 = com_google_android_gms_internal_zzbmj2.zzXi();
        if (zzXi == null) {
            return com_google_android_gms_internal_zzbmj2;
        }
        if (zzXi.equals(zzXi2)) {
            return zza(com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzbmj2.zzXj());
        }
        String valueOf = String.valueOf(com_google_android_gms_internal_zzbmj2);
        String valueOf2 = String.valueOf(com_google_android_gms_internal_zzbmj);
        throw new DatabaseException(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()).append("INTERNAL ERROR: ").append(valueOf).append(" is not contained in ").append(valueOf2).toString());
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzj((zzbmj) obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbmj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzbmj com_google_android_gms_internal_zzbmj = (zzbmj) obj;
        if (size() != com_google_android_gms_internal_zzbmj.size()) {
            return false;
        }
        int i = this.start;
        int i2 = com_google_android_gms_internal_zzbmj.start;
        while (i < this.end && i2 < com_google_android_gms_internal_zzbmj.end) {
            if (!this.zzccc[i].equals(com_google_android_gms_internal_zzbmj.zzccc[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 37) + this.zzccc[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.start >= this.end;
    }

    public Iterator<zzbos> iterator() {
        return new C12161(this);
    }

    public int size() {
        return this.end - this.start;
    }

    public String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            stringBuilder.append("/");
            stringBuilder.append(this.zzccc[i].asString());
        }
        return stringBuilder.toString();
    }

    public String zzXg() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            if (i > this.start) {
                stringBuilder.append("/");
            }
            stringBuilder.append(this.zzccc[i].asString());
        }
        return stringBuilder.toString();
    }

    public List<String> zzXh() {
        List<String> arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((zzbos) it.next()).asString());
        }
        return arrayList;
    }

    public zzbos zzXi() {
        return isEmpty() ? null : this.zzccc[this.start];
    }

    public zzbmj zzXj() {
        int i = this.start;
        if (!isEmpty()) {
            i++;
        }
        return new zzbmj(this.zzccc, i, this.end);
    }

    public zzbmj zzXk() {
        return isEmpty() ? null : new zzbmj(this.zzccc, this.start, this.end - 1);
    }

    public zzbos zzXl() {
        return !isEmpty() ? this.zzccc[this.end - 1] : null;
    }

    public zzbmj zza(zzbos com_google_android_gms_internal_zzbos) {
        int size = size();
        Object obj = new zzbos[(size + 1)];
        System.arraycopy(this.zzccc, this.start, obj, 0, size);
        obj[size] = com_google_android_gms_internal_zzbos;
        return new zzbmj(obj, 0, size + 1);
    }

    public zzbmj zzh(zzbmj com_google_android_gms_internal_zzbmj) {
        int size = size() + com_google_android_gms_internal_zzbmj.size();
        Object obj = new zzbos[size];
        System.arraycopy(this.zzccc, this.start, obj, 0, size());
        System.arraycopy(com_google_android_gms_internal_zzbmj.zzccc, com_google_android_gms_internal_zzbmj.start, obj, size(), com_google_android_gms_internal_zzbmj.size());
        return new zzbmj(obj, 0, size);
    }

    public boolean zzi(zzbmj com_google_android_gms_internal_zzbmj) {
        if (size() > com_google_android_gms_internal_zzbmj.size()) {
            return false;
        }
        int i = this.start;
        int i2 = com_google_android_gms_internal_zzbmj.start;
        while (i < this.end) {
            if (!this.zzccc[i].equals(com_google_android_gms_internal_zzbmj.zzccc[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int zzj(zzbmj com_google_android_gms_internal_zzbmj) {
        int i = this.start;
        int i2 = com_google_android_gms_internal_zzbmj.start;
        while (i < this.end && i2 < com_google_android_gms_internal_zzbmj.end) {
            int zzi = this.zzccc[i].zzi(com_google_android_gms_internal_zzbmj.zzccc[i2]);
            if (zzi != 0) {
                return zzi;
            }
            i++;
            i2++;
        }
        return (i == this.end && i2 == com_google_android_gms_internal_zzbmj.end) ? 0 : i == this.end ? -1 : 1;
    }
}
