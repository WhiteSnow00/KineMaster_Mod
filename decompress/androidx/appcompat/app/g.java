// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.view.KeyEvent;

public final class g implements a
{
    public final h a;
    
    public g(final h a) {
        this.a = a;
    }
    
    @Override
    public final boolean superDispatchKeyEvent(final KeyEvent keyEvent) {
        return this.a.g(keyEvent);
    }
}
