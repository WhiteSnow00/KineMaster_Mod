// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.os.Build;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import c2.f;

public final class u implements f<ParcelFileDescriptor, Bitmap>
{
    private final l a;
    
    public u(final l a) {
        this.a = a;
    }
    
    private boolean e(final ParcelFileDescriptor parcelFileDescriptor) {
        final String manufacturer = Build.MANUFACTURER;
        final boolean equalsIgnoreCase = "HUAWEI".equalsIgnoreCase(manufacturer);
        boolean b = true;
        if (!equalsIgnoreCase && !"HONOR".equalsIgnoreCase(manufacturer)) {
            return true;
        }
        if (parcelFileDescriptor.getStatSize() > 536870912L) {
            b = false;
        }
        return b;
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((ParcelFileDescriptor)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((ParcelFileDescriptor)o, e);
    }
    
    public s<Bitmap> c(final ParcelFileDescriptor parcelFileDescriptor, final int n, final int n2, final e e) throws IOException {
        return this.a.d(parcelFileDescriptor, n, n2, e);
    }
    
    public boolean d(final ParcelFileDescriptor parcelFileDescriptor, final e e) {
        return this.e(parcelFileDescriptor) && this.a.o(parcelFileDescriptor);
    }
}
