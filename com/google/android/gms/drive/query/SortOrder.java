package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder extends zza {
    public static final Creator<SortOrder> CREATOR;
    final int mVersionCode;
    final List<zzf> zzaOJ;
    final boolean zzaOK;

    public static class Builder {
        private final List<zzf> zzaOJ;
        private boolean zzaOK;

        public Builder() {
            this.zzaOJ = new ArrayList();
            this.zzaOK = false;
        }

        public Builder addSortAscending(SortableMetadataField sortableMetadataField) {
            this.zzaOJ.add(new zzf(sortableMetadataField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField) {
            this.zzaOJ.add(new zzf(sortableMetadataField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(false, null);
        }
    }

    static {
        CREATOR = new zzb();
    }

    SortOrder(int i, List<zzf> list, boolean z) {
        this.mVersionCode = i;
        this.zzaOJ = list;
        this.zzaOK = z;
    }

    private SortOrder(List<zzf> list, boolean z) {
        this(1, (List) list, z);
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.zzaOJ), Boolean.valueOf(this.zzaOK)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
