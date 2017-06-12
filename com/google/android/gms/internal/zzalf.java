package com.google.android.gms.internal;

import android.support.v7.mediarouter.C0308R;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public final class zzalf extends zzbun<zzalf> {
    public int versionCode;
    public long zzaNg;
    public String zzaNi;
    public long zzaNj;
    public int zzaNk;

    public zzalf() {
        zzAA();
    }

    public static zzalf zzu(byte[] bArr) throws zzbus {
        return (zzalf) zzbut.zza(new zzalf(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzalf)) {
            return false;
        }
        zzalf com_google_android_gms_internal_zzalf = (zzalf) obj;
        if (this.versionCode != com_google_android_gms_internal_zzalf.versionCode) {
            return false;
        }
        if (this.zzaNi == null) {
            if (com_google_android_gms_internal_zzalf.zzaNi != null) {
                return false;
            }
        } else if (!this.zzaNi.equals(com_google_android_gms_internal_zzalf.zzaNi)) {
            return false;
        }
        return (this.zzaNj == com_google_android_gms_internal_zzalf.zzaNj && this.zzaNg == com_google_android_gms_internal_zzalf.zzaNg && this.zzaNk == com_google_android_gms_internal_zzalf.zzaNk) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzalf.zzcrX == null || com_google_android_gms_internal_zzalf.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzalf.zzcrX) : false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.zzaNi == null ? 0 : this.zzaNi.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31)) * 31) + ((int) (this.zzaNj ^ (this.zzaNj >>> 32)))) * 31) + ((int) (this.zzaNg ^ (this.zzaNg >>> 32)))) * 31) + this.zzaNk) * 31;
        if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
            i = this.zzcrX.hashCode();
        }
        return hashCode + i;
    }

    public zzalf zzAA() {
        this.versionCode = 1;
        this.zzaNi = BuildConfig.FLAVOR;
        this.zzaNj = -1;
        this.zzaNg = -1;
        this.zzaNk = -1;
        this.zzcrX = null;
        this.zzcsg = -1;
        return this;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        com_google_android_gms_internal_zzbum.zzF(1, this.versionCode);
        com_google_android_gms_internal_zzbum.zzq(2, this.zzaNi);
        com_google_android_gms_internal_zzbum.zzd(3, this.zzaNj);
        com_google_android_gms_internal_zzbum.zzd(4, this.zzaNg);
        if (this.zzaNk != -1) {
            com_google_android_gms_internal_zzbum.zzF(5, this.zzaNk);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzz(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = (((super.zzv() + zzbum.zzH(1, this.versionCode)) + zzbum.zzr(2, this.zzaNi)) + zzbum.zzh(3, this.zzaNj)) + zzbum.zzh(4, this.zzaNg);
        return this.zzaNk != -1 ? zzv + zzbum.zzH(5, this.zzaNk) : zzv;
    }

    public zzalf zzz(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    this.versionCode = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    this.zzaNi = com_google_android_gms_internal_zzbul.readString();
                    continue;
                case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                    this.zzaNj = com_google_android_gms_internal_zzbul.zzacC();
                    continue;
                case HTTP.SP /*32*/:
                    this.zzaNg = com_google_android_gms_internal_zzbul.zzacC();
                    continue;
                case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.zzaNk = com_google_android_gms_internal_zzbul.zzacy();
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
