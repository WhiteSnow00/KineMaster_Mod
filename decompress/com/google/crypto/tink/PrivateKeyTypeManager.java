// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.shaded.protobuf.MessageLite;

@Alpha
public abstract class PrivateKeyTypeManager<KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyTypeManager<KeyProtoT>
{
    private final Class<PublicKeyProtoT> d;
    
    @SafeVarargs
    protected PrivateKeyTypeManager(final Class<KeyProtoT> clazz, final Class<PublicKeyProtoT> d, final PrimitiveFactory<?, KeyProtoT>... array) {
        super(clazz, array);
        this.d = d;
    }
}
