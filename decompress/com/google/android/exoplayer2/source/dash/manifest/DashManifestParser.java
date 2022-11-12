// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.common.collect.ImmutableList;
import java.io.InputStream;
import java.util.Collection;
import android.net.Uri;
import org.xmlpull.v1.XmlSerializer;
import java.io.OutputStream;
import com.google.common.base.Charsets;
import android.util.Xml;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import android.util.Base64;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import java.util.UUID;
import android.util.Pair;
import com.google.common.collect.Lists;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Assertions;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.io.IOException;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import org.xmlpull.v1.XmlPullParser;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Log;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import org.xml.sax.helpers.DefaultHandler;

public class DashManifestParser extends DefaultHandler implements Parser<DashManifest>
{
    private static final Pattern b;
    private static final Pattern c;
    private static final Pattern d;
    private static final int[] e;
    private final XmlPullParserFactory a;
    
    static {
        b = Pattern.compile("(\\d+)(?:/(\\d+))?");
        c = Pattern.compile("CC([1-4])=.*");
        d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
        e = new int[] { -1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14 };
    }
    
    public DashManifestParser() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        }
        catch (final XmlPullParserException ex) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", (Throwable)ex);
        }
    }
    
    protected static int D(final List<Descriptor> list) {
        for (int i = 0; i < list.size(); ++i) {
            final Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.a)) {
                final String b = descriptor.b;
                if (b != null) {
                    final Matcher matcher = DashManifestParser.c.matcher(b);
                    if (matcher.matches()) {
                        return Integer.parseInt(matcher.group(1));
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unable to parse CEA-608 channel number from: ");
                    sb.append(descriptor.b);
                    Log.i("MpdParser", sb.toString());
                }
            }
        }
        return -1;
    }
    
    protected static int E(final List<Descriptor> list) {
        for (int i = 0; i < list.size(); ++i) {
            final Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.a)) {
                final String b = descriptor.b;
                if (b != null) {
                    final Matcher matcher = DashManifestParser.d.matcher(b);
                    if (matcher.matches()) {
                        return Integer.parseInt(matcher.group(1));
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unable to parse CEA-708 service block number from: ");
                    sb.append(descriptor.b);
                    Log.i("MpdParser", sb.toString());
                }
            }
        }
        return -1;
    }
    
    protected static long H(final XmlPullParser xmlPullParser, final String s, final long n) throws ParserException {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue == null) {
            return n;
        }
        return Util.J0(attributeValue);
    }
    
    protected static Descriptor I(final XmlPullParser xmlPullParser, final String s) throws XmlPullParserException, IOException {
        final String r0 = r0(xmlPullParser, "schemeIdUri", "");
        final String r2 = r0(xmlPullParser, "value", null);
        final String r3 = r0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.d(xmlPullParser, s));
        return new Descriptor(r0, r2, r3);
    }
    
    protected static int J(final XmlPullParser xmlPullParser) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "value");
        if (attributeValue == null) {
            return -1;
        }
        final String e = Ascii.e(attributeValue);
        e.hashCode();
        int n = 0;
        Label_0142: {
            switch (e) {
                case "fa01": {
                    n = 3;
                    break Label_0142;
                }
                case "f801": {
                    n = 2;
                    break Label_0142;
                }
                case "a000": {
                    n = 1;
                    break Label_0142;
                }
                case "4000": {
                    n = 0;
                    break Label_0142;
                }
                default:
                    break;
            }
            n = -1;
        }
        switch (n) {
            default: {
                return -1;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 6;
            }
            case 1: {
                return 2;
            }
            case 0: {
                return 1;
            }
        }
    }
    
    protected static int K(final XmlPullParser xmlPullParser) {
        final int n = -1;
        final int u = U(xmlPullParser, "value", -1);
        int n2 = n;
        if (u > 0) {
            n2 = n;
            if (u < 33) {
                n2 = u;
            }
        }
        return n2;
    }
    
    protected static int L(final XmlPullParser xmlPullParser) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "value");
        final int n = -1;
        if (attributeValue == null) {
            return -1;
        }
        int bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16));
        if (bitCount == 0) {
            bitCount = n;
        }
        return bitCount;
    }
    
    protected static long M(final XmlPullParser xmlPullParser, final String s, final long n) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue == null) {
            return n;
        }
        return Util.K0(attributeValue);
    }
    
    protected static String N(final List<Descriptor> list) {
        for (int i = 0; i < list.size(); ++i) {
            final Descriptor descriptor = list.get(i);
            final String a = descriptor.a;
            if (("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(a) && "JOC".equals(descriptor.b)) || ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(a) && "ec+3".equals(descriptor.b))) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }
    
    protected static float R(final XmlPullParser xmlPullParser, final String s, float float1) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue != null) {
            float1 = Float.parseFloat(attributeValue);
        }
        return float1;
    }
    
    protected static float S(final XmlPullParser xmlPullParser, final float n) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "frameRate");
        float n2 = n;
        if (attributeValue != null) {
            final Matcher matcher = DashManifestParser.b.matcher(attributeValue);
            n2 = n;
            if (matcher.matches()) {
                final int int1 = Integer.parseInt(matcher.group(1));
                final String group = matcher.group(2);
                if (!TextUtils.isEmpty((CharSequence)group)) {
                    n2 = int1 / (float)Integer.parseInt(group);
                }
                else {
                    n2 = (float)int1;
                }
            }
        }
        return n2;
    }
    
    protected static int U(final XmlPullParser xmlPullParser, final String s, int int1) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue != null) {
            int1 = Integer.parseInt(attributeValue);
        }
        return int1;
    }
    
    protected static long W(final List<Descriptor> list) {
        for (int i = 0; i < list.size(); ++i) {
            final Descriptor descriptor = list.get(i);
            if (Ascii.a((CharSequence)"http://dashif.org/guidelines/last-segment-number", (CharSequence)descriptor.a)) {
                return Long.parseLong(descriptor.b);
            }
        }
        return -1L;
    }
    
    protected static long X(final XmlPullParser xmlPullParser, final String s, long long1) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue != null) {
            long1 = Long.parseLong(attributeValue);
        }
        return long1;
    }
    
    protected static int Z(final XmlPullParser xmlPullParser) {
        final int n = -1;
        final int u = U(xmlPullParser, "value", -1);
        int n2 = n;
        if (u >= 0) {
            final int[] e = DashManifestParser.e;
            n2 = n;
            if (u < e.length) {
                n2 = e[u];
            }
        }
        return n2;
    }
    
    private long b(final List<SegmentBase.SegmentTimelineElement> list, long n, final long n2, int n3, final long n4) {
        if (n3 >= 0) {
            ++n3;
        }
        else {
            n3 = (int)Util.m(n4 - n, n2);
        }
        for (int i = 0; i < n3; ++i) {
            list.add(this.m(n, n2));
            n += n2;
        }
        return n;
    }
    
    private static int p(final int n, final int n2) {
        if (n == -1) {
            return n2;
        }
        if (n2 == -1) {
            return n;
        }
        Assertions.g(n == n2);
        return n;
    }
    
    private static String q(final String s, final String s2) {
        if (s == null) {
            return s2;
        }
        if (s2 == null) {
            return s;
        }
        Assertions.g(s.equals(s2));
        return s;
    }
    
    private static void r(final ArrayList<DrmInitData.SchemeData> list) {
        final int n = 0;
        while (true) {
            for (int i = 0; i < list.size(); ++i) {
                final DrmInitData.SchemeData schemeData = list.get(i);
                if (C.c.equals(schemeData.b)) {
                    final String c = schemeData.c;
                    if (c != null) {
                        list.remove(i);
                        int j = n;
                        if (c == null) {
                            return;
                        }
                        while (j < list.size()) {
                            final DrmInitData.SchemeData schemeData2 = list.get(j);
                            if (C.b.equals(schemeData2.b) && schemeData2.c == null) {
                                list.set(j, new DrmInitData.SchemeData(C.c, c, schemeData2.d, schemeData2.e));
                            }
                            ++j;
                        }
                        return;
                    }
                }
            }
            final String c = null;
            continue;
        }
    }
    
    protected static String r0(final XmlPullParser xmlPullParser, final String s, String s2) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue != null) {
            s2 = attributeValue;
        }
        return s2;
    }
    
    private static void s(final ArrayList<DrmInitData.SchemeData> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            final DrmInitData.SchemeData schemeData = list.get(i);
            if (!schemeData.c()) {
                for (int j = 0; j < list.size(); ++j) {
                    if (((DrmInitData.SchemeData)list.get(j)).a(schemeData)) {
                        list.remove(i);
                        break;
                    }
                }
            }
        }
    }
    
    protected static String s0(final XmlPullParser xmlPullParser, final String s) throws XmlPullParserException, IOException {
        String s2 = "";
        String text;
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            }
            else {
                w(xmlPullParser);
                text = s2;
            }
            s2 = text;
        } while (!XmlPullParserUtil.d(xmlPullParser, s));
        return text;
    }
    
    private static long t(long n, final long n2) {
        final long n3 = -9223372036854775807L;
        if (n2 != -9223372036854775807L) {
            n = n2;
        }
        if (n == Long.MAX_VALUE) {
            n = n3;
        }
        return n;
    }
    
    private static String u(String g, String s) {
        if (MimeTypes.o(g)) {
            return MimeTypes.c(s);
        }
        if (MimeTypes.s(g)) {
            return MimeTypes.n(s);
        }
        if (MimeTypes.r(g)) {
            return g;
        }
        if (MimeTypes.p(g)) {
            return g;
        }
        if ("application/mp4".equals(g)) {
            s = (g = MimeTypes.g(s));
            if ("text/vtt".equals(s)) {
                g = "application/x-mp4-vtt";
            }
            return g;
        }
        return null;
    }
    
    private boolean v(final String[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i].startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }
    
    public static void w(final XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (!XmlPullParserUtil.e(xmlPullParser)) {
            return;
        }
        int i = 1;
        while (i != 0) {
            xmlPullParser.next();
            if (XmlPullParserUtil.e(xmlPullParser)) {
                ++i;
            }
            else {
                if (!XmlPullParserUtil.c(xmlPullParser)) {
                    continue;
                }
                --i;
            }
        }
    }
    
    protected int A(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        final String r0 = r0(xmlPullParser, "schemeIdUri", null);
        r0.hashCode();
        final int hashCode = r0.hashCode();
        final int n = -1;
        int n2 = 0;
        Label_0228: {
            switch (hashCode) {
                case 2036691300: {
                    if (!r0.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                        break;
                    }
                    n2 = 6;
                    break Label_0228;
                }
                case 312179081: {
                    if (!r0.equals("tag:dts.com,2018:uhd:audio_channel_configuration")) {
                        break;
                    }
                    n2 = 5;
                    break Label_0228;
                }
                case -79006963: {
                    if (!r0.equals("tag:dts.com,2014:dash:audio_channel_configuration:2012")) {
                        break;
                    }
                    n2 = 4;
                    break Label_0228;
                }
                case -986633423: {
                    if (!r0.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                        break;
                    }
                    n2 = 3;
                    break Label_0228;
                }
                case -1138141449: {
                    if (!r0.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                        break;
                    }
                    n2 = 2;
                    break Label_0228;
                }
                case -1352850286: {
                    if (!r0.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                        break;
                    }
                    n2 = 1;
                    break Label_0228;
                }
                case -2128649360: {
                    if (!r0.equals("urn:dts:dash:audio_channel_configuration:2012")) {
                        break;
                    }
                    n2 = 0;
                    break Label_0228;
                }
            }
            n2 = -1;
        }
        int n3 = 0;
        switch (n2) {
            default: {
                n3 = n;
                break;
            }
            case 5: {
                n3 = L(xmlPullParser);
                break;
            }
            case 3: {
                n3 = Z(xmlPullParser);
                break;
            }
            case 2:
            case 6: {
                n3 = J(xmlPullParser);
                break;
            }
            case 1: {
                n3 = U(xmlPullParser, "value", -1);
                break;
            }
            case 0:
            case 4: {
                n3 = K(xmlPullParser);
                break;
            }
        }
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.d(xmlPullParser, "AudioChannelConfiguration"));
        return n3;
    }
    
    protected long B(final XmlPullParser xmlPullParser, final long n) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return n;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long)(Float.parseFloat(attributeValue) * 1000000.0f);
    }
    
    protected List<BaseUrl> C(final XmlPullParser xmlPullParser, final List<BaseUrl> list, final boolean b) throws XmlPullParserException, IOException {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "dvb:priority");
        int int1;
        if (attributeValue != null) {
            int1 = Integer.parseInt(attributeValue);
        }
        else if (b) {
            int1 = 1;
        }
        else {
            int1 = Integer.MIN_VALUE;
        }
        final String attributeValue2 = xmlPullParser.getAttributeValue((String)null, "dvb:weight");
        int int2;
        if (attributeValue2 != null) {
            int2 = Integer.parseInt(attributeValue2);
        }
        else {
            int2 = 1;
        }
        final String attributeValue3 = xmlPullParser.getAttributeValue((String)null, "serviceLocation");
        final String s0 = s0(xmlPullParser, "BaseURL");
        final boolean b2 = UriUtil.b(s0);
        int i = 0;
        if (b2) {
            String s2;
            if ((s2 = attributeValue3) == null) {
                s2 = s0;
            }
            return Lists.l((Object[])new BaseUrl[] { new BaseUrl(s0, s2, int1, int2) });
        }
        final ArrayList list2 = new ArrayList();
        int c = int1;
        while (i < list.size()) {
            final BaseUrl baseUrl = list.get(i);
            final String d = UriUtil.d(baseUrl.a, s0);
            String b3;
            if (attributeValue3 == null) {
                b3 = d;
            }
            else {
                b3 = attributeValue3;
            }
            int d2 = int2;
            if (b) {
                c = baseUrl.c;
                d2 = baseUrl.d;
                b3 = baseUrl.b;
            }
            list2.add(new BaseUrl(d, b3, c, d2));
            ++i;
            int2 = d2;
        }
        return list2;
    }
    
    protected Pair<String, DrmInitData.SchemeData> F(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        final Object o = null;
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "schemeIdUri");
        while (true) {
            String attributeValue2 = null;
            UUID uuid = null;
            Label_0337: {
                Label_0334: {
                    Label_0331: {
                        if (attributeValue != null) {
                            final String e = Ascii.e(attributeValue);
                            e.hashCode();
                            int n = -1;
                            switch (e) {
                                case "urn:mpeg:dash:mp4protection:2011": {
                                    n = 3;
                                    break;
                                }
                                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed": {
                                    n = 2;
                                    break;
                                }
                                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95": {
                                    n = 1;
                                    break;
                                }
                                case "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e": {
                                    n = 0;
                                    break;
                                }
                                default:
                                    break;
                            }
                            switch (n) {
                                default: {
                                    break Label_0331;
                                }
                                case 3: {
                                    attributeValue2 = xmlPullParser.getAttributeValue((String)null, "value");
                                    final String b = XmlPullParserUtil.b(xmlPullParser, "default_KID");
                                    if (!TextUtils.isEmpty((CharSequence)b) && !"00000000-0000-0000-0000-000000000000".equals(b)) {
                                        final String[] split = b.split("\\s+");
                                        final UUID[] array = new UUID[split.length];
                                        for (int i = 0; i < split.length; ++i) {
                                            array[i] = UUID.fromString(split[i]);
                                        }
                                        final UUID b2 = C.b;
                                        final byte[] b3 = PsshAtomUtil.b(b2, array, null);
                                        final String s = null;
                                        final String s2 = attributeValue2;
                                        break Label_0351;
                                    }
                                    break Label_0334;
                                }
                                case 2: {
                                    uuid = C.d;
                                    break;
                                }
                                case 1: {
                                    uuid = C.e;
                                    break;
                                }
                                case 0: {
                                    uuid = C.c;
                                    break;
                                }
                            }
                            attributeValue2 = null;
                            break Label_0337;
                        }
                        break Label_0331;
                        String s3 = null;
                        UUID uuid2 = null;
                        byte[] array2 = null;
                        do {
                            xmlPullParser.next();
                            Label_0596: {
                                if (XmlPullParserUtil.f(xmlPullParser, "clearkey:Laurl") && xmlPullParser.next() == 4) {
                                    s3 = xmlPullParser.getText();
                                    final UUID b2;
                                    uuid2 = b2;
                                    final byte[] b3;
                                    array2 = b3;
                                }
                                else if (XmlPullParserUtil.f(xmlPullParser, "ms:laurl")) {
                                    s3 = xmlPullParser.getAttributeValue((String)null, "licenseUrl");
                                    final UUID b2;
                                    uuid2 = b2;
                                    final byte[] b3;
                                    array2 = b3;
                                }
                                else {
                                    final byte[] b3;
                                    if (b3 == null && XmlPullParserUtil.g(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                                        array2 = Base64.decode(xmlPullParser.getText(), 0);
                                        final UUID f = PsshAtomUtil.f(array2);
                                        if (f == null) {
                                            Log.i("MpdParser", "Skipping malformed cenc:pssh data");
                                            array2 = null;
                                            uuid2 = f;
                                            final String s;
                                            s3 = s;
                                        }
                                        else {
                                            uuid2 = f;
                                            final String s;
                                            s3 = s;
                                        }
                                    }
                                    else {
                                        final UUID b2;
                                        final String s;
                                        if (b3 == null) {
                                            final UUID e2 = C.e;
                                            if (e2.equals(b2) && XmlPullParserUtil.f(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                                                array2 = PsshAtomUtil.a(e2, Base64.decode(xmlPullParser.getText(), 0));
                                                uuid2 = b2;
                                                s3 = s;
                                                break Label_0596;
                                            }
                                        }
                                        w(xmlPullParser);
                                        s3 = s;
                                        array2 = b3;
                                        uuid2 = b2;
                                    }
                                }
                            }
                            final UUID b2 = uuid2;
                            final byte[] b3 = array2;
                            final String s = s3;
                        } while (!XmlPullParserUtil.d(xmlPullParser, "ContentProtection"));
                        Object o2 = o;
                        if (uuid2 != null) {
                            o2 = new DrmInitData.SchemeData(uuid2, s3, "video/mp4", array2);
                        }
                        String s2 = null;
                        return (Pair<String, DrmInitData.SchemeData>)Pair.create((Object)s2, o2);
                    }
                    attributeValue2 = null;
                }
                uuid = null;
            }
            final byte[] b3 = null;
            final String s = null;
            final UUID b2 = uuid;
            final String s2 = attributeValue2;
            continue;
        }
    }
    
    protected int G(final XmlPullParser xmlPullParser) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "contentType");
        final boolean empty = TextUtils.isEmpty((CharSequence)attributeValue);
        int n = -1;
        if (!empty) {
            if ("audio".equals(attributeValue)) {
                n = 1;
            }
            else if ("video".equals(attributeValue)) {
                n = 2;
            }
            else if ("text".equals(attributeValue)) {
                n = 3;
            }
        }
        return n;
    }
    
    protected Pair<Long, EventMessage> O(final XmlPullParser xmlPullParser, final String s, final String s2, long o0, final ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        final long x = X(xmlPullParser, "id", 0L);
        final long x2 = X(xmlPullParser, "duration", -9223372036854775807L);
        final long x3 = X(xmlPullParser, "presentationTime", 0L);
        final long o2 = Util.O0(x2, 1000L, o0);
        o0 = Util.O0(x3, 1000000L, o0);
        final String r0 = r0(xmlPullParser, "messageData", null);
        byte[] array = this.P(xmlPullParser, byteArrayOutputStream);
        if (r0 != null) {
            array = Util.n0(r0);
        }
        return (Pair<Long, EventMessage>)Pair.create((Object)o0, (Object)this.d(s, s2, x, o2, array));
    }
    
    protected byte[] P(final XmlPullParser xmlPullParser, final ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        final XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput((OutputStream)byteArrayOutputStream, Charsets.c.name());
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 10: {
                    serializer.docdecl(xmlPullParser.getText());
                    break;
                }
                case 9: {
                    serializer.comment(xmlPullParser.getText());
                    break;
                }
                case 8: {
                    serializer.processingInstruction(xmlPullParser.getText());
                    break;
                }
                case 7: {
                    serializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                }
                case 6: {
                    serializer.entityRef(xmlPullParser.getText());
                    break;
                }
                case 5: {
                    serializer.cdsect(xmlPullParser.getText());
                    break;
                }
                case 4: {
                    serializer.text(xmlPullParser.getText());
                    break;
                }
                case 3: {
                    serializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                }
                case 2: {
                    serializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); ++i) {
                        serializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                }
                case 1: {
                    serializer.endDocument();
                    break;
                }
                case 0: {
                    serializer.startDocument((String)null, Boolean.FALSE);
                    break;
                }
            }
            xmlPullParser.nextToken();
        }
        serializer.flush();
        return byteArrayOutputStream.toByteArray();
    }
    
    protected EventStream Q(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        final String r0 = r0(xmlPullParser, "schemeIdUri", "");
        final String r2 = r0(xmlPullParser, "value", "");
        final long x = X(xmlPullParser, "timescale", 1L);
        final ArrayList list = new ArrayList();
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Event")) {
                list.add(this.O(xmlPullParser, r0, r2, x, byteArrayOutputStream));
            }
            else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "EventStream"));
        final long[] array = new long[list.size()];
        final EventMessage[] array2 = new EventMessage[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            final Pair pair = (Pair)list.get(i);
            array[i] = (long)pair.first;
            array2[i] = (EventMessage)pair.second;
        }
        return this.e(r0, r2, x, array, array2);
    }
    
    protected RangedUri T(final XmlPullParser xmlPullParser) {
        return this.d0(xmlPullParser, "sourceURL", "range");
    }
    
    protected String V(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return s0(xmlPullParser, "Label");
    }
    
    protected DashManifest Y(final XmlPullParser xmlPullParser, final Uri uri) throws XmlPullParserException, IOException {
        final boolean v = this.v(this.b0(xmlPullParser, "profiles", new String[0]));
        final long n = -9223372036854775807L;
        final long h = H(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        final long m = M(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        final long i = M(xmlPullParser, "minBufferTime", -9223372036854775807L);
        final Throwable t = null;
        final boolean equals = "dynamic".equals(xmlPullParser.getAttributeValue((String)null, "type"));
        long j;
        if (equals) {
            j = M(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L);
        }
        else {
            j = -9223372036854775807L;
        }
        long k;
        if (equals) {
            k = M(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L);
        }
        else {
            k = -9223372036854775807L;
        }
        long l;
        if (equals) {
            l = M(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L);
        }
        else {
            l = -9223372036854775807L;
        }
        final long h2 = H(xmlPullParser, "publishTime", -9223372036854775807L);
        long n2;
        if (equals) {
            n2 = 0L;
        }
        else {
            n2 = -9223372036854775807L;
        }
        final String string = uri.toString();
        final String string2 = uri.toString();
        final int n3 = 1;
        int n4;
        if (v) {
            n4 = 1;
        }
        else {
            n4 = Integer.MIN_VALUE;
        }
        final ArrayList l2 = Lists.l((Object[])new BaseUrl[] { new BaseUrl(string, string2, n4, 1) });
        final ArrayList list = new ArrayList<Period>();
        final ArrayList list2 = new ArrayList();
        long n5;
        if (equals) {
            n5 = -9223372036854775807L;
        }
        else {
            n5 = 0L;
        }
        int n6 = 0;
        int n7 = 0;
        ProgramInformation c0 = null;
        Object v2 = null;
        Object q0;
        Object e = q0 = v2;
        final int n8 = n3;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "BaseURL")) {
                long b = n2;
                int n9;
                if ((n9 = n6) == 0) {
                    b = this.B(xmlPullParser, n2);
                    n9 = n8;
                }
                list2.addAll(this.C(xmlPullParser, l2, v));
                n2 = b;
                n6 = n9;
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "ProgramInformation")) {
                c0 = this.c0(xmlPullParser);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "UTCTiming")) {
                v2 = this.v0(xmlPullParser);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "Location")) {
                e = UriUtil.e(uri.toString(), xmlPullParser.nextText());
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "ServiceDescription")) {
                q0 = this.q0(xmlPullParser);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "Period") && n7 == 0) {
                ArrayList list3;
                if (!list2.isEmpty()) {
                    list3 = list2;
                }
                else {
                    list3 = l2;
                }
                final Pair<Period, Long> a0 = this.a0(xmlPullParser, list3, n5, n2, h, k, v);
                final Period period = (Period)a0.first;
                if (period.b == n) {
                    if (!equals) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unable to determine start of period ");
                        sb.append(list.size());
                        throw ParserException.createForMalformedManifest(sb.toString(), t);
                    }
                    n7 = n8;
                }
                else {
                    final long longValue = (long)a0.second;
                    if (longValue == n) {
                        n5 = n;
                    }
                    else {
                        n5 = period.b + longValue;
                    }
                    list.add(period);
                }
            }
            else {
                w(xmlPullParser);
            }
            if (XmlPullParserUtil.d(xmlPullParser, "MPD")) {
                long n10 = 0L;
                Label_0682: {
                    if (m == n) {
                        if (n5 != n) {
                            n10 = n5;
                            break Label_0682;
                        }
                        if (!equals) {
                            throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", t);
                        }
                    }
                    n10 = m;
                }
                if (!list.isEmpty()) {
                    return this.g(h, n10, i, equals, j, k, l, h2, c0, (UtcTimingElement)v2, (ServiceDescriptionElement)q0, (Uri)e, list);
                }
                throw ParserException.createForMalformedManifest("No periods found.", t);
            }
        }
    }
    
    @Override
    public /* bridge */ Object a(final Uri uri, final InputStream inputStream) throws IOException {
        return this.x(uri, inputStream);
    }
    
    protected Pair<Period, Long> a0(final XmlPullParser xmlPullParser, final List<BaseUrl> list, long n, long n2, long b, final long n3, final boolean b2) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        final String attributeValue = xmlPullParser2.getAttributeValue((String)null, "id");
        final long m = M(xmlPullParser2, "start", n);
        final long n4 = -9223372036854775807L;
        long n5;
        if (b != -9223372036854775807L) {
            n5 = b + m;
        }
        else {
            n5 = -9223372036854775807L;
        }
        final long i = M(xmlPullParser2, "duration", -9223372036854775807L);
        final ArrayList list2 = new ArrayList();
        final ArrayList<EventStream> list3 = new ArrayList<EventStream>();
        final ArrayList list4 = new ArrayList();
        n = n2;
        int n6 = 0;
        long n7 = -9223372036854775807L;
        SegmentBase j0 = null;
        Descriptor k = null;
        n2 = n4;
        while (true) {
            xmlPullParser.next();
            int n8 = 0;
            Label_0469: {
                if (XmlPullParserUtil.f(xmlPullParser2, "BaseURL")) {
                    b = n;
                    if ((n8 = n6) == 0) {
                        b = this.B(xmlPullParser2, n);
                        n8 = 1;
                    }
                    list4.addAll(this.C(xmlPullParser2, list, b2));
                    n = b;
                }
                else {
                    Label_0454: {
                        if (XmlPullParserUtil.f(xmlPullParser2, "AdaptationSet")) {
                            List<BaseUrl> list5;
                            if (!list4.isEmpty()) {
                                list5 = list4;
                            }
                            else {
                                list5 = list;
                            }
                            list2.add(this.y(xmlPullParser, list5, j0, i, n, n7, n5, n3, b2));
                        }
                        else if (XmlPullParserUtil.f(xmlPullParser, "EventStream")) {
                            list3.add(this.Q(xmlPullParser));
                        }
                        else {
                            if (XmlPullParserUtil.f(xmlPullParser, "SegmentBase")) {
                                j0 = this.j0(xmlPullParser, null);
                                n2 = -9223372036854775807L;
                                xmlPullParser2 = xmlPullParser;
                                n8 = n6;
                                break Label_0469;
                            }
                            SegmentBase.MultiSegmentBase multiSegmentBase;
                            if (XmlPullParserUtil.f(xmlPullParser, "SegmentList")) {
                                n2 = this.B(xmlPullParser, -9223372036854775807L);
                                multiSegmentBase = this.k0(xmlPullParser, null, n5, i, n, n2, n3);
                            }
                            else if (XmlPullParserUtil.f(xmlPullParser, "SegmentTemplate")) {
                                n2 = this.B(xmlPullParser, -9223372036854775807L);
                                multiSegmentBase = this.l0(xmlPullParser, null, (List<Descriptor>)ImmutableList.of(), n5, i, n, n2, n3);
                            }
                            else {
                                if (XmlPullParserUtil.f(xmlPullParser, "AssetIdentifier")) {
                                    k = I(xmlPullParser, "AssetIdentifier");
                                    break Label_0454;
                                }
                                w(xmlPullParser);
                                break Label_0454;
                            }
                            b = -9223372036854775807L;
                            j0 = multiSegmentBase;
                            xmlPullParser2 = xmlPullParser;
                            n8 = n6;
                            n7 = n2;
                            n2 = b;
                            break Label_0469;
                        }
                    }
                    n2 = -9223372036854775807L;
                    xmlPullParser2 = xmlPullParser;
                    n8 = n6;
                }
            }
            if (XmlPullParserUtil.d(xmlPullParser2, "Period")) {
                break;
            }
            n6 = n8;
        }
        return (Pair<Period, Long>)Pair.create((Object)this.h(attributeValue, m, list2, list3, k), (Object)i);
    }
    
    protected String[] b0(final XmlPullParser xmlPullParser, final String s, final String[] array) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue == null) {
            return array;
        }
        return attributeValue.split(",");
    }
    
    protected AdaptationSet c(final int n, final int n2, final List<Representation> list, final List<Descriptor> list2, final List<Descriptor> list3, final List<Descriptor> list4) {
        return new AdaptationSet(n, n2, list, list2, list3, list4);
    }
    
    protected ProgramInformation c0(final XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String nextText = null;
        final String r0 = r0(xmlPullParser, "moreInformationURL", null);
        final String r2 = r0(xmlPullParser, "lang", null);
        String nextText2 = null;
        String nextText3 = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Title")) {
                nextText = xmlPullParser.nextText();
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "Source")) {
                nextText2 = xmlPullParser.nextText();
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "Copyright")) {
                nextText3 = xmlPullParser.nextText();
            }
            else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "ProgramInformation"));
        return new ProgramInformation(nextText, nextText2, nextText3, r0, r2);
    }
    
    protected EventMessage d(final String s, final String s2, final long n, final long n2, final byte[] array) {
        return new EventMessage(s, s2, n2, n, array);
    }
    
    protected RangedUri d0(final XmlPullParser xmlPullParser, String attributeValue, final String s) {
        attributeValue = xmlPullParser.getAttributeValue((String)null, attributeValue);
        final String attributeValue2 = xmlPullParser.getAttributeValue((String)null, s);
        long long1;
        if (attributeValue2 != null) {
            final String[] split = attributeValue2.split("-");
            final long n = long1 = Long.parseLong(split[0]);
            if (split.length == 2) {
                final long n2 = Long.parseLong(split[1]) - n + 1L;
                long1 = n;
                final long n3 = n2;
                return this.i(attributeValue, long1, n3);
            }
        }
        else {
            long1 = 0L;
        }
        final long n3 = -1L;
        return this.i(attributeValue, long1, n3);
    }
    
    protected EventStream e(final String s, final String s2, final long n, final long[] array, final EventMessage[] array2) {
        return new EventStream(s, s2, n, array, array2);
    }
    
    protected RepresentationInfo e0(final XmlPullParser xmlPullParser, List<BaseUrl> list, final String s, final String s2, int n, int a, float s3, int n2, int u, final String s4, final List<Descriptor> list2, final List<Descriptor> list3, final List<Descriptor> list4, final List<Descriptor> list5, final SegmentBase segmentBase, final long n3, final long n4, long n5, long n6, final long n7, final boolean b) throws XmlPullParserException, IOException {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "id");
        final int u2 = U(xmlPullParser, "bandwidth", -1);
        final String r0 = r0(xmlPullParser, "mimeType", s);
        final String r2 = r0(xmlPullParser, "codecs", s2);
        final int u3 = U(xmlPullParser, "width", n);
        final int u4 = U(xmlPullParser, "height", a);
        s3 = S(xmlPullParser, s3);
        u = U(xmlPullParser, "audioSamplingRate", u);
        final ArrayList list6 = new ArrayList();
        final ArrayList list7 = new ArrayList();
        final ArrayList list8 = new ArrayList((Collection<? extends E>)list4);
        final ArrayList list9 = new ArrayList((Collection<? extends E>)list5);
        final ArrayList list10 = new ArrayList();
        a = n2;
        String s5 = null;
        n = 0;
        SegmentBase segmentBase2 = segmentBase;
        final ArrayList list11 = list8;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "BaseURL")) {
                long b2 = n5;
                if ((n2 = n) == 0) {
                    b2 = this.B(xmlPullParser, n5);
                    n2 = 1;
                }
                list10.addAll(this.C(xmlPullParser, list, b));
                n = n2;
                n5 = b2;
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "AudioChannelConfiguration")) {
                a = this.A(xmlPullParser);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "SegmentBase")) {
                segmentBase2 = this.j0(xmlPullParser, (SegmentBase.SingleSegmentBase)segmentBase2);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "SegmentList")) {
                n6 = this.B(xmlPullParser, n6);
                segmentBase2 = this.k0(xmlPullParser, (SegmentBase.SegmentList)segmentBase2, n3, n4, n5, n6, n7);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "SegmentTemplate")) {
                n6 = this.B(xmlPullParser, n6);
                segmentBase2 = this.l0(xmlPullParser, (SegmentBase.SegmentTemplate)segmentBase2, list5, n3, n4, n5, n6, n7);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "ContentProtection")) {
                final Pair<String, DrmInitData.SchemeData> f = this.F(xmlPullParser);
                final Object first = f.first;
                if (first != null) {
                    s5 = (String)first;
                }
                final Object second = f.second;
                if (second != null) {
                    list6.add(second);
                }
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "InbandEventStream")) {
                list7.add(I(xmlPullParser, "InbandEventStream"));
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "EssentialProperty")) {
                list11.add(I(xmlPullParser, "EssentialProperty"));
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "SupplementalProperty")) {
                list9.add(I(xmlPullParser, "SupplementalProperty"));
            }
            else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "Representation"));
        final Format f2 = this.f(attributeValue, r0, u3, u4, s3, a, u, u2, s4, list2, list3, r2, list11, list9);
        if (segmentBase2 == null) {
            segmentBase2 = new SegmentBase.SingleSegmentBase();
        }
        if (!list10.isEmpty()) {
            list = list10;
        }
        return new RepresentationInfo(f2, list, segmentBase2, s5, list6, list7, list11, list9, -1L);
    }
    
    protected Format f(final String s, final String s2, int n, final int n2, final float n3, final int n4, final int n5, final int n6, final String s3, final List<Descriptor> list, final List<Descriptor> list2, String s4, final List<Descriptor> list3, final List<Descriptor> list4) {
        final String s5 = s4;
        final String u = u(s2, s5);
        String s6 = s5;
        s4 = u;
        if ("audio/eac3".equals(u)) {
            final String n7 = N(list4);
            s6 = s5;
            s4 = n7;
            if ("audio/eac3-joc".equals(n7)) {
                s6 = "ec+3";
                s4 = n7;
            }
        }
        final Format.Builder v = new Format.Builder().S(s).K(s2).e0(s4).I(s6).Z(n6).g0(this.p0(list)).c0(this.i0(list) | this.f0(list2) | this.h0(list3) | this.h0(list4)).V(s3);
        if (MimeTypes.s(s4)) {
            v.j0(n).Q(n2).P(n3);
        }
        else if (MimeTypes.o(s4)) {
            v.H(n4).f0(n5);
        }
        else if (MimeTypes.r(s4)) {
            n = -1;
            if ("application/cea-608".equals(s4)) {
                n = D(list2);
            }
            else if ("application/cea-708".equals(s4)) {
                n = E(list2);
            }
            v.F(n);
        }
        else if (MimeTypes.p(s4)) {
            v.j0(n).Q(n2);
        }
        return v.E();
    }
    
    protected int f0(final List<Descriptor> list) {
        int i = 0;
        int n = 0;
        while (i < list.size()) {
            final Descriptor descriptor = list.get(i);
            int n3 = 0;
            Label_0091: {
                int n2;
                if (Ascii.a((CharSequence)"urn:mpeg:dash:role:2011", (CharSequence)descriptor.a)) {
                    n2 = this.g0(descriptor.b);
                }
                else {
                    n3 = n;
                    if (!Ascii.a((CharSequence)"urn:tva:metadata:cs:AudioPurposeCS:2007", (CharSequence)descriptor.a)) {
                        break Label_0091;
                    }
                    n2 = this.t0(descriptor.b);
                }
                n3 = (n | n2);
            }
            ++i;
            n = n3;
        }
        return n;
    }
    
    protected DashManifest g(final long n, final long n2, final long n3, final boolean b, final long n4, final long n5, final long n6, final long n7, final ProgramInformation programInformation, final UtcTimingElement utcTimingElement, final ServiceDescriptionElement serviceDescriptionElement, final Uri uri, final List<Period> list) {
        return new DashManifest(n, n2, n3, b, n4, n5, n6, n7, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
    }
    
    protected int g0(final String s) {
        if (s == null) {
            return 0;
        }
        int n = -1;
        switch (s) {
            case "supplementary": {
                n = 12;
                break;
            }
            case "emergency": {
                n = 11;
                break;
            }
            case "commentary": {
                n = 10;
                break;
            }
            case "caption": {
                n = 9;
                break;
            }
            case "sign": {
                n = 8;
                break;
            }
            case "main": {
                n = 7;
                break;
            }
            case "dub": {
                n = 6;
                break;
            }
            case "forced-subtitle": {
                n = 5;
                break;
            }
            case "alternate": {
                n = 4;
                break;
            }
            case "forced_subtitle": {
                n = 3;
                break;
            }
            case "enhanced-audio-intelligibility": {
                n = 2;
                break;
            }
            case "description": {
                n = 1;
                break;
            }
            case "subtitle": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return 0;
            }
            case 12: {
                return 4;
            }
            case 11: {
                return 32;
            }
            case 10: {
                return 8;
            }
            case 9: {
                return 64;
            }
            case 8: {
                return 256;
            }
            case 7: {
                return 1;
            }
            case 6: {
                return 16;
            }
            case 4: {
                return 2;
            }
            case 2: {
                return 2048;
            }
            case 1: {
                return 512;
            }
            case 0:
            case 3:
            case 5: {
                return 128;
            }
        }
    }
    
    protected Period h(final String s, final long n, final List<AdaptationSet> list, final List<EventStream> list2, final Descriptor descriptor) {
        return new Period(s, n, list, list2, descriptor);
    }
    
    protected int h0(final List<Descriptor> list) {
        int i = 0;
        int n = 0;
        while (i < list.size()) {
            int n2 = n;
            if (Ascii.a((CharSequence)"http://dashif.org/guidelines/trickmode", (CharSequence)((Descriptor)list.get(i)).a)) {
                n2 = (n | 0x4000);
            }
            ++i;
            n = n2;
        }
        return n;
    }
    
    protected RangedUri i(final String s, final long n, final long n2) {
        return new RangedUri(s, n, n2);
    }
    
    protected int i0(final List<Descriptor> list) {
        int i = 0;
        int n = 0;
        while (i < list.size()) {
            final Descriptor descriptor = list.get(i);
            int n2 = n;
            if (Ascii.a((CharSequence)"urn:mpeg:dash:role:2011", (CharSequence)descriptor.a)) {
                n2 = (n | this.g0(descriptor.b));
            }
            ++i;
            n = n2;
        }
        return n;
    }
    
    protected Representation j(final RepresentationInfo representationInfo, String d, String s, final ArrayList<DrmInitData.SchemeData> list, final ArrayList<Descriptor> list2) {
        final Format.Builder b = representationInfo.a.b();
        if (d != null) {
            b.U(d);
        }
        d = representationInfo.d;
        if (d != null) {
            s = d;
        }
        final ArrayList<DrmInitData.SchemeData> e = representationInfo.e;
        e.addAll(list);
        if (!e.isEmpty()) {
            r(e);
            s(e);
            b.M(new DrmInitData(s, e));
        }
        final ArrayList<Descriptor> f = representationInfo.f;
        f.addAll(list2);
        return Representation.o(representationInfo.g, b.E(), (List<BaseUrl>)representationInfo.b, representationInfo.c, f, representationInfo.h, representationInfo.i, null);
    }
    
    protected SegmentBase.SingleSegmentBase j0(final XmlPullParser xmlPullParser, final SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long b;
        if (singleSegmentBase != null) {
            b = singleSegmentBase.b;
        }
        else {
            b = 1L;
        }
        final long x = X(xmlPullParser, "timescale", b);
        long e = 0L;
        long c;
        if (singleSegmentBase != null) {
            c = singleSegmentBase.c;
        }
        else {
            c = 0L;
        }
        final long x2 = X(xmlPullParser, "presentationTimeOffset", c);
        long n;
        if (singleSegmentBase != null) {
            n = singleSegmentBase.d;
        }
        else {
            n = 0L;
        }
        if (singleSegmentBase != null) {
            e = singleSegmentBase.e;
        }
        RangedUri a = null;
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, "indexRange");
        if (attributeValue != null) {
            final String[] split = attributeValue.split("-");
            n = Long.parseLong(split[0]);
            e = Long.parseLong(split[1]) - n + 1L;
        }
        if (singleSegmentBase != null) {
            a = singleSegmentBase.a;
        }
        RangedUri t;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Initialization")) {
                t = this.T(xmlPullParser);
            }
            else {
                w(xmlPullParser);
                t = a;
            }
            a = t;
        } while (!XmlPullParserUtil.d(xmlPullParser, "SegmentBase"));
        return this.n(t, x, x2, n, e);
    }
    
    protected SegmentBase.SegmentList k(final RangedUri rangedUri, final long n, final long n2, final long n3, final long n4, final List<SegmentBase.SegmentTimelineElement> list, final long n5, final List<RangedUri> list2, final long n6, final long n7) {
        return new SegmentBase.SegmentList(rangedUri, n, n2, n3, n4, list, n5, list2, Util.C0(n6), Util.C0(n7));
    }
    
    protected SegmentBase.SegmentList k0(final XmlPullParser xmlPullParser, final SegmentBase.SegmentList list, final long n, final long n2, long t, final long n3, final long n4) throws XmlPullParserException, IOException {
        final long n5 = 1L;
        long b;
        if (list != null) {
            b = list.b;
        }
        else {
            b = 1L;
        }
        final long x = X(xmlPullParser, "timescale", b);
        long c;
        if (list != null) {
            c = list.c;
        }
        else {
            c = 0L;
        }
        final long x2 = X(xmlPullParser, "presentationTimeOffset", c);
        long e;
        if (list != null) {
            e = list.e;
        }
        else {
            e = -9223372036854775807L;
        }
        final long x3 = X(xmlPullParser, "duration", e);
        long d = n5;
        if (list != null) {
            d = list.d;
        }
        final long x4 = X(xmlPullParser, "startNumber", d);
        t = t(t, n3);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        List<RangedUri> list3 = null;
        RangedUri rangedUri = null;
        RangedUri rangedUri2;
        List<SegmentBase.SegmentTimelineElement> list4;
        List<RangedUri> list5;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Initialization")) {
                rangedUri2 = this.T(xmlPullParser);
                list4 = list2;
                list5 = list3;
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "SegmentTimeline")) {
                list4 = this.m0(xmlPullParser, x, n2);
                list5 = list3;
                rangedUri2 = rangedUri;
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "SegmentURL")) {
                if ((list5 = list3) == null) {
                    list5 = new ArrayList<RangedUri>();
                }
                list5.add(this.n0(xmlPullParser));
                list4 = list2;
                rangedUri2 = rangedUri;
            }
            else {
                w(xmlPullParser);
                rangedUri2 = rangedUri;
                list5 = list3;
                list4 = list2;
            }
            list2 = list4;
            list3 = list5;
            rangedUri = rangedUri2;
        } while (!XmlPullParserUtil.d(xmlPullParser, "SegmentList"));
        List<SegmentBase.SegmentTimelineElement> list6 = list4;
        List<RangedUri> j = list5;
        RangedUri rangedUri3 = rangedUri2;
        if (list != null) {
            if (rangedUri2 == null) {
                rangedUri2 = list.a;
            }
            if (list4 == null) {
                list4 = list.f;
            }
            if (list5 != null) {
                list6 = list4;
                j = list5;
                rangedUri3 = rangedUri2;
            }
            else {
                j = list.j;
                rangedUri3 = rangedUri2;
                list6 = list4;
            }
        }
        return this.k(rangedUri3, x, x2, x4, x3, list6, t, j, n4, n);
    }
    
    protected SegmentBase.SegmentTemplate l(final RangedUri rangedUri, final long n, final long n2, final long n3, final long n4, final long n5, final List<SegmentBase.SegmentTimelineElement> list, final long n6, final UrlTemplate urlTemplate, final UrlTemplate urlTemplate2, final long n7, final long n8) {
        return new SegmentBase.SegmentTemplate(rangedUri, n, n2, n3, n4, n5, list, n6, urlTemplate, urlTemplate2, Util.C0(n7), Util.C0(n8));
    }
    
    protected SegmentBase.SegmentTemplate l0(final XmlPullParser xmlPullParser, final SegmentBase.SegmentTemplate segmentTemplate, final List<Descriptor> list, final long n, final long n2, long t, final long n3, final long n4) throws XmlPullParserException, IOException {
        final long n5 = 1L;
        long b;
        if (segmentTemplate != null) {
            b = segmentTemplate.b;
        }
        else {
            b = 1L;
        }
        final long x = X(xmlPullParser, "timescale", b);
        long c;
        if (segmentTemplate != null) {
            c = segmentTemplate.c;
        }
        else {
            c = 0L;
        }
        final long x2 = X(xmlPullParser, "presentationTimeOffset", c);
        long e;
        if (segmentTemplate != null) {
            e = segmentTemplate.e;
        }
        else {
            e = -9223372036854775807L;
        }
        final long x3 = X(xmlPullParser, "duration", e);
        long d = n5;
        if (segmentTemplate != null) {
            d = segmentTemplate.d;
        }
        final long x4 = X(xmlPullParser, "startNumber", d);
        final long w = W(list);
        t = t(t, n3);
        List<SegmentBase.SegmentTimelineElement> m0 = null;
        UrlTemplate k;
        if (segmentTemplate != null) {
            k = segmentTemplate.k;
        }
        else {
            k = null;
        }
        final UrlTemplate u0 = this.u0(xmlPullParser, "media", k);
        UrlTemplate j;
        if (segmentTemplate != null) {
            j = segmentTemplate.j;
        }
        else {
            j = null;
        }
        final UrlTemplate u2 = this.u0(xmlPullParser, "initialization", j);
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Initialization")) {
                rangedUri = this.T(xmlPullParser);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "SegmentTimeline")) {
                m0 = this.m0(xmlPullParser, x, n2);
            }
            else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "SegmentTemplate"));
        List<SegmentBase.SegmentTimelineElement> f = m0;
        RangedUri rangedUri2 = rangedUri;
        if (segmentTemplate != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate.a;
            }
            if (m0 != null) {
                f = m0;
                rangedUri2 = rangedUri;
            }
            else {
                f = segmentTemplate.f;
                rangedUri2 = rangedUri;
            }
        }
        return this.l(rangedUri2, x, x2, x4, w, x3, f, t, u2, u0, n4, n);
    }
    
    protected SegmentBase.SegmentTimelineElement m(final long n, final long n2) {
        return new SegmentBase.SegmentTimelineElement(n, n2);
    }
    
    protected List<SegmentBase.SegmentTimelineElement> m0(final XmlPullParser xmlPullParser, final long n, final long n2) throws XmlPullParserException, IOException {
        final ArrayList list = new ArrayList();
        long n3 = 0L;
        int n4 = 0;
        int n5 = 0;
        long n6 = -9223372036854775807L;
        long x2;
        int u;
        int n8;
        long n9;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "S")) {
                final long x = X(xmlPullParser, "t", -9223372036854775807L);
                long b = n3;
                if (n4 != 0) {
                    b = this.b(list, n3, n6, n5, x);
                }
                long n7;
                if (x != -9223372036854775807L) {
                    n7 = x;
                }
                else {
                    n7 = b;
                }
                x2 = X(xmlPullParser, "d", -9223372036854775807L);
                u = U(xmlPullParser, "r", 0);
                n8 = 1;
                n9 = n7;
            }
            else {
                w(xmlPullParser);
                u = n5;
                x2 = n6;
                n9 = n3;
                n8 = n4;
            }
            n4 = n8;
            n3 = n9;
            n6 = x2;
            n5 = u;
        } while (!XmlPullParserUtil.d(xmlPullParser, "SegmentTimeline"));
        if (n8 != 0) {
            this.b(list, n9, x2, u, Util.O0(n2, n, 1000L));
        }
        return list;
    }
    
    protected SegmentBase.SingleSegmentBase n(final RangedUri rangedUri, final long n, final long n2, final long n3, final long n4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, n, n2, n3, n4);
    }
    
    protected RangedUri n0(final XmlPullParser xmlPullParser) {
        return this.d0(xmlPullParser, "media", "mediaRange");
    }
    
    protected UtcTimingElement o(final String s, final String s2) {
        return new UtcTimingElement(s, s2);
    }
    
    protected int o0(final String s) {
        if (s == null) {
            return 0;
        }
        if (!s.equals("forced_subtitle") && !s.equals("forced-subtitle")) {
            return 0;
        }
        return 2;
    }
    
    protected int p0(final List<Descriptor> list) {
        int i = 0;
        int n = 0;
        while (i < list.size()) {
            final Descriptor descriptor = list.get(i);
            int n2 = n;
            if (Ascii.a((CharSequence)"urn:mpeg:dash:role:2011", (CharSequence)descriptor.a)) {
                n2 = (n | this.o0(descriptor.b));
            }
            ++i;
            n = n2;
        }
        return n;
    }
    
    protected ServiceDescriptionElement q0(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        float r = -3.4028235E38f;
        float r2 = -3.4028235E38f;
        long n = -9223372036854775807L;
        long n3;
        long n2 = n3 = -9223372036854775807L;
        long x;
        long x2;
        long x3;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Latency")) {
                x = X(xmlPullParser, "target", -9223372036854775807L);
                x2 = X(xmlPullParser, "min", -9223372036854775807L);
                x3 = X(xmlPullParser, "max", -9223372036854775807L);
            }
            else {
                x = n;
                x2 = n2;
                x3 = n3;
                if (XmlPullParserUtil.f(xmlPullParser, "PlaybackRate")) {
                    r = R(xmlPullParser, "min", -3.4028235E38f);
                    r2 = R(xmlPullParser, "max", -3.4028235E38f);
                    x3 = n3;
                    x2 = n2;
                    x = n;
                }
            }
            if (XmlPullParserUtil.d(xmlPullParser, "ServiceDescription")) {
                break;
            }
            n2 = x2;
            n = x;
            n3 = x3;
        }
        return new ServiceDescriptionElement(x, x2, x3, r, r2);
    }
    
    protected int t0(final String s) {
        if (s == null) {
            return 0;
        }
        int n = -1;
        switch (s) {
            case "6": {
                n = 4;
                break;
            }
            case "4": {
                n = 3;
                break;
            }
            case "3": {
                n = 2;
                break;
            }
            case "2": {
                n = 1;
                break;
            }
            case "1": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 4;
            }
            case 1: {
                return 2048;
            }
            case 0: {
                return 512;
            }
        }
    }
    
    protected UrlTemplate u0(final XmlPullParser xmlPullParser, final String s, final UrlTemplate urlTemplate) {
        final String attributeValue = xmlPullParser.getAttributeValue((String)null, s);
        if (attributeValue != null) {
            return UrlTemplate.b(attributeValue);
        }
        return urlTemplate;
    }
    
    protected UtcTimingElement v0(final XmlPullParser xmlPullParser) {
        return this.o(xmlPullParser.getAttributeValue((String)null, "schemeIdUri"), xmlPullParser.getAttributeValue((String)null, "value"));
    }
    
    public DashManifest x(final Uri uri, final InputStream inputStream) throws IOException {
        try {
            final XmlPullParser pullParser = this.a.newPullParser();
            pullParser.setInput(inputStream, (String)null);
            if (pullParser.next() == 2 && "MPD".equals(pullParser.getName())) {
                return this.Y(pullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        }
        catch (final XmlPullParserException ex) {
            throw ParserException.createForMalformedManifest(null, (Throwable)ex);
        }
    }
    
    protected AdaptationSet y(final XmlPullParser xmlPullParser, final List<BaseUrl> list, final SegmentBase segmentBase, final long n, long n2, long n3, final long n4, final long n5, final boolean b) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        final int u = U(xmlPullParser2, "id", -1);
        int n6 = this.G(xmlPullParser);
        final String attributeValue = xmlPullParser2.getAttributeValue((String)null, "mimeType");
        final String attributeValue2 = xmlPullParser2.getAttributeValue((String)null, "codecs");
        final int u2 = U(xmlPullParser2, "width", -1);
        final int u3 = U(xmlPullParser2, "height", -1);
        final float s = S(xmlPullParser2, -1.0f);
        final int u4 = U(xmlPullParser2, "audioSamplingRate", -1);
        final String s2 = "lang";
        String attributeValue3 = xmlPullParser2.getAttributeValue((String)null, "lang");
        String attributeValue4 = xmlPullParser2.getAttributeValue((String)null, "label");
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        final ArrayList list5 = new ArrayList();
        final ArrayList list6 = new ArrayList();
        final ArrayList list7 = new ArrayList();
        final ArrayList list8 = new ArrayList();
        final ArrayList list9 = new ArrayList();
        int a = -1;
        String s3 = null;
        int n7 = 0;
        final long n8 = n3;
        SegmentBase segmentBase2 = segmentBase;
        final ArrayList list10 = list3;
        n3 = n2;
        n2 = n8;
        String v = null;
        String s5 = null;
        while (true) {
            xmlPullParser.next();
            int n9 = 0;
            XmlPullParser xmlPullParser3 = null;
            SegmentBase segmentBase3 = null;
            int n11 = 0;
            String s6 = null;
            Label_1184: {
                long b2;
                if (XmlPullParserUtil.f(xmlPullParser2, "BaseURL")) {
                    b2 = n3;
                    if ((n9 = n7) == 0) {
                        b2 = this.B(xmlPullParser2, n3);
                        n9 = 1;
                    }
                    list9.addAll(this.C(xmlPullParser2, list, b));
                }
                else {
                    if (!XmlPullParserUtil.f(xmlPullParser2, "ContentProtection")) {
                        String q = null;
                        Label_0451: {
                            if (!XmlPullParserUtil.f(xmlPullParser2, "ContentComponent")) {
                                if (XmlPullParserUtil.f(xmlPullParser2, "Role")) {
                                    list5.add(I(xmlPullParser2, "Role"));
                                }
                                else if (XmlPullParserUtil.f(xmlPullParser2, "AudioChannelConfiguration")) {
                                    a = this.A(xmlPullParser);
                                }
                                else if (XmlPullParserUtil.f(xmlPullParser2, "Accessibility")) {
                                    list4.add(I(xmlPullParser2, "Accessibility"));
                                }
                                else if (XmlPullParserUtil.f(xmlPullParser2, "EssentialProperty")) {
                                    list6.add(I(xmlPullParser2, "EssentialProperty"));
                                }
                                else if (XmlPullParserUtil.f(xmlPullParser2, "SupplementalProperty")) {
                                    list7.add(I(xmlPullParser2, "SupplementalProperty"));
                                }
                                else {
                                    if (XmlPullParserUtil.f(xmlPullParser2, "Representation")) {
                                        ArrayList list11;
                                        if (!list9.isEmpty()) {
                                            list11 = list9;
                                        }
                                        else {
                                            list11 = (ArrayList)list;
                                        }
                                        q = attributeValue3;
                                        final RepresentationInfo e0 = this.e0(xmlPullParser, list11, attributeValue, attributeValue2, u2, u3, s, a, u4, attributeValue3, list5, list4, list6, list7, segmentBase2, n4, n, n3, n2, n5, b);
                                        n6 = p(n6, MimeTypes.k(e0.a.w));
                                        list8.add(e0);
                                        xmlPullParser3 = xmlPullParser;
                                        break Label_0451;
                                    }
                                    final long n10 = n3;
                                    final String s4 = attributeValue3;
                                    if (XmlPullParserUtil.f(xmlPullParser, "SegmentBase")) {
                                        segmentBase3 = this.j0(xmlPullParser, (SegmentBase.SingleSegmentBase)segmentBase2);
                                        xmlPullParser3 = xmlPullParser;
                                        n11 = a;
                                        v = attributeValue4;
                                        n9 = n7;
                                        s5 = s3;
                                        n3 = n10;
                                        s6 = s4;
                                        break Label_1184;
                                    }
                                    if (XmlPullParserUtil.f(xmlPullParser, "SegmentList")) {
                                        n2 = this.B(xmlPullParser, n2);
                                        segmentBase3 = this.k0(xmlPullParser, (SegmentBase.SegmentList)segmentBase2, n4, n, n10, n2, n5);
                                    }
                                    else {
                                        final long n12 = n2;
                                        final int n13 = n6;
                                        if (XmlPullParserUtil.f(xmlPullParser, "SegmentTemplate")) {
                                            n2 = this.B(xmlPullParser, n12);
                                            segmentBase3 = this.l0(xmlPullParser, (SegmentBase.SegmentTemplate)segmentBase2, list7, n4, n, n10, n2, n5);
                                        }
                                        else {
                                            if (XmlPullParserUtil.f(xmlPullParser, "InbandEventStream")) {
                                                list10.add(I(xmlPullParser, "InbandEventStream"));
                                                n2 = n12;
                                                xmlPullParser3 = xmlPullParser;
                                                segmentBase3 = segmentBase2;
                                                n11 = a;
                                                v = attributeValue4;
                                                n9 = n7;
                                                s5 = s3;
                                                n3 = n10;
                                                n6 = n13;
                                                s6 = s4;
                                                break Label_1184;
                                            }
                                            if (XmlPullParserUtil.f(xmlPullParser, "Label")) {
                                                v = this.V(xmlPullParser);
                                                n2 = n12;
                                                xmlPullParser3 = xmlPullParser;
                                                segmentBase3 = segmentBase2;
                                                n11 = a;
                                                n9 = n7;
                                                s5 = s3;
                                                n3 = n10;
                                                n6 = n13;
                                                s6 = s4;
                                                break Label_1184;
                                            }
                                            n2 = n12;
                                            xmlPullParser3 = xmlPullParser;
                                            segmentBase3 = segmentBase2;
                                            n11 = a;
                                            v = attributeValue4;
                                            n9 = n7;
                                            s5 = s3;
                                            n3 = n10;
                                            n6 = n13;
                                            s6 = s4;
                                            if (XmlPullParserUtil.e(xmlPullParser)) {
                                                this.z(xmlPullParser);
                                                s6 = s4;
                                                n6 = n13;
                                                n3 = n10;
                                                s5 = s3;
                                                n9 = n7;
                                                v = attributeValue4;
                                                n11 = a;
                                                segmentBase3 = segmentBase2;
                                                xmlPullParser3 = xmlPullParser;
                                                n2 = n12;
                                            }
                                            break Label_1184;
                                        }
                                    }
                                    xmlPullParser3 = xmlPullParser;
                                    n11 = a;
                                    v = attributeValue4;
                                    n9 = n7;
                                    s5 = s3;
                                    n3 = n10;
                                    s6 = s4;
                                    break Label_1184;
                                }
                                final String s7 = attributeValue3;
                                xmlPullParser3 = xmlPullParser2;
                                segmentBase3 = segmentBase2;
                                n11 = a;
                                v = attributeValue4;
                                n9 = n7;
                                s5 = s3;
                                s6 = s7;
                                break Label_1184;
                            }
                            q = q(attributeValue3, xmlPullParser2.getAttributeValue((String)null, s2));
                            n6 = p(n6, this.G(xmlPullParser));
                            xmlPullParser3 = xmlPullParser2;
                        }
                        segmentBase3 = segmentBase2;
                        n11 = a;
                        v = attributeValue4;
                        n9 = n7;
                        s5 = s3;
                        s6 = q;
                        break Label_1184;
                    }
                    final Pair<String, DrmInitData.SchemeData> f = this.F(xmlPullParser);
                    final Object first = f.first;
                    String s8 = s3;
                    if (first != null) {
                        s8 = (String)first;
                    }
                    final Object second = f.second;
                    b2 = n3;
                    n9 = n7;
                    s3 = s8;
                    if (second != null) {
                        list2.add(second);
                        b2 = n3;
                        n9 = n7;
                        s3 = s8;
                    }
                }
                n3 = b2;
                final String s9 = attributeValue3;
                xmlPullParser3 = xmlPullParser2;
                segmentBase3 = segmentBase2;
                n11 = a;
                v = attributeValue4;
                s5 = s3;
                s6 = s9;
            }
            if (XmlPullParserUtil.d(xmlPullParser3, "AdaptationSet")) {
                break;
            }
            final String s10 = s6;
            xmlPullParser2 = xmlPullParser3;
            segmentBase2 = segmentBase3;
            a = n11;
            attributeValue3 = s10;
            attributeValue4 = v;
            n7 = n9;
            s3 = s5;
        }
        final ArrayList list12 = new ArrayList(list8.size());
        for (int i = 0; i < list8.size(); ++i) {
            list12.add((Object)this.j((RepresentationInfo)list8.get(i), v, s5, list2, list10));
        }
        return this.c(u, n6, (List<Representation>)list12, list4, list6, list7);
    }
    
    protected void z(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        w(xmlPullParser);
    }
    
    protected static final class RepresentationInfo
    {
        public final Format a;
        public final ImmutableList<BaseUrl> b;
        public final SegmentBase c;
        public final String d;
        public final ArrayList<DrmInitData.SchemeData> e;
        public final ArrayList<Descriptor> f;
        public final long g;
        public final List<Descriptor> h;
        public final List<Descriptor> i;
        
        public RepresentationInfo(final Format a, final List<BaseUrl> list, final SegmentBase c, final String d, final ArrayList<DrmInitData.SchemeData> e, final ArrayList<Descriptor> f, final List<Descriptor> h, final List<Descriptor> i, final long g) {
            this.a = a;
            this.b = (ImmutableList<BaseUrl>)ImmutableList.copyOf((Collection)list);
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.h = h;
            this.i = i;
            this.g = g;
        }
    }
}
