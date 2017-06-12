package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.MessageApi;

public class zzi {
    public static boolean zza(int i, DriveId driveId) {
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                return driveId != null;
            case Dimension.UNIT_IN /*4*/:
            case BuyButtonText.DONATE_WITH /*7*/:
                return driveId == null;
            default:
                return false;
        }
    }
}
