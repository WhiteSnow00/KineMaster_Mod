// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

import android.content.Context;
import android.widget.ImageView$ScaleType;
import com.google.android.gms.ads.MediaContent;
import android.widget.FrameLayout;

@Deprecated
public class MediaView extends FrameLayout
{
    private MediaContent a;
    private ImageView$ScaleType b;
    
    public MediaView(final Context context) {
        super(context);
    }
    
    public void setImageScaleType(final ImageView$ScaleType b) {
        this.b = b;
    }
    
    public void setMediaContent(final MediaContent a) {
        this.a = a;
    }
}
