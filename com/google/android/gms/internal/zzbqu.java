package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;

public interface zzbqu {

    public static final class zza extends zzbun<zza> {
        public long timestamp;
        public zzd[] zzcjU;

        public zza() {
            zzaaA();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbqu_zza = (zza) obj;
            return (zzbur.equals(this.zzcjU, com_google_android_gms_internal_zzbqu_zza.zzcjU) && this.timestamp == com_google_android_gms_internal_zzbqu_zza.timestamp) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbqu_zza.zzcrX == null || com_google_android_gms_internal_zzbqu_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbqu_zza.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzcjU)) * 31) + ((int) (this.timestamp ^ (this.timestamp >>> 32)))) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzcjU != null && this.zzcjU.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzcjU) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(1, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            if (this.timestamp != 0) {
                com_google_android_gms_internal_zzbum.zzc(2, this.timestamp);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zza zzaaA() {
            this.zzcjU = zzd.zzaaE();
            this.timestamp = 0;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zza zzac(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                        zzacu = this.zzcjU == null ? 0 : this.zzcjU.length;
                        Object obj = new zzd[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzcjU, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzd();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzd();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzcjU = obj;
                        continue;
                    case ConnectionResult.SIGN_IN_FAILED /*17*/:
                        this.timestamp = com_google_android_gms_internal_zzbul.zzacz();
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

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzac(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcjU != null && this.zzcjU.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzcjU) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        zzv += zzbum.zzc(1, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            return this.timestamp != 0 ? zzv + zzbum.zzg(2, this.timestamp) : zzv;
        }
    }

    public static final class zzb extends zzbun<zzb> {
        private static volatile zzb[] zzcjV;
        public String zzaA;
        public byte[] zzcjW;

        public zzb() {
            zzaaC();
        }

        public static zzb[] zzaaB() {
            if (zzcjV == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzcjV == null) {
                        zzcjV = new zzb[0];
                    }
                }
            }
            return zzcjV;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzbqu_zzb = (zzb) obj;
            if (this.zzaA == null) {
                if (com_google_android_gms_internal_zzbqu_zzb.zzaA != null) {
                    return false;
                }
            } else if (!this.zzaA.equals(com_google_android_gms_internal_zzbqu_zzb.zzaA)) {
                return false;
            }
            return Arrays.equals(this.zzcjW, com_google_android_gms_internal_zzbqu_zzb.zzcjW) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbqu_zzb.zzcrX == null || com_google_android_gms_internal_zzbqu_zzb.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbqu_zzb.zzcrX) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaA == null ? 0 : this.zzaA.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + Arrays.hashCode(this.zzcjW)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (!(this.zzaA == null || this.zzaA.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(1, this.zzaA);
            }
            if (!Arrays.equals(this.zzcjW, zzbuw.zzcsp)) {
                com_google_android_gms_internal_zzbum.zzb(2, this.zzcjW);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zzb zzaaC() {
            this.zzaA = BuildConfig.FLAVOR;
            this.zzcjW = zzbuw.zzcsp;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zzb zzad(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        this.zzaA = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzcjW = com_google_android_gms_internal_zzbul.readBytes();
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

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzad(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (!(this.zzaA == null || this.zzaA.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(1, this.zzaA);
            }
            return !Arrays.equals(this.zzcjW, zzbuw.zzcsp) ? zzv + zzbum.zzc(2, this.zzcjW) : zzv;
        }
    }

    public static final class zzc extends zzbun<zzc> {
        public int zzcjX;
        public boolean zzcjY;

        public zzc() {
            zzaaD();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzbqu_zzc = (zzc) obj;
            return (this.zzcjX == com_google_android_gms_internal_zzbqu_zzc.zzcjX && this.zzcjY == com_google_android_gms_internal_zzbqu_zzc.zzcjY) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbqu_zzc.zzcrX == null || com_google_android_gms_internal_zzbqu_zzc.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbqu_zzc.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = ((this.zzcjY ? 1231 : 1237) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzcjX) * 31)) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzcjX != 0) {
                com_google_android_gms_internal_zzbum.zzF(1, this.zzcjX);
            }
            if (this.zzcjY) {
                com_google_android_gms_internal_zzbum.zzg(2, this.zzcjY);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zzc zzaaD() {
            this.zzcjX = 0;
            this.zzcjY = false;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zzc zzae(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.zzcjX = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.zzcjY = com_google_android_gms_internal_zzbul.zzacA();
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

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzae(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcjX != 0) {
                zzv += zzbum.zzH(1, this.zzcjX);
            }
            return this.zzcjY ? zzv + zzbum.zzh(2, this.zzcjY) : zzv;
        }
    }

    public static final class zzd extends zzbun<zzd> {
        private static volatile zzd[] zzcjZ;
        public String zzaFs;
        public zzb[] zzcka;

        public zzd() {
            zzaaF();
        }

        public static zzd[] zzaaE() {
            if (zzcjZ == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzcjZ == null) {
                        zzcjZ = new zzd[0];
                    }
                }
            }
            return zzcjZ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzbqu_zzd = (zzd) obj;
            if (this.zzaFs == null) {
                if (com_google_android_gms_internal_zzbqu_zzd.zzaFs != null) {
                    return false;
                }
            } else if (!this.zzaFs.equals(com_google_android_gms_internal_zzbqu_zzd.zzaFs)) {
                return false;
            }
            return zzbur.equals(this.zzcka, com_google_android_gms_internal_zzbqu_zzd.zzcka) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbqu_zzd.zzcrX == null || com_google_android_gms_internal_zzbqu_zzd.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbqu_zzd.zzcrX) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaFs == null ? 0 : this.zzaFs.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzbur.hashCode(this.zzcka)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (!(this.zzaFs == null || this.zzaFs.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(1, this.zzaFs);
            }
            if (this.zzcka != null && this.zzcka.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzcka) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(2, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zzd zzaaF() {
            this.zzaFs = BuildConfig.FLAVOR;
            this.zzcka = zzb.zzaaB();
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zzd zzaf(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        this.zzaFs = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 18);
                        zzacu = this.zzcka == null ? 0 : this.zzcka.length;
                        Object obj = new zzb[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzcka, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzb();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzb();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzcka = obj;
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

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzaf(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (!(this.zzaFs == null || this.zzaFs.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(1, this.zzaFs);
            }
            if (this.zzcka == null || this.zzcka.length <= 0) {
                return zzv;
            }
            int i = zzv;
            for (zzbut com_google_android_gms_internal_zzbut : this.zzcka) {
                if (com_google_android_gms_internal_zzbut != null) {
                    i += zzbum.zzc(2, com_google_android_gms_internal_zzbut);
                }
            }
            return i;
        }
    }

    public static final class zze extends zzbun<zze> {
        public zza zzckb;
        public zza zzckc;
        public zza zzckd;
        public zzc zzcke;
        public zzf[] zzckf;

        public zze() {
            zzaaG();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzbqu_zze = (zze) obj;
            if (this.zzckb == null) {
                if (com_google_android_gms_internal_zzbqu_zze.zzckb != null) {
                    return false;
                }
            } else if (!this.zzckb.equals(com_google_android_gms_internal_zzbqu_zze.zzckb)) {
                return false;
            }
            if (this.zzckc == null) {
                if (com_google_android_gms_internal_zzbqu_zze.zzckc != null) {
                    return false;
                }
            } else if (!this.zzckc.equals(com_google_android_gms_internal_zzbqu_zze.zzckc)) {
                return false;
            }
            if (this.zzckd == null) {
                if (com_google_android_gms_internal_zzbqu_zze.zzckd != null) {
                    return false;
                }
            } else if (!this.zzckd.equals(com_google_android_gms_internal_zzbqu_zze.zzckd)) {
                return false;
            }
            if (this.zzcke == null) {
                if (com_google_android_gms_internal_zzbqu_zze.zzcke != null) {
                    return false;
                }
            } else if (!this.zzcke.equals(com_google_android_gms_internal_zzbqu_zze.zzcke)) {
                return false;
            }
            return zzbur.equals(this.zzckf, com_google_android_gms_internal_zzbqu_zze.zzckf) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbqu_zze.zzcrX == null || com_google_android_gms_internal_zzbqu_zze.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbqu_zze.zzcrX) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzcke == null ? 0 : this.zzcke.hashCode()) + (((this.zzckd == null ? 0 : this.zzckd.hashCode()) + (((this.zzckc == null ? 0 : this.zzckc.hashCode()) + (((this.zzckb == null ? 0 : this.zzckb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + zzbur.hashCode(this.zzckf)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzckb != null) {
                com_google_android_gms_internal_zzbum.zza(1, this.zzckb);
            }
            if (this.zzckc != null) {
                com_google_android_gms_internal_zzbum.zza(2, this.zzckc);
            }
            if (this.zzckd != null) {
                com_google_android_gms_internal_zzbum.zza(3, this.zzckd);
            }
            if (this.zzcke != null) {
                com_google_android_gms_internal_zzbum.zza(4, this.zzcke);
            }
            if (this.zzckf != null && this.zzckf.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzckf) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(5, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zze zzaaG() {
            this.zzckb = null;
            this.zzckc = null;
            this.zzckd = null;
            this.zzcke = null;
            this.zzckf = zzf.zzaaH();
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zze zzag(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        if (this.zzckb == null) {
                            this.zzckb = new zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzckb);
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzckc == null) {
                            this.zzckc = new zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzckc);
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        if (this.zzckd == null) {
                            this.zzckd = new zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzckd);
                        continue;
                    case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        if (this.zzcke == null) {
                            this.zzcke = new zzc();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzcke);
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 42);
                        zzacu = this.zzckf == null ? 0 : this.zzckf.length;
                        Object obj = new zzf[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzckf, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzf();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzf();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzckf = obj;
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

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzag(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzckb != null) {
                zzv += zzbum.zzc(1, this.zzckb);
            }
            if (this.zzckc != null) {
                zzv += zzbum.zzc(2, this.zzckc);
            }
            if (this.zzckd != null) {
                zzv += zzbum.zzc(3, this.zzckd);
            }
            if (this.zzcke != null) {
                zzv += zzbum.zzc(4, this.zzcke);
            }
            if (this.zzckf == null || this.zzckf.length <= 0) {
                return zzv;
            }
            int i = zzv;
            for (zzbut com_google_android_gms_internal_zzbut : this.zzckf) {
                if (com_google_android_gms_internal_zzbut != null) {
                    i += zzbum.zzc(5, com_google_android_gms_internal_zzbut);
                }
            }
            return i;
        }
    }

    public static final class zzf extends zzbun<zzf> {
        private static volatile zzf[] zzckg;
        public int resourceId;
        public String zzaFs;
        public long zzckh;

        public zzf() {
            zzaaI();
        }

        public static zzf[] zzaaH() {
            if (zzckg == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzckg == null) {
                        zzckg = new zzf[0];
                    }
                }
            }
            return zzckg;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzbqu_zzf = (zzf) obj;
            if (this.resourceId != com_google_android_gms_internal_zzbqu_zzf.resourceId || this.zzckh != com_google_android_gms_internal_zzbqu_zzf.zzckh) {
                return false;
            }
            if (this.zzaFs == null) {
                if (com_google_android_gms_internal_zzbqu_zzf.zzaFs != null) {
                    return false;
                }
            } else if (!this.zzaFs.equals(com_google_android_gms_internal_zzbqu_zzf.zzaFs)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbqu_zzf.zzcrX == null || com_google_android_gms_internal_zzbqu_zzf.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbqu_zzf.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaFs == null ? 0 : this.zzaFs.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.resourceId) * 31) + ((int) (this.zzckh ^ (this.zzckh >>> 32)))) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.resourceId != 0) {
                com_google_android_gms_internal_zzbum.zzF(1, this.resourceId);
            }
            if (this.zzckh != 0) {
                com_google_android_gms_internal_zzbum.zzc(2, this.zzckh);
            }
            if (!(this.zzaFs == null || this.zzaFs.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(3, this.zzaFs);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zzf zzaaI() {
            this.resourceId = 0;
            this.zzckh = 0;
            this.zzaFs = BuildConfig.FLAVOR;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zzf zzah(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.resourceId = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case ConnectionResult.SIGN_IN_FAILED /*17*/:
                        this.zzckh = com_google_android_gms_internal_zzbul.zzacz();
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        this.zzaFs = com_google_android_gms_internal_zzbul.readString();
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

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzah(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.resourceId != 0) {
                zzv += zzbum.zzH(1, this.resourceId);
            }
            if (this.zzckh != 0) {
                zzv += zzbum.zzg(2, this.zzckh);
            }
            return (this.zzaFs == null || this.zzaFs.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(3, this.zzaFs);
        }
    }
}
