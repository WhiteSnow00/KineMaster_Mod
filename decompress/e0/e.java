// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import android.view.KeyEvent;
import android.text.Editable;
import android.view.View;
import android.text.method.KeyListener;

final class e implements KeyListener
{
    private final KeyListener a;
    private final a b;
    
    e(final KeyListener keyListener) {
        this(keyListener, new a());
    }
    
    e(final KeyListener a, final a b) {
        this.a = a;
        this.b = b;
    }
    
    public void clearMetaKeyState(final View view, final Editable editable, final int n) {
        this.a.clearMetaKeyState(view, editable, n);
    }
    
    public int getInputType() {
        return this.a.getInputType();
    }
    
    public boolean onKeyDown(final View view, final Editable editable, final int n, final KeyEvent keyEvent) {
        return this.b.a(editable, n, keyEvent) || this.a.onKeyDown(view, editable, n, keyEvent);
    }
    
    public boolean onKeyOther(final View view, final Editable editable, final KeyEvent keyEvent) {
        return this.a.onKeyOther(view, editable, keyEvent);
    }
    
    public boolean onKeyUp(final View view, final Editable editable, final int n, final KeyEvent keyEvent) {
        return this.a.onKeyUp(view, editable, n, keyEvent);
    }
    
    public static class a
    {
        public boolean a(final Editable editable, final int n, final KeyEvent keyEvent) {
            return androidx.emoji2.text.e.f(editable, n, keyEvent);
        }
    }
}
