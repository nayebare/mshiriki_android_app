package com.google.android.gms.internal;

import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

public final class zzbih extends zzbun<zzbih> {
    public zza[] zzbTs;

    public static final class zza extends zzbun<zza> {
        private static volatile zza[] zzbTt;
        public String name;
        public zza zzbTu;

        public static final class zza extends zzbun<zza> {
            private static volatile zza[] zzbTv;
            public int type;
            public zza zzbTw;

            public static final class zza extends zzbun<zza> {
                public float zzbTA;
                public long zzbTB;
                public int zzbTC;
                public int zzbTD;
                public boolean zzbTE;
                public zza[] zzbTF;
                public zza[] zzbTG;
                public String[] zzbTH;
                public long[] zzbTI;
                public float[] zzbTJ;
                public long zzbTK;
                public byte[] zzbTx;
                public String zzbTy;
                public double zzbTz;

                public zza() {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    r0.zzTe();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.<init>():void");
                }

                public boolean equals(java.lang.Object r7) {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r6 = this;
                    r1 = 1;
                    r0 = 0;
                    if (r7 != r6) goto L_0x0006;
                L_0x0004:
                    r0 = r1;
                L_0x0005:
                    return r0;
                L_0x0006:
                    r2 = r7 instanceof com.google.android.gms.internal.zzbih.zza.zza.zza;
                    if (r2 == 0) goto L_0x0005;
                L_0x000a:
                    r7 = (com.google.android.gms.internal.zzbih.zza.zza.zza) r7;
                    r2 = r6.zzbTx;
                    r3 = r7.zzbTx;
                    r2 = java.util.Arrays.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0016:
                    r2 = r6.zzbTy;
                    if (r2 != 0) goto L_0x00ab;
                L_0x001a:
                    r2 = r7.zzbTy;
                    if (r2 != 0) goto L_0x0005;
                L_0x001e:
                    r2 = r6.zzbTz;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = r7.zzbTz;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 != 0) goto L_0x0005;
                L_0x002e:
                    r2 = r6.zzbTA;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    r3 = r7.zzbTA;
                    r3 = java.lang.Float.floatToIntBits(r3);
                    if (r2 != r3) goto L_0x0005;
                L_0x003c:
                    r2 = r6.zzbTB;
                    r4 = r7.zzbTB;
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 != 0) goto L_0x0005;
                L_0x0044:
                    r2 = r6.zzbTC;
                    r3 = r7.zzbTC;
                    if (r2 != r3) goto L_0x0005;
                L_0x004a:
                    r2 = r6.zzbTD;
                    r3 = r7.zzbTD;
                    if (r2 != r3) goto L_0x0005;
                L_0x0050:
                    r2 = r6.zzbTE;
                    r3 = r7.zzbTE;
                    if (r2 != r3) goto L_0x0005;
                L_0x0056:
                    r2 = r6.zzbTF;
                    r3 = r7.zzbTF;
                    r2 = com.google.android.gms.internal.zzbur.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0060:
                    r2 = r6.zzbTG;
                    r3 = r7.zzbTG;
                    r2 = com.google.android.gms.internal.zzbur.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x006a:
                    r2 = r6.zzbTH;
                    r3 = r7.zzbTH;
                    r2 = com.google.android.gms.internal.zzbur.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0074:
                    r2 = r6.zzbTI;
                    r3 = r7.zzbTI;
                    r2 = com.google.android.gms.internal.zzbur.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x007e:
                    r2 = r6.zzbTJ;
                    r3 = r7.zzbTJ;
                    r2 = com.google.android.gms.internal.zzbur.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0088:
                    r2 = r6.zzbTK;
                    r4 = r7.zzbTK;
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 != 0) goto L_0x0005;
                L_0x0090:
                    r2 = r6.zzcrX;
                    if (r2 == 0) goto L_0x009c;
                L_0x0094:
                    r2 = r6.zzcrX;
                    r2 = r2.isEmpty();
                    if (r2 == 0) goto L_0x00b7;
                L_0x009c:
                    r2 = r7.zzcrX;
                    if (r2 == 0) goto L_0x00a8;
                L_0x00a0:
                    r2 = r7.zzcrX;
                    r2 = r2.isEmpty();
                    if (r2 == 0) goto L_0x0005;
                L_0x00a8:
                    r0 = r1;
                    goto L_0x0005;
                L_0x00ab:
                    r2 = r6.zzbTy;
                    r3 = r7.zzbTy;
                    r2 = r2.equals(r3);
                    if (r2 != 0) goto L_0x001e;
                L_0x00b5:
                    goto L_0x0005;
                L_0x00b7:
                    r0 = r6.zzcrX;
                    r1 = r7.zzcrX;
                    r0 = r0.equals(r1);
                    goto L_0x0005;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r7 = this;
                    r1 = 0;
                    r6 = 32;
                    r0 = r7.getClass();
                    r0 = r0.getName();
                    r0 = r0.hashCode();
                    r0 = r0 + 527;
                    r0 = r0 * 31;
                    r2 = r7.zzbTx;
                    r2 = java.util.Arrays.hashCode(r2);
                    r0 = r0 + r2;
                    r2 = r0 * 31;
                    r0 = r7.zzbTy;
                    if (r0 != 0) goto L_0x009c;
                L_0x0020:
                    r0 = r1;
                L_0x0021:
                    r0 = r0 + r2;
                    r2 = r7.zzbTz;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r0 = r0 * 31;
                    r4 = r2 >>> r6;
                    r2 = r2 ^ r4;
                    r2 = (int) r2;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTA;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTB;
                    r4 = r7.zzbTB;
                    r4 = r4 >>> r6;
                    r2 = r2 ^ r4;
                    r2 = (int) r2;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTC;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTD;
                    r0 = r0 + r2;
                    r2 = r0 * 31;
                    r0 = r7.zzbTE;
                    if (r0 == 0) goto L_0x00a4;
                L_0x0052:
                    r0 = 1231; // 0x4cf float:1.725E-42 double:6.08E-321;
                L_0x0054:
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTF;
                    r2 = com.google.android.gms.internal.zzbur.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTG;
                    r2 = com.google.android.gms.internal.zzbur.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTH;
                    r2 = com.google.android.gms.internal.zzbur.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTI;
                    r2 = com.google.android.gms.internal.zzbur.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTJ;
                    r2 = com.google.android.gms.internal.zzbur.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbTK;
                    r4 = r7.zzbTK;
                    r4 = r4 >>> r6;
                    r2 = r2 ^ r4;
                    r2 = (int) r2;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzcrX;
                    if (r2 == 0) goto L_0x009a;
                L_0x0092:
                    r2 = r7.zzcrX;
                    r2 = r2.isEmpty();
                    if (r2 == 0) goto L_0x00a7;
                L_0x009a:
                    r0 = r0 + r1;
                    return r0;
                L_0x009c:
                    r0 = r7.zzbTy;
                    r0 = r0.hashCode();
                    goto L_0x0021;
                L_0x00a4:
                    r0 = 1237; // 0x4d5 float:1.733E-42 double:6.11E-321;
                    goto L_0x0054;
                L_0x00a7:
                    r1 = r7.zzcrX;
                    r1 = r1.hashCode();
                    goto L_0x009a;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.hashCode():int");
                }

