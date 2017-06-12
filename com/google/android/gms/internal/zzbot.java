package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzbot implements zzbpe {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static Comparator<zzbos> zzcgP;
    private final zzbla<zzbos, zzbpe> zzcfq;
    private final zzbpe zzcgQ;
    private String zzcgR;

    public static abstract class zza extends com.google.android.gms.internal.zzblf.zzb<zzbos, zzbpe> {
        public abstract void zzb(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe);

        public void zzf(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
            zzb(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
        }

        public /* synthetic */ void zzk(Object obj, Object obj2) {
            zzf((zzbos) obj, (zzbpe) obj2);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbot.1 */
    class C12711 implements Comparator<zzbos> {
        C12711() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((zzbos) obj, (zzbos) obj2);
        }

        public int zza(zzbos com_google_android_gms_internal_zzbos, zzbos com_google_android_gms_internal_zzbos2) {
            return com_google_android_gms_internal_zzbos.zzi(com_google_android_gms_internal_zzbos2);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbot.2 */
    class C12722 extends com.google.android.gms.internal.zzblf.zzb<zzbos, zzbpe> {
        boolean zzcgS;
        final /* synthetic */ zza zzcgT;
        final /* synthetic */ zzbot zzcgU;

        C12722(zzbot com_google_android_gms_internal_zzbot, zza com_google_android_gms_internal_zzbot_zza) {
            this.zzcgU = com_google_android_gms_internal_zzbot;
            this.zzcgT = com_google_android_gms_internal_zzbot_zza;
            this.zzcgS = false;
        }

        public void zzf(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
            if (!this.zzcgS && com_google_android_gms_internal_zzbos.zzi(zzbos.zzYY()) > 0) {
                this.zzcgS = true;
                this.zzcgT.zzb(zzbos.zzYY(), this.zzcgU.zzZe());
            }
            this.zzcgT.zzb(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
        }

        public /* synthetic */ void zzk(Object obj, Object obj2) {
            zzf((zzbos) obj, (zzbpe) obj2);
        }
    }

    private static class zzb implements Iterator<zzbpd> {
        private final Iterator<Entry<zzbos, zzbpe>> zzbYP;

        public zzb(Iterator<Entry<zzbos, zzbpe>> it) {
            this.zzbYP = it;
        }

        public boolean hasNext() {
            return this.zzbYP.hasNext();
        }

        public /* synthetic */ Object next() {
            return zzZh();
        }

        public void remove() {
            this.zzbYP.remove();
        }

        public zzbpd zzZh() {
            Entry entry = (Entry) this.zzbYP.next();
            return new zzbpd((zzbos) entry.getKey(), (zzbpe) entry.getValue());
        }
    }

    static {
        $assertionsDisabled = !zzbot.class.desiredAssertionStatus();
        zzcgP = new C12711();
    }

    protected zzbot() {
        this.zzcgR = null;
        this.zzcfq = com.google.android.gms.internal.zzbla.zza.zza(zzcgP);
        this.zzcgQ = zzbpi.zzZB();
    }

    protected zzbot(zzbla<zzbos, zzbpe> com_google_android_gms_internal_zzbla_com_google_android_gms_internal_zzbos__com_google_android_gms_internal_zzbpe, zzbpe com_google_android_gms_internal_zzbpe) {
        this.zzcgR = null;
        if (!com_google_android_gms_internal_zzbla_com_google_android_gms_internal_zzbos__com_google_android_gms_internal_zzbpe.isEmpty() || com_google_android_gms_internal_zzbpe.isEmpty()) {
            this.zzcgQ = com_google_android_gms_internal_zzbpe;
            this.zzcfq = com_google_android_gms_internal_zzbla_com_google_android_gms_internal_zzbos__com_google_android_gms_internal_zzbpe;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }

    private static void zzb(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(" ");
        }
    }

    private void zzc(StringBuilder stringBuilder, int i) {
        if (this.zzcfq.isEmpty() && this.zzcgQ.isEmpty()) {
            stringBuilder.append("{ }");
            return;
        }
        stringBuilder.append("{\n");
        Iterator it = this.zzcfq.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzb(stringBuilder, i + 2);
            stringBuilder.append(((zzbos) entry.getKey()).asString());
            stringBuilder.append("=");
            if (entry.getValue() instanceof zzbot) {
                ((zzbot) entry.getValue()).zzc(stringBuilder, i + 2);
            } else {
                stringBuilder.append(((zzbpe) entry.getValue()).toString());
            }
            stringBuilder.append("\n");
        }
        if (!this.zzcgQ.isEmpty()) {
            zzb(stringBuilder, i + 2);
            stringBuilder.append(".priority=");
            stringBuilder.append(this.zzcgQ.toString());
            stringBuilder.append("\n");
        }
        zzb(stringBuilder, i);
        stringBuilder.append("}");
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzh((zzbpe) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbot)) {
            return false;
        }
        zzbot com_google_android_gms_internal_zzbot = (zzbot) obj;
        if (!zzZe().equals(com_google_android_gms_internal_zzbot.zzZe())) {
            return false;
        }
        if (this.zzcfq.size() != com_google_android_gms_internal_zzbot.zzcfq.size()) {
            return false;
        }
        Iterator it = this.zzcfq.iterator();
        Iterator it2 = com_google_android_gms_internal_zzbot.zzcfq.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            if (((zzbos) entry.getKey()).equals(entry2.getKey())) {
                if (!((zzbpe) entry.getValue()).equals(entry2.getValue())) {
                }
            }
            return false;
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    public int getChildCount() {
        return this.zzcfq.size();
    }

    public Object getValue() {
        return getValue(false);
    }

    public Object getValue(boolean z) {
        int i = 0;
        if (isEmpty()) {
            return null;
        }
        Map hashMap = new HashMap();
        Iterator it = this.zzcfq.iterator();
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            int i5;
            int i6;
            Entry entry = (Entry) it.next();
            String asString = ((zzbos) entry.getKey()).asString();
            hashMap.put(asString, ((zzbpe) entry.getValue()).getValue(z));
            i4++;
            if (i2 != 0) {
                if (asString.length() <= 1 || asString.charAt(0) != '0') {
                    Integer zzjk = zzbqg.zzjk(asString);
                    if (zzjk == null || zzjk.intValue() < 0) {
                        i5 = 0;
                        i6 = i3;
                        i2 = i5;
                        i3 = i6;
                    } else if (zzjk.intValue() > i3) {
                        i3 = zzjk.intValue();
                        i5 = i2;
                        i6 = i3;
                        i2 = i5;
                        i3 = i6;
                    }
                } else {
                    i5 = 0;
                    i6 = i3;
                    i2 = i5;
                    i3 = i6;
                }
            }
            i5 = i2;
            i6 = i3;
            i2 = i5;
            i3 = i6;
        }
        if (z || i2 == 0 || i3 >= i4 * 2) {
            if (z && !this.zzcgQ.isEmpty()) {
                hashMap.put(".priority", this.zzcgQ.getValue());
            }
            return hashMap;
        }
        List arrayList = new ArrayList(i3 + 1);
        while (i <= i3) {
            arrayList.add(hashMap.get(i));
            i++;
        }
        return arrayList;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            zzbpd com_google_android_gms_internal_zzbpd = (zzbpd) it.next();
            i = com_google_android_gms_internal_zzbpd.zzUY().hashCode() + (((i * 31) + com_google_android_gms_internal_zzbpd.zzZz().hashCode()) * 17);
        }
        return i;
    }

    public boolean isEmpty() {
        return this.zzcfq.isEmpty();
    }

    public Iterator<zzbpd> iterator() {
        return new zzb(this.zzcfq.iterator());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        zzc(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public zzbpe zzO(zzbmj com_google_android_gms_internal_zzbmj) {
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        return zzXi == null ? this : zzm(zzXi).zzO(com_google_android_gms_internal_zzbmj.zzXj());
    }

    public Iterator<zzbpd> zzVl() {
        return new zzb(this.zzcfq.zzVl());
    }

    public String zzZc() {
        if (this.zzcgR == null) {
            String zza = zza(com.google.android.gms.internal.zzbpe.zza.V1);
            this.zzcgR = zza.isEmpty() ? BuildConfig.FLAVOR : zzbqg.zzji(zza);
        }
        return this.zzcgR;
    }

    public boolean zzZd() {
        return false;
    }

    public zzbpe zzZe() {
        return this.zzcgQ;
    }

    public zzbos zzZf() {
        return (zzbos) this.zzcfq.zzVj();
    }

    public zzbos zzZg() {
        return (zzbos) this.zzcfq.zzVk();
    }

    public String zza(com.google.android.gms.internal.zzbpe.zza com_google_android_gms_internal_zzbpe_zza) {
        if (com_google_android_gms_internal_zzbpe_zza != com.google.android.gms.internal.zzbpe.zza.V1) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.zzcgQ.isEmpty()) {
            stringBuilder.append("priority:");
            stringBuilder.append(this.zzcgQ.zza(com.google.android.gms.internal.zzbpe.zza.V1));
            stringBuilder.append(":");
        }
        List<zzbpd> arrayList = new ArrayList();
        Iterator it = iterator();
        Object obj = null;
        while (it.hasNext()) {
            zzbpd com_google_android_gms_internal_zzbpd = (zzbpd) it.next();
            arrayList.add(com_google_android_gms_internal_zzbpd);
            Object obj2 = (obj == null && com_google_android_gms_internal_zzbpd.zzUY().zzZe().isEmpty()) ? null : 1;
            obj = obj2;
        }
        if (obj != null) {
            Collections.sort(arrayList, zzbph.zzZA());
        }
        for (zzbpd com_google_android_gms_internal_zzbpd2 : arrayList) {
            String zzZc = com_google_android_gms_internal_zzbpd2.zzUY().zzZc();
            if (!zzZc.equals(BuildConfig.FLAVOR)) {
                stringBuilder.append(":");
                stringBuilder.append(com_google_android_gms_internal_zzbpd2.zzZz().asString());
                stringBuilder.append(":");
                stringBuilder.append(zzZc);
            }
        }
        return stringBuilder.toString();
    }

    public void zza(zza com_google_android_gms_internal_zzbot_zza) {
        zza(com_google_android_gms_internal_zzbot_zza, false);
    }

    public void zza(zza com_google_android_gms_internal_zzbot_zza, boolean z) {
        if (!z || zzZe().isEmpty()) {
            this.zzcfq.zza(com_google_android_gms_internal_zzbot_zza);
        } else {
            this.zzcfq.zza(new C12722(this, com_google_android_gms_internal_zzbot_zza));
        }
    }

    public zzbpe zze(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbos.zzZa()) {
            return zzg(com_google_android_gms_internal_zzbpe);
        }
        zzbla com_google_android_gms_internal_zzbla = this.zzcfq;
        if (com_google_android_gms_internal_zzbla.containsKey(com_google_android_gms_internal_zzbos)) {
            com_google_android_gms_internal_zzbla = com_google_android_gms_internal_zzbla.zzae(com_google_android_gms_internal_zzbos);
        }
        if (!com_google_android_gms_internal_zzbpe.isEmpty()) {
            com_google_android_gms_internal_zzbla = com_google_android_gms_internal_zzbla.zzj(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe);
        }
        return com_google_android_gms_internal_zzbla.isEmpty() ? zzbox.zzZp() : new zzbot(com_google_android_gms_internal_zzbla, this.zzcgQ);
    }

    public zzbpe zzg(zzbpe com_google_android_gms_internal_zzbpe) {
        return this.zzcfq.isEmpty() ? zzbox.zzZp() : new zzbot(this.zzcfq, com_google_android_gms_internal_zzbpe);
    }

    public int zzh(zzbpe com_google_android_gms_internal_zzbpe) {
        return isEmpty() ? com_google_android_gms_internal_zzbpe.isEmpty() ? 0 : -1 : com_google_android_gms_internal_zzbpe.zzZd() ? 1 : com_google_android_gms_internal_zzbpe.isEmpty() ? 1 : com_google_android_gms_internal_zzbpe == zzbpe.zzchu ? -1 : 0;
    }

    public boolean zzk(zzbos com_google_android_gms_internal_zzbos) {
        return !zzm(com_google_android_gms_internal_zzbos).isEmpty();
    }

    public zzbos zzl(zzbos com_google_android_gms_internal_zzbos) {
        return (zzbos) this.zzcfq.zzaf(com_google_android_gms_internal_zzbos);
    }

    public zzbpe zzl(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        if (zzXi == null) {
            return com_google_android_gms_internal_zzbpe;
        }
        if (!zzXi.zzZa()) {
            return zze(zzXi, zzm(zzXi).zzl(com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzbpe));
        }
        if ($assertionsDisabled || zzbpi.zzq(com_google_android_gms_internal_zzbpe)) {
            return zzg(com_google_android_gms_internal_zzbpe);
        }
        throw new AssertionError();
    }

    public zzbpe zzm(zzbos com_google_android_gms_internal_zzbos) {
        return (!com_google_android_gms_internal_zzbos.zzZa() || this.zzcgQ.isEmpty()) ? this.zzcfq.containsKey(com_google_android_gms_internal_zzbos) ? (zzbpe) this.zzcfq.get(com_google_android_gms_internal_zzbos) : zzbox.zzZp() : this.zzcgQ;
    }
}
