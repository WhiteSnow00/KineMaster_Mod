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
public final class DefaultMediaViewVideoRenderer extends MediaViewVideoRenderer
{
    private DefaultMediaViewVideoRendererApi mDefaultMediaViewVideoRendererApi;
    
    public DefaultMediaViewVideoRenderer(final Context context) {
        super(context);
        this.initializeSelf(context);
    }
    
    public DefaultMediaViewVideoRenderer(final Context context, final AttributeSet set) {
        super(context, set);
        this.initializeSelf(context);
    }
    
    public DefaultMediaViewVideoRenderer(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initializeSelf(context);
    }
    
    public DefaultMediaViewVideoRenderer(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.initializeSelf(context);
    }
    
    private void initializeSelf(final Context context) {
        (this.mDefaultMediaViewVideoRendererApi = DynamicLoaderFactory.makeLoader(context).createDefaultMediaViewVideoRendererApi()).initialize(context, this, this.getMediaViewVideoRendererApi(), 0);
    }
    
    @Override
    public void onPrepared() {
        super.onPrepared();
        this.mDefaultMediaViewVideoRendererApi.onPrepared();
    }
}
