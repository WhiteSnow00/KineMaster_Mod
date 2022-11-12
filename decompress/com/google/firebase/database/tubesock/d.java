// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.tubesock;

import java.nio.channels.Channels;
import java.io.OutputStream;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;

class d
{
    private BlockingQueue<ByteBuffer> a;
    private final Random b;
    private volatile boolean c;
    private boolean d;
    private WebSocket e;
    private WritableByteChannel f;
    private final Thread g;
    
    d(final WebSocket e, final String s, final int n) {
        this.b = new Random();
        this.c = false;
        this.d = false;
        this.g = WebSocket.j().newThread(new Runnable(this) {
            final d a;
            
            @Override
            public void run() {
                com.google.firebase.database.tubesock.d.a(this.a);
            }
        });
        final ThreadInitializer i = WebSocket.i();
        final Thread d = this.d();
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("Writer-");
        sb.append(n);
        i.a(d, sb.toString());
        this.e = e;
        this.a = new LinkedBlockingQueue<ByteBuffer>();
    }
    
    static void a(final d d) {
        d.f();
    }
    
    private ByteBuffer b(final byte b, final boolean b2, final byte[] array) throws IOException {
        int n;
        if (b2) {
            n = 6;
        }
        else {
            n = 2;
        }
        final int length = array.length;
        final int n2 = 126;
        if (length >= 126) {
            if (length <= 65535) {
                n += 2;
            }
            else {
                n += 8;
            }
        }
        final ByteBuffer allocate = ByteBuffer.allocate(array.length + n);
        allocate.put((byte)(b | 0xFFFFFF80));
        final int n3 = 0;
        if (length < 126) {
            int n4 = length;
            if (b2) {
                n4 = (length | 0x80);
            }
            allocate.put((byte)n4);
        }
        else if (length <= 65535) {
            int n5 = n2;
            if (b2) {
                n5 = 254;
            }
            allocate.put((byte)n5);
            allocate.putShort((short)length);
        }
        else {
            int n6 = 127;
            if (b2) {
                n6 = 255;
            }
            allocate.put((byte)n6);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (b2) {
            final byte[] c = this.c();
            allocate.put(c);
            for (int i = n3; i < array.length; ++i) {
                allocate.put((byte)(array[i] ^ c[i % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }
    
    private byte[] c() {
        final byte[] array = new byte[4];
        this.b.nextBytes(array);
        return array;
    }
    
    private void e(final WebSocketException ex) {
        this.e.k(ex);
    }
    
    private void f() {
        try {
            while (!this.c && !Thread.interrupted()) {
                this.j();
            }
            for (int i = 0; i < this.a.size(); ++i) {
                this.j();
            }
            goto Label_0060;
        }
        catch (final IOException ex) {
            this.e(new WebSocketException("IO Exception", ex));
        }
        catch (final InterruptedException ex2) {
            goto Label_0060;
        }
    }
    
    private void j() throws InterruptedException, IOException {
        this.f.write(this.a.take());
    }
    
    Thread d() {
        return this.g;
    }
    
    void g(final byte b, final boolean b2, final byte[] array) throws IOException {
        synchronized (this) {
            final ByteBuffer b3 = this.b(b, b2, array);
            if (this.c && (this.d || b != 8)) {
                throw new WebSocketException("Shouldn't be sending");
            }
            if (b == 8) {
                this.d = true;
            }
            this.a.add(b3);
        }
    }
    
    void h(final OutputStream outputStream) {
        this.f = Channels.newChannel(outputStream);
    }
    
    void i() {
        this.c = true;
    }
}
