// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import java.util.ArrayList;
import z0.e;
import android.view.View;
import androidx.collection.a;

class d0
{
    static final f0 a;
    static final f0 b;
    
    static {
        a = new e0();
        b = b();
    }
    
    static void a(final Fragment fragment, final Fragment fragment2, final boolean b, final a<String, View> a, final boolean b2) {
        if (b) {
            fragment2.getEnterTransitionCallback();
        }
        else {
            fragment.getEnterTransitionCallback();
        }
    }
    
    private static f0 b() {
        try {
            return e.class.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    static void c(final a<String, String> a, final a<String, View> a2) {
        for (int i = a.size() - 1; i >= 0; --i) {
            if (!a2.containsKey(a.m(i))) {
                a.k(i);
            }
        }
    }
    
    static void d(final ArrayList<View> list, final int visibility) {
        if (list == null) {
            return;
        }
        for (int i = list.size() - 1; i >= 0; --i) {
            ((View)list.get(i)).setVisibility(visibility);
        }
    }
    
    static boolean e() {
        return d0.a != null || d0.b != null;
    }
}
