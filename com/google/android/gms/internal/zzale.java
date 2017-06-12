package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public final class zzale extends zzbun<zzale> {
    public int versionCode;
    public long zzaNf;
    public long zzaNg;
    public long zzaNh;

    public zzale() {
        zzAz();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzale)) {
            return false;
        }
        zzale com_google_android_gms_internal_zzale = (zzale) obj;
        return (this.versionCode == com_google_android_gms_internal_zzale.versionCode && this.zzaNf == com_google_android_gms_internal_zzale.zzaNf && this.zzaNg == com_google_android_gms_internal_zzale.zzaNg && this.zzaNh == com_google_android_gms_internal_zzale.zzaNh) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzale.zzcrX == null || com_google_android_gms_internal_zzale.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzale.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31) + ((int) (this.zzaNf ^ (this.zzaNf >>> 32)))) * 31) + ((int) (this.zzaNg ^ (this.zzaNg >>> 32)))) * 31) + ((int) (this.zzaNh ^ (this.zzaNh >>> 32)))) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public zzale zzAz() {
        this.versionCode = 1;
        this.zzaNf = -1;
        this.zzaNg = -1;
        this.zzaNh = -1;
        this.zzcrX = null;
        this.zzcsg = -1;
        return this;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        com_google_android_gms_internal_zzbum.zzF(1, this.versionCode);
        com_google_android_gms_internal_zzbum.zzd(2, this.zzaNf);
        com_google_android_gms_internal_zzbum.zzd(3, this.zzaNg);
        com_google_android_gms_internal_zzbum.zzd(4, this.zzaNh);
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzy(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        return (((super.zzv() + zzbum.zzH(1, this.versionCode)) + zzbum.zzh(2, this.zzaNf)) + zzbum.zzh(3, this.zzaNg)) + zzbum.zzh(4, this.zzaNh);
    }

    public zzale zzy(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    this.versionCode = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.zzaNf = com_google_android_gms_internal_zzbul.zzacC();
                    continue;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    this.zzaNg = com_google_android_gms_internal_zzbul.zzacC();
                    continue;
                case HTTP.SP /*32*/:
                    this.zzaNh = com_google_android_gms_internal_zzbul.zzacC();
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
}
