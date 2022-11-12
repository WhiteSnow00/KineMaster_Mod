// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Objects;
import java.io.IOException;
import java.util.List;

final class c
{
    static int A(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final p p6 = (p)list;
        i = I(array, i, b);
        p6.N0(CodedInputStream.b(b.a));
        while (i < n2) {
            final int j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            i = I(array, j, b);
            p6.N0(CodedInputStream.b(b.a));
        }
        return i;
    }
    
    static int B(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final r r = (r)list;
        i = L(array, i, b);
        r.g(CodedInputStream.c(b.b));
        while (i < n2) {
            final int j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            i = L(array, j, b);
            r.g(CodedInputStream.c(b.b));
        }
        return i;
    }
    
    static int C(final byte[] array, int i, final b b) throws InvalidProtocolBufferException {
        i = I(array, i, b);
        final int a = b.a;
        if (a < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (a == 0) {
            b.c = "";
            return i;
        }
        b.c = new String(array, i, a, Internal.a);
        return i + a;
    }
    
    static int D(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) throws InvalidProtocolBufferException {
        i = I(array, i, b);
        int n3 = b.a;
        if (n3 >= 0) {
            while (true) {
                Label_0060: {
                    if (n3 != 0) {
                        list.add(new String(array, i, n3, Internal.a));
                        break Label_0060;
                    }
                    list.add("");
                    while (i < n2) {
                        final int j = I(array, i, b);
                        if (n != b.a) {
                            break;
                        }
                        i = I(array, j, b);
                        n3 = b.a;
                        if (n3 < 0) {
                            throw InvalidProtocolBufferException.negativeSize();
                        }
                        if (n3 != 0) {
                            list.add(new String(array, i, n3, Internal.a));
                            break Label_0060;
                        }
                        list.add("");
                    }
                    return i;
                }
                i += n3;
                continue;
            }
        }
        throw InvalidProtocolBufferException.negativeSize();
    }
    
    static int E(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) throws InvalidProtocolBufferException {
        final int j = I(array, i, b);
        final int a = b.a;
        if (a >= 0) {
            if (a == 0) {
                list.add("");
                i = j;
            }
            else {
                i = j + a;
                if (!Utf8.t(array, j, i)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                list.add(new String(array, j, a, Internal.a));
            }
            while (i < n2) {
                final int k = I(array, i, b);
                if (n != b.a) {
                    break;
                }
                i = I(array, k, b);
                final int a2 = b.a;
                if (a2 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                if (a2 == 0) {
                    list.add("");
                }
                else {
                    final int n3 = i + a2;
                    if (!Utf8.t(array, i, n3)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    list.add(new String(array, i, a2, Internal.a));
                    i = n3;
                }
            }
            return i;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }
    
    static int F(final byte[] array, int i, final b b) throws InvalidProtocolBufferException {
        i = I(array, i, b);
        final int a = b.a;
        if (a < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (a == 0) {
            b.c = "";
            return i;
        }
        b.c = Utf8.h(array, i, a);
        return i + a;
    }
    
    static int G(final int n, final byte[] array, int n2, int i, final UnknownFieldSetLite unknownFieldSetLite, final b b) throws InvalidProtocolBufferException {
        if (WireFormat.a(n) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        final int b2 = WireFormat.b(n);
        if (b2 == 0) {
            n2 = L(array, n2, b);
            unknownFieldSetLite.n(n, b.b);
            return n2;
        }
        if (b2 == 1) {
            unknownFieldSetLite.n(n, j(array, n2));
            return n2 + 8;
        }
        if (b2 != 2) {
            if (b2 != 3) {
                if (b2 == 5) {
                    unknownFieldSetLite.n(n, h(array, n2));
                    return n2 + 4;
                }
                throw InvalidProtocolBufferException.invalidTag();
            }
            else {
                final UnknownFieldSetLite l = UnknownFieldSetLite.l();
                final int n3 = (n & 0xFFFFFFF8) | 0x4;
                int n4 = 0;
                int j;
                while (true) {
                    j = n2;
                    if (n2 >= i) {
                        break;
                    }
                    j = I(array, n2, b);
                    n2 = b.a;
                    if (n2 == n3) {
                        n4 = n2;
                        break;
                    }
                    final int g = G(n2, array, j, i, l, b);
                    n4 = n2;
                    n2 = g;
                }
                if (j <= i && n4 == n3) {
                    unknownFieldSetLite.n(n, l);
                    return j;
                }
                throw InvalidProtocolBufferException.parseFailure();
            }
        }
        else {
            i = I(array, n2, b);
            n2 = b.a;
            if (n2 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (n2 <= array.length - i) {
                if (n2 == 0) {
                    unknownFieldSetLite.n(n, ByteString.EMPTY);
                }
                else {
                    unknownFieldSetLite.n(n, ByteString.copyFrom(array, i, n2));
                }
                return i + n2;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }
    
    static int H(int n, final byte[] array, int n2, final b b) {
        n &= 0x7F;
        final int n3 = n2 + 1;
        n2 = array[n2];
        if (n2 >= 0) {
            b.a = (n | n2 << 7);
            return n3;
        }
        n2 = (n | (n2 & 0x7F) << 7);
        n = n3 + 1;
        final byte b2 = array[n3];
        if (b2 >= 0) {
            b.a = (n2 | b2 << 14);
            return n;
        }
        final int n4 = n2 | (b2 & 0x7F) << 14;
        n2 = n + 1;
        n = array[n];
        if (n >= 0) {
            b.a = (n4 | n << 21);
            return n2;
        }
        final int n5 = n4 | (n & 0x7F) << 21;
        n = n2 + 1;
        final byte b3 = array[n2];
        if (b3 >= 0) {
            b.a = (n5 | b3 << 28);
            return n;
        }
        while (true) {
            n2 = n + 1;
            if (array[n] >= 0) {
                break;
            }
            n = n2;
        }
        b.a = (n5 | (b3 & 0x7F) << 28);
        return n2;
    }
    
    static int I(final byte[] array, int a, final b b) {
        final int n = a + 1;
        a = array[a];
        if (a >= 0) {
            b.a = a;
            return n;
        }
        return H(a, array, n, b);
    }
    
    static int J(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final p p6 = (p)list;
        i = I(array, i, b);
        p6.N0(b.a);
        while (i < n2) {
            final int j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            i = I(array, j, b);
            p6.N0(b.a);
        }
        return i;
    }
    
    static int K(long b, final byte[] array, int n, final b b2) {
        int n2;
        byte b3;
        for (n2 = n + 1, b3 = array[n], b = ((b & 0x7FL) | (long)(b3 & 0x7F) << 7), n = 7; b3 < 0; b3 = array[n2], n += 7, b |= (long)(b3 & 0x7F) << n, ++n2) {}
        b2.b = b;
        return n2;
    }
    
    static int L(final byte[] array, final int n, final b b) {
        final int n2 = n + 1;
        final long b2 = array[n];
        if (b2 >= 0L) {
            b.b = b2;
            return n2;
        }
        return K(b2, array, n2, b);
    }
    
    static int M(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final r r = (r)list;
        i = L(array, i, b);
        r.g(b.b);
        while (i < n2) {
            final int j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            i = L(array, j, b);
            r.g(b.b);
        }
        return i;
    }
    
    static int N(int a, final byte[] array, int n, final int n2, final b b) throws InvalidProtocolBufferException {
        if (WireFormat.a(a) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        final int b2 = WireFormat.b(a);
        if (b2 == 0) {
            return L(array, n, b);
        }
        if (b2 == 1) {
            return n + 8;
        }
        if (b2 == 2) {
            return I(array, n, b) + b.a;
        }
        if (b2 != 3) {
            if (b2 == 5) {
                return n + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        else {
            final int n3 = (a & 0xFFFFFFF8) | 0x4;
            a = 0;
            int i;
            while (true) {
                i = n;
                if (n >= n2) {
                    break;
                }
                i = I(array, n, b);
                a = b.a;
                if (a == n3) {
                    break;
                }
                n = N(a, array, i, n2, b);
            }
            if (i <= n2 && a == n3) {
                return i;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }
    }
    
    static int a(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final e e = (e)list;
        i = L(array, i, b);
        e.g(b.b != 0L);
        while (i < n2) {
            final int j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            i = L(array, j, b);
            e.g(b.b != 0L);
        }
        return i;
    }
    
    static int b(final byte[] array, int i, final b b) throws InvalidProtocolBufferException {
        i = I(array, i, b);
        final int a = b.a;
        if (a < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (a > array.length - i) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (a == 0) {
            b.c = ByteString.EMPTY;
            return i;
        }
        b.c = ByteString.copyFrom(array, i, a);
        return i + a;
    }
    
    static int c(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) throws InvalidProtocolBufferException {
        i = I(array, i, b);
        int n3 = b.a;
        if (n3 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (n3 <= array.length - i) {
            while (true) {
                Label_0063: {
                    if (n3 != 0) {
                        list.add(ByteString.copyFrom(array, i, n3));
                        break Label_0063;
                    }
                    list.add(ByteString.EMPTY);
                    while (i < n2) {
                        final int j = I(array, i, b);
                        if (n != b.a) {
                            break;
                        }
                        i = I(array, j, b);
                        n3 = b.a;
                        if (n3 < 0) {
                            throw InvalidProtocolBufferException.negativeSize();
                        }
                        if (n3 > array.length - i) {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                        if (n3 != 0) {
                            list.add(ByteString.copyFrom(array, i, n3));
                            break Label_0063;
                        }
                        list.add(ByteString.EMPTY);
                    }
                    return i;
                }
                i += n3;
                continue;
            }
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static double d(final byte[] array, final int n) {
        return Double.longBitsToDouble(j(array, n));
    }
    
    static int e(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final i j = (i)list;
        j.f(d(array, i));
        int k;
        for (i += 8; i < n2; i = k + 8) {
            k = I(array, i, b);
            if (n != b.a) {
                break;
            }
            j.f(d(array, k));
        }
        return i;
    }
    
    static int f(int n, final byte[] array, int n2, final int n3, final GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, final GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, final o0<UnknownFieldSetLite, UnknownFieldSetLite> o0, final b b) throws IOException {
        final FieldSet<GeneratedMessageLite.a> extensions = extendableMessage.extensions;
        final int n4 = n >>> 3;
        final boolean repeated = generatedExtension.b.isRepeated();
        final Integer n5 = null;
        final UnknownFieldSetLite unknownFieldSetLite = null;
        if (repeated && generatedExtension.b.isPacked()) {
            switch (c$a.a[generatedExtension.a().ordinal()]) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Type cannot be packed: ");
                    sb.append(generatedExtension.b.b());
                    throw new IllegalStateException(sb.toString());
                }
                case 14: {
                    final p p8 = new p();
                    n = y(array, n2, p8, b);
                    UnknownFieldSetLite unknownFields = extendableMessage.unknownFields;
                    if (unknownFields == UnknownFieldSetLite.e()) {
                        unknownFields = unknownFieldSetLite;
                    }
                    final UnknownFieldSetLite unknownFields2 = l0.z(n4, p8, generatedExtension.b.c(), unknownFields, (o0<Object, UnknownFieldSetLite>)o0);
                    if (unknownFields2 != null) {
                        extendableMessage.unknownFields = unknownFields2;
                    }
                    extensions.w(generatedExtension.b, p8);
                    break;
                }
                case 13: {
                    final r r = new r();
                    n = x(array, n2, r, b);
                    extensions.w(generatedExtension.b, r);
                    break;
                }
                case 12: {
                    final p p9 = new p();
                    n = w(array, n2, p9, b);
                    extensions.w(generatedExtension.b, p9);
                    break;
                }
                case 11: {
                    final e e = new e();
                    n = r(array, n2, e, b);
                    extensions.w(generatedExtension.b, e);
                    break;
                }
                case 9:
                case 10: {
                    final p p10 = new p();
                    n = t(array, n2, p10, b);
                    extensions.w(generatedExtension.b, p10);
                    break;
                }
                case 7:
                case 8: {
                    final r r2 = new r();
                    n = u(array, n2, r2, b);
                    extensions.w(generatedExtension.b, r2);
                    break;
                }
                case 5:
                case 6: {
                    final p p11 = new p();
                    n = y(array, n2, p11, b);
                    extensions.w(generatedExtension.b, p11);
                    break;
                }
                case 3:
                case 4: {
                    final r r3 = new r();
                    n = z(array, n2, r3, b);
                    extensions.w(generatedExtension.b, r3);
                    break;
                }
                case 2: {
                    final n n6 = new n();
                    n = v(array, n2, n6, b);
                    extensions.w(generatedExtension.b, n6);
                    break;
                }
                case 1: {
                    final i i = new i();
                    n = s(array, n2, i, b);
                    extensions.w(generatedExtension.b, i);
                    break;
                }
            }
        }
        else {
            Object o2 = null;
            Label_1046: {
                if (generatedExtension.a() == WireFormat.FieldType.ENUM) {
                    n2 = I(array, n2, b);
                    if (generatedExtension.b.c().a(b.a) == null) {
                        UnknownFieldSetLite unknownFields3;
                        if ((unknownFields3 = extendableMessage.unknownFields) == UnknownFieldSetLite.e()) {
                            unknownFields3 = UnknownFieldSetLite.l();
                            extendableMessage.unknownFields = unknownFields3;
                        }
                        l0.L(n4, b.a, unknownFields3, (o0<UT, UnknownFieldSetLite>)o0);
                        return n2;
                    }
                    o2 = b.a;
                }
                else {
                    Label_1043: {
                        switch (c$a.a[generatedExtension.a().ordinal()]) {
                            default: {
                                o2 = n5;
                                break Label_1046;
                            }
                            case 18: {
                                n2 = p(f0.a().d(generatedExtension.b().getClass()), array, n2, n3, b);
                                o2 = b.c;
                                break Label_1046;
                            }
                            case 17: {
                                n2 = n(f0.a().d(generatedExtension.b().getClass()), array, n2, n3, n4 << 3 | 0x4, b);
                                o2 = b.c;
                                break Label_1046;
                            }
                            case 16: {
                                n2 = C(array, n2, b);
                                o2 = b.c;
                                break Label_1046;
                            }
                            case 15: {
                                n2 = b(array, n2, b);
                                o2 = b.c;
                                break Label_1046;
                            }
                            case 14: {
                                throw new IllegalStateException("Shouldn't reach here.");
                            }
                            case 13: {
                                n2 = L(array, n2, b);
                                o2 = CodedInputStream.c(b.b);
                                break Label_1046;
                            }
                            case 12: {
                                n2 = I(array, n2, b);
                                o2 = CodedInputStream.b(b.a);
                                break Label_1046;
                            }
                            case 11: {
                                n2 = L(array, n2, b);
                                o2 = (b.b != 0L);
                                break Label_1046;
                            }
                            case 9:
                            case 10: {
                                o2 = h(array, n2);
                                break;
                            }
                            case 7:
                            case 8: {
                                o2 = j(array, n2);
                                break Label_1043;
                            }
                            case 5:
                            case 6: {
                                n2 = I(array, n2, b);
                                o2 = b.a;
                                break Label_1046;
                            }
                            case 3:
                            case 4: {
                                n2 = L(array, n2, b);
                                o2 = b.b;
                                break Label_1046;
                            }
                            case 2: {
                                o2 = l(array, n2);
                                break;
                            }
                            case 1: {
                                o2 = d(array, n2);
                                break Label_1043;
                            }
                        }
                        n2 += 4;
                        break Label_1046;
                    }
                    n2 += 8;
                }
            }
            if (generatedExtension.d()) {
                extensions.a(generatedExtension.b, o2);
            }
            else {
                n = c$a.a[generatedExtension.a().ordinal()];
                Object h;
                if (n != 17 && n != 18) {
                    h = o2;
                }
                else {
                    final Object j = extensions.i(generatedExtension.b);
                    h = o2;
                    if (j != null) {
                        h = Internal.h(j, o2);
                    }
                }
                extensions.w(generatedExtension.b, h);
            }
            n = n2;
        }
        return n;
    }
    
    static int g(final int n, final byte[] array, final int n2, final int n3, final Object o, final MessageLite messageLite, final o0<UnknownFieldSetLite, UnknownFieldSetLite> o2, final b b) throws IOException {
        final GeneratedMessageLite.GeneratedExtension<MessageLite, ?> a = b.d.a(messageLite, n >>> 3);
        if (a == null) {
            return G(n, array, n2, n3, z.v(o), b);
        }
        final GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage)o;
        extendableMessage.J();
        return f(n, array, n2, n3, extendableMessage, a, o2, b);
    }
    
    static int h(final byte[] array, final int n) {
        return (array[n + 3] & 0xFF) << 24 | ((array[n] & 0xFF) | (array[n + 1] & 0xFF) << 8 | (array[n + 2] & 0xFF) << 16);
    }
    
    static int i(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final p p6 = (p)list;
        p6.N0(h(array, i));
        int j;
        for (i += 4; i < n2; i = j + 4) {
            j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            p6.N0(h(array, j));
        }
        return i;
    }
    
    static long j(final byte[] array, final int n) {
        return ((long)array[n + 7] & 0xFFL) << 56 | (((long)array[n] & 0xFFL) | ((long)array[n + 1] & 0xFFL) << 8 | ((long)array[n + 2] & 0xFFL) << 16 | ((long)array[n + 3] & 0xFFL) << 24 | ((long)array[n + 4] & 0xFFL) << 32 | ((long)array[n + 5] & 0xFFL) << 40 | ((long)array[n + 6] & 0xFFL) << 48);
    }
    
    static int k(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final r r = (r)list;
        r.g(j(array, i));
        int j;
        for (i += 8; i < n2; i = j + 8) {
            j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            r.g(j(array, j));
        }
        return i;
    }
    
    static float l(final byte[] array, final int n) {
        return Float.intBitsToFloat(h(array, n));
    }
    
    static int m(final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) {
        final n n3 = (n)list;
        n3.f(l(array, i));
        int j;
        for (i += 4; i < n2; i = j + 4) {
            j = I(array, i, b);
            if (n != b.a) {
                break;
            }
            n3.f(l(array, j));
        }
        return i;
    }
    
    static int n(final j0 j0, final byte[] array, int c0, final int n, final int n2, final b b) throws IOException {
        final z z = (z)j0;
        final Object e = z.e();
        c0 = z.c0(e, array, c0, n, n2, b);
        z.b(e);
        b.c = e;
        return c0;
    }
    
    static int o(final j0 j0, final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final int n3 = (n & 0xFFFFFFF8) | 0x4;
        i = n(j0, array, i, n2, n3, b);
        list.add(b.c);
        while (i < n2) {
            final int k = I(array, i, b);
            if (n != b.a) {
                break;
            }
            i = n(j0, array, k, n2, n3, b);
            list.add(b.c);
        }
        return i;
    }
    
    static int p(final j0 j0, final byte[] array, int h, int n, final b b) throws IOException {
        final int n2 = h + 1;
        final byte b2 = array[h];
        h = n2;
        int a = b2;
        if (b2 < 0) {
            h = H(b2, array, n2, b);
            a = b.a;
        }
        if (a >= 0 && a <= n - h) {
            final Object e = j0.e();
            n = a + h;
            j0.h(e, array, h, n, b);
            j0.b(e);
            b.c = e;
            return n;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int q(final j0<?> j0, final int n, final byte[] array, int i, final int n2, final Internal.ProtobufList<?> list, final b b) throws IOException {
        i = p(j0, array, i, n2, b);
        list.add(b.c);
        while (i < n2) {
            final int k = I(array, i, b);
            if (n != b.a) {
                break;
            }
            i = p(j0, array, k, n2, b);
            list.add(b.c);
        }
        return i;
    }
    
    static int r(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final e e = (e)list;
        i = I(array, i, b);
        final int n = b.a + i;
        while (i < n) {
            i = L(array, i, b);
            e.g(b.b != 0L);
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int s(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final i j = (i)list;
        int n;
        for (i = I(array, i, b), n = b.a + i; i < n; i += 8) {
            j.f(d(array, i));
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int t(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final p p4 = (p)list;
        int n;
        for (i = I(array, i, b), n = b.a + i; i < n; i += 4) {
            p4.N0(h(array, i));
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int u(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final r r = (r)list;
        int n;
        for (i = I(array, i, b), n = b.a + i; i < n; i += 8) {
            r.g(j(array, i));
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int v(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final n n = (n)list;
        int n2;
        for (i = I(array, i, b), n2 = b.a + i; i < n2; i += 4) {
            n.f(l(array, i));
        }
        if (i == n2) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int w(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final p p4 = (p)list;
        i = I(array, i, b);
        final int n = b.a + i;
        while (i < n) {
            i = I(array, i, b);
            p4.N0(CodedInputStream.b(b.a));
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int x(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final r r = (r)list;
        i = I(array, i, b);
        final int n = b.a + i;
        while (i < n) {
            i = L(array, i, b);
            r.g(CodedInputStream.c(b.b));
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int y(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final p p4 = (p)list;
        i = I(array, i, b);
        final int n = b.a + i;
        while (i < n) {
            i = I(array, i, b);
            p4.N0(b.a);
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static int z(final byte[] array, int i, final Internal.ProtobufList<?> list, final b b) throws IOException {
        final r r = (r)list;
        i = I(array, i, b);
        final int n = b.a + i;
        while (i < n) {
            i = L(array, i, b);
            r.g(b.b);
        }
        if (i == n) {
            return i;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    static final class b
    {
        public int a;
        public long b;
        public Object c;
        public final ExtensionRegistryLite d;
        
        b(final ExtensionRegistryLite d) {
            Objects.requireNonNull(d);
            this.d = d;
        }
    }
}
