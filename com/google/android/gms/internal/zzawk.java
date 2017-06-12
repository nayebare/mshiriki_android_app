package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.mediarouter.C0308R;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.protocol.HTTP;

public final class zzawk extends zzacl implements Person {
    public static final Creator<zzawk> CREATOR;
    private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
    final int mVersionCode;
    String zzD;
    String zzGu;
    String zzabW;
    String zzaiX;
    int zzbAA;
    int zzbAB;
    String zzbAC;
    List<zzh> zzbAD;
    boolean zzbAE;
    final Set<Integer> zzbAl;
    String zzbAm;
    zza zzbAn;
    String zzbAo;
    String zzbAp;
    int zzbAq;
    zzb zzbAr;
    String zzbAs;
    zzc zzbAt;
    boolean zzbAu;
    zzd zzbAv;
    String zzbAw;
    int zzbAx;
    List<zzf> zzbAy;
    List<zzg> zzbAz;
    int zzyW;

    public static final class zza extends zzacl implements AgeRange {
        public static final Creator<zza> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
        final int mVersionCode;
        int zzbAF;
        int zzbAG;
        final Set<Integer> zzbAl;

        static {
            CREATOR = new zzawm();
            zzbAk = new HashMap();
            zzbAk.put("max", com.google.android.gms.internal.zzack.zza.zzk("max", 2));
            zzbAk.put("min", com.google.android.gms.internal.zzack.zza.zzk("min", 3));
        }

        public zza() {
            this.mVersionCode = 1;
            this.zzbAl = new HashSet();
        }

        zza(Set<Integer> set, int i, int i2, int i3) {
            this.zzbAl = set;
            this.mVersionCode = i;
            this.zzbAF = i2;
            this.zzbAG = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza com_google_android_gms_internal_zzawk_zza = (zza) obj;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    if (!com_google_android_gms_internal_zzawk_zza.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zza.zzb(com_google_android_gms_internal_zzack_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzawk_zza.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzNH();
        }

        public int getMax() {
            return this.zzbAF;
        }

        public int getMin() {
            return this.zzbAG;
        }

        public boolean hasMax() {
            return this.zzbAl.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.zzbAl.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzawm.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
            return zzbAk;
        }

        public zza zzNH() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
        }

        protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return Integer.valueOf(this.zzbAF);
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    return Integer.valueOf(this.zzbAG);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
            }
        }

