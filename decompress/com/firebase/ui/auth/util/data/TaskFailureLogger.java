// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

public class TaskFailureLogger implements OnFailureListener
{
    private String mMessage;
    private String mTag;
    
    public TaskFailureLogger(final String mTag, final String mMessage) {
        this.mTag = mTag;
        this.mMessage = mMessage;
    }
    
    public void onFailure(final Exception ex) {
        Log.w(this.mTag, this.mMessage, (Throwable)ex);
    }
}
