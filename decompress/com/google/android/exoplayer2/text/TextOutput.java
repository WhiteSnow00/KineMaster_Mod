// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import java.util.List;

public interface TextOutput
{
    void onCues(final CueGroup p0);
    
    @Deprecated
    default void onCues(final List<Cue> list) {
    }
}
