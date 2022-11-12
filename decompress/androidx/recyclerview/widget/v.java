// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.View;

class v
{
    static int a(final RecyclerView.z z, final s s, final View view, final View view2, final RecyclerView.o o, final boolean b) {
        if (o.getChildCount() == 0 || z.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!b) {
            return Math.abs(o.getPosition(view) - o.getPosition(view2)) + 1;
        }
        return Math.min(s.n(), s.d(view2) - s.g(view));
    }
    
    static int b(final RecyclerView.z z, final s s, final View view, final View view2, final RecyclerView.o o, final boolean b, final boolean b2) {
        if (o.getChildCount() == 0 || z.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        final int min = Math.min(o.getPosition(view), o.getPosition(view2));
        final int max = Math.max(o.getPosition(view), o.getPosition(view2));
        int n;
        if (b2) {
            n = Math.max(0, z.b() - max - 1);
        }
        else {
            n = Math.max(0, min);
        }
        if (!b) {
            return n;
        }
        return Math.round(n * (Math.abs(s.d(view2) - s.g(view)) / (float)(Math.abs(o.getPosition(view) - o.getPosition(view2)) + 1)) + (s.m() - s.g(view)));
    }
    
    static int c(final RecyclerView.z z, final s s, final View view, final View view2, final RecyclerView.o o, final boolean b) {
        if (o.getChildCount() == 0 || z.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!b) {
            return z.b();
        }
        return (int)((s.d(view2) - s.g(view)) / (float)(Math.abs(o.getPosition(view) - o.getPosition(view2)) + 1) * z.b());
    }
}
