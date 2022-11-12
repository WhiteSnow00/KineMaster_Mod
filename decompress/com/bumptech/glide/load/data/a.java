// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import android.net.Uri;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;

public final class a extends l<AssetFileDescriptor>
{
    public a(final ContentResolver contentResolver, final Uri uri) {
        super(contentResolver, uri);
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
    protected /* bridge */ Object f(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        return this.h(uri, contentResolver);
    }
    
    protected void g(final AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }
    
    protected AssetFileDescriptor h(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        final AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("FileDescriptor is null for: ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }
}
