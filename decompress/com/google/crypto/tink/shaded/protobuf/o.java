// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

class o implements x
{
    private static final o a;
    
    static {
        a = new o();
    }
    
    private o() {
    }
    
    public static o c() {
        return o.a;
    }
    
    @Override
    public w a(final Class<?> clazz) {
        if (GeneratedMessageLite.class.isAssignableFrom(clazz)) {
            try {
                return (w)((GeneratedMessageLite)GeneratedMessageLite.t(clazz.asSubclass(GeneratedMessageLite.class))).l();
            }
            catch (final Exception ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to get message info for ");
                sb.append(clazz.getName());
                throw new RuntimeException(sb.toString(), ex);
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Unsupported message type: ");
        sb2.append(clazz.getName());
        throw new IllegalArgumentException(sb2.toString());
    }
    
    @Override
    public boolean b(final Class<?> clazz) {
        return GeneratedMessageLite.class.isAssignableFrom(clazz);
    }
}
