// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

final class c extends ClientInfo
{
    private final ClientType a;
    private final AndroidClientInfo b;
    
    private c(final ClientType a, final AndroidClientInfo b) {
        this.a = a;
        this.b = b;
    }
    
    c(final ClientType clientType, final AndroidClientInfo androidClientInfo, final c$a object) {
        this(clientType, androidClientInfo);
    }
    
    @Override
    public AndroidClientInfo b() {
        return this.b;
    }
    
    @Override
    public ClientType c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof ClientInfo) {
            final ClientInfo clientInfo = (ClientInfo)o;
            final ClientType a = this.a;
            if (a == null) {
                if (clientInfo.c() != null) {
                    return false;
                }
            }
            else if (!a.equals(clientInfo.c())) {
                return false;
            }
            final AndroidClientInfo b2 = this.b;
            if (b2 == null) {
                if (clientInfo.b() == null) {
                    return b;
                }
            }
            else if (b2.equals(clientInfo.b())) {
                return b;
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final ClientType a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = a.hashCode();
        }
        final AndroidClientInfo b = this.b;
        if (b != null) {
            hashCode = b.hashCode();
        }
        return (hashCode2 ^ 0xF4243) * 1000003 ^ hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ClientInfo{clientType=");
        sb.append(this.a);
        sb.append(", androidClientInfo=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private ClientType a;
        private AndroidClientInfo b;
        
        @Override
        public ClientInfo a() {
            return new c(this.a, this.b, null);
        }
        
        @Override
        public Builder b(final AndroidClientInfo b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder c(final ClientType a) {
            this.a = a;
            return this;
        }
    }
}
