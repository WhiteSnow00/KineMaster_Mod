// 
// Decompiled by Procyon v0.6.0
// 

package androidx.security.crypto;

import java.util.Arrays;
import java.security.KeyStore;
import java.io.IOException;
import java.security.ProviderException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGenerator;
import android.security.keystore.KeyGenParameterSpec$Builder;
import android.security.keystore.KeyGenParameterSpec;

@Deprecated
public final class a
{
    public static final KeyGenParameterSpec a;
    
    static {
        a = a("_androidx_security_master_key_");
    }
    
    private static KeyGenParameterSpec a(final String s) {
        return new KeyGenParameterSpec$Builder(s, 3).setBlockModes(new String[] { "GCM" }).setEncryptionPaddings(new String[] { "NoPadding" }).setKeySize(256).build();
    }
    
    private static void b(final KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        try {
            final KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init((AlgorithmParameterSpec)keyGenParameterSpec);
            instance.generateKey();
        }
        catch (final ProviderException ex) {
            throw new GeneralSecurityException(ex.getMessage(), ex);
        }
    }
    
    public static String c(final KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException, IOException {
        e(keyGenParameterSpec);
        if (!d(keyGenParameterSpec.getKeystoreAlias())) {
            b(keyGenParameterSpec);
        }
        return keyGenParameterSpec.getKeystoreAlias();
    }
    
    private static boolean d(final String s) throws GeneralSecurityException, IOException {
        final KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load(null);
        return instance.containsAlias(s);
    }
    
    static void e(final KeyGenParameterSpec keyGenParameterSpec) {
        if (keyGenParameterSpec.getKeySize() != 256) {
            final StringBuilder sb = new StringBuilder();
            sb.append("invalid key size, want 256 bits got ");
            sb.append(keyGenParameterSpec.getKeySize());
            sb.append(" bits");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[] { "GCM" })) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("invalid block mode, want GCM got ");
            sb2.append(Arrays.toString(keyGenParameterSpec.getBlockModes()));
            throw new IllegalArgumentException(sb2.toString());
        }
        if (keyGenParameterSpec.getPurposes() != 3) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got ");
            sb3.append(keyGenParameterSpec.getPurposes());
            throw new IllegalArgumentException(sb3.toString());
        }
        if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[] { "NoPadding" })) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("invalid padding mode, want NoPadding got ");
            sb4.append(Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
            throw new IllegalArgumentException(sb4.toString());
        }
        if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
            throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
        }
    }
}
