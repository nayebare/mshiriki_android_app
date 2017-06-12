package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;

public class AccountChangeEventsRequest extends zza {
    public static final Creator<AccountChangeEventsRequest> CREATOR;
    final int mVersion;
    Account zzagg;
    @Deprecated
    String zzaht;
    int zzahv;

    static {
        CREATOR = new zzb();
    }

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.mVersion = i;
        this.zzahv = i2;
        this.zzaht = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzagg = account;
        } else {
            this.zzagg = new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        }
    }

    public Account getAccount() {
        return this.zzagg;
    }

    @Deprecated
    public String getAccountName() {
        return this.zzaht;
    }

    public int getEventIndex() {
        return this.zzahv;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzagg = account;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzaht = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzahv = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
