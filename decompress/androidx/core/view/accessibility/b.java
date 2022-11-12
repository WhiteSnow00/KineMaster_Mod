// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

public final class b
{
    public static int a(final AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }
    
    public static void b(final AccessibilityEvent accessibilityEvent, final int n) {
        a.b(accessibilityEvent, n);
    }
    
    static class a
    {
        static int a(final AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }
        
        static void b(final AccessibilityEvent accessibilityEvent, final int contentChangeTypes) {
            accessibilityEvent.setContentChangeTypes(contentChangeTypes);
        }
    }
}
