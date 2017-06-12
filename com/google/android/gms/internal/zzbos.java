package com.google.android.gms.internal;

public class zzbos implements Comparable<zzbos> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final zzbos zzcgL;
    private static final zzbos zzcgM;
    private static final zzbos zzcgN;
    private static final zzbos zzcgO;
    private final String zzaA;

    private static class zza extends zzbos {
        private final int zzaFz;

        zza(String str, int i) {
            super(null);
            this.zzaFz = i;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return super.zzi((zzbos) obj);
        }

        protected int intValue() {
            return this.zzaFz;
        }

        public String toString() {
            String zzj = this.zzaA;
            return new StringBuilder(String.valueOf(zzj).length() + 20).append("IntegerChildName(\"").append(zzj).append("\")").toString();
        }

        protected boolean zzZb() {
            return true;
        }
    }

    static {
        $assertionsDisabled = !zzbos.class.desiredAssertionStatus();
        zzcgL = new zzbos("[MIN_KEY]");
        zzcgM = new zzbos("[MAX_KEY]");
        zzcgN = new zzbos(".priority");
        zzcgO = new zzbos(".info");
    }

    private zzbos(String str) {
        this.zzaA = str;
    }

    public static zzbos zzYW() {
        return zzcgL;
    }

    public static zzbos zzYX() {
        return zzcgM;
    }

    public static zzbos zzYY() {
        return zzcgN;
    }

    public static zzbos zzYZ() {
        return zzcgO;
    }

    public static zzbos zzjb(String str) {
        Integer zzjk = zzbqg.zzjk(str);
        if (zzjk != null) {
            return new zza(str, zzjk.intValue());
        }
        if (str.equals(".priority")) {
            return zzcgN;
        }
        if ($assertionsDisabled || !str.contains("/")) {
            return new zzbos(str);
        }
        throw new AssertionError();
    }

    public String asString() {
        return this.zzaA;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzi((zzbos) obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbos)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.zzaA.equals(((zzbos) obj).zzaA);
    }

    public int hashCode() {
        return this.zzaA.hashCode();
    }

    protected int intValue() {
        return 0;
    }

    public String toString() {
        String str = this.zzaA;
        return new StringBuilder(String.valueOf(str).length() + 12).append("ChildKey(\"").append(str).append("\")").toString();
    }

    public boolean zzZa() {
        return this == zzcgN;
    }

    protected boolean zzZb() {
        return false;
    }

    public int zzi(zzbos com_google_android_gms_internal_zzbos) {
        if (this == com_google_android_gms_internal_zzbos) {
            return 0;
        }
        if (this == zzcgL || com_google_android_gms_internal_zzbos == zzcgM) {
            return -1;
        }
        if (com_google_android_gms_internal_zzbos == zzcgL || this == zzcgM) {
            return 1;
        }
        if (!zzZb()) {
            return com_google_android_gms_internal_zzbos.zzZb() ? 1 : this.zzaA.compareTo(com_google_android_gms_internal_zzbos.zzaA);
        } else {
            if (!com_google_android_gms_internal_zzbos.zzZb()) {
                return -1;
            }
            int zzD = zzbqg.zzD(intValue(), com_google_android_gms_internal_zzbos.intValue());
            return zzD == 0 ? zzbqg.zzD(this.zzaA.length(), com_google_android_gms_internal_zzbos.zzaA.length()) : zzD;
        }
    }
}
