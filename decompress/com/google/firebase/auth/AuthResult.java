// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public interface AuthResult extends SafeParcelable
{
    AdditionalUserInfo d1();
    
    AuthCredential getCredential();
    
    FirebaseUser l0();
}
