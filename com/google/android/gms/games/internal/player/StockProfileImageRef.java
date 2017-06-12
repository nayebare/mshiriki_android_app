package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public class StockProfileImageRef extends zzc implements StockProfileImage {
    public StockProfileImageRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzFv();
    }

    public String getImageUrl() {
        return getString("image_url");
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((StockProfileImageEntity) ((StockProfileImage) freeze())).writeToParcel(parcel, i);
    }

    public Uri zzDA() {
        return Uri.parse(getString("image_uri"));
    }

    public StockProfileImage zzFv() {
        return new StockProfileImageEntity(this);
    }
}
