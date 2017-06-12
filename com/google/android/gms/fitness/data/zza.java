package com.google.android.gms.fitness.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zza {
    static final Map<DataType, List<DataType>> zzaQP;

    static {
        zzaQP = new HashMap();
        zzaQP.put(DataType.TYPE_ACTIVITY_SEGMENT, Collections.singletonList(DataType.AGGREGATE_ACTIVITY_SUMMARY));
        zzaQP.put(DataType.TYPE_BASAL_METABOLIC_RATE, Collections.singletonList(DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY));
        zzaQP.put(DataType.TYPE_BODY_FAT_PERCENTAGE, Collections.singletonList(DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY));
        zzaQP.put(DataType.zzaRx, Collections.singletonList(DataType.zzaRz));
        zzaQP.put(DataType.zzaRw, Collections.singletonList(DataType.zzaRA));
        zzaQP.put(DataType.TYPE_CALORIES_CONSUMED, Collections.singletonList(DataType.AGGREGATE_CALORIES_CONSUMED));
        zzaQP.put(DataType.TYPE_CALORIES_EXPENDED, Collections.singletonList(DataType.AGGREGATE_CALORIES_EXPENDED));
        zzaQP.put(DataType.TYPE_DISTANCE_DELTA, Collections.singletonList(DataType.AGGREGATE_DISTANCE_DELTA));
        zzaQP.put(DataType.zzaRs, Collections.singletonList(DataType.zzaRy));
        zzaQP.put(DataType.TYPE_LOCATION_SAMPLE, Collections.singletonList(DataType.AGGREGATE_LOCATION_BOUNDING_BOX));
        zzaQP.put(DataType.TYPE_NUTRITION, Collections.singletonList(DataType.AGGREGATE_NUTRITION_SUMMARY));
        zzaQP.put(DataType.TYPE_HYDRATION, Collections.singletonList(DataType.AGGREGATE_HYDRATION));
        zzaQP.put(DataType.TYPE_HEART_RATE_BPM, Collections.singletonList(DataType.AGGREGATE_HEART_RATE_SUMMARY));
        zzaQP.put(DataType.TYPE_POWER_SAMPLE, Collections.singletonList(DataType.AGGREGATE_POWER_SUMMARY));
        zzaQP.put(DataType.TYPE_SPEED, Collections.singletonList(DataType.AGGREGATE_SPEED_SUMMARY));
        zzaQP.put(DataType.TYPE_STEP_COUNT_DELTA, Collections.singletonList(DataType.AGGREGATE_STEP_COUNT_DELTA));
        zzaQP.put(DataType.TYPE_WEIGHT, Collections.singletonList(DataType.AGGREGATE_WEIGHT_SUMMARY));
        zzaQP.put(zzs.zzaSA, Collections.singletonList(zzs.zzaSK));
        zzaQP.put(zzs.zzaSB, Collections.singletonList(zzs.zzaSL));
        zzaQP.put(zzs.zzaSC, Collections.singletonList(zzs.zzaSM));
        zzaQP.put(zzs.zzaSD, Collections.singletonList(zzs.zzaSN));
        zzaQP.put(zzs.zzaSE, Collections.singletonList(zzs.zzaSO));
        zzaQP.put(zzs.zzaSF, Collections.singletonList(zzs.zzaSF));
        zzaQP.put(zzs.zzaSG, Collections.singletonList(zzs.zzaSG));
        zzaQP.put(zzs.zzaSH, Collections.singletonList(zzs.zzaSH));
        zzaQP.put(zzs.zzaSI, Collections.singletonList(zzs.zzaSI));
        zzaQP.put(zzs.zzaSJ, Collections.singletonList(zzs.zzaSJ));
    }
}
