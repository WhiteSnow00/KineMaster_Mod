// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import android.content.SharedPreferences;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.User;
import java.util.Iterator;
import android.content.SharedPreferences$Editor;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import com.google.firebase.auth.AuthCredential;
import java.util.Set;

public class EmailLinkPersistenceManager
{
    private static final Set<String> KEYS;
    private static final String KEY_ANONYMOUS_USER_ID = "com.firebase.ui.auth.data.client.auid";
    private static final String KEY_EMAIL = "com.firebase.ui.auth.data.client.email";
    private static final String KEY_IDP_SECRET = "com.firebase.ui.auth.data.client.idpSecret";
    private static final String KEY_IDP_TOKEN = "com.firebase.ui.auth.data.client.idpToken";
    private static final String KEY_PROVIDER = "com.firebase.ui.auth.data.client.provider";
    private static final String KEY_SESSION_ID = "com.firebase.ui.auth.data.client.sid";
    private static final String SHARED_PREF_NAME = "com.firebase.ui.auth.util.data.EmailLinkPersistenceManager";
    private static final EmailLinkPersistenceManager instance;
    private AuthCredential mCredentialForLinking;
    
    static {
        KEYS = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Arrays.asList("com.firebase.ui.auth.data.client.email", "com.firebase.ui.auth.data.client.provider", "com.firebase.ui.auth.data.client.idpToken", "com.firebase.ui.auth.data.client.idpSecret")));
        instance = new EmailLinkPersistenceManager();
    }
    
    public static EmailLinkPersistenceManager getInstance() {
        return EmailLinkPersistenceManager.instance;
    }
    
    public void clearAllData(final Context context) {
        Preconditions.k(context);
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0).edit();
        final Iterator<String> iterator = EmailLinkPersistenceManager.KEYS.iterator();
        while (iterator.hasNext()) {
            edit.remove((String)iterator.next());
        }
        edit.apply();
    }
    
    public SessionRecord retrieveSessionRecord(final Context context) {
        Preconditions.k(context);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0);
        final String string = sharedPreferences.getString("com.firebase.ui.auth.data.client.email", (String)null);
        final String string2 = sharedPreferences.getString("com.firebase.ui.auth.data.client.sid", (String)null);
        if (string != null && string2 != null) {
            final String string3 = sharedPreferences.getString("com.firebase.ui.auth.data.client.auid", (String)null);
            final String string4 = sharedPreferences.getString("com.firebase.ui.auth.data.client.provider", (String)null);
            final String string5 = sharedPreferences.getString("com.firebase.ui.auth.data.client.idpToken", (String)null);
            final String string6 = sharedPreferences.getString("com.firebase.ui.auth.data.client.idpSecret", (String)null);
            final SessionRecord setEmail = new SessionRecord(string2, string3).setEmail(string);
            if (string4 != null && (string5 != null || this.mCredentialForLinking != null)) {
                setEmail.setIdpResponseForLinking(new IdpResponse.Builder(new User.Builder(string4, string).build()).setPendingCredential(this.mCredentialForLinking).setToken(string5).setSecret(string6).setNewUser(false).build());
            }
            this.mCredentialForLinking = null;
            return setEmail;
        }
        return null;
    }
    
    public void saveEmail(final Context context, final String s, final String s2, final String s3) {
        Preconditions.k(context);
        Preconditions.k(s);
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0).edit();
        edit.putString("com.firebase.ui.auth.data.client.email", s);
        edit.putString("com.firebase.ui.auth.data.client.auid", s3);
        edit.putString("com.firebase.ui.auth.data.client.sid", s2);
        edit.apply();
    }
    
    public void saveIdpResponseForLinking(final Context context, final IdpResponse idpResponse) {
        if (idpResponse.hasCredentialForLinking()) {
            this.mCredentialForLinking = idpResponse.getCredentialForLinking();
        }
        Preconditions.k(context);
        Preconditions.k(idpResponse);
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.firebase.ui.auth.util.data.EmailLinkPersistenceManager", 0).edit();
        edit.putString("com.firebase.ui.auth.data.client.email", idpResponse.getEmail());
        edit.putString("com.firebase.ui.auth.data.client.provider", idpResponse.getProviderType());
        edit.putString("com.firebase.ui.auth.data.client.idpToken", idpResponse.getIdpToken());
        edit.putString("com.firebase.ui.auth.data.client.idpSecret", idpResponse.getIdpSecret());
        edit.apply();
    }
    
    public static class SessionRecord
    {
        private String mAnonymousUserId;
        private String mEmail;
        private IdpResponse mIdpResponseForLinking;
        private String mSessionId;
        
        public SessionRecord(final String mSessionId, final String mAnonymousUserId) {
            Preconditions.k(mSessionId);
            this.mSessionId = mSessionId;
            this.mAnonymousUserId = mAnonymousUserId;
        }
        
        public String getAnonymousUserId() {
            return this.mAnonymousUserId;
        }
        
        public String getEmail() {
            return this.mEmail;
        }
        
        public IdpResponse getIdpResponseForLinking() {
            return this.mIdpResponseForLinking;
        }
        
        public String getSessionId() {
            return this.mSessionId;
        }
        
        public SessionRecord setEmail(final String mEmail) {
            this.mEmail = mEmail;
            return this;
        }
        
        public SessionRecord setIdpResponseForLinking(final IdpResponse mIdpResponseForLinking) {
            this.mIdpResponseForLinking = mIdpResponseForLinking;
            return this;
        }
    }
}
