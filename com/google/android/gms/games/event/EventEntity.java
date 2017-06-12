package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzg;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class EventEntity extends GamesAbstractSafeParcelable implements Event {
    public static final Creator<EventEntity> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final Uri zzaWW;
    private final String zzaXh;
    private final String zzaYL;
    private final String zzaYM;
    private final PlayerEntity zzaYi;
    private final long zzacc;
    private final String zzacd;
    private final boolean zzwn;

    static {
        CREATOR = new EventEntityCreator();
    }

    EventEntity(int i, String str, String str2, String str3, Uri uri, String str4, Player player, long j, String str5, boolean z) {
        this.mVersionCode = i;
        this.zzaYL = str;
        this.mName = str2;
        this.zzacd = str3;
        this.zzaWW = uri;
        this.zzaXh = str4;
        this.zzaYi = new PlayerEntity(player);
        this.zzacc = j;
        this.zzaYM = str5;
        this.zzwn = z;
    }

    public EventEntity(Event event) {
        this.mVersionCode = 1;
        this.zzaYL = event.getEventId();
        this.mName = event.getName();
        this.zzacd = event.getDescription();
        this.zzaWW = event.getIconImageUri();
        this.zzaXh = event.getIconImageUrl();
        this.zzaYi = (PlayerEntity) event.getPlayer().freeze();
        this.zzacc = event.getValue();
        this.zzaYM = event.getFormattedValue();
        this.zzwn = event.isVisible();
    }

    static int zza(Event event) {
        return zzaa.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzaa.equal(event2.getEventId(), event.getEventId()) && zzaa.equal(event2.getName(), event.getName()) && zzaa.equal(event2.getDescription(), event.getDescription()) && zzaa.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzaa.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzaa.equal(event2.getPlayer(), event.getPlayer()) && zzaa.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzaa.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzaa.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return zzaa.zzv(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.zzacd;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzacd, charArrayBuffer);
    }

    public String getEventId() {
        return this.zzaYL;
    }

    public String getFormattedValue() {
        return this.zzaYM;
    }

    public void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.zzaYM, charArrayBuffer);
    }

    public Uri getIconImageUri() {
        return this.zzaWW;
    }

    public String getIconImageUrl() {
        return this.zzaXh;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zzg.zzb(this.mName, charArrayBuffer);
    }

    public Player getPlayer() {
        return this.zzaYi;
    }

    public long getValue() {
        return this.zzacc;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.zzwn;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        EventEntityCreator.zza(this, parcel, i);
    }
}
