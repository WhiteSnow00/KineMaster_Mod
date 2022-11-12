// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import java.util.Iterator;
import java.util.HashMap;
import android.text.TextUtils;
import android.telephony.TelephonyManager;
import com.firebase.ui.auth.data.model.PhoneNumber;
import android.content.Context;
import java.util.Collections;
import java.util.Arrays;
import java.util.Locale;
import com.firebase.ui.auth.data.model.CountryInfo;
import java.util.List;
import android.util.SparseArray;
import java.util.Map;

public final class PhoneNumberUtils
{
    private static Map<String, Integer> COUNTRY_TO_ISO_CODES;
    private static final SparseArray<List<String>> COUNTRY_TO_REGION_CODES;
    private static final CountryInfo DEFAULT_COUNTRY;
    private static final String DEFAULT_COUNTRY_CODE;
    private static final int DEFAULT_COUNTRY_CODE_INT = 1;
    private static final Locale DEFAULT_LOCALE;
    private static final int MAX_COUNTRIES = 248;
    private static final int MAX_COUNTRY_CODES = 215;
    private static final int MAX_LENGTH_COUNTRY_CODE = 3;
    
    static {
        DEFAULT_COUNTRY_CODE = String.valueOf(1);
        DEFAULT_COUNTRY = new CountryInfo(DEFAULT_LOCALE = Locale.US, 1);
        COUNTRY_TO_REGION_CODES = createCountryCodeToRegionCodeMap();
    }
    
