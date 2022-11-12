// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

public class f
{
    public static void a(final AccessibilityRecord accessibilityRecord, final int n) {
        a.c(accessibilityRecord, n);
    }
    
    public static void b(final AccessibilityRecord accessibilityRecord, final int n) {
        a.d(accessibilityRecord, n);
    }
    
    public static void c(final AccessibilityRecord accessibilityRecord, final View view, final int n) {
        b.a(accessibilityRecord, view, n);
    }
    
    static class a
    {
        static int a(final AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }
        
        static int b(final AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }
        
        static void c(final AccessibilityRecord accessibilityRecord, final int maxScrollX) {
            accessibilityRecord.setMaxScrollX(maxScrollX);
        }
        
        static void d(final AccessibilityRecord accessibilityRecord, final int maxScrollY) {
            accessibilityRecord.setMaxScrollY(maxScrollY);
        }
    }
    
    static class b
    {
        static void a(final AccessibilityRecord accessibilityRecord, final View view, final int n) {
            accessibilityRecord.setSource(view, n);
        }
    }
}
