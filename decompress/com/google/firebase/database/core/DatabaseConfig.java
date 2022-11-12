// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;

public class DatabaseConfig extends Context
{
    public void I(final TokenProvider d) {
        super.d = d;
    }
    
    public void J(final TokenProvider c) {
        super.c = c;
    }
    
    public void K(final FirebaseApp l) {
        synchronized (this) {
            super.l = l;
        }
    }
    
    public void L(final boolean j) {
        synchronized (this) {
            this.b();
            super.j = j;
        }
    }
    
    public void M(final String f) {
        synchronized (this) {
            this.b();
            if (f != null && !f.isEmpty()) {
                super.f = f;
                return;
            }
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
    }
}
