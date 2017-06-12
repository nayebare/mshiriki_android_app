package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zzl implements Creator<MediaStatus> {
    static void zza(MediaStatus mediaStatus, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, mediaStatus.getVersionCode());
        zzc.zza(parcel, 2, mediaStatus.getMediaInfo(), i, false);
        zzc.zza(parcel, 3, mediaStatus.zzsa());
        zzc.zzc(parcel, 4, mediaStatus.getCurrentItemId());
        zzc.zza(parcel, 5, mediaStatus.getPlaybackRate());
        zzc.zzc(parcel, 6, mediaStatus.getPlayerState());
        zzc.zzc(parcel, 7, mediaStatus.getIdleReason());
        zzc.zza(parcel, 8, mediaStatus.getStreamPosition());
        zzc.zza(parcel, 9, mediaStatus.zzanG);
        zzc.zza(parcel, 10, mediaStatus.getStreamVolume());
        zzc.zza(parcel, 11, mediaStatus.isMute());
        zzc.zza(parcel, 12, mediaStatus.getActiveTrackIds(), false);
        zzc.zzc(parcel, 13, mediaStatus.getLoadingItemId());
        zzc.zzc(parcel, 14, mediaStatus.getPreloadedItemId());
        zzc.zza(parcel, 15, mediaStatus.zzalH, false);
        zzc.zzc(parcel, 16, mediaStatus.zzanL);
        zzc.zzc(parcel, 17, mediaStatus.zzanM, false);
        zzc.zza(parcel, 18, mediaStatus.isPlayingAd());
        zzc.zza(parcel, 19, mediaStatus.getAdBreakStatus(), i, false);
        zzc.zza(parcel, 20, mediaStatus.getVideoInfo(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzav(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbO(i);
    }

    public MediaStatus zzav(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        MediaInfo mediaInfo = null;
        long j = 0;
        int i2 = 0;
        double d = 0.0d;
        int i3 = 0;
        int i4 = 0;
        long j2 = 0;
        long j3 = 0;
        double d2 = 0.0d;
        boolean z = false;
        long[] jArr = null;
        int i5 = 0;
        int i6 = 0;
        String str = null;
        int i7 = 0;
        List list = null;
        boolean z2 = false;
        AdBreakStatus adBreakStatus = null;
        VideoInfo videoInfo = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    mediaInfo = (MediaInfo) zzb.zza(parcel, zzaT, MediaInfo.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    d = zzb.zzn(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    d2 = zzb.zzn(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    jArr = zzb.zzx(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    i6 = zzb.zzg(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    i7 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    list = zzb.zzc(parcel, zzaT, MediaQueueItem.CREATOR);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    adBreakStatus = (AdBreakStatus) zzb.zza(parcel, zzaT, AdBreakStatus.CREATOR);
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    videoInfo = (VideoInfo) zzb.zza(parcel, zzaT, VideoInfo.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new MediaStatus(i, mediaInfo, j, i2, d, i3, i4, j2, j3, d2, z, jArr, i5, i6, str, i7, list, z2, adBreakStatus, videoInfo);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MediaStatus[] zzbO(int i) {
        return new MediaStatus[i];
    }
}
