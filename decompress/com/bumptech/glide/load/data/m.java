// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.IOException;
import android.content.res.AssetManager;
import java.io.InputStream;

public class m extends b<InputStream>
{
    public m(final AssetManager assetManager, final String s) {
        super(assetManager, s);
    }
    
    @Override
    public Class<InputStream> a() {
        return InputStream.class;
    }
    
    @Override
    protected /* bridge */ void c(final Object o) throws IOException {
        this.g((InputStream)o);
    }
    
    @Override
    protected /* bridge */ Object f(final AssetManager assetManager, final String s) throws IOException {
        return this.h(assetManager, s);
    }
    
    protected void g(final InputStream inputStream) throws IOException {
        inputStream.close();
    }
    
    protected InputStream h(final AssetManager assetManager, final String s) throws IOException {
        return assetManager.open(s);
    }
}
