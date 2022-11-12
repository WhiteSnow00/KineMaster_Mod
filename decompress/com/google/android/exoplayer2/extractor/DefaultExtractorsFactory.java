// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.HashMap;
import com.google.android.exoplayer2.util.FileTypes;
import java.util.ArrayList;
import java.util.Map;
import android.net.Uri;
import java.lang.reflect.InvocationTargetException;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.extractor.jpeg.JpegExtractor;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import java.util.List;
import java.lang.reflect.Constructor;
import k3.a;
import k3.b;

public final class DefaultExtractorsFactory implements ExtractorsFactory
{
    private static final int[] n;
    private static final ExtensionLoader o;
    private static final ExtensionLoader p;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    
    static {
        n = new int[] { 5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14 };
        o = new ExtensionLoader((ExtensionLoader.ConstructorSupplier)b.a);
        p = new ExtensionLoader((ExtensionLoader.ConstructorSupplier)k3.a.a);
    }
    
    public DefaultExtractorsFactory() {
        this.k = 1;
        this.m = 112800;
    }
    
    public static Constructor e() {
        return i();
    }
    
    public static Constructor f() {
        return h();
    }
    
    private void g(int n, final List<Extractor> list) {
        int n2 = 2;
        switch (n) {
            case 16: {
                list.add(new AviExtractor());
                break;
            }
            case 15: {
                final Extractor a = DefaultExtractorsFactory.p.a(new Object[0]);
                if (a != null) {
                    list.add(a);
                    break;
                }
                break;
            }
            case 14: {
                list.add(new JpegExtractor());
                break;
            }
            case 12: {
                list.add(new WavExtractor());
                break;
            }
            case 11: {
                list.add(new TsExtractor(this.k, this.l, this.m));
                break;
            }
            case 10: {
                list.add(new PsExtractor());
                break;
            }
            case 9: {
                list.add(new OggExtractor());
                break;
            }
            case 8: {
                list.add(new FragmentedMp4Extractor(this.i));
                list.add(new Mp4Extractor(this.h));
                break;
            }
            case 7: {
                n = this.j;
                final boolean b = this.b;
                if (!this.c) {
                    n2 = 0;
                }
                list.add(new Mp3Extractor(n2 | (n | (b ? 1 : 0))));
                break;
            }
            case 6: {
                list.add(new MatroskaExtractor(this.g));
                break;
            }
            case 5: {
                list.add(new FlvExtractor());
                break;
            }
            case 4: {
                final Extractor a2 = DefaultExtractorsFactory.o.a(this.f);
                if (a2 != null) {
                    list.add(a2);
                    break;
                }
                list.add(new FlacExtractor(this.f));
                break;
            }
            case 3: {
                n = this.e;
                final boolean b2 = this.b;
                if (!this.c) {
                    n2 = 0;
                }
                list.add(new AmrExtractor(n2 | (n | (b2 ? 1 : 0))));
                break;
            }
            case 2: {
                n = this.d;
                final boolean b3 = this.b;
                if (!this.c) {
                    n2 = 0;
                }
                list.add(new AdtsExtractor(n2 | (n | (b3 ? 1 : 0))));
                break;
            }
            case 1: {
                list.add(new Ac4Extractor());
                break;
            }
            case 0: {
                list.add(new Ac3Extractor());
                break;
            }
        }
    }
    
    private static Constructor<? extends Extractor> h() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", (Class<?>[])new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
        }
        return null;
    }
    
    private static Constructor<? extends Extractor> i() throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor((Class<?>[])new Class[0]);
    }
    
    @Override
    public Extractor[] b(final Uri uri, final Map<String, List<String>> map) {
        synchronized (this) {
            final int[] n = DefaultExtractorsFactory.n;
            final ArrayList list = new ArrayList<Extractor>(n.length);
            final int b = FileTypes.b(map);
            if (b != -1) {
                this.g(b, (List<Extractor>)list);
            }
            final int c = FileTypes.c(uri);
            if (c != -1 && c != b) {
                this.g(c, (List<Extractor>)list);
            }
            for (final int n2 : n) {
                if (n2 != b && n2 != c) {
                    this.g(n2, (List<Extractor>)list);
                }
            }
            return list.toArray(new Extractor[list.size()]);
        }
    }
    
    @Override
    public Extractor[] c() {
        synchronized (this) {
            return this.b(Uri.EMPTY, new HashMap<String, List<String>>());
        }
    }
    
    private static final class ExtensionLoader
    {
        private final ConstructorSupplier a;
        private final AtomicBoolean b;
        private Constructor<? extends Extractor> c;
        
        public ExtensionLoader(final ConstructorSupplier a) {
            this.a = a;
            this.b = new AtomicBoolean(false);
        }
        
        private Constructor<? extends Extractor> b() {
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.c;
                }
                try {
                    return this.a.a();
                }
                catch (final Exception ex) {
                    throw new RuntimeException("Error instantiating extension", ex);
                }
                catch (final ClassNotFoundException ex2) {
                    this.b.set(true);
                    return this.c;
                }
            }
        }
        
        public Extractor a(final Object... array) {
            final Constructor<? extends Extractor> b = this.b();
            if (b == null) {
                return null;
            }
            try {
                return (Extractor)b.newInstance(array);
            }
            catch (final Exception ex) {
                throw new IllegalStateException("Unexpected error creating extractor", ex);
            }
        }
        
        public interface ConstructorSupplier
        {
            Constructor<? extends Extractor> a() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException;
        }
    }
}
