// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nativead;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.ImageView$ScaleType;
import com.google.android.gms.ads.MediaContent;
import android.widget.FrameLayout;

public class MediaView extends FrameLayout
{
    private MediaContent a;
    private boolean b;
    private ImageView$ScaleType c;
    private boolean d;
    private zzb e;
    private zzc f;
    
    public MediaView(final Context context) {
        super(context);
    }
    
    public MediaView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    protected final void a(final zzb e) {
        synchronized (this) {
            this.e = e;
            if (this.b) {
                e.a.c(this.a);
            }
        }
    }
    
    protected final void b(final zzc f) {
        synchronized (this) {
            this.f = f;
            if (this.d) {
                f.a.d(this.c);
            }
        }
    }
    
    public void setImageScaleType(final ImageView$ScaleType c) {
        this.d = true;
        this.c = c;
        final zzc f = this.f;
        if (f != null) {
            f.a.d(c);
        }
    }
    
    public void setMediaContent(final MediaContent a) {
        this.b = true;
        this.a = a;
        final zzb e = this.e;
        if (e != null) {
            e.a.c(a);
        }
    }
}
