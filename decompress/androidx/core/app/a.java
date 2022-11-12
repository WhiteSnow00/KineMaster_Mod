// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.app.Activity;

public final class a implements Runnable
{
    public final Activity a;
    
    public a(final Activity a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        b.a(this.a);
    }
}
