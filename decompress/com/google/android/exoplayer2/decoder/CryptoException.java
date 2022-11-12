// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

public class CryptoException extends Exception
{
    public final int errorCode;
    
    public CryptoException(final int errorCode, final String s) {
        super(s);
        this.errorCode = errorCode;
    }
}
