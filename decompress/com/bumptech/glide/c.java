// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.Set;
import android.content.ComponentCallbacks;
import java.util.Collections;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import android.content.ContentResolver;
import android.content.res.Resources;
import java.net.URL;
import h2.w;
import com.bumptech.glide.load.data.k;
import java.io.File;
import android.net.Uri;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.z;
import h2.v;
import android.content.res.AssetFileDescriptor;
import com.bumptech.glide.load.resource.bitmap.u;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import android.graphics.Bitmap;
import h2.t;
import java.nio.ByteBuffer;
import android.graphics.drawable.Drawable;
import java.io.InputStream;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import n2.a;
import com.bumptech.glide.load.resource.bitmap.o;
import android.os.Build$VERSION;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import java.util.ArrayList;
import com.bumptech.glide.request.g;
import java.util.Map;
import android.content.Context;
import java.util.List;
import p2.p;
import e2.b;
import f2.h;
import e2.d;
import com.bumptech.glide.load.engine.i;
import android.content.ComponentCallbacks2;

public class c implements ComponentCallbacks2
{
    private static volatile c w;
    private static volatile boolean x;
    private final i a;
    private final d b;
    private final h c;
    private final e d;
    private final Registry e;
    private final b f;
    private final p g;
    private final p2.d h;
    private final List<com.bumptech.glide.i> i;
    private final a j;
    private MemoryCategory p;
    
