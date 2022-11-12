// 
// Decompiled by Procyon v0.6.0
// 

package b2;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.nio.BufferUnderflowException;
import android.util.Log;
import java.nio.ByteBuffer;

public class d
{
    private final byte[] a;
    private ByteBuffer b;
    private c c;
    private int d;
    
    public d() {
        this.a = new byte[256];
        this.d = 0;
    }
    
    private boolean b() {
        return this.c.b != 0;
    }
    
    private int e() {
        int n;
        try {
            n = (this.b.get() & 0xFF);
        }
        catch (final Exception ex) {
            this.c.b = 1;
            n = 0;
        }
        return n;
    }
    
    private void f() {
        this.c.d.a = this.o();
        this.c.d.b = this.o();
        this.c.d.c = this.o();
        this.c.d.d = this.o();
        final int e = this.e();
        boolean e2 = false;
        final boolean b = (e & 0x80) != 0x0;
        final int n = (int)Math.pow(2.0, (e & 0x7) + 1);
        final b d = this.c.d;
        if ((e & 0x40) != 0x0) {
            e2 = true;
        }
        d.e = e2;
        if (b) {
            d.k = this.h(n);
        }
        else {
            d.k = null;
        }
        this.c.d.j = this.b.position();
        this.t();
        if (this.b()) {
            return;
        }
        final c c = this.c;
        ++c.c;
        c.e.add(c.d);
    }
    
    private void g() {
        final int e = this.e();
        this.d = e;
        if (e > 0) {
            int n = 0;
            int n2 = 0;
            try {
                while (true) {
                    final int d = this.d;
                    if (n >= d) {
                        break;
                    }
                    final int n3 = n2 = d - n;
                    this.b.get(this.a, n, n3);
                    n += n3;
                    n2 = n3;
                }
            }
            catch (final Exception ex) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Error Reading Block n: ");
                    sb.append(n);
                    sb.append(" count: ");
                    sb.append(n2);
                    sb.append(" blockSize: ");
                    sb.append(this.d);
                    Log.d("GifHeaderParser", sb.toString(), (Throwable)ex);
                }
                this.c.b = 1;
            }
        }
    }
    
    private int[] h(final int n) {
        final byte[] array = new byte[n * 3];
        int[] array2 = null;
        try {
            this.b.get(array);
            array2 = array2;
            final int[] array3 = new int[256];
            int n2 = 0;
            int n3 = 0;
            while (true) {
                array2 = array3;
                if (n2 >= n) {
                    break;
                }
                final int n4 = n3 + 1;
                final byte b = array[n3];
                n3 = n4 + 1;
                array3[n2] = ((b & 0xFF) << 16 | 0xFF000000 | (array[n4] & 0xFF) << 8 | (array[n3] & 0xFF));
                ++n3;
                ++n2;
            }
        }
        catch (final BufferUnderflowException ex) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", (Throwable)ex);
            }
            this.c.b = 1;
        }
        return array2;
    }
    
    private void i() {
        this.j(Integer.MAX_VALUE);
    }
    
    private void j(final int n) {
        int n2 = 0;
        while (n2 == 0 && !this.b() && this.c.c <= n) {
            final int e = this.e();
            if (e != 33) {
                if (e != 44) {
                    if (e != 59) {
                        this.c.b = 1;
                    }
                    else {
                        n2 = 1;
                    }
                }
                else {
                    final c c = this.c;
                    if (c.d == null) {
                        c.d = new b();
                    }
                    this.f();
                }
            }
            else {
                final int e2 = this.e();
                if (e2 != 1) {
                    if (e2 != 249) {
                        if (e2 != 254) {
                            if (e2 != 255) {
                                this.s();
                            }
                            else {
                                this.g();
                                final StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < 11; ++i) {
                                    sb.append((char)this.a[i]);
                                }
                                if (sb.toString().equals("NETSCAPE2.0")) {
                                    this.n();
                                }
                                else {
                                    this.s();
                                }
                            }
                        }
                        else {
                            this.s();
                        }
                    }
                    else {
                        this.c.d = new b();
                        this.k();
                    }
                }
                else {
                    this.s();
                }
            }
        }
    }
    
    private void k() {
        this.e();
        final int e = this.e();
        final b d = this.c.d;
        final int g = (e & 0x1C) >> 2;
        d.g = g;
        boolean f = true;
        if (g == 0) {
            d.g = 1;
        }
        if ((e & 0x1) == 0x0) {
            f = false;
        }
        d.f = f;
        int o;
        if ((o = this.o()) < 2) {
            o = 10;
        }
        final b d2 = this.c.d;
        d2.i = o * 10;
        d2.h = this.e();
        this.e();
    }
    
    private void l() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            sb.append((char)this.e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        this.m();
        if (this.c.h && !this.b()) {
            final c c = this.c;
            c.a = this.h(c.i);
            final c c2 = this.c;
            c2.l = c2.a[c2.j];
        }
    }
    
    private void m() {
        this.c.f = this.o();
        this.c.g = this.o();
        final int e = this.e();
        final c c = this.c;
        c.h = ((e & 0x80) != 0x0);
        c.i = (int)Math.pow(2.0, (e & 0x7) + 1);
        this.c.j = this.e();
        this.c.k = this.e();
    }
    
    private void n() {
        do {
            this.g();
            final byte[] a = this.a;
            if (a[0] == 1) {
                this.c.m = ((a[2] & 0xFF) << 8 | (a[1] & 0xFF));
            }
        } while (this.d > 0 && !this.b());
    }
    
    private int o() {
        return this.b.getShort();
    }
    
    private void p() {
        this.b = null;
        Arrays.fill(this.a, (byte)0);
        this.c = new c();
        this.d = 0;
    }
    
    private void s() {
        int i;
        do {
            i = this.e();
            this.b.position(Math.min(this.b.position() + i, this.b.limit()));
        } while (i > 0);
    }
    
    private void t() {
        this.e();
        this.s();
    }
    
    public void a() {
        this.b = null;
        this.c = null;
    }
    
    public boolean c() {
        this.l();
        if (!this.b()) {
            this.j(2);
        }
        final int c = this.c.c;
        boolean b = true;
        if (c <= 1) {
            b = false;
        }
        return b;
    }
    
    public c d() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (this.b()) {
            return this.c;
        }
        this.l();
        if (!this.b()) {
            this.i();
            final c c = this.c;
            if (c.c < 0) {
                c.b = 1;
            }
        }
        return this.c;
    }
    
    public d q(ByteBuffer readOnlyBuffer) {
        this.p();
        readOnlyBuffer = readOnlyBuffer.asReadOnlyBuffer();
        (this.b = readOnlyBuffer).position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
    
    public d r(final byte[] array) {
        if (array != null) {
            this.q(ByteBuffer.wrap(array));
        }
        else {
            this.b = null;
            this.c.b = 2;
        }
        return this;
    }
}
