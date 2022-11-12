// 
// Decompiled by Procyon v0.6.0
// 

package l2;

import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.content.res.Resources;
import java.util.List;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;

public class f implements c2.f<Uri, Drawable>
{
    private final Context a;
    
    public f(final Context context) {
        this.a = context.getApplicationContext();
    }
    
    private Context d(final Uri uri, final String s) {
        if (s.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
            return this.a.createPackageContext(s, 0);
        }
        catch (final PackageManager$NameNotFoundException ex) {
            if (s.contains(this.a.getPackageName())) {
                return this.a;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to obtain context or unrecognized Uri format for: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString(), (Throwable)ex);
        }
    }
    
    private int e(final Uri uri) {
        final List pathSegments = uri.getPathSegments();
        try {
            return Integer.parseInt((String)pathSegments.get(0));
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized Uri format: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString(), ex);
        }
    }
    
    private int f(final Context context, final Uri uri) {
        final List pathSegments = uri.getPathSegments();
        final String authority = uri.getAuthority();
        final String s = pathSegments.get(0);
        final String s2 = pathSegments.get(1);
        int n;
        if ((n = context.getResources().getIdentifier(s2, s, authority)) == 0) {
            n = Resources.getSystem().getIdentifier(s2, s, "android");
        }
        if (n != 0) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to find resource id for: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private int g(final Context context, final Uri uri) {
        final List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return this.f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return this.e(uri);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized Uri format: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((Uri)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.h((Uri)o, e);
    }
    
    public s<Drawable> c(final Uri uri, int g, final int n, final e e) {
        final Context d = this.d(uri, uri.getAuthority());
        g = this.g(d, uri);
        return e.e(b.b(this.a, d, g));
    }
    
    public boolean h(final Uri uri, final e e) {
        return uri.getScheme().equals("android.resource");
    }
}
