package com.google.android.gms.drive;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzahk;

public class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzaJF;
    private final boolean zzaJG;
    private final int zzaJH;

    public static class Builder {
        protected String zzaJF;
        protected boolean zzaJG;
        protected int zzaJH;

        public Builder() {
            this.zzaJH = ExecutionOptions.CONFLICT_STRATEGY_OVERWRITE_REMOTE;
        }

        public ExecutionOptions build() {
            zzzI();
            return new ExecutionOptions(this.zzaJF, this.zzaJG, this.zzaJH);
        }

        public Builder setConflictStrategy(int i) {
            if (ExecutionOptions.zzdY(i)) {
                this.zzaJH = i;
                return this;
            }
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + i);
        }

        public Builder setNotifyOnCompletion(boolean z) {
            this.zzaJG = z;
            return this;
        }

        public Builder setTrackingTag(String str) {
            if (ExecutionOptions.zzdI(str)) {
                this.zzaJF = str;
                return this;
            }
            Object[] objArr = new Object[ExecutionOptions.CONFLICT_STRATEGY_KEEP_REMOTE];
            objArr[ExecutionOptions.CONFLICT_STRATEGY_OVERWRITE_REMOTE] = Integer.valueOf(ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", objArr));
        }

        protected void zzzI() {
            if (this.zzaJH == ExecutionOptions.CONFLICT_STRATEGY_KEEP_REMOTE && !this.zzaJG) {
                throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
            }
        }
    }

    public ExecutionOptions(String str, boolean z, int i) {
        this.zzaJF = str;
        this.zzaJG = z;
        this.zzaJH = i;
    }

    public static boolean zzdI(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= MAX_TRACKING_TAG_STRING_LENGTH;
    }

    public static boolean zzdX(int i) {
        switch (i) {
            case CONFLICT_STRATEGY_KEEP_REMOTE /*1*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzdY(int i) {
        switch (i) {
            case CONFLICT_STRATEGY_OVERWRITE_REMOTE /*0*/:
            case CONFLICT_STRATEGY_KEEP_REMOTE /*1*/:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) obj;
        return zzaa.equal(this.zzaJF, executionOptions.zzaJF) && this.zzaJH == executionOptions.zzaJH && this.zzaJG == executionOptions.zzaJG;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaJF, Integer.valueOf(this.zzaJH), Boolean.valueOf(this.zzaJG));
    }

    public void zzh(GoogleApiClient googleApiClient) {
        zzahk com_google_android_gms_internal_zzahk = (zzahk) googleApiClient.zza(Drive.zzahc);
        if (zzzG() && !com_google_android_gms_internal_zzahk.zzAm()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public String zzzF() {
        return this.zzaJF;
    }

    public boolean zzzG() {
        return this.zzaJG;
    }

    public int zzzH() {
        return this.zzaJH;
    }
}
