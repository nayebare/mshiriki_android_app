package com.google.android.gms.internal;

public class zzbqb {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !zzbqb.class.desiredAssertionStatus();
    }

    private static long zzd(zzbpb<?> com_google_android_gms_internal_zzbpb_) {
        long j = 8;
        if (!((com_google_android_gms_internal_zzbpb_ instanceof zzbow) || (com_google_android_gms_internal_zzbpb_ instanceof zzbpc))) {
            if (com_google_android_gms_internal_zzbpb_ instanceof zzbor) {
                j = 4;
            } else if (com_google_android_gms_internal_zzbpb_ instanceof zzbpk) {
                j = (long) (((String) com_google_android_gms_internal_zzbpb_.getValue()).length() + 2);
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzbpb_.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown leaf node type: ").append(valueOf).toString());
            }
        }
        if (com_google_android_gms_internal_zzbpb_.zzZe().isEmpty()) {
            return j;
        }
        return zzd((zzbpb) com_google_android_gms_internal_zzbpb_.zzZe()) + (24 + j);
    }

    public static long zzt(zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbpe.isEmpty()) {
            return 4;
        }
        if (com_google_android_gms_internal_zzbpe.zzZd()) {
            return zzd((zzbpb) com_google_android_gms_internal_zzbpe);
        }
        if ($assertionsDisabled || (com_google_android_gms_internal_zzbpe instanceof zzbot)) {
            long j = 1;
            for (zzbpd com_google_android_gms_internal_zzbpd : com_google_android_gms_internal_zzbpe) {
                j = zzt(com_google_android_gms_internal_zzbpd.zzUY()) + ((j + ((long) com_google_android_gms_internal_zzbpd.zzZz().asString().length())) + 4);
            }
            return !com_google_android_gms_internal_zzbpe.zzZe().isEmpty() ? (j + 12) + zzd((zzbpb) com_google_android_gms_internal_zzbpe.zzZe()) : j;
        } else {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzbpe.getClass());
            throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
        }
    }

    public static int zzu(zzbpe com_google_android_gms_internal_zzbpe) {
        if (com_google_android_gms_internal_zzbpe.isEmpty()) {
            return 0;
        }
        if (com_google_android_gms_internal_zzbpe.zzZd()) {
            return 1;
        }
        if ($assertionsDisabled || (com_google_android_gms_internal_zzbpe instanceof zzbot)) {
            int i = 0;
            for (zzbpd zzUY : com_google_android_gms_internal_zzbpe) {
                i = zzu(zzUY.zzUY()) + i;
            }
            return i;
        }
        String valueOf = String.valueOf(com_google_android_gms_internal_zzbpe.getClass());
        throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
    }
}
