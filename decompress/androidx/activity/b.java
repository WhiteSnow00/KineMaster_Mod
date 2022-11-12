// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import android.content.Context;

public final class b implements b.b
{
    public final ComponentActivity a;
    
    public b(final ComponentActivity a) {
        this.a = a;
    }
    
    @Override
    public final void onContextAvailable(final Context context) {
        ComponentActivity.k(this.a, context);
    }
}
