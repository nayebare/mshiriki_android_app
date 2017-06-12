package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.zzai.zzf;
import com.google.android.gms.internal.zzai.zzj;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public interface zzbgg {

    public static final class zza extends zzbun<zza> {
        public long zzbLh;
        public zzj zzbLi;
        public zzf zzlu;

        public zza() {
            zzRT();
        }

        public static zza zzP(byte[] bArr) throws zzbus {
            return (zza) zzbut.zza(new zza(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbgg_zza = (zza) obj;
            if (this.zzbLh != com_google_android_gms_internal_zzbgg_zza.zzbLh) {
                return false;
            }
            if (this.zzlu == null) {
                if (com_google_android_gms_internal_zzbgg_zza.zzlu != null) {
                    return false;
                }
            } else if (!this.zzlu.equals(com_google_android_gms_internal_zzbgg_zza.zzlu)) {
                return false;
            }
            if (this.zzbLi == null) {
                if (com_google_android_gms_internal_zzbgg_zza.zzbLi != null) {
                    return false;
                }
            } else if (!this.zzbLi.equals(com_google_android_gms_internal_zzbgg_zza.zzbLi)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbgg_zza.zzcrX == null || com_google_android_gms_internal_zzbgg_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbgg_zza.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbLi == null ? 0 : this.zzbLi.hashCode()) + (((this.zzlu == null ? 0 : this.zzlu.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbLh ^ (this.zzbLh >>> 32)))) * 31)) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zza zzRT() {
            this.zzbLh = 0;
            this.zzlu = null;
            this.zzbLi = null;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zza zzW(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.zzbLh = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzlu == null) {
                            this.zzlu = new zzf();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzlu);
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        if (this.zzbLi == null) {
                            this.zzbLi = new zzj();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzbLi);
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

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            com_google_android_gms_internal_zzbum.zzb(1, this.zzbLh);
            if (this.zzlu != null) {
                com_google_android_gms_internal_zzbum.zza(2, this.zzlu);
            }
            if (this.zzbLi != null) {
                com_google_android_gms_internal_zzbum.zza(3, this.zzbLi);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzW(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv() + zzbum.zzf(1, this.zzbLh);
            if (this.zzlu != null) {
                zzv += zzbum.zzc(2, this.zzlu);
            }
            return this.zzbLi != null ? zzv + zzbum.zzc(3, this.zzbLi) : zzv;
        }
    }
}
