// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.android.gms.tasks.OnSuccessListener;

public final class n1 implements OnSuccessListener
{
    public final MetricsLoggerClient a;
    public final InAppMessage b;
    
    public n1(final MetricsLoggerClient a, final InAppMessage b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onSuccess(final Object o) {
        MetricsLoggerClient.a(this.a, this.b, (String)o);
    }
}
