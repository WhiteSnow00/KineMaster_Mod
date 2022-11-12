// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite
{
    private static boolean b = true;
    private static volatile ExtensionRegistryLite c;
    static final ExtensionRegistryLite d;
    private final Map<a, GeneratedMessageLite.GeneratedExtension<?, ?>> a;
    
    static {
        d = new ExtensionRegistryLite(true);
    }
    
    ExtensionRegistryLite() {
        this.a = new HashMap<a, GeneratedMessageLite.GeneratedExtension<?, ?>>();
    }
    
    ExtensionRegistryLite(final boolean b) {
        this.a = Collections.emptyMap();
    }
    
    public static ExtensionRegistryLite b() {
        final ExtensionRegistryLite c;
        if ((c = ExtensionRegistryLite.c) == null) {
            synchronized (ExtensionRegistryLite.class) {
                if (ExtensionRegistryLite.c == null) {
                    ExtensionRegistryLite c2;
                    if (ExtensionRegistryLite.b) {
                        c2 = j.a();
                    }
                    else {
                        c2 = ExtensionRegistryLite.d;
                    }
                    ExtensionRegistryLite.c = c2;
                }
            }
        }
        return c;
    }
    
    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> a(final ContainingType containingType, final int n) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>)(GeneratedMessageLite.GeneratedExtension)this.a.get(new a(containingType, n));
    }
    
    private static final class a
    {
        private final Object a;
        private final int b;
        
        a(final Object a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof a;
            final boolean b2 = false;
            if (!b) {
                return false;
            }
            final a a = (a)o;
            boolean b3 = b2;
            if (this.a == a.a) {
                b3 = b2;
                if (this.b == a.b) {
                    b3 = true;
                }
            }
            return b3;
        }
        
        @Override
        public int hashCode() {
            return System.identityHashCode(this.a) * 65535 + this.b;
        }
    }
}
