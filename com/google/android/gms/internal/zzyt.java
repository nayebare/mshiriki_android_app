package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzf;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.protocol.HTTP;

public final class zzyt {
    public static final zzf<zzyl> zzavu;
    public static final zzf<zzzb> zzavv;
    public static final zzf<Object> zzavw;
    public static final zzf<Object> zzavx;
    public static final Charset zzavy;
    public static final String zzavz;

    static {
        zzavu = new zzf();
        zzavv = new zzf();
        zzavw = new zzf();
        zzavx = new zzf();
        Charset charset = null;
        try {
            charset = Charset.forName(HTTP.UTF_8);
        } catch (IllegalCharsetNameException e) {
        } catch (UnsupportedCharsetException e2) {
        }
        zzavy = charset;
        zzavz = zzym.zzcQ("com.google.cast.multizone");
    }
}
