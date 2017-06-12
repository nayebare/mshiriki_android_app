package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.github.mikephil.charting.BuildConfig;
import com.google.ads.AdSize;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public interface zzaj {

    public static final class zza extends zzbun<zza> {
        private static volatile zza[] zzlw;
        public String string;
        public int type;
        public String zzlA;
        public String zzlB;
        public long zzlC;
        public boolean zzlD;
        public zza[] zzlE;
        public int[] zzlF;
        public boolean zzlG;
        public zza[] zzlx;
        public zza[] zzly;
        public zza[] zzlz;

        public zza() {
            zzP();
        }

        public static zza[] zzO() {
            if (zzlw == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzlw == null) {
                        zzlw = new zza[0];
                    }
                }
            }
            return zzlw;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaj_zza = (zza) obj;
            if (this.type != com_google_android_gms_internal_zzaj_zza.type) {
                return false;
            }
            if (this.string == null) {
                if (com_google_android_gms_internal_zzaj_zza.string != null) {
                    return false;
                }
            } else if (!this.string.equals(com_google_android_gms_internal_zzaj_zza.string)) {
                return false;
            }
            if (!zzbur.equals(this.zzlx, com_google_android_gms_internal_zzaj_zza.zzlx) || !zzbur.equals(this.zzly, com_google_android_gms_internal_zzaj_zza.zzly) || !zzbur.equals(this.zzlz, com_google_android_gms_internal_zzaj_zza.zzlz)) {
                return false;
            }
            if (this.zzlA == null) {
                if (com_google_android_gms_internal_zzaj_zza.zzlA != null) {
                    return false;
                }
            } else if (!this.zzlA.equals(com_google_android_gms_internal_zzaj_zza.zzlA)) {
                return false;
            }
            if (this.zzlB == null) {
                if (com_google_android_gms_internal_zzaj_zza.zzlB != null) {
                    return false;
                }
            } else if (!this.zzlB.equals(com_google_android_gms_internal_zzaj_zza.zzlB)) {
                return false;
            }
            return (this.zzlC == com_google_android_gms_internal_zzaj_zza.zzlC && this.zzlD == com_google_android_gms_internal_zzaj_zza.zzlD && zzbur.equals(this.zzlE, com_google_android_gms_internal_zzaj_zza.zzlE) && zzbur.equals(this.zzlF, com_google_android_gms_internal_zzaj_zza.zzlF) && this.zzlG == com_google_android_gms_internal_zzaj_zza.zzlG) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzaj_zza.zzcrX == null || com_google_android_gms_internal_zzaj_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzaj_zza.zzcrX) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzlD ? 1231 : 1237) + (((((this.zzlB == null ? 0 : this.zzlB.hashCode()) + (((this.zzlA == null ? 0 : this.zzlA.hashCode()) + (((((((((this.string == null ? 0 : this.string.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzbur.hashCode(this.zzlx)) * 31) + zzbur.hashCode(this.zzly)) * 31) + zzbur.hashCode(this.zzlz)) * 31)) * 31)) * 31) + ((int) (this.zzlC ^ (this.zzlC >>> 32)))) * 31)) * 31) + zzbur.hashCode(this.zzlE)) * 31) + zzbur.hashCode(this.zzlF)) * 31;
            if (!this.zzlG) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i2 = this.zzcrX.hashCode();
            }
            return hashCode + i2;
        }

        public zza zzP() {
            this.type = 1;
            this.string = BuildConfig.FLAVOR;
            this.zzlx = zzO();
            this.zzly = zzO();
            this.zzlz = zzO();
            this.zzlA = BuildConfig.FLAVOR;
            this.zzlB = BuildConfig.FLAVOR;
            this.zzlC = 0;
            this.zzlD = false;
            this.zzlE = zzO();
            this.zzlF = zzbuw.zzcsi;
            this.zzlG = false;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            int i = 0;
            com_google_android_gms_internal_zzbum.zzF(1, this.type);
            if (!(this.string == null || this.string.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(2, this.string);
            }
            if (this.zzlx != null && this.zzlx.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzlx) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(3, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            if (this.zzly != null && this.zzly.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut2 : this.zzly) {
                    if (com_google_android_gms_internal_zzbut2 != null) {
                        com_google_android_gms_internal_zzbum.zza(4, com_google_android_gms_internal_zzbut2);
                    }
                }
            }
            if (this.zzlz != null && this.zzlz.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut22 : this.zzlz) {
                    if (com_google_android_gms_internal_zzbut22 != null) {
                        com_google_android_gms_internal_zzbum.zza(5, com_google_android_gms_internal_zzbut22);
                    }
                }
            }
            if (!(this.zzlA == null || this.zzlA.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(6, this.zzlA);
            }
            if (!(this.zzlB == null || this.zzlB.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(7, this.zzlB);
            }
            if (this.zzlC != 0) {
                com_google_android_gms_internal_zzbum.zzb(8, this.zzlC);
            }
            if (this.zzlG) {
                com_google_android_gms_internal_zzbum.zzg(9, this.zzlG);
            }
            if (this.zzlF != null && this.zzlF.length > 0) {
                for (int zzF : this.zzlF) {
                    com_google_android_gms_internal_zzbum.zzF(10, zzF);
                }
            }
            if (this.zzlE != null && this.zzlE.length > 0) {
                while (i < this.zzlE.length) {
                    zzbut com_google_android_gms_internal_zzbut3 = this.zzlE[i];
                    if (com_google_android_gms_internal_zzbut3 != null) {
                        com_google_android_gms_internal_zzbum.zza(11, com_google_android_gms_internal_zzbut3);
                    }
                    i++;
                }
            }
            if (this.zzlD) {
                com_google_android_gms_internal_zzbum.zzg(12, this.zzlD);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzx(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int i;
            int i2 = 0;
            int zzv = super.zzv() + zzbum.zzH(1, this.type);
            if (!(this.string == null || this.string.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(2, this.string);
            }
            if (this.zzlx != null && this.zzlx.length > 0) {
                i = zzv;
                for (zzbut com_google_android_gms_internal_zzbut : this.zzlx) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        i += zzbum.zzc(3, com_google_android_gms_internal_zzbut);
                    }
                }
                zzv = i;
            }
            if (this.zzly != null && this.zzly.length > 0) {
                i = zzv;
                for (zzbut com_google_android_gms_internal_zzbut2 : this.zzly) {
                    if (com_google_android_gms_internal_zzbut2 != null) {
                        i += zzbum.zzc(4, com_google_android_gms_internal_zzbut2);
                    }
                }
                zzv = i;
            }
            if (this.zzlz != null && this.zzlz.length > 0) {
                i = zzv;
                for (zzbut com_google_android_gms_internal_zzbut22 : this.zzlz) {
                    if (com_google_android_gms_internal_zzbut22 != null) {
                        i += zzbum.zzc(5, com_google_android_gms_internal_zzbut22);
                    }
                }
                zzv = i;
            }
            if (!(this.zzlA == null || this.zzlA.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(6, this.zzlA);
            }
            if (!(this.zzlB == null || this.zzlB.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(7, this.zzlB);
            }
            if (this.zzlC != 0) {
                zzv += zzbum.zzf(8, this.zzlC);
            }
            if (this.zzlG) {
                zzv += zzbum.zzh(9, this.zzlG);
            }
            if (this.zzlF != null && this.zzlF.length > 0) {
                int i3 = 0;
                for (int zzqp : this.zzlF) {
                    i3 += zzbum.zzqp(zzqp);
                }
                zzv = (zzv + i3) + (this.zzlF.length * 1);
            }
            if (this.zzlE != null && this.zzlE.length > 0) {
                while (i2 < this.zzlE.length) {
                    zzbut com_google_android_gms_internal_zzbut3 = this.zzlE[i2];
                    if (com_google_android_gms_internal_zzbut3 != null) {
                        zzv += zzbum.zzc(11, com_google_android_gms_internal_zzbut3);
                    }
                    i2++;
                }
            }
            return this.zzlD ? zzv + zzbum.zzh(12, this.zzlD) : zzv;
        }

        public zza zzx(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                int zzc;
                Object obj;
                int i;
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        zzacu = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacu) {
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                            case Dimension.UNIT_IN /*4*/:
                            case Dimension.UNIT_MM /*5*/:
                            case BuyButtonText.LOGO_ONLY /*6*/:
                            case BuyButtonText.DONATE_WITH /*7*/:
                            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                                this.type = zzacu;
                                break;
                            default:
                                continue;
                        }
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.string = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 26);
                        zzacu = this.zzlx == null ? 0 : this.zzlx.length;
                        obj = new zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlx, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzlx = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 34);
                        zzacu = this.zzly == null ? 0 : this.zzly.length;
                        obj = new zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzly, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzly = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 42);
                        zzacu = this.zzlz == null ? 0 : this.zzlz.length;
                        obj = new zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlz, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzlz = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.zzlA = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        this.zzlB = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_editTextBackground /*64*/:
                        this.zzlC = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case C0308R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        this.zzlG = com_google_android_gms_internal_zzbul.zzacA();
                        continue;
                    case C0308R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        int zzc2 = zzbuw.zzc(com_google_android_gms_internal_zzbul, 80);
                        Object obj2 = new int[zzc2];
                        i = 0;
                        zzc = 0;
                        while (i < zzc2) {
                            if (i != 0) {
                                com_google_android_gms_internal_zzbul.zzacu();
                            }
                            int zzacy = com_google_android_gms_internal_zzbul.zzacy();
                            switch (zzacy) {
                                case MessageApi.FILTER_PREFIX /*1*/:
                                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                case Dimension.UNIT_IN /*4*/:
                                case Dimension.UNIT_MM /*5*/:
                                case BuyButtonText.LOGO_ONLY /*6*/:
                                case BuyButtonText.DONATE_WITH /*7*/:
                                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                                case HTTP.HT /*9*/:
                                case HTTP.LF /*10*/:
                                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                case HTTP.CR /*13*/:
                                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                                    zzacu = zzc + 1;
                                    obj2[zzc] = zzacy;
                                    break;
                                default:
                                    zzacu = zzc;
                                    break;
                            }
                            i++;
                            zzc = zzacu;
                        }
                        if (zzc != 0) {
                            zzacu = this.zzlF == null ? 0 : this.zzlF.length;
                            if (zzacu != 0 || zzc != obj2.length) {
                                Object obj3 = new int[(zzacu + zzc)];
                                if (zzacu != 0) {
                                    System.arraycopy(this.zzlF, 0, obj3, 0, zzacu);
                                }
                                System.arraycopy(obj2, 0, obj3, zzacu, zzc);
                                this.zzlF = obj3;
                                break;
                            }
                            this.zzlF = obj2;
                            break;
                        }
                        continue;
                    case C0308R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        i = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            switch (com_google_android_gms_internal_zzbul.zzacy()) {
                                case MessageApi.FILTER_PREFIX /*1*/:
                                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                case Dimension.UNIT_IN /*4*/:
                                case Dimension.UNIT_MM /*5*/:
                                case BuyButtonText.LOGO_ONLY /*6*/:
                                case BuyButtonText.DONATE_WITH /*7*/:
                                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                                case HTTP.HT /*9*/:
                                case HTTP.LF /*10*/:
                                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                case HTTP.CR /*13*/:
                                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                                    zzacu++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (zzacu != 0) {
                            com_google_android_gms_internal_zzbul.zzql(zzc);
                            zzc = this.zzlF == null ? 0 : this.zzlF.length;
                            Object obj4 = new int[(zzacu + zzc)];
                            if (zzc != 0) {
                                System.arraycopy(this.zzlF, 0, obj4, 0, zzc);
                            }
                            while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                                int zzacy2 = com_google_android_gms_internal_zzbul.zzacy();
                                switch (zzacy2) {
                                    case MessageApi.FILTER_PREFIX /*1*/:
                                    case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                    case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                    case Dimension.UNIT_IN /*4*/:
                                    case Dimension.UNIT_MM /*5*/:
                                    case BuyButtonText.LOGO_ONLY /*6*/:
                                    case BuyButtonText.DONATE_WITH /*7*/:
                                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                                    case HTTP.HT /*9*/:
                                    case HTTP.LF /*10*/:
                                    case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                    case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                    case HTTP.CR /*13*/:
                                    case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                    case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                                    case ConnectionResult.SIGN_IN_FAILED /*17*/:
                                        zzacu = zzc + 1;
                                        obj4[zzc] = zzacy2;
                                        zzc = zzacu;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.zzlF = obj4;
                        }
                        com_google_android_gms_internal_zzbul.zzqk(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 90);
                        zzacu = this.zzlE == null ? 0 : this.zzlE.length;
                        obj = new zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlE, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzlE = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                        this.zzlD = com_google_android_gms_internal_zzbul.zzacA();
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
}
