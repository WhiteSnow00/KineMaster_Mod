// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Validation;
import java.util.Objects;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.android.gms.common.internal.Preconditions;
import android.text.TextUtils;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.FirebaseApp;

public class FirebaseDatabase
{
    private final FirebaseApp a;
    private final RepoInfo b;
    private final DatabaseConfig c;
    @Nullable
    private EmulatedServiceSettings d;
    private Repo e;
    
    FirebaseDatabase(final FirebaseApp a, final RepoInfo b, final DatabaseConfig c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void a(final String s) {
        if (this.e == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Calls to ");
        sb.append(s);
        sb.append("() must be made before any other usage of FirebaseDatabase instance.");
        throw new DatabaseException(sb.toString());
    }
    
    private void b() {
        synchronized (this) {
            if (this.e == null) {
                this.b.a(this.d);
                this.e = RepoManager.b(this.c, this.b, this);
            }
        }
    }
    
    public static FirebaseDatabase c() {
        final FirebaseApp m = FirebaseApp.m();
        if (m != null) {
            return d(m);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }
    
    public static FirebaseDatabase d(final FirebaseApp firebaseApp) {
        String s;
        if ((s = firebaseApp.p().d()) == null) {
            if (firebaseApp.p().f() == null) {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Can't determine Firebase Database URL. Be sure to include a Project ID in your configuration.");
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("https://");
            sb.append(firebaseApp.p().f());
            sb.append("-default-rtdb.firebaseio.com");
            s = sb.toString();
        }
        return e(firebaseApp, s);
    }
    
    public static FirebaseDatabase e(final FirebaseApp firebaseApp, final String s) {
        synchronized (FirebaseDatabase.class) {
            if (TextUtils.isEmpty((CharSequence)s)) {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
            Preconditions.l(firebaseApp, "Provided FirebaseApp must not be null.");
            final a a = firebaseApp.j(a.class);
            Preconditions.l(a, "Firebase Database component is not present.");
            final ParsedUrl h = Utilities.h(s);
            if (h.b.isEmpty()) {
                return a.a(h.a);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Specified Database URL '");
            sb.append(s);
            sb.append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ");
            sb.append(h.b.toString());
            throw new DatabaseException(sb.toString());
        }
    }
    
    public static String g() {
        return "20.0.5";
    }
    
    public DatabaseReference f(final String s) {
        this.b();
        Objects.requireNonNull(s, "Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        Validation.f(s);
        return new DatabaseReference(this.e, new Path(s));
    }
    
    public void h(final boolean b) {
        synchronized (this) {
            this.a("setPersistenceEnabled");
            this.c.L(b);
        }
    }
}
