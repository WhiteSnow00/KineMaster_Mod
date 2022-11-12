// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public final class ProgramInformation
{
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    
    public ProgramInformation(final String a, final String b, final String c, final String d, final String e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProgramInformation)) {
            return false;
        }
        final ProgramInformation programInformation = (ProgramInformation)o;
        if (!Util.c(this.a, programInformation.a) || !Util.c(this.b, programInformation.b) || !Util.c(this.c, programInformation.c) || !Util.c(this.d, programInformation.d) || !Util.c(this.e, programInformation.e)) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final String a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a != null) {
            hashCode2 = a.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String b = this.b;
        int hashCode3;
        if (b != null) {
            hashCode3 = b.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String c = this.c;
        int hashCode4;
        if (c != null) {
            hashCode4 = c.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String d = this.d;
        int hashCode5;
        if (d != null) {
            hashCode5 = d.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String e = this.e;
        if (e != null) {
            hashCode = e.hashCode();
        }
        return ((((527 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
}
