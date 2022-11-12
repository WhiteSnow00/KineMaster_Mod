// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.errorprone.annotations.Immutable;

@Immutable
public final class KeyTemplate
{
    private final com.google.crypto.tink.proto.KeyTemplate a;
    
    private KeyTemplate(final com.google.crypto.tink.proto.KeyTemplate a) {
        this.a = a;
    }
    
    public static KeyTemplate a(final String s, final byte[] array, final OutputPrefixType outputPrefixType) {
        return new KeyTemplate(((GeneratedMessageLite.Builder<com.google.crypto.tink.proto.KeyTemplate, BuilderType>)com.google.crypto.tink.proto.KeyTemplate.R().E(s).F(ByteString.copyFrom(array)).D(c(outputPrefixType))).p());
    }
    
    private static com.google.crypto.tink.proto.OutputPrefixType c(final OutputPrefixType outputPrefixType) {
        final int n = KeyTemplate$a.b[outputPrefixType.ordinal()];
        if (n == 1) {
            return com.google.crypto.tink.proto.OutputPrefixType.TINK;
        }
        if (n == 2) {
            return com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
        }
        if (n == 3) {
            return com.google.crypto.tink.proto.OutputPrefixType.RAW;
        }
        if (n == 4) {
            return com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }
    
    com.google.crypto.tink.proto.KeyTemplate b() {
        return this.a;
    }
    
    public enum OutputPrefixType
    {
        private static final OutputPrefixType[] $VALUES;
        
        CRUNCHY, 
        LEGACY, 
        RAW, 
        TINK;
    }
}
