// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.List;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Util;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import f4.a;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import java.util.Map;
import android.content.Context;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableList;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener
{
    public static final ImmutableList<Long> p;
    public static final ImmutableList<Long> q;
    public static final ImmutableList<Long> r;
    public static final ImmutableList<Long> s;
    public static final ImmutableList<Long> t;
    public static final ImmutableList<Long> u;
    private static DefaultBandwidthMeter v;
    private final ImmutableMap<Integer, Long> a;
    private final EventListener.EventDispatcher b;
    private final SlidingPercentile c;
    private final Clock d;
    private final boolean e;
    private int f;
    private long g;
    private long h;
    private int i;
    private long j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private int o;
    
    static {
        final Long value = 1500000L;
        p = ImmutableList.of((Object)4800000L, (Object)3100000L, (Object)2100000L, (Object)value, (Object)800000L);
        final Long value2 = 1000000L;
        q = ImmutableList.of((Object)value, (Object)value2, (Object)730000L, (Object)440000L, (Object)170000L);
        final Long value3 = 1400000L;
        final Long value4 = 1100000L;
        r = ImmutableList.of((Object)2200000L, (Object)value3, (Object)value4, (Object)910000L, (Object)620000L);
        s = ImmutableList.of((Object)3000000L, (Object)1900000L, (Object)value3, (Object)value2, (Object)660000L);
        t = ImmutableList.of((Object)6000000L, (Object)4100000L, (Object)3200000L, (Object)1800000L, (Object)value2);
        u = ImmutableList.of((Object)2800000L, (Object)2400000L, (Object)1600000L, (Object)value4, (Object)950000L);
    }
    
    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, (Map<Integer, Long>)ImmutableMap.of(), 2000, Clock.a, false);
    }
    
    private DefaultBandwidthMeter(final Context context, final Map<Integer, Long> map, int f, final Clock d, final boolean e) {
        this.a = (ImmutableMap<Integer, Long>)ImmutableMap.copyOf((Map)map);
        this.b = new EventListener.EventDispatcher();
        this.c = new SlidingPercentile(f);
        this.d = d;
        this.e = e;
        if (context != null) {
            final NetworkTypeObserver d2 = NetworkTypeObserver.d(context);
            f = d2.f();
            this.i = f;
            this.l = this.m(f);
            d2.i((NetworkTypeObserver.Listener)new a(this));
        }
        else {
            this.i = 0;
            this.l = this.m(0);
        }
    }
    
    DefaultBandwidthMeter(final Context context, final Map map, final int n, final Clock clock, final boolean b, final DefaultBandwidthMeter$a object) {
        this(context, map, n, clock, b);
    }
    
    public static void j(final DefaultBandwidthMeter defaultBandwidthMeter, final int n) {
        defaultBandwidthMeter.q(n);
    }
    
    static int[] k(final String s) {
        return l(s);
    }
    
    private static int[] l(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2877: {
                if (!s.equals("ZW")) {
                    break;
                }
                n = 236;
                break;
            }
            case 2867: {
                if (!s.equals("ZM")) {
                    break;
                }
                n = 235;
                break;
            }
            case 2855: {
                if (!s.equals("ZA")) {
                    break;
                }
                n = 234;
                break;
            }
            case 2843: {
                if (!s.equals("YT")) {
                    break;
                }
                n = 233;
                break;
            }
            case 2828: {
                if (!s.equals("YE")) {
                    break;
                }
                n = 232;
                break;
            }
            case 2803: {
                if (!s.equals("XK")) {
                    break;
                }
                n = 231;
                break;
            }
            case 2780: {
                if (!s.equals("WS")) {
                    break;
                }
                n = 230;
                break;
            }
            case 2767: {
                if (!s.equals("WF")) {
                    break;
                }
                n = 229;
                break;
            }
            case 2751: {
                if (!s.equals("VU")) {
                    break;
                }
                n = 228;
                break;
            }
            case 2744: {
                if (!s.equals("VN")) {
                    break;
                }
                n = 227;
                break;
            }
            case 2739: {
                if (!s.equals("VI")) {
                    break;
                }
                n = 226;
                break;
            }
            case 2737: {
                if (!s.equals("VG")) {
                    break;
                }
                n = 225;
                break;
            }
            case 2735: {
                if (!s.equals("VE")) {
                    break;
                }
                n = 224;
                break;
            }
            case 2733: {
                if (!s.equals("VC")) {
                    break;
                }
                n = 223;
                break;
            }
            case 2731: {
                if (!s.equals("VA")) {
                    break;
                }
                n = 222;
                break;
            }
            case 2725: {
                if (!s.equals("UZ")) {
                    break;
                }
                n = 221;
                break;
            }
            case 2724: {
                if (!s.equals("UY")) {
                    break;
                }
                n = 220;
                break;
            }
            case 2718: {
                if (!s.equals("US")) {
                    break;
                }
                n = 219;
                break;
            }
            case 2706: {
                if (!s.equals("UG")) {
                    break;
                }
                n = 218;
                break;
            }
            case 2700: {
                if (!s.equals("UA")) {
                    break;
                }
                n = 217;
                break;
            }
            case 2694: {
                if (!s.equals("TZ")) {
                    break;
                }
                n = 216;
                break;
            }
            case 2691: {
                if (!s.equals("TW")) {
                    break;
                }
                n = 215;
                break;
            }
            case 2690: {
                if (!s.equals("TV")) {
                    break;
                }
                n = 214;
                break;
            }
            case 2688: {
                if (!s.equals("TT")) {
                    break;
                }
                n = 213;
                break;
            }
            case 2686: {
                if (!s.equals("TR")) {
                    break;
                }
                n = 212;
                break;
            }
            case 2683: {
                if (!s.equals("TO")) {
                    break;
                }
                n = 211;
                break;
            }
            case 2682: {
                if (!s.equals("TN")) {
                    break;
                }
                n = 210;
                break;
            }
            case 2681: {
                if (!s.equals("TM")) {
                    break;
                }
                n = 209;
                break;
            }
            case 2680: {
                if (!s.equals("TL")) {
                    break;
                }
                n = 208;
                break;
            }
            case 2679: {
                if (!s.equals("TK")) {
                    break;
                }
                n = 207;
                break;
            }
            case 2678: {
                if (!s.equals("TJ")) {
                    break;
                }
                n = 206;
                break;
            }
            case 2676: {
                if (!s.equals("TH")) {
                    break;
                }
                n = 205;
                break;
            }
            case 2675: {
                if (!s.equals("TG")) {
                    break;
                }
                n = 204;
                break;
            }
            case 2672: {
                if (!s.equals("TD")) {
                    break;
                }
                n = 203;
                break;
            }
            case 2671: {
                if (!s.equals("TC")) {
                    break;
                }
                n = 202;
                break;
            }
            case 2663: {
                if (!s.equals("SZ")) {
                    break;
                }
                n = 201;
                break;
            }
            case 2662: {
                if (!s.equals("SY")) {
                    break;
                }
                n = 200;
                break;
            }
            case 2661: {
                if (!s.equals("SX")) {
                    break;
                }
                n = 199;
                break;
            }
            case 2659: {
                if (!s.equals("SV")) {
                    break;
                }
                n = 198;
                break;
            }
            case 2657: {
                if (!s.equals("ST")) {
                    break;
                }
                n = 197;
                break;
            }
            case 2656: {
                if (!s.equals("SS")) {
                    break;
                }
                n = 196;
                break;
            }
            case 2655: {
                if (!s.equals("SR")) {
                    break;
                }
                n = 195;
                break;
            }
            case 2652: {
                if (!s.equals("SO")) {
                    break;
                }
                n = 194;
                break;
            }
            case 2651: {
                if (!s.equals("SN")) {
                    break;
                }
                n = 193;
                break;
            }
            case 2650: {
                if (!s.equals("SM")) {
                    break;
                }
                n = 192;
                break;
            }
            case 2649: {
                if (!s.equals("SL")) {
                    break;
                }
                n = 191;
                break;
            }
            case 2648: {
                if (!s.equals("SK")) {
                    break;
                }
                n = 190;
                break;
            }
            case 2646: {
                if (!s.equals("SI")) {
                    break;
                }
                n = 189;
                break;
            }
            case 2645: {
                if (!s.equals("SH")) {
                    break;
                }
                n = 188;
                break;
            }
            case 2644: {
                if (!s.equals("SG")) {
                    break;
                }
                n = 187;
                break;
            }
            case 2642: {
                if (!s.equals("SE")) {
                    break;
                }
                n = 186;
                break;
            }
            case 2641: {
                if (!s.equals("SD")) {
                    break;
                }
                n = 185;
                break;
            }
            case 2640: {
                if (!s.equals("SC")) {
                    break;
                }
                n = 184;
                break;
            }
            case 2639: {
                if (!s.equals("SB")) {
                    break;
                }
                n = 183;
                break;
            }
            case 2638: {
                if (!s.equals("SA")) {
                    break;
                }
                n = 182;
                break;
            }
            case 2629: {
                if (!s.equals("RW")) {
                    break;
                }
                n = 181;
                break;
            }
            case 2627: {
                if (!s.equals("RU")) {
                    break;
                }
                n = 180;
                break;
            }
            case 2625: {
                if (!s.equals("RS")) {
                    break;
                }
                n = 179;
                break;
            }
            case 2621: {
                if (!s.equals("RO")) {
                    break;
                }
                n = 178;
                break;
            }
            case 2611: {
                if (!s.equals("RE")) {
                    break;
                }
                n = 177;
                break;
            }
            case 2576: {
                if (!s.equals("QA")) {
                    break;
                }
                n = 176;
                break;
            }
            case 2567: {
                if (!s.equals("PW")) {
                    break;
                }
                n = 175;
                break;
            }
            case 2564: {
                if (!s.equals("PT")) {
                    break;
                }
                n = 174;
                break;
            }
            case 2563: {
                if (!s.equals("PS")) {
                    break;
                }
                n = 173;
                break;
            }
            case 2562: {
                if (!s.equals("PR")) {
                    break;
                }
                n = 172;
                break;
            }
            case 2557: {
                if (!s.equals("PM")) {
                    break;
                }
                n = 171;
                break;
            }
            case 2556: {
                if (!s.equals("PL")) {
                    break;
                }
                n = 170;
                break;
            }
            case 2555: {
                if (!s.equals("PK")) {
                    break;
                }
                n = 169;
                break;
            }
            case 2552: {
                if (!s.equals("PH")) {
                    break;
                }
                n = 168;
                break;
            }
            case 2551: {
                if (!s.equals("PG")) {
                    break;
                }
                n = 167;
                break;
            }
            case 2550: {
                if (!s.equals("PF")) {
                    break;
                }
                n = 166;
                break;
            }
            case 2549: {
                if (!s.equals("PE")) {
                    break;
                }
                n = 165;
                break;
            }
            case 2545: {
                if (!s.equals("PA")) {
                    break;
                }
                n = 164;
                break;
            }
            case 2526: {
                if (!s.equals("OM")) {
                    break;
                }
                n = 163;
                break;
            }
            case 2508: {
                if (!s.equals("NZ")) {
                    break;
                }
                n = 162;
                break;
            }
            case 2503: {
                if (!s.equals("NU")) {
                    break;
                }
                n = 161;
                break;
            }
            case 2500: {
                if (!s.equals("NR")) {
                    break;
                }
                n = 160;
                break;
            }
            case 2498: {
                if (!s.equals("NP")) {
                    break;
                }
                n = 159;
                break;
            }
            case 2497: {
                if (!s.equals("NO")) {
                    break;
                }
                n = 158;
                break;
            }
            case 2494: {
                if (!s.equals("NL")) {
                    break;
                }
                n = 157;
                break;
            }
            case 2491: {
                if (!s.equals("NI")) {
                    break;
                }
                n = 156;
                break;
            }
            case 2489: {
                if (!s.equals("NG")) {
                    break;
                }
                n = 155;
                break;
            }
            case 2487: {
                if (!s.equals("NE")) {
                    break;
                }
                n = 154;
                break;
            }
            case 2485: {
                if (!s.equals("NC")) {
                    break;
                }
                n = 153;
                break;
            }
            case 2483: {
                if (!s.equals("NA")) {
                    break;
                }
                n = 152;
                break;
            }
            case 2477: {
                if (!s.equals("MZ")) {
                    break;
                }
                n = 151;
                break;
            }
            case 2476: {
                if (!s.equals("MY")) {
                    break;
                }
                n = 150;
                break;
            }
            case 2475: {
                if (!s.equals("MX")) {
                    break;
                }
                n = 149;
                break;
            }
            case 2474: {
                if (!s.equals("MW")) {
                    break;
                }
                n = 148;
                break;
            }
            case 2473: {
                if (!s.equals("MV")) {
                    break;
                }
                n = 147;
                break;
            }
            case 2472: {
                if (!s.equals("MU")) {
                    break;
                }
                n = 146;
                break;
            }
            case 2471: {
                if (!s.equals("MT")) {
                    break;
                }
                n = 145;
                break;
            }
            case 2470: {
                if (!s.equals("MS")) {
                    break;
                }
                n = 144;
                break;
            }
            case 2469: {
                if (!s.equals("MR")) {
                    break;
                }
                n = 143;
                break;
            }
            case 2468: {
                if (!s.equals("MQ")) {
                    break;
                }
                n = 142;
                break;
            }
            case 2467: {
                if (!s.equals("MP")) {
                    break;
                }
                n = 141;
                break;
            }
            case 2466: {
                if (!s.equals("MO")) {
                    break;
                }
                n = 140;
                break;
            }
            case 2465: {
                if (!s.equals("MN")) {
                    break;
                }
                n = 139;
                break;
            }
            case 2464: {
                if (!s.equals("MM")) {
                    break;
                }
                n = 138;
                break;
            }
            case 2463: {
                if (!s.equals("ML")) {
                    break;
                }
                n = 137;
                break;
            }
            case 2462: {
                if (!s.equals("MK")) {
                    break;
                }
                n = 136;
                break;
            }
            case 2459: {
                if (!s.equals("MH")) {
                    break;
                }
                n = 135;
                break;
            }
            case 2458: {
                if (!s.equals("MG")) {
                    break;
                }
                n = 134;
                break;
            }
            case 2457: {
                if (!s.equals("MF")) {
                    break;
                }
                n = 133;
                break;
            }
            case 2456: {
                if (!s.equals("ME")) {
                    break;
                }
                n = 132;
                break;
            }
            case 2455: {
                if (!s.equals("MD")) {
                    break;
                }
                n = 131;
                break;
            }
            case 2454: {
                if (!s.equals("MC")) {
                    break;
                }
                n = 130;
                break;
            }
            case 2452: {
                if (!s.equals("MA")) {
                    break;
                }
                n = 129;
                break;
            }
            case 2445: {
                if (!s.equals("LY")) {
                    break;
                }
                n = 128;
                break;
            }
            case 2442: {
                if (!s.equals("LV")) {
                    break;
                }
                n = 127;
                break;
            }
            case 2441: {
                if (!s.equals("LU")) {
                    break;
                }
                n = 126;
                break;
            }
            case 2440: {
                if (!s.equals("LT")) {
                    break;
                }
                n = 125;
                break;
            }
            case 2439: {
                if (!s.equals("LS")) {
                    break;
                }
                n = 124;
                break;
            }
            case 2438: {
                if (!s.equals("LR")) {
                    break;
                }
                n = 123;
                break;
            }
            case 2431: {
                if (!s.equals("LK")) {
                    break;
                }
                n = 122;
                break;
            }
            case 2429: {
                if (!s.equals("LI")) {
                    break;
                }
                n = 121;
                break;
            }
            case 2423: {
                if (!s.equals("LC")) {
                    break;
                }
                n = 120;
                break;
            }
            case 2422: {
                if (!s.equals("LB")) {
                    break;
                }
                n = 119;
                break;
            }
            case 2421: {
                if (!s.equals("LA")) {
                    break;
                }
                n = 118;
                break;
            }
            case 2415: {
                if (!s.equals("KZ")) {
                    break;
                }
                n = 117;
                break;
            }
            case 2414: {
                if (!s.equals("KY")) {
                    break;
                }
                n = 116;
                break;
            }
            case 2412: {
                if (!s.equals("KW")) {
                    break;
                }
                n = 115;
                break;
            }
            case 2407: {
                if (!s.equals("KR")) {
                    break;
                }
                n = 114;
                break;
            }
            case 2405: {
                if (!s.equals("KP")) {
                    break;
                }
                n = 113;
                break;
            }
            case 2403: {
                if (!s.equals("KN")) {
                    break;
                }
                n = 112;
                break;
            }
            case 2402: {
                if (!s.equals("KM")) {
                    break;
                }
                n = 111;
                break;
            }
            case 2398: {
                if (!s.equals("KI")) {
                    break;
                }
                n = 110;
                break;
            }
            case 2397: {
                if (!s.equals("KH")) {
                    break;
                }
                n = 109;
                break;
            }
            case 2396: {
                if (!s.equals("KG")) {
                    break;
                }
                n = 108;
                break;
            }
            case 2394: {
                if (!s.equals("KE")) {
                    break;
                }
                n = 107;
                break;
            }
            case 2374: {
                if (!s.equals("JP")) {
                    break;
                }
                n = 106;
                break;
            }
            case 2373: {
                if (!s.equals("JO")) {
                    break;
                }
                n = 105;
                break;
            }
            case 2371: {
                if (!s.equals("JM")) {
                    break;
                }
                n = 104;
                break;
            }
            case 2363: {
                if (!s.equals("JE")) {
                    break;
                }
                n = 103;
                break;
            }
            case 2347: {
                if (!s.equals("IT")) {
                    break;
                }
                n = 102;
                break;
            }
            case 2346: {
                if (!s.equals("IS")) {
                    break;
                }
                n = 101;
                break;
            }
            case 2345: {
                if (!s.equals("IR")) {
                    break;
                }
                n = 100;
                break;
            }
            case 2344: {
                if (!s.equals("IQ")) {
                    break;
                }
                n = 99;
                break;
            }
            case 2342: {
                if (!s.equals("IO")) {
                    break;
                }
                n = 98;
                break;
            }
            case 2341: {
                if (!s.equals("IN")) {
                    break;
                }
                n = 97;
                break;
            }
            case 2340: {
                if (!s.equals("IM")) {
                    break;
                }
                n = 96;
                break;
            }
            case 2339: {
                if (!s.equals("IL")) {
                    break;
                }
                n = 95;
                break;
            }
            case 2332: {
                if (!s.equals("IE")) {
                    break;
                }
                n = 94;
                break;
            }
            case 2331: {
                if (!s.equals("ID")) {
                    break;
                }
                n = 93;
                break;
            }
            case 2317: {
                if (!s.equals("HU")) {
                    break;
                }
                n = 92;
                break;
            }
            case 2316: {
                if (!s.equals("HT")) {
                    break;
                }
                n = 91;
                break;
            }
            case 2314: {
                if (!s.equals("HR")) {
                    break;
                }
                n = 90;
                break;
            }
            case 2307: {
                if (!s.equals("HK")) {
                    break;
                }
                n = 89;
                break;
            }
            case 2290: {
                if (!s.equals("GY")) {
                    break;
                }
                n = 88;
                break;
            }
            case 2288: {
                if (!s.equals("GW")) {
                    break;
                }
                n = 87;
                break;
            }
            case 2286: {
                if (!s.equals("GU")) {
                    break;
                }
                n = 86;
                break;
            }
            case 2285: {
                if (!s.equals("GT")) {
                    break;
                }
                n = 85;
                break;
            }
            case 2283: {
                if (!s.equals("GR")) {
                    break;
                }
                n = 84;
                break;
            }
            case 2282: {
                if (!s.equals("GQ")) {
                    break;
                }
                n = 83;
                break;
            }
            case 2281: {
                if (!s.equals("GP")) {
                    break;
                }
                n = 82;
                break;
            }
            case 2279: {
                if (!s.equals("GN")) {
                    break;
                }
                n = 81;
                break;
            }
            case 2278: {
                if (!s.equals("GM")) {
                    break;
                }
                n = 80;
                break;
            }
            case 2277: {
                if (!s.equals("GL")) {
                    break;
                }
                n = 79;
                break;
            }
            case 2274: {
                if (!s.equals("GI")) {
                    break;
                }
                n = 78;
                break;
            }
            case 2273: {
                if (!s.equals("GH")) {
                    break;
                }
                n = 77;
                break;
            }
            case 2272: {
                if (!s.equals("GG")) {
                    break;
                }
                n = 76;
                break;
            }
            case 2271: {
                if (!s.equals("GF")) {
                    break;
                }
                n = 75;
                break;
            }
            case 2270: {
                if (!s.equals("GE")) {
                    break;
                }
                n = 74;
                break;
            }
            case 2269: {
                if (!s.equals("GD")) {
                    break;
                }
                n = 73;
                break;
            }
            case 2267: {
                if (!s.equals("GB")) {
                    break;
                }
                n = 72;
                break;
            }
            case 2266: {
                if (!s.equals("GA")) {
                    break;
                }
                n = 71;
                break;
            }
            case 2252: {
                if (!s.equals("FR")) {
                    break;
                }
                n = 70;
                break;
            }
            case 2249: {
                if (!s.equals("FO")) {
                    break;
                }
                n = 69;
                break;
            }
            case 2247: {
                if (!s.equals("FM")) {
                    break;
                }
                n = 68;
                break;
            }
            case 2245: {
                if (!s.equals("FK")) {
                    break;
                }
                n = 67;
                break;
            }
            case 2244: {
                if (!s.equals("FJ")) {
                    break;
                }
                n = 66;
                break;
            }
            case 2243: {
                if (!s.equals("FI")) {
                    break;
                }
                n = 65;
                break;
            }
            case 2223: {
                if (!s.equals("ET")) {
                    break;
                }
                n = 64;
                break;
            }
            case 2222: {
                if (!s.equals("ES")) {
                    break;
                }
                n = 63;
                break;
            }
            case 2221: {
                if (!s.equals("ER")) {
                    break;
                }
                n = 62;
                break;
            }
            case 2210: {
                if (!s.equals("EG")) {
                    break;
                }
                n = 61;
                break;
            }
            case 2208: {
                if (!s.equals("EE")) {
                    break;
                }
                n = 60;
                break;
            }
            case 2206: {
                if (!s.equals("EC")) {
                    break;
                }
                n = 59;
                break;
            }
            case 2198: {
                if (!s.equals("DZ")) {
                    break;
                }
                n = 58;
                break;
            }
            case 2187: {
                if (!s.equals("DO")) {
                    break;
                }
                n = 57;
                break;
            }
            case 2185: {
                if (!s.equals("DM")) {
                    break;
                }
                n = 56;
                break;
            }
            case 2183: {
                if (!s.equals("DK")) {
                    break;
                }
                n = 55;
                break;
            }
            case 2182: {
                if (!s.equals("DJ")) {
                    break;
                }
                n = 54;
                break;
            }
            case 2177: {
                if (!s.equals("DE")) {
                    break;
                }
                n = 53;
                break;
            }
            case 2167: {
                if (!s.equals("CZ")) {
                    break;
                }
                n = 52;
                break;
            }
            case 2166: {
                if (!s.equals("CY")) {
                    break;
                }
                n = 51;
                break;
            }
            case 2165: {
                if (!s.equals("CX")) {
                    break;
                }
                n = 50;
                break;
            }
            case 2164: {
                if (!s.equals("CW")) {
                    break;
                }
                n = 49;
                break;
            }
            case 2163: {
                if (!s.equals("CV")) {
                    break;
                }
                n = 48;
                break;
            }
            case 2162: {
                if (!s.equals("CU")) {
                    break;
                }
                n = 47;
                break;
            }
            case 2159: {
                if (!s.equals("CR")) {
                    break;
                }
                n = 46;
                break;
            }
            case 2156: {
                if (!s.equals("CO")) {
                    break;
                }
                n = 45;
                break;
            }
            case 2155: {
                if (!s.equals("CN")) {
                    break;
                }
                n = 44;
                break;
            }
            case 2154: {
                if (!s.equals("CM")) {
                    break;
                }
                n = 43;
                break;
            }
            case 2153: {
                if (!s.equals("CL")) {
                    break;
                }
                n = 42;
                break;
            }
            case 2152: {
                if (!s.equals("CK")) {
                    break;
                }
                n = 41;
                break;
            }
            case 2150: {
                if (!s.equals("CI")) {
                    break;
                }
                n = 40;
                break;
            }
            case 2149: {
                if (!s.equals("CH")) {
                    break;
                }
                n = 39;
                break;
            }
            case 2148: {
                if (!s.equals("CG")) {
                    break;
                }
                n = 38;
                break;
            }
            case 2147: {
                if (!s.equals("CF")) {
                    break;
                }
                n = 37;
                break;
            }
            case 2145: {
                if (!s.equals("CD")) {
                    break;
                }
                n = 36;
                break;
            }
            case 2142: {
                if (!s.equals("CA")) {
                    break;
                }
                n = 35;
                break;
            }
            case 2136: {
                if (!s.equals("BZ")) {
                    break;
                }
                n = 34;
                break;
            }
            case 2135: {
                if (!s.equals("BY")) {
                    break;
                }
                n = 33;
                break;
            }
            case 2133: {
                if (!s.equals("BW")) {
                    break;
                }
                n = 32;
                break;
            }
            case 2130: {
                if (!s.equals("BT")) {
                    break;
                }
                n = 31;
                break;
            }
            case 2129: {
                if (!s.equals("BS")) {
                    break;
                }
                n = 30;
                break;
            }
            case 2127: {
                if (!s.equals("BQ")) {
                    break;
                }
                n = 29;
                break;
            }
            case 2125: {
                if (!s.equals("BO")) {
                    break;
                }
                n = 28;
                break;
            }
            case 2124: {
                if (!s.equals("BN")) {
                    break;
                }
                n = 27;
                break;
            }
            case 2123: {
                if (!s.equals("BM")) {
                    break;
                }
                n = 26;
                break;
            }
            case 2122: {
                if (!s.equals("BL")) {
                    break;
                }
                n = 25;
                break;
            }
            case 2120: {
                if (!s.equals("BJ")) {
                    break;
                }
                n = 24;
                break;
            }
            case 2119: {
                if (!s.equals("BI")) {
                    break;
                }
                n = 23;
                break;
            }
            case 2118: {
                if (!s.equals("BH")) {
                    break;
                }
                n = 22;
                break;
            }
            case 2117: {
                if (!s.equals("BG")) {
                    break;
                }
                n = 21;
                break;
            }
            case 2116: {
                if (!s.equals("BF")) {
                    break;
                }
                n = 20;
                break;
            }
            case 2115: {
                if (!s.equals("BE")) {
                    break;
                }
                n = 19;
                break;
            }
            case 2114: {
                if (!s.equals("BD")) {
                    break;
                }
                n = 18;
                break;
            }
            case 2112: {
                if (!s.equals("BB")) {
                    break;
                }
                n = 17;
                break;
            }
            case 2111: {
                if (!s.equals("BA")) {
                    break;
                }
                n = 16;
                break;
            }
            case 2105: {
                if (!s.equals("AZ")) {
                    break;
                }
                n = 15;
                break;
            }
            case 2103: {
                if (!s.equals("AX")) {
                    break;
                }
                n = 14;
                break;
            }
            case 2102: {
                if (!s.equals("AW")) {
                    break;
                }
                n = 13;
                break;
            }
            case 2100: {
                if (!s.equals("AU")) {
                    break;
                }
                n = 12;
                break;
            }
            case 2099: {
                if (!s.equals("AT")) {
                    break;
                }
                n = 11;
                break;
            }
            case 2098: {
                if (!s.equals("AS")) {
                    break;
                }
                n = 10;
                break;
            }
            case 2097: {
                if (!s.equals("AR")) {
                    break;
                }
                n = 9;
                break;
            }
            case 2096: {
                if (!s.equals("AQ")) {
                    break;
                }
                n = 8;
                break;
            }
            case 2094: {
                if (!s.equals("AO")) {
                    break;
                }
                n = 7;
                break;
            }
            case 2092: {
                if (!s.equals("AM")) {
                    break;
                }
                n = 6;
                break;
            }
            case 2091: {
                if (!s.equals("AL")) {
                    break;
                }
                n = 5;
                break;
            }
            case 2088: {
                if (!s.equals("AI")) {
                    break;
                }
                n = 4;
                break;
            }
            case 2086: {
                if (!s.equals("AG")) {
                    break;
                }
                n = 3;
                break;
            }
            case 2085: {
                if (!s.equals("AF")) {
                    break;
                }
                n = 2;
                break;
            }
            case 2084: {
                if (!s.equals("AE")) {
                    break;
                }
                n = 1;
                break;
            }
            case 2083: {
                if (!s.equals("AD")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return new int[] { 2, 2, 2, 2, 2, 2 };
            }
            case 235: {
                return new int[] { 3, 3, 4, 2, 2, 2 };
            }
            case 234: {
                return new int[] { 3, 2, 2, 1, 1, 2 };
            }
            case 230: {
                return new int[] { 3, 1, 3, 1, 2, 2 };
            }
            case 227: {
                return new int[] { 0, 3, 3, 4, 2, 2 };
            }
            case 225: {
                return new int[] { 2, 2, 1, 1, 2, 2 };
            }
            case 221: {
                return new int[] { 2, 2, 3, 4, 2, 2 };
            }
            case 219: {
                return new int[] { 1, 0, 2, 2, 3, 1 };
            }
            case 216: {
                return new int[] { 3, 4, 3, 2, 2, 2 };
            }
            case 213: {
                return new int[] { 1, 4, 1, 3, 2, 2 };
            }
            case 212: {
                return new int[] { 1, 1, 0, 0, 2, 2 };
            }
            case 207: {
                return new int[] { 2, 2, 2, 4, 2, 2 };
            }
            case 205: {
                return new int[] { 0, 2, 2, 3, 3, 4 };
            }
            case 201: {
                return new int[] { 3, 3, 3, 4, 2, 2 };
            }
            case 199:
            case 202: {
                return new int[] { 1, 2, 1, 0, 2, 2 };
            }
            case 197: {
                return new int[] { 2, 2, 1, 2, 2, 2 };
            }
            case 196: {
                return new int[] { 4, 3, 2, 3, 2, 2 };
            }
            case 195: {
                return new int[] { 2, 4, 3, 0, 2, 2 };
            }
            case 193: {
                return new int[] { 4, 4, 4, 3, 2, 2 };
            }
            case 191:
            case 218: {
                return new int[] { 3, 3, 4, 3, 2, 2 };
            }
            case 187: {
                return new int[] { 1, 1, 2, 2, 2, 1 };
            }
            case 184:
            case 209: {
                return new int[] { 4, 2, 1, 1, 2, 2 };
            }
            case 183: {
                return new int[] { 4, 2, 4, 3, 2, 2 };
            }
            case 182: {
                return new int[] { 3, 1, 1, 1, 2, 2 };
            }
            case 181: {
                return new int[] { 3, 4, 2, 0, 2, 2 };
            }
            case 180: {
                return new int[] { 1, 0, 0, 0, 4, 3 };
            }
            case 178: {
                return new int[] { 0, 0, 1, 2, 1, 2 };
            }
            case 176: {
                return new int[] { 2, 4, 4, 4, 4, 2 };
            }
            case 175: {
                return new int[] { 2, 2, 4, 1, 2, 2 };
            }
            case 173: {
                return new int[] { 3, 4, 1, 2, 2, 2 };
            }
            case 172: {
                return new int[] { 2, 0, 2, 1, 2, 1 };
            }
            case 168: {
                return new int[] { 2, 1, 3, 3, 3, 0 };
            }
            case 163: {
                return new int[] { 2, 3, 1, 3, 4, 2 };
            }
            case 162:
            case 170: {
                return new int[] { 1, 1, 2, 2, 4, 2 };
            }
            case 160:
            case 161: {
                return new int[] { 4, 2, 2, 1, 2, 2 };
            }
            case 159: {
                return new int[] { 2, 2, 4, 3, 2, 2 };
            }
            case 157: {
                return new int[] { 0, 2, 2, 3, 0, 3 };
            }
            case 156:
            case 164:
            case 198: {
                return new int[] { 2, 3, 3, 3, 2, 2 };
            }
            case 155: {
                return new int[] { 3, 4, 2, 1, 2, 2 };
            }
            case 153: {
                return new int[] { 3, 3, 4, 4, 2, 2 };
            }
            case 151: {
                return new int[] { 3, 1, 2, 1, 2, 2 };
            }
            case 150: {
                return new int[] { 1, 0, 3, 1, 3, 2 };
            }
            case 149: {
                return new int[] { 2, 4, 3, 4, 2, 2 };
            }
            case 148: {
                return new int[] { 4, 2, 3, 3, 2, 2 };
            }
            case 147: {
                return new int[] { 3, 4, 1, 4, 2, 2 };
            }
            case 146: {
                return new int[] { 3, 1, 1, 2, 2, 2 };
            }
            case 143:
            case 236: {
                return new int[] { 4, 2, 4, 4, 2, 2 };
            }
            case 140:
            case 141: {
                return new int[] { 0, 2, 4, 4, 2, 2 };
            }
            case 139: {
                return new int[] { 2, 0, 1, 2, 2, 2 };
            }
            case 138: {
                return new int[] { 2, 4, 2, 3, 2, 2 };
            }
            case 137:
            case 167: {
                return new int[] { 4, 3, 3, 2, 2, 2 };
            }
            case 136: {
                return new int[] { 1, 0, 0, 1, 3, 2 };
            }
            case 133:
            case 177: {
                return new int[] { 1, 2, 1, 2, 2, 2 };
            }
            case 132: {
                return new int[] { 2, 0, 0, 1, 2, 2 };
            }
            case 131:
            case 179: {
                return new int[] { 1, 0, 0, 0, 2, 2 };
            }
            case 130: {
                return new int[] { 0, 2, 2, 0, 2, 2 };
            }
            case 129: {
                return new int[] { 3, 3, 1, 1, 2, 2 };
            }
            case 126: {
                return new int[] { 1, 0, 3, 2, 1, 4 };
            }
            case 125: {
                return new int[] { 0, 0, 0, 0, 2, 2 };
            }
            case 124: {
                return new int[] { 3, 3, 2, 2, 2, 2 };
            }
            case 122: {
                return new int[] { 3, 1, 3, 3, 4, 2 };
            }
            case 119: {
                return new int[] { 3, 3, 2, 4, 2, 2 };
            }
            case 118: {
                return new int[] { 1, 2, 1, 3, 2, 2 };
            }
            case 117: {
                return new int[] { 2, 1, 2, 2, 2, 2 };
            }
            case 114: {
                return new int[] { 0, 1, 1, 3, 4, 4 };
            }
            case 109: {
                return new int[] { 2, 1, 4, 2, 2, 2 };
            }
            case 106: {
                return new int[] { 0, 1, 1, 2, 2, 4 };
            }
            case 105: {
                return new int[] { 2, 1, 1, 2, 2, 2 };
            }
            case 104: {
                return new int[] { 2, 4, 3, 2, 2, 2 };
            }
            case 103:
            case 233: {
                return new int[] { 4, 2, 2, 3, 2, 2 };
            }
            case 102: {
                return new int[] { 0, 0, 0, 1, 1, 2 };
            }
            case 100: {
                return new int[] { 3, 0, 1, 1, 4, 1 };
            }
            case 99: {
                return new int[] { 3, 2, 2, 3, 2, 2 };
            }
            case 98:
            case 135:
            case 214:
            case 229: {
                return new int[] { 4, 2, 2, 4, 2, 2 };
            }
            case 97: {
                return new int[] { 1, 1, 3, 2, 3, 3 };
            }
            case 96:
            case 217: {
                return new int[] { 0, 2, 1, 1, 2, 2 };
            }
            case 93: {
                return new int[] { 3, 1, 2, 2, 3, 2 };
            }
            case 92: {
                return new int[] { 0, 0, 0, 1, 3, 2 };
            }
            case 89: {
                return new int[] { 0, 1, 2, 3, 2, 0 };
            }
            case 88: {
                return new int[] { 3, 2, 2, 1, 2, 2 };
            }
            case 86:
            case 165: {
                return new int[] { 1, 2, 4, 4, 4, 2 };
            }
            case 85: {
                return new int[] { 2, 3, 2, 2, 2, 2 };
            }
            case 84:
            case 90:
            case 189: {
                return new int[] { 1, 0, 0, 0, 1, 2 };
            }
            case 83: {
                return new int[] { 4, 2, 1, 4, 2, 2 };
            }
            case 82:
            case 142: {
                return new int[] { 2, 1, 2, 3, 2, 2 };
            }
            case 81: {
                return new int[] { 4, 3, 4, 2, 2, 2 };
            }
            case 77:
            case 152:
            case 228: {
                return new int[] { 3, 3, 3, 2, 2, 2 };
            }
            case 76:
            case 226: {
                return new int[] { 0, 2, 0, 1, 2, 2 };
            }
            case 74: {
                return new int[] { 1, 1, 1, 2, 2, 2 };
            }
            case 72: {
                return new int[] { 0, 0, 1, 1, 1, 1 };
            }
            case 71:
            case 204: {
                return new int[] { 3, 4, 1, 0, 2, 2 };
            }
            case 70: {
                return new int[] { 1, 2, 3, 1, 0, 2 };
            }
            case 68: {
                return new int[] { 4, 2, 4, 1, 2, 2 };
            }
            case 67:
            case 107:
            case 113: {
                return new int[] { 3, 2, 2, 2, 2, 2 };
            }
            case 66: {
                return new int[] { 3, 1, 2, 2, 2, 2 };
            }
            case 65: {
                return new int[] { 0, 0, 0, 3, 0, 2 };
            }
            case 64: {
                return new int[] { 4, 3, 3, 1, 2, 2 };
            }
            case 63:
            case 94: {
                return new int[] { 0, 1, 1, 1, 2, 2 };
            }
            case 60:
            case 101:
            case 127:
            case 174:
            case 186:
            case 215: {
                return new int[] { 0, 0, 0, 0, 0, 2 };
            }
            case 59: {
                return new int[] { 2, 3, 2, 1, 2, 2 };
            }
            case 57: {
                return new int[] { 3, 4, 4, 4, 4, 2 };
            }
            case 55: {
                return new int[] { 0, 0, 3, 2, 0, 2 };
            }
            case 53: {
                return new int[] { 0, 1, 2, 2, 2, 3 };
            }
            case 52:
            case 158: {
                return new int[] { 0, 0, 2, 0, 1, 2 };
            }
            case 51:
            case 115: {
                return new int[] { 1, 0, 0, 0, 0, 2 };
            }
            case 48: {
                return new int[] { 2, 1, 0, 0, 2, 2 };
            }
            case 47:
            case 54:
            case 200:
            case 206:
            case 208: {
                return new int[] { 4, 3, 4, 4, 2, 2 };
            }
            case 46: {
                return new int[] { 2, 3, 4, 4, 2, 2 };
            }
            case 45: {
                return new int[] { 2, 3, 4, 3, 2, 2 };
            }
            case 44: {
                return new int[] { 2, 0, 1, 1, 3, 2 };
            }
            case 43: {
                return new int[] { 3, 3, 3, 3, 2, 2 };
            }
            case 42:
            case 95: {
                return new int[] { 1, 2, 2, 2, 3, 2 };
            }
            case 41:
            case 166: {
                return new int[] { 2, 2, 2, 1, 2, 2 };
            }
            case 40:
            case 58:
            case 123: {
                return new int[] { 3, 4, 4, 4, 2, 2 };
            }
            case 39: {
                return new int[] { 0, 0, 0, 1, 0, 2 };
            }
            case 38:
            case 61:
            case 87: {
                return new int[] { 3, 4, 3, 3, 2, 2 };
            }
            case 37:
            case 110: {
                return new int[] { 4, 2, 4, 2, 2, 2 };
            }
            case 36: {
                return new int[] { 4, 2, 3, 2, 2, 2 };
            }
            case 35: {
                return new int[] { 0, 2, 2, 2, 3, 2 };
            }
            case 34: {
                return new int[] { 2, 4, 2, 1, 2, 2 };
            }
            case 33: {
                return new int[] { 0, 1, 2, 3, 2, 2 };
            }
            case 32: {
                return new int[] { 3, 2, 1, 0, 2, 2 };
            }
            case 31: {
                return new int[] { 3, 1, 3, 2, 2, 2 };
            }
            case 30: {
                return new int[] { 4, 4, 2, 2, 2, 2 };
            }
            case 28: {
                return new int[] { 1, 2, 3, 2, 2, 2 };
            }
            case 27:
            case 49: {
                return new int[] { 2, 2, 0, 0, 2, 2 };
            }
            case 25:
            case 50:
            case 222: {
                return new int[] { 1, 2, 2, 2, 2, 2 };
            }
            case 24: {
                return new int[] { 4, 4, 3, 3, 2, 2 };
            }
            case 23:
            case 91:
            case 111:
            case 134:
            case 154:
            case 185:
            case 203:
            case 224:
            case 232: {
                return new int[] { 4, 4, 4, 4, 2, 2 };
            }
            case 22: {
                return new int[] { 1, 2, 1, 3, 4, 2 };
            }
            case 21:
            case 145:
            case 190: {
                return new int[] { 0, 0, 0, 0, 1, 2 };
            }
            case 20: {
                return new int[] { 4, 3, 4, 3, 2, 2 };
            }
            case 19: {
                return new int[] { 0, 1, 4, 4, 3, 2 };
            }
            case 18: {
                return new int[] { 2, 1, 3, 3, 2, 2 };
            }
            case 17:
            case 56:
            case 69:
            case 78: {
                return new int[] { 0, 2, 0, 0, 2, 2 };
            }
            case 16: {
                return new int[] { 1, 2, 1, 1, 2, 2 };
            }
            case 15:
            case 75:
            case 128:
            case 169:
            case 194:
            case 211: {
                return new int[] { 3, 2, 3, 3, 2, 2 };
            }
            case 14:
            case 121:
            case 144:
            case 171:
            case 192: {
                return new int[] { 0, 2, 2, 2, 2, 2 };
            }
            case 13: {
                return new int[] { 1, 3, 4, 4, 2, 2 };
            }
            case 12: {
                return new int[] { 0, 1, 1, 1, 2, 0 };
            }
            case 11: {
                return new int[] { 1, 0, 1, 1, 0, 0 };
            }
            case 10: {
                return new int[] { 2, 2, 3, 3, 2, 2 };
            }
            case 9:
            case 108:
            case 210:
            case 220: {
                return new int[] { 2, 1, 1, 1, 2, 2 };
            }
            case 8:
            case 62:
            case 188: {
                return new int[] { 4, 2, 2, 2, 2, 2 };
            }
            case 7: {
                return new int[] { 4, 4, 3, 2, 2, 2 };
            }
            case 6: {
                return new int[] { 2, 3, 2, 3, 2, 2 };
            }
            case 5:
            case 231: {
                return new int[] { 1, 1, 1, 1, 2, 2 };
            }
            case 4: {
                return new int[] { 0, 2, 0, 3, 2, 2 };
            }
            case 3: {
                return new int[] { 2, 4, 1, 2, 2, 2 };
            }
            case 2:
            case 80: {
                return new int[] { 4, 3, 3, 4, 2, 2 };
            }
            case 1: {
                return new int[] { 1, 4, 4, 4, 4, 0 };
            }
            case 0:
            case 26:
            case 29:
            case 73:
            case 79:
            case 112:
            case 116:
            case 120:
            case 223: {
                return new int[] { 1, 2, 0, 0, 2, 2 };
            }
        }
    }
    
    private long m(final int n) {
        Long n2;
        if ((n2 = (Long)this.a.get((Object)n)) == null) {
            n2 = (Long)this.a.get((Object)0);
        }
        Long value;
        if ((value = n2) == null) {
            value = 1000000L;
        }
        return value;
    }
    
    public static DefaultBandwidthMeter n(final Context context) {
        synchronized (DefaultBandwidthMeter.class) {
            if (DefaultBandwidthMeter.v == null) {
                DefaultBandwidthMeter.v = new Builder(context).a();
            }
            return DefaultBandwidthMeter.v;
        }
    }
    
    private static boolean o(final DataSpec dataSpec, final boolean b) {
        return b && !dataSpec.d(8);
    }
    
    private void p(final int n, final long n2, final long m) {
        if (n == 0 && n2 == 0L && m == this.m) {
            return;
        }
        this.m = m;
        this.b.c(n, n2, m);
    }
    
    private void q(int o) {
        synchronized (this) {
            final int i = this.i;
            if (i != 0 && !this.e) {
                return;
            }
            if (this.n) {
                o = this.o;
            }
            if (i == o) {
                return;
            }
            this.i = o;
            if (o != 1 && o != 0 && o != 8) {
                this.l = this.m(o);
                final long c = this.d.c();
                if (this.f > 0) {
                    o = (int)(c - this.g);
                }
                else {
                    o = 0;
                }
                this.p(o, this.h, this.l);
                this.g = c;
                this.h = 0L;
                this.k = 0L;
                this.j = 0L;
                this.c.i();
            }
        }
    }
    
    @Override
    public void b(final DataSource dataSource, final DataSpec dataSpec, final boolean b) {
        synchronized (this) {
            if (!o(dataSpec, b)) {
                return;
            }
            Assertions.g(this.f > 0);
            final long c = this.d.c();
            final int n = (int)(c - this.g);
            this.j += n;
            final long k = this.k;
            final long h = this.h;
            this.k = k + h;
            if (n > 0) {
                this.c.c((int)Math.sqrt((double)h), h * 8000.0f / n);
                if (this.j >= 2000L || this.k >= 524288L) {
                    this.l = (long)this.c.f(0.5f);
                }
                this.p(n, this.h, this.l);
                this.g = c;
                this.h = 0L;
            }
            --this.f;
        }
    }
    
    @Override
    public TransferListener c() {
        return this;
    }
    
    @Override
    public void d(final EventListener eventListener) {
        this.b.e(eventListener);
    }
    
    @Override
    public long e() {
        synchronized (this) {
            return this.l;
        }
    }
    
    @Override
    public void f(final DataSource dataSource, final DataSpec dataSpec, final boolean b, final int n) {
        synchronized (this) {
            if (!o(dataSpec, b)) {
                return;
            }
            this.h += n;
        }
    }
    
    @Override
    public void g(final Handler handler, final EventListener eventListener) {
        Assertions.e(handler);
        Assertions.e(eventListener);
        this.b.b(handler, eventListener);
    }
    
    @Override
    public void h(final DataSource dataSource, final DataSpec dataSpec, final boolean b) {
        synchronized (this) {
            if (!o(dataSpec, b)) {
                return;
            }
            if (this.f == 0) {
                this.g = this.d.c();
            }
            ++this.f;
        }
    }
    
    @Override
    public void i(final DataSource dataSource, final DataSpec dataSpec, final boolean b) {
    }
    
    public static final class Builder
    {
        private final Context a;
        private Map<Integer, Long> b;
        private int c;
        private Clock d;
        private boolean e;
        
        public Builder(final Context context) {
            Context applicationContext;
            if (context == null) {
                applicationContext = null;
            }
            else {
                applicationContext = context.getApplicationContext();
            }
            this.a = applicationContext;
            this.b = b(Util.N(context));
            this.c = 2000;
            this.d = Clock.a;
            this.e = true;
        }
        
        private static Map<Integer, Long> b(final String s) {
            final int[] k = DefaultBandwidthMeter.k(s);
            final HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            final ImmutableList<Long> p = DefaultBandwidthMeter.p;
            hashMap.put(2, p.get(k[0]));
            hashMap.put(3, ((List<Long>)DefaultBandwidthMeter.q).get(k[1]));
            hashMap.put(4, ((List<Long>)DefaultBandwidthMeter.r).get(k[2]));
            hashMap.put(5, ((List<Long>)DefaultBandwidthMeter.s).get(k[3]));
            hashMap.put(10, ((List<Long>)DefaultBandwidthMeter.t).get(k[4]));
            hashMap.put(9, ((List<Long>)DefaultBandwidthMeter.u).get(k[5]));
            hashMap.put(7, p.get(k[0]));
            return hashMap;
        }
        
        public DefaultBandwidthMeter a() {
            return new DefaultBandwidthMeter(this.a, this.b, this.c, this.d, this.e, null);
        }
    }
}
