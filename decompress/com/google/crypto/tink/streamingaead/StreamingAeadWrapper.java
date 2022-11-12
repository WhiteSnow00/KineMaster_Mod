// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.PrimitiveWrapper;

public class StreamingAeadWrapper implements PrimitiveWrapper<StreamingAead, StreamingAead>
{
    StreamingAeadWrapper() {
    }
    
    public static void d() throws GeneralSecurityException {
        Registry.t((PrimitiveWrapper<Object, Object>)new StreamingAeadWrapper());
    }
    
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.e(set);
    }
    
    @Override
    public Class<StreamingAead> b() {
        return StreamingAead.class;
    }
    
    @Override
    public Class<StreamingAead> c() {
        return StreamingAead.class;
    }
    
    public StreamingAead e(final PrimitiveSet<StreamingAead> set) throws GeneralSecurityException {
        return new a(set);
    }
}
