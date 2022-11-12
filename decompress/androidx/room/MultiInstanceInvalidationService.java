// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import android.os.IBinder;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import java.util.HashMap;
import android.app.Service;

public class MultiInstanceInvalidationService extends Service
{
    int a;
    final HashMap<Integer, String> b;
    final RemoteCallbackList<s> c;
    private final t.a d;
    
    public MultiInstanceInvalidationService() {
        this.a = 0;
        this.b = new HashMap<Integer, String>();
        this.c = new RemoteCallbackList<s>() {
            final MultiInstanceInvalidationService a;
            
            public void a(final s s, final Object o) {
                this.a.b.remove((int)o);
            }
            
            public /* bridge */ void onCallbackDied(final IInterface interface1, final Object o) {
                this.a((s)interface1, o);
            }
        };
        this.d = new t.a() {
            final MultiInstanceInvalidationService a;
            
            public int B0(final s s, final String s2) {
                if (s2 == null) {
                    return 0;
                }
                synchronized (this.a.c) {
                    final MultiInstanceInvalidationService a = this.a;
                    final int a2 = a.a + 1;
                    a.a = a2;
                    if (a.c.register((IInterface)s, (Object)a2)) {
                        this.a.b.put(a2, s2);
                        return a2;
                    }
                    final MultiInstanceInvalidationService a3 = this.a;
                    --a3.a;
                    return 0;
                }
            }
            
            public void g0(final int n, final String[] array) {
                synchronized (this.a.c) {
                    final String s = this.a.b.get(n);
                    if (s == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    final int beginBroadcast = this.a.c.beginBroadcast();
                    int i = 0;
                    while (i < beginBroadcast) {
                        try {
                            final int intValue = (int)this.a.c.getBroadcastCookie(i);
                            final String s2 = this.a.b.get(intValue);
                            if (n != intValue) {
                                if (s.equals(s2)) {
                                    try {
                                        ((s)this.a.c.getBroadcastItem(i)).m(array);
                                    }
                                    catch (final RemoteException ex) {
                                        Log.w("ROOM", "Error invoking a remote callback", (Throwable)ex);
                                    }
                                }
                            }
                            ++i;
                            continue;
                        }
                        finally {
                            this.a.c.finishBroadcast();
                        }
                        break;
                    }
                    this.a.c.finishBroadcast();
                }
            }
            
            public void o1(final s s, final int n) {
                synchronized (this.a.c) {
                    this.a.c.unregister((IInterface)s);
                    this.a.b.remove(n);
                }
            }
        };
    }
    
    public IBinder onBind(final Intent intent) {
        return (IBinder)this.d;
    }
}
