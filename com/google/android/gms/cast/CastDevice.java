package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzym;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice extends zza implements ReflectedParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 32;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Creator<CastDevice> CREATOR;
    private final int mVersionCode;
    private int zzJh;
    private String zzamg;
    String zzamh;
    private Inet4Address zzami;
    private String zzamj;
    private String zzamk;
    private String zzaml;
    private int zzamm;
    private List<WebImage> zzamn;
    private int zzamo;
    private String zzamp;

    static {
        CREATOR = new zze();
    }

    CastDevice(int i, String str, String str2, String str3, String str4, String str5, int i2, List<WebImage> list, int i3, int i4, String str6) {
        List arrayList;
        this.mVersionCode = i;
        this.zzamg = zzcE(str);
        this.zzamh = zzcE(str2);
        if (!TextUtils.isEmpty(this.zzamh)) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzamh);
                if (byName instanceof Inet4Address) {
                    this.zzami = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                String str7 = this.zzamh;
                String valueOf = String.valueOf(e.getMessage());
                Log.i("CastDevice", new StringBuilder((String.valueOf(str7).length() + 48) + String.valueOf(valueOf).length()).append("Unable to convert host address (").append(str7).append(") to ipaddress: ").append(valueOf).toString());
            }
        }
        this.zzamj = zzcE(str3);
        this.zzamk = zzcE(str4);
        this.zzaml = zzcE(str5);
        this.zzamm = i2;
        if (list == null) {
            arrayList = new ArrayList();
        }
        this.zzamn = arrayList;
        this.zzamo = i3;
        this.zzJh = i4;
        this.zzamp = zzcE(str6);
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzcE(String str) {
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return this.zzamg == null ? castDevice.zzamg == null : zzym.zza(this.zzamg, castDevice.zzamg) && zzym.zza(this.zzami, castDevice.zzami) && zzym.zza(this.zzamk, castDevice.zzamk) && zzym.zza(this.zzamj, castDevice.zzamj) && zzym.zza(this.zzaml, castDevice.zzaml) && this.zzamm == castDevice.zzamm && zzym.zza(this.zzamn, castDevice.zzamn) && this.zzamo == castDevice.zzamo && this.zzJh == castDevice.zzJh && zzym.zza(this.zzamp, castDevice.zzamp);
    }

    public int getCapabilities() {
        return this.zzamo;
    }

    public String getDeviceId() {
        return this.zzamg.startsWith("__cast_nearby__") ? this.zzamg.substring("__cast_nearby__".length() + CAPABILITY_VIDEO_OUT) : this.zzamg;
    }

    public String getDeviceVersion() {
        return this.zzaml;
    }

    public String getFriendlyName() {
        return this.zzamj;
    }

    public WebImage getIcon(int i, int i2) {
        WebImage webImage = null;
        if (this.zzamn.isEmpty()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return (WebImage) this.zzamn.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzamn) {
            WebImage webImage32;
            int width = webImage32.getWidth();
            int height = webImage32.getHeight();
            if (width < i || height < i2) {
                if (width < i && height < i2 && (webImage == null || (webImage.getWidth() < width && webImage.getHeight() < height))) {
                    webImage = webImage2;
                }
                webImage32 = webImage;
                webImage = webImage2;
            } else {
                if (webImage2 == null || (webImage2.getWidth() > width && webImage2.getHeight() > height)) {
                    WebImage webImage4 = webImage;
                    webImage = webImage32;
                    webImage32 = webImage4;
                }
                webImage32 = webImage;
                webImage = webImage2;
            }
            webImage2 = webImage;
            webImage = webImage32;
        }
        if (webImage2 == null) {
            webImage2 = webImage != null ? webImage : (WebImage) this.zzamn.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzamn);
    }

    public Inet4Address getIpAddress() {
        return this.zzami;
    }

    public String getModelName() {
        return this.zzamk;
    }

    public int getServicePort() {
        return this.zzamm;
    }

    public int getStatus() {
        return this.zzJh;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasCapabilities(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i += CAPABILITY_VIDEO_OUT) {
            if (!hasCapability(iArr[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int i) {
        return (this.zzamo & i) == i;
    }

    public boolean hasIcons() {
        return !this.zzamn.isEmpty();
    }

    public int hashCode() {
        return this.zzamg == null ? 0 : this.zzamg.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzamg.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        return castDevice == null ? false : this.zzamg == null ? castDevice.zzamg == null : zzym.zza(this.zzamg, castDevice.zzamg);
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        Object[] objArr = new Object[CAPABILITY_VIDEO_IN];
        objArr[0] = this.zzamj;
        objArr[CAPABILITY_VIDEO_OUT] = this.zzamg;
        return String.format("\"%s\" (%s)", objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public String zzrJ() {
        return this.zzamg;
    }

    public String zzrK() {
        return this.zzamp;
    }
}
