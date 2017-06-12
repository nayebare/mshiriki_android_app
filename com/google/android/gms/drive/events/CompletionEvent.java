package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzahp;
import com.google.android.gms.internal.zzain;
import com.google.android.gms.internal.zzalh;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent extends zza implements ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR;
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int mVersionCode;
    final int zzJh;
    final DriveId zzaJj;
    final ParcelFileDescriptor zzaKm;
    final ParcelFileDescriptor zzaKn;
    final MetadataBundle zzaKo;
    final List<String> zzaKp;
    final IBinder zzaKq;
    private boolean zzaKr;
    private boolean zzaKs;
    private boolean zzaKt;
    final String zzaht;

    static {
        CREATOR = new zzg();
    }

    CompletionEvent(int i, DriveId driveId, String str, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, MetadataBundle metadataBundle, List<String> list, int i2, IBinder iBinder) {
        this.zzaKr = false;
        this.zzaKs = false;
        this.zzaKt = false;
        this.mVersionCode = i;
        this.zzaJj = driveId;
        this.zzaht = str;
        this.zzaKm = parcelFileDescriptor;
        this.zzaKn = parcelFileDescriptor2;
        this.zzaKo = metadataBundle;
        this.zzaKp = list;
        this.zzJh = i2;
        this.zzaKq = iBinder;
    }

    private void zzy(boolean z) {
        zzzY();
        this.zzaKt = true;
        zzo.zza(this.zzaKm);
        zzo.zza(this.zzaKn);
        if (this.zzaKo != null && this.zzaKo.zzc(zzalh.zzaOf)) {
            ((BitmapTeleporter) this.zzaKo.zza(zzalh.zzaOf)).release();
        }
        if (this.zzaKq == null) {
            String str = "CompletionEvent";
            String str2 = "No callback on ";
            String valueOf = String.valueOf(z ? "snooze" : "dismiss");
            zzahp.zzF(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        try {
            zzain.zza.zzbO(this.zzaKq).zzy(z);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            str2 = "CompletionEvent";
            valueOf = z ? "snooze" : "dismiss";
            str = String.valueOf(remoteException);
            zzahp.zzF(str2, new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(str).length()).append("RemoteException on ").append(valueOf).append(": ").append(str).toString());
        }
    }

    private void zzzY() {
        if (this.zzaKt) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public void dismiss() {
        zzy(false);
    }

    public String getAccountName() {
        zzzY();
        return this.zzaht;
    }

    public InputStream getBaseContentsInputStream() {
        zzzY();
        if (this.zzaKm == null) {
            return null;
        }
        if (this.zzaKr) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzaKr = true;
        return new FileInputStream(this.zzaKm.getFileDescriptor());
    }

    public DriveId getDriveId() {
        zzzY();
        return this.zzaJj;
    }

    public InputStream getModifiedContentsInputStream() {
        zzzY();
        if (this.zzaKn == null) {
            return null;
        }
        if (this.zzaKs) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzaKs = true;
        return new FileInputStream(this.zzaKn.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzzY();
        return this.zzaKo != null ? new MetadataChangeSet(this.zzaKo) : null;
    }

    public int getStatus() {
        zzzY();
        return this.zzJh;
    }

    public List<String> getTrackingTags() {
        zzzY();
        return new ArrayList(this.zzaKp);
    }

    public int getType() {
        return STATUS_CONFLICT;
    }

    public void snooze() {
        zzy(true);
    }

    public String toString() {
        String str;
        if (this.zzaKp == null) {
            str = "<null>";
        } else {
            str = String.valueOf(TextUtils.join("','", this.zzaKp));
            str = new StringBuilder(String.valueOf(str).length() + STATUS_CONFLICT).append("'").append(str).append("'").toString();
        }
        Object[] objArr = new Object[STATUS_CANCELED];
        objArr[0] = this.zzaJj;
        objArr[STATUS_FAILURE] = Integer.valueOf(this.zzJh);
        objArr[STATUS_CONFLICT] = str;
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i | STATUS_FAILURE);
    }
}
