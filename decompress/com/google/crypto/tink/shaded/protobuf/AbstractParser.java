// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType>
{
    private static final ExtensionRegistryLite a;
    
    static {
        a = ExtensionRegistryLite.b();
    }
    
    private MessageType c(final MessageType unfinishedMessage) throws InvalidProtocolBufferException {
        if (unfinishedMessage != null && !unfinishedMessage.isInitialized()) {
            throw this.d(unfinishedMessage).asInvalidProtocolBufferException().setUnfinishedMessage(unfinishedMessage);
        }
        return unfinishedMessage;
    }
    
    private UninitializedMessageException d(final MessageType messageType) {
        if (messageType instanceof AbstractMessageLite) {
            return ((AbstractMessageLite)messageType).h();
        }
        return new UninitializedMessageException(messageType);
    }
    
    @Override
    public /* bridge */ Object b(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return this.e(byteString, extensionRegistryLite);
    }
    
    public MessageType e(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return this.c(this.f(byteString, extensionRegistryLite));
    }
    
    public MessageType f(final ByteString byteString, ExtensionRegistryLite unfinishedMessage) throws InvalidProtocolBufferException {
        try {
            final CodedInputStream codedInput = byteString.newCodedInput();
            unfinishedMessage = (ExtensionRegistryLite)this.a(codedInput, unfinishedMessage);
            try {
                codedInput.a(0);
                return (MessageType)unfinishedMessage;
            }
            catch (final InvalidProtocolBufferException ex) {
                throw ex.setUnfinishedMessage((MessageLite)unfinishedMessage);
            }
        }
        catch (final InvalidProtocolBufferException ex2) {
            throw ex2;
        }
    }
}
