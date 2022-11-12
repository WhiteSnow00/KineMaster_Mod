// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Arrays;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList;
import java.util.List;
import com.google.android.exoplayer2.Tracks;

public final class TrackSelectionUtil
{
    private TrackSelectionUtil() {
    }
    
    public static Tracks a(final MappingTrackSelector.MappedTrackInfo mappedTrackInfo, final TrackSelection[] array) {
        final List[] array2 = new List[array.length];
        for (int i = 0; i < array.length; ++i) {
            final TrackSelection trackSelection = array[i];
            ImmutableList list;
            if (trackSelection != null) {
                list = ImmutableList.of((Object)trackSelection);
            }
            else {
                list = ImmutableList.of();
            }
            array2[i] = (List)list;
        }
        return b(mappedTrackInfo, array2);
    }
    
    public static Tracks b(final MappingTrackSelector.MappedTrackInfo mappedTrackInfo, final List<? extends TrackSelection>[] array) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        for (int i = 0; i < mappedTrackInfo.d(); ++i) {
            final TrackGroupArray f = mappedTrackInfo.f(i);
            final List<? extends TrackSelection> list = array[i];
            for (int j = 0; j < f.a; ++j) {
                final TrackGroup b = f.b(j);
                final boolean b2 = mappedTrackInfo.a(i, j, false) != 0;
                final int a = b.a;
                final int[] array2 = new int[a];
                final boolean[] array3 = new boolean[a];
                int k = 0;
            Label_0091:
                while (k < b.a) {
                    array2[k] = mappedTrackInfo.g(i, j, k);
                    while (true) {
                        for (int l = 0; l < list.size(); ++l) {
                            final TrackSelection trackSelection = list.get(l);
                            if (trackSelection.l().equals(b) && trackSelection.k(k) != -1) {
                                final boolean b3 = true;
                                array3[k] = b3;
                                ++k;
                                continue Label_0091;
                            }
                        }
                        final boolean b3 = false;
                        continue;
                    }
                }
                immutableList$Builder.i((Object)new Tracks.Group(b, b2, array2, array3));
            }
        }
        final TrackGroupArray h = mappedTrackInfo.h();
        for (int n = 0; n < h.a; ++n) {
            final TrackGroup b4 = h.b(n);
            final int[] array4 = new int[b4.a];
            Arrays.fill(array4, 0);
            immutableList$Builder.i((Object)new Tracks.Group(b4, false, array4, new boolean[b4.a]));
        }
        return new Tracks((List<Tracks.Group>)immutableList$Builder.l());
    }
    
    public static LoadErrorHandlingPolicy.FallbackOptions c(final ExoTrackSelection exoTrackSelection) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final int length = exoTrackSelection.length();
        int i = 0;
        int n = 0;
        while (i < length) {
            int n2 = n;
            if (exoTrackSelection.c(i, elapsedRealtime)) {
                n2 = n + 1;
            }
            ++i;
            n = n2;
        }
        return new LoadErrorHandlingPolicy.FallbackOptions(1, 0, length, n);
    }
    
    public static ExoTrackSelection[] d(final ExoTrackSelection.Definition[] array, final AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        final ExoTrackSelection[] array2 = new ExoTrackSelection[array.length];
        int i = 0;
        int n = 0;
        while (i < array.length) {
            final ExoTrackSelection.Definition definition = array[i];
            if (definition != null) {
                final int[] b = definition.b;
                if (b.length > 1 && n == 0) {
                    array2[i] = adaptiveTrackSelectionFactory.a(definition);
                    n = 1;
                }
                else {
                    array2[i] = new FixedTrackSelection(definition.a, b[0], definition.c);
                }
            }
            ++i;
        }
        return array2;
    }
    
    public interface AdaptiveTrackSelectionFactory
    {
        ExoTrackSelection a(final ExoTrackSelection.Definition p0);
    }
}
