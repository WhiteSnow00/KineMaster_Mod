// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.util.AttributeSet;
import android.content.Context;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import androidx.annotation.Keep;

@Keep
public final class MediaViewVideoRendererWithBackgroundPlayback extends MediaViewVideoRenderer
{
    private DefaultMediaViewVideoRendererApi mDefaultMediaViewVideoRendererApi;
    
    public MediaViewVideoRendererWithBackgroundPlayback(final Context context) {
        super(context);
        this.initialize(context);
    }
    
    public MediaViewVideoRendererWithBackgroundPlayback(final Context context, final AttributeSet set) {
        super(context, set);
        this.initialize(context);
    }
    
    public MediaViewVideoRendererWithBackgroundPlayback(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initialize(context);
    }
    
    public MediaViewVideoRendererWithBackgroundPlayback(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.initialize(context);
    }
    
    private void initialize(final Context context) {
        (this.mDefaultMediaViewVideoRendererApi = DynamicLoaderFactory.makeLoader(context).createDefaultMediaViewVideoRendererApi()).initialize(context, this, this.getMediaViewVideoRendererApi(), 1);
    }
    
    @Override
    public void onPrepared() {
        super.onPrepared();
        this.mDefaultMediaViewVideoRendererApi.onPrepared();
    }
    
    @Override
    public boolean shouldAllowBackgroundPlayback() {
        return true;
    }
}
