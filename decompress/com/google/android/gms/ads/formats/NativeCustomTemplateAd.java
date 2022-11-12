// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

@Deprecated
public interface NativeCustomTemplateAd
{
    String getCustomTemplateId();
    
    public interface DisplayOpenMeasurement
    {
    }
    
    public interface OnCustomClickListener
    {
        void b(final NativeCustomTemplateAd p0, final String p1);
    }
    
    public interface OnCustomTemplateAdLoadedListener
    {
        void a(final NativeCustomTemplateAd p0);
    }
}
