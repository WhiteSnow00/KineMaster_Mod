// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities.encoding;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import com.google.firebase.database.Exclude;
import java.lang.reflect.Modifier;
import java.lang.annotation.Annotation;
import com.google.firebase.database.PropertyName;
import java.lang.reflect.AccessibleObject;
import java.util.Locale;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ThrowOnExtraProperties;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.DatabaseException;
import java.util.Map;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CustomClassMapper
{
    private static final ConcurrentMap<Class<?>, a<?>> a;
    
    static {
        a = new ConcurrentHashMap<Class<?>, a<?>>();
    }
    
    static Object a(final Object o, final Type type) {
        return o(o, type);
    }
    
    static Object b(final Object o) {
        return r(o);
    }
    
    private static <T> T c(final Object o, final Class<T> clazz) {
        final a<T> q = q(clazz);
        if (o instanceof Map) {
            return q.d(p(o));
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't convert object of type ");
        sb.append(o.getClass().getName());
        sb.append(" to type ");
        sb.append(clazz.getName());
        throw new DatabaseException(sb.toString());
    }
    
    private static Boolean d(final Object o) {
        if (o instanceof Boolean) {
            return (Boolean)o;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to convert value of type ");
        sb.append(o.getClass().getName());
        sb.append(" to boolean");
        throw new DatabaseException(sb.toString());
    }
    
    private static Double e(final Object o) {
        if (o instanceof Integer) {
            return (double)o;
        }
        if (o instanceof Long) {
            final Long n = (Long)o;
            final Double value = (Object)n;
            if (value.longValue() == n) {
                return value;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Loss of precision while converting number to double: ");
            sb.append(o);
            sb.append(". Did you mean to use a 64-bit long instead?");
            throw new DatabaseException(sb.toString());
        }
        else {
            if (o instanceof Double) {
                return (Double)o;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to convert a value of type ");
            sb2.append(o.getClass().getName());
            sb2.append(" to double");
            throw new DatabaseException(sb2.toString());
        }
    }
    
    private static Integer f(final Object o) {
        if (o instanceof Integer) {
            return (Integer)o;
        }
        if (!(o instanceof Long) && !(o instanceof Double)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to convert a value of type ");
            sb.append(o.getClass().getName());
            sb.append(" to int");
            throw new DatabaseException(sb.toString());
        }
        final Number n = (Number)o;
        final double doubleValue = n.doubleValue();
        if (doubleValue >= -2.147483648E9 && doubleValue <= 2.147483647E9) {
            return n.intValue();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Numeric value out of 32-bit integer range: ");
        sb2.append(doubleValue);
        sb2.append(". Did you mean to use a long or double instead of an int?");
        throw new DatabaseException(sb2.toString());
    }
    
    private static Long g(final Object o) {
        if (o instanceof Integer) {
            return (long)o;
        }
        if (o instanceof Long) {
            return (Long)o;
        }
        if (!(o instanceof Double)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to convert a value of type ");
            sb.append(o.getClass().getName());
            sb.append(" to long");
            throw new DatabaseException(sb.toString());
        }
        final Double n = (Double)o;
        if (n >= -9.223372036854776E18 && n <= 9.223372036854776E18) {
            return n.longValue();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Numeric value out of 64-bit long range: ");
        sb2.append(n);
        sb2.append(". Did you mean to use a double instead of a long?");
        throw new DatabaseException(sb2.toString());
    }
    
    private static String h(final Object o) {
        if (o instanceof String) {
            return (String)o;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to convert value of type ");
        sb.append(o.getClass().getName());
        sb.append(" to String");
        throw new DatabaseException(sb.toString());
    }
    
    public static <T> T i(final Object o, final Class<T> clazz) {
        return (T)k(o, (Class<Object>)clazz);
    }
    
    public static Map<String, Object> j(final Map<String, Object> map) {
        final Object r = r(map);
        Utilities.f(r instanceof Map);
        return (Map<String, Object>)r;
    }
    
    private static <T> T k(final Object o, final Class<T> clazz) {
        if (o == null) {
            return null;
        }
        if (clazz.isPrimitive() || Number.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz)) {
            return (T)n(o, (Class<Object>)clazz);
        }
        if (String.class.isAssignableFrom(clazz)) {
            return (T)h(o);
        }
        if (clazz.isArray()) {
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        }
        if (clazz.getTypeParameters().length > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(clazz.getName());
            sb.append(" has generic type parameters, please use GenericTypeIndicator instead");
            throw new DatabaseException(sb.toString());
        }
        if (clazz.equals(Object.class)) {
            return (T)o;
        }
        if (clazz.isEnum()) {
            return (T)l(o, (Class<Object>)clazz);
        }
        return (T)c(o, (Class<Object>)clazz);
    }
    
    private static <T> T l(Object o, final Class<T> clazz) {
        if (o instanceof String) {
            o = o;
            try {
                return Enum.valueOf(clazz, (String)o);
            }
            catch (final IllegalArgumentException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not find enum value of ");
                sb.append(clazz.getName());
                sb.append(" for value \"");
                sb.append((String)o);
                sb.append("\"");
                throw new DatabaseException(sb.toString());
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected a String while deserializing to enum ");
        sb2.append(clazz);
        sb2.append(" but got a ");
        sb2.append(o.getClass());
        throw new DatabaseException(sb2.toString());
    }
    
    private static <T> T m(final Object o, final ParameterizedType parameterizedType) {
        final Class clazz = (Class)parameterizedType.getRawType();
        final boolean assignable = List.class.isAssignableFrom(clazz);
        int i = 0;
        if (assignable) {
            final Type type = parameterizedType.getActualTypeArguments()[0];
            if (o instanceof List) {
                final List list = (List)o;
                final ArrayList list2 = new ArrayList(list.size());
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    list2.add(o(iterator.next(), type));
                }
                return (T)list2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected a List while deserializing, but got a ");
            sb.append(o.getClass());
            throw new DatabaseException(sb.toString());
        }
        else if (Map.class.isAssignableFrom(clazz)) {
            final Type type2 = parameterizedType.getActualTypeArguments()[0];
            final Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (type2.equals(String.class)) {
                final Map<String, Object> p2 = p(o);
                final HashMap<String, Object> hashMap = new HashMap<String, Object>();
                for (final Map.Entry<String, V> entry : p2.entrySet()) {
                    hashMap.put(entry.getKey(), o(entry.getValue(), type3));
                }
                return (T)hashMap;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Only Maps with string keys are supported, but found Map with key type ");
            sb2.append(type2);
            throw new DatabaseException(sb2.toString());
        }
        else {
            if (Collection.class.isAssignableFrom(clazz)) {
                throw new DatabaseException("Collections are not supported, please use Lists instead");
            }
            final Map<String, Object> p3 = p(o);
            final a<T> q = q((Class<T>)clazz);
            final HashMap hashMap2 = new HashMap();
            final TypeVariable[] typeParameters = CustomClassMapper.a.a((a<Object>)q).getTypeParameters();
            final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == typeParameters.length) {
                while (i < typeParameters.length) {
                    hashMap2.put(typeParameters[i], actualTypeArguments[i]);
                    ++i;
                }
                return q.e(p3, hashMap2);
            }
            throw new IllegalStateException("Mismatched lengths for type variables and actual types");
        }
    }
    
    private static <T> T n(final Object o, final Class<T> clazz) {
        if (Integer.class.isAssignableFrom(clazz) || Integer.TYPE.isAssignableFrom(clazz)) {
            return (T)f(o);
        }
        if (Boolean.class.isAssignableFrom(clazz) || Boolean.TYPE.isAssignableFrom(clazz)) {
            return (T)d(o);
        }
        if (Double.class.isAssignableFrom(clazz) || Double.TYPE.isAssignableFrom(clazz)) {
            return (T)e(o);
        }
        if (Long.class.isAssignableFrom(clazz) || Long.TYPE.isAssignableFrom(clazz)) {
            return (T)g(o);
        }
        if (!Float.class.isAssignableFrom(clazz) && !Float.TYPE.isAssignableFrom(clazz)) {
            throw new DatabaseException(String.format("Deserializing values to %s is not supported", clazz.getSimpleName()));
        }
        return (T)Float.valueOf(e(o).floatValue());
    }
    
    private static <T> T o(final Object o, final Type type) {
        if (o == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return m(o, (ParameterizedType)type);
        }
        if (type instanceof Class) {
            return k(o, (Class<T>)type);
        }
        final boolean b = type instanceof WildcardType;
        boolean b2 = true;
        final boolean b3 = true;
        if (b) {
            final WildcardType wildcardType = (WildcardType)type;
            if (wildcardType.getLowerBounds().length <= 0) {
                final Type[] upperBounds = wildcardType.getUpperBounds();
                final boolean b4 = upperBounds.length > 0 && b3;
                final StringBuilder sb = new StringBuilder();
                sb.append("Wildcard type ");
                sb.append(type);
                sb.append(" is not upper bounded.");
                Utilities.g(b4, sb.toString());
                return (T)o(o, upperBounds[0]);
            }
            throw new DatabaseException("Generic lower-bounded wildcard types are not supported");
        }
        else {
            if (type instanceof TypeVariable) {
                final Type[] bounds = ((TypeVariable)type).getBounds();
                if (bounds.length <= 0) {
                    b2 = false;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Wildcard type ");
                sb2.append(type);
                sb2.append(" is not upper bounded.");
                Utilities.g(b2, sb2.toString());
                return (T)o(o, bounds[0]);
            }
            if (type instanceof GenericArrayType) {
                throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown type encountered: ");
            sb3.append(type);
            throw new IllegalStateException(sb3.toString());
        }
    }
    
    private static Map<String, Object> p(final Object o) {
        if (o instanceof Map) {
            return (Map)o;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected a Map while deserializing, but got a ");
        sb.append(o.getClass());
        throw new DatabaseException(sb.toString());
    }
    
    private static <T> a<T> q(final Class<T> clazz) {
        final ConcurrentMap<Class<?>, a<?>> a = CustomClassMapper.a;
        a a2;
        if ((a2 = a.get(clazz)) == null) {
            a2 = new a((Class<T>)clazz);
            a.put(clazz, a2);
        }
        return a2;
    }
    
    private static <T> Object r(final T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Number) {
            if (!(t instanceof Float) && !(t instanceof Double)) {
                if (!(t instanceof Long) && !(t instanceof Integer)) {
                    throw new DatabaseException(String.format("Numbers of type %s are not supported, please use an int, long, float or double", t.getClass().getSimpleName()));
                }
                return t;
            }
            else {
                final Number n = (Number)t;
                final double doubleValue = n.doubleValue();
                if (doubleValue <= 9.223372036854776E18 && doubleValue >= -9.223372036854776E18 && Math.floor(doubleValue) == doubleValue) {
                    return n.longValue();
                }
                return doubleValue;
            }
        }
        else {
            if (t instanceof String) {
                return t;
            }
            if (t instanceof Boolean) {
                return t;
            }
            if (t instanceof Character) {
                throw new DatabaseException("Characters are not supported, please use Strings");
            }
            if (t instanceof Map) {
                final HashMap hashMap = new HashMap();
                for (final Map.Entry<Object, V> entry : ((Map)t).entrySet()) {
                    final String key = entry.getKey();
                    if (!(key instanceof String)) {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                    hashMap.put(key, r(entry.getValue()));
                }
                return hashMap;
            }
            if (t instanceof Collection) {
                if (t instanceof List) {
                    final List list = (List)t;
                    final ArrayList list2 = new ArrayList(list.size());
                    final Iterator iterator2 = list.iterator();
                    while (iterator2.hasNext()) {
                        list2.add(r(iterator2.next()));
                    }
                    return list2;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            }
            else {
                if (t.getClass().isArray()) {
                    throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
                }
                if (t instanceof Enum) {
                    return ((Enum)t).name();
                }
                return q(t.getClass()).j(t);
            }
        }
    }
    
    private static class a<T>
    {
        private final Class<T> a;
        private final Constructor<T> b;
        private final boolean c;
        private final boolean d;
        private final Map<String, String> e;
        private final Map<String, Method> f;
        private final Map<String, Method> g;
        private final Map<String, Field> h;
        
        public a(final Class<T> a) {
            this.a = a;
            this.c = a.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.d = (a.isAnnotationPresent(IgnoreExtraProperties.class) ^ true);
            this.e = new HashMap<String, String>();
            this.g = new HashMap<String, Method>();
            this.f = new HashMap<String, Method>();
            this.h = new HashMap<String, Field>();
            Constructor<T> declaredConstructor;
            try {
                declaredConstructor = a.getDeclaredConstructor((Class<?>[])new Class[0]);
                declaredConstructor.setAccessible(true);
            }
            catch (final NoSuchMethodException ex) {
                declaredConstructor = null;
            }
            this.b = declaredConstructor;
            for (final Method method : a.getMethods()) {
                if (m(method)) {
                    final String h = h(method);
                    this.b(h);
                    method.setAccessible(true);
                    if (this.f.containsKey(h)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Found conflicting getters for name: ");
                        sb.append(method.getName());
                        throw new DatabaseException(sb.toString());
                    }
                    this.f.put(h, method);
                }
            }
            for (final Field field : a.getFields()) {
                if (l(field)) {
                    this.b(g(field));
                }
            }
            Class clazz = a;
            Class superclass;
            do {
                for (final Method method2 : clazz.getDeclaredMethods()) {
                    if (n(method2)) {
                        final String h2 = h(method2);
                        final String s = this.e.get(h2.toLowerCase(Locale.US));
                        if (s != null) {
                            if (!s.equals(h2)) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("Found setter with invalid case-sensitive name: ");
                                sb2.append(method2.getName());
                                throw new DatabaseException(sb2.toString());
                            }
                            final Method method3 = this.g.get(h2);
                            if (method3 == null) {
                                method2.setAccessible(true);
                                this.g.put(h2, method2);
                            }
                            else if (!f(method2, method3)) {
                                final StringBuilder sb3 = new StringBuilder();
                                sb3.append("Found a conflicting setters with name: ");
                                sb3.append(method2.getName());
                                sb3.append(" (conflicts with ");
                                sb3.append(method3.getName());
                                sb3.append(" defined on ");
                                sb3.append(method3.getDeclaringClass().getName());
                                sb3.append(")");
                                throw new DatabaseException(sb3.toString());
                            }
                        }
                    }
                }
                for (final Field field2 : clazz.getDeclaredFields()) {
                    final String g = g(field2);
                    if (this.e.containsKey(g.toLowerCase(Locale.US)) && !this.h.containsKey(g)) {
                        field2.setAccessible(true);
                        this.h.put(g, field2);
                    }
                }
                superclass = clazz.getSuperclass();
                if (superclass == null) {
                    break;
                }
                clazz = superclass;
            } while (!superclass.equals(Object.class));
            if (!this.e.isEmpty()) {
                return;
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("No properties to serialize found on class ");
            sb4.append(a.getName());
            throw new DatabaseException(sb4.toString());
        }
        
        static Class a(final a a) {
            return a.a;
        }
        
        private void b(final String s) {
            final Map<String, String> e = this.e;
            final Locale us = Locale.US;
            final String s2 = e.put(s.toLowerCase(us), s);
            if (s2 != null && !s.equals(s2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Found two getters or fields with conflicting case sensitivity for property: ");
                sb.append(s.toLowerCase(us));
                throw new DatabaseException(sb.toString());
            }
        }
        
        private static String c(final AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return accessibleObject.getAnnotation(PropertyName.class).value();
            }
            return null;
        }
        
        private static boolean f(final Method method, final Method method2) {
            Utilities.g(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            Utilities.g(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            Utilities.g(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            final Class<?>[] parameterTypes = method.getParameterTypes();
            final Class<?>[] parameterTypes2 = method2.getParameterTypes();
            final int length = parameterTypes.length;
            final boolean b = false;
            Utilities.g(length == 1, "Expected exactly one parameter");
            Utilities.g(parameterTypes2.length == 1, "Expected exactly one parameter");
            boolean b2 = b;
            if (method.getName().equals(method2.getName())) {
                b2 = b;
                if (parameterTypes[0].equals(parameterTypes2[0])) {
                    b2 = true;
                }
            }
            return b2;
        }
        
        private static String g(final Field field) {
            final String c = c(field);
            String name;
            if (c != null) {
                name = c;
            }
            else {
                name = field.getName();
            }
            return name;
        }
        
        private static String h(final Method method) {
            final String c = c(method);
            String k;
            if (c != null) {
                k = c;
            }
            else {
                k = k(method.getName());
            }
            return k;
        }
        
        private Type i(final Type type, final Map<TypeVariable<Class<T>>, Type> map) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            final Type type2 = map.get(type);
            if (type2 != null) {
                return type2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not resolve type ");
            sb.append(type);
            throw new IllegalStateException(sb.toString());
        }
        
        private static String k(final String s) {
            final int n = 0;
            String s2 = null;
            for (int i = 0; i < 3; ++i) {
                final String s3 = (new String[] { "get", "set", "is" })[i];
                if (s.startsWith(s3)) {
                    s2 = s3;
                }
            }
            if (s2 != null) {
                final char[] charArray = s.substring(s2.length()).toCharArray();
                for (int n2 = n; n2 < charArray.length && Character.isUpperCase(charArray[n2]); ++n2) {
                    charArray[n2] = Character.toLowerCase(charArray[n2]);
                }
                return new String(charArray);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Unknown Bean prefix for method: ");
            sb.append(s);
            throw new IllegalArgumentException(sb.toString());
        }
        
        private static boolean l(final Field field) {
            return !field.getDeclaringClass().equals(Object.class) && Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !field.isAnnotationPresent(Exclude.class);
        }
        
        private static boolean m(final Method method) {
            return (method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getDeclaringClass().equals(Object.class) && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && !method.isAnnotationPresent(Exclude.class);
        }
        
        private static boolean n(final Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class);
        }
        
        public T d(final Map<String, Object> map) {
            return this.e(map, Collections.emptyMap());
        }
        
        public T e(final Map<String, Object> map, final Map<TypeVariable<Class<T>>, Type> map2) {
            final Constructor<T> b = this.b;
            if (b != null) {
                try {
                    final T instance = b.newInstance(new Object[0]);
                    for (final Map.Entry<String, V> entry : map.entrySet()) {
                        final String s = entry.getKey();
                        if (this.g.containsKey(s)) {
                            final Method method = this.g.get(s);
                            final Type[] genericParameterTypes = method.getGenericParameterTypes();
                            if (genericParameterTypes.length == 1) {
                                final Object a = CustomClassMapper.a(entry.getValue(), this.i(genericParameterTypes[0], map2));
                                try {
                                    method.invoke(instance, a);
                                    continue;
                                }
                                catch (final InvocationTargetException ex) {
                                    throw new RuntimeException(ex);
                                }
                                catch (final IllegalAccessException ex2) {
                                    throw new RuntimeException(ex2);
                                }
                            }
                            throw new IllegalStateException("Setter does not have exactly one parameter");
                        }
                        if (this.h.containsKey(s)) {
                            final Field field = this.h.get(s);
                            final Object a2 = CustomClassMapper.a(entry.getValue(), this.i(field.getGenericType(), map2));
                            try {
                                field.set(instance, a2);
                                continue;
                            }
                            catch (final IllegalAccessException ex3) {
                                throw new RuntimeException(ex3);
                            }
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("No setter/field for ");
                        sb.append(s);
                        sb.append(" found on class ");
                        sb.append(this.a.getName());
                        String s3;
                        final String s2 = s3 = sb.toString();
                        if (this.e.containsKey(s.toLowerCase(Locale.US))) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(s2);
                            sb2.append(" (fields/setters are case sensitive!)");
                            s3 = sb2.toString();
                        }
                        if (this.c) {
                            throw new DatabaseException(s3);
                        }
                        if (!this.d) {
                            continue;
                        }
                        Log.w("ClassMapper", s3);
                    }
                    return instance;
                }
                catch (final InvocationTargetException ex4) {
                    throw new RuntimeException(ex4);
                }
                catch (final IllegalAccessException ex5) {
                    throw new RuntimeException(ex5);
                }
                catch (final InstantiationException ex6) {
                    throw new RuntimeException(ex6);
                }
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Class ");
            sb3.append(this.a.getName());
            sb3.append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.");
            throw new DatabaseException(sb3.toString());
        }
        
        public Map<String, Object> j(final T t) {
            if (this.a.isAssignableFrom(t.getClass())) {
                final HashMap hashMap = new HashMap();
                for (final String s : this.e.values()) {
                    Label_0144: {
                        if (this.f.containsKey(s)) {
                            final Method method = this.f.get(s);
                            try {
                                final Object o = method.invoke(t, new Object[0]);
                                break Label_0144;
                            }
                            catch (final InvocationTargetException ex) {
                                throw new RuntimeException(ex);
                            }
                            catch (final IllegalAccessException ex2) {
                                throw new RuntimeException(ex2);
                            }
                        }
                        final Field field = this.h.get(s);
                        if (field == null) {
                            break Label_0144;
                        }
                        try {
                            final Object o = field.get(t);
                            hashMap.put(s, CustomClassMapper.b(o));
                            continue;
                        }
                        catch (final IllegalAccessException ex3) {
                            throw new RuntimeException(ex3);
                        }
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Bean property without field or getter:");
                    sb.append(s);
                    throw new IllegalStateException(sb.toString());
                }
                return hashMap;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't serialize object of class ");
            sb2.append(t.getClass());
            sb2.append(" with BeanMapper for class ");
            sb2.append(this.a);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
