package com.google.android.gms.internal;

import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhb.zza;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzgy extends zza implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private final FrameLayout zzGI;
    private Map<String, WeakReference<View>> zzGJ;
    @Nullable
    private zzgn zzGK;
    boolean zzGL;
    int zzGM;
    int zzGN;
    @Nullable
    private zzgu zzGd;
    private final Object zzrN;
    @Nullable
    private FrameLayout zzsc;

    public zzgy(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzrN = new Object();
        this.zzGJ = new HashMap();
        this.zzGL = false;
        this.zzGI = frameLayout;
        this.zzsc = frameLayout2;
        zzv.zzdh().zza(this.zzGI, (OnGlobalLayoutListener) this);
        zzv.zzdh().zza(this.zzGI, (OnScrollChangedListener) this);
        this.zzGI.setOnTouchListener(this);
        this.zzGI.setOnClickListener(this);
    }

    private void zzd(zzgv com_google_android_gms_internal_zzgv) {
        synchronized (this.zzrN) {
            if (this.zzGJ == null || !this.zzGJ.containsKey("2011")) {
                com_google_android_gms_internal_zzgv.zzfW();
                return;
            }
            View view = (View) ((WeakReference) this.zzGJ.get("2011")).get();
            if (view instanceof FrameLayout) {
                com_google_android_gms_internal_zzgv.zza(view, new 2(this, view));
                return;
            }
            com_google_android_gms_internal_zzgv.zzfW();
        }
    }

    public void destroy() {
        synchronized (this.zzrN) {
            if (this.zzsc != null) {
                this.zzsc.removeAllViews();
            }
            this.zzsc = null;
            this.zzGJ = null;
            this.zzGK = null;
            this.zzGd = null;
        }
    }

    int getMeasuredHeight() {
        return this.zzGI.getMeasuredHeight();
    }

    int getMeasuredWidth() {
        return this.zzGI.getMeasuredWidth();
    }

    public void onClick(View view) {
        synchronized (this.zzrN) {
            if (this.zzGd == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", zzB(this.zzGM));
                jSONObject.put("y", zzB(this.zzGN));
            } catch (JSONException e) {
                zzpy.zzbe("Unable to get click location");
            }
            if (this.zzGK == null || !this.zzGK.zzfJ().equals(view)) {
                this.zzGd.zza(view, this.zzGJ, jSONObject, this.zzGI);
            } else if (!(this.zzGd instanceof zzgt) || ((zzgt) this.zzGd).zzfT() == null) {
                this.zzGd.zza(view, "1007", jSONObject, this.zzGJ, this.zzGI);
            } else {
                ((zzgt) this.zzGd).zzfT().zza(view, "1007", jSONObject, this.zzGJ, this.zzGI);
            }
        }
    }

    public void onGlobalLayout() {
        synchronized (this.zzrN) {
            if (this.zzGL) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0 || this.zzsc == null)) {
                    this.zzsc.setLayoutParams(new LayoutParams(measuredWidth, measuredHeight));
                    this.zzGL = false;
                }
            }
            if (this.zzGd != null) {
                this.zzGd.zzd(this.zzGI, this.zzGJ);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.zzrN) {
            if (this.zzGd != null) {
                this.zzGd.zzd(this.zzGI, this.zzGJ);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.zzrN) {
            if (this.zzGd == null) {
            } else {
                Point zze = zze(motionEvent);
                this.zzGM = zze.x;
                this.zzGN = zze.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) zze.x, (float) zze.y);
                this.zzGd.zzd(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    int zzB(int i) {
        return zzeh.zzeO().zzc(this.zzGd.getContext(), i);
    }

    public zzd zzU(String str) {
        Object obj = null;
        synchronized (this.zzrN) {
            if (this.zzGJ == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) this.zzGJ.get(str);
            if (weakReference != null) {
                View view = (View) weakReference.get();
            }
            zzd zzA = zze.zzA(obj);
            return zzA;
        }
    }

    @Nullable
    zzgn zzc(zzgv com_google_android_gms_internal_zzgv) {
        return com_google_android_gms_internal_zzgv.zza((OnClickListener) this);
    }

    public void zzc(String str, zzd com_google_android_gms_dynamic_zzd) {
        View view = (View) zze.zzE(com_google_android_gms_dynamic_zzd);
        synchronized (this.zzrN) {
            if (this.zzGJ == null) {
                return;
            }
            if (view == null) {
                this.zzGJ.remove(str);
            } else {
                this.zzGJ.put(str, new WeakReference(view));
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    Point zze(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.zzGI.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    public void zze(zzd com_google_android_gms_dynamic_zzd) {
        synchronized (this.zzrN) {
            zzj(null);
            Object zzE = zze.zzE(com_google_android_gms_dynamic_zzd);
            if (zzE instanceof zzgv) {
                if (this.zzsc != null) {
                    this.zzsc.setLayoutParams(new LayoutParams(0, 0));
                    this.zzGI.requestLayout();
                }
                this.zzGL = true;
                zzgv com_google_android_gms_internal_zzgv = (zzgv) zzE;
                if (this.zzGd != null && ((Boolean) zzfx.zzDV.get()).booleanValue()) {
                    this.zzGd.zzc(this.zzGI, this.zzGJ);
                }
                if ((this.zzGd instanceof zzgt) && ((zzgt) this.zzGd).zzfS()) {
                    ((zzgt) this.zzGd).zzc(com_google_android_gms_internal_zzgv);
                } else {
                    this.zzGd = com_google_android_gms_internal_zzgv;
                    if (com_google_android_gms_internal_zzgv instanceof zzgt) {
                        ((zzgt) com_google_android_gms_internal_zzgv).zzc(null);
                    }
                }
                if (((Boolean) zzfx.zzDV.get()).booleanValue()) {
                    this.zzsc.setClickable(false);
                }
                this.zzsc.removeAllViews();
                this.zzGK = zzc(com_google_android_gms_internal_zzgv);
                if (this.zzGK != null) {
                    if (this.zzGJ != null) {
                        this.zzGJ.put("1007", new WeakReference(this.zzGK.zzfJ()));
                    }
                    this.zzsc.addView(this.zzGK);
                }
                com_google_android_gms_internal_zzgv.zza(this.zzGI, this.zzGJ, (OnTouchListener) this, (OnClickListener) this);
                zzpi.zzWR.post(new 1(this, com_google_android_gms_internal_zzgv));
                zzj(this.zzGI);
                return;
            }
            zzpy.zzbe("Not an instance of native engine. This is most likely a transient error");
        }
    }

    void zzj(@Nullable View view) {
        if (this.zzGd != null) {
            zzgu zzfT = this.zzGd instanceof zzgt ? ((zzgt) this.zzGd).zzfT() : this.zzGd;
            if (zzfT != null) {
                zzfT.zzj(view);
            }
        }
    }
}
