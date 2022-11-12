// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.OutputStream;
import java.io.IOException;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite
{
    protected int memoizedHashCode;
    
    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }
    
    private String g(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Serializing ");
        sb.append(this.getClass().getName());
        sb.append(" to a ");
        sb.append(s);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }
    
    int a() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ByteString b() {
        try {
            final ByteString.f codedBuilder = ByteString.newCodedBuilder(this.getSerializedSize());
            this.e(codedBuilder.b());
            return codedBuilder.a();
        }
        catch (final IOException ex) {
            throw new RuntimeException(this.g("ByteString"), ex);
        }
    }
    
    @Override
    public byte[] c() {
        try {
            final byte[] array = new byte[this.getSerializedSize()];
            final CodedOutputStream h0 = CodedOutputStream.h0(array);
            this.e(h0);
            h0.d();
            return array;
        }
        catch (final IOException ex) {
            throw new RuntimeException(this.g("byte array"), ex);
        }
    }
    
    int f(final j0 j0) {
        int n;
        if ((n = this.a()) == -1) {
            n = j0.d(this);
            this.i(n);
        }
        return n;
    }
    
    UninitializedMessageException h() {
        return new UninitializedMessageException(this);
    }
    
    void i(final int n) {
        throw new UnsupportedOperationException();
    }
    
    public void j(final OutputStream outputStream) throws IOException {
        final CodedOutputStream g0 = CodedOutputStream.g0(outputStream, CodedOutputStream.J(this.getSerializedSize()));
        this.e(g0);
        g0.d0();
    }
    
    public abstract static class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder
    {
        private String g(final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Reading ");
            sb.append(this.getClass().getName());
            sb.append(" from a ");
            sb.append(s);
            sb.append(" threw an IOException (should never happen).");
            return sb.toString();
        }
        
        protected static UninitializedMessageException o(final MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }
        
        public /* bridge */ Object clone() throws CloneNotSupportedException {
            return this.f();
        }
        
        public abstract BuilderType f();
        
        @Override
        public /* bridge */ MessageLite.Builder g1(final MessageLite messageLite) {
            return this.l(messageLite);
        }
        
        protected abstract BuilderType h(final MessageType p0);
        
        public BuilderType i(final CodedInputStream codedInputStream) throws IOException {
            return this.j(codedInputStream, ExtensionRegistryLite.b());
        }
        
        public abstract BuilderType j(final CodedInputStream p0, final ExtensionRegistryLite p1) throws IOException;
        
        public BuilderType l(final MessageLite messageLite) {
            if (this.d().getClass().isInstance(messageLite)) {
                return this.h((MessageType)messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        
        public BuilderType m(final byte[] array) throws InvalidProtocolBufferException {
            return this.n(array, 0, array.length);
        }
        
        public BuilderType n(final byte[] array, final int n, final int n2) throws InvalidProtocolBufferException {
            try {
                final CodedInputStream j = CodedInputStream.j(array, n, n2);
                this.i(j);
                j.a(0);
                return (BuilderType)this;
            }
            catch (final IOException ex) {
                throw new RuntimeException(this.g("byte array"), ex);
            }
            catch (final InvalidProtocolBufferException ex2) {
                throw ex2;
            }
        }
        
        @Override
        public /* bridge */ MessageLite.Builder s(final byte[] array) throws InvalidProtocolBufferException {
            return this.m(array);
        }
    }
    
    protected interface InternalOneOfEnum
    {
    }
}
