// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

@Deprecated
public final class KeyTypeEntry extends GeneratedMessageLite<KeyTypeEntry, Builder> implements KeyTypeEntryOrBuilder
{
    public static final int CATALOGUE_NAME_FIELD_NUMBER = 5;
    private static final KeyTypeEntry DEFAULT_INSTANCE;
    public static final int KEY_MANAGER_VERSION_FIELD_NUMBER = 3;
    public static final int NEW_KEY_ALLOWED_FIELD_NUMBER = 4;
    private static volatile Parser<KeyTypeEntry> PARSER;
    public static final int PRIMITIVE_NAME_FIELD_NUMBER = 1;
    public static final int TYPE_URL_FIELD_NUMBER = 2;
    private String catalogueName_;
    private int keyManagerVersion_;
    private boolean newKeyAllowed_;
    private String primitiveName_;
    private String typeUrl_;
    
    static {
        GeneratedMessageLite.H(KeyTypeEntry.class, DEFAULT_INSTANCE = new KeyTypeEntry());
    }
    
    private KeyTypeEntry() {
        this.primitiveName_ = "";
        this.typeUrl_ = "";
        this.catalogueName_ = "";
    }
    
    static KeyTypeEntry J() {
        return KeyTypeEntry.DEFAULT_INSTANCE;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KeyTypeEntry$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KeyTypeEntry> parser;
                if ((parser = KeyTypeEntry.PARSER) == null) {
                    synchronized (KeyTypeEntry.class) {
                        if (KeyTypeEntry.PARSER == null) {
                            KeyTypeEntry.PARSER = new DefaultInstanceBasedParser<KeyTypeEntry>(KeyTypeEntry.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KeyTypeEntry.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KeyTypeEntry.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0208\u0002\u0208\u0003\u000b\u0004\u0007\u0005\u0208", new Object[] { "primitiveName_", "typeUrl_", "keyManagerVersion_", "newKeyAllowed_", "catalogueName_" });
            }
            case 2: {
                return new Builder((KeyTypeEntry$a)null);
            }
            case 1: {
                return new KeyTypeEntry();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KeyTypeEntry, Builder> implements KeyTypeEntryOrBuilder
    {
        private Builder() {
            super(KeyTypeEntry.J());
        }
        
        Builder(final KeyTypeEntry$a object) {
            this();
        }
    }
}
