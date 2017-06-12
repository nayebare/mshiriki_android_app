package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProxyRequest extends zza {
    public static final Creator<ProxyRequest> CREATOR;
    public static final int HTTP_METHOD_DELETE;
    public static final int HTTP_METHOD_GET;
    public static final int HTTP_METHOD_HEAD;
    public static final int HTTP_METHOD_OPTIONS;
    public static final int HTTP_METHOD_PATCH;
    public static final int HTTP_METHOD_POST;
    public static final int HTTP_METHOD_PUT;
    public static final int HTTP_METHOD_TRACE;
    public static final int LAST_CODE;
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    final int versionCode;
    Bundle zzaiN;

    public static class Builder {
        private long zzUP;
        private String zzaiO;
        private int zzaiP;
        private byte[] zzaiQ;
        private Bundle zzaiR;

        public Builder(String str) {
            this.zzaiP = ProxyRequest.HTTP_METHOD_GET;
            this.zzUP = 3000;
            this.zzaiQ = null;
            this.zzaiR = new Bundle();
            zzac.zzdv(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zzaiO = str;
                return;
            }
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 51).append("The supplied url [ ").append(str).append("] is not match Patterns.WEB_URL!").toString());
        }

        public ProxyRequest build() {
            if (this.zzaiQ == null) {
                this.zzaiQ = new byte[ProxyRequest.LAST_CODE];
            }
            return new ProxyRequest(ProxyRequest.VERSION_CODE, this.zzaiO, this.zzaiP, this.zzUP, this.zzaiQ, this.zzaiR);
        }

        public Builder putHeader(String str, String str2) {
            zzac.zzh(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zzaiR;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzaiQ = bArr;
            return this;
        }

        public Builder setHttpMethod(int i) {
            boolean z = i >= 0 && i <= ProxyRequest.LAST_CODE;
            zzac.zzb(z, (Object) "Unrecognized http method code.");
            this.zzaiP = i;
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            zzac.zzb(j >= 0, (Object) "The specified timeout must be non-negative.");
            this.zzUP = j;
            return this;
        }
    }

    static {
        CREATOR = new zzc();
        HTTP_METHOD_GET = LAST_CODE;
        HTTP_METHOD_POST = 1;
        HTTP_METHOD_PUT = VERSION_CODE;
        HTTP_METHOD_DELETE = 3;
        HTTP_METHOD_HEAD = 4;
        HTTP_METHOD_OPTIONS = 5;
        HTTP_METHOD_TRACE = 6;
        HTTP_METHOD_PATCH = 7;
        LAST_CODE = 7;
    }

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzaiN = bundle;
    }

    public Map<String, String> getHeaderMap() {
        Map linkedHashMap = new LinkedHashMap(this.zzaiN.size());
        for (String str : this.zzaiN.keySet()) {
            linkedHashMap.put(str, this.zzaiN.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        return new StringBuilder(String.valueOf(str).length() + 42).append("ProxyRequest[ url: ").append(str).append(", method: ").append(this.httpMethod).append(" ]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
