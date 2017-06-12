package com.google.android.gms.internal;

import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.HashMap;
import java.util.Map;

public class zzbod {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final zzbod zzcfX;
    private zzboy zzcfT;
    private Integer zzcfY;
    private zza zzcfZ;
    private zzbpe zzcga;
    private zzbos zzcgb;
    private zzbpe zzcgc;
    private zzbos zzcgd;
    private String zzcge;

    /* renamed from: com.google.android.gms.internal.zzbod.1 */
    static /* synthetic */ class C12661 {
        static final /* synthetic */ int[] zzcgf;

        static {
            zzcgf = new int[zza.values().length];
            try {
                zzcgf[zza.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzcgf[zza.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private enum zza {
        LEFT,
        RIGHT
    }

    static {
        $assertionsDisabled = !zzbod.class.desiredAssertionStatus();
        zzcfX = new zzbod();
    }

    public zzbod() {
        this.zzcga = null;
        this.zzcgb = null;
        this.zzcgc = null;
        this.zzcgd = null;
        this.zzcfT = zzbph.zzZA();
        this.zzcge = null;
    }

    private zzbod zzYA() {
        zzbod com_google_android_gms_internal_zzbod = new zzbod();
        com_google_android_gms_internal_zzbod.zzcfY = this.zzcfY;
        com_google_android_gms_internal_zzbod.zzcga = this.zzcga;
        com_google_android_gms_internal_zzbod.zzcgb = this.zzcgb;
        com_google_android_gms_internal_zzbod.zzcgc = this.zzcgc;
        com_google_android_gms_internal_zzbod.zzcgd = this.zzcgd;
        com_google_android_gms_internal_zzbod.zzcfZ = this.zzcfZ;
        com_google_android_gms_internal_zzbod.zzcfT = this.zzcfT;
        return com_google_android_gms_internal_zzbod;
    }

    public static zzbod zzaD(Map<String, Object> map) {
        String str;
        zzbod com_google_android_gms_internal_zzbod = new zzbod();
        com_google_android_gms_internal_zzbod.zzcfY = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            com_google_android_gms_internal_zzbod.zzcga = zze(zzbpf.zzar(map.get("sp")));
            str = (String) map.get("sn");
            if (str != null) {
                com_google_android_gms_internal_zzbod.zzcgb = zzbos.zzjb(str);
            }
        }
        if (map.containsKey("ep")) {
            com_google_android_gms_internal_zzbod.zzcgc = zze(zzbpf.zzar(map.get("ep")));
            str = (String) map.get("en");
            if (str != null) {
                com_google_android_gms_internal_zzbod.zzcgd = zzbos.zzjb(str);
            }
        }
        str = (String) map.get("vf");
        if (str != null) {
            com_google_android_gms_internal_zzbod.zzcfZ = str.equals("l") ? zza.LEFT : zza.RIGHT;
        }
        str = (String) map.get("i");
        if (str != null) {
            com_google_android_gms_internal_zzbod.zzcfT = zzboy.zzjc(str);
        }
        return com_google_android_gms_internal_zzbod;
    }

    private static zzbpe zze(zzbpe com_google_android_gms_internal_zzbpe) {
        if ((com_google_android_gms_internal_zzbpe instanceof zzbpk) || (com_google_android_gms_internal_zzbpe instanceof zzbor) || (com_google_android_gms_internal_zzbpe instanceof zzbow) || (com_google_android_gms_internal_zzbpe instanceof zzbox)) {
            return com_google_android_gms_internal_zzbpe;
        }
        if (com_google_android_gms_internal_zzbpe instanceof zzbpc) {
            return new zzbow(Double.valueOf(((Long) com_google_android_gms_internal_zzbpe.getValue()).doubleValue()), zzbpi.zzZB());
        }
        String valueOf = String.valueOf(com_google_android_gms_internal_zzbpe.getValue());
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Unexpected value passed to normalizeValue: ").append(valueOf).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzbod com_google_android_gms_internal_zzbod = (zzbod) obj;
        return (this.zzcfY == null ? com_google_android_gms_internal_zzbod.zzcfY != null : !this.zzcfY.equals(com_google_android_gms_internal_zzbod.zzcfY)) ? false : (this.zzcfT == null ? com_google_android_gms_internal_zzbod.zzcfT != null : !this.zzcfT.equals(com_google_android_gms_internal_zzbod.zzcfT)) ? false : (this.zzcgd == null ? com_google_android_gms_internal_zzbod.zzcgd != null : !this.zzcgd.equals(com_google_android_gms_internal_zzbod.zzcgd)) ? false : (this.zzcgc == null ? com_google_android_gms_internal_zzbod.zzcgc != null : !this.zzcgc.equals(com_google_android_gms_internal_zzbod.zzcgc)) ? false : (this.zzcgb == null ? com_google_android_gms_internal_zzbod.zzcgb != null : !this.zzcgb.equals(com_google_android_gms_internal_zzbod.zzcgb)) ? false : (this.zzcga == null ? com_google_android_gms_internal_zzbod.zzcga != null : !this.zzcga.equals(com_google_android_gms_internal_zzbod.zzcga)) ? false : zzYB() == com_google_android_gms_internal_zzbod.zzYB();
    }

    public int getLimit() {
        if (zzYx()) {
            return this.zzcfY.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzcgd != null ? this.zzcgd.hashCode() : 0) + (((this.zzcgc != null ? this.zzcgc.hashCode() : 0) + (((this.zzcgb != null ? this.zzcgb.hashCode() : 0) + (((this.zzcga != null ? this.zzcga.hashCode() : 0) + (((zzYB() ? 1231 : 1237) + ((this.zzcfY != null ? this.zzcfY.intValue() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzcfT != null) {
            i = this.zzcfT.hashCode();
        }
        return hashCode + i;
    }

    public boolean isDefault() {
        return zzYD() && this.zzcfT.equals(zzbph.zzZA());
    }

    public boolean isValid() {
        return (zzYr() && zzYu() && zzYx() && !zzYy()) ? false : true;
    }

    public String toString() {
        return zzYC().toString();
    }

    public boolean zzYB() {
        return this.zzcfZ != null ? this.zzcfZ == zza.LEFT : zzYr();
    }

    public Map<String, Object> zzYC() {
        Map<String, Object> hashMap = new HashMap();
        if (zzYr()) {
            hashMap.put("sp", this.zzcga.getValue());
            if (this.zzcgb != null) {
                hashMap.put("sn", this.zzcgb.asString());
            }
        }
        if (zzYu()) {
            hashMap.put("ep", this.zzcgc.getValue());
            if (this.zzcgd != null) {
                hashMap.put("en", this.zzcgd.asString());
            }
        }
        if (this.zzcfY != null) {
            hashMap.put("l", this.zzcfY);
            zza com_google_android_gms_internal_zzbod_zza = this.zzcfZ;
            if (com_google_android_gms_internal_zzbod_zza == null) {
                com_google_android_gms_internal_zzbod_zza = zzYr() ? zza.LEFT : zza.RIGHT;
            }
            switch (C12661.zzcgf[com_google_android_gms_internal_zzbod_zza.ordinal()]) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    hashMap.put("vf", "l");
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    hashMap.put("vf", "r");
                    break;
            }
        }
        if (!this.zzcfT.equals(zzbph.zzZA())) {
            hashMap.put("i", this.zzcfT.zzZs());
        }
        return hashMap;
    }

    public boolean zzYD() {
        return (zzYr() || zzYu() || zzYx()) ? false : true;
    }

    public String zzYE() {
        if (this.zzcge == null) {
            try {
                this.zzcge = zzbpx.zzaE(zzYC());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return this.zzcge;
    }

    public zzbol zzYF() {
        return zzYD() ? new zzboj(zzYz()) : zzYx() ? new zzbok(this) : new zzbom(this);
    }

    public boolean zzYr() {
        return this.zzcga != null;
    }

    public zzbpe zzYs() {
        if (zzYr()) {
            return this.zzcga;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public zzbos zzYt() {
        if (zzYr()) {
            return this.zzcgb != null ? this.zzcgb : zzbos.zzYW();
        } else {
            throw new IllegalArgumentException("Cannot get index start name if start has not been set");
        }
    }

    public boolean zzYu() {
        return this.zzcgc != null;
    }

    public zzbpe zzYv() {
        if (zzYu()) {
            return this.zzcgc;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public zzbos zzYw() {
        if (zzYu()) {
            return this.zzcgd != null ? this.zzcgd : zzbos.zzYX();
        } else {
            throw new IllegalArgumentException("Cannot get index end name if start has not been set");
        }
    }

    public boolean zzYx() {
        return this.zzcfY != null;
    }

    public boolean zzYy() {
        return zzYx() && this.zzcfZ != null;
    }

    public zzboy zzYz() {
        return this.zzcfT;
    }

    public zzbod zza(zzboy com_google_android_gms_internal_zzboy) {
        zzbod zzYA = zzYA();
        zzYA.zzcfT = com_google_android_gms_internal_zzboy;
        return zzYA;
    }

    public zzbod zza(zzbpe com_google_android_gms_internal_zzbpe, zzbos com_google_android_gms_internal_zzbos) {
        if ($assertionsDisabled || com_google_android_gms_internal_zzbpe.zzZd() || com_google_android_gms_internal_zzbpe.isEmpty()) {
            zzbqg.zzaW(!(com_google_android_gms_internal_zzbpe instanceof zzbpc));
            zzbod zzYA = zzYA();
            zzYA.zzcga = com_google_android_gms_internal_zzbpe;
            zzYA.zzcgb = com_google_android_gms_internal_zzbos;
            return zzYA;
        }
        throw new AssertionError();
    }

    public zzbod zzb(zzbpe com_google_android_gms_internal_zzbpe, zzbos com_google_android_gms_internal_zzbos) {
        if ($assertionsDisabled || com_google_android_gms_internal_zzbpe.zzZd() || com_google_android_gms_internal_zzbpe.isEmpty()) {
            zzbqg.zzaW(!(com_google_android_gms_internal_zzbpe instanceof zzbpc));
            zzbod zzYA = zzYA();
            zzYA.zzcgc = com_google_android_gms_internal_zzbpe;
            zzYA.zzcgd = com_google_android_gms_internal_zzbos;
            return zzYA;
        }
        throw new AssertionError();
    }

    public zzbod zzpO(int i) {
        zzbod zzYA = zzYA();
        zzYA.zzcfY = Integer.valueOf(i);
        zzYA.zzcfZ = zza.LEFT;
        return zzYA;
    }

    public zzbod zzpP(int i) {
        zzbod zzYA = zzYA();
        zzYA.zzcfY = Integer.valueOf(i);
        zzYA.zzcfZ = zza.RIGHT;
        return zzYA;
    }
}
