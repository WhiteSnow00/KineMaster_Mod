// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.view.View;
import android.os.Bundle;
import android.content.Context;

public abstract class j
{
    @Deprecated
    public Fragment b(final Context context, final String s, final Bundle bundle) {
        return Fragment.instantiate(context, s, bundle);
    }
    
    public abstract View c(final int p0);
    
    public abstract boolean d();
}
