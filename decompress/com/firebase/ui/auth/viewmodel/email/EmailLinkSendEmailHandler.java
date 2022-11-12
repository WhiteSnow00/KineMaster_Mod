// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.email;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.EmailLinkPersistenceManager;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.firebase.ui.auth.util.data.SessionUtils;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.ContinueUrlBuilder;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.ActionCodeSettings;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;

public class EmailLinkSendEmailHandler extends AuthViewModelBase<String>
{
    private static final int SESSION_ID_LENGTH = 10;
    
    public EmailLinkSendEmailHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final EmailLinkSendEmailHandler emailLinkSendEmailHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)emailLinkSendEmailHandler).setResult((Resource<T>)result);
    }
    
    static void access$100(final EmailLinkSendEmailHandler emailLinkSendEmailHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)emailLinkSendEmailHandler).setResult((Resource<T>)result);
    }
    
    private ActionCodeSettings addSessionInfoToActionCodeSettings(final ActionCodeSettings actionCodeSettings, final String s, final String s2, final IdpResponse idpResponse, final boolean b) {
        final ContinueUrlBuilder continueUrlBuilder = new ContinueUrlBuilder(actionCodeSettings.P1());
        continueUrlBuilder.appendSessionId(s);
        continueUrlBuilder.appendAnonymousUserId(s2);
        continueUrlBuilder.appendForceSameDeviceBit(b);
        if (idpResponse != null) {
            continueUrlBuilder.appendProviderId(idpResponse.getProviderType());
        }
        return ActionCodeSettings.Q1().e(continueUrlBuilder.build()).c(true).b(actionCodeSettings.N1(), actionCodeSettings.L1(), actionCodeSettings.M1()).d(actionCodeSettings.O1()).a();
    }
    
    public void sendSignInLinkToEmail(final String s, ActionCodeSettings addSessionInfoToActionCodeSettings, final IdpResponse idpResponse, final boolean b) {
        if (this.getAuth() == null) {
            return;
        }
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forLoading());
        String s2;
        if (AuthOperationManager.getInstance().canUpgradeAnonymous(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments())) {
            s2 = this.getAuth().h().S1();
        }
        else {
            s2 = null;
        }
        final String generateRandomAlphaNumericString = SessionUtils.generateRandomAlphaNumericString(10);
        addSessionInfoToActionCodeSettings = this.addSessionInfoToActionCodeSettings(addSessionInfoToActionCodeSettings, generateRandomAlphaNumericString, s2, idpResponse, b);
        this.getAuth().p(s, addSessionInfoToActionCodeSettings).c((OnCompleteListener)new OnCompleteListener<Void>(this, s, generateRandomAlphaNumericString, s2) {
            final EmailLinkSendEmailHandler this$0;
            final String val$anonymousUserId;
            final String val$email;
            final String val$sessionId;
            
            public void onComplete(final Task<Void> task) {
                if (task.t()) {
                    EmailLinkPersistenceManager.getInstance().saveEmail(this.this$0.getApplication(), this.val$email, this.val$sessionId, this.val$anonymousUserId);
                    EmailLinkSendEmailHandler.access$000(this.this$0, Resource.forSuccess(this.val$email));
                }
                else {
                    EmailLinkSendEmailHandler.access$100(this.this$0, Resource.forFailure(task.o()));
                }
            }
        });
    }
}
