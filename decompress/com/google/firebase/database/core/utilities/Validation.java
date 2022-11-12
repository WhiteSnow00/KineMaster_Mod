// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import java.util.List;
import java.util.Iterator;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.ValidationPath;
import java.util.TreeMap;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;
import com.google.firebase.database.core.Path;
import java.util.regex.Pattern;

public class Validation
{
    private static final Pattern a;
    private static final Pattern b;
    
    static {
        a = Pattern.compile("[\\[\\]\\.#$]");
        b = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");
    }
    
    private static boolean a(final String s) {
        return Validation.a.matcher(s).find() ^ true;
    }
    
    private static boolean b(final String s) {
        return s != null && s.length() > 0 && (s.equals(".value") || s.equals(".priority") || (!s.startsWith(".") && !Validation.b.matcher(s).find()));
    }
    
    public static Map<Path, Node> c(Path path, final Map<String, Object> map) throws DatabaseException {
        final TreeMap treeMap = new TreeMap();
        for (final Map.Entry entry : map.entrySet()) {
            final Path path2 = new Path((String)entry.getKey());
            final Object value = entry.getValue();
            ValidationPath.g(path.m(path2), value);
            String c;
            if (!path2.isEmpty()) {
                c = path2.q().c();
            }
            else {
                c = "";
            }
            if (c.equals(".sv") || c.equals(".value")) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Path '");
                sb.append(path2);
                sb.append("' contains disallowed child name: ");
                sb.append(c);
                throw new DatabaseException(sb.toString());
            }
            Node node;
            if (c.equals(".priority")) {
                node = PriorityUtilities.c(path2, value);
            }
            else {
                node = NodeUtilities.a(value);
            }
            h(value);
            treeMap.put(path2, node);
        }
        path = null;
        for (final Path path3 : treeMap.keySet()) {
            Utilities.f(path == null || path.o(path3) < 0);
            if (path != null && path.p(path3)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Path '");
                sb2.append(path);
                sb2.append("' is an ancestor of '");
                sb2.append(path3);
                sb2.append("' in an update.");
                throw new DatabaseException(sb2.toString());
            }
            path = path3;
        }
        return treeMap;
    }
    
    private static void d(final double n) {
        if (!Double.isInfinite(n) && !Double.isNaN(n)) {
            return;
        }
        throw new DatabaseException("Invalid value: Value cannot be NaN, Inf or -Inf.");
    }
    
    public static void e(final String s) throws DatabaseException {
        if (a(s)) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid Firebase Database path: ");
        sb.append(s);
        sb.append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
        throw new DatabaseException(sb.toString());
    }
    
    public static void f(final String s) throws DatabaseException {
        if (s.startsWith(".info")) {
            e(s.substring(5));
        }
        else if (s.startsWith("/.info")) {
            e(s.substring(6));
        }
        else {
            e(s);
        }
    }
    
    public static void g(final String s) throws DatabaseException {
        if (b(s)) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid key: ");
        sb.append(s);
        sb.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
        throw new DatabaseException(sb.toString());
    }
    
    public static void h(final Object o) {
        if (o instanceof Map) {
            final Map map = (Map)o;
            if (map.containsKey(".sv")) {
                return;
            }
            for (final Map.Entry<String, V> entry : map.entrySet()) {
                g(entry.getKey());
                h(entry.getValue());
            }
        }
        else if (o instanceof List) {
            final Iterator iterator2 = ((List)o).iterator();
            while (iterator2.hasNext()) {
                h(iterator2.next());
            }
        }
        else if (o instanceof Double || o instanceof Float) {
            d((double)o);
        }
    }
}
