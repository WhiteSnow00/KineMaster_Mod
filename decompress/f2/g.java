// 
// Decompiled by Procyon v0.6.0
// 

package f2;

import com.bumptech.glide.load.engine.s;
import c2.b;
import v2.h;

public class g extends h<b, s<?>> implements h
{
    private a e;
    
    public g(final long n) {
        super(n);
    }
    
    @Override
    public void a(final int n) {
        if (n >= 40) {
            this.b();
        }
        else if (n >= 20 || n == 15) {
            this.m(this.h() / 2L);
        }
    }
    
    @Override
    public /* bridge */ s c(final b b) {
        return super.l(b);
    }
    
    @Override
    public void d(final a e) {
        this.e = e;
    }
    
    @Override
    public /* bridge */ s e(final b b, final s s) {
        return super.k(b, s);
    }
    
    @Override
    protected /* bridge */ int i(final Object o) {
        return this.n((s<?>)o);
    }
    
    @Override
    protected /* bridge */ void j(final Object o, final Object o2) {
        this.o((b)o, (s<?>)o2);
    }
    
    protected int n(final s<?> s) {
        if (s == null) {
            return super.i(null);
        }
        return s.a();
    }
    
    protected void o(final b b, final s<?> s) {
        final a e = this.e;
        if (e != null && s != null) {
            e.a(s);
        }
    }
}
