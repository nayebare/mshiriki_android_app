package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzym;
import java.util.Locale;

public class LaunchOptions extends zza {
    public static final Creator<LaunchOptions> CREATOR;
    private final int mVersionCode;
    private String zzabW;
    private boolean zzamZ;

    public static final class Builder {
        private LaunchOptions zzana;

        public Builder() {
            this.zzana = new LaunchOptions();
        }

        public LaunchOptions build() {
            return this.zzana;
        }

        public Builder setLocale(Locale locale) {
            this.zzana.setLanguage(zzym.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean z) {
            this.zzana.setRelaunchIfRunning(z);
            return this;
        }
    }

    static {
        CREATOR = new zzh();
    }

    public LaunchOptions() {
        this(1, false, zzym.zzb(Locale.getDefault()));
    }

    LaunchOptions(int i, boolean z, String str) {
        this.mVersionCode = i;
        this.zzamZ = z;
        this.zzabW = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zzamZ == launchOptions.zzamZ && zzym.zza(this.zzabW, launchOptions.zzabW);
    }

    public String getLanguage() {
        return this.zzabW;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzamZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Boolean.valueOf(this.zzamZ), this.zzabW);
    }

    public void setLanguage(String str) {
        this.zzabW = str;
    }

    public void setRelaunchIfRunning(boolean z) {
        this.zzamZ = z;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.zzamZ), this.zzabW});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
