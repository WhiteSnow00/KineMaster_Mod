// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class EventRegistration
{
    private AtomicBoolean a;
    private EventRegistrationZombieListener b;
    private boolean c;
    
    public EventRegistration() {
        this.a = new AtomicBoolean(false);
        this.c = false;
    }
    
    public abstract EventRegistration a(final QuerySpec p0);
    
    public abstract DataEvent b(final Change p0, final QuerySpec p1);
    
    public abstract void c(final DatabaseError p0);
    
    public abstract void d(final DataEvent p0);
    
    @NotNull
    public abstract QuerySpec e();
    
    public abstract boolean f(final EventRegistration p0);
    
    public boolean g() {
        return this.c;
    }
    
    public boolean h() {
        return this.a.get();
    }
    
    public abstract boolean i(final Event.EventType p0);
    
    public void j(final boolean c) {
        this.c = c;
    }
    
    public void k(final EventRegistrationZombieListener b) {
        final boolean h = this.h();
        boolean b2 = true;
        Utilities.f(h ^ true);
        if (this.b != null) {
            b2 = false;
        }
        Utilities.f(b2);
        this.b = b;
    }
    
    public void l() {
        if (this.a.compareAndSet(false, true)) {
            final EventRegistrationZombieListener b = this.b;
            if (b != null) {
                b.a(this);
                this.b = null;
            }
        }
    }
}
