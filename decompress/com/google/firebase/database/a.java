// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.android.AndroidAppCheckTokenProvider;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import java.util.HashMap;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.core.RepoInfo;
import java.util.Map;

class a
{
    private final Map<RepoInfo, FirebaseDatabase> a;
    private final FirebaseApp b;
    private final TokenProvider c;
    private final TokenProvider d;
    
    a(final FirebaseApp b, final Deferred<InternalAuthProvider> deferred, final Deferred<InternalAppCheckTokenProvider> deferred2) {
        this.a = new HashMap<RepoInfo, FirebaseDatabase>();
        this.b = b;
        this.c = new AndroidAuthTokenProvider(deferred);
        this.d = new AndroidAppCheckTokenProvider(deferred2);
    }
    
    FirebaseDatabase a(final RepoInfo repoInfo) {
        synchronized (this) {
            FirebaseDatabase firebaseDatabase;
            if ((firebaseDatabase = this.a.get(repoInfo)) == null) {
                final DatabaseConfig databaseConfig = new DatabaseConfig();
                if (!this.b.w()) {
                    databaseConfig.M(this.b.o());
                }
                databaseConfig.K(this.b);
                databaseConfig.J(this.c);
                databaseConfig.I(this.d);
                firebaseDatabase = new FirebaseDatabase(this.b, repoInfo, databaseConfig);
                this.a.put(repoInfo, firebaseDatabase);
            }
            return firebaseDatabase;
        }
    }
}
