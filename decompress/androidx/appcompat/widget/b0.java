// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import java.lang.reflect.InvocationTargetException;
import android.widget.AdapterView;
import java.lang.reflect.Method;
import android.os.Build$VERSION;
import android.view.MotionEvent;
import android.view.ViewGroup$LayoutParams;
import android.widget.ListAdapter;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.view.View;
import android.widget.AbsListView;
import android.util.AttributeSet;
import d.a;
import android.content.Context;
import androidx.core.widget.k;
import androidx.core.view.i0;
import java.lang.reflect.Field;
import android.graphics.Rect;
import android.widget.ListView;

class b0 extends ListView
{
    private final Rect a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Field g;
    private c h;
    private boolean i;
    private boolean j;
    private boolean p;
    private i0 w;
    private k x;
    d y;
    
    b0(final Context context, final boolean j) {
        super(context, (AttributeSet)null, d.a.B);
        this.a = new Rect();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.j = j;
        this.setCacheColorHint(0);
        try {
            (this.g = AbsListView.class.getDeclaredField("mIsChildViewEnabled")).setAccessible(true);
        }
        catch (final NoSuchFieldException ex) {
            ex.printStackTrace();
        }
    }
    
    private void a() {
        this.setPressed(this.p = false);
        this.drawableStateChanged();
        final View child = this.getChildAt(this.f - this.getFirstVisiblePosition());
        if (child != null) {
            child.setPressed(false);
        }
        final i0 w = this.w;
        if (w != null) {
            w.c();
            this.w = null;
        }
    }
    
    private void b(final View view, final int n) {
        this.performItemClick(view, n, this.getItemIdAtPosition(n));
    }
    
    private void c(final Canvas canvas) {
        if (!this.a.isEmpty()) {
            final Drawable selector = this.getSelector();
            if (selector != null) {
                selector.setBounds(this.a);
                selector.draw(canvas);
            }
        }
    }
    
