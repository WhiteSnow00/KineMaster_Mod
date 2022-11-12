// 
// Decompiled by Procyon v0.6.0
// 

package s1;

import y1.d;
import android.view.View;
import java.util.HashMap;
import android.graphics.drawable.Drawable$Callback;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import java.util.Map;
import t1.h;

public class a
{
    private final h<String> a;
    private final Map<h<String>, Typeface> b;
    private final Map<String, Typeface> c;
    private final AssetManager d;
    private com.airbnb.lottie.a e;
    private String f;
    
    public a(final Drawable$Callback drawable$Callback, final com.airbnb.lottie.a e) {
        this.a = new h<String>();
        this.b = new HashMap<h<String>, Typeface>();
        this.c = new HashMap<String, Typeface>();
        this.f = ".ttf";
        this.e = e;
        if (!(drawable$Callback instanceof View)) {
            y1.d.c("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
            return;
        }
        this.d = ((View)drawable$Callback).getContext().getAssets();
    }
    
    private Typeface a(final String s) {
        final Typeface typeface = this.c.get(s);
        if (typeface != null) {
            return typeface;
        }
        Typeface a = null;
        final com.airbnb.lottie.a e = this.e;
        if (e != null) {
            a = e.a(s);
        }
        final com.airbnb.lottie.a e2 = this.e;
        Typeface fromAsset = a;
        if (e2 != null && (fromAsset = a) == null) {
            final String b = e2.b(s);
            fromAsset = a;
            if (b != null) {
                fromAsset = Typeface.createFromAsset(this.d, b);
            }
        }
        Typeface fromAsset2;
        if ((fromAsset2 = fromAsset) == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("fonts/");
            sb.append(s);
            sb.append(this.f);
            fromAsset2 = Typeface.createFromAsset(this.d, sb.toString());
        }
        this.c.put(s, fromAsset2);
        return fromAsset2;
    }
    
    private Typeface d(final Typeface typeface, final String s) {
        final boolean contains = s.contains("Italic");
        final boolean contains2 = s.contains("Bold");
        int n;
        if (contains && contains2) {
            n = 3;
        }
        else if (contains) {
            n = 2;
        }
        else if (contains2) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (typeface.getStyle() == n) {
            return typeface;
        }
        return Typeface.create(typeface, n);
    }
    
    public Typeface b(final String s, final String s2) {
        this.a.b(s, s2);
        final Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        final Typeface d = this.d(this.a(s), s2);
        this.b.put(this.a, d);
        return d;
    }
    
    public void c(final com.airbnb.lottie.a e) {
        this.e = e;
    }
}
