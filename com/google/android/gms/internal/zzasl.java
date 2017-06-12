package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.places.PlacesStatusCodes;

@Deprecated
public final class zzasl extends zzd<zzask> implements Result {
    private final Status zzahq;

    public zzasl(DataHolder dataHolder) {
        this(dataHolder, PlacesStatusCodes.zzdn(dataHolder.getStatusCode()));
    }

    private zzasl(DataHolder dataHolder, Status status) {
        super(dataHolder, zzask.CREATOR);
        boolean z = dataHolder == null || dataHolder.getStatusCode() == status.getStatusCode();
        zzac.zzas(z);
        this.zzahq = status;
    }

    public Status getStatus() {
        return this.zzahq;
    }
}
