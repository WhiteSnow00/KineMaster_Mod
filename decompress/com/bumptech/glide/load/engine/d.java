// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.io.File;
import c2.e;
import f2.a;

class d<DataType> implements b
{
    private final c2.a<DataType> a;
    private final DataType b;
    private final e c;
    
    d(final c2.a<DataType> a, final DataType b, final e c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean a(final File file) {
        return this.a.b(this.b, file, this.c);
    }
}
