// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;

public class CancelEvent implements Event
{
    private final Path a;
    private final EventRegistration b;
    private final DatabaseError c;
    
    public CancelEvent(final EventRegistration b, final DatabaseError c, final Path a) {
        this.b = b;
        this.a = a;
        this.c = c;
    }
    
    @Override
    public void a() {
        this.b.c(this.c);
    }
    
    public Path b() {
        return this.a;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.b());
        sb.append(":CANCEL");
        return sb.toString();
    }
}
