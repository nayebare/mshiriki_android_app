package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.wearable.MessageApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Goal extends zza {
    public static final Creator<Goal> CREATOR;
    public static final int OBJECTIVE_TYPE_DURATION = 2;
    public static final int OBJECTIVE_TYPE_FREQUENCY = 3;
    public static final int OBJECTIVE_TYPE_METRIC = 1;
    private final int versionCode;
    private final long zzaSo;
    private final long zzaSp;
    private final List<Integer> zzaSq;
    private final Recurrence zzaSr;
    private final int zzaSs;
    private final MetricObjective zzaSt;
    private final DurationObjective zzaSu;
    private final FrequencyObjective zzaSv;

    public static class DurationObjective extends zza {
        public static final Creator<DurationObjective> CREATOR;
        private final int versionCode;
        private final long zzaSw;

        static {
            CREATOR = new zzo();
        }

        DurationObjective(int i, long j) {
            this.versionCode = i;
            this.zzaSw = j;
        }

        public DurationObjective(long j, TimeUnit timeUnit) {
            this((int) Goal.OBJECTIVE_TYPE_METRIC, timeUnit.toNanos(j));
        }

        private boolean zza(DurationObjective durationObjective) {
            return this.zzaSw == durationObjective.zzaSw;
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof DurationObjective) && zza((DurationObjective) obj));
        }

        public long getDuration() {
            return this.zzaSw;
        }

        public long getDuration(TimeUnit timeUnit) {
            return timeUnit.convert(this.zzaSw, TimeUnit.NANOSECONDS);
        }

        int getVersionCode() {
            return this.versionCode;
        }

        public int hashCode() {
            return (int) this.zzaSw;
        }

        public String toString() {
            return zzaa.zzv(this).zzg("duration", Long.valueOf(this.zzaSw)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzo.zza(this, parcel, i);
        }
    }

    public static class FrequencyObjective extends zza {
        public static final Creator<FrequencyObjective> CREATOR;
        private final int frequency;
        private final int versionCode;

        static {
            CREATOR = new zzq();
        }

        public FrequencyObjective(int i) {
            this(Goal.OBJECTIVE_TYPE_METRIC, i);
        }

        FrequencyObjective(int i, int i2) {
            this.versionCode = i;
            this.frequency = i2;
        }

        private boolean zza(FrequencyObjective frequencyObjective) {
            return this.frequency == frequencyObjective.frequency;
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof FrequencyObjective) && zza((FrequencyObjective) obj));
        }

        public int getFrequency() {
            return this.frequency;
        }

        int getVersionCode() {
            return this.versionCode;
        }

        public int hashCode() {
            return this.frequency;
        }

        public String toString() {
            return zzaa.zzv(this).zzg("frequency", Integer.valueOf(this.frequency)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzq.zza(this, parcel, i);
        }
    }

    public static class MetricObjective extends zza {
        public static final Creator<MetricObjective> CREATOR;
        private final double value;
        private final int versionCode;
        private final String zzaSx;
        private final double zzaSy;

        static {
            CREATOR = new zzw();
        }

        MetricObjective(int i, String str, double d, double d2) {
            this.versionCode = i;
            this.zzaSx = str;
            this.value = d;
            this.zzaSy = d2;
        }

        public MetricObjective(String str, double d) {
            this(Goal.OBJECTIVE_TYPE_METRIC, str, d, 0.0d);
        }

        private boolean zza(MetricObjective metricObjective) {
            return zzaa.equal(this.zzaSx, metricObjective.zzaSx) && this.value == metricObjective.value && this.zzaSy == metricObjective.zzaSy;
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof MetricObjective) && zza((MetricObjective) obj));
        }

        public String getDataTypeName() {
            return this.zzaSx;
        }

        public double getValue() {
            return this.value;
        }

        int getVersionCode() {
            return this.versionCode;
        }

        public int hashCode() {
            return this.zzaSx.hashCode();
        }

        public String toString() {
            return zzaa.zzv(this).zzg("dataTypeName", this.zzaSx).zzg("value", Double.valueOf(this.value)).zzg("initialValue", Double.valueOf(this.zzaSy)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzw.zza(this, parcel, i);
        }

        public double zzBH() {
            return this.zzaSy;
        }
    }

    public static class MismatchedGoalException extends IllegalStateException {
        public MismatchedGoalException(String str) {
            super(str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ObjectiveType {
    }

    public static class Recurrence extends zza {
        public static final Creator<Recurrence> CREATOR;
        public static final int UNIT_DAY = 1;
        public static final int UNIT_MONTH = 3;
        public static final int UNIT_WEEK = 2;
        private final int count;
        private final int versionCode;
        private final int zzaSz;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RecurrenceUnit {
        }

        static {
            CREATOR = new zzaa();
        }

        public Recurrence(int i, int i2) {
            this(UNIT_DAY, i, i2);
        }

        Recurrence(int i, int i2, int i3) {
            this.versionCode = i;
            this.count = i2;
            boolean z = i3 > 0 && i3 <= UNIT_MONTH;
            zzac.zzar(z);
            this.zzaSz = i3;
        }

        private boolean zza(Recurrence recurrence) {
            return this.count == recurrence.count && this.zzaSz == recurrence.zzaSz;
        }

        private static String zzgE(int i) {
            switch (i) {
                case UNIT_DAY /*1*/:
                    return "day";
                case UNIT_WEEK /*2*/:
                    return "week";
                case UNIT_MONTH /*3*/:
                    return "month";
                default:
                    throw new IllegalArgumentException("invalid unit value");
            }
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof Recurrence) && zza((Recurrence) obj));
        }

        public int getCount() {
            return this.count;
        }

        public int getUnit() {
            return this.zzaSz;
        }

        int getVersionCode() {
            return this.versionCode;
        }

        public int hashCode() {
            return this.zzaSz;
        }

        public String toString() {
            return zzaa.zzv(this).zzg("count", Integer.valueOf(this.count)).zzg("unit", zzgE(this.zzaSz)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzaa.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzr();
    }

    Goal(int i, long j, long j2, List<Integer> list, Recurrence recurrence, int i2, MetricObjective metricObjective, DurationObjective durationObjective, FrequencyObjective frequencyObjective) {
        List emptyList;
        this.versionCode = i;
        this.zzaSo = j;
        this.zzaSp = j2;
        if (list == null) {
            emptyList = Collections.emptyList();
        }
        this.zzaSq = emptyList;
        this.zzaSr = recurrence;
        this.zzaSs = i2;
        this.zzaSt = metricObjective;
        this.zzaSu = durationObjective;
        this.zzaSv = frequencyObjective;
    }

    private boolean zza(Goal goal) {
        return this.zzaSo == goal.zzaSo && this.zzaSp == goal.zzaSp && zzaa.equal(this.zzaSq, goal.zzaSq) && zzaa.equal(this.zzaSr, goal.zzaSr) && this.zzaSs == goal.zzaSs && zzaa.equal(this.zzaSt, goal.zzaSt) && zzaa.equal(this.zzaSu, goal.zzaSu) && zzaa.equal(this.zzaSv, goal.zzaSv);
    }

    private static String zzgC(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return FitnessActivities.UNKNOWN;
            case OBJECTIVE_TYPE_METRIC /*1*/:
                return "metric";
            case OBJECTIVE_TYPE_DURATION /*2*/:
                return "duration";
            case OBJECTIVE_TYPE_FREQUENCY /*3*/:
                return "frequency";
            default:
                throw new IllegalArgumentException("invalid objective type value");
        }
    }

    private void zzgD(int i) throws MismatchedGoalException {
        if (i != this.zzaSs) {
            Object[] objArr = new Object[OBJECTIVE_TYPE_DURATION];
            objArr[0] = zzgC(this.zzaSs);
            objArr[OBJECTIVE_TYPE_METRIC] = zzgC(i);
            throw new MismatchedGoalException(String.format("%s goal does not have %s objective", objArr));
        }
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Goal) && zza((Goal) obj));
    }

    @Nullable
    public String getActivityName() {
        return (this.zzaSq.isEmpty() || this.zzaSq.size() > OBJECTIVE_TYPE_METRIC) ? null : FitnessActivities.getName(((Integer) this.zzaSq.get(0)).intValue());
    }

    public long getCreateTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaSo, TimeUnit.NANOSECONDS);
    }

    public DurationObjective getDurationObjective() {
        zzgD(OBJECTIVE_TYPE_DURATION);
        return this.zzaSu;
    }

    public long getEndTime(Calendar calendar, TimeUnit timeUnit) {
        if (this.zzaSr == null) {
            return timeUnit.convert(this.zzaSp, TimeUnit.NANOSECONDS);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendar.getTime());
        switch (this.zzaSr.zzaSz) {
            case OBJECTIVE_TYPE_METRIC /*1*/:
                instance.add(5, OBJECTIVE_TYPE_METRIC);
                instance.set(11, 0);
                return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
            case OBJECTIVE_TYPE_DURATION /*2*/:
                instance.add(4, OBJECTIVE_TYPE_METRIC);
                instance.set(7, OBJECTIVE_TYPE_DURATION);
                instance.set(11, 0);
                return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
            case OBJECTIVE_TYPE_FREQUENCY /*3*/:
                instance.add(OBJECTIVE_TYPE_DURATION, OBJECTIVE_TYPE_METRIC);
                instance.set(5, OBJECTIVE_TYPE_METRIC);
                instance.set(11, 0);
                return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
            default:
                throw new IllegalArgumentException("Invalid unit " + this.zzaSr.zzaSz);
        }
    }

    public FrequencyObjective getFrequencyObjective() {
        zzgD(OBJECTIVE_TYPE_FREQUENCY);
        return this.zzaSv;
    }

    public MetricObjective getMetricObjective() {
        zzgD(OBJECTIVE_TYPE_METRIC);
        return this.zzaSt;
    }

    public int getObjectiveType() {
        return this.zzaSs;
    }

    public Recurrence getRecurrence() {
        return this.zzaSr;
    }

    public long getStartTime(Calendar calendar, TimeUnit timeUnit) {
        if (this.zzaSr == null) {
            return timeUnit.convert(this.zzaSo, TimeUnit.NANOSECONDS);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendar.getTime());
        switch (this.zzaSr.zzaSz) {
            case OBJECTIVE_TYPE_METRIC /*1*/:
                instance.set(11, 0);
                return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
            case OBJECTIVE_TYPE_DURATION /*2*/:
                instance.set(7, OBJECTIVE_TYPE_DURATION);
                instance.set(11, 0);
                return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
            case OBJECTIVE_TYPE_FREQUENCY /*3*/:
                instance.set(5, OBJECTIVE_TYPE_METRIC);
                instance.set(11, 0);
                return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
            default:
                throw new IllegalArgumentException("Invalid unit " + this.zzaSr.zzaSz);
        }
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.zzaSs;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("activity", getActivityName()).zzg("recurrence", this.zzaSr).zzg("metricObjective", this.zzaSt).zzg("durationObjective", this.zzaSu).zzg("frequencyObjective", this.zzaSv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }

    public long zzBB() {
        return this.zzaSo;
    }

    public long zzBC() {
        return this.zzaSp;
    }

    public List<Integer> zzBD() {
        return this.zzaSq;
    }

    public MetricObjective zzBE() {
        return this.zzaSt;
    }

    public DurationObjective zzBF() {
        return this.zzaSu;
    }

    public FrequencyObjective zzBG() {
        return this.zzaSv;
    }
}
