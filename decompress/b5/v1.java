// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.RateLimitProto$RateLimit;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import ba.e;

public final class v1 implements e
{
    public final RateLimiterClient a;
    
    public v1(final RateLimiterClient a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        RateLimiterClient.h(this.a, (RateLimitProto$RateLimit)o);
    }
}
