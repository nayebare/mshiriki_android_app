package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.plus.PlusShare;

public final class EventRef extends zzc implements Event {
    EventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return EventEntity.zza(this, obj);
    }

    public Event freeze() {
        return new EventEntity(this);
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public String getEventId() {
        return getString("external_event_id");
    }

    public String getFormattedValue() {
        return getString("formatted_value");
    }

    public void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        zza("formatted_value", charArrayBuffer);
    }

    public Uri getIconImageUri() {
        return zzdk("icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("icon_image_url");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zza("name", charArrayBuffer);
    }

    public Player getPlayer() {
        return new PlayerRef(this.zzazI, this.zzaCm);
    }

    public long getValue() {
        return getLong("value");
    }

    public int hashCode() {
        return EventEntity.zza(this);
    }

    public boolean isVisible() {
        return getBoolean("visibility");
    }

    public String toString() {
        return EventEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((EventEntity) ((Event) freeze())).writeToParcel(parcel, i);
    }
}
