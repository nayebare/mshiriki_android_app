package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] zzbcT;
    private final int zzauz;
    private final HashMap<String, Integer> zzbcU;

    public static final class Builder {
        private int zzauz;
        private HashMap<String, Integer> zzbcU;

        public Builder() {
            this.zzbcU = new HashMap();
            this.zzauz = 0;
        }

        public RequestUpdateOutcomes zzFy() {
            return new RequestUpdateOutcomes(this.zzbcU, null);
        }

        public Builder zziR(int i) {
            this.zzauz = i;
            return this;
        }

        public Builder zzw(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.zzbcU.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    static {
        zzbcT = new String[]{"requestId", "outcome"};
    }

    private RequestUpdateOutcomes(int i, HashMap<String, Integer> hashMap) {
        this.zzauz = i;
        this.zzbcU = hashMap;
    }

    public static RequestUpdateOutcomes zzal(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.zziR(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int zzcC = dataHolder.zzcC(i);
            builder.zzw(dataHolder.zzd("requestId", i, zzcC), dataHolder.zzc("outcome", i, zzcC));
        }
        return builder.zzFy();
    }

    public Set<String> getRequestIds() {
        return this.zzbcU.keySet();
    }

    public int getRequestOutcome(String str) {
        zzac.zzb(this.zzbcU.containsKey(str), new StringBuilder(String.valueOf(str).length() + 46).append("Request ").append(str).append(" was not part of the update operation!").toString());
        return ((Integer) this.zzbcU.get(str)).intValue();
    }
}