    private static SparseArray<List<String>> createCountryCodeToRegionCodeMap() {
        final SparseArray sparseArray = new SparseArray(215);
        sparseArray.put(1, (Object)Arrays.asList("US", "AG", "AI", "AS", "BB", "BM", "BS", "CA", "DM", "DO", "GD", "GU", "JM", "KN", "KY", "LC", "MP", "MS", "PR", "SX", "TC", "TT", "VC", "VG", "VI"));
        sparseArray.put(7, (Object)Arrays.asList("RU", "KZ"));
        sparseArray.put(20, (Object)Collections.singletonList("EG"));
        sparseArray.put(27, (Object)Collections.singletonList("ZA"));
        sparseArray.put(30, (Object)Collections.singletonList("GR"));
        sparseArray.put(31, (Object)Collections.singletonList("NL"));
        sparseArray.put(32, (Object)Collections.singletonList("BE"));
        sparseArray.put(33, (Object)Collections.singletonList("FR"));
        sparseArray.put(34, (Object)Collections.singletonList("ES"));
        sparseArray.put(36, (Object)Collections.singletonList("HU"));
        sparseArray.put(39, (Object)Collections.singletonList("IT"));
        sparseArray.put(40, (Object)Collections.singletonList("RO"));
        sparseArray.put(41, (Object)Collections.singletonList("CH"));
        sparseArray.put(43, (Object)Collections.singletonList("AT"));
        sparseArray.put(44, (Object)Arrays.asList("GB", "GG", "IM", "JE"));
        sparseArray.put(45, (Object)Collections.singletonList("DK"));
        sparseArray.put(46, (Object)Collections.singletonList("SE"));
        sparseArray.put(47, (Object)Arrays.asList("NO", "SJ"));
        sparseArray.put(48, (Object)Collections.singletonList("PL"));
        sparseArray.put(49, (Object)Collections.singletonList("DE"));
        sparseArray.put(51, (Object)Collections.singletonList("PE"));
        sparseArray.put(52, (Object)Collections.singletonList("MX"));
        sparseArray.put(53, (Object)Collections.singletonList("CU"));
        sparseArray.put(54, (Object)Collections.singletonList("AR"));
        sparseArray.put(55, (Object)Collections.singletonList("BR"));
        sparseArray.put(56, (Object)Collections.singletonList("CL"));
        sparseArray.put(57, (Object)Collections.singletonList("CO"));
        sparseArray.put(58, (Object)Collections.singletonList("VE"));
        sparseArray.put(60, (Object)Collections.singletonList("MY"));
        sparseArray.put(61, (Object)Arrays.asList("AU", "CC", "CX"));
        sparseArray.put(62, (Object)Collections.singletonList("ID"));
        sparseArray.put(63, (Object)Collections.singletonList("PH"));
        sparseArray.put(64, (Object)Collections.singletonList("NZ"));
        sparseArray.put(65, (Object)Collections.singletonList("SG"));
        sparseArray.put(66, (Object)Collections.singletonList("TH"));
        sparseArray.put(81, (Object)Collections.singletonList("JP"));
        sparseArray.put(82, (Object)Collections.singletonList("KR"));
        sparseArray.put(84, (Object)Collections.singletonList("VN"));
        sparseArray.put(86, (Object)Collections.singletonList("CN"));
        sparseArray.put(90, (Object)Collections.singletonList("TR"));
        sparseArray.put(91, (Object)Collections.singletonList("IN"));
        sparseArray.put(92, (Object)Collections.singletonList("PK"));
        sparseArray.put(93, (Object)Collections.singletonList("AF"));
        sparseArray.put(94, (Object)Collections.singletonList("LK"));
        sparseArray.put(95, (Object)Collections.singletonList("MM"));
        sparseArray.put(98, (Object)Collections.singletonList("IR"));
        sparseArray.put(211, (Object)Collections.singletonList("SS"));
        sparseArray.put(212, (Object)Arrays.asList("MA", "EH"));
        sparseArray.put(213, (Object)Collections.singletonList("DZ"));
        sparseArray.put(216, (Object)Collections.singletonList("TN"));
        sparseArray.put(218, (Object)Collections.singletonList("LY"));
        sparseArray.put(220, (Object)Collections.singletonList("GM"));
        sparseArray.put(221, (Object)Collections.singletonList("SN"));
        sparseArray.put(222, (Object)Collections.singletonList("MR"));
        sparseArray.put(223, (Object)Collections.singletonList("ML"));
        sparseArray.put(224, (Object)Collections.singletonList("GN"));
        sparseArray.put(225, (Object)Collections.singletonList("CI"));
        sparseArray.put(226, (Object)Collections.singletonList("BF"));
        sparseArray.put(227, (Object)Collections.singletonList("NE"));
        sparseArray.put(228, (Object)Collections.singletonList("TG"));
        sparseArray.put(229, (Object)Collections.singletonList("BJ"));
        sparseArray.put(230, (Object)Collections.singletonList("MU"));
        sparseArray.put(231, (Object)Collections.singletonList("LR"));
        sparseArray.put(232, (Object)Collections.singletonList("SL"));
        sparseArray.put(233, (Object)Collections.singletonList("GH"));
        sparseArray.put(234, (Object)Collections.singletonList("NG"));
        sparseArray.put(235, (Object)Collections.singletonList("TD"));
        sparseArray.put(236, (Object)Collections.singletonList("CF"));
        sparseArray.put(237, (Object)Collections.singletonList("CM"));
        sparseArray.put(238, (Object)Collections.singletonList("CV"));
        sparseArray.put(239, (Object)Collections.singletonList("ST"));
        sparseArray.put(240, (Object)Collections.singletonList("GQ"));
        sparseArray.put(241, (Object)Collections.singletonList("GA"));
        sparseArray.put(242, (Object)Collections.singletonList("CG"));
        sparseArray.put(243, (Object)Collections.singletonList("CD"));
        sparseArray.put(244, (Object)Collections.singletonList("AO"));
        sparseArray.put(245, (Object)Collections.singletonList("GW"));
        sparseArray.put(246, (Object)Collections.singletonList("IO"));
        sparseArray.put(247, (Object)Collections.singletonList("AC"));
        sparseArray.put(248, (Object)Collections.singletonList("SC"));
        sparseArray.put(249, (Object)Collections.singletonList("SD"));
        sparseArray.put(250, (Object)Collections.singletonList("RW"));
        sparseArray.put(251, (Object)Collections.singletonList("ET"));
        sparseArray.put(252, (Object)Collections.singletonList("SO"));
        sparseArray.put(253, (Object)Collections.singletonList("DJ"));
        sparseArray.put(254, (Object)Collections.singletonList("KE"));
        sparseArray.put(255, (Object)Collections.singletonList("TZ"));
        sparseArray.put(256, (Object)Collections.singletonList("UG"));
        sparseArray.put(257, (Object)Collections.singletonList("BI"));
        sparseArray.put(258, (Object)Collections.singletonList("MZ"));
        sparseArray.put(260, (Object)Collections.singletonList("ZM"));
        sparseArray.put(261, (Object)Collections.singletonList("MG"));
        sparseArray.put(262, (Object)Arrays.asList("RE", "YT"));
        sparseArray.put(263, (Object)Collections.singletonList("ZW"));
        sparseArray.put(264, (Object)Collections.singletonList("NA"));
        sparseArray.put(265, (Object)Collections.singletonList("MW"));
        sparseArray.put(266, (Object)Collections.singletonList("LS"));
        sparseArray.put(267, (Object)Collections.singletonList("BW"));
        sparseArray.put(268, (Object)Collections.singletonList("SZ"));
        sparseArray.put(269, (Object)Collections.singletonList("KM"));
        sparseArray.put(290, (Object)Arrays.asList("SH", "TA"));
        sparseArray.put(291, (Object)Collections.singletonList("ER"));
        sparseArray.put(297, (Object)Collections.singletonList("AW"));
        sparseArray.put(298, (Object)Collections.singletonList("FO"));
        sparseArray.put(299, (Object)Collections.singletonList("GL"));
        sparseArray.put(350, (Object)Collections.singletonList("GI"));
        sparseArray.put(351, (Object)Collections.singletonList("PT"));
        sparseArray.put(352, (Object)Collections.singletonList("LU"));
        sparseArray.put(353, (Object)Collections.singletonList("IE"));
        sparseArray.put(354, (Object)Collections.singletonList("IS"));
        sparseArray.put(355, (Object)Collections.singletonList("AL"));
        sparseArray.put(356, (Object)Collections.singletonList("MT"));
        sparseArray.put(357, (Object)Collections.singletonList("CY"));
        sparseArray.put(358, (Object)Arrays.asList("FI", "AX"));
        sparseArray.put(359, (Object)Collections.singletonList("BG"));
        sparseArray.put(370, (Object)Collections.singletonList("LT"));
        sparseArray.put(371, (Object)Collections.singletonList("LV"));
        sparseArray.put(372, (Object)Collections.singletonList("EE"));
        sparseArray.put(373, (Object)Collections.singletonList("MD"));
        sparseArray.put(374, (Object)Collections.singletonList("AM"));
        sparseArray.put(375, (Object)Collections.singletonList("BY"));
        sparseArray.put(376, (Object)Collections.singletonList("AD"));
        sparseArray.put(377, (Object)Collections.singletonList("MC"));
        sparseArray.put(378, (Object)Collections.singletonList("SM"));
        sparseArray.put(379, (Object)Collections.singletonList("VA"));
        sparseArray.put(380, (Object)Collections.singletonList("UA"));
        sparseArray.put(381, (Object)Collections.singletonList("RS"));
        sparseArray.put(382, (Object)Collections.singletonList("ME"));
        sparseArray.put(383, (Object)Collections.singletonList("XK"));
        sparseArray.put(385, (Object)Collections.singletonList("HR"));
        sparseArray.put(386, (Object)Collections.singletonList("SI"));
        sparseArray.put(387, (Object)Collections.singletonList("BA"));
        sparseArray.put(389, (Object)Collections.singletonList("MK"));
        sparseArray.put(420, (Object)Collections.singletonList("CZ"));
        sparseArray.put(421, (Object)Collections.singletonList("SK"));
        sparseArray.put(423, (Object)Collections.singletonList("LI"));
        sparseArray.put(500, (Object)Collections.singletonList("FK"));
        sparseArray.put(501, (Object)Collections.singletonList("BZ"));
        sparseArray.put(502, (Object)Collections.singletonList("GT"));
        sparseArray.put(503, (Object)Collections.singletonList("SV"));
        sparseArray.put(504, (Object)Collections.singletonList("HN"));
        sparseArray.put(505, (Object)Collections.singletonList("NI"));
        sparseArray.put(506, (Object)Collections.singletonList("CR"));
        sparseArray.put(507, (Object)Collections.singletonList("PA"));
        sparseArray.put(508, (Object)Collections.singletonList("PM"));
        sparseArray.put(509, (Object)Collections.singletonList("HT"));
        sparseArray.put(590, (Object)Arrays.asList("GP", "BL", "MF"));
        sparseArray.put(591, (Object)Collections.singletonList("BO"));
        sparseArray.put(592, (Object)Collections.singletonList("GY"));
        sparseArray.put(593, (Object)Collections.singletonList("EC"));
        sparseArray.put(594, (Object)Collections.singletonList("GF"));
        sparseArray.put(595, (Object)Collections.singletonList("PY"));
        sparseArray.put(596, (Object)Collections.singletonList("MQ"));
        sparseArray.put(597, (Object)Collections.singletonList("SR"));
        sparseArray.put(598, (Object)Collections.singletonList("UY"));
        sparseArray.put(599, (Object)Arrays.asList("CW", "BQ"));
        sparseArray.put(670, (Object)Collections.singletonList("TL"));
        sparseArray.put(672, (Object)Collections.singletonList("NF"));
        sparseArray.put(673, (Object)Collections.singletonList("BN"));
        sparseArray.put(674, (Object)Collections.singletonList("NR"));
        sparseArray.put(675, (Object)Collections.singletonList("PG"));
        sparseArray.put(676, (Object)Collections.singletonList("TO"));
        sparseArray.put(677, (Object)Collections.singletonList("SB"));
        sparseArray.put(678, (Object)Collections.singletonList("VU"));
        sparseArray.put(679, (Object)Collections.singletonList("FJ"));
        sparseArray.put(680, (Object)Collections.singletonList("PW"));
        sparseArray.put(681, (Object)Collections.singletonList("WF"));
        sparseArray.put(682, (Object)Collections.singletonList("CK"));
        sparseArray.put(683, (Object)Collections.singletonList("NU"));
        sparseArray.put(685, (Object)Collections.singletonList("WS"));
        sparseArray.put(686, (Object)Collections.singletonList("KI"));
        sparseArray.put(687, (Object)Collections.singletonList("NC"));
        sparseArray.put(688, (Object)Collections.singletonList("TV"));
        sparseArray.put(689, (Object)Collections.singletonList("PF"));
        sparseArray.put(690, (Object)Collections.singletonList("TK"));
        sparseArray.put(691, (Object)Collections.singletonList("FM"));
        sparseArray.put(692, (Object)Collections.singletonList("MH"));
        sparseArray.put(800, (Object)Collections.singletonList("001"));
        sparseArray.put(808, (Object)Collections.singletonList("001"));
        sparseArray.put(850, (Object)Collections.singletonList("KP"));
        sparseArray.put(852, (Object)Collections.singletonList("HK"));
        sparseArray.put(853, (Object)Collections.singletonList("MO"));
        sparseArray.put(855, (Object)Collections.singletonList("KH"));
        sparseArray.put(856, (Object)Collections.singletonList("LA"));
        sparseArray.put(870, (Object)Collections.singletonList("001"));
        sparseArray.put(878, (Object)Collections.singletonList("001"));
        sparseArray.put(880, (Object)Collections.singletonList("BD"));
        sparseArray.put(881, (Object)Collections.singletonList("001"));
        sparseArray.put(882, (Object)Collections.singletonList("001"));
        sparseArray.put(883, (Object)Collections.singletonList("001"));
        sparseArray.put(886, (Object)Collections.singletonList("TW"));
        sparseArray.put(888, (Object)Collections.singletonList("001"));
        sparseArray.put(960, (Object)Collections.singletonList("MV"));
        sparseArray.put(961, (Object)Collections.singletonList("LB"));
        sparseArray.put(962, (Object)Collections.singletonList("JO"));
        sparseArray.put(963, (Object)Collections.singletonList("SY"));
        sparseArray.put(964, (Object)Collections.singletonList("IQ"));
        sparseArray.put(965, (Object)Collections.singletonList("KW"));
        sparseArray.put(966, (Object)Collections.singletonList("SA"));
        sparseArray.put(967, (Object)Collections.singletonList("YE"));
        sparseArray.put(968, (Object)Collections.singletonList("OM"));
        sparseArray.put(970, (Object)Collections.singletonList("PS"));
        sparseArray.put(971, (Object)Collections.singletonList("AE"));
        sparseArray.put(972, (Object)Collections.singletonList("IL"));
        sparseArray.put(973, (Object)Collections.singletonList("BH"));
        sparseArray.put(974, (Object)Collections.singletonList("QA"));
        sparseArray.put(975, (Object)Collections.singletonList("BT"));
        sparseArray.put(976, (Object)Collections.singletonList("MN"));
        sparseArray.put(977, (Object)Collections.singletonList("NP"));
        sparseArray.put(979, (Object)Collections.singletonList("001"));
        sparseArray.put(992, (Object)Collections.singletonList("TJ"));
        sparseArray.put(993, (Object)Collections.singletonList("TM"));
        sparseArray.put(994, (Object)Collections.singletonList("AZ"));
        sparseArray.put(995, (Object)Collections.singletonList("GE"));
        sparseArray.put(996, (Object)Collections.singletonList("KG"));
        sparseArray.put(998, (Object)Collections.singletonList("UZ"));
        return (SparseArray<List<String>>)sparseArray;
    }
    
