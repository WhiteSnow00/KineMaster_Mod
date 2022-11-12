// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableList$Builder;
import java.util.Collection;
import com.google.common.primitives.Ints;
import android.media.AudioTrack;
import android.media.AudioFormat$Builder;
import com.google.common.collect.ImmutableList;
import android.media.AudioAttributes$Builder;
import android.media.AudioAttributes;
import com.google.android.exoplayer2.util.MimeTypes;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import android.provider.Settings$Global;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.Context;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMap;

public final class AudioCapabilities
{
    public static final AudioCapabilities c;
    private static final AudioCapabilities d;
    private static final ImmutableMap<Integer, Integer> e;
    private final int[] a;
    private final int b;
    
    static {
        final Integer value = 8;
        c = new AudioCapabilities(new int[] { 2 }, 8);
        d = new AudioCapabilities(new int[] { 2, 5, 6 }, 8);
        final ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder();
        final Integer value2 = 6;
        e = immutableMap$Builder.d((Object)5, (Object)value2).d((Object)17, (Object)value2).d((Object)7, (Object)value2).d((Object)18, (Object)value2).d((Object)value2, (Object)value).d((Object)value, (Object)value).d((Object)14, (Object)value).b();
    }
    
    public AudioCapabilities(int[] copy, final int b) {
        if (copy != null) {
            copy = Arrays.copyOf(copy, copy.length);
            Arrays.sort(this.a = copy);
        }
        else {
            this.a = new int[0];
        }
        this.b = b;
    }
    
    static ImmutableMap a() {
        return AudioCapabilities.e;
    }
    
    private static boolean b() {
        if (Util.a >= 17) {
            final String c = Util.c;
            if ("Amazon".equals(c) || "Xiaomi".equals(c)) {
                return true;
            }
        }
        return false;
    }
    
    public static AudioCapabilities c(final Context context) {
        return d(context, context.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }
    
    static AudioCapabilities d(final Context context, final Intent intent) {
        if (b() && Settings$Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return AudioCapabilities.d;
        }
        if (Util.a >= 29 && (Util.x0(context) || Util.s0(context))) {
            return new AudioCapabilities(a.a(), 8);
        }
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return AudioCapabilities.c;
    }
    
    private static int e(int n) {
        final int a = Util.a;
        int n2 = n;
        if (a <= 28) {
            if (n == 7) {
                n2 = 8;
            }
            else if (n == 3 || n == 4 || (n2 = n) == 5) {
                n2 = 6;
            }
        }
        n = n2;
        if (a <= 26) {
            n = n2;
            if ("fugu".equals(Util.b) && (n = n2) == 1) {
                n = 2;
            }
        }
        return Util.G(n);
    }
    
    private static int g(final int n, final int n2) {
        if (Util.a >= 29) {
            return a.b(n, n2);
        }
        return Assertions.e(AudioCapabilities.e.getOrDefault((Object)n, (Object)0));
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof AudioCapabilities)) {
            return false;
        }
        final AudioCapabilities audioCapabilities = (AudioCapabilities)o;
        if (!Arrays.equals(this.a, audioCapabilities.a) || this.b != audioCapabilities.b) {
            b = false;
        }
        return b;
    }
    
    public Pair<Integer, Integer> f(final Format format) {
        final int f = MimeTypes.f(Assertions.e(format.w), format.i);
        if (!AudioCapabilities.e.containsKey((Object)f)) {
            return null;
        }
        int n;
        if (f == 18 && !this.i(18)) {
            n = 6;
        }
        else if ((n = f) == 8) {
            n = f;
            if (!this.i(8)) {
                n = 7;
            }
        }
        if (!this.i(n)) {
            return null;
        }
        final int j = format.J;
        int g;
        if (j != -1 && n != 18) {
            if ((g = j) > this.b) {
                return null;
            }
        }
        else {
            int k = format.K;
            if (k == -1) {
                k = 48000;
            }
            g = g(n, k);
        }
        final int e = e(g);
        if (e == 0) {
            return null;
        }
        return (Pair<Integer, Integer>)Pair.create((Object)n, (Object)e);
    }
    
    public boolean h(final Format format) {
        return this.f(format) != null;
    }
    
    @Override
    public int hashCode() {
        return this.b + Arrays.hashCode(this.a) * 31;
    }
    
    public boolean i(final int n) {
        return Arrays.binarySearch(this.a, n) >= 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(this.b);
        sb.append(", supportedEncodings=");
        sb.append(Arrays.toString(this.a));
        sb.append("]");
        return sb.toString();
    }
    
    private static final class a
    {
        private static final AudioAttributes a;
        
        static {
            a = new AudioAttributes$Builder().setUsage(1).setContentType(3).setFlags(0).build();
        }
        
        public static int[] a() {
            final ImmutableList$Builder builder = ImmutableList.builder();
            for (final int intValue : AudioCapabilities.a().keySet()) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat$Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), AudioCapabilities.a.a)) {
                    builder.i((Object)intValue);
                }
            }
            builder.i((Object)2);
            return Ints.n((Collection)builder.l());
        }
        
        public static int b(final int encoding, final int sampleRate) {
            for (int i = 8; i > 0; --i) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat$Builder().setEncoding(encoding).setSampleRate(sampleRate).setChannelMask(Util.G(i)).build(), AudioCapabilities.a.a)) {
                    return i;
                }
            }
            return 0;
        }
    }
}
