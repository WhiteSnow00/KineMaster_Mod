// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import java.util.ArrayList;
import android.graphics.drawable.Drawable$ConstantState;
import android.view.Gravity;
import android.graphics.Canvas;
import java.nio.ByteBuffer;
import android.graphics.drawable.Drawable$Callback;
import v2.k;
import android.graphics.Bitmap;
import c2.h;
import android.content.Context;
import a1.a;
import java.util.List;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public class c extends Drawable implements b, Animatable
{
    private final a a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;
    private Paint i;
    private Rect j;
    private List<a1.a> p;
    
    public c(final Context context, final b2.a a, final h<Bitmap> h, final int n, final int n2, final Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.c(context), a, n, n2, h, bitmap)));
    }
    
    c(final a a) {
        this.e = true;
        this.g = -1;
        this.a = v2.k.d(a);
    }
    
    private Drawable$Callback b() {
        Drawable$Callback drawable$Callback;
        for (drawable$Callback = this.getCallback(); drawable$Callback instanceof Drawable; drawable$Callback = ((Drawable)drawable$Callback).getCallback()) {}
        return drawable$Callback;
    }
    
    private Rect d() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }
    
    private Paint h() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }
    
    private void j() {
        final List<a1.a> p = this.p;
        if (p != null) {
            for (int i = 0; i < p.size(); ++i) {
                this.p.get(i).a(this);
            }
        }
    }
    
    private void m() {
        this.f = 0;
    }
    
    private void p() {
        v2.k.a(this.d ^ true, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.a.a.f() == 1) {
            this.invalidateSelf();
        }
        else if (!this.b) {
            this.b = true;
            this.a.a.s((g.b)this);
            this.invalidateSelf();
        }
    }
    
    private void q() {
        this.b = false;
        this.a.a.t((g.b)this);
    }
    
    public void a() {
        if (this.b() == null) {
            this.stop();
            this.invalidateSelf();
            return;
        }
        this.invalidateSelf();
        if (this.g() == this.f() - 1) {
            ++this.f;
        }
        final int g = this.g;
        if (g != -1 && this.f >= g) {
            this.j();
            this.stop();
        }
    }
    
    public ByteBuffer c() {
        return this.a.a.b();
    }
    
    public void draw(final Canvas canvas) {
        if (this.d) {
            return;
        }
        if (this.h) {
            Gravity.apply(119, this.getIntrinsicWidth(), this.getIntrinsicHeight(), this.getBounds(), this.d());
            this.h = false;
        }
        canvas.drawBitmap(this.a.a.c(), (Rect)null, this.d(), this.h());
    }
    
    public Bitmap e() {
        return this.a.a.e();
    }
    
    public int f() {
        return this.a.a.f();
    }
    
    public int g() {
        return this.a.a.d();
    }
    
    public Drawable$ConstantState getConstantState() {
        return this.a;
    }
    
    public int getIntrinsicHeight() {
        return this.a.a.h();
    }
    
    public int getIntrinsicWidth() {
        return this.a.a.l();
    }
    
    public int getOpacity() {
        return -2;
    }
    
    public int i() {
        return this.a.a.k();
    }
    
    public boolean isRunning() {
        return this.b;
    }
    
    public void k() {
        this.d = true;
        this.a.a.a();
    }
    
    public void l(final a1.a a) {
        if (a == null) {
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList<a1.a>();
        }
        this.p.add(a);
    }
    
    public void n(final h<Bitmap> h, final Bitmap bitmap) {
        this.a.a.p(h, bitmap);
    }
    
    public void o(int i) {
        final int n = -1;
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            i = this.a.a.i();
            if (i == 0) {
                i = n;
            }
            this.g = i;
        }
        else {
            this.g = i;
        }
    }
    
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }
    
    public void setAlpha(final int alpha) {
        this.h().setAlpha(alpha);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.h().setColorFilter(colorFilter);
    }
    
    public boolean setVisible(final boolean e, final boolean b) {
        v2.k.a(this.d ^ true, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        if (!(this.e = e)) {
            this.q();
        }
        else if (this.c) {
            this.p();
        }
        return super.setVisible(e, b);
    }
    
    public void start() {
        this.c = true;
        this.m();
        if (this.e) {
            this.p();
        }
    }
    
    public void stop() {
        this.c = false;
        this.q();
    }
    
    static final class a extends Drawable$ConstantState
    {
        final g a;
        
        a(final g a) {
            this.a = a;
        }
        
        public int getChangingConfigurations() {
            return 0;
        }
        
        public Drawable newDrawable() {
            return new c(this);
        }
        
        public Drawable newDrawable(final Resources resources) {
            return this.newDrawable();
        }
    }
}
