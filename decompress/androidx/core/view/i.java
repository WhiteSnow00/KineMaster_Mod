// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.ViewGroup$MarginLayoutParams;

public final class i
{
    public static int a(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return a.b(viewGroup$MarginLayoutParams);
    }
    
    public static int b(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        return a.c(viewGroup$MarginLayoutParams);
    }
    
    public static void c(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
        a.g(viewGroup$MarginLayoutParams, n);
    }
    
    public static void d(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
        a.h(viewGroup$MarginLayoutParams, n);
    }
    
    static class a
    {
        static int a(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            return viewGroup$MarginLayoutParams.getLayoutDirection();
        }
        
        static int b(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            return viewGroup$MarginLayoutParams.getMarginEnd();
        }
        
        static int c(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            return viewGroup$MarginLayoutParams.getMarginStart();
        }
        
        static boolean d(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            return viewGroup$MarginLayoutParams.isMarginRelative();
        }
        
        static void e(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int n) {
            viewGroup$MarginLayoutParams.resolveLayoutDirection(n);
        }
        
        static void f(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int layoutDirection) {
            viewGroup$MarginLayoutParams.setLayoutDirection(layoutDirection);
        }
        
        static void g(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int marginEnd) {
            viewGroup$MarginLayoutParams.setMarginEnd(marginEnd);
        }
        
        static void h(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final int marginStart) {
            viewGroup$MarginLayoutParams.setMarginStart(marginStart);
        }
    }
}
