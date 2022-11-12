// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Comparator;
import java.io.Serializable;

public abstract class ByteString implements Iterable<Byte>, Serializable
{
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final e a;
    private static final Comparator<ByteString> b;
    private int hash;
    
    static {
        EMPTY = new LiteralByteString(Internal.c);
        e a2;
        if (com.google.crypto.tink.shaded.protobuf.b.c()) {
            a2 = new g(null);
        }
        else {
            a2 = new d(null);
        }
        a = a2;
        b = new Comparator<ByteString>() {
            public int a(final ByteString byteString, final ByteString byteString2) {
                final ByteIterator iterator = byteString.iterator();
                final ByteIterator iterator2 = byteString2.iterator();
                while (iterator.hasNext() && iterator2.hasNext()) {
                    final int compare = Integer.compare(ByteString.access$200(iterator.a()), ByteString.access$200(iterator2.a()));
                    if (compare != 0) {
                        return compare;
                    }
                }
                return Integer.compare(byteString.size(), byteString2.size());
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((ByteString)o, (ByteString)o2);
            }
        };
    }
    
    ByteString() {
        this.hash = 0;
    }
    
    private static ByteString a(final Iterator<ByteString> iterator, final int n) {
        if (n >= 1) {
            ByteString concat;
            if (n == 1) {
                concat = iterator.next();
            }
            else {
                final int n2 = n >>> 1;
                concat = a(iterator, n2).concat(a(iterator, n - n2));
            }
            return concat;
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", n));
    }
    
    static int access$200(final byte b) {
        return e(b);
    }
    
    private static ByteString b(final InputStream inputStream, final int n) throws IOException {
        final byte[] array = new byte[n];
        int i;
        int read;
        for (i = 0; i < n; i += read) {
            read = inputStream.read(array, i, n - i);
            if (read == -1) {
                break;
            }
        }
        if (i == 0) {
            return null;
        }
        return copyFrom(array, 0, i);
    }
    
    static void checkIndex(final int n, final int n2) {
        if ((n2 - (n + 1) | n) >= 0) {
            return;
        }
        if (n < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Index < 0: ");
            sb.append(n);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Index > length: ");
        sb2.append(n);
        sb2.append(", ");
        sb2.append(n2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }
    
    static int checkRange(final int n, final int n2, final int n3) {
        final int n4 = n2 - n;
        if ((n | n2 | n4 | n3 - n2) >= 0) {
            return n4;
        }
        if (n < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Beginning index: ");
            sb.append(n);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (n2 < n) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(n);
            sb2.append(", ");
            sb2.append(n2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("End index: ");
        sb3.append(n2);
        sb3.append(" >= ");
        sb3.append(n3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
    
    public static ByteString copyFrom(final Iterable<ByteString> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            int n = 0;
            final Iterator iterator = iterable.iterator();
            while (true) {
                size = n;
                if (!iterator.hasNext()) {
                    break;
                }
                iterator.next();
                ++n;
            }
        }
        else {
            size = ((Collection)iterable).size();
        }
        if (size == 0) {
            return ByteString.EMPTY;
        }
        return a(iterable.iterator(), size);
    }
    
    public static ByteString copyFrom(final String s, final String s2) throws UnsupportedEncodingException {
        return new LiteralByteString(s.getBytes(s2));
    }
    
    public static ByteString copyFrom(final String s, final Charset charset) {
        return new LiteralByteString(s.getBytes(charset));
    }
    
    public static ByteString copyFrom(final ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }
    
    public static ByteString copyFrom(final ByteBuffer byteBuffer, final int n) {
        checkRange(0, n, byteBuffer.remaining());
        final byte[] array = new byte[n];
        byteBuffer.get(array);
        return new LiteralByteString(array);
    }
    
    public static ByteString copyFrom(final byte[] array) {
        return copyFrom(array, 0, array.length);
    }
    
    public static ByteString copyFrom(final byte[] array, final int n, final int n2) {
        checkRange(n, n + n2, array.length);
        return new LiteralByteString(ByteString.a.a(array, n, n2));
    }
    
    public static ByteString copyFromUtf8(final String s) {
        return new LiteralByteString(s.getBytes(Internal.a));
    }
    
    private static int e(final byte b) {
        return b & 0xFF;
    }
    
    private String f() {
        String s;
        if (this.size() <= 50) {
            s = n0.a(this);
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append(n0.a(this.substring(0, 47)));
            sb.append("...");
            s = sb.toString();
        }
        return s;
    }
    
    static f newCodedBuilder(final int n) {
        return new f(n, null);
    }
    
    public static Output newOutput() {
        return new Output(128);
    }
    
    public static Output newOutput(final int n) {
        return new Output(n);
    }
    
    public static ByteString readFrom(final InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }
    
    public static ByteString readFrom(final InputStream inputStream, final int n) throws IOException {
        return readFrom(inputStream, n, n);
    }
    
    public static ByteString readFrom(final InputStream inputStream, int min, final int n) throws IOException {
        final ArrayList list = new ArrayList();
        while (true) {
            final ByteString b = b(inputStream, min);
            if (b == null) {
                break;
            }
            list.add(b);
            min = Math.min(min * 2, n);
        }
        return copyFrom(list);
    }
    
    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return ByteString.b;
    }
    
    static ByteString wrap(final ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new NioByteString(byteBuffer);
    }
    
    static ByteString wrap(final byte[] array) {
        return new LiteralByteString(array);
    }
    
    static ByteString wrap(final byte[] array, final int n, final int n2) {
        return new BoundedByteString(array, n, n2);
    }
    
    public abstract ByteBuffer asReadOnlyByteBuffer();
    
    public abstract List<ByteBuffer> asReadOnlyByteBufferList();
    
    public abstract byte byteAt(final int p0);
    
    public final ByteString concat(final ByteString byteString) {
        if (Integer.MAX_VALUE - this.size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("ByteString would be too long: ");
        sb.append(this.size());
        sb.append("+");
        sb.append(byteString.size());
        throw new IllegalArgumentException(sb.toString());
    }
    
    public abstract void copyTo(final ByteBuffer p0);
    
    public void copyTo(final byte[] array, final int n) {
        this.copyTo(array, 0, n, this.size());
    }
    
    @Deprecated
    public final void copyTo(final byte[] array, final int n, final int n2, final int n3) {
        checkRange(n, n + n3, this.size());
        checkRange(n2, n2 + n3, array.length);
        if (n3 > 0) {
            this.copyToInternal(array, n, n2, n3);
        }
    }
    
    protected abstract void copyToInternal(final byte[] p0, final int p1, final int p2, final int p3);
    
    public final boolean endsWith(final ByteString byteString) {
        return this.size() >= byteString.size() && this.substring(this.size() - byteString.size()).equals(byteString);
    }
    
    @Override
    public abstract boolean equals(final Object p0);
    
    protected abstract int getTreeDepth();
    
    @Override
    public final int hashCode() {
        int hash;
        if ((hash = this.hash) == 0) {
            final int size = this.size();
            if ((hash = this.partialHash(size, 0, size)) == 0) {
                hash = 1;
            }
            this.hash = hash;
        }
        return hash;
    }
    
    abstract byte internalByteAt(final int p0);
    
    protected abstract boolean isBalanced();
    
    public final boolean isEmpty() {
        return this.size() == 0;
    }
    
    public abstract boolean isValidUtf8();
    
    @Override
    public ByteIterator iterator() {
        return (ByteIterator)new c(this) {
            private int a = 0;
            private final int b = c.size();
            final ByteString c;
            
            @Override
            public byte a() {
                final int a = this.a;
                if (a < this.b) {
                    this.a = a + 1;
                    return this.c.internalByteAt(a);
                }
                throw new NoSuchElementException();
            }
            
            @Override
            public boolean hasNext() {
                return this.a < this.b;
            }
        };
    }
    
    @Override
    public /* bridge */ Iterator iterator() {
        return this.iterator();
    }
    
    public abstract CodedInputStream newCodedInput();
    
    public abstract InputStream newInput();
    
    protected abstract int partialHash(final int p0, final int p1, final int p2);
    
    protected abstract int partialIsValidUtf8(final int p0, final int p1, final int p2);
    
    protected final int peekCachedHashCode() {
        return this.hash;
    }
    
    public abstract int size();
    
    public final boolean startsWith(final ByteString byteString) {
        final int size = this.size();
        final int size2 = byteString.size();
        boolean b = false;
        if (size >= size2) {
            b = b;
            if (this.substring(0, byteString.size()).equals(byteString)) {
                b = true;
            }
        }
        return b;
    }
    
    public final ByteString substring(final int n) {
        return this.substring(n, this.size());
    }
    
    public abstract ByteString substring(final int p0, final int p1);
    
    public final byte[] toByteArray() {
        final int size = this.size();
        if (size == 0) {
            return Internal.c;
        }
        final byte[] array = new byte[size];
        this.copyToInternal(array, 0, 0, size);
        return array;
    }
    
    @Override
    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), this.size(), this.f());
    }
    
    public final String toString(final String s) throws UnsupportedEncodingException {
        try {
            return this.toString(Charset.forName(s));
        }
        catch (final UnsupportedCharsetException ex) {
            final UnsupportedEncodingException ex2 = new UnsupportedEncodingException(s);
            ex2.initCause(ex);
            throw ex2;
        }
    }
    
    public final String toString(final Charset charset) {
        String stringInternal;
        if (this.size() == 0) {
            stringInternal = "";
        }
        else {
            stringInternal = this.toStringInternal(charset);
        }
        return stringInternal;
    }
    
    protected abstract String toStringInternal(final Charset p0);
    
    public final String toStringUtf8() {
        return this.toString(Internal.a);
    }
    
    abstract void writeTo(final ByteOutput p0) throws IOException;
    
    public abstract void writeTo(final OutputStream p0) throws IOException;
    
    final void writeTo(final OutputStream outputStream, final int n, final int n2) throws IOException {
        checkRange(n, n + n2, this.size());
        if (n2 > 0) {
            this.writeToInternal(outputStream, n, n2);
        }
    }
    
    abstract void writeToInternal(final OutputStream p0, final int p1, final int p2) throws IOException;
    
    abstract void writeToReverse(final ByteOutput p0) throws IOException;
    
    private static final class BoundedByteString extends LiteralByteString
    {
        private static final long serialVersionUID = 1L;
        private final int bytesLength;
        private final int bytesOffset;
        
        BoundedByteString(final byte[] array, final int bytesOffset, final int bytesLength) {
            super(array);
            ByteString.checkRange(bytesOffset, bytesOffset + bytesLength, array.length);
            this.bytesOffset = bytesOffset;
            this.bytesLength = bytesLength;
        }
        
        private void readObject(final ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }
        
        @Override
        public byte byteAt(final int n) {
            ByteString.checkIndex(n, this.size());
            return super.bytes[this.bytesOffset + n];
        }
        
        @Override
        protected void copyToInternal(final byte[] array, final int n, final int n2, final int n3) {
            System.arraycopy(super.bytes, this.getOffsetIntoBytes() + n, array, n2, n3);
        }
        
        @Override
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }
        
        @Override
        byte internalByteAt(final int n) {
            return super.bytes[this.bytesOffset + n];
        }
        
        @Override
        public int size() {
            return this.bytesLength;
        }
        
        Object writeReplace() {
            return ByteString.wrap(this.toByteArray());
        }
    }
    
    public interface ByteIterator extends Iterator<Byte>
    {
        byte a();
    }
    
    abstract static class LeafByteString extends ByteString
    {
        abstract boolean equalsRange(final ByteString p0, final int p1, final int p2);
        
        @Override
        protected final int getTreeDepth() {
            return 0;
        }
        
        @Override
        protected final boolean isBalanced() {
            return true;
        }
        
        @Override
        void writeToReverse(final ByteOutput byteOutput) throws IOException {
            this.writeTo(byteOutput);
        }
    }
    
    private static class LiteralByteString extends LeafByteString
    {
        private static final long serialVersionUID = 1L;
        protected final byte[] bytes;
        
        LiteralByteString(final byte[] bytes) {
            Objects.requireNonNull(bytes);
            this.bytes = bytes;
        }
        
        @Override
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, this.getOffsetIntoBytes(), this.size()).asReadOnlyBuffer();
        }
        
        @Override
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(this.asReadOnlyByteBuffer());
        }
        
