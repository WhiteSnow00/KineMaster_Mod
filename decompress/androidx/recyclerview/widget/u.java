// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.view.accessibility.e;
import androidx.core.view.b0;
import java.util.WeakHashMap;
import java.util.Map;
import android.os.Bundle;
import androidx.core.view.accessibility.d;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import androidx.core.view.a;

public class u extends androidx.core.view.a
{
    final RecyclerView a;
    private final a b;
    
    public u(final RecyclerView a) {
        this.a = a;
        final androidx.core.view.a a2 = this.a();
        if (a2 != null && a2 instanceof a) {
            this.b = (a)a2;
        }
        else {
            this.b = new a(this);
        }
    }
    
    public androidx.core.view.a a() {
        return this.b;
    }
    
    boolean b() {
        return this.a.hasPendingAdapterUpdates();
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (view instanceof RecyclerView && !this.b()) {
            final RecyclerView recyclerView = (RecyclerView)view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final View view, final d d) {
        super.onInitializeAccessibilityNodeInfo(view, d);
        if (!this.b() && this.a.getLayoutManager() != null) {
            this.a.getLayoutManager().onInitializeAccessibilityNodeInfo(d);
        }
    }
    
    @Override
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return super.performAccessibilityAction(view, n, bundle) || (!this.b() && this.a.getLayoutManager() != null && this.a.getLayoutManager().performAccessibilityAction(n, bundle));
    }
    
    public static class a extends androidx.core.view.a
    {
        final u a;
        private Map<View, androidx.core.view.a> b;
        
        public a(final u a) {
            this.b = new WeakHashMap<View, androidx.core.view.a>();
            this.a = a;
        }
        
        androidx.core.view.a a(final View view) {
            return this.b.remove(view);
        }
        
        void b(final View view) {
            final androidx.core.view.a l = b0.l(view);
            if (l != null && l != this) {
                this.b.put(view, l);
            }
        }
        
        @Override
        public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            final androidx.core.view.a a = this.b.get(view);
            if (a != null) {
                return a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        
        @Override
        public e getAccessibilityNodeProvider(final View view) {
            final androidx.core.view.a a = this.b.get(view);
            if (a != null) {
                return a.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
        
        @Override
        public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            final androidx.core.view.a a = this.b.get(view);
            if (a != null) {
                a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
            else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }
        
        @Override
        public void onInitializeAccessibilityNodeInfo(final View view, final d d) {
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                this.a.a.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, d);
                final androidx.core.view.a a = this.b.get(view);
                if (a != null) {
                    a.onInitializeAccessibilityNodeInfo(view, d);
                }
                else {
                    super.onInitializeAccessibilityNodeInfo(view, d);
                }
            }
            else {
                super.onInitializeAccessibilityNodeInfo(view, d);
            }
        }
        
        @Override
        public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            final androidx.core.view.a a = this.b.get(view);
            if (a != null) {
                a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }
        
        @Override
        public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
            final androidx.core.view.a a = this.b.get(viewGroup);
            if (a != null) {
                return a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        
        @Override
        public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                final androidx.core.view.a a = this.b.get(view);
                if (a != null) {
                    if (a.performAccessibilityAction(view, n, bundle)) {
                        return true;
                    }
                }
                else if (super.performAccessibilityAction(view, n, bundle)) {
                    return true;
                }
                return this.a.a.getLayoutManager().performAccessibilityActionForItem(view, n, bundle);
            }
            return super.performAccessibilityAction(view, n, bundle);
        }
        
        @Override
        public void sendAccessibilityEvent(final View view, final int n) {
            final androidx.core.view.a a = this.b.get(view);
            if (a != null) {
                a.sendAccessibilityEvent(view, n);
            }
            else {
                super.sendAccessibilityEvent(view, n);
            }
        }
        
        @Override
        public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
            final androidx.core.view.a a = this.b.get(view);
            if (a != null) {
                a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
            else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }
}
