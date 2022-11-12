// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import android.os.Bundle;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.firebase.ui.auth.FirebaseUiException;
import android.os.Parcelable;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import com.firebase.ui.auth.R;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import com.firebase.ui.auth.viewmodel.email.EmailLinkSignInHandler;
import com.firebase.ui.auth.ui.InvisibleActivityBase;

public class EmailLinkCatcherActivity extends InvisibleActivityBase
{
    private EmailLinkSignInHandler mHandler;
    
    static AlertDialog access$000(final EmailLinkCatcherActivity emailLinkCatcherActivity, final int n) {
        return emailLinkCatcherActivity.buildAlertDialog(n);
    }
    
    static void access$100(final EmailLinkCatcherActivity emailLinkCatcherActivity, final int n) {
        emailLinkCatcherActivity.startErrorRecoveryFlow(n);
    }
    
    private AlertDialog buildAlertDialog(final int n) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this);
        String title;
        String message;
        if (n == 11) {
            title = this.getString(R.string.fui_email_link_different_anonymous_user_header);
            message = this.getString(R.string.fui_email_link_different_anonymous_user_message);
        }
        else if (n == 7) {
            title = this.getString(R.string.fui_email_link_invalid_link_header);
            message = this.getString(R.string.fui_email_link_invalid_link_message);
        }
        else {
            title = this.getString(R.string.fui_email_link_wrong_device_header);
            message = this.getString(R.string.fui_email_link_wrong_device_message);
        }
        return alertDialog$Builder.setTitle((CharSequence)title).setMessage((CharSequence)message).setPositiveButton(R.string.fui_email_link_dismiss_button, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this, n) {
            final EmailLinkCatcherActivity this$0;
            final int val$errorCode;
            
            public void onClick(final DialogInterface dialogInterface, final int n) {
                this.this$0.finish(this.val$errorCode, null);
            }
        }).create();
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters) {
        return HelperActivityBase.createBaseIntent(context, EmailLinkCatcherActivity.class, flowParameters);
    }
    
    private void initHandler() {
        (this.mHandler = new o0(this).a(EmailLinkSignInHandler.class)).init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this) {
            final EmailLinkCatcherActivity this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof UserCancellationException) {
                    this.this$0.finish(0, null);
                }
                else if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(0, new Intent().putExtra("extra_idp_response", (Parcelable)((FirebaseAuthAnonymousUpgradeException)ex).getResponse()));
                }
                else if (ex instanceof FirebaseUiException) {
                    final int errorCode = ((FirebaseUiException)ex).getErrorCode();
                    if (errorCode != 8 && errorCode != 7 && errorCode != 11) {
                        if (errorCode != 9 && errorCode != 6) {
                            if (errorCode == 10) {
                                EmailLinkCatcherActivity.access$100(this.this$0, 116);
                            }
                        }
                        else {
                            EmailLinkCatcherActivity.access$100(this.this$0, 115);
                        }
                    }
                    else {
                        EmailLinkCatcherActivity.access$000(this.this$0, errorCode).show();
                    }
                }
                else if (ex instanceof FirebaseAuthInvalidCredentialsException) {
                    EmailLinkCatcherActivity.access$100(this.this$0, 115);
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
    }
    
    private void startErrorRecoveryFlow(final int n) {
        if (n != 116 && n != 115) {
            throw new IllegalStateException("Invalid flow param. It must be either RequestCodes.EMAIL_LINK_CROSS_DEVICE_LINKING_FLOW or RequestCodes.EMAIL_LINK_PROMPT_FOR_EMAIL_FLOW");
        }
        this.startActivityForResult(EmailLinkErrorRecoveryActivity.createIntent(this.getApplicationContext(), this.getFlowParams(), n), n);
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 115 || n == 116) {
            final IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (n2 == -1) {
                this.finish(-1, fromResultIntent.toIntent());
            }
            else {
                this.finish(0, null);
            }
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.initHandler();
        if (this.getFlowParams().emailLink != null) {
            this.mHandler.startSignIn();
        }
    }
}
