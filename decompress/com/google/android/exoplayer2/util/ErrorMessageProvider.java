// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.util.Pair;

public interface ErrorMessageProvider<T extends Throwable>
{
    Pair<Integer, String> a(final T p0);
}
