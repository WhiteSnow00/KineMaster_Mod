// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.List;

final class StructuralMessageInfo implements w
{
    private final ProtoSyntax a;
    private final boolean b;
    private final int[] c;
    private final FieldInfo[] d;
    private final MessageLite e;
    
    @Override
    public boolean a() {
        return this.b;
    }
    
    @Override
    public MessageLite b() {
        return this.e;
    }
    
    @Override
    public ProtoSyntax c() {
        return this.a;
    }
    
    public int[] d() {
        return this.c;
    }
    
    public FieldInfo[] e() {
        return this.d;
    }
    
    public static final class Builder
    {
        private final List<FieldInfo> a;
        private int[] b;
        
        public Builder() {
            this.b = null;
            this.a = new ArrayList<FieldInfo>();
        }
    }
}
