// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.firebase.ui.auth.data.model.PhoneNumberVerificationRequiredException;
import java.util.concurrent.TimeUnit;
import com.google.firebase.auth.PhoneAuthOptions;
import android.app.Activity;
import android.os.Bundle;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.google.firebase.auth.PhoneAuthProvider;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;

public class PhoneNumberVerificationHandler extends AuthViewModelBase<PhoneVerification>
{
    private static final long AUTO_RETRIEVAL_TIMEOUT_SECONDS = 120L;
    private static final String VERIFICATION_ID_KEY = "verification_id";
    private PhoneAuthProvider.ForceResendingToken mForceResendingToken;
    private String mVerificationId;
    
    public PhoneNumberVerificationHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final PhoneNumberVerificationHandler phoneNumberVerificationHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)phoneNumberVerificationHandler).setResult((Resource<T>)result);
    }
    
    static void access$100(final PhoneNumberVerificationHandler phoneNumberVerificationHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)phoneNumberVerificationHandler).setResult((Resource<T>)result);
    }
    
    static String access$202(final PhoneNumberVerificationHandler phoneNumberVerificationHandler, final String mVerificationId) {
        return phoneNumberVerificationHandler.mVerificationId = mVerificationId;
    }
    
    static PhoneAuthProvider.ForceResendingToken access$302(final PhoneNumberVerificationHandler phoneNumberVerificationHandler, final PhoneAuthProvider.ForceResendingToken mForceResendingToken) {
        return phoneNumberVerificationHandler.mForceResendingToken = mForceResendingToken;
    }
    
    static void access$400(final PhoneNumberVerificationHandler phoneNumberVerificationHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)phoneNumberVerificationHandler).setResult((Resource<T>)result);
    }
    
    public void onRestoreInstanceState(final Bundle bundle) {
        if (this.mVerificationId == null && bundle != null) {
            this.mVerificationId = bundle.getString("verification_id");
        }
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        bundle.putString("verification_id", this.mVerificationId);
    }
    
    public void submitVerificationCode(final String s, final String s2) {
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forSuccess((T)new PhoneVerification(s, PhoneAuthProvider.a(this.mVerificationId, s2), false)));
    }
    
    public void verifyPhoneNumber(final Activity activity, final String s, final boolean b) {
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forLoading());
        final PhoneAuthOptions.Builder c = PhoneAuthOptions.a(this.getAuth()).e(s).f(120L, TimeUnit.SECONDS).b(activity).c(new PhoneAuthProvider.OnVerificationStateChangedCallbacks(this, s) {
            final PhoneNumberVerificationHandler this$0;
            final String val$number;
            
            @Override
            public void onCodeSent(final String s, final ForceResendingToken forceResendingToken) {
                PhoneNumberVerificationHandler.access$202(this.this$0, s);
                PhoneNumberVerificationHandler.access$302(this.this$0, forceResendingToken);
                PhoneNumberVerificationHandler.access$400(this.this$0, Resource.forFailure(new PhoneNumberVerificationRequiredException(this.val$number)));
            }
            
            @Override
            public void onVerificationCompleted(final PhoneAuthCredential phoneAuthCredential) {
                PhoneNumberVerificationHandler.access$000(this.this$0, Resource.forSuccess(new PhoneVerification(this.val$number, phoneAuthCredential, true)));
            }
            
            @Override
            public void onVerificationFailed(final FirebaseException ex) {
                PhoneNumberVerificationHandler.access$100(this.this$0, Resource.forFailure(ex));
            }
        });
        if (b) {
            c.d(this.mForceResendingToken);
        }
        PhoneAuthProvider.b(c.a());
    }
}
