// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.view.View;
import androidx.core.view.b0;
import android.content.Context;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import android.view.Menu;
import androidx.appcompat.widget.t0;
import androidx.core.util.h;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import android.view.Window$Callback;
import androidx.appcompat.widget.z;

class l extends a
{
    final z a;
    final Window$Callback b;
    final AppCompatDelegateImpl.g c;
    boolean d;
    private boolean e;
    private boolean f;
    private ArrayList<b> g;
    private final Runnable h;
    private final Toolbar.f i;
    
    l(final Toolbar toolbar, final CharSequence windowTitle, final Window$Callback windowCallback) {
        this.g = new ArrayList<b>();
        this.h = new Runnable() {
            final l a;
            
            @Override
            public void run() {
                this.a.w();
            }
        };
        final Toolbar.f f = new Toolbar.f() {
            final l a;
            
            @Override
            public boolean onMenuItemClick(final MenuItem menuItem) {
                return this.a.b.onMenuItemSelected(0, menuItem);
            }
        };
        this.i = f;
        androidx.core.util.h.g(toolbar);
        final t0 a = new t0(toolbar, false);
        this.a = a;
        this.b = androidx.core.util.h.g(windowCallback);
        a.setWindowCallback(windowCallback);
        toolbar.setOnMenuItemClickListener((Toolbar.f)f);
        a.setWindowTitle(windowTitle);
        this.c = new e();
    }
    
    private Menu v() {
        if (!this.e) {
            this.a.t(new c(), new d());
            this.e = true;
        }
        return this.a.j();
    }
    
    @Override
    public boolean f() {
        return this.a.b();
    }
    
    @Override
    public boolean g() {
        if (this.a.h()) {
            this.a.collapseActionView();
            return true;
        }
        return false;
    }
    
    @Override
    public void h(final boolean f) {
        if (f == this.f) {
            return;
        }
        this.f = f;
        for (int size = this.g.size(), i = 0; i < size; ++i) {
            this.g.get(i).a(f);
        }
    }
    
    @Override
    public int i() {
        return this.a.v();
    }
    
    @Override
    public Context j() {
        return this.a.getContext();
    }
    
    @Override
    public boolean k() {
        this.a.m().removeCallbacks(this.h);
        b0.h0((View)this.a.m(), this.h);
        return true;
    }
    
    @Override
    public void l(final Configuration configuration) {
        super.l(configuration);
    }
    
    @Override
    void m() {
        this.a.m().removeCallbacks(this.h);
    }
    
    @Override
    public boolean n(final int n, final KeyEvent keyEvent) {
        final Menu v = this.v();
        if (v != null) {
            int deviceId;
            if (keyEvent != null) {
                deviceId = keyEvent.getDeviceId();
            }
            else {
                deviceId = -1;
            }
            final int keyboardType = KeyCharacterMap.load(deviceId).getKeyboardType();
            boolean qwertyMode = true;
            if (keyboardType == 1) {
                qwertyMode = false;
            }
            v.setQwertyMode(qwertyMode);
            return v.performShortcut(n, keyEvent, 0);
        }
        return false;
    }
    
    @Override
    public boolean o(final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            this.p();
        }
        return true;
    }
    
    @Override
    public boolean p() {
        return this.a.c();
    }
    
    @Override
    public void q(final boolean b) {
    }
    
    @Override
    public void r(final boolean b) {
        int n;
        if (b) {
            n = 8;
        }
        else {
            n = 0;
        }
        this.x(n, 8);
    }
    
    @Override
    public void s(final boolean b) {
    }
    
    @Override
    public void t(final CharSequence windowTitle) {
        this.a.setWindowTitle(windowTitle);
    }
    
    void w() {
        final Menu v = this.v();
        g g;
        if (v instanceof g) {
            g = (g)v;
        }
        else {
            g = null;
        }
        if (g != null) {
            g.h0();
        }
        try {
            v.clear();
            if (!this.b.onCreatePanelMenu(0, v) || !this.b.onPreparePanel(0, (View)null, v)) {
                v.clear();
            }
        }
        finally {
            if (g != null) {
                g.g0();
            }
        }
    }
    
    public void x(final int n, final int n2) {
        this.a.i((n & n2) | (~n2 & this.a.v()));
    }
    
    private final class c implements m.a
    {
        private boolean a;
        final l b;
        
        c(final l b) {
            this.b = b;
        }
        
        @Override
        public void b(final g g, final boolean b) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.b.a.q();
            this.b.b.onPanelClosed(108, (Menu)g);
            this.a = false;
        }
        
        @Override
        public boolean c(final g g) {
            this.b.b.onMenuOpened(108, (Menu)g);
            return true;
        }
    }
    
    private final class d implements g.a
    {
        final l a;
        
        d(final l a) {
            this.a = a;
        }
        
        @Override
        public boolean a(final g g, final MenuItem menuItem) {
            return false;
        }
        
        @Override
        public void b(final g g) {
            if (this.a.a.e()) {
                this.a.b.onPanelClosed(108, (Menu)g);
            }
            else if (this.a.b.onPreparePanel(0, (View)null, (Menu)g)) {
                this.a.b.onMenuOpened(108, (Menu)g);
            }
        }
    }
    
    private class e implements g
    {
        final l a;
        
        e(final l a) {
            this.a = a;
        }
        
        @Override
        public boolean a(final int n) {
            if (n == 0) {
                final l a = this.a;
                if (!a.d) {
                    a.a.f();
                    this.a.d = true;
                }
            }
            return false;
        }
        
        @Override
        public View onCreatePanelView(final int n) {
            if (n == 0) {
                return new View(this.a.a.getContext());
            }
            return null;
        }
    }
}
