// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import java.util.ArrayList;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Asserts;
import java.util.concurrent.CountDownLatch;
import android.graphics.Bitmap;
import android.net.Uri;

final class b implements Runnable
{
    private final Uri a;
    private final Bitmap b;
    private final CountDownLatch c;
    final ImageManager d;
    
    public b(final ImageManager d, final Uri a, final Bitmap b, final boolean b2, final CountDownLatch c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        Asserts.a("OnBitmapLoadedRunnable must be executed in the main thread");
        final Bitmap b = this.b;
        final ImageManager.ImageReceiver imageReceiver = ImageManager.h(this.d).remove(this.a);
        if (imageReceiver != null) {
            final ArrayList a = ImageManager.ImageReceiver.a(imageReceiver);
            for (int size = a.size(), i = 0; i < size; ++i) {
                final zag zag = a.get(i);
                final Bitmap b2 = this.b;
                if (b2 != null && b != null) {
                    zag.c(ImageManager.a(this.d), b2, false);
                }
                else {
                    ImageManager.f(this.d).put(this.a, SystemClock.elapsedRealtime());
                    final ImageManager d = this.d;
                    zag.b(ImageManager.a(d), ImageManager.c(d), false);
                }
                if (!(zag instanceof zaf)) {
                    ImageManager.g(this.d).remove(zag);
                }
            }
        }
        this.c.countDown();
        synchronized (ImageManager.d()) {
            ImageManager.e().remove(this.a);
        }
    }
}
