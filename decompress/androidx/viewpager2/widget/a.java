// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;
import android.animation.LayoutTransition;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import java.util.Arrays;
import java.util.Comparator;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.ViewGroup$MarginLayoutParams;

final class a
{
    private static final ViewGroup$MarginLayoutParams b;
    private LinearLayoutManager a;
    
    static {
        (b = new ViewGroup$MarginLayoutParams(-1, -1)).setMargins(0, 0, 0, 0);
    }
    
    a(final LinearLayoutManager a) {
        this.a = a;
    }
    
    private boolean a() {
        final int childCount = ((RecyclerView.o)this.a).getChildCount();
        if (childCount == 0) {
            return true;
        }
        final boolean b = this.a.getOrientation() == 0;
        final int[][] array = new int[childCount][2];
        for (int i = 0; i < childCount; ++i) {
            final View child = ((RecyclerView.o)this.a).getChildAt(i);
            if (child == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            final ViewGroup$LayoutParams layoutParams = child.getLayoutParams();
            ViewGroup$MarginLayoutParams b2;
            if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
                b2 = (ViewGroup$MarginLayoutParams)layoutParams;
            }
            else {
                b2 = androidx.viewpager2.widget.a.b;
            }
            final int[] array2 = array[i];
            int n;
            int n2;
            if (b) {
                n = child.getLeft();
                n2 = b2.leftMargin;
            }
            else {
                n = child.getTop();
                n2 = b2.topMargin;
            }
            array2[0] = n - n2;
            final int[] array3 = array[i];
            int n3;
            int n4;
            if (b) {
                n3 = child.getRight();
                n4 = b2.rightMargin;
            }
            else {
                n3 = child.getBottom();
                n4 = b2.bottomMargin;
            }
            array3[1] = n3 + n4;
        }
        Arrays.sort(array, new Comparator<int[]>(this) {
            final a a;
            
            public int a(final int[] array, final int[] array2) {
                return array[0] - array2[0];
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((int[])o, (int[])o2);
            }
        });
        for (int j = 1; j < childCount; ++j) {
            if (array[j - 1][1] != array[j][0]) {
                return false;
            }
        }
        final int n5 = array[0][1];
        final int n6 = array[0][0];
        return array[0][0] <= 0 && array[childCount - 1][1] >= n5 - n6;
    }
    
    private boolean b() {
        for (int childCount = ((RecyclerView.o)this.a).getChildCount(), i = 0; i < childCount; ++i) {
            if (c(((RecyclerView.o)this.a).getChildAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean c(final View view) {
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                if (c(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean d() {
        final boolean a = this.a();
        boolean b = true;
        if ((a && ((RecyclerView.o)this.a).getChildCount() > 1) || !this.b()) {
            b = false;
        }
        return b;
    }
}
