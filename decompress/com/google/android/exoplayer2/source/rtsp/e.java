// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.security.NoSuchAlgorithmException;
import com.google.android.exoplayer2.ParserException;
import java.security.MessageDigest;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import android.util.Base64;

final class e
{
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    
    public e(final int a, final String b, final String c, final String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    private String b(final RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo) {
        final StringBuilder sb = new StringBuilder();
        sb.append(rtspAuthUserInfo.a);
        sb.append(":");
        sb.append(rtspAuthUserInfo.b);
        return Util.C("Basic %s", Base64.encodeToString(RtspMessageUtil.d(sb.toString()), 0));
    }
    
    private String c(final RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, final Uri uri, final int n) throws ParserException {
        try {
            final MessageDigest instance = MessageDigest.getInstance("MD5");
            final String t = RtspMessageUtil.t(n);
            final StringBuilder sb = new StringBuilder();
            sb.append(rtspAuthUserInfo.a);
            sb.append(":");
            sb.append(this.b);
            sb.append(":");
            sb.append(rtspAuthUserInfo.b);
            final String a1 = Util.a1(instance.digest(RtspMessageUtil.d(sb.toString())));
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(t);
            sb2.append(":");
            sb2.append(uri);
            final String a2 = Util.a1(instance.digest(RtspMessageUtil.d(sb2.toString())));
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(a1);
            sb3.append(":");
            sb3.append(this.c);
            sb3.append(":");
            sb3.append(a2);
            final String a3 = Util.a1(instance.digest(RtspMessageUtil.d(sb3.toString())));
            if (this.d.isEmpty()) {
                return Util.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", rtspAuthUserInfo.a, this.b, this.c, uri, a3);
            }
            return Util.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", rtspAuthUserInfo.a, this.b, this.c, uri, a3, this.d);
        }
        catch (final NoSuchAlgorithmException ex) {
            throw ParserException.createForManifestWithUnsupportedFeature(null, ex);
        }
    }
    
    public String a(final RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, final Uri uri, final int n) throws ParserException {
        final int a = this.a;
        if (a == 1) {
            return this.b(rtspAuthUserInfo);
        }
        if (a == 2) {
            return this.c(rtspAuthUserInfo, uri, n);
        }
        throw ParserException.createForManifestWithUnsupportedFeature(null, new UnsupportedOperationException());
    }
}
