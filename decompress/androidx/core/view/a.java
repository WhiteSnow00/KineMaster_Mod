// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.accessibility.AccessibilityNodeInfo;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.e;
import android.view.accessibility.AccessibilityEvent;
import java.lang.ref.WeakReference;
import android.util.SparseArray;
import android.text.style.ClickableSpan;
import java.util.Collections;
import v.c;
import androidx.core.view.accessibility.d;
import java.util.List;
import android.view.View;
import android.view.View$AccessibilityDelegate;

public class a
{
    private static final View$AccessibilityDelegate DEFAULT_DELEGATE;
    private final View$AccessibilityDelegate mBridge;
    private final View$AccessibilityDelegate mOriginalDelegate;
    
    static {
        DEFAULT_DELEGATE = new View$AccessibilityDelegate();
    }
    
    public a() {
        this(a.DEFAULT_DELEGATE);
    }
    
    public a(final View$AccessibilityDelegate mOriginalDelegate) {
        this.mOriginalDelegate = mOriginalDelegate;
        this.mBridge = new a(this);
    }
    
    static List<d.a> getActionList(final View view) {
        List<Object> emptyList;
        if ((emptyList = (List)view.getTag(c.H)) == null) {
            emptyList = Collections.emptyList();
        }
        return (List<d.a>)emptyList;
    }
    
    private boolean isSpanStillValid(final ClickableSpan clickableSpan, final View view) {
        if (clickableSpan != null) {
            final ClickableSpan[] m = d.m(view.createAccessibilityNodeInfo().getText());
            for (int n = 0; m != null && n < m.length; ++n) {
                if (clickableSpan.equals(m[n])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean performClickableSpanAction(final int n, final View view) {
        final SparseArray sparseArray = (SparseArray)view.getTag(c.I);
        if (sparseArray != null) {
            final WeakReference weakReference = (WeakReference)sparseArray.get(n);
            if (weakReference != null) {
                final ClickableSpan clickableSpan = (ClickableSpan)weakReference.get();
                if (this.isSpanStillValid(clickableSpan, view)) {
                    clickableSpan.onClick(view);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public e getAccessibilityNodeProvider(final View view) {
        final AccessibilityNodeProvider a = b.a(this.mOriginalDelegate, view);
        if (a != null) {
            return new e(a);
        }
        return null;
    }
    
    View$AccessibilityDelegate getBridge() {
        return this.mBridge;
    }
    
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final d d) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, d.s0());
    }
    
    public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        final List<d.a> actionList = getActionList(view);
        final int n2 = 0;
        int n3 = 0;
        boolean d;
        while (true) {
            d = (n2 != 0);
            if (n3 >= actionList.size()) {
                break;
            }
            final d.a a = actionList.get(n3);
            if (a.b() == n) {
                d = a.d(view, bundle);
                break;
            }
            ++n3;
        }
        boolean b = d;
        if (!d) {
            b = androidx.core.view.a.b.b(this.mOriginalDelegate, view, n, bundle);
        }
        boolean performClickableSpanAction = b;
        if (!b) {
            performClickableSpanAction = b;
            if (n == c.a) {
                performClickableSpanAction = b;
                if (bundle != null) {
                    performClickableSpanAction = this.performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
                }
            }
        }
        return performClickableSpanAction;
    }
    
    public void sendAccessibilityEvent(final View view, final int n) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, n);
    }
    
    public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
    
    static final class a extends View$AccessibilityDelegate
    {
        final androidx.core.view.a a;
        
        a(final androidx.core.view.a a) {
            this.a = a;
        }
        
        public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        
        public AccessibilityNodeProvider getAccessibilityNodeProvider(final View view) {
            final e accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
            AccessibilityNodeProvider accessibilityNodeProvider2;
            if (accessibilityNodeProvider != null) {
                accessibilityNodeProvider2 = (AccessibilityNodeProvider)accessibilityNodeProvider.e();
            }
            else {
                accessibilityNodeProvider2 = null;
            }
            return accessibilityNodeProvider2;
        }
        
        public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }
        
        public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfo accessibilityNodeInfo) {
            final d t0 = d.t0(accessibilityNodeInfo);
            t0.k0(b0.W(view));
            t0.a0(b0.R(view));
            t0.f0(b0.p(view));
            t0.o0(b0.I(view));
            this.a.onInitializeAccessibilityNodeInfo(view, t0);
            t0.d(accessibilityNodeInfo.getText(), view);
            final List<d.a> actionList = androidx.core.view.a.getActionList(view);
            for (int i = 0; i < actionList.size(); ++i) {
                t0.b((d.a)actionList.get(i));
            }
        }
        
        public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        
        public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
            return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        
        public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
            return this.a.performAccessibilityAction(view, n, bundle);
        }
        
        public void sendAccessibilityEvent(final View view, final int n) {
            this.a.sendAccessibilityEvent(view, n);
        }
        
        public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
            this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }
    
    static class b
    {
        static AccessibilityNodeProvider a(final View$AccessibilityDelegate view$AccessibilityDelegate, final View view) {
            return view$AccessibilityDelegate.getAccessibilityNodeProvider(view);
        }
        
        static boolean b(final View$AccessibilityDelegate view$AccessibilityDelegate, final View view, final int n, final Bundle bundle) {
            return view$AccessibilityDelegate.performAccessibilityAction(view, n, bundle);
        }
    }
}
