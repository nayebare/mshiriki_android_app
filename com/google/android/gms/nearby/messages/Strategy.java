package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class Strategy extends zza {
    public static final Strategy BLE_ONLY;
    public static final Creator<Strategy> CREATOR;
    public static final Strategy DEFAULT;
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    public static final Strategy zzbxE;
    final int mVersionCode;
    @Deprecated
    final int zzbxF;
    final int zzbxG;
    final int zzbxH;
    @Deprecated
    final boolean zzbxI;
    final int zzbxJ;
    final int zzbxK;
    private final int zzbxL;

    static {
        CREATOR = new zzd();
        DEFAULT = new Builder().build();
        BLE_ONLY = new Builder().zzlP(DISCOVERY_MODE_SCAN).setTtlSeconds(TTL_SECONDS_INFINITE).build();
        zzbxE = BLE_ONLY;
    }

    Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        this.mVersionCode = i;
        this.zzbxF = i2;
        if (i2 != 0) {
            switch (i2) {
                case DISCOVERY_MODE_SCAN /*2*/:
                    this.zzbxK = DISTANCE_TYPE_EARSHOT;
                    break;
                case DISCOVERY_MODE_DEFAULT /*3*/:
                    this.zzbxK = DISCOVERY_MODE_SCAN;
                    break;
                default:
                    this.zzbxK = DISCOVERY_MODE_DEFAULT;
                    break;
            }
        }
        this.zzbxK = i6;
        this.zzbxH = i4;
        this.zzbxI = z;
        if (!z) {
            this.zzbxG = i3;
            switch (i5) {
                case MessageApi.UNKNOWN_REQUEST_ID /*-1*/:
                case DISTANCE_TYPE_DEFAULT /*0*/:
                case DISTANCE_TYPE_EARSHOT /*1*/:
                case BuyButtonText.LOGO_ONLY /*6*/:
                    this.zzbxJ = -1;
                    break;
                default:
                    this.zzbxJ = i5;
                    break;
            }
        }
        this.zzbxJ = DISCOVERY_MODE_SCAN;
        this.zzbxG = TTL_SECONDS_INFINITE;
        this.zzbxL = i7;
    }

    private static String zzlL(int i) {
        switch (i) {
            case DISTANCE_TYPE_DEFAULT /*0*/:
                return "DEFAULT";
            case DISTANCE_TYPE_EARSHOT /*1*/:
                return "ALWAYS_ON";
            default:
                return "UNKNOWN: " + i;
        }
    }

    private static String zzlM(int i) {
        switch (i) {
            case DISTANCE_TYPE_DEFAULT /*0*/:
                return "DEFAULT";
            case DISTANCE_TYPE_EARSHOT /*1*/:
                return "EARSHOT";
            default:
                return "UNKNOWN:" + i;
        }
    }

    private static String zzlN(int i) {
        if (i == -1) {
            return "DEFAULT";
        }
        List arrayList = new ArrayList();
        if ((i & 4) > 0) {
            arrayList.add("ULTRASOUND");
        }
        if ((i & DISCOVERY_MODE_SCAN) > 0) {
            arrayList.add("BLE");
        }
        return arrayList.isEmpty() ? "UNKNOWN:" + i : arrayList.toString();
    }

    private static String zzlO(int i) {
        if (i == DISCOVERY_MODE_DEFAULT) {
            return "DEFAULT";
        }
        List arrayList = new ArrayList();
        if ((i & DISTANCE_TYPE_EARSHOT) > 0) {
            arrayList.add("BROADCAST");
        }
        if ((i & DISCOVERY_MODE_SCAN) > 0) {
            arrayList.add("SCAN");
        }
        return arrayList.isEmpty() ? "UNKNOWN:" + i : arrayList.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.mVersionCode == strategy.mVersionCode && this.zzbxK == strategy.zzbxK && this.zzbxG == strategy.zzbxG && this.zzbxH == strategy.zzbxH && this.zzbxJ == strategy.zzbxJ;
    }

    public int hashCode() {
        return (((((((this.mVersionCode * 31) + this.zzbxK) * 31) + this.zzbxG) * 31) + this.zzbxH) * 31) + this.zzbxJ;
    }

    public String toString() {
        int i = this.zzbxG;
        String valueOf = String.valueOf(zzlM(this.zzbxH));
        String valueOf2 = String.valueOf(zzlN(this.zzbxJ));
        String valueOf3 = String.valueOf(zzlO(this.zzbxK));
        String valueOf4 = String.valueOf(zzlL(this.zzbxL));
        return new StringBuilder((((String.valueOf(valueOf).length() + Quests.SELECT_ENDING_SOON) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append("Strategy{ttlSeconds=").append(i).append(", distanceType=").append(valueOf).append(", discoveryMedium=").append(valueOf2).append(", discoveryMode=").append(valueOf3).append(", backgroundScanMode=").append(valueOf4).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public int zzNd() {
        return this.zzbxJ;
    }

    public int zzNe() {
        return this.zzbxK;
    }

    public int zzNf() {
        return this.zzbxL;
    }
}
