// 
// Decompiled by Procyon v0.6.0
// 

package androidx.customview.widget;

import androidx.core.view.accessibility.e;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewParent;
import java.util.List;
import java.util.ArrayList;
import android.view.accessibility.AccessibilityRecord;
import androidx.core.view.accessibility.f;
import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import androidx.core.view.b0;
import android.view.accessibility.AccessibilityManager;
import android.view.View;
import androidx.collection.h;
import androidx.core.view.accessibility.d;
import android.graphics.Rect;

public abstract class a extends androidx.core.view.a
{
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS;
    private static final androidx.customview.widget.b.a<d> NODE_ADAPTER;
    private static final androidx.customview.widget.b.b<h<d>, d> SPARSE_VALUES_ADAPTER;
    int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private c mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;
    
    static {
        INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        NODE_ADAPTER = new androidx.customview.widget.b.a<d>() {
            @Override
            public /* bridge */ void a(final Object o, final Rect rect) {
                this.b((d)o, rect);
            }
            
            public void b(final d d, final Rect rect) {
                d.i(rect);
            }
        };
        SPARSE_VALUES_ADAPTER = new androidx.customview.widget.b.b<h<d>, d>() {
            @Override
            public /* bridge */ Object a(final Object o, final int n) {
                return this.c((h<d>)o, n);
            }
            
            @Override
            public /* bridge */ int b(final Object o) {
                return this.d((h<d>)o);
            }
            
            public d c(final h<d> h, final int n) {
                return h.r(n);
            }
            
            public int d(final h<d> h) {
                return h.q();
            }
        };
    }
    
    public a(final View mHost) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (mHost != null) {
            this.mHost = mHost;
            this.mManager = (AccessibilityManager)mHost.getContext().getSystemService("accessibility");
            mHost.setFocusable(true);
            if (b0.z(mHost) == 0) {
                b0.A0(mHost, 1);
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }
    
    private boolean clearAccessibilityFocus(final int n) {
        if (this.mAccessibilityFocusedVirtualViewId == n) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            this.sendEventForVirtualView(n, 65536);
            return true;
        }
        return false;
    }
    
    private boolean clickKeyboardFocusedVirtualView() {
        final int mKeyboardFocusedVirtualViewId = this.mKeyboardFocusedVirtualViewId;
        return mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE && this.onPerformActionForVirtualView(mKeyboardFocusedVirtualViewId, 16, null);
    }
    
    private AccessibilityEvent createEvent(final int n, final int n2) {
        if (n != -1) {
            return this.createEventForChild(n, n2);
        }
        return this.createEventForHost(n2);
    }
    
