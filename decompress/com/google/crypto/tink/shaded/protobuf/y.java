// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Modifier;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

final class y
{
    private static final String a(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (Character.isUpperCase(char1)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(char1));
        }
        return sb.toString();
    }
    
    private static boolean b(final Object o) {
        final boolean b = o instanceof Boolean;
        boolean b2 = true;
        final boolean b3 = true;
        final boolean b4 = true;
        final boolean b5 = true;
        final boolean b6 = true;
        if (b) {
            return (boolean)o ^ true;
        }
        if (o instanceof Integer) {
            return (int)o == 0 && b6;
        }
        if (o instanceof Float) {
            if ((float)o != 0.0f) {
                b2 = false;
            }
            return b2;
        }
        if (o instanceof Double) {
            return (double)o == 0.0 && b3;
        }
        if (o instanceof String) {
            return o.equals("");
        }
        if (o instanceof ByteString) {
            return o.equals(ByteString.EMPTY);
        }
        if (o instanceof MessageLite) {
            return o == ((MessageLite)o).d() && b4;
        }
        return o instanceof Enum && ((Enum)o).ordinal() == 0 && b5;
    }
    
    static final void c(final StringBuilder sb, final int n, final String s, final Object o) {
        if (o instanceof List) {
            final Iterator iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                c(sb, n, s, iterator.next());
            }
            return;
        }
        if (o instanceof Map) {
            final Iterator iterator2 = ((Map)o).entrySet().iterator();
            while (iterator2.hasNext()) {
                c(sb, n, s, iterator2.next());
            }
            return;
        }
        sb.append('\n');
        final int n2 = 0;
        final int n3 = 0;
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        sb.append(s);
        if (o instanceof String) {
            sb.append(": \"");
            sb.append(n0.c((String)o));
            sb.append('\"');
        }
        else if (o instanceof ByteString) {
            sb.append(": \"");
            sb.append(n0.a((ByteString)o));
            sb.append('\"');
        }
        else if (o instanceof GeneratedMessageLite) {
            sb.append(" {");
            d((MessageLite)o, sb, n + 2);
            sb.append("\n");
            for (int j = n3; j < n; ++j) {
                sb.append(' ');
            }
            sb.append("}");
        }
        else if (o instanceof Map.Entry) {
            sb.append(" {");
            final Map.Entry entry = (Map.Entry)o;
            final int n4 = n + 2;
            c(sb, n4, "key", entry.getKey());
            c(sb, n4, "value", entry.getValue());
            sb.append("\n");
            for (int k = n2; k < n; ++k) {
                sb.append(' ');
            }
            sb.append("}");
        }
        else {
            sb.append(": ");
            sb.append(o.toString());
        }
    }
    
    private static void d(final MessageLite messageLite, final StringBuilder sb, final int n) {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final TreeSet set = new TreeSet();
        for (final Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    set.add(method.getName());
                }
            }
        }
        for (final String s : set) {
            String substring;
            if (s.startsWith("get")) {
                substring = s.substring(3);
            }
            else {
                substring = s;
            }
            final boolean endsWith = substring.endsWith("List");
            boolean booleanValue = true;
            if (endsWith && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(substring.substring(0, 1).toLowerCase());
                sb2.append(substring.substring(1, substring.length() - 4));
                final String string = sb2.toString();
                final Method method2 = (Method)hashMap.get(s);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    c(sb, n, a(string), GeneratedMessageLite.v(method2, messageLite, new Object[0]));
                    continue;
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(substring.substring(0, 1).toLowerCase());
                sb3.append(substring.substring(1, substring.length() - 3));
                final String string2 = sb3.toString();
                final Method method3 = (Method)hashMap.get(s);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb, n, a(string2), GeneratedMessageLite.v(method3, messageLite, new Object[0]));
                    continue;
                }
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("set");
            sb4.append(substring);
            if (hashMap2.get(sb4.toString()) == null) {
                continue;
            }
            if (substring.endsWith("Bytes")) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("get");
                sb5.append(substring.substring(0, substring.length() - 5));
                if (hashMap.containsKey(sb5.toString())) {
                    continue;
                }
            }
            final StringBuilder sb6 = new StringBuilder();
            sb6.append(substring.substring(0, 1).toLowerCase());
            sb6.append(substring.substring(1));
            final String string3 = sb6.toString();
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("get");
            sb7.append(substring);
            final Method method4 = (Method)hashMap.get(sb7.toString());
            final StringBuilder sb8 = new StringBuilder();
            sb8.append("has");
            sb8.append(substring);
            final Method method5 = (Method)hashMap.get(sb8.toString());
            if (method4 == null) {
                continue;
            }
            final Object v = GeneratedMessageLite.v(method4, messageLite, new Object[0]);
            if (method5 == null) {
                if (b(v)) {
                    booleanValue = false;
                }
            }
            else {
                booleanValue = (boolean)GeneratedMessageLite.v(method5, messageLite, new Object[0]);
            }
            if (!booleanValue) {
                continue;
            }
            c(sb, n, a(string3), v);
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            final Iterator<Map.Entry<GeneratedMessageLite.a, Object>> r = ((GeneratedMessageLite.ExtendableMessage)messageLite).extensions.r();
            while (r.hasNext()) {
                final Map.Entry<GeneratedMessageLite.a, V> entry = (Map.Entry<GeneratedMessageLite.a, V>)r.next();
                final StringBuilder sb9 = new StringBuilder();
                sb9.append("[");
                sb9.append(entry.getKey().getNumber());
                sb9.append("]");
                c(sb, n, sb9.toString(), entry.getValue());
            }
        }
        final UnknownFieldSetLite unknownFields = ((GeneratedMessageLite)messageLite).unknownFields;
        if (unknownFields != null) {
            unknownFields.m(sb, n);
        }
    }
    
    static String e(final MessageLite messageLite, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(s);
        d(messageLite, sb, 0);
        return sb.toString();
    }
}
