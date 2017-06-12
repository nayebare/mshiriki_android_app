package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public final class zzbis extends zzbun<zzbis> {
    public String[] zzbUv;
    public int[] zzbUw;
    public byte[][] zzbUx;

    public zzbis() {
        zzTr();
    }

    public static zzbis zzS(byte[] bArr) throws zzbus {
        return (zzbis) zzbut.zza(new zzbis(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbis)) {
            return false;
        }
        zzbis com_google_android_gms_internal_zzbis = (zzbis) obj;
        return (zzbur.equals(this.zzbUv, com_google_android_gms_internal_zzbis.zzbUv) && zzbur.equals(this.zzbUw, com_google_android_gms_internal_zzbis.zzbUw) && zzbur.zza(this.zzbUx, com_google_android_gms_internal_zzbis.zzbUx)) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbis.zzcrX == null || com_google_android_gms_internal_zzbis.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbis.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzbUv)) * 31) + zzbur.hashCode(this.zzbUw)) * 31) + zzbur.zzb(this.zzbUx)) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public zzbis zzTr() {
        this.zzbUv = zzbuw.zzcsn;
        this.zzbUw = zzbuw.zzcsi;
        this.zzbUx = zzbuw.zzcso;
        this.zzcrX = null;
        this.zzcsg = -1;
        return this;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        int i = 0;
        if (this.zzbUv != null && this.zzbUv.length > 0) {
            for (String str : this.zzbUv) {
                if (str != null) {
                    com_google_android_gms_internal_zzbum.zzq(1, str);
                }
            }
        }
        if (this.zzbUw != null && this.zzbUw.length > 0) {
            for (int zzF : this.zzbUw) {
                com_google_android_gms_internal_zzbum.zzF(2, zzF);
            }
        }
        if (this.zzbUx != null && this.zzbUx.length > 0) {
            while (i < this.zzbUx.length) {
                byte[] bArr = this.zzbUx[i];
                if (bArr != null) {
                    com_google_android_gms_internal_zzbum.zzb(3, bArr);
                }
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbis zzab(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            int zzc;
            Object obj;
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case HTTP.LF /*10*/:
                    zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                    zzacu = this.zzbUv == null ? 0 : this.zzbUv.length;
                    obj = new String[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzbUv, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                    this.zzbUv = obj;
                    continue;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 16);
                    zzacu = this.zzbUw == null ? 0 : this.zzbUw.length;
                    obj = new int[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzbUw, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                    this.zzbUw = obj;
                    continue;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    int zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                    zzc = com_google_android_gms_internal_zzbul.getPosition();
                    zzacu = 0;
                    while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                        com_google_android_gms_internal_zzbul.zzacy();
                        zzacu++;
                    }
                    com_google_android_gms_internal_zzbul.zzql(zzc);
                    zzc = this.zzbUw == null ? 0 : this.zzbUw.length;
                    Object obj2 = new int[(zzacu + zzc)];
                    if (zzc != 0) {
                        System.arraycopy(this.zzbUw, 0, obj2, 0, zzc);
                    }
                    while (zzc < obj2.length) {
                        obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                        zzc++;
                    }
                    this.zzbUw = obj2;
                    com_google_android_gms_internal_zzbul.zzqk(zzqj);
                    continue;
                case C0308R.styleable.Toolbar_logoDescription /*26*/:
                    zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 26);
                    zzacu = this.zzbUx == null ? 0 : this.zzbUx.length;
                    obj = new byte[(zzc + zzacu)][];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzbUx, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readBytes();
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = com_google_android_gms_internal_zzbul.readBytes();
                    this.zzbUx = obj;
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
        return zzab(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int zzv = super.zzv();
        if (this.zzbUv == null || this.zzbUv.length <= 0) {
            i = zzv;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.zzbUv) {
                if (str != null) {
                    i3++;
                    i2 += zzbum.zzkc(str);
                }
            }
            i = (zzv + i2) + (i3 * 1);
        }
        if (this.zzbUw != null && this.zzbUw.length > 0) {
            i3 = 0;
            for (int zzv2 : this.zzbUw) {
                i3 += zzbum.zzqp(zzv2);
            }
            i = (i + i3) + (this.zzbUw.length * 1);
        }
        if (this.zzbUx == null || this.zzbUx.length <= 0) {
            return i;
        }
        i2 = 0;
        i3 = 0;
        while (i4 < this.zzbUx.length) {
            byte[] bArr = this.zzbUx[i4];
            if (bArr != null) {
                i3++;
                i2 += zzbum.zzag(bArr);
            }
            i4++;
        }
        return (i + i2) + (i3 * 1);
    }
}
