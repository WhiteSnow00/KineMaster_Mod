// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct;

import java.util.regex.Pattern;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import com.google.android.datatransport.Encoding;
import java.util.Set;
import com.google.android.datatransport.runtime.EncodedDestination;

public final class CCTDestination implements EncodedDestination
{
    static final String c;
    static final String d;
    private static final String e;
    private static final Set<Encoding> f;
    public static final CCTDestination g;
    public static final CCTDestination h;
    private final String a;
    private final String b;
    
    static {
        final String s = c = StringMerger.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        final String s2 = d = StringMerger.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        final String s3 = e = StringMerger.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f = Collections.unmodifiableSet((Set<? extends Encoding>)new HashSet<Encoding>(Arrays.asList(Encoding.b("proto"), Encoding.b("json"))));
        g = new CCTDestination(s, null);
        h = new CCTDestination(s2, s3);
    }
    
    public CCTDestination(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public static CCTDestination c(final byte[] array) {
        final String s = new String(array, Charset.forName("UTF-8"));
        if (!s.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        final String[] split = s.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        final String s2 = split[0];
        if (!s2.isEmpty()) {
            String s3;
            if ((s3 = split[1]).isEmpty()) {
                s3 = null;
            }
            return new CCTDestination(s2, s3);
        }
        throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
    }
    
    @Override
    public Set<Encoding> a() {
        return CCTDestination.f;
    }
    
    public byte[] b() {
        final String b = this.b;
        if (b == null && this.a == null) {
            return null;
        }
        final String a = this.a;
        String s;
        if ((s = b) == null) {
            s = "";
        }
        return String.format("%s%s%s%s", "1$", a, "\\", s).getBytes(Charset.forName("UTF-8"));
    }
    
    public String d() {
        return this.b;
    }
    
    public String e() {
        return this.a;
    }
    
    @Override
    public byte[] getExtras() {
        return this.b();
    }
    
    @Override
    public String getName() {
        return "cct";
    }
}
