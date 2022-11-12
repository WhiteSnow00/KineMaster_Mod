// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

final class l extends k<GeneratedMessageLite.a>
{
    @Override
    int a(final Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.a)entry.getKey()).getNumber();
    }
    
    @Override
    Object b(final ExtensionRegistryLite extensionRegistryLite, final MessageLite messageLite, final int n) {
        return extensionRegistryLite.a(messageLite, n);
    }
    
    @Override
    FieldSet<GeneratedMessageLite.a> c(final Object o) {
        return ((GeneratedMessageLite.ExtendableMessage)o).extensions;
    }
    
    @Override
    FieldSet<GeneratedMessageLite.a> d(final Object o) {
        return ((GeneratedMessageLite.ExtendableMessage)o).J();
    }
    
    @Override
    boolean e(final MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }
    
    @Override
    void f(final Object o) {
        this.c(o).s();
    }
    
    @Override
     <UT, UB> UB g(final i0 i0, Object h, final ExtensionRegistryLite extensionRegistryLite, final FieldSet<GeneratedMessageLite.a> set, UB z, final o0<UT, UB> o0) throws IOException {
        final GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension)h;
        final int c = generatedExtension.c();
        if (generatedExtension.b.isRepeated() && generatedExtension.b.isPacked()) {
            ArrayList list2 = null;
            switch (l$a.a[generatedExtension.a().ordinal()]) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Type cannot be packed: ");
                    sb.append(generatedExtension.b.b());
                    throw new IllegalStateException(sb.toString());
                }
                case 14: {
                    final ArrayList list = new ArrayList();
                    i0.i(list);
                    z = l0.z(c, list, generatedExtension.b.c(), z, o0);
                    list2 = list;
                    break;
                }
                case 13: {
                    final ArrayList list3 = new ArrayList();
                    i0.c(list3);
                    list2 = list3;
                    break;
                }
                case 12: {
                    final ArrayList list4 = new ArrayList();
                    i0.q(list4);
                    list2 = list4;
                    break;
                }
                case 11: {
                    final ArrayList list5 = new ArrayList();
                    i0.u(list5);
                    list2 = list5;
                    break;
                }
                case 10: {
                    final ArrayList list6 = new ArrayList();
                    i0.b(list6);
                    list2 = list6;
                    break;
                }
                case 9: {
                    final ArrayList list7 = new ArrayList();
                    i0.s(list7);
                    list2 = list7;
                    break;
                }
                case 8: {
                    final ArrayList list8 = new ArrayList();
                    i0.l(list8);
                    list2 = list8;
                    break;
                }
                case 7: {
                    final ArrayList list9 = new ArrayList();
                    i0.w(list9);
                    list2 = list9;
                    break;
                }
                case 6: {
                    final ArrayList list10 = new ArrayList();
                    i0.p(list10);
                    list2 = list10;
                    break;
                }
                case 5: {
                    final ArrayList list11 = new ArrayList();
                    i0.v(list11);
                    list2 = list11;
                    break;
                }
                case 4: {
                    final ArrayList list12 = new ArrayList();
                    i0.f(list12);
                    list2 = list12;
                    break;
                }
                case 3: {
                    final ArrayList list13 = new ArrayList();
                    i0.h(list13);
                    list2 = list13;
                    break;
                }
                case 2: {
                    final ArrayList list14 = new ArrayList();
                    i0.B(list14);
                    list2 = list14;
                    break;
                }
                case 1: {
                    final ArrayList list15 = new ArrayList();
                    i0.F(list15);
                    list2 = list15;
                    break;
                }
            }
            set.w(generatedExtension.b, list2);
        }
        else {
            final Integer n = null;
            Serializable s = null;
            if (generatedExtension.a() == WireFormat.FieldType.ENUM) {
                final int o2 = i0.o();
                if (generatedExtension.b.c().a(o2) == null) {
                    return l0.L(c, o2, z, (o0<UT, UB>)o0);
                }
                s = o2;
            }
            else {
                switch (l$a.a[generatedExtension.a().ordinal()]) {
                    default: {
                        s = n;
                        break;
                    }
                    case 18: {
                        s = i0.N((Class<Integer>)generatedExtension.b().getClass(), extensionRegistryLite);
                        break;
                    }
                    case 17: {
                        s = i0.J((Class<Integer>)generatedExtension.b().getClass(), extensionRegistryLite);
                        break;
                    }
                    case 16: {
                        s = i0.y();
                        break;
                    }
                    case 15: {
                        s = i0.n();
                        break;
                    }
                    case 14: {
                        throw new IllegalStateException("Shouldn't reach here.");
                    }
                    case 13: {
                        s = i0.x();
                        break;
                    }
                    case 12: {
                        s = i0.k();
                        break;
                    }
                    case 11: {
                        s = i0.e();
                        break;
                    }
                    case 10: {
                        s = i0.D();
                        break;
                    }
                    case 9: {
                        s = i0.g();
                        break;
                    }
                    case 8: {
                        s = i0.d();
                        break;
                    }
                    case 7: {
                        s = i0.t();
                        break;
                    }
                    case 6: {
                        s = i0.a();
                        break;
                    }
                    case 5: {
                        s = i0.o();
                        break;
                    }
                    case 4: {
                        s = i0.r();
                        break;
                    }
                    case 3: {
                        s = i0.G();
                        break;
                    }
                    case 2: {
                        s = i0.readFloat();
                        break;
                    }
                    case 1: {
                        s = i0.readDouble();
                        break;
                    }
                }
            }
            if (generatedExtension.d()) {
                set.a(generatedExtension.b, s);
            }
            else {
                final int n2 = l$a.a[generatedExtension.a().ordinal()];
                if (n2 != 17 && n2 != 18) {
                    h = s;
                }
                else {
                    final Object j = set.i(generatedExtension.b);
                    h = s;
                    if (j != null) {
                        h = Internal.h(j, s);
                    }
                }
                set.w(generatedExtension.b, h);
            }
        }
        return z;
    }
    
    @Override
    void h(final i0 i0, final Object o, final ExtensionRegistryLite extensionRegistryLite, final FieldSet<GeneratedMessageLite.a> set) throws IOException {
        final GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension)o;
        set.w(generatedExtension.b, i0.N((Class<Object>)generatedExtension.b().getClass(), extensionRegistryLite));
    }
    
    @Override
    void i(final ByteString byteString, final Object o, final ExtensionRegistryLite extensionRegistryLite, final FieldSet<GeneratedMessageLite.a> set) throws IOException {
        final GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension)o;
        final MessageLite k = generatedExtension.b().newBuilderForType().k();
        final d p4 = d.P(ByteBuffer.wrap(byteString.toByteArray()), true);
        f0.a().b(k, p4, extensionRegistryLite);
        set.w(generatedExtension.b, k);
        if (p4.z() == Integer.MAX_VALUE) {
            return;
        }
        throw InvalidProtocolBufferException.invalidEndTag();
    }
    
    @Override
    void j(final Writer writer, final Map.Entry<?, ?> entry) throws IOException {
        final GeneratedMessageLite.a a = (GeneratedMessageLite.a)entry.getKey();
        if (a.isRepeated()) {
            switch (l$a.a[a.b().ordinal()]) {
                case 18: {
                    final List list = (List)entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        l0.X(a.getNumber(), (List<?>)entry.getValue(), writer, f0.a().d(list.get(0).getClass()));
                        break;
                    }
                    break;
                }
                case 17: {
                    final List list2 = (List)entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        l0.U(a.getNumber(), (List<?>)entry.getValue(), writer, f0.a().d(list2.get(0).getClass()));
                        break;
                    }
                    break;
                }
                case 16: {
                    l0.c0(a.getNumber(), (List<String>)entry.getValue(), writer);
                    break;
                }
                case 15: {
                    l0.O(a.getNumber(), (List<ByteString>)entry.getValue(), writer);
                    break;
                }
                case 14: {
                    l0.V(a.getNumber(), (List<Integer>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 13: {
                    l0.b0(a.getNumber(), (List<Long>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 12: {
                    l0.a0(a.getNumber(), (List<Integer>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 11: {
                    l0.Z(a.getNumber(), (List<Long>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 10: {
                    l0.Y(a.getNumber(), (List<Integer>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 9: {
                    l0.d0(a.getNumber(), (List<Integer>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 8: {
                    l0.N(a.getNumber(), (List<Boolean>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 7: {
                    l0.R(a.getNumber(), (List<Integer>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 6: {
                    l0.S(a.getNumber(), (List<Long>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 5: {
                    l0.V(a.getNumber(), (List<Integer>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 4: {
                    l0.e0(a.getNumber(), (List<Long>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 3: {
                    l0.W(a.getNumber(), (List<Long>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 2: {
                    l0.T(a.getNumber(), (List<Float>)entry.getValue(), writer, a.isPacked());
                    break;
                }
                case 1: {
                    l0.P(a.getNumber(), (List<Double>)entry.getValue(), writer, a.isPacked());
                    break;
                }
            }
        }
        else {
            switch (l$a.a[a.b().ordinal()]) {
                case 18: {
                    writer.N(a.getNumber(), entry.getValue(), f0.a().d(entry.getValue().getClass()));
                    break;
                }
                case 17: {
                    writer.K(a.getNumber(), entry.getValue(), f0.a().d(entry.getValue().getClass()));
                    break;
                }
                case 16: {
                    writer.e(a.getNumber(), (String)entry.getValue());
                    break;
                }
                case 15: {
                    writer.M(a.getNumber(), (ByteString)entry.getValue());
                    break;
                }
                case 14: {
                    writer.h(a.getNumber(), (int)entry.getValue());
                    break;
                }
                case 13: {
                    writer.m(a.getNumber(), (long)entry.getValue());
                    break;
                }
                case 12: {
                    writer.H(a.getNumber(), (int)entry.getValue());
                    break;
                }
                case 11: {
                    writer.i(a.getNumber(), (long)entry.getValue());
                    break;
                }
                case 10: {
                    writer.w(a.getNumber(), (int)entry.getValue());
                    break;
                }
                case 9: {
                    writer.o(a.getNumber(), (int)entry.getValue());
                    break;
                }
                case 8: {
                    writer.v(a.getNumber(), (boolean)entry.getValue());
                    break;
                }
                case 7: {
                    writer.c(a.getNumber(), (int)entry.getValue());
                    break;
                }
                case 6: {
                    writer.s(a.getNumber(), (long)entry.getValue());
                    break;
                }
                case 5: {
                    writer.h(a.getNumber(), (int)entry.getValue());
                    break;
                }
                case 4: {
                    writer.f(a.getNumber(), (long)entry.getValue());
                    break;
                }
                case 3: {
                    writer.u(a.getNumber(), (long)entry.getValue());
                    break;
                }
                case 2: {
                    writer.B(a.getNumber(), (float)entry.getValue());
                    break;
                }
                case 1: {
                    writer.p(a.getNumber(), (double)entry.getValue());
                    break;
                }
            }
        }
    }
}
