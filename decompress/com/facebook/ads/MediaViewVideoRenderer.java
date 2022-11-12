// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.view.ViewGroup$LayoutParams;
import android.view.View;
import com.facebook.ads.internal.api.AdComponentViewApiProvider;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.util.AttributeSet;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import android.content.Context;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AdComponentFrameLayout;

@Keep
public abstract class MediaViewVideoRenderer extends AdComponentFrameLayout
{
    private MediaViewVideoRendererApi mMediaViewVideoRendererApi;
    @Deprecated
    protected NativeAd nativeAd;
    @Deprecated
    protected VideoAutoplayBehavior videoAutoplayBehavior;
    
    public MediaViewVideoRenderer(final Context context) {
        super(context);
        this.initialize(new AdViewConstructorParams(context));
    }
    
    public MediaViewVideoRenderer(final Context context, final AttributeSet set) {
        super(context, set);
        this.initialize(new AdViewConstructorParams(context, set));
    }
    
    public MediaViewVideoRenderer(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initialize(new AdViewConstructorParams(context, set, n));
    }
    
    public MediaViewVideoRenderer(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.initialize(new AdViewConstructorParams(context, set, n, n2));
    }
    
    private void initialize(final AdViewConstructorParams adViewConstructorParams) {
        this.attachAdComponentViewApi(this.mMediaViewVideoRendererApi = DynamicLoaderFactory.makeLoader(adViewConstructorParams.getContext()).createMediaViewVideoRendererApi());
        this.mMediaViewVideoRendererApi.initialize(adViewConstructorParams, this);
    }
    
    @Override
    public void addView(final View view) {
    }
    
    @Override
    public void addView(final View view, final int n) {
    }
    
    @Override
    public void addView(final View view, final int n, final int n2) {
    }
    
    @Override
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
    }
    
    @Override
    public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
    }
    
    @Deprecated
    public void destroy() {
    }
    
    public final void disengageSeek(final VideoStartReason videoStartReason) {
        this.mMediaViewVideoRendererApi.disengageSeek(videoStartReason);
    }
    
    public final void engageSeek() {
        this.mMediaViewVideoRendererApi.engageSeek();
    }
    
    public final int getCurrentTimeMs() {
        return this.mMediaViewVideoRendererApi.getCurrentTimeMs();
    }
    
    public final int getDuration() {
        return this.mMediaViewVideoRendererApi.getDuration();
    }
    
    public MediaViewVideoRendererApi getMediaViewVideoRendererApi() {
        return this.mMediaViewVideoRendererApi;
    }
    
    @Deprecated
    final View getVideoView() {
        return this.mMediaViewVideoRendererApi.getVideoView();
    }
    
    public final float getVolume() {
        return this.mMediaViewVideoRendererApi.getVolume();
    }
    
    public void onCompleted() {
    }
    
    public void onError() {
    }
    
    public void onPaused() {
    }
    
    public void onPlayed() {
    }
    
    public void onPrepared() {
    }
    
    public void onSeek() {
    }
    
    public void onSeekDisengaged() {
    }
    
    public void onSeekEngaged() {
    }
    
    public void onVolumeChanged() {
    }
    
    public final void pause(final boolean b) {
        this.mMediaViewVideoRendererApi.pause(b);
    }
    
    public final void play(final VideoStartReason videoStartReason) {
        this.mMediaViewVideoRendererApi.play(videoStartReason);
    }
    
    public final void seekTo(final int n) {
        this.mMediaViewVideoRendererApi.seekTo(n);
    }
    
    @Deprecated
    final void setListener(final Object o) {
    }
    
    @Deprecated
    public void setNativeAd(final NativeAd nativeAd) {
        this.nativeAd = nativeAd;
        this.videoAutoplayBehavior = nativeAd.getVideoAutoplayBehavior();
    }
    
    public final void setVolume(final float volume) {
        this.mMediaViewVideoRendererApi.setVolume(volume);
    }
    
    public boolean shouldAllowBackgroundPlayback() {
        return false;
    }
    
    public final boolean shouldAutoplay() {
        return this.mMediaViewVideoRendererApi.shouldAutoplay();
    }
    
    @Deprecated
    public void unsetNativeAd() {
        this.nativeAd = null;
        this.videoAutoplayBehavior = VideoAutoplayBehavior.DEFAULT;
    }
}
