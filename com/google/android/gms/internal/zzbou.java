package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class zzbou {
    private final List<zzbmj> zzbZh;
    private final List<String> zzbZi;

    /* renamed from: com.google.android.gms.internal.zzbou.1 */
    class C12731 extends com.google.android.gms.internal.zzbot.zza {
        final /* synthetic */ zza zzcgV;

        C12731(zza com_google_android_gms_internal_zzbou_zza) {
            this.zzcgV = com_google_android_gms_internal_zzbou_zza;
        }

        public void zzb(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
            this.zzcgV.zzn(com_google_android_gms_internal_zzbos);
            zzbou.zza(com_google_android_gms_internal_zzbpe, this.zzcgV);
            this.zzcgV.zzZm();
        }
    }

    static class zza {
        private StringBuilder zzcgW;
        private Stack<zzbos> zzcgX;
        private int zzcgY;
        private int zzcgZ;
        private boolean zzcha;
        private final List<zzbmj> zzchb;
        private final List<String> zzchc;
        private final zzc zzchd;

        public zza(zzc com_google_android_gms_internal_zzbou_zzc) {
            this.zzcgW = null;
            this.zzcgX = new Stack();
            this.zzcgY = -1;
            this.zzcha = true;
            this.zzchb = new ArrayList();
            this.zzchc = new ArrayList();
            this.zzchd = com_google_android_gms_internal_zzbou_zzc;
        }

        private void zzZl() {
            if (!zzZi()) {
                this.zzcgW = new StringBuilder();
                this.zzcgW.append("(");
                Iterator it = zzpQ(this.zzcgZ).iterator();
                while (it.hasNext()) {
                    zza(this.zzcgW, (zzbos) it.next());
                    this.zzcgW.append(":(");
                }
                this.zzcha = false;
            }
        }

        private void zzZm() {
            this.zzcgZ--;
            if (zzZi()) {
                this.zzcgW.append(")");
            }
            this.zzcha = true;
        }

        private void zzZn() {
            zzbqg.zzb(this.zzcgZ == 0, "Can't finish hashing in the middle processing a child");
            if (zzZi()) {
                zzZo();
            }
            this.zzchc.add(BuildConfig.FLAVOR);
        }

        private void zzZo() {
            zzbqg.zzb(zzZi(), "Can't end range without starting a range!");
            for (int i = 0; i < this.zzcgZ; i++) {
                this.zzcgW.append(")");
            }
            this.zzcgW.append(")");
            zzbmj zzpQ = zzpQ(this.zzcgY);
            this.zzchc.add(zzbqg.zzji(this.zzcgW.toString()));
            this.zzchb.add(zzpQ);
            this.zzcgW = null;
        }

        private void zza(StringBuilder stringBuilder, zzbos com_google_android_gms_internal_zzbos) {
            stringBuilder.append(zzbqg.zzjj(com_google_android_gms_internal_zzbos.asString()));
        }

        private void zzb(zzbpb<?> com_google_android_gms_internal_zzbpb_) {
            zzZl();
            this.zzcgY = this.zzcgZ;
            this.zzcgW.append(com_google_android_gms_internal_zzbpb_.zza(com.google.android.gms.internal.zzbpe.zza.V2));
            this.zzcha = true;
            if (this.zzchd.zze(this)) {
                zzZo();
            }
        }

        private void zzn(zzbos com_google_android_gms_internal_zzbos) {
            zzZl();
            if (this.zzcha) {
                this.zzcgW.append(",");
            }
            zza(this.zzcgW, com_google_android_gms_internal_zzbos);
            this.zzcgW.append(":(");
            if (this.zzcgZ == this.zzcgX.size()) {
                this.zzcgX.add(com_google_android_gms_internal_zzbos);
            } else {
                this.zzcgX.set(this.zzcgZ, com_google_android_gms_internal_zzbos);
            }
            this.zzcgZ++;
            this.zzcha = false;
        }

        private zzbmj zzpQ(int i) {
            zzbos[] com_google_android_gms_internal_zzbosArr = new zzbos[i];
            for (int i2 = 0; i2 < i; i2++) {
                com_google_android_gms_internal_zzbosArr[i2] = (zzbos) this.zzcgX.get(i2);
            }
            return new zzbmj(com_google_android_gms_internal_zzbosArr);
        }

        public boolean zzZi() {
            return this.zzcgW != null;
        }

        public int zzZj() {
            return this.zzcgW.length();
        }

        public zzbmj zzZk() {
            return zzpQ(this.zzcgZ);
        }
    }

    public interface zzc {
        boolean zze(zza com_google_android_gms_internal_zzbou_zza);
    }

    private static class zzb implements zzc {
        private final long zzche;

        public zzb(zzbpe com_google_android_gms_internal_zzbpe) {
            this.zzche = Math.max(512, (long) Math.sqrt((double) (zzbqb.zzt(com_google_android_gms_internal_zzbpe) * 100)));
        }

        public boolean zze(zza com_google_android_gms_internal_zzbou_zza) {
            return ((long) com_google_android_gms_internal_zzbou_zza.zzZj()) > this.zzche && (com_google_android_gms_internal_zzbou_zza.zzZk().isEmpty() || !com_google_android_gms_internal_zzbou_zza.zzZk().zzXl().equals(zzbos.zzYY()));
        }
    }

    private zzbou(List<zzbmj> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.zzbZh = list;
        this.zzbZi = list2;
    }

    public static zzbou zza(zzbpe com_google_android_gms_internal_zzbpe, zzc com_google_android_gms_internal_zzbou_zzc) {
        if (com_google_android_gms_internal_zzbpe.isEmpty()) {
            return new zzbou(Collections.emptyList(), Collections.singletonList(BuildConfig.FLAVOR));
        }
        zza com_google_android_gms_internal_zzbou_zza = new zza(com_google_android_gms_internal_zzbou_zzc);
        zza(com_google_android_gms_internal_zzbpe, com_google_android_gms_internal_zzbou_zza);
        com_google_android_gms_internal_zzbou_zza.zzZn();
        return new zzbou(com_google_android_gms_internal_zzbou_zza.zzchb, com_google_android_gms_internal_zzbou_zza.zzchc);
    }

    private static void zza(zzbpe com_google_android_gms_internal_zzbpe, zza com_google_android_gms_internal_zzbou_zza) {
        if (com_google_android_gms_internal_zzbpe.zzZd()) {
            com_google_android_gms_internal_zzbou_zza.zzb((zzbpb) com_google_android_gms_internal_zzbpe);
        } else if (com_google_android_gms_internal_zzbpe.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        } else if (com_google_android_gms_internal_zzbpe instanceof zzbot) {
            ((zzbot) com_google_android_gms_internal_zzbpe).zza(new C12731(com_google_android_gms_internal_zzbou_zza), true);
        } else {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbpe);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Expected children node, but got: ").append(valueOf).toString());
        }
    }

    public static zzbou zzi(zzbpe com_google_android_gms_internal_zzbpe) {
        return zza(com_google_android_gms_internal_zzbpe, new zzb(com_google_android_gms_internal_zzbpe));
    }

    public List<zzbmj> zzVF() {
        return Collections.unmodifiableList(this.zzbZh);
    }

    public List<String> zzVG() {
        return Collections.unmodifiableList(this.zzbZi);
    }
}
