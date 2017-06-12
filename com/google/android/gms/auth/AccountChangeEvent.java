package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class AccountChangeEvent extends zza {
    public static final Creator<AccountChangeEvent> CREATOR;
    final int mVersion;
    final long zzahs;
    final String zzaht;
    final int zzahu;
    final int zzahv;
    final String zzahw;

    static {
        CREATOR = new zza();
    }

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.zzahs = j;
        this.zzaht = (String) zzac.zzw(str);
        this.zzahu = i2;
        this.zzahv = i3;
        this.zzahw = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.zzahs = j;
        this.zzaht = (String) zzac.zzw(str);
        this.zzahu = i;
        this.zzahv = i2;
        this.zzahw = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.mVersion == accountChangeEvent.mVersion && this.zzahs == accountChangeEvent.zzahs && zzaa.equal(this.zzaht, accountChangeEvent.zzaht) && this.zzahu == accountChangeEvent.zzahu && this.zzahv == accountChangeEvent.zzahv && zzaa.equal(this.zzahw, accountChangeEvent.zzahw);
    }

    public String getAccountName() {
        return this.zzaht;
    }

    public String getChangeData() {
        return this.zzahw;
    }

    public int getChangeType() {
        return this.zzahu;
    }

    public int getEventIndex() {
        return this.zzahv;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.zzahs), this.zzaht, Integer.valueOf(this.zzahu), Integer.valueOf(this.zzahv), this.zzahw);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzahu) {
            case MessageApi.FILTER_PREFIX /*1*/:
                str = "ADDED";
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                str = "REMOVED";
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                str = "RENAMED_FROM";
                break;
            case Dimension.UNIT_IN /*4*/:
                str = "RENAMED_TO";
                break;
        }
        String str2 = this.zzaht;
        String str3 = this.zzahw;
        return new StringBuilder(((String.valueOf(str2).length() + 91) + String.valueOf(str).length()) + String.valueOf(str3).length()).append("AccountChangeEvent {accountName = ").append(str2).append(", changeType = ").append(str).append(", changeData = ").append(str3).append(", eventIndex = ").append(this.zzahv).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
