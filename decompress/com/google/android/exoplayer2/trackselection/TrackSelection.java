// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.Format;

public interface TrackSelection
{
    Format f(final int p0);
    
    int g(final int p0);
    
    int k(final int p0);
    
    TrackGroup l();
    
    int length();
    
    int p(final Format p0);
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Type {
    }
}
