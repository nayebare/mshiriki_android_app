package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.zzyi;
import com.google.android.gms.internal.zzyl;
import com.google.android.gms.internal.zzyv;
import com.google.android.gms.internal.zzyw;
import com.google.android.gms.internal.zzyx;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

@SuppressLint({"MissingRemoteException"})
public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final String NAMESPACE;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzyv zzanU;
    private final zza zzanV;
    private OnPreloadStatusUpdatedListener zzanW;
    private OnQueueStatusUpdatedListener zzanX;
    private OnMetadataUpdatedListener zzanY;
    private OnStatusUpdatedListener zzanZ;
    private final Object zzrN;

    static abstract class zzb extends zzyi<MediaChannelResult> {
        zzyx zzaoC;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.zzb.1 */
        class C05981 implements zzyx {
            final /* synthetic */ zzb zzaoD;

            C05981(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.zzaoD = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public void zzC(long j) {
                this.zzaoD.zzb((MediaChannelResult) this.zzaoD.zzc(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }

            public void zza(long j, int i, Object obj) {
                this.zzaoD.zzb(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.zzb.2 */
        class C05992 implements MediaChannelResult {
            final /* synthetic */ Status zzamf;

            C05992(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb, Status status) {
                this.zzamf = status;
            }

            public JSONObject getCustomData() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaoC = new C05981(this);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzq(status);
        }

        public MediaChannelResult zzq(Status status) {
            return new C05992(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.10 */
    class AnonymousClass10 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;

        AnonymousClass10(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, RemoteMediaPlayer.STATUS_SUCCEEDED, -1, null, -1, null, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.11 */
    class AnonymousClass11 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;

        AnonymousClass11(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, RemoteMediaPlayer.STATUS_SUCCEEDED, -1, null, RemoteMediaPlayer.RESUME_STATE_PLAY, null, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.12 */
    class AnonymousClass12 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ MediaInfo zzaop;
        final /* synthetic */ boolean zzaoq;
        final /* synthetic */ long[] zzaor;

        AnonymousClass12(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaop = mediaInfo;
            this.zzaoq = z;
            this.zzaoh = j;
            this.zzaor = jArr;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaop, this.zzaoq, this.zzaoh, this.zzaor, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzaoa.zzanV.zzc(null);
                } catch (Throwable th) {
                    this.zzaoa.zzanV.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.13 */
    class AnonymousClass13 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ int zzaog;
        final /* synthetic */ JSONObject zzaoi;

        AnonymousClass13(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int i, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaog = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, RemoteMediaPlayer.STATUS_SUCCEEDED, -1, null, RemoteMediaPlayer.STATUS_SUCCEEDED, Integer.valueOf(this.zzaog), this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.14 */
    class AnonymousClass14 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaos;

        AnonymousClass14(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaos = i;
            this.zzaob = googleApiClient2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                if (this.zzaoa.zzbR(this.zzaos) == -1) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                    return;
                }
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    zzyv zzg = this.zzaoa.zzanU;
                    zzyx com_google_android_gms_internal_zzyx = this.zzaoC;
                    int[] iArr = new int[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    iArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzaos;
                    zzg.zza(com_google_android_gms_internal_zzyx, iArr, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.15 */
    class AnonymousClass15 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaos;

        AnonymousClass15(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, GoogleApiClient googleApiClient2, long j, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaos = i;
            this.zzaob = googleApiClient2;
            this.zzaoh = j;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                if (this.zzaoa.zzbR(this.zzaos) == -1) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                    return;
                }
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaos, this.zzaoh, null, RemoteMediaPlayer.STATUS_SUCCEEDED, null, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.16 */
    class AnonymousClass16 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaos;
        final /* synthetic */ int zzaot;

        AnonymousClass16(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, int i2, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaos = i;
            this.zzaot = i2;
            this.zzaob = googleApiClient2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            int i = RemoteMediaPlayer.STATUS_SUCCEEDED;
            synchronized (this.zzaoa.zzrN) {
                int zza = this.zzaoa.zzbR(this.zzaos);
                if (zza == -1) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                } else if (this.zzaot < 0) {
                    Object[] objArr = new Object[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    objArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = Integer.valueOf(this.zzaot);
                    zzb((MediaChannelResult) zzc(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", objArr))));
                } else if (zza == this.zzaot) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                } else {
                    MediaQueueItem queueItem = this.zzaoa.getMediaStatus().getQueueItem(this.zzaot > zza ? this.zzaot + RemoteMediaPlayer.RESUME_STATE_PLAY : this.zzaot);
                    if (queueItem != null) {
                        i = queueItem.getItemId();
                    }
                    this.zzaoa.zzanV.zzc(this.zzaob);
                    try {
                        zzyv zzg = this.zzaoa.zzanU;
                        zzyx com_google_android_gms_internal_zzyx = this.zzaoC;
                        int[] iArr = new int[RemoteMediaPlayer.RESUME_STATE_PLAY];
                        iArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzaos;
                        zzg.zza(com_google_android_gms_internal_zzyx, iArr, i, this.zzaoi);
                        this.zzaoa.zzanV.zzc(null);
                    } catch (IOException e) {
                        try {
                            zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        } finally {
                            this.zzaoa.zzanV.zzc(null);
                        }
                    } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.17 */
    class AnonymousClass17 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;

        AnonymousClass17(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.18 */
    class AnonymousClass18 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;

        AnonymousClass18(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zzb(this.zzaoC, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.19 */
    class AnonymousClass19 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;

        AnonymousClass19(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zzc(this.zzaoC, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C05891 implements com.google.android.gms.internal.zzyv.zza {
        final /* synthetic */ RemoteMediaPlayer zzaoa;

        C05891(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzaoa = remoteMediaPlayer;
        }

        public void onAdBreakStatusUpdated() {
        }

        public void onMetadataUpdated() {
            this.zzaoa.onMetadataUpdated();
        }

        public void onPreloadStatusUpdated() {
            this.zzaoa.onPreloadStatusUpdated();
        }

        public void onQueueStatusUpdated() {
            this.zzaoa.onQueueStatusUpdated();
        }

        public void onStatusUpdated() {
            this.zzaoa.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.20 */
    class AnonymousClass20 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ long zzaou;
        final /* synthetic */ int zzaov;

        AnonymousClass20(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long j, int i, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaou = j;
            this.zzaov = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaou, this.zzaov, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.21 */
    class AnonymousClass21 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ double zzaow;

        AnonymousClass21(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, double d, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaow = d;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaow, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IllegalArgumentException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (IOException e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e3) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.22 */
    class AnonymousClass22 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ boolean zzaox;

        AnonymousClass22(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, boolean z, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaox = z;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaox, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.23 */
    class AnonymousClass23 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;

        AnonymousClass23(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzaoa.zzanV.zzc(null);
                } catch (Throwable th) {
                    this.zzaoa.zzanV.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C05902 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ long[] zzaoc;

        C05902(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long[] jArr) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoc = jArr;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaoc);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C05913 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ TextTrackStyle zzaod;

        C05913(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, TextTrackStyle textTrackStyle) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaod = textTrackStyle;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaod);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C05924 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ MediaQueueItem[] zzaoe;
        final /* synthetic */ int zzaof;
        final /* synthetic */ int zzaog;
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;

        C05924(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoe = mediaQueueItemArr;
            this.zzaof = i;
            this.zzaog = i2;
            this.zzaoh = j;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaoe, this.zzaof, this.zzaog, this.zzaoh, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzaoa.zzanV.zzc(null);
                } catch (Throwable th) {
                    this.zzaoa.zzanV.zzc(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C05935 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ MediaQueueItem[] zzaoj;
        final /* synthetic */ int zzaok;

        C05935(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoj = mediaQueueItemArr;
            this.zzaok = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaoj, this.zzaok, RemoteMediaPlayer.STATUS_SUCCEEDED, -1, -1, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C05946 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaok;
        final /* synthetic */ MediaQueueItem zzaol;

        C05946(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaol = mediaQueueItem;
            this.zzaok = i;
            this.zzaoh = j;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    zzyv zzg = this.zzaoa.zzanU;
                    zzyx com_google_android_gms_internal_zzyx = this.zzaoC;
                    MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    mediaQueueItemArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzaol;
                    zzg.zza(com_google_android_gms_internal_zzyx, mediaQueueItemArr, this.zzaok, RemoteMediaPlayer.STATUS_SUCCEEDED, RemoteMediaPlayer.STATUS_SUCCEEDED, this.zzaoh, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C05957 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ MediaQueueItem[] zzaom;

        C05957(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaom = mediaQueueItemArr;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, RemoteMediaPlayer.STATUS_SUCCEEDED, -1, this.zzaom, RemoteMediaPlayer.STATUS_SUCCEEDED, null, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C05968 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int[] zzaon;

        C05968(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int[] iArr, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaon = iArr;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaon, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C05979 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        final /* synthetic */ GoogleApiClient zzaob;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaok;
        final /* synthetic */ int[] zzaoo;

        C05979(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int[] iArr, int i, JSONObject jSONObject) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaob = googleApiClient2;
            this.zzaoo = iArr;
            this.zzaok = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzaoa.zzrN) {
                this.zzaoa.zzanV.zzc(this.zzaob);
                try {
                    this.zzaoa.zzanU.zza(this.zzaoC, this.zzaoo, this.zzaok, this.zzaoi);
                    this.zzaoa.zzanV.zzc(null);
                } catch (IOException e) {
                    try {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzaoa.zzanV.zzc(null);
                    }
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                }
            }
        }
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    private class zza implements zzyw {
        final /* synthetic */ RemoteMediaPlayer zzaoa;
        private GoogleApiClient zzaoy;
        private long zzaoz;

        private final class zza implements ResultCallback<Status> {
            private final long zzaoA;
            final /* synthetic */ zza zzaoB;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.zzaoB = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.zzaoA = j;
            }

            public /* synthetic */ void onResult(@NonNull Result result) {
                zzp((Status) result);
            }

            public void zzp(@NonNull Status status) {
                if (!status.isSuccess()) {
                    this.zzaoB.zzaoa.zzanU.zzb(this.zzaoA, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzaoa = remoteMediaPlayer;
            this.zzaoz = 0;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaoy == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzaoy, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzc(GoogleApiClient googleApiClient) {
            this.zzaoy = googleApiClient;
        }

        public long zzsc() {
            long j = this.zzaoz + 1;
            this.zzaoz = j;
            return j;
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzahq;
        private final JSONObject zzalI;

        zzc(Status status, JSONObject jSONObject) {
            this.zzahq = status;
            this.zzalI = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzalI;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static {
        NAMESPACE = zzyv.NAMESPACE;
    }

    public RemoteMediaPlayer() {
        this(new zzyv(null));
    }

    RemoteMediaPlayer(zzyv com_google_android_gms_internal_zzyv) {
        this.zzrN = new Object();
        this.zzanU = com_google_android_gms_internal_zzyv;
        this.zzanU.zza(new C05891(this));
        this.zzanV = new zza(this);
        this.zzanU.zza(this.zzanV);
    }

    private void onMetadataUpdated() {
        if (this.zzanY != null) {
            this.zzanY.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated() {
        if (this.zzanW != null) {
            this.zzanW.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated() {
        if (this.zzanX != null) {
            this.zzanX.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzanZ != null) {
            this.zzanZ.onStatusUpdated();
        }
    }

    private int zzbR(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = STATUS_SUCCEEDED; i2 < mediaStatus.getQueueItemCount(); i2 += RESUME_STATE_PLAY) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzrN) {
            approximateStreamPosition = this.zzanU.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzrN) {
            mediaInfo = this.zzanU.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzrN) {
            mediaStatus = this.zzanU.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzanU.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzrN) {
            streamDuration = this.zzanU.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z) {
        return load(googleApiClient, mediaInfo, z, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j) {
        return load(googleApiClient, mediaInfo, z, j, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z, j, null, jSONObject);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass12(this, googleApiClient, googleApiClient, mediaInfo, z, j, jArr, jSONObject));
    }

    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzanU.zzcO(str2);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient) {
        return pause(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass17(this, googleApiClient, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient) {
        return play(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass19(this, googleApiClient, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, JSONObject jSONObject) throws IllegalArgumentException {
        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[RESUME_STATE_PLAY];
        mediaQueueItemArr[STATUS_SUCCEEDED] = mediaQueueItem;
        return queueInsertItems(googleApiClient, mediaQueueItemArr, STATUS_SUCCEEDED, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
        return googleApiClient.zzb(new C05946(this, googleApiClient, googleApiClient, mediaQueueItem, i, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, JSONObject jSONObject) {
        return queueInsertAndPlayItem(googleApiClient, mediaQueueItem, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new C05935(this, googleApiClient, googleApiClient, mediaQueueItemArr, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient googleApiClient, int i, long j, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass15(this, googleApiClient, i, googleApiClient, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return queueJumpToItem(googleApiClient, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new C05924(this, googleApiClient, googleApiClient, mediaQueueItemArr, i, i2, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IllegalArgumentException {
        return queueLoad(googleApiClient, mediaQueueItemArr, i, i2, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient googleApiClient, int i, int i2, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass16(this, googleApiClient, i, i2, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueNext(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass11(this, googleApiClient, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queuePrev(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass10(this, googleApiClient, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass14(this, googleApiClient, i, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient googleApiClient, int[] iArr, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new C05968(this, googleApiClient, googleApiClient, iArr, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient googleApiClient, int[] iArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new C05979(this, googleApiClient, googleApiClient, iArr, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass13(this, googleApiClient, googleApiClient, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        return googleApiClient.zzb(new C05957(this, googleApiClient, googleApiClient, mediaQueueItemArr, jSONObject));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new AnonymousClass23(this, googleApiClient, googleApiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j) {
        return seek(googleApiClient, j, STATUS_SUCCEEDED, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i) {
        return seek(googleApiClient, j, i, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass20(this, googleApiClient, googleApiClient, j, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(GoogleApiClient googleApiClient, long[] jArr) {
        if (jArr != null) {
            return googleApiClient.zzb(new C05902(this, googleApiClient, googleApiClient, jArr));
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.zzanY = onMetadataUpdatedListener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener) {
        this.zzanW = onPreloadStatusUpdatedListener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onQueueStatusUpdatedListener) {
        this.zzanX = onQueueStatusUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.zzanZ = onStatusUpdatedListener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z) {
        return setStreamMute(googleApiClient, z, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass22(this, googleApiClient, googleApiClient, z, jSONObject));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d) throws IllegalArgumentException {
        return setStreamVolume(googleApiClient, d, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d, JSONObject jSONObject) throws IllegalArgumentException {
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return googleApiClient.zzb(new AnonymousClass21(this, googleApiClient, googleApiClient, d, jSONObject));
        }
        throw new IllegalArgumentException("Volume cannot be " + d);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(GoogleApiClient googleApiClient, TextTrackStyle textTrackStyle) {
        if (textTrackStyle != null) {
            return googleApiClient.zzb(new C05913(this, googleApiClient, googleApiClient, textTrackStyle));
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient) {
        return stop(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.zzb(new AnonymousClass18(this, googleApiClient, googleApiClient, jSONObject));
    }
}
