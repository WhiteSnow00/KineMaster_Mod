// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class d extends FilesPayload
{
    private final ImmutableList<File> a;
    private final String b;
    
    private d(final ImmutableList<File> a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    d(final ImmutableList list, final String s, final d$a object) {
        this(list, s);
    }
    
    @Override
    public ImmutableList<File> b() {
        return this.a;
    }
    
    @Override
    public String c() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof FilesPayload) {
            final FilesPayload filesPayload = (FilesPayload)o;
            if (this.a.equals(filesPayload.b())) {
                final String b2 = this.b;
                if (b2 == null) {
                    if (filesPayload.c() == null) {
                        return b;
                    }
                }
                else if (b2.equals(filesPayload.c())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final String b = this.b;
        int hashCode2;
        if (b == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = b.hashCode();
        }
        return (hashCode ^ 0xF4243) * 1000003 ^ hashCode2;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FilesPayload{files=");
        sb.append(this.a);
        sb.append(", orgId=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private ImmutableList<File> a;
        private String b;
        
        @Override
        public FilesPayload a() {
            final ImmutableList<File> a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" files");
                string = sb.toString();
            }
            if (string.isEmpty()) {
                return new d(this.a, this.b, null);
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Missing required properties:");
            sb2.append(string);
            throw new IllegalStateException(sb2.toString());
        }
        
        @Override
        public Builder b(final ImmutableList<File> a) {
            Objects.requireNonNull(a, "Null files");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder c(final String b) {
            this.b = b;
            return this;
        }
    }
}
