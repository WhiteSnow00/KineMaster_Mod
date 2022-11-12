// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.ViewGroup;

public final class e0
{
    public static boolean a(final ViewGroup viewGroup) {
        return a.b(viewGroup);
    }
    
    static class a
    {
        static int a(final ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }
        
        static boolean b(final ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
        
        static void c(final ViewGroup viewGroup, final boolean transitionGroup) {
            viewGroup.setTransitionGroup(transitionGroup);
        }
    }
}
