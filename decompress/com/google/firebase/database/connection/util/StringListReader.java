// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection.util;

import java.util.Iterator;
import java.nio.CharBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;

public class StringListReader extends Reader
{
    private List<String> a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    
    public StringListReader() {
        this.a = null;
        this.b = false;
        this.e = this.c;
        this.f = this.d;
        this.g = false;
        this.a = new ArrayList<String>();
    }
    
    private long c(final long n) {
        long n2 = 0L;
        while (this.d < this.a.size() && n2 < n) {
            final int h = this.h();
            final long n3 = n - n2;
            final long n4 = h;
            if (n3 < n4) {
                this.c += (int)n3;
                n2 += n3;
            }
            else {
                n2 += n4;
                this.c = 0;
                ++this.d;
            }
        }
        return n2;
    }
    
    private void d() throws IOException {
        if (this.b) {
            throw new IOException("Stream already closed");
        }
        if (this.g) {
            return;
        }
        throw new IOException("Reader needs to be frozen before read operations can be called");
    }
    
    private String e() {
        String s;
        if (this.d < this.a.size()) {
            s = this.a.get(this.d);
        }
        else {
            s = null;
        }
        return s;
    }
    
    private int h() {
        final String e = this.e();
        int n;
        if (e == null) {
            n = 0;
        }
        else {
            n = e.length() - this.c;
        }
        return n;
    }
    
    public void a(final String s) {
        if (!this.g) {
            if (s.length() > 0) {
                this.a.add(s);
            }
            return;
        }
        throw new IllegalStateException("Trying to add string after reading");
    }
    
    @Override
    public void close() throws IOException {
        this.d();
        this.b = true;
    }
    
    public void i() {
        if (!this.g) {
            this.g = true;
            return;
        }
        throw new IllegalStateException("Trying to freeze frozen StringListReader");
    }
    
    @Override
    public void mark(final int n) throws IOException {
        this.d();
        this.e = this.c;
        this.f = this.d;
    }
    
    @Override
    public boolean markSupported() {
        return true;
    }
    
    @Override
    public int read() throws IOException {
        this.d();
        final String e = this.e();
        if (e == null) {
            return -1;
        }
        final char char1 = e.charAt(this.c);
        this.c(1L);
        return char1;
    }
    
    @Override
    public int read(final CharBuffer charBuffer) throws IOException {
        this.d();
        int remaining = charBuffer.remaining();
        String s = this.e();
        int n = 0;
        while (remaining > 0 && s != null) {
            final int min = Math.min(s.length() - this.c, remaining);
            final String s2 = this.a.get(this.d);
            final int c = this.c;
            charBuffer.put(s2, c, c + min);
            remaining -= min;
            n += min;
            this.c(min);
            s = this.e();
        }
        if (n <= 0 && s == null) {
            return -1;
        }
        return n;
    }
    
    @Override
    public int read(final char[] array, final int n, final int n2) throws IOException {
        this.d();
        String s;
        int n3;
        int min;
        int c;
        for (s = this.e(), n3 = 0; s != null && n3 < n2; s = this.e()) {
            min = Math.min(this.h(), n2 - n3);
            c = this.c;
            s.getChars(c, c + min, array, n + n3);
            n3 += min;
            this.c(min);
        }
        if (n3 <= 0 && s == null) {
            return -1;
        }
        return n3;
    }
    
    @Override
    public boolean ready() throws IOException {
        this.d();
        return true;
    }
    
    @Override
    public void reset() throws IOException {
        this.c = this.e;
        this.d = this.f;
    }
    
    @Override
    public long skip(final long n) throws IOException {
        this.d();
        return this.c(n);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Iterator<String> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
