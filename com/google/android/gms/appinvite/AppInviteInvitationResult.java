package com.google.android.gms.appinvite;

import android.content.Intent;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public interface AppInviteInvitationResult extends Result {
    Intent getInvitationIntent();

    Status getStatus();
}
