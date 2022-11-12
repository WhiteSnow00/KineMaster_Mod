// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InstallationIdResult;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.f;

public final class m0 implements f
{
    public final InAppMessageStreamManager a;
    public final CampaignImpressionList b;
    
    public m0(final InAppMessageStreamManager a, final CampaignImpressionList b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.s(this.a, this.b, (InstallationIdResult)o);
    }
}
