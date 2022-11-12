// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.io.BufferedReader;
import java.security.spec.ECParameterSpec;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.KeyFactory;
import java.security.Key;

public enum PemKeyType
{
    private static final PemKeyType[] $VALUES;
    private static final String BEGIN = "-----BEGIN ";
    
    ECDSA_P256_SHA256("EC", "ECDSA", 256, sha256), 
    ECDSA_P384_SHA384("EC", "ECDSA", 384, Enums.HashType.SHA384), 
    ECDSA_P521_SHA512("EC", "ECDSA", 521, sha257);
    
    private static final String END = "-----END ";
    private static final String MARKER = "-----";
    private static final String PRIVATE_KEY = "PRIVATE KEY";
    private static final String PUBLIC_KEY = "PUBLIC KEY";
    
    RSA_PSS_2048_SHA256("RSA", "RSASSA-PSS", 2048, sha256), 
    RSA_PSS_3072_SHA256("RSA", "RSASSA-PSS", 3072, sha256), 
    RSA_PSS_4096_SHA256("RSA", "RSASSA-PSS", 4096, sha256), 
    RSA_PSS_4096_SHA512("RSA", "RSASSA-PSS", 4096, sha257), 
    RSA_SIGN_PKCS1_2048_SHA256("RSA", "RSASSA-PKCS1-v1_5", 2048, sha256), 
    RSA_SIGN_PKCS1_3072_SHA256("RSA", "RSASSA-PKCS1-v1_5", 3072, sha256), 
    RSA_SIGN_PKCS1_4096_SHA256("RSA", "RSASSA-PKCS1-v1_5", 4096, sha256), 
    RSA_SIGN_PKCS1_4096_SHA512("RSA", "RSASSA-PKCS1-v1_5", 4096, sha257);
    
    public final String algorithm;
    public final Enums.HashType hash;
    public final int keySizeInBits;
    public final String keyType;
    
    static {
        final Enums.HashType sha256 = Enums.HashType.SHA256;
        final Enums.HashType sha257 = Enums.HashType.SHA512;
    }
    
    private PemKeyType(final String keyType, final String algorithm, final int keySizeInBits, final Enums.HashType hash) {
        this.keyType = keyType;
        this.algorithm = algorithm;
        this.keySizeInBits = keySizeInBits;
        this.hash = hash;
    }
    
    private Key a(final byte[] array) throws GeneralSecurityException {
        return this.d(EngineFactory.l.a(this.keyType).generatePrivate(new PKCS8EncodedKeySpec(array)));
    }
    
    private Key c(final byte[] array) throws GeneralSecurityException {
        return this.d(EngineFactory.l.a(this.keyType).generatePublic(new X509EncodedKeySpec(array)));
    }
    
    private Key d(final Key key) throws GeneralSecurityException {
        if (this.keyType.equals("RSA")) {
            final int bitLength = ((RSAKey)key).getModulus().bitLength();
            if (bitLength != this.keySizeInBits) {
                throw new GeneralSecurityException(String.format("invalid RSA key size, want %d got %d", this.keySizeInBits, bitLength));
            }
        }
        else {
            final ECParameterSpec params = ((ECKey)key).getParams();
            if (!EllipticCurves.n(params)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("unsupport EC spec: ");
                sb.append(params.toString());
                throw new GeneralSecurityException(sb.toString());
            }
            final int c = EllipticCurves.c(params.getCurve());
            if (c != this.keySizeInBits) {
                throw new GeneralSecurityException(String.format("invalid EC key size, want %d got %d", this.keySizeInBits, c));
            }
        }
        return key;
    }
    
    public Key readKey(final BufferedReader bufferedReader) throws IOException {
        String s;
        for (s = bufferedReader.readLine(); s != null && !s.startsWith("-----BEGIN "); s = bufferedReader.readLine()) {}
        if (s == null) {
            return null;
        }
        final String substring = s.trim().substring(11);
        final int index = substring.indexOf("-----");
        if (index < 0) {
            return null;
        }
        final String substring2 = substring.substring(0, index);
        final StringBuilder sb = new StringBuilder();
        sb.append("-----END ");
        sb.append(substring2);
        sb.append("-----");
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        while (true) {
            final String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            if (line.indexOf(":") > 0) {
                continue;
            }
            if (line.contains(string)) {
                break;
            }
            sb2.append(line);
        }
        try {
            final byte[] b = Base64.b(sb2.toString(), 0);
            if (substring2.contains("PUBLIC KEY")) {
                return this.c(b);
            }
            if (substring2.contains("PRIVATE KEY")) {
                return this.a(b);
            }
            return null;
        }
        catch (final GeneralSecurityException | IllegalArgumentException ex) {
            return null;
        }
    }
}
