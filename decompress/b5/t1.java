// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inject.Provider;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inject.Deferred$DeferredHandler;

public final class t1 implements Deferred$DeferredHandler
{
    public final ProxyAnalyticsConnector a;
    
    public t1(final ProxyAnalyticsConnector a) {
        this.a = a;
    }
    
    public final void a(final Provider provider) {
        ProxyAnalyticsConnector.h(this.a, provider);
    }
}
