// 
// Decompiled by Procyon v0.6.0
// 

package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.Shader$TileMode;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.b0;
import android.graphics.drawable.shapes.Shape;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.content.Context;
import android.view.animation.Animation$AnimationListener;
import android.widget.ImageView;

class a extends ImageView
{
    private Animation$AnimationListener a;
    int b;
    
    a(final Context context, final int color) {
        super(context);
        final float density = this.getContext().getResources().getDisplayMetrics().density;
        final int n = (int)(1.75f * density);
        final int n2 = (int)(0.0f * density);
        this.b = (int)(3.5f * density);
        ShapeDrawable shapeDrawable;
        if (this.a()) {
            shapeDrawable = new ShapeDrawable((Shape)new OvalShape());
            b0.x0((View)this, density * 4.0f);
        }
        else {
            shapeDrawable = new ShapeDrawable((Shape)new a(this.b));
            this.setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float)this.b, (float)n2, (float)n, 503316480);
            final int b = this.b;
            this.setPadding(b, b, b, b);
        }
        shapeDrawable.getPaint().setColor(color);
        b0.t0((View)this, (Drawable)shapeDrawable);
    }
    
    private boolean a() {
        return true;
    }
    
    public void b(final Animation$AnimationListener a) {
        this.a = a;
    }
    
    public void onAnimationEnd() {
        super.onAnimationEnd();
        final Animation$AnimationListener a = this.a;
        if (a != null) {
            a.onAnimationEnd(this.getAnimation());
        }
    }
    
    public void onAnimationStart() {
        super.onAnimationStart();
        final Animation$AnimationListener a = this.a;
        if (a != null) {
            a.onAnimationStart(this.getAnimation());
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (!this.a()) {
            this.setMeasuredDimension(this.getMeasuredWidth() + this.b * 2, this.getMeasuredHeight() + this.b * 2);
        }
    }
    
    public void setBackgroundColor(final int color) {
        if (this.getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable)this.getBackground()).getPaint().setColor(color);
        }
    }
    
    private class a extends OvalShape
    {
        private RadialGradient a;
        private Paint b;
        final androidx.swiperefreshlayout.widget.a c;
        
        a(final androidx.swiperefreshlayout.widget.a c, final int b) {
            this.c = c;
            this.b = new Paint();
            c.b = b;
            this.b((int)this.rect().width());
        }
        
        private void b(final int n) {
            final float n2 = (float)(n / 2);
            final RadialGradient radialGradient = new RadialGradient(n2, n2, (float)this.c.b, new int[] { 1023410176, 0 }, (float[])null, Shader$TileMode.CLAMP);
            this.a = radialGradient;
            this.b.setShader((Shader)radialGradient);
        }
        
        public void draw(final Canvas canvas, final Paint paint) {
            final int width = this.c.getWidth();
            final int height = this.c.getHeight();
            final int n = width / 2;
            final float n2 = (float)n;
            final float n3 = (float)(height / 2);
            canvas.drawCircle(n2, n3, n2, this.b);
            canvas.drawCircle(n2, n3, (float)(n - this.c.b), paint);
        }
        
        protected void onResize(final float n, final float n2) {
            super.onResize(n, n2);
            this.b((int)n);
        }
    }
}
