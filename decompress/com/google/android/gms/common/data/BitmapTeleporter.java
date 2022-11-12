// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.FileNotFoundException;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcel;
import java.io.IOException;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@ShowFirstParty
@Class
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable
{
    @KeepForSdk
    public static final Parcelable$Creator<BitmapTeleporter> CREATOR;
    @VersionField
    final int a;
    @Field
    ParcelFileDescriptor b;
    @Field
    final int c;
    private Bitmap d;
    private boolean e;
    private File f;
    
    static {
        CREATOR = (Parcelable$Creator)new zaa();
    }
    
    @Constructor
    BitmapTeleporter(@Param final int a, @Param final ParcelFileDescriptor b, @Param final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = null;
        this.e = false;
    }
    
    private static final void K1(final Closeable closeable) {
        try {
            closeable.close();
        }
        catch (final IOException ex) {
            Log.w("BitmapTeleporter", "Could not close stream", (Throwable)ex);
        }
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        if (this.b == null) {
            final Bitmap bitmap = Preconditions.k(this.d);
            final ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer((Buffer)allocate);
            final byte[] array = allocate.array();
            final File f = this.f;
            if (f != null) {
                try {
                    final File tempFile = File.createTempFile("teleporter", ".tmp", f);
                    try {
                        final FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
                        this.b = ParcelFileDescriptor.open(tempFile, 268435456);
                        tempFile.delete();
                        final DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                        try {
                            try {
                                dataOutputStream.writeInt(array.length);
                                dataOutputStream.writeInt(bitmap.getWidth());
                                dataOutputStream.writeInt(bitmap.getHeight());
                                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                                dataOutputStream.write(array);
                                K1(dataOutputStream);
                            }
                            finally {}
                        }
                        catch (final IOException ex) {
                            throw new IllegalStateException("Could not write into unlinked file", ex);
                        }
                        K1(dataOutputStream);
                    }
                    catch (final FileNotFoundException ex2) {
                        throw new IllegalStateException("Temporary file is somehow already deleted");
                    }
                }
                catch (final IOException ex3) {
                    throw new IllegalStateException("Could not create temporary file", ex3);
                }
            }
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.b, n | 0x1, false);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.b(parcel, a);
        this.b = null;
    }
}
