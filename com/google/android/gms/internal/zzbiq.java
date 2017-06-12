package com.google.android.gms.internal;

import android.graphics.PointF;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.ArrayList;

public class zzbiq {
    private static final com.google.android.gms.internal.zzbio.zzb zzbUj;
    private static final com.google.android.gms.internal.zzbio.zza zzbUk;
    private ArrayList<zzd> zzaId;

    private static class zza {
        zza zzbUl;
        float zzbUm;
        PointF zzbUn;

        zza(zza com_google_android_gms_internal_zzbiq_zza, float f, PointF pointF) {
            this.zzbUl = com_google_android_gms_internal_zzbiq_zza;
            this.zzbUm = f;
            this.zzbUn = pointF;
        }
    }

    public interface zzd {
        void zza(ArrayList<PointF> arrayList, ArrayList<Float> arrayList2, float f, PointF pointF);
    }

    public static class zzb implements zzd {
        final float zzbUo;
        final float zzbUp;
        final float zzbUq;
        final float zzbUr;
        final float zzbUs;
        final float zzbUt;
        private final boolean zzbUu;

        public zzb(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.zzbUo = f;
            this.zzbUp = f2;
            this.zzbUq = f3;
            this.zzbUr = f4;
            this.zzbUs = f5;
            this.zzbUt = f6;
            this.zzbUu = z;
        }

        public void zza(ArrayList<PointF> arrayList, ArrayList<Float> arrayList2, float f, PointF pointF) {
            PointF[] pointFArr;
            PointF pointF2 = arrayList.isEmpty() ? new PointF(0.0f, 0.0f) : (PointF) arrayList.get(arrayList.size() - 1);
            if (this.zzbUu) {
                PointF[] pointFArr2 = new PointF[4];
                pointFArr2[0] = pointF2;
                pointFArr2[1] = new PointF(this.zzbUo + pointF2.x, this.zzbUp + pointF2.y);
                pointFArr2[2] = new PointF(this.zzbUq + pointF2.x, this.zzbUr + pointF2.y);
                pointFArr2[3] = new PointF(this.zzbUs + pointF2.x, pointF2.y + this.zzbUt);
                pointFArr = pointFArr2;
            } else {
                pointFArr = new PointF[]{pointF2, new PointF(this.zzbUo, this.zzbUp), new PointF(this.zzbUq, this.zzbUr), new PointF(this.zzbUs, this.zzbUt)};
            }
            zzbiq.zza(pointFArr, zzbiq.zzbUk, true, arrayList, arrayList2, f, pointF);
        }
    }

    public static class zzc implements zzd {
        final float f27x;
        final float f28y;
        private final boolean zzbUu;

        public zzc(float f, float f2, boolean z) {
            this.f27x = f;
            this.f28y = f2;
            this.zzbUu = z;
        }

        public void zza(ArrayList<PointF> arrayList, ArrayList<Float> arrayList2, float f, PointF pointF) {
            PointF pointF2;
            if (arrayList2.isEmpty()) {
                arrayList2.add(Float.valueOf(0.0f));
            } else {
                arrayList2.add((Float) arrayList2.get(arrayList2.size() - 1));
            }
            if (!this.zzbUu || arrayList.isEmpty()) {
                pointF2 = new PointF(this.f27x, this.f28y);
            } else {
                pointF2 = (PointF) arrayList.get(arrayList.size() - 1);
                pointF2 = new PointF(pointF2.x + this.f27x, pointF2.y + this.f28y);
            }
            arrayList.add(pointF2);
            pointF.set(pointF2);
        }
    }

    static {
        zzbUj = new com.google.android.gms.internal.zzbio.zzb();
        zzbUk = new com.google.android.gms.internal.zzbio.zza();
    }

    public zzbiq() {
        this.zzaId = new ArrayList();
    }

