// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view.accessibility;

import java.util.ArrayList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import android.os.Bundle;

public class e
{
    private final Object a;
    
    public e() {
        this.a = new c(this);
    }
    
    public e(final Object a) {
        this.a = a;
    }
    
    public void a(final int n, final d d, final String s, final Bundle bundle) {
    }
    
    public d b(final int n) {
        return null;
    }
    
    public List<d> c(final String s, final int n) {
        return null;
    }
    
    public d d(final int n) {
        return null;
    }
    
    public Object e() {
        return this.a;
    }
    
    public boolean f(final int n, final int n2, final Bundle bundle) {
        return false;
    }
    
    static class a extends AccessibilityNodeProvider
    {
        final e a;
        
        a(final e a) {
            this.a = a;
        }
        
        public AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
            final d b = this.a.b(n);
            if (b == null) {
                return null;
            }
            return b.s0();
        }
        
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(final String s, int i) {
            final List<d> c = this.a.c(s, i);
            if (c == null) {
                return null;
            }
            final ArrayList list = new ArrayList();
            int size;
            for (size = c.size(), i = 0; i < size; ++i) {
                list.add(c.get(i).s0());
            }
            return list;
        }
        
        public boolean performAction(final int n, final int n2, final Bundle bundle) {
            return this.a.f(n, n2, bundle);
        }
    }
    
    static class b extends a
    {
        b(final e e) {
            super(e);
        }
        
        public AccessibilityNodeInfo findFocus(final int n) {
            final d d = super.a.d(n);
            if (d == null) {
                return null;
            }
            return d.s0();
        }
    }
    
    static class c extends b
    {
        c(final e e) {
            super(e);
        }
        
        public void addExtraDataToAccessibilityNodeInfo(final int n, final AccessibilityNodeInfo accessibilityNodeInfo, final String s, final Bundle bundle) {
            super.a.a(n, d.t0(accessibilityNodeInfo), s, bundle);
        }
    }
}
