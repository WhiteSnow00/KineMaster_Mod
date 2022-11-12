// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.Signature;
import java.security.MessageDigest;
import javax.crypto.Mac;
import java.security.KeyPairGenerator;
import java.security.KeyFactory;
import javax.crypto.KeyAgreement;
import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.Provider;

public interface EngineWrapper<T>
{
    T a(final String p0, final Provider p1) throws GeneralSecurityException;
    
    public static class TCipher implements EngineWrapper<Cipher>
    {
        @Override
        public /* bridge */ Object a(final String s, final Provider provider) throws GeneralSecurityException {
            return this.b(s, provider);
        }
        
        public Cipher b(final String s, final Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Cipher.getInstance(s);
            }
            return Cipher.getInstance(s, provider);
        }
    }
    
    public static class TKeyAgreement implements EngineWrapper<KeyAgreement>
    {
        @Override
        public /* bridge */ Object a(final String s, final Provider provider) throws GeneralSecurityException {
            return this.b(s, provider);
        }
        
        public KeyAgreement b(final String s, final Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return KeyAgreement.getInstance(s);
            }
            return KeyAgreement.getInstance(s, provider);
        }
    }
    
    public static class TKeyFactory implements EngineWrapper<KeyFactory>
    {
        @Override
        public /* bridge */ Object a(final String s, final Provider provider) throws GeneralSecurityException {
            return this.b(s, provider);
        }
        
        public KeyFactory b(final String s, final Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return KeyFactory.getInstance(s);
            }
            return KeyFactory.getInstance(s, provider);
        }
    }
    
    public static class TKeyPairGenerator implements EngineWrapper<KeyPairGenerator>
    {
        @Override
        public /* bridge */ Object a(final String s, final Provider provider) throws GeneralSecurityException {
            return this.b(s, provider);
        }
        
        public KeyPairGenerator b(final String s, final Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return KeyPairGenerator.getInstance(s);
            }
            return KeyPairGenerator.getInstance(s, provider);
        }
    }
    
    public static class TMac implements EngineWrapper<Mac>
    {
        @Override
        public /* bridge */ Object a(final String s, final Provider provider) throws GeneralSecurityException {
            return this.b(s, provider);
        }
        
        public Mac b(final String s, final Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Mac.getInstance(s);
            }
            return Mac.getInstance(s, provider);
        }
    }
    
    public static class TMessageDigest implements EngineWrapper<MessageDigest>
    {
        @Override
        public /* bridge */ Object a(final String s, final Provider provider) throws GeneralSecurityException {
            return this.b(s, provider);
        }
        
        public MessageDigest b(final String s, final Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return MessageDigest.getInstance(s);
            }
            return MessageDigest.getInstance(s, provider);
        }
    }
    
    public static class TSignature implements EngineWrapper<Signature>
    {
        @Override
        public /* bridge */ Object a(final String s, final Provider provider) throws GeneralSecurityException {
            return this.b(s, provider);
        }
        
        public Signature b(final String s, final Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Signature.getInstance(s);
            }
            return Signature.getInstance(s, provider);
        }
    }
}
