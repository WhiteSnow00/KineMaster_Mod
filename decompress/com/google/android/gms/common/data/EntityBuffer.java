// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T>
{
    private boolean b;
    private ArrayList c;
    
    private final void t() {
        synchronized (this) {
            if (!this.b) {
                final int count = Preconditions.k(super.a).getCount();
                final ArrayList c = new ArrayList();
                this.c = c;
                if (count > 0) {
                    c.add(0);
                    final String k = this.k();
                    String n1 = super.a.N1(k, 0, super.a.O1(0));
                    String s;
                    for (int i = 1; i < count; ++i, n1 = s) {
                        final int o1 = super.a.O1(i);
                        final String n2 = super.a.N1(k, i, o1);
                        if (n2 == null) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Missing value for markerColumn: ");
                            sb.append(k);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(o1);
                            throw new NullPointerException(sb.toString());
                        }
                        s = n1;
                        if (!n2.equals(n1)) {
                            this.c.add(i);
                            s = n2;
                        }
                    }
                }
                this.b = true;
            }
        }
    }
    
    @KeepForSdk
    protected String a() {
        return null;
    }
    
    @KeepForSdk
    protected abstract T e(final int p0, final int p1);
    
    @KeepForSdk
    @Override
    public final T get(int s) {
        this.t();
        final int s2 = this.s(s);
        int n2;
        final int n = n2 = 0;
        if (s >= 0) {
            if (s == this.c.size()) {
                n2 = n;
            }
            else {
                int n3;
                int n4;
                if (s == this.c.size() - 1) {
                    n3 = Preconditions.k(super.a).getCount();
                    n4 = this.c.get(s);
                }
                else {
                    n3 = this.c.get(s + 1);
                    n4 = this.c.get(s);
                }
                n2 = n3 - n4;
                if (n2 == 1) {
                    s = this.s(s);
                    final int o1 = Preconditions.k(super.a).O1(s);
                    final String a = this.a();
                    if (a != null && super.a.N1(a, s, o1) == null) {
                        n2 = n;
                    }
                    else {
                        n2 = 1;
                    }
                }
            }
        }
        return this.e(s2, n2);
    }
    
    @KeepForSdk
    @Override
    public int getCount() {
        this.t();
        return this.c.size();
    }
    
    @KeepForSdk
    protected abstract String k();
    
    final int s(final int n) {
        if (n >= 0 && n < this.c.size()) {
            return this.c.get(n);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Position ");
        sb.append(n);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }
}
