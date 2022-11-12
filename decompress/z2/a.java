// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.io.h;
import java.io.InputStreamReader;
import com.fasterxml.jackson.core.io.e;
import java.io.ByteArrayInputStream;
import java.io.Reader;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import b3.b;
import java.io.DataInput;
import java.io.CharConversionException;
import com.fasterxml.jackson.core.format.MatchStrength;
import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.io.c;

public final class a
{
    private final c a;
    private final InputStream b;
    private final byte[] c;
    private int d;
    private int e;
    private final boolean f;
    private boolean g;
    private int h;
    
    public a(final c a, final InputStream b) {
        this.g = true;
        this.a = a;
        this.b = b;
        this.c = a.e();
        this.d = 0;
        this.e = 0;
        this.f = true;
    }
    
    public a(final c a, final byte[] c, final int d, final int n) {
        this.g = true;
        this.a = a;
        this.b = null;
        this.c = c;
        this.d = d;
        this.e = d + n;
        this.f = false;
    }
    
    private boolean a(final int n) {
        if ((0xFF00 & n) == 0x0) {
            this.g = true;
        }
        else {
            if ((n & 0xFF) != 0x0) {
                return false;
            }
            this.g = false;
        }
        this.h = 2;
        return true;
    }
    
    private boolean b(final int n) throws IOException {
        if (n >> 8 == 0) {
            this.g = true;
        }
        else if ((0xFFFFFF & n) == 0x0) {
            this.g = false;
        }
        else if ((0xFF00FFFF & n) == 0x0) {
            this.i("3412");
        }
        else {
            if ((n & 0xFFFF00FF) != 0x0) {
                return false;
            }
            this.i("2143");
        }
        this.h = 4;
        return true;
    }
    
    private boolean g(final int n) throws IOException {
        if (n != -16842752) {
            if (n == -131072) {
                this.d += 4;
                this.h = 4;
                this.g = false;
                return true;
            }
            if (n == 65279) {
                this.g = true;
                this.d += 4;
                this.h = 4;
                return true;
            }
            if (n == 65534) {
                this.i("2143");
            }
        }
        else {
            this.i("3412");
        }
        final int n2 = n >>> 16;
        if (n2 == 65279) {
            this.d += 2;
            this.h = 2;
            return this.g = true;
        }
        if (n2 == 65534) {
            this.d += 2;
            this.h = 2;
            this.g = false;
            return true;
        }
        if (n >>> 8 == 15711167) {
            this.d += 3;
            this.h = 1;
            return this.g = true;
        }
        return false;
    }
    
