// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import x9.j;
import com.google.android.gms.tasks.OnSuccessListener;

public final class d1 implements OnSuccessListener
{
    public final j a;
    
    public d1(final j a) {
        this.a = a;
    }
    
    public final void onSuccess(final Object o) {
        InAppMessageStreamManager.G(this.a, o);
    }
}
