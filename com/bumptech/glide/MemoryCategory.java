package com.bumptech.glide;

import com.google.android.gms.cast.TextTrackStyle;

public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(TextTrackStyle.DEFAULT_FONT_SCALE),
    HIGH(1.5f);
    
    private float multiplier;

    private MemoryCategory(float multiplier) {
        this.multiplier = multiplier;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
