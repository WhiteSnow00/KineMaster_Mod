// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.f;

public final class p0 implements f
{
    public final InAppMessageStreamManager a;
    public final String b;
    
    public p0(final InAppMessageStreamManager a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.B(this.a, this.b, (CampaignProto$ThickContent)o);
    }
}
