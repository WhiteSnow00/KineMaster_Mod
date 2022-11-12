// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.bridge.fbsdk;

import androidx.annotation.Keep;

@Keep
public class FBLoginASID
{
    public static String getFBLoginASID() {
        try {
            final Object invoke = Class.forName("com.facebook.AccessToken").getDeclaredMethod("getCurrentAccessToken", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            if (invoke != null) {
                return (String)Class.forName("com.facebook.AccessToken").getDeclaredMethod("getUserId", (Class<?>[])new Class[0]).invoke(invoke, new Object[0]);
            }
            return null;
        }
        finally {
            return null;
        }
    }
}
