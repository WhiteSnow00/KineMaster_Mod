// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import s2.i;
import com.bumptech.glide.load.engine.GlideException;

public interface g<R>
{
    boolean onLoadFailed(final GlideException p0, final Object p1, final i<R> p2, final boolean p3);
    
    boolean onResourceReady(final R p0, final Object p1, final i<R> p2, final DataSource p3, final boolean p4);
}
