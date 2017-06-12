package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.awareness.fence.FenceQueryResult;
import com.google.android.gms.awareness.fence.FenceStateMap;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzzv.zzb;

public class zzafd extends com.google.android.gms.internal.zzaff.zza {
    private final zza zzaIC;
    private zzb<Status> zzaID;
    private zzb<zzadw> zzaIE;
    private zzb<zzafw> zzaIF;
    private zzb<zzadv> zzaIG;
    private zzb<zzwl> zzaIH;
    private zzb<FenceQueryResult> zzaII;
    private zzb<com.google.android.gms.awareness.fence.zzb> zzaIJ;

    /* renamed from: com.google.android.gms.internal.zzafd.1 */
    class C09191 implements zzadw {
        private final zzads zzaIK;
        final /* synthetic */ DataHolder zzaIL;
        final /* synthetic */ Status zzamf;

        C09191(zzafd com_google_android_gms_internal_zzafd, DataHolder dataHolder, Status status) {
            this.zzaIL = dataHolder;
            this.zzamf = status;
            this.zzaIK = this.zzaIL == null ? null : new zzads(this.zzaIL);
        }

        public Status getStatus() {
            return this.zzamf;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzafd.2 */
    class C09202 implements zzafw {
        final /* synthetic */ zzafu zzaIM;
        final /* synthetic */ Status zzamf;

        C09202(zzafd com_google_android_gms_internal_zzafd, Status status, zzafu com_google_android_gms_internal_zzafu) {
            this.zzamf = status;
            this.zzaIM = com_google_android_gms_internal_zzafu;
        }

        public Status getStatus() {
            return this.zzamf;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzafd.3 */
    class C09213 implements zzadv {
        private final zzads zzaIK;
        final /* synthetic */ DataHolder zzaIL;
        final /* synthetic */ Status zzamf;

        C09213(zzafd com_google_android_gms_internal_zzafd, DataHolder dataHolder, Status status) {
            this.zzaIL = dataHolder;
            this.zzamf = status;
            this.zzaIK = this.zzaIL == null ? null : new zzads(this.zzaIL);
        }

        public Status getStatus() {
            return this.zzamf;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzafd.4 */
    class C09224 implements zzwl {
        final /* synthetic */ zzwg zzaIN;
        final /* synthetic */ Status zzamf;

        C09224(zzafd com_google_android_gms_internal_zzafd, Status status, zzwg com_google_android_gms_internal_zzwg) {
            this.zzamf = status;
            this.zzaIN = com_google_android_gms_internal_zzwg;
        }

        public Status getStatus() {
            return this.zzamf;
        }

        public zzwg zzrD() {
            return this.zzaIN;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzafd.5 */
    class C09235 implements FenceQueryResult {
        final /* synthetic */ zzaek zzaIO;
        final /* synthetic */ Status zzamf;

        C09235(zzafd com_google_android_gms_internal_zzafd, zzaek com_google_android_gms_internal_zzaek, Status status) {
            this.zzaIO = com_google_android_gms_internal_zzaek;
            this.zzamf = status;
        }

        public FenceStateMap getFenceStateMap() {
            return this.zzaIO;
        }

        public Status getStatus() {
            return this.zzamf;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzafd.6 */
    class C09246 implements com.google.android.gms.awareness.fence.zzb {
        final /* synthetic */ zzaei zzaIP;
        final /* synthetic */ Status zzamf;

        C09246(zzafd com_google_android_gms_internal_zzafd, zzaei com_google_android_gms_internal_zzaei, Status status) {
            this.zzaIP = com_google_android_gms_internal_zzaei;
            this.zzamf = status;
        }

        public Status getStatus() {
            return this.zzamf;
        }
    }

    public interface zza {
    }

    private zzafd(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzb<zzadw> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzadw, zzb<zzafw> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzafw, zzb<zzadv> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzadv, zzb<zzwl> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzwl, zzb<FenceQueryResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_FenceQueryResult, zzb<com.google.android.gms.awareness.fence.zzb> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_zzb, zza com_google_android_gms_internal_zzafd_zza) {
        this.zzaID = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        this.zzaIE = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzadw;
        this.zzaIF = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzafw;
        this.zzaIG = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzadv;
        this.zzaIH = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzwl;
        this.zzaII = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_FenceQueryResult;
        this.zzaIJ = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_zzb;
        this.zzaIC = com_google_android_gms_internal_zzafd_zza;
    }

    public static zzafd zza(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zzafd_zza) {
        return new zzafd(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, null, null, null, null, null, null, com_google_android_gms_internal_zzafd_zza);
    }

    public static zzafd zzd(zzb<zzwl> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzwl) {
        return new zzafd(null, null, null, null, com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_internal_zzwl, null, null, null);
    }

    public static zzafd zze(zzb<FenceQueryResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_FenceQueryResult) {
        return new zzafd(null, null, null, null, null, com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_awareness_fence_FenceQueryResult, null, null);
    }

    public void zza(Status status, DataHolder dataHolder) throws RemoteException {
        if (this.zzaIG == null) {
            zzcd.zzd("ContextManagerPendingResult", "Unexpected callback to onStateResult");
            return;
        }
        this.zzaIG.setResult(new C09213(this, dataHolder, status));
        this.zzaIG = null;
    }

    public void zza(Status status, DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
        if (this.zzaIE == null) {
            zzcd.zzd("ContextManagerPendingResult", "Unexpected callback to onReadResult.");
            return;
        }
        this.zzaIE.setResult(new C09191(this, dataHolder, status));
        this.zzaIE = null;
    }

    public void zza(Status status, zzaei com_google_android_gms_internal_zzaei) {
        if (this.zzaIJ == null) {
            zzcd.zzd("ContextManagerPendingResult", "Unexpected callback to onFenceEvaluateResult");
            return;
        }
        this.zzaIJ.setResult(new C09246(this, com_google_android_gms_internal_zzaei, status));
        this.zzaIJ = null;
    }

    public void zza(Status status, zzaek com_google_android_gms_internal_zzaek) {
        if (this.zzaII == null) {
            zzcd.zzd("ContextManagerPendingResult", "Unexpected callback to onFenceQueryResult");
            return;
        }
        this.zzaII.setResult(new C09235(this, com_google_android_gms_internal_zzaek, status));
        this.zzaII = null;
    }

    public void zza(Status status, zzafu com_google_android_gms_internal_zzafu) throws RemoteException {
        if (this.zzaIF == null) {
            zzcd.zzd("ContextManagerPendingResult", "Unexpected callback to onWriteBatchResult");
            return;
        }
        this.zzaIF.setResult(new C09202(this, status, com_google_android_gms_internal_zzafu));
        this.zzaIF = null;
    }

    public void zza(Status status, zzwg com_google_android_gms_internal_zzwg) throws RemoteException {
        if (this.zzaIH == null) {
            zzcd.zzd("ContextManagerPendingResult", "Unexpected callback to onSnapshotResult");
            return;
        }
        this.zzaIH.setResult(new C09224(this, status, com_google_android_gms_internal_zzwg));
        this.zzaIH = null;
    }

    public void zzh(Status status) throws RemoteException {
        if (this.zzaID == null) {
            zzcd.zzd("ContextManagerPendingResult", "Unexpected callback to onStatusResult.");
            return;
        }
        this.zzaID.setResult(status);
        this.zzaID = null;
    }
}
