// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import ba.e;

public final class x implements e
{
    public final ImpressionStorageClient a;
    
    public x(final ImpressionStorageClient a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        ImpressionStorageClient.b(this.a, (Throwable)o);
    }
}
