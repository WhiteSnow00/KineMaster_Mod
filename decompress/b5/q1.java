// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.android.gms.tasks.OnSuccessListener;

public final class q1 implements OnSuccessListener
{
    public final MetricsLoggerClient a;
    public final InAppMessage b;
    public final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason c;
    
    public q1(final MetricsLoggerClient a, final InAppMessage b, final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void onSuccess(final Object o) {
        MetricsLoggerClient.b(this.a, this.b, this.c, (String)o);
    }
}
