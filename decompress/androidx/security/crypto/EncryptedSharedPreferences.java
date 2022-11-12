// 
// Decompiled by Procyon v0.6.0
// 

package androidx.security.crypto;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.crypto.tink.aead.AesGcmKeyManager;
import com.google.crypto.tink.daead.AesSivKeyManager;
import com.google.crypto.tink.KeyTemplate;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import android.content.SharedPreferences$Editor;
import android.util.Pair;
import androidx.collection.b;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import com.google.crypto.tink.subtle.Base64;
import java.io.IOException;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import android.content.Context;
import java.util.ArrayList;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.Aead;
import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import java.util.List;
import android.content.SharedPreferences;

public final class EncryptedSharedPreferences implements SharedPreferences
{
    final SharedPreferences a;
    final List<SharedPreferences$OnSharedPreferenceChangeListener> b;
    final String c;
    final String d;
    final Aead e;
    final DeterministicAead f;
    
    EncryptedSharedPreferences(final String c, final String d, final SharedPreferences a, final Aead e, final DeterministicAead f) {
        this.c = c;
        this.a = a;
        this.d = d;
        this.e = e;
        this.f = f;
        this.b = new ArrayList<SharedPreferences$OnSharedPreferenceChangeListener>();
    }
    
    @Deprecated
    public static SharedPreferences a(final String s, final String s2, Context applicationContext, final PrefKeyEncryptionScheme prefKeyEncryptionScheme, final PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        DeterministicAeadConfig.b();
        AeadConfig.b();
        applicationContext = applicationContext.getApplicationContext();
        final AndroidKeysetManager.Builder j = new AndroidKeysetManager.Builder().h(prefKeyEncryptionScheme.getKeyTemplate()).j(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", s);
        final StringBuilder sb = new StringBuilder();
        sb.append("android-keystore://");
        sb.append(s2);
        final KeysetHandle c = j.i(sb.toString()).d().c();
        final AndroidKeysetManager.Builder i = new AndroidKeysetManager.Builder().h(prefValueEncryptionScheme.getKeyTemplate()).j(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", s);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("android-keystore://");
        sb2.append(s2);
        return (SharedPreferences)new EncryptedSharedPreferences(s, s2, applicationContext.getSharedPreferences(s, 0), i.i(sb2.toString()).d().c().h(Aead.class), c.h(DeterministicAead.class));
    }
    
    private Object e(String s) {
        if (!this.f(s)) {
            String s2;
            if ((s2 = s) == null) {
                s2 = "__NULL__";
            }
            try {
                final String c = this.c(s2);
                final SharedPreferences a = this.a;
                final String s3 = null;
                final String string = a.getString(c, (String)null);
                s = s3;
                if (string != null) {
                    boolean b = false;
                    final ByteBuffer wrap = ByteBuffer.wrap(this.e.b(Base64.b(string, 0), c.getBytes(StandardCharsets.UTF_8)));
                    wrap.position(0);
                    switch (EncryptedSharedPreferences$a.a[EncryptedType.fromId(wrap.getInt()).ordinal()]) {
                        default: {
                            s = s3;
                            break;
                        }
                        case 6: {
                            s = (String)new androidx.collection.b();
                            while (wrap.hasRemaining()) {
                                final int int1 = wrap.getInt();
                                final ByteBuffer slice = wrap.slice();
                                slice.limit(int1);
                                wrap.position(wrap.position() + int1);
                                ((androidx.collection.b<String>)s).add(StandardCharsets.UTF_8.decode(slice).toString());
                            }
                            if (((androidx.collection.b)s).size() == 1 && "__NULL__".equals(((androidx.collection.b<Object>)s).n(0))) {
                                s = s3;
                                break;
                            }
                            break;
                        }
                        case 5: {
                            if (wrap.get() != 0) {
                                b = true;
                            }
                            s = (String)Boolean.valueOf(b);
                            break;
                        }
                        case 4: {
                            s = (String)Float.valueOf(wrap.getFloat());
                            break;
                        }
                        case 3: {
                            s = (String)Long.valueOf(wrap.getLong());
                            break;
                        }
                        case 2: {
                            s = (String)Integer.valueOf(wrap.getInt());
                            break;
                        }
                        case 1: {
                            final int int2 = wrap.getInt();
                            final ByteBuffer slice2 = wrap.slice();
                            wrap.limit(int2);
                            s = StandardCharsets.UTF_8.decode(slice2).toString();
                            if (s.equals("__NULL__")) {
                                s = s3;
                                break;
                            }
                            break;
                        }
                    }
                }
                return s;
            }
            catch (final GeneralSecurityException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not decrypt value. ");
                sb.append(ex.getMessage());
                throw new SecurityException(sb.toString(), ex);
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append(" is a reserved key for the encryption keyset.");
        throw new SecurityException(sb2.toString());
    }
    
    String b(final String s) {
        try {
            String s2 = new String(this.f.b(Base64.b(s, 0), this.c.getBytes()), StandardCharsets.UTF_8);
            if (s2.equals("__NULL__")) {
                s2 = null;
            }
            return s2;
        }
        catch (final GeneralSecurityException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not decrypt key. ");
            sb.append(ex.getMessage());
            throw new SecurityException(sb.toString(), ex);
        }
    }
    
    String c(String e) {
        String s = e;
        if (e == null) {
            s = "__NULL__";
        }
        try {
            e = Base64.e(this.f.a(s.getBytes(StandardCharsets.UTF_8), this.c.getBytes()));
            return e;
        }
        catch (final GeneralSecurityException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not encrypt key. ");
            sb.append(ex.getMessage());
            throw new SecurityException(sb.toString(), ex);
        }
    }
    
    public boolean contains(String c) {
        if (!this.f(c)) {
            c = this.c(c);
            return this.a.contains(c);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(" is a reserved key for the encryption keyset.");
        throw new SecurityException(sb.toString());
    }
    
    Pair<String, String> d(String c, final byte[] array) throws GeneralSecurityException {
        c = this.c(c);
        return (Pair<String, String>)new Pair((Object)c, (Object)Base64.e(this.e.a(array, c.getBytes(StandardCharsets.UTF_8))));
    }
    
    public SharedPreferences$Editor edit() {
        return (SharedPreferences$Editor)new b(this, this.a.edit());
    }
    
    boolean f(final String s) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(s) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(s);
    }
    
    public Map<String, ?> getAll() {
        final HashMap hashMap = new HashMap();
        for (final Map.Entry<String, V> entry : this.a.getAll().entrySet()) {
            if (!this.f(entry.getKey())) {
                final String b = this.b(entry.getKey());
                hashMap.put(b, this.e(b));
            }
        }
        return hashMap;
    }
    
    public boolean getBoolean(final String s, final boolean b) {
        final Object e = this.e(s);
        boolean booleanValue = b;
        if (e != null) {
            booleanValue = b;
            if (e instanceof Boolean) {
                booleanValue = (boolean)e;
            }
        }
        return booleanValue;
    }
    
    public float getFloat(final String s, final float n) {
        final Object e = this.e(s);
        float floatValue = n;
        if (e != null) {
            floatValue = n;
            if (e instanceof Float) {
                floatValue = (float)e;
            }
        }
        return floatValue;
    }
    
    public int getInt(final String s, final int n) {
        final Object e = this.e(s);
        int intValue = n;
        if (e != null) {
            intValue = n;
            if (e instanceof Integer) {
                intValue = (int)e;
            }
        }
        return intValue;
    }
    
    public long getLong(final String s, final long n) {
        final Object e = this.e(s);
        long longValue = n;
        if (e != null) {
            longValue = n;
            if (e instanceof Long) {
                longValue = (long)e;
            }
        }
        return longValue;
    }
    
    public String getString(String s, final String s2) {
        final Object e = this.e(s);
        s = s2;
        if (e != null) {
            s = s2;
            if (e instanceof String) {
                s = (String)e;
            }
        }
        return s;
    }
    
    public Set<String> getStringSet(final String s, Set<String> set) {
        final Object e = this.e(s);
        Set set2;
        if (e instanceof Set) {
            set2 = (Set)e;
        }
        else {
            set2 = new androidx.collection.b();
        }
        if (set2.size() > 0) {
            set = set2;
        }
        return set;
    }
    
    public void registerOnSharedPreferenceChangeListener(final SharedPreferences$OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener) {
        this.b.add(sharedPreferences$OnSharedPreferenceChangeListener);
    }
    
    public void unregisterOnSharedPreferenceChangeListener(final SharedPreferences$OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener) {
        this.b.remove(sharedPreferences$OnSharedPreferenceChangeListener);
    }
    
    private enum EncryptedType
    {
        private static final EncryptedType[] $VALUES;
        
        BOOLEAN(5), 
        FLOAT(4), 
        INT(2), 
        LONG(3), 
        STRING(0), 
        STRING_SET(1);
        
        private final int mId;
        
        private EncryptedType(final int mId) {
            this.mId = mId;
        }
        
        public static EncryptedType fromId(final int n) {
            if (n == 0) {
                return EncryptedType.STRING;
            }
            if (n == 1) {
                return EncryptedType.STRING_SET;
            }
            if (n == 2) {
                return EncryptedType.INT;
            }
            if (n == 3) {
                return EncryptedType.LONG;
            }
            if (n == 4) {
                return EncryptedType.FLOAT;
            }
            if (n != 5) {
                return null;
            }
            return EncryptedType.BOOLEAN;
        }
        
        public int getId() {
            return this.mId;
        }
    }
    
    public enum PrefKeyEncryptionScheme
    {
        private static final PrefKeyEncryptionScheme[] $VALUES;
        
        AES256_SIV(AesSivKeyManager.j());
        
        private final KeyTemplate mDeterministicAeadKeyTemplate;
        
        private PrefKeyEncryptionScheme(final KeyTemplate mDeterministicAeadKeyTemplate) {
            this.mDeterministicAeadKeyTemplate = mDeterministicAeadKeyTemplate;
        }
        
        KeyTemplate getKeyTemplate() {
            return this.mDeterministicAeadKeyTemplate;
        }
    }
    
    public enum PrefValueEncryptionScheme
    {
        private static final PrefValueEncryptionScheme[] $VALUES;
        
        AES256_GCM(AesGcmKeyManager.j());
        
        private final KeyTemplate mAeadKeyTemplate;
        
        private PrefValueEncryptionScheme(final KeyTemplate mAeadKeyTemplate) {
            this.mAeadKeyTemplate = mAeadKeyTemplate;
        }
        
        KeyTemplate getKeyTemplate() {
            return this.mAeadKeyTemplate;
        }
    }
    
    private static final class b implements SharedPreferences$Editor
    {
        private final EncryptedSharedPreferences a;
        private final SharedPreferences$Editor b;
        private final List<String> c;
        private AtomicBoolean d;
        
        b(final EncryptedSharedPreferences a, final SharedPreferences$Editor b) {
            this.d = new AtomicBoolean(false);
            this.a = a;
            this.b = b;
            this.c = new CopyOnWriteArrayList<String>();
        }
        
        private void a() {
            if (this.d.getAndSet(false)) {
                for (final String s : this.a.getAll().keySet()) {
                    if (!this.c.contains(s) && !this.a.f(s)) {
                        this.b.remove(this.a.c(s));
                    }
                }
            }
        }
        
        private void b() {
            for (final SharedPreferences$OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener : this.a.b) {
                final Iterator<String> iterator2 = this.c.iterator();
                while (iterator2.hasNext()) {
                    sharedPreferences$OnSharedPreferenceChangeListener.onSharedPreferenceChanged((SharedPreferences)this.a, (String)iterator2.next());
                }
            }
        }
        
        private void c(final String s, final byte[] array) {
            if (!this.a.f(s)) {
                this.c.add(s);
                String s2;
                if ((s2 = s) == null) {
                    s2 = "__NULL__";
                }
                try {
                    final Pair<String, String> d = this.a.d(s2, array);
                    this.b.putString((String)d.first, (String)d.second);
                    return;
                }
                catch (final GeneralSecurityException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Could not encrypt data: ");
                    sb.append(ex.getMessage());
                    throw new SecurityException(sb.toString(), ex);
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(" is a reserved key for the encryption keyset.");
            throw new SecurityException(sb2.toString());
        }
        
        public void apply() {
            this.a();
            this.b.apply();
            this.b();
            this.c.clear();
        }
        
        public SharedPreferences$Editor clear() {
            this.d.set(true);
            return (SharedPreferences$Editor)this;
        }
        
        public boolean commit() {
            this.a();
            try {
                return this.b.commit();
            }
            finally {
                this.b();
                this.c.clear();
            }
        }
        
        public SharedPreferences$Editor putBoolean(final String s, final boolean b) {
            final ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.getId());
            allocate.put((byte)(b ? 1 : 0));
            this.c(s, allocate.array());
            return (SharedPreferences$Editor)this;
        }
        
        public SharedPreferences$Editor putFloat(final String s, final float n) {
            final ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.getId());
            allocate.putFloat(n);
            this.c(s, allocate.array());
            return (SharedPreferences$Editor)this;
        }
        
        public SharedPreferences$Editor putInt(final String s, final int n) {
            final ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.getId());
            allocate.putInt(n);
            this.c(s, allocate.array());
            return (SharedPreferences$Editor)this;
        }
        
        public SharedPreferences$Editor putLong(final String s, final long n) {
            final ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.getId());
            allocate.putLong(n);
            this.c(s, allocate.array());
            return (SharedPreferences$Editor)this;
        }
        
        public SharedPreferences$Editor putString(final String s, final String s2) {
            String s3 = s2;
            if (s2 == null) {
                s3 = "__NULL__";
            }
            final byte[] bytes = s3.getBytes(StandardCharsets.UTF_8);
            final int length = bytes.length;
            final ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(EncryptedType.STRING.getId());
            allocate.putInt(length);
            allocate.put(bytes);
            this.c(s, allocate.array());
            return (SharedPreferences$Editor)this;
        }
        
        public SharedPreferences$Editor putStringSet(final String s, final Set<String> set) {
            Set<String> set2 = set;
            if (set == null) {
                set2 = new androidx.collection.b<String>();
                set2.add("__NULL__");
            }
            final ArrayList list = new ArrayList(set2.size());
            int n = set2.size() * 4;
            final Iterator iterator = set2.iterator();
            while (iterator.hasNext()) {
                final byte[] bytes = ((String)iterator.next()).getBytes(StandardCharsets.UTF_8);
                list.add((Object)bytes);
                n += bytes.length;
            }
            final ByteBuffer allocate = ByteBuffer.allocate(n + 4);
            allocate.putInt(EncryptedType.STRING_SET.getId());
            for (final byte[] array : list) {
                allocate.putInt(array.length);
                allocate.put(array);
            }
            this.c(s, allocate.array());
            return (SharedPreferences$Editor)this;
        }
        
        public SharedPreferences$Editor remove(final String s) {
            if (!this.a.f(s)) {
                this.b.remove(this.a.c(s));
                this.c.remove(s);
                return (SharedPreferences$Editor)this;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(" is a reserved key for the encryption keyset.");
            throw new SecurityException(sb.toString());
        }
    }
}
