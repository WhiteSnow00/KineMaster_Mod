// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;

public final class FlagSet
{
    private final SparseBooleanArray a;
    
    private FlagSet(final SparseBooleanArray a) {
        this.a = a;
    }
    
    FlagSet(final SparseBooleanArray sparseBooleanArray, final FlagSet$a object) {
        this(sparseBooleanArray);
    }
    
    public boolean a(final int n) {
        return this.a.get(n);
    }
    
    public boolean b(final int... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (this.a(array[i])) {
                return true;
            }
        }
        return false;
    }
    
    public int c(final int n) {
        Assertions.c(n, 0, this.d());
        return this.a.keyAt(n);
    }
    
    public int d() {
        return this.a.size();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlagSet)) {
            return false;
        }
        final FlagSet set = (FlagSet)o;
        if (Util.a >= 24) {
            return this.a.equals((Object)set.a);
        }
        if (this.d() != set.d()) {
            return false;
        }
        for (int i = 0; i < this.d(); ++i) {
            if (this.c(i) != set.c(i)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        if (Util.a < 24) {
            int d = this.d();
            for (int i = 0; i < this.d(); ++i) {
                d = d * 31 + this.c(i);
            }
            return d;
        }
        return this.a.hashCode();
    }
    
    public static final class Builder
    {
        private final SparseBooleanArray a;
        private boolean b;
        
        public Builder() {
            this.a = new SparseBooleanArray();
        }
        
        public Builder a(final int n) {
            Assertions.g(this.b ^ true);
            this.a.append(n, true);
            return this;
        }
        
        public Builder b(final FlagSet set) {
            for (int i = 0; i < set.d(); ++i) {
                this.a(set.c(i));
            }
            return this;
        }
        
        public Builder c(final int... array) {
            for (int length = array.length, i = 0; i < length; ++i) {
                this.a(array[i]);
            }
            return this;
        }
        
        public Builder d(final int n, final boolean b) {
            if (b) {
                return this.a(n);
            }
            return this;
        }
        
        public FlagSet e() {
            Assertions.g(this.b ^ true);
            this.b = true;
            return new FlagSet(this.a, null);
        }
    }
}
