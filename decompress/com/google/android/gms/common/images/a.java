// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;
import java.io.IOException;
import android.util.Log;
import android.graphics.BitmapFactory;
import com.google.android.gms.common.internal.Asserts;
import android.os.ParcelFileDescriptor;
import android.net.Uri;

final class a implements Runnable
{
    private final Uri a;
    private final ParcelFileDescriptor b;
    final ImageManager c;
    
    public a(final ImageManager c, final Uri a, final ParcelFileDescriptor b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        Asserts.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        final ParcelFileDescriptor b = this.b;
        Bitmap decodeFileDescriptor = null;
        final Bitmap bitmap = null;
        boolean b2 = false;
        final boolean b3 = false;
        if (b != null) {
            try {
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(b.getFileDescriptor());
                b2 = b3;
            }
            catch (final OutOfMemoryError outOfMemoryError) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.a)), (Throwable)outOfMemoryError);
                b2 = true;
                decodeFileDescriptor = bitmap;
            }
            try {
                this.b.close();
            }
            catch (final IOException ex) {
                Log.e("ImageManager", "closed failed", (Throwable)ex);
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ImageManager c = this.c;
        ImageManager.b(c).post((Runnable)new b(c, this.a, decodeFileDescriptor, b2, countDownLatch));
        try {
            countDownLatch.await();
        }
        catch (final InterruptedException ex2) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.a)));
        }
    }
}
