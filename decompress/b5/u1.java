// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.RateLimitProto$RateLimit;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import ba.a;

public final class u1 implements a
{
    public final RateLimiterClient a;
    public final RateLimitProto$RateLimit b;
    
    public u1(final RateLimiterClient a, final RateLimitProto$RateLimit b) {
        this.a = a;
        this.b = b;
    }
    
    public final void run() {
        RateLimiterClient.d(this.a, this.b);
    }
}
