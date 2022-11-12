// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.tubesock;

import java.net.SocketTimeoutException;
import java.io.IOException;
import java.io.DataInputStream;

class c
{
    private DataInputStream a;
    private WebSocket b;
    private WebSocketEventHandler c;
    private byte[] d;
    private a.b e;
    private volatile boolean f;
    
    c(final WebSocket b) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = new byte[112];
        this.f = false;
        this.b = b;
    }
    
    private void a(final boolean b, final byte b2, final byte[] array) {
        if (b2 == 9) {
            if (!b) {
                throw new WebSocketException("PING must not fragment across frames");
            }
            this.c(array);
        }
        else {
            final a.b e = this.e;
            if (e != null && b2 != 0) {
                throw new WebSocketException("Failed to continue outstanding frame");
            }
            if (e == null && b2 == 0) {
                throw new WebSocketException("Received continuing frame, but there's nothing to continue");
            }
            if (e == null) {
                this.e = com.google.firebase.database.tubesock.a.a(b2);
            }
            if (!this.e.a(array)) {
                throw new WebSocketException("Failed to decode frame");
            }
            if (b) {
                final WebSocketMessage b3 = this.e.b();
                this.e = null;
                if (b3 == null) {
                    throw new WebSocketException("Failed to decode whole message");
                }
                this.c.e(b3);
            }
        }
    }
    
    private void b(final WebSocketException ex) {
        this.h();
        this.b.k(ex);
    }
    
    private void c(final byte[] array) {
        if (array.length <= 125) {
            this.b.m(array);
            return;
        }
        throw new WebSocketException("PING frame too long");
    }
    
    private long d(final byte[] array, final int n) {
        return ((long)array[n + 0] << 56) + ((long)(array[n + 1] & 0xFF) << 48) + ((long)(array[n + 2] & 0xFF) << 40) + ((long)(array[n + 3] & 0xFF) << 32) + ((long)(array[n + 4] & 0xFF) << 24) + ((array[n + 5] & 0xFF) << 16) + ((array[n + 6] & 0xFF) << 8) + ((array[n + 7] & 0xFF) << 0);
    }
    
    private int e(final byte[] array, final int n, final int n2) throws IOException {
        this.a.readFully(array, n, n2);
        return n2;
    }
    
    void f() {
        this.c = this.b.g();
        while (!this.f) {
            try {
                final int n = this.e(this.d, 0, 1) + 0;
                final byte[] d = this.d;
                final boolean b = (d[0] & 0x80) != 0x0;
                if ((d[0] & 0x70) != 0x0) {
                    throw new WebSocketException("Invalid frame received");
                }
                final byte b2 = (byte)(d[0] & 0xF);
                final int n2 = n + this.e(d, n, 1);
                final byte[] d2 = this.d;
                final byte b3 = d2[1];
                long d3 = 0L;
                if (b3 < 126) {
                    d3 = b3;
                }
                else if (b3 == 126) {
                    this.e(d2, n2, 2);
                    final byte[] d4 = this.d;
                    d3 = ((long)(d4[2] & 0xFF) << 8 | (long)(d4[3] & 0xFF));
                }
                else if (b3 == 127) {
                    d3 = this.d(this.d, n2 + this.e(d2, n2, 8) - 8);
                }
                final int n3 = (int)d3;
                final byte[] array = new byte[n3];
                this.e(array, 0, n3);
                if (b2 == 8) {
                    this.b.l();
                }
                else {
                    if (b2 == 10) {
                        continue;
                    }
                    if (b2 != 1 && b2 != 2 && b2 != 9 && b2 != 0) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported opcode: ");
                        sb.append(b2);
                        throw new WebSocketException(sb.toString());
                    }
                    this.a(b, b2, array);
                }
            }
            catch (final WebSocketException ex) {
                this.b(ex);
            }
            catch (final IOException ex2) {
                this.b(new WebSocketException("IO Error", ex2));
            }
            catch (final SocketTimeoutException ex3) {}
        }
        goto Label_0372;
    }
    
    void g(final DataInputStream a) {
        this.a = a;
    }
    
    void h() {
        this.f = true;
    }
}