                public com.google.android.gms.internal.zzbih.zza.zza.zza zzTe() {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r6 = this;
                    r4 = 0;
                    r2 = 0;
                    r0 = com.google.android.gms.internal.zzbuw.zzcsp;
                    r6.zzbTx = r0;
                    r0 = "";
                    r6.zzbTy = r0;
                    r0 = 0;
                    r6.zzbTz = r0;
                    r0 = 0;
                    r6.zzbTA = r0;
                    r6.zzbTB = r4;
                    r6.zzbTC = r2;
                    r6.zzbTD = r2;
                    r6.zzbTE = r2;
                    r0 = com.google.android.gms.internal.zzbih.zza.zzTa();
                    r6.zzbTF = r0;
                    r0 = com.google.android.gms.internal.zzbih.zza.zza.zzTc();
                    r6.zzbTG = r0;
                    r0 = com.google.android.gms.internal.zzbuw.zzcsn;
                    r6.zzbTH = r0;
                    r0 = com.google.android.gms.internal.zzbuw.zzcsj;
                    r6.zzbTI = r0;
                    r0 = com.google.android.gms.internal.zzbuw.zzcsk;
                    r6.zzbTJ = r0;
                    r6.zzbTK = r4;
                    r0 = 0;
                    r6.zzcrX = r0;
                    r0 = -1;
                    r6.zzcsg = r0;
                    return r6;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.zzTe():com.google.android.gms.internal.zzbih$zza$zza$zza");
                }

