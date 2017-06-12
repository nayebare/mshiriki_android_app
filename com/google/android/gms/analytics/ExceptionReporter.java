package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import com.google.android.gms.internal.zzsw;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    private final UncaughtExceptionHandler zzaaB;
    private final Tracker zzaaC;
    private ExceptionParser zzaaD;
    private GoogleAnalytics zzaaE;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.zzaaB = uncaughtExceptionHandler;
            this.zzaaC = tracker;
            this.zzaaD = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            String str = "ExceptionReporter created, original handler is ";
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            zzsw.m27v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.zzaaD;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzaaD = exceptionParser;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.zzaaD != null) {
            str = this.zzaaD.getDescription(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        zzsw.m27v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzaaC.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics zzlT = zzlT();
        zzlT.dispatchLocalHits();
        zzlT.zzlY();
        if (this.zzaaB != null) {
            zzsw.m27v("Passing exception to the original handler");
            this.zzaaB.uncaughtException(thread, th);
        }
    }

    GoogleAnalytics zzlT() {
        if (this.zzaaE == null) {
            this.zzaaE = GoogleAnalytics.getInstance(this.mContext);
        }
        return this.zzaaE;
    }

    UncaughtExceptionHandler zzlU() {
        return this.zzaaB;
    }
}
