// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar
{
    private final t a;
    
    public AppCompatSeekBar(final Context context, final AttributeSet set) {
        this(context, set, d.a.K);
    }
    
    public AppCompatSeekBar(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        m0.a((View)this, this.getContext());
        (this.a = new t(this)).c(set, n);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.h();
    }
    
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.i();
    }
    
    protected void onDraw(final Canvas canvas) {
        synchronized (this) {
            super.onDraw(canvas);
            this.a.g(canvas);
        }
    }
}
