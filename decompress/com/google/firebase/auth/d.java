// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import java.util.Iterator;

final class d implements Runnable
{
    final FirebaseAuth a;
    
    d(final FirebaseAuth a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final Iterator iterator = FirebaseAuth.z(this.a).iterator();
        while (iterator.hasNext()) {
            ((FirebaseAuth.AuthStateListener)iterator.next()).a(this.a);
        }
    }
}
