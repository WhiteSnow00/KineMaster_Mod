// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.MediaMetadata;
import java.util.ArrayList;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class TextInformationFrame extends Id3Frame
{
    public static final Parcelable$Creator<TextInformationFrame> CREATOR;
    public final String b;
    public final String c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<TextInformationFrame>() {
            public TextInformationFrame a(final Parcel parcel) {
                return new TextInformationFrame(parcel);
            }
            
            public TextInformationFrame[] b(final int n) {
                return new TextInformationFrame[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    TextInformationFrame(final Parcel parcel) {
        super(Util.j(parcel.readString()));
        this.b = parcel.readString();
        this.c = Util.j(parcel.readString());
    }
    
    public TextInformationFrame(final String s, final String b, final String c) {
        super(s);
        this.b = b;
        this.c = c;
    }
    
    private static List<Integer> a(final String s) {
        final ArrayList list = new ArrayList();
        try {
            if (s.length() >= 10) {
                list.add(Integer.parseInt(s.substring(0, 4)));
                list.add(Integer.parseInt(s.substring(5, 7)));
                list.add(Integer.parseInt(s.substring(8, 10)));
            }
            else if (s.length() >= 7) {
                list.add(Integer.parseInt(s.substring(0, 4)));
                list.add(Integer.parseInt(s.substring(5, 7)));
            }
            else if (s.length() >= 4) {
                list.add(Integer.parseInt(s.substring(0, 4)));
            }
            return list;
        }
        catch (final NumberFormatException ex) {
            return new ArrayList<Integer>();
        }
    }
    
    @Override
    public void B0(final MediaMetadata.Builder builder) {
        final String a = super.a;
        a.hashCode();
        final int hashCode = a.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2590194: {
                if (!a.equals("TYER")) {
                    break;
                }
                n = 21;
                break;
            }
            case 2583398: {
                if (!a.equals("TRCK")) {
                    break;
                }
                n = 20;
                break;
            }
            case 2581514: {
                if (!a.equals("TPE3")) {
                    break;
                }
                n = 19;
                break;
            }
            case 2581513: {
                if (!a.equals("TPE2")) {
                    break;
                }
                n = 18;
                break;
            }
            case 2581512: {
                if (!a.equals("TPE1")) {
                    break;
                }
                n = 17;
                break;
            }
            case 2575251: {
                if (!a.equals("TIT2")) {
                    break;
                }
                n = 16;
                break;
            }
            case 2571565: {
                if (!a.equals("TEXT")) {
                    break;
                }
                n = 15;
                break;
            }
            case 2570410: {
                if (!a.equals("TDRL")) {
                    break;
                }
                n = 14;
                break;
            }
            case 2570401: {
                if (!a.equals("TDRC")) {
                    break;
                }
                n = 13;
                break;
            }
            case 2569891: {
                if (!a.equals("TDAT")) {
                    break;
                }
                n = 12;
                break;
            }
            case 2569357: {
                if (!a.equals("TCOM")) {
                    break;
                }
                n = 11;
                break;
            }
            case 2567331: {
                if (!a.equals("TALB")) {
                    break;
                }
                n = 10;
                break;
            }
            case 83552: {
                if (!a.equals("TYE")) {
                    break;
                }
                n = 9;
                break;
            }
            case 83536: {
                if (!a.equals("TXT")) {
                    break;
                }
                n = 8;
                break;
            }
            case 83378: {
                if (!a.equals("TT2")) {
                    break;
                }
                n = 7;
                break;
            }
            case 83341: {
                if (!a.equals("TRK")) {
                    break;
                }
                n = 6;
                break;
            }
            case 83255: {
                if (!a.equals("TP3")) {
                    break;
                }
                n = 5;
                break;
            }
            case 83254: {
                if (!a.equals("TP2")) {
                    break;
                }
                n = 4;
                break;
            }
            case 83253: {
                if (!a.equals("TP1")) {
                    break;
                }
                n = 3;
                break;
            }
            case 82897: {
                if (!a.equals("TDA")) {
                    break;
                }
                n = 2;
                break;
            }
            case 82878: {
                if (!a.equals("TCM")) {
                    break;
                }
                n = 1;
                break;
            }
            case 82815: {
                if (!a.equals("TAL")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        Label_1083: {
            switch (n) {
                default: {
                    return;
                }
                case 14: {
                    final List<Integer> a2 = a(this.c);
                    final int size = a2.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size != 3) {
                                return;
                            }
                            builder.d0((Integer)a2.get(2));
                        }
                        builder.e0((Integer)a2.get(1));
                    }
                    builder.f0((Integer)a2.get(0));
                    return;
                }
                case 13: {
                    final List<Integer> a3 = a(this.c);
                    final int size2 = a3.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 != 3) {
                                return;
                            }
                            builder.a0((Integer)a3.get(2));
                        }
                        builder.b0((Integer)a3.get(1));
                    }
                    builder.c0((Integer)a3.get(0));
                    return;
                }
                case 9:
                case 21: {
                    break Label_1083;
                }
                case 8:
                case 15: {
                    break Label_1083;
                }
                case 7:
                case 16: {
                    break Label_1083;
                }
                case 6:
                case 20: {
                    break Label_1083;
                }
                case 5:
                case 19: {
                    break Label_1083;
                }
                case 4:
                case 18: {
                    break Label_1083;
                }
                case 3:
                case 17: {
                    break Label_1083;
                }
                case 2:
                case 12: {
                    break Label_1083;
                }
                case 1:
                case 11: {
                    break Label_1083;
                }
                case 0:
                case 10: {
                    Label_1095: {
                        break Label_1095;
                        try {
                            builder.c0(Integer.parseInt(this.c));
                            return;
                            while (true) {
                                while (true) {
                                    final int int1;
                                    Integer value = null;
                                    builder.l0(int1).k0(value);
                                    return;
                                    builder.K(this.c);
                                    return;
                                    builder.b0(Integer.parseInt(this.c.substring(2, 4))).a0(Integer.parseInt(this.c.substring(0, 2)));
                                    return;
                                    builder.n0(this.c);
                                    return;
                                    Label_0982: {
                                        value = null;
                                    }
                                    continue;
                                    builder.M(this.c);
                                    return;
                                    builder.R(this.c);
                                    return;
                                    final String[] t0;
                                    value = Integer.parseInt(t0[1]);
                                    continue;
                                }
                                builder.L(this.c);
                                return;
                                final String[] t0 = Util.T0(this.c, "/");
                                final int int1 = Integer.parseInt(t0[0]);
                                iftrue(Label_0982:)(t0.length <= 1);
                                continue;
                            }
                            builder.Q(this.c);
                            return;
                            builder.i0(this.c);
                            return;
                        }
                        catch (final NumberFormatException | StringIndexOutOfBoundsException ex) {
                            return;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && TextInformationFrame.class == o.getClass()) {
            final TextInformationFrame textInformationFrame = (TextInformationFrame)o;
            if (!Util.c(super.a, textInformationFrame.a) || !Util.c(this.b, textInformationFrame.b) || !Util.c(this.c, textInformationFrame.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = super.a.hashCode();
        final String b = this.b;
        int hashCode2 = 0;
        int hashCode3;
        if (b != null) {
            hashCode3 = b.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String c = this.c;
        if (c != null) {
            hashCode2 = c.hashCode();
        }
        return ((527 + hashCode) * 31 + hashCode3) * 31 + hashCode2;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.a);
        sb.append(": description=");
        sb.append(this.b);
        sb.append(": value=");
        sb.append(this.c);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(super.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
