// 
// Decompiled by Procyon v0.6.0
// 

package com.github.ybq.android.spinkit;

public enum Style
{
    private static final Style[] $VALUES;
    
    CHASING_DOTS(5), 
    CIRCLE(7), 
    CUBE_GRID(8), 
    DOUBLE_BOUNCE(1), 
    FADING_CIRCLE(9), 
    FOLDING_CUBE(10), 
    MULTIPLE_PULSE(12), 
    MULTIPLE_PULSE_RING(14), 
    PULSE(4), 
    PULSE_RING(13), 
    ROTATING_CIRCLE(11), 
    ROTATING_PLANE(0), 
    THREE_BOUNCE(6), 
    WANDERING_CUBES(3), 
    WAVE(2);
    
    private int value;
    
    private Style(final int value) {
        this.value = value;
    }
}
