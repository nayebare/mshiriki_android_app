package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.query.internal.zzb;
import com.google.android.gms.drive.query.internal.zzd;
import com.google.android.gms.drive.query.internal.zzn;
import com.google.android.gms.drive.query.internal.zzp;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzv;
import com.google.android.gms.drive.query.internal.zzx;
import com.google.android.gms.drive.query.internal.zzz;

public class Filters {
    public static Filter and(Filter filter, Filter... filterArr) {
        return new zzr(zzx.zzaPi, filter, filterArr);
    }

    public static Filter and(Iterable<Filter> iterable) {
        return new zzr(zzx.zzaPi, iterable);
    }

    public static Filter contains(SearchableMetadataField<String> searchableMetadataField, String str) {
        return new zzb(zzx.zzaPl, (SearchableMetadataField) searchableMetadataField, (Object) str);
    }

    public static Filter eq(CustomPropertyKey customPropertyKey, String str) {
        zzac.zzb(str != null, (Object) "Custom property value may not be null.");
        return new zzn(SearchableField.zzaOI, new zza().zza(customPropertyKey, str).zzAE());
    }

    public static <T> Filter eq(SearchableMetadataField<T> searchableMetadataField, T t) {
        return new zzb(zzx.zzaPd, (SearchableMetadataField) searchableMetadataField, (Object) t);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaPg, (SearchableMetadataField) searchableOrderedMetadataField, (Object) t);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaPh, (SearchableMetadataField) searchableOrderedMetadataField, (Object) t);
    }

    public static <T> Filter in(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        return new zzp((SearchableCollectionMetadataField) searchableCollectionMetadataField, (Object) t);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaPe, (SearchableMetadataField) searchableOrderedMetadataField, (Object) t);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaPf, (SearchableMetadataField) searchableOrderedMetadataField, (Object) t);
    }

    public static Filter not(Filter filter) {
        return new zzv(filter);
    }

    public static Filter openedByMe() {
        return new zzd(SearchableField.LAST_VIEWED_BY_ME);
    }

    public static Filter or(Filter filter, Filter... filterArr) {
        return new zzr(zzx.zzaPj, filter, filterArr);
    }

    public static Filter or(Iterable<Filter> iterable) {
        return new zzr(zzx.zzaPj, iterable);
    }

    public static Filter ownedByMe() {
        return new zzz();
    }

    public static Filter sharedWithMe() {
        return new zzd(SearchableField.zzaOH);
    }
}
