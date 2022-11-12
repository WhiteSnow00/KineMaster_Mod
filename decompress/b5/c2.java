// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.RateLimitProto$Counter;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import ba.h;

public final class c2 implements h
{
    public final RateLimiterClient a;
    public final RateLimit b;
    
    public c2(final RateLimiterClient a, final RateLimit b) {
        this.a = a;
        this.b = b;
    }
    
    public final boolean test(final Object o) {
        return RateLimiterClient.i(this.a, this.b, (RateLimitProto$Counter)o);
    }
}
