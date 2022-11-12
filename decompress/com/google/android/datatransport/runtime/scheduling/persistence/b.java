// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import java.util.Objects;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

final class b extends PersistedEvent
{
    private final long a;
    private final TransportContext b;
    private final EventInternal c;
    
    b(final long a, final TransportContext b, final EventInternal c) {
        this.a = a;
        Objects.requireNonNull(b, "Null transportContext");
        this.b = b;
        Objects.requireNonNull(c, "Null event");
        this.c = c;
    }
    
    @Override
    public EventInternal b() {
        return this.c;
    }
    
    @Override
    public long c() {
        return this.a;
    }
    
    @Override
    public TransportContext d() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof PersistedEvent) {
            final PersistedEvent persistedEvent = (PersistedEvent)o;
            if (this.a != persistedEvent.c() || !this.b.equals(persistedEvent.d()) || !this.c.equals(persistedEvent.b())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        return (((int)(a ^ a >>> 32) ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PersistedEvent{id=");
        sb.append(this.a);
        sb.append(", transportContext=");
        sb.append(this.b);
        sb.append(", event=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
