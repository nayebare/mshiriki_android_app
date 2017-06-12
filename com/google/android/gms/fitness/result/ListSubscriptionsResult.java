package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSubscriptionsResult extends zza implements Result {
    public static final Creator<ListSubscriptionsResult> CREATOR;
    private final int mVersionCode;
    private final List<Subscription> zzaWz;
    private final Status zzahq;

    static {
        CREATOR = new zzo();
    }

    ListSubscriptionsResult(int i, List<Subscription> list, Status status) {
        this.mVersionCode = i;
        this.zzaWz = list;
        this.zzahq = status;
    }

    public ListSubscriptionsResult(List<Subscription> list, Status status) {
        this.mVersionCode = 3;
        this.zzaWz = Collections.unmodifiableList(list);
        this.zzahq = (Status) zzac.zzb((Object) status, Games.EXTRA_STATUS);
    }

    public static ListSubscriptionsResult zzag(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listSubscriptionsResult) {
        return this.zzahq.equals(listSubscriptionsResult.zzahq) && zzaa.equal(this.zzaWz, listSubscriptionsResult.zzaWz);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ListSubscriptionsResult) && zzb((ListSubscriptionsResult) obj));
    }

    public Status getStatus() {
        return this.zzahq;
    }

    public List<Subscription> getSubscriptions() {
        return this.zzaWz;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        List arrayList = new ArrayList();
        for (Subscription subscription : this.zzaWz) {
            if (dataType.equals(subscription.zzBL())) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzahq, this.zzaWz);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzahq).zzg("subscriptions", this.zzaWz).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
