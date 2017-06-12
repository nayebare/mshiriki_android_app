package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzac;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR;
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzbdM;
    private final byte[] zzbdN;
    private final int zzbdO;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.1 */
    class C08541 implements Creator<RealTimeMessage> {
        C08541() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzfQ(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zziV(i);
        }

        public RealTimeMessage zzfQ(Parcel parcel) {
            return new RealTimeMessage(null);
        }

        public RealTimeMessage[] zziV(int i) {
            return new RealTimeMessage[i];
        }
    }

    static {
        CREATOR = new C08541();
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String str, byte[] bArr, int i) {
        this.zzbdM = (String) zzac.zzw(str);
        this.zzbdN = (byte[]) ((byte[]) zzac.zzw(bArr)).clone();
        this.zzbdO = i;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzbdN;
    }

    public String getSenderParticipantId() {
        return this.zzbdM;
    }

    public boolean isReliable() {
        return this.zzbdO == RELIABLE;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzbdM);
        parcel.writeByteArray(this.zzbdN);
        parcel.writeInt(this.zzbdO);
    }
}
