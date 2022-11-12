// 
// Decompiled by Procyon v0.6.0
// 

package j2;

import android.util.Size;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import android.os.Build$VERSION;
import android.util.Log;
import android.graphics.ImageDecoder$DecodeException;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.graphics.ImageDecoder$Source;
import android.graphics.ImageDecoder$ImageInfo;
import android.graphics.ImageDecoder;
import c2.d;
import com.bumptech.glide.load.resource.bitmap.l;
import c2.e;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.q;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;

public final class a implements ImageDecoder$OnHeaderDecodedListener
{
    private final q a;
    private final int b;
    private final int c;
    private final DecodeFormat d;
    private final DownsampleStrategy e;
    private final boolean f;
    private final PreferredColorSpace g;
    
    public a(final int b, final int c, final e e) {
        this.a = q.b();
        this.b = b;
        this.c = c;
        this.d = e.c(l.f);
        this.e = e.c(DownsampleStrategy.h);
        final d<Boolean> j = l.j;
        this.f = (e.c((d<Object>)j) != null && e.c(j));
        this.g = e.c(l.g);
    }
    
    public void onHeaderDecoded(final ImageDecoder imageDecoder, final ImageDecoder$ImageInfo imageDecoder$ImageInfo, final ImageDecoder$Source imageDecoder$Source) {
        final q a = this.a;
        final int b = this.b;
        final int c = this.c;
        final boolean f = this.f;
        final boolean b2 = false;
        if (a.e(b, c, f, false)) {
            imageDecoder.setAllocator(3);
        }
        else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener((ImageDecoder$OnPartialImageListener)new ImageDecoder$OnPartialImageListener(this) {
            final a a;
            
            public boolean onPartialImage(final ImageDecoder$DecodeException ex) {
                return false;
            }
        });
        final Size size = imageDecoder$ImageInfo.getSize();
        int n;
        if ((n = this.b) == Integer.MIN_VALUE) {
            n = size.getWidth();
        }
        int n2;
        if ((n2 = this.c) == Integer.MIN_VALUE) {
            n2 = size.getHeight();
        }
        final float b3 = this.e.b(size.getWidth(), size.getHeight(), n, n2);
        final int round = Math.round(size.getWidth() * b3);
        final int round2 = Math.round(size.getHeight() * b3);
        if (Log.isLoggable("ImageDecoder", 2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Resizing from [");
            sb.append(size.getWidth());
            sb.append("x");
            sb.append(size.getHeight());
            sb.append("] to [");
            sb.append(round);
            sb.append("x");
            sb.append(round2);
            sb.append("] scaleFactor: ");
            sb.append(b3);
            Log.v("ImageDecoder", sb.toString());
        }
        imageDecoder.setTargetSize(round, round2);
        final PreferredColorSpace g = this.g;
        if (g != null) {
            if (Build$VERSION.SDK_INT >= 28) {
                int n3 = b2 ? 1 : 0;
                if (g == PreferredColorSpace.DISPLAY_P3) {
                    n3 = (b2 ? 1 : 0);
                    if (imageDecoder$ImageInfo.getColorSpace() != null) {
                        n3 = (b2 ? 1 : 0);
                        if (imageDecoder$ImageInfo.getColorSpace().isWideGamut()) {
                            n3 = 1;
                        }
                    }
                }
                ColorSpace$Named colorSpace$Named;
                if (n3 != 0) {
                    colorSpace$Named = ColorSpace$Named.DISPLAY_P3;
                }
                else {
                    colorSpace$Named = ColorSpace$Named.SRGB;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(colorSpace$Named));
            }
            else {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace$Named.SRGB));
            }
        }
    }
}
