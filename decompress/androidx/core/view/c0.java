// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;

public final class c0 implements View$OnUnhandledKeyEventListener
{
    public final b0.v a;
    
    public c0(final b0.v a) {
        this.a = a;
    }
    
    public final boolean onUnhandledKeyEvent(final View view, final KeyEvent keyEvent) {
        return this.a.onUnhandledKeyEvent(view, keyEvent);
    }
}
