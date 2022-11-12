// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import java.net.URI;

public class HostInfo
{
    private final String a;
    private final String b;
    private final boolean c;
    
    public HostInfo(final String a, final String b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static URI a(String s, final boolean b, String s2, final String s3) {
        String s4;
        if (b) {
            s4 = "wss";
        }
        else {
            s4 = "ws";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s4);
        sb.append("://");
        sb.append(s);
        sb.append("/.ws?ns=");
        sb.append(s2);
        sb.append("&");
        sb.append("v");
        sb.append("=");
        sb.append("5");
        s2 = (s = sb.toString());
        if (s3 != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s2);
            sb2.append("&ls=");
            sb2.append(s3);
            s = sb2.toString();
        }
        return URI.create(s);
    }
    
    public String b() {
        return this.a;
    }
    
    public String c() {
        return this.b;
    }
    
    public boolean d() {
        return this.c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("http");
        String s;
        if (this.c) {
            s = "s";
        }
        else {
            s = "";
        }
        sb.append(s);
        sb.append("://");
        sb.append(this.a);
        return sb.toString();
    }
}
