package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzavp;
import java.util.Arrays;

public class Message extends zza implements ReflectedParcelable {
    public static final Creator<Message> CREATOR;
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    private static final zzavp[] zzbxo;
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzaFs;
    @Deprecated
    final zzavp[] zzbxp;
    private final long zzbxq;

    static {
        CREATOR = new zza();
        zzbxo = new zzavp[]{zzavp.zzbyf};
    }

    Message(int i, @Nullable byte[] bArr, @Nullable String str, String str2, @Nullable zzavp[] com_google_android_gms_internal_zzavpArr, long j) {
        this.versionCode = i;
        this.type = (String) zzac.zzw(str2);
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.zzaFs = str;
        this.zzbxq = 0;
        if (zzac(this.zzaFs, this.type)) {
            zzac.zzb(bArr == null, (Object) "Content must be null for a device presence message.");
        } else {
            zzac.zzw(bArr);
            zzac.zzb(bArr.length <= MAX_CONTENT_SIZE_BYTES, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        }
        this.content = bArr;
        if (com_google_android_gms_internal_zzavpArr == null || com_google_android_gms_internal_zzavpArr.length == 0) {
            com_google_android_gms_internal_zzavpArr = zzbxo;
        }
        this.zzbxp = com_google_android_gms_internal_zzavpArr;
        zzac.zzb(str2.length() <= MAX_TYPE_LENGTH, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), Integer.valueOf(MAX_TYPE_LENGTH));
    }

    public Message(byte[] bArr) {
        this(bArr, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public Message(byte[] bArr, String str) {
        this(bArr, BuildConfig.FLAVOR, str);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, zzbxo);
    }

    public Message(byte[] bArr, String str, String str2, zzavp[] com_google_android_gms_internal_zzavpArr) {
        this(bArr, str, str2, com_google_android_gms_internal_zzavpArr, 0);
    }

    public Message(byte[] bArr, String str, String str2, zzavp[] com_google_android_gms_internal_zzavpArr, long j) {
        this(2, bArr, str, str2, com_google_android_gms_internal_zzavpArr, j);
    }

    @Deprecated
    public static boolean zzac(String str, String str2) {
        return str.equals(MESSAGE_NAMESPACE_RESERVED) && str2.equals("__device_presence");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.zzaFs, message.zzaFs) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content) && 0 == 0;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.zzaFs;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaFs, this.type, Integer.valueOf(Arrays.hashCode(this.content)), Long.valueOf(0));
    }

    public String toString() {
        String str = this.zzaFs;
        String str2 = this.type;
        return new StringBuilder((String.valueOf(str).length() + 59) + String.valueOf(str2).length()).append("Message{namespace='").append(str).append("', type='").append(str2).append("', content=[").append(this.content == null ? 0 : this.content.length).append(" bytes]}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public boolean zzMX() {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace());
    }

    public long zzMY() {
        return 0;
    }

    public boolean zzgp(String str) {
        return zzMX() && str.equals(getType());
    }
}
