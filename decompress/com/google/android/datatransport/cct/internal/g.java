// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

final class g extends NetworkConnectionInfo
{
    private final NetworkType a;
    private final MobileSubtype b;
    
    private g(final NetworkType a, final MobileSubtype b) {
        this.a = a;
        this.b = b;
    }
    
    g(final NetworkType networkType, final MobileSubtype mobileSubtype, final g$a object) {
        this(networkType, mobileSubtype);
    }
    
    @Override
    public MobileSubtype b() {
        return this.b;
    }
    
    @Override
    public NetworkType c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof NetworkConnectionInfo) {
            final NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo)o;
            final NetworkType a = this.a;
            if (a == null) {
                if (networkConnectionInfo.c() != null) {
                    return false;
                }
            }
            else if (!a.equals(networkConnectionInfo.c())) {
                return false;
            }
            final MobileSubtype b2 = this.b;
            if (b2 == null) {
                if (networkConnectionInfo.b() == null) {
                    return b;
                }
            }
            else if (b2.equals(networkConnectionInfo.b())) {
                return b;
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final NetworkType a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = a.hashCode();
        }
        final MobileSubtype b = this.b;
        if (b != null) {
            hashCode = b.hashCode();
        }
        return (hashCode2 ^ 0xF4243) * 1000003 ^ hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("NetworkConnectionInfo{networkType=");
        sb.append(this.a);
        sb.append(", mobileSubtype=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private NetworkType a;
        private MobileSubtype b;
        
        @Override
        public NetworkConnectionInfo a() {
            return new g(this.a, this.b, null);
        }
        
        @Override
        public Builder b(final MobileSubtype b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder c(final NetworkType a) {
            this.a = a;
            return this;
        }
    }
}
