// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class h0 implements w
{
    private final MessageLite a;
    private final String b;
    private final Object[] c;
    private final int d;
    
    h0(final MessageLite a, final String b, final Object[] c) {
        this.a = a;
        this.b = b;
        this.c = c;
        final char char1 = b.charAt(0);
        if (char1 < '\ud800') {
            this.d = char1;
        }
        else {
            int n = char1 & '\u1fff';
            int n2 = 13;
            int n3 = 1;
            char char2;
            while (true) {
                char2 = b.charAt(n3);
                if (char2 < '\ud800') {
                    break;
                }
                n |= (char2 & '\u1fff') << n2;
                n2 += 13;
                ++n3;
            }
            this.d = (n | char2 << n2);
        }
    }
    
    @Override
    public boolean a() {
        return (this.d & 0x2) == 0x2;
    }
    
    @Override
    public MessageLite b() {
        return this.a;
    }
    
    @Override
    public ProtoSyntax c() {
        ProtoSyntax protoSyntax;
        if ((this.d & 0x1) == 0x1) {
            protoSyntax = ProtoSyntax.PROTO2;
        }
        else {
            protoSyntax = ProtoSyntax.PROTO3;
        }
        return protoSyntax;
    }
    
    Object[] d() {
        return this.c;
    }
    
    String e() {
        return this.b;
    }
}
