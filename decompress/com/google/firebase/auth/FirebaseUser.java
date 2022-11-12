// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.internal.firebase-auth-api.zzwq;
import com.google.firebase.FirebaseApp;
import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import android.net.Uri;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo
{
    public Task<Void> K1() {
        return (Task<Void>)FirebaseAuth.getInstance(this.Y1()).M(this);
    }
    
    public abstract String L1();
    
    public abstract String M1();
    
    public abstract MultiFactor N1();
    
    public abstract String O1();
    
    public abstract Uri P1();
    
    public abstract List<? extends UserInfo> Q1();
    
    public abstract String R1();
    
    public abstract String S1();
    
    public abstract boolean T1();
    
    public Task<AuthResult> U1(final AuthCredential authCredential) {
        Preconditions.k(authCredential);
        return (Task<AuthResult>)FirebaseAuth.getInstance(this.Y1()).O(this, authCredential);
    }
    
    public Task<AuthResult> V1(final AuthCredential authCredential) {
        Preconditions.k(authCredential);
        return (Task<AuthResult>)FirebaseAuth.getInstance(this.Y1()).P(this, authCredential);
    }
    
    public Task<AuthResult> W1(final Activity activity, final FederatedAuthProvider federatedAuthProvider) {
        Preconditions.k(activity);
        Preconditions.k(federatedAuthProvider);
        return (Task<AuthResult>)FirebaseAuth.getInstance(this.Y1()).Q(activity, federatedAuthProvider, this);
    }
    
    public Task<Void> X1(final UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.k(userProfileChangeRequest);
        return (Task<Void>)FirebaseAuth.getInstance(this.Y1()).R(this, userProfileChangeRequest);
    }
    
    public abstract FirebaseApp Y1();
    
    public abstract FirebaseUser Z1();
    
    public abstract FirebaseUser a2(final List p0);
    
    public abstract zzwq b2();
    
    public abstract void c2(final zzwq p0);
    
    public abstract void d2(final List p0);
    
    public abstract String zze();
    
    public abstract String zzf();
    
    public abstract List zzg();
}
