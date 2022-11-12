// 
// Decompiled by Procyon v0.6.0
// 

package f3;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import d3.a;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable$Callback;

public abstract class g extends f
{
    private f[] P;
    private int Q;
    
    public g() {
        this.P = this.O();
        this.M();
        this.N(this.P);
    }
    
    private void M() {
        final f[] p = this.P;
        if (p != null) {
            for (int length = p.length, i = 0; i < length; ++i) {
                p[i].setCallback((Drawable$Callback)this);
            }
        }
    }
    
    public void J(final Canvas canvas) {
        final f[] p = this.P;
        if (p != null) {
            for (final f f : p) {
                final int save = canvas.save();
                f.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }
    
    public f K(final int n) {
        final f[] p = this.P;
        f f;
        if (p == null) {
            f = null;
        }
        else {
            f = p[n];
        }
        return f;
    }
    
    public int L() {
        final f[] p = this.P;
        int length;
        if (p == null) {
            length = 0;
        }
        else {
            length = p.length;
        }
        return length;
    }
    
    public void N(final f... array) {
    }
    
    public abstract f[] O();
    
    @Override
    protected void b(final Canvas canvas) {
    }
    
    @Override
    public int c() {
        return this.Q;
    }
    
    @Override
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        this.J(canvas);
    }
    
    @Override
    public boolean isRunning() {
        return d3.a.b(this.P) || super.isRunning();
    }
    
    @Override
    protected void onBoundsChange(final Rect bounds) {
        super.onBoundsChange(bounds);
        final f[] p = this.P;
        for (int length = p.length, i = 0; i < length; ++i) {
            p[i].setBounds(bounds);
        }
    }
    
    @Override
    public ValueAnimator r() {
        return null;
    }
    
    @Override
    public void start() {
        super.start();
        d3.a.e(this.P);
    }
    
    @Override
    public void stop() {
        super.stop();
        d3.a.f(this.P);
    }
    
    @Override
    public void u(final int q) {
        this.Q = q;
        for (int i = 0; i < this.L(); ++i) {
            this.K(i).u(q);
        }
    }
}
