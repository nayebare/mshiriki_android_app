package com.google.android.gms.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class zzbqr implements FirebaseRemoteConfigInfo {
    private long zzcjO;
    private int zzcjP;
    private FirebaseRemoteConfigSettings zzcjQ;

    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.zzcjQ;
    }

    public long getFetchTimeMillis() {
        return this.zzcjO;
    }

    public int getLastFetchStatus() {
        return this.zzcjP;
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzcjQ = firebaseRemoteConfigSettings;
    }

    public void zzaR(long j) {
        this.zzcjO = j;
    }

    public void zzpV(int i) {
        this.zzcjP = i;
    }
}
