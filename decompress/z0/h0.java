// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.view.View;
import android.view.WindowId;

class h0 implements i0
{
    private final WindowId a;
    
    h0(final View view) {
        this.a = view.getWindowId();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof h0 && ((h0)o).a.equals((Object)this.a);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
}
