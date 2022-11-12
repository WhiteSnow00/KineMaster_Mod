// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.widget.LinearLayout$LayoutParams;
import androidx.core.view.f;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.View$MeasureSpec;
import android.view.View;
import androidx.core.view.b0;
import d.j;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class LinearLayoutCompat extends ViewGroup
{
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable p;
    private int w;
    private int x;
    private int y;
    private int z;
    
    public LinearLayoutCompat(final Context context) {
        this(context, null);
    }
    
    public LinearLayoutCompat(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public LinearLayoutCompat(final Context context, final AttributeSet set, int n) {
        super(context, set, n);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        final int[] a1 = d.j.a1;
        final r0 v = r0.v(context, set, a1, n, 0);
        b0.n0((View)this, context, a1, set, v.r(), n, 0);
        n = v.k(d.j.c1, -1);
        if (n >= 0) {
            this.setOrientation(n);
        }
        n = v.k(d.j.b1, -1);
        if (n >= 0) {
            this.setGravity(n);
        }
        final boolean a2 = v.a(d.j.d1, true);
        if (!a2) {
            this.setBaselineAligned(a2);
        }
        this.g = v.i(d.j.f1, -1.0f);
        this.b = v.k(d.j.e1, -1);
        this.h = v.a(d.j.i1, false);
        this.setDividerDrawable(v.g(d.j.g1));
        this.y = v.k(d.j.j1, 0);
        this.z = v.f(d.j.h1, 0);
        v.w();
    }
    
    private void A(final View view, final int n, final int n2, final int n3, final int n4) {
        view.layout(n, n2, n3 + n, n4 + n2);
    }
    
    private void k(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View s = this.s(i);
            if (s.getVisibility() != 8) {
                final a a = (a)s.getLayoutParams();
                if (a.height == -1) {
                    final int width = a.width;
                    a.width = s.getMeasuredWidth();
                    this.measureChildWithMargins(s, n2, 0, measureSpec, 0);
                    a.width = width;
                }
            }
        }
    }
    
    private void l(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View s = this.s(i);
            if (s.getVisibility() != 8) {
                final a a = (a)s.getLayoutParams();
                if (a.width == -1) {
                    final int height = a.height;
                    a.height = s.getMeasuredHeight();
                    this.measureChildWithMargins(s, measureSpec, 0, n2, 0);
                    a.height = height;
                }
            }
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof a;
    }
    
    void g(final Canvas canvas) {
        final int virtualChildCount = this.getVirtualChildCount();
        final boolean b = w0.b((View)this);
        for (int i = 0; i < virtualChildCount; ++i) {
            final View s = this.s(i);
            if (s != null && s.getVisibility() != 8 && this.t(i)) {
                final a a = (a)s.getLayoutParams();
                int n;
                if (b) {
                    n = s.getRight() + a.rightMargin;
                }
                else {
                    n = s.getLeft() - a.leftMargin - this.w;
                }
                this.j(canvas, n);
            }
        }
        if (this.t(virtualChildCount)) {
            final View s2 = this.s(virtualChildCount - 1);
            int paddingLeft = 0;
            Label_0215: {
                int n2;
                int n3;
                if (s2 == null) {
                    if (b) {
                        paddingLeft = this.getPaddingLeft();
                        break Label_0215;
                    }
                    n2 = this.getWidth() - this.getPaddingRight();
                    n3 = this.w;
                }
                else {
                    final a a2 = (a)s2.getLayoutParams();
                    if (!b) {
                        paddingLeft = s2.getRight() + a2.rightMargin;
                        break Label_0215;
                    }
                    n2 = s2.getLeft() - a2.leftMargin;
                    n3 = this.w;
                }
                paddingLeft = n2 - n3;
            }
            this.j(canvas, paddingLeft);
        }
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.m();
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.n(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.o(viewGroup$LayoutParams);
    }
    
    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        final int childCount = this.getChildCount();
        final int b = this.b;
        if (childCount <= b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        final View child = this.getChildAt(b);
        final int baseline = child.getBaseline();
        if (baseline != -1) {
            int c;
            final int n = c = this.c;
            if (this.d == 1) {
                final int n2 = this.e & 0x70;
                c = n;
                if (n2 != 48) {
                    if (n2 != 16) {
                        if (n2 != 80) {
                            c = n;
                        }
                        else {
                            c = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.f;
                        }
                    }
                    else {
                        c = n + (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.f) / 2;
                    }
                }
            }
            return c + ((a)child.getLayoutParams()).topMargin + baseline;
        }
        if (this.b == 0) {
            return -1;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    }
    
    public int getBaselineAlignedChildIndex() {
        return this.b;
    }
    
    public Drawable getDividerDrawable() {
        return this.p;
    }
    
    public int getDividerPadding() {
        return this.z;
    }
    
    public int getDividerWidth() {
        return this.w;
    }
    
    public int getGravity() {
        return this.e;
    }
    
    public int getOrientation() {
        return this.d;
    }
    
    public int getShowDividers() {
        return this.y;
    }
    
    int getVirtualChildCount() {
        return this.getChildCount();
    }
    
    public float getWeightSum() {
        return this.g;
    }
    
    void h(final Canvas canvas) {
        final int virtualChildCount = this.getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; ++i) {
            final View s = this.s(i);
            if (s != null && s.getVisibility() != 8 && this.t(i)) {
                this.i(canvas, s.getTop() - ((a)s.getLayoutParams()).topMargin - this.x);
            }
        }
        if (this.t(virtualChildCount)) {
            final View s2 = this.s(virtualChildCount - 1);
            int n;
            if (s2 == null) {
                n = this.getHeight() - this.getPaddingBottom() - this.x;
            }
            else {
                n = s2.getBottom() + ((a)s2.getLayoutParams()).bottomMargin;
            }
            this.i(canvas, n);
        }
    }
    
    void i(final Canvas canvas, final int n) {
        this.p.setBounds(this.getPaddingLeft() + this.z, n, this.getWidth() - this.getPaddingRight() - this.z, this.x + n);
        this.p.draw(canvas);
    }
    
    void j(final Canvas canvas, final int n) {
        this.p.setBounds(n, this.getPaddingTop() + this.z, this.w + n, this.getHeight() - this.getPaddingBottom() - this.z);
        this.p.draw(canvas);
    }
    
    protected a m() {
        final int d = this.d;
        if (d == 0) {
            return new a(-2, -2);
        }
        if (d == 1) {
            return new a(-1, -2);
        }
        return null;
    }
    
    public a n(final AttributeSet set) {
        return new a(this.getContext(), set);
    }
    
    protected a o(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return new a(viewGroup$LayoutParams);
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.p == null) {
            return;
        }
        if (this.d == 1) {
            this.h(canvas);
        }
        else {
            this.g(canvas);
        }
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)"androidx.appcompat.widget.LinearLayoutCompat");
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)"androidx.appcompat.widget.LinearLayoutCompat");
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (this.d == 1) {
            this.v(n, n2, n3, n4);
        }
        else {
            this.u(n, n2, n3, n4);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (this.d == 1) {
            this.z(n, n2);
        }
        else {
            this.x(n, n2);
        }
    }
    
    int p(final View view, final int n) {
        return 0;
    }
    
    int q(final View view) {
        return 0;
    }
    
    int r(final View view) {
        return 0;
    }
    
    View s(final int n) {
        return this.getChildAt(n);
    }
    
    public void setBaselineAligned(final boolean a) {
        this.a = a;
    }
    
    public void setBaselineAlignedChildIndex(final int b) {
        if (b >= 0 && b < this.getChildCount()) {
            this.b = b;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("base aligned child index out of range (0, ");
        sb.append(this.getChildCount());
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void setDividerDrawable(final Drawable p) {
        if (p == this.p) {
            return;
        }
        this.p = p;
        boolean willNotDraw = false;
        if (p != null) {
            this.w = p.getIntrinsicWidth();
            this.x = p.getIntrinsicHeight();
        }
        else {
            this.w = 0;
            this.x = 0;
        }
        if (p == null) {
            willNotDraw = true;
        }
        this.setWillNotDraw(willNotDraw);
        this.requestLayout();
    }
    
    public void setDividerPadding(final int z) {
        this.z = z;
    }
    
    public void setGravity(int e) {
        if (this.e != e) {
            int n = e;
            if ((0x800007 & e) == 0x0) {
                n = (e | 0x800003);
            }
            e = n;
            if ((n & 0x70) == 0x0) {
                e = (n | 0x30);
            }
            this.e = e;
            this.requestLayout();
        }
    }
    
    public void setHorizontalGravity(int n) {
        n &= 0x800007;
        final int e = this.e;
        if ((0x800007 & e) != n) {
            this.e = (n | (0xFF7FFFF8 & e));
            this.requestLayout();
        }
    }
    
    public void setMeasureWithLargestChildEnabled(final boolean h) {
        this.h = h;
    }
    
    public void setOrientation(final int d) {
        if (this.d != d) {
            this.d = d;
            this.requestLayout();
        }
    }
    
    public void setShowDividers(final int y) {
        if (y != this.y) {
            this.requestLayout();
        }
        this.y = y;
    }
    
    public void setVerticalGravity(int n) {
        n &= 0x70;
        final int e = this.e;
        if ((e & 0x70) != n) {
            this.e = (n | (e & 0xFFFFFF8F));
            this.requestLayout();
        }
    }
    
    public void setWeightSum(final float n) {
        this.g = Math.max(0.0f, n);
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    protected boolean t(int n) {
        final boolean b = false;
        final boolean b2 = false;
        boolean b3 = false;
        if (n == 0) {
            if ((this.y & 0x1) != 0x0) {
                b3 = true;
            }
            return b3;
        }
        if (n == this.getChildCount()) {
            boolean b4 = b;
            if ((this.y & 0x4) != 0x0) {
                b4 = true;
            }
            return b4;
        }
        boolean b5 = b2;
        if ((this.y & 0x2) != 0x0) {
            --n;
            while (true) {
                b5 = b2;
                if (n < 0) {
                    break;
                }
                if (this.getChildAt(n).getVisibility() != 8) {
                    b5 = true;
                    break;
                }
                --n;
            }
        }
        return b5;
    }
    
    void u(int n, int n2, int n3, int n4) {
        final boolean b = w0.b((View)this);
        final int paddingTop = this.getPaddingTop();
        final int n5 = n4 - n2;
        final int paddingBottom = this.getPaddingBottom();
        final int paddingBottom2 = this.getPaddingBottom();
        final int virtualChildCount = this.getVirtualChildCount();
        n2 = this.e;
        n4 = (n2 & 0x70);
        final boolean a = this.a;
        final int[] i = this.i;
        final int[] j = this.j;
        n2 = androidx.core.view.f.b(0x800007 & n2, b0.B((View)this));
        if (n2 != 1) {
            if (n2 != 5) {
                n2 = this.getPaddingLeft();
            }
            else {
                n2 = this.getPaddingLeft() + n3 - n - this.f;
            }
        }
        else {
            n2 = this.getPaddingLeft() + (n3 - n - this.f) / 2;
        }
        int n6;
        int n7;
        if (b) {
            n6 = virtualChildCount - 1;
            n7 = -1;
        }
        else {
            n6 = 0;
            n7 = 1;
        }
        int k = 0;
        n3 = n4;
        n4 = paddingTop;
        while (k < virtualChildCount) {
            final int n8 = n6 + n7 * k;
            final View s = this.s(n8);
            if (s == null) {
                n2 += this.y(n8);
            }
            else if (s.getVisibility() != 8) {
                final int measuredWidth = s.getMeasuredWidth();
                final int measuredHeight = s.getMeasuredHeight();
                final a a2 = (a)s.getLayoutParams();
                int baseline;
                if (a && a2.height != -1) {
                    baseline = s.getBaseline();
                }
                else {
                    baseline = -1;
                }
                if ((n = a2.gravity) < 0) {
                    n = n3;
                }
                n &= 0x70;
                if (n != 16) {
                    if (n != 48) {
                        if (n != 80) {
                            n = n4;
                        }
                        else {
                            final int n9 = n = n5 - paddingBottom - measuredHeight - a2.bottomMargin;
                            if (baseline != -1) {
                                n = s.getMeasuredHeight();
                                n = n9 - (j[2] - (n - baseline));
                            }
                        }
                    }
                    else {
                        final int n10 = n = a2.topMargin + n4;
                        if (baseline != -1) {
                            n = n10 + (i[1] - baseline);
                        }
                    }
                }
                else {
                    n = (n5 - paddingTop - paddingBottom2 - measuredHeight) / 2 + n4 + a2.topMargin - a2.bottomMargin;
                }
                int n11 = n2;
                if (this.t(n8)) {
                    n11 = n2 + this.w;
                }
                n2 = a2.leftMargin + n11;
                this.A(s, n2 + this.q(s), n, measuredWidth, measuredHeight);
                n = a2.rightMargin;
                final int r = this.r(s);
                k += this.p(s, n8);
                n2 += measuredWidth + n + r;
            }
            ++k;
        }
    }
    
    void v(int paddingTop, int i, int r, int n) {
        final int paddingLeft = this.getPaddingLeft();
        final int n2 = r - paddingTop;
        final int paddingRight = this.getPaddingRight();
        final int paddingRight2 = this.getPaddingRight();
        final int virtualChildCount = this.getVirtualChildCount();
        final int e = this.e;
        paddingTop = (e & 0x70);
        if (paddingTop != 16) {
            if (paddingTop != 80) {
                paddingTop = this.getPaddingTop();
            }
            else {
                paddingTop = this.getPaddingTop() + n - i - this.f;
            }
        }
        else {
            paddingTop = this.getPaddingTop() + (n - i - this.f) / 2;
        }
        View s;
        int measuredWidth;
        int measuredHeight;
        a a;
        for (i = 0; i < virtualChildCount; ++i) {
            s = this.s(i);
            if (s == null) {
                r = paddingTop + this.y(i);
            }
            else {
                r = paddingTop;
                if (s.getVisibility() != 8) {
                    measuredWidth = s.getMeasuredWidth();
                    measuredHeight = s.getMeasuredHeight();
                    a = (a)s.getLayoutParams();
                    n = a.gravity;
                    if ((r = n) < 0) {
                        r = (e & 0x800007);
                    }
                    r = (androidx.core.view.f.b(r, b0.B((View)this)) & 0x7);
                    Label_0273: {
                        if (r != 1) {
                            if (r != 5) {
                                r = a.leftMargin + paddingLeft;
                                break Label_0273;
                            }
                            r = n2 - paddingRight - measuredWidth;
                            n = a.rightMargin;
                        }
                        else {
                            r = (n2 - paddingLeft - paddingRight2 - measuredWidth) / 2 + paddingLeft + a.leftMargin;
                            n = a.rightMargin;
                        }
                        r -= n;
                    }
                    n = paddingTop;
                    if (this.t(i)) {
                        n = paddingTop + this.x;
                    }
                    paddingTop = n + a.topMargin;
                    this.A(s, r, paddingTop + this.q(s), measuredWidth, measuredHeight);
                    n = a.bottomMargin;
                    r = this.r(s);
                    i += this.p(s, i);
                    paddingTop += measuredHeight + n + r;
                    continue;
                }
            }
            paddingTop = r;
        }
    }
    
    void w(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }
    
    void x(final int n, final int n2) {
        this.f = 0;
        final int virtualChildCount = this.getVirtualChildCount();
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        final int[] i = this.i;
        final int[] j = this.j;
        i[2] = (i[3] = -1);
        i[0] = (i[1] = -1);
        j[2] = (j[3] = -1);
        j[0] = (j[1] = -1);
        final boolean a = this.a;
        final boolean h = this.h;
        int n3 = 1073741824;
        final boolean b = mode == 1073741824;
        int k = 0;
        int n4 = 0;
        int max2;
        int max = max2 = n4;
        int n6;
        int n5 = n6 = max2;
        int n8;
        int n7 = n8 = n6;
        int n9 = 1;
        float n10 = 0.0f;
        while (k < virtualChildCount) {
            final View s = this.s(k);
            int n16 = 0;
            int n17 = 0;
            Label_0862: {
                if (s == null) {
                    this.f += this.y(k);
                }
                else {
                    if (s.getVisibility() != 8) {
                        if (this.t(k)) {
                            this.f += this.w;
                        }
                        final a a2 = (a)s.getLayoutParams();
                        final float weight = a2.weight;
                        n10 += weight;
                        Label_0588: {
                            int max3;
                            if (mode == n3 && a2.width == 0 && weight > 0.0f) {
                                if (b) {
                                    this.f += a2.leftMargin + a2.rightMargin;
                                }
                                else {
                                    final int f = this.f;
                                    this.f = Math.max(f, a2.leftMargin + f + a2.rightMargin);
                                }
                                if (!a) {
                                    n6 = 1;
                                    break Label_0588;
                                }
                                final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
                                s.measure(measureSpec, measureSpec);
                                max3 = n4;
                            }
                            else {
                                int width;
                                if (a2.width == 0 && weight > 0.0f) {
                                    a2.width = -2;
                                    width = 0;
                                }
                                else {
                                    width = Integer.MIN_VALUE;
                                }
                                int f2;
                                if (n10 == 0.0f) {
                                    f2 = this.f;
                                }
                                else {
                                    f2 = 0;
                                }
                                this.w(s, k, n, f2, n2, 0);
                                if (width != Integer.MIN_VALUE) {
                                    a2.width = width;
                                }
                                final int measuredWidth = s.getMeasuredWidth();
                                if (b) {
                                    this.f += a2.leftMargin + measuredWidth + a2.rightMargin + this.r(s);
                                }
                                else {
                                    final int f3 = this.f;
                                    this.f = Math.max(f3, f3 + measuredWidth + a2.leftMargin + a2.rightMargin + this.r(s));
                                }
                                max3 = n4;
                                if (h) {
                                    max3 = Math.max(measuredWidth, n4);
                                }
                            }
                            n4 = max3;
                        }
                        final int n11 = 1073741824;
                        boolean b2;
                        if (mode2 != 1073741824 && a2.height == -1) {
                            b2 = true;
                            n8 = 1;
                        }
                        else {
                            b2 = false;
                        }
                        int n12 = a2.topMargin + a2.bottomMargin;
                        int n13 = s.getMeasuredHeight() + n12;
                        final int combineMeasuredStates = View.combineMeasuredStates(n7, s.getMeasuredState());
                        if (a) {
                            final int baseline = s.getBaseline();
                            if (baseline != -1) {
                                int n14;
                                if ((n14 = a2.gravity) < 0) {
                                    n14 = this.e;
                                }
                                final int n15 = ((n14 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                                i[n15] = Math.max(i[n15], baseline);
                                j[n15] = Math.max(j[n15], n13 - baseline);
                            }
                        }
                        final int max4 = Math.max(max, n13);
                        if (n9 != 0 && a2.height == -1) {
                            n9 = 1;
                        }
                        else {
                            n9 = 0;
                        }
                        int max5;
                        if (a2.weight > 0.0f) {
                            if (!b2) {
                                n12 = n13;
                            }
                            max5 = Math.max(n5, n12);
                        }
                        else {
                            if (b2) {
                                n13 = n12;
                            }
                            max2 = Math.max(max2, n13);
                            max5 = n5;
                        }
                        n16 = this.p(s, k) + k;
                        n7 = combineMeasuredStates;
                        n5 = max5;
                        max = max4;
                        n17 = n11;
                        break Label_0862;
                    }
                    k += this.p(s, k);
                }
                final int n18 = k;
                n17 = n3;
                n16 = n18;
            }
            final int n19 = n17;
            k = n16 + 1;
            n3 = n19;
        }
        if (this.f > 0 && this.t(virtualChildCount)) {
            this.f += this.w;
        }
        if (i[1] != -1 || i[0] != -1 || i[2] != -1 || i[3] != -1) {
            max = Math.max(max, Math.max(i[3], Math.max(i[0], Math.max(i[1], i[2]))) + Math.max(j[3], Math.max(j[0], Math.max(j[1], j[2]))));
        }
        int n20 = max;
        Label_1199: {
            if (h) {
                if (mode != Integer.MIN_VALUE) {
                    n20 = max;
                    if (mode != 0) {
                        break Label_1199;
                    }
                }
                this.f = 0;
                int n21 = 0;
                while (true) {
                    n20 = max;
                    if (n21 >= virtualChildCount) {
                        break;
                    }
                    final View s2 = this.s(n21);
                    if (s2 == null) {
                        this.f += this.y(n21);
                    }
                    else if (s2.getVisibility() == 8) {
                        n21 += this.p(s2, n21);
                    }
                    else {
                        final a a3 = (a)s2.getLayoutParams();
                        if (b) {
                            this.f += a3.leftMargin + n4 + a3.rightMargin + this.r(s2);
                        }
                        else {
                            final int f4 = this.f;
                            this.f = Math.max(f4, f4 + n4 + a3.leftMargin + a3.rightMargin + this.r(s2));
                        }
                    }
                    ++n21;
                }
            }
        }
        final int f5 = this.f + (this.getPaddingLeft() + this.getPaddingRight());
        this.f = f5;
        final int resolveSizeAndState = View.resolveSizeAndState(Math.max(f5, this.getSuggestedMinimumWidth()), n, 0);
        final int n22 = (0xFFFFFF & resolveSizeAndState) - this.f;
        int n23;
        int max7;
        int n24;
        if (n6 == 0 && (n22 == 0 || n10 <= 0.0f)) {
            final int max6 = Math.max(max2, n5);
            if (h && mode != 1073741824) {
                for (int l = 0; l < virtualChildCount; ++l) {
                    final View s3 = this.s(l);
                    if (s3 != null) {
                        if (s3.getVisibility() != 8) {
                            if (((a)s3.getLayoutParams()).weight > 0.0f) {
                                s3.measure(View$MeasureSpec.makeMeasureSpec(n4, 1073741824), View$MeasureSpec.makeMeasureSpec(s3.getMeasuredHeight(), 1073741824));
                            }
                        }
                    }
                }
            }
            n23 = virtualChildCount;
            max7 = n20;
            n24 = max6;
        }
        else {
            final float g = this.g;
            if (g > 0.0f) {
                n10 = g;
            }
            i[2] = (i[3] = -1);
            i[0] = (i[1] = -1);
            j[2] = (j[3] = -1);
            j[0] = (j[1] = -1);
            this.f = 0;
            int n25 = -1;
            final int n26 = n7;
            int n27 = 0;
            int n28 = n9;
            final int n29 = virtualChildCount;
            int combineMeasuredStates2 = n26;
            int n30 = max2;
            int n31 = n22;
            while (n27 < n29) {
                final View s4 = this.s(n27);
                if (s4 != null) {
                    if (s4.getVisibility() != 8) {
                        final a a4 = (a)s4.getLayoutParams();
                        final float weight2 = a4.weight;
                        if (weight2 > 0.0f) {
                            final int n32 = (int)(n31 * weight2 / n10);
                            final int childMeasureSpec = ViewGroup.getChildMeasureSpec(n2, this.getPaddingTop() + this.getPaddingBottom() + a4.topMargin + a4.bottomMargin, a4.height);
                            if (a4.width == 0 && mode == 1073741824) {
                                int n33;
                                if (n32 > 0) {
                                    n33 = n32;
                                }
                                else {
                                    n33 = 0;
                                }
                                s4.measure(View$MeasureSpec.makeMeasureSpec(n33, 1073741824), childMeasureSpec);
                            }
                            else {
                                int n34;
                                if ((n34 = s4.getMeasuredWidth() + n32) < 0) {
                                    n34 = 0;
                                }
                                s4.measure(View$MeasureSpec.makeMeasureSpec(n34, 1073741824), childMeasureSpec);
                            }
                            combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates2, s4.getMeasuredState() & 0xFF000000);
                            n10 -= weight2;
                            n31 -= n32;
                        }
                        if (b) {
                            this.f += s4.getMeasuredWidth() + a4.leftMargin + a4.rightMargin + this.r(s4);
                        }
                        else {
                            final int f6 = this.f;
                            this.f = Math.max(f6, s4.getMeasuredWidth() + f6 + a4.leftMargin + a4.rightMargin + this.r(s4));
                        }
                        final boolean b3 = mode2 != 1073741824 && a4.height == -1;
                        final int n35 = a4.topMargin + a4.bottomMargin;
                        final int n36 = s4.getMeasuredHeight() + n35;
                        final int max8 = Math.max(n25, n36);
                        int n37;
                        if (b3) {
                            n37 = n35;
                        }
                        else {
                            n37 = n36;
                        }
                        final int max9 = Math.max(n30, n37);
                        if (n28 != 0 && a4.height == -1) {
                            n28 = 1;
                        }
                        else {
                            n28 = 0;
                        }
                        if (a) {
                            final int baseline2 = s4.getBaseline();
                            if (baseline2 != -1) {
                                int n38;
                                if ((n38 = a4.gravity) < 0) {
                                    n38 = this.e;
                                }
                                final int n39 = ((n38 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                                i[n39] = Math.max(i[n39], baseline2);
                                j[n39] = Math.max(j[n39], n36 - baseline2);
                            }
                        }
                        n30 = max9;
                        n25 = max8;
                    }
                }
                ++n27;
            }
            this.f += this.getPaddingLeft() + this.getPaddingRight();
            if (i[1] == -1 && i[0] == -1 && i[2] == -1 && i[3] == -1) {
                max7 = n25;
            }
            else {
                max7 = Math.max(n25, Math.max(i[3], Math.max(i[0], Math.max(i[1], i[2]))) + Math.max(j[3], Math.max(j[0], Math.max(j[1], j[2]))));
            }
            n7 = combineMeasuredStates2;
            n9 = n28;
            n23 = n29;
            n24 = n30;
        }
        if (n9 == 0 && mode2 != 1073741824) {
            max7 = n24;
        }
        this.setMeasuredDimension(resolveSizeAndState | (n7 & 0xFF000000), View.resolveSizeAndState(Math.max(max7 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), n2, n7 << 16));
        if (n8 != 0) {
            this.k(n23, n);
        }
    }
    
    int y(final int n) {
        return 0;
    }
    
    void z(final int n, final int n2) {
        this.f = 0;
        final int virtualChildCount = this.getVirtualChildCount();
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        final int b = this.b;
        final boolean h = this.h;
        int n3 = 0;
        int max = 0;
        int max3;
        int max2 = max3 = max;
        int i;
        int max4 = i = max3;
        int n5;
        int n4 = n5 = i;
        float n6 = 0.0f;
        int n7 = 1;
        while (i < virtualChildCount) {
            final View s = this.s(i);
            if (s == null) {
                this.f += this.y(i);
            }
            else if (s.getVisibility() == 8) {
                i += this.p(s, i);
            }
            else {
                if (this.t(i)) {
                    this.f += this.x;
                }
                final a a = (a)s.getLayoutParams();
                final float weight = a.weight;
                n6 += weight;
                if (mode2 == 1073741824 && a.height == 0 && weight > 0.0f) {
                    final int f = this.f;
                    this.f = Math.max(f, a.topMargin + f + a.bottomMargin);
                    n4 = 1;
                }
                else {
                    int height;
                    if (a.height == 0 && weight > 0.0f) {
                        a.height = -2;
                        height = 0;
                    }
                    else {
                        height = Integer.MIN_VALUE;
                    }
                    int f2;
                    if (n6 == 0.0f) {
                        f2 = this.f;
                    }
                    else {
                        f2 = 0;
                    }
                    this.w(s, i, n, 0, n2, f2);
                    if (height != Integer.MIN_VALUE) {
                        a.height = height;
                    }
                    final int measuredHeight = s.getMeasuredHeight();
                    final int f3 = this.f;
                    this.f = Math.max(f3, f3 + measuredHeight + a.topMargin + a.bottomMargin + this.r(s));
                    if (h) {
                        max2 = Math.max(measuredHeight, max2);
                    }
                }
                if (b >= 0 && b == i + 1) {
                    this.c = this.f;
                }
                if (i < b && a.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                boolean b2;
                if (mode != 1073741824 && a.width == -1) {
                    b2 = true;
                    n5 = 1;
                }
                else {
                    b2 = false;
                }
                int n8 = a.leftMargin + a.rightMargin;
                final int n9 = s.getMeasuredWidth() + n8;
                max = Math.max(max, n9);
                final int combineMeasuredStates = View.combineMeasuredStates(n3, s.getMeasuredState());
                int n10;
                if (n7 != 0 && a.width == -1) {
                    n10 = 1;
                }
                else {
                    n10 = 0;
                }
                int max5;
                if (a.weight > 0.0f) {
                    if (!b2) {
                        n8 = n9;
                    }
                    max3 = Math.max(max3, n8);
                    max5 = max4;
                }
                else {
                    if (!b2) {
                        n8 = n9;
                    }
                    max5 = Math.max(max4, n8);
                }
                final int p2 = this.p(s, i);
                max4 = max5;
                final int n11 = combineMeasuredStates;
                i += p2;
                n7 = n10;
                n3 = n11;
            }
            ++i;
        }
        if (this.f > 0 && this.t(virtualChildCount)) {
            this.f += this.x;
        }
        if (h && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f = 0;
            for (int j = 0; j < virtualChildCount; ++j) {
                final View s2 = this.s(j);
                if (s2 == null) {
                    this.f += this.y(j);
                }
                else if (s2.getVisibility() == 8) {
                    j += this.p(s2, j);
                }
                else {
                    final a a2 = (a)s2.getLayoutParams();
                    final int f4 = this.f;
                    this.f = Math.max(f4, f4 + max2 + a2.topMargin + a2.bottomMargin + this.r(s2));
                }
            }
        }
        final int f5 = this.f + (this.getPaddingTop() + this.getPaddingBottom());
        this.f = f5;
        final int resolveSizeAndState = View.resolveSizeAndState(Math.max(f5, this.getSuggestedMinimumHeight()), n2, 0);
        final int n12 = (0xFFFFFF & resolveSizeAndState) - this.f;
        int n13;
        int n14;
        if (n4 == 0 && (n12 == 0 || n6 <= 0.0f)) {
            final int max6 = Math.max(max4, max3);
            if (h && mode2 != 1073741824) {
                for (int k = 0; k < virtualChildCount; ++k) {
                    final View s3 = this.s(k);
                    if (s3 != null) {
                        if (s3.getVisibility() != 8) {
                            if (((a)s3.getLayoutParams()).weight > 0.0f) {
                                s3.measure(View$MeasureSpec.makeMeasureSpec(s3.getMeasuredWidth(), 1073741824), View$MeasureSpec.makeMeasureSpec(max2, 1073741824));
                            }
                        }
                    }
                }
            }
            n13 = max6;
            n14 = max;
        }
        else {
            final float g = this.g;
            if (g > 0.0f) {
                n6 = g;
            }
            this.f = 0;
            final int n15 = n12;
            int combineMeasuredStates2 = n3;
            int l = 0;
            int n16 = n15;
            n14 = max;
            while (l < virtualChildCount) {
                final View s4 = this.s(l);
                if (s4.getVisibility() != 8) {
                    final a a3 = (a)s4.getLayoutParams();
                    final float weight2 = a3.weight;
                    if (weight2 > 0.0f) {
                        final int n17 = (int)(n16 * weight2 / n6);
                        final int paddingLeft = this.getPaddingLeft();
                        final int paddingRight = this.getPaddingRight();
                        final int leftMargin = a3.leftMargin;
                        final int rightMargin = a3.rightMargin;
                        final int width = a3.width;
                        final int n18 = n16 - n17;
                        final int childMeasureSpec = ViewGroup.getChildMeasureSpec(n, paddingLeft + paddingRight + leftMargin + rightMargin, width);
                        if (a3.height == 0 && mode2 == 1073741824) {
                            int n19;
                            if (n17 > 0) {
                                n19 = n17;
                            }
                            else {
                                n19 = 0;
                            }
                            s4.measure(childMeasureSpec, View$MeasureSpec.makeMeasureSpec(n19, 1073741824));
                        }
                        else {
                            int n20;
                            if ((n20 = s4.getMeasuredHeight() + n17) < 0) {
                                n20 = 0;
                            }
                            s4.measure(childMeasureSpec, View$MeasureSpec.makeMeasureSpec(n20, 1073741824));
                        }
                        combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates2, s4.getMeasuredState() & 0xFFFFFF00);
                        n6 -= weight2;
                        n16 = n18;
                    }
                    final int n21 = a3.leftMargin + a3.rightMargin;
                    final int n22 = s4.getMeasuredWidth() + n21;
                    final int max7 = Math.max(n14, n22);
                    int n23;
                    if (mode != 1073741824 && a3.width == -1) {
                        n23 = n21;
                    }
                    else {
                        n23 = n22;
                    }
                    max4 = Math.max(max4, n23);
                    if (n7 != 0 && a3.width == -1) {
                        n7 = 1;
                    }
                    else {
                        n7 = 0;
                    }
                    final int f6 = this.f;
                    this.f = Math.max(f6, s4.getMeasuredHeight() + f6 + a3.topMargin + a3.bottomMargin + this.r(s4));
                    n14 = max7;
                }
                ++l;
            }
            this.f += this.getPaddingTop() + this.getPaddingBottom();
            n3 = combineMeasuredStates2;
            n13 = max4;
        }
        if (n7 != 0 || mode == 1073741824) {
            n13 = n14;
        }
        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(n13 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), n, n3), resolveSizeAndState);
        if (n5 != 0) {
            this.l(virtualChildCount, n2);
        }
    }
    
    public static class a extends LinearLayout$LayoutParams
    {
        public a(final int n, final int n2) {
            super(n, n2);
        }
        
        public a(final Context context, final AttributeSet set) {
            super(context, set);
        }
        
        public a(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
        }
    }
}
