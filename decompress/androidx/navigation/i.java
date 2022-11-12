// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.o;

public final class i implements o
{
    public final NavController a;
    
    public i(final NavController a) {
        this.a = a;
    }
    
    @Override
    public final void f(final r r, final Lifecycle.Event event) {
        NavController.a(this.a, r, event);
    }
}
