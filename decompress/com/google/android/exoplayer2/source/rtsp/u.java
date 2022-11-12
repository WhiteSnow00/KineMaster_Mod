// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.regex.Matcher;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Strings;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ParserException;
import java.util.regex.Pattern;

final class u
{
    private static final Pattern a;
    private static final Pattern b;
    private static final Pattern c;
    
    static {
        a = Pattern.compile("([a-z])=\\s?(.+)");
        b = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");
        c = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");
    }
    
    private static void a(final SessionDescription.Builder ex, final MediaDescription.Builder builder) throws ParserException {
        try {
            ((SessionDescription.Builder)ex).n(builder.j());
            return;
        }
        catch (final IllegalStateException ex) {}
        catch (final IllegalArgumentException ex2) {}
        throw ParserException.createForMalformedManifest(null, ex);
    }
    
    public static SessionDescription b(String ex) throws ParserException {
        final SessionDescription.Builder builder = new SessionDescription.Builder();
        final String[] s = RtspMessageUtil.s((String)ex);
        final int length = s.length;
        int i = 0;
        ex = null;
        while (i < length) {
            final String s2 = s[i];
            if (!"".equals(s2)) {
                final Matcher matcher = u.a.matcher(s2);
                if (!matcher.matches()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Malformed SDP line: ");
                    sb.append(s2);
                    throw ParserException.createForMalformedManifest(sb.toString(), null);
                }
                final String s3 = Assertions.e(matcher.group(1));
                final String s4 = Assertions.e(matcher.group(2));
                switch (s3) {
                    case "m": {
                        if (ex != null) {
                            a(builder, (MediaDescription.Builder)ex);
                        }
                        ex = (IllegalStateException)c(s4);
                        break;
                    }
                    case "a": {
                        final Matcher matcher2 = u.b.matcher(s4);
                        if (!matcher2.matches()) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Malformed Attribute line: ");
                            sb2.append(s2);
                            throw ParserException.createForMalformedManifest(sb2.toString(), null);
                        }
                        final String s5 = Assertions.e(matcher2.group(1));
                        final String e = Strings.e(matcher2.group(2));
                        if (ex == null) {
                            builder.m(s5, e);
                            break;
                        }
                        ((MediaDescription.Builder)ex).i(s5, e);
                        break;
                    }
                    case "k": {
                        if (ex == null) {
                            builder.s(s4);
                            break;
                        }
                        ((MediaDescription.Builder)ex).o(s4);
                        break;
                    }
                    case "t": {
                        builder.x(s4);
                        break;
                    }
                    case "b": {
                        final String[] t0 = Util.T0(s4, ":\\s?");
                        Assertions.a(t0.length == 2);
                        final int int1 = Integer.parseInt(t0[1]);
                        if (ex == null) {
                            builder.p(int1 * 1000);
                            break;
                        }
                        ((MediaDescription.Builder)ex).m(int1 * 1000);
                        break;
                    }
                    case "c": {
                        if (ex == null) {
                            builder.q(s4);
                            break;
                        }
                        ((MediaDescription.Builder)ex).n(s4);
                        break;
                    }
                    case "p": {
                        builder.u(s4);
                        break;
                    }
                    case "e": {
                        builder.r(s4);
                        break;
                    }
                    case "u": {
                        builder.y(Uri.parse(s4));
                        break;
                    }
                    case "i": {
                        if (ex == null) {
                            builder.v(s4);
                            break;
                        }
                        ((MediaDescription.Builder)ex).p(s4);
                        break;
                    }
                    case "s": {
                        builder.w(s4);
                        break;
                    }
                    case "o": {
                        builder.t(s4);
                        break;
                    }
                    case "v": {
                        if ("0".equals(s4)) {
                            break;
                        }
                        throw ParserException.createForMalformedManifest(String.format("SDP version %s is not supported.", s4), null);
                    }
                }
            }
            ++i;
        }
        if (ex != null) {
            a(builder, (MediaDescription.Builder)ex);
        }
        try {
            ex = (IllegalStateException)builder.o();
            return (SessionDescription)ex;
        }
        catch (final IllegalStateException ex) {}
        catch (final IllegalArgumentException ex2) {}
        throw ParserException.createForMalformedManifest(null, ex);
    }
    
    private static MediaDescription.Builder c(final String s) throws ParserException {
        final Matcher matcher = u.c.matcher(s);
        if (matcher.matches()) {
            final String s2 = Assertions.e(matcher.group(1));
            final String s3 = Assertions.e(matcher.group(2));
            final String s4 = Assertions.e(matcher.group(3));
            final String s5 = Assertions.e(matcher.group(4));
            try {
                return new MediaDescription.Builder(s2, Integer.parseInt(s3), s4, Integer.parseInt(s5));
            }
            catch (final NumberFormatException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Malformed SDP media description line: ");
                sb.append(s);
                throw ParserException.createForMalformedManifest(sb.toString(), ex);
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Malformed SDP media description line: ");
        sb2.append(s);
        throw ParserException.createForMalformedManifest(sb2.toString(), null);
    }
}
