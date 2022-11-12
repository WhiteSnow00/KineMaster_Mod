// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final class b implements Provider
{
    public final FirebaseApp a;
    public final Context b;
    
    public b(final FirebaseApp a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object get() {
        return FirebaseApp.b(this.a, this.b);
    }
}
