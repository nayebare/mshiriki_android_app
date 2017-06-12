package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzavj extends zzl<zzavm> {
    private final long zzaYW;

    private static class zzb extends zzavi {
        private final zzaaz<MessageListener> zzbwV;

        /* renamed from: com.google.android.gms.internal.zzavj.zzb.1 */
        class C10721 implements com.google.android.gms.internal.zzaaz.zzc<MessageListener> {
            final /* synthetic */ String zzbwW;
            final /* synthetic */ byte[] zzbwX;
            final /* synthetic */ boolean zzbwY;

            C10721(zzb com_google_android_gms_internal_zzavj_zzb, String str, byte[] bArr, boolean z) {
                this.zzbwW = str;
                this.zzbwX = bArr;
                this.zzbwY = z;
            }

            public void zza(MessageListener messageListener) {
                messageListener.onMessageReceived(this.zzbwW, this.zzbwX, this.zzbwY);
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((MessageListener) obj);
            }

            public void zzvy() {
            }
        }

        /* renamed from: com.google.android.gms.internal.zzavj.zzb.2 */
        class C10732 implements com.google.android.gms.internal.zzaaz.zzc<MessageListener> {
            final /* synthetic */ String zzbwW;

            C10732(zzb com_google_android_gms_internal_zzavj_zzb, String str) {
                this.zzbwW = str;
            }

            public void zza(MessageListener messageListener) {
                messageListener.onDisconnected(this.zzbwW);
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((MessageListener) obj);
            }

            public void zzvy() {
            }
        }

        zzb(zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            this.zzbwV = com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener;
        }

        public void onDisconnected(String str) throws RemoteException {
            this.zzbwV.zza(new C10732(this, str));
        }

        public void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException {
            this.zzbwV.zza(new C10721(this, str, bArr, z));
        }
    }

    private static final class zza extends zzb {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;

        public zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzlH(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static class zzc extends zzavi {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaUb;

        zzc(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaUb = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzlI(int i) throws RemoteException {
            this.zzaUb.setResult(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;
        private final zzaaz<ConnectionResponseCallback> zzbwZ;

        /* renamed from: com.google.android.gms.internal.zzavj.zzd.1 */
        class C10741 implements com.google.android.gms.internal.zzaaz.zzc<ConnectionResponseCallback> {
            final /* synthetic */ int zzavo;
            final /* synthetic */ String zzbwW;
            final /* synthetic */ byte[] zzbwX;

            C10741(zzd com_google_android_gms_internal_zzavj_zzd, String str, int i, byte[] bArr) {
                this.zzbwW = str;
                this.zzavo = i;
                this.zzbwX = bArr;
            }

            public void zza(ConnectionResponseCallback connectionResponseCallback) {
                connectionResponseCallback.onConnectionResponse(this.zzbwW, new Status(this.zzavo), this.zzbwX);
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((ConnectionResponseCallback) obj);
            }

            public void zzvy() {
            }
        }

        public zzd(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<ConnectionResponseCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
            this.zzbwZ = (zzaaz) zzac.zzw(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback);
        }

        public void zza(String str, int i, byte[] bArr) throws RemoteException {
            this.zzbwZ.zza(new C10741(this, str, i, bArr));
        }

        public void zzlG(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static final class zze extends zzavi {
        private final zzaaz<ConnectionRequestListener> zzaBG;
        private final com.google.android.gms.internal.zzzv.zzb<StartAdvertisingResult> zzaFq;

        /* renamed from: com.google.android.gms.internal.zzavj.zze.1 */
        class C10751 implements com.google.android.gms.internal.zzaaz.zzc<ConnectionRequestListener> {
            final /* synthetic */ String zzbwW;
            final /* synthetic */ byte[] zzbwX;
            final /* synthetic */ String zzbxa;
            final /* synthetic */ String zzbxb;

            C10751(zze com_google_android_gms_internal_zzavj_zze, String str, String str2, String str3, byte[] bArr) {
                this.zzbwW = str;
                this.zzbxa = str2;
                this.zzbxb = str3;
                this.zzbwX = bArr;
            }

            public void zza(ConnectionRequestListener connectionRequestListener) {
                connectionRequestListener.onConnectionRequest(this.zzbwW, this.zzbxa, this.zzbxb, this.zzbwX);
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((ConnectionRequestListener) obj);
            }

            public void zzvy() {
            }
        }

        zze(com.google.android.gms.internal.zzzv.zzb<StartAdvertisingResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, zzaaz<ConnectionRequestListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult);
            this.zzaBG = (zzaaz) zzac.zzw(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener);
        }

        public void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            this.zzaBG.zza(new C10751(this, str, str2, str3, bArr));
        }

        public void zzo(int i, String str) throws RemoteException {
            this.zzaFq.setResult(new zzf(new Status(i), str));
        }
    }

    private static final class zzf implements StartAdvertisingResult {
        private final Status zzahq;
        private final String zzbxc;

        zzf(Status status, String str) {
            this.zzahq = status;
            this.zzbxc = str;
        }

        public String getLocalEndpointName() {
            return this.zzbxc;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class zzg extends zzavi {
        private final zzaaz<EndpointDiscoveryListener> zzaBG;
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;

        /* renamed from: com.google.android.gms.internal.zzavj.zzg.1 */
        class C10761 implements com.google.android.gms.internal.zzaaz.zzc<EndpointDiscoveryListener> {
            final /* synthetic */ String val$name;
            final /* synthetic */ String zzbxd;
            final /* synthetic */ String zzbxe;
            final /* synthetic */ String zzbxf;

            C10761(zzg com_google_android_gms_internal_zzavj_zzg, String str, String str2, String str3, String str4) {
                this.zzbxd = str;
                this.zzbxe = str2;
                this.zzbxf = str3;
                this.val$name = str4;
            }

            public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                endpointDiscoveryListener.onEndpointFound(this.zzbxd, this.zzbxe, this.zzbxf, this.val$name);
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((EndpointDiscoveryListener) obj);
            }

            public void zzvy() {
            }
        }

        /* renamed from: com.google.android.gms.internal.zzavj.zzg.2 */
        class C10772 implements com.google.android.gms.internal.zzaaz.zzc<EndpointDiscoveryListener> {
            final /* synthetic */ String zzbxd;

            C10772(zzg com_google_android_gms_internal_zzavj_zzg, String str) {
                this.zzbxd = str;
            }

            public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                endpointDiscoveryListener.onEndpointLost(this.zzbxd);
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((EndpointDiscoveryListener) obj);
            }

            public void zzvy() {
            }
        }

        zzg(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<EndpointDiscoveryListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
            this.zzaBG = (zzaaz) zzac.zzw(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener);
        }

        public void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException {
            this.zzaBG.zza(new C10761(this, str, str2, str3, str4));
        }

        public void onEndpointLost(String str) throws RemoteException {
            this.zzaBG.zza(new C10772(this, str));
        }

        public void zzlF(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }

    public zzavj(Context context, Looper looper, com.google.android.gms.common.internal.zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzaYW = (long) hashCode();
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzavm) zzwW()).zzM(this.zzaYW);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public String zzMT() {
        try {
            return ((zzavm) zzwW()).zzat(this.zzaYW);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzMU() {
        try {
            return ((zzavm) zzwW()).zzMU();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzMV() {
        try {
            ((zzavm) zzwW()).zzar(this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzMW() {
        try {
            ((zzavm) zzwW()).zzas(this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str, long j, zzaaz<EndpointDiscoveryListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zzg(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener), str, j, this.zzaYW);
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<StartAdvertisingResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, String str, AppMetadata appMetadata, long j, zzaaz<ConnectionRequestListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zze(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener), str, appMetadata, j, this.zzaYW);
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str, String str2, byte[] bArr, zzaaz<ConnectionResponseCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zzd(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener), str, str2, bArr, this.zzaYW);
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str, byte[] bArr, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zza(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener), str, bArr, this.zzaYW);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzavm) zzwW()).zza(strArr, bArr, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzavm) zzwW()).zzb(strArr, bArr, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    protected String zzeu() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    protected zzavm zzez(IBinder iBinder) {
        return com.google.android.gms.internal.zzavm.zza.zzeB(iBinder);
    }

    public void zzgn(String str) {
        try {
            ((zzavm) zzwW()).zzk(str, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzgo(String str) {
        try {
            ((zzavm) zzwW()).zzl(str, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzez(iBinder);
    }

    protected Bundle zzql() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.zzaYW);
        return bundle;
    }

    public void zzt(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((zzavm) zzwW()).zza(new zzc(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), str, this.zzaYW);
    }
}
