package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public interface zzaqa {

    public static final class zza extends zzbun<zza> {
        public zza[] zzbgz;

        public static final class zza extends zzbun<zza> {
            private static volatile zza[] zzbgA;
            public int viewId;
            public String zzbgB;
            public String zzbgC;

            public zza() {
                zzGl();
            }

            public static zza[] zzGk() {
                if (zzbgA == null) {
                    synchronized (zzbur.zzcsf) {
                        if (zzbgA == null) {
                            zzbgA = new zza[0];
                        }
                    }
                }
                return zzbgA;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzaqa_zza_zza = (zza) obj;
                if (this.zzbgB == null) {
                    if (com_google_android_gms_internal_zzaqa_zza_zza.zzbgB != null) {
                        return false;
                    }
                } else if (!this.zzbgB.equals(com_google_android_gms_internal_zzaqa_zza_zza.zzbgB)) {
                    return false;
                }
                if (this.zzbgC == null) {
                    if (com_google_android_gms_internal_zzaqa_zza_zza.zzbgC != null) {
                        return false;
                    }
                } else if (!this.zzbgC.equals(com_google_android_gms_internal_zzaqa_zza_zza.zzbgC)) {
                    return false;
                }
                return this.viewId == com_google_android_gms_internal_zzaqa_zza_zza.viewId ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzaqa_zza_zza.zzcrX == null || com_google_android_gms_internal_zzaqa_zza_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzaqa_zza_zza.zzcrX) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.zzbgC == null ? 0 : this.zzbgC.hashCode()) + (((this.zzbgB == null ? 0 : this.zzbgB.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                    i = this.zzcrX.hashCode();
                }
                return hashCode + i;
            }

            public zza zzC(zzbul com_google_android_gms_internal_zzbul) throws IOException {
                while (true) {
                    int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                            break;
                        case HTTP.LF /*10*/:
                            this.zzbgB = com_google_android_gms_internal_zzbul.readString();
                            continue;
                        case ConnectionResult.SERVICE_UPDATING /*18*/:
                            this.zzbgC = com_google_android_gms_internal_zzbul.readString();
                            continue;
                        case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                            this.viewId = com_google_android_gms_internal_zzbul.zzacy();
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

            public zza zzGl() {
                this.zzbgB = BuildConfig.FLAVOR;
                this.zzbgC = BuildConfig.FLAVOR;
                this.viewId = 0;
                this.zzcrX = null;
                this.zzcsg = -1;
                return this;
            }

            public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
                if (!(this.zzbgB == null || this.zzbgB.equals(BuildConfig.FLAVOR))) {
                    com_google_android_gms_internal_zzbum.zzq(1, this.zzbgB);
                }
                if (!(this.zzbgC == null || this.zzbgC.equals(BuildConfig.FLAVOR))) {
                    com_google_android_gms_internal_zzbum.zzq(2, this.zzbgC);
                }
                if (this.viewId != 0) {
                    com_google_android_gms_internal_zzbum.zzF(3, this.viewId);
                }
                super.zza(com_google_android_gms_internal_zzbum);
            }

            public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
                return zzC(com_google_android_gms_internal_zzbul);
            }

            protected int zzv() {
                int zzv = super.zzv();
                if (!(this.zzbgB == null || this.zzbgB.equals(BuildConfig.FLAVOR))) {
                    zzv += zzbum.zzr(1, this.zzbgB);
                }
                if (!(this.zzbgC == null || this.zzbgC.equals(BuildConfig.FLAVOR))) {
                    zzv += zzbum.zzr(2, this.zzbgC);
                }
                return this.viewId != 0 ? zzv + zzbum.zzH(3, this.viewId) : zzv;
            }
        }

        public zza() {
            zzGj();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaqa_zza = (zza) obj;
            return zzbur.equals(this.zzbgz, com_google_android_gms_internal_zzaqa_zza.zzbgz) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzaqa_zza.zzcrX == null || com_google_android_gms_internal_zzaqa_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzaqa_zza.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzbgz)) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public zza zzB(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                        zzacu = this.zzbgz == null ? 0 : this.zzbgz.length;
                        Object obj = new zza[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzbgz, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zza();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzbgz = obj;
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

        public zza zzGj() {
            this.zzbgz = zza.zzGk();
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzbgz != null && this.zzbgz.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzbgz) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(1, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzB(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzbgz != null && this.zzbgz.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzbgz) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        zzv += zzbum.zzc(1, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            return zzv;
        }
    }

    public static final class zzb extends zzbun<zzb> {
        private static volatile zzb[] zzbgD;
        public String name;
        public zzd zzbgE;

        public zzb() {
            zzGn();
        }

        public static zzb[] zzGm() {
            if (zzbgD == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzbgD == null) {
                        zzbgD = new zzb[0];
                    }
                }
            }
            return zzbgD;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzaqa_zzb = (zzb) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzaqa_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzaqa_zzb.name)) {
                return false;
            }
            if (this.zzbgE == null) {
                if (com_google_android_gms_internal_zzaqa_zzb.zzbgE != null) {
                    return false;
                }
            } else if (!this.zzbgE.equals(com_google_android_gms_internal_zzaqa_zzb.zzbgE)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzaqa_zzb.zzcrX == null || com_google_android_gms_internal_zzaqa_zzb.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzaqa_zzb.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbgE == null ? 0 : this.zzbgE.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zzb zzD(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        this.name = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzbgE == null) {
                            this.zzbgE = new zzd();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzbgE);
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

        public zzb zzGn() {
            this.name = BuildConfig.FLAVOR;
            this.zzbgE = null;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (!(this.name == null || this.name.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(1, this.name);
            }
            if (this.zzbgE != null) {
                com_google_android_gms_internal_zzbum.zza(2, this.zzbgE);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzD(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (!(this.name == null || this.name.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(1, this.name);
            }
            return this.zzbgE != null ? zzv + zzbum.zzc(2, this.zzbgE) : zzv;
        }
    }

    public static final class zzc extends zzbun<zzc> {
        public String type;
        public zzb[] zzbgF;

        public zzc() {
            zzGo();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzaqa_zzc = (zzc) obj;
            if (this.type == null) {
                if (com_google_android_gms_internal_zzaqa_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zzaqa_zzc.type)) {
                return false;
            }
            return zzbur.equals(this.zzbgF, com_google_android_gms_internal_zzaqa_zzc.zzbgF) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzaqa_zzc.zzcrX == null || com_google_android_gms_internal_zzaqa_zzc.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzaqa_zzc.zzcrX) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzbur.hashCode(this.zzbgF)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zzc zzE(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case HTTP.LF /*10*/:
                        this.type = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 18);
                        zzacu = this.zzbgF == null ? 0 : this.zzbgF.length;
                        Object obj = new zzb[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzbgF, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = new zzb();
                            com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = new zzb();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        this.zzbgF = obj;
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

        public zzc zzGo() {
            this.type = BuildConfig.FLAVOR;
            this.zzbgF = zzb.zzGm();
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (!(this.type == null || this.type.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(1, this.type);
            }
            if (this.zzbgF != null && this.zzbgF.length > 0) {
                for (zzbut com_google_android_gms_internal_zzbut : this.zzbgF) {
                    if (com_google_android_gms_internal_zzbut != null) {
                        com_google_android_gms_internal_zzbum.zza(2, com_google_android_gms_internal_zzbut);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzE(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (!(this.type == null || this.type.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(1, this.type);
            }
            if (this.zzbgF == null || this.zzbgF.length <= 0) {
                return zzv;
            }
            int i = zzv;
            for (zzbut com_google_android_gms_internal_zzbut : this.zzbgF) {
                if (com_google_android_gms_internal_zzbut != null) {
                    i += zzbum.zzc(2, com_google_android_gms_internal_zzbut);
                }
            }
            return i;
        }
    }

    public static final class zzd extends zzbun<zzd> {
        public String zzaFy;
        public boolean zzbgG;
        public long zzbgH;
        public double zzbgI;
        public zzc zzbgJ;

        public zzd() {
            zzGp();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzaqa_zzd = (zzd) obj;
            if (this.zzbgG != com_google_android_gms_internal_zzaqa_zzd.zzbgG) {
                return false;
            }
            if (this.zzaFy == null) {
                if (com_google_android_gms_internal_zzaqa_zzd.zzaFy != null) {
                    return false;
                }
            } else if (!this.zzaFy.equals(com_google_android_gms_internal_zzaqa_zzd.zzaFy)) {
                return false;
            }
            if (this.zzbgH != com_google_android_gms_internal_zzaqa_zzd.zzbgH || Double.doubleToLongBits(this.zzbgI) != Double.doubleToLongBits(com_google_android_gms_internal_zzaqa_zzd.zzbgI)) {
                return false;
            }
            if (this.zzbgJ == null) {
                if (com_google_android_gms_internal_zzaqa_zzd.zzbgJ != null) {
                    return false;
                }
            } else if (!this.zzbgJ.equals(com_google_android_gms_internal_zzaqa_zzd.zzbgJ)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzaqa_zzd.zzcrX == null || com_google_android_gms_internal_zzaqa_zzd.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzaqa_zzd.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzaFy == null ? 0 : this.zzaFy.hashCode()) + (((this.zzbgG ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.zzbgH ^ (this.zzbgH >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzbgI);
            hashCode = ((this.zzbgJ == null ? 0 : this.zzbgJ.hashCode()) + (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zzd zzF(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.zzbgG = com_google_android_gms_internal_zzbul.zzacA();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzaFy = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                        this.zzbgH = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case C0308R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                        this.zzbgI = com_google_android_gms_internal_zzbul.readDouble();
                        continue;
                    case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        if (this.zzbgJ == null) {
                            this.zzbgJ = new zzc();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzbgJ);
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

        public zzd zzGp() {
            this.zzbgG = false;
            this.zzaFy = BuildConfig.FLAVOR;
            this.zzbgH = 0;
            this.zzbgI = 0.0d;
            this.zzbgJ = null;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzbgG) {
                com_google_android_gms_internal_zzbum.zzg(1, this.zzbgG);
            }
            if (!(this.zzaFy == null || this.zzaFy.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(2, this.zzaFy);
            }
            if (this.zzbgH != 0) {
                com_google_android_gms_internal_zzbum.zzb(3, this.zzbgH);
            }
            if (Double.doubleToLongBits(this.zzbgI) != Double.doubleToLongBits(0.0d)) {
                com_google_android_gms_internal_zzbum.zza(4, this.zzbgI);
            }
            if (this.zzbgJ != null) {
                com_google_android_gms_internal_zzbum.zza(5, this.zzbgJ);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzF(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzbgG) {
                zzv += zzbum.zzh(1, this.zzbgG);
            }
            if (!(this.zzaFy == null || this.zzaFy.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(2, this.zzaFy);
            }
            if (this.zzbgH != 0) {
                zzv += zzbum.zzf(3, this.zzbgH);
            }
            if (Double.doubleToLongBits(this.zzbgI) != Double.doubleToLongBits(0.0d)) {
                zzv += zzbum.zzb(4, this.zzbgI);
            }
            return this.zzbgJ != null ? zzv + zzbum.zzc(5, this.zzbgJ) : zzv;
        }
    }
}
