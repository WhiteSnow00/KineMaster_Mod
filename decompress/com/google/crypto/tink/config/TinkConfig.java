// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.config;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.streamingaead.StreamingAeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.signature.SignatureConfig;
import com.google.crypto.tink.hybrid.HybridConfig;
import com.google.crypto.tink.proto.RegistryConfig;

@Deprecated
public final class TinkConfig
{
    @Deprecated
    public static final RegistryConfig a;
    @Deprecated
    public static final RegistryConfig b;
    @Deprecated
    public static final RegistryConfig c;
    
    static {
        a = ((GeneratedMessageLite.Builder<RegistryConfig, BuilderType>)((RegistryConfig.Builder)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)RegistryConfig.M()).z(HybridConfig.c)).z(SignatureConfig.g)).D("TINK_1_0_0")).p();
        b = ((GeneratedMessageLite.Builder<RegistryConfig, BuilderType>)((RegistryConfig.Builder)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)RegistryConfig.M()).z(HybridConfig.d)).z(SignatureConfig.h)).z(DeterministicAeadConfig.b)).z(StreamingAeadConfig.c)).D("TINK_1_1_0")).p();
        c = ((GeneratedMessageLite.Builder<RegistryConfig, BuilderType>)((RegistryConfig.Builder)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)((GeneratedMessageLite.Builder<RegistryConfig, RegistryConfig.Builder>)RegistryConfig.M()).z(HybridConfig.e)).z(SignatureConfig.i)).z(DeterministicAeadConfig.c)).z(StreamingAeadConfig.d)).D("TINK")).p();
    }
}
