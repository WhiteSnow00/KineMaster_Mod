// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

public class ContinueUrlBuilder
{
    private StringBuilder mContinueUrl;
    
    public ContinueUrlBuilder(final String s) {
        Preconditions.g(s);
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("?");
        this.mContinueUrl = new StringBuilder(sb.toString());
    }
    
    private void addQueryParam(final String s, final String s2) {
        if (TextUtils.isEmpty((CharSequence)s2)) {
            return;
        }
        final StringBuilder mContinueUrl = this.mContinueUrl;
        String s3;
        if (mContinueUrl.charAt(mContinueUrl.length() - 1) == '?') {
            s3 = "";
        }
        else {
            s3 = "&";
        }
        this.mContinueUrl.append(String.format("%s%s=%s", s3, s, s2));
    }
    
    public ContinueUrlBuilder appendAnonymousUserId(final String s) {
        this.addQueryParam("ui_auid", s);
        return this;
    }
    
    public ContinueUrlBuilder appendForceSameDeviceBit(final boolean b) {
        String s;
        if (b) {
            s = "1";
        }
        else {
            s = "0";
        }
        this.addQueryParam("ui_sd", s);
        return this;
    }
    
    public ContinueUrlBuilder appendProviderId(final String s) {
        this.addQueryParam("ui_pid", s);
        return this;
    }
    
    public ContinueUrlBuilder appendSessionId(final String s) {
        this.addQueryParam("ui_sid", s);
        return this;
    }
    
    public String build() {
        final StringBuilder mContinueUrl = this.mContinueUrl;
        if (mContinueUrl.charAt(mContinueUrl.length() - 1) == '?') {
            final StringBuilder mContinueUrl2 = this.mContinueUrl;
            mContinueUrl2.setLength(mContinueUrl2.length() - 1);
        }
        return this.mContinueUrl.toString();
    }
}
