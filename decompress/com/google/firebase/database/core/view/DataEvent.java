// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.core.EventRegistration;

public class DataEvent implements Event
{
    private final EventType a;
    private final EventRegistration b;
    private final DataSnapshot c;
    private final String d;
    
    public DataEvent(final EventType a, final EventRegistration b, final DataSnapshot c, final String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void a() {
        this.b.d(this);
    }
    
    public EventType b() {
        return this.a;
    }
    
    public Path c() {
        final Path d = this.c.d().d();
        if (this.a == EventType.VALUE) {
            return d;
        }
        return d.w();
    }
    
    public String d() {
        return this.d;
    }
    
    public DataSnapshot e() {
        return this.c;
    }
    
    @Override
    public String toString() {
        if (this.a == EventType.VALUE) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.c());
            sb.append(": ");
            sb.append(this.a);
            sb.append(": ");
            sb.append(this.c.f(true));
            return sb.toString();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(this.c());
        sb2.append(": ");
        sb2.append(this.a);
        sb2.append(": { ");
        sb2.append(this.c.c());
        sb2.append(": ");
        sb2.append(this.c.f(true));
        sb2.append(" }");
        return sb2.toString();
    }
}
