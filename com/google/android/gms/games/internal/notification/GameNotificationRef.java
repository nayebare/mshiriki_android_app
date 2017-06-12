package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends zzc implements GameNotification {
    GameNotificationRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String toString() {
        return zzaa.zzv(this).zzg("Id", Long.valueOf(getId())).zzg("NotificationId", zzFi()).zzg("Type", Integer.valueOf(getType())).zzg("Title", getTitle()).zzg("Ticker", zzFj()).zzg("Text", getText()).zzg("CoalescedText", zzFk()).zzg("isAcknowledged", Boolean.valueOf(zzFl())).zzg("isSilent", Boolean.valueOf(zzFm())).zzg("isQuiet", Boolean.valueOf(zzFn())).toString();
    }

    public String zzFi() {
        return getString("notification_id");
    }

    public String zzFj() {
        return getString("ticker");
    }

    public String zzFk() {
        return getString("coalesced_text");
    }

    public boolean zzFl() {
        return getInteger("acknowledged") > 0;
    }

    public boolean zzFm() {
        return getInteger("alert_level") == 0;
    }

    public boolean zzFn() {
        return getInteger("alert_level") == 2;
    }
}
