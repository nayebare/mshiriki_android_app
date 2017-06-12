package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.util.zzb;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class DataType extends com.google.android.gms.common.internal.safeparcel.zza implements ReflectedParcelable {
    public static final DataType AGGREGATE_ACTIVITY_SUMMARY;
    public static final DataType AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
    public static final DataType AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
    @Deprecated
    public static final DataType AGGREGATE_CALORIES_CONSUMED;
    public static final DataType AGGREGATE_CALORIES_EXPENDED;
    public static final DataType AGGREGATE_DISTANCE_DELTA;
    @RequiresPermission(conditional = true, value = "android.permission.BODY_SENSORS")
    public static final DataType AGGREGATE_HEART_RATE_SUMMARY;
    public static final DataType AGGREGATE_HYDRATION;
    @Deprecated
    public static final Set<DataType> AGGREGATE_INPUT_TYPES;
    @RequiresPermission(conditional = true, value = "android.permission.ACCESS_FINE_LOCATION")
    public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX;
    public static final DataType AGGREGATE_NUTRITION_SUMMARY;
    public static final DataType AGGREGATE_POWER_SUMMARY;
    public static final DataType AGGREGATE_SPEED_SUMMARY;
    public static final DataType AGGREGATE_STEP_COUNT_DELTA;
    public static final DataType AGGREGATE_WEIGHT_SUMMARY;
    public static final Creator<DataType> CREATOR;
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.data_type/";
    @Deprecated
    public static final DataType TYPE_ACTIVITY_SAMPLE;
    public static final DataType TYPE_ACTIVITY_SAMPLES;
    public static final DataType TYPE_ACTIVITY_SEGMENT;
    public static final DataType TYPE_BASAL_METABOLIC_RATE;
    public static final DataType TYPE_BODY_FAT_PERCENTAGE;
    @Deprecated
    public static final DataType TYPE_CALORIES_CONSUMED;
    public static final DataType TYPE_CALORIES_EXPENDED;
    public static final DataType TYPE_CYCLING_PEDALING_CADENCE;
    public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE;
    public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION;
    public static final DataType TYPE_CYCLING_WHEEL_RPM;
    @KeepName
    @RequiresPermission(conditional = true, value = "android.permission.ACCESS_FINE_LOCATION")
    public static final DataType TYPE_DISTANCE_CUMULATIVE;
    @RequiresPermission(conditional = true, value = "android.permission.ACCESS_FINE_LOCATION")
    public static final DataType TYPE_DISTANCE_DELTA;
    @RequiresPermission(conditional = true, value = "android.permission.BODY_SENSORS")
    public static final DataType TYPE_HEART_RATE_BPM;
    public static final DataType TYPE_HEIGHT;
    public static final DataType TYPE_HYDRATION;
    @RequiresPermission(conditional = true, value = "android.permission.ACCESS_FINE_LOCATION")
    public static final DataType TYPE_LOCATION_SAMPLE;
    @RequiresPermission(conditional = true, value = "android.permission.ACCESS_FINE_LOCATION")
    public static final DataType TYPE_LOCATION_TRACK;
    public static final DataType TYPE_NUTRITION;
    public static final DataType TYPE_POWER_SAMPLE;
    @RequiresPermission(conditional = true, value = "android.permission.ACCESS_FINE_LOCATION")
    public static final DataType TYPE_SPEED;
    public static final DataType TYPE_STEP_COUNT_CADENCE;
    @KeepName
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE;
    public static final DataType TYPE_STEP_COUNT_DELTA;
    public static final DataType TYPE_WEIGHT;
    public static final DataType TYPE_WORKOUT_EXERCISE;
    public static final DataType zzaRA;
    public static final DataType zzaRr;
    public static final DataType zzaRs;
    public static final DataType zzaRt;
    public static final DataType zzaRu;
    public static final DataType zzaRv;
    public static final DataType zzaRw;
    public static final DataType zzaRx;
    public static final DataType zzaRy;
    public static final DataType zzaRz;
    private final String name;
    private final int versionCode;
    private final List<Field> zzaRB;

    public static final class zza {
        public static final DataType zzaRC;
        public static final DataType zzaRD;

        static {
            zzaRC = new DataType("com.google.internal.session.debug", com.google.android.gms.fitness.data.Field.zza.zzaSm);
            zzaRD = new DataType("com.google.internal.session.v2", com.google.android.gms.fitness.data.Field.zza.zzaSn);
        }
    }

    static {
        TYPE_STEP_COUNT_DELTA = new DataType("com.google.step_count.delta", Field.FIELD_STEPS);
        TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", Field.FIELD_STEPS);
        TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", Field.FIELD_RPM);
        zzaRr = new DataType("com.google.stride_model", Field.zzaRT);
        TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", Field.FIELD_ACTIVITY);
        zzaRs = new DataType("com.google.floor_change", Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE, Field.zzaRU, Field.zzaRX);
        TYPE_CALORIES_CONSUMED = new DataType("com.google.calories.consumed", Field.FIELD_CALORIES);
        TYPE_CALORIES_EXPENDED = new DataType("com.google.calories.expended", Field.FIELD_CALORIES);
        TYPE_BASAL_METABOLIC_RATE = new DataType("com.google.calories.bmr", Field.FIELD_CALORIES);
        TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", Field.FIELD_WATTS);
        TYPE_ACTIVITY_SAMPLE = new DataType("com.google.activity.sample", Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE);
        TYPE_ACTIVITY_SAMPLES = new DataType("com.google.activity.samples", Field.FIELD_ACTIVITY_CONFIDENCE);
        zzaRt = new DataType("com.google.accelerometer", com.google.android.gms.fitness.data.Field.zza.zzaSj, com.google.android.gms.fitness.data.Field.zza.zzaSk, com.google.android.gms.fitness.data.Field.zza.zzaSl);
        zzaRu = new DataType("com.google.sensor.events", Field.zzaSb, Field.zzaSd, Field.zzaSh);
        zzaRv = new DataType("com.google.sensor.const_rate_events", Field.zzaSc, Field.zzaSe, Field.zzaSf, Field.zzaSg, Field.zzaSh);
        TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", Field.FIELD_BPM);
        TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE);
        TYPE_LOCATION_TRACK = new DataType("com.google.location.track", Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE);
        TYPE_DISTANCE_DELTA = new DataType("com.google.distance.delta", Field.FIELD_DISTANCE);
        TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", Field.FIELD_DISTANCE);
        TYPE_SPEED = new DataType("com.google.speed", Field.FIELD_SPEED);
        TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", Field.FIELD_REVOLUTIONS);
        TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", Field.FIELD_RPM);
        TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", Field.FIELD_REVOLUTIONS);
        TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", Field.FIELD_RPM);
        TYPE_HEIGHT = new DataType("com.google.height", Field.FIELD_HEIGHT);
        TYPE_WEIGHT = new DataType("com.google.weight", Field.FIELD_WEIGHT);
        TYPE_BODY_FAT_PERCENTAGE = new DataType("com.google.body.fat.percentage", Field.FIELD_PERCENTAGE);
        zzaRw = new DataType("com.google.body.waist.circumference", Field.FIELD_CIRCUMFERENCE);
        zzaRx = new DataType("com.google.body.hip.circumference", Field.FIELD_CIRCUMFERENCE);
        TYPE_NUTRITION = new DataType("com.google.nutrition", Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE, Field.FIELD_FOOD_ITEM);
        TYPE_HYDRATION = new DataType("com.google.hydration", Field.FIELD_VOLUME);
        TYPE_WORKOUT_EXERCISE = new DataType("com.google.activity.exercise", Field.FIELD_EXERCISE, Field.FIELD_REPETITIONS, Field.FIELD_DURATION, Field.FIELD_RESISTANCE_TYPE, Field.FIELD_RESISTANCE);
        AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", Field.FIELD_ACTIVITY, Field.FIELD_DURATION, Field.FIELD_NUM_SEGMENTS);
        zzaRy = new DataType("com.google.floor_change.summary", Field.zzaRR, Field.zzaRS, Field.zzaRV, Field.zzaRW, Field.zzaRY, Field.zzaRZ);
        AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY = new DataType("com.google.calories.bmr.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_STEP_COUNT_DELTA = TYPE_STEP_COUNT_DELTA;
        AGGREGATE_DISTANCE_DELTA = TYPE_DISTANCE_DELTA;
        AGGREGATE_CALORIES_CONSUMED = TYPE_CALORIES_CONSUMED;
        AGGREGATE_CALORIES_EXPENDED = TYPE_CALORIES_EXPENDED;
        AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE);
        AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY = new DataType("com.google.body.fat.percentage.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        zzaRz = new DataType("com.google.body.hip.circumference.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        zzaRA = new DataType("com.google.body.waist.circumference.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_NUTRITION_SUMMARY = new DataType("com.google.nutrition.summary", Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE);
        AGGREGATE_HYDRATION = TYPE_HYDRATION;
        AGGREGATE_INPUT_TYPES = new com.google.android.gms.common.util.zza();
        AGGREGATE_INPUT_TYPES.add(TYPE_ACTIVITY_SEGMENT);
        AGGREGATE_INPUT_TYPES.add(TYPE_BASAL_METABOLIC_RATE);
        AGGREGATE_INPUT_TYPES.add(TYPE_BODY_FAT_PERCENTAGE);
        AGGREGATE_INPUT_TYPES.add(zzaRx);
        AGGREGATE_INPUT_TYPES.add(zzaRw);
        AGGREGATE_INPUT_TYPES.add(TYPE_CALORIES_CONSUMED);
        AGGREGATE_INPUT_TYPES.add(TYPE_CALORIES_EXPENDED);
        AGGREGATE_INPUT_TYPES.add(TYPE_DISTANCE_DELTA);
        AGGREGATE_INPUT_TYPES.add(zzaRs);
        AGGREGATE_INPUT_TYPES.add(TYPE_LOCATION_SAMPLE);
        AGGREGATE_INPUT_TYPES.add(TYPE_NUTRITION);
        AGGREGATE_INPUT_TYPES.add(TYPE_HYDRATION);
        AGGREGATE_INPUT_TYPES.add(TYPE_HEART_RATE_BPM);
        AGGREGATE_INPUT_TYPES.add(TYPE_POWER_SAMPLE);
        AGGREGATE_INPUT_TYPES.add(TYPE_SPEED);
        AGGREGATE_INPUT_TYPES.add(TYPE_STEP_COUNT_DELTA);
        AGGREGATE_INPUT_TYPES.add(TYPE_WEIGHT);
        CREATOR = new zzk();
    }

    DataType(int i, String str, List<Field> list) {
        this.versionCode = i;
        this.name = str;
        this.zzaRB = Collections.unmodifiableList(list);
    }

    public DataType(String str, Field... fieldArr) {
        this(1, str, zzb.zzb(fieldArr));
    }

    public static List<DataType> getAggregatesForInput(DataType dataType) {
        List list = (List) zza.zzaQP.get(dataType);
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public static String getMimeType(DataType dataType) {
        String valueOf = String.valueOf(MIME_TYPE_PREFIX);
        String valueOf2 = String.valueOf(dataType.getName());
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private boolean zzc(DataType dataType) {
        return this.name.equals(dataType.name) && this.zzaRB.equals(dataType.zzaRB);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataType) && zzc((DataType) obj));
    }

    public List<Field> getFields() {
        return this.zzaRB;
    }

    public String getName() {
        return this.name;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public int indexOf(Field field) {
        int indexOf = this.zzaRB.indexOf(field);
        if (indexOf >= 0) {
            return indexOf;
        }
        throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[]{field, this}));
    }

    public String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.name, this.zzaRB});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public String zzBv() {
        return this.name.startsWith("com.google.") ? this.name.substring(11) : this.name;
    }
}
