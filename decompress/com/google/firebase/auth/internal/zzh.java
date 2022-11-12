// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.auth.zze;
import com.google.firebase.auth.PlayGamesAuthCredential;
import com.google.firebase.auth.GithubAuthCredential;
import com.google.firebase.auth.TwitterAuthCredential;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase-auth-api.zzxq;
import com.google.firebase.auth.AuthCredential;

public final class zzh
{
    public static zzxq a(final AuthCredential authCredential, final String s) {
        Preconditions.k(authCredential);
        if (GoogleAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return GoogleAuthCredential.M1((GoogleAuthCredential)authCredential, s);
        }
        if (FacebookAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return FacebookAuthCredential.M1((FacebookAuthCredential)authCredential, s);
        }
        if (TwitterAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return TwitterAuthCredential.M1((TwitterAuthCredential)authCredential, s);
        }
        if (GithubAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return GithubAuthCredential.M1((GithubAuthCredential)authCredential, s);
        }
        if (PlayGamesAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return PlayGamesAuthCredential.M1((PlayGamesAuthCredential)authCredential, s);
        }
        if (zze.class.isAssignableFrom(authCredential.getClass())) {
            return zze.R1((zze)authCredential, s);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
