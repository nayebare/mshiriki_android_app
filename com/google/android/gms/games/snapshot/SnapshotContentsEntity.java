package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.drive.zzc;
import com.google.android.gms.games.internal.GamesAbstractSafeParcelable;
import com.google.android.gms.games.internal.GamesLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity extends GamesAbstractSafeParcelable implements SnapshotContents {
    public static final Creator<SnapshotContentsEntity> CREATOR;
    private static final Object zzbeE;
    private final int mVersionCode;
    private zzc zzaLH;

    static {
        zzbeE = new Object();
        CREATOR = new SnapshotContentsEntityCreator();
    }

    SnapshotContentsEntity(int i, zzc com_google_android_gms_drive_zzc) {
        this.mVersionCode = i;
        this.zzaLH = com_google_android_gms_drive_zzc;
    }

    public SnapshotContentsEntity(zzc com_google_android_gms_drive_zzc) {
        this(1, com_google_android_gms_drive_zzc);
    }

    private boolean zza(int i, byte[] bArr, int i2, int i3, boolean z) {
        zzac.zza(!isClosed(), (Object) "Must provide a previously opened SnapshotContents");
        synchronized (zzbeE) {
            OutputStream fileOutputStream = new FileOutputStream(this.zzaLH.getParcelFileDescriptor().getFileDescriptor());
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (Throwable e) {
                GamesLog.zzb("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    public void close() {
        this.zzaLH = null;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        zzac.zza(!isClosed(), (Object) "Cannot mutate closed contents!");
        return this.zzaLH.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        return this.zzaLH == null;
    }

    public boolean modifyBytes(int i, byte[] bArr, int i2, int i3) {
        return zza(i, bArr, i2, bArr.length, false);
    }

    public byte[] readFully() throws IOException {
        byte[] zza;
        boolean z = false;
        if (!isClosed()) {
            z = true;
        }
        zzac.zza(z, (Object) "Must provide a previously opened Snapshot");
        synchronized (zzbeE) {
            InputStream fileInputStream = new FileInputStream(this.zzaLH.getParcelFileDescriptor().getFileDescriptor());
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                zza = zzo.zza(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (Throwable e) {
                GamesLog.zzc("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return zza;
    }

    public boolean writeBytes(byte[] bArr) {
        return zza(0, bArr, 0, bArr.length, true);
    }

    public void writeToParcel(Parcel parcel, int i) {
        SnapshotContentsEntityCreator.zza(this, parcel, i);
    }

    public zzc zzzB() {
        return this.zzaLH;
    }
}
