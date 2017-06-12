package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.util.zzk;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    protected static boolean zzf(Integer num) {
        return num == null ? false : zzk.zzdi(num.intValue());
    }
}
