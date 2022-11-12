// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import android.content.Intent;
import com.firebase.ui.auth.FirebaseUiException;

public class IntentRequiredException extends FirebaseUiException
{
    private final Intent mIntent;
    private final int mRequestCode;
    
    public IntentRequiredException(final Intent mIntent, final int mRequestCode) {
        super(0);
        this.mIntent = mIntent;
        this.mRequestCode = mRequestCode;
    }
    
    public Intent getIntent() {
        return this.mIntent;
    }
    
    public int getRequestCode() {
        return this.mRequestCode;
    }
}
