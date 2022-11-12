// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

public interface Parser<MessageType>
{
    MessageType a(final CodedInputStream p0, final ExtensionRegistryLite p1) throws InvalidProtocolBufferException;
    
    MessageType b(final ByteString p0, final ExtensionRegistryLite p1) throws InvalidProtocolBufferException;
}