    private void f(final int n, final View view) {
        final Rect a = this.a;
        a.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        a.left -= this.b;
        a.top -= this.c;
        a.right += this.d;
        a.bottom += this.e;
        try {
            final boolean boolean1 = this.g.getBoolean(this);
            if (view.isEnabled() != boolean1) {
                this.g.set(this, !boolean1);
                if (n != -1) {
                    this.refreshDrawableState();
                }
            }
        }
        catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
    
    private void g(final int n, final View view) {
        final Drawable selector = this.getSelector();
        boolean b = true;
        final boolean b2 = selector != null && n != -1;
        if (b2) {
            selector.setVisible(false, false);
        }
        this.f(n, view);
        if (b2) {
            final Rect a = this.a;
            final float exactCenterX = a.exactCenterX();
            final float exactCenterY = a.exactCenterY();
            if (this.getVisibility() != 0) {
                b = false;
            }
            selector.setVisible(b, false);
            androidx.core.graphics.drawable.a.e(selector, exactCenterX, exactCenterY);
        }
    }
    
    private void h(final int n, final View view, final float n2, final float n3) {
        this.g(n, view);
        final Drawable selector = this.getSelector();
        if (selector != null && n != -1) {
            androidx.core.graphics.drawable.a.e(selector, n2, n3);
        }
    }
    
    private void i(final View view, final int f, final float n, final float n2) {
        this.p = true;
        b0.a.a((View)this, n, n2);
        if (!this.isPressed()) {
            this.setPressed(true);
        }
        this.layoutChildren();
        final int f2 = this.f;
        if (f2 != -1) {
            final View child = this.getChildAt(f2 - this.getFirstVisiblePosition());
            if (child != null && child != view && child.isPressed()) {
                child.setPressed(false);
            }
        }
        this.f = f;
        b0.a.a(view, n - view.getLeft(), n2 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        this.h(f, view, n, n2);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }
    
    private boolean j() {
        return this.p;
    }
    
    private void k() {
        final Drawable selector = this.getSelector();
        if (selector != null && this.j() && this.isPressed()) {
            selector.setState(this.getDrawableState());
        }
    }
    
    private void setSelectorEnabled(final boolean b) {
        final c h = this.h;
        if (h != null) {
            h.c(b);
        }
    }
    
    public int d(int n, int listPaddingBottom, int listPaddingTop, final int n2, final int n3) {
        listPaddingTop = this.getListPaddingTop();
        listPaddingBottom = this.getListPaddingBottom();
        int dividerHeight = this.getDividerHeight();
        final Drawable divider = this.getDivider();
        final ListAdapter adapter = this.getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingTop += listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        final int count = adapter.getCount();
        int i = 0;
        int n4 = listPaddingBottom = 0;
        View view = null;
        while (i < count) {
            final int itemViewType = adapter.getItemViewType(i);
            int n5;
            if (itemViewType != (n5 = n4)) {
                view = null;
                n5 = itemViewType;
            }
            final View view2 = adapter.getView(i, view, (ViewGroup)this);
            ViewGroup$LayoutParams layoutParams;
            if ((layoutParams = view2.getLayoutParams()) == null) {
                layoutParams = this.generateDefaultLayoutParams();
                view2.setLayoutParams(layoutParams);
            }
            final int height = layoutParams.height;
            int n6;
            if (height > 0) {
                n6 = View$MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
            else {
                n6 = View$MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(n, n6);
            view2.forceLayout();
            int n7 = listPaddingTop;
            if (i > 0) {
                n7 = listPaddingTop + dividerHeight;
            }
            listPaddingTop = n7 + view2.getMeasuredHeight();
            if (listPaddingTop >= n2) {
                n = n2;
                if (n3 >= 0) {
                    n = n2;
                    if (i > n3) {
                        n = n2;
                        if (listPaddingBottom > 0 && listPaddingTop != (n = n2)) {
                            n = listPaddingBottom;
                        }
                    }
                }
                return n;
            }
            int n8 = listPaddingBottom;
            if (n3 >= 0) {
                n8 = listPaddingBottom;
                if (i >= n3) {
                    n8 = listPaddingTop;
                }
            }
            ++i;
            n4 = n5;
            view = view2;
            listPaddingBottom = n8;
        }
        return listPaddingTop;
    }
    
    protected void dispatchDraw(final Canvas canvas) {
        this.c(canvas);
        super.dispatchDraw(canvas);
    }
    
    protected void drawableStateChanged() {
        if (this.y != null) {
            return;
        }
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.k();
    }
    
    public boolean e(final MotionEvent motionEvent, int n) {
        final int actionMasked = motionEvent.getActionMasked();
        boolean b = false;
    Label_0139:
        while (true) {
            int pointerIndex;
            while (true) {
                Label_0045: {
                    if (actionMasked == 1) {
                        b = false;
                        break Label_0045;
                    }
                    if (actionMasked == 2) {
                        b = true;
                        break Label_0045;
                    }
                    if (actionMasked == 3) {
                        break Label_0028;
                    }
                    n = 0;
                    b = true;
                    break Label_0139;
                    n = 0;
                    b = false;
                    break Label_0139;
                }
                pointerIndex = motionEvent.findPointerIndex(n);
                if (pointerIndex < 0) {
                    continue;
                }
                break;
            }
            n = (int)motionEvent.getX(pointerIndex);
            final int n2 = (int)motionEvent.getY(pointerIndex);
            final int pointToPosition = this.pointToPosition(n, n2);
            if (pointToPosition == -1) {
                n = 1;
            }
            else {
                final View child = this.getChildAt(pointToPosition - this.getFirstVisiblePosition());
                this.i(child, pointToPosition, (float)n, (float)n2);
                if (actionMasked == 1) {
                    this.b(child, pointToPosition);
                }
                continue;
            }
            break;
        }
        if (!b || n != 0) {
            this.a();
        }
        if (b) {
            if (this.x == null) {
                this.x = new k(this);
            }
            this.x.m(true);
            this.x.onTouch((View)this, motionEvent);
        }
        else {
            final k x = this.x;
            if (x != null) {
                x.m(false);
            }
        }
        return b;
    }
    
    public boolean hasFocus() {
        return this.j || super.hasFocus();
    }
    
    public boolean hasWindowFocus() {
        return this.j || super.hasWindowFocus();
    }
    
    public boolean isFocused() {
        return this.j || super.isFocused();
    }
    
    public boolean isInTouchMode() {
        return (this.j && this.i) || super.isInTouchMode();
    }
    
    protected void onDetachedFromWindow() {
        this.y = null;
        super.onDetachedFromWindow();
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.y == null) {
            (this.y = new d()).b();
        }
        final boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            this.setSelection(-1);
        }
        else {
            final int pointToPosition = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != this.getSelectedItemPosition()) {
                final View child = this.getChildAt(pointToPosition - this.getFirstVisiblePosition());
                if (child.isEnabled()) {
                    this.requestFocus();
                    if (sdk_INT >= 30 && b0.b.a()) {
                        b0.b.b(this, pointToPosition, child);
                    }
                    else {
                        this.setSelectionFromTop(pointToPosition, child.getTop() - this.getTop());
                    }
                }
                this.k();
            }
        }
        return onHoverEvent;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        }
        final d y = this.y;
        if (y != null) {
            y.a();
        }
        return super.onTouchEvent(motionEvent);
    }
    
