// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import java.util.Stack;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@ShowFirstParty
public class FastParser<T extends FastJsonResponse>
{
    private static final char[] g;
    private static final char[] h;
    private static final char[] i;
    private static final char[] j;
    private static final char[] k;
    private static final char[] l;
    private static final i m;
    private static final i n;
    private static final i o;
    private static final i p;
    private static final i q;
    private static final i r;
    private static final i s;
    private static final i t;
    private final char[] a;
    private final char[] b;
    private final char[] c;
    private final StringBuilder d;
    private final StringBuilder e;
    private final Stack f;
    
    static {
        g = new char[] { 'u', 'l', 'l' };
        h = new char[] { 'r', 'u', 'e' };
        i = new char[] { 'r', 'u', 'e', '\"' };
        j = new char[] { 'a', 'l', 's', 'e' };
        k = new char[] { 'a', 'l', 's', 'e', '\"' };
        l = new char[] { '\n' };
        m = new a();
        n = new b();
        o = new c();
        p = new d();
        q = new e();
        r = new f();
        s = new g();
        t = new h();
    }
    
    public FastParser() {
        this.a = new char[1];
        this.b = new char[32];
        this.c = new char[1024];
        this.d = new StringBuilder(32);
        this.e = new StringBuilder(1024);
        this.f = new Stack();
    }
    
    @KeepForSdk
    @ShowFirstParty
    public static class ParseException extends Exception
    {
        public ParseException(final String s) {
            super(s);
        }
        
        public ParseException(final String s, final Throwable t) {
            super("Error instantiating inner object", t);
        }
        
        public ParseException(final Throwable t) {
            super(t);
        }
    }
}
