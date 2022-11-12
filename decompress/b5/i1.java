// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import ba.e;

public final class i1 implements e
{
    public final TestDeviceHelper a;
    
    public i1(final TestDeviceHelper a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        this.a.c((FetchEligibleCampaignsResponse)o);
    }
}
