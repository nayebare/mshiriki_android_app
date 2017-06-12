package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public class zzade implements zzacz {
    private static final Charset UTF_8;
    private static final Pattern zzaHr;
    private static final Pattern zzaHs;

    static abstract class zzb<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzadg> {
        public zzb(GoogleApiClient googleApiClient) {
            super(zzacy.API, googleApiClient);
        }

        protected abstract void zza(Context context, zzado com_google_android_gms_internal_zzado) throws RemoteException;

        protected final void zza(zzadg com_google_android_gms_internal_zzadg) throws RemoteException {
            zza(com_google_android_gms_internal_zzadg.getContext(), (zzado) com_google_android_gms_internal_zzadg.zzwW());
        }
    }

    static abstract class zzc extends zzb<com.google.android.gms.internal.zzacz.zzb> {
        protected zzadn zzaHu;

        /* renamed from: com.google.android.gms.internal.zzade.zzc.1 */
        class C09121 extends zza {
            final /* synthetic */ zzc zzaHv;

            C09121(zzc com_google_android_gms_internal_zzade_zzc) {
                this.zzaHv = com_google_android_gms_internal_zzade_zzc;
            }

            public void zza(Status status, zzadl com_google_android_gms_internal_zzadl) {
                if (com_google_android_gms_internal_zzadl.getStatusCode() == GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE || com_google_android_gms_internal_zzadl.getStatusCode() == GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED) {
                    this.zzaHv.zzb(new zzd(zzade.zzdn(com_google_android_gms_internal_zzadl.getStatusCode()), zzade.zza(com_google_android_gms_internal_zzadl), com_google_android_gms_internal_zzadl.getThrottleEndTimeMillis()));
                } else {
                    this.zzaHv.zzb(new zzd(zzade.zzdn(com_google_android_gms_internal_zzadl.getStatusCode()), zzade.zza(com_google_android_gms_internal_zzadl)));
                }
            }
        }

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaHu = new C09121(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzade.1 */
    class C09111 extends zzc {
        final /* synthetic */ com.google.android.gms.internal.zzacz.zza zzaHt;

        C09111(zzade com_google_android_gms_internal_zzade, GoogleApiClient googleApiClient, com.google.android.gms.internal.zzacz.zza com_google_android_gms_internal_zzacz_zza) {
            this.zzaHt = com_google_android_gms_internal_zzacz_zza;
            super(googleApiClient);
        }

        protected com.google.android.gms.internal.zzacz.zzb zzH(Status status) {
            return new zzd(status, new HashMap());
        }

        protected void zza(Context context, zzado com_google_android_gms_internal_zzado) throws RemoteException {
            String id;
            String token;
            Throwable e;
            com.google.android.gms.common.data.DataHolder.zza zzwC = com.google.android.gms.common.data.zzd.zzwC();
            for (Entry entry : this.zzaHt.zzyR().entrySet()) {
                com.google.android.gms.common.data.zzd.zza(zzwC, new zzadh((String) entry.getKey(), (String) entry.getValue()));
            }
            DataHolder zzcE = zzwC.zzcE(0);
            String zzwj = zzaas.zzay(context) == Status.zzayh ? zzaas.zzwj() : null;
            try {
                id = com.google.firebase.iid.zzc.zzaab().getId();
                try {
                    token = com.google.firebase.iid.zzc.zzaab().getToken();
                } catch (IllegalStateException e2) {
                    e = e2;
                    if (Log.isLoggable("ConfigApiImpl", 3)) {
                        Log.d("ConfigApiImpl", "Cannot retrieve instanceId or instanceIdToken.", e);
                    }
                    token = null;
                    com_google_android_gms_internal_zzado.zza(this.zzaHu, new zzadj(context.getPackageName(), this.zzaHt.zzyQ(), zzcE, zzwj, id, token, null, this.zzaHt.zzyS(), zzadd.zzaS(context)));
                    zzcE.close();
                }
            } catch (IllegalStateException e3) {
                e = e3;
                id = null;
                if (Log.isLoggable("ConfigApiImpl", 3)) {
                    Log.d("ConfigApiImpl", "Cannot retrieve instanceId or instanceIdToken.", e);
                }
                token = null;
                com_google_android_gms_internal_zzado.zza(this.zzaHu, new zzadj(context.getPackageName(), this.zzaHt.zzyQ(), zzcE, zzwj, id, token, null, this.zzaHt.zzyS(), zzadd.zzaS(context)));
                zzcE.close();
            }
            com_google_android_gms_internal_zzado.zza(this.zzaHu, new zzadj(context.getPackageName(), this.zzaHt.zzyQ(), zzcE, zzwj, id, token, null, this.zzaHt.zzyS(), zzadd.zzaS(context)));
            zzcE.close();
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzH(status);
        }
    }

    static abstract class zza extends com.google.android.gms.internal.zzadn.zza {
        zza() {
        }

        public void zzI(Status status) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, zzadl com_google_android_gms_internal_zzadl) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, Map map) {
            throw new UnsupportedOperationException();
        }

        public void zza(Status status, byte[] bArr) {
            throw new UnsupportedOperationException();
        }
    }

    public static class zzd implements com.google.android.gms.internal.zzacz.zzb {
        private final Map<String, TreeMap<String, byte[]>> zzaHw;
        private final long zzaHx;
        private final Status zzahq;

        public zzd(Status status, Map<String, TreeMap<String, byte[]>> map) {
            this(status, map, -1);
        }

        public zzd(Status status, Map<String, TreeMap<String, byte[]>> map, long j) {
            this.zzahq = status;
            this.zzaHw = map;
            this.zzaHx = j;
        }

        public Status getStatus() {
            return this.zzahq;
        }

        public long getThrottleEndTimeMillis() {
            return this.zzaHx;
        }

        public boolean zzH(String str, String str2) {
            return (this.zzaHw == null || this.zzaHw.get(str2) == null) ? false : ((TreeMap) this.zzaHw.get(str2)).get(str) != null;
        }

        public byte[] zza(String str, byte[] bArr, String str2) {
            return zzH(str, str2) ? (byte[]) ((TreeMap) this.zzaHw.get(str2)).get(str) : bArr;
        }

        public Map<String, Set<String>> zzyU() {
            Map<String, Set<String>> hashMap = new HashMap();
            if (this.zzaHw != null) {
                for (String str : this.zzaHw.keySet()) {
                    Map map = (Map) this.zzaHw.get(str);
                    if (map != null) {
                        hashMap.put(str, map.keySet());
                    }
                }
            }
            return hashMap;
        }
    }

    static {
        UTF_8 = Charset.forName(HTTP.UTF_8);
        zzaHr = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        zzaHs = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    private static HashMap<String, TreeMap<String, byte[]>> zza(zzadl com_google_android_gms_internal_zzadl) {
        if (com_google_android_gms_internal_zzadl == null) {
            return null;
        }
        DataHolder zzzb = com_google_android_gms_internal_zzadl.zzzb();
        if (zzzb == null) {
            return null;
        }
        zzadp com_google_android_gms_internal_zzadp = (zzadp) new com.google.android.gms.common.data.zzd(zzzb, zzadp.CREATOR).get(0);
        com_google_android_gms_internal_zzadl.zzzc();
        HashMap<String, TreeMap<String, byte[]>> hashMap = new HashMap();
        for (String str : com_google_android_gms_internal_zzadp.zzzd().keySet()) {
            TreeMap treeMap = new TreeMap();
            hashMap.put(str, treeMap);
            Bundle bundle = com_google_android_gms_internal_zzadp.zzzd().getBundle(str);
            for (String str2 : bundle.keySet()) {
                treeMap.put(str2, bundle.getByteArray(str2));
            }
        }
        return hashMap;
    }

    private static Status zzdn(int i) {
        return new Status(i, zzada.getStatusCodeString(i));
    }

    public PendingResult<com.google.android.gms.internal.zzacz.zzb> zza(GoogleApiClient googleApiClient, com.google.android.gms.internal.zzacz.zza com_google_android_gms_internal_zzacz_zza) {
        return (googleApiClient == null || com_google_android_gms_internal_zzacz_zza == null) ? null : googleApiClient.zza(new C09111(this, googleApiClient, com_google_android_gms_internal_zzacz_zza));
    }
}
