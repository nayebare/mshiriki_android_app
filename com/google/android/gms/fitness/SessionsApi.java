package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface SessionsApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private Session zzaQL;
        private String zzaQM;
        private boolean zzaQN;

        public ViewIntentBuilder(Context context) {
            this.zzaQN = false;
            this.mContext = context;
        }

        private Intent zzk(Intent intent) {
            if (this.zzaQM == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzaQM);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzaQM, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            zzac.zza(this.zzaQL != null, (Object) "Session must be set");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(Session.getMimeType(this.zzaQL.getActivity()));
            zzd.zza(this.zzaQL, intent, Session.EXTRA_SESSION);
            if (!this.zzaQN) {
                this.zzaQM = this.zzaQL.getAppPackageName();
            }
            return zzk(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.zzaQM = str;
            this.zzaQN = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.zzaQL = session;
            return this;
        }
    }

    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);
}
