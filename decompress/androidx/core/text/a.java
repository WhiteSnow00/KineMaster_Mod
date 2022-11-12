// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class a
{
    static final c d;
    private static final String e;
    private static final String f;
    static final a g;
    static final a h;
    private final boolean a;
    private final int b;
    private final c c;
    
    static {
        final c c = d = androidx.core.text.d.c;
        e = Character.toString('\u200e');
        f = Character.toString('\u200f');
        g = new a(false, 2, c);
        h = new a(true, 2, c);
    }
    
    a(final boolean a, final int b, final c c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private static int a(final CharSequence charSequence) {
        return new b(charSequence, false).d();
    }
    
    private static int b(final CharSequence charSequence) {
        return new b(charSequence, false).e();
    }
    
    public static a c() {
        return new a().a();
    }
    
    static boolean e(final Locale locale) {
        final int a = androidx.core.text.e.a(locale);
        boolean b = true;
        if (a != 1) {
            b = false;
        }
        return b;
    }
    
    private String f(final CharSequence charSequence, final c c) {
        final boolean a = c.a(charSequence, 0, charSequence.length());
        if (!this.a && (a || b(charSequence) == 1)) {
            return androidx.core.text.a.e;
        }
        if (this.a && (!a || b(charSequence) == -1)) {
            return androidx.core.text.a.f;
        }
        return "";
    }
    
    private String g(final CharSequence charSequence, final c c) {
        final boolean a = c.a(charSequence, 0, charSequence.length());
        if (!this.a && (a || a(charSequence) == 1)) {
            return androidx.core.text.a.e;
        }
        if (this.a && (!a || a(charSequence) == -1)) {
            return androidx.core.text.a.f;
        }
        return "";
    }
    
    public boolean d() {
        return (this.b & 0x2) != 0x0;
    }
    
    public CharSequence h(final CharSequence charSequence) {
        return this.i(charSequence, this.c, true);
    }
    
    public CharSequence i(final CharSequence charSequence, c c, final boolean b) {
        if (charSequence == null) {
            return null;
        }
        final boolean a = c.a(charSequence, 0, charSequence.length());
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.d() && b) {
            if (a) {
                c = androidx.core.text.d.b;
            }
            else {
                c = androidx.core.text.d.a;
            }
            spannableStringBuilder.append((CharSequence)this.g(charSequence, c));
        }
        if (a != this.a) {
            char c2;
            if (a) {
                c2 = '\u202b';
            }
            else {
                c2 = '\u202a';
            }
            spannableStringBuilder.append(c2);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('\u202c');
        }
        else {
            spannableStringBuilder.append(charSequence);
        }
        if (b) {
            if (a) {
                c = androidx.core.text.d.b;
            }
            else {
                c = androidx.core.text.d.a;
            }
            spannableStringBuilder.append((CharSequence)this.f(charSequence, c));
        }
        return (CharSequence)spannableStringBuilder;
    }
    
    public String j(final String s) {
        return this.k(s, this.c, true);
    }
    
    public String k(final String s, final c c, final boolean b) {
        if (s == null) {
            return null;
        }
        return this.i(s, c, b).toString();
    }
    
    public static final class a
    {
        private boolean a;
        private int b;
        private c c;
        
        public a() {
            this.c(androidx.core.text.a.e(Locale.getDefault()));
        }
        
        private static androidx.core.text.a b(final boolean b) {
            androidx.core.text.a a;
            if (b) {
                a = androidx.core.text.a.h;
            }
            else {
                a = androidx.core.text.a.g;
            }
            return a;
        }
        
        private void c(final boolean a) {
            this.a = a;
            this.c = a.d;
            this.b = 2;
        }
        
        public androidx.core.text.a a() {
            if (this.b == 2 && this.c == androidx.core.text.a.d) {
                return b(this.a);
            }
            return new androidx.core.text.a(this.a, this.b, this.c);
        }
    }
    
    private static class b
    {
        private static final byte[] f;
        private final CharSequence a;
        private final boolean b;
        private final int c;
        private int d;
        private char e;
        
        static {
            f = new byte[1792];
            for (int i = 0; i < 1792; ++i) {
                b.f[i] = Character.getDirectionality(i);
            }
        }
        
        b(final CharSequence a, final boolean b) {
            this.a = a;
            this.b = b;
            this.c = a.length();
        }
        
        private static byte c(final char c) {
            byte directionality;
            if (c < '\u0700') {
                directionality = b.f[c];
            }
            else {
                directionality = Character.getDirectionality(c);
            }
            return directionality;
        }
        
        private byte f() {
            final int d = this.d;
            char char1;
            do {
                int d2 = this.d;
                if (d2 <= 0) {
                    break;
                }
                final CharSequence a = this.a;
                --d2;
                this.d = d2;
                char1 = a.charAt(d2);
                if ((this.e = char1) == '&') {
                    return 12;
                }
            } while (char1 != ';');
            this.d = d;
            this.e = ';';
            return 13;
        }
        
        private byte g() {
            int d;
            CharSequence a;
            do {
                d = this.d;
                if (d >= this.c) {
                    break;
                }
                a = this.a;
                this.d = d + 1;
            } while ((this.e = a.charAt(d)) != ';');
            return 12;
        }
        
        private byte h() {
            final int d = this.d;
            while (true) {
                int d2 = this.d;
                if (d2 <= 0) {
                    break;
                }
                final CharSequence a = this.a;
                --d2;
                this.d = d2;
                final char char1 = a.charAt(d2);
                if ((this.e = char1) == '<') {
                    return 12;
                }
                if (char1 == '>') {
                    break;
                }
                if (char1 != '\"' && char1 != '\'') {
                    continue;
                }
                int d3;
                CharSequence a2;
                do {
                    d3 = this.d;
                    if (d3 <= 0) {
                        break;
                    }
                    a2 = this.a;
                    --d3;
                    this.d = d3;
                } while ((this.e = a2.charAt(d3)) != char1);
            }
            this.d = d;
            this.e = '>';
            return 13;
        }
        
        private byte i() {
            final int d = this.d;
            while (true) {
                final int d2 = this.d;
                if (d2 >= this.c) {
                    this.d = d;
                    this.e = '<';
                    return 13;
                }
                final CharSequence a = this.a;
                this.d = d2 + 1;
                final char char1 = a.charAt(d2);
                if ((this.e = char1) == '>') {
                    return 12;
                }
                if (char1 != '\"' && char1 != '\'') {
                    continue;
                }
                int d3;
                CharSequence a2;
                do {
                    d3 = this.d;
                    if (d3 >= this.c) {
                        break;
                    }
                    a2 = this.a;
                    this.d = d3 + 1;
                } while ((this.e = a2.charAt(d3)) != char1);
            }
        }
        
        byte a() {
            final char char1 = this.a.charAt(this.d - 1);
            this.e = char1;
            if (Character.isLowSurrogate(char1)) {
                final int codePointBefore = Character.codePointBefore(this.a, this.d);
                this.d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            --this.d;
            byte b = c(this.e);
            if (this.b) {
                final char e = this.e;
                if (e == '>') {
                    b = this.h();
                }
                else {
                    b = b;
                    if (e == ';') {
                        b = this.f();
                    }
                }
            }
            return b;
        }
        
        byte b() {
            final char char1 = this.a.charAt(this.d);
            this.e = char1;
            if (Character.isHighSurrogate(char1)) {
                final int codePoint = Character.codePointAt(this.a, this.d);
                this.d += Character.charCount(codePoint);
                return Character.getDirectionality(codePoint);
            }
            ++this.d;
            byte b = c(this.e);
            if (this.b) {
                final char e = this.e;
                if (e == '<') {
                    b = this.i();
                }
                else {
                    b = b;
                    if (e == '&') {
                        b = this.g();
                    }
                }
            }
            return b;
        }
        
        int d() {
            this.d = 0;
            int n = 0;
            int n3;
            int n2 = n3 = 0;
            while (this.d < this.c && n == 0) {
                final byte b = this.b();
                if (b != 0) {
                    if (b != 1 && b != 2) {
                        if (b == 9) {
                            continue;
                        }
                        switch (b) {
                            case 18: {
                                --n3;
                                n2 = 0;
                                continue;
                            }
                            case 16:
                            case 17: {
                                ++n3;
                                n2 = 1;
                                continue;
                            }
                            case 14:
                            case 15: {
                                ++n3;
                                n2 = -1;
                                continue;
                            }
                        }
                    }
                    else if (n3 == 0) {
                        return 1;
                    }
                }
                else if (n3 == 0) {
                    return -1;
                }
                n = n3;
            }
            if (n == 0) {
                return 0;
            }
            if (n2 != 0) {
                return n2;
            }
            while (this.d > 0) {
                switch (this.a()) {
                    default: {
                        continue;
                    }
                    case 18: {
                        ++n3;
                        continue;
                    }
                    case 16:
                    case 17: {
                        if (n == n3) {
                            return 1;
                        }
                        break;
                    }
                    case 14:
                    case 15: {
                        if (n == n3) {
                            return -1;
                        }
                        break;
                    }
                }
                --n3;
            }
            return 0;
        }
        
        int e() {
            this.d = this.c;
            int n = 0;
            while (true) {
                int n3;
                final int n2 = n3 = n;
                int n4 = 0;
            Label_0156:
                while (true) {
                    n4 = n3;
                    if (this.d <= 0) {
                        return 0;
                    }
                    final byte a = this.a();
                    if (a != 0) {
                        if (a != 1 && a != 2) {
                            n3 = n4;
                            if (a == 9) {
                                continue;
                            }
                            switch (a) {
                                default: {
                                    n3 = n4;
                                    if (n2 == 0) {
                                        break Label_0156;
                                    }
                                    continue;
                                }
                                case 18: {
                                    n3 = n4 + 1;
                                    continue;
                                }
                                case 16:
                                case 17: {
                                    if (n2 == n4) {
                                        return 1;
                                    }
                                    break;
                                }
                                case 14:
                                case 15: {
                                    if (n2 == n4) {
                                        return -1;
                                    }
                                    break;
                                }
                            }
                            n3 = n4 - 1;
                        }
                        else {
                            if (n4 == 0) {
                                return 1;
                            }
                            n3 = n4;
                            if (n2 == 0) {
                                break;
                            }
                            continue;
                        }
                    }
                    else {
                        if (n4 == 0) {
                            return -1;
                        }
                        n3 = n4;
                        if (n2 == 0) {
                            break;
                        }
                        continue;
                    }
                }
                n = n4;
            }
        }
    }
}
