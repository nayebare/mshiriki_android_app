package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzk;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzajz;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String[] zzaJQ;
    private Filter zzaJR;
    private DriveId zzaJS;
    private String zzalD;

    public IntentSender build(GoogleApiClient googleApiClient) {
        zzac.zza(googleApiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzaJQ == null) {
            this.zzaJQ = new String[0];
        }
        if (this.zzaJQ.length <= 0 || this.zzaJR == null) {
            try {
                return ((zzahk) googleApiClient.zza(Drive.zzahc)).zzAi().zza(new zzajz(this.zzalD, this.zzaJQ, this.zzaJS, this.zzaJR == null ? null : new FilterHolder(this.zzaJR)));
            } catch (Throwable e) {
                throw new RuntimeException("Unable to connect Drive Play Service", e);
            }
        }
        throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzaJS = (DriveId) zzac.zzw(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String str) {
        this.zzalD = (String) zzac.zzw(str);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] strArr) {
        zzac.zzb(strArr != null, (Object) "mimeTypes may not be null");
        this.zzaJQ = strArr;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        boolean z = true;
        zzac.zzb(filter != null, (Object) "filter may not be null");
        if (zzk.zza(filter)) {
            z = false;
        }
        zzac.zzb(z, (Object) "FullTextSearchFilter cannot be used as a selection filter");
        this.zzaJR = filter;
        return this;
    }
}
