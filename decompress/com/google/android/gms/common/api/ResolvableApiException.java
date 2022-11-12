// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import android.content.IntentSender$SendIntentException;
import android.app.Activity;
import android.app.PendingIntent;

public class ResolvableApiException extends ApiException
{
    public ResolvableApiException(final Status status) {
        super(status);
    }
    
    public PendingIntent getResolution() {
        return this.getStatus().L1();
    }
    
    public void startResolutionForResult(final Activity activity, final int n) throws IntentSender$SendIntentException {
        this.getStatus().Q1(activity, n);
    }
}
