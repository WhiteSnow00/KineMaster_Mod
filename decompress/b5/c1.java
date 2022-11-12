// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import x9.j;
import com.google.android.gms.tasks.OnFailureListener;

public final class c1 implements OnFailureListener
{
    public final j a;
    
    public c1(final j a) {
        this.a = a;
    }
    
    public final void onFailure(final Exception ex) {
        InAppMessageStreamManager.t(this.a, ex);
    }
}
