// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Map;

abstract class k<T extends FieldSet.FieldDescriptorLite<T>>
{
    abstract int a(final Map.Entry<?, ?> p0);
    
    abstract Object b(final ExtensionRegistryLite p0, final MessageLite p1, final int p2);
    
    abstract FieldSet<T> c(final Object p0);
    
    abstract FieldSet<T> d(final Object p0);
    
    abstract boolean e(final MessageLite p0);
    
    abstract void f(final Object p0);
    
    abstract <UT, UB> UB g(final i0 p0, final Object p1, final ExtensionRegistryLite p2, final FieldSet<T> p3, final UB p4, final o0<UT, UB> p5) throws IOException;
    
    abstract void h(final i0 p0, final Object p1, final ExtensionRegistryLite p2, final FieldSet<T> p3) throws IOException;
    
    abstract void i(final ByteString p0, final Object p1, final ExtensionRegistryLite p2, final FieldSet<T> p3) throws IOException;
    
    abstract void j(final Writer p0, final Map.Entry<?, ?> p1) throws IOException;
}
