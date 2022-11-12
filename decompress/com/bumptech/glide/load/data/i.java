// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.net.Uri;
import android.content.ContentResolver;
import android.os.ParcelFileDescriptor;

public class i extends l<ParcelFileDescriptor>
{
    public i(final ContentResolver contentResolver, final Uri uri) {
        super(contentResolver, uri);
    }
    
    @Override
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
    
    @Override
    protected /* bridge */ void c(final Object o) throws IOException {
        this.g((ParcelFileDescriptor)o);
    }
    
    @Override
    protected /* bridge */ Object f(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        return this.h(uri, contentResolver);
    }
    
    protected void g(final ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
    
    protected ParcelFileDescriptor h(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        final AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("FileDescriptor is null for: ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }
}
