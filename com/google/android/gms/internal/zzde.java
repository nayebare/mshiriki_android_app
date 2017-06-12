package com.google.android.gms.internal;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.internal.zzdh.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzmb
public class zzde {
    private final int zzyc;
    private final int zzyd;
    private final int zzye;
    private final zzdd zzyf;

    public zzde(int i) {
        this.zzyf = new zzdg();
        this.zzyd = i;
        this.zzyc = 6;
        this.zzye = 0;
    }

    String zzG(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return BuildConfig.FLAVOR;
        }
        zza zzep = zzep();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzyd, new 1(this));
        for (String zzI : split) {
            String[] zzI2 = zzdf.zzI(zzI);
            if (zzI2.length != 0) {
                zzdh.zza(zzI2, this.zzyd, this.zzyc, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzep.write(this.zzyf.zzF(((zza) it.next()).zzyj));
            } catch (Throwable e) {
                zzpy.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzep.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return zzG(stringBuffer.toString());
    }

    zza zzep() {
        return new zza();
    }
}
