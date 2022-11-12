// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.f;

public final class q0 implements f
{
    public final InAppMessageStreamManager a;
    public final String b;
    public final f c;
    public final f d;
    public final f e;
    
    public q0(final InAppMessageStreamManager a, final String b, final f c, final f d, final f e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.h(this.a, this.b, this.c, this.d, this.e, (FetchEligibleCampaignsResponse)o);
    }
}
