// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.content;

import u1.d;
import u1.h;

public class Mask
{
    private final MaskMode a;
    private final h b;
    private final d c;
    private final boolean d;
    
    public Mask(final MaskMode a, final h b, final d c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public MaskMode a() {
        return this.a;
    }
    
    public h b() {
        return this.b;
    }
    
    public d c() {
        return this.c;
    }
    
    public boolean d() {
        return this.d;
    }
    
    public enum MaskMode
    {
        private static final MaskMode[] $VALUES;
        
        MASK_MODE_ADD, 
        MASK_MODE_INTERSECT, 
        MASK_MODE_NONE, 
        MASK_MODE_SUBTRACT;
    }
}
