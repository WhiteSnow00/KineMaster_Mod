// 
// Decompiled by Procyon v0.6.0
// 

package s2;

import t2.d;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.e;
import p2.m;

public interface i<R> extends m
{
    e getRequest();
    
    void getSize(final h p0);
    
    void onLoadCleared(final Drawable p0);
    
    void onLoadFailed(final Drawable p0);
    
    void onLoadStarted(final Drawable p0);
    
    void onResourceReady(final R p0, final d<? super R> p1);
    
    void removeCallback(final h p0);
    
    void setRequest(final e p0);
}
