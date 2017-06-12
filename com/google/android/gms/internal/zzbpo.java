package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.lang.Thread.State;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.protocol.HTTP;

public class zzbpo {
    private static final AtomicInteger zzchJ;
    private static final Charset zzchK;
    private static ThreadFactory zzchT;
    private static zzbpn zzchU;
    private final int zzayy;
    private volatile zza zzchL;
    private volatile Socket zzchM;
    private zzbpp zzchN;
    private final URI zzchO;
    private final zzbpt zzchP;
    private final zzbpu zzchQ;
    private final zzbpr zzchR;
    private final Thread zzchS;

    /* renamed from: com.google.android.gms.internal.zzbpo.1 */
    class C12791 implements zzbpn {
        C12791() {
        }

        public void zza(Thread thread, String str) {
            thread.setName(str);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbpo.2 */
    class C12802 implements Runnable {
        final /* synthetic */ zzbpo zzchV;

        C12802(zzbpo com_google_android_gms_internal_zzbpo) {
            this.zzchV = com_google_android_gms_internal_zzbpo;
        }

        public void run() {
            this.zzchV.zzZM();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbpo.3 */
    static /* synthetic */ class C12813 {
        static final /* synthetic */ int[] zzchW;

        static {
            zzchW = new int[zza.values().length];
            try {
                zzchW[zza.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzchW[zza.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzchW[zza.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzchW[zza.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzchW[zza.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private enum zza {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    static {
        zzchJ = new AtomicInteger(0);
        zzchK = Charset.forName(HTTP.UTF_8);
        zzchT = Executors.defaultThreadFactory();
        zzchU = new C12791();
    }

    public zzbpo(URI uri, String str, Map<String, String> map) {
        this.zzchL = zza.NONE;
        this.zzchM = null;
        this.zzchN = null;
        this.zzayy = zzchJ.incrementAndGet();
        this.zzchS = getThreadFactory().newThread(new C12802(this));
        this.zzchO = uri;
        this.zzchR = new zzbpr(uri, str, map);
        this.zzchP = new zzbpt(this);
        this.zzchQ = new zzbpu(this, "TubeSock", this.zzayy);
    }

    private Socket createSocket() {
        Throwable th;
        String str;
        String valueOf;
        String scheme = this.zzchO.getScheme();
        String host = this.zzchO.getHost();
        int port = this.zzchO.getPort();
        if (scheme != null && scheme.equals("ws")) {
            try {
                return new Socket(host, port == -1 ? 80 : port);
            } catch (Throwable e) {
                th = e;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new zzbpq(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            } catch (Throwable e2) {
                host = String.valueOf(this.zzchO);
                throw new zzbpq(new StringBuilder(String.valueOf(host).length() + 31).append("error while creating socket to ").append(host).toString(), e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            String str2 = "unsupported protocol: ";
            valueOf = String.valueOf(scheme);
            throw new zzbpq(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            if (port == -1) {
                port = 443;
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                scheme = String.valueOf(this.zzchO);
                throw new zzbpq(new StringBuilder(String.valueOf(scheme).length() + 39).append("Error while verifying secure socket to ").append(scheme).toString());
            } catch (Throwable e22) {
                th = e22;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new zzbpq(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            } catch (Throwable e222) {
                host = String.valueOf(this.zzchO);
                throw new zzbpq(new StringBuilder(String.valueOf(host).length() + 38).append("error while creating secure socket to ").append(host).toString(), e222);
            }
        }
    }

    static ThreadFactory getThreadFactory() {
        return zzchT;
    }

    static zzbpn zzZG() {
        return zzchU;
    }

    private synchronized void zzZJ() {
        if (this.zzchL != zza.DISCONNECTED) {
            this.zzchP.zzZQ();
            this.zzchQ.zzZT();
            if (this.zzchM != null) {
                try {
                    this.zzchM.close();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            this.zzchL = zza.DISCONNECTED;
            this.zzchN.onClose();
        }
    }

    private void zzZK() {
        try {
            this.zzchL = zza.DISCONNECTING;
            this.zzchQ.zzZT();
            this.zzchQ.zzb((byte) 8, true, new byte[0]);
        } catch (Throwable e) {
            this.zzchN.zza(new zzbpq("Failed to send close frame", e));
        }
    }

    private void zzZM() {
        try {
            Socket createSocket = createSocket();
            synchronized (this) {
                this.zzchM = createSocket;
                if (this.zzchL == zza.DISCONNECTED) {
                    try {
                        this.zzchM.close();
                        this.zzchM = null;
                        close();
                        return;
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
                DataInputStream dataInputStream = new DataInputStream(createSocket.getInputStream());
                OutputStream outputStream = createSocket.getOutputStream();
                outputStream.write(this.zzchR.zzZO());
                byte[] bArr = new byte[CardNetwork.OTHER];
                ArrayList arrayList = new ArrayList();
                int i = 0;
                Object obj = null;
                while (obj == null) {
                    int read = dataInputStream.read();
                    if (read == -1) {
                        throw new zzbpq("Connection closed before handshake was complete");
                    }
                    bArr[i] = (byte) read;
                    i++;
                    String str;
                    if (bArr[i - 1] == 10 && bArr[i - 2] == 13) {
                        Object obj2;
                        str = new String(bArr, zzchK);
                        if (str.trim().equals(BuildConfig.FLAVOR)) {
                            obj2 = 1;
                        } else {
                            arrayList.add(str.trim());
                            obj2 = obj;
                        }
                        obj = obj2;
                        bArr = new byte[CardNetwork.OTHER];
                        i = 0;
                    } else if (i == CardNetwork.OTHER) {
                        str = new String(bArr, zzchK);
                        String str2 = "Unexpected long line in handshake: ";
                        str = String.valueOf(str);
                        throw new zzbpq(str.length() != 0 ? str2.concat(str) : new String(str2));
                    }
                }
                this.zzchR.zzjd((String) arrayList.get(0));
                arrayList.remove(0);
                HashMap hashMap = new HashMap();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String[] split = ((String) it.next()).split(": ", 2);
                    hashMap.put(split[0], split[1]);
                }
                this.zzchR.zzd(hashMap);
                this.zzchQ.zzb(outputStream);
                this.zzchP.zza(dataInputStream);
                this.zzchL = zza.CONNECTED;
                this.zzchQ.zzZN().start();
                this.zzchN.zzWt();
                this.zzchP.run();
                close();
                return;
            }
        } catch (zzbpq e2) {
            try {
                this.zzchN.zza(e2);
            } finally {
                close();
            }
        } catch (Throwable e3) {
            zzbpp com_google_android_gms_internal_zzbpp = this.zzchN;
            String str3 = "error while connecting: ";
            String valueOf = String.valueOf(e3.getMessage());
            com_google_android_gms_internal_zzbpp.zza(new zzbpq(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e3));
            close();
        }
    }

    private synchronized void zza(byte b, byte[] bArr) {
        if (this.zzchL != zza.CONNECTED) {
            this.zzchN.zza(new zzbpq("error while sending data: not connected"));
        } else {
            try {
                this.zzchQ.zzb(b, true, bArr);
            } catch (Throwable e) {
                this.zzchN.zza(new zzbpq("Failed to send frame", e));
                close();
            }
        }
    }

    public static void zza(ThreadFactory threadFactory, zzbpn com_google_android_gms_internal_zzbpn) {
        zzchT = threadFactory;
        zzchU = com_google_android_gms_internal_zzbpn;
    }

    public synchronized void close() {
        switch (C12813.zzchW[this.zzchL.ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
                this.zzchL = zza.DISCONNECTED;
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                zzZJ();
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                zzZK();
                break;
        }
    }

    public synchronized void connect() {
        if (this.zzchL != zza.NONE) {
            this.zzchN.zza(new zzbpq("connect() already called"));
            close();
        } else {
            zzbpn zzZG = zzZG();
            Thread zzZN = zzZN();
            String valueOf = String.valueOf("TubeSockReader-");
            zzZG.zza(zzZN, new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(this.zzayy).toString());
            this.zzchL = zza.CONNECTING;
            zzZN().start();
        }
    }

    synchronized void zzW(byte[] bArr) {
        zza((byte) 10, bArr);
    }

    zzbpp zzZH() {
        return this.zzchN;
    }

    void zzZI() {
        zzZJ();
    }

    public void zzZL() throws InterruptedException {
        if (this.zzchQ.zzZN().getState() != State.NEW) {
            this.zzchQ.zzZN().join();
        }
        zzZN().join();
    }

    Thread zzZN() {
        return this.zzchS;
    }

    public void zza(zzbpp com_google_android_gms_internal_zzbpp) {
        this.zzchN = com_google_android_gms_internal_zzbpp;
    }

    void zzb(zzbpq com_google_android_gms_internal_zzbpq) {
        this.zzchN.zza(com_google_android_gms_internal_zzbpq);
        if (this.zzchL == zza.CONNECTED) {
            close();
        }
        zzZJ();
    }

    public synchronized void zziT(String str) {
        zza((byte) 1, str.getBytes(zzchK));
    }
}
