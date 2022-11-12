// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.content;

import q1.s;
import q1.c;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.f;
import v1.b;

public class ShapeTrimPath implements b
{
    private final String a;
    private final Type b;
    private final u1.b c;
    private final u1.b d;
    private final u1.b e;
    private final boolean f;
    
    public ShapeTrimPath(final String a, final Type b, final u1.b c, final u1.b d, final u1.b e, final boolean f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public c a(final f f, final a a) {
        return new s(a, this);
    }
    
    public u1.b b() {
        return this.d;
    }
    
    public String c() {
        return this.a;
    }
    
    public u1.b d() {
        return this.e;
    }
    
    public u1.b e() {
        return this.c;
    }
    
    public Type f() {
        return this.b;
    }
    
    public boolean g() {
        return this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Trim Path: {start: ");
        sb.append(this.c);
        sb.append(", end: ");
        sb.append(this.d);
        sb.append(", offset: ");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
    
    public enum Type
    {
        private static final Type[] $VALUES;
        
        INDIVIDUALLY, 
        SIMULTANEOUSLY;
        
        public static Type forId(final int n) {
            if (n == 1) {
                return Type.SIMULTANEOUSLY;
            }
            if (n == 2) {
                return Type.INDIVIDUALLY;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Unknown trim path type ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
