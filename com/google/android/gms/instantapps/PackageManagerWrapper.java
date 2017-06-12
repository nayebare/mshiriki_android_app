package com.google.android.gms.instantapps;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public interface PackageManagerWrapper {
    ApplicationInfo getApplicationInfo(String str, int i) throws NameNotFoundException;

    CharSequence getApplicationLabel(ApplicationInfo applicationInfo);

    ComponentName getCallingActivity(Activity activity);

    String getCallingPackage(Activity activity);

    PackageInfo getPackageInfo(String str, int i) throws NameNotFoundException;

    String[] getPackagesForUid(int i);

    boolean isInstantApp(int i);
}
