package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query extends zza {
    public static final Creator<Query> CREATOR;
    final int mVersionCode;
    final List<DriveSpace> zzaKk;
    private final Set<DriveSpace> zzaKl;
    final boolean zzaMr;
    final zzr zzaOB;
    final String zzaOC;
    final SortOrder zzaOD;
    final List<String> zzaOE;
    final boolean zzaOF;

    public static class Builder {
        private Set<DriveSpace> zzaKl;
        private boolean zzaMr;
        private String zzaOC;
        private SortOrder zzaOD;
        private List<String> zzaOE;
        private boolean zzaOF;
        private final List<Filter> zzaOG;

        public Builder() {
            this.zzaOG = new ArrayList();
        }

        public Builder(Query query) {
            this.zzaOG = new ArrayList();
            this.zzaOG.add(query.getFilter());
            this.zzaOC = query.getPageToken();
            this.zzaOD = query.getSortOrder();
            this.zzaOE = query.zzAN();
            this.zzaOF = query.zzAO();
            this.zzaKl = query.zzAP();
            this.zzaMr = query.zzAQ();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof zzt)) {
                this.zzaOG.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(this.zzaOC, this.zzaOD, this.zzaOE, this.zzaOF, this.zzaKl, this.zzaMr, null);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzaOC = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzaOD = sortOrder;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    private Query(int i, zzr com_google_android_gms_drive_query_internal_zzr, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, Set<DriveSpace> set, boolean z2) {
        this.mVersionCode = i;
        this.zzaOB = com_google_android_gms_drive_query_internal_zzr;
        this.zzaOC = str;
        this.zzaOD = sortOrder;
        this.zzaOE = list;
        this.zzaOF = z;
        this.zzaKk = list2;
        this.zzaKl = set;
        this.zzaMr = z2;
    }

    Query(int i, zzr com_google_android_gms_drive_query_internal_zzr, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, boolean z2) {
        this(i, com_google_android_gms_drive_query_internal_zzr, str, sortOrder, list, z, list2, list2 == null ? null : new HashSet(list2), z2);
    }

    private Query(zzr com_google_android_gms_drive_query_internal_zzr, String str, SortOrder sortOrder, List<String> list, boolean z, Set<DriveSpace> set, boolean z2) {
        this(1, com_google_android_gms_drive_query_internal_zzr, str, sortOrder, list, z, set == null ? null : new ArrayList(set), set, z2);
    }

    public Filter getFilter() {
        return this.zzaOB;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzaOC;
    }

    public SortOrder getSortOrder() {
        return this.zzaOD;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzaOB, this.zzaOD, this.zzaOC, this.zzaKk});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List<String> zzAN() {
        return this.zzaOE;
    }

    public boolean zzAO() {
        return this.zzaOF;
    }

    public Set<DriveSpace> zzAP() {
        return this.zzaKl;
    }

    public boolean zzAQ() {
        return this.zzaMr;
    }
}
