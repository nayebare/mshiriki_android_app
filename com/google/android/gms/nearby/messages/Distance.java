package com.google.android.gms.nearby.messages;

import android.support.annotation.NonNull;
import com.google.android.gms.nearby.messages.internal.zze;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Distance extends Comparable<Distance> {
    public static final Distance UNKNOWN;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Accuracy {
        public static final int LOW = 1;
    }

    static {
        UNKNOWN = new zze(1, Double.NaN);
    }

    int compareTo(@NonNull Distance distance);

    int getAccuracy();

    double getMeters();
}
