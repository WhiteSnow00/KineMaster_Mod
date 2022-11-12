// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import ba.a;

public final class k implements a
{
    public final DisplayCallbacksImpl a;
    public final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType b;
    
    public k(final DisplayCallbacksImpl a, final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType b) {
        this.a = a;
        this.b = b;
    }
    
    public final void run() {
        DisplayCallbacksImpl.m(this.a, this.b);
    }
}
