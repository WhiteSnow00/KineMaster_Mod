// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view.accessibility;

import android.text.Spannable;
import android.util.Log;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.core.os.a;
import android.view.accessibility.AccessibilityNodeInfo$RangeInfo;
import java.util.Collections;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

public class d
{
    private final AccessibilityNodeInfo a;
    public int b;
    private int c;
    
    private d(final AccessibilityNodeInfo a) {
        this.b = -1;
        this.c = -1;
        this.a = a;
    }
    
    public static d E() {
        return t0(AccessibilityNodeInfo.obtain());
    }
    
    public static d F(final View view) {
        return t0(AccessibilityNodeInfo.obtain(view));
    }
    
    public static d G(final d d) {
        return t0(AccessibilityNodeInfo.obtain(d.a));
    }
    
    private void L(final int n, final boolean b) {
        final Bundle o = this.o();
        if (o != null) {
            final int int1 = o.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
            int n2;
            if (b) {
                n2 = n;
            }
            else {
                n2 = 0;
            }
            o.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", n2 | (int1 & ~n));
        }
    }
    
    private List<Integer> e(final String s) {
        ArrayList integerArrayList;
        if ((integerArrayList = this.a.getExtras().getIntegerArrayList(s)) == null) {
            integerArrayList = new ArrayList();
            this.a.getExtras().putIntegerArrayList(s, integerArrayList);
        }
        return integerArrayList;
    }
    
