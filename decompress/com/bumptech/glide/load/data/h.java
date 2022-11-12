// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.IOException;
import android.content.res.AssetManager;
import android.content.res.AssetFileDescriptor;

public class h extends b<AssetFileDescriptor>
{
    public h(final AssetManager assetManager, final String s) {
        super(assetManager, s);
    }
    
    @Override
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }
    
    @Override
    protected /* bridge */ void c(final Object o) throws IOException {
        this.g((AssetFileDescriptor)o);
    }
    
    @Override
    protected /* bridge */ Object f(final AssetManager assetManager, final String s) throws IOException {
        return this.h(assetManager, s);
    }
    
    protected void g(final AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }
    
    protected AssetFileDescriptor h(final AssetManager assetManager, final String s) throws IOException {
        return assetManager.openFd(s);
    }
}
