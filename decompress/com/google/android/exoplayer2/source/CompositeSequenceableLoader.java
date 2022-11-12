// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public class CompositeSequenceableLoader implements SequenceableLoader
{
    protected final SequenceableLoader[] a;
    
    public CompositeSequenceableLoader(final SequenceableLoader[] a) {
        this.a = a;
    }
    
    @Override
    public final long b() {
        final SequenceableLoader[] a = this.a;
        final int length = a.length;
        int i = 0;
        long n = Long.MAX_VALUE;
        while (i < length) {
            final long b = a[i].b();
            long min = n;
            if (b != Long.MIN_VALUE) {
                min = Math.min(n, b);
            }
            ++i;
            n = min;
        }
        long n2 = n;
        if (n == Long.MAX_VALUE) {
            n2 = Long.MIN_VALUE;
        }
        return n2;
    }
    
    @Override
    public boolean d(final long n) {
        boolean b = false;
        int i;
        boolean b5;
        do {
            final long b2 = this.b();
            if (b2 == Long.MIN_VALUE) {
                return b;
            }
            final SequenceableLoader[] a = this.a;
            final int length = a.length;
            int j = 0;
            i = 0;
            while (j < length) {
                final SequenceableLoader sequenceableLoader = a[j];
                final long b3 = sequenceableLoader.b();
                final boolean b4 = b3 != Long.MIN_VALUE && b3 <= n;
                int n2 = 0;
                Label_0113: {
                    if (b3 != b2) {
                        n2 = i;
                        if (!b4) {
                            break Label_0113;
                        }
                    }
                    n2 = (i | (sequenceableLoader.d(n) ? 1 : 0));
                }
                ++j;
                i = n2;
            }
            b5 = (b |= (i != 0));
        } while (i != 0);
        b = b5;
        return b;
    }
    
    @Override
    public final long f() {
        final SequenceableLoader[] a = this.a;
        final int length = a.length;
        int i = 0;
        long n = Long.MAX_VALUE;
        while (i < length) {
            final long f = a[i].f();
            long min = n;
            if (f != Long.MIN_VALUE) {
                min = Math.min(n, f);
            }
            ++i;
            n = min;
        }
        long n2 = n;
        if (n == Long.MAX_VALUE) {
            n2 = Long.MIN_VALUE;
        }
        return n2;
    }
    
    @Override
    public final void g(final long n) {
        final SequenceableLoader[] a = this.a;
        for (int length = a.length, i = 0; i < length; ++i) {
            a[i].g(n);
        }
    }
    
    @Override
    public boolean isLoading() {
        final SequenceableLoader[] a = this.a;
        for (int length = a.length, i = 0; i < length; ++i) {
            if (a[i].isLoading()) {
                return true;
            }
        }
        return false;
    }
}
