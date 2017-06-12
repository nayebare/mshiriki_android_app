package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class zzbnc implements zzbmf {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static zzbnc zzcey;
    final HashMap<zzbme, List<zzbme>> zzcex;

    static {
        $assertionsDisabled = !zzbnc.class.desiredAssertionStatus();
        zzcey = new zzbnc();
    }

    private zzbnc() {
        this.zzcex = new HashMap();
    }

    public static zzbnc zzXK() {
        return zzcey;
    }

    private void zzj(zzbme com_google_android_gms_internal_zzbme) {
        int i = 0;
        synchronized (this.zzcex) {
            List list = (List) this.zzcex.get(com_google_android_gms_internal_zzbme);
            int i2;
            if (list != null) {
                int i3;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (list.get(i4) == com_google_android_gms_internal_zzbme) {
                        i3 = 1;
                        list.remove(i4);
                        break;
                    }
                }
                i3 = 0;
                if (list.isEmpty()) {
                    this.zzcex.remove(com_google_android_gms_internal_zzbme);
                }
                i2 = i3;
            } else {
                i2 = 0;
            }
            if (!$assertionsDisabled && r0 == 0 && com_google_android_gms_internal_zzbme.zzXc()) {
                throw new AssertionError();
            }
            if (!com_google_android_gms_internal_zzbme.zzWD().isDefault()) {
                zzbme zza = com_google_android_gms_internal_zzbme.zza(zzboe.zzN(com_google_android_gms_internal_zzbme.zzWD().zzVc()));
                list = (List) this.zzcex.get(zza);
                if (list != null) {
                    while (i < list.size()) {
                        if (list.get(i) == com_google_android_gms_internal_zzbme) {
                            list.remove(i);
                            break;
                        }
                        i++;
                    }
                    if (list.isEmpty()) {
                        this.zzcex.remove(zza);
                    }
                }
            }
        }
    }

    public void zzd(zzbme com_google_android_gms_internal_zzbme) {
        zzj(com_google_android_gms_internal_zzbme);
    }

    public void zzi(zzbme com_google_android_gms_internal_zzbme) {
        synchronized (this.zzcex) {
            List list = (List) this.zzcex.get(com_google_android_gms_internal_zzbme);
            if (list == null) {
                list = new ArrayList();
                this.zzcex.put(com_google_android_gms_internal_zzbme, list);
            }
            list.add(com_google_android_gms_internal_zzbme);
            if (!com_google_android_gms_internal_zzbme.zzWD().isDefault()) {
                zzbme zza = com_google_android_gms_internal_zzbme.zza(zzboe.zzN(com_google_android_gms_internal_zzbme.zzWD().zzVc()));
                list = (List) this.zzcex.get(zza);
                if (list == null) {
                    list = new ArrayList();
                    this.zzcex.put(zza, list);
                }
                list.add(com_google_android_gms_internal_zzbme);
            }
            com_google_android_gms_internal_zzbme.zzba(true);
            com_google_android_gms_internal_zzbme.zza((zzbmf) this);
        }
    }

    public void zzk(zzbme com_google_android_gms_internal_zzbme) {
        synchronized (this.zzcex) {
            List list = (List) this.zzcex.get(com_google_android_gms_internal_zzbme);
            if (!(list == null || list.isEmpty())) {
                if (com_google_android_gms_internal_zzbme.zzWD().isDefault()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        zzbme com_google_android_gms_internal_zzbme2 = (zzbme) list.get(size);
                        if (!hashSet.contains(com_google_android_gms_internal_zzbme2.zzWD())) {
                            hashSet.add(com_google_android_gms_internal_zzbme2.zzWD());
                            com_google_android_gms_internal_zzbme2.zzXa();
                        }
                    }
                } else {
                    ((zzbme) list.get(0)).zzXa();
                }
            }
        }
    }
}
