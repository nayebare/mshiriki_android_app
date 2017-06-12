package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.zzf.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class zzn extends zzk<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public static final zza zzaNz;

    /* renamed from: com.google.android.gms.drive.metadata.internal.zzn.1 */
    class C06491 implements zza {
        C06491() {
        }

        public String zzAH() {
            return "parentsExtraHolder";
        }

        public void zzb(DataHolder dataHolder) {
            zzn.zzd(dataHolder);
        }
    }

    static {
        zzaNz = new C06491();
    }

    public zzn(int i) {
        super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), i);
    }

    private void zzc(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zzwy().getParcelable("parentsExtraHolder");
            if (dataHolder2 == null) {
                return;
            }
            try {
                int i;
                int count = dataHolder.getCount();
                ArrayList arrayList = new ArrayList(count);
                Map hashMap = new HashMap(count);
                for (i = 0; i < count; i++) {
                    int zzcC = dataHolder.zzcC(i);
                    ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                    arrayList.add(parentDriveIdSet);
                    hashMap.put(Long.valueOf(dataHolder.zzb("sqlId", i, zzcC)), parentDriveIdSet);
                }
                Bundle zzwy = dataHolder2.zzwy();
                String string = zzwy.getString("childSqlIdColumn");
                String string2 = zzwy.getString("parentSqlIdColumn");
                String string3 = zzwy.getString("parentResIdColumn");
                int count2 = dataHolder2.getCount();
                for (i = 0; i < count2; i++) {
                    int zzcC2 = dataHolder2.zzcC(i);
                    ((ParentDriveIdSet) hashMap.get(Long.valueOf(dataHolder2.zzb(string, i, zzcC2)))).zza(new zzo(dataHolder2.zzd(string3, i, zzcC2), dataHolder2.zzb(string2, i, zzcC2), 1));
                }
                dataHolder.zzwy().putParcelableArrayList("parentsExtra", arrayList);
            } finally {
                dataHolder2.close();
                dataHolder.zzwy().remove("parentsExtraHolder");
            }
        }
    }

    private static void zzd(DataHolder dataHolder) {
        Bundle zzwy = dataHolder.zzwy();
        if (zzwy != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zzwy.getParcelable("parentsExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zzwy.remove("parentsExtraHolder");
                }
            }
        }
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzd(dataHolder, i, i2);
    }

    protected Collection<DriveId> zzd(DataHolder dataHolder, int i, int i2) {
        Bundle zzwy = dataHolder.zzwy();
        List parcelableArrayList = zzwy.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (zzwy.getParcelable("parentsExtraHolder") != null) {
                zzc(dataHolder);
                parcelableArrayList = zzwy.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        return ((ParentDriveIdSet) parcelableArrayList.get(i)).zzK(zzwy.getLong("dbInstanceId"));
    }

    protected /* synthetic */ Object zzt(Bundle bundle) {
        return zzy(bundle);
    }

    protected Collection<DriveId> zzy(Bundle bundle) {
        Collection zzy = super.zzy(bundle);
        return zzy == null ? null : new HashSet(zzy);
    }
}
