// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import androidx.work.impl.utils.futures.b;
import androidx.lifecycle.z;
import e1.i;

public class c implements i
{
    private final z<b> c;
    private final androidx.work.impl.utils.futures.b<b.c> d;
    
    public c() {
        this.c = new z<b>();
        this.d = androidx.work.impl.utils.futures.b.t();
        this.a((b)i.b);
    }
    
    public void a(final b b) {
        this.c.postValue(b);
        if (b instanceof b.c) {
            this.d.p((b.c)b);
        }
        else if (b instanceof b.a) {
            this.d.q(((b.a)b).a());
        }
    }
}
