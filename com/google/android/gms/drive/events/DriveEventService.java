package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.internal.zzahp;
import com.google.android.gms.internal.zzajc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzd, zzt {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzaDw;
    private CountDownLatch zzaKu;
    zza zzaKv;
    boolean zzaKw;

    /* renamed from: com.google.android.gms.drive.events.DriveEventService.1 */
    class C06471 extends Thread {
        final /* synthetic */ CountDownLatch zzaKx;
        final /* synthetic */ DriveEventService zzaKy;

        C06471(DriveEventService driveEventService, CountDownLatch countDownLatch) {
            this.zzaKy = driveEventService;
            this.zzaKx = countDownLatch;
        }

        public void run() {
            try {
                Looper.prepare();
                this.zzaKy.zzaKv = new zza(this.zzaKy);
                this.zzaKy.zzaKw = false;
                this.zzaKx.countDown();
                zzahp.zzD("DriveEventService", "Bound and starting loop");
                Looper.loop();
                zzahp.zzD("DriveEventService", "Finished loop");
                if (this.zzaKy.zzaKu != null) {
                    this.zzaKy.zzaKu.countDown();
                }
            } catch (Throwable th) {
                if (this.zzaKy.zzaKu != null) {
                    this.zzaKy.zzaKu.countDown();
                }
            }
        }
    }

    final class zza extends Handler {
        final /* synthetic */ DriveEventService zzaKy;

        zza(DriveEventService driveEventService) {
            this.zzaKy = driveEventService;
        }

        private Message zzAa() {
            return obtainMessage(2);
        }

        private Message zzb(zzajc com_google_android_gms_internal_zzajc) {
            return obtainMessage(1, com_google_android_gms_internal_zzajc);
        }

        public void handleMessage(Message message) {
            zzahp.zzD("DriveEventService", "handleMessage message type:" + message.what);
            switch (message.what) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    this.zzaKy.zza((zzajc) message.obj);
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    getLooper().quit();
                default:
                    zzahp.zzE("DriveEventService", "Unexpected message type:" + message.what);
            }
        }
    }

    final class zzb extends com.google.android.gms.internal.zzaim.zza {
        final /* synthetic */ DriveEventService zzaKy;

        zzb(DriveEventService driveEventService) {
            this.zzaKy = driveEventService;
        }

        public void zzc(zzajc com_google_android_gms_internal_zzajc) throws RemoteException {
            synchronized (this.zzaKy) {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzajc);
                zzahp.zzD("DriveEventService", new StringBuilder(String.valueOf(valueOf).length() + 9).append("onEvent: ").append(valueOf).toString());
                this.zzaKy.zzzZ();
                if (this.zzaKy.zzaKv != null) {
                    this.zzaKy.zzaKv.sendMessage(this.zzaKy.zzaKv.zzb(com_google_android_gms_internal_zzajc));
                } else {
                    zzahp.zzF("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String str) {
        this.zzaKw = false;
        this.zzaDw = -1;
        this.mName = str;
    }

    private void zza(zzajc com_google_android_gms_internal_zzajc) {
        String valueOf;
        DriveEvent zzAt = com_google_android_gms_internal_zzajc.zzAt();
        String valueOf2 = String.valueOf(zzAt);
        zzahp.zzD("DriveEventService", new StringBuilder(String.valueOf(valueOf2).length() + 20).append("handleEventMessage: ").append(valueOf2).toString());
        try {
            switch (zzAt.getType()) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    onChange((ChangeEvent) zzAt);
                    return;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    onCompletion((CompletionEvent) zzAt);
                    return;
                case Dimension.UNIT_IN /*4*/:
                    zza((zzb) zzAt);
                    return;
                case BuyButtonText.DONATE_WITH /*7*/:
                    zza((zzr) zzAt);
                    return;
                default:
                    String str = this.mName;
                    valueOf2 = String.valueOf(zzAt);
                    zzahp.zzE(str, new StringBuilder(String.valueOf(valueOf2).length() + 17).append("Unhandled event: ").append(valueOf2).toString());
                    return;
            }
        } catch (Throwable e) {
            valueOf2 = this.mName;
            valueOf = String.valueOf(zzAt);
            zzahp.zza(valueOf2, e, new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error handling event: ").append(valueOf).toString());
        }
        valueOf2 = this.mName;
        valueOf = String.valueOf(zzAt);
        zzahp.zza(valueOf2, e, new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error handling event: ").append(valueOf).toString());
    }

    private void zzzZ() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzaDw) {
            if (zzx.zzf(this, callingUid)) {
                this.zzaDw = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzaKv == null && !this.zzaKw) {
                this.zzaKw = true;
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzaKu = new CountDownLatch(1);
                new C06471(this, countDownLatch).start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        zzahp.zzF("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new zzb(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent changeEvent) {
        String str = this.mName;
        String valueOf = String.valueOf(changeEvent);
        zzahp.zzE(str, new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unhandled change event: ").append(valueOf).toString());
    }

    public void onCompletion(CompletionEvent completionEvent) {
        String str = this.mName;
        String valueOf = String.valueOf(completionEvent);
        zzahp.zzE(str, new StringBuilder(String.valueOf(valueOf).length() + 28).append("Unhandled completion event: ").append(valueOf).toString());
    }

    public synchronized void onDestroy() {
        zzahp.zzD("DriveEventService", "onDestroy");
        if (this.zzaKv != null) {
            this.zzaKv.sendMessage(this.zzaKv.zzAa());
            this.zzaKv = null;
            try {
                if (!this.zzaKu.await(5000, TimeUnit.MILLISECONDS)) {
                    zzahp.zzE("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzaKu = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public void zza(zzb com_google_android_gms_drive_events_zzb) {
        String str = this.mName;
        String valueOf = String.valueOf(com_google_android_gms_drive_events_zzb);
        zzahp.zzE(str, new StringBuilder(String.valueOf(valueOf).length() + 35).append("Unhandled changes available event: ").append(valueOf).toString());
    }

    public void zza(zzr com_google_android_gms_drive_events_zzr) {
        String str = this.mName;
        String valueOf = String.valueOf(com_google_android_gms_drive_events_zzr);
        zzahp.zzE(str, new StringBuilder(String.valueOf(valueOf).length() + 32).append("Unhandled transfer state event: ").append(valueOf).toString());
    }
}
