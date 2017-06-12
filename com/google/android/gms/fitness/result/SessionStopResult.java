package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.games.Games;
import java.util.Collections;
import java.util.List;

public class SessionStopResult extends zza implements Result {
    public static final Creator<SessionStopResult> CREATOR;
    private final int mVersionCode;
    private final List<Session> zzaUW;
    private final Status zzahq;

    static {
        CREATOR = new zzs();
    }

    SessionStopResult(int i, Status status, List<Session> list) {
        this.mVersionCode = i;
        this.zzahq = status;
        this.zzaUW = Collections.unmodifiableList(list);
    }

    public SessionStopResult(Status status, List<Session> list) {
        this.mVersionCode = 3;
        this.zzahq = status;
        this.zzaUW = Collections.unmodifiableList(list);
    }

    public static SessionStopResult zzai(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean zzb(SessionStopResult sessionStopResult) {
        return this.zzahq.equals(sessionStopResult.zzahq) && zzaa.equal(this.zzaUW, sessionStopResult.zzaUW);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionStopResult) && zzb((SessionStopResult) obj));
    }

    public List<Session> getSessions() {
        return this.zzaUW;
    }

    public Status getStatus() {
        return this.zzahq;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzahq, this.zzaUW);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzahq).zzg("sessions", this.zzaUW).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }
}
