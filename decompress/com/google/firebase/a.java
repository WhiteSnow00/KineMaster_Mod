// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

public final class a implements BackgroundStateChangeListener
{
    public final FirebaseApp a;
    
    public a(final FirebaseApp a) {
        this.a = a;
    }
    
    @Override
    public final void a(final boolean b) {
        FirebaseApp.a(this.a, b);
    }
}
