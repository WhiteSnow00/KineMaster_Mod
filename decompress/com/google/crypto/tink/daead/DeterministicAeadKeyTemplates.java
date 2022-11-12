// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.daead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyTemplate;

@Deprecated
public final class DeterministicAeadKeyTemplates
{
    public static final KeyTemplate a;
    
    static {
        a = a(64);
    }
    
    public static KeyTemplate a(final int n) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<AesSivKeyFormat, BuilderType>)AesSivKeyFormat.M().D(n)).p().b()).E(new AesSivKeyManager().c()).D(OutputPrefixType.TINK)).p();
    }
}
