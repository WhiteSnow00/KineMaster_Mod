// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import java.util.Map;
import android.animation.PropertyValuesHolder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.animation.TypeEvaluator;
import android.animation.ObjectAnimator;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Animator;
import android.view.ViewGroup;
import androidx.core.view.b0;
import android.graphics.Rect;
import android.view.View;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.Property;

public class c extends m
{
    private static final String[] W;
    private static final Property<Drawable, PointF> X;
    private static final Property<k, PointF> Y;
    private static final Property<k, PointF> Z;
    private static final Property<View, PointF> a0;
    private static final Property<View, PointF> b0;
    private static final Property<View, PointF> c0;
    private static z0.k d0;
    private int[] T;
    private boolean U;
    private boolean V;
    
    static {
        W = new String[] { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
        X = new Property<Drawable, PointF>("boundsOrigin") {
            private Rect a = new Rect();
            
            public PointF a(final Drawable drawable) {
                drawable.copyBounds(this.a);
                final Rect a = this.a;
                return new PointF((float)a.left, (float)a.top);
            }
            
            public void b(final Drawable drawable, final PointF pointF) {
                drawable.copyBounds(this.a);
                this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(this.a);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((Drawable)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((Drawable)o, (PointF)o2);
            }
        };
        Y = new Property<k, PointF>("topLeft") {
            public PointF a(final k k) {
                return null;
            }
            
            public void b(final k k, final PointF pointF) {
                k.c(pointF);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((k)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((k)o, (PointF)o2);
            }
        };
        Z = new Property<k, PointF>("bottomRight") {
            public PointF a(final k k) {
                return null;
            }
            
            public void b(final k k, final PointF pointF) {
                k.a(pointF);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((k)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((k)o, (PointF)o2);
            }
        };
        a0 = new Property<View, PointF>("bottomRight") {
            public PointF a(final View view) {
                return null;
            }
            
            public void b(final View view, final PointF pointF) {
                z0.z.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((View)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((View)o, (PointF)o2);
            }
        };
        b0 = new Property<View, PointF>("topLeft") {
            public PointF a(final View view) {
                return null;
            }
            
            public void b(final View view, final PointF pointF) {
                z0.z.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((View)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((View)o, (PointF)o2);
            }
        };
        c0 = new Property<View, PointF>("position") {
            public PointF a(final View view) {
                return null;
            }
            
            public void b(final View view, final PointF pointF) {
                final int round = Math.round(pointF.x);
                final int round2 = Math.round(pointF.y);
                z0.z.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((View)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((View)o, (PointF)o2);
            }
        };
        c.d0 = new z0.k();
    }
    
    public c() {
        this.T = new int[2];
        this.U = false;
        this.V = false;
    }
    
    private void i0(final s s) {
        final View b = s.b;
        if (androidx.core.view.b0.T(b) || b.getWidth() != 0 || b.getHeight() != 0) {
            s.a.put("android:changeBounds:bounds", new Rect(b.getLeft(), b.getTop(), b.getRight(), b.getBottom()));
            s.a.put("android:changeBounds:parent", s.b.getParent());
            if (this.V) {
                s.b.getLocationInWindow(this.T);
                s.a.put("android:changeBounds:windowX", this.T[0]);
                s.a.put("android:changeBounds:windowY", this.T[1]);
            }
            if (this.U) {
                s.a.put("android:changeBounds:clip", androidx.core.view.b0.u(b));
            }
        }
    }
    
    private boolean j0(final View view, final View view2) {
        final boolean v = this.V;
        boolean b = true;
        if (v) {
            final s w = this.w(view, true);
            b = (((w != null) ? (view2 == w.b) : (view == view2)) && b);
        }
        return b;
    }
    
    @Override
    public String[] G() {
        return c.W;
    }
    
    @Override
    public void g(final s s) {
        this.i0(s);
    }
    
    @Override
    public void j(final s s) {
        this.i0(s);
    }
    
    @Override
    public Animator o(final ViewGroup viewGroup, final s s, final s s2) {
        if (s == null || s2 == null) {
            return null;
        }
        final Map<String, Object> a = s.a;
        final Map<String, Object> a2 = s2.a;
        final ViewGroup viewGroup2 = a.get("android:changeBounds:parent");
        final ViewGroup viewGroup3 = a2.get("android:changeBounds:parent");
        if (viewGroup2 != null && viewGroup3 != null) {
            final View b = s2.b;
            if (this.j0((View)viewGroup2, (View)viewGroup3)) {
                final Rect rect = s.a.get("android:changeBounds:bounds");
                final Rect rect2 = s2.a.get("android:changeBounds:bounds");
                final int left = rect.left;
                final int left2 = rect2.left;
                final int top = rect.top;
                final int top2 = rect2.top;
                final int right = rect.right;
                final int right2 = rect2.right;
                final int bottom = rect.bottom;
                final int bottom2 = rect2.bottom;
                final int n = right - left;
                final int n2 = bottom - top;
                final int n3 = right2 - left2;
                final int n4 = bottom2 - top2;
                Rect rect3 = s.a.get("android:changeBounds:clip");
                final Rect rect4 = s2.a.get("android:changeBounds:clip");
                int n6 = 0;
                Label_0299: {
                    if ((n != 0 && n2 != 0) || (n3 != 0 && n4 != 0)) {
                        int n5;
                        if (left == left2 && top == top2) {
                            n5 = 0;
                        }
                        else {
                            n5 = 1;
                        }
                        if (right == right2) {
                            n6 = n5;
                            if (bottom == bottom2) {
                                break Label_0299;
                            }
                        }
                        n6 = n5 + 1;
                    }
                    else {
                        n6 = 0;
                    }
                }
                int n7 = 0;
                Label_0335: {
                    if (rect3 == null || rect3.equals((Object)rect4)) {
                        n7 = n6;
                        if (rect3 != null) {
                            break Label_0335;
                        }
                        n7 = n6;
                        if (rect4 == null) {
                            break Label_0335;
                        }
                    }
                    n7 = n6 + 1;
                }
                if (n7 > 0) {
                    Object o;
                    if (!this.U) {
                        z0.z.f(b, left, top, right, bottom);
                        if (n7 == 2) {
                            if (n == n3 && n2 == n4) {
                                o = z0.f.a(b, c.c0, this.y().a((float)left, (float)top, (float)left2, (float)top2));
                            }
                            else {
                                final k k = new k(b);
                                final ObjectAnimator a3 = z0.f.a(k, c.Y, this.y().a((float)left, (float)top, (float)left2, (float)top2));
                                final ObjectAnimator a4 = z0.f.a(k, c.Z, this.y().a((float)right, (float)bottom, (float)right2, (float)bottom2));
                                o = new AnimatorSet();
                                ((AnimatorSet)o).playTogether(new Animator[] { (Animator)a3, (Animator)a4 });
                                ((AnimatorSet)o).addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, k) {
                                    final k a;
                                    final c b;
                                    private k mViewBounds = k;
                                });
                            }
                        }
                        else if (left == left2 && top == top2) {
                            o = z0.f.a(b, c.a0, this.y().a((float)right, (float)bottom, (float)right2, (float)bottom2));
                        }
                        else {
                            o = z0.f.a(b, c.b0, this.y().a((float)left, (float)top, (float)left2, (float)top2));
                        }
                    }
                    else {
                        z0.z.f(b, left, top, Math.max(n, n3) + left, Math.max(n2, n4) + top);
                        Object a5;
                        if (left == left2 && top == top2) {
                            a5 = null;
                        }
                        else {
                            a5 = z0.f.a(b, c.c0, this.y().a((float)left, (float)top, (float)left2, (float)top2));
                        }
                        if (rect3 == null) {
                            rect3 = new Rect(0, 0, n, n2);
                        }
                        Rect rect5;
                        if (rect4 == null) {
                            rect5 = new Rect(0, 0, n3, n4);
                        }
                        else {
                            rect5 = rect4;
                        }
                        ObjectAnimator ofObject;
                        if (!rect3.equals((Object)rect5)) {
                            androidx.core.view.b0.w0(b, rect3);
                            ofObject = ObjectAnimator.ofObject((Object)b, "clipBounds", (TypeEvaluator)c.d0, new Object[] { rect3, rect5 });
                            ofObject.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, b, rect4, left2, top2, right2, bottom2) {
                                private boolean a;
                                final View b;
                                final Rect c;
                                final int d;
                                final int e;
                                final int f;
                                final int g;
                                final c h;
                                
                                public void onAnimationCancel(final Animator animator) {
                                    this.a = true;
                                }
                                
                                public void onAnimationEnd(final Animator animator) {
                                    if (!this.a) {
                                        androidx.core.view.b0.w0(this.b, this.c);
                                        z0.z.f(this.b, this.d, this.e, this.f, this.g);
                                    }
                                }
                            });
                        }
                        else {
                            ofObject = null;
                        }
                        o = r.c((Animator)a5, (Animator)ofObject);
                    }
                    if (b.getParent() instanceof ViewGroup) {
                        final ViewGroup viewGroup4 = (ViewGroup)b.getParent();
                        z0.w.c(viewGroup4, true);
                        this.b((f)new n(this, viewGroup4) {
                            boolean a = false;
                            final ViewGroup b;
                            final c c;
                            
                            @Override
                            public void a(final m m) {
                                z0.w.c(this.b, false);
                                this.a = true;
                            }
                            
                            @Override
                            public void c(final m m) {
                                if (!this.a) {
                                    z0.w.c(this.b, false);
                                }
                                m.T((f)this);
                            }
                            
                            @Override
                            public void d(final m m) {
                                z0.w.c(this.b, false);
                            }
                            
                            @Override
                            public void e(final m m) {
                                z0.w.c(this.b, true);
                            }
                        });
                    }
                    return (Animator)o;
                }
            }
            else {
                final int intValue = s.a.get("android:changeBounds:windowX");
                final int intValue2 = s.a.get("android:changeBounds:windowY");
                final int intValue3 = s2.a.get("android:changeBounds:windowX");
                final int intValue4 = s2.a.get("android:changeBounds:windowY");
                if (intValue != intValue3 || intValue2 != intValue4) {
                    viewGroup.getLocationInWindow(this.T);
                    final Bitmap bitmap = Bitmap.createBitmap(b.getWidth(), b.getHeight(), Bitmap$Config.ARGB_8888);
                    b.draw(new Canvas(bitmap));
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    final float c = z0.z.c(b);
                    z0.z.g(b, 0.0f);
                    z0.z.b((View)viewGroup).a((Drawable)bitmapDrawable);
                    final g y = this.y();
                    final int[] t = this.T;
                    final ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((Object)bitmapDrawable, new PropertyValuesHolder[] { z0.i.a(z0.c.X, y.a((float)(intValue - t[0]), (float)(intValue2 - t[1]), (float)(intValue3 - t[0]), (float)(intValue4 - t[1]))) });
                    ofPropertyValuesHolder.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, viewGroup, bitmapDrawable, b, c) {
                        final ViewGroup a;
                        final BitmapDrawable b;
                        final View c;
                        final float d;
                        final c e;
                        
                        public void onAnimationEnd(final Animator animator) {
                            z0.z.b((View)this.a).b((Drawable)this.b);
                            z0.z.g(this.c, this.d);
                        }
                    });
                    return (Animator)ofPropertyValuesHolder;
                }
            }
            return null;
        }
        return null;
    }
    
    private static class k
    {
        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;
        
        k(final View e) {
            this.e = e;
        }
        
        private void b() {
            z0.z.f(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }
        
        void a(final PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            final int g = this.g + 1;
            this.g = g;
            if (this.f == g) {
                this.b();
            }
        }
        
        void c(final PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            final int f = this.f + 1;
            this.f = f;
            if (f == this.g) {
                this.b();
            }
        }
    }
}
