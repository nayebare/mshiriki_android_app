package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzaqx implements Parcelable {
    public static final Creator<zzaqx> CREATOR;
    private static final int[] zzbip;
    private final int zzanR;
    private final String zzbin;
    private final int[] zzbio;

    /* renamed from: com.google.android.gms.internal.zzaqx.1 */
    class C09991 implements Creator<zzaqx> {
        C09991() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzgv(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzjM(i);
        }

        public zzaqx zzgv(Parcel parcel) {
            return new zzaqx(parcel);
        }

        public zzaqx[] zzjM(int i) {
            return new zzaqx[i];
        }
    }

    static {
        zzbip = new int[ItemAnimator.FLAG_MOVED];
        CREATOR = new C09991();
    }

    public zzaqx(Parcel parcel) {
        this.zzbin = parcel.readString();
        this.zzanR = parcel.readInt();
        this.zzbio = parcel.createIntArray();
    }

    public zzaqx(String str, int i) {
        this.zzbin = str;
        this.zzanR = i;
        if (this.zzanR == 3) {
            this.zzbio = zzeT(str);
        } else {
            this.zzbio = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized int[] zzeT(java.lang.String r13) {
        /*
        r8 = com.google.android.gms.internal.zzaqx.class;
        monitor-enter(r8);
        r1 = 0;
        r9 = r13.length();	 Catch:{ all -> 0x001c }
        r0 = 0;
        r6 = 0;
        r4 = 0;
        r3 = 0;
        r5 = r6;
        r6 = r0;
    L_0x000e:
        if (r1 >= r9) goto L_0x0205;
    L_0x0010:
        r0 = 2045; // 0x7fd float:2.866E-42 double:1.0104E-320;
        if (r6 <= r0) goto L_0x001f;
    L_0x0014:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "Pattern is too large!";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x001f:
        r0 = r13.charAt(r1);	 Catch:{ all -> 0x001c }
        r2 = 0;
        switch(r0) {
            case 42: goto L_0x00e1;
            case 43: goto L_0x0109;
            case 46: goto L_0x0131;
            case 91: goto L_0x0044;
            case 92: goto L_0x0143;
            case 93: goto L_0x0071;
            case 123: goto L_0x00a2;
            case 125: goto L_0x00ce;
            default: goto L_0x0027;
        };	 Catch:{ all -> 0x001c }
    L_0x0027:
        r2 = 1;
        r12 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r12;
    L_0x0030:
        if (r6 == 0) goto L_0x0191;
    L_0x0032:
        if (r0 == 0) goto L_0x015f;
    L_0x0034:
        r0 = zzbip;	 Catch:{ all -> 0x001c }
        r1 = r2 + 1;
        r0[r2] = r4;	 Catch:{ all -> 0x001c }
        r0 = 0;
        r2 = r3;
    L_0x003c:
        r2 = r2 + 1;
        r3 = r0;
        r4 = r5;
        r5 = r6;
        r6 = r1;
        r1 = r2;
        goto L_0x000e;
    L_0x0044:
        if (r5 == 0) goto L_0x0050;
    L_0x0046:
        r2 = 1;
        r12 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r12;
        goto L_0x0030;
    L_0x0050:
        r0 = r1 + 1;
        r0 = r13.charAt(r0);	 Catch:{ all -> 0x001c }
        r2 = 94;
        if (r0 != r2) goto L_0x0069;
    L_0x005a:
        r2 = zzbip;	 Catch:{ all -> 0x001c }
        r0 = r6 + 1;
        r5 = -2;
        r2[r6] = r5;	 Catch:{ all -> 0x001c }
        r1 = r1 + 1;
    L_0x0063:
        r1 = r1 + 1;
        r6 = 1;
        r5 = r6;
        r6 = r0;
        goto L_0x000e;
    L_0x0069:
        r2 = zzbip;	 Catch:{ all -> 0x001c }
        r0 = r6 + 1;
        r5 = -1;
        r2[r6] = r5;	 Catch:{ all -> 0x001c }
        goto L_0x0063;
    L_0x0071:
        if (r5 != 0) goto L_0x007d;
    L_0x0073:
        r2 = 1;
        r12 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r12;
        goto L_0x0030;
    L_0x007d:
        r3 = zzbip;	 Catch:{ all -> 0x001c }
        r5 = r6 + -1;
        r3 = r3[r5];	 Catch:{ all -> 0x001c }
        r5 = -1;
        if (r3 == r5) goto L_0x0089;
    L_0x0086:
        r5 = -2;
        if (r3 != r5) goto L_0x0091;
    L_0x0089:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "You must define characters in a set.";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x0091:
        r3 = zzbip;	 Catch:{ all -> 0x001c }
        r7 = r6 + 1;
        r5 = -3;
        r3[r6] = r5;	 Catch:{ all -> 0x001c }
        r5 = 0;
        r3 = 0;
        r6 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0030;
    L_0x00a2:
        if (r5 != 0) goto L_0x021b;
    L_0x00a4:
        if (r6 == 0) goto L_0x00b2;
    L_0x00a6:
        r4 = zzbip;	 Catch:{ all -> 0x001c }
        r7 = r6 + -1;
        r4 = r4[r7];	 Catch:{ all -> 0x001c }
        r4 = zzjL(r4);	 Catch:{ all -> 0x001c }
        if (r4 == 0) goto L_0x00ba;
    L_0x00b2:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "Modifier must follow a token.";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x00ba:
        r7 = zzbip;	 Catch:{ all -> 0x001c }
        r4 = r6 + 1;
        r10 = -5;
        r7[r6] = r10;	 Catch:{ all -> 0x001c }
        r6 = r1 + 1;
        r1 = 1;
        r12 = r0;
        r0 = r3;
        r3 = r6;
        r6 = r5;
        r5 = r1;
        r1 = r2;
        r2 = r4;
        r4 = r12;
        goto L_0x0030;
    L_0x00ce:
        if (r4 == 0) goto L_0x021b;
    L_0x00d0:
        r4 = zzbip;	 Catch:{ all -> 0x001c }
        r7 = r6 + 1;
        r10 = -6;
        r4[r6] = r10;	 Catch:{ all -> 0x001c }
        r4 = 0;
        r6 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0030;
    L_0x00e1:
        if (r5 != 0) goto L_0x021b;
    L_0x00e3:
        if (r6 == 0) goto L_0x00f1;
    L_0x00e5:
        r7 = zzbip;	 Catch:{ all -> 0x001c }
        r10 = r6 + -1;
        r7 = r7[r10];	 Catch:{ all -> 0x001c }
        r7 = zzjL(r7);	 Catch:{ all -> 0x001c }
        if (r7 == 0) goto L_0x00f9;
    L_0x00f1:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "Modifier must follow a token.";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x00f9:
        r10 = zzbip;	 Catch:{ all -> 0x001c }
        r7 = r6 + 1;
        r11 = -7;
        r10[r6] = r11;	 Catch:{ all -> 0x001c }
        r6 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0030;
    L_0x0109:
        if (r5 != 0) goto L_0x021b;
    L_0x010b:
        if (r6 == 0) goto L_0x0119;
    L_0x010d:
        r7 = zzbip;	 Catch:{ all -> 0x001c }
        r10 = r6 + -1;
        r7 = r7[r10];	 Catch:{ all -> 0x001c }
        r7 = zzjL(r7);	 Catch:{ all -> 0x001c }
        if (r7 == 0) goto L_0x0121;
    L_0x0119:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "Modifier must follow a token.";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x0121:
        r10 = zzbip;	 Catch:{ all -> 0x001c }
        r7 = r6 + 1;
        r11 = -8;
        r10[r6] = r11;	 Catch:{ all -> 0x001c }
        r6 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0030;
    L_0x0131:
        if (r5 != 0) goto L_0x021b;
    L_0x0133:
        r10 = zzbip;	 Catch:{ all -> 0x001c }
        r7 = r6 + 1;
        r11 = -4;
        r10[r6] = r11;	 Catch:{ all -> 0x001c }
        r6 = r5;
        r5 = r4;
        r4 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0030;
    L_0x0143:
        r0 = r1 + 1;
        if (r0 < r9) goto L_0x014f;
    L_0x0147:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "Escape found at end of pattern!";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x014f:
        r2 = r1 + 1;
        r0 = r13.charAt(r2);	 Catch:{ all -> 0x001c }
        r1 = 1;
        r12 = r0;
        r0 = r3;
        r3 = r2;
        r2 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r12;
        goto L_0x0030;
    L_0x015f:
        r1 = r3 + 2;
        if (r1 >= r9) goto L_0x0182;
    L_0x0163:
        r1 = r3 + 1;
        r1 = r13.charAt(r1);	 Catch:{ all -> 0x001c }
        r7 = 45;
        if (r1 != r7) goto L_0x0182;
    L_0x016d:
        r1 = r3 + 2;
        r1 = r13.charAt(r1);	 Catch:{ all -> 0x001c }
        r7 = 93;
        if (r1 == r7) goto L_0x0182;
    L_0x0177:
        r0 = 1;
        r7 = zzbip;	 Catch:{ all -> 0x001c }
        r1 = r2 + 1;
        r7[r2] = r4;	 Catch:{ all -> 0x001c }
        r2 = r3 + 1;
        goto L_0x003c;
    L_0x0182:
        r1 = zzbip;	 Catch:{ all -> 0x001c }
        r7 = r2 + 1;
        r1[r2] = r4;	 Catch:{ all -> 0x001c }
        r2 = zzbip;	 Catch:{ all -> 0x001c }
        r1 = r7 + 1;
        r2[r7] = r4;	 Catch:{ all -> 0x001c }
        r2 = r3;
        goto L_0x003c;
    L_0x0191:
        if (r5 == 0) goto L_0x01fa;
    L_0x0193:
        r1 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r4 = r13.indexOf(r1, r3);	 Catch:{ all -> 0x001c }
        if (r4 >= 0) goto L_0x01a3;
    L_0x019b:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "Range not ended with '}'";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x01a3:
        r1 = r13.substring(r3, r4);	 Catch:{ all -> 0x001c }
        r3 = 44;
        r7 = r1.indexOf(r3);	 Catch:{ all -> 0x001c }
        if (r7 >= 0) goto L_0x01c7;
    L_0x01af:
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x01be }
        r3 = r1;
    L_0x01b4:
        if (r3 <= r1) goto L_0x01e7;
    L_0x01b6:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ NumberFormatException -> 0x01be }
        r1 = "Range quantifier minimum is greater than maximum";
        r0.<init>(r1);	 Catch:{ NumberFormatException -> 0x01be }
        throw r0;	 Catch:{ NumberFormatException -> 0x01be }
    L_0x01be:
        r0 = move-exception;
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r2 = "Range number format incorrect";
        r1.<init>(r2, r0);	 Catch:{ all -> 0x001c }
        throw r1;	 Catch:{ all -> 0x001c }
    L_0x01c7:
        r3 = 0;
        r3 = r1.substring(r3, r7);	 Catch:{ NumberFormatException -> 0x01be }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x01be }
        r10 = r1.length();	 Catch:{ NumberFormatException -> 0x01be }
        r10 = r10 + -1;
        if (r7 != r10) goto L_0x01dc;
    L_0x01d8:
        r1 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        goto L_0x01b4;
    L_0x01dc:
        r7 = r7 + 1;
        r1 = r1.substring(r7);	 Catch:{ NumberFormatException -> 0x01be }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x01be }
        goto L_0x01b4;
    L_0x01e7:
        r7 = zzbip;	 Catch:{ NumberFormatException -> 0x01be }
        r10 = r2 + 1;
        r7[r2] = r3;	 Catch:{ NumberFormatException -> 0x01be }
        r3 = zzbip;	 Catch:{ NumberFormatException -> 0x01be }
        r2 = r10 + 1;
        r3[r10] = r1;	 Catch:{ NumberFormatException -> 0x01be }
        r3 = r0;
        r1 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r2;
        goto L_0x000e;
    L_0x01fa:
        if (r1 == 0) goto L_0x0217;
    L_0x01fc:
        r7 = zzbip;	 Catch:{ all -> 0x001c }
        r1 = r2 + 1;
        r7[r2] = r4;	 Catch:{ all -> 0x001c }
        r2 = r3;
        goto L_0x003c;
    L_0x0205:
        if (r5 == 0) goto L_0x020f;
    L_0x0207:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001c }
        r1 = "Set was not terminated!";
        r0.<init>(r1);	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x020f:
        r0 = zzbip;	 Catch:{ all -> 0x001c }
        r0 = java.util.Arrays.copyOf(r0, r6);	 Catch:{ all -> 0x001c }
        monitor-exit(r8);
        return r0;
    L_0x0217:
        r1 = r2;
        r2 = r3;
        goto L_0x003c;
    L_0x021b:
        r12 = r0;
        r0 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r12;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaqx.zzeT(java.lang.String):int[]");
    }

    private static boolean zzjL(int i) {
        return i == -8 || i == -7 || i == -6 || i == -5;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        String str = "? ";
        switch (this.zzanR) {
            case MessageApi.FILTER_LITERAL /*0*/:
                str = "LITERAL: ";
                break;
            case MessageApi.FILTER_PREFIX /*1*/:
                str = "PREFIX: ";
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                str = "GLOB: ";
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                str = "ADVANCED: ";
                break;
        }
        String str2 = this.zzbin;
        return new StringBuilder((String.valueOf(str).length() + 16) + String.valueOf(str2).length()).append("PatternMatcher{").append(str).append(str2).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzbin);
        parcel.writeInt(this.zzanR);
        parcel.writeIntArray(this.zzbio);
    }
}
