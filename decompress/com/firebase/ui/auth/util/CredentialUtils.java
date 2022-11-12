// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util;

import android.util.Log;
import android.text.TextUtils;
import android.net.Uri;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.firebase.auth.FirebaseUser;

public class CredentialUtils
{
    private static final String TAG = "CredentialUtils";
    
    private CredentialUtils() {
        throw new AssertionError((Object)"No instance for you!");
    }
    
    public static Credential buildCredential(final FirebaseUser firebaseUser, final String s, final String s2) {
        final String m1 = firebaseUser.M1();
        final String o1 = firebaseUser.O1();
        Uri parse;
        if (firebaseUser.P1() == null) {
            parse = null;
        }
        else {
            parse = Uri.parse(firebaseUser.P1().toString());
        }
        if (TextUtils.isEmpty((CharSequence)m1) && TextUtils.isEmpty((CharSequence)o1)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("User (accountType=");
            sb.append(s2);
            sb.append(") has no email or phone number, cannot build credential.");
            Log.w("CredentialUtils", sb.toString());
            return null;
        }
        if (s == null && s2 == null) {
            Log.w("CredentialUtils", "User has no accountType or password, cannot build credential.");
            return null;
        }
        String s3 = m1;
        if (TextUtils.isEmpty((CharSequence)m1)) {
            s3 = o1;
        }
        final Credential.Builder e = new Credential.Builder(s3).c(firebaseUser.L1()).e(parse);
        if (TextUtils.isEmpty((CharSequence)s)) {
            e.b(s2);
        }
        else {
            e.d(s);
        }
        return e.a();
    }
    
    public static Credential buildCredentialOrThrow(final FirebaseUser firebaseUser, final String s, final String s2) {
        final Credential buildCredential = buildCredential(firebaseUser, s, s2);
        if (buildCredential != null) {
            return buildCredential;
        }
        throw new IllegalStateException("Unable to build credential");
    }
}
