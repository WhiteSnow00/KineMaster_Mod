// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import ba.a;

public final class l implements a
{
    public final DisplayCallbacksImpl a;
    public final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason b;
    
    public l(final DisplayCallbacksImpl a, final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason b) {
        this.a = a;
        this.b = b;
    }
    
    public final void run() {
        DisplayCallbacksImpl.j(this.a, this.b);
    }
}
