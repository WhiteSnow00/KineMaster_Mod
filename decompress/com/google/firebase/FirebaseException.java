// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

public class FirebaseException extends Exception
{
    @Deprecated
    protected FirebaseException() {
    }
    
    public FirebaseException(final String s) {
        Preconditions.h(s, "Detail message must not be empty");
        super(s);
    }
    
    public FirebaseException(final String s, final Throwable t) {
        Preconditions.h(s, "Detail message must not be empty");
        super(s, t);
    }
}
