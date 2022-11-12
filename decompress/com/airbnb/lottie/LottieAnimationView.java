// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import android.graphics.Bitmap;
import java.util.Iterator;
import android.graphics.drawable.Drawable$Callback;
import android.util.Log;
import android.view.View;
import androidx.core.view.b0;
import android.text.TextUtils;
import android.os.Parcelable;
import android.animation.Animator$AnimatorListener;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import z1.c;
import e.a;
import java.util.concurrent.Callable;
import android.graphics.Paint;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import java.util.HashSet;
import android.content.Context;
import java.util.Set;
import androidx.appcompat.widget.AppCompatImageView;

public class LottieAnimationView extends AppCompatImageView
{
    private static final String H;
    private static final h<Throwable> I;
    private boolean A;
    private boolean B;
    private RenderMode C;
    private final Set<j> D;
    private int E;
    private m<d> F;
    private d G;
    private final h<d> d;
    private final h<Throwable> e;
    private h<Throwable> f;
    private int g;
    private final f h;
    private boolean i;
    private String j;
    private int p;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    
    static {
        H = LottieAnimationView.class.getSimpleName();
        I = new h<Throwable>() {
            @Override
            public /* bridge */ void a(final Object o) {
                this.b((Throwable)o);
            }
            
            public void b(final Throwable t) {
                if (y1.h.k(t)) {
                    y1.d.d("Unable to load composition.", t);
                    return;
                }
                throw new IllegalStateException("Unable to parse composition", t);
            }
        };
    }
    
    public LottieAnimationView(final Context context) {
        super(context);
        this.d = new h<d>() {
            final LottieAnimationView a;
            
            @Override
            public /* bridge */ void a(final Object o) {
                this.b((d)o);
            }
            
            public void b(final d composition) {
                this.a.setComposition(composition);
            }
        };
        this.e = new h<Throwable>() {
            final LottieAnimationView a;
            
            @Override
            public /* bridge */ void a(final Object o) {
                this.b((Throwable)o);
            }
            
            public void b(final Throwable t) {
                if (LottieAnimationView.c(this.a) != 0) {
                    final LottieAnimationView a = this.a;
                    a.setImageResource(LottieAnimationView.c(a));
                }
                h h;
                if (LottieAnimationView.d(this.a) == null) {
                    h = LottieAnimationView.e();
                }
                else {
                    h = LottieAnimationView.d(this.a);
                }
                h.a(t);
            }
        };
        this.g = 0;
        this.h = new f();
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = RenderMode.AUTOMATIC;
        this.D = new HashSet<j>();
        this.E = 0;
        this.q(null, o.a);
    }
    
    public LottieAnimationView(final Context context, final AttributeSet set) {
        super(context, set);
        this.d = new h<d>() {
            final LottieAnimationView a;
            
            @Override
            public /* bridge */ void a(final Object o) {
                this.b((d)o);
            }
            
            public void b(final d composition) {
                this.a.setComposition(composition);
            }
        };
        this.e = new h<Throwable>() {
            final LottieAnimationView a;
            
            @Override
            public /* bridge */ void a(final Object o) {
                this.b((Throwable)o);
            }
            
            public void b(final Throwable t) {
                if (LottieAnimationView.c(this.a) != 0) {
                    final LottieAnimationView a = this.a;
                    a.setImageResource(LottieAnimationView.c(a));
                }
                h h;
                if (LottieAnimationView.d(this.a) == null) {
                    h = LottieAnimationView.e();
                }
                else {
                    h = LottieAnimationView.d(this.a);
                }
                h.a(t);
            }
        };
        this.g = 0;
        this.h = new f();
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = RenderMode.AUTOMATIC;
        this.D = new HashSet<j>();
        this.E = 0;
        this.q(set, o.a);
    }
    
    static int c(final LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.g;
    }
    
    static h d(final LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.f;
    }
    
    static h e() {
        return LottieAnimationView.I;
    }
    
    static boolean f(final LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.B;
    }
    