    public static String format(final String s, final CountryInfo countryInfo) {
        if (s.startsWith("+")) {
            return s;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("+");
        sb.append(String.valueOf(countryInfo.getCountryCode()));
        sb.append(s.replaceAll("[^\\d.]", ""));
        return sb.toString();
    }
    
    public static String formatUsingCurrentCountry(final String s, final Context context) {
        return format(s, getCurrentCountryInfo(context));
    }
    
    public static Integer getCountryCode(final String s) {
        if (PhoneNumberUtils.COUNTRY_TO_ISO_CODES == null) {
            initCountryCodeByIsoMap();
        }
        Integer n;
        if (s == null) {
            n = null;
        }
        else {
            n = PhoneNumberUtils.COUNTRY_TO_ISO_CODES.get(s.toUpperCase(Locale.getDefault()));
        }
        return n;
    }
    
    private static String getCountryCodeForPhoneNumber(final String s) {
        final String replaceFirst = s.replaceFirst("^\\+", "");
        for (int length = replaceFirst.length(), n = 1; n <= 3 && n <= length; ++n) {
            final String substring = replaceFirst.substring(0, n);
            if (PhoneNumberUtils.COUNTRY_TO_REGION_CODES.indexOfKey((int)Integer.valueOf(substring)) >= 0) {
                return substring;
            }
        }
        return null;
    }
    
    private static String getCountryCodeForPhoneNumberOrDefault(String s) {
        if ((s = getCountryCodeForPhoneNumber(s)) == null) {
            s = PhoneNumberUtils.DEFAULT_COUNTRY_CODE;
        }
        return s;
    }
    
    private static String getCountryIsoForCountryCode(final String s) {
        final List list = (List)PhoneNumberUtils.COUNTRY_TO_REGION_CODES.get(Integer.parseInt(s));
        if (list != null) {
            return (String)list.get(0);
        }
        return PhoneNumberUtils.DEFAULT_LOCALE.getCountry();
    }
    
    public static List<String> getCountryIsosFromCountryCode(final String s) {
        List<String> list;
        if (!isValid(s)) {
            list = null;
        }
        else {
            list = (List)PhoneNumberUtils.COUNTRY_TO_REGION_CODES.get(Integer.parseInt(s.substring(1)));
        }
        return list;
    }
    
    public static CountryInfo getCurrentCountryInfo(final Context context) {
        Locale locale;
        if ((locale = getSimBasedLocale(context)) == null) {
            locale = getOSLocale();
        }
        if (locale == null) {
            return PhoneNumberUtils.DEFAULT_COUNTRY;
        }
        final Integer countryCode = getCountryCode(locale.getCountry());
        CountryInfo default_COUNTRY;
        if (countryCode == null) {
            default_COUNTRY = PhoneNumberUtils.DEFAULT_COUNTRY;
        }
        else {
            default_COUNTRY = new CountryInfo(locale, countryCode);
        }
        return default_COUNTRY;
    }
    
    public static Map<String, Integer> getImmutableCountryIsoMap() {
        if (PhoneNumberUtils.COUNTRY_TO_ISO_CODES == null) {
            initCountryCodeByIsoMap();
        }
        return PhoneNumberUtils.COUNTRY_TO_ISO_CODES;
    }
    
    private static Locale getOSLocale() {
        return Locale.getDefault();
    }
    
    public static PhoneNumber getPhoneNumber(final String s) {
        String s2 = PhoneNumberUtils.DEFAULT_COUNTRY_CODE;
        String s3 = PhoneNumberUtils.DEFAULT_LOCALE.getCountry();
        String stripCountryCode = s;
        if (s.startsWith("+")) {
            s2 = getCountryCodeForPhoneNumberOrDefault(s);
            s3 = getCountryIsoForCountryCode(s2);
            stripCountryCode = stripCountryCode(s, s2);
        }
        return new PhoneNumber(stripCountryCode, s3, s2);
    }
    
    public static PhoneNumber getPhoneNumber(String default_COUNTRY_CODE, final String s) {
        Integer n;
        if ((n = getCountryCode(default_COUNTRY_CODE)) == null) {
            n = 1;
            default_COUNTRY_CODE = PhoneNumberUtils.DEFAULT_COUNTRY_CODE;
        }
        return new PhoneNumber(stripPlusSign(s), default_COUNTRY_CODE, String.valueOf(n));
    }
    
    private static Locale getSimBasedLocale(final Context context) {
        final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        final Locale locale = null;
        String simCountryIso;
        if (telephonyManager != null) {
            simCountryIso = telephonyManager.getSimCountryIso();
        }
        else {
            simCountryIso = null;
        }
        Locale locale2;
        if (TextUtils.isEmpty((CharSequence)simCountryIso)) {
            locale2 = locale;
        }
        else {
            locale2 = new Locale("", simCountryIso);
        }
        return locale2;
    }
    
    private static void initCountryCodeByIsoMap() {
        final HashMap hashMap = new HashMap(248);
        int n = 0;
        while (true) {
            final SparseArray<List<String>> country_TO_REGION_CODES = PhoneNumberUtils.COUNTRY_TO_REGION_CODES;
            if (n >= country_TO_REGION_CODES.size()) {
                hashMap.remove("TA");
                hashMap.put("HM", 672);
                hashMap.put("GS", 500);
                PhoneNumberUtils.COUNTRY_TO_ISO_CODES = (Map<String, Integer>)Collections.unmodifiableMap((Map<?, ?>)hashMap);
                return;
            }
            final int key = country_TO_REGION_CODES.keyAt(n);
            for (final String s : (List)country_TO_REGION_CODES.get(key)) {
                if (s.equals("001")) {
                    continue;
                }
                if (hashMap.containsKey(s)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Duplicate regions for country code: ");
                    sb.append(key);
                    throw new IllegalStateException(sb.toString());
                }
                hashMap.put(s, key);
            }
            ++n;
        }
    }
    
    public static boolean isValid(final String s) {
        return s.startsWith("+") && getCountryCodeForPhoneNumber(s) != null;
    }
    
    public static boolean isValidIso(final String s) {
        return getCountryCode(s) != null;
    }
    
    private static String stripCountryCode(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("^\\+?");
        sb.append(s2);
        return s.replaceFirst(sb.toString(), "");
    }
    
    private static String stripPlusSign(final String s) {
        return s.replaceFirst("^\\+?", "");
    }
}
