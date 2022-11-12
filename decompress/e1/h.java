// 
// Decompiled by Procyon v0.6.0
// 

package e1;

import android.util.Log;

public abstract class h
{
    private static h a;
    private static final int b = 20;
    
    public h(final int n) {
    }
    
    public static h c() {
        synchronized (h.class) {
            if (h.a == null) {
                h.a = new a(3);
            }
            return h.a;
        }
    }
    
    public static void e(final h a) {
        synchronized (h.class) {
            h.a = a;
        }
    }
    
    public static String f(final String s) {
        final int length = s.length();
        final StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        final int b = h.b;
        if (length >= b) {
            sb.append(s.substring(0, b));
        }
        else {
            sb.append(s);
        }
        return sb.toString();
    }
    
    public abstract void a(final String p0, final String p1, final Throwable... p2);
    
    public abstract void b(final String p0, final String p1, final Throwable... p2);
    
    public abstract void d(final String p0, final String p1, final Throwable... p2);
    
    public abstract void g(final String p0, final String p1, final Throwable... p2);
    
    public abstract void h(final String p0, final String p1, final Throwable... p2);
    
    public static class a extends h
    {
        private int c;
        
        public a(final int c) {
            super(c);
            this.c = c;
        }
        
        @Override
        public void a(final String s, final String s2, final Throwable... array) {
            if (this.c <= 3) {
                if (array != null && array.length >= 1) {
                    Log.d(s, s2, array[0]);
                }
                else {
                    Log.d(s, s2);
                }
            }
        }
        
        @Override
        public void b(final String s, final String s2, final Throwable... array) {
            if (this.c <= 6) {
                if (array != null && array.length >= 1) {
                    Log.e(s, s2, array[0]);
                }
                else {
                    Log.e(s, s2);
                }
            }
        }
        
        @Override
        public void d(final String s, final String s2, final Throwable... array) {
            if (this.c <= 4) {
                if (array != null && array.length >= 1) {
                    Log.i(s, s2, array[0]);
                }
                else {
                    Log.i(s, s2);
                }
            }
        }
        
        @Override
        public void g(final String s, final String s2, final Throwable... array) {
            if (this.c <= 2) {
                if (array != null && array.length >= 1) {
                    Log.v(s, s2, array[0]);
                }
                else {
                    Log.v(s, s2);
                }
            }
        }
        
        @Override
        public void h(final String s, final String s2, final Throwable... array) {
            if (this.c <= 5) {
                if (array != null && array.length >= 1) {
                    Log.w(s, s2, array[0]);
                }
                else {
                    Log.w(s, s2);
                }
            }
        }
    }
}
