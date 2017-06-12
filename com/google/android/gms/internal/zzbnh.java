package com.google.android.gms.internal;

public class zzbnh {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final zzbnh zzceJ;
    public static final zzbnh zzceK;
    private final zza zzceL;
    private final zzbod zzceM;
    private final boolean zzceN;

    private enum zza {
        User,
        Server
    }

    static {
        $assertionsDisabled = !zzbnh.class.desiredAssertionStatus();
        zzceJ = new zzbnh(zza.User, null, false);
        zzceK = new zzbnh(zza.Server, null, false);
    }

    public zzbnh(zza com_google_android_gms_internal_zzbnh_zza, zzbod com_google_android_gms_internal_zzbod, boolean z) {
        this.zzceL = com_google_android_gms_internal_zzbnh_zza;
        this.zzceM = com_google_android_gms_internal_zzbod;
        this.zzceN = z;
        if (!$assertionsDisabled && z && !zzXR()) {
            throw new AssertionError();
        }
    }

    public static zzbnh zzc(zzbod com_google_android_gms_internal_zzbod) {
        return new zzbnh(zza.Server, com_google_android_gms_internal_zzbod, true);
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzceL);
        String valueOf2 = String.valueOf(this.zzceM);
        return new StringBuilder((String.valueOf(valueOf).length() + 52) + String.valueOf(valueOf2).length()).append("OperationSource{source=").append(valueOf).append(", queryParams=").append(valueOf2).append(", tagged=").append(this.zzceN).append("}").toString();
    }

    public boolean zzXQ() {
        return this.zzceL == zza.User;
    }

    public boolean zzXR() {
        return this.zzceL == zza.Server;
    }

    public boolean zzXS() {
        return this.zzceN;
    }

    public zzbod zzXT() {
        return this.zzceM;
    }
}
