// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.ExperimentPayloadProto$ExperimentPayload;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;

public final class a implements Runnable
{
    public final AbtIntegrationHelper a;
    public final ExperimentPayloadProto$ExperimentPayload b;
    
    public a(final AbtIntegrationHelper a, final ExperimentPayloadProto$ExperimentPayload b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AbtIntegrationHelper.a(this.a, this.b);
    }
}
