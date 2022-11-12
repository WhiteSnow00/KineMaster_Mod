// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.Node;

public final class UserWriteRecord
{
    private final long a;
    private final Path b;
    private final Node c;
    private final CompoundWrite d;
    private final boolean e;
    
    public UserWriteRecord(final long a, final Path b, final CompoundWrite d) {
        this.a = a;
        this.b = b;
        this.c = null;
        this.d = d;
        this.e = true;
    }
    
    public UserWriteRecord(final long a, final Path b, final Node c, final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = null;
        this.e = e;
    }
    
    public CompoundWrite a() {
        final CompoundWrite d = this.d;
        if (d != null) {
            return d;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }
    
    public Node b() {
        final Node c = this.c;
        if (c != null) {
            return c;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }
    
    public Path c() {
        return this.b;
    }
    
    public long d() {
        return this.a;
    }
    
    public boolean e() {
        return this.c != null;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || UserWriteRecord.class != o.getClass()) {
            return false;
        }
        final UserWriteRecord userWriteRecord = (UserWriteRecord)o;
        if (this.a != userWriteRecord.a) {
            return false;
        }
        if (!this.b.equals(userWriteRecord.b)) {
            return false;
        }
        if (this.e != userWriteRecord.e) {
            return false;
        }
        final Node c = this.c;
        Label_0103: {
            if (c != null) {
                if (c.equals(userWriteRecord.c)) {
                    break Label_0103;
                }
            }
            else if (userWriteRecord.c == null) {
                break Label_0103;
            }
            return false;
        }
        final CompoundWrite d = this.d;
        final CompoundWrite d2 = userWriteRecord.d;
        if (d != null) {
            if (d.equals(d2)) {
                return true;
            }
        }
        else if (d2 == null) {
            return true;
        }
        return false;
    }
    
    public boolean f() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = Long.valueOf(this.a).hashCode();
        final int hashCode2 = Boolean.valueOf(this.e).hashCode();
        final int hashCode3 = this.b.hashCode();
        final Node c = this.c;
        int hashCode4 = 0;
        int hashCode5;
        if (c != null) {
            hashCode5 = c.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final CompoundWrite d = this.d;
        if (d != null) {
            hashCode4 = d.hashCode();
        }
        return (((hashCode * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode5) * 31 + hashCode4;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UserWriteRecord{id=");
        sb.append(this.a);
        sb.append(" path=");
        sb.append(this.b);
        sb.append(" visible=");
        sb.append(this.e);
        sb.append(" overwrite=");
        sb.append(this.c);
        sb.append(" merge=");
        sb.append(this.d);
        sb.append("}");
        return sb.toString();
    }
}
