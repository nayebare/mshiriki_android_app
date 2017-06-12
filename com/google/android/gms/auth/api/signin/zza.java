package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;
import org.apache.http.protocol.HTTP;

public class zza implements Creator<GoogleSignInAccount> {
    static void zza(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, googleSignInAccount.versionCode);
        zzc.zza(parcel, 2, googleSignInAccount.getId(), false);
        zzc.zza(parcel, 3, googleSignInAccount.getIdToken(), false);
        zzc.zza(parcel, 4, googleSignInAccount.getEmail(), false);
        zzc.zza(parcel, 5, googleSignInAccount.getDisplayName(), false);
        zzc.zza(parcel, 6, googleSignInAccount.getPhotoUrl(), i, false);
        zzc.zza(parcel, 7, googleSignInAccount.getServerAuthCode(), false);
        zzc.zza(parcel, 8, googleSignInAccount.zzqE());
        zzc.zza(parcel, 9, googleSignInAccount.zzqF(), false);
        zzc.zzc(parcel, 10, googleSignInAccount.zzahM, false);
        zzc.zza(parcel, 11, googleSignInAccount.getGivenName(), false);
        zzc.zza(parcel, 12, googleSignInAccount.getFamilyName(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbj(i);
    }

    public GoogleSignInAccount zzV(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case HTTP.HT /*9*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case HTTP.LF /*10*/:
                    list = zzb.zzc(parcel, zzaT, Scope.CREATOR);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str8 = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GoogleSignInAccount[] zzbj(int i) {
        return new GoogleSignInAccount[i];
    }
}
