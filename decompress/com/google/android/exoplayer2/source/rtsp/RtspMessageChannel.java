// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import a4.a;
import java.util.Objects;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.OutputStream;
import java.io.InputStream;
import com.google.common.primitives.Ints;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import com.google.android.exoplayer2.ParserException;
import java.util.Collection;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import com.google.common.base.Charsets;
import java.net.Socket;
import java.util.Map;
import com.google.android.exoplayer2.upstream.Loader;
import java.nio.charset.Charset;
import java.io.Closeable;

final class RtspMessageChannel implements Closeable
{
    public static final Charset g;
    private final MessageListener a;
    private final Loader b;
    private final Map<Integer, InterleavedBinaryDataListener> c;
    private e d;
    private Socket e;
    private volatile boolean f;
    
    static {
        g = Charsets.c;
    }
    
    public RtspMessageChannel(final MessageListener a) {
        this.a = a;
        this.b = new Loader("ExoPlayer:RtspMessageChannel:ReceiverLoader");
        this.c = Collections.synchronizedMap(new HashMap<Integer, InterleavedBinaryDataListener>());
    }
    
    static boolean a(final RtspMessageChannel rtspMessageChannel) {
        return rtspMessageChannel.f;
    }
    
    static MessageListener c(final RtspMessageChannel rtspMessageChannel) {
        return rtspMessageChannel.a;
    }
    
    static Map d(final RtspMessageChannel rtspMessageChannel) {
        return rtspMessageChannel.c;
    }
    
    @Override
    public void close() throws IOException {
        if (this.f) {
            return;
        }
        try {
            try (final e d = this.d) {}
            this.b.l();
            try (final Socket e = this.e) {}
        }
        finally {
            this.f = true;
        }
    }
    
    public void e(final Socket e) throws IOException {
        this.e = e;
        this.d = new e(e.getOutputStream());
        this.b.n(new d(e.getInputStream()), (Loader.Callback<d>)new b(null), 0);
    }
    
    public void h(final int n, final InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.c.put(n, interleavedBinaryDataListener);
    }
    
    public void i(final List<String> list) {
        Assertions.i(this.d);
        this.d.d(list);
    }
    
    public interface InterleavedBinaryDataListener
    {
        void j(final byte[] p0);
    }
    
    public interface MessageListener
    {
        default void a(final Exception ex) {
        }
        
        default void b(final List<String> list, final Exception ex) {
        }
        
        void c(final List<String> p0);
    }
    
    private final class b implements Callback<d>
    {
        final RtspMessageChannel a;
        
        private b(final RtspMessageChannel a) {
            this.a = a;
        }
        
        b(final RtspMessageChannel rtspMessageChannel, final RtspMessageChannel$a object) {
            this(rtspMessageChannel);
        }
        
        @Override
        public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
            this.b((d)loadable, n, n2);
        }
        
