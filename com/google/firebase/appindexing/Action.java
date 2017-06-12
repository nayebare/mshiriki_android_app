package com.google.firebase.appindexing;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;
import com.google.firebase.appindexing.internal.zza.zza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Action {

    public static class Builder {
        public static final String ACTIVATE_ACTION = "ActivateAction";
        public static final String ADD_ACTION = "AddAction";
        public static final String BOOKMARK_ACTION = "BookmarkAction";
        public static final String COMMENT_ACTION = "CommentAction";
        public static final String LIKE_ACTION = "LikeAction";
        public static final String LISTEN_ACTION = "ListenAction";
        public static final String SEND_ACTION = "SendAction";
        public static final String SHARE_ACTION = "ShareAction";
        public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
        public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
        public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
        public static final String VIEW_ACTION = "ViewAction";
        public static final String WATCH_ACTION = "WatchAction";
        private final String zzbUQ;
        private String zzbUR;
        private String zzbUS;
        private String zzbUT;
        private zza zzbUU;
        private String zzbUV;

        @Retention(RetentionPolicy.CLASS)
        public @interface StatusType {
        }

        public Builder(String str) {
            this.zzbUU = Metadata.zzbUW;
            this.zzbUQ = str;
        }

        public Action build() {
            zzac.zzb(this.zzbUR, (Object) "setObject is required before calling build().");
            zzac.zzb(this.zzbUS, (Object) "setObject is required before calling build().");
            return new com.google.firebase.appindexing.internal.zza(this.zzbUQ, this.zzbUR, this.zzbUS, this.zzbUT, this.zzbUU, this.zzbUV);
        }

        public Builder setActionStatus(@StatusType String str) {
            zzac.zzw(str);
            this.zzbUV = str;
            return this;
        }

        public Builder setMetadata(@NonNull Builder builder) {
            zzac.zzw(builder);
            this.zzbUU = builder.zzTx();
            return this;
        }

        public Builder setObject(@NonNull String str, @NonNull String str2) {
            zzac.zzw(str);
            zzac.zzw(str2);
            this.zzbUR = str;
            this.zzbUS = str2;
            return this;
        }

        public Builder setObject(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            zzac.zzw(str);
            zzac.zzw(str2);
            zzac.zzw(str3);
            this.zzbUR = str;
            this.zzbUS = str2;
            this.zzbUT = str3;
            return this;
        }
    }

    public interface Metadata {
        public static final zza zzbUW;

        public static class Builder {
            private boolean zzbUX;
            private boolean zzbUY;

            public Builder() {
                this.zzbUX = true;
                this.zzbUY = false;
            }

            public Builder setUpload(boolean z) {
                this.zzbUX = z;
                return this;
            }

            public zza zzTx() {
                return new zza(this.zzbUX, null, null, null, false);
            }
        }

        static {
            zzbUW = new Builder().zzTx();
        }
    }
}
