package com.google.android.gms.internal;

import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzalg extends zzbun<zzalg> {
    public long zzaNg;
    public long zzaNj;

    public zzalg() {
        zzAB();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzalg)) {
            return false;
        }
        zzalg com_google_android_gms_internal_zzalg = (zzalg) obj;
        return (this.zzaNj == com_google_android_gms_internal_zzalg.zzaNj && this.zzaNg == com_google_android_gms_internal_zzalg.zzaNg) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzalg.zzcrX == null || com_google_android_gms_internal_zzalg.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzalg.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzaNj ^ (this.zzaNj >>> 32)))) * 31) + ((int) (this.zzaNg ^ (this.zzaNg >>> 32)))) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public zzalg zzA(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    this.zzaNj = com_google_android_gms_internal_zzbul.zzacC();
                    continue;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.zzaNg = com_google_android_gms_internal_zzbul.zzacC();
                    continue;
                default:
                    if (!super.zza(com_google_android_gms_internal_zzbul, zzacu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public zzalg zzAB() {
        this.zzaNj = -1;
        this.zzaNg = -1;
        this.zzcrX = null;
        this.zzcsg = -1;
        return this;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        com_google_android_gms_internal_zzbum.zzd(1, this.zzaNj);
        com_google_android_gms_internal_zzbum.zzd(2, this.zzaNg);
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzA(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        return (super.zzv() + zzbum.zzh(1, this.zzaNj)) + zzbum.zzh(2, this.zzaNg);
    }
}
