// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.os.LocaleList;
import java.util.Locale;
import y.a;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.widget.n;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import androidx.core.view.b0;
import android.util.AttributeSet;
import android.graphics.PorterDuff$Mode;
import androidx.core.widget.b;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.content.res.Resources$NotFoundException;
import androidx.core.content.res.f;
import java.lang.ref.WeakReference;
import android.os.Build$VERSION;
import d.j;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

class v
{
    private final TextView a;
    private p0 b;
    private p0 c;
    private p0 d;
    private p0 e;
    private p0 f;
    private p0 g;
    private p0 h;
    private final w i;
    private int j;
    private int k;
    private Typeface l;
    private boolean m;
    
    v(final TextView a) {
        this.j = 0;
        this.k = -1;
        this.a = a;
        this.i = new w(a);
    }
    
    private void B(final int n, final float n2) {
        this.i.t(n, n2);
    }
    
    private void C(final Context context, final r0 r0) {
        this.j = r0.k(d.j.V2, this.j);
        final int sdk_INT = Build$VERSION.SDK_INT;
        final boolean b = false;
        if (sdk_INT >= 28 && (this.k = r0.k(d.j.Y2, -1)) != -1) {
            this.j = ((this.j & 0x2) | 0x0);
        }
        int n = d.j.X2;
        if (!r0.s(n) && !r0.s(d.j.Z2)) {
            final int u2 = d.j.U2;
            if (r0.s(u2)) {
                this.m = false;
                final int k = r0.k(u2, 1);
                if (k != 1) {
                    if (k != 2) {
                        if (k == 3) {
                            this.l = Typeface.MONOSPACE;
                        }
                    }
                    else {
                        this.l = Typeface.SERIF;
                    }
                }
                else {
                    this.l = Typeface.SANS_SERIF;
                }
            }
            return;
        }
        this.l = null;
        final int z2 = d.j.Z2;
        if (r0.s(z2)) {
            n = z2;
        }
        final int i = this.k;
        final int j = this.j;
        while (true) {
            if (context.isRestricted()) {
                break Label_0323;
            }
            final androidx.core.content.res.f.e e = new androidx.core.content.res.f.e(this, i, j, new WeakReference((T)this.a)) {
                final int a;
                final int b;
                final WeakReference c;
                final v d;
                
                @Override
                public void h(final int n) {
                }
                
                @Override
                public void i(final Typeface typeface) {
                    Typeface a = typeface;
                    if (Build$VERSION.SDK_INT >= 28) {
                        final int a2 = this.a;
                        a = typeface;
                        if (a2 != -1) {
                            a = v.f.a(typeface, a2, (this.b & 0x2) != 0x0);
                        }
                    }
                    this.d.n(this.c, a);
                }
            };
            try {
                final Typeface l = r0.j(n, this.j, e);
                if (l != null) {
                    if (sdk_INT >= 28 && this.k != -1) {
                        this.l = v.f.a(Typeface.create(l, 0), this.k, (this.j & 0x2) != 0x0);
                    }
                    else {
                        this.l = l;
                    }
                }
                this.m = (this.l == null);
                if (this.l == null) {
                    final String o = r0.o(n);
                    if (o != null) {
                        if (Build$VERSION.SDK_INT >= 28 && this.k != -1) {
                            final Typeface create = Typeface.create(o, 0);
                            n = this.k;
                            boolean b2 = b;
                            if ((this.j & 0x2) != 0x0) {
                                b2 = true;
                            }
                            this.l = v.f.a(create, n, b2);
                        }
                        else {
                            this.l = Typeface.create(o, this.j);
                        }
                    }
                }
            }
            catch (final UnsupportedOperationException | Resources$NotFoundException ex) {
                continue;
            }
            break;
        }
    }
    
    private void a(final Drawable drawable, final p0 p2) {
        if (drawable != null && p2 != null) {
            androidx.appcompat.widget.h.i(drawable, p2, this.a.getDrawableState());
        }
    }
    
