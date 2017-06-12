package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface AppContentAnnotation extends Parcelable, Freezable<AppContentAnnotation> {
    String getDescription();

    String getId();

    String getTitle();

    Uri zzDA();

    Bundle zzDB();

    int zzDC();

    String zzDD();

    String zzDy();

    int zzDz();
}
