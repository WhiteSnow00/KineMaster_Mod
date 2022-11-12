// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;

public final class XmlPullParserUtil
{
    private XmlPullParserUtil() {
    }
    
    public static String a(final XmlPullParser xmlPullParser, final String s) {
        for (int attributeCount = xmlPullParser.getAttributeCount(), i = 0; i < attributeCount; ++i) {
            if (xmlPullParser.getAttributeName(i).equals(s)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
    
    public static String b(final XmlPullParser xmlPullParser, final String s) {
        for (int attributeCount = xmlPullParser.getAttributeCount(), i = 0; i < attributeCount; ++i) {
            if (h(xmlPullParser.getAttributeName(i)).equals(s)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
    
    public static boolean c(final XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 3;
    }
    
    public static boolean d(final XmlPullParser xmlPullParser, final String s) throws XmlPullParserException {
        return c(xmlPullParser) && xmlPullParser.getName().equals(s);
    }
    
    public static boolean e(final XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }
    
    public static boolean f(final XmlPullParser xmlPullParser, final String s) throws XmlPullParserException {
        return e(xmlPullParser) && xmlPullParser.getName().equals(s);
    }
    
    public static boolean g(final XmlPullParser xmlPullParser, final String s) throws XmlPullParserException {
        return e(xmlPullParser) && h(xmlPullParser.getName()).equals(s);
    }
    
    private static String h(String substring) {
        final int index = substring.indexOf(58);
        if (index != -1) {
            substring = substring.substring(index + 1);
        }
        return substring;
    }
}
