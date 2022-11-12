// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.Map;
import com.google.firebase.database.DatabaseException;
import java.util.Iterator;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.List;

public class ValidationPath
{
    private final List<String> a;
    private int b;
    
    private ValidationPath(final Path path) throws DatabaseException {
        this.a = new ArrayList<String>();
        int i = 0;
        this.b = 0;
        final Iterator<ChildKey> iterator = path.iterator();
        while (iterator.hasNext()) {
            this.a.add(iterator.next().c());
        }
        this.b = Math.max(1, this.a.size());
        while (i < this.a.size()) {
            this.b += f(this.a.get(i));
            ++i;
        }
        this.a();
    }
    
    private void a() throws DatabaseException {
        if (this.b > 768) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Data has a key path longer than 768 bytes (");
            sb.append(this.b);
            sb.append(").");
            throw new DatabaseException(sb.toString());
        }
        if (this.a.size() <= 32) {
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
        sb2.append(this.e());
        throw new DatabaseException(sb2.toString());
    }
    
    private static String b(final String s, final List<String> list) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                sb.append(s);
            }
            sb.append((String)list.get(i));
        }
        return sb.toString();
    }
    
    private String c() {
        final List<String> a = this.a;
        final String s = a.remove(a.size() - 1);
        this.b -= f(s);
        if (this.a.size() > 0) {
            --this.b;
        }
        return s;
    }
    
    private void d(final String s) throws DatabaseException {
        if (this.a.size() > 0) {
            ++this.b;
        }
        this.a.add(s);
        this.b += f(s);
        this.a();
    }
    
    private String e() {
        if (this.a.size() == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("in path '");
        sb.append(b("/", this.a));
        sb.append("'");
        return sb.toString();
    }
    
    private static int f(final CharSequence charSequence) {
        final int length = charSequence.length();
        int i = 0;
        int n = 0;
        while (i < length) {
            final char char1 = charSequence.charAt(i);
            if (char1 <= '\u007f') {
                ++n;
            }
            else if (char1 <= '\u07ff') {
                n += 2;
            }
            else if (Character.isHighSurrogate(char1)) {
                n += 4;
                ++i;
            }
            else {
                n += 3;
            }
            ++i;
        }
        return n;
    }
    
    public static void g(final Path path, final Object o) throws DatabaseException {
        new ValidationPath(path).h(o);
    }
    
    private void h(final Object o) throws DatabaseException {
        if (o instanceof Map) {
            final Map map = (Map)o;
            for (final String s : map.keySet()) {
                if (s.startsWith(".")) {
                    continue;
                }
                this.d(s);
                this.h(map.get(s));
                this.c();
            }
            return;
        }
        if (o instanceof List) {
            final List list = (List)o;
            for (int i = 0; i < list.size(); ++i) {
                this.d(Integer.toString(i));
                this.h(list.get(i));
                this.c();
            }
        }
    }
}
