package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zzb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class zzq extends zzb<String> {
    public zzq(String str, int i) {
        super(str, Collections.singleton(str), Collections.emptySet(), i);
    }

    public static Collection<String> zzdP(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    protected void zza(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzd(dataHolder, i, i2);
    }

    protected Collection<String> zzd(DataHolder dataHolder, int i, int i2) {
        try {
            return zzdP(dataHolder.zzd(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    protected /* synthetic */ Object zzt(Bundle bundle) {
        return zzy(bundle);
    }

    protected Collection<String> zzy(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