    private void k() {
        final m<d> f = this.F;
        if (f != null) {
            f.k(this.d);
            this.F.j(this.e);
        }
    }
    
    private void l() {
        this.G = null;
        this.h.i();
    }
    
    private void n() {
        final int n = LottieAnimationView$f.a[this.C.ordinal()];
        int n3;
        final int n2 = n3 = 2;
        Label_0099: {
            if (n != 1) {
                if (n != 2 && n == 3) {
                    final d g = this.G;
                    boolean b = false;
                    if (g == null || !g.p() || Build$VERSION.SDK_INT >= 28) {
                        final d g2 = this.G;
                        if (g2 == null || g2.l() <= 4) {
                            b = true;
                        }
                    }
                    if (b) {
                        n3 = n2;
                        break Label_0099;
                    }
                }
                n3 = 1;
            }
        }
        if (n3 != this.getLayerType()) {
            this.setLayerType(n3, (Paint)null);
        }
    }
    
    private m<d> o(final String s) {
        if (this.isInEditMode()) {
            return new m<d>(new Callable<l<d>>(this, s) {
                final String a;
                final LottieAnimationView b;
                
                public l<d> a() {
                    l<d> l;
                    if (LottieAnimationView.f(this.b)) {
                        l = com.airbnb.lottie.e.f(this.b.getContext(), this.a);
                    }
                    else {
                        l = com.airbnb.lottie.e.g(this.b.getContext(), this.a, null);
                    }
                    return l;
                }
                
                @Override
                public /* bridge */ Object call() throws Exception {
                    return this.a();
                }
            }, true);
        }
        m<d> m;
        if (this.B) {
            m = com.airbnb.lottie.e.d(this.getContext(), s);
        }
        else {
            m = com.airbnb.lottie.e.e(this.getContext(), s, null);
        }
        return m;
    }
    
    private m<d> p(final int n) {
        if (this.isInEditMode()) {
            return new m<d>(new Callable<l<d>>(this, n) {
                final int a;
                final LottieAnimationView b;
                
                public l<d> a() {
                    l<d> l;
                    if (LottieAnimationView.f(this.b)) {
                        l = com.airbnb.lottie.e.o(this.b.getContext(), this.a);
                    }
                    else {
                        l = com.airbnb.lottie.e.p(this.b.getContext(), this.a, null);
                    }
                    return l;
                }
                
                @Override
                public /* bridge */ Object call() throws Exception {
                    return this.a();
                }
            }, true);
        }
        m<d> m;
        if (this.B) {
            m = com.airbnb.lottie.e.m(this.getContext(), n);
        }
        else {
            m = com.airbnb.lottie.e.n(this.getContext(), n, null);
        }
        return m;
    }
    
