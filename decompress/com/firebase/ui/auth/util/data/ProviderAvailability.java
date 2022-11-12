// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

public final class ProviderAvailability
{
    public static final boolean IS_FACEBOOK_AVAILABLE;
    public static final boolean IS_GITHUB_AVAILABLE;
    public static final boolean IS_TWITTER_AVAILABLE;
    
    static {
        IS_GITHUB_AVAILABLE = exists("com.firebase.ui.auth.data.remote.GitHubSignInHandler");
        IS_FACEBOOK_AVAILABLE = exists("com.facebook.login.LoginManager");
        IS_TWITTER_AVAILABLE = exists("com.twitter.sdk.android.core.identity.TwitterAuthClient");
    }
    
    private ProviderAvailability() {
        throw new AssertionError((Object)"No instance for you!");
    }
    
    private static boolean exists(final String s) {
        boolean b;
        try {
            Class.forName(s);
            b = true;
        }
        catch (final ClassNotFoundException ex) {
            b = false;
        }
        return b;
    }
}