        @Override
        public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
            return this.c((d)loadable, n, n2, ex, n3);
        }
        
        public void a(final d d, final long n, final long n2, final boolean b) {
        }
        
        public void b(final d d, final long n, final long n2) {
        }
        
        public LoadErrorAction c(final d d, final long n, final long n2, final IOException ex, final int n3) {
            if (!RtspMessageChannel.a(this.a)) {
                RtspMessageChannel.c(this.a).a(ex);
            }
            return Loader.f;
        }
        
        @Override
        public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
            this.a((d)loadable, n, n2, b);
        }
    }
    
    private static final class c
    {
        private final List<String> a;
        private int b;
        private long c;
        
        public c() {
            this.a = new ArrayList<String>();
            this.b = 1;
        }
        
        private ImmutableList<String> a(final byte[] array) {
            Assertions.g(this.b == 3);
            if (array.length > 0 && array[array.length - 1] == 10) {
                String s;
                if (array.length > 1 && array[array.length - 2] == 13) {
                    s = new String(array, 0, array.length - 2, RtspMessageChannel.g);
                }
                else {
                    s = new String(array, 0, array.length - 1, RtspMessageChannel.g);
                }
                this.a.add(s);
                final ImmutableList copy = ImmutableList.copyOf((Collection)this.a);
                this.e();
                return (ImmutableList<String>)copy;
            }
            throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
        }
        
        private ImmutableList<String> b(final byte[] array) throws ParserException {
            Assertions.a(array.length >= 2 && array[array.length - 2] == 13 && array[array.length - 1] == 10);
            final String s = new String(array, 0, array.length - 2, RtspMessageChannel.g);
            this.a.add(s);
            final int b = this.b;
            if (b != 1) {
                if (b != 2) {
                    throw new IllegalStateException();
                }
                final long g = RtspMessageUtil.g(s);
                if (g != -1L) {
                    this.c = g;
                }
                if (s.isEmpty()) {
                    if (this.c <= 0L) {
                        final ImmutableList copy = ImmutableList.copyOf((Collection)this.a);
                        this.e();
                        return (ImmutableList<String>)copy;
                    }
                    this.b = 3;
                }
            }
            else if (RtspMessageUtil.f(s)) {
                this.b = 2;
            }
            return null;
        }
        
        private static byte[] d(final byte b, final DataInputStream dataInputStream) throws IOException {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final byte[] array = { b, dataInputStream.readByte() };
            byteArrayOutputStream.write(array);
            while (array[0] != 13 || array[1] != 10) {
                array[0] = array[1];
                byteArrayOutputStream.write(array[1] = dataInputStream.readByte());
            }
            return byteArrayOutputStream.toByteArray();
        }
        
        private void e() {
            this.a.clear();
            this.b = 1;
            this.c = 0L;
        }
        
        public ImmutableList<String> c(final byte b, final DataInputStream dataInputStream) throws IOException {
            ImmutableList<String> list = this.b(d(b, dataInputStream));
            while (list == null) {
                if (this.b == 3) {
                    final long c = this.c;
                    if (c <= 0L) {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                    final int d = Ints.d(c);
                    Assertions.g(d != -1);
                    final byte[] array = new byte[d];
                    dataInputStream.readFully(array, 0, d);
                    list = this.a(array);
                }
                else {
                    list = this.b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return list;
        }
    }
    
    private final class d implements Loadable
    {
        private final DataInputStream a;
        private final RtspMessageChannel.c b;
        private volatile boolean c;
        final RtspMessageChannel d;
        
        public d(final RtspMessageChannel d, final InputStream inputStream) {
            this.d = d;
            this.a = new DataInputStream(inputStream);
            this.b = new RtspMessageChannel.c();
        }
        
        private void b() throws IOException {
            final int unsignedByte = this.a.readUnsignedByte();
            final int unsignedShort = this.a.readUnsignedShort();
            final byte[] array = new byte[unsignedShort];
            this.a.readFully(array, 0, unsignedShort);
            final InterleavedBinaryDataListener interleavedBinaryDataListener = RtspMessageChannel.d(this.d).get(unsignedByte);
            if (interleavedBinaryDataListener != null && !RtspMessageChannel.a(this.d)) {
                interleavedBinaryDataListener.j(array);
            }
        }
        
        private void d(final byte b) throws IOException {
            if (!RtspMessageChannel.a(this.d)) {
                RtspMessageChannel.c(this.d).c((List<String>)this.b.c(b, this.a));
            }
        }
        
        @Override
        public void a() throws IOException {
            while (!this.c) {
                final byte byte1 = this.a.readByte();
                if (byte1 == 36) {
                    this.b();
                }
                else {
                    this.d(byte1);
                }
            }
        }
        
        @Override
        public void c() {
            this.c = true;
        }
    }
    
    private final class e implements Closeable
    {
        private final OutputStream a;
        private final HandlerThread b;
        private final Handler c;
        final RtspMessageChannel d;
        
        public e(final RtspMessageChannel d, final OutputStream a) {
            this.d = d;
            this.a = a;
            final HandlerThread b = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            (this.b = b).start();
            this.c = new Handler(b.getLooper());
        }
        
        public static void a(final e e, final byte[] array, final List list) {
            e.c(array, list);
        }
        
        private void c(final byte[] array, final List list) {
            try {
                this.a.write(array);
            }
            catch (final Exception ex) {
                if (!RtspMessageChannel.a(this.d)) {
                    RtspMessageChannel.c(this.d).b(list, ex);
                }
            }
        }
        
        @Override
        public void close() {
            final Handler c = this.c;
            final HandlerThread b = this.b;
            Objects.requireNonNull(b);
            c.post((Runnable)new a(b));
            try {
                this.b.join();
            }
            catch (final InterruptedException ex) {
                this.b.interrupt();
            }
        }
        
        public void d(final List<String> list) {
            this.c.post((Runnable)new m(this, RtspMessageUtil.b(list), list));
        }
    }
}
