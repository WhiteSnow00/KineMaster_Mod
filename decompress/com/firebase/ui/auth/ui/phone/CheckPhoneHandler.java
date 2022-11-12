// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import com.google.android.gms.auth.api.credentials.Credential;
import android.content.Intent;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.Credentials;
import android.app.Application;
import com.firebase.ui.auth.data.model.PhoneNumber;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;

public class CheckPhoneHandler extends AuthViewModelBase<PhoneNumber>
{
    public CheckPhoneHandler(final Application application) {
        super(application);
    }
    
    public void fetchCredential() {
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forFailure(new PendingIntentRequiredException(Credentials.b(this.getApplication()).d(new HintRequest.Builder().c(true).a()), 101)));
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 101) {
            if (n2 == -1) {
                final String formatUsingCurrentCountry = PhoneNumberUtils.formatUsingCurrentCountry(((Credential)intent.getParcelableExtra("com.google.android.gms.credentials.Credential")).N1(), this.getApplication());
                if (formatUsingCurrentCountry != null) {
                    ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forSuccess((T)PhoneNumberUtils.getPhoneNumber(formatUsingCurrentCountry)));
                }
            }
        }
    }
}
