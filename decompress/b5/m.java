// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import ba.a;

public final class m implements a
{
    public final DisplayCallbacksImpl a;
    public final Action b;
    
    public m(final DisplayCallbacksImpl a, final Action b) {
        this.a = a;
        this.b = b;
    }
    
    public final void run() {
        DisplayCallbacksImpl.n(this.a, this.b);
    }
}
