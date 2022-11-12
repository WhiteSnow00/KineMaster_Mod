// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import android.os.Message;
import android.os.Handler$Callback;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.TraceUtil;
import android.media.MediaCrypto;
import com.google.android.exoplayer2.ExoPlaybackException;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.Collection;
import com.google.common.collect.ImmutableList;
import java.util.List;
import android.graphics.Point;
import android.util.Pair;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.util.Util;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import android.view.Surface;
import android.content.Context;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;

public class MediaCodecVideoRenderer extends MediaCodecRenderer
{
    private static final int[] A1;
    private static boolean B1;
    private static boolean C1;
    private final Context R0;
    private final VideoFrameReleaseHelper S0;
    private final VideoRendererEventListener.EventDispatcher T0;
    private final long U0;
    private final int V0;
    private final boolean W0;
    private CodecMaxValues X0;
    private boolean Y0;
    private boolean Z0;
    private Surface a1;
    private PlaceholderSurface b1;
    private boolean c1;
    private int d1;
    private boolean e1;
    private boolean f1;
    private boolean g1;
    private long h1;
    private long i1;
    private long j1;
    private int k1;
    private int l1;
    private int m1;
    private long n1;
    private long o1;
    private long p1;
    private int q1;
    private int r1;
    private int s1;
    private int t1;
    private float u1;
    private VideoSize v1;
    private boolean w1;
    private int x1;
    a y1;
    private VideoFrameMetadataListener z1;
    
    static {
        A1 = new int[] { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
    }
    
    public MediaCodecVideoRenderer(final Context context, final MediaCodecAdapter.Factory factory, final MediaCodecSelector mediaCodecSelector, final long n, final boolean b, final Handler handler, final VideoRendererEventListener videoRendererEventListener, final int n2) {
        this(context, factory, mediaCodecSelector, n, b, handler, videoRendererEventListener, n2, 30.0f);
    }
    
    public MediaCodecVideoRenderer(Context applicationContext, final MediaCodecAdapter.Factory factory, final MediaCodecSelector mediaCodecSelector, final long u0, final boolean b, final Handler handler, final VideoRendererEventListener videoRendererEventListener, final int v0, final float n) {
        super(2, factory, mediaCodecSelector, b, n);
        this.U0 = u0;
        this.V0 = v0;
        applicationContext = applicationContext.getApplicationContext();
        this.R0 = applicationContext;
        this.S0 = new VideoFrameReleaseHelper(applicationContext);
        this.T0 = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.W0 = B1();
        this.i1 = -9223372036854775807L;
        this.r1 = -1;
        this.s1 = -1;
        this.u1 = -1.0f;
        this.d1 = 1;
        this.x1 = 0;
        this.y1();
    }
    
    private static void A1(final MediaFormat mediaFormat, final int n) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", n);
    }
    
    private static boolean B1() {
        return "NVIDIA".equals(Util.c);
    }
    
