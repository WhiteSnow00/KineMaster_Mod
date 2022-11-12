// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import v0.i;
import v0.j;

public class t0 implements j, i
{
    static final TreeMap<Integer, t0> i;
    private volatile String a;
    final long[] b;
    final double[] c;
    final String[] d;
    final byte[][] e;
    private final int[] f;
    final int g;
    int h;
    
    static {
        i = new TreeMap<Integer, t0>();
    }
    
    private t0(int g) {
        this.g = g;
        ++g;
        this.f = new int[g];
        this.b = new long[g];
        this.c = new double[g];
        this.d = new String[g];
        this.e = new byte[g][];
    }
    
    public static t0 e(final String s, final int n) {
        Object i = t0.i;
        synchronized (i) {
            final Map.Entry<Integer, Object> ceilingEntry = (Map.Entry<Integer, Object>)((TreeMap<Integer, t0>)i).ceilingEntry(Integer.valueOf(n));
            if (ceilingEntry != null) {
                ((TreeMap<Integer, t0>)i).remove(ceilingEntry.getKey());
                final t0 t0 = ceilingEntry.getValue();
                t0.j(s, n);
                return t0;
            }
            monitorexit(i);
            i = new t0(n);
            ((t0)i).j(s, n);
            return (t0)i;
        }
    }
    
    public static t0 i(final j j) {
        final t0 e = e(j.c(), j.a());
        j.d(new i(e) {
            final t0 a;
            
            @Override
            public void E0(final int n, final String s) {
                this.a.E0(n, s);
            }
            
            @Override
            public void G(final int n, final double n2) {
                this.a.G(n, n2);
            }
            
            @Override
            public void U0(final int n, final long n2) {
                this.a.U0(n, n2);
            }
            
            @Override
            public void V0(final int n, final byte[] array) {
                this.a.V0(n, array);
            }
            
            @Override
            public void close() {
            }
            
            @Override
            public void m1(final int n) {
                this.a.m1(n);
            }
        });
        return e;
    }
    
    private static void k() {
        final TreeMap<Integer, t0> i = t0.i;
        if (i.size() > 15) {
            int j = i.size() - 10;
            final Iterator iterator = i.descendingKeySet().iterator();
            while (j > 0) {
                iterator.next();
                iterator.remove();
                --j;
            }
        }
    }
    
    @Override
    public void E0(final int n, final String s) {
        this.f[n] = 4;
        this.d[n] = s;
    }
    
    @Override
    public void G(final int n, final double n2) {
        this.f[n] = 3;
        this.c[n] = n2;
    }
    
    @Override
    public void U0(final int n, final long n2) {
        this.f[n] = 2;
        this.b[n] = n2;
    }
    
    @Override
    public void V0(final int n, final byte[] array) {
        this.f[n] = 5;
        this.e[n] = array;
    }
    
    @Override
    public int a() {
        return this.h;
    }
    
    @Override
    public String c() {
        return this.a;
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public void d(final i i) {
        for (int j = 1; j <= this.h; ++j) {
            final int n = this.f[j];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) {
                            if (n == 5) {
                                i.V0(j, this.e[j]);
                            }
                        }
                        else {
                            i.E0(j, this.d[j]);
                        }
                    }
                    else {
                        i.G(j, this.c[j]);
                    }
                }
                else {
                    i.U0(j, this.b[j]);
                }
            }
            else {
                i.m1(j);
            }
        }
    }
    
    public void h(final t0 t0) {
        final int n = t0.a() + 1;
        System.arraycopy(t0.f, 0, this.f, 0, n);
        System.arraycopy(t0.b, 0, this.b, 0, n);
        System.arraycopy(t0.d, 0, this.d, 0, n);
        System.arraycopy(t0.e, 0, this.e, 0, n);
        System.arraycopy(t0.c, 0, this.c, 0, n);
    }
    
    void j(final String a, final int h) {
        this.a = a;
        this.h = h;
    }
    
    public void l() {
        final TreeMap<Integer, t0> i = t0.i;
        synchronized (i) {
            i.put(this.g, this);
            k();
        }
    }
    
    @Override
    public void m1(final int n) {
        this.f[n] = 1;
    }
}
