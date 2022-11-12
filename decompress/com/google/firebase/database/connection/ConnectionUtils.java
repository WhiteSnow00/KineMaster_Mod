// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConnectionUtils
{
    public static void a(final boolean b) {
        b(b, "", new Object[0]);
    }
    
    public static void b(final boolean b, final String s, final Object... array) {
        if (b) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("hardAssert failed: ");
        sb.append(String.format(s, array));
        throw new AssertionError((Object)sb.toString());
    }
    
    public static Long c(final Object o) {
        if (o instanceof Integer) {
            return (long)(int)o;
        }
        if (o instanceof Long) {
            return (Long)o;
        }
        return null;
    }
    
    public static String d(final List<String> list) {
        if (list.isEmpty()) {
            return "/";
        }
        final StringBuilder sb = new StringBuilder();
        int n = 1;
        for (final String s : list) {
            if (n == 0) {
                sb.append("/");
            }
            n = 0;
            sb.append(s);
        }
        return sb.toString();
    }
    
    public static List<String> e(final String s) {
        final ArrayList list = new ArrayList();
        final String[] split = s.split("/", -1);
        for (int i = 0; i < split.length; ++i) {
            if (!split[i].isEmpty()) {
                list.add(split[i]);
            }
        }
        return list;
    }
}
