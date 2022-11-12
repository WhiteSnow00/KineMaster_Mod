// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import java.util.Comparator;

public final class e1 implements Comparator
{
    public static final e1 a;
    
    static {
        a = new e1();
    }
    
    private e1() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return InAppMessageStreamManager.q((CampaignProto$ThickContent)o, (CampaignProto$ThickContent)o2);
    }
}
