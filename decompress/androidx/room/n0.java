// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.List;
import v0.k;

final class n0 implements k
{
    private final k a;
    private final RoomDatabase.e b;
    private final String c;
    private final List<Object> d;
    private final Executor e;
    
    n0(final k a, final RoomDatabase.e b, final String c, final Executor e) {
        this.d = new ArrayList<Object>();
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
    }
    
    public static void a(final n0 n0) {
        n0.d();
    }
    
    public static void c(final n0 n0) {
        n0.e();
    }
    
    private void d() {
        this.b.a(this.c, this.d);
    }
    
    private void e() {
        this.b.a(this.c, this.d);
    }
    
    private void h(int i, final Object o) {
        final int n = i - 1;
        if (n >= this.d.size()) {
            for (i = this.d.size(); i <= n; ++i) {
                this.d.add(null);
            }
        }
        this.d.set(n, o);
    }
    
    @Override
    public long A0() {
        this.e.execute(new l0(this));
        return this.a.A0();
    }
    
    @Override
    public int C() {
        this.e.execute(new m0(this));
        return this.a.C();
    }
    
    @Override
    public void E0(final int n, final String s) {
        this.h(n, s);
        this.a.E0(n, s);
    }
    
    @Override
    public void G(final int n, final double n2) {
        this.h(n, n2);
        this.a.G(n, n2);
    }
    
    @Override
    public void U0(final int n, final long n2) {
        this.h(n, n2);
        this.a.U0(n, n2);
    }
    
    @Override
    public void V0(final int n, final byte[] array) {
        this.h(n, array);
        this.a.V0(n, array);
    }
    
    @Override
    public void close() throws IOException {
        this.a.close();
    }
    
    @Override
    public void m1(final int n) {
        this.h(n, this.d.toArray());
        this.a.m1(n);
    }
}