    void setListSelectionHidden(final boolean i) {
        this.i = i;
    }
    
    public void setSelector(final Drawable drawable) {
        c h;
        if (drawable != null) {
            h = new c(drawable);
        }
        else {
            h = null;
        }
        super.setSelector((Drawable)(this.h = h));
        final Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.b = rect.left;
        this.c = rect.top;
        this.d = rect.right;
        this.e = rect.bottom;
    }
    
    static class a
    {
        static void a(final View view, final float n, final float n2) {
            view.drawableHotspotChanged(n, n2);
        }
    }
    
    static class b
    {
        private static Method a;
        private static Method b;
        private static Method c;
        private static boolean d;
        
        static {
            try {
                final Class<Integer> type = Integer.TYPE;
                final Class<Boolean> type2 = Boolean.TYPE;
                final Class<Float> type3 = Float.TYPE;
                (b0.b.a = AbsListView.class.getDeclaredMethod("positionSelector", type, View.class, type2, type3, type3)).setAccessible(true);
                (b0.b.b = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", type)).setAccessible(true);
                (b0.b.c = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", type)).setAccessible(true);
                b0.b.d = true;
            }
            catch (final NoSuchMethodException ex) {
                ex.printStackTrace();
            }
        }
        
        static boolean a() {
            return b0.b.d;
        }
        
        static void b(final b0 b0, final int n, final View view) {
            try {
                androidx.appcompat.widget.b0.b.a.invoke(b0, n, view, Boolean.FALSE, -1, -1);
                androidx.appcompat.widget.b0.b.b.invoke(b0, n);
                androidx.appcompat.widget.b0.b.c.invoke(b0, n);
            }
            catch (final InvocationTargetException ex) {
                ex.printStackTrace();
            }
            catch (final IllegalAccessException ex2) {
                ex2.printStackTrace();
            }
        }
    }
    
    private static class c extends f.a
    {
        private boolean b;
        
        c(final Drawable drawable) {
            super(drawable);
            this.b = true;
        }
        
        void c(final boolean b) {
            this.b = b;
        }
        
        @Override
        public void draw(final Canvas canvas) {
            if (this.b) {
                super.draw(canvas);
            }
        }
        
        @Override
        public void setHotspot(final float n, final float n2) {
            if (this.b) {
                super.setHotspot(n, n2);
            }
        }
        
        @Override
        public void setHotspotBounds(final int n, final int n2, final int n3, final int n4) {
            if (this.b) {
                super.setHotspotBounds(n, n2, n3, n4);
            }
        }
        
        @Override
        public boolean setState(final int[] state) {
            return this.b && super.setState(state);
        }
        
        @Override
        public boolean setVisible(final boolean b, final boolean b2) {
            return this.b && super.setVisible(b, b2);
        }
    }
    
    private class d implements Runnable
    {
        final b0 a;
        
        d(final b0 a) {
            this.a = a;
        }
        
        public void a() {
            final b0 a = this.a;
            a.y = null;
            a.removeCallbacks((Runnable)this);
        }
        
        public void b() {
            this.a.post((Runnable)this);
        }
        
        @Override
        public void run() {
            final b0 a = this.a;
            a.y = null;
            a.drawableStateChanged();
        }
    }
}
