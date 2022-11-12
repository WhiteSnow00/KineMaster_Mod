// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class b extends PathClassLoader
{
    b(final String s, final ClassLoader classLoader) {
        super(s, classLoader);
    }
    
    protected final Class loadClass(final String s, final boolean b) throws ClassNotFoundException {
        Label_0026: {
            if (s.startsWith("java.") || s.startsWith("android.")) {
                break Label_0026;
            }
            try {
                return this.findClass(s);
                return super.loadClass(s, b);
            }
            catch (final ClassNotFoundException ex) {
                return super.loadClass(s, b);
            }
        }
    }
}
