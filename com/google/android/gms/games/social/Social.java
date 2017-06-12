package com.google.android.gms.games.social;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Social {

    public interface InviteUpdateResult extends Result {
    }

    public interface LoadInvitesResult extends Releasable, Result {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InviteDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InviteType {
    }
}