    private void q(final AttributeSet set, int animation) {
        final Context context = this.getContext();
        final int[] c = com.airbnb.lottie.p.C;
        boolean b = false;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, c, animation, 0);
        this.B = obtainStyledAttributes.getBoolean(com.airbnb.lottie.p.E, true);
        final int m = com.airbnb.lottie.p.M;
        final boolean hasValue = obtainStyledAttributes.hasValue(m);
        final int i = com.airbnb.lottie.p.I;
        final boolean hasValue2 = obtainStyledAttributes.hasValue(i);
        animation = com.airbnb.lottie.p.S;
        final boolean hasValue3 = obtainStyledAttributes.hasValue(animation);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            animation = obtainStyledAttributes.getResourceId(m, 0);
            if (animation != 0) {
                this.setAnimation(animation);
            }
        }
        else if (hasValue2) {
            final String string = obtainStyledAttributes.getString(i);
            if (string != null) {
                this.setAnimation(string);
            }
        }
        else if (hasValue3) {
            final String string2 = obtainStyledAttributes.getString(animation);
            if (string2 != null) {
                this.setAnimationFromUrl(string2);
            }
        }
        this.setFallbackResource(obtainStyledAttributes.getResourceId(com.airbnb.lottie.p.H, 0));
        if (obtainStyledAttributes.getBoolean(com.airbnb.lottie.p.D, false)) {
            this.y = true;
            this.A = true;
        }
        if (obtainStyledAttributes.getBoolean(com.airbnb.lottie.p.K, false)) {
            this.h.e0(-1);
        }
        animation = com.airbnb.lottie.p.P;
        if (obtainStyledAttributes.hasValue(animation)) {
            this.setRepeatMode(obtainStyledAttributes.getInt(animation, 1));
        }
        animation = com.airbnb.lottie.p.O;
        if (obtainStyledAttributes.hasValue(animation)) {
            this.setRepeatCount(obtainStyledAttributes.getInt(animation, -1));
        }
        animation = com.airbnb.lottie.p.R;
        if (obtainStyledAttributes.hasValue(animation)) {
            this.setSpeed(obtainStyledAttributes.getFloat(animation, 1.0f));
        }
        this.setImageAssetsFolder(obtainStyledAttributes.getString(com.airbnb.lottie.p.J));
        this.setProgress(obtainStyledAttributes.getFloat(com.airbnb.lottie.p.L, 0.0f));
        this.m(obtainStyledAttributes.getBoolean(com.airbnb.lottie.p.G, false));
        animation = com.airbnb.lottie.p.F;
        if (obtainStyledAttributes.hasValue(animation)) {
            animation = obtainStyledAttributes.getResourceId(animation, -1);
            this.i(new t1.d(new String[] { "**" }), k.E, new c<ColorFilter>((ColorFilter)new q(e.a.a(this.getContext(), animation).getDefaultColor())));
        }
        animation = com.airbnb.lottie.p.Q;
        if (obtainStyledAttributes.hasValue(animation)) {
            this.h.h0(obtainStyledAttributes.getFloat(animation, 1.0f));
        }
        animation = com.airbnb.lottie.p.N;
        if (obtainStyledAttributes.hasValue(animation)) {
            final RenderMode automatic = RenderMode.AUTOMATIC;
            if ((animation = obtainStyledAttributes.getInt(animation, automatic.ordinal())) >= RenderMode.values().length) {
                animation = automatic.ordinal();
            }
            this.setRenderMode(RenderMode.values()[animation]);
        }
        obtainStyledAttributes.recycle();
        final f h = this.h;
        if (y1.h.f(this.getContext()) != 0.0f) {
            b = true;
        }
        h.j0(b);
        this.n();
        this.i = true;
    }
    
    private void setCompositionTask(final m<d> m) {
        this.l();
        this.k();
        this.F = m.f(this.d).e(this.e);
    }
    
    private void x() {
        final boolean r = this.r();
        this.setImageDrawable(null);
        this.setImageDrawable(this.h);
        if (r) {
            this.h.M();
        }
    }
    
    public void buildDrawingCache(final boolean b) {
        com.airbnb.lottie.c.a("buildDrawingCache");
        ++this.E;
        super.buildDrawingCache(b);
        if (this.E == 1 && this.getWidth() > 0 && this.getHeight() > 0 && this.getLayerType() == 1 && this.getDrawingCache(b) == null) {
            this.setRenderMode(RenderMode.HARDWARE);
        }
        --this.E;
        com.airbnb.lottie.c.b("buildDrawingCache");
    }
    
    public void g(final Animator$AnimatorListener animator$AnimatorListener) {
        this.h.c(animator$AnimatorListener);
    }
    
    public d getComposition() {
        return this.G;
    }
    
    public long getDuration() {
        final d g = this.G;
        long n;
        if (g != null) {
            n = (long)g.d();
        }
        else {
            n = 0L;
        }
        return n;
    }
    
    public int getFrame() {
        return this.h.s();
    }
    
    public String getImageAssetsFolder() {
        return this.h.v();
    }
    
    public float getMaxFrame() {
        return this.h.w();
    }
    
    public float getMinFrame() {
        return this.h.y();
    }
    
    public n getPerformanceTracker() {
        return this.h.z();
    }
    
    public float getProgress() {
        return this.h.A();
    }
    
    public int getRepeatCount() {
        return this.h.B();
    }
    
    public int getRepeatMode() {
        return this.h.C();
    }
    
    public float getScale() {
        return this.h.D();
    }
    
    public float getSpeed() {
        return this.h.E();
    }
    
    public boolean h(final j j) {
        final d g = this.G;
        if (g != null) {
            j.a(g);
        }
        return this.D.add(j);
    }
    
    public <T> void i(final t1.d d, final T t, final c<T> c) {
        this.h.d(d, t, c);
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        final Drawable drawable2 = this.getDrawable();
        final f h = this.h;
        if (drawable2 == h) {
            super.invalidateDrawable((Drawable)h);
        }
        else {
            super.invalidateDrawable(drawable);
        }
    }
    
    public void j() {
        this.y = false;
        this.x = false;
        this.w = false;
        this.h.h();
        this.n();
    }
    
    public void m(final boolean b) {
        this.h.m(b);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.isInEditMode() && (this.A || this.y)) {
            this.t();
            this.A = false;
            this.y = false;
        }
    }
    
    protected void onDetachedFromWindow() {
        if (this.r()) {
            this.j();
            this.y = true;
        }
        super.onDetachedFromWindow();
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        final String a = savedState.a;
        this.j = a;
        if (!TextUtils.isEmpty((CharSequence)a)) {
            this.setAnimation(this.j);
        }
        final int b = savedState.b;
        if ((this.p = b) != 0) {
            this.setAnimation(b);
        }
        this.setProgress(savedState.c);
        if (savedState.d) {
            this.t();
        }
        this.h.S(savedState.e);
        this.setRepeatMode(savedState.f);
        this.setRepeatCount(savedState.g);
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.j;
        savedState.b = this.p;
        savedState.c = this.h.A();
        savedState.d = (this.h.H() || (!b0.S((View)this) && this.y));
        savedState.e = this.h.v();
        savedState.f = this.h.C();
        savedState.g = this.h.B();
        return (Parcelable)savedState;
    }
    
    protected void onVisibilityChanged(final View view, final int n) {
        if (!this.i) {
            return;
        }
        if (this.isShown()) {
            if (this.x) {
                this.u();
            }
            else if (this.w) {
                this.t();
            }
            this.x = false;
            this.w = false;
        }
        else if (this.r()) {
            this.s();
            this.x = true;
        }
    }
    
    public boolean r() {
        return this.h.H();
    }
    
    public void s() {
        this.A = false;
        this.y = false;
        this.x = false;
        this.w = false;
        this.h.J();
        this.n();
    }
    
    public void setAnimation(final int p) {
        this.p = p;
        this.j = null;
        this.setCompositionTask(this.p(p));
    }
    
    public void setAnimation(final String j) {
        this.j = j;
        this.p = 0;
        this.setCompositionTask(this.o(j));
    }
    
    @Deprecated
    public void setAnimationFromJson(final String s) {
        this.w(s, null);
    }
    
    public void setAnimationFromUrl(final String s) {
        m<d> compositionTask;
        if (this.B) {
            compositionTask = com.airbnb.lottie.e.q(this.getContext(), s);
        }
        else {
            compositionTask = com.airbnb.lottie.e.r(this.getContext(), s, null);
        }
        this.setCompositionTask(compositionTask);
    }
    
    public void setApplyingOpacityToLayersEnabled(final boolean b) {
        this.h.N(b);
    }
    
    public void setCacheComposition(final boolean b) {
        this.B = b;
    }
    
    public void setComposition(final d g) {
        if (com.airbnb.lottie.c.a) {
            final String h = LottieAnimationView.H;
            final StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(g);
            Log.v(h, sb.toString());
        }
        this.h.setCallback((Drawable$Callback)this);
        this.G = g;
        this.z = true;
        final boolean o = this.h.O(g);
        this.z = false;
        this.n();
        if (this.getDrawable() == this.h && !o) {
            return;
        }
        if (!o) {
            this.x();
        }
        this.onVisibilityChanged((View)this, this.getVisibility());
        this.requestLayout();
        final Iterator<j> iterator = this.D.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(g);
        }
    }
    
    public void setFailureListener(final h<Throwable> f) {
        this.f = f;
    }
    
    public void setFallbackResource(final int g) {
        this.g = g;
    }
    
    public void setFontAssetDelegate(final com.airbnb.lottie.a a) {
        this.h.P(a);
    }
    
    public void setFrame(final int n) {
        this.h.Q(n);
    }
    
    public void setImageAssetDelegate(final b b) {
        this.h.R(b);
    }
    
    public void setImageAssetsFolder(final String s) {
        this.h.S(s);
    }
    
    @Override
    public void setImageBitmap(final Bitmap imageBitmap) {
        this.k();
        super.setImageBitmap(imageBitmap);
    }
    
    @Override
    public void setImageDrawable(final Drawable imageDrawable) {
        this.k();
        super.setImageDrawable(imageDrawable);
    }
    
    @Override
    public void setImageResource(final int imageResource) {
        this.k();
        super.setImageResource(imageResource);
    }
    
    public void setMaxFrame(final int n) {
        this.h.T(n);
    }
    
    public void setMaxFrame(final String s) {
        this.h.U(s);
    }
    
    public void setMaxProgress(final float n) {
        this.h.V(n);
    }
    
    public void setMinAndMaxFrame(final String s) {
        this.h.X(s);
    }
    
    public void setMinFrame(final int n) {
        this.h.Y(n);
    }
    
    public void setMinFrame(final String s) {
        this.h.Z(s);
    }
    
    public void setMinProgress(final float n) {
        this.h.a0(n);
    }
    
    public void setOutlineMasksAndMattes(final boolean b) {
        this.h.b0(b);
    }
    
    public void setPerformanceTrackingEnabled(final boolean b) {
        this.h.c0(b);
    }
    
    public void setProgress(final float n) {
        this.h.d0(n);
    }
    
    public void setRenderMode(final RenderMode c) {
        this.C = c;
        this.n();
    }
    
    public void setRepeatCount(final int n) {
        this.h.e0(n);
    }
    
    public void setRepeatMode(final int n) {
        this.h.f0(n);
    }
    
    public void setSafeMode(final boolean b) {
        this.h.g0(b);
    }
    
    public void setScale(final float n) {
        this.h.h0(n);
        if (this.getDrawable() == this.h) {
            this.x();
        }
    }
    
    public void setSpeed(final float n) {
        this.h.i0(n);
    }
    
    public void setTextDelegate(final r r) {
        this.h.k0(r);
    }
    
    public void t() {
        if (this.isShown()) {
            this.h.K();
            this.n();
        }
        else {
            this.w = true;
        }
    }
    
    public void u() {
        if (this.isShown()) {
            this.h.M();
            this.n();
        }
        else {
            this.w = false;
            this.x = true;
        }
    }
    
    public void unscheduleDrawable(final Drawable drawable) {
        Label_0061: {
            if (!this.z) {
                final f h = this.h;
                if (drawable == h && h.H()) {
                    this.s();
                    break Label_0061;
                }
            }
            if (!this.z && drawable instanceof f) {
                final f f = (f)drawable;
                if (f.H()) {
                    f.J();
                }
            }
        }
        super.unscheduleDrawable(drawable);
    }
    
    public void v(final InputStream inputStream, final String s) {
        this.setCompositionTask(com.airbnb.lottie.e.h(inputStream, s));
    }
    
    public void w(final String s, final String s2) {
        this.v(new ByteArrayInputStream(s.getBytes()), s2);
    }
    
    private static class SavedState extends View$BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        String a;
        int b;
        float c;
        boolean d;
        String e;
        int f;
        int g;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel, null);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        private SavedState(final Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            final int int1 = parcel.readInt();
            boolean d = true;
            if (int1 != 1) {
                d = false;
            }
            this.d = d;
            this.e = parcel.readString();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }
        
        SavedState(final Parcel parcel, final LottieAnimationView$a h) {
            this(parcel);
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt((int)(this.d ? 1 : 0));
            parcel.writeString(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }
    }
}