    c(final Context context, final i a, final h c, final d b, final b f, final p g, final p2.d h, final int n, final a j, final Map<Class<?>, j<?, ?>> map, final List<g<Object>> list, final f f2) {
        this.i = new ArrayList<com.bumptech.glide.i>();
        this.p = MemoryCategory.NORMAL;
        this.a = a;
        this.b = b;
        this.f = f;
        this.c = c;
        this.g = g;
        this.h = h;
        this.j = j;
        final Resources resources = context.getResources();
        final Registry e = new Registry();
        (this.e = e).o(new DefaultImageHeaderParser());
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 27) {
            e.o(new o());
        }
        final List<ImageHeaderParser> g2 = e.g();
        final n2.a a2 = new n2.a(context, g2, b, f);
        final c2.f<ParcelFileDescriptor, Bitmap> h2 = VideoDecoder.h(b);
        final l l = new l(e.g(), resources.getDisplayMetrics(), b, f);
        c2.f<InputStream, Bitmap> f3;
        c2.f<ByteBuffer, Bitmap> f4;
        if (sdk_INT >= 28 && f2.a((Class<Object>)com.bumptech.glide.d.c.class)) {
            f3 = new s();
            f4 = new com.bumptech.glide.load.resource.bitmap.h();
        }
        else {
            f4 = new com.bumptech.glide.load.resource.bitmap.g(l);
            f3 = new x(l, f);
        }
        if (sdk_INT >= 28 && f2.a((Class<Object>)com.bumptech.glide.d.b.class)) {
            e.e("Animation", InputStream.class, Drawable.class, l2.a.f(g2, f));
            e.e("Animation", ByteBuffer.class, Drawable.class, l2.a.a(g2, f));
        }
        final l2.f f5 = new l2.f(context);
        final h2.s.c c2 = new h2.s.c(resources);
        final h2.s.d d = new h2.s.d(resources);
        final h2.s.b b2 = new h2.s.b(resources);
        final h2.s.a a3 = new h2.s.a(resources);
        final com.bumptech.glide.load.resource.bitmap.c c3 = new com.bumptech.glide.load.resource.bitmap.c(f);
        final o2.a a4 = new o2.a();
        final o2.d d2 = new o2.d();
        final ContentResolver contentResolver = context.getContentResolver();
        e.a(ByteBuffer.class, new h2.c()).a(InputStream.class, new t(f)).e("Bitmap", ByteBuffer.class, Bitmap.class, f4).e("Bitmap", InputStream.class, Bitmap.class, f3);
        if (ParcelFileDescriptorRewinder.c()) {
            e.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new u(l));
        }
        e.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, h2).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(b)).d(Bitmap.class, Bitmap.class, (h2.o<Bitmap, Bitmap>)v.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new z()).b(Bitmap.class, c3).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a<ByteBuffer>(resources, f4)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a<InputStream>(resources, f3)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a<ParcelFileDescriptor>(resources, h2)).b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(b, c3)).e("Animation", InputStream.class, n2.c.class, new n2.j(g2, a2, f)).e("Animation", ByteBuffer.class, n2.c.class, a2).b(n2.c.class, new n2.d()).d(b2.a.class, b2.a.class, (h2.o<b2.a, b2.a>)v.a.a()).e("Bitmap", b2.a.class, Bitmap.class, new n2.h(b)).c(Uri.class, Drawable.class, f5).c(Uri.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.v(f5, b)).p(new k2.a.a()).d(File.class, ByteBuffer.class, new h2.d.b()).d(File.class, InputStream.class, new h2.f.e()).c(File.class, File.class, new m2.a()).d(File.class, ParcelFileDescriptor.class, new h2.f.b()).d(File.class, File.class, (h2.o<File, File>)v.a.a()).p(new k.a(f));
        if (ParcelFileDescriptorRewinder.c()) {
            e.p(new ParcelFileDescriptorRewinder.a());
        }
        final Class<Integer> type = Integer.TYPE;
        e.d((Class<Object>)type, InputStream.class, (h2.o<Object, InputStream>)c2).d((Class<Object>)type, ParcelFileDescriptor.class, (h2.o<Object, ParcelFileDescriptor>)b2).d(Integer.class, InputStream.class, c2).d(Integer.class, ParcelFileDescriptor.class, b2).d(Integer.class, Uri.class, d).d((Class<Object>)type, AssetFileDescriptor.class, (h2.o<Object, AssetFileDescriptor>)a3).d(Integer.class, AssetFileDescriptor.class, a3).d((Class<Object>)type, Uri.class, (h2.o<Object, Uri>)d).d(String.class, InputStream.class, new h2.e.c<String>()).d(Uri.class, InputStream.class, new h2.e.c<Uri>()).d(String.class, InputStream.class, new h2.u.c()).d(String.class, ParcelFileDescriptor.class, new h2.u.b()).d(String.class, AssetFileDescriptor.class, new h2.u.a()).d(Uri.class, InputStream.class, new h2.a.c(context.getAssets())).d(Uri.class, AssetFileDescriptor.class, new h2.a.b(context.getAssets())).d(Uri.class, InputStream.class, new i2.b.a(context)).d(Uri.class, InputStream.class, new i2.c.a(context));
        if (sdk_INT >= 29) {
            e.d(Uri.class, InputStream.class, new i2.d.c(context));
            e.d(Uri.class, ParcelFileDescriptor.class, new i2.d.b(context));
        }
        e.d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new h2.x.a()).d(URL.class, InputStream.class, new i2.e.a()).d(Uri.class, File.class, new h2.k.a(context)).d(h2.g.class, InputStream.class, new i2.a.a()).d(byte[].class, ByteBuffer.class, new h2.b.a()).d(byte[].class, InputStream.class, new h2.b.d()).d(Uri.class, Uri.class, (h2.o<Uri, Uri>)v.a.a()).d(Drawable.class, Drawable.class, (h2.o<Drawable, Drawable>)v.a.a()).c(Drawable.class, Drawable.class, new l2.g()).q(Bitmap.class, BitmapDrawable.class, new o2.b(resources)).q(Bitmap.class, byte[].class, a4).q(Drawable.class, byte[].class, new o2.c(b, a4, d2)).q(n2.c.class, byte[].class, d2);
        final c2.f<ByteBuffer, Bitmap> d3 = VideoDecoder.d(b);
        e.c(ByteBuffer.class, Bitmap.class, d3);
        e.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a<ByteBuffer>(resources, (c2.f<Object, Bitmap>)d3));
        this.d = new e(context, f, e, new s2.g(), j, map, list, a, f2, n);
    }
    
    private static void a(final Context context, final GeneratedAppGlideModule generatedAppGlideModule) {
        if (!c.x) {
            c.x = true;
            m(context, generatedAppGlideModule);
            c.x = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }
    
    public static c c(final Context context) {
        if (c.w == null) {
            final GeneratedAppGlideModule d = d(context.getApplicationContext());
            synchronized (c.class) {
                if (c.w == null) {
                    a(context, d);
                }
            }
        }
        return c.w;
    }
    
    private static GeneratedAppGlideModule d(final Context context) {
        try {
            return GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        }
        catch (final InvocationTargetException ex) {
            q(ex);
        }
        catch (final NoSuchMethodException ex2) {
            q(ex2);
        }
        catch (final IllegalAccessException ex3) {
            q(ex3);
        }
        catch (final InstantiationException ex4) {
            q(ex4);
        }
        catch (final ClassNotFoundException ex5) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        }
        return null;
    }
    
    private static p l(final Context context) {
        v2.k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }
    
    private static void m(final Context context, final GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new com.bumptech.glide.d(), generatedAppGlideModule);
    }
    
    private static void n(Context context, final com.bumptech.glide.d d, final GeneratedAppGlideModule generatedAppGlideModule) {
        final Context applicationContext = context.getApplicationContext();
        Object o = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            o = new q2.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            final Set<Class<?>> d2 = generatedAppGlideModule.d();
            final Iterator iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                final q2.b b = (q2.b)iterator.next();
                if (!d2.contains(b.getClass())) {
                    continue;
                }
                if (Log.isLoggable("Glide", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("AppGlideModule excludes manifest GlideModule: ");
                    sb.append(b);
                    Log.d("Glide", sb.toString());
                }
                iterator.remove();
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (final q2.b b2 : o) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Discovered GlideModule from manifest: ");
                sb2.append(b2.getClass());
                Log.d("Glide", sb2.toString());
            }
        }
        p.b e;
        if (generatedAppGlideModule != null) {
            e = generatedAppGlideModule.e();
        }
        else {
            e = null;
        }
        d.b(e);
        final Iterator iterator3 = ((List)o).iterator();
        while (iterator3.hasNext()) {
            ((q2.b)iterator3.next()).a(applicationContext, d);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, d);
        }
        final c a = d.a(applicationContext);
        final Iterator iterator4 = ((List)o).iterator();
        while (iterator4.hasNext()) {
            context = (Context)iterator4.next();
            try {
                ((q2.b)context).b(applicationContext, a, a.e);
                continue;
            }
            catch (final AbstractMethodError abstractMethodError) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                sb3.append(context.getClass().getName());
                throw new IllegalStateException(sb3.toString(), abstractMethodError);
            }
            break;
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a, a.e);
        }
        applicationContext.registerComponentCallbacks((ComponentCallbacks)a);
        c.w = a;
    }
    
    private static void q(final Exception ex) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", ex);
    }
    
    public static com.bumptech.glide.i t(final Context context) {
        return l(context).f(context);
    }
    
    public static com.bumptech.glide.i u(final Fragment fragment) {
        return l(fragment.getContext()).g(fragment);
    }
    
    public void b() {
        v2.l.b();
        this.c.b();
        this.b.b();
        this.f.b();
    }
    
    public b e() {
        return this.f;
    }
    
    public d f() {
        return this.b;
    }
    
    p2.d g() {
        return this.h;
    }
    
    public Context h() {
        return this.d.getBaseContext();
    }
    
    e i() {
        return this.d;
    }
    
    public Registry j() {
        return this.e;
    }
    
    public p k() {
        return this.g;
    }
    
    void o(final com.bumptech.glide.i i) {
        synchronized (this.i) {
            if (!this.i.contains(i)) {
                this.i.add(i);
                return;
            }
            throw new IllegalStateException("Cannot register already registered manager");
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
    }
    
    public void onLowMemory() {
        this.b();
    }
    
    public void onTrimMemory(final int n) {
        this.r(n);
    }
    
    boolean p(final s2.i<?> i) {
        synchronized (this.i) {
            final Iterator<com.bumptech.glide.i> iterator = this.i.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().x(i)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public void r(final int n) {
        v2.l.b();
        synchronized (this.i) {
            final Iterator<com.bumptech.glide.i> iterator = this.i.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTrimMemory(n);
            }
            monitorexit(this.i);
            this.c.a(n);
            this.b.a(n);
            this.f.a(n);
        }
    }
    
    void s(final com.bumptech.glide.i i) {
        synchronized (this.i) {
            if (this.i.contains(i)) {
                this.i.remove(i);
                return;
            }
            throw new IllegalStateException("Cannot unregister not yet registered manager");
        }
    }
    
    public interface a
    {
        com.bumptech.glide.request.h build();
    }
}
