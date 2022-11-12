// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import java.util.Objects;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;

public class Query
{
    protected final Repo a;
    protected final Path b;
    protected final QueryParams c;
    private final boolean d;
    
    Query(final Repo a, final Path b) {
        this.a = a;
        this.b = b;
        this.c = QueryParams.i;
        this.d = false;
    }
    
    private void a(final EventRegistration eventRegistration) {
        ZombieEventManager.b().c(eventRegistration);
        this.a.U(new Runnable(this, eventRegistration) {
            final EventRegistration a;
            final Query b;
            
            @Override
            public void run() {
                this.b.a.C(this.a);
            }
        });
    }
    
    private void g(final EventRegistration eventRegistration) {
        ZombieEventManager.b().e(eventRegistration);
        this.a.U(new Runnable(this, eventRegistration) {
            final EventRegistration a;
            final Query b;
            
            @Override
            public void run() {
                this.b.a.P(this.a);
            }
        });
    }
    
    public void b(final ValueEventListener valueEventListener) {
        this.a(new ValueEventRegistration(this.a, new ValueEventListener(this, valueEventListener) {
            final ValueEventListener a;
            final Query b;
            
            @Override
            public void a(final DatabaseError databaseError) {
                this.a.a(databaseError);
            }
            
            @Override
            public void b(final DataSnapshot dataSnapshot) {
                this.b.f(this);
                this.a.b(dataSnapshot);
            }
        }, this.e()));
    }
    
    public ValueEventListener c(final ValueEventListener valueEventListener) {
        this.a(new ValueEventRegistration(this.a, valueEventListener, this.e()));
        return valueEventListener;
    }
    
    public Path d() {
        return this.b;
    }
    
    public QuerySpec e() {
        return new QuerySpec(this.b, this.c);
    }
    
    public void f(final ValueEventListener valueEventListener) {
        Objects.requireNonNull(valueEventListener, "listener must not be null");
        this.g(new ValueEventRegistration(this.a, valueEventListener, this.e()));
    }
}
