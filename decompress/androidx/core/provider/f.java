// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.provider;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.CancellationSignal;
import android.content.Context;
import androidx.core.util.a;
import java.util.ArrayList;
import androidx.collection.g;
import java.util.concurrent.ExecutorService;
import android.graphics.Typeface;
import androidx.collection.e;

class f
{
    static final androidx.collection.e<String, Typeface> a;
    private static final ExecutorService b;
    static final Object c;
    static final g<String, ArrayList<a<e>>> d;
    
    static {
        a = new androidx.collection.e<String, Typeface>(16);
        b = h.a("fonts-androidx", 10, 10000);
        c = new Object();
        d = new g<String, ArrayList<a<e>>>();
    }
    
    private static String a(final androidx.core.provider.e e, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(e.d());
        sb.append("-");
        sb.append(n);
        return sb.toString();
    }
    
    private static int b(final androidx.core.provider.g.a a) {
        final int c = a.c();
        final int n = -3;
        final boolean b = true;
        if (c == 0) {
            final androidx.core.provider.g.b[] b2 = a.b();
            int n2 = b ? 1 : 0;
            if (b2 != null) {
                if (b2.length == 0) {
                    n2 = (b ? 1 : 0);
                }
                else {
                    final int length = b2.length;
                    final int n3 = 0;
                    int n4 = 0;
                    while (true) {
                        n2 = n3;
                        if (n4 >= length) {
                            break;
                        }
                        final int b3 = b2[n4].b();
                        if (b3 != 0) {
                            int n5;
                            if (b3 < 0) {
                                n5 = n;
                            }
                            else {
                                n5 = b3;
                            }
                            return n5;
                        }
                        ++n4;
                    }
                }
            }
            return n2;
        }
        if (a.c() != 1) {
            return -3;
        }
        return -2;
    }
    
    static e c(final String s, final Context context, final androidx.core.provider.e e, final int n) {
        final androidx.collection.e<String, Typeface> a = f.a;
        final Typeface typeface = a.get(s);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            final androidx.core.provider.g.a e2 = androidx.core.provider.d.e(context, e, null);
            final int b = b(e2);
            if (b != 0) {
                return new e(b);
            }
            final Typeface b2 = androidx.core.graphics.h.b(context, null, e2.b(), n);
            if (b2 != null) {
                a.put(s, b2);
                return new e(b2);
            }
            return new e(-3);
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return new e(-1);
        }
    }
    
    static Typeface d(final Context context, final androidx.core.provider.e e, final int n, final Executor executor, final androidx.core.provider.a a) {
        final String a2 = a(e, n);
        final Typeface typeface = f.a.get(a2);
        if (typeface != null) {
            a.b(new e(typeface));
            return typeface;
        }
        final a<e> a3 = new a<e>(a) {
            final androidx.core.provider.a a;
            
            public void a(final e e) {
                e e2 = e;
                if (e == null) {
                    e2 = new e(-3);
                }
                this.a.b(e2);
            }
            
            @Override
            public /* bridge */ void accept(final Object o) {
                this.a((e)o);
            }
        };
        synchronized (f.c) {
            final g<String, ArrayList<a<e>>> d = f.d;
            final ArrayList list = d.get(a2);
            if (list != null) {
                list.add(a3);
                return null;
            }
            final ArrayList<a<e>> list2 = new ArrayList<a<e>>();
            list2.add(a3);
            d.put(a2, list2);
            monitorexit(f.c);
            final Callable<e> callable = new Callable<e>(a2, context, e, n) {
                final String a;
                final Context b;
                final androidx.core.provider.e c;
                final int d;
                
                public e a() {
                    try {
                        return f.c(this.a, this.b, this.c, this.d);
                    }
                    finally {
                        return new e(-3);
                    }
                }
                
                @Override
                public /* bridge */ Object call() throws Exception {
                    return this.a();
                }
            };
            Executor b;
            if ((b = executor) == null) {
                b = f.b;
            }
            h.b(b, (Callable<Object>)callable, (a<Object>)new a<e>(a2) {
                final String a;
                
                public void a(final e e) {
                    synchronized (f.c) {
                        final g<String, ArrayList<a<e>>> d = f.d;
                        final ArrayList list = d.get(this.a);
                        if (list == null) {
                            return;
                        }
                        d.remove(this.a);
                        monitorexit(f.c);
                        for (int i = 0; i < list.size(); ++i) {
                            ((a<e>)list.get(i)).accept(e);
                        }
                    }
                }
                
                @Override
                public /* bridge */ void accept(final Object o) {
                    this.a((e)o);
                }
            });
            return null;
        }
    }
    
    static Typeface e(final Context context, final androidx.core.provider.e e, final androidx.core.provider.a a, final int n, final int n2) {
        final String a2 = a(e, n);
        final Typeface typeface = f.a.get(a2);
        if (typeface != null) {
            a.b(new e(typeface));
            return typeface;
        }
        if (n2 == -1) {
            final e c = c(a2, context, e, n);
            a.b(c);
            return c.a;
        }
        final Callable<e> callable = new Callable<e>(a2, context, e, n) {
            final String a;
            final Context b;
            final androidx.core.provider.e c;
            final int d;
            
            public e a() {
                return f.c(this.a, this.b, this.c, this.d);
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        };
        try {
            final e e2 = h.c(f.b, (Callable<e>)callable, n2);
            a.b(e2);
            return e2.a;
        }
        catch (final InterruptedException ex) {
            a.b(new e(-3));
            return null;
        }
    }
    
    static final class e
    {
        final Typeface a;
        final int b;
        
        e(final int b) {
            this.a = null;
            this.b = b;
        }
        
        e(final Typeface a) {
            this.a = a;
            this.b = 0;
        }
        
        boolean a() {
            return this.b == 0;
        }
    }
}
