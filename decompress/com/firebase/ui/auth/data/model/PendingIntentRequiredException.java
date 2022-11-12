// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import android.app.PendingIntent;
import com.firebase.ui.auth.FirebaseUiException;

public class PendingIntentRequiredException extends FirebaseUiException
{
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;
    
    public PendingIntentRequiredException(final PendingIntent mPendingIntent, final int mRequestCode) {
        super(0);
        this.mPendingIntent = mPendingIntent;
        this.mRequestCode = mRequestCode;
    }
    
    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }
    
    public int getRequestCode() {
        return this.mRequestCode;
    }
}
