// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import com.google.android.gms.common.util.VisibleForTesting;

public class UserRecoverableNotifiedException extends GoogleAuthException
{
    @VisibleForTesting
    public UserRecoverableNotifiedException(final String s) {
        super(s);
    }
}
