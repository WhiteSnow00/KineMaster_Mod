// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import android.widget.FrameLayout;

public final class SubtitleView extends FrameLayout
{
    private List<Cue> a;
    private CaptionStyleCompat b;
    private int c;
    private float d;
    private float e;
    private boolean f;
    private boolean g;
    private int h;
    private a i;
    private View j;
    
    public SubtitleView(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = Collections.emptyList();
        this.b = CaptionStyleCompat.g;
        this.c = 0;
        this.d = 0.0533f;
        this.e = 0.08f;
        this.f = true;
        this.g = true;
        final com.google.android.exoplayer2.ui.a a = new com.google.android.exoplayer2.ui.a(context);
        this.i = (a)a;
        this.addView(this.j = a);
        this.h = 1;
    }
    
    private Cue a(final Cue cue) {
        final Cue.Builder b = cue.b();
        if (!this.f) {
            b0.e(b);
        }
        else if (!this.g) {
            b0.f(b);
        }
        return b.a();
    }
    
    private void c(final int c, final float d) {
        this.c = c;
        this.d = d;
        this.f();
    }
    
    private void f() {
        this.i.a(this.getCuesWithStylingPreferencesApplied(), this.b, this.d, this.c, this.e);
    }
    
    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f && this.g) {
            return this.a;
        }
        final ArrayList list = new ArrayList(this.a.size());
        for (int i = 0; i < this.a.size(); ++i) {
            list.add(this.a(this.a.get(i)));
        }
        return list;
    }
    
    private float getUserCaptionFontScale() {
        final int a = Util.a;
        float fontScale;
        final float n = fontScale = 1.0f;
        if (a >= 19) {
            if (this.isInEditMode()) {
                fontScale = n;
            }
            else {
                final CaptioningManager captioningManager = (CaptioningManager)this.getContext().getSystemService("captioning");
                fontScale = n;
                if (captioningManager != null) {
                    fontScale = n;
                    if (captioningManager.isEnabled()) {
                        fontScale = captioningManager.getFontScale();
                    }
                }
            }
        }
        return fontScale;
    }
    
    private CaptionStyleCompat getUserCaptionStyle() {
        if (Util.a >= 19 && !this.isInEditMode()) {
            final CaptioningManager captioningManager = (CaptioningManager)this.getContext().getSystemService("captioning");
            CaptionStyleCompat captionStyleCompat;
            if (captioningManager != null && captioningManager.isEnabled()) {
                captionStyleCompat = CaptionStyleCompat.a(captioningManager.getUserStyle());
            }
            else {
                captionStyleCompat = CaptionStyleCompat.g;
            }
            return captionStyleCompat;
        }
        return CaptionStyleCompat.g;
    }
    
    private <T extends View & a> void setView(final T j) {
        this.removeView(this.j);
        final View i = this.j;
        if (i instanceof c0) {
            ((c0)i).g();
        }
        this.j = j;
        this.i = j;
        this.addView((View)j);
    }
    
    public void b(final float n, final boolean b) {
        this.c(b ? 1 : 0, n);
    }
    
    public void d() {
        this.setStyle(this.getUserCaptionStyle());
    }
    
    public void e() {
        this.setFractionalTextSize(this.getUserCaptionFontScale() * 0.0533f);
    }
    
    public void setApplyEmbeddedFontSizes(final boolean g) {
        this.g = g;
        this.f();
    }
    
    public void setApplyEmbeddedStyles(final boolean f) {
        this.f = f;
        this.f();
    }
    
    public void setBottomPaddingFraction(final float e) {
        this.e = e;
        this.f();
    }
    
    public void setCues(List<Cue> emptyList) {
        if (emptyList == null) {
            emptyList = Collections.emptyList();
        }
        this.a = emptyList;
        this.f();
    }
    
    public void setFractionalTextSize(final float n) {
        this.b(n, false);
    }
    
    public void setStyle(final CaptionStyleCompat b) {
        this.b = b;
        this.f();
    }
    
    public void setViewType(final int h) {
        if (this.h == h) {
            return;
        }
        if (h != 1) {
            if (h != 2) {
                throw new IllegalArgumentException();
            }
            this.setView(new c0(this.getContext()));
        }
        else {
            this.setView(new com.google.android.exoplayer2.ui.a(this.getContext()));
        }
        this.h = h;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface ViewType {
    }
    
    interface a
    {
        void a(final List<Cue> p0, final CaptionStyleCompat p1, final float p2, final int p3, final float p4);
    }
}
