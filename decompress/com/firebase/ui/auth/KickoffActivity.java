// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.common.GoogleApiAvailability;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.data.remote.SignInKickstarter;
import com.firebase.ui.auth.ui.InvisibleActivityBase;

public class KickoffActivity extends InvisibleActivityBase
{
    private SignInKickstarter mKickstarter;
    
    static SignInKickstarter access$000(final KickoffActivity kickoffActivity) {
        return kickoffActivity.mKickstarter;
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters) {
        return HelperActivityBase.createBaseIntent(context, KickoffActivity.class, flowParameters);
    }
    
    public void invalidateEmailLink() {
        final FlowParameters flowParams = this.getFlowParams();
        flowParams.emailLink = null;
        this.setIntent(this.getIntent().putExtra("extra_flow_params", (Parcelable)flowParams));
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 106 && (n2 == 113 || n2 == 114)) {
            this.invalidateEmailLink();
        }
        this.mKickstarter.onActivityResult(n, n2, intent);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        (this.mKickstarter = new o0(this).a(SignInKickstarter.class)).init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)this.mKickstarter).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this) {
            final KickoffActivity this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof UserCancellationException) {
                    this.this$0.finish(0, null);
                }
                else if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(0, new Intent().putExtra("extra_idp_response", (Parcelable)((FirebaseAuthAnonymousUpgradeException)ex).getResponse()));
                }
                else {
                    this.this$0.finish(0, IdpResponse.getErrorIntent(ex));
                }
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                this.this$0.finish(-1, idpResponse.toIntent());
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        Task task;
        if (this.getFlowParams().isPlayServicesRequired()) {
            task = GoogleApiAvailability.q().r(this);
        }
        else {
            task = Tasks.e((Object)null);
        }
        task.h((Activity)this, (OnSuccessListener)new OnSuccessListener<Void>(this, bundle) {
            final KickoffActivity this$0;
            final Bundle val$savedInstanceState;
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((Void)o);
            }
            
            public void onSuccess(final Void void1) {
                if (this.val$savedInstanceState != null) {
                    return;
                }
                KickoffActivity.access$000(this.this$0).start();
            }
        }).e((Activity)this, (OnFailureListener)new OnFailureListener(this) {
            final KickoffActivity this$0;
            
            public void onFailure(final Exception ex) {
                this.this$0.finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(2, ex)));
            }
        });
    }
}
