package com.google.android.gms.appinvite;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.MessageApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public final class AppInviteInvitation {
    private static final String[] zzahe;

    public static final class IntentBuilder {
        public static final int MAX_CALL_TO_ACTION_TEXT_LENGTH = 20;
        public static final int MAX_EMAIL_HTML_CONTENT = 512000;
        public static final int MAX_MESSAGE_LENGTH = 100;
        public static final int MIN_CALL_TO_ACTION_TEXT_LENGTH = 2;
        private final Intent mIntent;
        private String zzahf;
        private String zzahg;

        @Retention(RetentionPolicy.SOURCE)
        public @interface PlatformMode {
            public static final int PROJECT_PLATFORM_ANDROID = 2;
            public static final int PROJECT_PLATFORM_IOS = 1;
        }

        public IntentBuilder(@NonNull CharSequence charSequence) {
            zzac.zzw(charSequence);
            this.mIntent = new Intent("com.google.android.gms.appinvite.ACTION_APP_INVITE");
            this.mIntent.putExtra("com.google.android.gms.appinvite.TITLE", charSequence);
            this.mIntent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        }

        public Intent build() {
            if (!TextUtils.isEmpty(this.zzahf)) {
                zzac.zzh(this.zzahg, "Email html content must be set when email subject is set.");
                zzac.zzb(this.mIntent.getData() == null, (Object) "Custom image must not be set when email html content is set.");
                zzac.zzb(TextUtils.isEmpty(this.mIntent.getCharSequenceExtra("com.google.android.gms.appinvite.BUTTON_TEXT")), (Object) "Call to action text must not be set when email html content is set.");
                this.mIntent.putExtra("com.google.android.gms.appinvite.EMAIL_SUBJECT", this.zzahf);
                this.mIntent.putExtra("com.google.android.gms.appinvite.EMAIL_CONTENT", this.zzahg);
            } else if (!TextUtils.isEmpty(this.zzahg)) {
                throw new IllegalArgumentException("Email subject must be set when email html content is set.");
            }
            return this.mIntent;
        }

        public IntentBuilder setAccount(Account account) {
            if (account == null || !GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE.equals(account.type)) {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.ACCOUNT_NAME");
            } else {
                this.mIntent.putExtra("com.google.android.gms.appinvite.ACCOUNT_NAME", account);
            }
            return this;
        }

        public IntentBuilder setAdditionalReferralParameters(Map<String, String> map) {
            if (map != null) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI", AppInviteInvitation.zzT(map));
            } else {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI");
            }
            return this;
        }

        public IntentBuilder setAndroidMinimumVersionCode(int i) {
            this.mIntent.putExtra("com.google.android.gms.appinvite.appMinimumVersionCode", i);
            return this;
        }

        public IntentBuilder setCallToActionText(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() < MIN_CALL_TO_ACTION_TEXT_LENGTH || charSequence.length() > MAX_CALL_TO_ACTION_TEXT_LENGTH) {
                Object[] objArr = new Object[MIN_CALL_TO_ACTION_TEXT_LENGTH];
                objArr[0] = Integer.valueOf(MIN_CALL_TO_ACTION_TEXT_LENGTH);
                objArr[1] = Integer.valueOf(MAX_CALL_TO_ACTION_TEXT_LENGTH);
                throw new IllegalArgumentException(String.format("Text must be between %d and %d chars in length.", objArr));
            }
            this.mIntent.putExtra("com.google.android.gms.appinvite.BUTTON_TEXT", charSequence);
            return this;
        }

        public IntentBuilder setCustomImage(Uri uri) {
            boolean z = false;
            zzac.zzw(uri);
            zzac.zzb(uri.isAbsolute(), (Object) "Image uri is not an absolute uri. Did you forget to add a scheme to the Uri?");
            String toLowerCase = uri.getScheme().toLowerCase();
            boolean z2 = toLowerCase.equals("android.resource") || toLowerCase.equals("content") || toLowerCase.equals("file");
            boolean z3 = z2 || toLowerCase.equals("http") || toLowerCase.equals("https");
            zzac.zzb(z3, (Object) "Image uri must be a content URI with scheme \"android.resource\", \"content\" or \"file\", or a network url with scheme \"http\" or \"https\".");
            if (!z2) {
                String uri2 = uri.toString();
                uri2 = uri2.substring(uri2.lastIndexOf("/") + 1, uri2.length());
                Object toLowerCase2 = uri2 == null ? null : uri2.lastIndexOf(".") == -1 ? null : uri2.substring(uri2.lastIndexOf(".") + 1, uri2.length()).toLowerCase();
                if (TextUtils.isEmpty(toLowerCase2) || AppInviteInvitation.zzcp(toLowerCase2)) {
                    z = true;
                }
                zzac.zzb(z, String.valueOf(toLowerCase2).concat(" images are not supported. Only jpg, jpeg, or png images are supported."));
            }
            this.mIntent.setData(uri.buildUpon().scheme(toLowerCase).build());
            if (z2) {
                this.mIntent.addFlags(1);
            }
            return this;
        }

        public IntentBuilder setDeepLink(Uri uri) {
            if (uri != null) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.DEEP_LINK_URL", uri);
            } else {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.DEEP_LINK_URL");
            }
            return this;
        }

        public IntentBuilder setEmailHtmlContent(String str) {
            if (str == null || str.getBytes().length <= MAX_EMAIL_HTML_CONTENT) {
                this.zzahg = str;
                return this;
            }
            throw new IllegalArgumentException(String.format("Email html content must be %d bytes or less.", new Object[]{Integer.valueOf(MAX_EMAIL_HTML_CONTENT)}));
        }

        public IntentBuilder setEmailSubject(String str) {
            this.zzahf = str;
            return this;
        }

        public IntentBuilder setGoogleAnalyticsTrackingId(String str) {
            this.mIntent.putExtra("com.google.android.gms.appinvite.GOOGLE_ANALYTICS_TRACKING_ID", str);
            return this;
        }

        public IntentBuilder setMessage(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() <= MAX_MESSAGE_LENGTH) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.MESSAGE", charSequence);
                return this;
            }
            throw new IllegalArgumentException(String.format("Message must be %d chars or less.", new Object[]{Integer.valueOf(MAX_MESSAGE_LENGTH)}));
        }

        public IntentBuilder setOtherPlatformsTargetApplication(int i, String str) throws IllegalArgumentException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    this.mIntent.putExtra("com.google.android.gms.appinvite.iosTargetApplication", str);
                    break;
                case MIN_CALL_TO_ACTION_TEXT_LENGTH /*2*/:
                    this.mIntent.putExtra("com.google.android.gms.appinvite.androidTargetApplication", str);
                    break;
                default:
                    throw new IllegalArgumentException("targetPlatform must be either PROJECT_PLATFORM_IOS or PROJECT_PLATFORM_ANDROID.");
            }
            return this;
        }
    }

    static {
        zzahe = new String[]{"jpg", "jpeg", "png"};
    }

    private AppInviteInvitation() {
    }

    public static String[] getInvitationIds(int i, @NonNull Intent intent) {
        return i == -1 ? intent.getStringArrayExtra("com.google.android.gms.appinvite.RESULT_INVITATION_IDS") : null;
    }

    private static Bundle zzT(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, (String) map.get(str));
        }
        return bundle;
    }

    private static boolean zzcp(String str) {
        for (String equals : zzahe) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
