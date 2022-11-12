// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.avi;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableList$Builder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;

final class e implements a
{
    public final ImmutableList<a> a;
    private final int b;
    
    private e(final int b, final ImmutableList<a> a) {
        this.b = b;
        this.a = a;
    }
    
    private static a a(final int n, final int n2, final ParsableByteArray parsableByteArray) {
        switch (n) {
            default: {
                return null;
            }
            case 1852994675: {
                return g.a(parsableByteArray);
            }
            case 1752331379: {
                return c.c(parsableByteArray);
            }
            case 1751742049: {
                return b.b(parsableByteArray);
            }
            case 1718776947: {
                return f.d(n2, parsableByteArray);
            }
        }
    }
    
    public static e c(final int n, final ParsableByteArray parsableByteArray) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        final int f = parsableByteArray.f();
        int b = -2;
        while (parsableByteArray.a() > 8) {
            final int q = parsableByteArray.q();
            final int n2 = parsableByteArray.e() + parsableByteArray.q();
            parsableByteArray.O(n2);
            a a;
            if (q == 1414744396) {
                a = c(parsableByteArray.q(), parsableByteArray);
            }
            else {
                a = a(q, b, parsableByteArray);
            }
            int n3 = b;
            if (a != null) {
                if (a.getType() == 1752331379) {
                    b = ((c)a).b();
                }
                immutableList$Builder.i((Object)a);
                n3 = b;
            }
            parsableByteArray.P(n2);
            parsableByteArray.O(f);
            b = n3;
        }
        return new e(n, (ImmutableList<a>)immutableList$Builder.l());
    }
    
    public <T extends a> T b(final Class<T> clazz) {
        for (final a a : this.a) {
            if (a.getClass() == clazz) {
                return (T)a;
            }
        }
        return null;
    }
    
    @Override
    public int getType() {
        return this.b;
    }
}