    private static String g(final int n) {
        if (n == 1) {
            return "ACTION_FOCUS";
        }
        if (n == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        switch (n) {
                            default: {
                                return "ACTION_UNKNOWN";
                            }
                            case 16908362: {
                                return "ACTION_PRESS_AND_HOLD";
                            }
                            case 16908361: {
                                return "ACTION_PAGE_RIGHT";
                            }
                            case 16908360: {
                                return "ACTION_PAGE_LEFT";
                            }
                            case 16908359: {
                                return "ACTION_PAGE_DOWN";
                            }
                            case 16908358: {
                                return "ACTION_PAGE_UP";
                            }
                            case 16908357: {
                                return "ACTION_HIDE_TOOLTIP";
                            }
                            case 16908356: {
                                return "ACTION_SHOW_TOOLTIP";
                            }
                        }
                        break;
                    }
                    case 16908349: {
                        return "ACTION_SET_PROGRESS";
                    }
                    case 16908348: {
                        return "ACTION_CONTEXT_CLICK";
                    }
                    case 16908347: {
                        return "ACTION_SCROLL_RIGHT";
                    }
                    case 16908346: {
                        return "ACTION_SCROLL_DOWN";
                    }
                    case 16908345: {
                        return "ACTION_SCROLL_LEFT";
                    }
                    case 16908344: {
                        return "ACTION_SCROLL_UP";
                    }
                    case 16908343: {
                        return "ACTION_SCROLL_TO_POSITION";
                    }
                    case 16908342: {
                        return "ACTION_SHOW_ON_SCREEN";
                    }
                }
                break;
            }
            case 16908372: {
                return "ACTION_IME_ENTER";
            }
            case 16908354: {
                return "ACTION_MOVE_WINDOW";
            }
            case 2097152: {
                return "ACTION_SET_TEXT";
            }
            case 524288: {
                return "ACTION_COLLAPSE";
            }
            case 262144: {
                return "ACTION_EXPAND";
            }
            case 131072: {
                return "ACTION_SET_SELECTION";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 4: {
                return "ACTION_SELECT";
            }
        }
    }
    
    public static ClickableSpan[] m(final CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[])((Spanned)charSequence).getSpans(0, charSequence.length(), (Class)ClickableSpan.class);
        }
        return null;
    }
    
    private boolean s() {
        return this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty() ^ true;
    }
    
    public static d t0(final AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }
    
    public boolean A() {
        return this.a.isPassword();
    }
    
    public boolean B() {
        return this.a.isScrollable();
    }
    
    public boolean C() {
        return this.a.isSelected();
    }
    
    public boolean D() {
        return this.a.isShowingHintText();
    }
    
    public boolean H(final int n, final Bundle bundle) {
        return this.a.performAction(n, bundle);
    }
    
    public void I() {
        this.a.recycle();
    }
    
    public boolean J(final a a) {
        return this.a.removeAction((AccessibilityNodeInfo$AccessibilityAction)a.a);
    }
    
    public void K(final boolean accessibilityFocused) {
        this.a.setAccessibilityFocused(accessibilityFocused);
    }
    
    @Deprecated
    public void M(final Rect boundsInParent) {
        this.a.setBoundsInParent(boundsInParent);
    }
    
    public void N(final Rect boundsInScreen) {
        this.a.setBoundsInScreen(boundsInScreen);
    }
    
    public void O(final boolean checkable) {
        this.a.setCheckable(checkable);
    }
    
    public void P(final boolean checked) {
        this.a.setChecked(checked);
    }
    
    public void Q(final CharSequence className) {
        this.a.setClassName(className);
    }
    
    public void R(final boolean clickable) {
        this.a.setClickable(clickable);
    }
    
    public void S(final Object o) {
        final AccessibilityNodeInfo a = this.a;
        AccessibilityNodeInfo$CollectionInfo collectionInfo;
        if (o == null) {
            collectionInfo = null;
        }
        else {
            collectionInfo = (AccessibilityNodeInfo$CollectionInfo)((b)o).a;
        }
        a.setCollectionInfo(collectionInfo);
    }
    
    public void T(final Object o) {
        final AccessibilityNodeInfo a = this.a;
        AccessibilityNodeInfo$CollectionItemInfo collectionItemInfo;
        if (o == null) {
            collectionItemInfo = null;
        }
        else {
            collectionItemInfo = (AccessibilityNodeInfo$CollectionItemInfo)((c)o).a;
        }
        a.setCollectionItemInfo(collectionItemInfo);
    }
    
    public void U(final CharSequence contentDescription) {
        this.a.setContentDescription(contentDescription);
    }
    
    public void V(final boolean dismissable) {
        this.a.setDismissable(dismissable);
    }
    
    public void W(final boolean enabled) {
        this.a.setEnabled(enabled);
    }
    
    public void X(final CharSequence error) {
        this.a.setError(error);
    }
    
    public void Y(final boolean focusable) {
        this.a.setFocusable(focusable);
    }
    
    public void Z(final boolean focused) {
        this.a.setFocused(focused);
    }
    
    public void a(final int n) {
        this.a.addAction(n);
    }
    
    public void a0(final boolean heading) {
        if (Build$VERSION.SDK_INT >= 28) {
            this.a.setHeading(heading);
        }
        else {
            this.L(2, heading);
        }
    }
    
    public void b(final a a) {
        this.a.addAction((AccessibilityNodeInfo$AccessibilityAction)a.a);
    }
    
    public void b0(final CharSequence hintText) {
        this.a.setHintText(hintText);
    }
    
    public void c(final View view, final int n) {
        this.a.addChild(view, n);
    }
    
    public void c0(final View labelFor) {
        this.a.setLabelFor(labelFor);
    }
    
    public void d(final CharSequence charSequence, final View view) {
    }
    
    public void d0(final int maxTextLength) {
        this.a.setMaxTextLength(maxTextLength);
    }
    
    public void e0(final CharSequence packageName) {
        this.a.setPackageName(packageName);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof d)) {
            return false;
        }
        final d d = (d)o;
        final AccessibilityNodeInfo a = this.a;
        if (a == null) {
            if (d.a != null) {
                return false;
            }
        }
        else if (!a.equals((Object)d.a)) {
            return false;
        }
        return this.c == d.c && this.b == d.b;
    }
    
    public List<a> f() {
        final List actionList = this.a.getActionList();
        if (actionList != null) {
            final ArrayList list = new ArrayList();
            for (int size = actionList.size(), i = 0; i < size; ++i) {
                list.add(new a(actionList.get(i)));
            }
            return list;
        }
        return Collections.emptyList();
    }
    
    public void f0(final CharSequence paneTitle) {
        if (Build$VERSION.SDK_INT >= 28) {
            this.a.setPaneTitle(paneTitle);
        }
        else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paneTitle);
        }
    }
    
    public void g0(final View parent) {
        this.b = -1;
        this.a.setParent(parent);
    }
    
    public int h() {
        return this.a.getActions();
    }
    
    public void h0(final View view, final int b) {
        this.b = b;
        this.a.setParent(view, b);
    }
    
    @Override
    public int hashCode() {
        final AccessibilityNodeInfo a = this.a;
        int hashCode;
        if (a == null) {
            hashCode = 0;
        }
        else {
            hashCode = a.hashCode();
        }
        return hashCode;
    }
    
    @Deprecated
    public void i(final Rect rect) {
        this.a.getBoundsInParent(rect);
    }
    
    public void i0(final d d) {
        this.a.setRangeInfo((AccessibilityNodeInfo$RangeInfo)d.a);
    }
    
    public void j(final Rect rect) {
        this.a.getBoundsInScreen(rect);
    }
    
    public void j0(final CharSequence charSequence) {
        this.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }
    
    public int k() {
        return this.a.getChildCount();
    }
    
    public void k0(final boolean screenReaderFocusable) {
        if (Build$VERSION.SDK_INT >= 28) {
            this.a.setScreenReaderFocusable(screenReaderFocusable);
        }
        else {
            this.L(1, screenReaderFocusable);
        }
    }
    
    public CharSequence l() {
        return this.a.getClassName();
    }
    
    public void l0(final boolean scrollable) {
        this.a.setScrollable(scrollable);
    }
    
    public void m0(final boolean showingHintText) {
        this.a.setShowingHintText(showingHintText);
    }
    
    public CharSequence n() {
        return this.a.getContentDescription();
    }
    
    public void n0(final View view, final int c) {
        this.c = c;
        this.a.setSource(view, c);
    }
    
    public Bundle o() {
        return this.a.getExtras();
    }
    
    public void o0(final CharSequence stateDescription) {
        if (androidx.core.os.a.b()) {
            this.a.setStateDescription(stateDescription);
        }
        else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", stateDescription);
        }
    }
    
    public CharSequence p() {
        return this.a.getPackageName();
    }
    
    public void p0(final CharSequence text) {
        this.a.setText(text);
    }
    
    public CharSequence q() {
        if (this.s()) {
            final List<Integer> e = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            final List<Integer> e2 = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            final List<Integer> e3 = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            final List<Integer> e4 = this.e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            final CharSequence text = this.a.getText();
            final int length = this.a.getText().length();
            int i = 0;
            final SpannableString spannableString = new SpannableString((CharSequence)TextUtils.substring(text, 0, length));
            while (i < e.size()) {
                ((Spannable)spannableString).setSpan((Object)new androidx.core.view.accessibility.a(e4.get(i), this, this.o().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), (int)e.get(i), (int)e2.get(i), (int)e3.get(i));
                ++i;
            }
            return (CharSequence)spannableString;
        }
        return this.a.getText();
    }
    
    public void q0(final View traversalAfter) {
        this.a.setTraversalAfter(traversalAfter);
    }
    
    public String r() {
        return this.a.getViewIdResourceName();
    }
    
    public void r0(final boolean visibleToUser) {
        this.a.setVisibleToUser(visibleToUser);
    }
    
    public AccessibilityNodeInfo s0() {
        return this.a;
    }
    
    public boolean t() {
        return this.a.isCheckable();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        final Rect rect = new Rect();
        this.i(rect);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("; boundsInParent: ");
        sb2.append(rect);
        sb.append(sb2.toString());
        this.j(rect);
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("; boundsInScreen: ");
        sb3.append(rect);
        sb.append(sb3.toString());
        sb.append("; packageName: ");
        sb.append(this.p());
        sb.append("; className: ");
        sb.append(this.l());
        sb.append("; text: ");
        sb.append(this.q());
        sb.append("; contentDescription: ");
        sb.append(this.n());
        sb.append("; viewId: ");
        sb.append(this.r());
        sb.append("; checkable: ");
        sb.append(this.t());
        sb.append("; checked: ");
        sb.append(this.u());
        sb.append("; focusable: ");
        sb.append(this.x());
        sb.append("; focused: ");
        sb.append(this.y());
        sb.append("; selected: ");
        sb.append(this.C());
        sb.append("; clickable: ");
        sb.append(this.v());
        sb.append("; longClickable: ");
        sb.append(this.z());
        sb.append("; enabled: ");
        sb.append(this.w());
        sb.append("; password: ");
        sb.append(this.A());
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("; scrollable: ");
        sb4.append(this.B());
        sb.append(sb4.toString());
        sb.append("; [");
        final List<a> f = this.f();
        for (int i = 0; i < f.size(); ++i) {
            final a a = f.get(i);
            String s2;
            final String s = s2 = g(a.b());
            if (s.equals("ACTION_UNKNOWN")) {
                s2 = s;
                if (a.c() != null) {
                    s2 = a.c().toString();
                }
            }
            sb.append(s2);
            if (i != f.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public boolean u() {
        return this.a.isChecked();
    }
    
    public boolean v() {
        return this.a.isClickable();
    }
    
    public boolean w() {
        return this.a.isEnabled();
    }
    
    public boolean x() {
        return this.a.isFocusable();
    }
    
    public boolean y() {
        return this.a.isFocused();
    }
    
    public boolean z() {
        return this.a.isLongClickable();
    }
    
    public static class a
    {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        public static final a s;
        public static final a t;
        public static final a u;
        public static final a v;
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object a;
        private final int b;
        private final Class<? extends g.a> c;
        protected final g d;
        
        static {
            final Object o2 = null;
            e = new a(1, null);
            f = new a(2, null);
            g = new a(4, null);
            h = new a(8, null);
            i = new a(16, null);
            j = new a(32, null);
            k = new a(64, null);
            l = new a(128, null);
            m = new a(256, null, g.b.class);
            n = new a(512, null, g.b.class);
            o = new a(1024, null, g.c.class);
            p = new a(2048, null, g.c.class);
            q = new a(4096, null);
            r = new a(8192, null);
            s = new a(16384, null);
            t = new a(32768, null);
            u = new a(65536, null);
            v = new a(131072, null, g.g.class);
            w = new a(262144, null);
            x = new a(524288, null);
            y = new a(1048576, null);
            z = new a(2097152, null, g.h.class);
            final int sdk_INT = Build$VERSION.SDK_INT;
            A = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
            B = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, g.e.class);
            C = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);
            D = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
            E = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);
            F = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
            AccessibilityNodeInfo$AccessibilityAction action_PAGE_UP;
            if (sdk_INT >= 29) {
                action_PAGE_UP = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_UP;
            }
            else {
                action_PAGE_UP = null;
            }
            G = new a(action_PAGE_UP, 16908358, null, null, null);
            AccessibilityNodeInfo$AccessibilityAction action_PAGE_DOWN;
            if (sdk_INT >= 29) {
                action_PAGE_DOWN = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_DOWN;
            }
            else {
                action_PAGE_DOWN = null;
            }
            H = new a(action_PAGE_DOWN, 16908359, null, null, null);
            AccessibilityNodeInfo$AccessibilityAction action_PAGE_LEFT;
            if (sdk_INT >= 29) {
                action_PAGE_LEFT = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_LEFT;
            }
            else {
                action_PAGE_LEFT = null;
            }
            I = new a(action_PAGE_LEFT, 16908360, null, null, null);
            AccessibilityNodeInfo$AccessibilityAction action_PAGE_RIGHT;
            if (sdk_INT >= 29) {
                action_PAGE_RIGHT = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_RIGHT;
            }
            else {
                action_PAGE_RIGHT = null;
            }
            J = new a(action_PAGE_RIGHT, 16908361, null, null, null);
            K = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
            L = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_SET_PROGRESS, 16908349, null, null, g.f.class);
            M = new a(AccessibilityNodeInfo$AccessibilityAction.ACTION_MOVE_WINDOW, 16908354, null, null, g.d.class);
            AccessibilityNodeInfo$AccessibilityAction action_SHOW_TOOLTIP;
            if (sdk_INT >= 28) {
                action_SHOW_TOOLTIP = AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_TOOLTIP;
            }
            else {
                action_SHOW_TOOLTIP = null;
            }
            N = new a(action_SHOW_TOOLTIP, 16908356, null, null, null);
            AccessibilityNodeInfo$AccessibilityAction action_HIDE_TOOLTIP;
            if (sdk_INT >= 28) {
                action_HIDE_TOOLTIP = AccessibilityNodeInfo$AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            else {
                action_HIDE_TOOLTIP = null;
            }
            O = new a(action_HIDE_TOOLTIP, 16908357, null, null, null);
            AccessibilityNodeInfo$AccessibilityAction action_PRESS_AND_HOLD;
            if (sdk_INT >= 30) {
                action_PRESS_AND_HOLD = AccessibilityNodeInfo$AccessibilityAction.ACTION_PRESS_AND_HOLD;
            }
            else {
                action_PRESS_AND_HOLD = null;
            }
            P = new a(action_PRESS_AND_HOLD, 16908362, null, null, null);
            Object action_IME_ENTER = o2;
            if (sdk_INT >= 30) {
                action_IME_ENTER = AccessibilityNodeInfo$AccessibilityAction.ACTION_IME_ENTER;
            }
            Q = new a(action_IME_ENTER, 16908372, null, null, null);
        }
        
        public a(final int n, final CharSequence charSequence) {
            this(null, n, charSequence, null, null);
        }
        
        public a(final int n, final CharSequence charSequence, final g g) {
            this(null, n, charSequence, g, null);
        }
        
        private a(final int n, final CharSequence charSequence, final Class<? extends g.a> clazz) {
            this(null, n, charSequence, null, clazz);
        }
        
        a(final Object o) {
            this(o, 0, null, null, null);
        }
        
        a(final Object a, final int b, final CharSequence charSequence, final g d, final Class<? extends g.a> c) {
            this.b = b;
            this.d = d;
            if (a == null) {
                this.a = new AccessibilityNodeInfo$AccessibilityAction(b, charSequence);
            }
            else {
                this.a = a;
            }
            this.c = c;
        }
        
        public a a(final CharSequence charSequence, final g g) {
            return new a(null, this.b, charSequence, g, this.c);
        }
        
        public int b() {
            return ((AccessibilityNodeInfo$AccessibilityAction)this.a).getId();
        }
        
        public CharSequence c() {
            return ((AccessibilityNodeInfo$AccessibilityAction)this.a).getLabel();
        }
        
        public boolean d(final View view, final Bundle bundle) {
            if (this.d != null) {
                Object o = null;
                final Exception ex = null;
                final Class<? extends g.a> c = this.c;
                if (c != null) {
                    Object o2;
                    Exception ex2 = null;
                    try {
                        o = (g.a)c.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
                        try {
                            ((g.a)o).a(bundle);
                        }
                        catch (final Exception ex) {
                            o2 = o;
                            ex2 = ex;
                        }
                    }
                    catch (final Exception ex2) {
                        o2 = ex;
                    }
                    final Class<? extends g.a> c2 = this.c;
                    String name;
                    if (c2 == null) {
                        name = "null";
                    }
                    else {
                        name = c2.getName();
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to execute command with argument class ViewCommandArgument: ");
                    sb.append(name);
                    Log.e("A11yActionCompat", sb.toString(), (Throwable)ex2);
                    o = o2;
                }
                return this.d.a(view, (g.a)o);
            }
            return false;
        }
        
        @Override
        public boolean equals(Object a) {
            if (a == null) {
                return false;
            }
            if (!(a instanceof a)) {
                return false;
            }
            final a a2 = (a)a;
            a = this.a;
            if (a == null) {
                if (a2.a != null) {
                    return false;
                }
            }
            else if (!a.equals(a2.a)) {
                return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            final Object a = this.a;
            int hashCode;
            if (a != null) {
                hashCode = a.hashCode();
            }
            else {
                hashCode = 0;
            }
            return hashCode;
        }
    }
    
    public static class b
    {
        final Object a;
        
        b(final Object a) {
            this.a = a;
        }
        
        public static b a(final int n, final int n2, final boolean b, final int n3) {
            return new b(AccessibilityNodeInfo$CollectionInfo.obtain(n, n2, b, n3));
        }
    }
    
    public static class c
    {
        final Object a;
        
        c(final Object a) {
            this.a = a;
        }
        
        public static c a(final int n, final int n2, final int n3, final int n4, final boolean b, final boolean b2) {
            return new c(AccessibilityNodeInfo$CollectionItemInfo.obtain(n, n2, n3, n4, b, b2));
        }
    }
    
    public static class d
    {
        final Object a;
        
        d(final Object a) {
            this.a = a;
        }
        
        public static d a(final int n, final float n2, final float n3, final float n4) {
            return new d(AccessibilityNodeInfo$RangeInfo.obtain(n, n2, n3, n4));
        }
    }
}
