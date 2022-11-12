// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.HashSet;
import java.util.ArrayList;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.annotations.NotNull;
import java.util.List;
import java.util.HashMap;

public class ZombieEventManager implements EventRegistrationZombieListener
{
    private static ZombieEventManager b;
    final HashMap<EventRegistration, List<EventRegistration>> a;
    
    static {
        ZombieEventManager.b = new ZombieEventManager();
    }
    
    private ZombieEventManager() {
        this.a = new HashMap<EventRegistration, List<EventRegistration>>();
    }
    
    @NotNull
    public static ZombieEventManager b() {
        return ZombieEventManager.b;
    }
    
    private void d(final EventRegistration eventRegistration) {
        synchronized (this.a) {
            final List list = this.a.get(eventRegistration);
            final boolean b = true;
            final int n = 0;
            int n2 = 0;
            int i = 0;
            Label_0105: {
                if (list != null) {
                    while (true) {
                        while (i < list.size()) {
                            if (list.get(i) == eventRegistration) {
                                list.remove(i);
                                final int n3 = 1;
                                n2 = n3;
                                if (list.isEmpty()) {
                                    this.a.remove(eventRegistration);
                                    n2 = n3;
                                }
                                break Label_0105;
                            }
                            else {
                                ++i;
                            }
                        }
                        final int n3 = 0;
                        continue;
                    }
                }
            }
            boolean b2 = b;
            if (n2 == 0) {
                b2 = (!eventRegistration.g() && b);
            }
            Utilities.f(b2);
            if (!eventRegistration.e().f()) {
                final EventRegistration a = eventRegistration.a(QuerySpec.a(eventRegistration.e().e()));
                final List list2 = this.a.get(a);
                if (list2 != null) {
                    for (int j = n; j < list2.size(); ++j) {
                        if (list2.get(j) == eventRegistration) {
                            list2.remove(j);
                            break;
                        }
                    }
                    if (list2.isEmpty()) {
                        this.a.remove(a);
                    }
                }
            }
        }
    }
    
    @Override
    public void a(final EventRegistration eventRegistration) {
        this.d(eventRegistration);
    }
    
    public void c(final EventRegistration eventRegistration) {
        synchronized (this.a) {
            List list;
            if ((list = this.a.get(eventRegistration)) == null) {
                list = new ArrayList();
                this.a.put(eventRegistration, list);
            }
            list.add(eventRegistration);
            if (!eventRegistration.e().f()) {
                final EventRegistration a = eventRegistration.a(QuerySpec.a(eventRegistration.e().e()));
                List list2;
                if ((list2 = this.a.get(a)) == null) {
                    list2 = new ArrayList();
                    this.a.put(a, list2);
                }
                list2.add(eventRegistration);
            }
            eventRegistration.j(true);
            eventRegistration.k(this);
        }
    }
    
    public void e(EventRegistration eventRegistration) {
        synchronized (this.a) {
            final List list = this.a.get(eventRegistration);
            if (list != null && !list.isEmpty()) {
                if (eventRegistration.e().f()) {
                    final HashSet set = new HashSet();
                    for (int i = list.size() - 1; i >= 0; --i) {
                        eventRegistration = (EventRegistration)list.get(i);
                        if (!set.contains(eventRegistration.e())) {
                            set.add(eventRegistration.e());
                            eventRegistration.l();
                        }
                    }
                }
                else {
                    ((EventRegistration)list.get(0)).l();
                }
            }
        }
    }
}
