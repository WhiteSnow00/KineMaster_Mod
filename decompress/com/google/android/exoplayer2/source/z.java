// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;
import android.util.SparseArray;

final class z<V>
{
    private int a;
    private final SparseArray<V> b;
    private final Consumer<V> c;
    
    public z(final Consumer<V> c) {
        this.b = (SparseArray<V>)new SparseArray();
        this.c = c;
        this.a = -1;
    }
    
    public void a(final int n, final V v) {
        final int a = this.a;
        final boolean b = false;
        if (a == -1) {
            Assertions.g(this.b.size() == 0);
            this.a = 0;
        }
        if (this.b.size() > 0) {
            final SparseArray<V> b2 = this.b;
            final int key = b2.keyAt(b2.size() - 1);
            boolean b3 = b;
            if (n >= key) {
                b3 = true;
            }
            Assertions.a(b3);
            if (key == n) {
                final Consumer<V> c = this.c;
                final SparseArray<V> b4 = this.b;
                c.accept((V)b4.valueAt(b4.size() - 1));
            }
        }
        this.b.append(n, (Object)v);
    }
    
    public void b() {
        for (int i = 0; i < this.b.size(); ++i) {
            this.c.accept((V)this.b.valueAt(i));
        }
        this.a = -1;
        this.b.clear();
    }
    
    public void c(int min) {
        for (int n = this.b.size() - 1; n >= 0 && min < this.b.keyAt(n); --n) {
            this.c.accept((V)this.b.valueAt(n));
            this.b.removeAt(n);
        }
        if (this.b.size() > 0) {
            min = Math.min(this.a, this.b.size() - 1);
        }
        else {
            min = -1;
        }
        this.a = min;
    }
    
    public void d(final int n) {
        int n2;
        for (int i = 0; i < this.b.size() - 1; i = n2) {
            final SparseArray<V> b = this.b;
            n2 = i + 1;
            if (n < b.keyAt(n2)) {
                break;
            }
            this.c.accept((V)this.b.valueAt(i));
            this.b.removeAt(i);
            final int a = this.a;
            if (a > 0) {
                this.a = a - 1;
            }
        }
    }
    
    public V e(final int n) {
        if (this.a == -1) {
            this.a = 0;
        }
        while (true) {
            final int a = this.a;
            if (a <= 0 || n >= this.b.keyAt(a)) {
                break;
            }
            --this.a;
        }
        while (this.a < this.b.size() - 1 && n >= this.b.keyAt(this.a + 1)) {
            ++this.a;
        }
        return (V)this.b.valueAt(this.a);
    }
    
    public V f() {
        final SparseArray<V> b = this.b;
        return (V)b.valueAt(b.size() - 1);
    }
    
    public boolean g() {
        return this.b.size() == 0;
    }
}
