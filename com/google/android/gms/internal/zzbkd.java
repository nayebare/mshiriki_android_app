package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.wearable.MessageApi;
import com.google.firebase.auth.ActionCodeResult;

public class zzbkd implements ActionCodeResult {
    private final String zzaiW;
    private final String zzbWI;
    private final int zzbkr;

    public zzbkd(@NonNull zzbjv com_google_android_gms_internal_zzbjv) {
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzbjv.zzUy())) {
            this.zzaiW = com_google_android_gms_internal_zzbjv.getEmail();
        } else {
            this.zzaiW = com_google_android_gms_internal_zzbjv.zzUy();
        }
        this.zzbWI = com_google_android_gms_internal_zzbjv.getEmail();
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzbjv.zzUz())) {
            this.zzbkr = 3;
        } else if (com_google_android_gms_internal_zzbjv.zzUz().equals("PASSWORD_RESET")) {
            this.zzbkr = 0;
        } else if (com_google_android_gms_internal_zzbjv.zzUz().equals("VERIFY_EMAIL")) {
            this.zzbkr = 1;
        } else if (com_google_android_gms_internal_zzbjv.zzUz().equals("RECOVER_EMAIL")) {
            this.zzbkr = 2;
        } else {
            this.zzbkr = 3;
        }
    }

    @Nullable
    public String getData(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return this.zzaiW;
            case MessageApi.FILTER_PREFIX /*1*/:
                return this.zzbWI;
            default:
                return null;
        }
    }

    public int getOperation() {
        return this.zzbkr;
    }
}
