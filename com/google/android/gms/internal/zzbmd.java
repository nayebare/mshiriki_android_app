package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboq.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger.Level;

public class zzbmd extends zzbmc {

    /* renamed from: com.google.android.gms.internal.zzbmd.1 */
    static /* synthetic */ class C12111 {
        static final /* synthetic */ int[] zzcbS;

        static {
            zzcbS = new int[Level.values().length];
            try {
                zzcbS[Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzcbS[Level.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzcbS[Level.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzcbS[Level.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzcbS[Level.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public synchronized void setLogLevel(Level level) {
        zzWN();
        switch (C12111.zzcbS[level.ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
                this.zzcbO = zza.DEBUG;
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                this.zzcbO = zza.INFO;
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                this.zzcbO = zza.WARN;
                break;
            case Dimension.UNIT_IN /*4*/:
                this.zzcbO = zza.ERROR;
                break;
            case Dimension.UNIT_MM /*5*/:
                this.zzcbO = zza.NONE;
                break;
            default:
                String valueOf = String.valueOf(level);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown log level: ").append(valueOf).toString());
        }
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        zzWN();
        this.zzbZx = z;
    }

    public synchronized void zzf(FirebaseApp firebaseApp) {
        this.zzbYm = firebaseApp;
    }

    public synchronized void zziZ(String str) {
        zzWN();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.zzcbN = str;
    }
}
