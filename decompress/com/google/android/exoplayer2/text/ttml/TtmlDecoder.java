// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ttml;

import java.util.ArrayDeque;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ColorParser;
import java.io.IOException;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.util.Map;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import org.xmlpull.v1.XmlPullParser;
import com.google.common.base.Ascii;
import android.text.Layout$Alignment;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class TtmlDecoder extends SimpleSubtitleDecoder
{
    private static final Pattern p;
    private static final Pattern q;
    private static final Pattern r;
    static final Pattern s;
    static final Pattern t;
    private static final Pattern u;
    private static final Pattern v;
    private static final b w;
    private static final a x;
    private final XmlPullParserFactory o;
    
    static {
        p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
        t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
        u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
        v = Pattern.compile("^(\\d+) (\\d+)$");
        w = new b(30.0f, 1, 1);
        x = new a(32, 15);
    }
    
    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            (this.o = XmlPullParserFactory.newInstance()).setNamespaceAware(true);
        }
        catch (final XmlPullParserException ex) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", (Throwable)ex);
        }
    }
    
    private static TtmlStyle B(final TtmlStyle ttmlStyle) {
        TtmlStyle ttmlStyle2 = ttmlStyle;
        if (ttmlStyle == null) {
            ttmlStyle2 = new TtmlStyle();
        }
        return ttmlStyle2;
    }
    
    private static boolean C(final String s) {
        return s.equals("tt") || s.equals("head") || s.equals("body") || s.equals("div") || s.equals("p") || s.equals("span") || s.equals("br") || s.equals("style") || s.equals("styling") || s.equals("layout") || s.equals("region") || s.equals("metadata") || s.equals("image") || s.equals("data") || s.equals("information");
    }
    
    private static Layout$Alignment D(String e) {
        e = Ascii.e(e);
        e.hashCode();
        final int hashCode = e.hashCode();
        int n = -1;
        switch (hashCode) {
            case 109757538: {
                if (!e.equals("start")) {
                    break;
                }
                n = 4;
                break;
            }
            case 108511772: {
                if (!e.equals("right")) {
                    break;
                }
                n = 3;
                break;
            }
            case 3317767: {
                if (!e.equals("left")) {
                    break;
                }
                n = 2;
                break;
            }
            case 100571: {
                if (!e.equals("end")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1364013995: {
                if (!e.equals("center")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return null;
            }
            case 2:
            case 4: {
                return Layout$Alignment.ALIGN_NORMAL;
            }
            case 1:
            case 3: {
                return Layout$Alignment.ALIGN_OPPOSITE;
            }
            case 0: {
                return Layout$Alignment.ALIGN_CENTER;
            }
        }
    }
    
    private static a E(XmlPullParser attributeValue, final a a) throws SubtitleDecoderException {
        attributeValue = (XmlPullParser)attributeValue.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return a;
        }
        final Matcher matcher = TtmlDecoder.v.matcher((CharSequence)attributeValue);
        if (!matcher.matches()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring malformed cell resolution: ");
            sb.append((String)attributeValue);
            Log.i("TtmlDecoder", sb.toString());
            return a;
        }
        try {
            final int int1 = Integer.parseInt(Assertions.e(matcher.group(1)));
            final int int2 = Integer.parseInt(Assertions.e(matcher.group(2)));
            if (int1 != 0 && int2 != 0) {
                return new a(int1, int2);
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid cell resolution ");
            sb2.append(int1);
            sb2.append(" ");
            sb2.append(int2);
            throw new SubtitleDecoderException(sb2.toString());
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Ignoring malformed cell resolution: ");
            sb3.append((String)attributeValue);
            Log.i("TtmlDecoder", sb3.toString());
            return a;
        }
    }
    
    private static void F(String s, final TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        final String[] t0 = Util.T0(s, "\\s+");
        Matcher matcher;
        if (t0.length == 1) {
            matcher = TtmlDecoder.r.matcher(s);
        }
        else {
            if (t0.length != 2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid number of entries for fontSize: ");
                sb.append(t0.length);
                sb.append(".");
                throw new SubtitleDecoderException(sb.toString());
            }
            matcher = TtmlDecoder.r.matcher(t0[1]);
            Log.i("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (matcher.matches()) {
            s = Assertions.e(matcher.group(3));
            s.hashCode();
            int n = -1;
            switch (s) {
                case "px": {
                    n = 2;
                    break;
                }
                case "em": {
                    n = 1;
                    break;
                }
                case "%": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid unit for fontSize: '");
                    sb2.append(s);
                    sb2.append("'.");
                    throw new SubtitleDecoderException(sb2.toString());
                }
                case 2: {
                    ttmlStyle.z(1);
                    break;
                }
                case 1: {
                    ttmlStyle.z(2);
                    break;
                }
                case 0: {
                    ttmlStyle.z(3);
                    break;
                }
            }
            ttmlStyle.y(Float.parseFloat(Assertions.e(matcher.group(1))));
            return;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Invalid expression for fontSize: '");
        sb3.append(s);
        sb3.append("'.");
        throw new SubtitleDecoderException(sb3.toString());
    }
    
    private static b G(final XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        final String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int int1;
        if (attributeValue != null) {
            int1 = Integer.parseInt(attributeValue);
        }
        else {
            int1 = 30;
        }
        float n = 1.0f;
        final String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            final String[] t0 = Util.T0(attributeValue2, " ");
            if (t0.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            n = Integer.parseInt(t0[0]) / (float)Integer.parseInt(t0[1]);
        }
        final b w = TtmlDecoder.w;
        int n2 = w.b;
        final String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            n2 = Integer.parseInt(attributeValue3);
        }
        int n3 = w.c;
        final String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            n3 = Integer.parseInt(attributeValue4);
        }
        return new b(int1 * n, n2, n3);
    }
    
    private static Map<String, TtmlStyle> H(final XmlPullParser xmlPullParser, final Map<String, TtmlStyle> map, final a a, final c c, final Map<String, com.google.android.exoplayer2.text.ttml.c> map2, final Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "style")) {
                final String a2 = XmlPullParserUtil.a(xmlPullParser, "style");
                final TtmlStyle m = M(xmlPullParser, new TtmlStyle());
                if (a2 != null) {
                    final String[] n = N(a2);
                    for (int length = n.length, i = 0; i < length; ++i) {
                        m.a(map.get(n[i]));
                    }
                }
                final String g = m.g();
                if (g == null) {
                    continue;
                }
                map.put(g, m);
            }
            else if (XmlPullParserUtil.f(xmlPullParser, "region")) {
                final com.google.android.exoplayer2.text.ttml.c k = K(xmlPullParser, a, c);
                if (k == null) {
                    continue;
                }
                map2.put(k.a, k);
            }
            else {
                if (!XmlPullParserUtil.f(xmlPullParser, "metadata")) {
                    continue;
                }
                I(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "head"));
        return map;
    }
    
    private static void I(final XmlPullParser xmlPullParser, final Map<String, String> map) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "image")) {
                final String a = XmlPullParserUtil.a(xmlPullParser, "id");
                if (a == null) {
                    continue;
                }
                map.put(a, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "metadata"));
    }
    
    private static com.google.android.exoplayer2.text.ttml.b J(final XmlPullParser xmlPullParser, final com.google.android.exoplayer2.text.ttml.b b, final Map<String, com.google.android.exoplayer2.text.ttml.c> map, final b b2) throws SubtitleDecoderException {
        final int attributeCount = xmlPullParser.getAttributeCount();
        final TtmlStyle m = M(xmlPullParser, null);
        String s = null;
        String s2 = "";
        long n = -9223372036854775807L;
        long n2 = -9223372036854775807L;
        long n3 = -9223372036854775807L;
        String[] array = null;
        String[] array2 = null;
        String substring = null;
        long o = 0L;
        long o2 = 0L;
        long o3 = 0L;
        for (int i = 0; i < attributeCount; ++i, array = array2, s = substring, n = o, n2 = o2, n3 = o3) {
            final String attributeName = xmlPullParser.getAttributeName(i);
            final String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            int n4 = 0;
            Label_0260: {
                switch (attributeName) {
                    case "backgroundImage": {
                        n4 = 5;
                        break Label_0260;
                    }
                    case "style": {
                        n4 = 4;
                        break Label_0260;
                    }
                    case "begin": {
                        n4 = 3;
                        break Label_0260;
                    }
                    case "end": {
                        n4 = 2;
                        break Label_0260;
                    }
                    case "dur": {
                        n4 = 1;
                        break Label_0260;
                    }
                    case "region": {
                        n4 = 0;
                        break Label_0260;
                    }
                    default:
                        break;
                }
                n4 = -1;
            }
            switch (n4) {
                default: {
                    array2 = array;
                    substring = s;
                    o = n;
                    o2 = n2;
                    o3 = n3;
                    break;
                }
                case 5: {
                    array2 = array;
                    substring = s;
                    o = n;
                    o2 = n2;
                    o3 = n3;
                    if (attributeValue.startsWith("#")) {
                        substring = attributeValue.substring(1);
                        array2 = array;
                        o = n;
                        o2 = n2;
                        o3 = n3;
                        break;
                    }
                    break;
                }
                case 4: {
                    final String[] n5 = N(attributeValue);
                    array2 = array;
                    substring = s;
                    o = n;
                    o2 = n2;
                    o3 = n3;
                    if (n5.length > 0) {
                        array2 = n5;
                        substring = s;
                        o = n;
                        o2 = n2;
                        o3 = n3;
                        break;
                    }
                    break;
                }
                case 3: {
                    o = O(attributeValue, b2);
                    o3 = n3;
                    o2 = n2;
                    substring = s;
                    array2 = array;
                    break;
                }
                case 2: {
                    o2 = O(attributeValue, b2);
                    array2 = array;
                    substring = s;
                    o = n;
                    o3 = n3;
                    break;
                }
                case 1: {
                    o3 = O(attributeValue, b2);
                    array2 = array;
                    substring = s;
                    o = n;
                    o2 = n2;
                    break;
                }
                case 0: {
                    array2 = array;
                    substring = s;
                    o = n;
                    o2 = n2;
                    o3 = n3;
                    if (map.containsKey(attributeValue)) {
                        s2 = attributeValue;
                        o3 = n3;
                        o2 = n2;
                        o = n;
                        substring = s;
                        array2 = array;
                        break;
                    }
                    break;
                }
            }
        }
        long n6;
        long n7;
        if (b != null) {
            final long d = b.d;
            n6 = n;
            n7 = n2;
            if (d != -9223372036854775807L) {
                long n8 = n;
                if (n != -9223372036854775807L) {
                    n8 = n + d;
                }
                n6 = n8;
                n7 = n2;
                if (n2 != -9223372036854775807L) {
                    n7 = n2 + d;
                    n6 = n8;
                }
            }
        }
        else {
            n7 = n2;
            n6 = n;
        }
        if (n7 == -9223372036854775807L) {
            if (n3 != -9223372036854775807L) {
                final long e = n6 + n3;
                return b.c(xmlPullParser.getName(), n6, e, m, array, s2, s, b);
            }
            if (b != null) {
                final long e = b.e;
                if (e != -9223372036854775807L) {
                    return b.c(xmlPullParser.getName(), n6, e, m, array, s2, s, b);
                }
            }
        }
        final long e = n7;
        return b.c(xmlPullParser.getName(), n6, e, m, array, s2, s, b);
    }
    
    private static com.google.android.exoplayer2.text.ttml.c K(final XmlPullParser xmlPullParser, final a a, final c c) {
        final String a2 = XmlPullParserUtil.a(xmlPullParser, "id");
        if (a2 == null) {
            return null;
        }
        final String a3 = XmlPullParserUtil.a(xmlPullParser, "origin");
        if (a3 != null) {
            final Pattern t = TtmlDecoder.t;
            final Matcher matcher = t.matcher(a3);
            final Pattern u = TtmlDecoder.u;
            final Matcher matcher2 = u.matcher(a3);
            Label_0254: {
                if (matcher.matches()) {
                    try {
                        final float n = Float.parseFloat(Assertions.e(matcher.group(1))) / 100.0f;
                        final float n2 = Float.parseFloat(Assertions.e(matcher.group(2))) / 100.0f;
                        break Label_0254;
                    }
                    catch (final NumberFormatException ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Ignoring region with malformed origin: ");
                        sb.append(a3);
                        Log.i("TtmlDecoder", sb.toString());
                        return null;
                    }
                }
                if (!matcher2.matches()) {
                    break Label_0254;
                }
                if (c == null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring region with missing tts:extent: ");
                    sb2.append(a3);
                    Log.i("TtmlDecoder", sb2.toString());
                    return null;
                }
                try {
                    final int int1 = Integer.parseInt(Assertions.e(matcher2.group(1)));
                    final int int2 = Integer.parseInt(Assertions.e(matcher2.group(2)));
                    final float n = int1 / (float)c.a;
                    float n2 = int2 / (float)c.b;
                    final String a4 = XmlPullParserUtil.a(xmlPullParser, "extent");
                    if (a4 != null) {
                        final Matcher matcher3 = t.matcher(a4);
                        final Matcher matcher4 = u.matcher(a4);
                        Label_0488: {
                            if (matcher3.matches()) {
                                try {
                                    final float n3 = Float.parseFloat(Assertions.e(matcher3.group(1))) / 100.0f;
                                    final float n4 = Float.parseFloat(Assertions.e(matcher3.group(2))) / 100.0f;
                                    break Label_0488;
                                }
                                catch (final NumberFormatException ex2) {
                                    final StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Ignoring region with malformed extent: ");
                                    sb3.append(a3);
                                    Log.i("TtmlDecoder", sb3.toString());
                                    return null;
                                }
                            }
                            if (!matcher4.matches()) {
                                break Label_0488;
                            }
                            if (c == null) {
                                final StringBuilder sb4 = new StringBuilder();
                                sb4.append("Ignoring region with missing tts:extent: ");
                                sb4.append(a3);
                                Log.i("TtmlDecoder", sb4.toString());
                                return null;
                            }
                            try {
                                final int int3 = Integer.parseInt(Assertions.e(matcher4.group(1)));
                                final int int4 = Integer.parseInt(Assertions.e(matcher4.group(2)));
                                final float n3 = int3 / (float)c.a;
                                final float n4 = int4 / (float)c.b;
                                final String a5 = XmlPullParserUtil.a(xmlPullParser, "displayAlign");
                                int n5 = 0;
                                int n6 = 0;
                                Label_0562: {
                                    if (a5 != null) {
                                        final String e = Ascii.e(a5);
                                        e.hashCode();
                                        if (e.equals("center")) {
                                            n2 += n4 / 2.0f;
                                            n6 = 1;
                                            break Label_0562;
                                        }
                                        if (e.equals("after")) {
                                            n2 += n4;
                                            n6 = 2;
                                            break Label_0562;
                                        }
                                    }
                                    n6 = 0;
                                }
                                final float n7 = 1.0f / a.b;
                                final String a6 = XmlPullParserUtil.a(xmlPullParser, "writingMode");
                                if (a6 != null) {
                                    final String e2 = Ascii.e(a6);
                                    e2.hashCode();
                                    Label_0689: {
                                        switch (e2) {
                                            case "tbrl": {
                                                n5 = 2;
                                                break Label_0689;
                                            }
                                            case "tblr": {
                                                n5 = 1;
                                                break Label_0689;
                                            }
                                            case "tb": {
                                                break Label_0689;
                                            }
                                            default:
                                                break;
                                        }
                                        n5 = -1;
                                    }
                                    switch (n5) {
                                        case 2: {
                                            final int n8 = 1;
                                            return new com.google.android.exoplayer2.text.ttml.c(a2, n, n2, 0, n6, n3, n4, 1, n7, n8);
                                        }
                                        case 0:
                                        case 1: {
                                            final int n8 = 2;
                                            return new com.google.android.exoplayer2.text.ttml.c(a2, n, n2, 0, n6, n3, n4, 1, n7, n8);
                                        }
                                    }
                                }
                                final int n8 = Integer.MIN_VALUE;
                                return new com.google.android.exoplayer2.text.ttml.c(a2, n, n2, 0, n6, n3, n4, 1, n7, n8);
                            }
                            catch (final NumberFormatException ex3) {
                                final StringBuilder sb5 = new StringBuilder();
                                sb5.append("Ignoring region with malformed extent: ");
                                sb5.append(a3);
                                Log.i("TtmlDecoder", sb5.toString());
                                return null;
                            }
                        }
                        final StringBuilder sb6 = new StringBuilder();
                        sb6.append("Ignoring region with unsupported extent: ");
                        sb6.append(a3);
                        Log.i("TtmlDecoder", sb6.toString());
                        return null;
                    }
                    Log.i("TtmlDecoder", "Ignoring region without an extent");
                    return null;
                }
                catch (final NumberFormatException ex4) {
                    final StringBuilder sb7 = new StringBuilder();
                    sb7.append("Ignoring region with malformed origin: ");
                    sb7.append(a3);
                    Log.i("TtmlDecoder", sb7.toString());
                    return null;
                }
            }
            final StringBuilder sb8 = new StringBuilder();
            sb8.append("Ignoring region with unsupported origin: ");
            sb8.append(a3);
            Log.i("TtmlDecoder", sb8.toString());
            return null;
        }
        Log.i("TtmlDecoder", "Ignoring region without an origin");
        return null;
    }
    
    private static float L(final String s) {
        final Matcher matcher = TtmlDecoder.s.matcher(s);
        if (!matcher.matches()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid value for shear: ");
            sb.append(s);
            Log.i("TtmlDecoder", sb.toString());
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(Assertions.e(matcher.group(1)))));
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to parse shear: ");
            sb2.append(s);
            Log.j("TtmlDecoder", sb2.toString(), ex);
            return Float.MAX_VALUE;
        }
    }
    
    private static TtmlStyle M(final XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        final int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
        TtmlStyle ttmlStyle2 = ttmlStyle;
        while (i < attributeCount) {
            final String attributeValue = xmlPullParser.getAttributeValue(i);
            final String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            final int hashCode = attributeName.hashCode();
            final int n = 5;
            final int n2 = -1;
            int n3 = 0;
            Label_0465: {
                switch (hashCode) {
                    case 1754920356: {
                        if (!attributeName.equals("multiRowAlign")) {
                            break;
                        }
                        n3 = 14;
                        break Label_0465;
                    }
                    case 1287124693: {
                        if (!attributeName.equals("backgroundColor")) {
                            break;
                        }
                        n3 = 13;
                        break Label_0465;
                    }
                    case 1115953443: {
                        if (!attributeName.equals("rubyPosition")) {
                            break;
                        }
                        n3 = 12;
                        break Label_0465;
                    }
                    case 921125321: {
                        if (!attributeName.equals("textEmphasis")) {
                            break;
                        }
                        n3 = 11;
                        break Label_0465;
                    }
                    case 365601008: {
                        if (!attributeName.equals("fontSize")) {
                            break;
                        }
                        n3 = 10;
                        break Label_0465;
                    }
                    case 110138194: {
                        if (!attributeName.equals("textCombine")) {
                            break;
                        }
                        n3 = 9;
                        break Label_0465;
                    }
                    case 109403361: {
                        if (!attributeName.equals("shear")) {
                            break;
                        }
                        n3 = 8;
                        break Label_0465;
                    }
                    case 94842723: {
                        if (!attributeName.equals("color")) {
                            break;
                        }
                        n3 = 7;
                        break Label_0465;
                    }
                    case 3511770: {
                        if (!attributeName.equals("ruby")) {
                            break;
                        }
                        n3 = 6;
                        break Label_0465;
                    }
                    case 3355: {
                        if (!attributeName.equals("id")) {
                            break;
                        }
                        n3 = 5;
                        break Label_0465;
                    }
                    case -734428249: {
                        if (!attributeName.equals("fontWeight")) {
                            break;
                        }
                        n3 = 4;
                        break Label_0465;
                    }
                    case -879295043: {
                        if (!attributeName.equals("textDecoration")) {
                            break;
                        }
                        n3 = 3;
                        break Label_0465;
                    }
                    case -1065511464: {
                        if (!attributeName.equals("textAlign")) {
                            break;
                        }
                        n3 = 2;
                        break Label_0465;
                    }
                    case -1224696685: {
                        if (!attributeName.equals("fontFamily")) {
                            break;
                        }
                        n3 = 1;
                        break Label_0465;
                    }
                    case -1550943582: {
                        if (!attributeName.equals("fontStyle")) {
                            break;
                        }
                        n3 = 0;
                        break Label_0465;
                    }
                }
                n3 = -1;
            }
            Label_1526: {
                switch (n3) {
                    default: {
                        ttmlStyle = ttmlStyle2;
                        break;
                    }
                    case 14: {
                        ttmlStyle = B(ttmlStyle2).D(D(attributeValue));
                        break;
                    }
                    case 13: {
                        ttmlStyle = B(ttmlStyle2);
                        try {
                            ttmlStyle.u(ColorParser.c(attributeValue));
                        }
                        catch (final IllegalArgumentException ex) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Failed parsing background value: ");
                            sb.append(attributeValue);
                            Log.i("TtmlDecoder", sb.toString());
                        }
                        break;
                    }
                    case 12: {
                        final String e = Ascii.e(attributeValue);
                        e.hashCode();
                        if (e.equals("before")) {
                            ttmlStyle = B(ttmlStyle2).E(1);
                            break;
                        }
                        if (!e.equals("after")) {
                            ttmlStyle = ttmlStyle2;
                            break;
                        }
                        ttmlStyle = B(ttmlStyle2).E(2);
                        break;
                    }
                    case 11: {
                        ttmlStyle = B(ttmlStyle2).J(TextEmphasis.a(attributeValue));
                        break;
                    }
                    case 10: {
                        ttmlStyle = ttmlStyle2;
                        try {
                            final TtmlStyle ttmlStyle3 = ttmlStyle = B(ttmlStyle2);
                            F(attributeValue, ttmlStyle3);
                            ttmlStyle = ttmlStyle3;
                        }
                        catch (final SubtitleDecoderException ex2) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed parsing fontSize value: ");
                            sb2.append(attributeValue);
                            Log.i("TtmlDecoder", sb2.toString());
                        }
                        break;
                    }
                    case 9: {
                        final String e2 = Ascii.e(attributeValue);
                        e2.hashCode();
                        if (e2.equals("all")) {
                            ttmlStyle = B(ttmlStyle2).I(true);
                            break;
                        }
                        if (!e2.equals("none")) {
                            ttmlStyle = ttmlStyle2;
                            break;
                        }
                        ttmlStyle = B(ttmlStyle2).I(false);
                        break;
                    }
                    case 8: {
                        ttmlStyle = B(ttmlStyle2).G(L(attributeValue));
                        break;
                    }
                    case 7: {
                        ttmlStyle = B(ttmlStyle2);
                        try {
                            ttmlStyle.w(ColorParser.c(attributeValue));
                        }
                        catch (final IllegalArgumentException ex3) {
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("Failed parsing color value: ");
                            sb3.append(attributeValue);
                            Log.i("TtmlDecoder", sb3.toString());
                        }
                        break;
                    }
                    case 6: {
                        final String e3 = Ascii.e(attributeValue);
                        e3.hashCode();
                        int n4 = 0;
                        Label_1092: {
                            switch (e3.hashCode()) {
                                case 3556653: {
                                    n4 = n;
                                    if (!e3.equals("text")) {
                                        break;
                                    }
                                    break Label_1092;
                                }
                                case 3016401: {
                                    if (!e3.equals("base")) {
                                        break;
                                    }
                                    n4 = 4;
                                    break Label_1092;
                                }
                                case -136074796: {
                                    if (!e3.equals("textContainer")) {
                                        break;
                                    }
                                    n4 = 3;
                                    break Label_1092;
                                }
                                case -250518009: {
                                    if (!e3.equals("delimiter")) {
                                        break;
                                    }
                                    n4 = 2;
                                    break Label_1092;
                                }
                                case -410956671: {
                                    if (!e3.equals("container")) {
                                        break;
                                    }
                                    n4 = 1;
                                    break Label_1092;
                                }
                                case -618561360: {
                                    if (!e3.equals("baseContainer")) {
                                        break;
                                    }
                                    n4 = 0;
                                    break Label_1092;
                                }
                            }
                            n4 = -1;
                        }
                        switch (n4) {
                            default: {
                                ttmlStyle = ttmlStyle2;
                                break Label_1526;
                            }
                            case 3:
                            case 5: {
                                ttmlStyle = B(ttmlStyle2).F(3);
                                break Label_1526;
                            }
                            case 2: {
                                ttmlStyle = B(ttmlStyle2).F(4);
                                break Label_1526;
                            }
                            case 1: {
                                ttmlStyle = B(ttmlStyle2).F(1);
                                break Label_1526;
                            }
                            case 0:
                            case 4: {
                                ttmlStyle = B(ttmlStyle2).F(2);
                                break Label_1526;
                            }
                        }
                        break;
                    }
                    case 5: {
                        ttmlStyle = ttmlStyle2;
                        if ("style".equals(xmlPullParser.getName())) {
                            ttmlStyle = B(ttmlStyle2).A(attributeValue);
                            break;
                        }
                        break;
                    }
                    case 4: {
                        ttmlStyle = B(ttmlStyle2).v("bold".equalsIgnoreCase(attributeValue));
                        break;
                    }
                    case 3: {
                        final String e4 = Ascii.e(attributeValue);
                        e4.hashCode();
                        int n5 = 0;
                        switch (e4.hashCode()) {
                            default: {
                                n5 = n2;
                                break;
                            }
                            case 1679736913: {
                                if (!e4.equals("linethrough")) {
                                    n5 = n2;
                                    break;
                                }
                                n5 = 3;
                                break;
                            }
                            case 913457136: {
                                if (!e4.equals("nolinethrough")) {
                                    n5 = n2;
                                    break;
                                }
                                n5 = 2;
                                break;
                            }
                            case -1026963764: {
                                if (!e4.equals("underline")) {
                                    n5 = n2;
                                    break;
                                }
                                n5 = 1;
                                break;
                            }
                            case -1461280213: {
                                if (!e4.equals("nounderline")) {
                                    n5 = n2;
                                    break;
                                }
                                n5 = 0;
                                break;
                            }
                        }
                        switch (n5) {
                            default: {
                                ttmlStyle = ttmlStyle2;
                                break Label_1526;
                            }
                            case 3: {
                                ttmlStyle = B(ttmlStyle2).C(true);
                                break Label_1526;
                            }
                            case 2: {
                                ttmlStyle = B(ttmlStyle2).C(false);
                                break Label_1526;
                            }
                            case 1: {
                                ttmlStyle = B(ttmlStyle2).K(true);
                                break Label_1526;
                            }
                            case 0: {
                                ttmlStyle = B(ttmlStyle2).K(false);
                                break Label_1526;
                            }
                        }
                        break;
                    }
                    case 2: {
                        ttmlStyle = B(ttmlStyle2).H(D(attributeValue));
                        break;
                    }
                    case 1: {
                        ttmlStyle = B(ttmlStyle2).x(attributeValue);
                        break;
                    }
                    case 0: {
                        ttmlStyle = B(ttmlStyle2).B("italic".equalsIgnoreCase(attributeValue));
                        break;
                    }
                }
            }
            ++i;
            ttmlStyle2 = ttmlStyle;
        }
        return ttmlStyle2;
    }
    
    private static String[] N(String trim) {
        trim = trim.trim();
        String[] t0;
        if (trim.isEmpty()) {
            t0 = new String[0];
        }
        else {
            t0 = Util.T0(trim, "\\s+");
        }
        return t0;
    }
    
    private static long O(String s, final b b) throws SubtitleDecoderException {
        final Matcher matcher = TtmlDecoder.p.matcher(s);
        final boolean matches = matcher.matches();
        int n = 4;
        if (matches) {
            final double n2 = (double)(Long.parseLong(Assertions.e(matcher.group(1))) * 3600L);
            final double n3 = (double)(Long.parseLong(Assertions.e(matcher.group(2))) * 60L);
            final double n4 = (double)Long.parseLong(Assertions.e(matcher.group(3)));
            s = matcher.group(4);
            double n5 = 0.0;
            double double1;
            if (s != null) {
                double1 = Double.parseDouble(s);
            }
            else {
                double1 = 0.0;
            }
            s = matcher.group(5);
            double n6;
            if (s != null) {
                n6 = Long.parseLong(s) / b.a;
            }
            else {
                n6 = 0.0;
            }
            s = matcher.group(6);
            if (s != null) {
                n5 = Long.parseLong(s) / (double)b.b / b.a;
            }
            return (long)((n2 + n3 + n4 + double1 + n6 + n5) * 1000000.0);
        }
        final Matcher matcher2 = TtmlDecoder.q.matcher(s);
        if (matcher2.matches()) {
            final double double2 = Double.parseDouble(Assertions.e(matcher2.group(1)));
            s = Assertions.e(matcher2.group(2));
            s.hashCode();
            Label_0392: {
                switch (s) {
                    case "ms": {
                        break Label_0392;
                    }
                    case "t": {
                        n = 3;
                        break Label_0392;
                    }
                    case "m": {
                        n = 2;
                        break Label_0392;
                    }
                    case "h": {
                        n = 1;
                        break Label_0392;
                    }
                    case "f": {
                        n = 0;
                        break Label_0392;
                    }
                    default:
                        break;
                }
                n = -1;
            }
            double n9 = 0.0;
            Label_0466: {
                double n8 = 0.0;
                switch (n) {
                    default: {
                        final double n7 = double2;
                        return (long)(n7 * 1000000.0);
                    }
                    case 4: {
                        n8 = 1000.0;
                        break;
                    }
                    case 3: {
                        n8 = b.c;
                        break;
                    }
                    case 2: {
                        n9 = 60.0;
                        break Label_0466;
                    }
                    case 1: {
                        n9 = 3600.0;
                        break Label_0466;
                    }
                    case 0: {
                        n8 = b.a;
                        break;
                    }
                }
                final double n7 = double2 / n8;
                return (long)(n7 * 1000000.0);
            }
            final double n7 = double2 * n9;
            return (long)(n7 * 1000000.0);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Malformed time expression: ");
        sb.append(s);
        throw new SubtitleDecoderException(sb.toString());
    }
    
    private static c P(XmlPullParser a) {
        a = (XmlPullParser)XmlPullParserUtil.a(a, "extent");
        if (a == null) {
            return null;
        }
        final Matcher matcher = TtmlDecoder.u.matcher((CharSequence)a);
        if (!matcher.matches()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring non-pixel tts extent: ");
            sb.append((String)a);
            Log.i("TtmlDecoder", sb.toString());
            return null;
        }
        try {
            return new c(Integer.parseInt(Assertions.e(matcher.group(1))), Integer.parseInt(Assertions.e(matcher.group(2))));
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring malformed tts extent: ");
            sb2.append((String)a);
            Log.i("TtmlDecoder", sb2.toString());
            return null;
        }
    }
    
    @Override
    protected Subtitle z(byte[] o, int n, final boolean b) throws SubtitleDecoderException {
        try {
            final XmlPullParser pullParser = this.o.newPullParser();
            final HashMap<String, TtmlStyle> hashMap = new HashMap<String, TtmlStyle>();
            final HashMap hashMap2 = new HashMap();
            final HashMap<String, String> hashMap3 = new HashMap<String, String>();
            hashMap2.put("", new com.google.android.exoplayer2.text.ttml.c(""));
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])o, 0, n);
            c p3 = null;
            pullParser.setInput((InputStream)byteArrayInputStream, (String)null);
            final ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
            int i = pullParser.getEventType();
            o = TtmlDecoder.w;
            a a = TtmlDecoder.x;
            int n2 = 0;
            Subtitle subtitle = null;
            while (i != 1) {
                final com.google.android.exoplayer2.text.ttml.b b2 = arrayDeque.peek();
                c c = null;
                Object o2 = null;
                a a2 = null;
                Subtitle subtitle2 = null;
                Label_0584: {
                    if (n2 == 0) {
                        final String name = pullParser.getName();
                        if (i == 2) {
                            if ("tt".equals(name)) {
                                o = G(pullParser);
                                a = E(pullParser, TtmlDecoder.x);
                                p3 = P(pullParser);
                            }
                            while (true) {
                                if (!C(name)) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Ignoring unsupported tag: ");
                                    sb.append(pullParser.getName());
                                    Log.f("TtmlDecoder", sb.toString());
                                    n = n2 + 1;
                                    break Label_0326;
                                }
                                if ("head".equals(name)) {
                                    H(pullParser, hashMap, a, p3, hashMap2, hashMap3);
                                    n = n2;
                                    break Label_0326;
                                }
                                try {
                                    final com.google.android.exoplayer2.text.ttml.b j = J(pullParser, b2, hashMap2, (b)o);
                                    arrayDeque.push(j);
                                    n = n2;
                                    if (b2 != null) {
                                        b2.a(j);
                                        n = n2;
                                    }
                                    c = p3;
                                    o2 = o;
                                    a2 = a;
                                    subtitle2 = subtitle;
                                    break Label_0584;
                                }
                                catch (final SubtitleDecoderException ex) {
                                    Log.j("TtmlDecoder", "Suppressing parser error", ex);
                                    n = n2 + 1;
                                    continue;
                                }
                                break;
                            }
                        }
                        if (i == 4) {
                            Assertions.e(b2).a(b.d(pullParser.getText()));
                            c = p3;
                            o2 = o;
                            a2 = a;
                            n = n2;
                            subtitle2 = subtitle;
                        }
                        else {
                            c = p3;
                            o2 = o;
                            a2 = a;
                            n = n2;
                            subtitle2 = subtitle;
                            if (i == 3) {
                                if (pullParser.getName().equals("tt")) {
                                    subtitle = new e(Assertions.e((com.google.android.exoplayer2.text.ttml.b)arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                                }
                                arrayDeque.pop();
                                c = p3;
                                o2 = o;
                                a2 = a;
                                n = n2;
                                subtitle2 = subtitle;
                            }
                        }
                    }
                    else if (i == 2) {
                        n = n2 + 1;
                        c = p3;
                        o2 = o;
                        a2 = a;
                        subtitle2 = subtitle;
                    }
                    else {
                        c = p3;
                        o2 = o;
                        a2 = a;
                        n = n2;
                        subtitle2 = subtitle;
                        if (i == 3) {
                            n = n2 - 1;
                            subtitle2 = subtitle;
                            a2 = a;
                            o2 = o;
                            c = p3;
                        }
                    }
                }
                pullParser.next();
                i = pullParser.getEventType();
                p3 = c;
                o = o2;
                a = a2;
                n2 = n;
                subtitle = subtitle2;
            }
            if (subtitle != null) {
                return subtitle;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        }
        catch (final IOException ex2) {
            throw new IllegalStateException("Unexpected error when reading input.", ex2);
        }
        catch (final XmlPullParserException ex3) {
            throw new SubtitleDecoderException("Unable to decode source", (Throwable)ex3);
        }
    }
    
    private static final class a
    {
        final int a;
        final int b;
        
        a(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static final class b
    {
        final float a;
        final int b;
        final int c;
        
        b(final float a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    private static final class c
    {
        final int a;
        final int b;
        
        c(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
}
