package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class zzazk {

    /* renamed from: com.google.android.gms.internal.zzazk.1 */
    class C11221 implements Runnable {
        final /* synthetic */ Editor zzbGo;

        C11221(Editor editor) {
            this.zzbGo = editor;
        }

        public void run() {
            this.zzbGo.commit();
        }
    }

    public static void zza(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C11221(editor)).start();
        }
    }
}
