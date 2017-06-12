package com.google.android.gms.awareness.fence;

import android.app.PendingIntent;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaee;
import com.google.android.gms.internal.zzaeo;
import com.google.android.gms.internal.zzaeu;
import java.util.ArrayList;

public interface FenceUpdateRequest {

    public static class Builder {
        private final ArrayList<zzaeu> zzakU;

        public Builder() {
            this.zzakU = new ArrayList();
        }

        public Builder addFence(String str, AwarenessFence awarenessFence, PendingIntent pendingIntent) {
            zzac.zzdv(str);
            zzac.zzw(awarenessFence);
            zzac.zzw(pendingIntent);
            this.zzakU.add(zzaeu.zza(str, (zzaee) awarenessFence, pendingIntent));
            return this;
        }

        public FenceUpdateRequest build() {
            return new zzaeo(this.zzakU);
        }

        public Builder removeFence(PendingIntent pendingIntent) {
            zzac.zzw(pendingIntent);
            this.zzakU.add(zzaeu.zza(pendingIntent));
            return this;
        }

        public Builder removeFence(String str) {
            zzac.zzdv(str);
            this.zzakU.add(zzaeu.zzdG(str));
            return this;
        }
    }
}
