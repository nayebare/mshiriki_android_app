package com.google.android.gms.internal;

@zzmb
public class zzqh {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection zzb(java.lang.String r8, int r9) throws java.io.IOException {
        /*
        r7 = this;
        r2 = 0;
        r0 = new java.net.URL;
        r0.<init>(r8);
        r1 = r0;
        r0 = r2;
    L_0x0008:
        r3 = r0 + 1;
        r0 = 20;
        if (r3 > r0) goto L_0x00a1;
    L_0x000e:
        r0 = r1.openConnection();
        r0.setConnectTimeout(r9);
        r0.setReadTimeout(r9);
        r4 = r0 instanceof java.net.HttpURLConnection;
        if (r4 != 0) goto L_0x0024;
    L_0x001c:
        r0 = new java.io.IOException;
        r1 = "Invalid protocol.";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r0 = (java.net.HttpURLConnection) r0;
        r0.setInstanceFollowRedirects(r2);
        r4 = r0.getResponseCode();
        r4 = r4 / 100;
        r5 = 3;
        if (r4 != r5) goto L_0x00a9;
    L_0x0032:
        r4 = "Location";
        r5 = r0.getHeaderField(r4);
        if (r5 != 0) goto L_0x0042;
    L_0x003a:
        r0 = new java.io.IOException;
        r1 = "Missing Location header in redirect";
        r0.<init>(r1);
        throw r0;
    L_0x0042:
        r4 = new java.net.URL;
        r4.<init>(r1, r5);
        r1 = r4.getProtocol();
        if (r1 != 0) goto L_0x0055;
    L_0x004d:
        r0 = new java.io.IOException;
        r1 = "Protocol is null";
        r0.<init>(r1);
        throw r0;
    L_0x0055:
        r6 = "http";
        r6 = r1.equals(r6);
        if (r6 != 0) goto L_0x0081;
    L_0x005d:
        r6 = "https";
        r6 = r1.equals(r6);
        if (r6 != 0) goto L_0x0081;
    L_0x0065:
        r2 = new java.io.IOException;
        r3 = "Unsupported scheme: ";
        r0 = java.lang.String.valueOf(r1);
        r1 = r0.length();
        if (r1 == 0) goto L_0x007b;
    L_0x0073:
        r0 = r3.concat(r0);
    L_0x0077:
        r2.<init>(r0);
        throw r2;
    L_0x007b:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x0077;
    L_0x0081:
        r6 = "Redirecting to ";
        r1 = java.lang.String.valueOf(r5);
        r5 = r1.length();
        if (r5 == 0) goto L_0x009b;
    L_0x008d:
        r1 = r6.concat(r1);
    L_0x0091:
        com.google.android.gms.internal.zzpy.zzbc(r1);
        r0.disconnect();
        r0 = r3;
        r1 = r4;
        goto L_0x0008;
    L_0x009b:
        r1 = new java.lang.String;
        r1.<init>(r6);
        goto L_0x0091;
    L_0x00a1:
        r0 = new java.io.IOException;
        r1 = "Too many redirects (20)";
        r0.<init>(r1);
        throw r0;
    L_0x00a9:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqh.zzb(java.lang.String, int):java.net.HttpURLConnection");
    }
}
