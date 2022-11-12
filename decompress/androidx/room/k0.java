// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.ArrayList;
import java.util.List;
import v0.i;

final class k0 implements i
{
    private List<Object> a;
    
    k0() {
        this.a = new ArrayList<Object>();
    }
    
    private void c(int i, final Object o) {
        final int n = i - 1;
        if (n >= this.a.size()) {
            for (i = this.a.size(); i <= n; ++i) {
                this.a.add(null);
            }
        }
        this.a.set(n, o);
    }
    
    @Override
    public void E0(final int n, final String s) {
        this.c(n, s);
    }
    
    @Override
    public void G(final int n, final double n2) {
        this.c(n, n2);
    }
    
    @Override
    public void U0(final int n, final long n2) {
        this.c(n, n2);
    }
    
    @Override
    public void V0(final int n, final byte[] array) {
        this.c(n, array);
    }
    
    List<Object> a() {
        return this.a;
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public void m1(final int n) {
        this.c(n, null);
    }
}
