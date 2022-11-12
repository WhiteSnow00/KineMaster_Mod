// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;

public interface IndCpaCipher
{
    byte[] a(final byte[] p0) throws GeneralSecurityException;
    
    byte[] b(final byte[] p0) throws GeneralSecurityException;
}
