// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.android.gms.auth.api.credentials.Credential;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;

public class CheckEmailHandler extends AuthViewModelBase<User>
{
    public CheckEmailHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final CheckEmailHandler checkEmailHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)checkEmailHandler).setResult((Resource<T>)result);
    }
    
    static void access$100(final CheckEmailHandler checkEmailHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)checkEmailHandler).setResult((Resource<T>)result);
    }
    
    static void access$200(final CheckEmailHandler checkEmailHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)checkEmailHandler).setResult((Resource<T>)result);
    }
    
    static void access$300(final CheckEmailHandler checkEmailHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)checkEmailHandler).setResult((Resource<T>)result);
    }
    
    public void fetchCredential() {
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forFailure(new PendingIntentRequiredException(Credentials.b(this.getApplication()).d(new HintRequest.Builder().b(true).a()), 101)));
    }
    
    public void fetchProvider(final String s) {
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forLoading());
        ProviderUtils.fetchTopProvider(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments(), s).c((OnCompleteListener)new OnCompleteListener<String>(this, s) {
            final CheckEmailHandler this$0;
            final String val$email;
            
            public void onComplete(final Task<String> task) {
                if (task.t()) {
                    CheckEmailHandler.access$000(this.this$0, Resource.forSuccess(new User.Builder((String)task.p(), this.val$email).build()));
                }
                else {
                    CheckEmailHandler.access$100(this.this$0, Resource.forFailure(task.o()));
                }
            }
        });
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 101) {
            if (n2 == -1) {
                ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forLoading());
                final Credential credential = (Credential)intent.getParcelableExtra("com.google.android.gms.credentials.Credential");
                final String n3 = credential.N1();
                ProviderUtils.fetchTopProvider(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments(), n3).c((OnCompleteListener)new OnCompleteListener<String>(this, n3, credential) {
                    final CheckEmailHandler this$0;
                    final Credential val$credential;
                    final String val$email;
                    
                    public void onComplete(final Task<String> task) {
                        if (task.t()) {
                            CheckEmailHandler.access$200(this.this$0, Resource.forSuccess(new User.Builder((String)task.p(), this.val$email).setName(this.val$credential.P1()).setPhotoUri(this.val$credential.R1()).build()));
                        }
                        else {
                            CheckEmailHandler.access$300(this.this$0, Resource.forFailure(task.o()));
                        }
                    }
                });
            }
        }
    }
}
