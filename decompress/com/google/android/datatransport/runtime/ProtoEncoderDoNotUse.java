// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.encoders.annotations.Encodable;

@Encodable
public abstract class ProtoEncoderDoNotUse
{
    private static final ProtobufEncoder a;
    
    static {
        a = ProtobufEncoder.a().d(AutoProtoEncoderDoNotUseEncoder.a).c();
    }
    
    private ProtoEncoderDoNotUse() {
    }
    
    public static byte[] a(final Object o) {
        return ProtoEncoderDoNotUse.a.c(o);
    }
    
    public abstract ClientMetrics b();
}
