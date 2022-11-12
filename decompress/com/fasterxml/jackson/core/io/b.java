// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.DataOutput;
import java.io.OutputStream;

public class b extends OutputStream
{
    protected final DataOutput a;
    
    public b(final DataOutput a) {
        this.a = a;
    }
    
    @Override
    public void write(final int n) throws IOException {
        this.a.write(n);
    }
    
    @Override
    public void write(final byte[] array) throws IOException {
        this.a.write(array, 0, array.length);
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) throws IOException {
        this.a.write(array, n, n2);
    }
}
