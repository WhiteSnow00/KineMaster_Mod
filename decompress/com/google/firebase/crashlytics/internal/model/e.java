// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;
import java.util.Arrays;

final class e extends File
{
    private final String a;
    private final byte[] b;
    
    private e(final String a, final byte[] b) {
        this.a = a;
        this.b = b;
    }
    
    e(final String s, final byte[] array, final e$a object) {
        this(s, array);
    }
    
    @Override
    public byte[] b() {
        return this.b;
    }
    
    @Override
    public String c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof File) {
            final File file = (File)o;
            if (this.a.equals(file.c())) {
                final byte[] b2 = this.b;
                byte[] array;
                if (file instanceof e) {
                    array = ((e)file).b;
                }
                else {
                    array = file.b();
                }
                if (Arrays.equals(b2, array)) {
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
        return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.b);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("File{filename=");
        sb.append(this.a);
        sb.append(", contents=");
        sb.append(Arrays.toString(this.b));
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private byte[] b;
        
        @Override
        public File a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" filename");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" contents");
                string2 = sb2.toString();
            }
            if (string2.isEmpty()) {
                return new e(this.a, this.b, null);
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing required properties:");
            sb3.append(string2);
            throw new IllegalStateException(sb3.toString());
        }
        
        @Override
        public Builder b(final byte[] b) {
            Objects.requireNonNull(b, "Null contents");
            this.b = b;
            return this;
        }
        
        @Override
        public Builder c(final String a) {
            Objects.requireNonNull(a, "Null filename");
            this.a = a;
            return this;
        }
    }
}
