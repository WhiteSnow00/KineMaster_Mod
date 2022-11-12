// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.nio.ShortBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import android.app.UiModeManager;
import android.os.Handler$Callback;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.io.Closeable;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Formatter;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import android.os.SystemClock;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Display$Mode;
import android.view.Display;
import android.view.WindowManager;
import android.hardware.display.DisplayManager;
import android.graphics.Point;
import android.telephony.TelephonyManager;
import android.os.Parcel;
import android.os.Looper;
import android.os.Handler;
import com.google.android.exoplayer2.ParserException;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.Player;
import java.util.Arrays;
import android.media.AudioManager;
import android.content.Context;
import com.google.common.base.Ascii;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import com.google.common.base.Charsets;
import java.util.Collection;
import java.util.ArrayDeque;
import java.util.List;
import java.util.regex.Matcher;
import android.net.Uri;
import java.util.MissingResourceException;
import android.text.TextUtils;
import java.util.Locale;
import android.os.Build;
import android.os.Build$VERSION;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class Util
{
    public static final int a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final byte[] f;
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    private static final Pattern j;
    private static HashMap<String, String> k;
    private static final String[] l;
    private static final String[] m;
    private static final int[] n;
    private static final int[] o;
    
    static {
        final int n2 = a = Build$VERSION.SDK_INT;
        final String s = b = Build.DEVICE;
        final String s2 = c = Build.MANUFACTURER;
        final String s3 = d = Build.MODEL;
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(", ");
        sb.append(s3);
        sb.append(", ");
        sb.append(s2);
        sb.append(", ");
        sb.append(n2);
        e = sb.toString();
        f = new byte[0];
        g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        i = Pattern.compile("%([A-Fa-f0-9]{2})");
        j = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        l = new String[] { "alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn" };
        m = new String[] { "i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn" };
        n = $d2j$hex$3e45107e$decode_I("00000000b71dc1046e3b8209d926430ddc7604136b6bc517b24d861a0550471eb8ed08260ff0c922d6d68a2f61cb4b2b649b0c35d386cd310aa08e3cbdbd4f3870db114cc7c6d0481ee09345a9fd5241acad155f1bb0d45bc2969756758b5652c836196a7f2bd86ea60d9b6311105a6714401d79a35ddc7d7a7b9f70cd665e74e0b6239857abe29c8e8da191399060953cc0278b8bdde68f52fba582e5e66486585b2bbeef46eaba3660a9b7817d68b3842d2fad3330eea9ea16ada45d0b6ca0906d32d42770f3d0fe56b0dd494b71d94c1b36c7fb06f7c32220b4ce953d75ca28803af29f9dfbf646bbb8fbf1a679fff4f63ee143ebffe59acdbce82dd07dec77708634c06d4730194b043dae56c539ab0682271c1b4323c53d002e7220c12acf9d8e1278804f16a1a60c1b16bbcd1f13eb8a01a4f64b057dd00808cacdc90c07ab9778b0b6567c69901571de8dd475dbdd936b6cc0526fb5e6116202fbd066bf469f5e085b5e5ad17d1d576660dc5363309b4dd42d5a490d0b1944ba16d84097c6a5ac20db64a8f9fd27a54ee0e6a14bb0a1bffcad60bb258b23b69296e2b22f2bad8a98366c8e41102f83f60dee87f35da9994440689d9d662b902a7bea94e71db4e0500075e4892636e93e3bf7ed3b6bb0f38c7671f7555032fae24df3fe5ff0bcc6e8ed7dc231cb3ecf86d6ffcb8386b8d5349b79d1edbd3adc5aa0fbd8eee00c6959fdcd6d80db8e6037c64f643296087a858bc97e5cad8a73ebb04b77560d044fe110c54b383686468f2b47428a7b005c3d66c158e4408255535d43519e3b1d252926dc21f0009f2c471d5e28424d1936f550d8322c769b3f9b6b5a3b26d6150391cbd40748ed970afff0560efaa011104dbdd014949b93192386521d0e562ff1b94beef5606dadf8d7706cfcd2202be2653deae6bc1ba9eb0b0668efb6bb27d701a6e6d3d880a5de6f9d64da6acd23c4ddd0e2c004f6a1cdb3eb60c97e8d3ebdc990ffb910b6bcb4a7ab7db0a2fb3aae15e6fbaaccc0b8a77bdd79a3c660369b717df79fa85bb4921f4675961a163288ad0bf38c742db081c330718599908a5d2e8d4b59f7ab085440b6c95045e68e4ef2fb4f4a2bdd0c479cc0cd43217d827b9660437f4f460072f85bc176fd0b86684a16476c93300461242dc565e94b9b115e565a1587701918306dd81c353d9f0282205e065b061d0bec1bdc0f51a69337e6bb52333f9d113e8880d03a8dd097243acd5620e3eb152d54f6d4297926a9c5ce3b68c1171d2bcca000eac8a550add6124d6cd2cb6b2fdf7c76eedbc1cba1e376d660e7aff023ea18ede2ee1dbda5f0aaa064f4738627f9c49be6fd09fdb889bee0798d67c63a80d0dbfb84d58bbc9a62967d9ebbb03e930cadff97b110b0af060d71abdf2b32a66836f3a26d66b4bcda7b75b8035d36b5b440f7b1");
        o = $d2j$hex$3e45107e$decode_I("00000000070000000e000000090000001c0000001b0000001200000015000000380000003f000000360000003100000024000000230000002a0000002d00000070000000770000007e000000790000006c0000006b0000006200000065000000480000004f000000460000004100000054000000530000005a0000005d000000e0000000e7000000ee000000e9000000fc000000fb000000f2000000f5000000d8000000df000000d6000000d1000000c4000000c3000000ca000000cd00000090000000970000009e000000990000008c0000008b0000008200000085000000a8000000af000000a6000000a1000000b4000000b3000000ba000000bd000000c7000000c0000000c9000000ce000000db000000dc000000d5000000d2000000ff000000f8000000f1000000f6000000e3000000e4000000ed000000ea000000b7000000b0000000b9000000be000000ab000000ac000000a5000000a20000008f00000088000000810000008600000093000000940000009d0000009a0000002700000020000000290000002e0000003b0000003c00000035000000320000001f00000018000000110000001600000003000000040000000d0000000a0000005700000050000000590000005e0000004b0000004c00000045000000420000006f00000068000000610000006600000073000000740000007d0000007a000000890000008e000000870000008000000095000000920000009b0000009c000000b1000000b6000000bf000000b8000000ad000000aa000000a3000000a4000000f9000000fe000000f7000000f0000000e5000000e2000000eb000000ec000000c1000000c6000000cf000000c8000000dd000000da000000d3000000d4000000690000006e000000670000006000000075000000720000007b0000007c00000051000000560000005f000000580000004d0000004a0000004300000044000000190000001e000000170000001000000005000000020000000b0000000c00000021000000260000002f000000280000003d0000003a00000033000000340000004e00000049000000400000004700000052000000550000005c0000005b0000007600000071000000780000007f0000006a0000006d00000064000000630000003e00000039000000300000003700000022000000250000002c0000002b0000000600000001000000080000000f0000001a0000001d0000001400000013000000ae000000a9000000a0000000a7000000b2000000b5000000bc000000bb0000009600000091000000980000009f0000008a0000008d0000008400000083000000de000000d9000000d0000000d7000000c2000000c5000000cc000000cb000000e6000000e1000000e8000000ef000000fa000000fd000000f4000000f3000000");
    }
    
    private Util() {
    }
    
    private static HashMap<String, String> A() {
        String[] array = Locale.getISOLanguages();
        final HashMap hashMap = new HashMap<String, String>(array.length + Util.l.length);
        final int length = array.length;
        final int n = 0;
        int n2 = 0;
    Label_0086_Outer:
        while (true) {
            int n3 = n;
        Label_0080_Outer:
            while (true) {
                if (n2 >= length) {
                    break Label_0086;
                }
                final String s = array[n2];
                while (true) {
                    try {
                        final String iso3Language = new Locale(s).getISO3Language();
                        if (!TextUtils.isEmpty((CharSequence)iso3Language)) {
                            hashMap.put(iso3Language, s);
                        }
                        ++n2;
                        continue Label_0086_Outer;
                        Label_0120: {
                            return (HashMap<String, String>)hashMap;
                        }
                        array = Util.l;
                        iftrue(Label_0120:)(n3 >= array.length);
                        hashMap.put(array[n3], array[n3 + 1]);
                        n3 += 2;
                        continue Label_0080_Outer;
                    }
                    catch (final MissingResourceException ex) {
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
    
    private static String A0(final String s) {
        int n = 0;
        while (true) {
            final String[] m = Util.m;
            if (n >= m.length) {
                return s;
            }
            if (s.startsWith(m[n])) {
                final StringBuilder sb = new StringBuilder();
                sb.append(m[n + 1]);
                sb.append(s.substring(m[n].length()));
                return sb.toString();
            }
            n += 2;
        }
    }
    
    public static Uri B(final Uri uri) {
        final String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        final Matcher matcher = Util.j.matcher(path);
        Uri withAppendedPath = uri;
        if (matcher.matches()) {
            withAppendedPath = uri;
            if (matcher.group(1) == null) {
                withAppendedPath = Uri.withAppendedPath(uri, "Manifest");
            }
        }
        return withAppendedPath;
    }
    
    public static <T> void B0(final List<T> list, final int n, int i, final int n2) {
        final ArrayDeque arrayDeque = new ArrayDeque();
        for (i = i - n - 1; i >= 0; --i) {
            arrayDeque.addFirst(list.remove(n + i));
        }
        list.addAll(Math.min(n2, list.size()), arrayDeque);
    }
    
    public static String C(final String s, final Object... array) {
        return String.format(Locale.US, s, array);
    }
    
    public static long C0(final long n) {
        long n2 = n;
        if (n != -9223372036854775807L) {
            if (n == Long.MIN_VALUE) {
                n2 = n;
            }
            else {
                n2 = n * 1000L;
            }
        }
        return n2;
    }
    
    public static String D(final byte[] array) {
        return new String(array, Charsets.c);
    }
    
    public static ExecutorService D0(final String s) {
        return Executors.newSingleThreadExecutor(new e(s));
    }
    
    public static String E(final byte[] array, final int n, final int n2) {
        return new String(array, n, n2, Charsets.c);
    }
    
    public static String E0(String string) {
        if (string == null) {
            return null;
        }
        final String replace = string.replace('_', '-');
        String s = string;
        if (!replace.isEmpty()) {
            if (replace.equals("und")) {
                s = string;
            }
            else {
                s = replace;
            }
        }
        final String e = Ascii.e(s);
        final String s2 = U0(e, "-")[0];
        if (Util.k == null) {
            Util.k = A();
        }
        final String s3 = Util.k.get(s2);
        String s4 = s2;
        string = e;
        if (s3 != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s3);
            sb.append(e.substring(s2.length()));
            string = sb.toString();
            s4 = s3;
        }
        if (!"no".equals(s4) && !"i".equals(s4)) {
            final String a0 = string;
            if (!"zh".equals(s4)) {
                return a0;
            }
        }
        return A0(string);
    }
    
    public static int F(final Context context) {
        final AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        int generateAudioSessionId;
        if (audioManager == null) {
            generateAudioSessionId = -1;
        }
        else {
            generateAudioSessionId = audioManager.generateAudioSessionId();
        }
        return generateAudioSessionId;
    }
    
    public static <T> T[] F0(final T[] array, final T t) {
        final T[] copy = Arrays.copyOf(array, array.length + 1);
        copy[array.length] = t;
        return k(copy);
    }
    
    public static int G(int a) {
        final int n = 0;
        if (a == 12) {
            a = n;
            if (Util.a >= 32) {
                a = 743676;
            }
            return a;
        }
        switch (a) {
            default: {
                return 0;
            }
            case 8: {
                a = Util.a;
                if (a >= 23) {
                    return 6396;
                }
                if (a >= 21) {
                    return 6396;
                }
                return 0;
            }
            case 7: {
                return 1276;
            }
            case 6: {
                return 252;
            }
            case 5: {
                return 220;
            }
            case 4: {
                return 204;
            }
            case 3: {
                return 28;
            }
            case 2: {
                return 12;
            }
            case 1: {
                return 4;
            }
        }
    }
    
    public static <T> T[] G0(final T[] array, final T[] array2) {
        final T[] copy = Arrays.copyOf(array, array.length + array2.length);
        System.arraycopy(array2, 0, copy, array.length, array2.length);
        return copy;
    }
    
    public static Player.Commands H(final Player player, final Player.Commands commands) {
        final boolean e = player.e();
        final boolean v = player.V();
        final boolean m = player.M();
        final boolean q = player.q();
        final boolean i0 = player.i0();
        final boolean u = player.u();
        final boolean u2 = player.w().u();
        final Player.Commands.Builder d = new Player.Commands.Builder().b(commands).d(4, e ^ true);
        final boolean b = false;
        final Player.Commands.Builder d2 = d.d(5, v && !e).d(6, m && !e).d(7, !u2 && (m || !i0 || v) && !e).d(8, q && !e).d(9, !u2 && (q || (i0 && u)) && !e).d(10, e ^ true).d(11, v && !e);
        boolean b2 = b;
        if (v) {
            b2 = b;
            if (!e) {
                b2 = true;
            }
        }
        return d2.d(12, b2).e();
    }
    
    public static <T> T[] H0(final T[] array, final int n) {
        Assertions.a(n <= array.length);
        return Arrays.copyOf(array, n);
    }
    
    public static int I(final ByteBuffer byteBuffer, int n) {
        n = byteBuffer.getInt(n);
        if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
            n = Integer.reverseBytes(n);
        }
        return n;
    }
    
    public static <T> T[] I0(final T[] array, final int n, final int n2) {
        final boolean b = true;
        Assertions.a(n >= 0);
        Assertions.a(n2 <= array.length && b);
        return Arrays.copyOfRange(array, n, n2);
    }
    
    public static byte[] J(final String s) {
        final int n = s.length() / 2;
        final byte[] array = new byte[n];
        for (int i = 0; i < n; ++i) {
            final int n2 = i * 2;
            array[i] = (byte)((Character.digit(s.charAt(n2), 16) << 4) + Character.digit(s.charAt(n2 + 1), 16));
        }
        return array;
    }
    
    public static long J0(String group) throws ParserException {
        final Matcher matcher = Util.g.matcher(group);
        if (matcher.matches()) {
            group = matcher.group(9);
            int n = 0;
            if (group != null) {
                if (!matcher.group(9).equalsIgnoreCase("Z")) {
                    final int n2 = n = Integer.parseInt(matcher.group(12)) * 60 + Integer.parseInt(matcher.group(13));
                    if ("-".equals(matcher.group(11))) {
                        n = n2 * -1;
                    }
                }
            }
            final GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty((CharSequence)matcher.group(8))) {
                final StringBuilder sb = new StringBuilder();
                sb.append("0.");
                sb.append(matcher.group(8));
                gregorianCalendar.set(14, new BigDecimal(sb.toString()).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (n != 0) {
                timeInMillis -= n * 60000L;
            }
            return timeInMillis;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid date/time format: ");
        sb2.append(group);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }
    
    public static int K(final String s, final int n) {
        final String[] v0 = V0(s);
        final int length = v0.length;
        int i = 0;
        int n2 = 0;
        while (i < length) {
            int n3 = n2;
            if (n == MimeTypes.m(v0[i])) {
                n3 = n2 + 1;
            }
            ++i;
            n2 = n3;
        }
        return n2;
    }
    
    public static long K0(String s) {
        final Matcher matcher = Util.h.matcher(s);
        if (matcher.matches()) {
            final boolean empty = TextUtils.isEmpty((CharSequence)matcher.group(1));
            s = matcher.group(3);
            double double1 = 0.0;
            double n;
            if (s != null) {
                n = Double.parseDouble(s) * 3.1556908E7;
            }
            else {
                n = 0.0;
            }
            s = matcher.group(5);
            double n2;
            if (s != null) {
                n2 = Double.parseDouble(s) * 2629739.0;
            }
            else {
                n2 = 0.0;
            }
            s = matcher.group(7);
            double n3;
            if (s != null) {
                n3 = Double.parseDouble(s) * 86400.0;
            }
            else {
                n3 = 0.0;
            }
            s = matcher.group(10);
            double n4;
            if (s != null) {
                n4 = Double.parseDouble(s) * 3600.0;
            }
            else {
                n4 = 0.0;
            }
            s = matcher.group(12);
            double n5;
            if (s != null) {
                n5 = Double.parseDouble(s) * 60.0;
            }
            else {
                n5 = 0.0;
            }
            s = matcher.group(14);
            if (s != null) {
                double1 = Double.parseDouble(s);
            }
            long n6 = (long)((n + n2 + n3 + n4 + n5 + double1) * 1000.0);
            if (true ^ empty) {
                n6 = -n6;
            }
            return n6;
        }
        return (long)(Double.parseDouble(s) * 3600.0 * 1000.0);
    }
    
    public static String L(String string, final int n) {
        final String[] v0 = V0(string);
        final int length = v0.length;
        string = null;
        if (length == 0) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (final String s : v0) {
            if (n == MimeTypes.m(s)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(s);
            }
        }
        if (sb.length() > 0) {
            string = sb.toString();
        }
        return string;
    }
    
    public static boolean L0(final Handler handler, final Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        return handler.post(runnable);
    }
    
    public static String M(final Object[] array) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(array[i].getClass().getSimpleName());
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    public static boolean M0(final Parcel parcel) {
        return parcel.readInt() != 0;
    }
    
    public static String N(final Context context) {
        if (context != null) {
            final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
            if (telephonyManager != null) {
                final String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (!TextUtils.isEmpty((CharSequence)networkCountryIso)) {
                    return Ascii.g(networkCountryIso);
                }
            }
        }
        return Ascii.g(Locale.getDefault().getCountry());
    }
    
    public static <T> void N0(final List<T> list, final int n, final int n2) {
        if (n >= 0 && n2 <= list.size() && n <= n2) {
            if (n != n2) {
                list.subList(n, n2).clear();
            }
            return;
        }
        throw new IllegalArgumentException();
    }
    
    public static Point O(final Context context) {
        Display display = null;
        Label_0034: {
            if (Util.a >= 17) {
                final DisplayManager displayManager = (DisplayManager)context.getSystemService("display");
                if (displayManager != null) {
                    display = displayManager.getDisplay(0);
                    break Label_0034;
                }
            }
            display = null;
        }
        Display defaultDisplay = display;
        if (display == null) {
            defaultDisplay = Assertions.e(context.getSystemService("window")).getDefaultDisplay();
        }
        return P(context, defaultDisplay);
    }
    
    public static long O0(final long n, final long n2, final long n3) {
        final long n4 = lcmp(n3, n2);
        if (n4 >= 0 && n3 % n2 == 0L) {
            return n / (n3 / n2);
        }
        if (n4 < 0 && n2 % n3 == 0L) {
            return n * (n2 / n3);
        }
        return (long)(n * (n2 / (double)n3));
    }
    
    public static Point P(Context context, final Display display) {
        Label_0195: {
            if (display.getDisplayId() != 0 || !x0(context)) {
                break Label_0195;
            }
            String s;
            if (Util.a < 28) {
                s = l0("sys.display-size");
            }
            else {
                s = l0("vendor.display-size");
            }
            Label_0144: {
                if (TextUtils.isEmpty((CharSequence)s)) {
                    break Label_0144;
                }
                while (true) {
                    try {
                        final String[] t0 = T0(s.trim(), "x");
                        if (t0.length == 2) {
                            final int int1 = Integer.parseInt(t0[0]);
                            final int int2 = Integer.parseInt(t0[1]);
                            if (int1 > 0 && int2 > 0) {
                                return new Point(int1, int2);
                            }
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid display size: ");
                        sb.append(s);
                        Log.c("Util", sb.toString());
                        if ("Sony".equals(Util.c) && Util.d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                            return new Point(3840, 2160);
                        }
                        context = (Context)new Point();
                        final int a = Util.a;
                        if (a >= 23) {
                            U(display, (Point)context);
                        }
                        else if (a >= 17) {
                            T(display, (Point)context);
                        }
                        else {
                            S(display, (Point)context);
                        }
                        return (Point)context;
                    }
                    catch (final NumberFormatException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    public static long[] P0(final List<Long> list, long n, final long n2) {
        final int size = list.size();
        final long[] array = new long[size];
        final long n3 = lcmp(n2, n);
        int i = 0;
        final int n4 = 0;
        final int n5 = 0;
        if (n3 >= 0 && n2 % n == 0L) {
            n = n2 / n;
            for (int j = n5; j < size; ++j) {
                array[j] = (long)list.get(j) / n;
            }
        }
        else if (n3 < 0 && n % n2 == 0L) {
            n /= n2;
            while (i < size) {
                array[i] = (long)list.get(i) * n;
                ++i;
            }
        }
        else {
            final double n6 = n / (double)n2;
            for (int k = n4; k < size; ++k) {
                array[k] = (long)((long)list.get(k) * n6);
            }
        }
        return array;
    }
    
    public static Looper Q() {
        Looper looper = Looper.myLooper();
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        return looper;
    }
    
    public static void Q0(final long[] array, long n, final long n2) {
        final long n3 = lcmp(n2, n);
        final int n4 = 0;
        int i = 0;
        final int n5 = 0;
        if (n3 >= 0 && n2 % n == 0L) {
            n = n2 / n;
            for (int j = n5; j < array.length; ++j) {
                array[j] /= n;
            }
        }
        else if (n3 < 0 && n % n2 == 0L) {
            n /= n2;
            for (int k = n4; k < array.length; ++k) {
                array[k] *= n;
            }
        }
        else {
            final double n6 = n / (double)n2;
            while (i < array.length) {
                array[i] *= (long)n6;
                ++i;
            }
        }
    }
    
    public static Locale R() {
        Locale locale;
        if (Util.a >= 24) {
            locale = Locale.getDefault(Locale.Category.DISPLAY);
        }
        else {
            locale = Locale.getDefault();
        }
        return locale;
    }
    
    public static void R0(final Throwable t) {
        S0(t);
    }
    
    private static void S(final Display display, final Point point) {
        display.getSize(point);
    }
    
    private static <T extends Throwable> void S0(final Throwable t) throws T, Throwable {
        throw t;
    }
    
    private static void T(final Display display, final Point point) {
        display.getRealSize(point);
    }
    
    public static String[] T0(final String s, final String s2) {
        return s.split(s2, -1);
    }
    
    private static void U(final Display display, final Point point) {
        final Display$Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }
    
    public static String[] U0(final String s, final String s2) {
        return s.split(s2, 2);
    }
    
    public static int V(final int n) {
        if (n != 2 && n != 4) {
            if (n != 10) {
                if (n != 7) {
                    if (n != 8) {
                        switch (n) {
                            default: {
                                switch (n) {
                                    default: {
                                        return 6006;
                                    }
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28: {
                                        return 6002;
                                    }
                                }
                                break;
                            }
                            case 15: {
                                break;
                            }
                            case 17:
                            case 19:
                            case 20:
                            case 21:
                            case 22: {
                                return 6004;
                            }
                            case 16:
                            case 18: {
                                return 6005;
                            }
                        }
                    }
                    return 6003;
                }
                return 6005;
            }
            return 6004;
        }
        return 6005;
    }
    
    public static String[] V0(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return new String[0];
        }
        return T0(s.trim(), "(\\s*,\\s*)");
    }
    
    public static int W(String s) {
        int int1 = 0;
        if (s == null) {
            return 0;
        }
        final String[] t0 = T0(s, "_");
        final int length = t0.length;
        if (length < 2) {
            return 0;
        }
        s = t0[length - 1];
        boolean b;
        if (length >= 3 && "neg".equals(t0[length - 2])) {
            b = true;
        }
        else {
            b = false;
        }
        try {
            int1 = Integer.parseInt(Assertions.e(s));
            if (b) {
                int1 = -int1;
            }
            return int1;
        }
        catch (final NumberFormatException ex) {
            return int1;
        }
    }
    
    public static ComponentName W0(final Context context, final Intent intent) {
        if (Util.a >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }
    
    public static String X(final int n) {
        if (n == 0) {
            return "NO";
        }
        if (n == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (n == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (n == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (n == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }
    
    public static long X0(final long n, final long n2, final long n3) {
        final long n4 = n - n2;
        if (((n ^ n4) & (n2 ^ n)) < 0L) {
            return n3;
        }
        return n4;
    }
    
    public static String Y(final Locale locale) {
        String s;
        if (Util.a >= 21) {
            s = Z(locale);
        }
        else {
            s = locale.toString();
        }
        return s;
    }
    
    public static boolean Y0(final SQLiteDatabase sqLiteDatabase, final String s) {
        boolean b = true;
        if (DatabaseUtils.queryNumEntries(sqLiteDatabase, "sqlite_master", "tbl_name = ?", new String[] { s }) <= 0L) {
            b = false;
        }
        return b;
    }
    
    private static String Z(final Locale locale) {
        return locale.toLanguageTag();
    }
    
    public static byte[] Z0(final InputStream inputStream) throws IOException {
        final byte[] array = new byte[4096];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(array, 0, read);
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    public static Thread a(final String s, final Runnable runnable) {
        return y0(s, runnable);
    }
    
    public static long a0(final long n, final float n2) {
        if (n2 == 1.0f) {
            return n;
        }
        return Math.round(n * (double)n2);
    }
    
    public static String a1(final byte[] array) {
        final StringBuilder sb = new StringBuilder(array.length * 2);
        for (int i = 0; i < array.length; ++i) {
            sb.append(Character.forDigit(array[i] >> 4 & 0xF, 16));
            sb.append(Character.forDigit(array[i] & 0xF, 16));
        }
        return sb.toString();
    }
    
    public static long b(final long n, final long n2, final long n3) {
        final long n4 = n + n2;
        if (((n ^ n4) & (n2 ^ n4)) < 0L) {
            return n3;
        }
        return n4;
    }
    
    public static long b0(long currentTimeMillis) {
        if (currentTimeMillis == -9223372036854775807L) {
            currentTimeMillis = System.currentTimeMillis();
        }
        else {
            currentTimeMillis += SystemClock.elapsedRealtime();
        }
        return currentTimeMillis;
    }
    
    public static long b1(final int n, final int n2) {
        return c1(n2) | c1(n) << 32;
    }
    
    public static boolean c(final Object o, final Object o2) {
        boolean equals;
        if (o == null) {
            equals = (o2 == null);
        }
        else {
            equals = o.equals(o2);
        }
        return equals;
    }
    
    public static int c0(final int n) {
        if (n == 8) {
            return 3;
        }
        if (n == 16) {
            return 2;
        }
        if (n == 24) {
            return 536870912;
        }
        if (n != 32) {
            return 0;
        }
        return 805306368;
    }
    
    public static long c1(final int n) {
        return (long)n & 0xFFFFFFFFL;
    }
    
    public static <T extends Comparable<? super T>> int d(final List<? extends Comparable<? super T>> list, final T t, final boolean b, final boolean b2) {
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            binarySearch ^= -1;
        }
        else {
            while (++binarySearch < list.size() && ((Comparable<T>)list.get(binarySearch)).compareTo(t) == 0) {}
            if (b) {
                --binarySearch;
            }
        }
        int min = binarySearch;
        if (b2) {
            min = Math.min(list.size() - 1, binarySearch);
        }
        return min;
    }
    
    public static Format d0(final int n, final int n2, final int n3) {
        return new Format.Builder().e0("audio/raw").H(n2).f0(n3).Y(n).E();
    }
    
    public static CharSequence d1(CharSequence subSequence, final int n) {
        if (subSequence.length() > n) {
            subSequence = subSequence.subSequence(0, n);
        }
        return subSequence;
    }
    
    public static int e(final long[] array, final long n, final boolean b, final boolean b2) {
        int binarySearch;
        final int n2 = binarySearch = Arrays.binarySearch(array, n);
        if (n2 < 0) {
            binarySearch = ~n2;
        }
        else {
            while (++binarySearch < array.length && array[binarySearch] == n) {}
            if (b) {
                --binarySearch;
            }
        }
        int min = binarySearch;
        if (b2) {
            min = Math.min(array.length - 1, binarySearch);
        }
        return min;
    }
    
    public static int e0(final int n, final int n2) {
        if (n != 2) {
            int n3 = n2;
            if (n != 3) {
                if (n != 4) {
                    if (n == 268435456) {
                        return n2 * 2;
                    }
                    if (n == 536870912) {
                        return n2 * 3;
                    }
                    if (n != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
                n3 = n2 * 4;
            }
            return n3;
        }
        return n2 * 2;
    }
    
    public static String e1(final String s) {
        final int length = s.length();
        final int n = 0;
        int i = 0;
        int n2 = 0;
        while (i < length) {
            int n3 = n2;
            if (s.charAt(i) == '%') {
                n3 = n2 + 1;
            }
            ++i;
            n2 = n3;
        }
        if (n2 == 0) {
            return s;
        }
        final int n4 = length - n2 * 2;
        final StringBuilder sb = new StringBuilder(n4);
        final Matcher matcher = Util.i.matcher(s);
        int end = n;
        while (n2 > 0 && matcher.find()) {
            final char c = (char)Integer.parseInt(Assertions.e(matcher.group(1)), 16);
            sb.append(s, end, matcher.start());
            sb.append(c);
            end = matcher.end();
            --n2;
        }
        if (end < length) {
            sb.append(s, end, length);
        }
        if (sb.length() != n4) {
            return null;
        }
        return sb.toString();
    }
    
    public static int f(final LongArray longArray, final long n, final boolean b, final boolean b2) {
        int n2 = longArray.c() - 1;
        final int n3 = 0;
        int i = 0;
        while (i <= n2) {
            final int n4 = i + n2 >>> 1;
            if (longArray.b(n4) < n) {
                i = n4 + 1;
            }
            else {
                n2 = n4 - 1;
            }
        }
        if (b) {
            final int n5 = n2 + 1;
            if (n5 < longArray.c() && longArray.b(n5) == n) {
                n2 = n5;
                return n2;
            }
        }
        if (b2 && n2 == -1) {
            n2 = n3;
        }
        return n2;
    }
    
    public static long f0(final long n, final float n2) {
        if (n2 == 1.0f) {
            return n;
        }
        return Math.round(n / (double)n2);
    }
    
    public static long f1(final long n) {
        long n2 = n;
        if (n != -9223372036854775807L) {
            if (n == Long.MIN_VALUE) {
                n2 = n;
            }
            else {
                n2 = n / 1000L;
            }
        }
        return n2;
    }
    
    public static <T extends Comparable<? super T>> int g(final List<? extends Comparable<? super T>> list, final T t, final boolean b, final boolean b2) {
        int binarySearch;
        final int n = binarySearch = Collections.binarySearch(list, t);
        if (n < 0) {
            binarySearch = -(n + 2);
        }
        else {
            while (--binarySearch >= 0 && ((Comparable)list.get(binarySearch)).compareTo(t) == 0) {}
            if (b) {
                ++binarySearch;
            }
        }
        int max = binarySearch;
        if (b2) {
            max = Math.max(0, binarySearch);
        }
        return max;
    }
    
    public static int g0(final int n) {
        if (n == 13) {
            return 1;
        }
        switch (n) {
            default: {
                return 3;
            }
            case 6: {
                return 2;
            }
            case 5:
            case 7:
            case 8:
            case 9:
            case 10: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 0;
            }
        }
    }
    
    public static void g1(final Parcel parcel, final boolean b) {
        parcel.writeInt((int)(b ? 1 : 0));
    }
    
    public static int h(final int[] array, int n, final boolean b, final boolean b2) {
        int binarySearch;
        final int n2 = binarySearch = Arrays.binarySearch(array, n);
        if (n2 < 0) {
            n = -(n2 + 2);
        }
        else {
            while (--binarySearch >= 0 && array[binarySearch] == n) {}
            if (b) {
                n = binarySearch + 1;
            }
            else {
                n = binarySearch;
            }
        }
        int max = n;
        if (b2) {
            max = Math.max(0, n);
        }
        return max;
    }
    
    public static String h0(final StringBuilder sb, final Formatter formatter, long n) {
        long n2 = n;
        if (n == -9223372036854775807L) {
            n2 = 0L;
        }
        String s;
        if (n2 < 0L) {
            s = "-";
        }
        else {
            s = "";
        }
        final long n3 = (Math.abs(n2) + 500L) / 1000L;
        n = n3 % 60L;
        final long n4 = n3 / 60L % 60L;
        final long n5 = n3 / 3600L;
        sb.setLength(0);
        String s2;
        if (n5 > 0L) {
            s2 = formatter.format("%s%d:%02d:%02d", s, n5, n4, n).toString();
        }
        else {
            s2 = formatter.format("%s%02d:%02d", s, n4, n).toString();
        }
        return s2;
    }
    
    public static int i(final long[] array, final long n, final boolean b, final boolean b2) {
        int binarySearch;
        final int n2 = binarySearch = Arrays.binarySearch(array, n);
        if (n2 < 0) {
            binarySearch = -(n2 + 2);
        }
        else {
            while (--binarySearch >= 0 && array[binarySearch] == n) {}
            if (b) {
                ++binarySearch;
            }
        }
        int max = binarySearch;
        if (b2) {
            max = Math.max(0, binarySearch);
        }
        return max;
    }
    
    public static String[] i0() {
        final String[] j0 = j0();
        for (int i = 0; i < j0.length; ++i) {
            j0[i] = E0(j0[i]);
        }
        return j0;
    }
    
    public static <T> T j(final T t) {
        return t;
    }
    
    private static String[] j0() {
        final Configuration configuration = Resources.getSystem().getConfiguration();
        String[] k0;
        if (Util.a >= 24) {
            k0 = k0(configuration);
        }
        else {
            k0 = new String[] { Y(configuration.locale) };
        }
        return k0;
    }
    
    public static <T> T[] k(final T[] array) {
        return array;
    }
    
    private static String[] k0(final Configuration configuration) {
        return T0(configuration.getLocales().toLanguageTags(), ",");
    }
    
    public static int l(final int n, final int n2) {
        return (n + n2 - 1) / n2;
    }
    
    private static String l0(final String s) {
        try {
            final Class<?> forName = Class.forName("android.os.SystemProperties");
            return (String)forName.getMethod("get", String.class).invoke(forName, s);
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to read system property ");
            sb.append(s);
            Log.d("Util", sb.toString(), ex);
            return null;
        }
    }
    
    public static long m(final long n, final long n2) {
        return (n + n2 - 1L) / n2;
    }
    
    public static String m0(final int n) {
        switch (n) {
            default: {
                String string;
                if (n >= 10000) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("custom (");
                    sb.append(n);
                    sb.append(")");
                    string = sb.toString();
                }
                else {
                    string = "?";
                }
                return string;
            }
            case 6: {
                return "camera motion";
            }
            case 5: {
                return "metadata";
            }
            case 4: {
                return "image";
            }
            case 3: {
                return "text";
            }
            case 2: {
                return "video";
            }
            case 1: {
                return "audio";
            }
            case 0: {
                return "default";
            }
            case -1: {
                return "unknown";
            }
            case -2: {
                return "none";
            }
        }
    }
    
    public static void n(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (final IOException ex) {}
    }
    
    public static byte[] n0(final String s) {
        return s.getBytes(Charsets.c);
    }
    
    public static int o(final long n, final long n2) {
        final long n3 = lcmp(n, n2);
        int n4;
        if (n3 < 0) {
            n4 = -1;
        }
        else if (n3 == 0) {
            n4 = 0;
        }
        else {
            n4 = 1;
        }
        return n4;
    }
    
    public static int o0(final Uri uri) {
        final String scheme = uri.getScheme();
        if (scheme != null && Ascii.a((CharSequence)"rtsp", (CharSequence)scheme)) {
            return 3;
        }
        final String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        final int lastIndex = lastPathSegment.lastIndexOf(46);
        if (lastIndex >= 0) {
            final int p = p0(lastPathSegment.substring(lastIndex + 1));
            if (p != 4) {
                return p;
            }
        }
        final Matcher matcher = Util.j.matcher(Assertions.e(uri.getPath()));
        if (matcher.matches()) {
            final String group = matcher.group(2);
            if (group != null) {
                if (group.contains("format=mpd-time-csf")) {
                    return 0;
                }
                if (group.contains("format=m3u8-aapl")) {
                    return 2;
                }
            }
            return 1;
        }
        return 4;
    }
    
    public static float p(final float n, final float n2, final float n3) {
        return Math.max(n2, Math.min(n, n3));
    }
    
    public static int p0(String e) {
        e = Ascii.e(e);
        e.hashCode();
        final int hashCode = e.hashCode();
        int n = -1;
        switch (hashCode) {
            case 3299913: {
                if (!e.equals("m3u8")) {
                    break;
                }
                n = 3;
                break;
            }
            case 3242057: {
                if (!e.equals("isml")) {
                    break;
                }
                n = 2;
                break;
            }
            case 108321: {
                if (!e.equals("mpd")) {
                    break;
                }
                n = 1;
                break;
            }
            case 104579: {
                if (!e.equals("ism")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return 4;
            }
            case 3: {
                return 2;
            }
            case 1: {
                return 0;
            }
            case 0:
            case 2: {
                return 1;
            }
        }
    }
    
    public static int q(final int n, final int n2, final int n3) {
        return Math.max(n2, Math.min(n, n3));
    }
    
    public static int q0(final Uri uri, final String s) {
        if (s == null) {
            return o0(uri);
        }
        int n = -1;
        switch (s) {
            case "application/x-rtsp": {
                n = 3;
                break;
            }
            case "application/dash+xml": {
                n = 2;
                break;
            }
            case "application/vnd.ms-sstr+xml": {
                n = 1;
                break;
            }
            case "application/x-mpegURL": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 0: {
                return 2;
            }
        }
    }
    
    public static long r(final long n, final long n2, final long n3) {
        return Math.max(n2, Math.min(n, n3));
    }
    
    public static boolean r0(final ParsableByteArray parsableByteArray, final ParsableByteArray parsableByteArray2, final Inflater inflater) {
        if (parsableByteArray.a() <= 0) {
            return false;
        }
        if (parsableByteArray2.b() < parsableByteArray.a()) {
            parsableByteArray2.c(parsableByteArray.a() * 2);
        }
        Inflater inflater2;
        if ((inflater2 = inflater) == null) {
            inflater2 = new Inflater();
        }
        inflater2.setInput(parsableByteArray.d(), parsableByteArray.e(), parsableByteArray.a());
        int n = 0;
        try {
            while (true) {
                final int n2 = n + inflater2.inflate(parsableByteArray2.d(), n, parsableByteArray2.b() - n);
                if (inflater2.finished()) {
                    parsableByteArray2.O(n2);
                    return true;
                }
                if (inflater2.needsDictionary() || inflater2.needsInput()) {
                    return false;
                }
                if ((n = n2) != parsableByteArray2.b()) {
                    continue;
                }
                parsableByteArray2.c(parsableByteArray2.b() * 2);
                n = n2;
            }
        }
        catch (final DataFormatException ex) {
            return false;
        }
        finally {
            inflater2.reset();
        }
    }
    
    public static boolean s(final Object[] array, final Object o) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (c(array[i], o)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean s0(final Context context) {
        return Util.a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }
    
    public static int t(final byte[] array, int i, final int n, int n2) {
        while (i < n) {
            n2 = (Util.n[(n2 >>> 24 ^ (array[i] & 0xFF)) & 0xFF] ^ n2 << 8);
            ++i;
        }
        return n2;
    }
    
    public static boolean t0(final int n) {
        return n == 536870912 || n == 805306368 || n == 4;
    }
    
    public static int u(final byte[] array, int i, final int n, int n2) {
        while (i < n) {
            n2 = Util.o[n2 ^ (array[i] & 0xFF)];
            ++i;
        }
        return n2;
    }
    
    public static boolean u0(final int n) {
        return n == 3 || n == 2 || n == 268435456 || n == 536870912 || n == 805306368 || n == 4;
    }
    
    public static Handler v(final Looper looper, final Handler$Callback handler$Callback) {
        return new Handler(looper, handler$Callback);
    }
    
    public static boolean v0(final int n) {
        return n == 10 || n == 13;
    }
    
    public static Handler w() {
        return x(null);
    }
    
    public static boolean w0(final Uri uri) {
        final String scheme = uri.getScheme();
        return TextUtils.isEmpty((CharSequence)scheme) || "file".equals(scheme);
    }
    
    public static Handler x(final Handler$Callback handler$Callback) {
        return v(Assertions.i(Looper.myLooper()), handler$Callback);
    }
    
    public static boolean x0(final Context context) {
        final UiModeManager uiModeManager = (UiModeManager)context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }
    
    public static Handler y() {
        return z(null);
    }
    
    private static Thread y0(final String s, final Runnable runnable) {
        return new Thread(runnable, s);
    }
    
    public static Handler z(final Handler$Callback handler$Callback) {
        return v(Q(), handler$Callback);
    }
    
    public static int z0(final int[] array, final int n) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    private static long[] $d2j$hex$3e45107e$decode_J(final String src) {
        final byte[] d = $d2j$hex$3e45107e$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final LongBuffer s = b.asLongBuffer();
        final long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }
    
    private static int[] $d2j$hex$3e45107e$decode_I(final String src) {
        final byte[] d = $d2j$hex$3e45107e$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final IntBuffer s = b.asIntBuffer();
        final int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }
    
    private static short[] $d2j$hex$3e45107e$decode_S(final String src) {
        final byte[] d = $d2j$hex$3e45107e$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final ShortBuffer s = b.asShortBuffer();
        final short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }
    
    private static byte[] $d2j$hex$3e45107e$decode_B(final String src) {
        final char[] d = src.toCharArray();
        final byte[] ret = new byte[src.length() / 2];
        for (int i = 0; i < ret.length; ++i) {
            final char h = d[2 * i];
            final char l = d[2 * i + 1];
            int hh;
            if (h >= '0' && h <= '9') {
                hh = h - '0';
            }
            else if (h >= 'a' && h <= 'f') {
                hh = h - 'a' + 10;
            }
            else {
                if (h < 'A' || h > 'F') {
                    throw new RuntimeException();
                }
                hh = h - 'A' + 10;
            }
            int ll;
            if (l >= '0' && l <= '9') {
                ll = l - '0';
            }
            else if (l >= 'a' && l <= 'f') {
                ll = l - 'a' + 10;
            }
            else {
                if (l < 'A' || l > 'F') {
                    throw new RuntimeException();
                }
                ll = l - 'A' + 10;
            }
            ret[i] = (byte)(hh << 4 | ll);
        }
        return ret;
    }
}
