// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Iterator;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.ArrayList;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import javax.crypto.KeyAgreement;
import java.security.MessageDigest;
import java.security.Signature;
import javax.crypto.Mac;
import javax.crypto.Cipher;
import java.security.Provider;
import java.util.List;
import java.util.logging.Logger;

public final class EngineFactory<T_WRAPPER extends EngineWrapper<T_ENGINE>, T_ENGINE>
{
    private static final Logger d;
    private static final List<Provider> e;
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> f;
    public static final EngineFactory<EngineWrapper.TMac, Mac> g;
    public static final EngineFactory<EngineWrapper.TSignature, Signature> h;
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> i;
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> j;
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> k;
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> l;
    private T_WRAPPER a;
    private List<Provider> b;
    private boolean c;
    
    static {
        d = Logger.getLogger(EngineFactory.class.getName());
        if (SubtleUtil.d()) {
            e = b("GmsCore_OpenSSL", "AndroidOpenSSL");
        }
        else {
            e = new ArrayList<Provider>();
        }
        f = new EngineFactory<EngineWrapper.TCipher, Cipher>(new EngineWrapper.TCipher());
        g = new EngineFactory<EngineWrapper.TMac, Mac>(new EngineWrapper.TMac());
        h = new EngineFactory<EngineWrapper.TSignature, Signature>(new EngineWrapper.TSignature());
        i = new EngineFactory<EngineWrapper.TMessageDigest, MessageDigest>(new EngineWrapper.TMessageDigest());
        j = new EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement>(new EngineWrapper.TKeyAgreement());
        k = new EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator>(new EngineWrapper.TKeyPairGenerator());
        l = new EngineFactory<EngineWrapper.TKeyFactory, KeyFactory>(new EngineWrapper.TKeyFactory());
    }
    
    public EngineFactory(final T_WRAPPER a) {
        this.a = a;
        this.b = EngineFactory.e;
        this.c = true;
    }
    
    public static List<Provider> b(final String... array) {
        final ArrayList list = new ArrayList();
        for (final String s : array) {
            final Provider provider = Security.getProvider(s);
            if (provider != null) {
                list.add(provider);
            }
            else {
                EngineFactory.d.info(String.format("Provider %s not available", s));
            }
        }
        return list;
    }
    
    public T_ENGINE a(final String s) throws GeneralSecurityException {
        final Iterator<Provider> iterator = this.b.iterator();
        Throwable t = null;
        while (iterator.hasNext()) {
            final Provider provider = iterator.next();
            try {
                return this.a.a(s, provider);
            }
            catch (final Exception ex) {
                if (t == null) {
                    t = ex;
                    continue;
                }
                continue;
            }
            break;
        }
        if (this.c) {
            return this.a.a(s, null);
        }
        throw new GeneralSecurityException("No good Provider found.", t);
    }
}
