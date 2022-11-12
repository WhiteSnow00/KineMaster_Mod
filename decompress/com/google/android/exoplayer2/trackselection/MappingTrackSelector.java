// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.Arrays;
import android.util.Pair;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.RendererCapabilities;

public abstract class MappingTrackSelector extends TrackSelector
{
    private MappedTrackInfo c;
    
    private static int k(final RendererCapabilities[] array, final TrackGroup trackGroup, final int[] array2, final boolean b) throws ExoPlaybackException {
        int length = array.length;
        int n = 1;
        int i = 0;
        int n2 = 0;
        while (i < array.length) {
            final RendererCapabilities rendererCapabilities = array[i];
            int j = 0;
            int max = 0;
            while (j < trackGroup.a) {
                max = Math.max(max, RendererCapabilities.E(rendererCapabilities.a(trackGroup.c(j))));
                ++j;
            }
            final boolean b2 = array2[i] == 0;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            Label_0174: {
                if (max <= n2) {
                    n3 = length;
                    n4 = n2;
                    n5 = n;
                    if (max != n2) {
                        break Label_0174;
                    }
                    n3 = length;
                    n4 = n2;
                    n5 = n;
                    if (!b) {
                        break Label_0174;
                    }
                    n3 = length;
                    n4 = n2;
                    if ((n5 = n) != 0) {
                        break Label_0174;
                    }
                    n3 = length;
                    n4 = n2;
                    n5 = n;
                    if (!b2) {
                        break Label_0174;
                    }
                }
                n3 = i;
                n5 = (b2 ? 1 : 0);
                n4 = max;
            }
            ++i;
            length = n3;
            n2 = n4;
            n = n5;
        }
        return length;
    }
    
    private static int[] l(final RendererCapabilities rendererCapabilities, final TrackGroup trackGroup) throws ExoPlaybackException {
        final int[] array = new int[trackGroup.a];
        for (int i = 0; i < trackGroup.a; ++i) {
            array[i] = rendererCapabilities.a(trackGroup.c(i));
        }
        return array;
    }
    
    private static int[] m(final RendererCapabilities[] array) throws ExoPlaybackException {
        final int length = array.length;
        final int[] array2 = new int[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = array[i].z();
        }
        return array2;
    }
    
    @Override
    public final void f(final Object o) {
        this.c = (MappedTrackInfo)o;
    }
    
    @Override
    public final TrackSelectorResult h(final RendererCapabilities[] array, final TrackGroupArray trackGroupArray, final MediaSource.MediaPeriodId mediaPeriodId, final Timeline timeline) throws ExoPlaybackException {
        final int[] array2 = new int[array.length + 1];
        final int n = array.length + 1;
        final TrackGroup[][] array3 = new TrackGroup[n][];
        final int[][][] array4 = new int[array.length + 1][][];
        final int n2 = 0;
        for (int i = 0; i < n; ++i) {
            final int a = trackGroupArray.a;
            array3[i] = new TrackGroup[a];
            array4[i] = new int[a][];
        }
        final int[] m = m(array);
        for (int j = 0; j < trackGroupArray.a; ++j) {
            final TrackGroup b = trackGroupArray.b(j);
            final int k = k(array, b, array2, b.c == 5);
            int[] l;
            if (k == array.length) {
                l = new int[b.a];
            }
            else {
                l = l(array[k], b);
            }
            final int n3 = array2[k];
            array3[k][n3] = b;
            array4[k][n3] = l;
            ++array2[k];
        }
        final TrackGroupArray[] array5 = new TrackGroupArray[array.length];
        final String[] array6 = new String[array.length];
        final int[] array7 = new int[array.length];
        for (int n4 = n2; n4 < array.length; ++n4) {
            final int n5 = array2[n4];
            array5[n4] = new TrackGroupArray((TrackGroup[])Util.H0(array3[n4], n5));
            array4[n4] = Util.H0(array4[n4], n5);
            array6[n4] = array[n4].getName();
            array7[n4] = array[n4].f();
        }
        final MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(array6, array7, array5, m, array4, new TrackGroupArray((TrackGroup[])Util.H0(array3[array.length], array2[array.length])));
        final Pair<RendererConfiguration[], ExoTrackSelection[]> n6 = this.n(mappedTrackInfo, array4, m, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[])n6.first, (ExoTrackSelection[])n6.second, TrackSelectionUtil.a(mappedTrackInfo, (TrackSelection[])n6.second), mappedTrackInfo);
    }
    
    protected abstract Pair<RendererConfiguration[], ExoTrackSelection[]> n(final MappedTrackInfo p0, final int[][][] p1, final int[] p2, final MediaSource.MediaPeriodId p3, final Timeline p4) throws ExoPlaybackException;
    
    public static final class MappedTrackInfo
    {
        private final int a;
        private final String[] b;
        private final int[] c;
        private final TrackGroupArray[] d;
        private final int[] e;
        private final int[][][] f;
        private final TrackGroupArray g;
        
        MappedTrackInfo(final String[] b, final int[] c, final TrackGroupArray[] d, final int[] e, final int[][][] f, final TrackGroupArray g) {
            this.b = b;
            this.c = c;
            this.d = d;
            this.f = f;
            this.e = e;
            this.g = g;
            this.a = c.length;
        }
        
        public int a(final int n, final int n2, final boolean b) {
            final int a = this.d[n].b(n2).a;
            final int[] array = new int[a];
            int i = 0;
            int n3 = 0;
            while (i < a) {
                final int g = this.g(n, n2, i);
                int n4 = 0;
                Label_0081: {
                    if (g != 4) {
                        n4 = n3;
                        if (!b) {
                            break Label_0081;
                        }
                        n4 = n3;
                        if (g != 3) {
                            break Label_0081;
                        }
                    }
                    array[n3] = i;
                    n4 = n3 + 1;
                }
                ++i;
                n3 = n4;
            }
            return this.b(n, n2, Arrays.copyOf(array, n3));
        }
        
        public int b(final int n, int min, final int[] array) {
            int i = 0;
            int min2 = 16;
            Object o = null;
            boolean b = false;
            for (int n2 = 0; i < array.length; ++i, ++n2) {
                final String w = this.d[n].b(min).c(array[i]).w;
                if (n2 == 0) {
                    o = w;
                }
                else {
                    b |= (Util.c(o, w) ^ true);
                }
                min2 = Math.min(min2, RendererCapabilities.n(this.f[n][min][i]));
            }
            min = min2;
            if (b) {
                min = Math.min(min2, this.e[n]);
            }
            return min;
        }
        
        public int c(final int n, final int n2, final int n3) {
            return this.f[n][n2][n3];
        }
        
        public int d() {
            return this.a;
        }
        
        public int e(final int n) {
            return this.c[n];
        }
        
        public TrackGroupArray f(final int n) {
            return this.d[n];
        }
        
        public int g(final int n, final int n2, final int n3) {
            return RendererCapabilities.E(this.c(n, n2, n3));
        }
        
        public TrackGroupArray h() {
            return this.g;
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
        public @interface RendererSupport {
        }
    }
}
