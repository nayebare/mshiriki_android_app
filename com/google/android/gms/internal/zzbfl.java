package com.google.android.gms.internal;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.gms.wallet.WalletConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class zzbfl implements zzbfm {
    private HttpURLConnection zzbKt;

    zzbfl() {
    }

    private InputStream zzd(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            throw new FileNotFoundException(str);
        } else if (responseCode == 503) {
            throw new zzbfq(str);
        } else {
            throw new IOException(str);
        }
    }

    private void zze(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zze(this.zzbKt);
    }

    public InputStream zzia(String str) throws IOException {
        this.zzbKt = zzib(str);
        return zzd(this.zzbKt);
    }

    HttpURLConnection zzib(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }
}
