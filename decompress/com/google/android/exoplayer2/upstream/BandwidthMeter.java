// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.Iterator;
import com.google.android.exoplayer2.util.Assertions;
import java.util.concurrent.CopyOnWriteArrayList;
import android.os.Handler;

public interface BandwidthMeter
{
    default long a() {
        return -9223372036854775807L;
    }
    
    TransferListener c();
    
    void d(final EventListener p0);
    
    long e();
    
    void g(final Handler p0, final EventListener p1);
    
    public interface EventListener
    {
        void u(final int p0, final long p1, final long p2);
        
        public static final class EventDispatcher
        {
            private final CopyOnWriteArrayList<a> a;
            
            public EventDispatcher() {
                this.a = new CopyOnWriteArrayList<a>();
            }
            
            public static void a(final a a, final int n, final long n2, final long n3) {
                d(a, n, n2, n3);
            }
            
            private static void d(final a a, final int n, final long n2, final long n3) {
                EventDispatcher.a.a(a).u(n, n2, n3);
            }
            
            public void b(final Handler handler, final EventListener eventListener) {
                Assertions.e(handler);
                Assertions.e(eventListener);
                this.e(eventListener);
                this.a.add(new a(handler, eventListener));
            }
            
            public void c(final int n, final long n2, final long n3) {
                for (final a a : this.a) {
                    if (!EventDispatcher.a.b(a)) {
                        EventDispatcher.a.c(a).post((Runnable)new com.google.android.exoplayer2.upstream.a(a, n, n2, n3));
                    }
                }
            }
            
            public void e(final EventListener eventListener) {
                for (final a a : this.a) {
                    if (EventDispatcher.a.a(a) == eventListener) {
                        a.d();
                        this.a.remove(a);
                    }
                }
            }
            
            private static final class a
            {
                private final Handler a;
                private final EventListener b;
                private boolean c;
                
                public a(final Handler a, final EventListener b) {
                    this.a = a;
                    this.b = b;
                }
                
                static EventListener a(final a a) {
                    return a.b;
                }
                
                static boolean b(final a a) {
                    return a.c;
                }
                
                static Handler c(final a a) {
                    return a.a;
                }
                
                public void d() {
                    this.c = true;
                }
            }
        }
    }
}
