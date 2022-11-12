// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import ba.e;

public final class w1 implements e
{
    public final RateLimiterClient a;
    
    public w1(final RateLimiterClient a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        RateLimiterClient.f(this.a, (Throwable)o);
    }
}
