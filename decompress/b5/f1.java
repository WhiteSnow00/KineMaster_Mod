// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import x9.j;
import com.google.android.gms.tasks.Task;
import x9.l;

public final class f1 implements l
{
    public final Task a;
    
    public f1(final Task a) {
        this.a = a;
    }
    
    public final void a(final j j) {
        InAppMessageStreamManager.E(this.a, j);
    }
}
