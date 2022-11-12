// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics.drawable;

import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import java.lang.reflect.InvocationTargetException;
import android.os.Build$VERSION;
import androidx.core.util.h;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.io.FileNotFoundException;
import android.util.Log;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import android.content.Context;
import android.text.TextUtils;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.core.util.c;
import android.net.Uri;
import android.graphics.drawable.Icon;
import android.content.res.ColorStateList;
import android.os.Parcelable;
import android.graphics.PorterDuff$Mode;
import androidx.versionedparcelable.CustomVersionedParcelable;

public class IconCompat extends CustomVersionedParcelable
{
    static final PorterDuff$Mode k;
    public int a;
    Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g;
    PorterDuff$Mode h;
    public String i;
    public String j;
    
    static {
        k = PorterDuff$Mode.SRC_IN;
    }
    
    public IconCompat() {
        this.a = -1;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = IconCompat.k;
        this.i = null;
    }
    
    IconCompat(final int a) {
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = IconCompat.k;
        this.i = null;
        this.a = a;
    }
    
    public static IconCompat b(final Icon icon) {
        return a.a(icon);
    }
    
    public static IconCompat c(final Uri uri) {
        androidx.core.util.c.c(uri);
        return d(uri.toString());
    }
    
    public static IconCompat d(final String b) {
        androidx.core.util.c.c(b);
        final IconCompat iconCompat = new IconCompat(6);
        iconCompat.b = b;
        return iconCompat;
    }
    
    public static IconCompat e(final Bitmap b) {
        androidx.core.util.c.c(b);
        final IconCompat iconCompat = new IconCompat(1);
        iconCompat.b = b;
        return iconCompat;
    }
    
    public static IconCompat f(final Uri uri) {
        androidx.core.util.c.c(uri);
        return g(uri.toString());
    }
    
    public static IconCompat g(final String b) {
        androidx.core.util.c.c(b);
        final IconCompat iconCompat = new IconCompat(4);
        iconCompat.b = b;
        return iconCompat;
    }
    
