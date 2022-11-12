// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import android.os.Bundle;
import u0.c;

public final class d implements c
{
    public final ComponentActivity a;
    
    public d(final ComponentActivity a) {
        this.a = a;
    }
    
    @Override
    public final Bundle saveState() {
        return ComponentActivity.l(this.a);
    }
}
