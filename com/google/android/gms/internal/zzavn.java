package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;

public final class zzavn extends zza {
    public static final Creator<zzavn> CREATOR;
    private final int mVersionCode;
    private final ParcelUuid zzbxU;
    private final ParcelUuid zzbxV;
    private final ParcelUuid zzbxW;
    private final byte[] zzbxX;
    private final byte[] zzbxY;
    private final int zzbxZ;
    private final byte[] zzbya;
    private final byte[] zzbyb;

    static {
        CREATOR = new zzavo();
    }

    zzavn(int i, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        this.mVersionCode = i;
        this.zzbxU = parcelUuid;
        this.zzbxV = parcelUuid2;
        this.zzbxW = parcelUuid3;
        this.zzbxX = bArr;
        this.zzbxY = bArr2;
        this.zzbxZ = i2;
        this.zzbya = bArr3;
        this.zzbyb = bArr4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzavn com_google_android_gms_internal_zzavn = (zzavn) obj;
        return this.zzbxZ == com_google_android_gms_internal_zzavn.zzbxZ && Arrays.equals(this.zzbya, com_google_android_gms_internal_zzavn.zzbya) && Arrays.equals(this.zzbyb, com_google_android_gms_internal_zzavn.zzbyb) && zzaa.equal(this.zzbxW, com_google_android_gms_internal_zzavn.zzbxW) && Arrays.equals(this.zzbxX, com_google_android_gms_internal_zzavn.zzbxX) && Arrays.equals(this.zzbxY, com_google_android_gms_internal_zzavn.zzbxY) && zzaa.equal(this.zzbxU, com_google_android_gms_internal_zzavn.zzbxU) && zzaa.equal(this.zzbxV, com_google_android_gms_internal_zzavn.zzbxV);
    }

    public byte[] getManufacturerData() {
        return this.zzbya;
    }

    public byte[] getManufacturerDataMask() {
        return this.zzbyb;
    }

    public int getManufacturerId() {
        return this.zzbxZ;
    }

    public byte[] getServiceData() {
        return this.zzbxX;
    }

    public byte[] getServiceDataMask() {
        return this.zzbxY;
    }

    public ParcelUuid getServiceDataUuid() {
        return this.zzbxW;
    }

    public ParcelUuid getServiceUuid() {
        return this.zzbxU;
    }

    public ParcelUuid getServiceUuidMask() {
        return this.zzbxV;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzbxZ), Integer.valueOf(Arrays.hashCode(this.zzbya)), Integer.valueOf(Arrays.hashCode(this.zzbyb)), this.zzbxW, Integer.valueOf(Arrays.hashCode(this.zzbxX)), Integer.valueOf(Arrays.hashCode(this.zzbxY)), this.zzbxU, this.zzbxV);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzavo.zza(this, parcel, i);
    }
}
