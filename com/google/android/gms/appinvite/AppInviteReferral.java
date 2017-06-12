package com.google.android.gms.appinvite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.http.protocol.HTTP;

public class AppInviteReferral {
    private AppInviteReferral() {
    }

    @Deprecated
    public static Intent addPlayStoreReferrerToIntent(Intent intent, Intent intent2) {
        Bundle zzh = zzh(intent);
        if (!(zzh == null || intent2 == null)) {
            intent2.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", zzh);
        }
        return intent2;
    }

    @Deprecated
    public static Intent addReferralDataToIntent(String str, String str2, Intent intent) {
        return intent == null ? null : intent.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", zzd(str, str2, false));
    }

    public static String getDeepLink(Intent intent) {
        if (intent != null) {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE");
            if (bundleExtra != null) {
                return bundleExtra.getString("com.google.android.gms.appinvite.DEEP_LINK");
            }
        }
        return null;
    }

    public static String getInvitationId(Intent intent) {
        if (intent != null) {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE");
            if (bundleExtra != null) {
                return bundleExtra.getString("com.google.android.gms.appinvite.INVITATION_ID");
            }
        }
        return null;
    }

    public static boolean hasReferral(Intent intent) {
        return (intent == null || intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE") == null) ? false : true;
    }

    public static boolean isOpenedFromPlayStore(Intent intent) {
        return hasReferral(intent) && intent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE").getBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", false);
    }

    private static Bundle zzd(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.gms.appinvite.INVITATION_ID", str);
        if (str2 != null) {
            bundle.putString("com.google.android.gms.appinvite.DEEP_LINK", str2);
        }
        bundle.putBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", z);
        return bundle;
    }

    private static Bundle zzh(Intent intent) {
        String str;
        if (intent == null || !intent.getAction().equals("com.android.vending.INSTALL_REFERRER") || intent.getStringExtra("referrer") == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String decode;
        try {
            decode = URLDecoder.decode(stringExtra, HTTP.UTF_8);
            str = "s://a.b.c?";
            stringExtra = String.valueOf(decode);
            Uri parse = Uri.parse(stringExtra.length() != 0 ? str.concat(stringExtra) : new String(str));
            str = parse.getQueryParameter("invitation_id");
            stringExtra = parse.getQueryParameter(PlusShare.PARAM_CONTENT_DEEP_LINK_ID);
            if (str != null || stringExtra != null) {
                return zzd(str, stringExtra, true);
            }
            str = "AppInviteRef";
            String str2 = "Missing  Referrer query params: ";
            stringExtra = String.valueOf(decode);
            Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
            return null;
        } catch (UnsupportedEncodingException e) {
            decode = "AppInviteRef";
            str = "Error parsing Play Store referrer URL: ";
            stringExtra = String.valueOf(stringExtra);
            Log.e(decode, stringExtra.length() != 0 ? str.concat(stringExtra) : new String(str));
            return null;
        }
    }
}
