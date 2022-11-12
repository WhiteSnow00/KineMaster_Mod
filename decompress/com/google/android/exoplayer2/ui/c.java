// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.util.Comparator;

public final class c implements Comparator
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return SpannedToHtmlConverter.b.a((SpannedToHtmlConverter.b)o, (SpannedToHtmlConverter.b)o2);
    }
}
