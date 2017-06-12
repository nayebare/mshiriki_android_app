package com.google.android.gms.cast.framework;

import java.util.Locale;

public final class CastState {
    public static final int CONNECTED = 4;
    public static final int CONNECTING = 3;
    public static final int NOT_CONNECTED = 2;
    public static final int NO_DEVICES_AVAILABLE = 1;

    private CastState() {
    }

    public static String toString(int i) {
        switch (i) {
            case NO_DEVICES_AVAILABLE /*1*/:
                return "NO_DEVICES_AVAILABLE";
            case NOT_CONNECTED /*2*/:
                return "NOT_CONNECTED";
            case CONNECTING /*3*/:
                return "CONNECTING";
            case CONNECTED /*4*/:
                return "CONNECTED";
            default:
                Object[] objArr = new Object[NO_DEVICES_AVAILABLE];
                objArr[0] = Integer.valueOf(i);
                return String.format(Locale.ROOT, "UNKNOWN_STATE(%d)", objArr);
        }
    }
}
