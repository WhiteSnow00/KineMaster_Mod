// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface PrimitiveWrapper<B, P>
{
    P a(final PrimitiveSet<B> p0) throws GeneralSecurityException;
    
    Class<B> b();
    
    Class<P> c();
}
