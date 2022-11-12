// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.audio.AacUtil;
import java.util.Collection;
import java.util.Collections;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Util;
import android.text.TextUtils;
import java.util.ArrayList;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import android.util.Base64;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import java.util.UUID;
import java.util.LinkedList;
import android.util.Pair;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.io.InputStream;
import android.net.Uri;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import com.google.android.exoplayer2.upstream.ParsingLoadable;

public class SsManifestParser implements Parser<SsManifest>
{
    private final XmlPullParserFactory a;
    
    public SsManifestParser() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        }
        catch (final XmlPullParserException ex) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", (Throwable)ex);
        }
    }
    
    @Override
    public /* bridge */ Object a(final Uri uri, final InputStream inputStream) throws IOException {
        return this.b(uri, inputStream);
    }
    
    public SsManifest b(final Uri uri, final InputStream inputStream) throws IOException {
        try {
            final XmlPullParser pullParser = this.a.newPullParser();
            pullParser.setInput(inputStream, (String)null);
            return (SsManifest)((a)new d(null, uri.toString())).f(pullParser);
        }
        catch (final XmlPullParserException ex) {
            throw ParserException.createForMalformedManifest(null, (Throwable)ex);
        }
    }
    
    public static class MissingFieldException extends ParserException
    {
        public MissingFieldException(final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Missing required field: ");
            sb.append(s);
            super(sb.toString(), null, true, 4);
        }
    }
    
    private abstract static class a
    {
        private final String a;
        private final String b;
        private final a c;
        private final List<Pair<String, Object>> d;
        
        public a(final a c, final String a, final String b) {
            this.c = c;
            this.a = a;
            this.b = b;
            this.d = new LinkedList<Pair<String, Object>>();
        }
        
        private a e(final a a, final String s, final String s2) {
            if ("QualityLevel".equals(s)) {
                return (a)new c(a, s2);
            }
            if ("Protection".equals(s)) {
                return (a)new b(a, s2);
            }
            if ("StreamIndex".equals(s)) {
                return (a)new e(a, s2);
            }
            return null;
        }
        
        protected void a(final Object o) {
        }
        
        protected abstract Object b();
        
        protected final Object c(final String s) {
            for (int i = 0; i < this.d.size(); ++i) {
                final Pair pair = this.d.get(i);
                if (((String)pair.first).equals(s)) {
                    return pair.second;
                }
            }
            final a c = this.c;
            Object c2;
            if (c == null) {
                c2 = null;
            }
            else {
                c2 = c.c(s);
            }
            return c2;
        }
        
        protected boolean d(final String s) {
            return false;
        }
        
        public final Object f(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            int n = 0;
            int n2 = 0;
            while (true) {
                final int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                int n3;
                int n4;
                if (eventType != 2) {
                    if (eventType != 3) {
                        if (eventType != 4) {
                            n3 = n;
                            n4 = n2;
                        }
                        else {
                            n3 = n;
                            n4 = n2;
                            if (n != 0) {
                                n3 = n;
                                if ((n4 = n2) == 0) {
                                    this.o(xmlPullParser);
                                    n3 = n;
                                    n4 = n2;
                                }
                            }
                        }
                    }
                    else {
                        n3 = n;
                        n4 = n2;
                        if (n != 0) {
                            if (n2 > 0) {
                                n4 = n2 - 1;
                                n3 = n;
                            }
                            else {
                                final String name = xmlPullParser.getName();
                                this.h(xmlPullParser);
                                n3 = n;
                                n4 = n2;
                                if (!this.d(name)) {
                                    return this.b();
                                }
                            }
                        }
                    }
                }
                else {
                    final String name2 = xmlPullParser.getName();
                    if (this.b.equals(name2)) {
                        this.n(xmlPullParser);
                        n3 = 1;
                        n4 = n2;
                    }
                    else {
                        n3 = n;
                        n4 = n2;
                        if (n != 0) {
                            if (n2 > 0) {
                                n4 = n2 + 1;
                                n3 = n;
                            }
                            else if (this.d(name2)) {
                                this.n(xmlPullParser);
                                n3 = n;
                                n4 = n2;
                            }
                            else {
                                final a e = this.e(this, name2, this.a);
                                if (e == null) {
                                    n4 = 1;
                                    n3 = n;
                                }
                                else {
                                    this.a(e.f(xmlPullParser));
                                    n4 = n2;
                                    n3 = n;
                                }
                            }
                        }
                    }
                }
                xmlPullParser.next();
                n = n3;
                n2 = n4;
            }
        }
        
        protected final boolean g(final XmlPullParser xmlPullParser, final String s, final boolean b) {
            final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
            if (attributeValue != null) {
                return Boolean.parseBoolean(attributeValue);
            }
            return b;
        }
        
        protected void h(final XmlPullParser xmlPullParser) {
        }
        
        protected final int i(final XmlPullParser xmlPullParser, final String s, int int1) throws ParserException {
            final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
            if (attributeValue != null) {
                try {
                    int1 = Integer.parseInt(attributeValue);
                    return int1;
                }
                catch (final NumberFormatException ex) {
                    throw ParserException.createForMalformedManifest(null, ex);
                }
            }
            return int1;
        }
        
        protected final long j(final XmlPullParser xmlPullParser, final String s, long long1) throws ParserException {
            final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
            if (attributeValue != null) {
                try {
                    long1 = Long.parseLong(attributeValue);
                    return long1;
                }
                catch (final NumberFormatException ex) {
                    throw ParserException.createForMalformedManifest(null, ex);
                }
            }
            return long1;
        }
        
        protected final int k(final XmlPullParser xmlPullParser, final String s) throws ParserException {
            final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                }
                catch (final NumberFormatException ex) {
                    throw ParserException.createForMalformedManifest(null, ex);
                }
            }
            throw new MissingFieldException(s);
        }
        
        protected final long l(final XmlPullParser xmlPullParser, final String s) throws ParserException {
            final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                }
                catch (final NumberFormatException ex) {
                    throw ParserException.createForMalformedManifest(null, ex);
                }
            }
            throw new MissingFieldException(s);
        }
        
        protected final String m(final XmlPullParser xmlPullParser, final String s) throws MissingFieldException {
            final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(s);
        }
        
        protected abstract void n(final XmlPullParser p0) throws ParserException;
        
        protected void o(final XmlPullParser xmlPullParser) {
        }
        
        protected final void p(final String s, final Object o) {
            this.d.add((Pair<String, Object>)Pair.create((Object)s, o));
        }
    }
    
    private static class b extends a
    {
        private boolean e;
        private UUID f;
        private byte[] g;
        
        public b(final a a, final String s) {
            super(a, s, "Protection");
        }
        
        private static TrackEncryptionBox[] q(final byte[] array) {
            return new TrackEncryptionBox[] { new TrackEncryptionBox(true, null, 8, r(array), 0, 0, null) };
        }
        
        private static byte[] r(byte[] decode) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < decode.length; i += 2) {
                sb.append((char)decode[i]);
            }
            final String string = sb.toString();
            decode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }
        
        private static String s(final String s) {
            String substring = s;
            if (s.charAt(0) == '{') {
                substring = s;
                if (s.charAt(s.length() - 1) == '}') {
                    substring = s.substring(1, s.length() - 1);
                }
            }
            return substring;
        }
        
        private static void t(final byte[] array, final int n, final int n2) {
            final byte b = array[n];
            array[n] = array[n2];
            array[n2] = b;
        }
        
        public Object b() {
            final UUID f = this.f;
            return new SsManifest.ProtectionElement(f, PsshAtomUtil.a(f, this.g), q(this.g));
        }
        
        public boolean d(final String s) {
            return "ProtectionHeader".equals(s);
        }
        
        public void h(final XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = false;
            }
        }
        
        public void n(final XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.e = true;
                this.f = UUID.fromString(s(xmlPullParser.getAttributeValue((String)null, "SystemID")));
            }
        }
        
        public void o(final XmlPullParser xmlPullParser) {
            if (this.e) {
                this.g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }
    
    private static class c extends a
    {
        private Format e;
        
        public c(final a a, final String s) {
            super(a, s, "QualityLevel");
        }
        
        private static List<byte[]> q(final String s) {
            final ArrayList list = new ArrayList();
            if (!TextUtils.isEmpty((CharSequence)s)) {
                final byte[] j = Util.J(s);
                final byte[][] i = CodecSpecificDataUtil.j(j);
                if (i == null) {
                    list.add(j);
                }
                else {
                    Collections.addAll(list, i);
                }
            }
            return list;
        }
        
        private static String r(final String s) {
            if (s.equalsIgnoreCase("H264") || s.equalsIgnoreCase("X264") || s.equalsIgnoreCase("AVC1") || s.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (s.equalsIgnoreCase("AAC") || s.equalsIgnoreCase("AACL") || s.equalsIgnoreCase("AACH") || s.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (s.equalsIgnoreCase("TTML") || s.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (s.equalsIgnoreCase("ac-3") || s.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (s.equalsIgnoreCase("ec-3") || s.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (s.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (s.equalsIgnoreCase("dtsh") || s.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (s.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (s.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }
        
        public Object b() {
            return this.e;
        }
        
        public void n(final XmlPullParser xmlPullParser) throws ParserException {
            final Format.Builder builder = new Format.Builder();
            final String r = r(((a)this).m(xmlPullParser, "FourCC"));
            final int intValue = (int)((a)this).c("Type");
            String s;
            if (intValue == 2) {
                builder.K("video/mp4").j0(((a)this).k(xmlPullParser, "MaxWidth")).Q(((a)this).k(xmlPullParser, "MaxHeight")).T(q(xmlPullParser.getAttributeValue((String)null, "CodecPrivateData")));
                s = r;
            }
            else if (intValue == 1) {
                if ((s = r) == null) {
                    s = "audio/mp4a-latm";
                }
                final int k = ((a)this).k(xmlPullParser, "Channels");
                final int i = ((a)this).k(xmlPullParser, "SamplingRate");
                List<byte[]> list2;
                final List<byte[]> list = list2 = q(xmlPullParser.getAttributeValue((String)null, "CodecPrivateData"));
                if (list.isEmpty()) {
                    list2 = list;
                    if ("audio/mp4a-latm".equals(s)) {
                        list2 = Collections.singletonList(AacUtil.a(i, k));
                    }
                }
                builder.K("audio/mp4").H(k).f0(i).T(list2);
            }
            else if (intValue == 3) {
                final int n = 0;
                final String s2 = (String)((a)this).c("Subtype");
                int n2 = n;
                if (s2 != null) {
                    if (!s2.equals("CAPT")) {
                        if (!s2.equals("DESC")) {
                            n2 = n;
                        }
                        else {
                            n2 = 1024;
                        }
                    }
                    else {
                        n2 = 64;
                    }
                }
                builder.K("application/mp4").c0(n2);
                s = r;
            }
            else {
                builder.K("application/mp4");
                s = r;
            }
            this.e = builder.S(xmlPullParser.getAttributeValue((String)null, "Index")).U((String)((a)this).c("Name")).e0(s).G(((a)this).k(xmlPullParser, "Bitrate")).V((String)((a)this).c("Language")).E();
        }
    }
    
    private static class d extends a
    {
        private final List<SsManifest.StreamElement> e;
        private int f;
        private int g;
        private long h;
        private long i;
        private long j;
        private int k;
        private boolean l;
        private SsManifest.ProtectionElement m;
        
        public d(final a a, final String s) {
            super(a, s, "SmoothStreamingMedia");
            this.k = -1;
            this.m = null;
            this.e = new LinkedList<SsManifest.StreamElement>();
        }
        
        public void a(final Object o) {
            if (o instanceof SsManifest.StreamElement) {
                this.e.add((SsManifest.StreamElement)o);
            }
            else if (o instanceof SsManifest.ProtectionElement) {
                Assertions.g(this.m == null);
                this.m = (SsManifest.ProtectionElement)o;
            }
        }
        
        public Object b() {
            final int size = this.e.size();
            final SsManifest.StreamElement[] array = new SsManifest.StreamElement[size];
            this.e.toArray(array);
            if (this.m != null) {
                final SsManifest.ProtectionElement m = this.m;
                final DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(m.a, "video/mp4", m.b) });
                for (final SsManifest.StreamElement streamElement : array) {
                    final int a = streamElement.a;
                    if (a == 2 || a == 1) {
                        final Format[] j = streamElement.j;
                        for (int k = 0; k < j.length; ++k) {
                            j[k] = j[k].b().M(drmInitData).E();
                        }
                    }
                }
            }
            return new SsManifest(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, array);
        }
        
        public void n(final XmlPullParser xmlPullParser) throws ParserException {
            this.f = ((a)this).k(xmlPullParser, "MajorVersion");
            this.g = ((a)this).k(xmlPullParser, "MinorVersion");
            this.h = ((a)this).j(xmlPullParser, "TimeScale", 10000000L);
            this.i = ((a)this).l(xmlPullParser, "Duration");
            this.j = ((a)this).j(xmlPullParser, "DVRWindowLength", 0L);
            this.k = ((a)this).i(xmlPullParser, "LookaheadCount", -1);
            this.l = ((a)this).g(xmlPullParser, "IsLive", false);
            ((a)this).p("TimeScale", this.h);
        }
    }
    
    private static class e extends a
    {
        private final String e;
        private final List<Format> f;
        private int g;
        private String h;
        private long i;
        private String j;
        private String k;
        private int l;
        private int m;
        private int n;
        private int o;
        private String p;
        private ArrayList<Long> q;
        private long r;
        
        public e(final a a, final String e) {
            super(a, e, "StreamIndex");
            this.e = e;
            this.f = new LinkedList<Format>();
        }
        
        private void q(final XmlPullParser xmlPullParser) throws ParserException {
            final int s = this.s(xmlPullParser);
            this.g = s;
            ((a)this).p("Type", s);
            if (this.g == 3) {
                this.h = ((a)this).m(xmlPullParser, "Subtype");
            }
            else {
                this.h = xmlPullParser.getAttributeValue((String)null, "Subtype");
            }
            ((a)this).p("Subtype", this.h);
            ((a)this).p("Name", this.j = xmlPullParser.getAttributeValue((String)null, "Name"));
            this.k = ((a)this).m(xmlPullParser, "Url");
            this.l = ((a)this).i(xmlPullParser, "MaxWidth", -1);
            this.m = ((a)this).i(xmlPullParser, "MaxHeight", -1);
            this.n = ((a)this).i(xmlPullParser, "DisplayWidth", -1);
            this.o = ((a)this).i(xmlPullParser, "DisplayHeight", -1);
            ((a)this).p("Language", this.p = xmlPullParser.getAttributeValue((String)null, "Language"));
            final long i = ((a)this).i(xmlPullParser, "TimeScale", -1);
            this.i = i;
            if (i == -1L) {
                this.i = (long)((a)this).c("TimeScale");
            }
            this.q = new ArrayList<Long>();
        }
        
        private void r(final XmlPullParser xmlPullParser) throws ParserException {
            final int size = this.q.size();
            final long j = ((a)this).j(xmlPullParser, "t", -9223372036854775807L);
            final int n = 1;
            long n2 = j;
            if (j == -9223372036854775807L) {
                if (size == 0) {
                    n2 = 0L;
                }
                else {
                    if (this.r == -1L) {
                        throw ParserException.createForMalformedManifest("Unable to infer start time", null);
                    }
                    n2 = this.r + this.q.get(size - 1);
                }
            }
            this.q.add(n2);
            this.r = ((a)this).j(xmlPullParser, "d", -9223372036854775807L);
            final long i = ((a)this).j(xmlPullParser, "r", 1L);
            int n3 = n;
            if (i > 1L) {
                if (this.r == -9223372036854775807L) {
                    throw ParserException.createForMalformedManifest("Repeated chunk with unspecified duration", null);
                }
                n3 = n;
            }
            while (true) {
                final long n4 = n3;
                if (n4 >= i) {
                    break;
                }
                this.q.add(this.r * n4 + n2);
                ++n3;
            }
        }
        
        private int s(final XmlPullParser xmlPullParser) throws ParserException {
            final String attributeValue = xmlPullParser.getAttributeValue((String)null, "Type");
            if (attributeValue == null) {
                throw new MissingFieldException("Type");
            }
            if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if ("text".equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid key value[");
            sb.append(attributeValue);
            sb.append("]");
            throw ParserException.createForMalformedManifest(sb.toString(), null);
        }
        
        public void a(final Object o) {
            if (o instanceof Format) {
                this.f.add((Format)o);
            }
        }
        
        public Object b() {
            final Format[] array = new Format[this.f.size()];
            this.f.toArray(array);
            return new SsManifest.StreamElement(this.e, this.k, this.g, this.h, this.i, this.j, this.l, this.m, this.n, this.o, this.p, array, this.q, this.r);
        }
        
        public boolean d(final String s) {
            return "c".equals(s);
        }
        
        public void n(final XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                this.r(xmlPullParser);
            }
            else {
                this.q(xmlPullParser);
            }
        }
    }
}
