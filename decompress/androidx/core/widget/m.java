// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

public final class m
{
    public static void a(final PopupWindow popupWindow, final boolean b) {
        m.b.c(popupWindow, b);
    }
    
    public static void b(final PopupWindow popupWindow, final int n) {
        b.d(popupWindow, n);
    }
    
    public static void c(final PopupWindow popupWindow, final View view, final int n, final int n2, final int n3) {
        a.a(popupWindow, view, n, n2, n3);
    }
    
    static class a
    {
        static void a(final PopupWindow popupWindow, final View view, final int n, final int n2, final int n3) {
            popupWindow.showAsDropDown(view, n, n2, n3);
        }
    }
    
    static class b
    {
        static boolean a(final PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }
        
        static int b(final PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }
        
        static void c(final PopupWindow popupWindow, final boolean overlapAnchor) {
            popupWindow.setOverlapAnchor(overlapAnchor);
        }
        
        static void d(final PopupWindow popupWindow, final int windowLayoutType) {
            popupWindow.setWindowLayoutType(windowLayoutType);
        }
    }
}
