package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzc;
import com.google.android.gms.drive.zzl;
import com.google.android.gms.internal.zzahj.zza;
import java.io.InputStream;
import java.io.OutputStream;

public class zzahl implements DriveContents {
    private boolean mClosed;
    private final zzc zzaLH;
    private boolean zzaLI;
    private boolean zzaLJ;

    /* renamed from: com.google.android.gms.internal.zzahl.1 */
    class C09361 extends zzc {
        final /* synthetic */ zzahl zzaLK;

        C09361(zzahl com_google_android_gms_internal_zzahl, GoogleApiClient googleApiClient) {
            this.zzaLK = com_google_android_gms_internal_zzahl;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzajw(this.zzaLK.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzaLK.zzaLH.getRequestId()), new zzajy(this, null));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahl.2 */
    class C09372 extends zza {
        final /* synthetic */ zzahl zzaLK;
        final /* synthetic */ MetadataChangeSet zzaLL;
        final /* synthetic */ zzl zzaLM;

        C09372(zzahl com_google_android_gms_internal_zzahl, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, zzl com_google_android_gms_drive_zzl) {
            this.zzaLK = com_google_android_gms_internal_zzahl;
            this.zzaLL = metadataChangeSet;
            this.zzaLM = com_google_android_gms_drive_zzl;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            this.zzaLL.zzzP().setContext(com_google_android_gms_internal_zzahk.getContext());
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzago(this.zzaLK.zzaLH.getDriveId(), this.zzaLL.zzzP(), this.zzaLK.zzaLH.getRequestId(), this.zzaLK.zzaLH.zzzz(), this.zzaLM), new zzakp(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahl.3 */
    class C09383 implements ResultCallback<Status> {
        C09383(zzahl com_google_android_gms_internal_zzahl) {
        }

        public /* synthetic */ void onResult(Result result) {
            zzp((Status) result);
        }

        public void zzp(Status status) {
            if (status.isSuccess()) {
                zzahp.zzD("DriveContentsImpl", "Contents discarded");
            } else {
                zzahp.zzF("DriveContentsImpl", "Error discarding contents");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzahl.4 */
    class C09394 extends zza {
        final /* synthetic */ zzahl zzaLK;

        C09394(zzahl com_google_android_gms_internal_zzahl, GoogleApiClient googleApiClient) {
            this.zzaLK = com_google_android_gms_internal_zzahl;
            super(googleApiClient);
        }

        protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
            com_google_android_gms_internal_zzahk.zzAi().zza(new zzagq(this.zzaLK.zzaLH.getRequestId(), false), new zzakp(this));
        }
    }

    public zzahl(zzc com_google_android_gms_drive_zzc) {
        this.mClosed = false;
        this.zzaLI = false;
        this.zzaLJ = false;
        this.zzaLH = (zzc) zzac.zzw(com_google_android_gms_drive_zzc);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return zza(googleApiClient, metadataChangeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        return zza(googleApiClient, metadataChangeSet, executionOptions == null ? null : zzl.zzb(executionOptions));
    }

    public void discard(GoogleApiClient googleApiClient) {
        if (zzzD()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzzC();
        ((C09394) googleApiClient.zzb(new C09394(this, googleApiClient))).setResultCallback(new C09383(this));
    }

    public DriveId getDriveId() {
        return this.zzaLH.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzzD()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzaLH.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzaLI) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzaLI = true;
            return this.zzaLH.getInputStream();
        }
    }

    public int getMode() {
        return this.zzaLH.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzzD()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzaLH.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzaLJ) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzaLJ = true;
            return this.zzaLH.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzzD()) {
            return this.zzaLH.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (zzzD()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzaLH.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzzC();
            return googleApiClient.zza(new C09361(this, googleApiClient));
        }
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, zzl com_google_android_gms_drive_zzl) {
        zzl com_google_android_gms_drive_zzl2 = com_google_android_gms_drive_zzl == null ? (zzl) new zzl.zza().build() : com_google_android_gms_drive_zzl;
        if (this.zzaLH.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzdX(com_google_android_gms_drive_zzl2.zzzH()) || this.zzaLH.zzzz()) {
            com_google_android_gms_drive_zzl2.zzh(googleApiClient);
            if (zzzD()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.zzaJN;
                }
                zzzC();
                return googleApiClient.zzb(new C09372(this, googleApiClient, metadataChangeSet, com_google_android_gms_drive_zzl2));
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public zzc zzzB() {
        return this.zzaLH;
    }

    public void zzzC() {
        zzo.zza(this.zzaLH.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzzD() {
        return this.mClosed;
    }
}
