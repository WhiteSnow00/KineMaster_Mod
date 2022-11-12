// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.RateLimitProto$RateLimit;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import ba.f;

public final class y1 implements f
{
    public final RateLimiterClient a;
    
    public y1(final RateLimiterClient a) {
        this.a = a;
    }
    
    public final Object apply(final Object o) {
        return RateLimiterClient.g(this.a, (RateLimitProto$RateLimit)o);
    }
}
