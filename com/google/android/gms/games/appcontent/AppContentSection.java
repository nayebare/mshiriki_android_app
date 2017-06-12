package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public interface AppContentSection extends Parcelable, Freezable<AppContentSection> {
    List<AppContentAction> getActions();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    List<AppContentAnnotation> zzDF();

    String zzDH();

    List<AppContentCard> zzDP();

    String zzDQ();

    String zzDv();
}
