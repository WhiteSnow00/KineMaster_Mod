// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.h;

public final class w0 implements h
{
    public final InAppMessageStreamManager a;
    
    public w0(final InAppMessageStreamManager a) {
        this.a = a;
    }
    
    public final boolean test(final Object o) {
        return InAppMessageStreamManager.a(this.a, (CampaignProto$ThickContent)o);
    }
}
