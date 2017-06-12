package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class zzbpb<T extends zzbpb> implements zzbpe {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected final zzbpe zzcgQ;
    private String zzcgR;

    /* renamed from: com.google.android.gms.internal.zzbpb.1 */
    static /* synthetic */ class C12741 {
        static final /* synthetic */ int[] zzchm;

        static {
            zzchm = new int[com.google.android.gms.internal.zzbpe.zza.values().length];
            try {
                zzchm[com.google.android.gms.internal.zzbpe.zza.V1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzchm[com.google.android.gms.internal.zzbpe.zza.V2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected enum zza {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    static {
        $assertionsDisabled = !zzbpb.class.desiredAssertionStatus();
    }

    zzbpb(zzbpe com_google_android_gms_internal_zzbpe) {
        this.zzcgQ = com_google_android_gms_internal_zzbpe;
    }

    private static int zza(zzbpc com_google_android_gms_internal_zzbpc, zzbow com_google_android_gms_internal_zzbow) {
        return Double.valueOf((double) ((Long) com_google_android_gms_internal_zzbpc.getValue()).longValue()).compareTo((Double) com_google_android_gms_internal_zzbow.getValue());
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzh((zzbpe) obj);
    }

    public int getChildCount() {
        return 0;
    }

    public Object getValue(boolean z) {
        if (!z || this.zzcgQ.isEmpty()) {
            return getValue();
        }
        Map hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.zzcgQ.getValue());
        return hashMap;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<zzbpd> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = getValue(true).toString();
        return obj.length() <= 100 ? obj : String.valueOf(obj.substring(0, 100)).concat("...");
    }

    public zzbpe zzO(zzbmj com_google_android_gms_internal_zzbmj) {
        return com_google_android_gms_internal_zzbmj.isEmpty() ? this : com_google_android_gms_internal_zzbmj.zzXi().zzZa() ? this.zzcgQ : zzbox.zzZp();
    }

    public Iterator<zzbpd> zzVl() {
        return Collections.emptyList().iterator();
    }

    protected abstract zza zzYV();

    public String zzZc() {
        if (this.zzcgR == null) {
            this.zzcgR = zzbqg.zzji(zza(com.google.android.gms.internal.zzbpe.zza.V1));
        }
        return this.zzcgR;
    }

    public boolean zzZd() {
        return true;
    }

    public zzbpe zzZe() {
        return this.zzcgQ;
    }

    protected abstract int zza(T t);

    protected String zzb(com.google.android.gms.internal.zzbpe.zza com_google_android_gms_internal_zzbpe_zza) {
        switch (C12741.zzchm[com_google_android_gms_internal_zzbpe_zza.ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                if (this.zzcgQ.isEmpty()) {
                    return BuildConfig.FLAVOR;
                }
                String valueOf = String.valueOf(this.zzcgQ.zza(com_google_android_gms_internal_zzbpe_zza));
                return new StringBuilder(String.valueOf(valueOf).length() + 10).append("priority:").append(valueOf).append(":").toString();
            default:
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzbpe_zza);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 22).append("Unknown hash version: ").append(valueOf2).toString());
        }
    }

    protected int zzc(zzbpb<?> com_google_android_gms_internal_zzbpb_) {
        zza zzYV = zzYV();
        Enum zzYV2 = com_google_android_gms_internal_zzbpb_.zzYV();
        return zzYV.equals(zzYV2) ? zza(com_google_android_gms_internal_zzbpb_) : zzYV.compareTo(zzYV2);
    }

    public zzbpe zze(zzbos com_google_android_gms_internal_zzbos, zzbpe com_google_android_gms_internal_zzbpe) {
        return com_google_android_gms_internal_zzbos.zzZa() ? zzg(com_google_android_gms_internal_zzbpe) : !com_google_android_gms_internal_zzbpe.isEmpty() ? zzbox.zzZp().zze(com_google_android_gms_internal_zzbos, com_google_android_gms_internal_zzbpe).zzg(this.zzcgQ) : this;
    }

    public int zzh(zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbpe.isEmpty()) {
            return 1;
        }
        if (com_google_android_gms_internal_zzbpe instanceof zzbot) {
            return -1;
        }
        if ($assertionsDisabled || com_google_android_gms_internal_zzbpe.zzZd()) {
            return ((this instanceof zzbpc) && (com_google_android_gms_internal_zzbpe instanceof zzbow)) ? zza((zzbpc) this, (zzbow) com_google_android_gms_internal_zzbpe) : ((this instanceof zzbow) && (com_google_android_gms_internal_zzbpe instanceof zzbpc)) ? zza((zzbpc) com_google_android_gms_internal_zzbpe, (zzbow) this) * -1 : zzc((zzbpb) com_google_android_gms_internal_zzbpe);
        } else {
            throw new AssertionError("Node is not leaf node!");
        }
    }

    public boolean zzk(zzbos com_google_android_gms_internal_zzbos) {
        return false;
    }

    public zzbos zzl(zzbos com_google_android_gms_internal_zzbos) {
        return null;
    }

    public zzbpe zzl(zzbmj com_google_android_gms_internal_zzbmj, zzbpe com_google_android_gms_internal_zzbpe) {
        zzbos zzXi = com_google_android_gms_internal_zzbmj.zzXi();
        if (zzXi == null) {
            return com_google_android_gms_internal_zzbpe;
        }
        if (com_google_android_gms_internal_zzbpe.isEmpty() && !zzXi.zzZa()) {
            return this;
        }
        if ($assertionsDisabled || !com_google_android_gms_internal_zzbmj.zzXi().zzZa() || com_google_android_gms_internal_zzbmj.size() == 1) {
            return zze(zzXi, zzbox.zzZp().zzl(com_google_android_gms_internal_zzbmj.zzXj(), com_google_android_gms_internal_zzbpe));
        }
        throw new AssertionError();
    }

    public zzbpe zzm(zzbos com_google_android_gms_internal_zzbos) {
        return com_google_android_gms_internal_zzbos.zzZa() ? this.zzcgQ : zzbox.zzZp();
    }
}
