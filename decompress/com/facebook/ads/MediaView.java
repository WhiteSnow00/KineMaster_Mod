// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.view.View;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.api.AdComponentViewApiProvider;
import com.facebook.ads.internal.api.AdComponentViewApi;
import android.util.AttributeSet;
import android.content.Context;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AdNativeComponentView;

@Keep
public class MediaView extends AdNativeComponentView
{
    private AdViewConstructorParams mConstructorParams;
    private MediaViewApi mMediaViewApi;
    
    public MediaView(final Context context) {
        super(context);
        this.initializeSelf(new AdViewConstructorParams(context));
    }
    
    public MediaView(final Context context, final AttributeSet set) {
        super(context, set);
        this.initializeSelf(new AdViewConstructorParams(context, set));
    }
    
    public MediaView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initializeSelf(new AdViewConstructorParams(context, set, n));
    }
    
    public MediaView(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.initializeSelf(new AdViewConstructorParams(context, set, n, n2));
    }
    
    static AdComponentViewApi access$002(final MediaView mediaView, final AdComponentViewApi mAdComponentViewApi) {
        return mediaView.mAdComponentViewApi = mAdComponentViewApi;
    }
    
    static MediaViewApi access$100(final MediaView mediaView) {
        return mediaView.mMediaViewApi;
    }
    
    static MediaViewApi access$102(final MediaView mediaView, final MediaViewApi mMediaViewApi) {
        return mediaView.mMediaViewApi = mMediaViewApi;
    }
    
    static AdViewConstructorParams access$200(final MediaView mediaView) {
        return mediaView.mConstructorParams;
    }
    
    static void access$300(final MediaView mediaView, final AdComponentViewApiProvider adComponentViewApiProvider) {
        mediaView.attachAdComponentViewApi(adComponentViewApiProvider);
    }
    
    private void initializeSelf(final AdViewConstructorParams mConstructorParams) {
        this.mConstructorParams = mConstructorParams;
        this.attachAdComponentViewApi(this.mMediaViewApi = DynamicLoaderFactory.makeLoader(mConstructorParams.getContext()).createMediaViewApi());
        this.mMediaViewApi.initialize(mConstructorParams, this);
    }
    
    public void destroy() {
        this.mMediaViewApi.destroy();
    }
    
    @Override
    public View getAdContentsView() {
        return this.mMediaViewApi.getAdContentsView();
    }
    
    public int getMediaHeight() {
        return this.mMediaViewApi.getMediaHeight();
    }
    
    public MediaViewApi getMediaViewApi() {
        return this.mMediaViewApi;
    }
    
    public int getMediaWidth() {
        return this.mMediaViewApi.getMediaWidth();
    }
    
    public void repair(final Throwable t) {
        this.post((Runnable)new Runnable(this) {
            final MediaView a;
            
            @Override
            public void run() {
                this.a.removeAllViews();
                MediaView.access$002(this.a, null);
                final MediaView a = this.a;
                MediaView.access$102(a, DynamicLoaderFactory.makeLoader(MediaView.access$200(a).getContext()).createMediaViewApi());
                final MediaView a2 = this.a;
                MediaView.access$300(a2, MediaView.access$100(a2));
                MediaView.access$100(this.a).initialize(MediaView.access$200(this.a), this.a);
            }
        });
    }
    
    public void setListener(final MediaViewListener listener) {
        this.mMediaViewApi.setListener(listener);
    }
    
    public void setVideoRenderer(final MediaViewVideoRenderer videoRenderer) {
        this.mMediaViewApi.setVideoRenderer(videoRenderer);
    }
}
