package com.google.android.gms.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.util.SimpleArrayMap;

public class zzbij extends AnimatorListenerAdapter {
    private SimpleArrayMap<Animator, Boolean> zzbTT;

    public zzbij() {
        this.zzbTT = new SimpleArrayMap();
    }

    public void onAnimationCancel(Animator animator) {
        this.zzbTT.put(animator, Boolean.valueOf(true));
    }

    public void onAnimationStart(Animator animator) {
        this.zzbTT.put(animator, Boolean.valueOf(false));
    }

    protected final boolean zzb(Animator animator) {
        return this.zzbTT.containsKey(animator) && ((Boolean) this.zzbTT.get(animator)).booleanValue();
    }
}