    private static void zza(PointF[] pointFArr, zzbio com_google_android_gms_internal_zzbio, boolean z, ArrayList<PointF> arrayList, ArrayList<Float> arrayList2, float f, PointF pointF) {
        zza com_google_android_gms_internal_zzbiq_zza = new zza(null, TextTrackStyle.DEFAULT_FONT_SCALE, com_google_android_gms_internal_zzbio.zza(TextTrackStyle.DEFAULT_FONT_SCALE, pointFArr, new PointF()));
        zza com_google_android_gms_internal_zzbiq_zza2 = new zza(com_google_android_gms_internal_zzbiq_zza, 0.0f, com_google_android_gms_internal_zzbio.zza(0.0f, pointFArr, new PointF()));
        float[] fArr = new float[1];
        zza com_google_android_gms_internal_zzbiq_zza3 = com_google_android_gms_internal_zzbiq_zza2;
        boolean z2 = z;
        while (com_google_android_gms_internal_zzbiq_zza != null) {
            boolean z3;
            do {
                zza com_google_android_gms_internal_zzbiq_zza4 = com_google_android_gms_internal_zzbiq_zza;
                boolean z4 = z2;
                PointF pointF2 = new PointF();
                boolean zza = zza(pointFArr, com_google_android_gms_internal_zzbio, com_google_android_gms_internal_zzbiq_zza3.zzbUm, com_google_android_gms_internal_zzbiq_zza3.zzbUn, com_google_android_gms_internal_zzbiq_zza4.zzbUm, com_google_android_gms_internal_zzbiq_zza4.zzbUn, fArr, pointF2, f);
                if (!zza && z4) {
                    float[] fArr2 = new float[1];
                    PointF[] pointFArr2 = pointFArr;
                    zzbio com_google_android_gms_internal_zzbio2 = com_google_android_gms_internal_zzbio;
                    zza = zza(pointFArr2, com_google_android_gms_internal_zzbio2, com_google_android_gms_internal_zzbiq_zza3.zzbUm, com_google_android_gms_internal_zzbiq_zza3.zzbUn, fArr[0], pointF2, fArr2, new PointF(), f);
                    if (zza) {
                        z3 = zza;
                        z2 = false;
                        if (z3) {
                            com_google_android_gms_internal_zzbiq_zza = com_google_android_gms_internal_zzbiq_zza4;
                            continue;
                        } else {
                            com_google_android_gms_internal_zzbiq_zza = new zza(com_google_android_gms_internal_zzbiq_zza4, fArr[0], pointF2);
                            com_google_android_gms_internal_zzbiq_zza3.zzbUl = com_google_android_gms_internal_zzbiq_zza;
                            continue;
                        }
                    }
                }
                z3 = zza;
                z2 = z4;
                if (z3) {
                    com_google_android_gms_internal_zzbiq_zza = com_google_android_gms_internal_zzbiq_zza4;
                    continue;
                } else {
                    com_google_android_gms_internal_zzbiq_zza = new zza(com_google_android_gms_internal_zzbiq_zza4, fArr[0], pointF2);
                    com_google_android_gms_internal_zzbiq_zza3.zzbUl = com_google_android_gms_internal_zzbiq_zza;
                    continue;
                }
            } while (z3);
            com_google_android_gms_internal_zzbiq_zza3 = com_google_android_gms_internal_zzbiq_zza;
            com_google_android_gms_internal_zzbiq_zza = com_google_android_gms_internal_zzbiq_zza.zzbUl;
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new PointF(0.0f, 0.0f));
            arrayList2.add(Float.valueOf(0.0f));
            pointF.set(0.0f, 0.0f);
        }
        PointF pointF3 = (PointF) arrayList.get(arrayList.size() - 1);
        PointF pointF4 = pointF3;
        float floatValue = ((Float) arrayList2.get(arrayList2.size() - 1)).floatValue();
        PointF pointF5 = pointF4;
        for (zza com_google_android_gms_internal_zzbiq_zza5 = com_google_android_gms_internal_zzbiq_zza2; com_google_android_gms_internal_zzbiq_zza5 != null; com_google_android_gms_internal_zzbiq_zza5 = com_google_android_gms_internal_zzbiq_zza5.zzbUl) {
            arrayList.add(com_google_android_gms_internal_zzbiq_zza5.zzbUn);
            floatValue += PointF.length(com_google_android_gms_internal_zzbiq_zza5.zzbUn.x - pointF5.x, com_google_android_gms_internal_zzbiq_zza5.zzbUn.y - pointF5.y);
            arrayList2.add(Float.valueOf(floatValue));
            pointF5 = com_google_android_gms_internal_zzbiq_zza5.zzbUn;
        }
    }

    static boolean zza(PointF[] pointFArr, zzbio com_google_android_gms_internal_zzbio, float f, PointF pointF, float f2, PointF pointF2, float[] fArr, PointF pointF3, float f3) {
        fArr[0] = (f2 + f) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
        float f4 = (pointF2.x + pointF.x) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
        float f5 = (pointF2.y + pointF.y) / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
        com_google_android_gms_internal_zzbio.zza(fArr[0], pointFArr, pointF3);
        f4 = pointF3.x - f4;
        f5 = pointF3.y - f5;
        return (f4 * f4) + (f5 * f5) > f3;
    }

    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.zzaId.add(new zzb(f, f2, f3, f4, f5, f6, false));
    }

    public void moveTo(float f, float f2) {
        this.zzaId.add(new zzc(f, f2, false));
    }

    float[] zzj(float f) {
        float f2;
        int i = 0;
        int size = this.zzaId.size();
        ArrayList arrayList = new ArrayList(size + 1);
        ArrayList arrayList2 = new ArrayList(size + 1);
        float f3 = f * f;
        PointF pointF = new PointF();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzd) this.zzaId.get(i2)).zza(arrayList, arrayList2, f3, pointF);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new PointF(0.0f, 0.0f));
            arrayList2.add(Float.valueOf(0.0f));
        }
        float floatValue = ((Float) arrayList2.get(arrayList2.size() - 1)).floatValue();
        if (floatValue == 0.0f) {
            arrayList.add((PointF) arrayList.get(arrayList.size() - 1));
            arrayList2.add(Float.valueOf(TextTrackStyle.DEFAULT_FONT_SCALE));
            f2 = TextTrackStyle.DEFAULT_FONT_SCALE;
        } else {
            f2 = floatValue;
        }
        int size2 = arrayList.size();
        float[] fArr = new float[(size2 * 3)];
        size = 0;
        while (i < size2) {
            PointF pointF2 = (PointF) arrayList.get(i);
            int i3 = size + 1;
            fArr[size] = ((Float) arrayList2.get(i)).floatValue() / f2;
            size = i3 + 1;
            fArr[i3] = pointF2.x;
            int i4 = size + 1;
            fArr[size] = pointF2.y;
            i++;
            size = i4;
        }
        return fArr;
    }
}
