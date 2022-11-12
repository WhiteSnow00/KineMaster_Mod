// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.protobuf.AbstractMessageLite;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import java.util.concurrent.Callable;

public final class r1 implements Callable
{
    public final ProtoStorageClient a;
    public final AbstractMessageLite b;
    
    public r1(final ProtoStorageClient a, final AbstractMessageLite b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object call() {
        return ProtoStorageClient.a(this.a, this.b);
    }
}
