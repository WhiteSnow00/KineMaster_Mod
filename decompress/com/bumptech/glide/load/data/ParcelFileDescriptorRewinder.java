// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;
import android.os.ParcelFileDescriptor;

public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor>
{
    private final InternalRewinder a;
    
    public ParcelFileDescriptorRewinder(final ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new InternalRewinder(parcelFileDescriptor);
    }
    
    public static boolean c() {
        return true;
    }
    
    @Override
    public /* bridge */ Object a() throws IOException {
        return this.d();
    }
    
    @Override
    public void b() {
    }
    
    public ParcelFileDescriptor d() throws IOException {
        return this.a.rewind();
    }
    
    private static final class InternalRewinder
    {
        private final ParcelFileDescriptor a;
        
        InternalRewinder(final ParcelFileDescriptor a) {
            this.a = a;
        }
        
        ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.a;
            }
            catch (final ErrnoException ex) {
                throw new IOException((Throwable)ex);
            }
        }
    }
    
    public static final class a implements e.a<ParcelFileDescriptor>
    {
        @Override
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
        
        @Override
        public /* bridge */ e b(final Object o) {
            return this.c((ParcelFileDescriptor)o);
        }
        
        public e<ParcelFileDescriptor> c(final ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }
}
