package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zzaqr {
    private static Boolean zzbif;
    private static ContentProviderClient zzbig;

    static {
        zzbif = null;
    }

    static Intent getInstantAppIntent(Context context, String str, Intent intent) {
        return zza(context, str, (Parcelable) intent, true);
    }

    static synchronized void reset() {
        synchronized (zzaqr.class) {
            if (zzbig != null) {
                zzbig.release();
                zzbig = null;
            }
            zzbif = null;
        }
    }

    @TargetApi(11)
    private static Intent zza(Context context, String str, Parcelable parcelable, boolean z) {
        Throwable e;
        if (context == null || str == null) {
            throw new IllegalArgumentException("Parameter is null");
        } else if (!zzbl(context)) {
            return null;
        } else {
            Bundle bundle;
            if (parcelable != null) {
                bundle = new Bundle(1);
                bundle.putParcelable("key_fallbackIntent", parcelable);
            } else {
                bundle = null;
            }
            try {
                bundle = zza(context, "method_getInstantAppIntent", str, bundle);
                return bundle == null ? null : (Intent) bundle.getParcelable("key_instantAppIntent");
            } catch (Throwable e2) {
                Log.e("InstantAppsApi", String.format("While calling %s %s:\n", new Object[]{zzaqi.zzbhS, "method_getInstantAppIntent"}), e2);
                reset();
                return z ? zza(context, str, parcelable, false) : null;
            } catch (IllegalArgumentException e3) {
                e2 = e3;
                Log.e("InstantAppsApi", String.format("While calling %s %s:\n", new Object[]{zzaqi.zzbhS, "method_getInstantAppIntent"}), e2);
                return null;
            } catch (RemoteException e4) {
                e2 = e4;
                Log.e("InstantAppsApi", String.format("While calling %s %s:\n", new Object[]{zzaqi.zzbhS, "method_getInstantAppIntent"}), e2);
                return null;
            }
        }
    }

    @TargetApi(11)
    private static synchronized Bundle zza(Context context, String str, String str2, Bundle bundle) throws RemoteException {
        Bundle call;
        synchronized (zzaqr.class) {
            call = zzbig == null ? context.getContentResolver().call(zzaqi.zzbhS, str, str2, bundle) : zzd(str, str2, bundle);
        }
        return call;
    }

    @TargetApi(17)
    private static synchronized boolean zzbk(Context context) {
        boolean z;
        synchronized (zzaqr.class) {
            if (zzbig == null) {
                zzbig = context.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(zzaqi.zzbhS);
            }
            z = zzbig != null;
        }
        return z;
    }

    @TargetApi(11)
    static synchronized boolean zzbl(Context context) {
        boolean booleanValue;
        synchronized (zzaqr.class) {
            if (context == null) {
                throw new IllegalArgumentException("Parameter is null");
            }
            if (zzbif != null) {
                booleanValue = zzbif.booleanValue();
            } else {
                zzbif = Boolean.valueOf(zzbm(context));
                booleanValue = zzbif.booleanValue();
            }
        }
        return booleanValue;
    }

    private static synchronized boolean zzbm(Context context) {
        boolean z = false;
        synchronized (zzaqr.class) {
            if (VERSION.SDK_INT >= 11) {
                if (zzarc.zzbp(context)) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(zzaqi.zzbhS.getAuthority(), 0);
                    if (resolveContentProvider != null) {
                        if (!resolveContentProvider.packageName.equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                            String str = "InstantAppsApi";
                            String str2 = "Incorrect package name for instant apps content provider: ";
                            String valueOf = String.valueOf(resolveContentProvider.packageName);
                            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                        } else if (VERSION.SDK_INT < 17 || zzbk(context)) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    @TargetApi(17)
    private static synchronized Bundle zzd(String str, String str2, Bundle bundle) throws RemoteException {
        Bundle call;
        synchronized (zzaqr.class) {
            call = zzbig.call(str, str2, bundle);
        }
        return call;
    }
}
