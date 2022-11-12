// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.RateLimitProto$Counter;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.internal.RateLimitProto$RateLimit;
import ba.f;

public final class x1 implements f
{
    public final RateLimitProto$RateLimit a;
    public final RateLimit b;
    
    public x1(final RateLimitProto$RateLimit a, final RateLimit b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return RateLimiterClient.c(this.a, this.b, (RateLimitProto$Counter)o);
    }
}
