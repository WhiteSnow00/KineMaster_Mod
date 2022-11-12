// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;

public class CommonStatusCodes
{
    @KeepForSdk
    protected CommonStatusCodes() {
    }
    
    public static String a(final int n) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("unknown status code: ");
                sb.append(n);
                return sb.toString();
            }
            case 22: {
                return "RECONNECTION_TIMED_OUT";
            }
            case 21: {
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            }
            case 20: {
                return "CONNECTION_SUSPENDED_DURING_CALL";
            }
            case 19: {
                return "REMOTE_EXCEPTION";
            }
            case 18: {
                return "DEAD_CLIENT";
            }
            case 17: {
                return "API_NOT_CONNECTED";
            }
            case 16: {
                return "CANCELED";
            }
            case 15: {
                return "TIMEOUT";
            }
            case 14: {
                return "INTERRUPTED";
            }
            case 13: {
                return "ERROR";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 0: {
                return "SUCCESS";
            }
            case -1: {
                return "SUCCESS_CACHE";
            }
        }
    }
}
