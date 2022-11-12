// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import java.util.Comparator;

public final class d implements Comparator
{
    public static final d a;
    
    static {
        a = new d();
    }
    
    private d() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return e.b((WebvttCueInfo)o, (WebvttCueInfo)o2);
    }
}
