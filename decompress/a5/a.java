// 
// Decompiled by Procyon v0.6.0
// 

package a5;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;
import android.app.Activity;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;

public final class a implements FirebaseInAppMessagingDisplay
{
    public final com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay a;
    public final Activity b;
    
    public a(final com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay a, final Activity b) {
        this.a = a;
        this.b = b;
    }
    
    public final void displayMessage(final InAppMessage inAppMessage, final FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.a(this.a, this.b, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }
}
