package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.zzai.zzh;
import com.google.android.gms.tagmanager.zzbo;
import com.google.android.gms.tagmanager.zzdm;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzbgi {

    public static class zza {
        private final com.google.android.gms.internal.zzaj.zza zzbFS;
        private final Map<String, com.google.android.gms.internal.zzaj.zza> zzbKA;

        private zza(Map<String, com.google.android.gms.internal.zzaj.zza> map, com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza) {
            this.zzbKA = map;
            this.zzbFS = com_google_android_gms_internal_zzaj_zza;
        }

        public static zzb zzRU() {
            return new zzb();
        }

        public String toString() {
            String valueOf = String.valueOf(zzRt());
            String valueOf2 = String.valueOf(this.zzbFS);
            return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Properties: ").append(valueOf).append(" pushAfterEvaluate: ").append(valueOf2).toString();
        }

        public com.google.android.gms.internal.zzaj.zza zzPM() {
            return this.zzbFS;
        }

        public Map<String, com.google.android.gms.internal.zzaj.zza> zzRt() {
            return Collections.unmodifiableMap(this.zzbKA);
        }

        public void zza(String str, com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza) {
            this.zzbKA.put(str, com_google_android_gms_internal_zzaj_zza);
        }
    }

    public static class zzb {
        private com.google.android.gms.internal.zzaj.zza zzbFS;
        private final Map<String, com.google.android.gms.internal.zzaj.zza> zzbKA;

        private zzb() {
            this.zzbKA = new HashMap();
        }

        public zza zzRV() {
            return new zza(this.zzbFS, null);
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza) {
            this.zzbKA.put(str, com_google_android_gms_internal_zzaj_zza);
            return this;
        }

        public zzb zzo(com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza) {
            this.zzbFS = com_google_android_gms_internal_zzaj_zza;
            return this;
        }
    }

    public static class zzc {
        private final String zzaux;
        private final List<zze> zzbKx;
        private final Map<String, List<zza>> zzbKy;
        private final int zzbKz;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzbKx = Collections.unmodifiableList(list);
            this.zzbKy = Collections.unmodifiableMap(map);
            this.zzaux = str;
            this.zzbKz = i;
        }

        public static zzd zzRW() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzaux;
        }

        public String toString() {
            String valueOf = String.valueOf(zzRr());
            String valueOf2 = String.valueOf(this.zzbKy);
            return new StringBuilder((String.valueOf(valueOf).length() + 17) + String.valueOf(valueOf2).length()).append("Rules: ").append(valueOf).append("  Macros: ").append(valueOf2).toString();
        }

        public Map<String, List<zza>> zzRX() {
            return this.zzbKy;
        }

        public List<zze> zzRr() {
            return this.zzbKx;
        }
    }

    public static class zzd {
        private String zzaux;
        private final List<zze> zzbKx;
        private final Map<String, List<zza>> zzbKy;
        private int zzbKz;

        private zzd() {
            this.zzbKx = new ArrayList();
            this.zzbKy = new HashMap();
            this.zzaux = BuildConfig.FLAVOR;
            this.zzbKz = 0;
        }

        public zzc zzRY() {
            return new zzc(this.zzbKy, this.zzaux, this.zzbKz, null);
        }

        public zzd zzb(zze com_google_android_gms_internal_zzbgi_zze) {
            this.zzbKx.add(com_google_android_gms_internal_zzbgi_zze);
            return this;
        }

        public zzd zzc(zza com_google_android_gms_internal_zzbgi_zza) {
            String zze = zzdm.zze((com.google.android.gms.internal.zzaj.zza) com_google_android_gms_internal_zzbgi_zza.zzRt().get(zzah.INSTANCE_NAME.toString()));
            List list = (List) this.zzbKy.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbKy.put(zze, list);
            }
            list.add(com_google_android_gms_internal_zzbgi_zza);
            return this;
        }

        public zzd zzik(String str) {
            this.zzaux = str;
            return this;
        }

        public zzd zznd(int i) {
            this.zzbKz = i;
            return this;
        }
    }

    public static class zze {
        private final List<zza> zzbKC;
        private final List<zza> zzbKD;
        private final List<zza> zzbKE;
        private final List<zza> zzbKF;
        private final List<zza> zzbLk;
        private final List<zza> zzbLl;
        private final List<String> zzbLm;
        private final List<String> zzbLn;
        private final List<String> zzbLo;
        private final List<String> zzbLp;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzbKC = Collections.unmodifiableList(list);
            this.zzbKD = Collections.unmodifiableList(list2);
            this.zzbKE = Collections.unmodifiableList(list3);
            this.zzbKF = Collections.unmodifiableList(list4);
            this.zzbLk = Collections.unmodifiableList(list5);
            this.zzbLl = Collections.unmodifiableList(list6);
            this.zzbLm = Collections.unmodifiableList(list7);
            this.zzbLn = Collections.unmodifiableList(list8);
            this.zzbLo = Collections.unmodifiableList(list9);
            this.zzbLp = Collections.unmodifiableList(list10);
        }

        public static zzf zzRZ() {
            return new zzf();
        }

        public String toString() {
            String valueOf = String.valueOf(zzRv());
            String valueOf2 = String.valueOf(zzRw());
            String valueOf3 = String.valueOf(zzRx());
            String valueOf4 = String.valueOf(zzRy());
            String valueOf5 = String.valueOf(zzSa());
            String valueOf6 = String.valueOf(zzSb());
            return new StringBuilder((((((String.valueOf(valueOf).length() + Quests.SELECT_ENDING_SOON) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()).append("Positive predicates: ").append(valueOf).append("  Negative predicates: ").append(valueOf2).append("  Add tags: ").append(valueOf3).append("  Remove tags: ").append(valueOf4).append("  Add macros: ").append(valueOf5).append("  Remove macros: ").append(valueOf6).toString();
        }

        public List<zza> zzRv() {
            return this.zzbKC;
        }

        public List<zza> zzRw() {
            return this.zzbKD;
        }

        public List<zza> zzRx() {
            return this.zzbKE;
        }

        public List<zza> zzRy() {
            return this.zzbKF;
        }

        public List<zza> zzSa() {
            return this.zzbLk;
        }

        public List<zza> zzSb() {
            return this.zzbLl;
        }
    }

    public static class zzf {
        private final List<zza> zzbKC;
        private final List<zza> zzbKD;
        private final List<zza> zzbKE;
        private final List<zza> zzbKF;
        private final List<zza> zzbLk;
        private final List<zza> zzbLl;
        private final List<String> zzbLm;
        private final List<String> zzbLn;
        private final List<String> zzbLo;
        private final List<String> zzbLp;

        private zzf() {
            this.zzbKC = new ArrayList();
            this.zzbKD = new ArrayList();
            this.zzbKE = new ArrayList();
            this.zzbKF = new ArrayList();
            this.zzbLk = new ArrayList();
            this.zzbLl = new ArrayList();
            this.zzbLm = new ArrayList();
            this.zzbLn = new ArrayList();
            this.zzbLo = new ArrayList();
            this.zzbLp = new ArrayList();
        }

        public zze zzSc() {
            return new zze(this.zzbKD, this.zzbKE, this.zzbKF, this.zzbLk, this.zzbLl, this.zzbLm, this.zzbLn, this.zzbLo, this.zzbLp, null);
        }

        public zzf zzd(zza com_google_android_gms_internal_zzbgi_zza) {
            this.zzbKC.add(com_google_android_gms_internal_zzbgi_zza);
            return this;
        }

        public zzf zze(zza com_google_android_gms_internal_zzbgi_zza) {
            this.zzbKD.add(com_google_android_gms_internal_zzbgi_zza);
            return this;
        }

        public zzf zzf(zza com_google_android_gms_internal_zzbgi_zza) {
            this.zzbKE.add(com_google_android_gms_internal_zzbgi_zza);
            return this;
        }

        public zzf zzg(zza com_google_android_gms_internal_zzbgi_zza) {
            this.zzbKF.add(com_google_android_gms_internal_zzbgi_zza);
            return this;
        }

        public zzf zzh(zza com_google_android_gms_internal_zzbgi_zza) {
            this.zzbLk.add(com_google_android_gms_internal_zzbgi_zza);
            return this;
        }

        public zzf zzi(zza com_google_android_gms_internal_zzbgi_zza) {
            this.zzbLl.add(com_google_android_gms_internal_zzbgi_zza);
            return this;
        }

        public zzf zzil(String str) {
            this.zzbLo.add(str);
            return this;
        }

        public zzf zzim(String str) {
            this.zzbLp.add(str);
            return this;
        }

        public zzf zzin(String str) {
            this.zzbLm.add(str);
            return this;
        }

        public zzf zzio(String str) {
            this.zzbLn.add(str);
            return this;
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.zzaj.zza zza(int i, com.google.android.gms.internal.zzai.zzf com_google_android_gms_internal_zzai_zzf, com.google.android.gms.internal.zzaj.zza[] com_google_android_gms_internal_zzaj_zzaArr, Set<Integer> set) throws zzg {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            zzhV(new StringBuilder(String.valueOf(valueOf).length() + 90).append("Value cycle detected.  Current value reference: ").append(i).append(".  Previous value references: ").append(valueOf).append(".").toString());
        }
        com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza = (com.google.android.gms.internal.zzaj.zza) zza(com_google_android_gms_internal_zzai_zzf.zzkI, i, "values");
        if (com_google_android_gms_internal_zzaj_zzaArr[i] != null) {
            return com_google_android_gms_internal_zzaj_zzaArr[i];
        }
        com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza2 = null;
        set.add(Integer.valueOf(i));
        zzh zzn;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (com_google_android_gms_internal_zzaj_zza.type) {
            case MessageApi.FILTER_PREFIX /*1*/:
            case Dimension.UNIT_MM /*5*/:
            case BuyButtonText.LOGO_ONLY /*6*/:
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                com_google_android_gms_internal_zzaj_zza2 = com_google_android_gms_internal_zzaj_zza;
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                zzn = zzn(com_google_android_gms_internal_zzaj_zza);
                com_google_android_gms_internal_zzaj_zza2 = zzm(com_google_android_gms_internal_zzaj_zza);
                com_google_android_gms_internal_zzaj_zza2.zzlx = new com.google.android.gms.internal.zzaj.zza[zzn.zzlj.length];
                iArr = zzn.zzlj;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzaj_zza2.zzlx[i3] = zza(iArr[i2], com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                com_google_android_gms_internal_zzaj_zza2 = zzm(com_google_android_gms_internal_zzaj_zza);
                zzh zzn2 = zzn(com_google_android_gms_internal_zzaj_zza);
                if (zzn2.zzlk.length != zzn2.zzll.length) {
                    i3 = zzn2.zzlk.length;
                    zzhV("Uneven map keys (" + i3 + ") and map values (" + zzn2.zzll.length + ")");
                }
                com_google_android_gms_internal_zzaj_zza2.zzly = new com.google.android.gms.internal.zzaj.zza[zzn2.zzlk.length];
                com_google_android_gms_internal_zzaj_zza2.zzlz = new com.google.android.gms.internal.zzaj.zza[zzn2.zzlk.length];
                int[] iArr2 = zzn2.zzlk;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    com_google_android_gms_internal_zzaj_zza2.zzly[i4] = zza(iArr2[i3], com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = zzn2.zzll;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzaj_zza2.zzlz[i3] = zza(iArr[i2], com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case Dimension.UNIT_IN /*4*/:
                com_google_android_gms_internal_zzaj_zza2 = zzm(com_google_android_gms_internal_zzaj_zza);
                com_google_android_gms_internal_zzaj_zza2.zzlA = zzdm.zze(zza(zzn(com_google_android_gms_internal_zzaj_zza).zzlo, com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, (Set) set));
                break;
            case BuyButtonText.DONATE_WITH /*7*/:
                com_google_android_gms_internal_zzaj_zza2 = zzm(com_google_android_gms_internal_zzaj_zza);
                zzn = zzn(com_google_android_gms_internal_zzaj_zza);
                com_google_android_gms_internal_zzaj_zza2.zzlE = new com.google.android.gms.internal.zzaj.zza[zzn.zzln.length];
                iArr = zzn.zzln;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzaj_zza2.zzlE[i3] = zza(iArr[i2], com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (com_google_android_gms_internal_zzaj_zza2 == null) {
            valueOf = String.valueOf(com_google_android_gms_internal_zzaj_zza);
            zzhV(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Invalid value: ").append(valueOf).toString());
        }
        com_google_android_gms_internal_zzaj_zzaArr[i] = com_google_android_gms_internal_zzaj_zza2;
        set.remove(Integer.valueOf(i));
        return com_google_android_gms_internal_zzaj_zza2;
    }

    private static zza zza(com.google.android.gms.internal.zzai.zzb com_google_android_gms_internal_zzai_zzb, com.google.android.gms.internal.zzai.zzf com_google_android_gms_internal_zzai_zzf, com.google.android.gms.internal.zzaj.zza[] com_google_android_gms_internal_zzaj_zzaArr, int i) throws zzg {
        zzb zzRU = zza.zzRU();
        for (int valueOf : com_google_android_gms_internal_zzai_zzb.zzkt) {
            com.google.android.gms.internal.zzai.zze com_google_android_gms_internal_zzai_zze = (com.google.android.gms.internal.zzai.zze) zza(com_google_android_gms_internal_zzai_zzf.zzkJ, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(com_google_android_gms_internal_zzai_zzf.zzkH, com_google_android_gms_internal_zzai_zze.key, "keys");
            com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza = (com.google.android.gms.internal.zzaj.zza) zza(com_google_android_gms_internal_zzaj_zzaArr, com_google_android_gms_internal_zzai_zze.value, "values");
            if (zzah.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzRU.zzo(com_google_android_gms_internal_zzaj_zza);
            } else {
                zzRU.zzb(str, com_google_android_gms_internal_zzaj_zza);
            }
        }
        return zzRU.zzRV();
    }

    private static zze zza(com.google.android.gms.internal.zzai.zzg com_google_android_gms_internal_zzai_zzg, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzai.zzf com_google_android_gms_internal_zzai_zzf) {
        zzf zzRZ = zze.zzRZ();
        for (int valueOf : com_google_android_gms_internal_zzai_zzg.zzkX) {
            zzRZ.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : com_google_android_gms_internal_zzai_zzg.zzkY) {
            zzRZ.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : com_google_android_gms_internal_zzai_zzg.zzkZ) {
            zzRZ.zzf((zza) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : com_google_android_gms_internal_zzai_zzg.zzlb) {
            zzRZ.zzil(com_google_android_gms_internal_zzai_zzf.zzkI[Integer.valueOf(valueOf3).intValue()].string);
        }
        for (int valueOf222 : com_google_android_gms_internal_zzai_zzg.zzla) {
            zzRZ.zzg((zza) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : com_google_android_gms_internal_zzai_zzg.zzlc) {
            zzRZ.zzim(com_google_android_gms_internal_zzai_zzf.zzkI[Integer.valueOf(valueOf32).intValue()].string);
        }
        for (int valueOf2222 : com_google_android_gms_internal_zzai_zzg.zzld) {
            zzRZ.zzh((zza) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : com_google_android_gms_internal_zzai_zzg.zzlf) {
            zzRZ.zzin(com_google_android_gms_internal_zzai_zzf.zzkI[Integer.valueOf(valueOf322).intValue()].string);
        }
        for (int valueOf22222 : com_google_android_gms_internal_zzai_zzg.zzle) {
            zzRZ.zzi((zza) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : com_google_android_gms_internal_zzai_zzg.zzlg) {
            zzRZ.zzio(com_google_android_gms_internal_zzai_zzf.zzkI[Integer.valueOf(valueOf4).intValue()].string);
        }
        return zzRZ.zzSc();
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzg {
        if (i < 0 || i >= tArr.length) {
            zzhV(new StringBuilder(String.valueOf(str).length() + 45).append("Index out of bounds detected: ").append(i).append(" in ").append(str).toString());
        }
        return tArr[i];
    }

    public static zzc zzb(com.google.android.gms.internal.zzai.zzf com_google_android_gms_internal_zzai_zzf) throws zzg {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.zzaj.zza[] com_google_android_gms_internal_zzaj_zzaArr = new com.google.android.gms.internal.zzaj.zza[com_google_android_gms_internal_zzai_zzf.zzkI.length];
        for (i = 0; i < com_google_android_gms_internal_zzai_zzf.zzkI.length; i++) {
            zza(i, com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, new HashSet(0));
        }
        zzd zzRW = zzc.zzRW();
        List arrayList = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzai_zzf.zzkL.length; i++) {
            arrayList.add(zza(com_google_android_gms_internal_zzai_zzf.zzkL[i], com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzai_zzf.zzkM.length; i++) {
            arrayList2.add(zza(com_google_android_gms_internal_zzai_zzf.zzkM[i], com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzai_zzf.zzkK.length; i++) {
            zza zza = zza(com_google_android_gms_internal_zzai_zzf.zzkK[i], com_google_android_gms_internal_zzai_zzf, com_google_android_gms_internal_zzaj_zzaArr, i);
            zzRW.zzc(zza);
            arrayList3.add(zza);
        }
        com.google.android.gms.internal.zzai.zzg[] com_google_android_gms_internal_zzai_zzgArr = com_google_android_gms_internal_zzai_zzf.zzkN;
        int length = com_google_android_gms_internal_zzai_zzgArr.length;
        while (i2 < length) {
            zzRW.zzb(zza(com_google_android_gms_internal_zzai_zzgArr[i2], arrayList, arrayList3, arrayList2, com_google_android_gms_internal_zzai_zzf));
            i2++;
        }
        zzRW.zzik(com_google_android_gms_internal_zzai_zzf.version);
        zzRW.zznd(com_google_android_gms_internal_zzai_zzf.zzkV);
        return zzRW.zzRY();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzhV(String str) throws zzg {
        zzbo.e(str);
        throw new zzg(str);
    }

    public static com.google.android.gms.internal.zzaj.zza zzm(com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza) {
        com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza2 = new com.google.android.gms.internal.zzaj.zza();
        com_google_android_gms_internal_zzaj_zza2.type = com_google_android_gms_internal_zzaj_zza.type;
        com_google_android_gms_internal_zzaj_zza2.zzlF = (int[]) com_google_android_gms_internal_zzaj_zza.zzlF.clone();
        if (com_google_android_gms_internal_zzaj_zza.zzlG) {
            com_google_android_gms_internal_zzaj_zza2.zzlG = com_google_android_gms_internal_zzaj_zza.zzlG;
        }
        return com_google_android_gms_internal_zzaj_zza2;
    }

    private static zzh zzn(com.google.android.gms.internal.zzaj.zza com_google_android_gms_internal_zzaj_zza) throws zzg {
        if (((zzh) com_google_android_gms_internal_zzaj_zza.zza(zzh.zzlh)) == null) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzaj_zza);
            zzhV(new StringBuilder(String.valueOf(valueOf).length() + 54).append("Expected a ServingValue and didn't get one. Value is: ").append(valueOf).toString());
        }
        return (zzh) com_google_android_gms_internal_zzaj_zza.zza(zzh.zzlh);
    }
}
