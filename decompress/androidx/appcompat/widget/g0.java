// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.view.menu.ListMenuItemView;
import android.view.KeyEvent;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.f;
import android.widget.HeaderViewListAdapter;
import android.view.MotionEvent;
import android.view.MenuItem;
import androidx.appcompat.view.menu.g;
import android.transition.Transition;
import android.util.AttributeSet;
import android.content.Context;
import android.util.Log;
import android.widget.PopupWindow;
import android.os.Build$VERSION;
import java.lang.reflect.Method;

public class g0 extends e0 implements f0
{
    private static Method U;
    private f0 T;
    
    static {
        try {
            if (Build$VERSION.SDK_INT <= 28) {
                g0.U = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        }
        catch (final NoSuchMethodException ex) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }
    
    public g0(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
    }
    
    public void Q(final Object o) {
        a.a(super.Q, (Transition)o);
    }
    
    public void R(final Object o) {
        a.b(super.Q, (Transition)o);
    }
    
    public void S(final f0 t) {
        this.T = t;
    }
    
    public void T(final boolean b) {
        if (Build$VERSION.SDK_INT <= 28) {
            final Method u = g0.U;
            if (u != null) {
                try {
                    u.invoke(super.Q, b);
                }
                catch (final Exception ex) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        }
        else {
            g0.b.a(super.Q, b);
        }
    }
    
    @Override
    public void d(final androidx.appcompat.view.menu.g g, final MenuItem menuItem) {
        final f0 t = this.T;
        if (t != null) {
            t.d(g, menuItem);
        }
    }
    
    @Override
    public void n(final androidx.appcompat.view.menu.g g, final MenuItem menuItem) {
        final f0 t = this.T;
        if (t != null) {
            t.n(g, menuItem);
        }
    }
    
    @Override
    b0 r(final Context context, final boolean b) {
        final c c = new c(context, b);
        c.setHoverListener(this);
        return c;
    }
    
    static class a
    {
        static void a(final PopupWindow popupWindow, final Transition enterTransition) {
            popupWindow.setEnterTransition(enterTransition);
        }
        
        static void b(final PopupWindow popupWindow, final Transition exitTransition) {
            popupWindow.setExitTransition(exitTransition);
        }
    }
    
    static class b
    {
        static void a(final PopupWindow popupWindow, final boolean touchModal) {
            popupWindow.setTouchModal(touchModal);
        }
    }
    
    public static class c extends b0
    {
        final int A;
        private f0 B;
        private MenuItem C;
        final int z;
        
        public c(final Context context, final boolean b) {
            super(context, b);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.z = 21;
                this.A = 22;
            }
            else {
                this.z = 22;
                this.A = 21;
            }
        }
        
        @Override
        public /* bridge */ int d(final int n, final int n2, final int n3, final int n4, final int n5) {
            return super.d(n, n2, n3, n4, n5);
        }
        
        @Override
        public /* bridge */ boolean e(final MotionEvent motionEvent, final int n) {
            return super.e(motionEvent, n);
        }
        
        @Override
        public /* bridge */ boolean hasFocus() {
            return super.hasFocus();
        }
        
        @Override
        public /* bridge */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }
        
        @Override
        public /* bridge */ boolean isFocused() {
            return super.isFocused();
        }
        
        @Override
        public /* bridge */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }
        
        @Override
        public boolean onHoverEvent(final MotionEvent motionEvent) {
            if (this.B != null) {
                final ListAdapter adapter = this.getAdapter();
                int headersCount;
                androidx.appcompat.view.menu.f f;
                if (adapter instanceof HeaderViewListAdapter) {
                    final HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter)adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    f = (androidx.appcompat.view.menu.f)headerViewListAdapter.getWrappedAdapter();
                }
                else {
                    headersCount = 0;
                    f = (androidx.appcompat.view.menu.f)adapter;
                }
                Object c;
                final Object o = c = null;
                if (motionEvent.getAction() != 10) {
                    final int pointToPosition = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
                    c = o;
                    if (pointToPosition != -1) {
                        final int n = pointToPosition - headersCount;
                        c = o;
                        if (n >= 0) {
                            c = o;
                            if (n < f.getCount()) {
                                c = f.c(n);
                            }
                        }
                    }
                }
                final MenuItem c2 = this.C;
                if (c2 != c) {
                    final androidx.appcompat.view.menu.g b = f.b();
                    if (c2 != null) {
                        this.B.n(b, c2);
                    }
                    if ((this.C = (MenuItem)c) != null) {
                        this.B.d(b, (MenuItem)c);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
        
        public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
            final ListMenuItemView listMenuItemView = (ListMenuItemView)this.getSelectedView();
            if (listMenuItemView != null && n == this.z) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    this.performItemClick((View)listMenuItemView, this.getSelectedItemPosition(), this.getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && n == this.A) {
                this.setSelection(-1);
                final ListAdapter adapter = this.getAdapter();
                androidx.appcompat.view.menu.f f;
                if (adapter instanceof HeaderViewListAdapter) {
                    f = (androidx.appcompat.view.menu.f)((HeaderViewListAdapter)adapter).getWrappedAdapter();
                }
                else {
                    f = (androidx.appcompat.view.menu.f)adapter;
                }
                f.b().e(false);
                return true;
            }
            return super.onKeyDown(n, keyEvent);
        }
        
        @Override
        public /* bridge */ boolean onTouchEvent(final MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }
        
        public void setHoverListener(final f0 b) {
            this.B = b;
        }
        
        @Override
        public /* bridge */ void setSelector(final Drawable selector) {
            super.setSelector(selector);
        }
        
        static class a
        {
            static int a(final Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }
    }
}
