// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import androidx.emoji2.text.n;
import android.text.Editable;
import android.text.Editable$Factory;

final class b extends Editable$Factory
{
    private static final Object a;
    private static volatile Editable$Factory b;
    private static Class<?> c;
    
    static {
        a = new Object();
    }
    
    private b() {
        try {
            e0.b.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        }
        finally {}
    }
    
    public static Editable$Factory getInstance() {
        if (e0.b.b == null) {
            synchronized (e0.b.a) {
                if (e0.b.b == null) {
                    e0.b.b = new b();
                }
            }
        }
        return e0.b.b;
    }
    
    public Editable newEditable(final CharSequence charSequence) {
        final Class<?> c = e0.b.c;
        if (c != null) {
            return (Editable)n.c(c, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
