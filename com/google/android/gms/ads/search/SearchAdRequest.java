package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzey.zza;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int mBackgroundColor;
    private final int zzaaa;
    private final int zzaab;
    private final int zzaac;
    private final int zzaad;
    private final int zzaae;
    private final int zzaaf;
    private final int zzaag;
    private final String zzaah;
    private final int zzaai;
    private final String zzaaj;
    private final int zzaak;
    private final int zzaal;
    private final zzey zzrE;
    private final String zzuv;

    public static final class Builder {
        private int mBackgroundColor;
        private int zzaaa;
        private int zzaab;
        private int zzaac;
        private int zzaad;
        private int zzaae;
        private int zzaaf;
        private int zzaag;
        private String zzaah;
        private int zzaai;
        private String zzaaj;
        private int zzaak;
        private int zzaal;
        private final zza zzrF;
        private String zzuv;

        public Builder() {
            this.zzrF = new zza();
            this.zzaaf = SearchAdRequest.ERROR_CODE_INTERNAL_ERROR;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzrF.zzb(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzrF.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzrF.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zzrF.zzM(str);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int i) {
            this.zzaaa = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.mBackgroundColor = i;
            this.zzaab = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.zzaac = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            this.mBackgroundColor = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.zzaab = i2;
            this.zzaac = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.zzaad = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.zzaae = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.zzaaf = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.zzaag = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.zzaah = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.zzaai = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.zzaaj = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.zzaak = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.zzaal = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzrF.zzb(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.zzuv = str;
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zzrF.zzQ(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.zzrF.zzo(z);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = zzey.DEVICE_ID_EMULATOR;
    }

    private SearchAdRequest(Builder builder) {
        this.zzaaa = builder.zzaaa;
        this.mBackgroundColor = builder.mBackgroundColor;
        this.zzaab = builder.zzaab;
        this.zzaac = builder.zzaac;
        this.zzaad = builder.zzaad;
        this.zzaae = builder.zzaae;
        this.zzaaf = builder.zzaaf;
        this.zzaag = builder.zzaag;
        this.zzaah = builder.zzaah;
        this.zzaai = builder.zzaai;
        this.zzaaj = builder.zzaaj;
        this.zzaak = builder.zzaak;
        this.zzaal = builder.zzaal;
        this.zzuv = builder.zzuv;
        this.zzrE = new zzey(builder.zzrF, this);
    }

    public int getAnchorTextColor() {
        return this.zzaaa;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBackgroundGradientBottom() {
        return this.zzaab;
    }

    public int getBackgroundGradientTop() {
        return this.zzaac;
    }

    public int getBorderColor() {
        return this.zzaad;
    }

    public int getBorderThickness() {
        return this.zzaae;
    }

    public int getBorderType() {
        return this.zzaaf;
    }

    public int getCallButtonColor() {
        return this.zzaag;
    }

    public String getCustomChannels() {
        return this.zzaah;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzrE.getCustomEventExtrasBundle(cls);
    }

    public int getDescriptionTextColor() {
        return this.zzaai;
    }

    public String getFontFace() {
        return this.zzaaj;
    }

    public int getHeaderTextColor() {
        return this.zzaak;
    }

    public int getHeaderTextSize() {
        return this.zzaal;
    }

    public Location getLocation() {
        return this.zzrE.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzrE.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzrE.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.zzuv;
    }

    public boolean isTestDevice(Context context) {
        return this.zzrE.isTestDevice(context);
    }

    zzey zzbq() {
        return this.zzrE;
    }
}
