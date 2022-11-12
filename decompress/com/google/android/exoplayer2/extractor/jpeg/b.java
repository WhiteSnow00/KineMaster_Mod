// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.jpeg;

import com.google.common.collect.ImmutableList$Builder;
import org.xmlpull.v1.XmlPullParser;
import java.util.List;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.Reader;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import com.google.android.exoplayer2.ParserException;
import org.xmlpull.v1.XmlPullParserException;
import com.google.android.exoplayer2.util.Log;

final class b
{
    private static final String[] a;
    private static final String[] b;
    private static final String[] c;
    
    static {
        a = new String[] { "Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo" };
        b = new String[] { "Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs" };
        c = new String[] { "Camera:MicroVideoOffset", "GCamera:MicroVideoOffset" };
    }
    
    public static MotionPhotoDescription a(final String s) throws IOException {
        try {
            return b(s);
        }
        catch (final XmlPullParserException | ParserException | NumberFormatException ex) {
            Log.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }
    
    private static MotionPhotoDescription b(final String s) throws XmlPullParserException, IOException {
        final XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
        pullParser.setInput((Reader)new StringReader(s));
        pullParser.next();
        if (!XmlPullParserUtil.f(pullParser, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
        }
        long n = -9223372036854775807L;
        Object of = ImmutableList.of();
        long e;
        Object o;
        do {
            pullParser.next();
            if (XmlPullParserUtil.f(pullParser, "rdf:Description")) {
                if (!d(pullParser)) {
                    return null;
                }
                e = e(pullParser);
                o = c(pullParser);
            }
            else if (XmlPullParserUtil.f(pullParser, "Container:Directory")) {
                o = f(pullParser, "Container", "Item");
                e = n;
            }
            else {
                o = of;
                e = n;
                if (XmlPullParserUtil.f(pullParser, "GContainer:Directory")) {
                    o = f(pullParser, "GContainer", "GContainerItem");
                    e = n;
                }
            }
            of = o;
            n = e;
        } while (!XmlPullParserUtil.d(pullParser, "x:xmpmeta"));
        if (((List)o).isEmpty()) {
            return null;
        }
        return new MotionPhotoDescription(e, (List<MotionPhotoDescription.ContainerItem>)o);
    }
    
    private static ImmutableList<MotionPhotoDescription.ContainerItem> c(final XmlPullParser xmlPullParser) {
        final String[] c = com.google.android.exoplayer2.extractor.jpeg.b.c;
        for (int length = c.length, i = 0; i < length; ++i) {
            final String a = XmlPullParserUtil.a(xmlPullParser, c[i]);
            if (a != null) {
                return (ImmutableList<MotionPhotoDescription.ContainerItem>)ImmutableList.of((Object)new MotionPhotoDescription.ContainerItem("image/jpeg", "Primary", 0L, 0L), (Object)new MotionPhotoDescription.ContainerItem("video/mp4", "MotionPhoto", Long.parseLong(a), 0L));
            }
        }
        return (ImmutableList<MotionPhotoDescription.ContainerItem>)ImmutableList.of();
    }
    
    private static boolean d(final XmlPullParser xmlPullParser) {
        final String[] a = com.google.android.exoplayer2.extractor.jpeg.b.a;
        final int length = a.length;
        boolean b = false;
        for (int i = 0; i < length; ++i) {
            final String a2 = XmlPullParserUtil.a(xmlPullParser, a[i]);
            if (a2 != null) {
                if (Integer.parseInt(a2) == 1) {
                    b = true;
                }
                return b;
            }
        }
        return false;
    }
    
    private static long e(final XmlPullParser xmlPullParser) {
        final String[] b = com.google.android.exoplayer2.extractor.jpeg.b.b;
        final int length = b.length;
        int n = 0;
        while (true) {
            long n2 = -9223372036854775807L;
            if (n >= length) {
                return -9223372036854775807L;
            }
            final String a = XmlPullParserUtil.a(xmlPullParser, b[n]);
            if (a != null) {
                final long long1 = Long.parseLong(a);
                if (long1 != -1L) {
                    n2 = long1;
                }
                return n2;
            }
            ++n;
        }
    }
    
    private static ImmutableList<MotionPhotoDescription.ContainerItem> f(final XmlPullParser xmlPullParser, String string, final String s) throws XmlPullParserException, IOException {
        final ImmutableList$Builder builder = ImmutableList.builder();
        final StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(":Item");
        final String string2 = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append(":Directory");
        string = sb2.toString();
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, string2)) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(s);
                sb3.append(":Mime");
                final String string3 = sb3.toString();
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(s);
                sb4.append(":Semantic");
                final String string4 = sb4.toString();
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(s);
                sb5.append(":Length");
                final String string5 = sb5.toString();
                final StringBuilder sb6 = new StringBuilder();
                sb6.append(s);
                sb6.append(":Padding");
                final String string6 = sb6.toString();
                final String a = XmlPullParserUtil.a(xmlPullParser, string3);
                final String a2 = XmlPullParserUtil.a(xmlPullParser, string4);
                final String a3 = XmlPullParserUtil.a(xmlPullParser, string5);
                final String a4 = XmlPullParserUtil.a(xmlPullParser, string6);
                if (a == null || a2 == null) {
                    return (ImmutableList<MotionPhotoDescription.ContainerItem>)ImmutableList.of();
                }
                long long1;
                if (a3 != null) {
                    long1 = Long.parseLong(a3);
                }
                else {
                    long1 = 0L;
                }
                long long2;
                if (a4 != null) {
                    long2 = Long.parseLong(a4);
                }
                else {
                    long2 = 0L;
                }
                builder.i((Object)new MotionPhotoDescription.ContainerItem(a, a2, long1, long2));
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, string));
        return (ImmutableList<MotionPhotoDescription.ContainerItem>)builder.l();
    }
}
