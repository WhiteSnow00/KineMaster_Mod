// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class RewardData implements Serializable
{
    private static final long serialVersionUID = -6264212909606201882L;
    private String mCurrency;
    private int mQuantity;
    private String mUserID;
    
    public RewardData(final String s, final String s2) {
        this(s, s2, 0);
    }
    
    public RewardData(final String mUserID, final String mCurrency, final int mQuantity) {
        this.mUserID = mUserID;
        this.mCurrency = mCurrency;
        this.mQuantity = mQuantity;
    }
    
    public String getCurrency() {
        return this.mCurrency;
    }
    
    public int getQuantity() {
        return this.mQuantity;
    }
    
    public String getUserID() {
        return this.mUserID;
    }
}
