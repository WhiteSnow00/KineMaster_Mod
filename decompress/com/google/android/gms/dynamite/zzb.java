// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.util.Log;
import android.os.Looper;

public final class zzb
{
    private static volatile ClassLoader a;
    private static volatile Thread b;
    
    public static ClassLoader a() {
        synchronized (zzb.class) {
            if (zzb.a == null) {
                zzb.a = b();
            }
            return zzb.a;
        }
    }
    
    private static ClassLoader b() {
        synchronized (zzb.class) {
            if (zzb.b == null) {
                zzb.b = c();
                if (zzb.b == null) {
                    return null;
                }
            }
            final Thread b = zzb.b;
            monitorenter(b);
            try {
                try {
                    final ClassLoader contextClassLoader = zzb.b.getContextClassLoader();
                }
                finally {
                    monitorexit(b);
                    monitorexit(b);
                    return;
                }
            }
            catch (final SecurityException ex) {}
        }
    }
    
    private static Thread c() {
        synchronized (zzb.class) {
            final ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup == null) {
                return null;
            }
            monitorenter(Void.class);
            try {
                Label_0283: {
                    try {
                        final int activeGroupCount = threadGroup.activeGroupCount();
                        final ThreadGroup[] array = new ThreadGroup[activeGroupCount];
                        threadGroup.enumerate(array);
                        final int n = 0;
                        for (final ThreadGroup threadGroup2 : array) {
                            if ("dynamiteLoader".equals(threadGroup2.getName())) {
                                ThreadGroup threadGroup3 = threadGroup2;
                                if (threadGroup2 == null) {
                                    threadGroup3 = new ThreadGroup(threadGroup, "dynamiteLoader");
                                }
                                final int activeCount = threadGroup3.activeCount();
                                final Thread[] array2 = new Thread[activeCount];
                                threadGroup3.enumerate(array2);
                                int j = n;
                                while (true) {
                                    while (j < activeCount) {
                                        Thread thread = array2[j];
                                        if ("GmsDynamite".equals(thread.getName())) {
                                            final Thread thread2 = thread;
                                            if (thread != null) {
                                                break Label_0283;
                                            }
                                            try {
                                                final a a = new a(threadGroup3, "GmsDynamite");
                                                try {
                                                    a.setContextClassLoader(null);
                                                    a.start();
                                                    thread = a;
                                                }
                                                catch (final SecurityException ex) {
                                                    thread = a;
                                                }
                                            }
                                            catch (final SecurityException ex) {}
                                        }
                                        else {
                                            ++j;
                                        }
                                    }
                                    Thread thread = null;
                                    continue;
                                }
                            }
                        }
                        ThreadGroup threadGroup2 = null;
                    }
                    finally {
                        monitorexit(Void.class);
                        Thread thread2;
                        while (true) {
                            final Thread thread;
                            thread2 = thread;
                            break Label_0283;
                            final SecurityException ex;
                            final String message = ex.getMessage();
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Failed to enumerate thread/threadgroup ");
                            sb.append(message);
                            Log.w("DynamiteLoaderV2CL", sb.toString());
                            continue;
                        }
                        monitorexit(Void.class);
                        return thread2;
                    }
                }
            }
            catch (final SecurityException ex2) {}
        }
    }
}
