package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

public class Thing {
    final Bundle zzaha;

    public static class Builder {
        final Bundle zzahb;

        public Builder() {
            this.zzahb = new Bundle();
        }

        public Thing build() {
            return new Thing(this.zzahb);
        }

        public Builder put(String str, Thing thing) {
            zzac.zzw(str);
            if (thing != null) {
                this.zzahb.putParcelable(str, thing.zzaha);
            }
            return this;
        }

        public Builder put(String str, String str2) {
            zzac.zzw(str);
            if (str2 != null) {
                this.zzahb.putString(str, str2);
            }
            return this;
        }

        public Builder put(String str, boolean z) {
            zzac.zzw(str);
            this.zzahb.putBoolean(str, z);
            return this;
        }

        public Builder put(String str, Thing[] thingArr) {
            zzac.zzw(str);
            if (thingArr != null) {
                ArrayList arrayList = new ArrayList();
                for (Thing thing : thingArr) {
                    if (thing != null) {
                        arrayList.add(thing.zzaha);
                    }
                }
                this.zzahb.putParcelableArray(str, (Parcelable[]) arrayList.toArray(new Bundle[arrayList.size()]));
            }
            return this;
        }

        public Builder put(String str, String[] strArr) {
            zzac.zzw(str);
            if (strArr != null) {
                this.zzahb.putStringArray(str, strArr);
            }
            return this;
        }

        public Builder setDescription(String str) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str);
            return this;
        }

        public Builder setId(String str) {
            if (str != null) {
                put("id", str);
            }
            return this;
        }

        public Builder setName(String str) {
            zzac.zzw(str);
            put("name", str);
            return this;
        }

        public Builder setType(String str) {
            put("type", str);
            return this;
        }

        public Builder setUrl(Uri uri) {
            zzac.zzw(uri);
            put(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            return this;
        }
    }

    Thing(Bundle bundle) {
        this.zzaha = bundle;
    }

    public Bundle zzqk() {
        return this.zzaha;
    }
}
