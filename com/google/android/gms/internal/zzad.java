package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public interface zzad {

    public static final class zza extends zzbut {
        public zzb zzaJ;
        public zzc zzaK;

        public zza() {
            zzu();
        }

        public static zza zzc(byte[] bArr) throws zzbus {
            return (zza) zzbut.zza(new zza(), bArr);
        }

        public zza zza(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        if (this.zzaJ == null) {
                            this.zzaJ = new zzb();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzaJ);
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzaK == null) {
                            this.zzaK = new zzc();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzaK);
                        continue;
                    default:
                        if (!zzbuw.zzb(com_google_android_gms_internal_zzbul, zzacu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzaJ != null) {
                com_google_android_gms_internal_zzbum.zza(1, this.zzaJ);
            }
            if (this.zzaK != null) {
                com_google_android_gms_internal_zzbum.zza(2, this.zzaK);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zza(com_google_android_gms_internal_zzbul);
        }

        public zza zzu() {
            this.zzaJ = null;
            this.zzaK = null;
            this.zzcsg = -1;
            return this;
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzaJ != null) {
                zzv += zzbum.zzc(1, this.zzaJ);
            }
            return this.zzaK != null ? zzv + zzbum.zzc(2, this.zzaK) : zzv;
        }
    }

    public static final class zzb extends zzbut {
        public Integer zzaL;

        public zzb() {
            zzw();
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzaL != null) {
                com_google_android_gms_internal_zzbum.zzF(27, this.zzaL.intValue());
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzc(com_google_android_gms_internal_zzbul);
        }

        public zzb zzc(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case 216:
                        zzacu = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacu) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                            case Dimension.UNIT_IN /*4*/:
                                this.zzaL = Integer.valueOf(zzacu);
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!zzbuw.zzb(com_google_android_gms_internal_zzbul, zzacu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        protected int zzv() {
            int zzv = super.zzv();
            return this.zzaL != null ? zzv + zzbum.zzH(27, this.zzaL.intValue()) : zzv;
        }

        public zzb zzw() {
            this.zzcsg = -1;
            return this;
        }
    }

    public static final class zzc extends zzbut {
        public String zzaM;
        public String zzaN;
        public String zzaO;
        public String zzaP;
        public String zzaQ;

        public zzc() {
            zzx();
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzaM != null) {
                com_google_android_gms_internal_zzbum.zzq(1, this.zzaM);
            }
            if (this.zzaN != null) {
                com_google_android_gms_internal_zzbum.zzq(2, this.zzaN);
            }
            if (this.zzaO != null) {
                com_google_android_gms_internal_zzbum.zzq(3, this.zzaO);
            }
            if (this.zzaP != null) {
                com_google_android_gms_internal_zzbum.zzq(4, this.zzaP);
            }
            if (this.zzaQ != null) {
                com_google_android_gms_internal_zzbum.zzq(5, this.zzaQ);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzd(com_google_android_gms_internal_zzbul);
        }

        public zzc zzd(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        this.zzaM = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzaN = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        this.zzaO = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzaP = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.zzaQ = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    default:
                        if (!zzbuw.zzb(com_google_android_gms_internal_zzbul, zzacu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzaM != null) {
                zzv += zzbum.zzr(1, this.zzaM);
            }
            if (this.zzaN != null) {
                zzv += zzbum.zzr(2, this.zzaN);
            }
            if (this.zzaO != null) {
                zzv += zzbum.zzr(3, this.zzaO);
            }
            if (this.zzaP != null) {
                zzv += zzbum.zzr(4, this.zzaP);
            }
            return this.zzaQ != null ? zzv + zzbum.zzr(5, this.zzaQ) : zzv;
        }

        public zzc zzx() {
            this.zzaM = null;
            this.zzaN = null;
            this.zzaO = null;
            this.zzaP = null;
            this.zzaQ = null;
            this.zzcsg = -1;
            return this;
        }
    }
}
