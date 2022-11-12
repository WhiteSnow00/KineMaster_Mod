// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.shaded.protobuf.MessageLite;

@Alpha
public class PrivateKeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyManagerImpl<PrimitiveT, KeyProtoT> implements PrivateKeyManager<PrimitiveT>
{
    private final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> c;
    private final KeyTypeManager<PublicKeyProtoT> d;
    
    public PrivateKeyManagerImpl(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> c, final KeyTypeManager<PublicKeyProtoT> d, final Class<PrimitiveT> clazz) {
        super((KeyTypeManager<MessageLite>)c, clazz);
        this.c = c;
        this.d = d;
    }
}
