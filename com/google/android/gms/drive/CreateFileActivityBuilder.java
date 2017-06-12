package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzagw;
import com.google.android.gms.internal.zzahl;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzagw zzaJl;
    private DriveContents zzaJm;
    private boolean zzaJn;

    public CreateFileActivityBuilder() {
        this.zzaJl = new zzagw(0);
    }

    public IntentSender build(GoogleApiClient googleApiClient) {
        zzac.zzb(Boolean.valueOf(this.zzaJn), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        zzac.zza(googleApiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzaJm != null) {
            this.zzaJm.zzzC();
        }
        return this.zzaJl.build(googleApiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzaJl.zza(driveId);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String str) {
        this.zzaJl.zzdM(str);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.zzaJl.zzeA(1);
        } else if (!(driveContents instanceof zzahl)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzzD()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.zzaJl.zzeA(driveContents.zzzB().getRequestId());
            this.zzaJm = driveContents;
        }
        this.zzaJn = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.zzaJl.zza(metadataChangeSet);
        return this;
    }
}
