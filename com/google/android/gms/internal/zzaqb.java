package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zzaqb extends zzl<zzaqd> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzaht;
    private zza zzbgN;

    public static final class zza extends com.google.android.gms.internal.zzaqc.zza {
        private Activity mActivity;
        private final int zzaye;

        public zza(int i, Activity activity) {
            this.zzaye = i;
            this.mActivity = activity;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        public void zzj(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.mActivity.createPendingResult(this.zzaye, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.mActivity, this.zzaye);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.mActivity.createPendingResult(this.zzaye, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public zzaqb(Activity activity, Looper looper, zzg com_google_android_gms_common_internal_zzg, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(activity, looper, 12, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzaht = com_google_android_gms_common_internal_zzg.getAccountName();
        this.mActivity = activity;
        this.mTheme = i;
    }

    public void disconnect() {
        super.disconnect();
        if (this.zzbgN != null) {
            this.zzbgN.setActivity(null);
            this.zzbgN = null;
        }
    }

    protected zzaqd zzGq() throws DeadObjectException {
        return (zzaqd) super.zzwW();
    }

    protected void zzGr() {
        super.zzwV();
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzGr();
        this.zzbgN = new zza(i, this.mActivity);
        Bundle bundle;
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzaht)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzaht, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzGq().zza(this.zzbgN, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzbgN.zzj(1, bundle);
        }
    }

    protected zzaqd zzcW(IBinder iBinder) {
        return com.google.android.gms.internal.zzaqd.zza.zzcY(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String zzev() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzcW(iBinder);
    }

    public boolean zzwX() {
        return true;
    }
}
