// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.android.gms.tasks.OnSuccessListener;

public final class p1 implements OnSuccessListener
{
    public final MetricsLoggerClient a;
    public final InAppMessage b;
    public final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType c;
    
    public p1(final MetricsLoggerClient a, final InAppMessage b, final FirebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void onSuccess(final Object o) {
        MetricsLoggerClient.d(this.a, this.b, this.c, (String)o);
    }
}
