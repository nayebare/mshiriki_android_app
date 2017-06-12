package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzadd {
    static AppMeasurement zzaR(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    public static List<zzadb> zzaS(Context context) {
        AppMeasurement zzaR = zzaR(context);
        if (zzaR != null) {
            Map zzaE;
            try {
                zzaE = zzaR.zzaE(false);
            } catch (Throwable e) {
                if (Log.isLoggable("FRCAnalytics", 3)) {
                    Log.d("FRCAnalytics", "Unable to get user properties.", e);
                }
                zzaE = null;
            }
            if (zzaE == null) {
                return null;
            }
            List<zzadb> arrayList = new ArrayList();
            for (Entry entry : zzaE.entrySet()) {
                if (entry.getValue() != null) {
                    arrayList.add(new zzadb((String) entry.getKey(), entry.getValue().toString()));
                }
            }
            return arrayList;
        } else if (!Log.isLoggable("FRCAnalytics", 3)) {
            return null;
        } else {
            Log.d("FRCAnalytics", "Unable to get user properties: analytics library is missing.");
            return null;
        }
    }
}
