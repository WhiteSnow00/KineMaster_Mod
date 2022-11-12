// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.HashMap;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

public class EmailLinkParser
{
    private static final String CONTINUE_URL = "continueUrl";
    private static String LINK = "link";
    private static final String OOB_CODE = "oobCode";
    private Map<String, String> mParams;
    
    public EmailLinkParser(final String s) {
        Preconditions.g(s);
        final Map<String, String> uri = this.parseUri(Uri.parse(s));
        this.mParams = uri;
        if (!uri.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("Invalid link: no parameters found");
    }
    
    private Map<String, String> parseUri(final Uri uri) {
        final HashMap hashMap = new HashMap();
        try {
            for (final String s : uri.getQueryParameterNames()) {
                if (!s.equalsIgnoreCase(EmailLinkParser.LINK) && !s.equalsIgnoreCase("continueUrl")) {
                    final String queryParameter = uri.getQueryParameter(s);
                    if (queryParameter == null) {
                        continue;
                    }
                    hashMap.put(s, queryParameter);
                }
                else {
                    final Map<String, String> uri2 = this.parseUri(Uri.parse(uri.getQueryParameter(s)));
                    if (uri2 == null) {
                        continue;
                    }
                    hashMap.putAll(uri2);
                }
            }
            return hashMap;
        }
        catch (final Exception ex) {
            return hashMap;
        }
    }
    
    public String getAnonymousUserId() {
        return this.mParams.get("ui_auid");
    }
    
    public boolean getForceSameDeviceBit() {
        final String s = this.mParams.get("ui_sd");
        return !TextUtils.isEmpty((CharSequence)s) && s.equals("1");
    }
    
    public String getOobCode() {
        return this.mParams.get("oobCode");
    }
    
    public String getProviderId() {
        return this.mParams.get("ui_pid");
    }
    
    public String getSessionId() {
        return this.mParams.get("ui_sid");
    }
    
    public static class LinkParameters
    {
        public static final String ANONYMOUS_USER_ID_IDENTIFIER = "ui_auid";
        public static final String FORCE_SAME_DEVICE_IDENTIFIER = "ui_sd";
        public static final String PROVIDER_ID_IDENTIFIER = "ui_pid";
        public static final String SESSION_IDENTIFIER = "ui_sid";
    }
}
