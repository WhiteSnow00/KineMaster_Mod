// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import v2.k;
import t2.c;
import t2.e;

public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable
{
    private e<? super TranscodeType> a;
    
    public j() {
        this.a = c.c();
    }
    
    private CHILD d() {
        return (CHILD)this;
    }
    
    public final CHILD b() {
        try {
            return (CHILD)super.clone();
        }
        catch (final CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    final e<? super TranscodeType> c() {
        return this.a;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    public final CHILD e(final e<? super TranscodeType> e) {
        this.a = k.d(e);
        return this.d();
    }
}
