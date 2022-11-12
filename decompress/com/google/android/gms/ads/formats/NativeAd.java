// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

import android.net.Uri;
import android.graphics.drawable.Drawable;
import java.util.List;

@Deprecated
public abstract class NativeAd
{
    @Deprecated
    public abstract static class AdChoicesInfo
    {
        public abstract List<Image> getImages();
        
        public abstract CharSequence getText();
    }
    
    @Deprecated
    public abstract static class Image
    {
        public abstract Drawable getDrawable();
        
        public abstract double getScale();
        
        public abstract Uri getUri();
        
        public int zza() {
            return -1;
        }
        
        public int zzb() {
            return -1;
        }
    }
}
