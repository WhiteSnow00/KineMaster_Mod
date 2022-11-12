// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import com.fasterxml.jackson.core.util.b;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import com.fasterxml.jackson.core.e;

public class SerializedString implements e, Serializable
{
    private static final long serialVersionUID = 1L;
    protected transient String _jdkSerializeValue;
    protected char[] _quotedChars;
    protected byte[] _quotedUTF8Ref;
    protected byte[] _unquotedUTF8Ref;
    protected final String _value;
    
    public SerializedString(final String value) {
        if (value != null) {
            this._value = value;
            return;
        }
        throw new IllegalStateException("Null String illegal for SerializedString");
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException {
        this._jdkSerializeValue = objectInputStream.readUTF();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this._value);
    }
    
    public int appendQuoted(final char[] array, final int n) {
        char[] quotedChars;
        if ((quotedChars = this._quotedChars) == null) {
            quotedChars = b.d(this._value);
            this._quotedChars = quotedChars;
        }
        final int length = quotedChars.length;
        if (n + length > array.length) {
            return -1;
        }
        System.arraycopy(quotedChars, 0, array, n, length);
        return length;
    }
    
    public int appendQuotedUTF8(final byte[] array, final int n) {
        byte[] quotedUTF8Ref;
        if ((quotedUTF8Ref = this._quotedUTF8Ref) == null) {
            quotedUTF8Ref = b.e(this._value);
            this._quotedUTF8Ref = quotedUTF8Ref;
        }
        final int length = quotedUTF8Ref.length;
        if (n + length > array.length) {
            return -1;
        }
        System.arraycopy(quotedUTF8Ref, 0, array, n, length);
        return length;
    }
    
    public int appendUnquoted(final char[] array, final int n) {
        final String value = this._value;
        final int length = value.length();
        if (n + length > array.length) {
            return -1;
        }
        value.getChars(0, length, array, n);
        return length;
    }
    
    public int appendUnquotedUTF8(final byte[] array, final int n) {
        byte[] unquotedUTF8Ref;
        if ((unquotedUTF8Ref = this._unquotedUTF8Ref) == null) {
            unquotedUTF8Ref = b.a(this._value);
            this._unquotedUTF8Ref = unquotedUTF8Ref;
        }
        final int length = unquotedUTF8Ref.length;
        if (n + length > array.length) {
            return -1;
        }
        System.arraycopy(unquotedUTF8Ref, 0, array, n, length);
        return length;
    }
    
    public final char[] asQuotedChars() {
        char[] quotedChars;
        if ((quotedChars = this._quotedChars) == null) {
            quotedChars = b.d(this._value);
            this._quotedChars = quotedChars;
        }
        return quotedChars;
    }
    
    public final byte[] asQuotedUTF8() {
        byte[] quotedUTF8Ref;
        if ((quotedUTF8Ref = this._quotedUTF8Ref) == null) {
            quotedUTF8Ref = b.e(this._value);
            this._quotedUTF8Ref = quotedUTF8Ref;
        }
        return quotedUTF8Ref;
    }
    
    @Override
    public final byte[] asUnquotedUTF8() {
        byte[] unquotedUTF8Ref;
        if ((unquotedUTF8Ref = this._unquotedUTF8Ref) == null) {
            unquotedUTF8Ref = b.a(this._value);
            this._unquotedUTF8Ref = unquotedUTF8Ref;
        }
        return unquotedUTF8Ref;
    }
    
    public final int charLength() {
        return this._value.length();
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o == this || (o != null && o.getClass() == this.getClass() && this._value.equals(((SerializedString)o)._value));
    }
    
    @Override
    public final String getValue() {
        return this._value;
    }
    
    @Override
    public final int hashCode() {
        return this._value.hashCode();
    }
    
    public int putQuotedUTF8(final ByteBuffer byteBuffer) {
        byte[] quotedUTF8Ref;
        if ((quotedUTF8Ref = this._quotedUTF8Ref) == null) {
            quotedUTF8Ref = b.e(this._value);
            this._quotedUTF8Ref = quotedUTF8Ref;
        }
        final int length = quotedUTF8Ref.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(quotedUTF8Ref, 0, length);
        return length;
    }
    
    public int putUnquotedUTF8(final ByteBuffer byteBuffer) {
        byte[] unquotedUTF8Ref;
        if ((unquotedUTF8Ref = this._unquotedUTF8Ref) == null) {
            unquotedUTF8Ref = b.a(this._value);
            this._unquotedUTF8Ref = unquotedUTF8Ref;
        }
        final int length = unquotedUTF8Ref.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(unquotedUTF8Ref, 0, length);
        return length;
    }
    
    protected Object readResolve() {
        return new SerializedString(this._jdkSerializeValue);
    }
    
    @Override
    public final String toString() {
        return this._value;
    }
    
    public int writeQuotedUTF8(final OutputStream outputStream) throws IOException {
        byte[] quotedUTF8Ref;
        if ((quotedUTF8Ref = this._quotedUTF8Ref) == null) {
            quotedUTF8Ref = b.e(this._value);
            this._quotedUTF8Ref = quotedUTF8Ref;
        }
        final int length = quotedUTF8Ref.length;
        outputStream.write(quotedUTF8Ref, 0, length);
        return length;
    }
    
    public int writeUnquotedUTF8(final OutputStream outputStream) throws IOException {
        byte[] unquotedUTF8Ref;
        if ((unquotedUTF8Ref = this._unquotedUTF8Ref) == null) {
            unquotedUTF8Ref = b.a(this._value);
            this._unquotedUTF8Ref = unquotedUTF8Ref;
        }
        final int length = unquotedUTF8Ref.length;
        outputStream.write(unquotedUTF8Ref, 0, length);
        return length;
    }
}
