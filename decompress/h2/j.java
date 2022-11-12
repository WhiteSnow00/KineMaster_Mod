// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class j implements h
{
    private final Map<String, List<i>> c;
    private volatile Map<String, String> d;
    
    j(final Map<String, List<i>> map) {
        this.c = Collections.unmodifiableMap((Map<? extends String, ? extends List<i>>)map);
    }
    
    private String b(final List<i> list) {
        final StringBuilder sb = new StringBuilder();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final String a = list.get(i).a();
            if (!TextUtils.isEmpty((CharSequence)a)) {
                sb.append(a);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
    
    private Map<String, String> c() {
        final HashMap hashMap = new HashMap();
        for (final Map.Entry<K, List> entry : this.c.entrySet()) {
            final String b = this.b(entry.getValue());
            if (!TextUtils.isEmpty((CharSequence)b)) {
                hashMap.put(entry.getKey(), b);
            }
        }
        return hashMap;
    }
    
    @Override
    public Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap((Map<? extends String, ? extends String>)this.c());
                }
            }
        }
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof j && this.c.equals(((j)o).c);
    }
    
    @Override
    public int hashCode() {
        return this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LazyHeaders{headers=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
    
    public static final class a
    {
        private static final String d;
        private static final Map<String, List<i>> e;
        private boolean a;
        private Map<String, List<i>> b;
        private boolean c;
        
        static {
            final String s = d = g();
            final HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty((CharSequence)s)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(s)));
            }
            e = Collections.unmodifiableMap((Map<?, ?>)hashMap);
        }
        
        public a() {
            this.a = true;
            this.b = a.e;
            this.c = true;
        }
        
        private Map<String, List<i>> d() {
            final HashMap hashMap = new HashMap(this.b.size());
            for (final Map.Entry<Object, V> entry : this.b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList((Collection<?>)entry.getValue()));
            }
            return hashMap;
        }
        
        private void e() {
            if (this.a) {
                this.a = false;
                this.b = this.d();
            }
        }
        
        private List<i> f(final String s) {
            List list;
            if ((list = this.b.get(s)) == null) {
                list = new ArrayList();
                this.b.put(s, list);
            }
            return list;
        }
        
        static String g() {
            final String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty((CharSequence)property)) {
                return property;
            }
            final int length = property.length();
            final StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; ++i) {
                final char char1 = property.charAt(i);
                if ((char1 > '\u001f' || char1 == '\t') && char1 < '\u007f') {
                    sb.append(char1);
                }
                else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
        
        public a a(final String s, final i i) {
            if (this.c && "User-Agent".equalsIgnoreCase(s)) {
                return this.h(s, i);
            }
            this.e();
            this.f(s).add(i);
            return this;
        }
        
        public a b(final String s, final String s2) {
            return this.a(s, new b(s2));
        }
        
        public j c() {
            this.a = true;
            return new j(this.b);
        }
        
        public a h(final String s, final i i) {
            this.e();
            if (i == null) {
                this.b.remove(s);
            }
            else {
                final List<i> f = this.f(s);
                f.clear();
                f.add(i);
            }
            if (this.c && "User-Agent".equalsIgnoreCase(s)) {
                this.c = false;
            }
            return this;
        }
    }
    
    static final class b implements i
    {
        private final String a;
        
        b(final String a) {
            this.a = a;
        }
        
        @Override
        public String a() {
            return this.a;
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof b && this.a.equals(((b)o).a);
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("StringHeaderFactory{value='");
            sb.append(this.a);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
