package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public final class SubscribeRequest extends zza implements ReflectedParcelable {
    public static final Creator<SubscribeRequest> CREATOR;
    final int mVersionCode;
    public final PendingIntent zzaIj;
    public final boolean zzbxT;
    @Deprecated
    public final String zzbxx;
    @Deprecated
    public final boolean zzbxy;
    @Deprecated
    public final ClientAppContext zzbyA;
    public final Strategy zzbyY;
    @Deprecated
    public final boolean zzbyZ;
    @Deprecated
    public final String zzbyv;
    public final zzn zzbyz;
    public final zzm zzbzd;
    public final MessageFilter zzbze;
    public final int zzbzf;
    public final byte[] zzbzg;
    public final zzr zzbzh;

    static {
        CREATOR = new zzaf();
    }

    public SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2, byte[] bArr, boolean z, IBinder iBinder3, boolean z2, ClientAppContext clientAppContext, boolean z3) {
        this.mVersionCode = i;
        this.zzbzd = zzm.zza.zzeC(iBinder);
        this.zzbyY = strategy;
        this.zzbyz = zzn.zza.zzeD(iBinder2);
        this.zzbze = messageFilter;
        this.zzaIj = pendingIntent;
        this.zzbzf = i2;
        this.zzbxx = str;
        this.zzbyv = str2;
        this.zzbzg = bArr;
        this.zzbyZ = z;
        this.zzbzh = iBinder3 == null ? null : zzr.zza.zzeH(iBinder3);
        this.zzbxy = z2;
        this.zzbyA = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzbxT = z3;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i, byte[] bArr, IBinder iBinder3, boolean z) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, i, null, null, bArr, false, iBinder3, false, null, z);
    }

    public String toString() {
        String str;
        String valueOf = String.valueOf(this.zzbzd);
        String valueOf2 = String.valueOf(this.zzbyY);
        String valueOf3 = String.valueOf(this.zzbyz);
        String valueOf4 = String.valueOf(this.zzbze);
        String valueOf5 = String.valueOf(this.zzaIj);
        int i = this.zzbzf;
        if (this.zzbzg == null) {
            str = null;
        } else {
            str = "<" + this.zzbzg.length + " bytes>";
        }
        String valueOf6 = String.valueOf(this.zzbzh);
        boolean z = this.zzbxy;
        String valueOf7 = String.valueOf(this.zzbyA);
        boolean z2 = this.zzbxT;
        String str2 = this.zzbxx;
        String str3 = this.zzbyv;
        return new StringBuilder((((((((((String.valueOf(valueOf).length() + 295) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(str).length()) + String.valueOf(valueOf6).length()) + String.valueOf(valueOf7).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append("SubscribeRequest{messageListener=").append(valueOf).append(", strategy=").append(valueOf2).append(", callback=").append(valueOf3).append(", filter=").append(valueOf4).append(", pendingIntent=").append(valueOf5).append(", messageListenerKey=").append(i).append(", hint=").append(str).append(", subscribeCallback=").append(valueOf6).append(", useRealClientApiKey=").append(z).append(", clientAppContext=").append(valueOf7).append(", isDiscardPendingIntent=").append(z2).append(", zeroPartyPackageName=").append(str2).append(", realClientPackageName=").append(str3).append(", isIgnoreNearbyPermission=").append(this.zzbyZ).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }

    IBinder zzNi() {
        return this.zzbyz == null ? null : this.zzbyz.asBinder();
    }

    IBinder zzNo() {
        return this.zzbzd == null ? null : this.zzbzd.asBinder();
    }

    IBinder zzNp() {
        return this.zzbzh == null ? null : this.zzbzh.asBinder();
    }
}
