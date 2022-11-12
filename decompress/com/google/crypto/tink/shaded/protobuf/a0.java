// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;
import java.io.IOException;

final class a0<T> implements j0<T>
{
    private final MessageLite a;
    private final o0<?, ?> b;
    private final boolean c;
    private final k<?> d;
    
    private a0(final o0<?, ?> b, final k<?> d, final MessageLite a) {
        this.b = b;
        this.c = d.e(a);
        this.d = d;
        this.a = a;
    }
    
    private <UT, UB> int k(final o0<UT, UB> o0, final T t) {
        return o0.i(o0.g(t));
    }
    
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void l(final o0<UT, UB> o0, final k<ET> k, final T t, final i0 i0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        final UB f = o0.f(t);
        final FieldSet<ET> d = k.d(t);
        try {
            while (i0.z() != Integer.MAX_VALUE) {
                if (this.n(i0, extensionRegistryLite, k, d, (o0<UT, Object>)o0, f)) {
                    continue;
                }
            }
        }
        finally {
            o0.o((Object)t, f);
        }
    }
    
    static <T> a0<T> m(final o0<?, ?> o0, final k<?> k, final MessageLite messageLite) {
        return new a0<T>(o0, k, messageLite);
    }
    
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean n(final i0 i0, final ExtensionRegistryLite extensionRegistryLite, final k<ET> k, final FieldSet<ET> set, final o0<UT, UB> o0, final UB ub) throws IOException {
        final int tag = i0.getTag();
        if (tag == WireFormat.a) {
            int g = 0;
            Object b = null;
            ByteString n = null;
            while (true) {
                while (i0.z() != Integer.MAX_VALUE) {
                    final int tag2 = i0.getTag();
                    if (tag2 == WireFormat.c) {
                        g = i0.g();
                        b = k.b(extensionRegistryLite, this.a, g);
                    }
                    else if (tag2 == WireFormat.d) {
                        if (b != null) {
                            k.h(i0, b, extensionRegistryLite, set);
                        }
                        else {
                            n = i0.n();
                        }
                    }
                    else {
                        if (i0.C()) {
                            continue;
                        }
                        if (i0.getTag() == WireFormat.b) {
                            if (n != null) {
                                if (b != null) {
                                    k.i(n, b, extensionRegistryLite, set);
                                }
                                else {
                                    o0.d(ub, g, n);
                                }
                            }
                            return true;
                        }
                        throw InvalidProtocolBufferException.invalidEndTag();
                    }
                }
                continue;
            }
        }
        if (WireFormat.b(tag) != 2) {
            return i0.C();
        }
        final Object b2 = k.b(extensionRegistryLite, this.a, WireFormat.a(tag));
        if (b2 != null) {
            k.h(i0, b2, extensionRegistryLite, set);
            return true;
        }
        return o0.m(ub, i0);
    }
    
    private <UT, UB> void o(final o0<UT, UB> o0, final T t, final Writer writer) throws IOException {
        o0.s(o0.g(t), writer);
    }
    
    @Override
    public void a(final T t, final T t2) {
        l0.G(this.b, t, t2);
        if (this.c) {
            l0.E(this.d, t, t2);
        }
    }
    
    @Override
    public void b(final T t) {
        this.b.j(t);
        this.d.f(t);
    }
    
    @Override
    public final boolean c(final T t) {
        return this.d.c(t).o();
    }
    
    @Override
    public int d(final T t) {
        int n = this.k(this.b, t) + 0;
        if (this.c) {
            n += this.d.c(t).j();
        }
        return n;
    }
    
    @Override
    public T e() {
        return (T)this.a.newBuilderForType().k();
    }
    
    @Override
    public int f(final T t) {
        int hashCode = this.b.g(t).hashCode();
        if (this.c) {
            hashCode = hashCode * 53 + this.d.c(t).hashCode();
        }
        return hashCode;
    }
    
