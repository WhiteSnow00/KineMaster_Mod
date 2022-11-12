// 
// Decompiled by Procyon v0.6.0
// 

package s1;

import java.io.InputStream;
import android.content.res.AssetManager;
import java.io.IOException;
import y1.h;
import android.graphics.Rect;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.graphics.BitmapFactory$Options;
import android.graphics.Bitmap;
import java.util.HashMap;
import y1.d;
import android.view.View;
import android.text.TextUtils;
import android.graphics.drawable.Drawable$Callback;
import com.airbnb.lottie.g;
import java.util.Map;
import android.content.Context;

public class b
{
    private static final Object e;
    private final Context a;
    private String b;
    private com.airbnb.lottie.b c;
    private final Map<String, g> d;
    
    static {
        e = new Object();
    }
    
    public b(final Drawable$Callback drawable$Callback, String b, final com.airbnb.lottie.b b2, final Map<String, g> d) {
        this.b = b;
        if (!TextUtils.isEmpty((CharSequence)b)) {
            b = this.b;
            if (b.charAt(b.length() - 1) != '/') {
                final StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                sb.append('/');
                this.b = sb.toString();
            }
        }
        if (!(drawable$Callback instanceof View)) {
            y1.d.c("LottieDrawable must be inside of a view for images to work.");
            this.d = new HashMap<String, g>();
            this.a = null;
            return;
        }
        this.a = ((View)drawable$Callback).getContext();
        this.d = d;
        this.d(b2);
    }
    
    private Bitmap c(final String s, final Bitmap bitmap) {
        synchronized (s1.b.e) {
            this.d.get(s).f(bitmap);
            return bitmap;
        }
    }
    
    public Bitmap a(final String s) {
        final g g = this.d.get(s);
        if (g == null) {
            return null;
        }
        final Bitmap a = g.a();
        if (a != null) {
            return a;
        }
        final com.airbnb.lottie.b c = this.c;
        if (c != null) {
            final Bitmap a2 = c.a(g);
            if (a2 != null) {
                this.c(s, a2);
            }
            return a2;
        }
        final String b = g.b();
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inScaled = true;
        bitmapFactory$Options.inDensity = 160;
        if (b.startsWith("data:") && b.indexOf("base64,") > 0) {
            try {
                final byte[] decode = Base64.decode(b.substring(b.indexOf(44) + 1), 0);
                return this.c(s, BitmapFactory.decodeByteArray(decode, 0, decode.length, bitmapFactory$Options));
            }
            catch (final IllegalArgumentException ex) {
                y1.d.d("data URL did not have correct base64 format.", ex);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty((CharSequence)this.b)) {
                final AssetManager assets = this.a.getAssets();
                final StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                sb.append(b);
                final InputStream open = assets.open(sb.toString());
                try {
                    return this.c(s, h.l(BitmapFactory.decodeStream(open, (Rect)null, bitmapFactory$Options), g.e(), g.c()));
                }
                catch (final IllegalArgumentException ex2) {
                    y1.d.d("Unable to decode image.", ex2);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        }
        catch (final IOException ex3) {
            y1.d.d("Unable to open asset.", ex3);
            return null;
        }
    }
    
    public boolean b(final Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }
    
    public void d(final com.airbnb.lottie.b c) {
        this.c = c;
    }
}
