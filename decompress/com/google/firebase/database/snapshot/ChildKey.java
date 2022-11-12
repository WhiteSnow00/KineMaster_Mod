// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

public class ChildKey implements Comparable<ChildKey>
{
    private static final ChildKey b;
    private static final ChildKey c;
    private static final ChildKey d;
    private static final ChildKey e;
    private final String a;
    
    static {
        b = new ChildKey("[MIN_NAME]");
        c = new ChildKey("[MAX_KEY]");
        d = new ChildKey(".priority");
        e = new ChildKey(".info");
    }
    
    private ChildKey(final String a) {
        this.a = a;
    }
    
    ChildKey(final String s, final ChildKey$a object) {
        this(s);
    }
    
    static String a(final ChildKey childKey) {
        return childKey.a;
    }
    
    public static ChildKey f(final String s) {
        final Integer k = Utilities.k(s);
        if (k != null) {
            return new b(s, k);
        }
        if (s.equals(".priority")) {
            return ChildKey.d;
        }
        Utilities.f(s.contains("/") ^ true);
        return new ChildKey(s);
    }
    
    public static ChildKey g() {
        return ChildKey.c;
    }
    
    public static ChildKey h() {
        return ChildKey.b;
    }
    
    public static ChildKey i() {
        return ChildKey.d;
    }
    
    public String c() {
        return this.a;
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.d((ChildKey)o);
    }
    
    public int d(final ChildKey childKey) {
        if (this == childKey) {
            return 0;
        }
        if (this.a.equals("[MIN_NAME]") || childKey.a.equals("[MAX_KEY]")) {
            return -1;
        }
        if (childKey.a.equals("[MIN_NAME]") || this.a.equals("[MAX_KEY]")) {
            return 1;
        }
        if (this.l()) {
            if (childKey.l()) {
                int n;
                if ((n = Utilities.a(this.k(), childKey.k())) == 0) {
                    n = Utilities.a(this.a.length(), childKey.a.length());
                }
                return n;
            }
            return -1;
        }
        else {
            if (childKey.l()) {
                return 1;
            }
            return this.a.compareTo(childKey.a);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof ChildKey && (this == o || this.a.equals(((ChildKey)o).a));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    protected int k() {
        return 0;
    }
    
    protected boolean l() {
        return false;
    }
    
    public boolean m() {
        return this.equals(ChildKey.d);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ChildKey(\"");
        sb.append(this.a);
        sb.append("\")");
        return sb.toString();
    }
    
    private static class b extends ChildKey
    {
        private final int f;
        
        b(final String s, final int f) {
            super(s, null);
            this.f = f;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return super.d((ChildKey)o);
        }
        
        @Override
        protected int k() {
            return this.f;
        }
        
        @Override
        protected boolean l() {
            return true;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("IntegerChildName(\"");
            sb.append(ChildKey.a(this));
            sb.append("\")");
            return sb.toString();
        }
    }
}
