package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzac;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult extends zza implements Result {
    public static final Creator<SessionReadResult> CREATOR;
    private final int mVersionCode;
    private final List<Session> zzaUW;
    private final List<zzac> zzaWB;
    private final Status zzahq;

    static {
        CREATOR = new zzr();
    }

    SessionReadResult(int i, List<Session> list, List<zzac> list2, Status status) {
        this.mVersionCode = i;
        this.zzaUW = list;
        this.zzaWB = Collections.unmodifiableList(list2);
        this.zzahq = status;
    }

    public SessionReadResult(List<Session> list, List<zzac> list2, Status status) {
        this.mVersionCode = 3;
        this.zzaUW = list;
        this.zzaWB = Collections.unmodifiableList(list2);
        this.zzahq = status;
    }

    public static SessionReadResult zzah(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzahq.equals(sessionReadResult.zzahq) && zzaa.equal(this.zzaUW, sessionReadResult.zzaUW) && zzaa.equal(this.zzaWB, sessionReadResult.zzaWB);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadResult) && zzb((SessionReadResult) obj));
    }

    public List<DataSet> getDataSet(Session session) {
        com.google.android.gms.common.internal.zzac.zzb(this.zzaUW.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (zzac com_google_android_gms_fitness_data_zzac : this.zzaWB) {
            if (zzaa.equal(session, com_google_android_gms_fitness_data_zzac.getSession())) {
                arrayList.add(com_google_android_gms_fitness_data_zzac.getDataSet());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        com.google.android.gms.common.internal.zzac.zzb(this.zzaUW.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (zzac com_google_android_gms_fitness_data_zzac : this.zzaWB) {
            if (zzaa.equal(session, com_google_android_gms_fitness_data_zzac.getSession()) && dataType.equals(com_google_android_gms_fitness_data_zzac.getDataSet().getDataType())) {
                arrayList.add(com_google_android_gms_fitness_data_zzac.getDataSet());
            }
        }
        return arrayList;
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
        return zzaa.hashCode(this.zzahq, this.zzaUW, this.zzaWB);
    }

    public String toString() {
        return zzaa.zzv(this).zzg(Games.EXTRA_STATUS, this.zzahq).zzg("sessions", this.zzaUW).zzg("sessionDataSets", this.zzaWB).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }

    public List<zzac> zzCJ() {
        return this.zzaWB;
    }
}
