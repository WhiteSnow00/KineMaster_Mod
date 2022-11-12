// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util;

import android.content.res.Resources$NotFoundException;
import android.os.Bundle;
import java.util.Objects;
import android.content.Context;

public final class Preconditions
{
    private Preconditions() {
    }
    
    public static void checkArgument(final boolean b, final String s) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException(s);
    }
    
    public static void checkConfigured(final Context context, final String s, final int... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (context.getString(array[i]).equals("CHANGE-ME")) {
                throw new IllegalStateException(s);
            }
        }
    }
    
    public static <T> T checkNotNull(final T t, final String s, final Object... array) {
        if (t != null) {
            return t;
        }
        Objects.requireNonNull(array, s);
        throw new NullPointerException(String.format(s, array));
    }
    
    public static void checkUnset(final Bundle bundle, final String s, final String... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (bundle.containsKey(array[i])) {
                throw new IllegalStateException(s);
            }
        }
    }
    
    public static int checkValidStyle(final Context context, final int n, final String s, final Object... array) {
        try {
            if ("style".equals(context.getResources().getResourceTypeName(n))) {
                return n;
            }
            throw new IllegalArgumentException(String.format(s, array));
        }
        catch (final Resources$NotFoundException ex) {
            throw new IllegalArgumentException(String.format(s, array));
        }
    }
}
