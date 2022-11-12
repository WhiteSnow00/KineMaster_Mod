// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

public enum MemoryCategory
{
    private static final MemoryCategory[] $VALUES;
    
    HIGH(1.5f), 
    LOW(0.5f), 
    NORMAL(1.0f);
    
    private final float multiplier;
    
    private MemoryCategory(final float multiplier) {
        this.multiplier = multiplier;
    }
    
    public float getMultiplier() {
        return this.multiplier;
    }
}
