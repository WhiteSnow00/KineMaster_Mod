// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import java.util.Iterator;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;

final class c implements Runnable
{
    final FirebaseAuth a;
    final InternalTokenResult b;
    
    c(final FirebaseAuth a, final InternalTokenResult b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        final Iterator iterator = FirebaseAuth.B(this.a).iterator();
        while (iterator.hasNext()) {
            ((IdTokenListener)iterator.next()).a(this.b);
        }
        final Iterator iterator2 = FirebaseAuth.A(this.a).iterator();
        while (iterator2.hasNext()) {
            ((FirebaseAuth.IdTokenListener)iterator2.next()).a(this.a);
        }
    }
}
