// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.ChildEventListener;

public class ChildEventRegistration extends EventRegistration
{
    private final Repo d;
    private final ChildEventListener e;
    private final QuerySpec f;
    
    public ChildEventRegistration(@NotNull final Repo d, @NotNull final ChildEventListener e, @NotNull final QuerySpec f) {
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public EventRegistration a(final QuerySpec querySpec) {
        return new ChildEventRegistration(this.d, this.e, querySpec);
    }
    
    @Override
    public DataEvent b(final Change change, final QuerySpec querySpec) {
        final DataSnapshot a = InternalHelpers.a(InternalHelpers.c(this.d, querySpec.e().n(change.i())), change.k());
        String c;
        if (change.m() != null) {
            c = change.m().c();
        }
        else {
            c = null;
        }
        return new DataEvent(change.j(), this, a, c);
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
        final int n = ChildEventRegistration$a.a[dataEvent.b().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n == 4) {
                        this.e.e(dataEvent.e());
                    }
                }
                else {
                    this.e.d(dataEvent.e(), dataEvent.d());
                }
            }
            else {
                this.e.b(dataEvent.e(), dataEvent.d());
            }
        }
        else {
            this.e.c(dataEvent.e(), dataEvent.d());
        }
    }
    
    @NotNull
    @Override
    public QuerySpec e() {
        return this.f;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof ChildEventRegistration) {
            final ChildEventRegistration childEventRegistration = (ChildEventRegistration)o;
            if (childEventRegistration.e.equals(this.e) && childEventRegistration.d.equals(this.d) && childEventRegistration.f.equals(this.f)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean f(final EventRegistration eventRegistration) {
        return eventRegistration instanceof ChildEventRegistration && ((ChildEventRegistration)eventRegistration).e.equals(this.e);
    }
    
    @Override
    public int hashCode() {
        return (this.e.hashCode() * 31 + this.d.hashCode()) * 31 + this.f.hashCode();
    }
    
    @Override
    public boolean i(final Event.EventType eventType) {
        return eventType != Event.EventType.VALUE;
    }
    
    @Override
    public String toString() {
        return "ChildEventRegistration";
    }
}
