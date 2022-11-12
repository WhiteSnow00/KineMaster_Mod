// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager;

public final class c
{
    public static boolean a(final AccessibilityManager accessibilityManager, final b b) {
        return a.a(accessibilityManager, b);
    }
    
    public static boolean b(final AccessibilityManager accessibilityManager, final b b) {
        return a.b(accessibilityManager, b);
    }
    
    static class a
    {
        static boolean a(final AccessibilityManager accessibilityManager, final b b) {
            return accessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager$TouchExplorationStateChangeListener)new c(b));
        }
        
        static boolean b(final AccessibilityManager accessibilityManager, final b b) {
            return accessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager$TouchExplorationStateChangeListener)new c(b));
        }
    }
    
    public interface b
    {
        void onTouchExplorationStateChanged(final boolean p0);
    }
    
    private static final class c implements AccessibilityManager$TouchExplorationStateChangeListener
    {
        final b a;
        
        c(final b a) {
            this.a = a;
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o instanceof c && this.a.equals(((c)o).a));
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode();
        }
        
        public void onTouchExplorationStateChanged(final boolean b) {
            this.a.onTouchExplorationStateChanged(b);
        }
    }
}