    public static IconCompat h(final Resources resources, final String s, final int e) {
        androidx.core.util.c.c(s);
        if (e != 0) {
            final IconCompat iconCompat = new IconCompat(2);
            iconCompat.e = e;
            Label_0055: {
                if (resources != null) {
                    try {
                        iconCompat.b = resources.getResourceName(e);
                        break Label_0055;
                    }
                    catch (final Resources$NotFoundException ex) {
                        throw new IllegalArgumentException("Icon resource cannot be found");
                    }
                }
                iconCompat.b = s;
            }
            iconCompat.j = s;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }
    
    private static String r(final int n) {
        switch (n) {
            default: {
                return "UNKNOWN";
            }
            case 6: {
                return "URI_MASKABLE";
            }
            case 5: {
                return "BITMAP_MASKABLE";
            }
            case 4: {
                return "URI";
            }
            case 3: {
                return "DATA";
            }
            case 2: {
                return "RESOURCE";
            }
            case 1: {
                return "BITMAP";
            }
        }
    }
    
    public int i() {
        final int a = this.a;
        if (a == -1) {
            return IconCompat.a.b(this.b);
        }
        if (a == 2) {
            return this.e;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("called getResId() on ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }
    
    public String j() {
        final int a = this.a;
        if (a == -1) {
            return IconCompat.a.c(this.b);
        }
        if (a != 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("called getResPackage() on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        final String j = this.j;
        if (j != null && !TextUtils.isEmpty((CharSequence)j)) {
            return this.j;
        }
        return ((String)this.b).split(":", -1)[0];
    }
    
    public int k() {
        int n;
        if ((n = this.a) == -1) {
            n = IconCompat.a.d(this.b);
        }
        return n;
    }
    
    public Uri l() {
        final int a = this.a;
        if (a == -1) {
            return IconCompat.a.e(this.b);
        }
        if (a != 4 && a != 6) {
            final StringBuilder sb = new StringBuilder();
            sb.append("called getUri() on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        return Uri.parse((String)this.b);
    }
    
    public InputStream m(final Context context) {
        final Uri l = this.l();
        final String scheme = l.getScheme();
        if (!"content".equals(scheme)) {
            if (!"file".equals(scheme)) {
                try {
                    return new FileInputStream(new File((String)this.b));
                }
                catch (final FileNotFoundException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unable to load image from path: ");
                    sb.append(l);
                    Log.w("IconCompat", sb.toString(), (Throwable)ex);
                    return null;
                }
            }
        }
        try {
            return context.getContentResolver().openInputStream(l);
        }
        catch (final Exception ex2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to load image from URI: ");
            sb2.append(l);
            Log.w("IconCompat", sb2.toString(), (Throwable)ex2);
        }
        return null;
    }
    
    public void n() {
        this.h = PorterDuff$Mode.valueOf(this.i);
        switch (this.a) {
            case 3: {
                this.b = this.c;
                break;
            }
            case 2:
            case 4:
            case 6: {
                final String b = new String(this.c, Charset.forName("UTF-16"));
                this.b = b;
                if (this.a == 2 && this.j == null) {
                    this.j = b.split(":", -1)[0];
                    break;
                }
                break;
            }
            case 1:
            case 5: {
                final Parcelable d = this.d;
                if (d != null) {
                    this.b = d;
                    break;
                }
                final byte[] c = this.c;
                this.b = c;
                this.a = 3;
                this.e = 0;
                this.f = c.length;
                break;
            }
            case -1: {
                final Parcelable d2 = this.d;
                if (d2 != null) {
                    this.b = d2;
                    break;
                }
                throw new IllegalArgumentException("Invalid icon");
            }
        }
    }
    
    public void o(final boolean b) {
        this.i = this.h.name();
        switch (this.a) {
            case 4:
            case 6: {
                this.c = this.b.toString().getBytes(Charset.forName("UTF-16"));
                break;
            }
            case 3: {
                this.c = (byte[])this.b;
                break;
            }
            case 2: {
                this.c = ((String)this.b).getBytes(Charset.forName("UTF-16"));
                break;
            }
            case 1:
            case 5: {
                if (b) {
                    final Bitmap bitmap = (Bitmap)this.b;
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap$CompressFormat.PNG, 90, (OutputStream)byteArrayOutputStream);
                    this.c = byteArrayOutputStream.toByteArray();
                    break;
                }
                this.d = (Parcelable)this.b;
                break;
            }
            case -1: {
                if (!b) {
                    this.d = (Parcelable)this.b;
                    break;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            }
        }
    }
    
    @Deprecated
    public Icon p() {
        return this.q(null);
    }
    
    public Icon q(final Context context) {
        return IconCompat.a.g(this, context);
    }
    
    @Override
    public String toString() {
        if (this.a == -1) {
            return String.valueOf(this.b);
        }
        final StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(r(this.a));
        switch (this.a) {
            case 4:
            case 6: {
                sb.append(" uri=");
                sb.append(this.b);
                break;
            }
            case 3: {
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    sb.append(this.f);
                    break;
                }
                break;
            }
            case 2: {
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", this.i()));
                break;
            }
            case 1:
            case 5: {
                sb.append(" size=");
                sb.append(((Bitmap)this.b).getWidth());
                sb.append("x");
                sb.append(((Bitmap)this.b).getHeight());
                break;
            }
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != IconCompat.k) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }
    
    static class a
    {
        static IconCompat a(final Object b) {
            h.g(b);
            final int d = d(b);
            if (d == 2) {
                return IconCompat.h(null, c(b), b(b));
            }
            if (d == 4) {
                return IconCompat.f(e(b));
            }
            if (d != 6) {
                final IconCompat iconCompat = new IconCompat(-1);
                iconCompat.b = b;
                return iconCompat;
            }
            return IconCompat.c(e(b));
        }
        
        static int b(final Object o) {
            if (Build$VERSION.SDK_INT >= 28) {
                return c.a(o);
            }
            try {
                return (int)o.getClass().getMethod("getResId", (Class<?>[])new Class[0]).invoke(o, new Object[0]);
            }
            catch (final NoSuchMethodException ex) {
                Log.e("IconCompat", "Unable to get icon resource", (Throwable)ex);
                return 0;
            }
            catch (final InvocationTargetException ex2) {
                Log.e("IconCompat", "Unable to get icon resource", (Throwable)ex2);
                return 0;
            }
            catch (final IllegalAccessException ex3) {
                Log.e("IconCompat", "Unable to get icon resource", (Throwable)ex3);
                return 0;
            }
        }
        
        static String c(final Object o) {
            if (Build$VERSION.SDK_INT >= 28) {
                return c.b(o);
            }
            try {
                return (String)o.getClass().getMethod("getResPackage", (Class<?>[])new Class[0]).invoke(o, new Object[0]);
            }
            catch (final NoSuchMethodException ex) {
                Log.e("IconCompat", "Unable to get icon package", (Throwable)ex);
                return null;
            }
            catch (final InvocationTargetException ex2) {
                Log.e("IconCompat", "Unable to get icon package", (Throwable)ex2);
                return null;
            }
            catch (final IllegalAccessException ex3) {
                Log.e("IconCompat", "Unable to get icon package", (Throwable)ex3);
                return null;
            }
        }
        
        static int d(final Object o) {
            if (Build$VERSION.SDK_INT >= 28) {
                return c.c(o);
            }
            try {
                return (int)o.getClass().getMethod("getType", (Class<?>[])new Class[0]).invoke(o, new Object[0]);
            }
            catch (final NoSuchMethodException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(o);
                Log.e("IconCompat", sb.toString(), (Throwable)ex);
                return -1;
            }
            catch (final InvocationTargetException ex2) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to get icon type ");
                sb2.append(o);
                Log.e("IconCompat", sb2.toString(), (Throwable)ex2);
                return -1;
            }
            catch (final IllegalAccessException ex3) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to get icon type ");
                sb3.append(o);
                Log.e("IconCompat", sb3.toString(), (Throwable)ex3);
                return -1;
            }
        }
        
        static Uri e(final Object o) {
            if (Build$VERSION.SDK_INT >= 28) {
                return c.d(o);
            }
            try {
                return (Uri)o.getClass().getMethod("getUri", (Class<?>[])new Class[0]).invoke(o, new Object[0]);
            }
            catch (final NoSuchMethodException ex) {
                Log.e("IconCompat", "Unable to get icon uri", (Throwable)ex);
                return null;
            }
            catch (final InvocationTargetException ex2) {
                Log.e("IconCompat", "Unable to get icon uri", (Throwable)ex2);
                return null;
            }
            catch (final IllegalAccessException ex3) {
                Log.e("IconCompat", "Unable to get icon uri", (Throwable)ex3);
                return null;
            }
        }
        
        static Drawable f(final Icon icon, final Context context) {
            return icon.loadDrawable(context);
        }
        
        static Icon g(final IconCompat iconCompat, final Context context) {
            Icon icon = null;
            switch (iconCompat.a) {
                default: {
                    throw new IllegalArgumentException("Unknown type");
                }
                case 6: {
                    if (Build$VERSION.SDK_INT >= 30) {
                        icon = d.a(iconCompat.l());
                        break;
                    }
                    if (context == null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Context is required to resolve the file uri of the icon: ");
                        sb.append(iconCompat.l());
                        throw new IllegalArgumentException(sb.toString());
                    }
                    final InputStream m = iconCompat.m(context);
                    if (m != null) {
                        icon = b.b(BitmapFactory.decodeStream(m));
                        break;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot load adaptive icon from uri: ");
                    sb2.append(iconCompat.l());
                    throw new IllegalStateException(sb2.toString());
                }
                case 5: {
                    icon = b.b((Bitmap)iconCompat.b);
                    break;
                }
                case 4: {
                    icon = Icon.createWithContentUri((String)iconCompat.b);
                    break;
                }
                case 3: {
                    icon = Icon.createWithData((byte[])iconCompat.b, iconCompat.e, iconCompat.f);
                    break;
                }
                case 2: {
                    icon = Icon.createWithResource(iconCompat.j(), iconCompat.e);
                    break;
                }
                case 1: {
                    icon = Icon.createWithBitmap((Bitmap)iconCompat.b);
                    break;
                }
                case -1: {
                    return (Icon)iconCompat.b;
                }
            }
            final ColorStateList g = iconCompat.g;
            if (g != null) {
                icon.setTintList(g);
            }
            final PorterDuff$Mode h = iconCompat.h;
            if (h != IconCompat.k) {
                icon.setTintMode(h);
            }
            return icon;
        }
    }
    
    static class b
    {
        static Drawable a(final Drawable drawable, final Drawable drawable2) {
            return (Drawable)new AdaptiveIconDrawable(drawable, drawable2);
        }
        
        static Icon b(final Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }
    
    static class c
    {
        static int a(final Object o) {
            return ((Icon)o).getResId();
        }
        
        static String b(final Object o) {
            return ((Icon)o).getResPackage();
        }
        
        static int c(final Object o) {
            return ((Icon)o).getType();
        }
        
        static Uri d(final Object o) {
            return ((Icon)o).getUri();
        }
    }
    
    static class d
    {
        static Icon a(final Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }
}
