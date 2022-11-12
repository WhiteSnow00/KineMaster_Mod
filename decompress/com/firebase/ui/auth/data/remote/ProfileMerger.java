// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.data.model.User;
import android.net.Uri;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.android.gms.tasks.Tasks;
import android.text.TextUtils;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Continuation;

public class ProfileMerger implements Continuation<AuthResult, Task<AuthResult>>
{
    private static final String TAG = "ProfileMerger";
    private final IdpResponse mResponse;
    
    public ProfileMerger(final IdpResponse mResponse) {
        this.mResponse = mResponse;
    }
    
    public Task<AuthResult> then(final Task<AuthResult> task) {
        final AuthResult authResult = (AuthResult)task.p();
        final FirebaseUser l0 = authResult.l0();
        final String l2 = l0.L1();
        final Uri p = l0.P1();
        if (!TextUtils.isEmpty((CharSequence)l2) && p != null) {
            return (Task<AuthResult>)Tasks.e((Object)authResult);
        }
        final User user = this.mResponse.getUser();
        String name = l2;
        if (TextUtils.isEmpty((CharSequence)l2)) {
            name = user.getName();
        }
        Uri photoUri;
        if ((photoUri = p) == null) {
            photoUri = user.getPhotoUri();
        }
        return (Task<AuthResult>)l0.X1(new UserProfileChangeRequest.Builder().b(name).c(photoUri).a()).f((OnFailureListener)new TaskFailureLogger("ProfileMerger", "Error updating profile")).m((Continuation)new Continuation<Void, Task<AuthResult>>(this, authResult) {
            final ProfileMerger this$0;
            final AuthResult val$authResult;
            
            public Task<AuthResult> then(final Task<Void> task) {
                return (Task<AuthResult>)Tasks.e((Object)this.val$authResult);
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<Void>)task);
            }
        });
    }
    
    public /* bridge */ Object then(final Task task) throws Exception {
        return this.then((Task<AuthResult>)task);
    }
}
