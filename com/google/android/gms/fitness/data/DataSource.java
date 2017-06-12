package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class DataSource extends zza {
    public static final Creator<DataSource> CREATOR;
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private static final int[] zzaRl;
    private final String name;
    private final int type;
    private final int versionCode;
    private final DataType zzaQI;
    private final Device zzaRm;
    private final zzb zzaRn;
    private final String zzaRo;
    private final int[] zzaRp;
    private final String zzaRq;

    public static final class Builder {
        private String name;
        private int type;
        private DataType zzaQI;
        private Device zzaRm;
        private zzb zzaRn;
        private String zzaRo;

        public Builder() {
            this.type = -1;
            this.zzaRo = BuildConfig.FLAVOR;
        }

        public DataSource build() {
            boolean z = true;
            zzac.zza(this.zzaQI != null, (Object) "Must set data type");
            if (this.type < 0) {
                z = false;
            }
            zzac.zza(z, (Object) "Must set data source type");
            return new DataSource();
        }

        public Builder setAppPackageName(Context context) {
            return setAppPackageName(context.getPackageName());
        }

        public Builder setAppPackageName(String str) {
            this.zzaRn = zzb.zzdZ(str);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzaQI = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.zzaRm = device;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setStreamName(String str) {
            zzac.zzb(str != null, (Object) "Must specify a valid stream name");
            this.zzaRo = str;
            return this;
        }

        public Builder setType(int i) {
            this.type = i;
            return this;
        }
    }

    static {
        zzaRl = new int[0];
        CREATOR = new zzj();
    }

    DataSource(int i, DataType dataType, String str, int i2, Device device, zzb com_google_android_gms_fitness_data_zzb, String str2, int[] iArr) {
        this.versionCode = i;
        this.zzaQI = dataType;
        this.type = i2;
        this.name = str;
        this.zzaRm = device;
        this.zzaRn = com_google_android_gms_fitness_data_zzb;
        this.zzaRo = str2;
        this.zzaRq = zzBu();
        if (iArr == null) {
            iArr = zzaRl;
        }
        this.zzaRp = iArr;
    }

    private DataSource(Builder builder) {
        this.versionCode = 3;
        this.zzaQI = builder.zzaQI;
        this.type = builder.type;
        this.name = builder.name;
        this.zzaRm = builder.zzaRm;
        this.zzaRn = builder.zzaRn;
        this.zzaRo = builder.zzaRo;
        this.zzaRq = zzBu();
        this.zzaRp = null;
    }

    public static DataSource extract(Intent intent) {
        return intent == null ? null : (DataSource) zzd.zza(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.type) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return "raw";
            case TYPE_DERIVED /*1*/:
                return "derived";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "cleaned";
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return "converted";
            default:
                return "derived";
        }
    }

    private String zzBu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeString());
        stringBuilder.append(":").append(this.zzaQI.getName());
        if (this.zzaRn != null) {
            stringBuilder.append(":").append(this.zzaRn.getPackageName());
        }
        if (this.zzaRm != null) {
            stringBuilder.append(":").append(this.zzaRm.getStreamIdentifier());
        }
        if (this.zzaRo != null) {
            stringBuilder.append(":").append(this.zzaRo);
        }
        return stringBuilder.toString();
    }

    private boolean zza(DataSource dataSource) {
        return this.zzaRq.equals(dataSource.zzaRq);
    }

    private static String zzgt(int i) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return "r";
            case TYPE_DERIVED /*1*/:
                return "d";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "c";
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return "v";
            default:
                return "?";
        }
    }

    public static String zzgu(int i) {
        switch (i) {
            case TYPE_DERIVED /*1*/:
                return "blood_pressure_esh2002";
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return "blood_pressure_esh2010";
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return "blood_pressure_aami";
            case Dimension.UNIT_IN /*4*/:
                return "blood_pressure_bhs_a_a";
            case Dimension.UNIT_MM /*5*/:
                return "blood_pressure_bhs_a_b";
            case BuyButtonText.LOGO_ONLY /*6*/:
                return "blood_pressure_bhs_b_a";
            case BuyButtonText.DONATE_WITH /*7*/:
                return "blood_pressure_bhs_b_b";
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                return "blood_glucose_iso151972003";
            case HTTP.HT /*9*/:
                return "blood_glucose_iso151972013";
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSource) && zza((DataSource) obj));
    }

    public String getAppPackageName() {
        return this.zzaRn == null ? null : this.zzaRn.getPackageName();
    }

    public DataType getDataType() {
        return this.zzaQI;
    }

    public Device getDevice() {
        return this.zzaRm;
    }

    public String getName() {
        return this.name;
    }

    public String getStreamIdentifier() {
        return this.zzaRq;
    }

    public String getStreamName() {
        return this.zzaRo;
    }

    public int getType() {
        return this.type;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.zzaRq.hashCode();
    }

    public String toDebugString() {
        String str;
        String str2;
        String valueOf;
        String valueOf2 = String.valueOf(zzgt(this.type));
        String valueOf3 = String.valueOf(this.zzaQI.zzBv());
        if (this.zzaRn == null) {
            str = BuildConfig.FLAVOR;
        } else if (this.zzaRn.equals(zzb.zzaQQ)) {
            str = ":gms";
        } else {
            str2 = ":";
            str = String.valueOf(this.zzaRn.getPackageName());
            str = str.length() != 0 ? str2.concat(str) : new String(str2);
        }
        if (this.zzaRm != null) {
            str2 = String.valueOf(this.zzaRm.getModel());
            valueOf = String.valueOf(this.zzaRm.getUid());
            str2 = new StringBuilder((String.valueOf(str2).length() + 2) + String.valueOf(valueOf).length()).append(":").append(str2).append(":").append(valueOf).toString();
        } else {
            str2 = BuildConfig.FLAVOR;
        }
        if (this.zzaRo != null) {
            String str3 = ":";
            valueOf = String.valueOf(this.zzaRo);
            valueOf = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
        } else {
            valueOf = BuildConfig.FLAVOR;
        }
        return new StringBuilder(((((String.valueOf(valueOf2).length() + TYPE_DERIVED) + String.valueOf(valueOf3).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append(valueOf2).append(":").append(valueOf3).append(str).append(str2).append(valueOf).toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(getTypeString());
        if (this.name != null) {
            stringBuilder.append(":").append(this.name);
        }
        if (this.zzaRn != null) {
            stringBuilder.append(":").append(this.zzaRn);
        }
        if (this.zzaRm != null) {
            stringBuilder.append(":").append(this.zzaRm);
        }
        if (this.zzaRo != null) {
            stringBuilder.append(":").append(this.zzaRo);
        }
        stringBuilder.append(":").append(this.zzaQI);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public zzb zzBs() {
        return this.zzaRn;
    }

    public int[] zzBt() {
        return this.zzaRp;
    }
}
