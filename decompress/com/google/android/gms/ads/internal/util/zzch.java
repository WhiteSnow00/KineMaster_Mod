// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.util.Range;
import android.media.MediaCodecInfo$VideoCapabilities;
import android.media.MediaCodecInfo$CodecProfileLevel;
import android.media.MediaCodecInfo$CodecCapabilities;
import java.util.Iterator;
import android.media.MediaCodecInfo;
import java.util.ArrayList;
import java.util.Arrays;
import android.media.MediaCodecList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzch
{
    private static final Map a;
    private static List b;
    private static final Object c;
    
    static {
        a = new HashMap();
        c = new Object();
    }
    
    public static List a(final String s) {
        synchronized (zzch.c) {
            final Map a = zzch.a;
            if (a.containsKey(s)) {
                return (List)a.get(s);
            }
            try {
                synchronized (zzch.c) {
                    if (zzch.b != null) {
                        monitorexit(zzch.c);
                    }
                    else {
                        zzch.b = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        monitorexit(zzch.c);
                    }
                    final ArrayList<HashMap> list = new ArrayList<HashMap>();
                    for (final MediaCodecInfo mediaCodecInfo : zzch.b) {
                        if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(s)) {
                            final HashMap hashMap = new HashMap();
                            hashMap.put("codecName", mediaCodecInfo.getName());
                            final MediaCodecInfo$CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(s);
                            final ArrayList<Integer[]> list2 = new ArrayList<Integer[]>();
                            for (final MediaCodecInfo$CodecProfileLevel mediaCodecInfo$CodecProfileLevel : capabilitiesForType.profileLevels) {
                                list2.add(new Integer[] { mediaCodecInfo$CodecProfileLevel.profile, mediaCodecInfo$CodecProfileLevel.level });
                            }
                            hashMap.put("profileLevels", list2);
                            final MediaCodecInfo$VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            hashMap.put("bitRatesBps", b(videoCapabilities.getBitrateRange()));
                            hashMap.put("widthAlignment", videoCapabilities.getWidthAlignment());
                            hashMap.put("heightAlignment", videoCapabilities.getHeightAlignment());
                            hashMap.put("frameRates", b(videoCapabilities.getSupportedFrameRates()));
                            hashMap.put("widths", b(videoCapabilities.getSupportedWidths()));
                            hashMap.put("heights", b(videoCapabilities.getSupportedHeights()));
                            hashMap.put("instancesLimit", capabilitiesForType.getMaxSupportedInstances());
                            list.add(hashMap);
                        }
                    }
                    zzch.a.put(s, list);
                    return list;
                }
            }
            catch (final LinkageError a) {}
            catch (final RuntimeException ex) {}
            final HashMap hashMap2 = new HashMap();
            hashMap2.put("error", a.getClass().getSimpleName());
            final ArrayList<HashMap> list3 = new ArrayList<HashMap>();
            list3.add(hashMap2);
            zzch.a.put(s, list3);
            return list3;
        }
    }
    
    private static Integer[] b(final Range range) {
        return new Integer[] { (Integer)range.getLower(), (Integer)range.getUpper() };
    }
}
