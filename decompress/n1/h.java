// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import androidx.work.WorkerParameters;
import f1.i;

public class h implements Runnable
{
    private i a;
    private String b;
    private WorkerParameters.a c;
    
    public h(final i a, final String b, final WorkerParameters.a c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void run() {
        this.a.m().k(this.b, this.c);
    }
}