    private static boolean D1() {
        final int a = Util.a;
        final int n = 7;
        final int n2 = 2;
        if (a <= 28) {
            final String b = Util.b;
            b.hashCode();
            int n3 = 0;
            Label_0252: {
                switch (b) {
                    case "machuca": {
                        n3 = 7;
                        break Label_0252;
                    }
                    case "once": {
                        n3 = 6;
                        break Label_0252;
                    }
                    case "magnolia": {
                        n3 = 5;
                        break Label_0252;
                    }
                    case "aquaman": {
                        n3 = 4;
                        break Label_0252;
                    }
                    case "oneday": {
                        n3 = 3;
                        break Label_0252;
                    }
                    case "dangalUHD": {
                        n3 = 2;
                        break Label_0252;
                    }
                    case "dangalFHD": {
                        n3 = 1;
                        break Label_0252;
                    }
                    case "dangal": {
                        n3 = 0;
                        break Label_0252;
                    }
                    default:
                        break;
                }
                n3 = -1;
            }
            switch (n3) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7: {
                    return true;
                }
            }
        }
        if (a <= 27 && "HWEML".equals(Util.b)) {
            return true;
        }
        Label_4961: {
            if (a <= 26) {
                final String b2 = Util.b;
                b2.hashCode();
                int n4 = 0;
                Label_4243: {
                    switch (b2.hashCode()) {
                        case 2048855701: {
                            if (!b2.equals("HWWAS-H")) {
                                break;
                            }
                            n4 = 139;
                            break Label_4243;
                        }
                        case 2048319463: {
                            if (!b2.equals("HWVNS-H")) {
                                break;
                            }
                            n4 = 138;
                            break Label_4243;
                        }
                        case 2047252157: {
                            if (!b2.equals("ELUGA_Prim")) {
                                break;
                            }
                            n4 = 137;
                            break Label_4243;
                        }
                        case 2047190025: {
                            if (!b2.equals("ELUGA_Note")) {
                                break;
                            }
                            n4 = 136;
                            break Label_4243;
                        }
                        case 2033393791: {
                            if (!b2.equals("ASUS_X00AD_2")) {
                                break;
                            }
                            n4 = 135;
                            break Label_4243;
                        }
                        case 2030379515: {
                            if (!b2.equals("HWCAM-H")) {
                                break;
                            }
                            n4 = 134;
                            break Label_4243;
                        }
                        case 2029784656: {
                            if (!b2.equals("HWBLN-H")) {
                                break;
                            }
                            n4 = 133;
                            break Label_4243;
                        }
                        case 2019281702: {
                            if (!b2.equals("DM-01K")) {
                                break;
                            }
                            n4 = 132;
                            break Label_4243;
                        }
                        case 2006372676: {
                            if (!b2.equals("BRAVIA_ATV3_4K")) {
                                break;
                            }
                            n4 = 131;
                            break Label_4243;
                        }
                        case 1977196784: {
                            if (!b2.equals("Infinix-X572")) {
                                break;
                            }
                            n4 = 130;
                            break Label_4243;
                        }
                        case 1906253259: {
                            if (!b2.equals("PB2-670M")) {
                                break;
                            }
                            n4 = 129;
                            break Label_4243;
                        }
                        case 1865889110: {
                            if (!b2.equals("santoni")) {
                                break;
                            }
                            n4 = 128;
                            break Label_4243;
                        }
                        case 1709443163: {
                            if (!b2.equals("iball8735_9806")) {
                                break;
                            }
                            n4 = 127;
                            break Label_4243;
                        }
                        case 1691544261: {
                            if (!b2.equals("CPH1715")) {
                                break;
                            }
                            n4 = 126;
                            break Label_4243;
                        }
                        case 1691543273: {
                            if (!b2.equals("CPH1609")) {
                                break;
                            }
                            n4 = 125;
                            break Label_4243;
                        }
                        case 1522194893: {
                            if (!b2.equals("woods_f")) {
                                break;
                            }
                            n4 = 124;
                            break Label_4243;
                        }
                        case 1349174697: {
                            if (!b2.equals("htc_e56ml_dtul")) {
                                break;
                            }
                            n4 = 123;
                            break Label_4243;
                        }
                        case 1306947716: {
                            if (!b2.equals("EverStar_S")) {
                                break;
                            }
                            n4 = 122;
                            break Label_4243;
                        }
                        case 1280332038: {
                            if (!b2.equals("hwALE-H")) {
                                break;
                            }
                            n4 = 121;
                            break Label_4243;
                        }
                        case 1176899427: {
                            if (!b2.equals("itel_S41")) {
                                break;
                            }
                            n4 = 120;
                            break Label_4243;
                        }
                        case 1150207623: {
                            if (!b2.equals("LS-5017")) {
                                break;
                            }
                            n4 = 119;
                            break Label_4243;
                        }
                        case 1060579533: {
                            if (!b2.equals("panell_d")) {
                                break;
                            }
                            n4 = 118;
                            break Label_4243;
                        }
                        case 958008161: {
                            if (!b2.equals("j2xlteins")) {
                                break;
                            }
                            n4 = 117;
                            break Label_4243;
                        }
                        case 917340916: {
                            if (!b2.equals("A7000plus")) {
                                break;
                            }
                            n4 = 116;
                            break Label_4243;
                        }
                        case 835649806: {
                            if (!b2.equals("manning")) {
                                break;
                            }
                            n4 = 115;
                            break Label_4243;
                        }
                        case 794040393: {
                            if (!b2.equals("GIONEE_WBL7519")) {
                                break;
                            }
                            n4 = 114;
                            break Label_4243;
                        }
                        case 794038622: {
                            if (!b2.equals("GIONEE_WBL7365")) {
                                break;
                            }
                            n4 = 113;
                            break Label_4243;
                        }
                        case 793982701: {
                            if (!b2.equals("GIONEE_WBL5708")) {
                                break;
                            }
                            n4 = 112;
                            break Label_4243;
                        }
                        case 507412548: {
                            if (!b2.equals("QM16XE_U")) {
                                break;
                            }
                            n4 = 111;
                            break Label_4243;
                        }
                        case 407160593: {
                            if (!b2.equals("Pixi5-10_4G")) {
                                break;
                            }
                            n4 = 110;
                            break Label_4243;
                        }
                        case 316246818: {
                            if (!b2.equals("TB3-850M")) {
                                break;
                            }
                            n4 = 109;
                            break Label_4243;
                        }
                        case 316246811: {
                            if (!b2.equals("TB3-850F")) {
                                break;
                            }
                            n4 = 108;
                            break Label_4243;
                        }
                        case 316215116: {
                            if (!b2.equals("TB3-730X")) {
                                break;
                            }
                            n4 = 107;
                            break Label_4243;
                        }
                        case 316215098: {
                            if (!b2.equals("TB3-730F")) {
                                break;
                            }
                            n4 = 106;
                            break Label_4243;
                        }
                        case 308517133: {
                            if (!b2.equals("A7020a48")) {
                                break;
                            }
                            n4 = 105;
                            break Label_4243;
                        }
                        case 307593612: {
                            if (!b2.equals("A7010a48")) {
                                break;
                            }
                            n4 = 104;
                            break Label_4243;
                        }
                        case 287431619: {
                            if (!b2.equals("griffin")) {
                                break;
                            }
                            n4 = 103;
                            break Label_4243;
                        }
                        case 245388979: {
                            if (!b2.equals("marino_f")) {
                                break;
                            }
                            n4 = 102;
                            break Label_4243;
                        }
                        case 182191441: {
                            if (!b2.equals("CPY83_I00")) {
                                break;
                            }
                            n4 = 101;
                            break Label_4243;
                        }
                        case 165221241: {
                            if (!b2.equals("A2016a40")) {
                                break;
                            }
                            n4 = 100;
                            break Label_4243;
                        }
                        case 102844228: {
                            if (!b2.equals("le_x6")) {
                                break;
                            }
                            n4 = 99;
                            break Label_4243;
                        }
                        case 101370885: {
                            if (!b2.equals("l5460")) {
                                break;
                            }
                            n4 = 98;
                            break Label_4243;
                        }
                        case 98715550: {
                            if (!b2.equals("i9031")) {
                                break;
                            }
                            n4 = 97;
                            break Label_4243;
                        }
                        case 82882791: {
                            if (!b2.equals("X3_HK")) {
                                break;
                            }
                            n4 = 96;
                            break Label_4243;
                        }
                        case 80963634: {
                            if (!b2.equals("V23GB")) {
                                break;
                            }
                            n4 = 95;
                            break Label_4243;
                        }
                        case 76404911: {
                            if (!b2.equals("Q4310")) {
                                break;
                            }
                            n4 = 94;
                            break Label_4243;
                        }
                        case 76404105: {
                            if (!b2.equals("Q4260")) {
                                break;
                            }
                            n4 = 93;
                            break Label_4243;
                        }
                        case 76402249: {
                            if (!b2.equals("PRO7S")) {
                                break;
                            }
                            n4 = 92;
                            break Label_4243;
                        }
                        case 66216390: {
                            if (!b2.equals("F3311")) {
                                break;
                            }
                            n4 = 91;
                            break Label_4243;
                        }
                        case 66215433: {
                            if (!b2.equals("F3215")) {
                                break;
                            }
                            n4 = 90;
                            break Label_4243;
                        }
                        case 66215431: {
                            if (!b2.equals("F3213")) {
                                break;
                            }
                            n4 = 89;
                            break Label_4243;
                        }
                        case 66215429: {
                            if (!b2.equals("F3211")) {
                                break;
                            }
                            n4 = 88;
                            break Label_4243;
                        }
                        case 66214473: {
                            if (!b2.equals("F3116")) {
                                break;
                            }
                            n4 = 87;
                            break Label_4243;
                        }
                        case 66214470: {
                            if (!b2.equals("F3113")) {
                                break;
                            }
                            n4 = 86;
                            break Label_4243;
                        }
                        case 66214468: {
                            if (!b2.equals("F3111")) {
                                break;
                            }
                            n4 = 85;
                            break Label_4243;
                        }
                        case 65355429: {
                            if (!b2.equals("E5643")) {
                                break;
                            }
                            n4 = 84;
                            break Label_4243;
                        }
                        case 61542055: {
                            if (!b2.equals("A1601")) {
                                break;
                            }
                            n4 = 83;
                            break Label_4243;
                        }
                        case 55178625: {
                            if (!b2.equals("Aura_Note_2")) {
                                break;
                            }
                            n4 = 82;
                            break Label_4243;
                        }
                        case 51350594: {
                            if (!b2.equals("602LV")) {
                                break;
                            }
                            n4 = 81;
                            break Label_4243;
                        }
                        case 51349633: {
                            if (!b2.equals("601LV")) {
                                break;
                            }
                            n4 = 80;
                            break Label_4243;
                        }
                        case 41325051: {
                            if (!b2.equals("MEIZU_M5")) {
                                break;
                            }
                            n4 = 79;
                            break Label_4243;
                        }
                        case 3386211: {
                            if (!b2.equals("p212")) {
                                break;
                            }
                            n4 = 78;
                            break Label_4243;
                        }
                        case 3351335: {
                            if (!b2.equals("mido")) {
                                break;
                            }
                            n4 = 77;
                            break Label_4243;
                        }
                        case 3284551: {
                            if (!b2.equals("kate")) {
                                break;
                            }
                            n4 = 76;
                            break Label_4243;
                        }
                        case 3154429: {
                            if (!b2.equals("fugu")) {
                                break;
                            }
                            n4 = 75;
                            break Label_4243;
                        }
                        case 2689555: {
                            if (!b2.equals("XE2X")) {
                                break;
                            }
                            n4 = 74;
                            break Label_4243;
                        }
                        case 2464648: {
                            if (!b2.equals("Q427")) {
                                break;
                            }
                            n4 = 73;
                            break Label_4243;
                        }
                        case 2463773: {
                            if (!b2.equals("Q350")) {
                                break;
                            }
                            n4 = 72;
                            break Label_4243;
                        }
                        case 2436959: {
                            if (!b2.equals("P681")) {
                                break;
                            }
                            n4 = 71;
                            break Label_4243;
                        }
                        case 2133184: {
                            if (!b2.equals("F04J")) {
                                break;
                            }
                            n4 = 70;
                            break Label_4243;
                        }
                        case 2133182: {
                            if (!b2.equals("F04H")) {
                                break;
                            }
                            n4 = 69;
                            break Label_4243;
                        }
                        case 2133151: {
                            if (!b2.equals("F03H")) {
                                break;
                            }
                            n4 = 68;
                            break Label_4243;
                        }
                        case 2133120: {
                            if (!b2.equals("F02H")) {
                                break;
                            }
                            n4 = 67;
                            break Label_4243;
                        }
                        case 2133091: {
                            if (!b2.equals("F01J")) {
                                break;
                            }
                            n4 = 66;
                            break Label_4243;
                        }
                        case 2133089: {
                            if (!b2.equals("F01H")) {
                                break;
                            }
                            n4 = 65;
                            break Label_4243;
                        }
                        case 1514185: {
                            if (!b2.equals("1714")) {
                                break;
                            }
                            n4 = 64;
                            break Label_4243;
                        }
                        case 1514184: {
                            if (!b2.equals("1713")) {
                                break;
                            }
                            n4 = 63;
                            break Label_4243;
                        }
                        case 1513190: {
                            if (!b2.equals("1601")) {
                                break;
                            }
                            n4 = 62;
                            break Label_4243;
                        }
                        case 101481: {
                            if (!b2.equals("flo")) {
                                break;
                            }
                            n4 = 61;
                            break Label_4243;
                        }
                        case 99329: {
                            if (!b2.equals("deb")) {
                                break;
                            }
                            n4 = 60;
                            break Label_4243;
                        }
                        case 98848: {
                            if (!b2.equals("cv3")) {
                                break;
                            }
                            n4 = 59;
                            break Label_4243;
                        }
                        case 98846: {
                            if (!b2.equals("cv1")) {
                                break;
                            }
                            n4 = 58;
                            break Label_4243;
                        }
                        case 88274: {
                            if (!b2.equals("Z80")) {
                                break;
                            }
                            n4 = 57;
                            break Label_4243;
                        }
                        case 80618: {
                            if (!b2.equals("QX1")) {
                                break;
                            }
                            n4 = 56;
                            break Label_4243;
                        }
                        case 79305: {
                            if (!b2.equals("PLE")) {
                                break;
                            }
                            n4 = 55;
                            break Label_4243;
                        }
                        case 78669: {
                            if (!b2.equals("P85")) {
                                break;
                            }
                            n4 = 54;
                            break Label_4243;
                        }
                        case 76779: {
                            if (!b2.equals("MX6")) {
                                break;
                            }
                            n4 = 53;
                            break Label_4243;
                        }
                        case 75739: {
                            if (!b2.equals("M5c")) {
                                break;
                            }
                            n4 = 52;
                            break Label_4243;
                        }
                        case 75537: {
                            if (!b2.equals("M04")) {
                                break;
                            }
                            n4 = 51;
                            break Label_4243;
                        }
                        case 73405: {
                            if (!b2.equals("JGZ")) {
                                break;
                            }
                            n4 = 50;
                            break Label_4243;
                        }
                        case 3483: {
                            if (!b2.equals("mh")) {
                                break;
                            }
                            n4 = 49;
                            break Label_4243;
                        }
                        case 3091: {
                            if (!b2.equals("b5")) {
                                break;
                            }
                            n4 = 48;
                            break Label_4243;
                        }
                        case 2719: {
                            if (!b2.equals("V5")) {
                                break;
                            }
                            n4 = 47;
                            break Label_4243;
                        }
                        case 2715: {
                            if (!b2.equals("V1")) {
                                break;
                            }
                            n4 = 46;
                            break Label_4243;
                        }
                        case 2564: {
                            if (!b2.equals("Q5")) {
                                break;
                            }
                            n4 = 45;
                            break Label_4243;
                        }
                        case 2126: {
                            if (!b2.equals("C1")) {
                                break;
                            }
                            n4 = 44;
                            break Label_4243;
                        }
                        case -56598463: {
                            if (!b2.equals("woods_fn")) {
                                break;
                            }
                            n4 = 43;
                            break Label_4243;
                        }
                        case -173639913: {
                            if (!b2.equals("ELUGA_A3_Pro")) {
                                break;
                            }
                            n4 = 42;
                            break Label_4243;
                        }
                        case -277133239: {
                            if (!b2.equals("Z12_PRO")) {
                                break;
                            }
                            n4 = 41;
                            break Label_4243;
                        }
                        case -282781963: {
                            if (!b2.equals("BLACK-1X")) {
                                break;
                            }
                            n4 = 40;
                            break Label_4243;
                        }
                        case -290434366: {
                            if (!b2.equals("taido_row")) {
                                break;
                            }
                            n4 = 39;
                            break Label_4243;
                        }
                        case -430914369: {
                            if (!b2.equals("Pixi4-7_3G")) {
                                break;
                            }
                            n4 = 38;
                            break Label_4243;
                        }
                        case -521118391: {
                            if (!b2.equals("GIONEE_GBL7360")) {
                                break;
                            }
                            n4 = 37;
                            break Label_4243;
                        }
                        case -575125681: {
                            if (!b2.equals("GiONEE_CBL7513")) {
                                break;
                            }
                            n4 = 36;
                            break Label_4243;
                        }
                        case -782144577: {
                            if (!b2.equals("OnePlus5T")) {
                                break;
                            }
                            n4 = 35;
                            break Label_4243;
                        }
                        case -788334647: {
                            if (!b2.equals("whyred")) {
                                break;
                            }
                            n4 = 34;
                            break Label_4243;
                        }
                        case -794946968: {
                            if (!b2.equals("watson")) {
                                break;
                            }
                            n4 = 33;
                            break Label_4243;
                        }
                        case -797483286: {
                            if (!b2.equals("SVP-DTV15")) {
                                break;
                            }
                            n4 = 32;
                            break Label_4243;
                        }
                        case -821392978: {
                            if (!b2.equals("A7000-a")) {
                                break;
                            }
                            n4 = 31;
                            break Label_4243;
                        }
                        case -842500323: {
                            if (!b2.equals("nicklaus_f")) {
                                break;
                            }
                            n4 = 30;
                            break Label_4243;
                        }
                        case -879245230: {
                            if (!b2.equals("tcl_eu")) {
                                break;
                            }
                            n4 = 29;
                            break Label_4243;
                        }
                        case -958336948: {
                            if (!b2.equals("ELUGA_Ray_X")) {
                                break;
                            }
                            n4 = 28;
                            break Label_4243;
                        }
                        case -965403638: {
                            if (!b2.equals("s905x018")) {
                                break;
                            }
                            n4 = 27;
                            break Label_4243;
                        }
                        case -993250458: {
                            if (!b2.equals("A10-70L")) {
                                break;
                            }
                            n4 = 26;
                            break Label_4243;
                        }
                        case -993250464: {
                            if (!b2.equals("A10-70F")) {
                                break;
                            }
                            n4 = 25;
                            break Label_4243;
                        }
                        case -1052835013: {
                            if (!b2.equals("namath")) {
                                break;
                            }
                            n4 = 24;
                            break Label_4243;
                        }
                        case -1139198265: {
                            if (!b2.equals("Slate_Pro")) {
                                break;
                            }
                            n4 = 23;
                            break Label_4243;
                        }
                        case -1180384755: {
                            if (!b2.equals("iris60")) {
                                break;
                            }
                            n4 = 22;
                            break Label_4243;
                        }
                        case -1217592143: {
                            if (!b2.equals("BRAVIA_ATV2")) {
                                break;
                            }
                            n4 = 21;
                            break Label_4243;
                        }
                        case -1320080169: {
                            if (!b2.equals("GiONEE_GBL7319")) {
                                break;
                            }
                            n4 = 20;
                            break Label_4243;
                        }
                        case -1481772729: {
                            if (!b2.equals("panell_dt")) {
                                break;
                            }
                            n4 = 19;
                            break Label_4243;
                        }
                        case -1481772730: {
                            if (!b2.equals("panell_ds")) {
                                break;
                            }
                            n4 = 18;
                            break Label_4243;
                        }
                        case -1481772737: {
                            if (!b2.equals("panell_dl")) {
                                break;
                            }
                            n4 = 17;
                            break Label_4243;
                        }
                        case -1554255044: {
                            if (!b2.equals("vernee_M5")) {
                                break;
                            }
                            n4 = 16;
                            break Label_4243;
                        }
                        case -1600724499: {
                            if (!b2.equals("pacificrim")) {
                                break;
                            }
                            n4 = 15;
                            break Label_4243;
                        }
                        case -1615810839: {
                            if (!b2.equals("Phantom6")) {
                                break;
                            }
                            n4 = 14;
                            break Label_4243;
                        }
                        case -1680025915: {
                            if (!b2.equals("ComioS1")) {
                                break;
                            }
                            n4 = 13;
                            break Label_4243;
                        }
                        case -1696512866: {
                            if (!b2.equals("XT1663")) {
                                break;
                            }
                            n4 = 12;
                            break Label_4243;
                        }
                        case -1885099851: {
                            if (!b2.equals("RAIJIN")) {
                                break;
                            }
                            n4 = 11;
                            break Label_4243;
                        }
                        case -1931988508: {
                            if (!b2.equals("AquaPowerM")) {
                                break;
                            }
                            n4 = 10;
                            break Label_4243;
                        }
                        case -1936688065: {
                            if (!b2.equals("PGN611")) {
                                break;
                            }
                            n4 = 9;
                            break Label_4243;
                        }
                        case -1936688066: {
                            if (!b2.equals("PGN610")) {
                                break;
                            }
                            n4 = 8;
                            break Label_4243;
                        }
                        case -1936688988: {
                            n4 = n;
                            if (!b2.equals("PGN528")) {
                                break;
                            }
                            break Label_4243;
                        }
                        case -1978990237: {
                            if (!b2.equals("NX573J")) {
                                break;
                            }
                            n4 = 6;
                            break Label_4243;
                        }
                        case -1978993182: {
                            if (!b2.equals("NX541J")) {
                                break;
                            }
                            n4 = 5;
                            break Label_4243;
                        }
                        case -2022874474: {
                            if (!b2.equals("CP8676_I02")) {
                                break;
                            }
                            n4 = 4;
                            break Label_4243;
                        }
                        case -2097309513: {
                            if (!b2.equals("K50a40")) {
                                break;
                            }
                            n4 = 3;
                            break Label_4243;
                        }
                        case -2144781160: {
                            if (!b2.equals("GIONEE_SWW1631")) {
                                break;
                            }
                            n4 = 2;
                            break Label_4243;
                        }
                        case -2144781185: {
                            if (!b2.equals("GIONEE_SWW1627")) {
                                break;
                            }
                            n4 = 1;
                            break Label_4243;
                        }
                        case -2144781245: {
                            if (!b2.equals("GIONEE_SWW1609")) {
                                break;
                            }
                            n4 = 0;
                            break Label_4243;
                        }
                    }
                    n4 = -1;
                }
                switch (n4) {
                    default: {
                        final String d = Util.d;
                        d.hashCode();
                        int n5 = 0;
                        Label_4928: {
                            switch (d.hashCode()) {
                                case 2006367: {
                                    n5 = n2;
                                    if (!d.equals("AFTN")) {
                                        break;
                                    }
                                    break Label_4928;
                                }
                                case 2006354: {
                                    if (!d.equals("AFTA")) {
                                        break;
                                    }
                                    n5 = 1;
                                    break Label_4928;
                                }
                                case -594534941: {
                                    if (!d.equals("JSN-L21")) {
                                        break;
                                    }
                                    n5 = 0;
                                    break Label_4928;
                                }
                            }
                            n5 = -1;
                        }
                        switch (n5) {
                            default: {
                                break Label_4961;
                            }
                            case 0:
                            case 1:
                            case 2: {
                                return true;
                            }
                        }
                        break;
                    }
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                    case 136:
                    case 137:
                    case 138:
                    case 139: {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static int E1(final MediaCodecInfo mediaCodecInfo, final Format format) {
        final int b = format.B;
        final int c = format.C;
        if (b != -1 && c != -1) {
            String w = format.w;
            final boolean equals = "video/dolby-vision".equals(w);
            int n = 1;
            Label_0100: {
                if (equals) {
                    final Pair<Integer, Integer> q = MediaCodecUtil.q(format);
                    if (q != null) {
                        final int intValue = (int)q.first;
                        if (intValue == 512 || intValue == 1 || intValue == 2) {
                            w = "video/avc";
                            break Label_0100;
                        }
                    }
                    w = "video/hevc";
                }
            }
            w.hashCode();
            final int hashCode = w.hashCode();
            final int n2 = 4;
            Label_0315: {
                switch (hashCode) {
                    case 1599127257: {
                        if (!w.equals("video/x-vnd.on2.vp9")) {
                            break;
                        }
                        n = 6;
                        break Label_0315;
                    }
                    case 1599127256: {
                        if (!w.equals("video/x-vnd.on2.vp8")) {
                            break;
                        }
                        n = 5;
                        break Label_0315;
                    }
                    case 1331836730: {
                        if (!w.equals("video/avc")) {
                            break;
                        }
                        n = 4;
                        break Label_0315;
                    }
                    case 1187890754: {
                        if (!w.equals("video/mp4v-es")) {
                            break;
                        }
                        n = 3;
                        break Label_0315;
                    }
                    case -1662541442: {
                        if (!w.equals("video/hevc")) {
                            break;
                        }
                        n = 2;
                        break Label_0315;
                    }
                    case -1662735862: {
                        if (!w.equals("video/av01")) {
                            break;
                        }
                        break Label_0315;
                    }
                    case -1664118616: {
                        if (!w.equals("video/3gpp")) {
                            break;
                        }
                        n = 0;
                        break Label_0315;
                    }
                }
                n = -1;
            }
            int n3 = 0;
            switch (n) {
                default: {
                    return -1;
                }
                case 4: {
                    final String d = Util.d;
                    if (!"BRAVIA 4K 2015".equals(d)) {
                        if ("Amazon".equals(Util.c)) {
                            if ("KFSOWI".equals(d)) {
                                return -1;
                            }
                            if ("AFTS".equals(d) && mediaCodecInfo.g) {
                                return -1;
                            }
                        }
                        n3 = Util.l(b, 16) * Util.l(c, 16) * 16 * 16;
                        break;
                    }
                    return -1;
                }
                case 2:
                case 6: {
                    final int n4 = b * c;
                    final int n5 = n2;
                    final int n6 = n4;
                    return n6 * 3 / (n5 * 2);
                }
                case 0:
                case 1:
                case 3:
                case 5: {
                    n3 = b * c;
                    break;
                }
            }
            final int n7 = 2;
            final int n6 = n3;
            final int n5 = n7;
            return n6 * 3 / (n5 * 2);
        }
        return -1;
    }
    
    private static Point F1(final MediaCodecInfo mediaCodecInfo, final Format format) {
        int c = format.C;
        final int b = format.B;
        final int n = 0;
        final boolean b2 = c > b;
        int n2;
        if (b2) {
            n2 = c;
        }
        else {
            n2 = b;
        }
        if (b2) {
            c = b;
        }
        final float n3 = c / (float)n2;
        final int[] a1 = MediaCodecVideoRenderer.A1;
        final int length = a1.length;
        int n4 = n;
        Point b3;
        while (true) {
            Label_0273: {
                if (n4 >= length) {
                    break Label_0273;
                }
                int n5 = a1[n4];
                final int n6 = (int)(n5 * n3);
                if (n5 <= n2) {
                    break Label_0273;
                }
                if (n6 <= c) {
                    break Label_0273;
                }
                Label_0267: {
                    if (Util.a >= 21) {
                        int n7;
                        if (b2) {
                            n7 = n6;
                        }
                        else {
                            n7 = n5;
                        }
                        if (!b2) {
                            n5 = n6;
                        }
                        b3 = mediaCodecInfo.b(n7, n5);
                        if (mediaCodecInfo.u(b3.x, b3.y, format.D)) {
                            break;
                        }
                        break Label_0267;
                    }
                    try {
                        int n8 = Util.l(n5, 16) * 16;
                        final int n9 = Util.l(n6, 16) * 16;
                        if (n8 * n9 <= MediaCodecUtil.N()) {
                            int n10;
                            if (b2) {
                                n10 = n9;
                            }
                            else {
                                n10 = n8;
                            }
                            if (!b2) {
                                n8 = n9;
                            }
                            return new Point(n10, n8);
                        }
                        ++n4;
                        continue;
                        return null;
                    }
                    catch (final MediaCodecUtil.DecoderQueryException ex) {
                        return null;
                    }
                }
            }
        }
        return b3;
    }
    
    private static List<MediaCodecInfo> H1(final MediaCodecSelector mediaCodecSelector, final Format format, final boolean b, final boolean b2) throws MediaCodecUtil.DecoderQueryException {
        final String w = format.w;
        if (w == null) {
            return (List<MediaCodecInfo>)ImmutableList.of();
        }
        final List<MediaCodecInfo> a = mediaCodecSelector.a(w, b, b2);
        final String m = MediaCodecUtil.m(format);
        if (m == null) {
            return (List<MediaCodecInfo>)ImmutableList.copyOf((Collection)a);
        }
        return (List<MediaCodecInfo>)ImmutableList.builder().j((Iterable)a).j((Iterable)mediaCodecSelector.a(m, b, b2)).l();
    }
    
    protected static int I1(final MediaCodecInfo mediaCodecInfo, final Format format) {
        if (format.x != -1) {
            final int size = format.y.size();
            int i = 0;
            int n = 0;
            while (i < size) {
                n += format.y.get(i).length;
                ++i;
            }
            return format.x + n;
        }
        return E1(mediaCodecInfo, format);
    }
    
    private static boolean K1(final long n) {
        return n < -30000L;
    }
    
    private static boolean L1(final long n) {
        return n < -500000L;
    }
    
    private void N1() {
        if (this.k1 > 0) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.T0.n(this.k1, elapsedRealtime - this.j1);
            this.k1 = 0;
            this.j1 = elapsedRealtime;
        }
    }
    
    private void P1() {
        final int q1 = this.q1;
        if (q1 != 0) {
            this.T0.B(this.p1, q1);
            this.p1 = 0L;
            this.q1 = 0;
        }
    }
    
    private void Q1() {
        final int r1 = this.r1;
        if (r1 != -1 || this.s1 != -1) {
            final VideoSize v1 = this.v1;
            if (v1 == null || v1.a != r1 || v1.b != this.s1 || v1.c != this.t1 || v1.d != this.u1) {
                final VideoSize v2 = new VideoSize(this.r1, this.s1, this.t1, this.u1);
                this.v1 = v2;
                this.T0.D(v2);
            }
        }
    }
    
    private void R1() {
        if (this.c1) {
            this.T0.A(this.a1);
        }
    }
    
    private void S1() {
        final VideoSize v1 = this.v1;
        if (v1 != null) {
            this.T0.D(v1);
        }
    }
    
    private void T1(final long n, final long n2, final Format format) {
        final VideoFrameMetadataListener z1 = this.z1;
        if (z1 != null) {
            z1.a(n, n2, format, this.z0());
        }
    }
    
    private void V1() {
        this.j1();
    }
    
    private void W1() {
        final Surface a1 = this.a1;
        final PlaceholderSurface b1 = this.b1;
        if (a1 == b1) {
            this.a1 = null;
        }
        b1.release();
        this.b1 = null;
    }
    
    private static void Z1(final MediaCodecAdapter mediaCodecAdapter, final byte[] array) {
        final Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", array);
        mediaCodecAdapter.i(bundle);
    }
    
    private void a2() {
        long i1;
        if (this.U0 > 0L) {
            i1 = SystemClock.elapsedRealtime() + this.U0;
        }
        else {
            i1 = -9223372036854775807L;
        }
        this.i1 = i1;
    }
    
    private void b2(final Object o) throws ExoPlaybackException {
        Surface surface;
        if (o instanceof Surface) {
            surface = (Surface)o;
        }
        else {
            surface = null;
        }
        PlaceholderSurface placeholderSurface = (PlaceholderSurface)surface;
        if (surface == null) {
            placeholderSurface = this.b1;
            if (placeholderSurface == null) {
                final MediaCodecInfo w0 = this.w0();
                placeholderSurface = (PlaceholderSurface)surface;
                if (w0 != null) {
                    placeholderSurface = (PlaceholderSurface)surface;
                    if (this.g2(w0)) {
                        placeholderSurface = PlaceholderSurface.c(this.R0, w0.g);
                        this.b1 = placeholderSurface;
                    }
                }
            }
        }
        if (this.a1 != placeholderSurface) {
            this.a1 = placeholderSurface;
            this.S0.m(placeholderSurface);
            this.c1 = false;
            final int state = this.getState();
            final MediaCodecAdapter v0 = this.v0();
            if (v0 != null) {
                if (Util.a >= 23 && placeholderSurface != null && !this.Y0) {
                    this.c2(v0, placeholderSurface);
                }
                else {
                    this.c1();
                    this.N0();
                }
            }
            if (placeholderSurface != null && placeholderSurface != this.b1) {
                this.S1();
                this.x1();
                if (state == 2) {
                    this.a2();
                }
            }
            else {
                this.y1();
                this.x1();
            }
        }
        else if (placeholderSurface != null && placeholderSurface != this.b1) {
            this.S1();
            this.R1();
        }
    }
    
    private boolean g2(final MediaCodecInfo mediaCodecInfo) {
        return Util.a >= 23 && !this.w1 && !this.z1(mediaCodecInfo.a) && (!mediaCodecInfo.g || PlaceholderSurface.b(this.R0));
    }
    
    static void v1(final MediaCodecVideoRenderer mediaCodecVideoRenderer) {
        mediaCodecVideoRenderer.V1();
    }
    
    static void w1(final MediaCodecVideoRenderer mediaCodecVideoRenderer, final ExoPlaybackException ex) {
        mediaCodecVideoRenderer.k1(ex);
    }
    
    private void x1() {
        this.e1 = false;
        if (Util.a >= 23 && this.w1) {
            final MediaCodecAdapter v0 = this.v0();
            if (v0 != null) {
                this.y1 = new a(v0);
            }
        }
    }
    
    private void y1() {
        this.v1 = null;
    }
    
    @Override
    protected List<MediaCodecInfo> A0(final MediaCodecSelector mediaCodecSelector, final Format format, final boolean b) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.u(H1(mediaCodecSelector, format, b, this.w1), format);
    }
    
    @Override
    protected MediaCodecAdapter.Configuration C0(final MediaCodecInfo mediaCodecInfo, final Format format, final MediaCrypto mediaCrypto, final float n) {
        final PlaceholderSurface b1 = this.b1;
        if (b1 != null && b1.a != mediaCodecInfo.g) {
            this.W1();
        }
        final String c = mediaCodecInfo.c;
        final CodecMaxValues g1 = this.G1(mediaCodecInfo, format, this.L());
        this.X0 = g1;
        final boolean w0 = this.W0;
        int x1;
        if (this.w1) {
            x1 = this.x1;
        }
        else {
            x1 = 0;
        }
        final MediaFormat j1 = this.J1(format, c, g1, n, w0, x1);
        if (this.a1 == null) {
            if (!this.g2(mediaCodecInfo)) {
                throw new IllegalStateException();
            }
            if (this.b1 == null) {
                this.b1 = PlaceholderSurface.c(this.R0, mediaCodecInfo.g);
            }
            this.a1 = this.b1;
        }
        return MediaCodecAdapter.Configuration.b(mediaCodecInfo, j1, format, this.a1, mediaCrypto);
    }
    
    protected void C1(final MediaCodecAdapter mediaCodecAdapter, final int n, final long n2) {
        TraceUtil.a("dropVideoBuffer");
        mediaCodecAdapter.m(n, false);
        TraceUtil.c();
        this.i2(0, 1);
    }
    
    @Override
    protected void F0(final DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (!this.Z0) {
            return;
        }
        final ByteBuffer byteBuffer = Assertions.e(decoderInputBuffer.g);
        if (byteBuffer.remaining() >= 7) {
            final byte value = byteBuffer.get();
            final short short1 = byteBuffer.getShort();
            final short short2 = byteBuffer.getShort();
            final byte value2 = byteBuffer.get();
            final byte value3 = byteBuffer.get();
            byteBuffer.position(0);
            if (value == -75 && short1 == 60 && short2 == 1 && value2 == 4 && value3 == 0) {
                final byte[] array = new byte[byteBuffer.remaining()];
                byteBuffer.get(array);
                byteBuffer.position(0);
                Z1(this.v0(), array);
            }
        }
    }
    
    protected CodecMaxValues G1(final MediaCodecInfo mediaCodecInfo, final Format format, final Format[] array) {
        int b = format.B;
        final int c = format.C;
        int i1 = I1(mediaCodecInfo, format);
        if (array.length == 1) {
            int min;
            if ((min = i1) != -1) {
                final int e1 = E1(mediaCodecInfo, format);
                min = i1;
                if (e1 != -1) {
                    min = Math.min((int)(i1 * 1.5f), e1);
                }
            }
            return new CodecMaxValues(b, c, min);
        }
        final int length = array.length;
        int j = 0;
        int n = 0;
        int n2 = c;
        while (j < length) {
            Format e2;
            final Format format2 = e2 = array[j];
            if (format.I != null) {
                e2 = format2;
                if (format2.I == null) {
                    e2 = format2.b().J(format.I).E();
                }
            }
            int max = b;
            int max2 = n2;
            int max3 = i1;
            int n3 = n;
            if (mediaCodecInfo.e(format, e2).d != 0) {
                final int b2 = e2.B;
                n3 = (n | ((b2 == -1 || e2.C == -1) ? 1 : 0));
                max = Math.max(b, b2);
                max2 = Math.max(n2, e2.C);
                max3 = Math.max(i1, I1(mediaCodecInfo, e2));
            }
            ++j;
            b = max;
            n2 = max2;
            i1 = max3;
            n = n3;
        }
        int max4 = b;
        int max5 = n2;
        int max6 = i1;
        if (n != 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(b);
            sb.append("x");
            sb.append(n2);
            Log.i("MediaCodecVideoRenderer", sb.toString());
            final Point f1 = F1(mediaCodecInfo, format);
            max4 = b;
            max5 = n2;
            max6 = i1;
            if (f1 != null) {
                max4 = Math.max(b, f1.x);
                max5 = Math.max(n2, f1.y);
                max6 = Math.max(i1, E1(mediaCodecInfo, format.b().j0(max4).Q(max5).E()));
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(max4);
                sb2.append("x");
                sb2.append(max5);
                Log.i("MediaCodecVideoRenderer", sb2.toString());
            }
        }
        return new CodecMaxValues(max4, max5, max6);
    }
    
    protected MediaFormat J1(final Format format, final String s, final CodecMaxValues codecMaxValues, final float n, final boolean b, final int n2) {
        final MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", s);
        mediaFormat.setInteger("width", format.B);
        mediaFormat.setInteger("height", format.C);
        MediaFormatUtil.e(mediaFormat, format.y);
        MediaFormatUtil.c(mediaFormat, "frame-rate", format.D);
        MediaFormatUtil.d(mediaFormat, "rotation-degrees", format.E);
        MediaFormatUtil.b(mediaFormat, format.I);
        if ("video/dolby-vision".equals(format.w)) {
            final Pair<Integer, Integer> q = MediaCodecUtil.q(format);
            if (q != null) {
                MediaFormatUtil.d(mediaFormat, "profile", (int)q.first);
            }
        }
        mediaFormat.setInteger("max-width", codecMaxValues.a);
        mediaFormat.setInteger("max-height", codecMaxValues.b);
        MediaFormatUtil.d(mediaFormat, "max-input-size", codecMaxValues.c);
        if (Util.a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (n != -1.0f) {
                mediaFormat.setFloat("operating-rate", n);
            }
        }
        if (b) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (n2 != 0) {
            A1(mediaFormat, n2);
        }
        return mediaFormat;
    }
    
    protected boolean M1(final long n, final boolean b) throws ExoPlaybackException {
        final int w = this.W(n);
        if (w == 0) {
            return false;
        }
        if (b) {
            final DecoderCounters m0 = super.M0;
            m0.d += w;
            m0.f += this.m1;
        }
        else {
            final DecoderCounters m2 = super.M0;
            ++m2.j;
            this.i2(w, this.m1);
        }
        this.s0();
        return true;
    }
    
    @Override
    protected void N() {
        this.y1();
        this.x1();
        this.c1 = false;
        this.y1 = null;
        try {
            super.N();
        }
        finally {
            this.T0.m(super.M0);
        }
    }
    
    @Override
    protected void O(final boolean b, final boolean f1) throws ExoPlaybackException {
        super.O(b, f1);
        final boolean a = this.H().a;
        Assertions.g(!a || this.x1 != 0);
        if (this.w1 != a) {
            this.w1 = a;
            this.c1();
        }
        this.T0.o(super.M0);
        this.f1 = f1;
        this.g1 = false;
    }
    
    void O1() {
        this.g1 = true;
        if (!this.e1) {
            this.e1 = true;
            this.T0.A(this.a1);
            this.c1 = true;
        }
    }
    
    @Override
    protected void P(final long n, final boolean b) throws ExoPlaybackException {
        super.P(n, b);
        this.x1();
        this.S0.j();
        this.n1 = -9223372036854775807L;
        this.h1 = -9223372036854775807L;
        this.l1 = 0;
        if (b) {
            this.a2();
        }
        else {
            this.i1 = -9223372036854775807L;
        }
    }
    
    @Override
    protected void P0(final Exception ex) {
        Log.d("MediaCodecVideoRenderer", "Video codec error", ex);
        this.T0.C(ex);
    }
    
    @Override
    protected void Q() {
        try {
            super.Q();
        }
        finally {
            if (this.b1 != null) {
                this.W1();
            }
        }
    }
    
    @Override
    protected void Q0(final String s, final MediaCodecAdapter.Configuration configuration, final long n, final long n2) {
        this.T0.k(s, n, n2);
        this.Y0 = this.z1(s);
        this.Z0 = Assertions.e(this.w0()).n();
        if (Util.a >= 23 && this.w1) {
            this.y1 = new a(Assertions.e(this.v0()));
        }
    }
    
    @Override
    protected void R() {
        super.R();
        this.k1 = 0;
        this.j1 = SystemClock.elapsedRealtime();
        this.o1 = SystemClock.elapsedRealtime() * 1000L;
        this.p1 = 0L;
        this.q1 = 0;
        this.S0.k();
    }
    
    @Override
    protected void R0(final String s) {
        this.T0.l(s);
    }
    
    @Override
    protected void S() {
        this.i1 = -9223372036854775807L;
        this.N1();
        this.P1();
        this.S0.l();
        super.S();
    }
    
    @Override
    protected DecoderReuseEvaluation S0(final FormatHolder formatHolder) throws ExoPlaybackException {
        final DecoderReuseEvaluation s0 = super.S0(formatHolder);
        this.T0.p(formatHolder.b, s0);
        return s0;
    }
    
    @Override
    protected void T0(final Format format, final MediaFormat mediaFormat) {
        final MediaCodecAdapter v0 = this.v0();
        if (v0 != null) {
            v0.d(this.d1);
        }
        if (this.w1) {
            this.r1 = format.B;
            this.s1 = format.C;
        }
        else {
            Assertions.e(mediaFormat);
            final boolean b = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer;
            if (b) {
                integer = mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left") + 1;
            }
            else {
                integer = mediaFormat.getInteger("width");
            }
            this.r1 = integer;
            int integer2;
            if (b) {
                integer2 = mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top") + 1;
            }
            else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.s1 = integer2;
        }
        final float f = format.F;
        this.u1 = f;
        if (Util.a >= 21) {
            final int e = format.E;
            if (e == 90 || e == 270) {
                final int r1 = this.r1;
                this.r1 = this.s1;
                this.s1 = r1;
                this.u1 = 1.0f / f;
            }
        }
        else {
            this.t1 = format.E;
        }
        this.S0.g(format.D);
    }
    
    @Override
    protected void U0(final long n) {
        super.U0(n);
        if (!this.w1) {
            --this.m1;
        }
    }
    
    protected void U1(final long n) throws ExoPlaybackException {
        this.u1(n);
        this.Q1();
        final DecoderCounters m0 = super.M0;
        ++m0.e;
        this.O1();
        this.U0(n);
    }
    
    @Override
    protected void V0() {
        super.V0();
        this.x1();
    }
    
    @Override
    protected void W0(final DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        final boolean w1 = this.w1;
        if (!w1) {
            ++this.m1;
        }
        if (Util.a < 23 && w1) {
            this.U1(decoderInputBuffer.f);
        }
    }
    
    protected void X1(final MediaCodecAdapter mediaCodecAdapter, final int n, final long n2) {
        this.Q1();
        TraceUtil.a("releaseOutputBuffer");
        mediaCodecAdapter.m(n, true);
        TraceUtil.c();
        this.o1 = SystemClock.elapsedRealtime() * 1000L;
        final DecoderCounters m0 = super.M0;
        ++m0.e;
        this.l1 = 0;
        this.O1();
    }
    
    @Override
    protected boolean Y0(long nanoTime, final long n, final MediaCodecAdapter mediaCodecAdapter, final ByteBuffer byteBuffer, final int n2, int n3, int n4, long b, final boolean b2, final boolean b3, final Format format) throws ExoPlaybackException {
        Assertions.e(mediaCodecAdapter);
        if (this.h1 == -9223372036854775807L) {
            this.h1 = nanoTime;
        }
        if (b != this.n1) {
            this.S0.h(b);
            this.n1 = b;
        }
        final long d0 = this.D0();
        final long n5 = b - d0;
        if (b2 && !b3) {
            this.h2(mediaCodecAdapter, n2, n5);
            return true;
        }
        final double n6 = this.E0();
        if (this.getState() == 2) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        final long n7 = SystemClock.elapsedRealtime() * 1000L;
        final long n8 = b = (long)((b - nanoTime) / n6);
        if (n3 != 0) {
            b = n8 - (n7 - n);
        }
        if (this.a1 != this.b1) {
            final long n9 = n7 - this.o1;
            Label_0230: {
                Label_0227: {
                    if (!this.g1) {
                        if (n3 == 0) {
                            if (!this.f1) {
                                break Label_0227;
                            }
                        }
                    }
                    else if (this.e1) {
                        break Label_0227;
                    }
                    n4 = 1;
                    break Label_0230;
                }
                n4 = 0;
            }
            if (this.i1 == -9223372036854775807L && nanoTime >= d0 && (n4 != 0 || (n3 != 0 && this.f2(b, n9)))) {
                n4 = 1;
            }
            else {
                n4 = 0;
            }
            if (n4 == 0) {
                if (n3 != 0) {
                    if (nanoTime != this.h1) {
                        final long nanoTime2 = System.nanoTime();
                        b = this.S0.b(b * 1000L + nanoTime2);
                        final long n10 = (b - nanoTime2) / 1000L;
                        final boolean b4 = this.i1 != -9223372036854775807L;
                        if (this.d2(n10, n, b3) && this.M1(nanoTime, b4)) {
                            return false;
                        }
                        if (this.e2(n10, n, b3)) {
                            if (b4) {
                                this.h2(mediaCodecAdapter, n2, n5);
                            }
                            else {
                                this.C1(mediaCodecAdapter, n2, n5);
                            }
                            this.j2(n10);
                            return true;
                        }
                        if (Util.a >= 21) {
                            if (n10 < 50000L) {
                                this.T1(n5, b, format);
                                this.Y1(mediaCodecAdapter, n2, n5, b);
                                this.j2(n10);
                                return true;
                            }
                        }
                        else if (n10 < 30000L) {
                            if (n10 > 11000L) {
                                try {
                                    Thread.sleep((n10 - 10000L) / 1000L);
                                }
                                catch (final InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                    return false;
                                }
                            }
                            this.T1(n5, b, format);
                            this.X1(mediaCodecAdapter, n2, n5);
                            this.j2(n10);
                            return true;
                        }
                    }
                }
                return false;
            }
            nanoTime = System.nanoTime();
            this.T1(n5, nanoTime, format);
            if (Util.a >= 21) {
                this.Y1(mediaCodecAdapter, n2, n5, nanoTime);
            }
            else {
                this.X1(mediaCodecAdapter, n2, n5);
            }
            this.j2(b);
            return true;
        }
        if (K1(b)) {
            this.h2(mediaCodecAdapter, n2, n5);
            this.j2(b);
            return true;
        }
        return false;
    }
    
    protected void Y1(final MediaCodecAdapter mediaCodecAdapter, final int n, final long n2, final long n3) {
        this.Q1();
        TraceUtil.a("releaseOutputBuffer");
        mediaCodecAdapter.j(n, n3);
        TraceUtil.c();
        this.o1 = SystemClock.elapsedRealtime() * 1000L;
        final DecoderCounters m0 = super.M0;
        ++m0.e;
        this.l1 = 0;
        this.O1();
    }
    
    @Override
    protected DecoderReuseEvaluation Z(final MediaCodecInfo mediaCodecInfo, final Format format, final Format format2) {
        final DecoderReuseEvaluation e = mediaCodecInfo.e(format, format2);
        final int e2 = e.e;
        final int b = format2.B;
        final CodecMaxValues x0 = this.X0;
        int n = 0;
        Label_0061: {
            if (b <= x0.a) {
                n = e2;
                if (format2.C <= x0.b) {
                    break Label_0061;
                }
            }
            n = (e2 | 0x100);
        }
        int n2 = n;
        if (I1(mediaCodecInfo, format2) > this.X0.c) {
            n2 = (n | 0x40);
        }
        final String a = mediaCodecInfo.a;
        int d;
        if (n2 != 0) {
            d = 0;
        }
        else {
            d = e.d;
        }
        return new DecoderReuseEvaluation(a, format, format2, d, n2);
    }
    
    protected void c2(final MediaCodecAdapter mediaCodecAdapter, final Surface surface) {
        mediaCodecAdapter.f(surface);
    }
    
    protected boolean d2(final long n, final long n2, final boolean b) {
        return L1(n) && !b;
    }
    
    @Override
    protected void e1() {
        super.e1();
        this.m1 = 0;
    }
    
    protected boolean e2(final long n, final long n2, final boolean b) {
        return K1(n) && !b;
    }
    
    protected boolean f2(final long n, final long n2) {
        return K1(n) && n2 > 100000L;
    }
    
    @Override
    public String getName() {
        return "MediaCodecVideoRenderer";
    }
    
    protected void h2(final MediaCodecAdapter mediaCodecAdapter, final int n, final long n2) {
        TraceUtil.a("skipVideoBuffer");
        mediaCodecAdapter.m(n, false);
        TraceUtil.c();
        final DecoderCounters m0 = super.M0;
        ++m0.f;
    }
    
    protected void i2(int v0, final int n) {
        final DecoderCounters m0 = super.M0;
        m0.h += v0;
        v0 += n;
        m0.g += v0;
        this.k1 += v0;
        v0 += this.l1;
        this.l1 = v0;
        m0.i = Math.max(v0, m0.i);
        v0 = this.V0;
        if (v0 > 0 && this.k1 >= v0) {
            this.N1();
        }
    }
    
    @Override
    public boolean isReady() {
        Label_0054: {
            if (super.isReady()) {
                if (!this.e1) {
                    final PlaceholderSurface b1 = this.b1;
                    if ((b1 == null || this.a1 != b1) && this.v0() != null && !this.w1) {
                        break Label_0054;
                    }
                }
                this.i1 = -9223372036854775807L;
                return true;
            }
        }
        if (this.i1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.i1) {
            return true;
        }
        this.i1 = -9223372036854775807L;
        return false;
    }
    
    @Override
    protected MediaCodecDecoderException j0(final Throwable t, final MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(t, mediaCodecInfo, this.a1);
    }
    
    protected void j2(final long n) {
        super.M0.a(n);
        this.p1 += n;
        ++this.q1;
    }
    
    @Override
    protected boolean n1(final MediaCodecInfo mediaCodecInfo) {
        return this.a1 != null || this.g2(mediaCodecInfo);
    }
    
    @Override
    public void p(int intValue, final Object o) throws ExoPlaybackException {
        if (intValue != 1) {
            if (intValue != 7) {
                if (intValue != 10) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            super.p(intValue, o);
                        }
                        else {
                            this.S0.o((int)o);
                        }
                    }
                    else {
                        this.d1 = (int)o;
                        final MediaCodecAdapter v0 = this.v0();
                        if (v0 != null) {
                            v0.d(this.d1);
                        }
                    }
                }
                else {
                    intValue = (int)o;
                    if (this.x1 != intValue) {
                        this.x1 = intValue;
                        if (this.w1) {
                            this.c1();
                        }
                    }
                }
            }
            else {
                this.z1 = (VideoFrameMetadataListener)o;
            }
        }
        else {
            this.b2(o);
        }
    }
    
    @Override
    protected int q1(final MediaCodecSelector mediaCodecSelector, final Format format) throws MediaCodecUtil.DecoderQueryException {
        final boolean s = MimeTypes.s(format.w);
        final int n = 0;
        if (!s) {
            return RendererCapabilities.o(0);
        }
        final boolean b = format.z != null;
        List<MediaCodecInfo> list2;
        final List<MediaCodecInfo> list = list2 = H1(mediaCodecSelector, format, b, (boolean)(0 != 0));
        if (b) {
            list2 = list;
            if (list.isEmpty()) {
                list2 = H1(mediaCodecSelector, format, false, false);
            }
        }
        if (list2.isEmpty()) {
            return RendererCapabilities.o(1);
        }
        if (!MediaCodecRenderer.r1(format)) {
            return RendererCapabilities.o(2);
        }
        final MediaCodecInfo mediaCodecInfo = list2.get(0);
        int m = mediaCodecInfo.m(format) ? 1 : 0;
        boolean b2 = false;
        MediaCodecInfo mediaCodecInfo3 = null;
        Label_0194: {
            if (m == 0) {
                for (int i = 1; i < list2.size(); ++i) {
                    final MediaCodecInfo mediaCodecInfo2 = list2.get(i);
                    if (mediaCodecInfo2.m(format)) {
                        b2 = false;
                        m = 1;
                        mediaCodecInfo3 = mediaCodecInfo2;
                        break Label_0194;
                    }
                }
            }
            b2 = true;
            mediaCodecInfo3 = mediaCodecInfo;
        }
        int n2;
        if (m != 0) {
            n2 = 4;
        }
        else {
            n2 = 3;
        }
        int n3;
        if (mediaCodecInfo3.p(format)) {
            n3 = 16;
        }
        else {
            n3 = 8;
        }
        int n4;
        if (mediaCodecInfo3.h) {
            n4 = 64;
        }
        else {
            n4 = 0;
        }
        int n5;
        if (b2) {
            n5 = 128;
        }
        else {
            n5 = 0;
        }
        int n6 = n;
        if (m != 0) {
            final List<MediaCodecInfo> h1 = H1(mediaCodecSelector, format, b, true);
            n6 = n;
            if (!h1.isEmpty()) {
                final MediaCodecInfo mediaCodecInfo4 = MediaCodecUtil.u(h1, format).get(0);
                n6 = n;
                if (mediaCodecInfo4.m(format)) {
                    n6 = n;
                    if (mediaCodecInfo4.p(format)) {
                        n6 = 32;
                    }
                }
            }
        }
        return RendererCapabilities.k(n2, n3, n6, n4, n5);
    }
    
    @Override
    public void x(final float n, final float n2) throws ExoPlaybackException {
        super.x(n, n2);
        this.S0.i(n);
    }
    
    @Override
    protected boolean x0() {
        return this.w1 && Util.a < 23;
    }
    
    @Override
    protected float y0(float n, final Format format, final Format[] array) {
        final int length = array.length;
        final float n2 = -1.0f;
        int i = 0;
        float n3 = -1.0f;
        while (i < length) {
            final float d = array[i].D;
            float max = n3;
            if (d != -1.0f) {
                max = Math.max(n3, d);
            }
            ++i;
            n3 = max;
        }
        if (n3 == -1.0f) {
            n = n2;
        }
        else {
            n *= n3;
        }
        return n;
    }
    
    protected boolean z1(final String s) {
        if (s.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!MediaCodecVideoRenderer.B1) {
                MediaCodecVideoRenderer.C1 = D1();
                MediaCodecVideoRenderer.B1 = true;
            }
            return MediaCodecVideoRenderer.C1;
        }
    }
    
    protected static final class CodecMaxValues
    {
        public final int a;
        public final int b;
        public final int c;
        
        public CodecMaxValues(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    private final class a implements OnFrameRenderedListener, Handler$Callback
    {
        private final Handler a;
        final MediaCodecVideoRenderer b;
        
        public a(final MediaCodecVideoRenderer b, final MediaCodecAdapter mediaCodecAdapter) {
            this.b = b;
            mediaCodecAdapter.c((MediaCodecAdapter.OnFrameRenderedListener)this, this.a = Util.x((Handler$Callback)this));
        }
        
        private void b(final long n) {
            final MediaCodecVideoRenderer b = this.b;
            if (this != b.y1) {
                return;
            }
            if (n == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.v1(b);
            }
            else {
                try {
                    b.U1(n);
                }
                catch (final ExoPlaybackException ex) {
                    MediaCodecVideoRenderer.w1(this.b, ex);
                }
            }
        }
        
        @Override
        public void a(final MediaCodecAdapter mediaCodecAdapter, final long n, final long n2) {
            if (Util.a < 30) {
                this.a.sendMessageAtFrontOfQueue(Message.obtain(this.a, 0, (int)(n >> 32), (int)n));
            }
            else {
                this.b(n);
            }
        }
        
        public boolean handleMessage(final Message message) {
            if (message.what != 0) {
                return false;
            }
            this.b(Util.b1(message.arg1, message.arg2));
            return true;
        }
    }
}
