// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.protobuf.Parser;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import java.util.concurrent.Callable;

public final class s1 implements Callable
{
    public final ProtoStorageClient a;
    public final Parser b;
    
    public s1(final ProtoStorageClient a, final Parser b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object call() {
        return ProtoStorageClient.b(this.a, this.b);
    }
}
