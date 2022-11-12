// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.RateLimitProto$RateLimit;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import ba.f;

public final class a2 implements f
{
    public final RateLimiterClient a;
    public final RateLimit b;
    
    public a2(final RateLimiterClient a, final RateLimit b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return RateLimiterClient.e(this.a, this.b, (RateLimitProto$RateLimit)o);
    }
}
