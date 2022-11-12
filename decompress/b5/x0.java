// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import ba.h;

public final class x0 implements h
{
    public final String a;
    
    public x0(final String a) {
        this.a = a;
    }
    
    public final boolean test(final Object o) {
        return InAppMessageStreamManager.k(this.a, (CampaignProto$ThickContent)o);
    }
}
