// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.io.IOException;

public class ForwardingExtractorInput implements ExtractorInput
{
    private final ExtractorInput a;
    
    public ForwardingExtractorInput(final ExtractorInput a) {
        this.a = a;
    }
    
    @Override
    public int a(final int n) throws IOException {
        return this.a.a(n);
    }
    
    @Override
    public boolean f(final byte[] array, final int n, final int n2, final boolean b) throws IOException {
        return this.a.f(array, n, n2, b);
    }
    
    @Override
    public long getLength() {
        return this.a.getLength();
    }
    
    @Override
    public long getPosition() {
        return this.a.getPosition();
    }
    
    @Override
    public void h() {
        this.a.h();
    }
    
    @Override
    public boolean i(final byte[] array, final int n, final int n2, final boolean b) throws IOException {
        return this.a.i(array, n, n2, b);
    }
    
    @Override
    public long k() {
        return this.a.k();
    }
    
    @Override
    public void m(final int n) throws IOException {
        this.a.m(n);
    }
    
    @Override
    public int n(final byte[] array, final int n, final int n2) throws IOException {
        return this.a.n(array, n, n2);
    }
    
    @Override
    public void o(final int n) throws IOException {
        this.a.o(n);
    }
    
    @Override
    public boolean p(final int n, final boolean b) throws IOException {
        return this.a.p(n, b);
    }
    
    @Override
    public void r(final byte[] array, final int n, final int n2) throws IOException {
        this.a.r(array, n, n2);
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) throws IOException {
        return this.a.read(array, n, n2);
    }
    
    @Override
    public void readFully(final byte[] array, final int n, final int n2) throws IOException {
        this.a.readFully(array, n, n2);
    }
}
