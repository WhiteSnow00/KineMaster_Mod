// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import com.google.android.gms.internal.firebase_auth_api.zzug;
import android.content.Context;
import com.google.firebase.auth.internal.GenericIdpActivity;
import android.content.Intent;
import android.app.Activity;
import com.google.android.gms.internal.firebase_auth_api.zzvr;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Bundle;

public class OAuthProvider extends FederatedAuthProvider
{
    private final Bundle a;
    
    OAuthProvider(final Bundle a, final zzad zzad) {
        this.a = a;
    }
    
    public static Builder d(final String s) {
        return e(s, FirebaseAuth.getInstance());
    }
    
    public static Builder e(final String s, final FirebaseAuth firebaseAuth) {
        Preconditions.g(s);
        Preconditions.k(firebaseAuth);
        if ("facebook.com".equals(s) && !zzvr.zzg(firebaseAuth.g())) {
            throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
        }
        return new Builder(s, firebaseAuth, null);
    }
    
    @Override
    public final void a(final Activity activity) {
        final Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass((Context)activity, (Class)GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.a);
        activity.startActivity(intent);
    }
    
    @Override
    public final void b(final Activity activity) {
        final Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass((Context)activity, (Class)GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.a);
        activity.startActivity(intent);
    }
    
    public String c() {
        return this.a.getString("com.google.firebase.auth.KEY_PROVIDER_ID");
    }
    
    public static class Builder
    {
        private final FirebaseAuth a;
        final Bundle b;
        private final Bundle c;
        
        Builder(final String s, final FirebaseAuth a, final zzab zzab) {
            final Bundle b = new Bundle();
            this.b = b;
            final Bundle c = new Bundle();
            this.c = c;
            this.a = a;
            b.putString("com.google.firebase.auth.KEY_API_KEY", a.g().p().b());
            b.putString("com.google.firebase.auth.KEY_PROVIDER_ID", s);
            b.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", c);
            b.putString("com.google.firebase.auth.internal.CLIENT_VERSION", ((zzug)zzug.zza()).zzb());
            b.putString("com.google.firebase.auth.KEY_TENANT_ID", a.l());
            b.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", a.g().o());
        }
        
        public Builder a(final Map<String, String> map) {
            for (final Map.Entry entry : map.entrySet()) {
                this.c.putString((String)entry.getKey(), (String)entry.getValue());
            }
            return this;
        }
        
        public OAuthProvider b() {
            return new OAuthProvider(this.b, null);
        }
        
        public Builder c(final List<String> list) {
            this.b.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList((Collection<? extends E>)list));
            return this;
        }
    }
    
    public static class CredentialBuilder
    {
    }
}
