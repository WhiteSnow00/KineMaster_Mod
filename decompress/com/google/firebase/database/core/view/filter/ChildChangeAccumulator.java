// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;

public class ChildChangeAccumulator
{
    private final Map<ChildKey, Change> a;
    
    public ChildChangeAccumulator() {
        this.a = new HashMap<ChildKey, Change>();
    }
    
    public List<Change> a() {
        return new ArrayList<Change>(this.a.values());
    }
    
    public void b(final Change change) {
        final Event.EventType j = change.j();
        final ChildKey i = change.i();
        final Event.EventType child_ADDED = Event.EventType.CHILD_ADDED;
        Utilities.g(j == child_ADDED || j == Event.EventType.CHILD_CHANGED || j == Event.EventType.CHILD_REMOVED, "Only child changes supported for tracking");
        Utilities.f(true ^ change.i().m());
        if (this.a.containsKey(i)) {
            final Change change2 = this.a.get(i);
            final Event.EventType k = change2.j();
            if (j == child_ADDED && k == Event.EventType.CHILD_REMOVED) {
                this.a.put(change.i(), Change.d(i, change.k(), change2.k()));
            }
            else {
                final Event.EventType child_REMOVED = Event.EventType.CHILD_REMOVED;
                if (j == child_REMOVED && k == child_ADDED) {
                    this.a.remove(i);
                }
                else if (j == child_REMOVED && k == Event.EventType.CHILD_CHANGED) {
                    this.a.put(i, Change.g(i, change2.l()));
                }
                else {
                    final Event.EventType child_CHANGED = Event.EventType.CHILD_CHANGED;
                    if (j == child_CHANGED && k == child_ADDED) {
                        this.a.put(i, Change.b(i, change.k()));
                    }
                    else {
                        if (j != child_CHANGED || k != child_CHANGED) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Illegal combination of changes: ");
                            sb.append(change);
                            sb.append(" occurred after ");
                            sb.append(change2);
                            throw new IllegalStateException(sb.toString());
                        }
                        this.a.put(i, Change.d(i, change.k(), change2.l()));
                    }
                }
            }
        }
        else {
            this.a.put(change.i(), change);
        }
    }
}
