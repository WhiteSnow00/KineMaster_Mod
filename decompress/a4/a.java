// 
// Decompiled by Procyon v0.6.0
// 

package a4;

import android.os.HandlerThread;

public final class a implements Runnable
{
    public final HandlerThread a;
    
    public a(final HandlerThread a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.quit();
    }
}
