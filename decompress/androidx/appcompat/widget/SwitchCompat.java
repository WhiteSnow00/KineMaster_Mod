// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import java.lang.ref.WeakReference;
import java.lang.ref.Reference;
import android.text.InputFilter;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Region$Op;
import androidx.core.widget.n;
import android.view.ActionMode$Callback;
import android.text.TextUtils;
import android.graphics.Canvas;
import androidx.emoji2.text.e;
import android.graphics.Typeface;
import d.h;
import android.os.Build$VERSION;
import android.text.StaticLayout;
import android.text.Layout$Alignment;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import android.graphics.drawable.Drawable$Callback;
import androidx.core.view.b0;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.PorterDuff$Mode;
import android.animation.ObjectAnimator;
import android.text.method.TransformationMethod;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.view.VelocityTracker;
import android.util.Property;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton
{
    private static final Property<SwitchCompat, Float> g0;
    private static final int[] h0;
    private CharSequence A;
    private CharSequence B;
    private CharSequence C;
    private boolean D;
    private int E;
    private int F;
    private float G;
    private float H;
    private VelocityTracker I;
    private int J;
    float K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private final TextPaint T;
    private ColorStateList U;
    private Layout V;
    private Layout W;
    private Drawable a;
    private TransformationMethod a0;
    private ColorStateList b;
    ObjectAnimator b0;
    private PorterDuff$Mode c;
    private final v c0;
    private boolean d;
    private j d0;
    private boolean e;
    private c e0;
    private Drawable f;
    private final Rect f0;
    private ColorStateList g;
    private PorterDuff$Mode h;
    private boolean i;
    private boolean j;
    private int p;
    private int w;
    private int x;
    private boolean y;
    private CharSequence z;
    
    static {
        g0 = new Property<SwitchCompat, Float>("thumbPos") {
            public Float a(final SwitchCompat switchCompat) {
                return switchCompat.K;
            }
            
            public void b(final SwitchCompat switchCompat, final Float n) {
                switchCompat.setThumbPosition(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((SwitchCompat)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((SwitchCompat)o, (Float)o2);
            }
        };
        h0 = new int[] { 16842912 };
    }
    
    public SwitchCompat(final Context context, final AttributeSet set) {
        this(context, set, d.a.M);
    }
    
    public SwitchCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.I = VelocityTracker.obtain();
        this.S = true;
        this.f0 = new Rect();
        m0.a((View)this, this.getContext());
        final TextPaint t = new TextPaint(1);
        this.T = t;
        t.density = this.getResources().getDisplayMetrics().density;
        final int[] d2 = d.j.D2;
        final r0 v = r0.v(context, set, d2, n, 0);
        androidx.core.view.b0.n0((View)this, context, d2, set, v.r(), n, 0);
        final Drawable g = v.g(d.j.G2);
        this.a = g;
        if (g != null) {
            g.setCallback((Drawable$Callback)this);
        }
        final Drawable g2 = v.g(d.j.P2);
        if ((this.f = g2) != null) {
            g2.setCallback((Drawable$Callback)this);
        }
        this.setTextOnInternal(v.p(d.j.E2));
        this.setTextOffInternal(v.p(d.j.F2));
        this.D = v.a(d.j.H2, true);
        this.p = v.f(d.j.M2, 0);
        this.w = v.f(d.j.J2, 0);
        this.x = v.f(d.j.K2, 0);
        this.y = v.a(d.j.I2, false);
        final ColorStateList c = v.c(d.j.N2);
        if (c != null) {
            this.b = c;
            this.d = true;
        }
        final PorterDuff$Mode e = androidx.appcompat.widget.a0.e(v.k(d.j.O2, -1), null);
        if (this.c != e) {
            this.c = e;
            this.e = true;
        }
        if (this.d || this.e) {
            this.b();
        }
        final ColorStateList c2 = v.c(d.j.Q2);
        if (c2 != null) {
            this.g = c2;
            this.i = true;
        }
        final PorterDuff$Mode e2 = androidx.appcompat.widget.a0.e(v.k(d.j.R2, -1), null);
        if (this.h != e2) {
            this.h = e2;
            this.j = true;
        }
        if (this.i || this.j) {
            this.c();
        }
        final int n2 = v.n(d.j.L2, 0);
        if (n2 != 0) {
            this.m(context, n2);
        }
        (this.c0 = new v((TextView)this)).m(set, n);
        v.w();
        final ViewConfiguration value = ViewConfiguration.get(context);
        this.F = value.getScaledTouchSlop();
        this.J = value.getScaledMinimumFlingVelocity();
        this.getEmojiTextViewHelper().c(set, n);
        this.refreshDrawableState();
        this.setChecked(this.isChecked());
    }
    
    private void a(final boolean b) {
        float n;
        if (b) {
            n = 1.0f;
        }
        else {
            n = 0.0f;
        }
        (this.b0 = ObjectAnimator.ofFloat((Object)this, (Property)SwitchCompat.g0, new float[] { n })).setDuration(250L);
        SwitchCompat.b.a(this.b0, true);
        this.b0.start();
    }
    
    private void b() {
        final Drawable a = this.a;
        if (a != null && (this.d || this.e)) {
            final Drawable mutate = androidx.core.graphics.drawable.a.l(a).mutate();
            this.a = mutate;
            if (this.d) {
                androidx.core.graphics.drawable.a.i(mutate, this.b);
            }
            if (this.e) {
                androidx.core.graphics.drawable.a.j(this.a, this.c);
            }
            if (this.a.isStateful()) {
                this.a.setState(this.getDrawableState());
            }
        }
    }
    
    private void c() {
        final Drawable f = this.f;
        if (f != null && (this.i || this.j)) {
            final Drawable mutate = androidx.core.graphics.drawable.a.l(f).mutate();
            this.f = mutate;
            if (this.i) {
                androidx.core.graphics.drawable.a.i(mutate, this.g);
            }
            if (this.j) {
                androidx.core.graphics.drawable.a.j(this.f, this.h);
            }
            if (this.f.isStateful()) {
                this.f.setState(this.getDrawableState());
            }
        }
    }
    
    private void d() {
        final ObjectAnimator b0 = this.b0;
        if (b0 != null) {
            b0.cancel();
        }
    }
    
    private void e(MotionEvent obtain) {
        obtain = MotionEvent.obtain(obtain);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }
    
    private static float f(final float n, float n2, final float n3) {
        if (n >= n2) {
            n2 = n;
            if (n > n3) {
                n2 = n3;
            }
        }
        return n2;
    }
    
    private CharSequence g(final CharSequence charSequence) {
        final TransformationMethod f = this.getEmojiTextViewHelper().f(this.a0);
        CharSequence transformation = charSequence;
        if (f != null) {
            transformation = f.getTransformation(charSequence, (View)this);
        }
        return transformation;
    }
    
    private j getEmojiTextViewHelper() {
        if (this.d0 == null) {
            this.d0 = new j((TextView)this);
        }
        return this.d0;
    }
    
    private boolean getTargetCheckedState() {
        return this.K > 0.5f;
    }
    
    private int getThumbOffset() {
        float k;
        if (w0.b((View)this)) {
            k = 1.0f - this.K;
        }
        else {
            k = this.K;
        }
        return (int)(k * this.getThumbScrollRange() + 0.5f);
    }
    
    private int getThumbScrollRange() {
        final Drawable f = this.f;
        if (f != null) {
            final Rect f2 = this.f0;
            f.getPadding(f2);
            final Drawable a = this.a;
            Rect rect;
            if (a != null) {
                rect = androidx.appcompat.widget.a0.d(a);
            }
            else {
                rect = androidx.appcompat.widget.a0.c;
            }
            return this.L - this.N - f2.left - f2.right - rect.left - rect.right;
        }
        return 0;
    }
    
    private boolean h(final float n, final float n2) {
        final Drawable a = this.a;
        final boolean b = false;
        if (a == null) {
            return false;
        }
        final int thumbOffset = this.getThumbOffset();
        this.a.getPadding(this.f0);
        final int p2 = this.P;
        final int f = this.F;
        final int n3 = this.O + thumbOffset - f;
        final int n4 = this.N;
        final Rect f2 = this.f0;
        final int left = f2.left;
        final int right = f2.right;
        final int r = this.R;
        boolean b2 = b;
        if (n > n3) {
            b2 = b;
            if (n < n4 + n3 + left + right + f) {
                b2 = b;
                if (n2 > p2 - f) {
                    b2 = b;
                    if (n2 < r + f) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    private Layout i(final CharSequence charSequence) {
        final TextPaint t = this.T;
        int n;
        if (charSequence != null) {
            n = (int)Math.ceil(Layout.getDesiredWidth(charSequence, t));
        }
        else {
            n = 0;
        }
        return (Layout)new StaticLayout(charSequence, t, n, Layout$Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }
    
    private void k() {
        if (Build$VERSION.SDK_INT >= 30) {
            CharSequence charSequence;
            if ((charSequence = this.B) == null) {
                charSequence = this.getResources().getString(d.h.b);
            }
            androidx.core.view.b0.I0((View)this, charSequence);
        }
    }
    
    private void l() {
        if (Build$VERSION.SDK_INT >= 30) {
            CharSequence charSequence;
            if ((charSequence = this.z) == null) {
                charSequence = this.getResources().getString(d.h.c);
            }
            androidx.core.view.b0.I0((View)this, charSequence);
        }
    }
    
    private void o(final int n, final int n2) {
        Typeface typeface;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    typeface = null;
                }
                else {
                    typeface = Typeface.MONOSPACE;
                }
            }
            else {
                typeface = Typeface.SERIF;
            }
        }
        else {
            typeface = Typeface.SANS_SERIF;
        }
        this.n(typeface, n2);
    }
    
    private void p() {
        if (this.e0 == null) {
            if (this.d0.b()) {
                if (androidx.emoji2.text.e.h()) {
                    final e b = androidx.emoji2.text.e.b();
                    final int d = b.d();
                    if (d == 3 || d == 0) {
                        b.s((e.e)(this.e0 = new c(this)));
                    }
                }
            }
        }
    }
    
    private void q(final MotionEvent motionEvent) {
        this.E = 0;
        final int action = motionEvent.getAction();
        boolean targetCheckedState = true;
        final boolean b = action == 1 && this.isEnabled();
        final boolean checked = this.isChecked();
        Label_0117: {
            if (b) {
                this.I.computeCurrentVelocity(1000);
                final float xVelocity = this.I.getXVelocity();
                if (Math.abs(xVelocity) > this.J) {
                    if (w0.b((View)this)) {
                        if (xVelocity < 0.0f) {
                            break Label_0117;
                        }
                    }
                    else if (xVelocity > 0.0f) {
                        break Label_0117;
                    }
                    targetCheckedState = false;
                }
                else {
                    targetCheckedState = this.getTargetCheckedState();
                }
            }
            else {
                targetCheckedState = checked;
            }
        }
        if (targetCheckedState != checked) {
            this.playSoundEffect(0);
        }
        this.setChecked(targetCheckedState);
        this.e(motionEvent);
    }
    
    private void setTextOffInternal(final CharSequence b) {
        this.B = b;
        this.C = this.g(b);
        this.W = null;
        if (this.D) {
            this.p();
        }
    }
    
    private void setTextOnInternal(final CharSequence z) {
        this.z = z;
        this.A = this.g(z);
        this.V = null;
        if (this.D) {
            this.p();
        }
    }
    
    public void draw(final Canvas canvas) {
        final Rect f0 = this.f0;
        int o = this.O;
        final int p = this.P;
        int q = this.Q;
        final int r = this.R;
        final int n = this.getThumbOffset() + o;
        final Drawable a = this.a;
        Rect rect;
        if (a != null) {
            rect = androidx.appcompat.widget.a0.d(a);
        }
        else {
            rect = androidx.appcompat.widget.a0.c;
        }
        final Drawable f2 = this.f;
        int n2 = n;
        if (f2 != null) {
            f2.getPadding(f0);
            final int left = f0.left;
            final int n3 = n + left;
            int n4 = 0;
            int n5 = 0;
            int n9 = 0;
            Label_0260: {
                int n7;
                if (rect != null) {
                    final int left2 = rect.left;
                    n4 = o;
                    if (left2 > left) {
                        n4 = o + (left2 - left);
                    }
                    final int top = rect.top;
                    final int top2 = f0.top;
                    if (top > top2) {
                        n5 = top - top2 + p;
                    }
                    else {
                        n5 = p;
                    }
                    final int right = rect.right;
                    final int right2 = f0.right;
                    int n6 = q;
                    if (right > right2) {
                        n6 = q - (right - right2);
                    }
                    final int bottom = rect.bottom;
                    final int bottom2 = f0.bottom;
                    o = n4;
                    q = n6;
                    n7 = n5;
                    if (bottom > bottom2) {
                        final int n8 = r - (bottom - bottom2);
                        q = n6;
                        n9 = n8;
                        break Label_0260;
                    }
                }
                else {
                    n7 = p;
                }
                n9 = r;
                n5 = n7;
                n4 = o;
            }
            this.f.setBounds(n4, n5, q, n9);
            n2 = n3;
        }
        final Drawable a2 = this.a;
        if (a2 != null) {
            a2.getPadding(f0);
            final int n10 = n2 - f0.left;
            final int n11 = n2 + this.N + f0.right;
            this.a.setBounds(n10, p, n11, r);
            final Drawable background = this.getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.f(background, n10, p, n11, r);
            }
        }
        super.draw(canvas);
    }
    
    public void drawableHotspotChanged(final float n, final float n2) {
        super.drawableHotspotChanged(n, n2);
        final Drawable a = this.a;
        if (a != null) {
            androidx.core.graphics.drawable.a.e(a, n, n2);
        }
        final Drawable f = this.f;
        if (f != null) {
            androidx.core.graphics.drawable.a.e(f, n, n2);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final int[] drawableState = this.getDrawableState();
        final Drawable a = this.a;
        int n2;
        final int n = n2 = 0;
        if (a != null) {
            n2 = n;
            if (a.isStateful()) {
                n2 = ((false | a.setState(drawableState)) ? 1 : 0);
            }
        }
        final Drawable f = this.f;
        int n3 = n2;
        if (f != null) {
            n3 = n2;
            if (f.isStateful()) {
                n3 = (n2 | (f.setState(drawableState) ? 1 : 0));
            }
        }
        if (n3 != 0) {
            this.invalidate();
        }
    }
    
    public int getCompoundPaddingLeft() {
        if (!w0.b((View)this)) {
            return super.getCompoundPaddingLeft();
        }
        int n = super.getCompoundPaddingLeft() + this.L;
        if (!TextUtils.isEmpty(this.getText())) {
            n += this.x;
        }
        return n;
    }
    
    public int getCompoundPaddingRight() {
        if (w0.b((View)this)) {
            return super.getCompoundPaddingRight();
        }
        int n = super.getCompoundPaddingRight() + this.L;
        if (!TextUtils.isEmpty(this.getText())) {
            n += this.x;
        }
        return n;
    }
    
    public ActionMode$Callback getCustomSelectionActionModeCallback() {
        return n.s(super.getCustomSelectionActionModeCallback());
    }
    
    public boolean getShowText() {
        return this.D;
    }
    
    public boolean getSplitTrack() {
        return this.y;
    }
    
    public int getSwitchMinWidth() {
        return this.w;
    }
    
    public int getSwitchPadding() {
        return this.x;
    }
    
    public CharSequence getTextOff() {
        return this.B;
    }
    
    public CharSequence getTextOn() {
        return this.z;
    }
    
    public Drawable getThumbDrawable() {
        return this.a;
    }
    
    protected final float getThumbPosition() {
        return this.K;
    }
    
    public int getThumbTextPadding() {
        return this.p;
    }
    
    public ColorStateList getThumbTintList() {
        return this.b;
    }
    
    public PorterDuff$Mode getThumbTintMode() {
        return this.c;
    }
    
    public Drawable getTrackDrawable() {
        return this.f;
    }
    
    public ColorStateList getTrackTintList() {
        return this.g;
    }
    
    public PorterDuff$Mode getTrackTintMode() {
        return this.h;
    }
    
    void j() {
        this.setTextOnInternal(this.z);
        this.setTextOffInternal(this.B);
        this.requestLayout();
    }
    
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final Drawable a = this.a;
        if (a != null) {
            a.jumpToCurrentState();
        }
        final Drawable f = this.f;
        if (f != null) {
            f.jumpToCurrentState();
        }
        final ObjectAnimator b0 = this.b0;
        if (b0 != null && b0.isStarted()) {
            this.b0.end();
            this.b0 = null;
        }
    }
    
    public void m(final Context context, int f) {
        final r0 t = r0.t(context, f, d.j.S2);
        final ColorStateList c = t.c(d.j.W2);
        if (c != null) {
            this.U = c;
        }
        else {
            this.U = this.getTextColors();
        }
        f = t.f(d.j.T2, 0);
        if (f != 0) {
            final float textSize = (float)f;
            if (textSize != this.T.getTextSize()) {
                this.T.setTextSize(textSize);
                this.requestLayout();
            }
        }
        this.o(t.k(d.j.U2, -1), t.k(d.j.V2, -1));
        if (t.a(d.j.b3, false)) {
            this.a0 = (TransformationMethod)new h.a(this.getContext());
        }
        else {
            this.a0 = null;
        }
        this.setTextOnInternal(this.z);
        this.setTextOffInternal(this.B);
        t.w();
    }
    
    public void n(Typeface typeface, int n) {
        float textSkewX = 0.0f;
        boolean fakeBoldText = false;
        if (n > 0) {
            if (typeface == null) {
                typeface = Typeface.defaultFromStyle(n);
            }
            else {
                typeface = Typeface.create(typeface, n);
            }
            this.setSwitchTypeface(typeface);
            int style;
            if (typeface != null) {
                style = typeface.getStyle();
            }
            else {
                style = 0;
            }
            n &= ~style;
            final TextPaint t = this.T;
            if ((n & 0x1) != 0x0) {
                fakeBoldText = true;
            }
            t.setFakeBoldText(fakeBoldText);
            final TextPaint t2 = this.T;
            if ((n & 0x2) != 0x0) {
                textSkewX = -0.25f;
            }
            t2.setTextSkewX(textSkewX);
        }
        else {
            this.T.setFakeBoldText(false);
            this.T.setTextSkewX(0.0f);
            this.setSwitchTypeface(typeface);
        }
    }
    
    protected int[] onCreateDrawableState(final int n) {
        final int[] onCreateDrawableState = super.onCreateDrawableState(n + 1);
        if (this.isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, SwitchCompat.h0);
        }
        return onCreateDrawableState;
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        final Rect f0 = this.f0;
        final Drawable f2 = this.f;
        if (f2 != null) {
            f2.getPadding(f0);
        }
        else {
            f0.setEmpty();
        }
        final int p = this.P;
        final int r = this.R;
        final int top = f0.top;
        final int bottom = f0.bottom;
        final Drawable a = this.a;
        if (f2 != null) {
            if (this.y && a != null) {
                final Rect d = androidx.appcompat.widget.a0.d(a);
                a.copyBounds(f0);
                f0.left += d.left;
                f0.right -= d.right;
                final int save = canvas.save();
                canvas.clipRect(f0, Region$Op.DIFFERENCE);
                f2.draw(canvas);
                canvas.restoreToCount(save);
            }
            else {
                f2.draw(canvas);
            }
        }
        final int save2 = canvas.save();
        if (a != null) {
            a.draw(canvas);
        }
        Layout layout;
        if (this.getTargetCheckedState()) {
            layout = this.V;
        }
        else {
            layout = this.W;
        }
        if (layout != null) {
            final int[] drawableState = this.getDrawableState();
            final ColorStateList u = this.U;
            if (u != null) {
                this.T.setColor(u.getColorForState(drawableState, 0));
            }
            this.T.drawableState = drawableState;
            int width;
            if (a != null) {
                final Rect bounds = a.getBounds();
                width = bounds.left + bounds.right;
            }
            else {
                width = this.getWidth();
            }
            canvas.translate((float)(width / 2 - layout.getWidth() / 2), (float)((p + top + (r - bottom)) / 2 - layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)"android.widget.Switch");
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)"android.widget.Switch");
        if (Build$VERSION.SDK_INT < 30) {
            CharSequence text;
            if (this.isChecked()) {
                text = this.z;
            }
            else {
                text = this.B;
            }
            if (!TextUtils.isEmpty(text)) {
                final CharSequence text2 = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text2)) {
                    accessibilityNodeInfo.setText(text);
                }
                else {
                    final StringBuilder text3 = new StringBuilder();
                    text3.append(text2);
                    text3.append(' ');
                    text3.append(text);
                    accessibilityNodeInfo.setText((CharSequence)text3);
                }
            }
        }
    }
    
    protected void onLayout(final boolean b, int p5, int max, int q, int r) {
        super.onLayout(b, p5, max, q, r);
        final Drawable a = this.a;
        max = 0;
        if (a != null) {
            final Rect f0 = this.f0;
            final Drawable f2 = this.f;
            if (f2 != null) {
                f2.getPadding(f0);
            }
            else {
                f0.setEmpty();
            }
            final Rect d = androidx.appcompat.widget.a0.d(this.a);
            p5 = Math.max(0, d.left - f0.left);
            max = Math.max(0, d.right - f0.right);
        }
        else {
            p5 = 0;
        }
        if (w0.b((View)this)) {
            q = this.getPaddingLeft() + p5;
            p5 = this.L + q - p5 - max;
            max = q;
            q = p5;
        }
        else {
            q = this.getWidth() - this.getPaddingRight() - max;
            max += q - this.L + p5;
        }
        p5 = (this.getGravity() & 0x70);
        Label_0256: {
            if (p5 != 16) {
                if (p5 == 80) {
                    r = this.getHeight() - this.getPaddingBottom();
                    p5 = r - this.M;
                    break Label_0256;
                }
                p5 = this.getPaddingTop();
                r = this.M;
            }
            else {
                p5 = (this.getPaddingTop() + this.getHeight() - this.getPaddingBottom()) / 2;
                r = this.M;
                p5 -= r / 2;
            }
            r += p5;
        }
        this.O = max;
        this.P = p5;
        this.R = r;
        this.Q = q;
    }
    
    public void onMeasure(final int n, final int n2) {
        if (this.D) {
            if (this.V == null) {
                this.V = this.i(this.A);
            }
            if (this.W == null) {
                this.W = this.i(this.C);
            }
        }
        final Rect f0 = this.f0;
        final Drawable a = this.a;
        final int n3 = 0;
        int n4;
        int intrinsicHeight;
        if (a != null) {
            a.getPadding(f0);
            n4 = this.a.getIntrinsicWidth() - f0.left - f0.right;
            intrinsicHeight = this.a.getIntrinsicHeight();
        }
        else {
            n4 = 0;
            intrinsicHeight = 0;
        }
        int n5;
        if (this.D) {
            n5 = Math.max(this.V.getWidth(), this.W.getWidth()) + this.p * 2;
        }
        else {
            n5 = 0;
        }
        this.N = Math.max(n5, n4);
        final Drawable f2 = this.f;
        int intrinsicHeight2;
        if (f2 != null) {
            f2.getPadding(f0);
            intrinsicHeight2 = this.f.getIntrinsicHeight();
        }
        else {
            f0.setEmpty();
            intrinsicHeight2 = n3;
        }
        final int left = f0.left;
        final int right = f0.right;
        final Drawable a2 = this.a;
        int max = right;
        int max2 = left;
        if (a2 != null) {
            final Rect d = androidx.appcompat.widget.a0.d(a2);
            max2 = Math.max(left, d.left);
            max = Math.max(right, d.right);
        }
        int l;
        if (this.S) {
            l = Math.max(this.w, this.N * 2 + max2 + max);
        }
        else {
            l = this.w;
        }
        final int max3 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.L = l;
        this.M = max3;
        super.onMeasure(n, n2);
        if (this.getMeasuredHeight() < max3) {
            this.setMeasuredDimension(this.getMeasuredWidthAndState(), max3);
        }
    }
    
    public void onPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence;
        if (this.isChecked()) {
            charSequence = this.z;
        }
        else {
            charSequence = this.B;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.I.addMovement(motionEvent);
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return super.onTouchEvent(motionEvent);
                    }
                }
                else {
                    final int e = this.E;
                    if (e != 1) {
                        if (e != 2) {
                            return super.onTouchEvent(motionEvent);
                        }
                        final float x = motionEvent.getX();
                        final int thumbScrollRange = this.getThumbScrollRange();
                        final float n = x - this.G;
                        float n2;
                        if (thumbScrollRange != 0) {
                            n2 = n / thumbScrollRange;
                        }
                        else if (n > 0.0f) {
                            n2 = 1.0f;
                        }
                        else {
                            n2 = -1.0f;
                        }
                        float n3 = n2;
                        if (w0.b((View)this)) {
                            n3 = -n2;
                        }
                        final float f = f(this.K + n3, 0.0f, 1.0f);
                        if (f != this.K) {
                            this.G = x;
                            this.setThumbPosition(f);
                        }
                        return true;
                    }
                    else {
                        final float x2 = motionEvent.getX();
                        final float y = motionEvent.getY();
                        if (Math.abs(x2 - this.G) > this.F || Math.abs(y - this.H) > this.F) {
                            this.E = 2;
                            this.getParent().requestDisallowInterceptTouchEvent(true);
                            this.G = x2;
                            this.H = y;
                            return true;
                        }
                        return super.onTouchEvent(motionEvent);
                    }
                }
            }
            if (this.E == 2) {
                this.q(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.E = 0;
            this.I.clear();
        }
        else {
            final float x3 = motionEvent.getX();
            final float y2 = motionEvent.getY();
            if (this.isEnabled() && this.h(x3, y2)) {
                this.E = 1;
                this.G = x3;
                this.H = y2;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
    
    public void setAllCaps(final boolean allCaps) {
        super.setAllCaps(allCaps);
        this.getEmojiTextViewHelper().d(allCaps);
    }
    
    public void setChecked(final boolean checked) {
        super.setChecked(checked);
        final boolean checked2 = this.isChecked();
        if (checked2) {
            this.l();
        }
        else {
            this.k();
        }
        if (this.getWindowToken() != null && androidx.core.view.b0.T((View)this)) {
            this.a(checked2);
        }
        else {
            this.d();
            float thumbPosition;
            if (checked2) {
                thumbPosition = 1.0f;
            }
            else {
                thumbPosition = 0.0f;
            }
            this.setThumbPosition(thumbPosition);
        }
    }
    
    public void setCustomSelectionActionModeCallback(final ActionMode$Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(n.t((TextView)this, actionMode$Callback));
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.getEmojiTextViewHelper().e(b);
        this.setTextOnInternal(this.z);
        this.setTextOffInternal(this.B);
        this.requestLayout();
    }
    
    protected final void setEnforceSwitchWidth(final boolean s) {
        this.S = s;
        this.invalidate();
    }
    
    public void setFilters(final InputFilter[] array) {
        super.setFilters(this.getEmojiTextViewHelper().a(array));
    }
    
    public void setShowText(final boolean d) {
        if (this.D != d) {
            this.D = d;
            this.requestLayout();
            if (d) {
                this.p();
            }
        }
    }
    
    public void setSplitTrack(final boolean y) {
        this.y = y;
        this.invalidate();
    }
    
    public void setSwitchMinWidth(final int w) {
        this.w = w;
        this.requestLayout();
    }
    
    public void setSwitchPadding(final int x) {
        this.x = x;
        this.requestLayout();
    }
    
    public void setSwitchTypeface(final Typeface typeface) {
        if ((this.T.getTypeface() != null && !this.T.getTypeface().equals((Object)typeface)) || (this.T.getTypeface() == null && typeface != null)) {
            this.T.setTypeface(typeface);
            this.requestLayout();
            this.invalidate();
        }
    }
    
    public void setTextOff(final CharSequence textOffInternal) {
        this.setTextOffInternal(textOffInternal);
        this.requestLayout();
        if (!this.isChecked()) {
            this.k();
        }
    }
    
    public void setTextOn(final CharSequence textOnInternal) {
        this.setTextOnInternal(textOnInternal);
        this.requestLayout();
        if (this.isChecked()) {
            this.l();
        }
    }
    
    public void setThumbDrawable(final Drawable a) {
        final Drawable a2 = this.a;
        if (a2 != null) {
            a2.setCallback((Drawable$Callback)null);
        }
        if ((this.a = a) != null) {
            a.setCallback((Drawable$Callback)this);
        }
        this.requestLayout();
    }
    
    void setThumbPosition(final float k) {
        this.K = k;
        this.invalidate();
    }
    
    public void setThumbResource(final int n) {
        this.setThumbDrawable(e.a.b(this.getContext(), n));
    }
    
    public void setThumbTextPadding(final int p) {
        this.p = p;
        this.requestLayout();
    }
    
    public void setThumbTintList(final ColorStateList b) {
        this.b = b;
        this.d = true;
        this.b();
    }
    
    public void setThumbTintMode(final PorterDuff$Mode c) {
        this.c = c;
        this.e = true;
        this.b();
    }
    
    public void setTrackDrawable(final Drawable f) {
        final Drawable f2 = this.f;
        if (f2 != null) {
            f2.setCallback((Drawable$Callback)null);
        }
        if ((this.f = f) != null) {
            f.setCallback((Drawable$Callback)this);
        }
        this.requestLayout();
    }
    
    public void setTrackResource(final int n) {
        this.setTrackDrawable(e.a.b(this.getContext(), n));
    }
    
    public void setTrackTintList(final ColorStateList g) {
        this.g = g;
        this.i = true;
        this.c();
    }
    
    public void setTrackTintMode(final PorterDuff$Mode h) {
        this.h = h;
        this.j = true;
        this.c();
    }
    
    public void toggle() {
        this.setChecked(this.isChecked() ^ true);
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.a || drawable == this.f;
    }
    
    static class b
    {
        static void a(final ObjectAnimator objectAnimator, final boolean autoCancel) {
            objectAnimator.setAutoCancel(autoCancel);
        }
    }
    
    static class c extends e
    {
        private final Reference<SwitchCompat> a;
        
        c(final SwitchCompat switchCompat) {
            this.a = new WeakReference<SwitchCompat>(switchCompat);
        }
        
        @Override
        public void a(final Throwable t) {
            final SwitchCompat switchCompat = this.a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
        
        @Override
        public void b() {
            final SwitchCompat switchCompat = this.a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }
}
