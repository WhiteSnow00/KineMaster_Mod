// 
// Decompiled by Procyon v0.6.0
// 

package c5;

import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule;
import com.google.android.datatransport.Transport;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient$EngagementMetricsLoggerInterface;

public final class d implements MetricsLoggerClient$EngagementMetricsLoggerInterface
{
    public final Transport a;
    
    public d(final Transport a) {
        this.a = a;
    }
    
    public final void a(final byte[] array) {
        TransportClientModule.b(this.a, array);
    }
}
