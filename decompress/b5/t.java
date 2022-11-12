// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;

public final class t implements Runnable
{
    public final ForegroundNotifier a;
    
    public t(final ForegroundNotifier a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ForegroundNotifier.a(this.a);
    }
}
