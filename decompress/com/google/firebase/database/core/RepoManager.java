// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

public class RepoManager
{
    private static final RepoManager b;
    private final Map<Context, Map<String, Repo>> a;
    
    static {
        b = new RepoManager();
    }
    
    public RepoManager() {
        this.a = new HashMap<Context, Map<String, Repo>>();
    }
    
    private Repo a(final Context context, final RepoInfo repoInfo, final FirebaseDatabase firebaseDatabase) throws DatabaseException {
        context.k();
        final StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(repoInfo.a);
        sb.append("/");
        sb.append(repoInfo.c);
        final String string = sb.toString();
        synchronized (this.a) {
            if (!this.a.containsKey(context)) {
                this.a.put(context, new HashMap<String, Repo>());
            }
            final Map map = this.a.get(context);
            if (!map.containsKey(string)) {
                final Repo repo = new Repo(repoInfo, context, firebaseDatabase);
                map.put(string, repo);
                return repo;
            }
            throw new IllegalStateException("createLocalRepo() called for existing repo.");
        }
    }
    
    public static Repo b(final Context context, final RepoInfo repoInfo, final FirebaseDatabase firebaseDatabase) throws DatabaseException {
        return RepoManager.b.a(context, repoInfo, firebaseDatabase);
    }
}
