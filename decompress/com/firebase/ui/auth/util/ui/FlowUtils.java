// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui;

import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import android.content.IntentSender$SendIntentException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.os.Bundle;
import android.content.Intent;
import android.app.PendingIntent;
import com.firebase.ui.auth.ui.FragmentBase;

public final class FlowUtils
{
    private FlowUtils() {
        throw new AssertionError((Object)"No instance for you!");
    }
    
    private static void startIntentSenderForResult(final FragmentBase fragmentBase, final PendingIntent pendingIntent, final int n) {
        try {
            fragmentBase.startIntentSenderForResult(pendingIntent.getIntentSender(), n, null, 0, 0, 0, null);
        }
        catch (final IntentSender$SendIntentException ex) {
            ((HelperActivityBase)fragmentBase.requireActivity()).finish(0, IdpResponse.getErrorIntent((Exception)ex));
        }
    }
    
    private static void startIntentSenderForResult(final HelperActivityBase helperActivityBase, final PendingIntent pendingIntent, final int n) {
        try {
            helperActivityBase.startIntentSenderForResult(pendingIntent.getIntentSender(), n, null, 0, 0, 0);
        }
        catch (final IntentSender$SendIntentException ex) {
            helperActivityBase.finish(0, IdpResponse.getErrorIntent((Exception)ex));
        }
    }
    
    public static boolean unhandled(final FragmentBase fragmentBase, final Exception ex) {
        if (ex instanceof IntentRequiredException) {
            final IntentRequiredException ex2 = (IntentRequiredException)ex;
            fragmentBase.startActivityForResult(ex2.getIntent(), ex2.getRequestCode());
            return false;
        }
        if (ex instanceof PendingIntentRequiredException) {
            final PendingIntentRequiredException ex3 = (PendingIntentRequiredException)ex;
            startIntentSenderForResult(fragmentBase, ex3.getPendingIntent(), ex3.getRequestCode());
            return false;
        }
        return true;
    }
    
    public static boolean unhandled(final HelperActivityBase helperActivityBase, final Exception ex) {
        if (ex instanceof IntentRequiredException) {
            final IntentRequiredException ex2 = (IntentRequiredException)ex;
            helperActivityBase.startActivityForResult(ex2.getIntent(), ex2.getRequestCode());
            return false;
        }
        if (ex instanceof PendingIntentRequiredException) {
            final PendingIntentRequiredException ex3 = (PendingIntentRequiredException)ex;
            startIntentSenderForResult(helperActivityBase, ex3.getPendingIntent(), ex3.getRequestCode());
            return false;
        }
        return true;
    }
}
