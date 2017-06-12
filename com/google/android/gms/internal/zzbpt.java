package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.cast.Cast;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

class zzbpt {
    private zzbpp zzchN;
    private DataInputStream zzcii;
    private zzbpo zzcij;
    private byte[] zzcik;
    private zzb zzcil;
    private volatile boolean zzcim;

    zzbpt(zzbpo com_google_android_gms_internal_zzbpo) {
        this.zzcii = null;
        this.zzcij = null;
        this.zzchN = null;
        this.zzcik = new byte[C0308R.styleable.AppCompatTheme_spinnerStyle];
        this.zzcim = false;
        this.zzcij = com_google_android_gms_internal_zzbpo;
    }

    private int read(byte[] bArr, int i, int i2) throws IOException {
        this.zzcii.readFully(bArr, i, i2);
        return i2;
    }

    private void zzX(byte[] bArr) {
        if (bArr.length <= 125) {
            this.zzcij.zzW(bArr);
            return;
        }
        throw new zzbpq("PING frame too long");
    }

    private void zza(boolean z, byte b, byte[] bArr) {
        if (b == 9) {
            if (z) {
                zzX(bArr);
                return;
            }
            throw new zzbpq("PING must not fragment across frames");
        } else if (this.zzcil != null && b != null) {
            throw new zzbpq("Failed to continue outstanding frame");
        } else if (this.zzcil == null && b == null) {
            throw new zzbpq("Received continuing frame, but there's nothing to continue");
        } else {
            if (this.zzcil == null) {
                this.zzcil = zzbpm.zzb(b);
            }
            if (!this.zzcil.zzU(bArr)) {
                throw new zzbpq("Failed to decode frame");
            } else if (z) {
                zzbps zzZD = this.zzcil.zzZD();
                this.zzcil = null;
                this.zzchN.zza(zzZD);
            }
        }
    }

    private void zzc(zzbpq com_google_android_gms_internal_zzbpq) {
        zzZQ();
        this.zzcij.zzb(com_google_android_gms_internal_zzbpq);
    }

    private long zze(byte[] bArr, int i) {
        return (((((((((long) bArr[i + 0]) << 56) + (((long) (bArr[i + 1] & MotionEventCompat.ACTION_MASK)) << 48)) + (((long) (bArr[i + 2] & MotionEventCompat.ACTION_MASK)) << 40)) + (((long) (bArr[i + 3] & MotionEventCompat.ACTION_MASK)) << 32)) + (((long) (bArr[i + 4] & MotionEventCompat.ACTION_MASK)) << 24)) + ((long) ((bArr[i + 5] & MotionEventCompat.ACTION_MASK) << 16))) + ((long) ((bArr[i + 6] & MotionEventCompat.ACTION_MASK) << 8))) + ((long) ((bArr[i + 7] & MotionEventCompat.ACTION_MASK) << 0));
    }

    void run() {
        this.zzchN = this.zzcij.zzZH();
        while (!this.zzcim) {
            try {
                int read = read(this.zzcik, 0, 1) + 0;
                boolean z = (this.zzcik[0] & Cast.MAX_NAMESPACE_LENGTH) != 0;
                if (((this.zzcik[0] & C0308R.styleable.AppCompatTheme_spinnerStyle) != 0 ? 1 : null) != null) {
                    throw new zzbpq("Invalid frame received");
                }
                byte b = (byte) (this.zzcik[0] & 15);
                int read2 = read + read(this.zzcik, read, 1);
                byte b2 = this.zzcik[1];
                long j = 0;
                if (b2 < (byte) 126) {
                    j = (long) b2;
                } else if (b2 == (byte) 126) {
                    read(this.zzcik, read2, 2);
                    j = (long) (((this.zzcik[2] & MotionEventCompat.ACTION_MASK) << 8) | (this.zzcik[3] & MotionEventCompat.ACTION_MASK));
                } else if (b2 == 127) {
                    j = zze(this.zzcik, (read(this.zzcik, read2, 8) + read2) - 8);
                }
                byte[] bArr = new byte[((int) j)];
                read(bArr, 0, (int) j);
                if (b == 8) {
                    this.zzcij.zzZI();
                } else if (b == 10) {
                    continue;
                } else if (b == (byte) 1 || b == 2 || b == 9 || b == null) {
                    zza(z, b, bArr);
                } else {
                    throw new zzbpq("Unsupported opcode: " + b);
                }
            } catch (SocketTimeoutException e) {
            } catch (Throwable e2) {
                zzc(new zzbpq("IO Error", e2));
            } catch (zzbpq e3) {
                zzc(e3);
            }
        }
    }

    void zzZQ() {
        this.zzcim = true;
    }

    void zza(DataInputStream dataInputStream) {
        this.zzcii = dataInputStream;
    }
}
