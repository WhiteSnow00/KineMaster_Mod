// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class e
{
    static final String[] a;
    
    static {
        a = new String[] { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient" };
    }
    
    private static CommentFrame a(final int n, final ParsableByteArray parsableByteArray) {
        final int n2 = parsableByteArray.n();
        if (parsableByteArray.n() == 1684108385) {
            parsableByteArray.Q(8);
            final String y = parsableByteArray.y(n2 - 16);
            return new CommentFrame("und", y, y);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to parse comment attribute: ");
        sb.append(com.google.android.exoplayer2.extractor.mp4.a.a(n));
        Log.i("MetadataUtil", sb.toString());
        return null;
    }
    
    private static ApicFrame b(final ParsableByteArray parsableByteArray) {
        int n = parsableByteArray.n();
        if (parsableByteArray.n() != 1684108385) {
            Log.i("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        final int b = com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n());
        String s;
        if (b == 13) {
            s = "image/jpeg";
        }
        else if (b == 14) {
            s = "image/png";
        }
        else {
            s = null;
        }
        if (s == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized cover art flags: ");
            sb.append(b);
            Log.i("MetadataUtil", sb.toString());
            return null;
        }
        parsableByteArray.Q(4);
        n -= 16;
        final byte[] array = new byte[n];
        parsableByteArray.j(array, 0, n);
        return new ApicFrame(s, null, 3, array);
    }
    
    public static Metadata.Entry c(final ParsableByteArray parsableByteArray) {
        final int n = parsableByteArray.e() + parsableByteArray.n();
        final int n2 = parsableByteArray.n();
        int n3 = n2 >> 24 & 0xFF;
        Label_0788: {
            Label_0463: {
                if (n3 == 169 || n3 == 253) {
                    break Label_0463;
                }
                Label_0062: {
                    if (n2 != 1735291493) {
                        break Label_0062;
                    }
                    try {
                        final TextInformationFrame g = g(parsableByteArray);
                        parsableByteArray.P(n);
                        return g;
                        iftrue(Label_0087:)(n2 != 1684632427);
                        Block_16: {
                            break Block_16;
                            Label_0087: {
                                iftrue(Label_0112:)(n2 != 1953655662);
                            }
                            Block_30: {
                                while (true) {
                                    while (true) {
                                        TextInformationFrame h;
                                        TextInformationFrame h2;
                                        TextInformationFrame h3;
                                        Id3Frame i;
                                        Id3Frame j;
                                        TextInformationFrame h4;
                                        TextInformationFrame h5;
                                        ApicFrame b;
                                        Id3Frame k;
                                        CommentFrame a;
                                        TextInformationFrame d;
                                        Id3Frame e;
                                        Id3Frame l;
                                        TextInformationFrame h6;
                                        TextInformationFrame h7;
                                        Block_25_Outer:Block_26_Outer:Block_29_Outer:
                                        while (true) {
                                            Block_21: {
                                                Block_18: {
                                                Block_31:
                                                    while (true) {
                                                        Block_17: {
                                                            break Block_17;
                                                            Label_0112:
                                                            iftrue(Label_0139:)(n2 != 1953329263);
                                                            break Block_18;
                                                            Block_32: {
                                                                while (true) {
                                                                    while (true) {
                                                                        while (true) {
                                                                            while (true) {
                                                                                h = h(n2, "TSOA", parsableByteArray);
                                                                                parsableByteArray.P(n);
                                                                                return h;
                                                                                h2 = h(n2, "TSOT", parsableByteArray);
                                                                                parsableByteArray.P(n);
                                                                                return h2;
                                                                                h3 = h(n2, "TSOP", parsableByteArray);
                                                                                parsableByteArray.P(n);
                                                                                return h3;
                                                                                while (true) {
                                                                                    i = i(n2, "ITUNESGAPLESS", parsableByteArray, false, true);
                                                                                    parsableByteArray.P(n);
                                                                                    return i;
                                                                                    n3 = (0xFFFFFF & n2);
                                                                                    iftrue(Label_0496:)(n3 != 6516084);
                                                                                    break Block_32;
                                                                                    j = i(n2, "ITUNESADVISORY", parsableByteArray, false, false);
                                                                                    parsableByteArray.P(n);
                                                                                    return j;
                                                                                    Label_0364:
                                                                                    iftrue(Label_0391:)(n2 != 1885823344);
                                                                                    continue Block_26_Outer;
                                                                                }
                                                                                h4 = h(n2, "TSOC", parsableByteArray);
                                                                                parsableByteArray.P(n);
                                                                                return h4;
                                                                                h5 = h(n2, "TVSHOWSORT", parsableByteArray);
                                                                                parsableByteArray.P(n);
                                                                                return h5;
                                                                                Label_0262:
                                                                                iftrue(Label_0287:)(n2 != 1936679282);
                                                                                continue Block_25_Outer;
                                                                            }
                                                                            b = b(parsableByteArray);
                                                                            parsableByteArray.P(n);
                                                                            return b;
                                                                            Label_0287:
                                                                            iftrue(Label_0312:)(n2 != 1936679265);
                                                                            continue Block_26_Outer;
                                                                        }
                                                                        Label_0166:
                                                                        iftrue(Label_0187:)(n2 != 1668249202);
                                                                        continue;
                                                                    }
                                                                    Label_0416:
                                                                    iftrue(Label_0441:)(n2 != 1953919848);
                                                                    break Block_30;
                                                                    Label_0139:
                                                                    iftrue(Label_0166:)(n2 != 1668311404);
                                                                    Block_19: {
                                                                        break Block_19;
                                                                        Label_0187:
                                                                        iftrue(Label_0212:)(n2 != 1631670868);
                                                                        break Block_21;
                                                                        Label_0441:
                                                                        iftrue(Label_0705:)(n2 != 757935405);
                                                                        break Block_31;
                                                                    }
                                                                    k = i(n2, "TCMP", parsableByteArray, true, true);
                                                                    parsableByteArray.P(n);
                                                                    return k;
                                                                    Label_0312:
                                                                    iftrue(Label_0337:)(n2 != 1936679791);
                                                                    continue Block_29_Outer;
                                                                }
                                                            }
                                                            a = a(n2, parsableByteArray);
                                                            parsableByteArray.P(n);
                                                            return a;
                                                        }
                                                        d = d(n2, "TRCK", parsableByteArray);
                                                        parsableByteArray.P(n);
                                                        return d;
                                                        Label_0391:
                                                        iftrue(Label_0416:)(n2 != 1936683886);
                                                        continue;
                                                    }
                                                    e = e(parsableByteArray, n);
                                                    parsableByteArray.P(n);
                                                    return e;
                                                }
                                                l = i(n2, "TBPM", parsableByteArray, true, false);
                                                parsableByteArray.P(n);
                                                return l;
                                                h6 = h(n2, "TSO2", parsableByteArray);
                                                parsableByteArray.P(n);
                                                return h6;
                                            }
                                            h7 = h(n2, "TPE2", parsableByteArray);
                                            parsableByteArray.P(n);
                                            return h7;
                                            Label_0212:
                                            iftrue(Label_0237:)(n2 != 1936682605);
                                            continue;
                                        }
                                        Label_0337:
                                        iftrue(Label_0364:)(n2 != 1920233063);
                                        continue;
                                    }
                                    Label_0237:
                                    iftrue(Label_0262:)(n2 != 1936679276);
                                    continue;
                                }
                            }
                            final TextInformationFrame h8 = h(n2, "TVSHOW", parsableByteArray);
                            parsableByteArray.P(n);
                            return h8;
                        }
                        final TextInformationFrame d2 = d(n2, "TPOS", parsableByteArray);
                        parsableByteArray.P(n);
                        return d2;
                    }
                    finally {
                        break Label_0788;
                    }
                }
            }
            Label_0496: {
                if (n3 == 7233901 || n3 == 7631467) {
                    final TextInformationFrame h9 = h(n2, "TIT2", parsableByteArray);
                    parsableByteArray.P(n);
                    return h9;
                }
            }
            if (n3 == 6516589 || n3 == 7828084) {
                final TextInformationFrame h10 = h(n2, "TCOM", parsableByteArray);
                parsableByteArray.P(n);
                return h10;
            }
            if (n3 == 6578553) {
                final TextInformationFrame h11 = h(n2, "TDRC", parsableByteArray);
                parsableByteArray.P(n);
                return h11;
            }
            if (n3 == 4280916) {
                final TextInformationFrame h12 = h(n2, "TPE1", parsableByteArray);
                parsableByteArray.P(n);
                return h12;
            }
            if (n3 == 7630703) {
                final TextInformationFrame h13 = h(n2, "TSSE", parsableByteArray);
                parsableByteArray.P(n);
                return h13;
            }
            if (n3 == 6384738) {
                final TextInformationFrame h14 = h(n2, "TALB", parsableByteArray);
                parsableByteArray.P(n);
                return h14;
            }
            if (n3 == 7108978) {
                final TextInformationFrame h15 = h(n2, "USLT", parsableByteArray);
                parsableByteArray.P(n);
                return h15;
            }
            if (n3 == 6776174) {
                final TextInformationFrame h16 = h(n2, "TCON", parsableByteArray);
                parsableByteArray.P(n);
                return h16;
            }
            if (n3 == 6779504) {
                final TextInformationFrame h17 = h(n2, "TIT1", parsableByteArray);
                parsableByteArray.P(n);
                return h17;
            }
            Label_0705:
            final StringBuilder sb = new StringBuilder();
            sb.append("Skipped unknown metadata entry: ");
            sb.append(com.google.android.exoplayer2.extractor.mp4.a.a(n2));
            Log.b("MetadataUtil", sb.toString());
            parsableByteArray.P(n);
            return null;
        }
        parsableByteArray.P(n);
    }
    
    private static TextInformationFrame d(int j, final String s, final ParsableByteArray parsableByteArray) {
        final int n = parsableByteArray.n();
        if (parsableByteArray.n() == 1684108385 && n >= 22) {
            parsableByteArray.Q(10);
            final int i = parsableByteArray.J();
            if (i > 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i);
                final String string = sb.toString();
                j = parsableByteArray.J();
                String string2 = string;
                if (j > 0) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append("/");
                    sb2.append(j);
                    string2 = sb2.toString();
                }
                return new TextInformationFrame(s, null, string2);
            }
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Failed to parse index/count attribute: ");
        sb3.append(com.google.android.exoplayer2.extractor.mp4.a.a(j));
        Log.i("MetadataUtil", sb3.toString());
        return null;
    }
    
    private static Id3Frame e(final ParsableByteArray parsableByteArray, final int n) {
        int n2 = -1;
        int n3 = -1;
        String y = null;
        String y2 = null;
        while (parsableByteArray.e() < n) {
            final int e = parsableByteArray.e();
            final int n4 = parsableByteArray.n();
            final int n5 = parsableByteArray.n();
            parsableByteArray.Q(4);
            if (n5 == 1835360622) {
                y = parsableByteArray.y(n4 - 12);
            }
            else if (n5 == 1851878757) {
                y2 = parsableByteArray.y(n4 - 12);
            }
            else {
                if (n5 == 1684108385) {
                    n2 = e;
                    n3 = n4;
                }
                parsableByteArray.Q(n4 - 12);
            }
        }
        if (y != null && y2 != null && n2 != -1) {
            parsableByteArray.P(n2);
            parsableByteArray.Q(16);
            return new InternalFrame(y, y2, parsableByteArray.y(n3 - 16));
        }
        return null;
    }
    
    public static MdtaMetadataEntry f(final ParsableByteArray parsableByteArray, int n, final String s) {
        while (true) {
            final int e = parsableByteArray.e();
            if (e >= n) {
                return null;
            }
            int n2 = parsableByteArray.n();
            if (parsableByteArray.n() == 1684108385) {
                n = parsableByteArray.n();
                final int n3 = parsableByteArray.n();
                n2 -= 16;
                final byte[] array = new byte[n2];
                parsableByteArray.j(array, 0, n2);
                return new MdtaMetadataEntry(s, array, n3, n);
            }
            parsableByteArray.P(e + n2);
        }
    }
    
    private static TextInformationFrame g(final ParsableByteArray parsableByteArray) {
        final int j = j(parsableByteArray);
        String s = null;
        Label_0030: {
            if (j > 0) {
                final String[] a = e.a;
                if (j <= a.length) {
                    s = a[j - 1];
                    break Label_0030;
                }
            }
            s = null;
        }
        if (s != null) {
            return new TextInformationFrame("TCON", null, s);
        }
        Log.i("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }
    
    private static TextInformationFrame h(final int n, final String s, final ParsableByteArray parsableByteArray) {
        final int n2 = parsableByteArray.n();
        if (parsableByteArray.n() == 1684108385) {
            parsableByteArray.Q(8);
            return new TextInformationFrame(s, null, parsableByteArray.y(n2 - 16));
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to parse text attribute: ");
        sb.append(com.google.android.exoplayer2.extractor.mp4.a.a(n));
        Log.i("MetadataUtil", sb.toString());
        return null;
    }
    
    private static Id3Frame i(final int n, final String s, final ParsableByteArray parsableByteArray, final boolean b, final boolean b2) {
        int n3;
        final int n2 = n3 = j(parsableByteArray);
        if (b2) {
            n3 = Math.min(1, n2);
        }
        if (n3 >= 0) {
            Id3Frame id3Frame;
            if (b) {
                id3Frame = new TextInformationFrame(s, null, Integer.toString(n3));
            }
            else {
                id3Frame = new CommentFrame("und", s, Integer.toString(n3));
            }
            return id3Frame;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to parse uint8 attribute: ");
        sb.append(com.google.android.exoplayer2.extractor.mp4.a.a(n));
        Log.i("MetadataUtil", sb.toString());
        return null;
    }
    
    private static int j(final ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(4);
        if (parsableByteArray.n() == 1684108385) {
            parsableByteArray.Q(8);
            return parsableByteArray.D();
        }
        Log.i("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
    
    public static void k(final int n, final GaplessInfoHolder gaplessInfoHolder, final Format.Builder builder) {
        if (n == 1 && gaplessInfoHolder.a()) {
            builder.N(gaplessInfoHolder.a).O(gaplessInfoHolder.b);
        }
    }
    
    public static void l(int i, Metadata b, final Metadata metadata, final Format.Builder builder, final Metadata... array) {
        final int n = 0;
        final Metadata metadata2 = new Metadata(new Metadata.Entry[0]);
        Label_0106: {
            if (i == 1) {
                if (b != null) {
                    break Label_0106;
                }
            }
            else if (i == 2 && metadata != null) {
                Metadata.Entry c;
                MdtaMetadataEntry mdtaMetadataEntry;
                for (i = 0; i < metadata.d(); ++i) {
                    c = metadata.c(i);
                    if (c instanceof MdtaMetadataEntry) {
                        mdtaMetadataEntry = (MdtaMetadataEntry)c;
                        if ("com.android.capture.fps".equals(mdtaMetadataEntry.a)) {
                            b = new Metadata(new Metadata.Entry[] { mdtaMetadataEntry });
                            break Label_0106;
                        }
                    }
                }
            }
            b = metadata2;
        }
        int length;
        for (length = array.length, i = n; i < length; ++i) {
            b = b.b(array[i]);
        }
        if (b.d() > 0) {
            builder.X(b);
        }
    }
}
