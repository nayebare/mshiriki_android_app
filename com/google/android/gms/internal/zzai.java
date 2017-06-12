package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v7.mediarouter.C0308R;
import com.github.mikephil.charting.BuildConfig;
import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public interface zzai {

    public static final class zza extends zzbun<zza> {
        public int level;
        public int zzkq;
        public int zzkr;

        public zza() {
            zzz();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzai_zza = (zza) obj;
            return (this.level == com_google_android_gms_internal_zzai_zza.level && this.zzkq == com_google_android_gms_internal_zzai_zza.zzkq && this.zzkr == com_google_android_gms_internal_zzai_zza.zzkr) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zza.zzcrX == null || com_google_android_gms_internal_zzai_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zza.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzkq) * 31) + this.zzkr) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.level != 1) {
                com_google_android_gms_internal_zzbum.zzF(1, this.level);
            }
            if (this.zzkq != 0) {
                com_google_android_gms_internal_zzbum.zzF(2, this.zzkq);
            }
            if (this.zzkr != 0) {
                com_google_android_gms_internal_zzbum.zzF(3, this.zzkr);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzn(com_google_android_gms_internal_zzbul);
        }

        public zza zzn(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        zzacu = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacu) {
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                this.level = zzacu;
                                break;
                            default:
                                continue;
                        }
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.zzkq = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                        this.zzkr = com_google_android_gms_internal_zzbul.zzacy();
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

        protected int zzv() {
            int zzv = super.zzv();
            if (this.level != 1) {
                zzv += zzbum.zzH(1, this.level);
            }
            if (this.zzkq != 0) {
                zzv += zzbum.zzH(2, this.zzkq);
            }
            return this.zzkr != 0 ? zzv + zzbum.zzH(3, this.zzkr) : zzv;
        }

        public zza zzz() {
            this.level = 1;
            this.zzkq = 0;
            this.zzkr = 0;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }
    }

    public static final class zzb extends zzbun<zzb> {
        private static volatile zzb[] zzks;
        public int name;
        public int[] zzkt;
        public int zzku;
        public boolean zzkv;
        public boolean zzkw;

        public zzb() {
            zzB();
        }

        public static zzb[] zzA() {
            if (zzks == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzks == null) {
                        zzks = new zzb[0];
                    }
                }
            }
            return zzks;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzai_zzb = (zzb) obj;
            return (zzbur.equals(this.zzkt, com_google_android_gms_internal_zzai_zzb.zzkt) && this.zzku == com_google_android_gms_internal_zzai_zzb.zzku && this.name == com_google_android_gms_internal_zzai_zzb.name && this.zzkv == com_google_android_gms_internal_zzai_zzb.zzkv && this.zzkw == com_google_android_gms_internal_zzai_zzb.zzkw) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzb.zzcrX == null || com_google_android_gms_internal_zzai_zzb.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzb.zzcrX) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzkv ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzkt)) * 31) + this.zzku) * 31) + this.name) * 31)) * 31;
            if (!this.zzkw) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode + i;
        }

        public zzb zzB() {
            this.zzkt = zzbuw.zzcsi;
            this.zzku = 0;
            this.name = 0;
            this.zzkv = false;
            this.zzkw = false;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzkw) {
                com_google_android_gms_internal_zzbum.zzg(1, this.zzkw);
            }
            com_google_android_gms_internal_zzbum.zzF(2, this.zzku);
            if (this.zzkt != null && this.zzkt.length > 0) {
                for (int zzF : this.zzkt) {
                    com_google_android_gms_internal_zzbum.zzF(3, zzF);
                }
            }
            if (this.name != 0) {
                com_google_android_gms_internal_zzbum.zzF(4, this.name);
            }
            if (this.zzkv) {
                com_google_android_gms_internal_zzbum.zzg(6, this.zzkv);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzo(com_google_android_gms_internal_zzbul);
        }

        public zzb zzo(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                int zzc;
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.zzkw = com_google_android_gms_internal_zzbul.zzacA();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.zzku = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 24);
                        zzacu = this.zzkt == null ? 0 : this.zzkt.length;
                        Object obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkt, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzkt = obj;
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        int zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzkt == null ? 0 : this.zzkt.length;
                        Object obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzkt, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzkt = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case HTTP.SP /*32*/:
                        this.name = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case C0308R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.zzkv = com_google_android_gms_internal_zzbul.zzacA();
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

        protected int zzv() {
            int i = 0;
            int zzv = super.zzv();
            if (this.zzkw) {
                zzv += zzbum.zzh(1, this.zzkw);
            }
            int zzH = zzbum.zzH(2, this.zzku) + zzv;
            if (this.zzkt == null || this.zzkt.length <= 0) {
                zzv = zzH;
            } else {
                for (int zzqp : this.zzkt) {
                    i += zzbum.zzqp(zzqp);
                }
                zzv = (zzH + i) + (this.zzkt.length * 1);
            }
            if (this.name != 0) {
                zzv += zzbum.zzH(4, this.name);
            }
            return this.zzkv ? zzv + zzbum.zzh(6, this.zzkv) : zzv;
        }
    }

    public static final class zzc extends zzbun<zzc> {
        private static volatile zzc[] zzkx;
        public String zzaA;
        public boolean zzkA;
        public long zzkB;
        public long zzky;
        public long zzkz;

        public zzc() {
            zzD();
        }

        public static zzc[] zzC() {
            if (zzkx == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzkx == null) {
                        zzkx = new zzc[0];
                    }
                }
            }
            return zzkx;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzai_zzc = (zzc) obj;
            if (this.zzaA == null) {
                if (com_google_android_gms_internal_zzai_zzc.zzaA != null) {
                    return false;
                }
            } else if (!this.zzaA.equals(com_google_android_gms_internal_zzai_zzc.zzaA)) {
                return false;
            }
            return (this.zzky == com_google_android_gms_internal_zzai_zzc.zzky && this.zzkz == com_google_android_gms_internal_zzai_zzc.zzkz && this.zzkA == com_google_android_gms_internal_zzai_zzc.zzkA && this.zzkB == com_google_android_gms_internal_zzai_zzc.zzkB) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzc.zzcrX == null || com_google_android_gms_internal_zzai_zzc.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzc.zzcrX) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzkA ? 1231 : 1237) + (((((((this.zzaA == null ? 0 : this.zzaA.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzky ^ (this.zzky >>> 32)))) * 31) + ((int) (this.zzkz ^ (this.zzkz >>> 32)))) * 31)) * 31) + ((int) (this.zzkB ^ (this.zzkB >>> 32)))) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zzc zzD() {
            this.zzaA = BuildConfig.FLAVOR;
            this.zzky = 0;
            this.zzkz = 2147483647L;
            this.zzkA = false;
            this.zzkB = 0;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (!(this.zzaA == null || this.zzaA.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(1, this.zzaA);
            }
            if (this.zzky != 0) {
                com_google_android_gms_internal_zzbum.zzb(2, this.zzky);
            }
            if (this.zzkz != 2147483647L) {
                com_google_android_gms_internal_zzbum.zzb(3, this.zzkz);
            }
            if (this.zzkA) {
                com_google_android_gms_internal_zzbum.zzg(4, this.zzkA);
            }
            if (this.zzkB != 0) {
                com_google_android_gms_internal_zzbum.zzb(5, this.zzkB);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzp(com_google_android_gms_internal_zzbul);
        }

        public zzc zzp(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        this.zzaA = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.zzky = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                        this.zzkz = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case HTTP.SP /*32*/:
                        this.zzkA = com_google_android_gms_internal_zzbul.zzacA();
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.zzkB = com_google_android_gms_internal_zzbul.zzacx();
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

        protected int zzv() {
            int zzv = super.zzv();
            if (!(this.zzaA == null || this.zzaA.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(1, this.zzaA);
            }
            if (this.zzky != 0) {
                zzv += zzbum.zzf(2, this.zzky);
            }
            if (this.zzkz != 2147483647L) {
                zzv += zzbum.zzf(3, this.zzkz);
            }
            if (this.zzkA) {
                zzv += zzbum.zzh(4, this.zzkA);
            }
            return this.zzkB != 0 ? zzv + zzbum.zzf(5, this.zzkB) : zzv;
        }
    }

    public static final class zzd extends zzbun<zzd> {
        public com.google.android.gms.internal.zzaj.zza[] zzkC;
        public com.google.android.gms.internal.zzaj.zza[] zzkD;
        public zzc[] zzkE;

        public zzd() {
            zzE();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzai_zzd = (zzd) obj;
            return (zzbur.equals(this.zzkC, com_google_android_gms_internal_zzai_zzd.zzkC) && zzbur.equals(this.zzkD, com_google_android_gms_internal_zzai_zzd.zzkD) && zzbur.equals(this.zzkE, com_google_android_gms_internal_zzai_zzd.zzkE)) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzd.zzcrX == null || com_google_android_gms_internal_zzai_zzd.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzd.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzkC)) * 31) + zzbur.hashCode(this.zzkD)) * 31) + zzbur.hashCode(this.zzkE)) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public zzd zzE() {
            this.zzkC = com.google.android.gms.internal.zzaj.zza.zzO();
            this.zzkD = com.google.android.gms.internal.zzaj.zza.zzO();
            this.zzkE = zzc.zzC();
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            int i = 0;
            if (this.zzkC != null && this.zzkC.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzkC) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(1, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            if (this.zzkD != null && this.zzkD.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut2 : this.zzkD) {
                    if (com_google_android_gms_internal_zzbut2 != null) {
                        com_google_android_gms_internal_zzbum.zza(2, com_google_android_gms_internal_zzbut2);
                    }
                }
            }
            if (this.zzkE != null && this.zzkE.length > 0) {
                while (i < this.zzkE.length) {
                    zzbut com_google_android_gms_internal_zzbut3 = this.zzkE[i];
                    if (com_google_android_gms_internal_zzbut3 != null) {
                        com_google_android_gms_internal_zzbum.zza(3, com_google_android_gms_internal_zzbut3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzq(com_google_android_gms_internal_zzbul);
        }

        public zzd zzq(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                int zzc;
                Object obj;
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                        zzacu = this.zzkC == null ? 0 : this.zzkC.length;
                        obj = new com.google.android.gms.internal.zzaj.zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkC, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new com.google.android.gms.internal.zzaj.zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new com.google.android.gms.internal.zzaj.zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkC = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 18);
                        zzacu = this.zzkD == null ? 0 : this.zzkD.length;
                        obj = new com.google.android.gms.internal.zzaj.zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkD, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new com.google.android.gms.internal.zzaj.zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new com.google.android.gms.internal.zzaj.zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkD = obj;
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 26);
                        zzacu = this.zzkE == null ? 0 : this.zzkE.length;
                        obj = new zzc[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkE, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzc();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzc();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkE = obj;
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

        protected int zzv() {
            int i;
            int i2 = 0;
            int zzv = super.zzv();
            if (this.zzkC != null && this.zzkC.length > 0) {
                i = zzv;
                for (zzbut com_google_android_gms_internal_zzbut : this.zzkC) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        i += zzbum.zzc(1, com_google_android_gms_internal_zzbut);
                    }
                }
                zzv = i;
            }
            if (this.zzkD != null && this.zzkD.length > 0) {
                i = zzv;
                for (zzbut com_google_android_gms_internal_zzbut2 : this.zzkD) {
                    if (com_google_android_gms_internal_zzbut2 != null) {
                        i += zzbum.zzc(2, com_google_android_gms_internal_zzbut2);
                    }
                }
                zzv = i;
            }
            if (this.zzkE != null && this.zzkE.length > 0) {
                while (i2 < this.zzkE.length) {
                    zzbut com_google_android_gms_internal_zzbut3 = this.zzkE[i2];
                    if (com_google_android_gms_internal_zzbut3 != null) {
                        zzv += zzbum.zzc(3, com_google_android_gms_internal_zzbut3);
                    }
                    i2++;
                }
            }
            return zzv;
        }
    }

    public static final class zze extends zzbun<zze> {
        private static volatile zze[] zzkF;
        public int key;
        public int value;

        public zze() {
            zzG();
        }

        public static zze[] zzF() {
            if (zzkF == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzkF == null) {
                        zzkF = new zze[0];
                    }
                }
            }
            return zzkF;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzai_zze = (zze) obj;
            return (this.key == com_google_android_gms_internal_zzai_zze.key && this.value == com_google_android_gms_internal_zzai_zze.value) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zze.zzcrX == null || com_google_android_gms_internal_zzai_zze.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zze.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public zze zzG() {
            this.key = 0;
            this.value = 0;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            com_google_android_gms_internal_zzbum.zzF(1, this.key);
            com_google_android_gms_internal_zzbum.zzF(2, this.value);
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzr(com_google_android_gms_internal_zzbul);
        }

        public zze zzr(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.key = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.value = com_google_android_gms_internal_zzbul.zzacy();
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

        protected int zzv() {
            return (super.zzv() + zzbum.zzH(1, this.key)) + zzbum.zzH(2, this.value);
        }
    }

    public static final class zzf extends zzbun<zzf> {
        public String version;
        public String[] zzkG;
        public String[] zzkH;
        public com.google.android.gms.internal.zzaj.zza[] zzkI;
        public zze[] zzkJ;
        public zzb[] zzkK;
        public zzb[] zzkL;
        public zzb[] zzkM;
        public zzg[] zzkN;
        public String zzkO;
        public String zzkP;
        public String zzkQ;
        public zza zzkR;
        public float zzkS;
        public boolean zzkT;
        public String[] zzkU;
        public int zzkV;

        public zzf() {
            zzH();
        }

        public static zzf zzf(byte[] bArr) throws zzbus {
            return (zzf) zzbut.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzai_zzf = (zzf) obj;
            if (!zzbur.equals(this.zzkG, com_google_android_gms_internal_zzai_zzf.zzkG) || !zzbur.equals(this.zzkH, com_google_android_gms_internal_zzai_zzf.zzkH) || !zzbur.equals(this.zzkI, com_google_android_gms_internal_zzai_zzf.zzkI) || !zzbur.equals(this.zzkJ, com_google_android_gms_internal_zzai_zzf.zzkJ) || !zzbur.equals(this.zzkK, com_google_android_gms_internal_zzai_zzf.zzkK) || !zzbur.equals(this.zzkL, com_google_android_gms_internal_zzai_zzf.zzkL) || !zzbur.equals(this.zzkM, com_google_android_gms_internal_zzai_zzf.zzkM) || !zzbur.equals(this.zzkN, com_google_android_gms_internal_zzai_zzf.zzkN)) {
                return false;
            }
            if (this.zzkO == null) {
                if (com_google_android_gms_internal_zzai_zzf.zzkO != null) {
                    return false;
                }
            } else if (!this.zzkO.equals(com_google_android_gms_internal_zzai_zzf.zzkO)) {
                return false;
            }
            if (this.zzkP == null) {
                if (com_google_android_gms_internal_zzai_zzf.zzkP != null) {
                    return false;
                }
            } else if (!this.zzkP.equals(com_google_android_gms_internal_zzai_zzf.zzkP)) {
                return false;
            }
            if (this.zzkQ == null) {
                if (com_google_android_gms_internal_zzai_zzf.zzkQ != null) {
                    return false;
                }
            } else if (!this.zzkQ.equals(com_google_android_gms_internal_zzai_zzf.zzkQ)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzai_zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzai_zzf.version)) {
                return false;
            }
            if (this.zzkR == null) {
                if (com_google_android_gms_internal_zzai_zzf.zzkR != null) {
                    return false;
                }
            } else if (!this.zzkR.equals(com_google_android_gms_internal_zzai_zzf.zzkR)) {
                return false;
            }
            return (Float.floatToIntBits(this.zzkS) == Float.floatToIntBits(com_google_android_gms_internal_zzai_zzf.zzkS) && this.zzkT == com_google_android_gms_internal_zzai_zzf.zzkT && zzbur.equals(this.zzkU, com_google_android_gms_internal_zzai_zzf.zzkU) && this.zzkV == com_google_android_gms_internal_zzai_zzf.zzkV) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzf.zzcrX == null || com_google_android_gms_internal_zzai_zzf.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzf.zzcrX) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zzkT ? 1231 : 1237) + (((((this.zzkR == null ? 0 : this.zzkR.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzkQ == null ? 0 : this.zzkQ.hashCode()) + (((this.zzkP == null ? 0 : this.zzkP.hashCode()) + (((this.zzkO == null ? 0 : this.zzkO.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzkG)) * 31) + zzbur.hashCode(this.zzkH)) * 31) + zzbur.hashCode(this.zzkI)) * 31) + zzbur.hashCode(this.zzkJ)) * 31) + zzbur.hashCode(this.zzkK)) * 31) + zzbur.hashCode(this.zzkL)) * 31) + zzbur.hashCode(this.zzkM)) * 31) + zzbur.hashCode(this.zzkN)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzkS)) * 31)) * 31) + zzbur.hashCode(this.zzkU)) * 31) + this.zzkV) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zzf zzH() {
            this.zzkG = zzbuw.zzcsn;
            this.zzkH = zzbuw.zzcsn;
            this.zzkI = com.google.android.gms.internal.zzaj.zza.zzO();
            this.zzkJ = zze.zzF();
            this.zzkK = zzb.zzA();
            this.zzkL = zzb.zzA();
            this.zzkM = zzb.zzA();
            this.zzkN = zzg.zzI();
            this.zzkO = BuildConfig.FLAVOR;
            this.zzkP = BuildConfig.FLAVOR;
            this.zzkQ = "0";
            this.version = BuildConfig.FLAVOR;
            this.zzkR = null;
            this.zzkS = 0.0f;
            this.zzkT = false;
            this.zzkU = zzbuw.zzcsn;
            this.zzkV = 0;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            int i = 0;
            if (this.zzkH != null && this.zzkH.length > 0) {
                for (String str : this.zzkH) {
                    if (str != null) {
                        com_google_android_gms_internal_zzbum.zzq(1, str);
                    }
                }
            }
            if (this.zzkI != null && this.zzkI.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzkI) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(2, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            if (this.zzkJ != null && this.zzkJ.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut2 : this.zzkJ) {
                    if (com_google_android_gms_internal_zzbut2 != null) {
                        com_google_android_gms_internal_zzbum.zza(3, com_google_android_gms_internal_zzbut2);
                    }
                }
            }
            if (this.zzkK != null && this.zzkK.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut22 : this.zzkK) {
                    if (com_google_android_gms_internal_zzbut22 != null) {
                        com_google_android_gms_internal_zzbum.zza(4, com_google_android_gms_internal_zzbut22);
                    }
                }
            }
            if (this.zzkL != null && this.zzkL.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut222 : this.zzkL) {
                    if (com_google_android_gms_internal_zzbut222 != null) {
                        com_google_android_gms_internal_zzbum.zza(5, com_google_android_gms_internal_zzbut222);
                    }
                }
            }
            if (this.zzkM != null && this.zzkM.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut2222 : this.zzkM) {
                    if (com_google_android_gms_internal_zzbut2222 != null) {
                        com_google_android_gms_internal_zzbum.zza(6, com_google_android_gms_internal_zzbut2222);
                    }
                }
            }
            if (this.zzkN != null && this.zzkN.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut22222 : this.zzkN) {
                    if (com_google_android_gms_internal_zzbut22222 != null) {
                        com_google_android_gms_internal_zzbum.zza(7, com_google_android_gms_internal_zzbut22222);
                    }
                }
            }
            if (!(this.zzkO == null || this.zzkO.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(9, this.zzkO);
            }
            if (!(this.zzkP == null || this.zzkP.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(10, this.zzkP);
            }
            if (!(this.zzkQ == null || this.zzkQ.equals("0"))) {
                com_google_android_gms_internal_zzbum.zzq(12, this.zzkQ);
            }
            if (!(this.version == null || this.version.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(13, this.version);
            }
            if (this.zzkR != null) {
                com_google_android_gms_internal_zzbum.zza(14, this.zzkR);
            }
            if (Float.floatToIntBits(this.zzkS) != Float.floatToIntBits(0.0f)) {
                com_google_android_gms_internal_zzbum.zzc(15, this.zzkS);
            }
            if (this.zzkU != null && this.zzkU.length > 0) {
                for (String str2 : this.zzkU) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zzbum.zzq(16, str2);
                    }
                }
            }
            if (this.zzkV != 0) {
                com_google_android_gms_internal_zzbum.zzF(17, this.zzkV);
            }
            if (this.zzkT) {
                com_google_android_gms_internal_zzbum.zzg(18, this.zzkT);
            }
            if (this.zzkG != null && this.zzkG.length > 0) {
                while (i < this.zzkG.length) {
                    String str3 = this.zzkG[i];
                    if (str3 != null) {
                        com_google_android_gms_internal_zzbum.zzq(19, str3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzs(com_google_android_gms_internal_zzbul);
        }

        public zzf zzs(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                int zzc;
                Object obj;
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                        zzacu = this.zzkH == null ? 0 : this.zzkH.length;
                        obj = new String[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkH, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                        this.zzkH = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 18);
                        zzacu = this.zzkI == null ? 0 : this.zzkI.length;
                        obj = new com.google.android.gms.internal.zzaj.zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkI, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new com.google.android.gms.internal.zzaj.zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new com.google.android.gms.internal.zzaj.zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkI = obj;
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 26);
                        zzacu = this.zzkJ == null ? 0 : this.zzkJ.length;
                        obj = new zze[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkJ, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zze();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zze();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkJ = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 34);
                        zzacu = this.zzkK == null ? 0 : this.zzkK.length;
                        obj = new zzb[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkK, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzb();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzb();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkK = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 42);
                        zzacu = this.zzkL == null ? 0 : this.zzkL.length;
                        obj = new zzb[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkL, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzb();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzb();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkL = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 50);
                        zzacu = this.zzkM == null ? 0 : this.zzkM.length;
                        obj = new zzb[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkM, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzb();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzb();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkM = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 58);
                        zzacu = this.zzkN == null ? 0 : this.zzkN.length;
                        obj = new zzg[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkN, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzg();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzg();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzkN = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                        this.zzkO = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        this.zzkP = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                        this.zzkQ = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_editTextStyle /*106*/:
                        this.version = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                        if (this.zzkR == null) {
                            this.zzkR = new zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzkR);
                        continue;
                    case 125:
                        this.zzkS = com_google_android_gms_internal_zzbul.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, TransportMediator.KEYCODE_MEDIA_RECORD);
                        zzacu = this.zzkU == null ? 0 : this.zzkU.length;
                        obj = new String[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkU, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                        this.zzkU = obj;
                        continue;
                    case 136:
                        this.zzkV = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case 144:
                        this.zzkT = com_google_android_gms_internal_zzbul.zzacA();
                        continue;
                    case 154:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 154);
                        zzacu = this.zzkG == null ? 0 : this.zzkG.length;
                        obj = new String[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkG, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                        this.zzkG = obj;
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

        protected int zzv() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzv = super.zzv();
            if (this.zzkH == null || this.zzkH.length <= 0) {
                i = zzv;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzkH) {
                    if (str != null) {
                        i3++;
                        i2 += zzbum.zzkc(str);
                    }
                }
                i = (zzv + i2) + (i3 * 1);
            }
            if (this.zzkI != null && this.zzkI.length > 0) {
                i2 = i;
                for (zzbut com_google_android_gms_internal_zzbut : this.zzkI) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        i2 += zzbum.zzc(2, com_google_android_gms_internal_zzbut);
                    }
                }
                i = i2;
            }
            if (this.zzkJ != null && this.zzkJ.length > 0) {
                i2 = i;
                for (zzbut com_google_android_gms_internal_zzbut2 : this.zzkJ) {
                    if (com_google_android_gms_internal_zzbut2 != null) {
                        i2 += zzbum.zzc(3, com_google_android_gms_internal_zzbut2);
                    }
                }
                i = i2;
            }
            if (this.zzkK != null && this.zzkK.length > 0) {
                i2 = i;
                for (zzbut com_google_android_gms_internal_zzbut22 : this.zzkK) {
                    if (com_google_android_gms_internal_zzbut22 != null) {
                        i2 += zzbum.zzc(4, com_google_android_gms_internal_zzbut22);
                    }
                }
                i = i2;
            }
            if (this.zzkL != null && this.zzkL.length > 0) {
                i2 = i;
                for (zzbut com_google_android_gms_internal_zzbut222 : this.zzkL) {
                    if (com_google_android_gms_internal_zzbut222 != null) {
                        i2 += zzbum.zzc(5, com_google_android_gms_internal_zzbut222);
                    }
                }
                i = i2;
            }
            if (this.zzkM != null && this.zzkM.length > 0) {
                i2 = i;
                for (zzbut com_google_android_gms_internal_zzbut2222 : this.zzkM) {
                    if (com_google_android_gms_internal_zzbut2222 != null) {
                        i2 += zzbum.zzc(6, com_google_android_gms_internal_zzbut2222);
                    }
                }
                i = i2;
            }
            if (this.zzkN != null && this.zzkN.length > 0) {
                i2 = i;
                for (zzbut com_google_android_gms_internal_zzbut22222 : this.zzkN) {
                    if (com_google_android_gms_internal_zzbut22222 != null) {
                        i2 += zzbum.zzc(7, com_google_android_gms_internal_zzbut22222);
                    }
                }
                i = i2;
            }
            if (!(this.zzkO == null || this.zzkO.equals(BuildConfig.FLAVOR))) {
                i += zzbum.zzr(9, this.zzkO);
            }
            if (!(this.zzkP == null || this.zzkP.equals(BuildConfig.FLAVOR))) {
                i += zzbum.zzr(10, this.zzkP);
            }
            if (!(this.zzkQ == null || this.zzkQ.equals("0"))) {
                i += zzbum.zzr(12, this.zzkQ);
            }
            if (!(this.version == null || this.version.equals(BuildConfig.FLAVOR))) {
                i += zzbum.zzr(13, this.version);
            }
            if (this.zzkR != null) {
                i += zzbum.zzc(14, this.zzkR);
            }
            if (Float.floatToIntBits(this.zzkS) != Float.floatToIntBits(0.0f)) {
                i += zzbum.zzd(15, this.zzkS);
            }
            if (this.zzkU != null && this.zzkU.length > 0) {
                i3 = 0;
                zzv = 0;
                for (String str2 : this.zzkU) {
                    if (str2 != null) {
                        zzv++;
                        i3 += zzbum.zzkc(str2);
                    }
                }
                i = (i + i3) + (zzv * 2);
            }
            if (this.zzkV != 0) {
                i += zzbum.zzH(17, this.zzkV);
            }
            if (this.zzkT) {
                i += zzbum.zzh(18, this.zzkT);
            }
            if (this.zzkG == null || this.zzkG.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zzkG.length) {
                String str3 = this.zzkG[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zzbum.zzkc(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }
    }

    public static final class zzg extends zzbun<zzg> {
        private static volatile zzg[] zzkW;
        public int[] zzkX;
        public int[] zzkY;
        public int[] zzkZ;
        public int[] zzla;
        public int[] zzlb;
        public int[] zzlc;
        public int[] zzld;
        public int[] zzle;
        public int[] zzlf;
        public int[] zzlg;

        public zzg() {
            zzJ();
        }

        public static zzg[] zzI() {
            if (zzkW == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzkW == null) {
                        zzkW = new zzg[0];
                    }
                }
            }
            return zzkW;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzai_zzg = (zzg) obj;
            return (zzbur.equals(this.zzkX, com_google_android_gms_internal_zzai_zzg.zzkX) && zzbur.equals(this.zzkY, com_google_android_gms_internal_zzai_zzg.zzkY) && zzbur.equals(this.zzkZ, com_google_android_gms_internal_zzai_zzg.zzkZ) && zzbur.equals(this.zzla, com_google_android_gms_internal_zzai_zzg.zzla) && zzbur.equals(this.zzlb, com_google_android_gms_internal_zzai_zzg.zzlb) && zzbur.equals(this.zzlc, com_google_android_gms_internal_zzai_zzg.zzlc) && zzbur.equals(this.zzld, com_google_android_gms_internal_zzai_zzg.zzld) && zzbur.equals(this.zzle, com_google_android_gms_internal_zzai_zzg.zzle) && zzbur.equals(this.zzlf, com_google_android_gms_internal_zzai_zzg.zzlf) && zzbur.equals(this.zzlg, com_google_android_gms_internal_zzai_zzg.zzlg)) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzg.zzcrX == null || com_google_android_gms_internal_zzai_zzg.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzg.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzkX)) * 31) + zzbur.hashCode(this.zzkY)) * 31) + zzbur.hashCode(this.zzkZ)) * 31) + zzbur.hashCode(this.zzla)) * 31) + zzbur.hashCode(this.zzlb)) * 31) + zzbur.hashCode(this.zzlc)) * 31) + zzbur.hashCode(this.zzld)) * 31) + zzbur.hashCode(this.zzle)) * 31) + zzbur.hashCode(this.zzlf)) * 31) + zzbur.hashCode(this.zzlg)) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public zzg zzJ() {
            this.zzkX = zzbuw.zzcsi;
            this.zzkY = zzbuw.zzcsi;
            this.zzkZ = zzbuw.zzcsi;
            this.zzla = zzbuw.zzcsi;
            this.zzlb = zzbuw.zzcsi;
            this.zzlc = zzbuw.zzcsi;
            this.zzld = zzbuw.zzcsi;
            this.zzle = zzbuw.zzcsi;
            this.zzlf = zzbuw.zzcsi;
            this.zzlg = zzbuw.zzcsi;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            int i = 0;
            if (this.zzkX != null && this.zzkX.length > 0) {
                for (int zzF : this.zzkX) {
                    com_google_android_gms_internal_zzbum.zzF(1, zzF);
                }
            }
            if (this.zzkY != null && this.zzkY.length > 0) {
                for (int zzF2 : this.zzkY) {
                    com_google_android_gms_internal_zzbum.zzF(2, zzF2);
                }
            }
            if (this.zzkZ != null && this.zzkZ.length > 0) {
                for (int zzF22 : this.zzkZ) {
                    com_google_android_gms_internal_zzbum.zzF(3, zzF22);
                }
            }
            if (this.zzla != null && this.zzla.length > 0) {
                for (int zzF222 : this.zzla) {
                    com_google_android_gms_internal_zzbum.zzF(4, zzF222);
                }
            }
            if (this.zzlb != null && this.zzlb.length > 0) {
                for (int zzF2222 : this.zzlb) {
                    com_google_android_gms_internal_zzbum.zzF(5, zzF2222);
                }
            }
            if (this.zzlc != null && this.zzlc.length > 0) {
                for (int zzF22222 : this.zzlc) {
                    com_google_android_gms_internal_zzbum.zzF(6, zzF22222);
                }
            }
            if (this.zzld != null && this.zzld.length > 0) {
                for (int zzF222222 : this.zzld) {
                    com_google_android_gms_internal_zzbum.zzF(7, zzF222222);
                }
            }
            if (this.zzle != null && this.zzle.length > 0) {
                for (int zzF2222222 : this.zzle) {
                    com_google_android_gms_internal_zzbum.zzF(8, zzF2222222);
                }
            }
            if (this.zzlf != null && this.zzlf.length > 0) {
                for (int zzF22222222 : this.zzlf) {
                    com_google_android_gms_internal_zzbum.zzF(9, zzF22222222);
                }
            }
            if (this.zzlg != null && this.zzlg.length > 0) {
                while (i < this.zzlg.length) {
                    com_google_android_gms_internal_zzbum.zzF(10, this.zzlg[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzt(com_google_android_gms_internal_zzbul);
        }

        public zzg zzt(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                int zzc;
                Object obj;
                int zzqj;
                Object obj2;
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 8);
                        zzacu = this.zzkX == null ? 0 : this.zzkX.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkX, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzkX = obj;
                        continue;
                    case HTTP.LF /*10*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzkX == null ? 0 : this.zzkX.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzkX, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzkX = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 16);
                        zzacu = this.zzkY == null ? 0 : this.zzkY.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkY, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzkY = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzkY == null ? 0 : this.zzkY.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzkY, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzkY = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 24);
                        zzacu = this.zzkZ == null ? 0 : this.zzkZ.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzkZ, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzkZ = obj;
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzkZ == null ? 0 : this.zzkZ.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzkZ, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzkZ = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case HTTP.SP /*32*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 32);
                        zzacu = this.zzla == null ? 0 : this.zzla.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzla, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzla = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzla == null ? 0 : this.zzla.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzla, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzla = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 40);
                        zzacu = this.zzlb == null ? 0 : this.zzlb.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlb, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzlb = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzlb == null ? 0 : this.zzlb.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzlb, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzlb = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 48);
                        zzacu = this.zzlc == null ? 0 : this.zzlc.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlc, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzlc = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzlc == null ? 0 : this.zzlc.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzlc, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzlc = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 56);
                        zzacu = this.zzld == null ? 0 : this.zzld.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzld, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzld = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzld == null ? 0 : this.zzld.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzld, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzld = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.AppCompatTheme_editTextBackground /*64*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 64);
                        zzacu = this.zzle == null ? 0 : this.zzle.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzle, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzle = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzle == null ? 0 : this.zzle.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzle, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzle = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 72);
                        zzacu = this.zzlf == null ? 0 : this.zzlf.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlf, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzlf = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzlf == null ? 0 : this.zzlf.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzlf, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzlf = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 80);
                        zzacu = this.zzlg == null ? 0 : this.zzlg.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlg, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzlg = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzlg == null ? 0 : this.zzlg.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzlg, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzlg = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
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

        protected int zzv() {
            int i;
            int i2;
            int i3 = 0;
            int zzv = super.zzv();
            if (this.zzkX == null || this.zzkX.length <= 0) {
                i = zzv;
            } else {
                i2 = 0;
                for (int zzqp : this.zzkX) {
                    i2 += zzbum.zzqp(zzqp);
                }
                i = (zzv + i2) + (this.zzkX.length * 1);
            }
            if (this.zzkY != null && this.zzkY.length > 0) {
                zzv = 0;
                for (int zzqp2 : this.zzkY) {
                    zzv += zzbum.zzqp(zzqp2);
                }
                i = (i + zzv) + (this.zzkY.length * 1);
            }
            if (this.zzkZ != null && this.zzkZ.length > 0) {
                zzv = 0;
                for (int zzqp22 : this.zzkZ) {
                    zzv += zzbum.zzqp(zzqp22);
                }
                i = (i + zzv) + (this.zzkZ.length * 1);
            }
            if (this.zzla != null && this.zzla.length > 0) {
                zzv = 0;
                for (int zzqp222 : this.zzla) {
                    zzv += zzbum.zzqp(zzqp222);
                }
                i = (i + zzv) + (this.zzla.length * 1);
            }
            if (this.zzlb != null && this.zzlb.length > 0) {
                zzv = 0;
                for (int zzqp2222 : this.zzlb) {
                    zzv += zzbum.zzqp(zzqp2222);
                }
                i = (i + zzv) + (this.zzlb.length * 1);
            }
            if (this.zzlc != null && this.zzlc.length > 0) {
                zzv = 0;
                for (int zzqp22222 : this.zzlc) {
                    zzv += zzbum.zzqp(zzqp22222);
                }
                i = (i + zzv) + (this.zzlc.length * 1);
            }
            if (this.zzld != null && this.zzld.length > 0) {
                zzv = 0;
                for (int zzqp222222 : this.zzld) {
                    zzv += zzbum.zzqp(zzqp222222);
                }
                i = (i + zzv) + (this.zzld.length * 1);
            }
            if (this.zzle != null && this.zzle.length > 0) {
                zzv = 0;
                for (int zzqp2222222 : this.zzle) {
                    zzv += zzbum.zzqp(zzqp2222222);
                }
                i = (i + zzv) + (this.zzle.length * 1);
            }
            if (this.zzlf != null && this.zzlf.length > 0) {
                zzv = 0;
                for (int zzqp22222222 : this.zzlf) {
                    zzv += zzbum.zzqp(zzqp22222222);
                }
                i = (i + zzv) + (this.zzlf.length * 1);
            }
            if (this.zzlg == null || this.zzlg.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zzlg.length) {
                i2 += zzbum.zzqp(this.zzlg[i3]);
                i3++;
            }
            return (i + i2) + (this.zzlg.length * 1);
        }
    }

    public static final class zzh extends zzbun<zzh> {
        public static final zzbuo<com.google.android.gms.internal.zzaj.zza, zzh> zzlh;
        private static final zzh[] zzli;
        public int[] zzlj;
        public int[] zzlk;
        public int[] zzll;
        public int zzlm;
        public int[] zzln;
        public int zzlo;
        public int zzlp;

        static {
            zzlh = zzbuo.zza(11, zzh.class, 810);
            zzli = new zzh[0];
        }

        public zzh() {
            zzK();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh com_google_android_gms_internal_zzai_zzh = (zzh) obj;
            return (zzbur.equals(this.zzlj, com_google_android_gms_internal_zzai_zzh.zzlj) && zzbur.equals(this.zzlk, com_google_android_gms_internal_zzai_zzh.zzlk) && zzbur.equals(this.zzll, com_google_android_gms_internal_zzai_zzh.zzll) && this.zzlm == com_google_android_gms_internal_zzai_zzh.zzlm && zzbur.equals(this.zzln, com_google_android_gms_internal_zzai_zzh.zzln) && this.zzlo == com_google_android_gms_internal_zzai_zzh.zzlo && this.zzlp == com_google_android_gms_internal_zzai_zzh.zzlp) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzh.zzcrX == null || com_google_android_gms_internal_zzai_zzh.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzh.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzlj)) * 31) + zzbur.hashCode(this.zzlk)) * 31) + zzbur.hashCode(this.zzll)) * 31) + this.zzlm) * 31) + zzbur.hashCode(this.zzln)) * 31) + this.zzlo) * 31) + this.zzlp) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public zzh zzK() {
            this.zzlj = zzbuw.zzcsi;
            this.zzlk = zzbuw.zzcsi;
            this.zzll = zzbuw.zzcsi;
            this.zzlm = 0;
            this.zzln = zzbuw.zzcsi;
            this.zzlo = 0;
            this.zzlp = 0;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            int i = 0;
            if (this.zzlj != null && this.zzlj.length > 0) {
                for (int zzF : this.zzlj) {
                    com_google_android_gms_internal_zzbum.zzF(1, zzF);
                }
            }
            if (this.zzlk != null && this.zzlk.length > 0) {
                for (int zzF2 : this.zzlk) {
                    com_google_android_gms_internal_zzbum.zzF(2, zzF2);
                }
            }
            if (this.zzll != null && this.zzll.length > 0) {
                for (int zzF22 : this.zzll) {
                    com_google_android_gms_internal_zzbum.zzF(3, zzF22);
                }
            }
            if (this.zzlm != 0) {
                com_google_android_gms_internal_zzbum.zzF(4, this.zzlm);
            }
            if (this.zzln != null && this.zzln.length > 0) {
                while (i < this.zzln.length) {
                    com_google_android_gms_internal_zzbum.zzF(5, this.zzln[i]);
                    i++;
                }
            }
            if (this.zzlo != 0) {
                com_google_android_gms_internal_zzbum.zzF(6, this.zzlo);
            }
            if (this.zzlp != 0) {
                com_google_android_gms_internal_zzbum.zzF(7, this.zzlp);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzu(com_google_android_gms_internal_zzbul);
        }

        public zzh zzu(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                int zzc;
                Object obj;
                int zzqj;
                Object obj2;
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 8);
                        zzacu = this.zzlj == null ? 0 : this.zzlj.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlj, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzlj = obj;
                        continue;
                    case HTTP.LF /*10*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzlj == null ? 0 : this.zzlj.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzlj, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzlj = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 16);
                        zzacu = this.zzlk == null ? 0 : this.zzlk.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlk, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzlk = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzlk == null ? 0 : this.zzlk.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzlk, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzlk = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 24);
                        zzacu = this.zzll == null ? 0 : this.zzll.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzll, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzll = obj;
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzll == null ? 0 : this.zzll.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzll, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzll = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case HTTP.SP /*32*/:
                        this.zzlm = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 40);
                        zzacu = this.zzln == null ? 0 : this.zzln.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzln, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzln = obj;
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzln == null ? 0 : this.zzln.length;
                        obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzln, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzln = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0308R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.zzlo = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case C0308R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        this.zzlp = com_google_android_gms_internal_zzbul.zzacy();
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

        protected int zzv() {
            int i;
            int i2;
            int i3 = 0;
            int zzv = super.zzv();
            if (this.zzlj == null || this.zzlj.length <= 0) {
                i = zzv;
            } else {
                i2 = 0;
                for (int zzqp : this.zzlj) {
                    i2 += zzbum.zzqp(zzqp);
                }
                i = (zzv + i2) + (this.zzlj.length * 1);
            }
            if (this.zzlk != null && this.zzlk.length > 0) {
                zzv = 0;
                for (int zzqp2 : this.zzlk) {
                    zzv += zzbum.zzqp(zzqp2);
                }
                i = (i + zzv) + (this.zzlk.length * 1);
            }
            if (this.zzll != null && this.zzll.length > 0) {
                zzv = 0;
                for (int zzqp22 : this.zzll) {
                    zzv += zzbum.zzqp(zzqp22);
                }
                i = (i + zzv) + (this.zzll.length * 1);
            }
            if (this.zzlm != 0) {
                i += zzbum.zzH(4, this.zzlm);
            }
            if (this.zzln != null && this.zzln.length > 0) {
                i2 = 0;
                while (i3 < this.zzln.length) {
                    i2 += zzbum.zzqp(this.zzln[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zzln.length * 1);
            }
            if (this.zzlo != 0) {
                i += zzbum.zzH(6, this.zzlo);
            }
            return this.zzlp != 0 ? i + zzbum.zzH(7, this.zzlp) : i;
        }
    }

    public static final class zzi extends zzbun<zzi> {
        private static volatile zzi[] zzlq;
        public String name;
        public com.google.android.gms.internal.zzaj.zza zzlr;
        public zzd zzls;

        public zzi() {
            zzM();
        }

        public static zzi[] zzL() {
            if (zzlq == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzlq == null) {
                        zzlq = new zzi[0];
                    }
                }
            }
            return zzlq;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi com_google_android_gms_internal_zzai_zzi = (zzi) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzai_zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzai_zzi.name)) {
                return false;
            }
            if (this.zzlr == null) {
                if (com_google_android_gms_internal_zzai_zzi.zzlr != null) {
                    return false;
                }
            } else if (!this.zzlr.equals(com_google_android_gms_internal_zzai_zzi.zzlr)) {
                return false;
            }
            if (this.zzls == null) {
                if (com_google_android_gms_internal_zzai_zzi.zzls != null) {
                    return false;
                }
            } else if (!this.zzls.equals(com_google_android_gms_internal_zzai_zzi.zzls)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzi.zzcrX == null || com_google_android_gms_internal_zzai_zzi.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzi.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzls == null ? 0 : this.zzls.hashCode()) + (((this.zzlr == null ? 0 : this.zzlr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zzi zzM() {
            this.name = BuildConfig.FLAVOR;
            this.zzlr = null;
            this.zzls = null;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (!(this.name == null || this.name.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(1, this.name);
            }
            if (this.zzlr != null) {
                com_google_android_gms_internal_zzbum.zza(2, this.zzlr);
            }
            if (this.zzls != null) {
                com_google_android_gms_internal_zzbum.zza(3, this.zzls);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzv(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (!(this.name == null || this.name.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(1, this.name);
            }
            if (this.zzlr != null) {
                zzv += zzbum.zzc(2, this.zzlr);
            }
            return this.zzls != null ? zzv + zzbum.zzc(3, this.zzls) : zzv;
        }

        public zzi zzv(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        this.name = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzlr == null) {
                            this.zzlr = new com.google.android.gms.internal.zzaj.zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzlr);
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        if (this.zzls == null) {
                            this.zzls = new zzd();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzls);
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

    public static final class zzj extends zzbun<zzj> {
        public zzi[] zzlt;
        public zzf zzlu;
        public String zzlv;

        public zzj() {
            zzN();
        }

        public static zzj zzg(byte[] bArr) throws zzbus {
            return (zzj) zzbut.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj com_google_android_gms_internal_zzai_zzj = (zzj) obj;
            if (!zzbur.equals(this.zzlt, com_google_android_gms_internal_zzai_zzj.zzlt)) {
                return false;
            }
            if (this.zzlu == null) {
                if (com_google_android_gms_internal_zzai_zzj.zzlu != null) {
                    return false;
                }
            } else if (!this.zzlu.equals(com_google_android_gms_internal_zzai_zzj.zzlu)) {
                return false;
            }
            if (this.zzlv == null) {
                if (com_google_android_gms_internal_zzai_zzj.zzlv != null) {
                    return false;
                }
            } else if (!this.zzlv.equals(com_google_android_gms_internal_zzai_zzj.zzlv)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzai_zzj.zzcrX == null || com_google_android_gms_internal_zzai_zzj.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzai_zzj.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzlv == null ? 0 : this.zzlv.hashCode()) + (((this.zzlu == null ? 0 : this.zzlu.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzlt)) * 31)) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zzj zzN() {
            this.zzlt = zzi.zzL();
            this.zzlu = null;
            this.zzlv = BuildConfig.FLAVOR;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzlt != null && this.zzlt.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzlt) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(1, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            if (this.zzlu != null) {
                com_google_android_gms_internal_zzbum.zza(2, this.zzlu);
            }
            if (!(this.zzlv == null || this.zzlv.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(3, this.zzlv);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzw(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzlt != null && this.zzlt.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzlt) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        zzv += zzbum.zzc(1, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            if (this.zzlu != null) {
                zzv += zzbum.zzc(2, this.zzlu);
            }
            return (this.zzlv == null || this.zzlv.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(3, this.zzlv);
        }

        public zzj zzw(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                        zzacu = this.zzlt == null ? 0 : this.zzlt.length;
                        Object obj = new zzi[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzlt, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzi();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzi();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzlt = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzlu == null) {
                            this.zzlu = new zzf();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzlu);
                        continue;
                    case C0308R.styleable.Toolbar_logoDescription /*26*/:
                        this.zzlv = com_google_android_gms_internal_zzbul.readString();
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
