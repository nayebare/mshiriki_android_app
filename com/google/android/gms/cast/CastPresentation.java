package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.Display;
import android.view.Window;
import com.google.android.gms.drive.DriveFile;

@TargetApi(19)
public abstract class CastPresentation extends Presentation {
    public CastPresentation(Context context, Display display) {
        super(context, display);
        zzrL();
    }

    public CastPresentation(Context context, Display display, int i) {
        super(context, display, i);
        zzrL();
    }

    private void zzrL() {
        Window window = getWindow();
        if (window != null) {
            window.setType(2030);
            window.addFlags(DriveFile.MODE_READ_ONLY);
            window.addFlags(AccessibilityEventCompat.TYPE_ASSIST_READING_CONTEXT);
            window.addFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        }
    }
}
