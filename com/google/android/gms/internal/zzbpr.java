package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.util.Base64;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.wallet.WalletConstants;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.protocol.HTTP;

class zzbpr {
    private String protocol;
    private URI zzchO;
    private String zzcid;
    private Map<String, String> zzcie;

    public zzbpr(URI uri, String str, Map<String, String> map) {
        this.zzchO = null;
        this.protocol = null;
        this.zzcid = null;
        this.zzcie = null;
        this.zzchO = uri;
        this.protocol = str;
        this.zzcie = map;
        this.zzcid = zzZP();
    }

    private int zzC(int i, int i2) {
        return (int) ((Math.random() * ((double) i2)) + ((double) i));
    }

    private String zzZP() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) zzC(0, MotionEventCompat.ACTION_MASK);
        }
        return Base64.encodeToString(bArr, 2);
    }

    private String zza(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        String str2 = str;
        for (String str3 : linkedHashMap.keySet()) {
            String valueOf = String.valueOf(str2);
            str2 = (String) linkedHashMap.get(str3);
            str2 = new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(str3).length()) + String.valueOf(str2).length()).append(valueOf).append(str3).append(": ").append(str2).append("\r\n").toString();
        }
        return str2;
    }

    public byte[] zzZO() {
        Object obj;
        String path = this.zzchO.getPath();
        String query = this.zzchO.getQuery();
        String valueOf = String.valueOf(path);
        if (query == null) {
            obj = BuildConfig.FLAVOR;
        } else {
            String str = "?";
            path = String.valueOf(query);
            obj = path.length() != 0 ? str.concat(path) : new String(str);
        }
        path = String.valueOf(obj);
        valueOf = path.length() != 0 ? valueOf.concat(path) : new String(valueOf);
        obj = this.zzchO.getHost();
        if (this.zzchO.getPort() != -1) {
            path = String.valueOf(obj);
            obj = new StringBuilder(String.valueOf(path).length() + 12).append(path).append(":").append(this.zzchO.getPort()).toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HTTP.TARGET_HOST, obj);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.zzcid);
        if (this.protocol != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", this.protocol);
        }
        if (this.zzcie != null) {
            for (String path2 : this.zzcie.keySet()) {
                if (!linkedHashMap.containsKey(path2)) {
                    linkedHashMap.put(path2, (String) this.zzcie.get(path2));
                }
            }
        }
        query = String.valueOf(new StringBuilder(String.valueOf(valueOf).length() + 15).append("GET ").append(valueOf).append(" HTTP/1.1\r\n").toString());
        path2 = String.valueOf(zza(linkedHashMap));
        path2 = String.valueOf(path2.length() != 0 ? query.concat(path2) : new String(query)).concat("\r\n");
        Object obj2 = new byte[path2.getBytes().length];
        System.arraycopy(path2.getBytes(), 0, obj2, 0, path2.getBytes().length);
        return obj2;
    }

    public void zzd(HashMap<String, String> hashMap) {
        if (!((String) hashMap.get("Upgrade")).toLowerCase(Locale.US).equals("websocket")) {
            throw new zzbpq("connection failed: missing header field in server handshake: Upgrade");
        } else if (!((String) hashMap.get(HTTP.CONN_DIRECTIVE)).toLowerCase(Locale.US).equals("upgrade")) {
            throw new zzbpq("connection failed: missing header field in server handshake: Connection");
        }
    }

    public void zzjd(String str) {
        int intValue = Integer.valueOf(str.substring(9, 12)).intValue();
        if (intValue == 407) {
            throw new zzbpq("connection failed: proxy authentication not supported");
        } else if (intValue == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            throw new zzbpq("connection failed: 404 not found");
        } else if (intValue != Quests.SELECT_COMPLETED_UNCLAIMED) {
            throw new zzbpq("connection failed: unknown status code " + intValue);
        }
    }
}
