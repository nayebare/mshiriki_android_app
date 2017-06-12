package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.wearable.MessageApi;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class VideoInfo extends zza {
    public static final Creator<VideoInfo> CREATOR;
    public static final int HDR_TYPE_DV = 3;
    public static final int HDR_TYPE_HDR = 4;
    public static final int HDR_TYPE_HDR10 = 2;
    public static final int HDR_TYPE_SDR = 1;
    public static final int HDR_TYPE_UNKNOWN = 0;
    private final int mVersionCode;
    private int zzaoO;
    private int zzrG;
    private int zzrH;

    static {
        CREATOR = new zzo();
    }

    VideoInfo(int i, int i2, int i3, int i4) {
        this.mVersionCode = i;
        this.zzrG = i2;
        this.zzrH = i3;
        this.zzaoO = i4;
    }

    static VideoInfo zzq(JSONObject jSONObject) {
        int i = HDR_TYPE_HDR10;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("hdrType");
            int i2 = -1;
            switch (string.hashCode()) {
                case 3218:
                    if (string.equals("dv")) {
                        i2 = 0;
                        break;
                    }
                    break;
                case 103158:
                    if (string.equals("hdr")) {
                        i2 = HDR_TYPE_HDR10;
                        break;
                    }
                    break;
                case 113729:
                    if (string.equals("sdr")) {
                        i2 = HDR_TYPE_DV;
                        break;
                    }
                    break;
                case 99136405:
                    if (string.equals("hdr10")) {
                        i2 = HDR_TYPE_SDR;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    i = HDR_TYPE_DV;
                    break;
                case HDR_TYPE_SDR /*1*/:
                    break;
                case HDR_TYPE_HDR10 /*2*/:
                    i = HDR_TYPE_HDR;
                    break;
                case HDR_TYPE_DV /*3*/:
                    i = HDR_TYPE_SDR;
                    break;
                default:
                    Object[] objArr = new Object[HDR_TYPE_SDR];
                    objArr[0] = string;
                    Log.d("VideoInfo", String.format(Locale.ROOT, "Unknown HDR type: %s", objArr));
                    i = 0;
                    break;
            }
            return new VideoInfo(HDR_TYPE_SDR, jSONObject.getInt("width"), jSONObject.getInt("height"), i);
        } catch (JSONException e) {
            Object[] objArr2 = new Object[HDR_TYPE_SDR];
            objArr2[0] = e.getMessage();
            Log.d("VideoInfo", String.format(Locale.ROOT, "Error while creating a VideoInfo instance from JSON: %s", objArr2));
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.zzrH == videoInfo.getHeight() && this.zzrG == videoInfo.getWidth() && this.zzaoO == videoInfo.getHdrType();
    }

    public int getHdrType() {
        return this.zzaoO;
    }

    public int getHeight() {
        return this.zzrH;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zzrG;
    }

    public int hashCode() {
        Object[] objArr = new Object[HDR_TYPE_DV];
        objArr[0] = Integer.valueOf(this.zzrH);
        objArr[HDR_TYPE_SDR] = Integer.valueOf(this.zzrG);
        objArr[HDR_TYPE_HDR10] = Integer.valueOf(this.zzaoO);
        return zzaa.hashCode(objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
