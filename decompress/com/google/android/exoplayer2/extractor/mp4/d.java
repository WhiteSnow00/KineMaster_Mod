// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.common.base.Function;

public final class d implements Function
{
    public final FragmentedMp4Extractor a;
    
    public d(final FragmentedMp4Extractor a) {
        this.a = a;
    }
    
    public final Object apply(final Object o) {
        return this.a.m((Track)o);
    }
}
