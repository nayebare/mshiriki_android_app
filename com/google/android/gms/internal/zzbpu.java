package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.games.request.GameRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class zzbpu {
    private final Random zzcbl;
    private final Thread zzchS;
    private zzbpo zzcij;
    private volatile boolean zzcim;
    private BlockingQueue<ByteBuffer> zzcin;
    private boolean zzcio;
    private WritableByteChannel zzcip;

    /* renamed from: com.google.android.gms.internal.zzbpu.1 */
    class C12821 implements Runnable {
        final /* synthetic */ zzbpu zzciq;

        C12821(zzbpu com_google_android_gms_internal_zzbpu) {
            this.zzciq = com_google_android_gms_internal_zzbpu;
        }

        public void run() {
            this.zzciq.zzZU();
        }
    }

    zzbpu(zzbpo com_google_android_gms_internal_zzbpo, String str, int i) {
        this.zzcbl = new Random();
        this.zzcim = false;
        this.zzcio = false;
        this.zzchS = zzbpo.getThreadFactory().newThread(new C12821(this));
        zzbpo.zzZG().zza(zzZN(), new StringBuilder(String.valueOf(str).length() + 18).append(str).append("Writer-").append(i).toString());
        this.zzcij = com_google_android_gms_internal_zzbpo;
        this.zzcin = new LinkedBlockingQueue();
    }

    private byte[] zzZR() {
        byte[] bArr = new byte[4];
        this.zzcbl.nextBytes(bArr);
        return bArr;
    }

    private void zzZS() throws InterruptedException, IOException {
        this.zzcip.write((ByteBuffer) this.zzcin.take());
    }

    private void zzZU() {
        while (!this.zzcim && !Thread.interrupted()) {
            try {
                zzZS();
            } catch (Throwable e) {
                zzc(new zzbpq("IO Exception", e));
                return;
            } catch (InterruptedException e2) {
                return;
            }
        }
        for (int i = 0; i < this.zzcin.size(); i++) {
            zzZS();
        }
    }

    private ByteBuffer zza(byte b, boolean z, byte[] bArr) throws IOException {
        int i = 2;
        if (z) {
            i = 6;
        }
        int length = bArr.length;
        if (length >= TransportMediator.KEYCODE_MEDIA_PLAY) {
            i = length <= GameRequest.TYPE_ALL ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i + bArr.length);
        allocate.put((byte) (b | -128));
        if (length < TransportMediator.KEYCODE_MEDIA_PLAY) {
            allocate.put((byte) (z ? length | Cast.MAX_NAMESPACE_LENGTH : length));
        } else if (length <= GameRequest.TYPE_ALL) {
            allocate.put((byte) (z ? 254 : TransportMediator.KEYCODE_MEDIA_PLAY));
            allocate.putShort((short) length);
        } else {
            i = TransportMediator.KEYCODE_MEDIA_PAUSE;
            if (z) {
                i = MotionEventCompat.ACTION_MASK;
            }
            allocate.put((byte) i);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] zzZR = zzZR();
            allocate.put(zzZR);
            for (i = 0; i < bArr.length; i++) {
                allocate.put((byte) (bArr[i] ^ zzZR[i % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private void zzc(zzbpq com_google_android_gms_internal_zzbpq) {
        this.zzcij.zzb(com_google_android_gms_internal_zzbpq);
    }

    Thread zzZN() {
        return this.zzchS;
    }

    void zzZT() {
        this.zzcim = true;
    }

    synchronized void zzb(byte b, boolean z, byte[] bArr) throws IOException {
        ByteBuffer zza = zza(b, z, bArr);
        if (!this.zzcim || (!this.zzcio && b == (byte) 8)) {
            if (b == (byte) 8) {
                this.zzcio = true;
            }
            this.zzcin.add(zza);
        } else {
            throw new zzbpq("Shouldn't be sending");
        }
    }

    void zzb(OutputStream outputStream) {
        this.zzcip = Channels.newChannel(outputStream);
    }
}
