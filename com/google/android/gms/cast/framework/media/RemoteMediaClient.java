package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.Cast.CastApi;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.zzyi;
import com.google.android.gms.internal.zzyl;
import com.google.android.gms.internal.zzyv;
import com.google.android.gms.internal.zzyw;
import com.google.android.gms.internal.zzyx;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class RemoteMediaClient implements MessageReceivedCallback {
    public static final String NAMESPACE;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    private final Handler mHandler;
    private final List<Listener> mListeners;
    private final zzyv zzanU;
    private final CastApi zzaph;
    private final Map<ProgressListener, zzd> zzarA;
    private final Map<Long, zzd> zzarB;
    private ParseAdsInfoCallback zzarC;
    private final zza zzary;
    private GoogleApiClient zzarz;
    private final Object zzrN;

    static abstract class zzb extends zzyi<MediaChannelResult> {
        zzyx zzaoC;

        /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.zzb.1 */
        class C06201 implements zzyx {
            final /* synthetic */ zzb zzarG;

            C06201(zzb com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb) {
                this.zzarG = com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb;
            }

            public void zzC(long j) {
                this.zzarG.zzb((MediaChannelResult) this.zzarG.zzc(new Status(RemoteMediaClient.STATUS_REPLACED)));
            }

            public void zza(long j, int i, Object obj) {
                this.zzarG.zzb(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }
        }

        /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.zzb.2 */
        class C06212 implements MediaChannelResult {
            final /* synthetic */ Status zzamf;

            C06212(zzb com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb, Status status) {
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
            this.zzaoC = new C06201(this);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzr(status);
        }

        public MediaChannelResult zzr(Status status) {
            return new C06212(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.10 */
    class AnonymousClass10 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass10(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, RemoteMediaClient.RESUME_STATE_UNCHANGED, -1, null, -1, null, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.11 */
    class AnonymousClass11 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass11(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, RemoteMediaClient.RESUME_STATE_UNCHANGED, -1, null, RemoteMediaClient.RESUME_STATE_PLAY, null, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.12 */
    class AnonymousClass12 extends zzb {
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ MediaInfo zzaop;
        final /* synthetic */ boolean zzaoq;
        final /* synthetic */ long[] zzaor;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass12(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaop = mediaInfo;
            this.zzaoq = z;
            this.zzaoh = j;
            this.zzaor = jArr;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaop, this.zzaoq, this.zzaoh, this.zzaor, this.zzaoi);
                } catch (IllegalStateException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (IOException e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.13 */
    class AnonymousClass13 extends zzb {
        final /* synthetic */ int zzaog;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass13(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaog = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, RemoteMediaClient.RESUME_STATE_UNCHANGED, -1, null, RemoteMediaClient.RESUME_STATE_UNCHANGED, Integer.valueOf(this.zzaog), this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.14 */
    class AnonymousClass14 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaos;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass14(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaos = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                if (this.zzarD.zzbR(this.zzaos) == -1) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.RESUME_STATE_UNCHANGED)));
                    return;
                }
                try {
                    zzyv zze = this.zzarD.zzanU;
                    zzyx com_google_android_gms_internal_zzyx = this.zzaoC;
                    int[] iArr = new int[RemoteMediaClient.RESUME_STATE_PLAY];
                    iArr[RemoteMediaClient.RESUME_STATE_UNCHANGED] = this.zzaos;
                    zze.zza(com_google_android_gms_internal_zzyx, iArr, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.15 */
    class AnonymousClass15 extends zzb {
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaos;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass15(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, int i, long j, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaos = i;
            this.zzaoh = j;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                if (this.zzarD.zzbR(this.zzaos) == -1) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.RESUME_STATE_UNCHANGED)));
                    return;
                }
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaos, this.zzaoh, null, RemoteMediaClient.RESUME_STATE_UNCHANGED, null, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.16 */
    class AnonymousClass16 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaos;
        final /* synthetic */ int zzaot;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass16(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, int i, int i2, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaos = i;
            this.zzaot = i2;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            int i = RemoteMediaClient.RESUME_STATE_UNCHANGED;
            synchronized (this.zzarD.zzrN) {
                int zza = this.zzarD.zzbR(this.zzaos);
                if (zza == -1) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.RESUME_STATE_UNCHANGED)));
                } else if (this.zzaot < 0) {
                    Object[] objArr = new Object[RemoteMediaClient.RESUME_STATE_PLAY];
                    objArr[RemoteMediaClient.RESUME_STATE_UNCHANGED] = Integer.valueOf(this.zzaot);
                    zzb((MediaChannelResult) zzc(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", objArr))));
                } else if (zza == this.zzaot) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.RESUME_STATE_UNCHANGED)));
                } else {
                    MediaQueueItem queueItem = this.zzarD.getMediaStatus().getQueueItem(this.zzaot > zza ? this.zzaot + RemoteMediaClient.RESUME_STATE_PLAY : this.zzaot);
                    if (queueItem != null) {
                        i = queueItem.getItemId();
                    }
                    try {
                        zzyv zze = this.zzarD.zzanU;
                        zzyx com_google_android_gms_internal_zzyx = this.zzaoC;
                        int[] iArr = new int[RemoteMediaClient.RESUME_STATE_PLAY];
                        iArr[RemoteMediaClient.RESUME_STATE_UNCHANGED] = this.zzaos;
                        zze.zza(com_google_android_gms_internal_zzyx, iArr, i, this.zzaoi);
                    } catch (IOException e) {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                    } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                        zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.17 */
    class AnonymousClass17 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass17(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.18 */
    class AnonymousClass18 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass18(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zzb(this.zzaoC, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.19 */
    class AnonymousClass19 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass19(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zzc(this.zzaoC, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.1 */
    class C06111 implements com.google.android.gms.internal.zzyv.zza {
        final /* synthetic */ RemoteMediaClient zzarD;

        C06111(RemoteMediaClient remoteMediaClient) {
            this.zzarD = remoteMediaClient;
        }

        private void zztj() {
            if (this.zzarD.zzarC != null) {
                MediaStatus mediaStatus = this.zzarD.getMediaStatus();
                if (mediaStatus != null) {
                    mediaStatus.zzak(this.zzarD.zzarC.parseIsPlayingAdFromMediaStatus(mediaStatus));
                    List parseAdBreaksFromMediaStatus = this.zzarD.zzarC.parseAdBreaksFromMediaStatus(mediaStatus);
                    MediaInfo mediaInfo = this.zzarD.getMediaInfo();
                    if (mediaInfo != null) {
                        mediaInfo.zzy(parseAdBreaksFromMediaStatus);
                    }
                }
            }
        }

        public void onAdBreakStatusUpdated() {
            for (Listener onAdBreakStatusUpdated : this.zzarD.mListeners) {
                onAdBreakStatusUpdated.onAdBreakStatusUpdated();
            }
        }

        public void onMetadataUpdated() {
            zztj();
            for (Listener onMetadataUpdated : this.zzarD.mListeners) {
                onMetadataUpdated.onMetadataUpdated();
            }
        }

        public void onPreloadStatusUpdated() {
            for (Listener onPreloadStatusUpdated : this.zzarD.mListeners) {
                onPreloadStatusUpdated.onPreloadStatusUpdated();
            }
        }

        public void onQueueStatusUpdated() {
            for (Listener onQueueStatusUpdated : this.zzarD.mListeners) {
                onQueueStatusUpdated.onQueueStatusUpdated();
            }
        }

        public void onStatusUpdated() {
            zztj();
            this.zzarD.zzti();
            for (Listener onStatusUpdated : this.zzarD.mListeners) {
                onStatusUpdated.onStatusUpdated();
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.20 */
    class AnonymousClass20 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ long zzaou;
        final /* synthetic */ int zzaov;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass20(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaou = j;
            this.zzaov = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaou, this.zzaov, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.21 */
    class AnonymousClass21 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ double zzaow;
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass21(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, double d, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaow = d;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaow, this.zzaoi);
                } catch (IllegalArgumentException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (IOException e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e3) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.22 */
    class AnonymousClass22 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;
        final /* synthetic */ boolean zzarE;

        AnonymousClass22(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzarE = z;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzarE, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.23 */
    class AnonymousClass23 extends zzb {
        final /* synthetic */ RemoteMediaClient zzarD;

        AnonymousClass23(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient) {
            this.zzarD = remoteMediaClient;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.2 */
    class C06122 extends zzb {
        final /* synthetic */ long[] zzaoc;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06122(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, long[] jArr) {
            this.zzarD = remoteMediaClient;
            this.zzaoc = jArr;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaoc);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.3 */
    class C06133 extends zzb {
        final /* synthetic */ TextTrackStyle zzaod;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06133(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, TextTrackStyle textTrackStyle) {
            this.zzarD = remoteMediaClient;
            this.zzaod = textTrackStyle;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaod);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.4 */
    class C06144 extends zzb {
        final /* synthetic */ MediaQueueItem[] zzaoe;
        final /* synthetic */ int zzaof;
        final /* synthetic */ int zzaog;
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06144(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoe = mediaQueueItemArr;
            this.zzaof = i;
            this.zzaog = i2;
            this.zzaoh = j;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaoe, this.zzaof, this.zzaog, this.zzaoh, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.5 */
    class C06155 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ MediaQueueItem[] zzaoj;
        final /* synthetic */ int zzaok;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06155(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoj = mediaQueueItemArr;
            this.zzaok = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaoj, this.zzaok, RemoteMediaClient.RESUME_STATE_UNCHANGED, -1, -1, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.6 */
    class C06166 extends zzb {
        final /* synthetic */ long zzaoh;
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaok;
        final /* synthetic */ MediaQueueItem zzaol;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06166(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaol = mediaQueueItem;
            this.zzaok = i;
            this.zzaoh = j;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    zzyv zze = this.zzarD.zzanU;
                    zzyx com_google_android_gms_internal_zzyx = this.zzaoC;
                    MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[RemoteMediaClient.RESUME_STATE_PLAY];
                    mediaQueueItemArr[RemoteMediaClient.RESUME_STATE_UNCHANGED] = this.zzaol;
                    zze.zza(com_google_android_gms_internal_zzyx, mediaQueueItemArr, this.zzaok, RemoteMediaClient.RESUME_STATE_UNCHANGED, RemoteMediaClient.RESUME_STATE_UNCHANGED, this.zzaoh, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.7 */
    class C06177 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ MediaQueueItem[] zzaom;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06177(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaom = mediaQueueItemArr;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, RemoteMediaClient.RESUME_STATE_UNCHANGED, -1, this.zzaom, RemoteMediaClient.RESUME_STATE_UNCHANGED, null, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.8 */
    class C06188 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int[] zzaon;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06188(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, int[] iArr, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaon = iArr;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaon, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.9 */
    class C06199 extends zzb {
        final /* synthetic */ JSONObject zzaoi;
        final /* synthetic */ int zzaok;
        final /* synthetic */ int[] zzaoo;
        final /* synthetic */ RemoteMediaClient zzarD;

        C06199(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, int[] iArr, int i, JSONObject jSONObject) {
            this.zzarD = remoteMediaClient;
            this.zzaoo = iArr;
            this.zzaok = i;
            this.zzaoi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zzyl com_google_android_gms_internal_zzyl) {
            synchronized (this.zzarD.zzrN) {
                try {
                    this.zzarD.zzanU.zza(this.zzaoC, this.zzaoo, this.zzaok, this.zzaoi);
                } catch (IOException e) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                } catch (com.google.android.gms.internal.zzyv.zzb e2) {
                    zzb((MediaChannelResult) zzc(new Status(RemoteMediaClient.STATUS_FAILED)));
                }
            }
        }
    }

    public interface Listener {
        void onAdBreakStatusUpdated();

        void onMetadataUpdated();

        void onPreloadStatusUpdated();

        void onQueueStatusUpdated();

        void onSendingRemoteMediaRequest();

        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface ParseAdsInfoCallback {
        List<AdBreakInfo> parseAdBreaksFromMediaStatus(MediaStatus mediaStatus);

        boolean parseIsPlayingAdFromMediaStatus(MediaStatus mediaStatus);
    }

    public interface ProgressListener {
        void onProgressUpdated(long j, long j2);
    }

    private class zza implements zzyw {
        private GoogleApiClient zzaoy;
        private long zzaoz;
        final /* synthetic */ RemoteMediaClient zzarD;

        private final class zza implements ResultCallback<Status> {
            private final long zzaoA;
            final /* synthetic */ zza zzarF;

            zza(zza com_google_android_gms_cast_framework_media_RemoteMediaClient_zza, long j) {
                this.zzarF = com_google_android_gms_cast_framework_media_RemoteMediaClient_zza;
                this.zzaoA = j;
            }

            public /* synthetic */ void onResult(@NonNull Result result) {
                zzp((Status) result);
            }

            public void zzp(@NonNull Status status) {
                if (!status.isSuccess()) {
                    this.zzarF.zzarD.zzanU.zzb(this.zzaoA, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaClient remoteMediaClient) {
            this.zzarD = remoteMediaClient;
            this.zzaoz = 0;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaoy == null) {
                throw new IOException("No GoogleApiClient available");
            }
            for (Listener onSendingRemoteMediaRequest : this.zzarD.mListeners) {
                onSendingRemoteMediaRequest.onSendingRemoteMediaRequest();
            }
            this.zzarD.zzaph.sendMessage(this.zzaoy, str, str2).setResultCallback(new zza(this, j));
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

    private class zzd {
        final /* synthetic */ RemoteMediaClient zzarD;
        private final Set<ProgressListener> zzarH;
        private final long zzarI;
        private final Runnable zzarJ;
        private boolean zzarK;

        /* renamed from: com.google.android.gms.cast.framework.media.RemoteMediaClient.zzd.1 */
        class C06221 extends TimerTask {
            final /* synthetic */ RemoteMediaClient zzarL;
            final /* synthetic */ zzd zzarM;

            C06221(zzd com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd, RemoteMediaClient remoteMediaClient) {
                this.zzarM = com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd;
                this.zzarL = remoteMediaClient;
            }

            public void run() {
                this.zzarM.zzarD.zza(this.zzarM.zzarH);
                this.zzarM.zzarD.mHandler.postDelayed(this, this.zzarM.zzarI);
            }
        }

        public zzd(RemoteMediaClient remoteMediaClient, long j) {
            this.zzarD = remoteMediaClient;
            this.zzarH = new HashSet();
            this.zzarI = j;
            this.zzarJ = new C06221(this, remoteMediaClient);
        }

        public boolean isStarted() {
            return this.zzarK;
        }

        public void start() {
            this.zzarD.mHandler.removeCallbacks(this.zzarJ);
            this.zzarK = true;
            this.zzarD.mHandler.postDelayed(this.zzarJ, this.zzarI);
        }

        public void stop() {
            this.zzarD.mHandler.removeCallbacks(this.zzarJ);
            this.zzarK = false;
        }

        public void zza(ProgressListener progressListener) {
            this.zzarH.add(progressListener);
        }

        public void zzb(ProgressListener progressListener) {
            this.zzarH.remove(progressListener);
        }

        public long zztk() {
            return this.zzarI;
        }

        public boolean zztl() {
            return !this.zzarH.isEmpty();
        }
    }

    static {
        NAMESPACE = zzyv.NAMESPACE;
    }

    public RemoteMediaClient(@NonNull zzyv com_google_android_gms_internal_zzyv, @NonNull CastApi castApi) {
        this.mListeners = new CopyOnWriteArrayList();
        this.zzarA = new ConcurrentHashMap();
        this.zzarB = new ConcurrentHashMap();
        this.zzrN = new Object();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzary = new zza(this);
        this.zzaph = castApi;
        this.zzanU = (zzyv) zzac.zzw(com_google_android_gms_internal_zzyv);
        this.zzanU.zza(new C06111(this));
        this.zzanU.zza(this.zzary);
    }

    private zzb zza(zzb com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb) {
        try {
            this.zzarz.zzb((com.google.android.gms.internal.zzzv.zza) com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb);
        } catch (IllegalStateException e) {
            com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb.zzb((MediaChannelResult) com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb.zzc(new Status(STATUS_FAILED)));
        } catch (Throwable th) {
        }
        return com_google_android_gms_cast_framework_media_RemoteMediaClient_zzb;
    }

    private void zza(Set<ProgressListener> set) {
        if (!isBuffering() && !isPaused()) {
            Set<ProgressListener> hashSet = new HashSet(set);
            if (isPlaying()) {
                for (ProgressListener onProgressUpdated : hashSet) {
                    onProgressUpdated.onProgressUpdated(getApproximateStreamPosition(), getStreamDuration());
                }
            } else if (isLoadingNextItem()) {
                MediaQueueItem loadingItem = getLoadingItem();
                if (loadingItem != null && loadingItem.getMedia() != null) {
                    for (ProgressListener onProgressUpdated2 : hashSet) {
                        onProgressUpdated2.onProgressUpdated(0, loadingItem.getMedia().getStreamDuration());
                    }
                }
            } else {
                for (ProgressListener onProgressUpdated22 : hashSet) {
                    onProgressUpdated22.onProgressUpdated(0, 0);
                }
            }
        }
    }

    private int zzbR(int i) {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = RESUME_STATE_UNCHANGED; i2 < mediaStatus.getQueueItemCount(); i2 += RESUME_STATE_PLAY) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    private void zzth() throws IllegalStateException {
        if (this.zzarz == null) {
            throw new IllegalStateException("No connection");
        }
    }

    private void zzti() {
        for (zzd com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd : this.zzarB.values()) {
            if (hasMediaSession() && !com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.isStarted()) {
                com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.start();
            } else if (!hasMediaSession() && com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.isStarted()) {
                com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.stop();
            }
            if (com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.isStarted() && (isBuffering() || isPaused() || isLoadingNextItem())) {
                zza(com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.zzarH);
            }
        }
    }

    public void addListener(Listener listener) {
        zzac.zzdn("Must be called from the main thread.");
        if (listener != null) {
            this.mListeners.add(listener);
        }
    }

    public boolean addProgressListener(ProgressListener progressListener, long j) {
        zzac.zzdn("Must be called from the main thread.");
        if (progressListener == null || this.zzarA.containsKey(progressListener)) {
            return false;
        }
        zzd com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd = (zzd) this.zzarB.get(Long.valueOf(j));
        if (com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd == null) {
            com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd = new zzd(this, j);
            this.zzarB.put(Long.valueOf(j), com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd);
        }
        com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.zza(progressListener);
        this.zzarA.put(progressListener, com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd);
        if (hasMediaSession()) {
            com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.start();
        }
        return true;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzrN) {
            zzac.zzdn("Must be called from the main thread.");
            approximateStreamPosition = this.zzanU.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaQueueItem getCurrentItem() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus == null ? null : mediaStatus.getQueueItemById(mediaStatus.getCurrentItemId());
    }

    public int getIdleReason() {
        int idleReason;
        synchronized (this.zzrN) {
            zzac.zzdn("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            idleReason = mediaStatus != null ? mediaStatus.getIdleReason() : RESUME_STATE_UNCHANGED;
        }
        return idleReason;
    }

    public MediaQueueItem getLoadingItem() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus == null ? null : mediaStatus.getQueueItemById(mediaStatus.getLoadingItemId());
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzrN) {
            zzac.zzdn("Must be called from the main thread.");
            mediaInfo = this.zzanU.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzrN) {
            zzac.zzdn("Must be called from the main thread.");
            mediaStatus = this.zzanU.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        zzac.zzdn("Must be called from the main thread.");
        return this.zzanU.getNamespace();
    }

    public int getPlayerState() {
        int playerState;
        synchronized (this.zzrN) {
            zzac.zzdn("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            playerState = mediaStatus != null ? mediaStatus.getPlayerState() : RESUME_STATE_PLAY;
        }
        return playerState;
    }

    public MediaQueueItem getPreloadedItem() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus == null ? null : mediaStatus.getQueueItemById(mediaStatus.getPreloadedItemId());
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzrN) {
            zzac.zzdn("Must be called from the main thread.");
            streamDuration = this.zzanU.getStreamDuration();
        }
        return streamDuration;
    }

    public boolean hasMediaSession() {
        zzac.zzdn("Must be called from the main thread.");
        return isBuffering() || isPlaying() || isPaused() || isLoadingNextItem();
    }

    public boolean isBuffering() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 4;
    }

    public boolean isLiveStream() {
        zzac.zzdn("Must be called from the main thread.");
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null && mediaInfo.getStreamType() == RESUME_STATE_PAUSE;
    }

    public boolean isLoadingNextItem() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return (mediaStatus == null || mediaStatus.getLoadingItemId() == 0) ? false : true;
    }

    public boolean isPaused() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && (mediaStatus.getPlayerState() == 3 || (isLiveStream() && getIdleReason() == RESUME_STATE_PAUSE));
    }

    public boolean isPlaying() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == RESUME_STATE_PAUSE;
    }

    public boolean isPlayingAd() {
        zzac.zzdn("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.isPlayingAd();
    }

    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo) {
        return load(mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z) {
        return load(mediaInfo, z, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j) {
        return load(mediaInfo, z, j, null, null);
    }

    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(mediaInfo, z, j, null, jSONObject);
    }

    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass12(this, this.zzarz, mediaInfo, z, j, jArr, jSONObject));
    }

    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzanU.zzcO(str2);
    }

    public PendingResult<MediaChannelResult> pause() {
        return pause(null);
    }

    public PendingResult<MediaChannelResult> pause(JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass17(this, this.zzarz, jSONObject));
    }

    public PendingResult<MediaChannelResult> play() {
        return play(null);
    }

    public PendingResult<MediaChannelResult> play(JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass19(this, this.zzarz, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueAppendItem(MediaQueueItem mediaQueueItem, JSONObject jSONObject) throws IllegalArgumentException {
        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[RESUME_STATE_PLAY];
        mediaQueueItemArr[RESUME_STATE_UNCHANGED] = mediaQueueItem;
        return queueInsertItems(mediaQueueItemArr, RESUME_STATE_UNCHANGED, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new C06166(this, this.zzarz, mediaQueueItem, i, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(MediaQueueItem mediaQueueItem, int i, JSONObject jSONObject) {
        return queueInsertAndPlayItem(mediaQueueItem, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new C06155(this, this.zzarz, mediaQueueItemArr, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(int i, long j, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass15(this, this.zzarz, i, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(int i, JSONObject jSONObject) {
        return queueJumpToItem(i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueLoad(MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IllegalArgumentException {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new C06144(this, this.zzarz, mediaQueueItemArr, i, i2, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueLoad(MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IllegalArgumentException {
        return queueLoad(mediaQueueItemArr, i, i2, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(int i, int i2, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass16(this, this.zzarz, i, i2, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueNext(JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass11(this, this.zzarz, jSONObject));
    }

    public PendingResult<MediaChannelResult> queuePrev(JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass10(this, this.zzarz, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(int i, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass14(this, this.zzarz, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(int[] iArr, JSONObject jSONObject) throws IllegalArgumentException {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new C06188(this, this.zzarz, iArr, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueReorderItems(int[] iArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new C06199(this, this.zzarz, iArr, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(int i, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass13(this, this.zzarz, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new C06177(this, this.zzarz, mediaQueueItemArr, jSONObject));
    }

    public void removeListener(Listener listener) {
        zzac.zzdn("Must be called from the main thread.");
        if (listener != null) {
            this.mListeners.remove(listener);
        }
    }

    public void removeProgressListener(ProgressListener progressListener) {
        zzac.zzdn("Must be called from the main thread.");
        zzd com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd = (zzd) this.zzarA.remove(progressListener);
        if (com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd != null) {
            com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.zzb(progressListener);
            if (!com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.zztl()) {
                this.zzarB.remove(Long.valueOf(com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.zztk()));
                com_google_android_gms_cast_framework_media_RemoteMediaClient_zzd.stop();
            }
        }
    }

    public PendingResult<MediaChannelResult> requestStatus() {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass23(this, this.zzarz));
    }

    public PendingResult<MediaChannelResult> seek(long j) {
        return seek(j, RESUME_STATE_UNCHANGED, null);
    }

    public PendingResult<MediaChannelResult> seek(long j, int i) {
        return seek(j, i, null);
    }

    public PendingResult<MediaChannelResult> seek(long j, int i, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass20(this, this.zzarz, j, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(long[] jArr) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        if (jArr != null) {
            return zza(new C06122(this, this.zzarz, jArr));
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setParseAdsInfoCallback(ParseAdsInfoCallback parseAdsInfoCallback) {
        zzac.zzdn("Must be called from the main thread.");
        this.zzarC = parseAdsInfoCallback;
    }

    public PendingResult<MediaChannelResult> setStreamMute(boolean z) {
        return setStreamMute(z, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(boolean z, JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass22(this, this.zzarz, z, jSONObject));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(double d) throws IllegalArgumentException {
        return setStreamVolume(d, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(double d, JSONObject jSONObject) throws IllegalArgumentException {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return zza(new AnonymousClass21(this, this.zzarz, d, jSONObject));
        }
        throw new IllegalArgumentException("Volume cannot be " + d);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(TextTrackStyle textTrackStyle) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        if (textTrackStyle != null) {
            return zza(new C06133(this, this.zzarz, textTrackStyle));
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop() {
        return stop(null);
    }

    public PendingResult<MediaChannelResult> stop(JSONObject jSONObject) {
        zzac.zzdn("Must be called from the main thread.");
        zzth();
        return zza(new AnonymousClass18(this, this.zzarz, jSONObject));
    }

    public void togglePlayback() {
        zzac.zzdn("Must be called from the main thread.");
        int playerState = getPlayerState();
        if (playerState == 4 || playerState == RESUME_STATE_PAUSE) {
            pause();
        } else {
            play();
        }
    }

    public void zzd(GoogleApiClient googleApiClient) throws IOException {
        if (this.zzarz != googleApiClient) {
            if (this.zzarz != null) {
                this.zzanU.zzua();
                this.zzaph.removeMessageReceivedCallbacks(this.zzarz, getNamespace());
                this.zzary.zzc(null);
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.zzarz = googleApiClient;
            if (this.zzarz != null) {
                this.zzaph.setMessageReceivedCallbacks(this.zzarz, getNamespace(), this);
                this.zzary.zzc(this.zzarz);
            }
        }
    }
}
