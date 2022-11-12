// 
// Decompiled by Procyon v0.6.0
// 

package f2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import v2.k;
import java.util.HashMap;
import java.util.Map;

final class c
{
    private final Map<String, a> a;
    private final b b;
    
    c() {
        this.a = new HashMap<String, a>();
        this.b = new b();
    }
    
    void a(final String s) {
        synchronized (this) {
            Object a;
            if ((a = this.a.get(s)) == null) {
                a = this.b.a();
                this.a.put(s, (a)a);
            }
            ++((a)a).b;
            monitorexit(this);
            ((a)a).a.lock();
        }
    }
    
    void b(final String s) {
        synchronized (this) {
            final a a = k.d(this.a.get(s));
            int b = a.b;
            if (b >= 1) {
                --b;
                if ((a.b = b) == 0) {
                    final a a2 = this.a.remove(s);
                    if (!a2.equals(a)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Removed the wrong lock, expected to remove: ");
                        sb.append(a);
                        sb.append(", but actually removed: ");
                        sb.append(a2);
                        sb.append(", safeKey: ");
                        sb.append(s);
                        throw new IllegalStateException(sb.toString());
                    }
                    this.b.b(a2);
                }
                monitorexit(this);
                a.a.unlock();
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot release a lock that is not held, safeKey: ");
            sb2.append(s);
            sb2.append(", interestedThreads: ");
            sb2.append(a.b);
            throw new IllegalStateException(sb2.toString());
        }
    }
    
    private static class a
    {
        final Lock a;
        int b;
        
        a() {
            this.a = new ReentrantLock();
        }
    }
    
    private static class b
    {
        private final Queue<a> a;
        
        b() {
            this.a = new ArrayDeque<a>();
        }
        
        a a() {
            Object a = this.a;
            synchronized (a) {
                final a a2 = this.a.poll();
                monitorexit(a);
                a = a2;
                if (a2 == null) {
                    a = new a();
                }
                return (a)a;
            }
        }
        
        void b(final a a) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(a);
                }
            }
        }
    }
}
