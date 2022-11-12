// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.email;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.ActionCodeSettings;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;

public class RecoverPasswordHandler extends AuthViewModelBase<String>
{
    public RecoverPasswordHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final RecoverPasswordHandler recoverPasswordHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)recoverPasswordHandler).setResult((Resource<T>)result);
    }
    
    public void startReset(final String s, final ActionCodeSettings actionCodeSettings) {
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forLoading());
        Task<Void> task;
        if (actionCodeSettings != null) {
            task = this.getAuth().o(s, actionCodeSettings);
        }
        else {
            task = this.getAuth().n(s);
        }
        task.c((OnCompleteListener)new OnCompleteListener<Void>(this, s) {
            final RecoverPasswordHandler this$0;
            final String val$email;
            
            public void onComplete(final Task<Void> task) {
                Object o;
                if (task.t()) {
                    o = Resource.forSuccess(this.val$email);
                }
                else {
                    o = Resource.forFailure(task.o());
                }
                RecoverPasswordHandler.access$000(this.this$0, o);
            }
        });
    }
}
