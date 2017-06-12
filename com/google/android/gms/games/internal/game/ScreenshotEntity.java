package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;

public final class ScreenshotEntity extends GamesAbstractSafeParcelable implements Screenshot {
    public static final Creator<ScreenshotEntity> CREATOR;
    private final Uri mUri;
    private final int mVersionCode;
    private final int zzrG;
    private final int zzrH;

    static {
        CREATOR = new ScreenshotEntityCreator();
    }

    ScreenshotEntity(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.mUri = uri;
        this.zzrG = i2;
        this.zzrH = i3;
    }

    static int zza(ScreenshotEntity screenshotEntity) {
        return zzaa.hashCode(screenshotEntity.getUri(), Integer.valueOf(screenshotEntity.getWidth()), Integer.valueOf(screenshotEntity.getHeight()));
    }

    static boolean zza(ScreenshotEntity screenshotEntity, Object obj) {
        if (!(obj instanceof ScreenshotEntity)) {
            return false;
        }
        if (screenshotEntity == obj) {
            return true;
        }
        ScreenshotEntity screenshotEntity2 = (ScreenshotEntity) obj;
        return zzaa.equal(screenshotEntity2.getUri(), screenshotEntity.getUri()) && zzaa.equal(Integer.valueOf(screenshotEntity2.getWidth()), Integer.valueOf(screenshotEntity.getWidth())) && zzaa.equal(Integer.valueOf(screenshotEntity2.getHeight()), Integer.valueOf(screenshotEntity.getHeight()));
    }

    static String zzb(ScreenshotEntity screenshotEntity) {
        return zzaa.zzv(screenshotEntity).zzg("Uri", screenshotEntity.getUri()).zzg("Width", Integer.valueOf(screenshotEntity.getWidth())).zzg("Height", Integer.valueOf(screenshotEntity.getHeight())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzFf();
    }

    public int getHeight() {
        return this.zzrH;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zzrG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ScreenshotEntityCreator.zza(this, parcel, i);
    }

    public Screenshot zzFf() {
        return this;
    }
}
