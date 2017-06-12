package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafeBrowsingThreat;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzaxa implements SafetyNetApi {
    private static final String TAG;
    protected static SparseArray<zzaxf> zzbBg;
    protected static long zzbBh;

    static abstract class zzb extends zzawx<AttestationResult> {
        protected zzawy zzbBp;

        /* renamed from: com.google.android.gms.internal.zzaxa.zzb.1 */
        class C11011 extends zzaww {
            final /* synthetic */ zzb zzbBq;

            C11011(zzb com_google_android_gms_internal_zzaxa_zzb) {
                this.zzbBq = com_google_android_gms_internal_zzaxa_zzb;
            }

            public void zza(Status status, com.google.android.gms.safetynet.zza com_google_android_gms_safetynet_zza) {
                this.zzbBq.zzb(new zza(status, com_google_android_gms_safetynet_zza));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbBp = new C11011(this);
        }

        protected AttestationResult zzbB(Status status) {
            return new zza(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbB(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaxa.1 */
    class C10951 extends zzb {
        final /* synthetic */ byte[] zzbBi;

        C10951(zzaxa com_google_android_gms_internal_zzaxa, GoogleApiClient googleApiClient, byte[] bArr) {
            this.zzbBi = bArr;
            super(googleApiClient);
        }

        protected void zza(zzaxb com_google_android_gms_internal_zzaxb) throws RemoteException {
            com_google_android_gms_internal_zzaxb.zza(this.zzbBp, this.zzbBi);
        }
    }

    static abstract class zzf extends zzawx<SafeBrowsingResult> {
        protected zzawy zzbBp;

        /* renamed from: com.google.android.gms.internal.zzaxa.zzf.1 */
        class C11051 extends zzaww {
            final /* synthetic */ zzf zzbBu;

            C11051(zzf com_google_android_gms_internal_zzaxa_zzf) {
                this.zzbBu = com_google_android_gms_internal_zzaxa_zzf;
            }

            public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                DataHolder blacklistsDataHolder = safeBrowsingData.getBlacklistsDataHolder();
                if (blacklistsDataHolder != null) {
                    try {
                        int count = blacklistsDataHolder.getCount();
                        if (count != 0) {
                            if (zzaxa.zzbBg != null) {
                                zzaxa.zzbBg.clear();
                            }
                            zzaxa.zzbBg = new SparseArray();
                            for (int i = 0; i < count; i++) {
                                zzaxf com_google_android_gms_internal_zzaxf = new zzaxf(blacklistsDataHolder, i);
                                zzaxa.zzbBg.put(com_google_android_gms_internal_zzaxf.getThreatType(), com_google_android_gms_internal_zzaxf);
                            }
                            zzaxa.zzbBh = SystemClock.elapsedRealtime();
                        }
                        if (!blacklistsDataHolder.isClosed()) {
                            blacklistsDataHolder.close();
                        }
                    } catch (Throwable th) {
                        if (!blacklistsDataHolder.isClosed()) {
                            blacklistsDataHolder.close();
                        }
                    }
                }
                this.zzbBu.zzb(new zzi(status, safeBrowsingData));
            }
        }

        public zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbBp = new C11051(this);
        }

        protected SafeBrowsingResult zzbF(Status status) {
            return new zzi(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbF(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaxa.2 */
    class C10962 extends zzf {
        final /* synthetic */ List zzbBj;
        final /* synthetic */ String zzbBk;
        final /* synthetic */ String zzbBl;

        C10962(zzaxa com_google_android_gms_internal_zzaxa, GoogleApiClient googleApiClient, List list, String str, String str2) {
            this.zzbBj = list;
            this.zzbBk = str;
            this.zzbBl = str2;
            super(googleApiClient);
        }

        protected void zza(zzaxb com_google_android_gms_internal_zzaxb) throws RemoteException {
            com_google_android_gms_internal_zzaxb.zza(this.zzbBp, this.zzbBj, 2, this.zzbBk, this.zzbBl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaxa.3 */
    class C10973 extends zzf {
        final /* synthetic */ String zzbBk;
        final /* synthetic */ int[] zzbBm;

        C10973(zzaxa com_google_android_gms_internal_zzaxa, GoogleApiClient googleApiClient, int[] iArr, String str) {
            this.zzbBm = iArr;
            this.zzbBk = str;
            super(googleApiClient);
        }

        protected void zza(zzaxb com_google_android_gms_internal_zzaxb) throws RemoteException {
            List arrayList = new ArrayList();
            for (int valueOf : this.zzbBm) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            com_google_android_gms_internal_zzaxb.zza(this.zzbBp, arrayList, 1, this.zzbBk, null);
        }
    }

    static abstract class zzc extends zzawx<com.google.android.gms.safetynet.SafetyNetApi.zzd> {
        protected zzawy zzbBp;

        /* renamed from: com.google.android.gms.internal.zzaxa.zzc.1 */
        class C11021 extends zzaww {
            final /* synthetic */ zzc zzbBr;

            C11021(zzc com_google_android_gms_internal_zzaxa_zzc) {
                this.zzbBr = com_google_android_gms_internal_zzaxa_zzc;
            }

            public void zzc(Status status, boolean z) {
                this.zzbBr.zzb(new zzj(status, z));
            }
        }

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbBp = new C11021(this);
        }

        protected com.google.android.gms.safetynet.SafetyNetApi.zzd zzbC(Status status) {
            return new zzj(status, false);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbC(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaxa.4 */
    class C10984 extends zzc {
        C10984(zzaxa com_google_android_gms_internal_zzaxa, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzaxb com_google_android_gms_internal_zzaxb) throws RemoteException {
            com_google_android_gms_internal_zzaxb.zzb(this.zzbBp);
        }
    }

    static abstract class zzd extends zzawx<com.google.android.gms.safetynet.SafetyNetApi.zzb> {
        protected final zzawy zzbBp;

        /* renamed from: com.google.android.gms.internal.zzaxa.zzd.1 */
        class C11031 extends zzaww {
            final /* synthetic */ zzd zzbBs;

            C11031(zzd com_google_android_gms_internal_zzaxa_zzd) {
                this.zzbBs = com_google_android_gms_internal_zzaxa_zzd;
            }

            public void zza(Status status, com.google.android.gms.safetynet.zze com_google_android_gms_safetynet_zze) {
                this.zzbBs.zzb(new zzg(status, com_google_android_gms_safetynet_zze));
            }
        }

        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbBp = new C11031(this);
        }

        protected com.google.android.gms.safetynet.SafetyNetApi.zzb zzbD(Status status) {
            return new zzg(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbD(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaxa.5 */
    class C10995 extends zzd {
        C10995(zzaxa com_google_android_gms_internal_zzaxa, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzaxb com_google_android_gms_internal_zzaxb) throws RemoteException {
            com_google_android_gms_internal_zzaxb.zzc(this.zzbBp);
        }
    }

    static abstract class zze extends zzawx<com.google.android.gms.safetynet.SafetyNetApi.zzc> {
        protected zzawy zzbBp;

        /* renamed from: com.google.android.gms.internal.zzaxa.zze.1 */
        class C11041 extends zzaww {
            final /* synthetic */ zze zzbBt;

            C11041(zze com_google_android_gms_internal_zzaxa_zze) {
                this.zzbBt = com_google_android_gms_internal_zzaxa_zze;
            }

            public void zza(Status status, com.google.android.gms.safetynet.zzg com_google_android_gms_safetynet_zzg) {
                this.zzbBt.zzb(new zzh(status, com_google_android_gms_safetynet_zzg));
            }
        }

        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbBp = new C11041(this);
        }

        protected com.google.android.gms.safetynet.SafetyNetApi.zzc zzbE(Status status) {
            return new zzh(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbE(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaxa.6 */
    class C11006 extends zze {
        final /* synthetic */ String zzbBn;

        C11006(zzaxa com_google_android_gms_internal_zzaxa, GoogleApiClient googleApiClient, String str) {
            this.zzbBn = str;
            super(googleApiClient);
        }

        protected void zza(zzaxb com_google_android_gms_internal_zzaxb) throws RemoteException {
            com_google_android_gms_internal_zzaxb.zza(this.zzbBp, this.zzbBn);
        }
    }

    static class zza implements AttestationResult {
        private final Status zzahq;
        private final com.google.android.gms.safetynet.zza zzbBo;

        public zza(Status status, com.google.android.gms.safetynet.zza com_google_android_gms_safetynet_zza) {
            this.zzahq = status;
            this.zzbBo = com_google_android_gms_safetynet_zza;
        }

        public String getJwsResult() {
            return this.zzbBo == null ? null : this.zzbBo.getJwsResult();
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static class zzg implements com.google.android.gms.safetynet.SafetyNetApi.zzb {
        private final Status zzahq;
        private final com.google.android.gms.safetynet.zze zzbBv;

        public zzg(Status status, com.google.android.gms.safetynet.zze com_google_android_gms_safetynet_zze) {
            this.zzahq = status;
            this.zzbBv = com_google_android_gms_safetynet_zze;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static class zzh implements com.google.android.gms.safetynet.SafetyNetApi.zzc {
        private final Status zzahq;
        private final com.google.android.gms.safetynet.zzg zzbBw;

        public zzh(Status status, com.google.android.gms.safetynet.zzg com_google_android_gms_safetynet_zzg) {
            this.zzahq = status;
            this.zzbBw = com_google_android_gms_safetynet_zzg;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static class zzi implements SafeBrowsingResult {
        private Status zzahq;
        private String zzbBc;
        private final SafeBrowsingData zzbBx;

        public zzi(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzahq = status;
            this.zzbBx = safeBrowsingData;
            this.zzbBc = null;
            if (this.zzbBx != null) {
                this.zzbBc = this.zzbBx.getMetadata();
            } else if (this.zzahq.isSuccess()) {
                this.zzahq = new Status(8);
            }
        }

        public List<SafeBrowsingThreat> getDetectedThreats() {
            List<SafeBrowsingThreat> arrayList = new ArrayList();
            if (this.zzbBc == null) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONObject(this.zzbBc).getJSONArray("matches");
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(new SafeBrowsingThreat(Integer.parseInt(jSONArray.getJSONObject(i).getString("threat_type"))));
                    } catch (JSONException e) {
                    } catch (NumberFormatException e2) {
                    }
                }
                return arrayList;
            } catch (JSONException e3) {
                return arrayList;
            }
        }

        public String getMetadata() {
            return this.zzbBc;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static class zzj implements com.google.android.gms.safetynet.SafetyNetApi.zzd {
        private final boolean zzXR;
        private final Status zzahq;

        public zzj(Status status, boolean z) {
            this.zzahq = status;
            this.zzXR = z;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static {
        TAG = zzaxa.class.getSimpleName();
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, byte[] bArr) {
        return googleApiClient.zza(new C10951(this, googleApiClient, bArr));
    }

    public PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zzd> enableVerifyApps(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C10984(this, googleApiClient));
    }

    public boolean isVerifyAppsEnabled(Context context) {
        return new zzaxh(context).zzNZ();
    }

    public PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zzb> listHarmfulApps(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C10995(this, googleApiClient));
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, String str, int... iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            return googleApiClient.zza(new C10973(this, googleApiClient, iArr, str));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str) {
        return zza(googleApiClient, list, str, null);
    }

    public boolean lookupUriInLocalBlacklist(String str, int... iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        } else if (zzbBg == null || zzbBh == 0 || SystemClock.elapsedRealtime() - zzbBh >= 1200000) {
            return true;
        } else {
            if (zzbBg == null || zzbBg.size() == 0) {
                return true;
            }
            List<zzaxd> zzNU = new zzaxg(str).zzNU();
            if (zzNU == null || zzNU.isEmpty()) {
                return true;
            }
            for (zzaxd com_google_android_gms_internal_zzaxd : zzNU) {
                for (int i : iArr) {
                    zzaxf com_google_android_gms_internal_zzaxf = (zzaxf) zzbBg.get(i);
                    if (com_google_android_gms_internal_zzaxf == null) {
                        return true;
                    }
                    if (com_google_android_gms_internal_zzaxf.zzH(com_google_android_gms_internal_zzaxd.zzmG(4).getBytes())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zzc> verifyWithRecaptcha(GoogleApiClient googleApiClient, String str) {
        if (!TextUtils.isEmpty(str)) {
            return googleApiClient.zza(new C11006(this, googleApiClient, str));
        }
        throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
    }

    public PendingResult<SafeBrowsingResult> zza(GoogleApiClient googleApiClient, List<Integer> list, String str, String str2) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            return googleApiClient.zza(new C10962(this, googleApiClient, list, str, str2));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }
}