        @Override
        public byte byteAt(final int n) {
            return this.bytes[n];
        }
        
        @Override
        public final void copyTo(final ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, this.getOffsetIntoBytes(), this.size());
        }
        
        @Override
        protected void copyToInternal(final byte[] array, final int n, final int n2, final int n3) {
            System.arraycopy(this.bytes, n, array, n2, n3);
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ByteString)) {
                return false;
            }
            if (this.size() != ((ByteString)o).size()) {
                return false;
            }
            if (this.size() == 0) {
                return true;
            }
            if (o instanceof LiteralByteString) {
                final LiteralByteString literalByteString = (LiteralByteString)o;
                final int peekCachedHashCode = this.peekCachedHashCode();
                final int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
                return (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) && this.equalsRange(literalByteString, 0, this.size());
            }
            return o.equals(this);
        }
        
        @Override
        final boolean equalsRange(final ByteString byteString, int i, final int n) {
            if (n > byteString.size()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Length too large: ");
                sb.append(n);
                sb.append(this.size());
                throw new IllegalArgumentException(sb.toString());
            }
            final int n2 = i + n;
            if (n2 > byteString.size()) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Ran off end of other: ");
                sb2.append(i);
                sb2.append(", ");
                sb2.append(n);
                sb2.append(", ");
                sb2.append(byteString.size());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (byteString instanceof LiteralByteString) {
                final LiteralByteString literalByteString = (LiteralByteString)byteString;
                final byte[] bytes = this.bytes;
                final byte[] bytes2 = literalByteString.bytes;
                final int offsetIntoBytes = this.getOffsetIntoBytes();
                final int offsetIntoBytes2 = this.getOffsetIntoBytes();
                int n3;
                for (n3 = literalByteString.getOffsetIntoBytes() + i, i = offsetIntoBytes2; i < offsetIntoBytes + n; ++i, ++n3) {
                    if (bytes[i] != bytes2[n3]) {
                        return false;
                    }
                }
                return true;
            }
            return byteString.substring(i, n2).equals(this.substring(0, n));
        }
        
        protected int getOffsetIntoBytes() {
            return 0;
        }
        
        @Override
        byte internalByteAt(final int n) {
            return this.bytes[n];
        }
        
        @Override
        public final boolean isValidUtf8() {
            final int offsetIntoBytes = this.getOffsetIntoBytes();
            return Utf8.t(this.bytes, offsetIntoBytes, this.size() + offsetIntoBytes);
        }
        
        @Override
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.k(this.bytes, this.getOffsetIntoBytes(), this.size(), true);
        }
        
        @Override
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, this.getOffsetIntoBytes(), this.size());
        }
        
        @Override
        protected final int partialHash(final int n, final int n2, final int n3) {
            return Internal.i(n, this.bytes, this.getOffsetIntoBytes() + n2, n3);
        }
        
        @Override
        protected final int partialIsValidUtf8(final int n, int n2, final int n3) {
            n2 += this.getOffsetIntoBytes();
            return Utf8.v(n, this.bytes, n2, n3 + n2);
        }
        
        @Override
        public int size() {
            return this.bytes.length;
        }
        
        @Override
        public final ByteString substring(final int n, int checkRange) {
            checkRange = ByteString.checkRange(n, checkRange, this.size());
            if (checkRange == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, this.getOffsetIntoBytes() + n, checkRange);
        }
        
        @Override
        protected final String toStringInternal(final Charset charset) {
            return new String(this.bytes, this.getOffsetIntoBytes(), this.size(), charset);
        }
        
        @Override
        final void writeTo(final ByteOutput byteOutput) throws IOException {
            byteOutput.b(this.bytes, this.getOffsetIntoBytes(), this.size());
        }
        
        @Override
        public final void writeTo(final OutputStream outputStream) throws IOException {
            outputStream.write(this.toByteArray());
        }
        
        @Override
        final void writeToInternal(final OutputStream outputStream, final int n, final int n2) throws IOException {
            outputStream.write(this.bytes, this.getOffsetIntoBytes() + n, n2);
        }
    }
    
    public static final class Output extends OutputStream
    {
        private static final byte[] f;
        private final int a;
        private final ArrayList<ByteString> b;
        private int c;
        private byte[] d;
        private int e;
        
        static {
            f = new byte[0];
        }
        
        Output(final int a) {
            if (a >= 0) {
                this.a = a;
                this.b = new ArrayList<ByteString>();
                this.d = new byte[a];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }
        
        private void a(final int n) {
            this.b.add(new LiteralByteString(this.d));
            final int c = this.c + this.d.length;
            this.c = c;
            this.d = new byte[Math.max(this.a, Math.max(n, c >>> 1))];
            this.e = 0;
        }
        
        public int c() {
            synchronized (this) {
                return this.c + this.e;
            }
        }
        
        @Override
        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.c());
        }
        
        @Override
        public void write(final int n) {
            synchronized (this) {
                if (this.e == this.d.length) {
                    this.a(1);
                }
                this.d[this.e++] = (byte)n;
            }
        }
        
        @Override
        public void write(final byte[] array, final int n, int e) {
            synchronized (this) {
                final byte[] d = this.d;
                final int length = d.length;
                final int e2 = this.e;
                if (e <= length - e2) {
                    System.arraycopy(array, n, d, e2, e);
                    this.e += e;
                }
                else {
                    final int n2 = d.length - e2;
                    System.arraycopy(array, n, d, e2, n2);
                    e -= n2;
                    this.a(e);
                    System.arraycopy(array, n + n2, this.d, 0, e);
                    this.e = e;
                }
            }
        }
    }
    
    abstract static class c implements ByteIterator
    {
        public final Byte b() {
            return ((ByteIterator)this).a();
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.b();
        }
        
        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private static final class d implements e
    {
        private d() {
        }
        
        d(final ByteString$a c) {
            this();
        }
        
        @Override
        public byte[] a(final byte[] array, final int n, final int n2) {
            return Arrays.copyOfRange(array, n, n2 + n);
        }
    }
    
    private interface e
    {
        byte[] a(final byte[] p0, final int p1, final int p2);
    }
    
    static final class f
    {
        private final CodedOutputStream a;
        private final byte[] b;
        
        private f(final int n) {
            final byte[] b = new byte[n];
            this.b = b;
            this.a = CodedOutputStream.h0(b);
        }
        
        f(final int n, final ByteString$a c) {
            this(n);
        }
        
        public ByteString a() {
            this.a.d();
            return new LiteralByteString(this.b);
        }
        
        public CodedOutputStream b() {
            return this.a;
        }
    }
    
    private static final class g implements e
    {
        private g() {
        }
        
        g(final ByteString$a c) {
            this();
        }
        
        @Override
        public byte[] a(final byte[] array, final int n, final int n2) {
            final byte[] array2 = new byte[n2];
            System.arraycopy(array, n, array2, 0, n2);
            return array2;
        }
    }
}
