// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.logging;

import java.util.Locale;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class Logger
{
    private final String a;
    private final String b;
    private final GmsLogger c;
    private final int d;
    
    @KeepForSdk
    public Logger(final String a, final String... array) {
        final int length = array.length;
        String string;
        if (length == 0) {
            string = "";
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (final String s : array) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(s);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.b = string;
        this.a = a;
        this.c = new GmsLogger(a);
        int d;
        for (d = 2; d <= 7 && !Log.isLoggable(this.a, d); ++d) {}
        this.d = d;
    }
    
    @KeepForSdk
    public void a(final String s, final Object... array) {
        if (this.f(3)) {
            Log.d(this.a, this.d(s, array));
        }
    }
    
    @KeepForSdk
    public void b(final String s, final Throwable t, final Object... array) {
        Log.e(this.a, this.d(s, array), t);
    }
    
    @KeepForSdk
    public void c(final String s, final Object... array) {
        Log.e(this.a, this.d(s, array));
    }
    
    @KeepForSdk
    protected String d(final String s, final Object... array) {
        String format = s;
        if (array != null) {
            format = s;
            if (array.length > 0) {
                format = String.format(Locale.US, s, array);
            }
        }
        return this.b.concat(format);
    }
    
    @KeepForSdk
    public void e(final String s, final Object... array) {
        Log.i(this.a, this.d(s, array));
    }
    
    @KeepForSdk
    public boolean f(final int n) {
        return this.d <= n;
    }
    
    @KeepForSdk
    public void g(final String s, final Object... array) {
        if (this.f(2)) {
            Log.v(this.a, this.d(s, array));
        }
    }
    
    @KeepForSdk
    public void h(final String s, final Object... array) {
        Log.w(this.a, this.d(s, array));
    }
    
    @KeepForSdk
    public void i(final String s, final Throwable t, final Object... array) {
        Log.wtf(this.a, this.d(s, array), t);
    }
    
    @KeepForSdk
    public void j(final Throwable t) {
        Log.wtf(this.a, t);
    }
}
