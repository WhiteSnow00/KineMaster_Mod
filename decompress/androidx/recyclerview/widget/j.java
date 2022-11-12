// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.View;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.util.Log;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class j extends n
{
    private static final int[] d;
    private Drawable a;
    private int b;
    private final Rect c;
    
    static {
        d = new int[] { 16843284 };
    }
    
    public j(final Context context, final int n) {
        this.c = new Rect();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(j.d);
        final Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        this.g(n);
    }
    
    private void d(final Canvas canvas, final RecyclerView recyclerView) {
        canvas.save();
        final boolean clipToPadding = recyclerView.getClipToPadding();
        int i = 0;
        int paddingTop;
        int height;
        if (clipToPadding) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        }
        else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        while (i < recyclerView.getChildCount()) {
            final View child = recyclerView.getChildAt(i);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(child, this.c);
            final int n = this.c.right + Math.round(child.getTranslationX());
            this.a.setBounds(n - this.a.getIntrinsicWidth(), paddingTop, n, height);
            this.a.draw(canvas);
            ++i;
        }
        canvas.restore();
    }
    
    private void e(final Canvas canvas, final RecyclerView recyclerView) {
        canvas.save();
        final boolean clipToPadding = recyclerView.getClipToPadding();
        int i = 0;
        int paddingLeft;
        int width;
        if (clipToPadding) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        }
        else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        while (i < recyclerView.getChildCount()) {
            final View child = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(child, this.c);
            final int n = this.c.bottom + Math.round(child.getTranslationY());
            this.a.setBounds(paddingLeft, n - this.a.getIntrinsicHeight(), width, n);
            this.a.draw(canvas);
            ++i;
        }
        canvas.restore();
    }
    
    public void f(final Drawable a) {
        if (a != null) {
            this.a = a;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }
    
    public void g(final int b) {
        if (b != 0 && b != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.b = b;
    }
    
    @Override
    public void getItemOffsets(final Rect rect, final View view, final RecyclerView recyclerView, final z z) {
        final Drawable a = this.a;
        if (a == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (this.b == 1) {
            rect.set(0, 0, 0, a.getIntrinsicHeight());
        }
        else {
            rect.set(0, 0, a.getIntrinsicWidth(), 0);
        }
    }
    
    @Override
    public void onDraw(final Canvas canvas, final RecyclerView recyclerView, final z z) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.a != null) {
                if (this.b == 1) {
                    this.e(canvas, recyclerView);
                }
                else {
                    this.d(canvas, recyclerView);
                }
            }
        }
    }
}
