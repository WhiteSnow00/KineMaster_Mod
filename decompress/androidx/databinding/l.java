// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import java.lang.ref.WeakReference;

class l<T> extends WeakReference<ViewDataBinding>
{
    private final i<T> a;
    private T b;
    
    public boolean a() {
        final T b = this.b;
        boolean b2;
        if (b != null) {
            this.a.a(b);
            b2 = true;
        }
        else {
            b2 = false;
        }
        this.b = null;
        return b2;
    }
}
