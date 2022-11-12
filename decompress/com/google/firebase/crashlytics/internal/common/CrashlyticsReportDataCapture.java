// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.Iterator;
import android.os.Build$VERSION;
import android.os.StatFs;
import java.util.ArrayList;
import java.util.List;
import android.os.Environment;
import android.app.ActivityManager$RunningAppProcessInfo;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import android.text.TextUtils;
import android.os.Build;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Locale;
import java.util.HashMap;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import android.content.Context;
import java.util.Map;

public class CrashlyticsReportDataCapture
{
    private static final Map<String, Integer> e;
    static final String f;
    private final Context a;
    private final IdManager b;
    private final AppData c;
    private final StackTraceTrimmingStrategy d;
    
    static {
        final HashMap e2 = new HashMap();
        (e = e2).put("armeabi", 5);
        e2.put("armeabi-v7a", 6);
        e2.put("arm64-v8a", 9);
        e2.put("x86", 0);
        e2.put("x86_64", 1);
        f = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.2.12");
    }
    
    public CrashlyticsReportDataCapture(final Context a, final IdManager b, final AppData c, final StackTraceTrimmingStrategy d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    private CrashlyticsReport.Builder a() {
        return CrashlyticsReport.b().h("18.2.12").d(this.c.a).e(this.b.a()).b(this.c.e).c(this.c.f).g(4);
    }
    
    private static int e() {
        final String cpu_ABI = Build.CPU_ABI;
        if (TextUtils.isEmpty((CharSequence)cpu_ABI)) {
            return 7;
        }
        final Integer n = CrashlyticsReportDataCapture.e.get(cpu_ABI.toLowerCase(Locale.US));
        if (n == null) {
            return 7;
        }
        return n;
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage f() {
        return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a().b(0L).d(0L).c(this.c.d).e(this.c.b).a();
    }
    
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> g() {
        return ImmutableList.b(this.f());
    }
    
    private CrashlyticsReport.Session.Event.Application h(final int n, final CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.a().b(applicationExitInfo.b() != 100).f(n).d(this.m(applicationExitInfo)).a();
    }
    
    private CrashlyticsReport.Session.Event.Application i(final int n, final TrimmedThrowableData trimmedThrowableData, final Thread thread, final int n2, final int n3, final boolean b) {
        final ActivityManager$RunningAppProcessInfo j = CommonUtils.j(this.c.d, this.a);
        Boolean value;
        if (j != null) {
            value = (j.importance != 100);
        }
        else {
            value = null;
        }
        return CrashlyticsReport.Session.Event.Application.a().b(value).f(n).d(this.n(trimmedThrowableData, thread, n2, n3, b)).a();
    }
    
    private CrashlyticsReport.Session.Event.Device j(final int n) {
        final b a = com.google.firebase.crashlytics.internal.common.b.a(this.a);
        final Float b = a.b();
        Double value;
        if (b != null) {
            value = (double)b;
        }
        else {
            value = null;
        }
        return CrashlyticsReport.Session.Event.Device.a().b(value).c(a.c()).f(CommonUtils.o(this.a)).e(n).g(CommonUtils.s() - CommonUtils.a(this.a)).d(CommonUtils.b(Environment.getDataDirectory().getPath())).a();
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution.Exception k(final TrimmedThrowableData trimmedThrowableData, final int n, final int n2) {
        return this.l(trimmedThrowableData, n, n2, 0);
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution.Exception l(TrimmedThrowableData d, final int n, final int n2, final int n3) {
        final String b = d.b;
        final String a = d.a;
        StackTraceElement[] c = d.c;
        int n4 = 0;
        int n5 = 0;
        if (c == null) {
            c = new StackTraceElement[0];
        }
        final TrimmedThrowableData d2 = d.d;
        if (n3 >= n2) {
            d = d2;
            while (true) {
                n4 = n5;
                if (d == null) {
                    break;
                }
                d = d.d;
                ++n5;
            }
        }
        final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder d3 = CrashlyticsReport.Session.Event.Application.Execution.Exception.a().f(b).e(a).c(ImmutableList.a(this.p(c, n))).d(n4);
        if (d2 != null && n4 == 0) {
            d3.b(this.l(d2, n, n2, n3 + 1));
        }
        return d3.a();
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution m(final CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().b(applicationExitInfo).e(this.u()).c(this.g()).a();
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution n(final TrimmedThrowableData trimmedThrowableData, final Thread thread, final int n, final int n2, final boolean b) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().f(this.x(trimmedThrowableData, thread, n, b)).d(this.k(trimmedThrowableData, n, n2)).e(this.u()).c(this.g()).a();
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame o(final StackTraceElement stackTraceElement, final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder) {
        final boolean nativeMethod = stackTraceElement.isNativeMethod();
        final long n = 0L;
        long max;
        if (nativeMethod) {
            max = Math.max(stackTraceElement.getLineNumber(), 0L);
        }
        else {
            max = 0L;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName());
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        final String string = sb.toString();
        final String fileName = stackTraceElement.getFileName();
        long n2 = n;
        if (!stackTraceElement.isNativeMethod()) {
            n2 = n;
            if (stackTraceElement.getLineNumber() > 0) {
                n2 = stackTraceElement.getLineNumber();
            }
        }
        return builder.e(max).f(string).b(fileName).d(n2).a();
    }
    
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> p(final StackTraceElement[] array, final int n) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(this.o(array[i], CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a().c(n)));
        }
        return ImmutableList.a((List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame>)list);
    }
    
    private CrashlyticsReport.Session.Application q() {
        return CrashlyticsReport.Session.Application.a().e(this.b.f()).g(this.c.e).d(this.c.f).f(this.b.a()).b(this.c.g.d()).c(this.c.g.e()).a();
    }
    
    private CrashlyticsReport.Session r(final String s, final long n) {
        return CrashlyticsReport.Session.a().l(n).i(s).g(CrashlyticsReportDataCapture.f).b(this.q()).k(this.t()).d(this.s()).h(3).a();
    }
    
    private CrashlyticsReport.Session.Device s() {
        final StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return CrashlyticsReport.Session.Device.a().b(e()).f(Build.MODEL).c(Runtime.getRuntime().availableProcessors()).h(CommonUtils.s()).d(statFs.getBlockCount() * (long)statFs.getBlockSize()).i(CommonUtils.x()).j(CommonUtils.m()).e(Build.MANUFACTURER).g(Build.PRODUCT).a();
    }
    
    private CrashlyticsReport.Session.OperatingSystem t() {
        return CrashlyticsReport.Session.OperatingSystem.a().d(3).e(Build$VERSION.RELEASE).b(Build$VERSION.CODENAME).c(CommonUtils.y()).a();
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution.Signal u() {
        return CrashlyticsReport.Session.Event.Application.Execution.Signal.a().d("0").c("0").b(0L).a();
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution.Thread v(final Thread thread, final StackTraceElement[] array) {
        return this.w(thread, array, 0);
    }
    
    private CrashlyticsReport.Session.Event.Application.Execution.Thread w(final Thread thread, final StackTraceElement[] array, final int n) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.a().d(thread.getName()).c(n).b(ImmutableList.a(this.p(array, n))).a();
    }
    
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> x(final TrimmedThrowableData trimmedThrowableData, final Thread thread, final int n, final boolean b) {
        final ArrayList list = new ArrayList();
        list.add(this.w(thread, trimmedThrowableData.c, n));
        if (b) {
            for (final Map.Entry<Thread, V> entry : Thread.getAllStackTraces().entrySet()) {
                final Thread thread2 = entry.getKey();
                if (!thread2.equals(thread)) {
                    list.add(this.v(thread2, this.d.a((StackTraceElement[])(Object)entry.getValue())));
                }
            }
        }
        return ImmutableList.a((List<CrashlyticsReport.Session.Event.Application.Execution.Thread>)list);
    }
    
    public CrashlyticsReport.Session.Event b(final CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        final int orientation = this.a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.a().f("anr").e(applicationExitInfo.h()).b(this.h(orientation, applicationExitInfo)).c(this.j(orientation)).a();
    }
    
    public CrashlyticsReport.Session.Event c(final Throwable t, final Thread thread, final String s, final long n, final int n2, final int n3, final boolean b) {
        final int orientation = this.a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.a().f(s).e(n).b(this.i(orientation, new TrimmedThrowableData(t, this.d), thread, n2, n3, b)).c(this.j(orientation)).a();
    }
    
    public CrashlyticsReport d(final String s, final long n) {
        return this.a().i(this.r(s, n)).a();
    }
}
