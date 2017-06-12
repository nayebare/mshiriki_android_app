package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzs extends zzl<UserMetadata> {
    public zzs(String str, int i) {
        super(str, zzdR(str), Collections.emptyList(), i);
    }

    private static String zzI(String str, String str2) {
        return new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(".").append(str2).toString();
    }

    private String zzdQ(String str) {
        return zzI(getName(), str);
    }

    private static Collection<String> zzdR(String str) {
        return Arrays.asList(new String[]{zzI(str, "permissionId"), zzI(str, "displayName"), zzI(str, "picture"), zzI(str, "isAuthenticatedUser"), zzI(str, "emailAddress")});
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzdj(zzdQ("permissionId")) && !dataHolder.zzi(zzdQ("permissionId"), i, i2);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzj(dataHolder, i, i2);
    }

    protected UserMetadata zzj(DataHolder dataHolder, int i, int i2) {
        String zzd = dataHolder.zzd(zzdQ("permissionId"), i, i2);
        if (zzd == null) {
            return null;
        }
        String zzd2 = dataHolder.zzd(zzdQ("displayName"), i, i2);
        String zzd3 = dataHolder.zzd(zzdQ("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.zze(zzdQ("isAuthenticatedUser"), i, i2));
        return new UserMetadata(zzd, zzd2, zzd3, valueOf.booleanValue(), dataHolder.zzd(zzdQ("emailAddress"), i, i2));
    }
}
