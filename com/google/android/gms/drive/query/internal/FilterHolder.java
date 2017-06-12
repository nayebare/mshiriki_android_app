package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder extends zza implements ReflectedParcelable {
    public static final Creator<FilterHolder> CREATOR;
    final int mVersionCode;
    private final Filter zzaJR;
    final zzb<?> zzaOQ;
    final zzd zzaOR;
    final zzr zzaOS;
    final zzv zzaOT;
    final zzp<?> zzaOU;
    final zzt zzaOV;
    final zzn zzaOW;
    final zzl zzaOX;
    final zzz zzaOY;

    static {
        CREATOR = new zzh();
    }

    FilterHolder(int i, zzb<?> com_google_android_gms_drive_query_internal_zzb_, zzd com_google_android_gms_drive_query_internal_zzd, zzr com_google_android_gms_drive_query_internal_zzr, zzv com_google_android_gms_drive_query_internal_zzv, zzp<?> com_google_android_gms_drive_query_internal_zzp_, zzt com_google_android_gms_drive_query_internal_zzt, zzn<?> com_google_android_gms_drive_query_internal_zzn_, zzl com_google_android_gms_drive_query_internal_zzl, zzz com_google_android_gms_drive_query_internal_zzz) {
        this.mVersionCode = i;
        this.zzaOQ = com_google_android_gms_drive_query_internal_zzb_;
        this.zzaOR = com_google_android_gms_drive_query_internal_zzd;
        this.zzaOS = com_google_android_gms_drive_query_internal_zzr;
        this.zzaOT = com_google_android_gms_drive_query_internal_zzv;
        this.zzaOU = com_google_android_gms_drive_query_internal_zzp_;
        this.zzaOV = com_google_android_gms_drive_query_internal_zzt;
        this.zzaOW = com_google_android_gms_drive_query_internal_zzn_;
        this.zzaOX = com_google_android_gms_drive_query_internal_zzl;
        this.zzaOY = com_google_android_gms_drive_query_internal_zzz;
        if (this.zzaOQ != null) {
            this.zzaJR = this.zzaOQ;
        } else if (this.zzaOR != null) {
            this.zzaJR = this.zzaOR;
        } else if (this.zzaOS != null) {
            this.zzaJR = this.zzaOS;
        } else if (this.zzaOT != null) {
            this.zzaJR = this.zzaOT;
        } else if (this.zzaOU != null) {
            this.zzaJR = this.zzaOU;
        } else if (this.zzaOV != null) {
            this.zzaJR = this.zzaOV;
        } else if (this.zzaOW != null) {
            this.zzaJR = this.zzaOW;
        } else if (this.zzaOX != null) {
            this.zzaJR = this.zzaOX;
        } else if (this.zzaOY != null) {
            this.zzaJR = this.zzaOY;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        zzac.zzb((Object) filter, (Object) "Null filter.");
        this.mVersionCode = 2;
        this.zzaOQ = filter instanceof zzb ? (zzb) filter : null;
        this.zzaOR = filter instanceof zzd ? (zzd) filter : null;
        this.zzaOS = filter instanceof zzr ? (zzr) filter : null;
        this.zzaOT = filter instanceof zzv ? (zzv) filter : null;
        this.zzaOU = filter instanceof zzp ? (zzp) filter : null;
        this.zzaOV = filter instanceof zzt ? (zzt) filter : null;
        this.zzaOW = filter instanceof zzn ? (zzn) filter : null;
        this.zzaOX = filter instanceof zzl ? (zzl) filter : null;
        this.zzaOY = filter instanceof zzz ? (zzz) filter : null;
        if (this.zzaOQ == null && this.zzaOR == null && this.zzaOS == null && this.zzaOT == null && this.zzaOU == null && this.zzaOV == null && this.zzaOW == null && this.zzaOX == null && this.zzaOY == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzaJR = filter;
    }

    public Filter getFilter() {
        return this.zzaJR;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.zzaJR});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
