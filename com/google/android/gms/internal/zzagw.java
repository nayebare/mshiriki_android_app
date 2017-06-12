package com.google.android.gms.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzagw {
    private DriveId zzaJS;
    protected MetadataChangeSet zzaLc;
    private Integer zzaLd;
    private final int zzaLe;
    private String zzalD;

    public zzagw(int i) {
        this.zzaLe = i;
    }

    public IntentSender build(GoogleApiClient googleApiClient) {
        zzac.zzb(this.zzaLc, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzac.zza(googleApiClient.isConnected(), (Object) "Client must be connected");
        zzahk com_google_android_gms_internal_zzahk = (zzahk) googleApiClient.zza(Drive.zzahc);
        this.zzaLc.zzzP().setContext(com_google_android_gms_internal_zzahk.getContext());
        try {
            return com_google_android_gms_internal_zzahk.zzAi().zza(new zzagx(this.zzaLc.zzzP(), this.zzaLd == null ? 0 : this.zzaLd.intValue(), this.zzalD, this.zzaJS, this.zzaLe));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzaJS = (DriveId) zzac.zzw(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzaLc = (MetadataChangeSet) zzac.zzw(metadataChangeSet);
    }

    public void zzdM(String str) {
        this.zzalD = (String) zzac.zzw(str);
    }

    public void zzeA(int i) {
        this.zzaLd = Integer.valueOf(i);
    }
}
