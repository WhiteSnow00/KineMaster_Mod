// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.events.Event;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.events.EventHandler;

public final class g implements EventHandler
{
    public final DataCollectionHelper a;
    
    public g(final DataCollectionHelper a) {
        this.a = a;
    }
    
    public final void a(final Event event) {
        DataCollectionHelper.a(this.a, event);
    }
}