        public /* synthetic */ Map zzxK() {
            return zzNF();
        }
    }

    public static final class zzb extends zzacl implements Cover {
        public static final Creator<zzb> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
        final int mVersionCode;
        zza zzbAH;
        zzb zzbAI;
        int zzbAJ;
        final Set<Integer> zzbAl;

        public static final class zza extends zzacl implements CoverInfo {
            public static final Creator<zza> CREATOR;
            private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
            final int mVersionCode;
            int zzbAK;
            int zzbAL;
            final Set<Integer> zzbAl;

            static {
                CREATOR = new zzawo();
                zzbAk = new HashMap();
                zzbAk.put("leftImageOffset", com.google.android.gms.internal.zzack.zza.zzk("leftImageOffset", 2));
                zzbAk.put("topImageOffset", com.google.android.gms.internal.zzack.zza.zzk("topImageOffset", 3));
            }

            public zza() {
                this.mVersionCode = 1;
                this.zzbAl = new HashSet();
            }

            zza(Set<Integer> set, int i, int i2, int i3) {
                this.zzbAl = set;
                this.mVersionCode = i;
                this.zzbAK = i2;
                this.zzbAL = i3;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof zza)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zza com_google_android_gms_internal_zzawk_zzb_zza = (zza) obj;
                for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                    if (zza(com_google_android_gms_internal_zzack_zza)) {
                        if (!com_google_android_gms_internal_zzawk_zzb_zza.zza(com_google_android_gms_internal_zzack_zza)) {
                            return false;
                        }
                        if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzb_zza.zzb(com_google_android_gms_internal_zzack_zza))) {
                            return false;
                        }
                    } else if (com_google_android_gms_internal_zzawk_zzb_zza.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzNJ();
            }

            public int getLeftImageOffset() {
                return this.zzbAK;
            }

            public int getTopImageOffset() {
                return this.zzbAL;
            }

            public boolean hasLeftImageOffset() {
                return this.zzbAl.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.zzbAl.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                    int hashCode;
                    if (zza(com_google_android_gms_internal_zzack_zza)) {
                        hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel parcel, int i) {
                zzawo.zza(this, parcel, i);
            }

            public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
                return zzbAk;
            }

            public zza zzNJ() {
                return this;
            }

            protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
                return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
            }

            protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
                switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                    case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        return Integer.valueOf(this.zzbAK);
                    case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                        return Integer.valueOf(this.zzbAL);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
                }
            }

            public /* synthetic */ Map zzxK() {
                return zzNF();
            }
        }

        public static final class zzb extends zzacl implements CoverPhoto {
            public static final Creator<zzb> CREATOR;
            private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
            final int mVersionCode;
            String zzD;
            final Set<Integer> zzbAl;
            int zzrG;
            int zzrH;

            static {
                CREATOR = new zzawp();
                zzbAk = new HashMap();
                zzbAk.put("height", com.google.android.gms.internal.zzack.zza.zzk("height", 2));
                zzbAk.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.zzack.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzbAk.put("width", com.google.android.gms.internal.zzack.zza.zzk("width", 4));
            }

            public zzb() {
                this.mVersionCode = 1;
                this.zzbAl = new HashSet();
            }

            zzb(Set<Integer> set, int i, int i2, String str, int i3) {
                this.zzbAl = set;
                this.mVersionCode = i;
                this.zzrH = i2;
                this.zzD = str;
                this.zzrG = i3;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof zzb)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zzb com_google_android_gms_internal_zzawk_zzb_zzb = (zzb) obj;
                for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                    if (zza(com_google_android_gms_internal_zzack_zza)) {
                        if (!com_google_android_gms_internal_zzawk_zzb_zzb.zza(com_google_android_gms_internal_zzack_zza)) {
                            return false;
                        }
                        if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzb_zzb.zzb(com_google_android_gms_internal_zzack_zza))) {
                            return false;
                        }
                    } else if (com_google_android_gms_internal_zzawk_zzb_zzb.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzNK();
            }

            public int getHeight() {
                return this.zzrH;
            }

            public String getUrl() {
                return this.zzD;
            }

            public int getWidth() {
                return this.zzrG;
            }

            public boolean hasHeight() {
                return this.zzbAl.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.zzbAl.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.zzbAl.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                    int hashCode;
                    if (zza(com_google_android_gms_internal_zzack_zza)) {
                        hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel parcel, int i) {
                zzawp.zza(this, parcel, i);
            }

            public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
                return zzbAk;
            }

            public zzb zzNK() {
                return this;
            }

            protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
                return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
            }

            protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
                switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                    case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        return Integer.valueOf(this.zzrH);
                    case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                        return this.zzD;
                    case Dimension.UNIT_IN /*4*/:
                        return Integer.valueOf(this.zzrG);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
                }
            }

            public /* synthetic */ Map zzxK() {
                return zzNF();
            }
        }

        static {
            CREATOR = new zzawn();
            zzbAk = new HashMap();
            zzbAk.put("coverInfo", com.google.android.gms.internal.zzack.zza.zza("coverInfo", 2, zza.class));
            zzbAk.put("coverPhoto", com.google.android.gms.internal.zzack.zza.zza("coverPhoto", 3, zzb.class));
            zzbAk.put("layout", com.google.android.gms.internal.zzack.zza.zza("layout", 4, new zzach().zzj("banner", 0), false));
        }

        public zzb() {
            this.mVersionCode = 1;
            this.zzbAl = new HashSet();
        }

        zzb(Set<Integer> set, int i, zza com_google_android_gms_internal_zzawk_zzb_zza, zzb com_google_android_gms_internal_zzawk_zzb_zzb, int i2) {
            this.zzbAl = set;
            this.mVersionCode = i;
            this.zzbAH = com_google_android_gms_internal_zzawk_zzb_zza;
            this.zzbAI = com_google_android_gms_internal_zzawk_zzb_zzb;
            this.zzbAJ = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzb com_google_android_gms_internal_zzawk_zzb = (zzb) obj;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    if (!com_google_android_gms_internal_zzawk_zzb.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzb.zzb(com_google_android_gms_internal_zzack_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzawk_zzb.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzNI();
        }

        public CoverInfo getCoverInfo() {
            return this.zzbAH;
        }

        public CoverPhoto getCoverPhoto() {
            return this.zzbAI;
        }

        public int getLayout() {
            return this.zzbAJ;
        }

        public boolean hasCoverInfo() {
            return this.zzbAl.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.zzbAl.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.zzbAl.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzawn.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
            return zzbAk;
        }

        public zzb zzNI() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
        }

        protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return this.zzbAH;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    return this.zzbAI;
                case Dimension.UNIT_IN /*4*/:
                    return Integer.valueOf(this.zzbAJ);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
            }
        }

        public /* synthetic */ Map zzxK() {
            return zzNF();
        }
    }

    public static final class zzc extends zzacl implements Image {
        public static final Creator<zzc> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
        final int mVersionCode;
        String zzD;
        final Set<Integer> zzbAl;

        static {
            CREATOR = new zzawq();
            zzbAk = new HashMap();
            zzbAk.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.zzack.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public zzc() {
            this.mVersionCode = 1;
            this.zzbAl = new HashSet();
        }

        public zzc(String str) {
            this.zzbAl = new HashSet();
            this.mVersionCode = 1;
            this.zzD = str;
            this.zzbAl.add(Integer.valueOf(2));
        }

        zzc(Set<Integer> set, int i, String str) {
            this.zzbAl = set;
            this.mVersionCode = i;
            this.zzD = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_internal_zzawk_zzc = (zzc) obj;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    if (!com_google_android_gms_internal_zzawk_zzc.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzc.zzb(com_google_android_gms_internal_zzack_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzawk_zzc.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzNL();
        }

        public String getUrl() {
            return this.zzD;
        }

        public boolean hasUrl() {
            return this.zzbAl.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzawq.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
            return zzbAk;
        }

        public zzc zzNL() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
        }

        protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return this.zzD;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
            }
        }

        public /* synthetic */ Map zzxK() {
            return zzNF();
        }
    }

    public static final class zzd extends zzacl implements Name {
        public static final Creator<zzd> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
        final int mVersionCode;
        String zzaik;
        String zzail;
        String zzbAM;
        String zzbAN;
        String zzbAO;
        String zzbAP;
        final Set<Integer> zzbAl;

        static {
            CREATOR = new zzawr();
            zzbAk = new HashMap();
            zzbAk.put("familyName", com.google.android.gms.internal.zzack.zza.zzm("familyName", 2));
            zzbAk.put("formatted", com.google.android.gms.internal.zzack.zza.zzm("formatted", 3));
            zzbAk.put("givenName", com.google.android.gms.internal.zzack.zza.zzm("givenName", 4));
            zzbAk.put("honorificPrefix", com.google.android.gms.internal.zzack.zza.zzm("honorificPrefix", 5));
            zzbAk.put("honorificSuffix", com.google.android.gms.internal.zzack.zza.zzm("honorificSuffix", 6));
            zzbAk.put("middleName", com.google.android.gms.internal.zzack.zza.zzm("middleName", 7));
        }

        public zzd() {
            this.mVersionCode = 1;
            this.zzbAl = new HashSet();
        }

        zzd(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.zzbAl = set;
            this.mVersionCode = i;
            this.zzail = str;
            this.zzbAM = str2;
            this.zzaik = str3;
            this.zzbAN = str4;
            this.zzbAO = str5;
            this.zzbAP = str6;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzd)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzd com_google_android_gms_internal_zzawk_zzd = (zzd) obj;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    if (!com_google_android_gms_internal_zzawk_zzd.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzd.zzb(com_google_android_gms_internal_zzack_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzawk_zzd.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzNM();
        }

        public String getFamilyName() {
            return this.zzail;
        }

        public String getFormatted() {
            return this.zzbAM;
        }

        public String getGivenName() {
            return this.zzaik;
        }

        public String getHonorificPrefix() {
            return this.zzbAN;
        }

        public String getHonorificSuffix() {
            return this.zzbAO;
        }

        public String getMiddleName() {
            return this.zzbAP;
        }

        public boolean hasFamilyName() {
            return this.zzbAl.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.zzbAl.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.zzbAl.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.zzbAl.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.zzbAl.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.zzbAl.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzawr.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
            return zzbAk;
        }

        public zzd zzNM() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
        }

        protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return this.zzail;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    return this.zzbAM;
                case Dimension.UNIT_IN /*4*/:
                    return this.zzaik;
                case Dimension.UNIT_MM /*5*/:
                    return this.zzbAN;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    return this.zzbAO;
                case BuyButtonText.DONATE_WITH /*7*/:
                    return this.zzbAP;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
            }
        }

        public /* synthetic */ Map zzxK() {
            return zzNF();
        }
    }

    public static class zze {
        public static int zzgv(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            String str2 = "Unknown objectType string: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    public static final class zzf extends zzacl implements Organizations {
        public static final Creator<zzf> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
        String mName;
        final int mVersionCode;
        String zzacd;
        String zzalD;
        int zzanR;
        String zzbAQ;
        String zzbAR;
        String zzbAS;
        boolean zzbAT;
        String zzbAU;
        final Set<Integer> zzbAl;

        static {
            CREATOR = new zzaws();
            zzbAk = new HashMap();
            zzbAk.put("department", com.google.android.gms.internal.zzack.zza.zzm("department", 2));
            zzbAk.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, com.google.android.gms.internal.zzack.zza.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzbAk.put("endDate", com.google.android.gms.internal.zzack.zza.zzm("endDate", 4));
            zzbAk.put("location", com.google.android.gms.internal.zzack.zza.zzm("location", 5));
            zzbAk.put("name", com.google.android.gms.internal.zzack.zza.zzm("name", 6));
            zzbAk.put("primary", com.google.android.gms.internal.zzack.zza.zzl("primary", 7));
            zzbAk.put("startDate", com.google.android.gms.internal.zzack.zza.zzm("startDate", 8));
            zzbAk.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, com.google.android.gms.internal.zzack.zza.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzbAk.put("type", com.google.android.gms.internal.zzack.zza.zza("type", 10, new zzach().zzj("work", 0).zzj("school", 1), false));
        }

        public zzf() {
            this.mVersionCode = 1;
            this.zzbAl = new HashSet();
        }

        zzf(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.zzbAl = set;
            this.mVersionCode = i;
            this.zzbAQ = str;
            this.zzacd = str2;
            this.zzbAR = str3;
            this.zzbAS = str4;
            this.mName = str5;
            this.zzbAT = z;
            this.zzbAU = str6;
            this.zzalD = str7;
            this.zzanR = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzf)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzf com_google_android_gms_internal_zzawk_zzf = (zzf) obj;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    if (!com_google_android_gms_internal_zzawk_zzf.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzf.zzb(com_google_android_gms_internal_zzack_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzawk_zzf.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzNN();
        }

        public String getDepartment() {
            return this.zzbAQ;
        }

        public String getDescription() {
            return this.zzacd;
        }

        public String getEndDate() {
            return this.zzbAR;
        }

        public String getLocation() {
            return this.zzbAS;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzbAU;
        }

        public String getTitle() {
            return this.zzalD;
        }

        public int getType() {
            return this.zzanR;
        }

        public boolean hasDepartment() {
            return this.zzbAl.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.zzbAl.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.zzbAl.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.zzbAl.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.zzbAl.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.zzbAl.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.zzbAl.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.zzbAl.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.zzbAl.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzbAT;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzaws.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
            return zzbAk;
        }

        public zzf zzNN() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
        }

        protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return this.zzbAQ;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    return this.zzacd;
                case Dimension.UNIT_IN /*4*/:
                    return this.zzbAR;
                case Dimension.UNIT_MM /*5*/:
                    return this.zzbAS;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    return this.mName;
                case BuyButtonText.DONATE_WITH /*7*/:
                    return Boolean.valueOf(this.zzbAT);
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    return this.zzbAU;
                case HTTP.HT /*9*/:
                    return this.zzalD;
                case HTTP.LF /*10*/:
                    return Integer.valueOf(this.zzanR);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
            }
        }

        public /* synthetic */ Map zzxK() {
            return zzNF();
        }
    }

    public static final class zzg extends zzacl implements PlacesLived {
        public static final Creator<zzg> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
        String mValue;
        final int mVersionCode;
        boolean zzbAT;
        final Set<Integer> zzbAl;

        static {
            CREATOR = new zzawt();
            zzbAk = new HashMap();
            zzbAk.put("primary", com.google.android.gms.internal.zzack.zza.zzl("primary", 2));
            zzbAk.put("value", com.google.android.gms.internal.zzack.zza.zzm("value", 3));
        }

        public zzg() {
            this.mVersionCode = 1;
            this.zzbAl = new HashSet();
        }

        zzg(Set<Integer> set, int i, boolean z, String str) {
            this.zzbAl = set;
            this.mVersionCode = i;
            this.zzbAT = z;
            this.mValue = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzg)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzg com_google_android_gms_internal_zzawk_zzg = (zzg) obj;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    if (!com_google_android_gms_internal_zzawk_zzg.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzg.zzb(com_google_android_gms_internal_zzack_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzawk_zzg.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzNO();
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.zzbAl.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.zzbAl.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzbAT;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzawt.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
            return zzbAk;
        }

        public zzg zzNO() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
        }

        protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return Boolean.valueOf(this.zzbAT);
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
            }
        }

        public /* synthetic */ Map zzxK() {
            return zzNF();
        }
    }

    public static final class zzh extends zzacl implements Urls {
        public static final Creator<zzh> CREATOR;
        private static final HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzbAk;
        String mValue;
        final int mVersionCode;
        String zzacb;
        int zzanR;
        private final int zzbAV;
        final Set<Integer> zzbAl;

        static {
            CREATOR = new zzawu();
            zzbAk = new HashMap();
            zzbAk.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, com.google.android.gms.internal.zzack.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzbAk.put("type", com.google.android.gms.internal.zzack.zza.zza("type", 6, new zzach().zzj("home", 0).zzj("work", 1).zzj("blog", 2).zzj(Scopes.PROFILE, 3).zzj(FitnessActivities.OTHER, 4).zzj("otherProfile", 5).zzj("contributor", 6).zzj("website", 7), false));
            zzbAk.put("value", com.google.android.gms.internal.zzack.zza.zzm("value", 4));
        }

        public zzh() {
            this.zzbAV = 4;
            this.mVersionCode = 1;
            this.zzbAl = new HashSet();
        }

        zzh(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.zzbAV = 4;
            this.zzbAl = set;
            this.mVersionCode = i;
            this.zzacb = str;
            this.zzanR = i2;
            this.mValue = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzh)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzh com_google_android_gms_internal_zzawk_zzh = (zzh) obj;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    if (!com_google_android_gms_internal_zzawk_zzh.zza(com_google_android_gms_internal_zzack_zza)) {
                        return false;
                    }
                    if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk_zzh.zzb(com_google_android_gms_internal_zzack_zza))) {
                        return false;
                    }
                } else if (com_google_android_gms_internal_zzawk_zzh.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzNQ();
        }

        public String getLabel() {
            return this.zzacb;
        }

        public int getType() {
            return this.zzanR;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.zzbAl.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.zzbAl.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.zzbAl.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
                int hashCode;
                if (zza(com_google_android_gms_internal_zzack_zza)) {
                    hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzawu.zza(this, parcel, i);
        }

        public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
            return zzbAk;
        }

        @Deprecated
        public int zzNP() {
            return 4;
        }

        public zzh zzNQ() {
            return this;
        }

        protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
        }

        protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
            switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
                case Dimension.UNIT_IN /*4*/:
                    return this.mValue;
                case Dimension.UNIT_MM /*5*/:
                    return this.zzacb;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    return Integer.valueOf(this.zzanR);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
            }
        }

        public /* synthetic */ Map zzxK() {
            return zzNF();
        }
    }

    static {
        CREATOR = new zzawl();
        zzbAk = new HashMap();
        zzbAk.put("aboutMe", com.google.android.gms.internal.zzack.zza.zzm("aboutMe", 2));
        zzbAk.put("ageRange", com.google.android.gms.internal.zzack.zza.zza("ageRange", 3, zza.class));
        zzbAk.put("birthday", com.google.android.gms.internal.zzack.zza.zzm("birthday", 4));
        zzbAk.put("braggingRights", com.google.android.gms.internal.zzack.zza.zzm("braggingRights", 5));
        zzbAk.put("circledByCount", com.google.android.gms.internal.zzack.zza.zzk("circledByCount", 6));
        zzbAk.put("cover", com.google.android.gms.internal.zzack.zza.zza("cover", 7, zzb.class));
        zzbAk.put("currentLocation", com.google.android.gms.internal.zzack.zza.zzm("currentLocation", 8));
        zzbAk.put("displayName", com.google.android.gms.internal.zzack.zza.zzm("displayName", 9));
        zzbAk.put("gender", com.google.android.gms.internal.zzack.zza.zza("gender", 12, new zzach().zzj("male", 0).zzj("female", 1).zzj(FitnessActivities.OTHER, 2), false));
        zzbAk.put("id", com.google.android.gms.internal.zzack.zza.zzm("id", 14));
        zzbAk.put("image", com.google.android.gms.internal.zzack.zza.zza("image", 15, zzc.class));
        zzbAk.put("isPlusUser", com.google.android.gms.internal.zzack.zza.zzl("isPlusUser", 16));
        zzbAk.put("language", com.google.android.gms.internal.zzack.zza.zzm("language", 18));
        zzbAk.put("name", com.google.android.gms.internal.zzack.zza.zza("name", 19, zzd.class));
        zzbAk.put("nickname", com.google.android.gms.internal.zzack.zza.zzm("nickname", 20));
        zzbAk.put("objectType", com.google.android.gms.internal.zzack.zza.zza("objectType", 21, new zzach().zzj("person", 0).zzj("page", 1), false));
        zzbAk.put("organizations", com.google.android.gms.internal.zzack.zza.zzb("organizations", 22, zzf.class));
        zzbAk.put("placesLived", com.google.android.gms.internal.zzack.zza.zzb("placesLived", 23, zzg.class));
        zzbAk.put("plusOneCount", com.google.android.gms.internal.zzack.zza.zzk("plusOneCount", 24));
        zzbAk.put("relationshipStatus", com.google.android.gms.internal.zzack.zza.zza("relationshipStatus", 25, new zzach().zzj("single", 0).zzj("in_a_relationship", 1).zzj("engaged", 2).zzj("married", 3).zzj("its_complicated", 4).zzj("open_relationship", 5).zzj("widowed", 6).zzj("in_domestic_partnership", 7).zzj("in_civil_union", 8), false));
        zzbAk.put("tagline", com.google.android.gms.internal.zzack.zza.zzm("tagline", 26));
        zzbAk.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.zzack.zza.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzbAk.put("urls", com.google.android.gms.internal.zzack.zza.zzb("urls", 28, zzh.class));
        zzbAk.put("verified", com.google.android.gms.internal.zzack.zza.zzl("verified", 29));
    }

    public zzawk() {
        this.mVersionCode = 1;
        this.zzbAl = new HashSet();
    }

    public zzawk(String str, String str2, zzc com_google_android_gms_internal_zzawk_zzc, int i, String str3) {
        this.mVersionCode = 1;
        this.zzbAl = new HashSet();
        this.zzaiX = str;
        this.zzbAl.add(Integer.valueOf(9));
        this.zzGu = str2;
        this.zzbAl.add(Integer.valueOf(14));
        this.zzbAt = com_google_android_gms_internal_zzawk_zzc;
        this.zzbAl.add(Integer.valueOf(15));
        this.zzbAx = i;
        this.zzbAl.add(Integer.valueOf(21));
        this.zzD = str3;
        this.zzbAl.add(Integer.valueOf(27));
    }

    zzawk(Set<Integer> set, int i, String str, zza com_google_android_gms_internal_zzawk_zza, String str2, String str3, int i2, zzb com_google_android_gms_internal_zzawk_zzb, String str4, String str5, int i3, String str6, zzc com_google_android_gms_internal_zzawk_zzc, boolean z, String str7, zzd com_google_android_gms_internal_zzawk_zzd, String str8, int i4, List<zzf> list, List<zzg> list2, int i5, int i6, String str9, String str10, List<zzh> list3, boolean z2) {
        this.zzbAl = set;
        this.mVersionCode = i;
        this.zzbAm = str;
        this.zzbAn = com_google_android_gms_internal_zzawk_zza;
        this.zzbAo = str2;
        this.zzbAp = str3;
        this.zzbAq = i2;
        this.zzbAr = com_google_android_gms_internal_zzawk_zzb;
        this.zzbAs = str4;
        this.zzaiX = str5;
        this.zzyW = i3;
        this.zzGu = str6;
        this.zzbAt = com_google_android_gms_internal_zzawk_zzc;
        this.zzbAu = z;
        this.zzabW = str7;
        this.zzbAv = com_google_android_gms_internal_zzawk_zzd;
        this.zzbAw = str8;
        this.zzbAx = i4;
        this.zzbAy = list;
        this.zzbAz = list2;
        this.zzbAA = i5;
        this.zzbAB = i6;
        this.zzbAC = str9;
        this.zzD = str10;
        this.zzbAD = list3;
        this.zzbAE = z2;
    }

    public static zzawk zzF(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzawk com_google_android_gms_internal_zzawk = (zzawk) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return com_google_android_gms_internal_zzawk;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzawk)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzawk com_google_android_gms_internal_zzawk = (zzawk) obj;
        for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
            if (zza(com_google_android_gms_internal_zzack_zza)) {
                if (!com_google_android_gms_internal_zzawk.zza(com_google_android_gms_internal_zzack_zza)) {
                    return false;
                }
                if (!zzb(com_google_android_gms_internal_zzack_zza).equals(com_google_android_gms_internal_zzawk.zzb(com_google_android_gms_internal_zzack_zza))) {
                    return false;
                }
            } else if (com_google_android_gms_internal_zzawk.zza(com_google_android_gms_internal_zzack_zza)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzNG();
    }

    public String getAboutMe() {
        return this.zzbAm;
    }

    public AgeRange getAgeRange() {
        return this.zzbAn;
    }

    public String getBirthday() {
        return this.zzbAo;
    }

    public String getBraggingRights() {
        return this.zzbAp;
    }

    public int getCircledByCount() {
        return this.zzbAq;
    }

    public Cover getCover() {
        return this.zzbAr;
    }

    public String getCurrentLocation() {
        return this.zzbAs;
    }

    public String getDisplayName() {
        return this.zzaiX;
    }

    public int getGender() {
        return this.zzyW;
    }

    public String getId() {
        return this.zzGu;
    }

    public Image getImage() {
        return this.zzbAt;
    }

    public String getLanguage() {
        return this.zzabW;
    }

    public Name getName() {
        return this.zzbAv;
    }

    public String getNickname() {
        return this.zzbAw;
    }

    public int getObjectType() {
        return this.zzbAx;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.zzbAy;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzbAz;
    }

    public int getPlusOneCount() {
        return this.zzbAA;
    }

    public int getRelationshipStatus() {
        return this.zzbAB;
    }

    public String getTagline() {
        return this.zzbAC;
    }

    public String getUrl() {
        return this.zzD;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.zzbAD;
    }

    public boolean hasAboutMe() {
        return this.zzbAl.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.zzbAl.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.zzbAl.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.zzbAl.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.zzbAl.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.zzbAl.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.zzbAl.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.zzbAl.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.zzbAl.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.zzbAl.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.zzbAl.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.zzbAl.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.zzbAl.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.zzbAl.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.zzbAl.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.zzbAl.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.zzbAl.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.zzbAl.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.zzbAl.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.zzbAl.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.zzbAl.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.zzbAl.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.zzbAl.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.zzbAl.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza : zzbAk.values()) {
            int hashCode;
            if (zza(com_google_android_gms_internal_zzack_zza)) {
                hashCode = zzb(com_google_android_gms_internal_zzack_zza).hashCode() + (i + com_google_android_gms_internal_zzack_zza.zzxQ());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.zzbAu;
    }

    public boolean isVerified() {
        return this.zzbAE;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzawl.zza(this, parcel, i);
    }

    public HashMap<String, com.google.android.gms.internal.zzack.zza<?, ?>> zzNF() {
        return zzbAk;
    }

    public zzawk zzNG() {
        return this;
    }

    protected boolean zza(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
        return this.zzbAl.contains(Integer.valueOf(com_google_android_gms_internal_zzack_zza.zzxQ()));
    }

    protected Object zzb(com.google.android.gms.internal.zzack.zza com_google_android_gms_internal_zzack_zza) {
        switch (com_google_android_gms_internal_zzack_zza.zzxQ()) {
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return this.zzbAm;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return this.zzbAn;
            case Dimension.UNIT_IN /*4*/:
                return this.zzbAo;
            case Dimension.UNIT_MM /*5*/:
                return this.zzbAp;
            case BuyButtonText.LOGO_ONLY /*6*/:
                return Integer.valueOf(this.zzbAq);
            case BuyButtonText.DONATE_WITH /*7*/:
                return this.zzbAr;
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                return this.zzbAs;
            case HTTP.HT /*9*/:
                return this.zzaiX;
            case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                return Integer.valueOf(this.zzyW);
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return this.zzGu;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return this.zzbAt;
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return Boolean.valueOf(this.zzbAu);
            case ConnectionResult.SERVICE_UPDATING /*18*/:
                return this.zzabW;
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                return this.zzbAv;
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                return this.zzbAw;
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                return Integer.valueOf(this.zzbAx);
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                return this.zzbAy;
            case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                return this.zzbAz;
            case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                return Integer.valueOf(this.zzbAA);
            case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                return Integer.valueOf(this.zzbAB);
            case C0308R.styleable.Toolbar_logoDescription /*26*/:
                return this.zzbAC;
            case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                return this.zzD;
            case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                return this.zzbAD;
            case C0308R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                return Boolean.valueOf(this.zzbAE);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzack_zza.zzxQ());
        }
    }

    public /* synthetic */ Map zzxK() {
        return zzNF();
    }
}
