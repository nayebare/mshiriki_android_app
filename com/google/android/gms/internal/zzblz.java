package com.google.android.gms.internal;

import com.google.android.gms.internal.zzboa.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;

public class zzblz extends zzbme {
    private final zzbml zzbXR;
    private final ChildEventListener zzcby;
    private final zzboe zzcbz;

    /* renamed from: com.google.android.gms.internal.zzblz.1 */
    static /* synthetic */ class C12061 {
        static final /* synthetic */ int[] zzcbA;

        static {
            zzcbA = new int[zza.values().length];
            try {
                zzcbA[zza.CHILD_ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzcbA[zza.CHILD_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzcbA[zza.CHILD_MOVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzcbA[zza.CHILD_REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public zzblz(zzbml com_google_android_gms_internal_zzbml, ChildEventListener childEventListener, zzboe com_google_android_gms_internal_zzboe) {
        this.zzbXR = com_google_android_gms_internal_zzbml;
        this.zzcby = childEventListener;
        this.zzcbz = com_google_android_gms_internal_zzboe;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzblz) && ((zzblz) obj).zzcby.equals(this.zzcby) && ((zzblz) obj).zzbXR.equals(this.zzbXR) && ((zzblz) obj).zzcbz.equals(this.zzcbz);
    }

    public int hashCode() {
        return (((this.zzcby.hashCode() * 31) + this.zzbXR.hashCode()) * 31) + this.zzcbz.hashCode();
    }

    public String toString() {
        return "ChildEventRegistration";
    }

    public zzboe zzWD() {
        return this.zzcbz;
    }

    public zzbme zza(zzboe com_google_android_gms_internal_zzboe) {
        return new zzblz(this.zzbXR, this.zzcby, com_google_android_gms_internal_zzboe);
    }

    public zzbnz zza(zzbny com_google_android_gms_internal_zzbny, zzboe com_google_android_gms_internal_zzboe) {
        return new zzbnz(com_google_android_gms_internal_zzbny.zzYl(), this, com.google.firebase.database.zza.zza(com.google.firebase.database.zza.zza(this.zzbXR, com_google_android_gms_internal_zzboe.zzVc().zza(com_google_android_gms_internal_zzbny.zzYk())), com_google_android_gms_internal_zzbny.zzYi()), com_google_android_gms_internal_zzbny.zzYm() != null ? com_google_android_gms_internal_zzbny.zzYm().asString() : null);
    }

    public void zza(zzbnz com_google_android_gms_internal_zzbnz) {
        if (!zzXb()) {
            switch (C12061.zzcbA[com_google_android_gms_internal_zzbnz.zzYl().ordinal()]) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    this.zzcby.onChildAdded(com_google_android_gms_internal_zzbnz.zzYo(), com_google_android_gms_internal_zzbnz.zzYp());
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    this.zzcby.onChildChanged(com_google_android_gms_internal_zzbnz.zzYo(), com_google_android_gms_internal_zzbnz.zzYp());
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    this.zzcby.onChildMoved(com_google_android_gms_internal_zzbnz.zzYo(), com_google_android_gms_internal_zzbnz.zzYp());
                case Dimension.UNIT_IN /*4*/:
                    this.zzcby.onChildRemoved(com_google_android_gms_internal_zzbnz.zzYo());
                default:
            }
        }
    }

    public void zza(DatabaseError databaseError) {
        this.zzcby.onCancelled(databaseError);
    }

    public boolean zza(zza com_google_android_gms_internal_zzboa_zza) {
        return com_google_android_gms_internal_zzboa_zza != zza.VALUE;
    }

    public boolean zzc(zzbme com_google_android_gms_internal_zzbme) {
        return (com_google_android_gms_internal_zzbme instanceof zzblz) && ((zzblz) com_google_android_gms_internal_zzbme).zzcby.equals(this.zzcby);
    }
}