                public void zza(com.google.android.gms.internal.zzbum r9) throws java.io.IOException {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r8 = this;
                    r6 = 0;
                    r1 = 0;
                    r0 = r8.zzbTx;
                    r2 = com.google.android.gms.internal.zzbuw.zzcsp;
                    r0 = java.util.Arrays.equals(r0, r2);
                    if (r0 != 0) goto L_0x0013;
                L_0x000d:
                    r0 = 1;
                    r2 = r8.zzbTx;
                    r9.zzb(r0, r2);
                L_0x0013:
                    r0 = r8.zzbTy;
                    if (r0 == 0) goto L_0x0027;
                L_0x0017:
                    r0 = r8.zzbTy;
                    r2 = "";
                    r0 = r0.equals(r2);
                    if (r0 != 0) goto L_0x0027;
                L_0x0021:
                    r0 = 2;
                    r2 = r8.zzbTy;
                    r9.zzq(r0, r2);
                L_0x0027:
                    r2 = r8.zzbTz;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = 0;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r0 == 0) goto L_0x003d;
                L_0x0037:
                    r0 = 3;
                    r2 = r8.zzbTz;
                    r9.zza(r0, r2);
                L_0x003d:
                    r0 = r8.zzbTA;
                    r0 = java.lang.Float.floatToIntBits(r0);
                    r2 = 0;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    if (r0 == r2) goto L_0x0050;
                L_0x004a:
                    r0 = 4;
                    r2 = r8.zzbTA;
                    r9.zzc(r0, r2);
                L_0x0050:
                    r2 = r8.zzbTB;
                    r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r0 == 0) goto L_0x005c;
                L_0x0056:
                    r0 = 5;
                    r2 = r8.zzbTB;
                    r9.zzb(r0, r2);
                L_0x005c:
                    r0 = r8.zzbTC;
                    if (r0 == 0) goto L_0x0066;
                L_0x0060:
                    r0 = 6;
                    r2 = r8.zzbTC;
                    r9.zzF(r0, r2);
                L_0x0066:
                    r0 = r8.zzbTD;
                    if (r0 == 0) goto L_0x0070;
                L_0x006a:
                    r0 = 7;
                    r2 = r8.zzbTD;
                    r9.zzG(r0, r2);
                L_0x0070:
                    r0 = r8.zzbTE;
                    if (r0 == 0) goto L_0x007b;
                L_0x0074:
                    r0 = 8;
                    r2 = r8.zzbTE;
                    r9.zzg(r0, r2);
                L_0x007b:
                    r0 = r8.zzbTF;
                    if (r0 == 0) goto L_0x0098;
                L_0x007f:
                    r0 = r8.zzbTF;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x0098;
                L_0x0084:
                    r0 = r1;
                L_0x0085:
                    r2 = r8.zzbTF;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x0098;
                L_0x008a:
                    r2 = r8.zzbTF;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x0095;
                L_0x0090:
                    r3 = 9;
                    r9.zza(r3, r2);
                L_0x0095:
                    r0 = r0 + 1;
                    goto L_0x0085;
                L_0x0098:
                    r0 = r8.zzbTG;
                    if (r0 == 0) goto L_0x00b5;
                L_0x009c:
                    r0 = r8.zzbTG;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00b5;
                L_0x00a1:
                    r0 = r1;
                L_0x00a2:
                    r2 = r8.zzbTG;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00b5;
                L_0x00a7:
                    r2 = r8.zzbTG;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x00b2;
                L_0x00ad:
                    r3 = 10;
                    r9.zza(r3, r2);
                L_0x00b2:
                    r0 = r0 + 1;
                    goto L_0x00a2;
                L_0x00b5:
                    r0 = r8.zzbTH;
                    if (r0 == 0) goto L_0x00d2;
                L_0x00b9:
                    r0 = r8.zzbTH;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00d2;
                L_0x00be:
                    r0 = r1;
                L_0x00bf:
                    r2 = r8.zzbTH;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00d2;
                L_0x00c4:
                    r2 = r8.zzbTH;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x00cf;
                L_0x00ca:
                    r3 = 11;
                    r9.zzq(r3, r2);
                L_0x00cf:
                    r0 = r0 + 1;
                    goto L_0x00bf;
                L_0x00d2:
                    r0 = r8.zzbTI;
                    if (r0 == 0) goto L_0x00ed;
                L_0x00d6:
                    r0 = r8.zzbTI;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00ed;
                L_0x00db:
                    r0 = r1;
                L_0x00dc:
                    r2 = r8.zzbTI;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00ed;
                L_0x00e1:
                    r2 = 12;
                    r3 = r8.zzbTI;
                    r4 = r3[r0];
                    r9.zzb(r2, r4);
                    r0 = r0 + 1;
                    goto L_0x00dc;
                L_0x00ed:
                    r2 = r8.zzbTK;
                    r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r0 == 0) goto L_0x00fa;
                L_0x00f3:
                    r0 = 13;
                    r2 = r8.zzbTK;
                    r9.zzb(r0, r2);
                L_0x00fa:
                    r0 = r8.zzbTJ;
                    if (r0 == 0) goto L_0x0114;
                L_0x00fe:
                    r0 = r8.zzbTJ;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x0114;
                L_0x0103:
                    r0 = r8.zzbTJ;
                    r0 = r0.length;
                    if (r1 >= r0) goto L_0x0114;
                L_0x0108:
                    r0 = 14;
                    r2 = r8.zzbTJ;
                    r2 = r2[r1];
                    r9.zzc(r0, r2);
                    r1 = r1 + 1;
                    goto L_0x0103;
                L_0x0114:
                    super.zza(r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.zza(com.google.android.gms.internal.zzbum):void");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.android.gms.internal.zzbih.zza.zza.zza zzaa(com.google.android.gms.internal.zzbul r7) throws java.io.IOException {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r6 = this;
                    r1 = 0;
                L_0x0001:
                    r0 = r7.zzacu();
                    switch(r0) {
                        case 0: goto L_0x000e;
                        case 10: goto L_0x000f;
                        case 18: goto L_0x0016;
                        case 25: goto L_0x001d;
                        case 37: goto L_0x0024;
                        case 40: goto L_0x002b;
                        case 48: goto L_0x0032;
                        case 56: goto L_0x0039;
                        case 64: goto L_0x0040;
                        case 74: goto L_0x0047;
                        case 82: goto L_0x0087;
                        case 90: goto L_0x00c7;
                        case 96: goto L_0x00fb;
                        case 98: goto L_0x012f;
                        case 104: goto L_0x0171;
                        case 114: goto L_0x01ad;
                        case 117: goto L_0x0179;
                        default: goto L_0x0008;
                    };
                L_0x0008:
                    r0 = super.zza(r7, r0);
                    if (r0 != 0) goto L_0x0001;
                L_0x000e:
                    return r6;
                L_0x000f:
                    r0 = r7.readBytes();
                    r6.zzbTx = r0;
                    goto L_0x0001;
                L_0x0016:
                    r0 = r7.readString();
                    r6.zzbTy = r0;
                    goto L_0x0001;
                L_0x001d:
                    r2 = r7.readDouble();
                    r6.zzbTz = r2;
                    goto L_0x0001;
                L_0x0024:
                    r0 = r7.readFloat();
                    r6.zzbTA = r0;
                    goto L_0x0001;
                L_0x002b:
                    r2 = r7.zzacx();
                    r6.zzbTB = r2;
                    goto L_0x0001;
                L_0x0032:
                    r0 = r7.zzacy();
                    r6.zzbTC = r0;
                    goto L_0x0001;
                L_0x0039:
                    r0 = r7.zzacB();
                    r6.zzbTD = r0;
                    goto L_0x0001;
                L_0x0040:
                    r0 = r7.zzacA();
                    r6.zzbTE = r0;
                    goto L_0x0001;
                L_0x0047:
                    r0 = 74;
                    r2 = com.google.android.gms.internal.zzbuw.zzc(r7, r0);
                    r0 = r6.zzbTF;
                    if (r0 != 0) goto L_0x0073;
                L_0x0051:
                    r0 = r1;
                L_0x0052:
                    r2 = r2 + r0;
                    r2 = new com.google.android.gms.internal.zzbih.zza[r2];
                    if (r0 == 0) goto L_0x005c;
                L_0x0057:
                    r3 = r6.zzbTF;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x005c:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x0077;
                L_0x0061:
                    r3 = new com.google.android.gms.internal.zzbih$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r3 = r2[r0];
                    r7.zza(r3);
                    r7.zzacu();
                    r0 = r0 + 1;
                    goto L_0x005c;
                L_0x0073:
                    r0 = r6.zzbTF;
                    r0 = r0.length;
                    goto L_0x0052;
                L_0x0077:
                    r3 = new com.google.android.gms.internal.zzbih$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r0 = r2[r0];
                    r7.zza(r0);
                    r6.zzbTF = r2;
                    goto L_0x0001;
                L_0x0087:
                    r0 = 82;
                    r2 = com.google.android.gms.internal.zzbuw.zzc(r7, r0);
                    r0 = r6.zzbTG;
                    if (r0 != 0) goto L_0x00b3;
                L_0x0091:
                    r0 = r1;
                L_0x0092:
                    r2 = r2 + r0;
                    r2 = new com.google.android.gms.internal.zzbih.zza.zza[r2];
                    if (r0 == 0) goto L_0x009c;
                L_0x0097:
                    r3 = r6.zzbTG;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x009c:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x00b7;
                L_0x00a1:
                    r3 = new com.google.android.gms.internal.zzbih$zza$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r3 = r2[r0];
                    r7.zza(r3);
                    r7.zzacu();
                    r0 = r0 + 1;
                    goto L_0x009c;
                L_0x00b3:
                    r0 = r6.zzbTG;
                    r0 = r0.length;
                    goto L_0x0092;
                L_0x00b7:
                    r3 = new com.google.android.gms.internal.zzbih$zza$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r0 = r2[r0];
                    r7.zza(r0);
                    r6.zzbTG = r2;
                    goto L_0x0001;
                L_0x00c7:
                    r0 = 90;
                    r2 = com.google.android.gms.internal.zzbuw.zzc(r7, r0);
                    r0 = r6.zzbTH;
                    if (r0 != 0) goto L_0x00ed;
                L_0x00d1:
                    r0 = r1;
                L_0x00d2:
                    r2 = r2 + r0;
                    r2 = new java.lang.String[r2];
                    if (r0 == 0) goto L_0x00dc;
                L_0x00d7:
                    r3 = r6.zzbTH;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x00dc:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x00f1;
                L_0x00e1:
                    r3 = r7.readString();
                    r2[r0] = r3;
                    r7.zzacu();
                    r0 = r0 + 1;
                    goto L_0x00dc;
                L_0x00ed:
                    r0 = r6.zzbTH;
                    r0 = r0.length;
                    goto L_0x00d2;
                L_0x00f1:
                    r3 = r7.readString();
                    r2[r0] = r3;
                    r6.zzbTH = r2;
                    goto L_0x0001;
                L_0x00fb:
                    r0 = 96;
                    r2 = com.google.android.gms.internal.zzbuw.zzc(r7, r0);
                    r0 = r6.zzbTI;
                    if (r0 != 0) goto L_0x0121;
                L_0x0105:
                    r0 = r1;
                L_0x0106:
                    r2 = r2 + r0;
                    r2 = new long[r2];
                    if (r0 == 0) goto L_0x0110;
                L_0x010b:
                    r3 = r6.zzbTI;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x0110:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x0125;
                L_0x0115:
                    r4 = r7.zzacx();
                    r2[r0] = r4;
                    r7.zzacu();
                    r0 = r0 + 1;
                    goto L_0x0110;
                L_0x0121:
                    r0 = r6.zzbTI;
                    r0 = r0.length;
                    goto L_0x0106;
                L_0x0125:
                    r4 = r7.zzacx();
                    r2[r0] = r4;
                    r6.zzbTI = r2;
                    goto L_0x0001;
                L_0x012f:
                    r0 = r7.zzacD();
                    r3 = r7.zzqj(r0);
                    r2 = r7.getPosition();
                    r0 = r1;
                L_0x013c:
                    r4 = r7.zzacI();
                    if (r4 <= 0) goto L_0x0148;
                L_0x0142:
                    r7.zzacx();
                    r0 = r0 + 1;
                    goto L_0x013c;
                L_0x0148:
                    r7.zzql(r2);
                    r2 = r6.zzbTI;
                    if (r2 != 0) goto L_0x0166;
                L_0x014f:
                    r2 = r1;
                L_0x0150:
                    r0 = r0 + r2;
                    r0 = new long[r0];
                    if (r2 == 0) goto L_0x015a;
                L_0x0155:
                    r4 = r6.zzbTI;
                    java.lang.System.arraycopy(r4, r1, r0, r1, r2);
                L_0x015a:
                    r4 = r0.length;
                    if (r2 >= r4) goto L_0x016a;
                L_0x015d:
                    r4 = r7.zzacx();
                    r0[r2] = r4;
                    r2 = r2 + 1;
                    goto L_0x015a;
                L_0x0166:
                    r2 = r6.zzbTI;
                    r2 = r2.length;
                    goto L_0x0150;
                L_0x016a:
                    r6.zzbTI = r0;
                    r7.zzqk(r3);
                    goto L_0x0001;
                L_0x0171:
                    r2 = r7.zzacx();
                    r6.zzbTK = r2;
                    goto L_0x0001;
                L_0x0179:
                    r0 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
                    r2 = com.google.android.gms.internal.zzbuw.zzc(r7, r0);
                    r0 = r6.zzbTJ;
                    if (r0 != 0) goto L_0x019f;
                L_0x0183:
                    r0 = r1;
                L_0x0184:
                    r2 = r2 + r0;
                    r2 = new float[r2];
                    if (r0 == 0) goto L_0x018e;
                L_0x0189:
                    r3 = r6.zzbTJ;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x018e:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x01a3;
                L_0x0193:
                    r3 = r7.readFloat();
                    r2[r0] = r3;
                    r7.zzacu();
                    r0 = r0 + 1;
                    goto L_0x018e;
                L_0x019f:
                    r0 = r6.zzbTJ;
                    r0 = r0.length;
                    goto L_0x0184;
                L_0x01a3:
                    r3 = r7.readFloat();
                    r2[r0] = r3;
                    r6.zzbTJ = r2;
                    goto L_0x0001;
                L_0x01ad:
                    r0 = r7.zzacD();
                    r2 = r7.zzqj(r0);
                    r3 = r0 / 4;
                    r0 = r6.zzbTJ;
                    if (r0 != 0) goto L_0x01d2;
                L_0x01bb:
                    r0 = r1;
                L_0x01bc:
                    r3 = r3 + r0;
                    r3 = new float[r3];
                    if (r0 == 0) goto L_0x01c6;
                L_0x01c1:
                    r4 = r6.zzbTJ;
                    java.lang.System.arraycopy(r4, r1, r3, r1, r0);
                L_0x01c6:
                    r4 = r3.length;
                    if (r0 >= r4) goto L_0x01d6;
                L_0x01c9:
                    r4 = r7.readFloat();
                    r3[r0] = r4;
                    r0 = r0 + 1;
                    goto L_0x01c6;
                L_0x01d2:
                    r0 = r6.zzbTJ;
                    r0 = r0.length;
                    goto L_0x01bc;
                L_0x01d6:
                    r6.zzbTJ = r3;
                    r7.zzqk(r2);
                    goto L_0x0001;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.zzaa(com.google.android.gms.internal.zzbul):com.google.android.gms.internal.zzbih$zza$zza$zza");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public /* synthetic */ com.google.android.gms.internal.zzbut zzb(com.google.android.gms.internal.zzbul r2) throws java.io.IOException {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r1 = this;
                    r0 = r1.zzaa(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.zzb(com.google.android.gms.internal.zzbul):com.google.android.gms.internal.zzbut");
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected int zzv() {
                    /* JADX: method processing error */
/*
                    Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                    /*
                    r8 = this;
                    r6 = 0;
                    r1 = 0;
                    r0 = super.zzv();
                    r2 = r8.zzbTx;
                    r3 = com.google.android.gms.internal.zzbuw.zzcsp;
                    r2 = java.util.Arrays.equals(r2, r3);
                    if (r2 != 0) goto L_0x0019;
                L_0x0011:
                    r2 = 1;
                    r3 = r8.zzbTx;
                    r2 = com.google.android.gms.internal.zzbum.zzc(r2, r3);
                    r0 += r2;
                L_0x0019:
                    r2 = r8.zzbTy;
                    if (r2 == 0) goto L_0x002f;
                L_0x001d:
                    r2 = r8.zzbTy;
                    r3 = "";
                    r2 = r2.equals(r3);
                    if (r2 != 0) goto L_0x002f;
                L_0x0027:
                    r2 = 2;
                    r3 = r8.zzbTy;
                    r2 = com.google.android.gms.internal.zzbum.zzr(r2, r3);
                    r0 += r2;
                L_0x002f:
                    r2 = r8.zzbTz;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = 0;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 == 0) goto L_0x0047;
                L_0x003f:
                    r2 = 3;
                    r4 = r8.zzbTz;
                    r2 = com.google.android.gms.internal.zzbum.zzb(r2, r4);
                    r0 += r2;
                L_0x0047:
                    r2 = r8.zzbTA;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    r3 = 0;
                    r3 = java.lang.Float.floatToIntBits(r3);
                    if (r2 == r3) goto L_0x005c;
                L_0x0054:
                    r2 = 4;
                    r3 = r8.zzbTA;
                    r2 = com.google.android.gms.internal.zzbum.zzd(r2, r3);
                    r0 += r2;
                L_0x005c:
                    r2 = r8.zzbTB;
                    r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r2 == 0) goto L_0x006a;
                L_0x0062:
                    r2 = 5;
                    r4 = r8.zzbTB;
                    r2 = com.google.android.gms.internal.zzbum.zzf(r2, r4);
                    r0 += r2;
                L_0x006a:
                    r2 = r8.zzbTC;
                    if (r2 == 0) goto L_0x0076;
                L_0x006e:
                    r2 = 6;
                    r3 = r8.zzbTC;
                    r2 = com.google.android.gms.internal.zzbum.zzH(r2, r3);
                    r0 += r2;
                L_0x0076:
                    r2 = r8.zzbTD;
                    if (r2 == 0) goto L_0x0082;
                L_0x007a:
                    r2 = 7;
                    r3 = r8.zzbTD;
                    r2 = com.google.android.gms.internal.zzbum.zzI(r2, r3);
                    r0 += r2;
                L_0x0082:
                    r2 = r8.zzbTE;
                    if (r2 == 0) goto L_0x008f;
                L_0x0086:
                    r2 = 8;
                    r3 = r8.zzbTE;
                    r2 = com.google.android.gms.internal.zzbum.zzh(r2, r3);
                    r0 += r2;
                L_0x008f:
                    r2 = r8.zzbTF;
                    if (r2 == 0) goto L_0x00b0;
                L_0x0093:
                    r2 = r8.zzbTF;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00b0;
                L_0x0098:
                    r2 = r0;
                    r0 = r1;
                L_0x009a:
                    r3 = r8.zzbTF;
                    r3 = r3.length;
                    if (r0 >= r3) goto L_0x00af;
                L_0x009f:
                    r3 = r8.zzbTF;
                    r3 = r3[r0];
                    if (r3 == 0) goto L_0x00ac;
                L_0x00a5:
                    r4 = 9;
                    r3 = com.google.android.gms.internal.zzbum.zzc(r4, r3);
                    r2 = r2 + r3;
                L_0x00ac:
                    r0 = r0 + 1;
                    goto L_0x009a;
                L_0x00af:
                    r0 = r2;
                L_0x00b0:
                    r2 = r8.zzbTG;
                    if (r2 == 0) goto L_0x00d1;
                L_0x00b4:
                    r2 = r8.zzbTG;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00d1;
                L_0x00b9:
                    r2 = r0;
                    r0 = r1;
                L_0x00bb:
                    r3 = r8.zzbTG;
                    r3 = r3.length;
                    if (r0 >= r3) goto L_0x00d0;
                L_0x00c0:
                    r3 = r8.zzbTG;
                    r3 = r3[r0];
                    if (r3 == 0) goto L_0x00cd;
                L_0x00c6:
                    r4 = 10;
                    r3 = com.google.android.gms.internal.zzbum.zzc(r4, r3);
                    r2 = r2 + r3;
                L_0x00cd:
                    r0 = r0 + 1;
                    goto L_0x00bb;
                L_0x00d0:
                    r0 = r2;
                L_0x00d1:
                    r2 = r8.zzbTH;
                    if (r2 == 0) goto L_0x00f6;
                L_0x00d5:
                    r2 = r8.zzbTH;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00f6;
                L_0x00da:
                    r2 = r1;
                    r3 = r1;
                    r4 = r1;
                L_0x00dd:
                    r5 = r8.zzbTH;
                    r5 = r5.length;
                    if (r2 >= r5) goto L_0x00f2;
                L_0x00e2:
                    r5 = r8.zzbTH;
                    r5 = r5[r2];
                    if (r5 == 0) goto L_0x00ef;
                L_0x00e8:
                    r4 = r4 + 1;
                    r5 = com.google.android.gms.internal.zzbum.zzkc(r5);
                    r3 = r3 + r5;
                L_0x00ef:
                    r2 = r2 + 1;
                    goto L_0x00dd;
                L_0x00f2:
                    r0 = r0 + r3;
                    r2 = r4 * 1;
                    r0 = r0 + r2;
                L_0x00f6:
                    r2 = r8.zzbTI;
                    if (r2 == 0) goto L_0x0118;
                L_0x00fa:
                    r2 = r8.zzbTI;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x0118;
                L_0x00ff:
                    r2 = r1;
                L_0x0100:
                    r3 = r8.zzbTI;
                    r3 = r3.length;
                    if (r1 >= r3) goto L_0x0111;
                L_0x0105:
                    r3 = r8.zzbTI;
                    r4 = r3[r1];
                    r3 = com.google.android.gms.internal.zzbum.zzbb(r4);
                    r2 = r2 + r3;
                    r1 = r1 + 1;
                    goto L_0x0100;
                L_0x0111:
                    r0 = r0 + r2;
                    r1 = r8.zzbTI;
                    r1 = r1.length;
                    r1 = r1 * 1;
                    r0 = r0 + r1;
                L_0x0118:
                    r2 = r8.zzbTK;
                    r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r1 == 0) goto L_0x0127;
                L_0x011e:
                    r1 = 13;
                    r2 = r8.zzbTK;
                    r1 = com.google.android.gms.internal.zzbum.zzf(r1, r2);
                    r0 = r0 + r1;
                L_0x0127:
                    r1 = r8.zzbTJ;
                    if (r1 == 0) goto L_0x013c;
                L_0x012b:
                    r1 = r8.zzbTJ;
                    r1 = r1.length;
                    if (r1 <= 0) goto L_0x013c;
                L_0x0130:
                    r1 = r8.zzbTJ;
                    r1 = r1.length;
                    r1 = r1 * 4;
                    r0 = r0 + r1;
                    r1 = r8.zzbTJ;
                    r1 = r1.length;
                    r1 = r1 * 1;
                    r0 = r0 + r1;
                L_0x013c:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza.zzv():int");
                }
            }

            public zza() {
                /* JADX: method processing error */
/*
                Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r0 = this;
                r0.<init>();
                r0.zzTd();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.<init>():void");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static com.google.android.gms.internal.zzbih.zza.zza[] zzTc() {
                /* JADX: method processing error */
/*
                Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r0 = zzbTv;
                if (r0 != 0) goto L_0x0011;
            L_0x0004:
                r1 = com.google.android.gms.internal.zzbur.zzcsf;
                monitor-enter(r1);
                r0 = zzbTv;	 Catch:{ all -> 0x0014 }
                if (r0 != 0) goto L_0x0010;	 Catch:{ all -> 0x0014 }
            L_0x000b:
                r0 = 0;	 Catch:{ all -> 0x0014 }
                r0 = new com.google.android.gms.internal.zzbih.zza.zza[r0];	 Catch:{ all -> 0x0014 }
                zzbTv = r0;	 Catch:{ all -> 0x0014 }
            L_0x0010:
                monitor-exit(r1);	 Catch:{ all -> 0x0014 }
            L_0x0011:
                r0 = zzbTv;
                return r0;
            L_0x0014:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0014 }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zzTc():com.google.android.gms.internal.zzbih$zza$zza[]");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(java.lang.Object r5) {
                /* JADX: method processing error */
/*
                Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:63)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r4 = this;
                r1 = 1;
                r0 = 0;
                if (r5 != r4) goto L_0x0006;
            L_0x0004:
                r0 = r1;
            L_0x0005:
                return r0;
            L_0x0006:
                r2 = r5 instanceof com.google.android.gms.internal.zzbih.zza.zza;
                if (r2 == 0) goto L_0x0005;
            L_0x000a:
                r5 = (com.google.android.gms.internal.zzbih.zza.zza) r5;
                r2 = r4.type;
                r3 = r5.type;
                if (r2 != r3) goto L_0x0005;
            L_0x0012:
                r2 = r4.zzbTw;
                if (r2 != 0) goto L_0x0034;
            L_0x0016:
                r2 = r5.zzbTw;
                if (r2 != 0) goto L_0x0005;
            L_0x001a:
                r2 = r4.zzcrX;
                if (r2 == 0) goto L_0x0026;
            L_0x001e:
                r2 = r4.zzcrX;
                r2 = r2.isEmpty();
                if (r2 == 0) goto L_0x003f;
            L_0x0026:
                r2 = r5.zzcrX;
                if (r2 == 0) goto L_0x0032;
            L_0x002a:
                r2 = r5.zzcrX;
                r2 = r2.isEmpty();
                if (r2 == 0) goto L_0x0005;
            L_0x0032:
                r0 = r1;
                goto L_0x0005;
            L_0x0034:
                r2 = r4.zzbTw;
                r3 = r5.zzbTw;
                r2 = r2.equals(r3);
                if (r2 != 0) goto L_0x001a;
            L_0x003e:
                goto L_0x0005;
            L_0x003f:
                r0 = r4.zzcrX;
                r1 = r5.zzcrX;
                r0 = r0.equals(r1);
                goto L_0x0005;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.equals(java.lang.Object):boolean");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int hashCode() {
                /* JADX: method processing error */
/*
                Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:63)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r3 = this;
                r1 = 0;
                r0 = r3.getClass();
                r0 = r0.getName();
                r0 = r0.hashCode();
                r0 += 527;
                r0 *= 31;
                r2 = r3.type;
                r0 += r2;
                r2 = r0 * 31;
                r0 = r3.zzbTw;
                if (r0 != 0) goto L_0x002c;
            L_0x001a:
                r0 = r1;
            L_0x001b:
                r0 = r0 + r2;
                r0 = r0 * 31;
                r2 = r3.zzcrX;
                if (r2 == 0) goto L_0x002a;
            L_0x0022:
                r2 = r3.zzcrX;
                r2 = r2.isEmpty();
                if (r2 == 0) goto L_0x0033;
            L_0x002a:
                r0 = r0 + r1;
                return r0;
            L_0x002c:
                r0 = r3.zzbTw;
                r0 = r0.hashCode();
                goto L_0x001b;
            L_0x0033:
                r1 = r3.zzcrX;
                r1 = r1.hashCode();
                goto L_0x002a;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.hashCode():int");
            }

            public com.google.android.gms.internal.zzbih.zza.zza zzTd() {
                /* JADX: method processing error */
/*
                Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r2 = this;
                r1 = 0;
                r0 = 1;
                r2.type = r0;
                r2.zzbTw = r1;
                r2.zzcrX = r1;
                r0 = -1;
                r2.zzcsg = r0;
                return r2;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zzTd():com.google.android.gms.internal.zzbih$zza$zza");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.android.gms.internal.zzbih.zza.zza zzZ(com.google.android.gms.internal.zzbul r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
                Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r1 = this;
            L_0x0000:
                r0 = r2.zzacu();
                switch(r0) {
                    case 0: goto L_0x000d;
                    case 8: goto L_0x000e;
                    case 18: goto L_0x0019;
                    default: goto L_0x0007;
                };
            L_0x0007:
                r0 = super.zza(r2, r0);
                if (r0 != 0) goto L_0x0000;
            L_0x000d:
                return r1;
            L_0x000e:
                r0 = r2.zzacy();
                switch(r0) {
                    case 1: goto L_0x0016;
                    case 2: goto L_0x0016;
                    case 3: goto L_0x0016;
                    case 4: goto L_0x0016;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0016;
                    case 7: goto L_0x0016;
                    case 8: goto L_0x0016;
                    case 9: goto L_0x0016;
                    case 10: goto L_0x0016;
                    case 11: goto L_0x0016;
                    case 12: goto L_0x0016;
                    case 13: goto L_0x0016;
                    case 14: goto L_0x0016;
                    case 15: goto L_0x0016;
                    default: goto L_0x0015;
                };
            L_0x0015:
                goto L_0x0000;
            L_0x0016:
                r1.type = r0;
                goto L_0x0000;
            L_0x0019:
                r0 = r1.zzbTw;
                if (r0 != 0) goto L_0x0024;
            L_0x001d:
                r0 = new com.google.android.gms.internal.zzbih$zza$zza$zza;
                r0.<init>();
                r1.zzbTw = r0;
            L_0x0024:
                r0 = r1.zzbTw;
                r2.zza(r0);
                goto L_0x0000;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zzZ(com.google.android.gms.internal.zzbul):com.google.android.gms.internal.zzbih$zza$zza");
            }

            public void zza(com.google.android.gms.internal.zzbum r3) throws java.io.IOException {
                /* JADX: method processing error */
/*
                Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r2 = this;
                r0 = 1;
                r1 = r2.type;
                r3.zzF(r0, r1);
                r0 = r2.zzbTw;
                if (r0 == 0) goto L_0x0010;
            L_0x000a:
                r0 = 2;
                r1 = r2.zzbTw;
                r3.zza(r0, r1);
            L_0x0010:
                super.zza(r3);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zza(com.google.android.gms.internal.zzbum):void");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ com.google.android.gms.internal.zzbut zzb(com.google.android.gms.internal.zzbul r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
                Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r1 = this;
                r0 = r1.zzZ(r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zzb(com.google.android.gms.internal.zzbul):com.google.android.gms.internal.zzbut");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected int zzv() {
                /* JADX: method processing error */
/*
                Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
                /*
                r3 = this;
                r0 = super.zzv();
                r1 = 1;
                r2 = r3.type;
                r1 = com.google.android.gms.internal.zzbum.zzH(r1, r2);
                r0 += r1;
                r1 = r3.zzbTw;
                if (r1 == 0) goto L_0x0018;
            L_0x0010:
                r1 = 2;
                r2 = r3.zzbTw;
                r1 = com.google.android.gms.internal.zzbum.zzc(r1, r2);
                r0 += r1;
            L_0x0018:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza.zzv():int");
            }
        }

        public zza() {
            /* JADX: method processing error */
/*
            Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r0 = this;
            r0.<init>();
            r0.zzTb();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.<init>():void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.android.gms.internal.zzbih.zza[] zzTa() {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r0 = zzbTt;
            if (r0 != 0) goto L_0x0011;
        L_0x0004:
            r1 = com.google.android.gms.internal.zzbur.zzcsf;
            monitor-enter(r1);
            r0 = zzbTt;	 Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0010;	 Catch:{ all -> 0x0014 }
        L_0x000b:
            r0 = 0;	 Catch:{ all -> 0x0014 }
            r0 = new com.google.android.gms.internal.zzbih.zza[r0];	 Catch:{ all -> 0x0014 }
            zzbTt = r0;	 Catch:{ all -> 0x0014 }
        L_0x0010:
            monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        L_0x0011:
            r0 = zzbTt;
            return r0;
        L_0x0014:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0014 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zzTa():com.google.android.gms.internal.zzbih$zza[]");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /* JADX: method processing error */
/*
            Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:63)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r4 = this;
            r1 = 1;
            r0 = 0;
            if (r5 != r4) goto L_0x0006;
        L_0x0004:
            r0 = r1;
        L_0x0005:
            return r0;
        L_0x0006:
            r2 = r5 instanceof com.google.android.gms.internal.zzbih.zza;
            if (r2 == 0) goto L_0x0005;
        L_0x000a:
            r5 = (com.google.android.gms.internal.zzbih.zza) r5;
            r2 = r4.name;
            if (r2 != 0) goto L_0x0036;
        L_0x0010:
            r2 = r5.name;
            if (r2 != 0) goto L_0x0005;
        L_0x0014:
            r2 = r4.zzbTu;
            if (r2 != 0) goto L_0x0041;
        L_0x0018:
            r2 = r5.zzbTu;
            if (r2 != 0) goto L_0x0005;
        L_0x001c:
            r2 = r4.zzcrX;
            if (r2 == 0) goto L_0x0028;
        L_0x0020:
            r2 = r4.zzcrX;
            r2 = r2.isEmpty();
            if (r2 == 0) goto L_0x004c;
        L_0x0028:
            r2 = r5.zzcrX;
            if (r2 == 0) goto L_0x0034;
        L_0x002c:
            r2 = r5.zzcrX;
            r2 = r2.isEmpty();
            if (r2 == 0) goto L_0x0005;
        L_0x0034:
            r0 = r1;
            goto L_0x0005;
        L_0x0036:
            r2 = r4.name;
            r3 = r5.name;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x0014;
        L_0x0040:
            goto L_0x0005;
        L_0x0041:
            r2 = r4.zzbTu;
            r3 = r5.zzbTu;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x001c;
        L_0x004b:
            goto L_0x0005;
        L_0x004c:
            r0 = r4.zzcrX;
            r1 = r5.zzcrX;
            r0 = r0.equals(r1);
            goto L_0x0005;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.equals(java.lang.Object):boolean");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int hashCode() {
            /* JADX: method processing error */
/*
            Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:63)
	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r3 = this;
            r1 = 0;
            r0 = r3.getClass();
            r0 = r0.getName();
            r0 = r0.hashCode();
            r0 += 527;
            r2 = r0 * 31;
            r0 = r3.name;
            if (r0 != 0) goto L_0x002f;
        L_0x0015:
            r0 = r1;
        L_0x0016:
            r0 = r0 + r2;
            r2 = r0 * 31;
            r0 = r3.zzbTu;
            if (r0 != 0) goto L_0x0036;
        L_0x001d:
            r0 = r1;
        L_0x001e:
            r0 = r0 + r2;
            r0 = r0 * 31;
            r2 = r3.zzcrX;
            if (r2 == 0) goto L_0x002d;
        L_0x0025:
            r2 = r3.zzcrX;
            r2 = r2.isEmpty();
            if (r2 == 0) goto L_0x003d;
        L_0x002d:
            r0 = r0 + r1;
            return r0;
        L_0x002f:
            r0 = r3.name;
            r0 = r0.hashCode();
            goto L_0x0016;
        L_0x0036:
            r0 = r3.zzbTu;
            r0 = r0.hashCode();
            goto L_0x001e;
        L_0x003d:
            r1 = r3.zzcrX;
            r1 = r1.hashCode();
            goto L_0x002d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.hashCode():int");
        }

        public com.google.android.gms.internal.zzbih.zza zzTb() {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r2 = this;
            r1 = 0;
            r0 = "";
            r2.name = r0;
            r2.zzbTu = r1;
            r2.zzcrX = r1;
            r0 = -1;
            r2.zzcsg = r0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zzTb():com.google.android.gms.internal.zzbih$zza");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.internal.zzbih.zza zzY(com.google.android.gms.internal.zzbul r2) throws java.io.IOException {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r1 = this;
        L_0x0000:
            r0 = r2.zzacu();
            switch(r0) {
                case 0: goto L_0x000d;
                case 10: goto L_0x000e;
                case 18: goto L_0x0015;
                default: goto L_0x0007;
            };
        L_0x0007:
            r0 = super.zza(r2, r0);
            if (r0 != 0) goto L_0x0000;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r2.readString();
            r1.name = r0;
            goto L_0x0000;
        L_0x0015:
            r0 = r1.zzbTu;
            if (r0 != 0) goto L_0x0020;
        L_0x0019:
            r0 = new com.google.android.gms.internal.zzbih$zza$zza;
            r0.<init>();
            r1.zzbTu = r0;
        L_0x0020:
            r0 = r1.zzbTu;
            r2.zza(r0);
            goto L_0x0000;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zzY(com.google.android.gms.internal.zzbul):com.google.android.gms.internal.zzbih$zza");
        }

        public void zza(com.google.android.gms.internal.zzbum r3) throws java.io.IOException {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r2 = this;
            r0 = 1;
            r1 = r2.name;
            r3.zzq(r0, r1);
            r0 = r2.zzbTu;
            if (r0 == 0) goto L_0x0010;
        L_0x000a:
            r0 = 2;
            r1 = r2.zzbTu;
            r3.zza(r0, r1);
        L_0x0010:
            super.zza(r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zza(com.google.android.gms.internal.zzbum):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ com.google.android.gms.internal.zzbut zzb(com.google.android.gms.internal.zzbul r2) throws java.io.IOException {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r1 = this;
            r0 = r1.zzY(r2);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zzb(com.google.android.gms.internal.zzbul):com.google.android.gms.internal.zzbut");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected int zzv() {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:119)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r3 = this;
            r0 = super.zzv();
            r1 = 1;
            r2 = r3.name;
            r1 = com.google.android.gms.internal.zzbum.zzr(r1, r2);
            r0 += r1;
            r1 = r3.zzbTu;
            if (r1 == 0) goto L_0x0018;
        L_0x0010:
            r1 = 2;
            r2 = r3.zzbTu;
            r1 = com.google.android.gms.internal.zzbum.zzc(r1, r2);
            r0 += r1;
        L_0x0018:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbih.zza.zzv():int");
        }
    }

    public zzbih() {
        zzSZ();
    }

    public static zzbih zzR(byte[] bArr) throws zzbus {
        return (zzbih) zzbut.zza(new zzbih(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbih)) {
            return false;
        }
        zzbih com_google_android_gms_internal_zzbih = (zzbih) obj;
        return zzbur.equals(this.zzbTs, com_google_android_gms_internal_zzbih.zzbTs) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbih.zzcrX == null || com_google_android_gms_internal_zzbih.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbih.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzbTs)) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public zzbih zzSZ() {
        this.zzbTs = zza.zzTa();
        this.zzcrX = null;
        this.zzcsg = -1;
        return this;
    }

    public zzbih zzX(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case HTTP.LF /*10*/:
                    int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                    zzacu = this.zzbTs == null ? 0 : this.zzbTs.length;
                    Object obj = new zza[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzbTs, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = new zza();
                    com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                    this.zzbTs = obj;
                    continue;
                default:
                    if (!super.zza(com_google_android_gms_internal_zzbul, zzacu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzbTs != null && this.zzbTs.length > 0) {
            for (zzbut com_google_android_gms_internal_zzbut : this.zzbTs) {
                if (com_google_android_gms_internal_zzbut != null) {
                    com_google_android_gms_internal_zzbum.zza(1, com_google_android_gms_internal_zzbut);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzX(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzbTs != null && this.zzbTs.length > 0) {
            for (zzbut com_google_android_gms_internal_zzbut : this.zzbTs) {
                if (com_google_android_gms_internal_zzbut != null) {
                    zzv += zzbum.zzc(1, com_google_android_gms_internal_zzbut);
                }
            }
        }
        return zzv;
    }
}
