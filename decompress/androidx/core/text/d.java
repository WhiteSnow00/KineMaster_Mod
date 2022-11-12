// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.text;

import java.util.Locale;

public final class d
{
    public static final androidx.core.text.c a;
    public static final androidx.core.text.c b;
    public static final androidx.core.text.c c;
    public static final androidx.core.text.c d;
    public static final androidx.core.text.c e;
    public static final androidx.core.text.c f;
    
    static {
        a = new e(null, false);
        b = new e(null, true);
        final b a2 = androidx.core.text.d.b.a;
        c = new e(a2, false);
        d = new e(a2, true);
        e = new e(androidx.core.text.d.a.b, false);
        f = androidx.core.text.d.f.b;
    }
    
    static int a(final int n) {
        if (n == 0) {
            return 1;
        }
        if (n != 1 && n != 2) {
            return 2;
        }
        return 0;
    }
    
    static int b(final int n) {
        if (n != 0) {
            if (n != 1 && n != 2) {
                switch (n) {
                    default: {
                        return 2;
                    }
                    case 16:
                    case 17: {
                        break;
                    }
                    case 14:
                    case 15: {
                        return 1;
                    }
                }
            }
            return 0;
        }
        return 1;
    }
    
    private static class a implements c
    {
        static final a b;
        private final boolean a;
        
        static {
            b = new a(true);
        }
        
        private a(final boolean a) {
            this.a = a;
        }
        
        @Override
        public int a(final CharSequence charSequence, final int n, final int n2) {
            boolean b = false;
            for (int i = n; i < n2 + n; ++i) {
                final int a = androidx.core.text.d.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a != 0) {
                    if (a != 1) {
                        continue;
                    }
                    if (!this.a) {
                        return 1;
                    }
                }
                else if (this.a) {
                    return 0;
                }
                b = true;
            }
            if (b) {
                return this.a ? 1 : 0;
            }
            return 2;
        }
    }
    
    private interface c
    {
        int a(final CharSequence p0, final int p1, final int p2);
    }
    
    private static class b implements c
    {
        static final b a;
        
        static {
            a = new b();
        }
        
        @Override
        public int a(final CharSequence charSequence, final int n, final int n2) {
            int b = 2;
            for (int n3 = n; n3 < n2 + n && b == 2; b = androidx.core.text.d.b(Character.getDirectionality(charSequence.charAt(n3))), ++n3) {}
            return b;
        }
    }
    
    private abstract static class d implements c
    {
        private final androidx.core.text.d.c a;
        
        d(final androidx.core.text.d.c a) {
            this.a = a;
        }
        
        private boolean c(final CharSequence charSequence, int a, final int n) {
            a = this.a.a(charSequence, a, n);
            return a == 0 || (a != 1 && this.b());
        }
        
        @Override
        public boolean a(final CharSequence charSequence, final int n, final int n2) {
            if (charSequence == null || n < 0 || n2 < 0 || charSequence.length() - n2 < n) {
                throw new IllegalArgumentException();
            }
            if (this.a == null) {
                return this.b();
            }
            return this.c(charSequence, n, n2);
        }
        
        protected abstract boolean b();
    }
    
    private static class e extends d
    {
        private final boolean b;
        
        e(final c c, final boolean b) {
            super(c);
            this.b = b;
        }
        
        @Override
        protected boolean b() {
            return this.b;
        }
    }
    
    private static class f extends d
    {
        static final f b;
        
        static {
            b = new f();
        }
        
        f() {
            super(null);
        }
        
        @Override
        protected boolean b() {
            final int a = androidx.core.text.e.a(Locale.getDefault());
            boolean b = true;
            if (a != 1) {
                b = false;
            }
            return b;
        }
    }
}
