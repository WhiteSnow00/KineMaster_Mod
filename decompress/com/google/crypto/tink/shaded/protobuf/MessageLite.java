// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

public interface MessageLite extends MessageLiteOrBuilder
{
    ByteString b();
    
    byte[] c();
    
    void e(final CodedOutputStream p0) throws IOException;
    
    Parser<? extends MessageLite> getParserForType();
    
    int getSerializedSize();
    
    Builder newBuilderForType();
    
    Builder toBuilder();
    
    public interface Builder extends MessageLiteOrBuilder, Cloneable
    {
        MessageLite build();
        
        Builder g1(final MessageLite p0);
        
        MessageLite k();
        
        Builder s(final byte[] p0) throws InvalidProtocolBufferException;
    }
}
