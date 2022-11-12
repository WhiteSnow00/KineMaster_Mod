// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

final class b implements Runnable
{
    final FirebaseAuth.AuthStateListener a;
    final FirebaseAuth b;
    
    b(final FirebaseAuth b, final FirebaseAuth.AuthStateListener a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.a(this.b);
    }
}
