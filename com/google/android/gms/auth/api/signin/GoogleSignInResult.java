package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    private Status zzahq;
    private GoogleSignInAccount zzajn;

    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.zzajn = googleSignInAccount;
        this.zzahq = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.zzajn;
    }

    @NonNull
    public Status getStatus() {
        return this.zzahq;
    }

    public boolean isSuccess() {
        return this.zzahq.isSuccess();
    }
}
