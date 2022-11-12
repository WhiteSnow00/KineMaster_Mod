// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList;
import android.net.Uri;

final class t
{
    public final long a;
    public final int b;
    public final Uri c;
    
    private t(final long a, final int b, final Uri c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static ImmutableList<t> a(final String s, final Uri uri) throws ParserException {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        for (final String s2 : Util.T0(s, ",")) {
            final String[] t2 = Util.T0(s2, ";");
            final int length2 = t2.length;
            int j = 0;
            Uri b = null;
            int int1 = -1;
            long long1 = -9223372036854775807L;
            while (j < length2) {
                final String s3 = t2[j];
                try {
                    final String[] u0 = Util.U0(s3, "=");
                    final String s4 = u0[0];
                    final String s5 = u0[1];
                    final int hashCode = s4.hashCode();
                    int n = 0;
                    Label_0172: {
                        if (hashCode != 113759) {
                            if (hashCode != 116079) {
                                if (hashCode == 1524180539) {
                                    if (s4.equals("rtptime")) {
                                        n = 2;
                                        break Label_0172;
                                    }
                                }
                            }
                            else if (s4.equals("url")) {
                                n = 0;
                                break Label_0172;
                            }
                        }
                        else if (s4.equals("seq")) {
                            n = 1;
                            break Label_0172;
                        }
                        n = -1;
                    }
                    if (n != 0) {
                        if (n != 1) {
                            if (n != 2) {
                                throw ParserException.createForMalformedManifest(s4, null);
                            }
                            long1 = Long.parseLong(s5);
                        }
                        else {
                            int1 = Integer.parseInt(s5);
                        }
                    }
                    else {
                        b = b(s5, uri);
                    }
                    ++j;
                    continue;
                }
                catch (final Exception ex) {
                    throw ParserException.createForMalformedManifest(s3, ex);
                }
                break;
            }
            if (b == null || b.getScheme() == null || (int1 == -1 && long1 == -9223372036854775807L)) {
                throw ParserException.createForMalformedManifest(s2, null);
            }
            immutableList$Builder.i((Object)new t(long1, int1, b));
        }
        return (ImmutableList<t>)immutableList$Builder.l();
    }
    
    static Uri b(final String s, final Uri uri) {
        Assertions.a(Assertions.e(uri.getScheme()).equals("rtsp"));
        final Uri parse = Uri.parse(s);
        if (parse.isAbsolute()) {
            return parse;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("rtsp://");
        sb.append(s);
        final Uri parse2 = Uri.parse(sb.toString());
        final String string = uri.toString();
        if (Assertions.e(parse2.getHost()).equals(uri.getHost())) {
            return parse2;
        }
        Uri uri2;
        if (string.endsWith("/")) {
            uri2 = UriUtil.e(string, s);
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append("/");
            uri2 = UriUtil.e(sb2.toString(), s);
        }
        return uri2;
    }
}
