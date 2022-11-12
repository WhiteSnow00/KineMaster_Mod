// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.core.EventTarget;

public class EventRaiser
{
    private final EventTarget a;
    private final LogWrapper b;
    
    public EventRaiser(final Context context) {
        this.a = context.o();
        this.b = context.q("EventRaiser");
    }
    
    static LogWrapper a(final EventRaiser eventRaiser) {
        return eventRaiser.b;
    }
    
    public void b(final List<? extends Event> list) {
        if (this.b.f()) {
            final LogWrapper b = this.b;
            final StringBuilder sb = new StringBuilder();
            sb.append("Raising ");
            sb.append(list.size());
            sb.append(" event(s)");
            b.b(sb.toString(), new Object[0]);
        }
        this.a.b(new Runnable(this, new ArrayList((Collection<? extends E>)list)) {
            final ArrayList a;
            final EventRaiser b;
            
            @Override
            public void run() {
                for (final Event event : this.a) {
                    if (EventRaiser.a(this.b).f()) {
                        final LogWrapper a = EventRaiser.a(this.b);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Raising ");
                        sb.append(event.toString());
                        a.b(sb.toString(), new Object[0]);
                    }
                    event.a();
                }
            }
        });
    }
}
