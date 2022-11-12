// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import java.util.List;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;

public final class zzo implements Comparator
{
    public static final zzo a;
    
    static {
        a = new zzo();
    }
    
    private zzo() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        final String s = (String)o;
        final String s2 = (String)o2;
        final List e = RequestConfiguration.e;
        return e.indexOf(s) - e.indexOf(s2);
    }
}
