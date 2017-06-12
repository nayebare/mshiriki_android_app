package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;

public final class Action extends Thing {
    public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
    public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
    public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
    public static final String TYPE_ACTIVATE = "http://schema.org/ActivateAction";
    public static final String TYPE_ADD = "http://schema.org/AddAction";
    public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
    public static final String TYPE_COMMUNICATE = "http://schema.org/CommunicateAction";
    public static final String TYPE_FILM = "http://schema.org/FilmAction";
    public static final String TYPE_LIKE = "http://schema.org/LikeAction";
    public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
    public static final String TYPE_PHOTOGRAPH = "http://schema.org/PhotographAction";
    public static final String TYPE_RESERVE = "http://schema.org/ReserveAction";
    public static final String TYPE_SEARCH = "http://schema.org/SearchAction";
    public static final String TYPE_VIEW = "http://schema.org/ViewAction";
    public static final String TYPE_WANT = "http://schema.org/WantAction";
    public static final String TYPE_WATCH = "http://schema.org/WatchAction";

    public static final class Builder extends com.google.android.gms.appindexing.Thing.Builder {
        public Builder(String str) {
            zzac.zzw(str);
            super.put("type", str);
        }

        public Action build() {
            zzac.zzb(this.zzahb.get("object"), (Object) "setObject is required before calling build().");
            zzac.zzb(this.zzahb.get("type"), (Object) "setType is required before calling build().");
            Bundle bundle = (Bundle) this.zzahb.getParcelable("object");
            zzac.zzb(bundle.get("name"), (Object) "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            zzac.zzb(bundle.get(PlusShare.KEY_CALL_TO_ACTION_URL), (Object) "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            return new Action(null);
        }

        public Builder put(String str, Thing thing) {
            return (Builder) super.put(str, thing);
        }

        public Builder put(String str, String str2) {
            return (Builder) super.put(str, str2);
        }

        public Builder put(String str, boolean z) {
            return (Builder) super.put(str, z);
        }

        public Builder put(String str, Thing[] thingArr) {
            return (Builder) super.put(str, thingArr);
        }

        public Builder put(String str, String[] strArr) {
            return (Builder) super.put(str, strArr);
        }

        public Builder setActionStatus(String str) {
            zzac.zzw(str);
            return (Builder) super.put(FitnessActivities.EXTRA_STATUS, str);
        }

        public Builder setName(String str) {
            return (Builder) super.put("name", str);
        }

        public Builder setObject(Thing thing) {
            zzac.zzw(thing);
            return (Builder) super.put("object", thing);
        }

        public Builder setUrl(Uri uri) {
            if (uri != null) {
                super.put(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            }
            return this;
        }
    }

    private Action(Bundle bundle) {
        super(bundle);
    }

    public static Action newAction(String str, String str2, Uri uri) {
        return newAction(str, str2, null, uri);
    }

    public static Action newAction(String str, String str2, Uri uri, Uri uri2) {
        return (Action) new Builder(str).setObject(new com.google.android.gms.appindexing.Thing.Builder().setName(str2).setId(uri == null ? null : uri.toString()).setUrl(uri2).build()).build();
    }
}
