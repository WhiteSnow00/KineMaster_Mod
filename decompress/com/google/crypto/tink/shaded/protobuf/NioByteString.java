// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.InvalidMarkException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;

final class NioByteString extends LeafByteString
{
    private final ByteBuffer buffer;
    
    NioByteString(final ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }
    
    static ByteBuffer access$000(final NioByteString nioByteString) {
        return nioByteString.buffer;
    }
    
    private ByteBuffer g(final int n, final int n2) {
        if (n >= this.buffer.position() && n2 <= this.buffer.limit() && n <= n2) {
            final ByteBuffer slice = this.buffer.slice();
            slice.position(n - this.buffer.position());
            slice.limit(n2 - this.buffer.position());
            return slice;
        }
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", n, n2));
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }
    
    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }
    
    @Override
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }
    
    @Override
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(this.asReadOnlyByteBuffer());
    }
    
    @Override
    public byte byteAt(final int n) {
        try {
            return this.buffer.get(n);
        }
        catch (final IndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException(ex.getMessage());
        }
        catch (final ArrayIndexOutOfBoundsException ex2) {
            throw ex2;
        }
    }
    
    @Override
    public void copyTo(final ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }
    
    @Override
    protected void copyToInternal(final byte[] array, final int n, final int n2, final int n3) {
        final ByteBuffer slice = this.buffer.slice();
        slice.position(n);
        slice.get(array, n2, n3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ByteString)) {
            return false;
        }
        final ByteString byteString = (ByteString)o;
        if (this.size() != byteString.size()) {
            return false;
        }
        if (this.size() == 0) {
            return true;
        }
        if (o instanceof NioByteString) {
            return this.buffer.equals(((NioByteString)o).buffer);
        }
        if (o instanceof RopeByteString) {
            return o.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }
    
    @Override
    boolean equalsRange(final ByteString byteString, final int n, final int n2) {
        return this.substring(0, n2).equals(byteString.substring(n, n2 + n));
    }
    
    public byte internalByteAt(final int n) {
        return this.byteAt(n);
    }
    
    @Override
    public boolean isValidUtf8() {
        return Utf8.r(this.buffer);
    }
    
    @Override
    public CodedInputStream newCodedInput() {
        return CodedInputStream.h(this.buffer, true);
    }
    
    @Override
    public InputStream newInput() {
        return new InputStream(this) {
            private final ByteBuffer a = NioByteString.access$000(b).slice();
            final NioByteString b;
            
            @Override
            public int available() throws IOException {
                return this.a.remaining();
            }
            
            @Override
            public void mark(final int n) {
                this.a.mark();
            }
            
            @Override
            public boolean markSupported() {
                return true;
            }
            
            @Override
            public int read() throws IOException {
                if (!this.a.hasRemaining()) {
                    return -1;
                }
                return this.a.get() & 0xFF;
            }
            
            @Override
            public int read(final byte[] array, final int n, int min) throws IOException {
                if (!this.a.hasRemaining()) {
                    return -1;
                }
                min = Math.min(min, this.a.remaining());
                this.a.get(array, n, min);
                return min;
            }
            
            @Override
            public void reset() throws IOException {
                try {
                    this.a.reset();
                }
                catch (final InvalidMarkException ex) {
                    throw new IOException(ex);
                }
            }
        };
    }
    
    @Override
    protected int partialHash(int i, final int n, final int n2) {
        int n3 = i;
        for (i = n; i < n + n2; ++i) {
            n3 = n3 * 31 + this.buffer.get(i);
        }
        return n3;
    }
    
    @Override
    protected int partialIsValidUtf8(final int n, final int n2, final int n3) {
        return Utf8.u(n, this.buffer, n2, n3 + n2);
    }
    
    @Override
    public int size() {
        return this.buffer.remaining();
    }
    
    @Override
    public ByteString substring(final int n, final int n2) {
        try {
            return new NioByteString(this.g(n, n2));
        }
        catch (final IndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException(ex.getMessage());
        }
        catch (final ArrayIndexOutOfBoundsException ex2) {
            throw ex2;
        }
    }
    
    @Override
    protected String toStringInternal(final Charset charset) {
        byte[] array;
        int n;
        int n2;
        if (this.buffer.hasArray()) {
            array = this.buffer.array();
            n = this.buffer.arrayOffset() + this.buffer.position();
            n2 = this.buffer.remaining();
        }
        else {
            array = this.toByteArray();
            n = 0;
            n2 = array.length;
        }
        return new String(array, n, n2, charset);
    }
    
    @Override
    void writeTo(final ByteOutput byteOutput) throws IOException {
        byteOutput.a(this.buffer.slice());
    }
    
    @Override
    public void writeTo(final OutputStream outputStream) throws IOException {
        outputStream.write(this.toByteArray());
    }
    
    @Override
    void writeToInternal(final OutputStream outputStream, final int n, final int n2) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + n, n2);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.f.g(this.g(n, n2 + n), outputStream);
    }
}
