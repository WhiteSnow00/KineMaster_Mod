// 
// Decompiled by Procyon v0.6.0
// 

package a5;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplayRegistrar;
import com.google.firebase.components.ComponentFactory;

public final class b implements ComponentFactory
{
    public final FirebaseInAppMessagingDisplayRegistrar a;
    
    public b(final FirebaseInAppMessagingDisplayRegistrar a) {
        this.a = a;
    }
    
    @Override
    public final Object a(final ComponentContainer componentContainer) {
        return FirebaseInAppMessagingDisplayRegistrar.a(this.a, componentContainer);
    }
}
