// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

public class ApiException extends Exception
{
    @Deprecated
    protected final Status mStatus;
    
    public ApiException(final Status mStatus) {
        final int m1 = mStatus.M1();
        String n1;
        if (mStatus.N1() != null) {
            n1 = mStatus.N1();
        }
        else {
            n1 = "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(m1);
        sb.append(": ");
        sb.append(n1);
        super(sb.toString());
        this.mStatus = mStatus;
    }
    
    public Status getStatus() {
        return this.mStatus;
    }
    
    public int getStatusCode() {
        return this.mStatus.M1();
    }
    
    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.N1();
    }
}