    @Override
    public boolean g(final T t, final T t2) {
        return this.b.g(t).equals(this.b.g(t2)) && (!this.c || this.d.c(t).equals(this.d.c(t2)));
    }
    
    @Override
    public void h(final T t, final byte[] array, int i, final int n, final c.b b) throws IOException {
        final GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)t;
        UnknownFieldSetLite unknownFields;
        if ((unknownFields = generatedMessageLite.unknownFields) == UnknownFieldSetLite.e()) {
            unknownFields = UnknownFieldSetLite.l();
            generatedMessageLite.unknownFields = unknownFields;
        }
        final FieldSet j = ((GeneratedMessageLite.ExtendableMessage)t).J();
        GeneratedMessageLite.GeneratedExtension generatedExtension = null;
        while (i < n) {
            i = com.google.crypto.tink.shaded.protobuf.c.I(array, i, b);
            final int a = b.a;
            if (a != WireFormat.a) {
                if (WireFormat.b(a) == 2) {
                    generatedExtension = (GeneratedMessageLite.GeneratedExtension)this.d.b(b.d, this.a, WireFormat.a(a));
                    if (generatedExtension != null) {
                        i = com.google.crypto.tink.shaded.protobuf.c.p(f0.a().d(generatedExtension.b().getClass()), array, i, n, b);
                        j.w((FieldSet.FieldDescriptorLite)generatedExtension.b, b.c);
                    }
                    else {
                        i = com.google.crypto.tink.shaded.protobuf.c.G(a, array, i, n, unknownFields, b);
                    }
                }
                else {
                    i = com.google.crypto.tink.shaded.protobuf.c.N(a, array, i, n, b);
                }
            }
            else {
                int a2 = 0;
                Object o = null;
                int k;
                while (true) {
                    k = i;
                    if (i >= n) {
                        break;
                    }
                    k = com.google.crypto.tink.shaded.protobuf.c.I(array, i, b);
                    i = b.a;
                    final int a3 = WireFormat.a(i);
                    final int b2 = WireFormat.b(i);
                    if (a3 != 2) {
                        if (a3 == 3) {
                            if (generatedExtension != null) {
                                i = com.google.crypto.tink.shaded.protobuf.c.p(f0.a().d(generatedExtension.b().getClass()), array, k, n, b);
                                j.w((FieldSet.FieldDescriptorLite)generatedExtension.b, b.c);
                                continue;
                            }
                            if (b2 == 2) {
                                i = com.google.crypto.tink.shaded.protobuf.c.b(array, k, b);
                                o = b.c;
                                continue;
                            }
                        }
                    }
                    else if (b2 == 0) {
                        i = com.google.crypto.tink.shaded.protobuf.c.I(array, k, b);
                        a2 = b.a;
                        generatedExtension = (GeneratedMessageLite.GeneratedExtension)this.d.b(b.d, this.a, a2);
                        continue;
                    }
                    if (i == WireFormat.b) {
                        break;
                    }
                    i = com.google.crypto.tink.shaded.protobuf.c.N(i, array, k, n, b);
                }
                if (o != null) {
                    unknownFields.n(WireFormat.c(a2, 2), o);
                }
                i = k;
            }
        }
        if (i == n) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }
    
    @Override
    public void i(final T t, final i0 i0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        this.l(this.b, this.d, t, i0, extensionRegistryLite);
    }
    
    @Override
    public void j(final T t, final Writer writer) throws IOException {
        final Iterator<Map.Entry<?, Object>> r = this.d.c(t).r();
        while (r.hasNext()) {
            final Map.Entry entry = (Map.Entry)r.next();
            final FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite)entry.getKey();
            if (fieldDescriptorLite.e() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof LazyField.b) {
                writer.b(fieldDescriptorLite.getNumber(), ((LazyField.b)entry).a().e());
            }
            else {
                writer.b(fieldDescriptorLite.getNumber(), entry.getValue());
            }
        }
        this.o(this.b, t, writer);
    }
}
