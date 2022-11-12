// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.List;

final class FieldSet<T extends FieldDescriptorLite<T>>
{
    private static final FieldSet d;
    private final m0<T, Object> a;
    private boolean b;
    private boolean c;
    
    static {
        d = new FieldSet(true);
    }
    
    private FieldSet() {
        this.a = m0.q(16);
    }
    
    private FieldSet(final m0<T, Object> a) {
        this.a = a;
        this.s();
    }
    
    private FieldSet(final boolean b) {
        this(m0.q(0));
        this.s();
    }
    
    private static Object c(final Object o) {
        if (o instanceof byte[]) {
            final byte[] array = (byte[])o;
            final byte[] array2 = new byte[array.length];
            System.arraycopy(array, 0, array2, 0, array.length);
            return array2;
        }
        return o;
    }
    
    static int d(final WireFormat.FieldType fieldType, int w, final Object o) {
        final int n = w = CodedOutputStream.W(w);
        if (fieldType == WireFormat.FieldType.GROUP) {
            w = n * 2;
        }
        return w + e(fieldType, o);
    }
    
    static int e(final WireFormat.FieldType fieldType, final Object o) {
        switch (FieldSet$a.b[fieldType.ordinal()]) {
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
            case 18: {
                if (o instanceof Internal.EnumLite) {
                    return CodedOutputStream.m(((Internal.EnumLite)o).getNumber());
                }
                return CodedOutputStream.m((int)o);
            }
            case 17: {
                return CodedOutputStream.T((long)o);
            }
            case 16: {
                return CodedOutputStream.R((int)o);
            }
            case 15: {
                return CodedOutputStream.P((long)o);
            }
            case 14: {
                return CodedOutputStream.N((int)o);
            }
            case 13: {
                return CodedOutputStream.Y((int)o);
            }
            case 12: {
                if (o instanceof ByteString) {
                    return CodedOutputStream.i((ByteString)o);
                }
                return CodedOutputStream.g((byte[])o);
            }
            case 11: {
                if (o instanceof ByteString) {
                    return CodedOutputStream.i((ByteString)o);
                }
                return CodedOutputStream.V((String)o);
            }
            case 10: {
                if (o instanceof LazyField) {
                    return CodedOutputStream.C((LazyFieldLite)o);
                }
                return CodedOutputStream.H((MessageLite)o);
            }
            case 9: {
                return CodedOutputStream.u((MessageLite)o);
            }
            case 8: {
                return CodedOutputStream.f((boolean)o);
            }
            case 7: {
                return CodedOutputStream.o((int)o);
            }
            case 6: {
                return CodedOutputStream.q((long)o);
            }
            case 5: {
                return CodedOutputStream.x((int)o);
            }
            case 4: {
                return CodedOutputStream.a0((long)o);
            }
            case 3: {
                return CodedOutputStream.z((long)o);
            }
            case 2: {
                return CodedOutputStream.s((float)o);
            }
            case 1: {
                return CodedOutputStream.k((double)o);
            }
        }
    }
    
