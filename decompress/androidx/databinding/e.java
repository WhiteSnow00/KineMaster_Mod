// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.view.View;
import java.util.Collections;
import java.util.List;

public abstract class e
{
    public List<e> a() {
        return Collections.emptyList();
    }
    
    public abstract ViewDataBinding b(final f p0, final View p1, final int p2);
    
    public abstract ViewDataBinding c(final f p0, final View[] p1, final int p2);
}
