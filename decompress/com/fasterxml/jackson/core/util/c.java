// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.io.OutputStream;

public final class c extends OutputStream
{
    public static final byte[] f;
    private final a a;
    private final LinkedList<byte[]> b;
    private int c;
    private byte[] d;
    private int e;
    
    static {
        f = new byte[0];
    }
    
    public c(final a a) {
        this(a, 500);
    }
    
    public c(final a a, final int n) {
        this.b = new LinkedList<byte[]>();
        this.a = a;
        byte[] a2;
        if (a == null) {
            a2 = new byte[n];
        }
        else {
            a2 = a.a(2);
        }
        this.d = a2;
    }
    
    private void a() {
        final int c = this.c + this.d.length;
        if (c >= 0) {
            this.c = c;
            int max;
            if ((max = Math.max(c >> 1, 1000)) > 262144) {
                max = 262144;
            }
            this.b.add(this.d);
            this.d = new byte[max];
            this.e = 0;
            return;
        }
        throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
    }
    
    public void c(final int n) {
        if (this.e >= this.d.length) {
            this.a();
        }
        this.d[this.e++] = (byte)n;
    }
    
    @Override
    public void close() {
    }
    
    public byte[] d(final int e) {
        this.e = e;
        return this.l();
    }
    
    public byte[] e() {
        this.a();
        return this.d;
    }
    
    @Override
    public void flush() {
    }
    
    public byte[] h() {
        return this.d;
    }
    
    public int i() {
        return this.e;
    }
    
    public byte[] j() {
        this.reset();
        return this.d;
    }
    
    public void k(final int e) {
        this.e = e;
    }
    
    public byte[] l() {
        final int n = this.c + this.e;
        if (n == 0) {
            return com.fasterxml.jackson.core.util.c.f;
        }
        final byte[] array = new byte[n];
        final Iterator<Object> iterator = this.b.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            final byte[] array2 = iterator.next();
            final int length = array2.length;
            System.arraycopy(array2, 0, array, n2, length);
            n2 += length;
        }
        System.arraycopy(this.d, 0, array, n2, this.e);
        final int n3 = n2 + this.e;
        if (n3 == n) {
            if (!this.b.isEmpty()) {
                this.reset();
            }
            return array;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Internal error: total len assumed to be ");
        sb.append(n);
        sb.append(", copied ");
        sb.append(n3);
        sb.append(" bytes");
        throw new RuntimeException(sb.toString());
    }
    
    public void reset() {
        this.c = 0;
        this.e = 0;
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
    }
    
    @Override
    public void write(final int n) {
        this.c(n);
    }
    
    @Override
    public void write(final byte[] array) {
        this.write(array, 0, array.length);
    }
    
    @Override
    public void write(final byte[] array, int n, int n2) {
        int n3 = n;
        while (true) {
            final int min = Math.min(this.d.length - this.e, n2);
            int n4 = n3;
            n = n2;
            if (min > 0) {
                System.arraycopy(array, n3, this.d, this.e, min);
                n4 = n3 + min;
                this.e += min;
                n = n2 - min;
            }
            if (n <= 0) {
                break;
            }
            this.a();
            n3 = n4;
            n2 = n;
        }
    }
}
