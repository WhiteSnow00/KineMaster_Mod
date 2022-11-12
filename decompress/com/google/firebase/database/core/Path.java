// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.google.firebase.database.snapshot.ChildKey;

public class Path implements Iterable<ChildKey>, Comparable<Path>
{
    private static final Path d;
    private final ChildKey[] a;
    private final int b;
    private final int c;
    
    static {
        d = new Path("");
    }
    
    public Path(final String s) {
        final String[] split = s.split("/", -1);
        final int length = split.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            int n2 = n;
            if (split[i].length() > 0) {
                n2 = n + 1;
            }
            ++i;
            n = n2;
        }
        this.a = new ChildKey[n];
        final int length2 = split.length;
        int j = 0;
        int n3 = 0;
        while (j < length2) {
            final String s2 = split[j];
            int n4 = n3;
            if (s2.length() > 0) {
                this.a[n3] = ChildKey.f(s2);
                n4 = n3 + 1;
            }
            ++j;
            n3 = n4;
        }
        this.b = 0;
        this.c = this.a.length;
    }
    
    public Path(final List<String> list) {
        this.a = new ChildKey[list.size()];
        final Iterator iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            this.a[n] = ChildKey.f((String)iterator.next());
            ++n;
        }
        this.b = 0;
        this.c = list.size();
    }
    
    public Path(final ChildKey... array) {
        this.a = Arrays.copyOf(array, array.length);
        this.b = 0;
        this.c = array.length;
        for (int length = array.length, i = 0; i < length; ++i) {
            Utilities.g(array[i] != null, "Can't construct a path with a null value!");
        }
    }
    
    private Path(final ChildKey[] a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    static int a(final Path path) {
        return path.b;
    }
    
    static int f(final Path path) {
        return path.c;
    }
    
    static ChildKey[] g(final Path path) {
        return path.a;
    }
    
    public static Path s() {
        return Path.d;
    }
    
    public static Path x(final Path path, final Path path2) {
        final ChildKey t = path.t();
        final ChildKey t2 = path2.t();
        if (t == null) {
            return path2;
        }
        if (t.equals(t2)) {
            return x(path.y(), path2.y());
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("INTERNAL ERROR: ");
        sb.append(path2);
        sb.append(" is not contained in ");
        sb.append(path);
        throw new DatabaseException(sb.toString());
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.o((Path)o);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Path)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final Path path = (Path)o;
        if (this.size() != path.size()) {
            return false;
        }
        for (int b = this.b, b2 = path.b; b < this.c && b2 < path.c; ++b, ++b2) {
            if (!this.a[b].equals(path.a[b2])) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int i = this.b;
        int n = 0;
        while (i < this.c) {
            n = n * 37 + this.a[i].hashCode();
            ++i;
        }
        return n;
    }
    
    public boolean isEmpty() {
        return this.b >= this.c;
    }
    
    @Override
    public Iterator<ChildKey> iterator() {
        return new Iterator<ChildKey>(this) {
            int a = Path.a(b);
            final Path b;
            
            public ChildKey b() {
                if (this.hasNext()) {
                    final ChildKey[] g = Path.g(this.b);
                    final int a = this.a;
                    final ChildKey childKey = g[a];
                    this.a = a + 1;
                    return childKey;
                }
                throw new NoSuchElementException("No more elements.");
            }
            
            @Override
            public boolean hasNext() {
                return this.a < Path.f(this.b);
            }
            
            @Override
            public /* bridge */ Object next() {
                return this.b();
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Can't remove component from immutable Path!");
            }
        };
    }
    
    public List<String> k() {
        final ArrayList list = new ArrayList(this.size());
        final Iterator<ChildKey> iterator = this.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().c());
        }
        return list;
    }
    
    public Path m(final Path path) {
        final int n = this.size() + path.size();
        final ChildKey[] array = new ChildKey[n];
        System.arraycopy(this.a, this.b, array, 0, this.size());
        System.arraycopy(path.a, path.b, array, this.size(), path.size());
        return new Path(array, 0, n);
    }
    
    public Path n(final ChildKey childKey) {
        final int size = this.size();
        final int n = size + 1;
        final ChildKey[] array = new ChildKey[n];
        System.arraycopy(this.a, this.b, array, 0, size);
        array[size] = childKey;
        return new Path(array, 0, n);
    }
    
    public int o(final Path path) {
        int b = this.b;
        int b2 = path.b;
        while (true) {
            final int c = this.c;
            if (b < c && b2 < path.c) {
                final int d = this.a[b].d(path.a[b2]);
                if (d != 0) {
                    return d;
                }
                ++b;
                ++b2;
            }
            else {
                if (b == c && b2 == path.c) {
                    return 0;
                }
                if (b == c) {
                    return -1;
                }
                return 1;
            }
        }
    }
    
    public boolean p(final Path path) {
        if (this.size() > path.size()) {
            return false;
        }
        for (int i = this.b, b = path.b; i < this.c; ++i, ++b) {
            if (!this.a[i].equals(path.a[b])) {
                return false;
            }
        }
        return true;
    }
    
    public ChildKey q() {
        if (!this.isEmpty()) {
            return this.a[this.c - 1];
        }
        return null;
    }
    
    public int size() {
        return this.c - this.b;
    }
    
    public ChildKey t() {
        if (this.isEmpty()) {
            return null;
        }
        return this.a[this.b];
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "/";
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = this.b; i < this.c; ++i) {
            sb.append("/");
            sb.append(this.a[i].c());
        }
        return sb.toString();
    }
    
    public Path w() {
        if (this.isEmpty()) {
            return null;
        }
        return new Path(this.a, this.b, this.c - 1);
    }
    
    public Path y() {
        int b = this.b;
        if (!this.isEmpty()) {
            ++b;
        }
        return new Path(this.a, b, this.c);
    }
    
    public String z() {
        if (this.isEmpty()) {
            return "/";
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = this.b; i < this.c; ++i) {
            if (i > this.b) {
                sb.append("/");
            }
            sb.append(this.a[i].c());
        }
        return sb.toString();
    }
}
