// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class AuxEffectInfo
{
    public final int a;
    public final float b;
    
    public AuxEffectInfo(final int a, final float b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && AuxEffectInfo.class == o.getClass()) {
            final AuxEffectInfo auxEffectInfo = (AuxEffectInfo)o;
            if (this.a != auxEffectInfo.a || Float.compare(auxEffectInfo.b, this.b) != 0) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (527 + this.a) * 31 + Float.floatToIntBits(this.b);
    }
}