    public static int f(final FieldDescriptorLite<?> fieldDescriptorLite, final Object o) {
        final WireFormat.FieldType b = fieldDescriptorLite.b();
        final int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return d(b, number, o);
        }
        final boolean packed = fieldDescriptorLite.isPacked();
        final int n = 0;
        int n2 = 0;
        if (packed) {
            final Iterator iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                n2 += e(b, iterator.next());
            }
            return CodedOutputStream.W(number) + n2 + CodedOutputStream.L(n2);
        }
        final Iterator iterator2 = ((List)o).iterator();
        int n3 = n;
        while (iterator2.hasNext()) {
            n3 += d(b, number, iterator2.next());
        }
        return n3;
    }
    
    public static <T extends FieldDescriptorLite<T>> FieldSet<T> h() {
        return FieldSet.d;
    }
    
    private int k(final Map.Entry<T, Object> entry) {
        final FieldDescriptorLite<T> fieldDescriptorLite = entry.getKey();
        final LazyField value = entry.getValue();
        if (fieldDescriptorLite.e() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
            return f(fieldDescriptorLite, value);
        }
        if (value instanceof LazyField) {
            return CodedOutputStream.A(entry.getKey().getNumber(), value);
        }
        return CodedOutputStream.E(entry.getKey().getNumber(), (MessageLite)value);
    }
    
    private static <T extends FieldDescriptorLite<T>> boolean p(final Map.Entry<T, Object> entry) {
        final FieldDescriptorLite<T> fieldDescriptorLite = entry.getKey();
        if (fieldDescriptorLite.e() == WireFormat.JavaType.MESSAGE) {
            if (fieldDescriptorLite.isRepeated()) {
                final Iterator iterator = entry.getValue().iterator();
                while (iterator.hasNext()) {
                    if (!((MessageLite)iterator.next()).isInitialized()) {
                        return false;
                    }
                }
            }
            else {
                final List value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite)value).isInitialized()) {
                        return false;
                    }
                }
                else {
                    if (value instanceof LazyField) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }
    
    private static boolean q(final WireFormat.FieldType fieldType, final Object o) {
        Internal.a(o);
        final int n = FieldSet$a.a[fieldType.getJavaType().ordinal()];
        final boolean b = true;
        final boolean b2 = true;
        final boolean b3 = true;
        switch (n) {
            default: {
                return false;
            }
            case 9: {
                boolean b4 = b3;
                if (!(o instanceof MessageLite)) {
                    b4 = (o instanceof LazyField && b3);
                }
                return b4;
            }
            case 8: {
                boolean b5 = b;
                if (!(o instanceof Integer)) {
                    b5 = (o instanceof Internal.EnumLite && b);
                }
                return b5;
            }
            case 7: {
                boolean b6 = b2;
                if (!(o instanceof ByteString)) {
                    b6 = (o instanceof byte[] && b2);
                }
                return b6;
            }
            case 6: {
                return o instanceof String;
            }
            case 5: {
                return o instanceof Boolean;
            }
            case 4: {
                return o instanceof Double;
            }
            case 3: {
                return o instanceof Float;
            }
            case 2: {
                return o instanceof Long;
            }
            case 1: {
                return o instanceof Integer;
            }
        }
    }
    
    private void u(final Map.Entry<T, Object> entry) {
        final FieldDescriptorLite<T> fieldDescriptorLite = entry.getKey();
        Object o;
        final LazyField lazyField = (LazyField)(o = entry.getValue());
        if (lazyField instanceof LazyField) {
            o = lazyField.f();
        }
        if (fieldDescriptorLite.isRepeated()) {
            Object i;
            if ((i = this.i((T)fieldDescriptorLite)) == null) {
                i = new ArrayList<Object>();
            }
            final Iterator iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                ((List<Object>)i).add(c(iterator.next()));
            }
            this.a.r((T)fieldDescriptorLite, i);
        }
        else if (fieldDescriptorLite.e() == WireFormat.JavaType.MESSAGE) {
            final Object j = this.i((T)fieldDescriptorLite);
            if (j == null) {
                this.a.r((T)fieldDescriptorLite, c(o));
            }
            else {
                this.a.r((T)fieldDescriptorLite, fieldDescriptorLite.D(((MessageLite)j).toBuilder(), (MessageLite)o).build());
            }
        }
        else {
            this.a.r((T)fieldDescriptorLite, c(o));
        }
    }
    
    public static <T extends FieldDescriptorLite<T>> FieldSet<T> v() {
        return new FieldSet<T>();
    }
    
    private void x(final WireFormat.FieldType fieldType, final Object o) {
        if (q(fieldType, o)) {
            return;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
    
    public void a(final T t, final Object o) {
        if (t.isRepeated()) {
            this.x(t.b(), o);
            final Object i = this.i(t);
            List list2;
            if (i == null) {
                final ArrayList list = new ArrayList();
                this.a.r(t, list);
                list2 = list;
            }
            else {
                list2 = (List)i;
            }
            list2.add(o);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    
    public FieldSet<T> b() {
        final FieldSet<FieldDescriptorLite> v = v();
        for (int i = 0; i < this.a.k(); ++i) {
            final Map.Entry<T, Object> j = this.a.j(i);
            v.w(j.getKey(), j.getValue());
        }
        for (final Map.Entry<FieldDescriptorLite, V> entry : this.a.m()) {
            v.w(entry.getKey(), entry.getValue());
        }
        v.c = this.c;
        return (FieldSet<T>)v;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof FieldSet && this.a.equals(((FieldSet)o).a));
    }
    
    Iterator<Map.Entry<T, Object>> g() {
        if (this.c) {
            return new LazyField.c<T>(this.a.h().iterator());
        }
        return this.a.h().iterator();
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    public Object i(final T t) {
        Object o2;
        final Object o = o2 = this.a.get(t);
        if (o instanceof LazyField) {
            o2 = ((LazyField)o).f();
        }
        return o2;
    }
    
    public int j() {
        int i = 0;
        int n = 0;
        while (i < this.a.k()) {
            n += this.k(this.a.j(i));
            ++i;
        }
        final Iterator<Map.Entry<T, Object>> iterator = this.a.m().iterator();
        while (iterator.hasNext()) {
            n += this.k((Map.Entry)iterator.next());
        }
        return n;
    }
    
    public int l() {
        int i = 0;
        int n = 0;
        while (i < this.a.k()) {
            final Map.Entry<T, Object> j = this.a.j(i);
            n += f(j.getKey(), j.getValue());
            ++i;
        }
        for (final Map.Entry<FieldDescriptorLite<?>, V> entry : this.a.m()) {
            n += f(entry.getKey(), entry.getValue());
        }
        return n;
    }
    
    boolean m() {
        return this.a.isEmpty();
    }
    
    public boolean n() {
        return this.b;
    }
    
    public boolean o() {
        for (int i = 0; i < this.a.k(); ++i) {
            if (!p(this.a.j(i))) {
                return false;
            }
        }
        final Iterator<Map.Entry<T, Object>> iterator = this.a.m().iterator();
        while (iterator.hasNext()) {
            if (!p((Map.Entry<FieldDescriptorLite, Object>)(Map.Entry)iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public Iterator<Map.Entry<T, Object>> r() {
        if (this.c) {
            return new LazyField.c<T>(this.a.entrySet().iterator());
        }
        return this.a.entrySet().iterator();
    }
    
    public void s() {
        if (this.b) {
            return;
        }
        this.a.p();
        this.b = true;
    }
    
    public void t(final FieldSet<T> set) {
        for (int i = 0; i < set.a.k(); ++i) {
            this.u(set.a.j(i));
        }
        final Iterator<Map.Entry<T, Object>> iterator = set.a.m().iterator();
        while (iterator.hasNext()) {
            this.u((Map.Entry)iterator.next());
        }
    }
    
    public void w(final T t, Object o) {
        if (t.isRepeated()) {
            if (!(o instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            final ArrayList list = new ArrayList();
            list.addAll((Collection)o);
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                this.x(t.b(), iterator.next());
            }
            o = list;
        }
        else {
            this.x(t.b(), o);
        }
        if (o instanceof LazyField) {
            this.c = true;
        }
        this.a.r(t, o);
    }
    
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T>
    {
        MessageLite.Builder D(final MessageLite.Builder p0, final MessageLite p1);
        
        WireFormat.FieldType b();
        
        WireFormat.JavaType e();
        
        int getNumber();
        
        boolean isPacked();
        
        boolean isRepeated();
    }
}
