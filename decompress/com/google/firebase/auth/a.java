// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzan;

final class a implements zzan
{
    final FirebaseUser a;
    final FirebaseAuth b;
    
    a(final FirebaseAuth b, final FirebaseUser a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void zza() {
        final FirebaseAuth b = this.b;
        if (FirebaseAuth.S(b) != null && FirebaseAuth.S(b).S1().equalsIgnoreCase(this.a.S1())) {
            this.b.C();
        }
    }
    
    @Override
    public final void zzb(final Status status) {
        if (status.M1() != 17011 && status.M1() != 17021 && status.M1() != 17005) {
            return;
        }
        this.b.v();
    }
}
