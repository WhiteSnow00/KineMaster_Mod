// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

public final class RendererConfiguration
{
    public static final RendererConfiguration b;
    public final boolean a;
    
    static {
        b = new RendererConfiguration(false);
    }
    
    public RendererConfiguration(final boolean a) {
        this.a = a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && RendererConfiguration.class == o.getClass()) {
            if (this.a != ((RendererConfiguration)o).a) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.a ^ true) ? 1 : 0;
    }
}
