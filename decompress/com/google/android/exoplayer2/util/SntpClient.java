// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.ConcurrentModificationException;
import java.util.Arrays;
import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;

public final class SntpClient
{
    private static final Object a;
    private static final Object b;
    private static boolean c = false;
    private static long d = 0L;
    private static String e = "time.android.com";
    
    static {
        a = new Object();
        b = new Object();
    }
    
    private SntpClient() {
    }
    
    static Object a() {
        return SntpClient.a;
    }
    
    static Object b() {
        return SntpClient.b;
    }
    
    static boolean c() {
        return SntpClient.c;
    }
    
    static boolean d(final boolean c) {
        return SntpClient.c = c;
    }
    
    static long e() throws IOException {
        return l();
    }
    
    static long f(final long d) {
        return SntpClient.d = d;
    }
    
    private static void g(final byte b, final byte b2, final int n, final long n2) throws IOException {
        if (b == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b2 != 4 && b2 != 5) {
            final StringBuilder sb = new StringBuilder();
            sb.append("SNTP: Untrusted mode: ");
            sb.append(b2);
            throw new IOException(sb.toString());
        }
        if (n == 0 || n > 15) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("SNTP: Untrusted stratum: ");
            sb2.append(n);
            throw new IOException(sb2.toString());
        }
        if (n2 != 0L) {
            return;
        }
        throw new IOException("SNTP: Zero transmitTime");
    }
    
    public static long h() {
        synchronized (SntpClient.b) {
            long d;
            if (SntpClient.c) {
                d = SntpClient.d;
            }
            else {
                d = -9223372036854775807L;
            }
            return d;
        }
    }
    
    public static String i() {
        synchronized (SntpClient.b) {
            return SntpClient.e;
        }
    }
    
    public static void j(final Loader loader, final InitializationCallback initializationCallback) {
        if (k()) {
            if (initializationCallback != null) {
                initializationCallback.b();
            }
            return;
        }
        Loader loader2;
        if ((loader2 = loader) == null) {
            loader2 = new Loader("SntpClient");
        }
        loader2.n((Loader.Loadable)new c(null), (Loader.Callback<Loader.Loadable>)new b(initializationCallback), 1);
    }
    
    public static boolean k() {
        synchronized (SntpClient.b) {
            return SntpClient.c;
        }
    }
    
    private static long l() throws IOException {
        final InetAddress byName = InetAddress.getByName(i());
        final DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            final byte[] array = new byte[48];
            final DatagramPacket datagramPacket = new DatagramPacket(array, 48, byName, 123);
            array[0] = 27;
            final long currentTimeMillis = System.currentTimeMillis();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            o(array, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(array, 48));
            final long elapsedRealtime2 = SystemClock.elapsedRealtime();
            final long n = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            final byte b = (byte)(array[0] >> 6 & 0x3);
            final byte b2 = (byte)(array[0] & 0x7);
            final byte b3 = array[1];
            final long n2 = n(array, 24);
            final long n3 = n(array, 32);
            final long n4 = n(array, 40);
            g(b, b2, b3 & 0xFF, n4);
            final long n5 = (n3 - n2 + (n4 - n)) / 2L;
            datagramSocket.close();
            return n + n5 - elapsedRealtime2;
        }
        finally {
            try {
                datagramSocket.close();
            }
            finally {
                final Throwable t;
                final Throwable t2;
                t.addSuppressed(t2);
            }
        }
    }
    
    private static long m(final byte[] array, int n) {
        final int n2 = array[n];
        final byte b = array[n + 1];
        final byte b2 = array[n + 2];
        final byte b3 = array[n + 3];
        n = n2;
        if ((n2 & 0x80) == 0x80) {
            n = (n2 & 0x7F) + 128;
        }
        int n3 = b;
        if ((b & 0x80) == 0x80) {
            n3 = (b & 0x7F) + 128;
        }
        int n4 = b2;
        if ((b2 & 0x80) == 0x80) {
            n4 = (b2 & 0x7F) + 128;
        }
        int n5 = b3;
        if ((b3 & 0x80) == 0x80) {
            n5 = (b3 & 0x7F) + 128;
        }
        return ((long)n << 24) + ((long)n3 << 16) + ((long)n4 << 8) + n5;
    }
    
    private static long n(final byte[] array, final int n) {
        final long m = m(array, n);
        final long i = m(array, n + 4);
        if (m == 0L && i == 0L) {
            return 0L;
        }
        return (m - 2208988800L) * 1000L + i * 1000L / 4294967296L;
    }
    
    private static void o(final byte[] array, int n, long n2) {
        if (n2 == 0L) {
            Arrays.fill(array, n, n + 8, (byte)0);
            return;
        }
        final long n3 = n2 / 1000L;
        final long n4 = n3 + 2208988800L;
        final int n5 = n + 1;
        array[n] = (byte)(n4 >> 24);
        n = n5 + 1;
        array[n5] = (byte)(n4 >> 16);
        final int n6 = n + 1;
        array[n] = (byte)(n4 >> 8);
        n = n6 + 1;
        array[n6] = (byte)(n4 >> 0);
        n2 = (n2 - n3 * 1000L) * 4294967296L / 1000L;
        final int n7 = n + 1;
        array[n] = (byte)(n2 >> 24);
        n = n7 + 1;
        array[n7] = (byte)(n2 >> 16);
        array[n] = (byte)(n2 >> 8);
        array[n + 1] = (byte)(Math.random() * 255.0);
    }
    
    public interface InitializationCallback
    {
        void a(final IOException p0);
        
        void b();
    }
    
    private static final class b implements Callback<Loadable>
    {
        private final InitializationCallback a;
        
        public b(final InitializationCallback a) {
            this.a = a;
        }
        
        @Override
        public void A(final Loadable loadable, final long n, final long n2) {
            if (this.a != null) {
                if (!SntpClient.k()) {
                    this.a.a(new IOException(new ConcurrentModificationException()));
                }
                else {
                    this.a.b();
                }
            }
        }
        
        @Override
        public LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
            final InitializationCallback a = this.a;
            if (a != null) {
                a.a(ex);
            }
            return Loader.f;
        }
        
        @Override
        public void v(final Loadable loadable, final long n, final long n2, final boolean b) {
        }
    }
    
    private static final class c implements Loadable
    {
        private c() {
        }
        
        c(final SntpClient$a object) {
            this();
        }
        
        @Override
        public void a() throws IOException {
            synchronized (SntpClient.a()) {
                synchronized (SntpClient.b()) {
                    if (SntpClient.c()) {
                        return;
                    }
                    monitorexit(SntpClient.b());
                    final long e = SntpClient.e();
                    SntpClient.b();
                    synchronized (SntpClient.b()) {
                        SntpClient.f(e);
                        SntpClient.d(true);
                    }
                }
            }
        }
        
        @Override
        public void c() {
        }
    }
}
