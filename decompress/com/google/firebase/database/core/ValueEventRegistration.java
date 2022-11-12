// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.ValueEventListener;

public class ValueEventRegistration extends EventRegistration
{
    private final Repo d;
    private final ValueEventListener e;
    private final QuerySpec f;
    
    public ValueEventRegistration(final Repo d, final ValueEventListener e, @NotNull final QuerySpec f) {
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public EventRegistration a(final QuerySpec querySpec) {
        return new ValueEventRegistration(this.d, this.e, querySpec);
    }
    
    @Override
    public DataEvent b(final Change change, final QuerySpec querySpec) {
        return new DataEvent(Event.EventType.VALUE, this, InternalHelpers.a(InternalHelpers.c(this.d, querySpec.e()), change.k()), null);
    }
    
    @Override
    public void c(final DatabaseError databaseError) {
        this.e.a(databaseError);
    }
    
    @Override
    public void d(final DataEvent dataEvent) {
        if (this.h()) {
            return;
        }
        this.e.b(dataEvent.e());
    }
    
    @NotNull
    @Override
    public QuerySpec e() {
        return this.f;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof ValueEventRegistration) {
            final ValueEventRegistration valueEventRegistration = (ValueEventRegistration)o;
            if (valueEventRegistration.e.equals(this.e) && valueEventRegistration.d.equals(this.d) && valueEventRegistration.f.equals(this.f)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean f(final EventRegistration eventRegistration) {
        return eventRegistration instanceof ValueEventRegistration && ((ValueEventRegistration)eventRegistration).e.equals(this.e);
    }
    
    @Override
    public int hashCode() {
        return (this.e.hashCode() * 31 + this.d.hashCode()) * 31 + this.f.hashCode();
    }
    
    @Override
    public boolean i(final Event.EventType eventType) {
        return eventType == Event.EventType.VALUE;
    }
    
    @Override
    public String toString() {
        return "ValueEventRegistration";
    }
}
