package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastOptions extends zza {
    public static final Creator<CastOptions> CREATOR;
    private final int mVersionCode;
    private final LaunchOptions zzana;
    private final String zzaoY;
    private final List<String> zzaoZ;
    private final boolean zzapa;
    private final boolean zzapb;
    private final CastMediaOptions zzapc;
    private final boolean zzapd;
    private final double zzape;

    public static final class Builder {
        private LaunchOptions zzana;
        private String zzaoY;
        private List<String> zzaoZ;
        private boolean zzapa;
        private boolean zzapb;
        private CastMediaOptions zzapc;
        private boolean zzapd;
        private double zzape;

        public Builder() {
            this.zzaoZ = new ArrayList();
            this.zzana = new LaunchOptions();
            this.zzapb = true;
            this.zzapc = new com.google.android.gms.cast.framework.media.CastMediaOptions.Builder().build();
            this.zzapd = true;
            this.zzape = 0.05000000074505806d;
        }

        public CastOptions build() {
            return new CastOptions(1, this.zzaoY, this.zzaoZ, this.zzapa, this.zzana, this.zzapb, this.zzapc, this.zzapd, this.zzape);
        }

        public Builder setCastMediaOptions(CastMediaOptions castMediaOptions) {
            this.zzapc = castMediaOptions;
            return this;
        }

        public Builder setEnableReconnectionService(boolean z) {
            this.zzapd = z;
            return this;
        }

        public Builder setLaunchOptions(LaunchOptions launchOptions) {
            this.zzana = launchOptions;
            return this;
        }

        public Builder setReceiverApplicationId(String str) {
            this.zzaoY = str;
            return this;
        }

        public Builder setResumeSavedSession(boolean z) {
            this.zzapb = z;
            return this;
        }

        public Builder setStopReceiverApplicationWhenEndingSession(boolean z) {
            this.zzapa = z;
            return this;
        }

        public Builder setSupportedNamespaces(List<String> list) {
            this.zzaoZ = list;
            return this;
        }

        public Builder setVolumeDeltaBeforeIceCreamSandwich(double d) throws IllegalArgumentException {
            if (d <= 0.0d || d > 0.5d) {
                throw new IllegalArgumentException("volumeDelta must be greater than 0 and less or equal to 0.5");
            }
            this.zzape = d;
            return this;
        }
    }

    static {
        CREATOR = new zzb();
    }

    CastOptions(int i, String str, List<String> list, boolean z, LaunchOptions launchOptions, boolean z2, CastMediaOptions castMediaOptions, boolean z3, double d) {
        this.mVersionCode = i;
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.FLAVOR;
        }
        this.zzaoY = str;
        int size = list == null ? 0 : list.size();
        this.zzaoZ = new ArrayList(size);
        if (size > 0) {
            this.zzaoZ.addAll(list);
        }
        this.zzapa = z;
        if (launchOptions == null) {
            launchOptions = new LaunchOptions();
        }
        this.zzana = launchOptions;
        this.zzapb = z2;
        this.zzapc = castMediaOptions;
        this.zzapd = z3;
        this.zzape = d;
    }

    public CastMediaOptions getCastMediaOptions() {
        return this.zzapc;
    }

    public boolean getEnableReconnectionService() {
        return this.zzapd;
    }

    public LaunchOptions getLaunchOptions() {
        return this.zzana;
    }

    public String getReceiverApplicationId() {
        return this.zzaoY;
    }

    public boolean getResumeSavedSession() {
        return this.zzapb;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.zzapa;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzaoZ);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.zzape;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
