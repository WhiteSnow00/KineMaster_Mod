// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.KeyEvent$DispatcherState;
import android.view.Window;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.view.WindowManager$LayoutParams;
import android.view.View;
import android.os.IBinder;
import androidx.appcompat.app.c;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnKeyListener;

class h implements DialogInterface$OnKeyListener, DialogInterface$OnClickListener, DialogInterface$OnDismissListener, a
{
    private g a;
    private c b;
    e c;
    private a d;
    
    public h(final g a) {
        this.a = a;
    }
    
    public void a() {
        final c b = this.b;
        if (b != null) {
            b.dismiss();
        }
    }
    
    public void b(final g g, final boolean b) {
        if (b || g == this.a) {
            this.a();
        }
        final a d = this.d;
        if (d != null) {
            d.b(g, b);
        }
    }
    
    public boolean c(final g g) {
        final a d = this.d;
        return d != null && d.c(g);
    }
    
    public void d(final IBinder token) {
        final g a = this.a;
        final c.a a2 = new c.a(a.w());
        (this.c = new e(a2.getContext(), d.g.j)).d(this);
        this.a.b(this.c);
        a2.a(this.c.a(), (DialogInterface$OnClickListener)this);
        final View a3 = a.A();
        if (a3 != null) {
            a2.b(a3);
        }
        else {
            a2.c(a.y()).setTitle(a.z());
        }
        a2.h((DialogInterface$OnKeyListener)this);
        (this.b = a2.create()).setOnDismissListener((DialogInterface$OnDismissListener)this);
        final WindowManager$LayoutParams attributes = this.b.getWindow().getAttributes();
        attributes.type = 1003;
        if (token != null) {
            attributes.token = token;
        }
        attributes.flags |= 0x20000;
        this.b.show();
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.N((MenuItem)this.c.a().getItem(n), 0);
    }
    
    public void onDismiss(final DialogInterface dialogInterface) {
        this.c.b(this.a, true);
    }
    
    public boolean onKey(final DialogInterface dialogInterface, final int n, final KeyEvent keyEvent) {
        if (n == 82 || n == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                final Window window = this.b.getWindow();
                if (window != null) {
                    final View decorView = window.getDecorView();
                    if (decorView != null) {
                        final KeyEvent$DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, (Object)this);
                            return true;
                        }
                    }
                }
            }
            else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                final Window window2 = this.b.getWindow();
                if (window2 != null) {
                    final View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        final KeyEvent$DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.a.e(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.a.performShortcut(n, keyEvent, 0);
    }
}