    private static p0 d(final Context context, final h h, final int n) {
        final ColorStateList f = h.f(context, n);
        if (f != null) {
            final p0 p3 = new p0();
            p3.d = true;
            p3.a = f;
            return p3;
        }
        return null;
    }
    
    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                final Drawable[] a = v.c.a(this.a);
                if (a[0] != null || a[2] != null) {
                    final TextView a2 = this.a;
                    drawable = a[0];
                    if (drawable2 == null) {
                        drawable2 = a[1];
                    }
                    drawable6 = a[2];
                    if (drawable4 == null) {
                        drawable4 = a[3];
                    }
                    v.c.b(a2, drawable, drawable2, drawable6, drawable4);
                    return;
                }
                final Drawable[] compoundDrawables = this.a.getCompoundDrawables();
                final TextView a3 = this.a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                a3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            }
        }
        else {
            final Drawable[] a4 = v.c.a(this.a);
            final TextView a5 = this.a;
            if (drawable5 == null) {
                drawable5 = a4[0];
            }
            if (drawable2 == null) {
                drawable2 = a4[1];
            }
            if (drawable6 == null) {
                drawable6 = a4[2];
            }
            if (drawable4 == null) {
                drawable4 = a4[3];
            }
            v.c.b(a5, drawable5, drawable2, drawable6, drawable4);
        }
    }
    
    private void z() {
        final p0 h = this.h;
        this.b = h;
        this.c = h;
        this.d = h;
        this.e = h;
        this.f = h;
        this.g = h;
    }
    
    void A(final int n, final float n2) {
        if (!androidx.core.widget.b.k && !this.l()) {
            this.B(n, n2);
        }
    }
    
    void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            final Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            this.a(compoundDrawables[0], this.b);
            this.a(compoundDrawables[1], this.c);
            this.a(compoundDrawables[2], this.d);
            this.a(compoundDrawables[3], this.e);
        }
        if (this.f != null || this.g != null) {
            final Drawable[] a = v.c.a(this.a);
            this.a(a[0], this.f);
            this.a(a[2], this.g);
        }
    }
    
    void c() {
        this.i.a();
    }
    
    int e() {
        return this.i.f();
    }
    
    int f() {
        return this.i.g();
    }
    
    int g() {
        return this.i.h();
    }
    
    int[] h() {
        return this.i.i();
    }
    
    int i() {
        return this.i.j();
    }
    
    ColorStateList j() {
        final p0 h = this.h;
        ColorStateList a;
        if (h != null) {
            a = h.a;
        }
        else {
            a = null;
        }
        return a;
    }
    
    PorterDuff$Mode k() {
        final p0 h = this.h;
        PorterDuff$Mode b;
        if (h != null) {
            b = h.b;
        }
        else {
            b = null;
        }
        return b;
    }
    
    boolean l() {
        return this.i.n();
    }
    
    void m(final AttributeSet set, int n) {
        final Context context = this.a.getContext();
        final h b = androidx.appcompat.widget.h.b();
        final int[] y = d.j.Y;
        final r0 v = r0.v(context, set, y, n, 0);
        final TextView a = this.a;
        b0.n0((View)a, a.getContext(), y, set, v.r(), n, 0);
        final int n2 = v.n(d.j.Z, -1);
        final int c0 = d.j.c0;
        if (v.s(c0)) {
            this.b = d(context, b, v.n(c0, 0));
        }
        final int a2 = d.j.a0;
        if (v.s(a2)) {
            this.c = d(context, b, v.n(a2, 0));
        }
        final int d0 = d.j.d0;
        if (v.s(d0)) {
            this.d = d(context, b, v.n(d0, 0));
        }
        final int b2 = d.j.b0;
        if (v.s(b2)) {
            this.e = d(context, b, v.n(b2, 0));
        }
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int e0 = d.j.e0;
        if (v.s(e0)) {
            this.f = d(context, b, v.n(e0, 0));
        }
        final int f0 = d.j.f0;
        if (v.s(f0)) {
            this.g = d(context, b, v.n(f0, 0));
        }
        v.w();
        final boolean b3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean b5;
        boolean b6;
        String o3;
        String o4;
        if (n2 != -1) {
            final r0 t = r0.t(context, n2, d.j.S2);
            Label_0346: {
                if (!b3) {
                    final int b4 = d.j.b3;
                    if (t.s(b4)) {
                        b5 = t.a(b4, false);
                        b6 = true;
                        break Label_0346;
                    }
                }
                b5 = false;
                b6 = false;
            }
            this.C(context, t);
            final int c2 = d.j.c3;
            String o;
            if (t.s(c2)) {
                o = t.o(c2);
            }
            else {
                o = null;
            }
            final int a3 = d.j.a3;
            String o2;
            if (t.s(a3)) {
                o2 = t.o(a3);
            }
            else {
                o2 = null;
            }
            t.w();
            o3 = o;
            o4 = o2;
        }
        else {
            b5 = false;
            b6 = false;
            o3 = null;
            o4 = null;
        }
        final r0 v2 = r0.v(context, set, d.j.S2, n, 0);
        if (!b3) {
            final int b7 = d.j.b3;
            if (v2.s(b7)) {
                b5 = v2.a(b7, false);
                b6 = true;
            }
        }
        final int c3 = d.j.c3;
        if (v2.s(c3)) {
            o3 = v2.o(c3);
        }
        final int a4 = d.j.a3;
        if (v2.s(a4)) {
            o4 = v2.o(a4);
        }
        if (sdk_INT >= 28) {
            final int t2 = d.j.T2;
            if (v2.s(t2) && v2.f(t2, -1) == 0) {
                this.a.setTextSize(0, 0.0f);
            }
        }
        this.C(context, v2);
        v2.w();
        if (!b3 && b6) {
            this.s(b5);
        }
        final Typeface l = this.l;
        if (l != null) {
            if (this.k == -1) {
                this.a.setTypeface(l, this.j);
            }
            else {
                this.a.setTypeface(l);
            }
        }
        if (o4 != null) {
            androidx.appcompat.widget.v.e.d(this.a, o4);
        }
        if (o3 != null) {
            androidx.appcompat.widget.v.d.b(this.a, androidx.appcompat.widget.v.d.a(o3));
        }
        this.i.o(set, n);
        if (androidx.core.widget.b.k && this.i.j() != 0) {
            final int[] i = this.i.i();
            if (i.length > 0) {
                if (androidx.appcompat.widget.v.e.a(this.a) != -1.0f) {
                    androidx.appcompat.widget.v.e.b(this.a, this.i.g(), this.i.f(), this.i.h(), 0);
                }
                else {
                    androidx.appcompat.widget.v.e.c(this.a, i, 0);
                }
            }
        }
        final r0 u = r0.u(context, set, d.j.g0);
        n = u.n(d.j.o0, -1);
        Drawable c4;
        if (n != -1) {
            c4 = b.c(context, n);
        }
        else {
            c4 = null;
        }
        n = u.n(d.j.t0, -1);
        Drawable c5;
        if (n != -1) {
            c5 = b.c(context, n);
        }
        else {
            c5 = null;
        }
        n = u.n(d.j.p0, -1);
        Drawable c6;
        if (n != -1) {
            c6 = b.c(context, n);
        }
        else {
            c6 = null;
        }
        n = u.n(d.j.m0, -1);
        Drawable c7;
        if (n != -1) {
            c7 = b.c(context, n);
        }
        else {
            c7 = null;
        }
        n = u.n(d.j.q0, -1);
        Drawable c8;
        if (n != -1) {
            c8 = b.c(context, n);
        }
        else {
            c8 = null;
        }
        n = u.n(d.j.n0, -1);
        Drawable c9;
        if (n != -1) {
            c9 = b.c(context, n);
        }
        else {
            c9 = null;
        }
        this.y(c4, c5, c6, c7, c8, c9);
        n = d.j.r0;
        if (u.s(n)) {
            n.i(this.a, u.c(n));
        }
        n = d.j.s0;
        if (u.s(n)) {
            n.j(this.a, a0.e(u.k(n, -1), null));
        }
        final int f2 = u.f(d.j.v0, -1);
        final int f3 = u.f(d.j.w0, -1);
        n = u.f(d.j.x0, -1);
        u.w();
        if (f2 != -1) {
            n.m(this.a, f2);
        }
        if (f3 != -1) {
            n.n(this.a, f3);
        }
        if (n != -1) {
            n.o(this.a, n);
        }
    }
    
    void n(final WeakReference<TextView> weakReference, final Typeface l) {
        if (this.m) {
            this.l = l;
            final TextView textView = weakReference.get();
            if (textView != null) {
                if (b0.S((View)textView)) {
                    textView.post((Runnable)new Runnable(this, textView, l, this.j) {
                        final TextView a;
                        final Typeface b;
                        final int c;
                        final v d;
                        
                        @Override
                        public void run() {
                            this.a.setTypeface(this.b, this.c);
                        }
                    });
                }
                else {
                    textView.setTypeface(l, this.j);
                }
            }
        }
    }
    
    void o(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (!b.k) {
            this.c();
        }
    }
    
    void p() {
        this.b();
    }
    
    void q(final Context context, int n) {
        final r0 t = r0.t(context, n, d.j.S2);
        n = d.j.b3;
        if (t.s(n)) {
            this.s(t.a(n, false));
        }
        n = d.j.T2;
        if (t.s(n) && t.f(n, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        this.C(context, t);
        n = d.j.a3;
        if (t.s(n)) {
            final String o = t.o(n);
            if (o != null) {
                v.e.d(this.a, o);
            }
        }
        t.w();
        final Typeface l = this.l;
        if (l != null) {
            this.a.setTypeface(l, this.j);
        }
    }
    
    void r(final TextView textView, final InputConnection inputConnection, final EditorInfo editorInfo) {
        if (Build$VERSION.SDK_INT < 30 && inputConnection != null) {
            y.a.e(editorInfo, textView.getText());
        }
    }
    
    void s(final boolean allCaps) {
        this.a.setAllCaps(allCaps);
    }
    
    void t(final int n, final int n2, final int n3, final int n4) throws IllegalArgumentException {
        this.i.p(n, n2, n3, n4);
    }
    
    void u(final int[] array, final int n) throws IllegalArgumentException {
        this.i.q(array, n);
    }
    
    void v(final int n) {
        this.i.r(n);
    }
    
    void w(final ColorStateList a) {
        if (this.h == null) {
            this.h = new p0();
        }
        final p0 h = this.h;
        h.a = a;
        h.d = (a != null);
        this.z();
    }
    
    void x(final PorterDuff$Mode b) {
        if (this.h == null) {
            this.h = new p0();
        }
        final p0 h = this.h;
        h.b = b;
        h.c = (b != null);
        this.z();
    }
    
    static class c
    {
        static Drawable[] a(final TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
        
        static void b(final TextView textView, final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
        
        static void c(final TextView textView, final Locale textLocale) {
            textView.setTextLocale(textLocale);
        }
    }
    
    static class d
    {
        static LocaleList a(final String s) {
            return LocaleList.forLanguageTags(s);
        }
        
        static void b(final TextView textView, final LocaleList textLocales) {
            textView.setTextLocales(textLocales);
        }
    }
    
    static class e
    {
        static int a(final TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }
        
        static void b(final TextView textView, final int n, final int n2, final int n3, final int n4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
        
        static void c(final TextView textView, final int[] array, final int n) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(array, n);
        }
        
        static boolean d(final TextView textView, final String fontVariationSettings) {
            return textView.setFontVariationSettings(fontVariationSettings);
        }
    }
    
    static class f
    {
        static Typeface a(final Typeface typeface, final int n, final boolean b) {
            return Typeface.create(typeface, n, b);
        }
    }
}