    private AccessibilityEvent createEventForChild(final int n, final int n2) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(n2);
        final d obtainAccessibilityNodeInfo = this.obtainAccessibilityNodeInfo(n);
        obtain.getText().add(obtainAccessibilityNodeInfo.q());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.n());
        obtain.setScrollable(obtainAccessibilityNodeInfo.B());
        obtain.setPassword(obtainAccessibilityNodeInfo.A());
        obtain.setEnabled(obtainAccessibilityNodeInfo.w());
        obtain.setChecked(obtainAccessibilityNodeInfo.u());
        this.onPopulateEventForVirtualView(n, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.l());
        f.c((AccessibilityRecord)obtain, this.mHost, n);
        obtain.setPackageName((CharSequence)this.mHost.getContext().getPackageName());
        return obtain;
    }
    
    private AccessibilityEvent createEventForHost(final int n) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(n);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }
    
    private d createNodeForChild(int i) {
        final d e = d.E();
        e.W(true);
        e.Y(true);
        e.Q("android.view.View");
        final Rect invalid_PARENT_BOUNDS = a.INVALID_PARENT_BOUNDS;
        e.M(invalid_PARENT_BOUNDS);
        e.N(invalid_PARENT_BOUNDS);
        e.g0(this.mHost);
        this.onPopulateNodeForVirtualView(i, e);
        if (e.q() == null && e.n() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        e.i(this.mTempParentRect);
        if (this.mTempParentRect.equals((Object)invalid_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        final int h = e.h();
        if ((h & 0x40) != 0x0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((h & 0x80) == 0x0) {
            e.e0(this.mHost.getContext().getPackageName());
            e.n0(this.mHost, i);
            if (this.mAccessibilityFocusedVirtualViewId == i) {
                e.K(true);
                e.a(128);
            }
            else {
                e.K(false);
                e.a(64);
            }
            final boolean b = this.mKeyboardFocusedVirtualViewId == i;
            if (b) {
                e.a(2);
            }
            else if (e.x()) {
                e.a(1);
            }
            e.Z(b);
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            e.j(this.mTempScreenRect);
            if (this.mTempScreenRect.equals((Object)invalid_PARENT_BOUNDS)) {
                e.i(this.mTempScreenRect);
                if (e.b != -1) {
                    d e2;
                    Rect mTempScreenRect;
                    Rect mTempParentRect;
                    for (e2 = d.E(), i = e.b; i != -1; i = e2.b) {
                        e2.h0(this.mHost, -1);
                        e2.M(a.INVALID_PARENT_BOUNDS);
                        this.onPopulateNodeForVirtualView(i, e2);
                        e2.i(this.mTempParentRect);
                        mTempScreenRect = this.mTempScreenRect;
                        mTempParentRect = this.mTempParentRect;
                        mTempScreenRect.offset(mTempParentRect.left, mTempParentRect.top);
                    }
                    e2.I();
                }
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            }
            if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                    e.N(this.mTempScreenRect);
                    if (this.isVisibleToUser(this.mTempScreenRect)) {
                        e.r0(true);
                    }
                }
            }
            return e;
        }
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    
    private d createNodeForHost() {
        final d f = d.F(this.mHost);
        b0.c0(this.mHost, f);
        final ArrayList list = new ArrayList();
        this.getVisibleVirtualViews(list);
        if (f.k() > 0 && list.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        for (int i = 0; i < list.size(); ++i) {
            f.c(this.mHost, (int)list.get(i));
        }
        return f;
    }
    
    private h<d> getAllNodes() {
        final ArrayList list = new ArrayList();
        this.getVisibleVirtualViews(list);
        final h h = new h();
        for (int i = 0; i < list.size(); ++i) {
            h.n((int)list.get(i), this.createNodeForChild((int)list.get(i)));
        }
        return h;
    }
    
    private void getBoundsInParent(final int n, final Rect rect) {
        this.obtainAccessibilityNodeInfo(n).i(rect);
    }
    
    private static Rect guessPreviouslyFocusedRect(final View view, final int n, final Rect rect) {
        final int width = view.getWidth();
        final int height = view.getHeight();
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect.set(0, -1, width, -1);
                }
                else {
                    rect.set(-1, 0, -1, height);
                }
            }
            else {
                rect.set(0, height, width, height);
            }
        }
        else {
            rect.set(width, 0, width, height);
        }
        return rect;
    }
    
    private boolean isVisibleToUser(final Rect rect) {
        boolean b2;
        final boolean b = b2 = false;
        if (rect != null) {
            if (rect.isEmpty()) {
                b2 = b;
            }
            else {
                if (this.mHost.getWindowVisibility() != 0) {
                    return false;
                }
                ViewParent viewParent;
                View view;
                for (viewParent = this.mHost.getParent(); viewParent instanceof View; viewParent = view.getParent()) {
                    view = (View)viewParent;
                    if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                        return false;
                    }
                }
                b2 = b;
                if (viewParent != null) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    private static int keyToDirection(final int n) {
        if (n == 19) {
            return 33;
        }
        if (n == 21) {
            return 17;
        }
        if (n != 22) {
            return 130;
        }
        return 66;
    }
    
    private boolean moveFocus(int m, final Rect rect) {
        final h<d> allNodes = this.getAllNodes();
        final int mKeyboardFocusedVirtualViewId = this.mKeyboardFocusedVirtualViewId;
        final int n = Integer.MIN_VALUE;
        d d;
        if (mKeyboardFocusedVirtualViewId == Integer.MIN_VALUE) {
            d = null;
        }
        else {
            d = allNodes.g(mKeyboardFocusedVirtualViewId);
        }
        d d2;
        if (m != 1 && m != 2) {
            if (m != 17 && m != 33 && m != 66 && m != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            final Rect rect2 = new Rect();
            final int mKeyboardFocusedVirtualViewId2 = this.mKeyboardFocusedVirtualViewId;
            if (mKeyboardFocusedVirtualViewId2 != Integer.MIN_VALUE) {
                this.getBoundsInParent(mKeyboardFocusedVirtualViewId2, rect2);
            }
            else if (rect != null) {
                rect2.set(rect);
            }
            else {
                guessPreviouslyFocusedRect(this.mHost, m, rect2);
            }
            d2 = androidx.customview.widget.b.c((h)allNodes, (androidx.customview.widget.b.b<h, d>)a.SPARSE_VALUES_ADAPTER, a.NODE_ADAPTER, d, rect2, m);
        }
        else {
            d2 = androidx.customview.widget.b.d((h)allNodes, (androidx.customview.widget.b.b<h, d>)a.SPARSE_VALUES_ADAPTER, a.NODE_ADAPTER, d, m, b0.B(this.mHost) == 1, false);
        }
        if (d2 == null) {
            m = n;
        }
        else {
            m = allNodes.m(allNodes.j(d2));
        }
        return this.requestKeyboardFocusForVirtualView(m);
    }
    
    private boolean performActionForChild(final int n, final int n2, final Bundle bundle) {
        if (n2 == 1) {
            return this.requestKeyboardFocusForVirtualView(n);
        }
        if (n2 == 2) {
            return this.clearKeyboardFocusForVirtualView(n);
        }
        if (n2 == 64) {
            return this.requestAccessibilityFocus(n);
        }
        if (n2 != 128) {
            return this.onPerformActionForVirtualView(n, n2, bundle);
        }
        return this.clearAccessibilityFocus(n);
    }
    
    private boolean performActionForHost(final int n, final Bundle bundle) {
        return b0.e0(this.mHost, n, bundle);
    }
    
    private boolean requestAccessibilityFocus(final int mAccessibilityFocusedVirtualViewId) {
        if (this.mManager.isEnabled()) {
            if (this.mManager.isTouchExplorationEnabled()) {
                final int mAccessibilityFocusedVirtualViewId2 = this.mAccessibilityFocusedVirtualViewId;
                if (mAccessibilityFocusedVirtualViewId2 != mAccessibilityFocusedVirtualViewId) {
                    if (mAccessibilityFocusedVirtualViewId2 != Integer.MIN_VALUE) {
                        this.clearAccessibilityFocus(mAccessibilityFocusedVirtualViewId2);
                    }
                    this.mAccessibilityFocusedVirtualViewId = mAccessibilityFocusedVirtualViewId;
                    this.mHost.invalidate();
                    this.sendEventForVirtualView(mAccessibilityFocusedVirtualViewId, 32768);
                    return true;
                }
            }
        }
        return false;
    }
    
    private void updateHoveredVirtualView(final int mHoveredVirtualViewId) {
        final int mHoveredVirtualViewId2 = this.mHoveredVirtualViewId;
        if (mHoveredVirtualViewId2 == mHoveredVirtualViewId) {
            return;
        }
        this.sendEventForVirtualView(this.mHoveredVirtualViewId = mHoveredVirtualViewId, 128);
        this.sendEventForVirtualView(mHoveredVirtualViewId2, 256);
    }
    
    public final boolean clearKeyboardFocusForVirtualView(final int n) {
        if (this.mKeyboardFocusedVirtualViewId != n) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.onVirtualViewKeyboardFocusChanged(n, false);
        this.sendEventForVirtualView(n, 8);
        return true;
    }
    
    public final boolean dispatchHoverEvent(final MotionEvent motionEvent) {
        final boolean enabled = this.mManager.isEnabled();
        boolean b2;
        final boolean b = b2 = false;
        if (enabled) {
            if (!this.mManager.isTouchExplorationEnabled()) {
                b2 = b;
            }
            else {
                final int action = motionEvent.getAction();
                if (action != 7 && action != 9) {
                    if (action != 10) {
                        return false;
                    }
                    if (this.mHoveredVirtualViewId != Integer.MIN_VALUE) {
                        this.updateHoveredVirtualView(Integer.MIN_VALUE);
                        return true;
                    }
                    return false;
                }
                else {
                    final int virtualView = this.getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                    this.updateHoveredVirtualView(virtualView);
                    b2 = b;
                    if (virtualView != Integer.MIN_VALUE) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    public final boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final int action = keyEvent.getAction();
        final boolean b = false;
        int n = 0;
        boolean b2 = b;
        if (action != 1) {
            final int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        default: {
                            b2 = b;
                            return b2;
                        }
                        case 19:
                        case 20:
                        case 21:
                        case 22: {
                            b2 = b;
                            if (keyEvent.hasNoModifiers()) {
                                final int keyToDirection = keyToDirection(keyCode);
                                final int repeatCount = keyEvent.getRepeatCount();
                                b2 = false;
                                while (n < repeatCount + 1 && this.moveFocus(keyToDirection, null)) {
                                    ++n;
                                    b2 = true;
                                }
                                return b2;
                            }
                            return b2;
                        }
                        case 23: {
                            break;
                        }
                    }
                }
                b2 = b;
                if (keyEvent.hasNoModifiers()) {
                    b2 = b;
                    if (keyEvent.getRepeatCount() == 0) {
                        this.clickKeyboardFocusedVirtualView();
                        b2 = true;
                    }
                }
            }
            else if (keyEvent.hasNoModifiers()) {
                b2 = this.moveFocus(2, null);
            }
            else {
                b2 = b;
                if (keyEvent.hasModifiers(1)) {
                    b2 = this.moveFocus(1, null);
                }
            }
        }
        return b2;
    }
    
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }
    
    @Override
    public e getAccessibilityNodeProvider(final View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new c();
        }
        return this.mNodeProvider;
    }
    
    @Deprecated
    public int getFocusedVirtualView() {
        return this.getAccessibilityFocusedVirtualViewId();
    }
    
    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }
    
    protected abstract int getVirtualViewAt(final float p0, final float p1);
    
    protected abstract void getVisibleVirtualViews(final List<Integer> p0);
    
    public final void invalidateRoot() {
        this.invalidateVirtualView(-1, 1);
    }
    
    public final void invalidateVirtualView(final int n) {
        this.invalidateVirtualView(n, 0);
    }
    
    public final void invalidateVirtualView(final int n, final int n2) {
        if (n != Integer.MIN_VALUE && this.mManager.isEnabled()) {
            final ViewParent parent = this.mHost.getParent();
            if (parent != null) {
                final AccessibilityEvent event = this.createEvent(n, 2048);
                androidx.core.view.accessibility.b.b(event, n2);
                parent.requestSendAccessibilityEvent(this.mHost, event);
            }
        }
    }
    
    d obtainAccessibilityNodeInfo(final int n) {
        if (n == -1) {
            return this.createNodeForHost();
        }
        return this.createNodeForChild(n);
    }
    
    public final void onFocusChanged(final boolean b, final int n, final Rect rect) {
        final int mKeyboardFocusedVirtualViewId = this.mKeyboardFocusedVirtualViewId;
        if (mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            this.clearKeyboardFocusForVirtualView(mKeyboardFocusedVirtualViewId);
        }
        if (b) {
            this.moveFocus(n, rect);
        }
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        this.onPopulateEventForHost(accessibilityEvent);
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final View view, final d d) {
        super.onInitializeAccessibilityNodeInfo(view, d);
        this.onPopulateNodeForHost(d);
    }
    
    protected abstract boolean onPerformActionForVirtualView(final int p0, final int p1, final Bundle p2);
    
    protected void onPopulateEventForHost(final AccessibilityEvent accessibilityEvent) {
    }
    
    protected void onPopulateEventForVirtualView(final int n, final AccessibilityEvent accessibilityEvent) {
    }
    
    protected void onPopulateNodeForHost(final d d) {
    }
    
    protected abstract void onPopulateNodeForVirtualView(final int p0, final d p1);
    
    protected void onVirtualViewKeyboardFocusChanged(final int n, final boolean b) {
    }
    
    boolean performAction(final int n, final int n2, final Bundle bundle) {
        if (n != -1) {
            return this.performActionForChild(n, n2, bundle);
        }
        return this.performActionForHost(n2, bundle);
    }
    
    public final boolean requestKeyboardFocusForVirtualView(final int mKeyboardFocusedVirtualViewId) {
        if (!this.mHost.isFocused() && !this.mHost.requestFocus()) {
            return false;
        }
        final int mKeyboardFocusedVirtualViewId2 = this.mKeyboardFocusedVirtualViewId;
        if (mKeyboardFocusedVirtualViewId2 == mKeyboardFocusedVirtualViewId) {
            return false;
        }
        if (mKeyboardFocusedVirtualViewId2 != Integer.MIN_VALUE) {
            this.clearKeyboardFocusForVirtualView(mKeyboardFocusedVirtualViewId2);
        }
        if (mKeyboardFocusedVirtualViewId == Integer.MIN_VALUE) {
            return false;
        }
        this.onVirtualViewKeyboardFocusChanged(this.mKeyboardFocusedVirtualViewId = mKeyboardFocusedVirtualViewId, true);
        this.sendEventForVirtualView(mKeyboardFocusedVirtualViewId, 8);
        return true;
    }
    
    public final boolean sendEventForVirtualView(final int n, final int n2) {
        if (n != Integer.MIN_VALUE && this.mManager.isEnabled()) {
            final ViewParent parent = this.mHost.getParent();
            return parent != null && parent.requestSendAccessibilityEvent(this.mHost, this.createEvent(n, n2));
        }
        return false;
    }
    
    private class c extends e
    {
        final a b;
        
        c(final a b) {
            this.b = b;
        }
        
        @Override
        public d b(final int n) {
            return d.G(this.b.obtainAccessibilityNodeInfo(n));
        }
        
        @Override
        public d d(int n) {
            if (n == 2) {
                n = this.b.mAccessibilityFocusedVirtualViewId;
            }
            else {
                n = this.b.mKeyboardFocusedVirtualViewId;
            }
            if (n == Integer.MIN_VALUE) {
                return null;
            }
            return this.b(n);
        }
        
        @Override
        public boolean f(final int n, final int n2, final Bundle bundle) {
            return this.b.performAction(n, n2, bundle);
        }
    }
}
