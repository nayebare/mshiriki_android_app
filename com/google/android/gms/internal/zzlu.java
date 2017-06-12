package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzlu implements Callable<zzov> {
    static long zzPS;
    private final Context mContext;
    private final zzlt zzGp;
    private final zzav zzGr;
    private int zzPF;
    private final zza zzPo;
    private final zzpp zzQb;
    private final zzr zzQc;
    private boolean zzQd;
    private List<String> zzQe;
    private JSONObject zzQf;
    private final Object zzrN;
    private final zzgf zzsr;

    static {
        zzPS = TimeUnit.SECONDS.toMillis(60);
    }

    public zzlu(Context context, zzr com_google_android_gms_ads_internal_zzr, zzpp com_google_android_gms_internal_zzpp, zzav com_google_android_gms_internal_zzav, zza com_google_android_gms_internal_zzov_zza, zzgf com_google_android_gms_internal_zzgf) {
        this.zzrN = new Object();
        this.mContext = context;
        this.zzQc = com_google_android_gms_ads_internal_zzr;
        this.zzQb = com_google_android_gms_internal_zzpp;
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzGr = com_google_android_gms_internal_zzav;
        this.zzsr = com_google_android_gms_internal_zzgf;
        this.zzGp = zza(context, com_google_android_gms_internal_zzov_zza, com_google_android_gms_ads_internal_zzr, com_google_android_gms_internal_zzav);
        this.zzGp.zziE();
        this.zzQd = false;
        this.zzPF = -2;
        this.zzQe = null;
    }

    private zzgu.zza zza(zza com_google_android_gms_internal_zzlu_zza, JSONObject jSONObject, String str) throws ExecutionException, InterruptedException, JSONException {
        if (zziQ() || com_google_android_gms_internal_zzlu_zza == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] zzd = zzd(jSONObject2, "impression_tracking_urls");
        this.zzQe = zzd == null ? null : Arrays.asList(zzd);
        this.zzQf = jSONObject2.optJSONObject("active_view");
        zzgu.zza zza = com_google_android_gms_internal_zzlu_zza.zza(this, jSONObject);
        if (zza == null) {
            zzpy.m25e("Failed to retrieve ad assets.");
            return null;
        }
        zza.zzb(new zzgv(this.mContext, this.zzQc, this.zzGp, this.zzGr, jSONObject, zza, this.zzPo.zzSF.zzvf, str));
        return zza;
    }

    private zzqf<zzgo> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzqd(new zzgo(null, Uri.parse(string), optDouble)) : this.zzQb.zza(string, new 6(this, z, optDouble, optBoolean, string));
        } else {
            zza(0, z);
            return new zzqd(null);
        }
    }

    private void zza(zzgu.zza com_google_android_gms_internal_zzgu_zza) {
        if (com_google_android_gms_internal_zzgu_zza instanceof zzgr) {
            zzgr com_google_android_gms_internal_zzgr = (zzgr) com_google_android_gms_internal_zzgu_zza;
            zzb com_google_android_gms_internal_zzlu_zzb = new zzb(this);
            3 3 = new 3(this, com_google_android_gms_internal_zzgr);
            com_google_android_gms_internal_zzlu_zzb.zzQz = 3;
            this.zzGp.zza(new 4(this, 3));
        }
    }

    private JSONObject zzaG(String str) throws ExecutionException, InterruptedException, TimeoutException, JSONException {
        if (zziQ()) {
            return null;
        }
        zzqc com_google_android_gms_internal_zzqc = new zzqc();
        this.zzGp.zza(new 1(this, str, new zzb(this), com_google_android_gms_internal_zzqc));
        return (JSONObject) com_google_android_gms_internal_zzqc.get(zzPS, TimeUnit.MILLISECONDS);
    }

    private zzov zzb(zzgu.zza com_google_android_gms_internal_zzgu_zza) {
        int i;
        synchronized (this.zzrN) {
            i = this.zzPF;
            if (com_google_android_gms_internal_zzgu_zza == null && this.zzPF == -2) {
                i = 0;
            }
        }
        return new zzov(this.zzPo.zzSF.zzRd, null, this.zzPo.zzVB.zzJY, i, this.zzPo.zzVB.zzJZ, this.zzQe, this.zzPo.zzVB.orientation, this.zzPo.zzVB.zzKe, this.zzPo.zzSF.zzRg, false, null, null, null, null, null, 0, this.zzPo.zzvj, this.zzPo.zzVB.zzRJ, this.zzPo.zzVv, this.zzPo.zzVw, this.zzPo.zzVB.zzRP, this.zzQf, i != -2 ? null : com_google_android_gms_internal_zzgu_zza, null, null, null, this.zzPo.zzVB.zzSc, this.zzPo.zzVB.zzSd, null, this.zzPo.zzVB.zzKb, this.zzPo.zzVB.zzSg);
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private void zzb(zzhh com_google_android_gms_internal_zzhh, String str) {
        try {
            zzhl zzz = this.zzQc.zzz(com_google_android_gms_internal_zzhh.getCustomTemplateId());
            if (zzz != null) {
                zzz.zza(com_google_android_gms_internal_zzhh, str);
            }
        } catch (Throwable e) {
            zzpy.zzc(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private String[] zzd(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private static List<Drawable> zzh(List<zzgo> list) throws RemoteException {
        List<Drawable> arrayList = new ArrayList();
        for (zzgo zzfK : list) {
            arrayList.add((Drawable) zze.zzE(zzfK.zzfK()));
        }
        return arrayList;
    }

    public /* synthetic */ Object call() throws Exception {
        return zziP();
    }

    public void zzS(int i) {
        synchronized (this.zzrN) {
            this.zzQd = true;
            this.zzPF = i;
        }
    }

    zzlt zza(Context context, zza com_google_android_gms_internal_zzov_zza, zzr com_google_android_gms_ads_internal_zzr, zzav com_google_android_gms_internal_zzav) {
        return new zzlt(context, com_google_android_gms_internal_zzov_zza, com_google_android_gms_ads_internal_zzr, com_google_android_gms_internal_zzav);
    }

    zzlv zza(Context context, zzav com_google_android_gms_internal_zzav, zza com_google_android_gms_internal_zzov_zza, zzgf com_google_android_gms_internal_zzgf, zzr com_google_android_gms_ads_internal_zzr) {
        return new zzlv(context, com_google_android_gms_internal_zzav, com_google_android_gms_internal_zzov_zza, com_google_android_gms_internal_zzgf, com_google_android_gms_ads_internal_zzr);
    }

    public zzqf<zzgo> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzqf<zzgo>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<zzqf<zzgo>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<zzgo> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzS(i);
        }
    }

    public zzqf<zzqp> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return new zzqd(null);
        }
        if (!TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            return zza(this.mContext, this.zzGr, this.zzPo, this.zzsr, this.zzQc).zzf(optJSONObject);
        }
        zzpy.zzbe("Required field 'vast_xml' is missing");
        return new zzqd(null);
    }

    protected zza zzd(JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException, TimeoutException {
        if (zziQ() || jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzPo.zzSF.zzvx != null ? this.zzPo.zzSF.zzvx.zzGD : false;
        boolean z2 = this.zzPo.zzSF.zzvx != null ? this.zzPo.zzSF.zzvx.zzGF : false;
        if ("2".equals(string)) {
            return new zzlw(z, z2);
        }
        if ("1".equals(string)) {
            return new zzlx(z, z2);
        }
        if ("3".equals(string)) {
            String string2 = jSONObject.getString("custom_template_id");
            zzqc com_google_android_gms_internal_zzqc = new zzqc();
            zzpi.zzWR.post(new 2(this, com_google_android_gms_internal_zzqc, string2));
            if (com_google_android_gms_internal_zzqc.get(zzPS, TimeUnit.MILLISECONDS) != null) {
                return new zzly(z);
            }
            string2 = "No handler for custom template: ";
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            zzpy.m25e(valueOf.length() != 0 ? string2.concat(valueOf) : new String(string2));
        } else {
            zzS(0);
        }
        return null;
    }

    public zzqf<zzgm> zze(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzqd(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", CardNetwork.OTHER);
        int optInt3 = optJSONObject.optInt("presentation_ms", GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND);
        int i = (this.zzPo.zzSF.zzvx == null || this.zzPo.zzSF.zzvx.versionCode < 2) ? 1 : this.zzPo.zzSF.zzvx.zzGG;
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        return zzqe.zza(zzqe.zzo(arrayList), new 5(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i));
    }

    public zzov zziP() {
        try {
            this.zzGp.zziF();
            String zziR = zziR();
            JSONObject zzaG = zzaG(zziR);
            zzgu.zza zza = zza(zzd(zzaG), zzaG, zziR);
            zza(zza);
            return zzb(zza);
        } catch (CancellationException e) {
            if (!this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (ExecutionException e2) {
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (InterruptedException e3) {
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (Throwable e4) {
            zzpy.zzc("Malformed native JSON response.", e4);
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (Throwable e42) {
            zzpy.zzc("Timeout when loading native ad.", e42);
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        }
    }

    public boolean zziQ() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzQd;
        }
        return z;
    }

    String zziR() {
        return UUID.randomUUID().toString();
    }
}
