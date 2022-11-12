// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

@Deprecated
public final class RegistryConfig extends GeneratedMessageLite<RegistryConfig, Builder> implements RegistryConfigOrBuilder
{
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    private static final RegistryConfig DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    private static volatile Parser<RegistryConfig> PARSER;
    private String configName_;
    private Internal.ProtobufList<KeyTypeEntry> entry_;
    
    static {
        GeneratedMessageLite.H(RegistryConfig.class, DEFAULT_INSTANCE = new RegistryConfig());
    }
    
    private RegistryConfig() {
        this.configName_ = "";
        this.entry_ = GeneratedMessageLite.r();
    }
    
    static RegistryConfig J() {
        return RegistryConfig.DEFAULT_INSTANCE;
    }
    
    static void K(final RegistryConfig registryConfig, final String s) {
        registryConfig.N(s);
    }
    
    public static RegistryConfig L() {
        return RegistryConfig.DEFAULT_INSTANCE;
    }
    
    public static Builder M() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RegistryConfig.DEFAULT_INSTANCE).n();
    }
    
    private void N(final String configName_) {
        configName_.getClass();
        this.configName_ = configName_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RegistryConfig$a.a[methodToInvoke.ordinal()]) {
            default: {
                throw new UnsupportedOperationException();
            }
            case 7: {
                return null;
            }
            case 6: {
                return 1;
            }
            case 5: {
                final Parser<RegistryConfig> parser;
                if ((parser = RegistryConfig.PARSER) == null) {
                    synchronized (RegistryConfig.class) {
                        if (RegistryConfig.PARSER == null) {
                            RegistryConfig.PARSER = new DefaultInstanceBasedParser<RegistryConfig>(RegistryConfig.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RegistryConfig.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RegistryConfig.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0208\u0002\u001b", new Object[] { "configName_", "entry_", KeyTypeEntry.class });
            }
            case 2: {
                return new Builder((RegistryConfig$a)null);
            }
            case 1: {
                return new RegistryConfig();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RegistryConfig, Builder> implements RegistryConfigOrBuilder
    {
        private Builder() {
            super(RegistryConfig.J());
        }
        
        Builder(final RegistryConfig$a object) {
            this();
        }
        
        public Builder D(final String s) {
            ((GeneratedMessageLite.Builder)this).u();
            RegistryConfig.K((RegistryConfig)super.b, s);
            return this;
        }
    }
}
