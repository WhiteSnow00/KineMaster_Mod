// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.Window;

public final class m0
{
    public static o0 a(final Window window, final View view) {
        return new o0(window, view);
    }
    
    public static void b(final Window window, final boolean b) {
        if (Build$VERSION.SDK_INT >= 30) {
            m0.b.a(window, b);
        }
        else {
            a.a(window, b);
        }
    }
    
    static class a
    {
        static void a(final Window window, final boolean b) {
            final View decorView = window.getDecorView();
            final int systemUiVisibility = decorView.getSystemUiVisibility();
            int systemUiVisibility2;
            if (b) {
                systemUiVisibility2 = (systemUiVisibility & 0xFFFFF8FF);
            }
            else {
                systemUiVisibility2 = (systemUiVisibility | 0x700);
            }
            decorView.setSystemUiVisibility(systemUiVisibility2);
        }
    }
    
    static class b
    {
        static void a(final Window window, final boolean decorFitsSystemWindows) {
            window.setDecorFitsSystemWindows(decorFitsSystemWindows);
        }
    }
}
