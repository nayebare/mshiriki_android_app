package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zzi implements Creator<DataReadRequest> {
    static void zza(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, dataReadRequest.getDataTypes(), false);
        zzc.zzc(parcel, 2, dataReadRequest.getDataSources(), false);
        zzc.zza(parcel, 3, dataReadRequest.zzpN());
        zzc.zza(parcel, 4, dataReadRequest.zzzx());
        zzc.zzc(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        zzc.zzc(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        zzc.zzc(parcel, 7, dataReadRequest.getBucketType());
        zzc.zzc(parcel, CardNetwork.OTHER, dataReadRequest.getVersionCode());
        zzc.zza(parcel, 8, dataReadRequest.zzCf());
        zzc.zza(parcel, 9, dataReadRequest.getActivityDataSource(), i, false);
        zzc.zzc(parcel, 10, dataReadRequest.getLimit());
        zzc.zza(parcel, 12, dataReadRequest.zzCe());
        zzc.zza(parcel, 13, dataReadRequest.zzCd());
        zzc.zza(parcel, 14, dataReadRequest.getCallbackBinder(), false);
        zzc.zzc(parcel, 16, dataReadRequest.zzCg(), false);
        zzc.zza(parcel, 17, dataReadRequest.zzCh(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzer(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzha(i);
    }

    public DataReadRequest zzer(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        long j = 0;
        long j2 = 0;
        List list3 = null;
        List list4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        List list5 = null;
        List list6 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    list = zzb.zzc(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    list2 = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list3 = zzb.zzc(parcel, zzaT, DataType.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    list4 = zzb.zzc(parcel, zzaT, DataSource.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case HTTP.LF /*10*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case HTTP.CR /*13*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    list5 = zzb.zzc(parcel, zzaT, Device.CREATOR);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    list6 = zzb.zzD(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new DataReadRequest(i, list, list2, j, j2, list3, list4, i2, j3, dataSource, i3, z, z2, iBinder, list5, list6);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public DataReadRequest[] zzha(int i) {
        return new DataReadRequest[i];
    }
}
