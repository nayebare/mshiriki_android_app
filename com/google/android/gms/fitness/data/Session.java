package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import java.util.concurrent.TimeUnit;

public class Session extends zza {
    public static final Creator<Session> CREATOR;
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int mVersionCode;
    private final long zzaQV;
    private final int zzaQW;
    private final String zzaTJ;
    private final zzb zzaTK;
    private final Long zzaTL;
    private final String zzacd;
    private final long zzaed;

    public static class Builder {
        private String mName;
        private long zzaQV;
        private int zzaQW;
        private String zzaTJ;
        private Long zzaTL;
        private String zzacd;
        private long zzaed;

        public Builder() {
            this.zzaed = 0;
            this.zzaQV = 0;
            this.mName = null;
            this.zzaQW = 4;
        }

        public Session build() {
            boolean z = false;
            zzac.zza(this.zzaed > 0, (Object) "Start time should be specified.");
            if (this.zzaQV == 0 || this.zzaQV > this.zzaed) {
                z = true;
            }
            zzac.zza(z, (Object) "End time should be later than start time.");
            if (this.zzaTJ == null) {
                String str = this.mName == null ? BuildConfig.FLAVOR : this.mName;
                this.zzaTJ = new StringBuilder(String.valueOf(str).length() + 20).append(str).append(this.zzaed).toString();
            }
            if (this.zzacd == null) {
                this.zzacd = BuildConfig.FLAVOR;
            }
            return new Session();
        }

        public Builder setActiveTime(long j, TimeUnit timeUnit) {
            this.zzaTL = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }

        public Builder setActivity(String str) {
            return zzgM(FitnessActivities.zzdY(str));
        }

        public Builder setDescription(String str) {
            zzac.zzb(str.length() <= CardNetwork.OTHER, "Session description cannot exceed %d characters", Integer.valueOf(CardNetwork.OTHER));
            this.zzacd = str;
            return this;
        }

        public Builder setEndTime(long j, TimeUnit timeUnit) {
            zzac.zza(j >= 0, (Object) "End time should be positive.");
            this.zzaQV = timeUnit.toMillis(j);
            return this;
        }

        public Builder setIdentifier(String str) {
            boolean z = str != null && TextUtils.getTrimmedLength(str) > 0;
            zzac.zzas(z);
            this.zzaTJ = str;
            return this;
        }

        public Builder setName(String str) {
            zzac.zzb(str.length() <= 100, "Session name cannot exceed %d characters", Integer.valueOf(100));
            this.mName = str;
            return this;
        }

        public Builder setStartTime(long j, TimeUnit timeUnit) {
            zzac.zza(j > 0, (Object) "Start time should be positive.");
            this.zzaed = timeUnit.toMillis(j);
            return this;
        }

        public Builder zzgM(int i) {
            this.zzaQW = i;
            return this;
        }
    }

    static {
        CREATOR = new zzab();
    }

    Session(int i, long j, long j2, String str, String str2, String str3, int i2, zzb com_google_android_gms_fitness_data_zzb, Long l) {
        this.mVersionCode = i;
        this.zzaed = j;
        this.zzaQV = j2;
        this.mName = str;
        this.zzaTJ = str2;
        this.zzacd = str3;
        this.zzaQW = i2;
        this.zzaTK = com_google_android_gms_fitness_data_zzb;
        this.zzaTL = l;
    }

    public Session(long j, long j2, String str, String str2, String str3, int i, zzb com_google_android_gms_fitness_data_zzb, Long l) {
        this(3, j, j2, str, str2, str3, i, com_google_android_gms_fitness_data_zzb, l);
    }

    private Session(Builder builder) {
        this(builder.zzaed, builder.zzaQV, builder.mName, builder.zzaTJ, builder.zzacd, builder.zzaQW, null, builder.zzaTL);
    }

    public static Session extract(Intent intent) {
        return intent == null ? null : (Session) zzd.zza(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String str) {
        String valueOf = String.valueOf(MIME_TYPE_PREFIX);
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private boolean zza(Session session) {
        return this.zzaed == session.zzaed && this.zzaQV == session.zzaQV && zzaa.equal(this.mName, session.mName) && zzaa.equal(this.zzaTJ, session.zzaTJ) && zzaa.equal(this.zzacd, session.zzacd) && zzaa.equal(this.zzaTK, session.zzaTK) && this.zzaQW == session.zzaQW;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Session) && zza((Session) obj));
    }

    public long getActiveTime(TimeUnit timeUnit) {
        zzac.zza(this.zzaTL != null, (Object) "Active time is not set");
        return timeUnit.convert(this.zzaTL.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzaQW);
    }

    public String getAppPackageName() {
        return this.zzaTK == null ? null : this.zzaTK.getPackageName();
    }

    public String getDescription() {
        return this.zzacd;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaQV, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzaTJ;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaed, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasActiveTime() {
        return this.zzaTL != null;
    }

    public int hashCode() {
        return zzaa.hashCode(Long.valueOf(this.zzaed), Long.valueOf(this.zzaQV), this.zzaTJ);
    }

    public boolean isOngoing() {
        return this.zzaQV == 0;
    }

    public String toString() {
        return zzaa.zzv(this).zzg("startTime", Long.valueOf(this.zzaed)).zzg("endTime", Long.valueOf(this.zzaQV)).zzg("name", this.mName).zzg("identifier", this.zzaTJ).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzacd).zzg("activity", Integer.valueOf(this.zzaQW)).zzg("application", this.zzaTK).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
    }

    public Long zzBJ() {
        return this.zzaTL;
    }

    public int zzBg() {
        return this.zzaQW;
    }

    public zzb zzBs() {
        return this.zzaTK;
    }

    public long zzpN() {
        return this.zzaed;
    }

    public long zzzx() {
        return this.zzaQV;
    }
}