    public static MatchStrength h(final y2.a a) throws IOException {
        if (!a.b()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte b;
        if ((b = a.a()) == -17) {
            if (!a.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (a.a() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!a.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (a.a() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!a.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            b = a.a();
        }
        final int k = k(a, b);
        if (k < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (k == 123) {
            final int j = j(a);
            if (j < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (j != 34 && j != 125) {
                return MatchStrength.NO_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        }
        else if (k == 91) {
            final int i = j(a);
            if (i < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (i != 93 && i != 91) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        }
        else {
            final MatchStrength weak_MATCH = MatchStrength.WEAK_MATCH;
            if (k == 34) {
                return weak_MATCH;
            }
            if (k <= 57 && k >= 48) {
                return weak_MATCH;
            }
            if (k == 45) {
                final int l = j(a);
                if (l < 0) {
                    return MatchStrength.INCONCLUSIVE;
                }
                MatchStrength no_MATCH;
                if (l <= 57 && l >= 48) {
                    no_MATCH = weak_MATCH;
                }
                else {
                    no_MATCH = MatchStrength.NO_MATCH;
                }
                return no_MATCH;
            }
            else {
                if (k == 110) {
                    return m(a, "ull", weak_MATCH);
                }
                if (k == 116) {
                    return m(a, "rue", weak_MATCH);
                }
                if (k == 102) {
                    return m(a, "alse", weak_MATCH);
                }
                return MatchStrength.NO_MATCH;
            }
        }
    }
    
    private void i(final String s) throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Unsupported UCS-4 endianness (");
        sb.append(s);
        sb.append(") detected");
        throw new CharConversionException(sb.toString());
    }
    
    private static int j(final y2.a a) throws IOException {
        if (!a.b()) {
            return -1;
        }
        return k(a, a.a());
    }
    
    private static int k(final y2.a a, byte a2) throws IOException {
        while (true) {
            final int n = a2 & 0xFF;
            if (n != 32 && n != 13 && n != 10 && n != 9) {
                return n;
            }
            if (!a.b()) {
                return -1;
            }
            a2 = a.a();
        }
    }
    
    public static int l(final DataInput dataInput) throws IOException {
        final int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte != 239) {
            return unsignedByte;
        }
        final int unsignedByte2 = dataInput.readUnsignedByte();
        if (unsignedByte2 != 187) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected byte 0x");
            sb.append(Integer.toHexString(unsignedByte2));
            sb.append(" following 0xEF; should get 0xBB as part of UTF-8 BOM");
            throw new IOException(sb.toString());
        }
        final int unsignedByte3 = dataInput.readUnsignedByte();
        if (unsignedByte3 == 191) {
            return dataInput.readUnsignedByte();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected byte 0x");
        sb2.append(Integer.toHexString(unsignedByte3));
        sb2.append(" following 0xEF 0xBB; should get 0xBF as part of UTF-8 BOM");
        throw new IOException(sb2.toString());
    }
    
    private static MatchStrength m(final y2.a a, final String s, final MatchStrength matchStrength) throws IOException {
        for (int length = s.length(), i = 0; i < length; ++i) {
            if (!a.b()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (a.a() != s.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }
    
    public JsonParser c(final int n, final com.fasterxml.jackson.core.c c, b3.a g, final b b, final int n2) throws IOException {
        if (this.e() == JsonEncoding.UTF8 && JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(n2)) {
            g = g.G(n2);
            return new j(this.a, n, this.b, c, g, this.c, this.d, this.e, this.f);
        }
        return new g(this.a, n, this.d(), c, b.q(n2));
    }
    
    public Reader d() throws IOException {
        final JsonEncoding j = this.a.j();
        final int bits = j.bits();
        if (bits == 8 || bits == 16) {
            final InputStream b = this.b;
            InputStream inputStream;
            if (b == null) {
                inputStream = new ByteArrayInputStream(this.c, this.d, this.e);
            }
            else {
                inputStream = b;
                if (this.d < this.e) {
                    inputStream = new e(this.a, b, this.c, this.d, this.e);
                }
            }
            return new InputStreamReader(inputStream, j.getJavaName());
        }
        if (bits == 32) {
            final c a = this.a;
            return new h(a, this.b, this.c, this.d, this.e, a.j().isBigEndian());
        }
        throw new RuntimeException("Internal error");
    }
    
    public JsonEncoding e() throws IOException {
        final boolean f = this.f(4);
        final boolean b = false;
        int n2 = 0;
        Label_0179: {
            if (f) {
                final byte[] c = this.c;
                final int d = this.d;
                final int n = (c[d + 3] & 0xFF) | (c[d] << 24 | (c[d + 1] & 0xFF) << 16 | (c[d + 2] & 0xFF) << 8);
                if (!this.g(n)) {
                    if (!this.b(n)) {
                        n2 = (b ? 1 : 0);
                        if (!this.a(n >>> 16)) {
                            break Label_0179;
                        }
                    }
                }
            }
            else {
                n2 = (b ? 1 : 0);
                if (!this.f(2)) {
                    break Label_0179;
                }
                final byte[] c2 = this.c;
                final int d2 = this.d;
                final byte b2 = c2[d2];
                n2 = (b ? 1 : 0);
                if (!this.a((c2[d2 + 1] & 0xFF) | (b2 & 0xFF) << 8)) {
                    break Label_0179;
                }
            }
            n2 = 1;
        }
        JsonEncoding jsonEncoding;
        if (n2 == 0) {
            jsonEncoding = JsonEncoding.UTF8;
        }
        else {
            final int h = this.h;
            if (h != 1) {
                if (h != 2) {
                    if (h != 4) {
                        throw new RuntimeException("Internal error");
                    }
                    if (this.g) {
                        jsonEncoding = JsonEncoding.UTF32_BE;
                    }
                    else {
                        jsonEncoding = JsonEncoding.UTF32_LE;
                    }
                }
                else if (this.g) {
                    jsonEncoding = JsonEncoding.UTF16_BE;
                }
                else {
                    jsonEncoding = JsonEncoding.UTF16_LE;
                }
            }
            else {
                jsonEncoding = JsonEncoding.UTF8;
            }
        }
        this.a.r(jsonEncoding);
        return jsonEncoding;
    }
    
    protected boolean f(final int n) throws IOException {
        int read;
        for (int i = this.e - this.d; i < n; i += read) {
            final InputStream b = this.b;
            if (b == null) {
                read = -1;
            }
            else {
                final byte[] c = this.c;
                final int e = this.e;
                read = b.read(c, e, c.length - e);
            }
            if (read < 1) {
                return false;
            }
            this.e += read;
        }
        return true;
    }
}
