// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Objects;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

final class RopeByteString extends ByteString
{
    static final int[] minLengthByDepth;
    private static final long serialVersionUID = 1L;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;
    
    static {
        minLengthByDepth = new int[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE };
    }
    
    private RopeByteString(final ByteString left, final ByteString right) {
        this.left = left;
        this.right = right;
        final int size = left.size();
        this.leftLength = size;
        this.totalLength = size + right.size();
        this.treeDepth = Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1;
    }
    
    RopeByteString(final ByteString byteString, final ByteString byteString2, final RopeByteString$a c) {
        this(byteString, byteString2);
    }
    
    static ByteString access$400(final RopeByteString ropeByteString) {
        return ropeByteString.left;
    }
    
    static ByteString access$500(final RopeByteString ropeByteString) {
        return ropeByteString.right;
    }
    
    static ByteString concatenate(ByteString g, final ByteString byteString) {
        if (byteString.size() == 0) {
            return g;
        }
        if (g.size() == 0) {
            return byteString;
        }
        final int n = g.size() + byteString.size();
        if (n < 128) {
            return g(g, byteString);
        }
        if (g instanceof RopeByteString) {
            final RopeByteString ropeByteString = (RopeByteString)g;
            if (ropeByteString.right.size() + byteString.size() < 128) {
                g = g(ropeByteString.right, byteString);
                return new RopeByteString(ropeByteString.left, g);
            }
            if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString));
            }
        }
        if (n >= minLength(Math.max(g.getTreeDepth(), byteString.getTreeDepth()) + 1)) {
            return new RopeByteString(g, byteString);
        }
        return b.a(new b(null), g, byteString);
    }
    
    private static ByteString g(final ByteString byteString, final ByteString byteString2) {
        final int size = byteString.size();
        final int size2 = byteString2.size();
        final byte[] array = new byte[size + size2];
        byteString.copyTo(array, 0, 0, size);
        byteString2.copyTo(array, 0, size, size2);
        return ByteString.wrap(array);
    }
    
    private boolean k(final ByteString byteString) {
        final c c = new c(this, null);
        LeafByteString leafByteString = c.next();
        final c c2 = new c(byteString, null);
        LeafByteString leafByteString2 = c2.next();
        int n = 0;
        int n3;
        int n2 = n3 = 0;
        while (true) {
            final int n4 = leafByteString.size() - n;
            final int n5 = leafByteString2.size() - n2;
            final int min = Math.min(n4, n5);
            boolean b;
            if (n == 0) {
                b = leafByteString.equalsRange(leafByteString2, n2, min);
            }
            else {
                b = leafByteString2.equalsRange(leafByteString, n, min);
            }
            if (!b) {
                return false;
            }
            n3 += min;
            final int totalLength = this.totalLength;
            if (n3 >= totalLength) {
                if (n3 == totalLength) {
                    return true;
                }
                throw new IllegalStateException();
            }
            else {
                if (min == n4) {
                    leafByteString = (LeafByteString)c.next();
                    n = 0;
                }
                else {
                    n += min;
                }
                if (min == n5) {
                    leafByteString2 = (LeafByteString)c2.next();
                    n2 = 0;
                }
                else {
                    n2 += min;
                }
            }
        }
    }
    
    static int minLength(final int n) {
        final int[] minLengthByDepth = RopeByteString.minLengthByDepth;
        if (n >= minLengthByDepth.length) {
            return Integer.MAX_VALUE;
        }
        return minLengthByDepth[n];
    }
    
    static RopeByteString newInstanceForTest(final ByteString byteString, final ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }
    
    @Override
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
    }
    
    @Override
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        final ArrayList list = new ArrayList();
        final c c = new c(this, null);
        while (c.hasNext()) {
            list.add(c.d().asReadOnlyByteBuffer());
        }
        return list;
    }
    
    @Override
    public byte byteAt(final int n) {
        ByteString.checkIndex(n, this.totalLength);
        return this.internalByteAt(n);
    }
    
    @Override
    public void copyTo(final ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }
    
    @Override
    protected void copyToInternal(final byte[] array, final int n, final int n2, final int n3) {
        final int leftLength = this.leftLength;
        if (n + n3 <= leftLength) {
            this.left.copyToInternal(array, n, n2, n3);
        }
        else if (n >= leftLength) {
            this.right.copyToInternal(array, n - leftLength, n2, n3);
        }
        else {
            final int n4 = leftLength - n;
            this.left.copyToInternal(array, n, n2, n4);
            this.right.copyToInternal(array, 0, n2 + n4, n3 - n4);
        }
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
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        final int peekCachedHashCode = this.peekCachedHashCode();
        final int peekCachedHashCode2 = byteString.peekCachedHashCode();
        return (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) && this.k(byteString);
    }
    
    @Override
    protected int getTreeDepth() {
        return this.treeDepth;
    }
    
    @Override
    byte internalByteAt(final int n) {
        final int leftLength = this.leftLength;
        if (n < leftLength) {
            return this.left.internalByteAt(n);
        }
        return this.right.internalByteAt(n - leftLength);
    }
    
    @Override
    protected boolean isBalanced() {
        return this.totalLength >= minLength(this.treeDepth);
    }
    
    @Override
    public boolean isValidUtf8() {
        final ByteString left = this.left;
        final int leftLength = this.leftLength;
        boolean b = false;
        final int partialIsValidUtf8 = left.partialIsValidUtf8(0, 0, leftLength);
        final ByteString right = this.right;
        if (right.partialIsValidUtf8(partialIsValidUtf8, 0, right.size()) == 0) {
            b = true;
        }
        return b;
    }
    
    @Override
    public ByteIterator iterator() {
        return new ByteString.c(this) {
            final RopeByteString.c a = new RopeByteString.c(c, null);
            ByteIterator b = this.c();
            final RopeByteString c;
            
            private ByteIterator c() {
                Object iterator;
                if (this.a.hasNext()) {
                    iterator = this.a.d().iterator();
                }
                else {
                    iterator = null;
                }
                return (ByteIterator)iterator;
            }
            
            @Override
            public byte a() {
                final ByteIterator b = this.b;
                if (b != null) {
                    final byte a = b.a();
                    if (!this.b.hasNext()) {
                        this.b = this.c();
                    }
                    return a;
                }
                throw new NoSuchElementException();
            }
            
            @Override
            public boolean hasNext() {
                return this.b != null;
            }
        };
    }
    
    @Override
    public /* bridge */ Iterator iterator() {
        return this.iterator();
    }
    
    @Override
    public CodedInputStream newCodedInput() {
        return CodedInputStream.f(new d());
    }
    
    @Override
    public InputStream newInput() {
        return new d();
    }
    
    @Override
    protected int partialHash(int partialHash, final int n, final int n2) {
        final int leftLength = this.leftLength;
        if (n + n2 <= leftLength) {
            return this.left.partialHash(partialHash, n, n2);
        }
        if (n >= leftLength) {
            return this.right.partialHash(partialHash, n - leftLength, n2);
        }
        final int n3 = leftLength - n;
        partialHash = this.left.partialHash(partialHash, n, n3);
        return this.right.partialHash(partialHash, 0, n2 - n3);
    }
    
    @Override
    protected int partialIsValidUtf8(int partialIsValidUtf8, final int n, final int n2) {
        final int leftLength = this.leftLength;
        if (n + n2 <= leftLength) {
            return this.left.partialIsValidUtf8(partialIsValidUtf8, n, n2);
        }
        if (n >= leftLength) {
            return this.right.partialIsValidUtf8(partialIsValidUtf8, n - leftLength, n2);
        }
        final int n3 = leftLength - n;
        partialIsValidUtf8 = this.left.partialIsValidUtf8(partialIsValidUtf8, n, n3);
        return this.right.partialIsValidUtf8(partialIsValidUtf8, 0, n2 - n3);
    }
    
    @Override
    public int size() {
        return this.totalLength;
    }
    
    @Override
    public ByteString substring(final int n, final int n2) {
        final int checkRange = ByteString.checkRange(n, n2, this.totalLength);
        if (checkRange == 0) {
            return ByteString.EMPTY;
        }
        if (checkRange == this.totalLength) {
            return this;
        }
        final int leftLength = this.leftLength;
        if (n2 <= leftLength) {
            return this.left.substring(n, n2);
        }
        if (n >= leftLength) {
            return this.right.substring(n - leftLength, n2 - leftLength);
        }
        return new RopeByteString(this.left.substring(n), this.right.substring(0, n2 - this.leftLength));
    }
    
    @Override
    protected String toStringInternal(final Charset charset) {
        return new String(this.toByteArray(), charset);
    }
    
    Object writeReplace() {
        return ByteString.wrap(this.toByteArray());
    }
    
    @Override
    void writeTo(final ByteOutput byteOutput) throws IOException {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }
    
    @Override
    public void writeTo(final OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }
    
    @Override
    void writeToInternal(final OutputStream outputStream, final int n, final int n2) throws IOException {
        final int leftLength = this.leftLength;
        if (n + n2 <= leftLength) {
            this.left.writeToInternal(outputStream, n, n2);
        }
        else if (n >= leftLength) {
            this.right.writeToInternal(outputStream, n - leftLength, n2);
        }
        else {
            final int n3 = leftLength - n;
            this.left.writeToInternal(outputStream, n, n3);
            this.right.writeToInternal(outputStream, 0, n2 - n3);
        }
    }
    
    @Override
    void writeToReverse(final ByteOutput byteOutput) throws IOException {
        this.right.writeToReverse(byteOutput);
        this.left.writeToReverse(byteOutput);
    }
    
    private static class b
    {
        private final ArrayDeque<ByteString> a;
        
        private b() {
            this.a = new ArrayDeque<ByteString>();
        }
        
        b(final RopeByteString$a c) {
            this();
        }
        
        static ByteString a(final b b, final ByteString byteString, final ByteString byteString2) {
            return b.b(byteString, byteString2);
        }
        
        private ByteString b(ByteString o, final ByteString byteString) {
            this.c((ByteString)o);
            this.c(byteString);
            o = this.a.pop();
            while (!this.a.isEmpty()) {
                o = new RopeByteString(this.a.pop(), (ByteString)o, null);
            }
            return (ByteString)o;
        }
        
        private void c(final ByteString byteString) {
            if (byteString.isBalanced()) {
                this.e(byteString);
            }
            else {
                if (!(byteString instanceof RopeByteString)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Has a new type of ByteString been created? Found ");
                    sb.append(byteString.getClass());
                    throw new IllegalArgumentException(sb.toString());
                }
                final RopeByteString ropeByteString = (RopeByteString)byteString;
                this.c(RopeByteString.access$400(ropeByteString));
                this.c(RopeByteString.access$500(ropeByteString));
            }
        }
        
        private int d(int binarySearch) {
            final int n = binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, binarySearch);
            if (n < 0) {
                binarySearch = -(n + 1) - 1;
            }
            return binarySearch;
        }
        
        private void e(final ByteString byteString) {
            final int d = this.d(byteString.size());
            final int minLength = RopeByteString.minLength(d + 1);
            if (!this.a.isEmpty() && this.a.peek().size() < minLength) {
                final int minLength2 = RopeByteString.minLength(d);
                ByteString byteString2 = this.a.pop();
                while (!this.a.isEmpty() && this.a.peek().size() < minLength2) {
                    byteString2 = new RopeByteString(this.a.pop(), byteString2, null);
                }
                RopeByteString ropeByteString;
                for (ropeByteString = new RopeByteString(byteString2, byteString, null); !this.a.isEmpty() && this.a.peek().size() < RopeByteString.minLength(this.d(ropeByteString.size()) + 1); ropeByteString = new RopeByteString(this.a.pop(), ropeByteString, null)) {}
                this.a.push(ropeByteString);
            }
            else {
                this.a.push(byteString);
            }
        }
    }
    
    private static final class c implements Iterator<LeafByteString>
    {
        private final ArrayDeque<RopeByteString> a;
        private LeafByteString b;
        
        private c(final ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                final RopeByteString ropeByteString = (RopeByteString)byteString;
                (this.a = new ArrayDeque<RopeByteString>(ropeByteString.getTreeDepth())).push(ropeByteString);
                this.b = this.b(RopeByteString.access$400(ropeByteString));
            }
            else {
                this.a = null;
                this.b = (LeafByteString)byteString;
            }
        }
        
        c(final ByteString byteString, final RopeByteString$a c) {
            this(byteString);
        }
        
        private LeafByteString b(ByteString access$400) {
            while (access$400 instanceof RopeByteString) {
                final RopeByteString ropeByteString = (RopeByteString)access$400;
                this.a.push(ropeByteString);
                access$400 = RopeByteString.access$400(ropeByteString);
            }
            return (LeafByteString)access$400;
        }
        
        private LeafByteString c() {
            LeafByteString b;
            do {
                final ArrayDeque<RopeByteString> a = this.a;
                if (a == null || a.isEmpty()) {
                    return null;
                }
                b = this.b(RopeByteString.access$500(this.a.pop()));
            } while (b.isEmpty());
            return b;
        }
        
        public LeafByteString d() {
            final LeafByteString b = this.b;
            if (b != null) {
                this.b = this.c();
                return b;
            }
            throw new NoSuchElementException();
        }
        
        @Override
        public boolean hasNext() {
            return this.b != null;
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.d();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private class d extends InputStream
    {
        private c a;
        private LeafByteString b;
        private int c;
        private int d;
        private int e;
        private int f;
        final RopeByteString g;
        
        public d(final RopeByteString g) {
            this.g = g;
            this.c();
        }
        
        private void a() {
            if (this.b != null) {
                final int d = this.d;
                final int c = this.c;
                if (d == c) {
                    this.e += c;
                    this.d = 0;
                    if (this.a.hasNext()) {
                        final LeafByteString d2 = this.a.d();
                        this.b = d2;
                        this.c = d2.size();
                    }
                    else {
                        this.b = null;
                        this.c = 0;
                    }
                }
            }
        }
        
        private void c() {
            final c a = new c(this.g, null);
            this.a = a;
            final LeafByteString d = a.d();
            this.b = d;
            this.c = d.size();
            this.d = 0;
            this.e = 0;
        }
        
        private int d(final byte[] array, int i, final int n) {
            int n2 = i;
            int min;
            int n3;
            for (i = n; i > 0; i -= min, n2 = n3) {
                this.a();
                if (this.b == null) {
                    break;
                }
                min = Math.min(this.c - this.d, i);
                n3 = n2;
                if (array != null) {
                    this.b.copyTo(array, this.d, n2, min);
                    n3 = n2 + min;
                }
                this.d += min;
            }
            return n - i;
        }
        
        @Override
        public int available() throws IOException {
            return this.g.size() - (this.e + this.d);
        }
        
        @Override
        public void mark(final int n) {
            this.f = this.e + this.d;
        }
        
        @Override
        public boolean markSupported() {
            return true;
        }
        
        @Override
        public int read() throws IOException {
            this.a();
            final LeafByteString b = this.b;
            if (b == null) {
                return -1;
            }
            return b.byteAt(this.d++) & 0xFF;
        }
        
        @Override
        public int read(final byte[] array, int n, int d) {
            Objects.requireNonNull(array);
            if (n >= 0 && d >= 0 && d <= array.length - n) {
                d = this.d(array, n, d);
                if ((n = d) == 0) {
                    n = -1;
                }
                return n;
            }
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public void reset() {
            synchronized (this) {
                this.c();
                this.d(null, 0, this.f);
            }
        }
        
        @Override
        public long skip(final long n) {
            if (n >= 0L) {
                long n2 = n;
                if (n > 2147483647L) {
                    n2 = 2147483647L;
                }
                return this.d(null, 0, (int)n2);
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
