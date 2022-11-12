// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.content;

import android.graphics.Paint$Join;
import android.graphics.Paint$Cap;
import q1.r;
import q1.c;
import com.airbnb.lottie.f;
import u1.d;
import u1.a;
import java.util.List;
import v1.b;

public class ShapeStroke implements b
{
    private final String a;
    private final u1.b b;
    private final List<u1.b> c;
    private final a d;
    private final d e;
    private final u1.b f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;
    private final boolean j;
    
    public ShapeStroke(final String a, final u1.b b, final List<u1.b> c, final a d, final d e, final u1.b f, final LineCapType g, final LineJoinType h, final float i, final boolean j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    @Override
    public c a(final f f, final com.airbnb.lottie.model.layer.a a) {
        return new r(f, a, this);
    }
    
    public LineCapType b() {
        return this.g;
    }
    
    public a c() {
        return this.d;
    }
    
    public u1.b d() {
        return this.b;
    }
    
    public LineJoinType e() {
        return this.h;
    }
    
    public List<u1.b> f() {
        return this.c;
    }
    
    public float g() {
        return this.i;
    }
    
    public String h() {
        return this.a;
    }
    
    public d i() {
        return this.e;
    }
    
    public u1.b j() {
        return this.f;
    }
    
    public boolean k() {
        return this.j;
    }
    
    public enum LineCapType
    {
        private static final LineCapType[] $VALUES;
        
        BUTT, 
        ROUND, 
        UNKNOWN;
        
        public Paint$Cap toPaintCap() {
            final int n = ShapeStroke$a.a[this.ordinal()];
            if (n == 1) {
                return Paint$Cap.BUTT;
            }
            if (n != 2) {
                return Paint$Cap.SQUARE;
            }
            return Paint$Cap.ROUND;
        }
    }
    
    public enum LineJoinType
    {
        private static final LineJoinType[] $VALUES;
        
        BEVEL, 
        MITER, 
        ROUND;
        
        public Paint$Join toPaintJoin() {
            final int n = ShapeStroke$a.b[this.ordinal()];
            if (n == 1) {
                return Paint$Join.BEVEL;
            }
            if (n == 2) {
                return Paint$Join.MITER;
            }
            if (n != 3) {
                return null;
            }
            return Paint$Join.ROUND;
        }
    }
}
