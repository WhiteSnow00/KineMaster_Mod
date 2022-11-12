// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.widget.ListView;

public final class l
{
    public static boolean a(final ListView listView, final int n) {
        return a.a(listView, n);
    }
    
    public static void b(final ListView listView, final int n) {
        a.b(listView, n);
    }
    
    static class a
    {
        static boolean a(final ListView listView, final int n) {
            return listView.canScrollList(n);
        }
        
        static void b(final ListView listView, final int n) {
            listView.scrollListBy(n);
        }
    }
}
