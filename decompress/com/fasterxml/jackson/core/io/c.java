// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.d;
import com.fasterxml.jackson.core.util.a;
import com.fasterxml.jackson.core.JsonEncoding;

public class c
{
    protected final Object a;
    protected JsonEncoding b;
    protected final boolean c;
    protected final a d;
    protected byte[] e;
    protected byte[] f;
    protected char[] g;
    protected char[] h;
    protected char[] i;
    
    public c(final a d, final Object a, final boolean c) {
        this.d = d;
        this.a = a;
        this.c = c;
    }
    
    private IllegalArgumentException s() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }
    
    protected final void a(final Object o) {
        if (o == null) {
            return;
        }
        throw new IllegalStateException("Trying to call same allocXxx() method second time");
    }
    
    protected final void b(final byte[] array, final byte[] array2) {
        if (array != array2 && array.length < array2.length) {
            throw this.s();
        }
    }
    
    protected final void c(final char[] array, final char[] array2) {
        if (array != array2 && array.length < array2.length) {
            throw this.s();
        }
    }
    
    public char[] d() {
        this.a(this.h);
        return this.h = this.d.c(1);
    }
    
    public byte[] e() {
        this.a(this.e);
        return this.e = this.d.a(0);
    }
    
    public char[] f() {
        this.a(this.g);
        return this.g = this.d.c(0);
    }
    
    public char[] g(final int n) {
        this.a(this.g);
        return this.g = this.d.d(0, n);
    }
    
    public byte[] h() {
        this.a(this.f);
        return this.f = this.d.a(1);
    }
    
    public d i() {
        return new d(this.d);
    }
    
    public JsonEncoding j() {
        return this.b;
    }
    
    public Object k() {
        return this.a;
    }
    
    public boolean l() {
        return this.c;
    }
    
    public void m(final char[] array) {
        if (array != null) {
            this.c(array, this.h);
            this.h = null;
            this.d.j(1, array);
        }
    }
    
    public void n(final char[] array) {
        if (array != null) {
            this.c(array, this.i);
            this.i = null;
            this.d.j(3, array);
        }
    }
    
    public void o(final byte[] array) {
        if (array != null) {
            this.b(array, this.e);
            this.e = null;
            this.d.i(0, array);
        }
    }
    
    public void p(final char[] array) {
        if (array != null) {
            this.c(array, this.g);
            this.g = null;
            this.d.j(0, array);
        }
    }
    
    public void q(final byte[] array) {
        if (array != null) {
            this.b(array, this.f);
            this.f = null;
            this.d.i(1, array);
        }
    }
    
    public void r(final JsonEncoding b) {
        this.b = b;
    }
}
