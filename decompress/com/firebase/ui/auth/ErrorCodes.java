// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public final class ErrorCodes
{
    public static final int ANONYMOUS_UPGRADE_MERGE_CONFLICT = 5;
    public static final int DEVELOPER_ERROR = 3;
    public static final int EMAIL_LINK_CROSS_DEVICE_LINKING_ERROR = 10;
    public static final int EMAIL_LINK_DIFFERENT_ANONYMOUS_USER_ERROR = 11;
    public static final int EMAIL_LINK_PROMPT_FOR_EMAIL_ERROR = 9;
    public static final int EMAIL_LINK_WRONG_DEVICE_ERROR = 8;
    public static final int EMAIL_MISMATCH_ERROR = 6;
    public static final int ERROR_GENERIC_IDP_RECOVERABLE_ERROR = 13;
    public static final int ERROR_USER_DISABLED = 12;
    public static final int INVALID_EMAIL_LINK_ERROR = 7;
    public static final int NO_NETWORK = 1;
    public static final int PLAY_SERVICES_UPDATE_CANCELLED = 2;
    public static final int PROVIDER_ERROR = 4;
    public static final int UNKNOWN_ERROR = 0;
    
    private ErrorCodes() {
        throw new AssertionError((Object)"No instance for you!");
    }
    
    public static String toFriendlyMessage(final int n) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown code: ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            }
            case 13: {
                return "Generic IDP recoverable error.";
            }
            case 12: {
                return "The user account has been disabled by an administrator.";
            }
            case 11: {
                return "The session associated with this sign-in request has either expired or was cleared";
            }
            case 10: {
                return "You must determine if you want to continue linking or complete the sign in";
            }
            case 9: {
                return "Please enter your email to continue signing in";
            }
            case 8: {
                return "You must open the email link on the same device.";
            }
            case 7: {
                return "You are are attempting to sign in with an invalid email link";
            }
            case 6: {
                return "You are are attempting to sign in a different email than previously provided";
            }
            case 5: {
                return "User account merge conflict";
            }
            case 4: {
                return "Provider error";
            }
            case 3: {
                return "Developer error";
            }
            case 2: {
                return "Play Services update cancelled";
            }
            case 1: {
                return "No internet connection";
            }
            case 0: {
                return "Unknown error";
            }
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }
}
