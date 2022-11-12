// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.common.collect.ImmutableCollection;
import java.util.AbstractCollection;
import java.util.concurrent.Executor;
import com.google.android.exoplayer2.audio.n;
import java.util.Objects;
import android.media.AudioFormat$Builder;
import android.media.AudioManager;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.media.Spatializer;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList$Builder;
import java.util.Arrays;
import d4.i;
import com.google.android.exoplayer2.util.BundleableUtil;
import java.util.Iterator;
import android.os.Bundle;
import d4.h;
import android.util.SparseBooleanArray;
import android.util.SparseArray;
import com.google.android.exoplayer2.Bundleable;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import d4.c;
import d4.b;
import d4.d;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import android.util.Pair;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.common.base.Predicate;
import d4.e;
import java.util.List;
import com.google.android.exoplayer2.RendererCapabilities;
import android.graphics.Point;
import com.google.android.exoplayer2.source.TrackGroup;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import java.util.Collection;
import com.google.common.primitives.Ints;
import java.util.Map;
import java.util.HashMap;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import d4.f;
import java.util.Comparator;
import d4.g;
import com.google.android.exoplayer2.audio.AudioAttributes;
import android.content.Context;
import com.google.common.collect.Ordering;

public class DefaultTrackSelector extends MappingTrackSelector
{
    private static final Ordering<Integer> k;
    private static final Ordering<Integer> l;
    private final Object d;
    public final Context e;
    private final ExoTrackSelection.Factory f;
    private final boolean g;
    private Parameters h;
    private d i;
    private AudioAttributes j;
    
    static {
        k = Ordering.from((Comparator)g.a);
        l = Ordering.from((Comparator)d4.f.a);
    }
    
    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.d0, new AdaptiveTrackSelection.Factory());
    }
    
    public DefaultTrackSelector(final Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }
    
    public DefaultTrackSelector(final Context context, final ExoTrackSelection.Factory factory) {
        this(context, Parameters.k(context), factory);
    }
    
    public DefaultTrackSelector(final Context context, final TrackSelectionParameters trackSelectionParameters, final ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context);
    }
    
    @Deprecated
    public DefaultTrackSelector(final TrackSelectionParameters trackSelectionParameters, final ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, null);
    }
    
    private DefaultTrackSelector(final TrackSelectionParameters trackSelectionParameters, final ExoTrackSelection.Factory f, final Context context) {
        this.d = new Object();
        Context applicationContext;
        if (context != null) {
            applicationContext = context.getApplicationContext();
        }
        else {
            applicationContext = null;
        }
        this.e = applicationContext;
        this.f = f;
        if (trackSelectionParameters instanceof Parameters) {
            this.h = (Parameters)trackSelectionParameters;
        }
        else {
            Parameters parameters;
            if (context == null) {
                parameters = Parameters.d0;
            }
            else {
                parameters = Parameters.k(context);
            }
            this.h = parameters.j().h0(trackSelectionParameters).c0();
        }
        this.j = AudioAttributes.g;
        final boolean g = context != null && Util.x0(context);
        this.g = g;
        if (!g && context != null && Util.a >= 32) {
            this.i = DefaultTrackSelector.d.g(context);
        }
        if (this.h.X && context == null) {
            Log.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
    
    private static void A(final MappedTrackInfo mappedTrackInfo, final Parameters parameters, final ExoTrackSelection.Definition[] array) {
        for (int d = mappedTrackInfo.d(), i = 0; i < d; ++i) {
            final TrackGroupArray f = mappedTrackInfo.f(i);
            if (parameters.o(i, f)) {
                final SelectionOverride n = parameters.n(i, f);
                Object o;
                if (n != null && n.b.length != 0) {
                    o = new ExoTrackSelection.Definition(f.b(n.a), n.b, n.d);
                }
                else {
                    o = null;
                }
                array[i] = (ExoTrackSelection.Definition)o;
            }
        }
    }
    
    private static void B(final MappedTrackInfo mappedTrackInfo, final TrackSelectionParameters trackSelectionParameters, final ExoTrackSelection.Definition[] array) {
        final int d = mappedTrackInfo.d();
        final HashMap hashMap = new HashMap();
        final int n = 0;
        for (int i = 0; i < d; ++i) {
            C(mappedTrackInfo.f(i), trackSelectionParameters, hashMap);
        }
        C(mappedTrackInfo.h(), trackSelectionParameters, hashMap);
        for (int j = n; j < d; ++j) {
            final TrackSelectionOverride trackSelectionOverride = hashMap.get(mappedTrackInfo.e(j));
            if (trackSelectionOverride != null) {
                Object o;
                if (!((AbstractCollection)trackSelectionOverride.b).isEmpty() && mappedTrackInfo.f(j).c(trackSelectionOverride.a) != -1) {
                    o = new ExoTrackSelection.Definition(trackSelectionOverride.a, Ints.n((Collection)trackSelectionOverride.b));
                }
                else {
                    o = null;
                }
                array[j] = (ExoTrackSelection.Definition)o;
            }
        }
    }
    
    private static void C(final TrackGroupArray trackGroupArray, final TrackSelectionParameters trackSelectionParameters, final Map<Integer, TrackSelectionOverride> map) {
        for (int i = 0; i < trackGroupArray.a; ++i) {
            final TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride)trackSelectionParameters.J.get((Object)trackGroupArray.b(i));
            if (trackSelectionOverride != null) {
                final TrackSelectionOverride trackSelectionOverride2 = map.get(trackSelectionOverride.b());
                if (trackSelectionOverride2 == null || (((AbstractCollection)trackSelectionOverride2.b).isEmpty() && !((AbstractCollection)trackSelectionOverride.b).isEmpty())) {
                    map.put(trackSelectionOverride.b(), trackSelectionOverride);
                }
            }
        }
    }
    
    protected static int D(final Format format, String t, final boolean b) {
        if (!TextUtils.isEmpty((CharSequence)t) && t.equals(format.c)) {
            return 4;
        }
        t = T(t);
        final String t2 = T(format.c);
        final boolean b2 = false;
        if (t2 == null || t == null) {
            int n = b2 ? 1 : 0;
            if (b) {
                n = (b2 ? 1 : 0);
                if (t2 == null) {
                    n = 1;
                }
            }
            return n;
        }
        if (t2.startsWith(t) || t.startsWith(t2)) {
            return 3;
        }
        if (Util.U0(t2, "-")[0].equals(Util.U0(t, "-")[0])) {
            return 2;
        }
        return 0;
    }
    
    private static int E(final TrackGroup trackGroup, final int n, final int n2, final boolean b) {
        int n4;
        int n3 = n4 = Integer.MAX_VALUE;
        if (n != Integer.MAX_VALUE) {
            if (n2 == Integer.MAX_VALUE) {
                n4 = n3;
            }
            else {
                int n5 = 0;
                while (true) {
                    n4 = n3;
                    if (n5 >= trackGroup.a) {
                        break;
                    }
                    final Format c = trackGroup.c(n5);
                    final int b2 = c.B;
                    int n6 = n3;
                    if (b2 > 0) {
                        final int c2 = c.C;
                        n6 = n3;
                        if (c2 > 0) {
                            final Point f = F(b, n, n2, b2, c2);
                            final int b3 = c.B;
                            final int c3 = c.C;
                            final int n7 = b3 * c3;
                            n6 = n3;
                            if (b3 >= (int)(f.x * 0.98f)) {
                                n6 = n3;
                                if (c3 >= (int)(f.y * 0.98f) && n7 < (n6 = n3)) {
                                    n6 = n7;
                                }
                            }
                        }
                    }
                    ++n5;
                    n3 = n6;
                }
            }
        }
        return n4;
    }
    
    private static Point F(final boolean b, int n, int n2, final int n3, final int n4) {
        Label_0051: {
            if (b) {
                int n5 = true ? 1 : 0;
                final boolean b2 = n3 > n4;
                if (n <= n2) {
                    n5 = (false ? 1 : 0);
                }
                if ((b2 ? 1 : 0) != n5) {
                    break Label_0051;
                }
            }
            final int n6 = n2;
            n2 = n;
            n = n6;
        }
        final int n7 = n3 * n;
        final int n8 = n4 * n2;
        if (n7 >= n8) {
            return new Point(n2, Util.l(n8, n3));
        }
        return new Point(Util.l(n7, n4), n);
    }
    
    private static int H(final int n, final int n2) {
        if (n != 0 && n == n2) {
            return Integer.MAX_VALUE;
        }
        return Integer.bitCount(n & n2);
    }
    
    private static int I(final String s) {
        if (s == null) {
            return 0;
        }
        int n = -1;
        switch (s) {
            case "video/x-vnd.on2.vp9": {
                n = 3;
                break;
            }
            case "video/avc": {
                n = 2;
                break;
            }
            case "video/hevc": {
                n = 1;
                break;
            }
            case "video/av01": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return 0;
            }
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 3;
            }
            case 0: {
                return 4;
            }
        }
    }
    
    private boolean J(final Format format) {
        synchronized (this.d) {
            if (this.h.X && !this.g && format.J > 2) {
                if (K(format)) {
                    if (Util.a < 32) {
                        return true;
                    }
                    final d i = this.i;
                    if (i == null || !i.e()) {
                        return true;
                    }
                }
                if (Util.a >= 32) {
                    final d j = this.i;
                    if (j != null && j.e() && this.i.c() && this.i.d() && this.i.a(this.j, format)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
    }
    
    private static boolean K(final Format format) {
        final String w = format.w;
        if (w == null) {
            return false;
        }
        w.hashCode();
        int n = -1;
        switch (w) {
            case "audio/eac3": {
                n = 3;
                break;
            }
            case "audio/ac4": {
                n = 2;
                break;
            }
            case "audio/ac3": {
                n = 1;
                break;
            }
            case "audio/eac3-joc": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return false;
            }
            case 0:
            case 1:
            case 2:
            case 3: {
                return true;
            }
        }
    }
    
    protected static boolean L(int e, final boolean b) {
        e = RendererCapabilities.E(e);
        return e == 4 || (b && e == 3);
    }
    
    private List M(final Parameters parameters, final boolean b, final int n, final TrackGroup trackGroup, final int[] array) {
        return (List)DefaultTrackSelector.b.g(n, trackGroup, parameters, array, b, (Predicate<Format>)new d4.e(this));
    }
    
    private static List N(final Parameters parameters, final String s, final int n, final TrackGroup trackGroup, final int[] array) {
        return (List)e.g(n, trackGroup, parameters, array, s);
    }
    
    private static List O(final Parameters parameters, final int[] array, final int n, final TrackGroup trackGroup, final int[] array2) {
        return (List)f.k(n, trackGroup, parameters, array2, array[n]);
    }
    
    private static int P(final Integer n, final Integer n2) {
        final int intValue = n;
        int n3 = -1;
        if (intValue == -1) {
            if (n2 == -1) {
                n3 = 0;
            }
        }
        else if (n2 == -1) {
            n3 = 1;
        }
        else {
            n3 = n - n2;
        }
        return n3;
    }
    
    private static int Q(final Integer n, final Integer n2) {
        return 0;
    }
    
    private static void R(final MappedTrackInfo mappedTrackInfo, final int[][][] array, final RendererConfiguration[] array2, final ExoTrackSelection[] array3) {
        final boolean b = false;
        int i = 0;
        int n = -1;
        int n2 = -1;
        while (true) {
            while (i < mappedTrackInfo.d()) {
                final int e = mappedTrackInfo.e(i);
                final ExoTrackSelection exoTrackSelection = array3[i];
                int n3 = 0;
                int n4 = 0;
                Label_0140: {
                    if (e != 1) {
                        n3 = n;
                        n4 = n2;
                        if (e != 2) {
                            break Label_0140;
                        }
                    }
                    n3 = n;
                    n4 = n2;
                    if (exoTrackSelection != null) {
                        n3 = n;
                        n4 = n2;
                        if (U(array[i], mappedTrackInfo.f(i), exoTrackSelection)) {
                            if (e == 1) {
                                if (n2 == -1) {
                                    n4 = i;
                                    n3 = n;
                                    break Label_0140;
                                }
                            }
                            else if (n == -1) {
                                n3 = i;
                                n4 = n2;
                                break Label_0140;
                            }
                            final int n5 = 0;
                            int n6 = b ? 1 : 0;
                            if (n2 != -1) {
                                n6 = (b ? 1 : 0);
                                if (n != -1) {
                                    n6 = 1;
                                }
                            }
                            if ((n5 & n6) != 0x0) {
                                array2[n] = (array2[n2] = new RendererConfiguration(true));
                            }
                            return;
                        }
                    }
                }
                ++i;
                n = n3;
                n2 = n4;
            }
            final int n5 = 1;
            continue;
        }
    }
    
    private void S() {
        synchronized (this.d) {
            boolean b = false;
            Label_0055: {
                if (this.h.X && !this.g && Util.a >= 32) {
                    final d i = this.i;
                    if (i != null && i.e()) {
                        b = true;
                        break Label_0055;
                    }
                }
                b = false;
            }
            monitorexit(this.d);
            if (b) {
                this.d();
            }
        }
    }
    
    protected static String T(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final String s2 = s;
            if (!TextUtils.equals((CharSequence)s, (CharSequence)"und")) {
                return s2;
            }
        }
        return null;
    }
    
    private static boolean U(final int[][] array, final TrackGroupArray trackGroupArray, final ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        final int c = trackGroupArray.c(exoTrackSelection.l());
        for (int i = 0; i < exoTrackSelection.length(); ++i) {
            if (RendererCapabilities.m(array[c][exoTrackSelection.g(i)]) != 32) {
                return false;
            }
        }
        return true;
    }
    
    private <T extends TrackInfo<T>> Pair<ExoTrackSelection.Definition, Integer> Z(int i, final MappedTrackInfo mappedTrackInfo, final int[][][] array, final TrackInfo.Factory<T> factory, final Comparator<List<T>> comparator) {
        final ArrayList list = new ArrayList();
        int n;
        for (int d = mappedTrackInfo.d(), j = 0; j < d; ++j, d = n) {
            n = d;
            if (i == mappedTrackInfo.e(j)) {
                final TrackGroupArray f = mappedTrackInfo.f(j);
                int n2 = 0;
                while (true) {
                    n = d;
                    if (n2 >= f.a) {
                        break;
                    }
                    final TrackGroup b = f.b(n2);
                    final List<T> a = factory.a(j, b, array[j][n2]);
                    final boolean[] array2 = new boolean[b.a];
                    for (int k = 0; k < b.a; ++k) {
                        final TrackInfo<T> trackInfo = a.get(k);
                        final int a2 = trackInfo.a();
                        if (!array2[k]) {
                            if (a2 != 0) {
                                Object of;
                                if (a2 == 1) {
                                    of = ImmutableList.of((Object)trackInfo);
                                }
                                else {
                                    of = new ArrayList<TrackInfo>();
                                    ((List<TrackInfo>)of).add(trackInfo);
                                    for (int l = k + 1; l < b.a; ++l) {
                                        final TrackInfo<T> trackInfo2 = a.get(l);
                                        if (trackInfo2.a() == 2 && trackInfo.c((TrackInfo)trackInfo2)) {
                                            ((List<TrackInfo>)of).add(trackInfo2);
                                            array2[l] = true;
                                        }
                                    }
                                }
                                list.add(of);
                            }
                        }
                    }
                    ++n2;
                }
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        final List list2 = Collections.max((Collection<? extends List>)list, (Comparator<? super List>)comparator);
        final int[] array3 = new int[list2.size()];
        for (i = 0; i < list2.size(); ++i) {
            array3[i] = ((TrackInfo)list2.get(i)).c;
        }
        final TrackInfo trackInfo3 = (TrackInfo)list2.get(0);
        return (Pair<ExoTrackSelection.Definition, Integer>)Pair.create((Object)new ExoTrackSelection.Definition(trackInfo3.b, array3), (Object)trackInfo3.a);
    }
    
    private void b0(final Parameters h) {
        Assertions.e(h);
        synchronized (this.d) {
            final boolean b = !this.h.equals(h);
            this.h = h;
            monitorexit(this.d);
            if (b) {
                if (h.X && this.e == null) {
                    Log.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
                }
                this.d();
            }
        }
    }
    
    public static int o(final Integer n, final Integer n2) {
        return Q(n, n2);
    }
    
    public static boolean p(final DefaultTrackSelector defaultTrackSelector, final Format format) {
        return defaultTrackSelector.J(format);
    }
    
    public static List q(final Parameters parameters, final int[] array, final int n, final TrackGroup trackGroup, final int[] array2) {
        return O(parameters, array, n, trackGroup, array2);
    }
    
    public static List r(final Parameters parameters, final String s, final int n, final TrackGroup trackGroup, final int[] array) {
        return N(parameters, s, n, trackGroup, array);
    }
    
    public static List s(final DefaultTrackSelector defaultTrackSelector, final Parameters parameters, final boolean b, final int n, final TrackGroup trackGroup, final int[] array) {
        return defaultTrackSelector.M(parameters, b, n, trackGroup, array);
    }
    
    public static int t(final Integer n, final Integer n2) {
        return P(n, n2);
    }
    
    static int u(final TrackGroup trackGroup, final int n, final int n2, final boolean b) {
        return E(trackGroup, n, n2, b);
    }
    
    static int v(final int n, final int n2) {
        return H(n, n2);
    }
    
    static int w(final String s) {
        return I(s);
    }
    
    static Ordering x() {
        return DefaultTrackSelector.k;
    }
    
    static Ordering y() {
        return DefaultTrackSelector.l;
    }
    
    static void z(final DefaultTrackSelector defaultTrackSelector) {
        defaultTrackSelector.S();
    }
    
    public Parameters G() {
        synchronized (this.d) {
            return this.h;
        }
    }
    
    protected ExoTrackSelection.Definition[] V(final MappedTrackInfo mappedTrackInfo, final int[][][] array, final int[] array2, final Parameters parameters) throws ExoPlaybackException {
        final int d = mappedTrackInfo.d();
        final ExoTrackSelection.Definition[] array3 = new ExoTrackSelection.Definition[d];
        final Pair<ExoTrackSelection.Definition, Integer> a0 = this.a0(mappedTrackInfo, array, array2, parameters);
        if (a0 != null) {
            array3[a0.second] = (ExoTrackSelection.Definition)a0.first;
        }
        final Pair<ExoTrackSelection.Definition, Integer> w = this.W(mappedTrackInfo, array, array2, parameters);
        if (w != null) {
            array3[w.second] = (ExoTrackSelection.Definition)w.first;
        }
        final int n = 0;
        String c;
        if (w == null) {
            c = null;
        }
        else {
            final Object first = w.first;
            c = ((ExoTrackSelection.Definition)first).a.c(((ExoTrackSelection.Definition)first).b[0]).c;
        }
        final Pair<ExoTrackSelection.Definition, Integer> y = this.Y(mappedTrackInfo, array, parameters, c);
        int i = n;
        if (y != null) {
            array3[y.second] = (ExoTrackSelection.Definition)y.first;
            i = n;
        }
        while (i < d) {
            final int e = mappedTrackInfo.e(i);
            if (e != 2 && e != 1 && e != 3) {
                array3[i] = this.X(e, mappedTrackInfo.f(i), array[i], parameters);
            }
            ++i;
        }
        return array3;
    }
    
    protected Pair<ExoTrackSelection.Definition, Integer> W(final MappedTrackInfo mappedTrackInfo, final int[][][] array, final int[] array2, final Parameters parameters) throws ExoPlaybackException {
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= mappedTrackInfo.d()) {
                break;
            }
            if (2 == mappedTrackInfo.e(n) && mappedTrackInfo.f(n).a > 0) {
                b2 = true;
                break;
            }
            ++n;
        }
        return this.Z(1, mappedTrackInfo, array, (TrackInfo.Factory<TrackInfo>)new d4.d(this, parameters, b2), com.google.android.exoplayer2.trackselection.a.a);
    }
    
    protected ExoTrackSelection.Definition X(int i, final TrackGroupArray trackGroupArray, final int[][] array, final Parameters parameters) throws ExoPlaybackException {
        final ExoTrackSelection.Definition definition = null;
        TrackGroup trackGroup = null;
        c c = null;
        int j = 0;
        int n = 0;
        while (j < trackGroupArray.a) {
            final TrackGroup b = trackGroupArray.b(j);
            final int[] array2 = array[j];
            TrackGroup trackGroup2;
            int n2;
            c c2;
            c c3;
            for (i = 0; i < b.a; ++i, trackGroup = trackGroup2, n = n2, c = c2) {
                trackGroup2 = trackGroup;
                n2 = n;
                c2 = c;
                if (L(array2[i], parameters.Y)) {
                    c3 = new c(b.c(i), array2[i]);
                    if (c != null) {
                        trackGroup2 = trackGroup;
                        n2 = n;
                        c2 = c;
                        if (c3.a(c) <= 0) {
                            continue;
                        }
                    }
                    trackGroup2 = b;
                    n2 = i;
                    c2 = c3;
                }
            }
            ++j;
        }
        Object o;
        if (trackGroup == null) {
            o = definition;
        }
        else {
            o = new ExoTrackSelection.Definition(trackGroup, new int[] { n });
        }
        return (ExoTrackSelection.Definition)o;
    }
    
    protected Pair<ExoTrackSelection.Definition, Integer> Y(final MappedTrackInfo mappedTrackInfo, final int[][][] array, final Parameters parameters, final String s) throws ExoPlaybackException {
        return this.Z(3, mappedTrackInfo, array, (TrackInfo.Factory<TrackInfo>)new d4.b(parameters, s), com.google.android.exoplayer2.trackselection.b.a);
    }
    
    protected Pair<ExoTrackSelection.Definition, Integer> a0(final MappedTrackInfo mappedTrackInfo, final int[][][] array, final int[] array2, final Parameters parameters) throws ExoPlaybackException {
        return this.Z(2, mappedTrackInfo, array, (TrackInfo.Factory<TrackInfo>)new d4.c(parameters, array2), com.google.android.exoplayer2.trackselection.c.a);
    }
    
    @Override
    public /* bridge */ TrackSelectionParameters b() {
        return this.G();
    }
    
    @Override
    public boolean e() {
        return true;
    }
    
    @Override
    public void g() {
        synchronized (this.d) {
            if (Util.a >= 32) {
                final d i = this.i;
                if (i != null) {
                    i.f();
                }
            }
            monitorexit(this.d);
            super.g();
        }
    }
    
    @Override
    public void i(final AudioAttributes j) {
        synchronized (this.d) {
            final boolean b = !this.j.equals(j);
            this.j = j;
            monitorexit(this.d);
            if (b) {
                this.S();
            }
        }
    }
    
    @Override
    public void j(final TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            this.b0((Parameters)trackSelectionParameters);
        }
        this.b0(new Parameters.Builder(this.G(), null).h0(trackSelectionParameters).c0());
    }
    
    @Override
    protected final Pair<RendererConfiguration[], ExoTrackSelection[]> n(final MappedTrackInfo mappedTrackInfo, final int[][][] array, final int[] array2, final MediaSource.MediaPeriodId mediaPeriodId, final Timeline timeline) throws ExoPlaybackException {
        synchronized (this.d) {
            final Parameters h = this.h;
            if (h.X && Util.a >= 32) {
                final d i = this.i;
                if (i != null) {
                    i.b(this, Assertions.i(Looper.myLooper()));
                }
            }
            monitorexit(this.d);
            final int d = mappedTrackInfo.d();
            final ExoTrackSelection.Definition[] v = this.V(mappedTrackInfo, array, array2, h);
            B(mappedTrackInfo, h, v);
            A(mappedTrackInfo, h, v);
            for (int j = 0; j < d; ++j) {
                final int e = mappedTrackInfo.e(j);
                if (h.m(j) || ((ImmutableCollection)h.K).contains((Object)e)) {
                    v[j] = null;
                }
            }
            final ExoTrackSelection[] a = this.f.a(v, this.a(), mediaPeriodId, timeline);
            final RendererConfiguration[] array3 = new RendererConfiguration[d];
            for (int k = 0; k < d; ++k) {
                final int e2 = mappedTrackInfo.e(k);
                final boolean m = h.m(k);
                final boolean b = true;
                int n = 0;
                Label_0273: {
                    if (!m && !((ImmutableCollection)h.K).contains((Object)e2)) {
                        n = (b ? 1 : 0);
                        if (mappedTrackInfo.e(k) == -2) {
                            break Label_0273;
                        }
                        if (a[k] != null) {
                            n = (b ? 1 : 0);
                            break Label_0273;
                        }
                    }
                    n = 0;
                }
                RendererConfiguration b2;
                if (n != 0) {
                    b2 = RendererConfiguration.b;
                }
                else {
                    b2 = null;
                }
                array3[k] = b2;
            }
            if (h.Z) {
                R(mappedTrackInfo, array, array3, a);
            }
            return (Pair<RendererConfiguration[], ExoTrackSelection[]>)Pair.create((Object)array3, (Object)a);
        }
    }
    
    public static final class Parameters extends TrackSelectionParameters
    {
        public static final Parameters d0;
        @Deprecated
        public static final Parameters e0;
        public static final Creator<Parameters> f0;
        public final boolean O;
        public final boolean P;
        public final boolean Q;
        public final boolean R;
        public final boolean S;
        public final boolean T;
        public final boolean U;
        public final boolean V;
        public final boolean W;
        public final boolean X;
        public final boolean Y;
        public final boolean Z;
        public final boolean a0;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> b0;
        private final SparseBooleanArray c0;
        
        static {
            e0 = (d0 = new Builder().c0());
            f0 = (Creator)h.a;
        }
        
        private Parameters(final Builder builder) {
            super((TrackSelectionParameters.Builder)builder);
            this.O = Builder.V(builder);
            this.P = Builder.W(builder);
            this.Q = Builder.X(builder);
            this.R = Builder.Y(builder);
            this.S = Builder.Z(builder);
            this.T = Builder.a0(builder);
            this.U = Builder.b0(builder);
            this.V = Builder.N(builder);
            this.W = Builder.O(builder);
            this.X = Builder.P(builder);
            this.Y = Builder.Q(builder);
            this.Z = Builder.R(builder);
            this.a0 = Builder.S(builder);
            this.b0 = (SparseArray<Map<TrackGroupArray, SelectionOverride>>)Builder.T(builder);
            this.c0 = Builder.U(builder);
        }
        
        Parameters(final Builder builder, final DefaultTrackSelector$a object) {
            this(builder);
        }
        
        public static Parameters d(final Bundle bundle) {
            return p(bundle);
        }
        
        static SparseArray e(final Parameters parameters) {
            return parameters.b0;
        }
        
        static SparseBooleanArray f(final Parameters parameters) {
            return parameters.c0;
        }
        
        private static boolean g(final SparseBooleanArray sparseBooleanArray, final SparseBooleanArray sparseBooleanArray2) {
            final int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; ++i) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }
        
        private static boolean h(final SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, final SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            final int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; ++i) {
                final int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !i((Map<TrackGroupArray, SelectionOverride>)sparseArray.valueAt(i), (Map<TrackGroupArray, SelectionOverride>)sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }
        
        private static boolean i(final Map<TrackGroupArray, SelectionOverride> map, final Map<TrackGroupArray, SelectionOverride> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (final Map.Entry<TrackGroupArray, V> entry : map.entrySet()) {
                final TrackGroupArray trackGroupArray = entry.getKey();
                if (!map2.containsKey(trackGroupArray) || !Util.c(entry.getValue(), map2.get(trackGroupArray))) {
                    return false;
                }
            }
            return true;
        }
        
        public static Parameters k(final Context context) {
            return new Builder(context).c0();
        }
        
        private static int[] l(final SparseBooleanArray sparseBooleanArray) {
            final int[] array = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); ++i) {
                array[i] = sparseBooleanArray.keyAt(i);
            }
            return array;
        }
        
        private static Parameters p(final Bundle bundle) {
            return new Builder(bundle, null).c0();
        }
        
        private static void q(final Bundle bundle, final SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            final ArrayList list = new ArrayList();
            final ArrayList list2 = new ArrayList();
            final SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); ++i) {
                final int key = sparseArray.keyAt(i);
                for (final Map.Entry<K, SelectionOverride> entry : ((Map)sparseArray.valueAt(i)).entrySet()) {
                    final SelectionOverride selectionOverride = entry.getValue();
                    if (selectionOverride != null) {
                        sparseArray2.put(list2.size(), (Object)selectionOverride);
                    }
                    list2.add(entry.getKey());
                    list.add(key);
                }
                bundle.putIntArray(TrackSelectionParameters.c(1010), Ints.n((Collection)list));
                bundle.putParcelableArrayList(TrackSelectionParameters.c(1011), (ArrayList)BundleableUtil.d((Collection<Bundleable>)list2));
                bundle.putSparseParcelableArray(TrackSelectionParameters.c(1012), (SparseArray)BundleableUtil.e((android.util.SparseArray<Bundleable>)sparseArray2));
            }
        }
        
        @Override
        public /* bridge */ TrackSelectionParameters.Builder a() {
            return this.j();
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && Parameters.class == o.getClass()) {
                final Parameters parameters = (Parameters)o;
                if (!super.equals(parameters) || this.O != parameters.O || this.P != parameters.P || this.Q != parameters.Q || this.R != parameters.R || this.S != parameters.S || this.T != parameters.T || this.U != parameters.U || this.V != parameters.V || this.W != parameters.W || this.X != parameters.X || this.Y != parameters.Y || this.Z != parameters.Z || this.a0 != parameters.a0 || !g(this.c0, parameters.c0) || !h(this.b0, parameters.b0)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return (((((((((((((super.hashCode() + 31) * 31 + (this.O ? 1 : 0)) * 31 + (this.P ? 1 : 0)) * 31 + (this.Q ? 1 : 0)) * 31 + (this.R ? 1 : 0)) * 31 + (this.S ? 1 : 0)) * 31 + (this.T ? 1 : 0)) * 31 + (this.U ? 1 : 0)) * 31 + (this.V ? 1 : 0)) * 31 + (this.W ? 1 : 0)) * 31 + (this.X ? 1 : 0)) * 31 + (this.Y ? 1 : 0)) * 31 + (this.Z ? 1 : 0)) * 31 + (this.a0 ? 1 : 0);
        }
        
        public Builder j() {
            return new Builder(this, null);
        }
        
        public boolean m(final int n) {
            return this.c0.get(n);
        }
        
        @Deprecated
        public SelectionOverride n(final int n, final TrackGroupArray trackGroupArray) {
            final Map map = (Map)this.b0.get(n);
            SelectionOverride selectionOverride;
            if (map != null) {
                selectionOverride = map.get(trackGroupArray);
            }
            else {
                selectionOverride = null;
            }
            return selectionOverride;
        }
        
        @Deprecated
        public boolean o(final int n, final TrackGroupArray trackGroupArray) {
            final Map map = (Map)this.b0.get(n);
            return map != null && map.containsKey(trackGroupArray);
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = super.toBundle();
            bundle.putBoolean(TrackSelectionParameters.c(1000), this.O);
            bundle.putBoolean(TrackSelectionParameters.c(1001), this.P);
            bundle.putBoolean(TrackSelectionParameters.c(1002), this.Q);
            bundle.putBoolean(TrackSelectionParameters.c(1014), this.R);
            bundle.putBoolean(TrackSelectionParameters.c(1003), this.S);
            bundle.putBoolean(TrackSelectionParameters.c(1004), this.T);
            bundle.putBoolean(TrackSelectionParameters.c(1005), this.U);
            bundle.putBoolean(TrackSelectionParameters.c(1006), this.V);
            bundle.putBoolean(TrackSelectionParameters.c(1015), this.W);
            bundle.putBoolean(TrackSelectionParameters.c(1016), this.X);
            bundle.putBoolean(TrackSelectionParameters.c(1007), this.Y);
            bundle.putBoolean(TrackSelectionParameters.c(1008), this.Z);
            bundle.putBoolean(TrackSelectionParameters.c(1009), this.a0);
            q(bundle, this.b0);
            bundle.putIntArray(TrackSelectionParameters.c(1013), l(this.c0));
            return bundle;
        }
        
        public static final class Builder extends TrackSelectionParameters.Builder
        {
            private boolean A;
            private boolean B;
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private final SparseArray<Map<TrackGroupArray, SelectionOverride>> N;
            private final SparseBooleanArray O;
            
            @Deprecated
            public Builder() {
                this.N = (SparseArray<Map<TrackGroupArray, SelectionOverride>>)new SparseArray();
                this.O = new SparseBooleanArray();
                this.f0();
            }
            
            public Builder(final Context context) {
                super(context);
                this.N = (SparseArray<Map<TrackGroupArray, SelectionOverride>>)new SparseArray();
                this.O = new SparseBooleanArray();
                this.f0();
            }
            
            private Builder(final Bundle bundle) {
                super(bundle);
                this.f0();
                final Parameters d0 = Parameters.d0;
                this.t0(bundle.getBoolean(TrackSelectionParameters.c(1000), d0.O));
                this.o0(bundle.getBoolean(TrackSelectionParameters.c(1001), d0.P));
                this.p0(bundle.getBoolean(TrackSelectionParameters.c(1002), d0.Q));
                this.n0(bundle.getBoolean(TrackSelectionParameters.c(1014), d0.R));
                this.r0(bundle.getBoolean(TrackSelectionParameters.c(1003), d0.S));
                this.k0(bundle.getBoolean(TrackSelectionParameters.c(1004), d0.T));
                this.l0(bundle.getBoolean(TrackSelectionParameters.c(1005), d0.U));
                this.i0(bundle.getBoolean(TrackSelectionParameters.c(1006), d0.V));
                this.j0(bundle.getBoolean(TrackSelectionParameters.c(1015), d0.W));
                this.q0(bundle.getBoolean(TrackSelectionParameters.c(1016), d0.X));
                this.s0(bundle.getBoolean(TrackSelectionParameters.c(1007), d0.Y));
                this.B0(bundle.getBoolean(TrackSelectionParameters.c(1008), d0.Z));
                this.m0(bundle.getBoolean(TrackSelectionParameters.c(1009), d0.a0));
                this.N = (SparseArray<Map<TrackGroupArray, SelectionOverride>>)new SparseArray();
                this.z0(bundle);
                this.O = this.g0(bundle.getIntArray(TrackSelectionParameters.c(1013)));
            }
            
            Builder(final Bundle bundle, final DefaultTrackSelector$a object) {
                this(bundle);
            }
            
            private Builder(final Parameters parameters) {
                super(parameters);
                this.A = parameters.O;
                this.B = parameters.P;
                this.C = parameters.Q;
                this.D = parameters.R;
                this.E = parameters.S;
                this.F = parameters.T;
                this.G = parameters.U;
                this.H = parameters.V;
                this.I = parameters.W;
                this.J = parameters.X;
                this.K = parameters.Y;
                this.L = parameters.Z;
                this.M = parameters.a0;
                this.N = e0((SparseArray<Map<TrackGroupArray, SelectionOverride>>)Parameters.e(parameters));
                this.O = Parameters.f(parameters).clone();
            }
            
            Builder(final Parameters parameters, final DefaultTrackSelector$a object) {
                this(parameters);
            }
            
            static boolean N(final Builder builder) {
                return builder.H;
            }
            
            static boolean O(final Builder builder) {
                return builder.I;
            }
            
            static boolean P(final Builder builder) {
                return builder.J;
            }
            
            static boolean Q(final Builder builder) {
                return builder.K;
            }
            
            static boolean R(final Builder builder) {
                return builder.L;
            }
            
            static boolean S(final Builder builder) {
                return builder.M;
            }
            
            static SparseArray T(final Builder builder) {
                return builder.N;
            }
            
            static SparseBooleanArray U(final Builder builder) {
                return builder.O;
            }
            
            static boolean V(final Builder builder) {
                return builder.A;
            }
            
            static boolean W(final Builder builder) {
                return builder.B;
            }
            
            static boolean X(final Builder builder) {
                return builder.C;
            }
            
            static boolean Y(final Builder builder) {
                return builder.D;
            }
            
            static boolean Z(final Builder builder) {
                return builder.E;
            }
            
            static boolean a0(final Builder builder) {
                return builder.F;
            }
            
            static boolean b0(final Builder builder) {
                return builder.G;
            }
            
            private static SparseArray<Map<TrackGroupArray, SelectionOverride>> e0(final SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
                final SparseArray sparseArray2 = new SparseArray();
                for (int i = 0; i < sparseArray.size(); ++i) {
                    sparseArray2.put(sparseArray.keyAt(i), (Object)new HashMap((Map<?, ?>)sparseArray.valueAt(i)));
                }
                return (SparseArray<Map<TrackGroupArray, SelectionOverride>>)sparseArray2;
            }
            
            private void f0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }
            
            private SparseBooleanArray g0(final int[] array) {
                if (array == null) {
                    return new SparseBooleanArray();
                }
                final SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(array.length);
                for (int length = array.length, i = 0; i < length; ++i) {
                    sparseBooleanArray.append(array[i], true);
                }
                return sparseBooleanArray;
            }
            
            private void z0(final Bundle bundle) {
                final int[] intArray = bundle.getIntArray(TrackSelectionParameters.c(1010));
                final ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.c(1011));
                ImmutableList list;
                if (parcelableArrayList == null) {
                    list = ImmutableList.of();
                }
                else {
                    list = BundleableUtil.b(TrackGroupArray.e, parcelableArrayList);
                }
                final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(TrackSelectionParameters.c(1012));
                SparseArray c;
                if (sparseParcelableArray == null) {
                    c = new SparseArray();
                }
                else {
                    c = BundleableUtil.c(SelectionOverride.e, (SparseArray<Bundle>)sparseParcelableArray);
                }
                if (intArray != null) {
                    if (intArray.length == ((List)list).size()) {
                        for (int i = 0; i < intArray.length; ++i) {
                            this.y0(intArray[i], (TrackGroupArray)((List)list).get(i), (SelectionOverride)c.get(i));
                        }
                    }
                }
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters A() {
                return this.c0();
            }
            
            public Builder A0(final int n, final boolean b) {
                super.K(n, b);
                return this;
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters.Builder B(final int n) {
                return this.d0(n);
            }
            
            public Builder B0(final boolean l) {
                this.L = l;
                return this;
            }
            
            public Builder C0(final int n, final int n2, final boolean b) {
                super.L(n, n2, b);
                return this;
            }
            
            public Builder D0(final Context context, final boolean b) {
                super.M(context, b);
                return this;
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters.Builder G(final int n) {
                return this.v0(n);
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters.Builder H(final TrackSelectionOverride trackSelectionOverride) {
                return this.w0(trackSelectionOverride);
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters.Builder I(final Context context) {
                return this.x0(context);
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters.Builder K(final int n, final boolean b) {
                return this.A0(n, b);
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters.Builder L(final int n, final int n2, final boolean b) {
                return this.C0(n, n2, b);
            }
            
            @Override
            public /* bridge */ TrackSelectionParameters.Builder M(final Context context, final boolean b) {
                return this.D0(context, b);
            }
            
            public Parameters c0() {
                return new Parameters(this, null);
            }
            
            public Builder d0(final int n) {
                super.B(n);
                return this;
            }
            
            protected Builder h0(final TrackSelectionParameters trackSelectionParameters) {
                super.E(trackSelectionParameters);
                return this;
            }
            
            public Builder i0(final boolean h) {
                this.H = h;
                return this;
            }
            
            public Builder j0(final boolean i) {
                this.I = i;
                return this;
            }
            
            public Builder k0(final boolean f) {
                this.F = f;
                return this;
            }
            
            public Builder l0(final boolean g) {
                this.G = g;
                return this;
            }
            
            public Builder m0(final boolean m) {
                this.M = m;
                return this;
            }
            
            public Builder n0(final boolean d) {
                this.D = d;
                return this;
            }
            
            public Builder o0(final boolean b) {
                this.B = b;
                return this;
            }
            
            public Builder p0(final boolean c) {
                this.C = c;
                return this;
            }
            
            public Builder q0(final boolean j) {
                this.J = j;
                return this;
            }
            
            public Builder r0(final boolean e) {
                this.E = e;
                return this;
            }
            
            public Builder s0(final boolean k) {
                this.K = k;
                return this;
            }
            
            public Builder t0(final boolean a) {
                this.A = a;
                return this;
            }
            
            public Builder u0(final boolean b) {
                super.F(b);
                return this;
            }
            
            public Builder v0(final int n) {
                super.G(n);
                return this;
            }
            
            public Builder w0(final TrackSelectionOverride trackSelectionOverride) {
                super.H(trackSelectionOverride);
                return this;
            }
            
            public Builder x0(final Context context) {
                super.I(context);
                return this;
            }
            
            @Deprecated
            public Builder y0(final int n, final TrackGroupArray trackGroupArray, final SelectionOverride selectionOverride) {
                Map map;
                if ((map = (Map)this.N.get(n)) == null) {
                    map = new HashMap();
                    this.N.put(n, (Object)map);
                }
                if (map.containsKey(trackGroupArray) && Util.c(map.get(trackGroupArray), selectionOverride)) {
                    return this;
                }
                map.put(trackGroupArray, selectionOverride);
                return this;
            }
        }
    }
    
    @Deprecated
    public static final class ParametersBuilder extends Builder
    {
        private final Parameters.Builder A;
        
        @Deprecated
        public ParametersBuilder() {
            this.A = new Parameters.Builder();
        }
        
        @Override
        public /* bridge */ TrackSelectionParameters A() {
            return this.N();
        }
        
        @Override
        public /* bridge */ Builder B(final int n) {
            return this.O(n);
        }
        
        @Override
        public /* bridge */ Builder G(final int n) {
            return this.P(n);
        }
        
        @Override
        public /* bridge */ Builder H(final TrackSelectionOverride trackSelectionOverride) {
            return this.Q(trackSelectionOverride);
        }
        
        @Override
        public /* bridge */ Builder I(final Context context) {
            return this.R(context);
        }
        
        @Override
        public /* bridge */ Builder K(final int n, final boolean b) {
            return this.S(n, b);
        }
        
        @Override
        public /* bridge */ Builder L(final int n, final int n2, final boolean b) {
            return this.T(n, n2, b);
        }
        
        @Override
        public /* bridge */ Builder M(final Context context, final boolean b) {
            return this.U(context, b);
        }
        
        public Parameters N() {
            return this.A.c0();
        }
        
        public ParametersBuilder O(final int n) {
            this.A.d0(n);
            return this;
        }
        
        public ParametersBuilder P(final int n) {
            this.A.v0(n);
            return this;
        }
        
        public ParametersBuilder Q(final TrackSelectionOverride trackSelectionOverride) {
            this.A.w0(trackSelectionOverride);
            return this;
        }
        
        public ParametersBuilder R(final Context context) {
            this.A.x0(context);
            return this;
        }
        
        public ParametersBuilder S(final int n, final boolean b) {
            this.A.A0(n, b);
            return this;
        }
        
        public ParametersBuilder T(final int n, final int n2, final boolean b) {
            this.A.C0(n, n2, b);
            return this;
        }
        
        public ParametersBuilder U(final Context context, final boolean b) {
            this.A.D0(context, b);
            return this;
        }
    }
    
    public static final class SelectionOverride implements Bundleable
    {
        public static final Creator<SelectionOverride> e;
        public final int a;
        public final int[] b;
        public final int c;
        public final int d;
        
        static {
            e = (Creator)i.a;
        }
        
        public SelectionOverride(final int a, final int[] array, final int d) {
            this.a = a;
            final int[] copy = Arrays.copyOf(array, array.length);
            this.b = copy;
            this.c = array.length;
            this.d = d;
            Arrays.sort(copy);
        }
        
        public static SelectionOverride a(final Bundle bundle) {
            return c(bundle);
        }
        
        private static String b(final int n) {
            return Integer.toString(n, 36);
        }
        
        private static SelectionOverride c(final Bundle bundle) {
            final boolean b = false;
            final int int1 = bundle.getInt(b(0), -1);
            final int[] intArray = bundle.getIntArray(b(1));
            final int int2 = bundle.getInt(b(2), -1);
            boolean b2 = b;
            if (int1 >= 0) {
                b2 = b;
                if (int2 >= 0) {
                    b2 = true;
                }
            }
            Assertions.a(b2);
            Assertions.e(intArray);
            return new SelectionOverride(int1, intArray, int2);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && SelectionOverride.class == o.getClass()) {
                final SelectionOverride selectionOverride = (SelectionOverride)o;
                if (this.a != selectionOverride.a || !Arrays.equals(this.b, selectionOverride.b) || this.d != selectionOverride.d) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return (this.a * 31 + Arrays.hashCode(this.b)) * 31 + this.d;
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putInt(b(0), this.a);
            bundle.putIntArray(b(1), this.b);
            bundle.putInt(b(2), this.d);
            return bundle;
        }
    }
    
    private abstract static class TrackInfo<T extends TrackInfo<T>>
    {
        public final int a;
        public final TrackGroup b;
        public final int c;
        public final Format d;
        
        public TrackInfo(final int a, final TrackGroup b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = b.c(c);
        }
        
        public abstract int a();
        
        public abstract boolean c(final T p0);
        
        public interface Factory<T extends TrackInfo<T>>
        {
            List<T> a(final int p0, final TrackGroup p1, final int[] p2);
        }
    }
    
    private static final class b extends TrackInfo<b> implements Comparable<b>
    {
        private final boolean A;
        private final int B;
        private final int C;
        private final int D;
        private final int E;
        private final boolean F;
        private final boolean G;
        private final int e;
        private final boolean f;
        private final String g;
        private final Parameters h;
        private final boolean i;
        private final int j;
        private final int p;
        private final int w;
        private final boolean x;
        private final int y;
        private final int z;
        
        public b(int i, final TrackGroup trackGroup, int n, final Parameters h, final int n2, final boolean b, final Predicate<Format> predicate) {
            super(i, trackGroup, n);
            this.h = h;
            this.g = DefaultTrackSelector.T(super.d.c);
            final boolean b2 = false;
            this.i = DefaultTrackSelector.L(n2, false);
            i = 0;
            int n3;
            while (true) {
                n = ((AbstractCollection)h.y).size();
                n3 = Integer.MAX_VALUE;
                if (i >= n) {
                    i = 0;
                    n = Integer.MAX_VALUE;
                    break;
                }
                final int d = DefaultTrackSelector.D(super.d, ((List<String>)h.y).get(i), false);
                if (d > 0) {
                    n = i;
                    i = d;
                    break;
                }
                ++i;
            }
            this.p = n;
            this.j = i;
            this.w = DefaultTrackSelector.v(super.d.e, h.z);
            final Format d2 = super.d;
            i = d2.e;
            this.x = (i == 0 || (i & 0x1) != 0x0);
            this.A = ((d2.d & 0x1) != 0x0);
            n = d2.J;
            this.B = n;
            this.C = d2.K;
            i = d2.h;
            this.D = i;
            this.f = ((i == -1 || i <= h.B) && (n == -1 || n <= h.A) && predicate.apply((Object)d2));
            while (true) {
                String[] i2;
                String w;
                boolean g;
                for (i2 = Util.i0(), i = 0; i < i2.length; ++i) {
                    n = DefaultTrackSelector.D(super.d, i2[i], false);
                    if (n > 0) {
                        this.y = i;
                        this.z = n;
                        i = 0;
                        while (true) {
                            n = n3;
                            if (i >= ((AbstractCollection)h.C).size()) {
                                break;
                            }
                            w = super.d.w;
                            if (w != null && w.equals(((List<Object>)h.C).get(i))) {
                                n = i;
                                break;
                            }
                            ++i;
                        }
                        this.E = n;
                        this.F = (RendererCapabilities.i(n2) == 128);
                        g = b2;
                        if (RendererCapabilities.t(n2) == 64) {
                            g = true;
                        }
                        this.G = g;
                        this.e = this.h(n2, b);
                        return;
                    }
                }
                n = 0;
                i = Integer.MAX_VALUE;
                continue;
            }
        }
        
        public static int d(final List<b> list, final List<b> list2) {
            return Collections.max((Collection<? extends b>)list).f(Collections.max((Collection<? extends b>)list2));
        }
        
        public static ImmutableList<b> g(final int n, final TrackGroup trackGroup, final Parameters parameters, final int[] array, final boolean b, final Predicate<Format> predicate) {
            final ImmutableList$Builder builder = ImmutableList.builder();
            for (int i = 0; i < trackGroup.a; ++i) {
                builder.i((Object)new b(n, trackGroup, i, parameters, array[i], b, predicate));
            }
            return (ImmutableList<b>)builder.l();
        }
        
        private int h(int n, final boolean b) {
            if (!DefaultTrackSelector.L(n, this.h.Y)) {
                return 0;
            }
            if (!this.f && !this.h.S) {
                return 0;
            }
            if (DefaultTrackSelector.L(n, false) && this.f && super.d.h != -1) {
                final Parameters h = this.h;
                if (!h.I && !h.H && (h.a0 || !b)) {
                    n = 2;
                    return n;
                }
            }
            n = 1;
            return n;
        }
        
        @Override
        public int a() {
            return this.e;
        }
        
        @Override
        public /* bridge */ boolean c(final TrackInfo trackInfo) {
            return this.i((b)trackInfo);
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.f((b)o);
        }
        
        public int f(final b b) {
            Ordering ordering;
            if (this.f && this.i) {
                ordering = DefaultTrackSelector.x();
            }
            else {
                ordering = DefaultTrackSelector.x().reverse();
            }
            final ComparisonChain g = ComparisonChain.k().h(this.i, b.i).g((Object)this.p, (Object)b.p, (Comparator)Ordering.natural().reverse()).d(this.j, b.j).d(this.w, b.w).h(this.A, b.A).h(this.x, b.x).g((Object)this.y, (Object)b.y, (Comparator)Ordering.natural().reverse()).d(this.z, b.z).h(this.f, b.f).g((Object)this.E, (Object)b.E, (Comparator)Ordering.natural().reverse());
            final int d = this.D;
            final int d2 = b.D;
            Ordering ordering2;
            if (this.h.H) {
                ordering2 = DefaultTrackSelector.x().reverse();
            }
            else {
                ordering2 = DefaultTrackSelector.y();
            }
            final ComparisonChain g2 = g.g((Object)d, (Object)d2, (Comparator)ordering2).h(this.F, b.F).h(this.G, b.G).g((Object)this.B, (Object)b.B, (Comparator)ordering).g((Object)this.C, (Object)b.C, (Comparator)ordering);
            final int d3 = this.D;
            final int d4 = b.D;
            if (!Util.c(this.g, b.g)) {
                ordering = DefaultTrackSelector.y();
            }
            return g2.g((Object)d3, (Object)d4, (Comparator)ordering).j();
        }
        
        public boolean i(final b b) {
            final Parameters h = this.h;
            if (!h.V) {
                final int j = super.d.J;
                if (j == -1 || j != b.d.J) {
                    return false;
                }
            }
            if (!h.T) {
                final String w = super.d.w;
                if (w == null || !TextUtils.equals((CharSequence)w, (CharSequence)b.d.w)) {
                    return false;
                }
            }
            final Parameters h2 = this.h;
            if (!h2.U) {
                final int k = super.d.K;
                if (k == -1 || k != b.d.K) {
                    return false;
                }
            }
            if (h2.W || (this.F == b.F && this.G == b.G)) {
                return true;
            }
            return false;
        }
    }
    
    private static final class c implements Comparable<c>
    {
        private final boolean a;
        private final boolean b;
        
        public c(final Format format, final int n) {
            final int d = format.d;
            boolean a = true;
            if ((d & 0x1) == 0x0) {
                a = false;
            }
            this.a = a;
            this.b = DefaultTrackSelector.L(n, false);
        }
        
        public int a(final c c) {
            return ComparisonChain.k().h(this.b, c.b).h(this.a, c.a).j();
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((c)o);
        }
    }
    
    private static class d
    {
        private final Spatializer a;
        private final boolean b;
        private Handler c;
        private Spatializer$OnSpatializerStateChangedListener d;
        
        private d(final Spatializer a) {
            this.a = a;
            this.b = (a.getImmersiveAudioLevel() != 0);
        }
        
        public static d g(final Context context) {
            final AudioManager audioManager = (AudioManager)context.getSystemService("audio");
            d d;
            if (audioManager == null) {
                d = null;
            }
            else {
                d = new d(audioManager.getSpatializer());
            }
            return d;
        }
        
        public boolean a(final AudioAttributes audioAttributes, final Format format) {
            int j;
            if ("audio/eac3-joc".equals(format.w) && format.J == 16) {
                j = 12;
            }
            else {
                j = format.J;
            }
            final AudioFormat$Builder setChannelMask = new AudioFormat$Builder().setEncoding(2).setChannelMask(Util.G(j));
            final int k = format.K;
            if (k != -1) {
                setChannelMask.setSampleRate(k);
            }
            return this.a.canBeSpatialized(audioAttributes.b().a, setChannelMask.build());
        }
        
        public void b(final DefaultTrackSelector defaultTrackSelector, final Looper looper) {
            if (this.d == null) {
                if (this.c == null) {
                    this.d = (Spatializer$OnSpatializerStateChangedListener)new Spatializer$OnSpatializerStateChangedListener(this, defaultTrackSelector) {
                        final DefaultTrackSelector a;
                        
                        public void onSpatializerAvailableChanged(final Spatializer spatializer, final boolean b) {
                            DefaultTrackSelector.z(this.a);
                        }
                        
                        public void onSpatializerEnabledChanged(final Spatializer spatializer, final boolean b) {
                            DefaultTrackSelector.z(this.a);
                        }
                    };
                    final Handler c = new Handler(looper);
                    this.c = c;
                    final Spatializer a = this.a;
                    Objects.requireNonNull(c);
                    a.addOnSpatializerStateChangedListener((Executor)new n(c), this.d);
                }
            }
        }
        
        public boolean c() {
            return this.a.isAvailable();
        }
        
        public boolean d() {
            return this.a.isEnabled();
        }
        
        public boolean e() {
            return this.b;
        }
        
        public void f() {
            final Spatializer$OnSpatializerStateChangedListener d = this.d;
            if (d != null) {
                if (this.c != null) {
                    this.a.removeOnSpatializerStateChangedListener(d);
                    Util.j(this.c).removeCallbacksAndMessages((Object)null);
                    this.c = null;
                    this.d = null;
                }
            }
        }
    }
    
    private static final class e extends TrackInfo<e> implements Comparable<e>
    {
        private final int e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final int i;
        private final int j;
        private final int p;
        private final int w;
        private final boolean x;
        
        public e(int i, final TrackGroup trackGroup, int v, final Parameters parameters, final int n, final String s) {
            super(i, trackGroup, v);
            final int n2 = 0;
            this.f = DefaultTrackSelector.L(n, false);
            i = (super.d.d & ~parameters.F);
            this.g = ((i & 0x1) != 0x0);
            this.h = ((i & 0x2) != 0x0);
            v = Integer.MAX_VALUE;
            ImmutableList list;
            if (((AbstractCollection)parameters.D).isEmpty()) {
                list = ImmutableList.of((Object)"");
            }
            else {
                list = parameters.D;
            }
            while (true) {
                int d;
                int d2;
                for (i = 0; i < ((AbstractCollection)list).size(); ++i) {
                    d = DefaultTrackSelector.D(super.d, ((List<String>)list).get(i), parameters.G);
                    if (d > 0) {
                        v = i;
                        i = d;
                        this.i = v;
                        this.j = i;
                        v = DefaultTrackSelector.v(super.d.e, parameters.E);
                        this.p = v;
                        this.x = ((super.d.e & 0x440) != 0x0);
                        d2 = DefaultTrackSelector.D(super.d, s, DefaultTrackSelector.T(s) == null);
                        this.w = d2;
                        if (i <= 0 && (!((AbstractCollection)parameters.D).isEmpty() || v <= 0) && !this.g && (!this.h || d2 <= 0)) {
                            v = 0;
                        }
                        else {
                            v = 1;
                        }
                        i = n2;
                        if (DefaultTrackSelector.L(n, parameters.Y)) {
                            i = n2;
                            if (v != 0) {
                                i = 1;
                            }
                        }
                        this.e = i;
                        return;
                    }
                }
                i = 0;
                continue;
            }
        }
        
        public static int d(final List<e> list, final List<e> list2) {
            return list.get(0).f(list2.get(0));
        }
        
        public static ImmutableList<e> g(final int n, final TrackGroup trackGroup, final Parameters parameters, final int[] array, final String s) {
            final ImmutableList$Builder builder = ImmutableList.builder();
            for (int i = 0; i < trackGroup.a; ++i) {
                builder.i((Object)new e(n, trackGroup, i, parameters, array[i], s));
            }
            return (ImmutableList<e>)builder.l();
        }
        
        @Override
        public int a() {
            return this.e;
        }
        
        @Override
        public /* bridge */ boolean c(final TrackInfo trackInfo) {
            return this.h((e)trackInfo);
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.f((e)o);
        }
        
        public int f(final e e) {
            final ComparisonChain h = ComparisonChain.k().h(this.f, e.f).g((Object)this.i, (Object)e.i, (Comparator)Ordering.natural().reverse()).d(this.j, e.j).d(this.p, e.p).h(this.g, e.g);
            final boolean h2 = this.h;
            final boolean h3 = e.h;
            Ordering ordering;
            if (this.j == 0) {
                ordering = Ordering.natural();
            }
            else {
                ordering = Ordering.natural().reverse();
            }
            ComparisonChain comparisonChain = h.g((Object)h2, (Object)h3, (Comparator)ordering).d(this.w, e.w);
            if (this.p == 0) {
                comparisonChain = comparisonChain.i(this.x, e.x);
            }
            return comparisonChain.j();
        }
        
        public boolean h(final e e) {
            return false;
        }
    }
    
    private static final class f extends TrackInfo<f>
    {
        private final boolean A;
        private final boolean B;
        private final int C;
        private final boolean e;
        private final Parameters f;
        private final boolean g;
        private final boolean h;
        private final int i;
        private final int j;
        private final int p;
        private final int w;
        private final boolean x;
        private final boolean y;
        private final int z;
        
        public f(int n, final TrackGroup trackGroup, int n2, final Parameters f, final int n3, int p7, final boolean b) {
            super(n, trackGroup, n2);
            this.f = f;
            if (f.Q) {
                n2 = 24;
            }
            else {
                n2 = 16;
            }
            final boolean p8 = f.P;
            final boolean b2 = true;
            this.y = (p8 && (p7 & n2) != 0x0);
            boolean e = false;
            Label_0169: {
                if (b) {
                    final Format d = super.d;
                    n = d.B;
                    if (n == -1 || n <= f.a) {
                        n = d.C;
                        if (n == -1 || n <= f.b) {
                            final float d2 = d.D;
                            if (d2 == -1.0f || d2 <= f.c) {
                                n = d.h;
                                if (n == -1 || n <= f.d) {
                                    e = true;
                                    break Label_0169;
                                }
                            }
                        }
                    }
                }
                e = false;
            }
            this.e = e;
            boolean g = false;
            Label_0277: {
                if (b) {
                    final Format d3 = super.d;
                    n = d3.B;
                    if (n == -1 || n >= f.e) {
                        n = d3.C;
                        if (n == -1 || n >= f.f) {
                            final float d4 = d3.D;
                            if (d4 == -1.0f || d4 >= f.g) {
                                n = d3.h;
                                if (n == -1 || n >= f.h) {
                                    g = true;
                                    break Label_0277;
                                }
                            }
                        }
                    }
                }
                g = false;
            }
            this.g = g;
            this.h = DefaultTrackSelector.L(n3, false);
            final Format d5 = super.d;
            this.i = d5.h;
            this.j = d5.f();
            this.w = DefaultTrackSelector.v(super.d.e, f.x);
            n = super.d.e;
            this.x = (n == 0 || (n & 0x1) != 0x0);
            final int n4 = Integer.MAX_VALUE;
            n = 0;
            while (true) {
                p7 = n4;
                if (n >= ((AbstractCollection)f.w).size()) {
                    break;
                }
                final String w = super.d.w;
                if (w != null && w.equals(((List<Object>)f.w).get(n))) {
                    p7 = n;
                    break;
                }
                ++n;
            }
            this.p = p7;
            this.A = (RendererCapabilities.i(n3) == 128);
            this.B = (RendererCapabilities.t(n3) == 64 && b2);
            this.C = DefaultTrackSelector.w(super.d.w);
            this.z = this.l(n3, n2);
        }
        
        public static int d(final f f, final f f2) {
            return g(f, f2);
        }
        
        public static int f(final f f, final f f2) {
            return h(f, f2);
        }
        
        private static int g(final f f, final f f2) {
            ComparisonChain comparisonChain2;
            final ComparisonChain comparisonChain = comparisonChain2 = ComparisonChain.k().h(f.h, f2.h).d(f.w, f2.w).h(f.x, f2.x).h(f.e, f2.e).h(f.g, f2.g).g((Object)f.p, (Object)f2.p, (Comparator)Ordering.natural().reverse()).h(f.A, f2.A).h(f.B, f2.B);
            if (f.A) {
                comparisonChain2 = comparisonChain;
                if (f.B) {
                    comparisonChain2 = comparisonChain.d(f.C, f2.C);
                }
            }
            return comparisonChain2.j();
        }
        
        private static int h(final f f, final f f2) {
            Ordering ordering;
            if (f.e && f.h) {
                ordering = DefaultTrackSelector.x();
            }
            else {
                ordering = DefaultTrackSelector.x().reverse();
            }
            final ComparisonChain k = ComparisonChain.k();
            final int i = f.i;
            final int j = f2.i;
            Ordering ordering2;
            if (f.f.H) {
                ordering2 = DefaultTrackSelector.x().reverse();
            }
            else {
                ordering2 = DefaultTrackSelector.y();
            }
            return k.g((Object)i, (Object)j, (Comparator)ordering2).g((Object)f.j, (Object)f2.j, (Comparator)ordering).g((Object)f.i, (Object)f2.i, (Comparator)ordering).j();
        }
        
        public static int i(final List<f> list, final List<f> list2) {
            return ComparisonChain.k().g((Object)Collections.max((Collection<? extends f>)list, (Comparator<? super f>)com.google.android.exoplayer2.trackselection.d.a), (Object)Collections.max((Collection<? extends f>)list2, (Comparator<? super f>)com.google.android.exoplayer2.trackselection.d.a), (Comparator)com.google.android.exoplayer2.trackselection.d.a).d(list.size(), list2.size()).g((Object)Collections.max((Collection<? extends f>)list, (Comparator<? super f>)com.google.android.exoplayer2.trackselection.e.a), (Object)Collections.max((Collection<? extends f>)list2, (Comparator<? super f>)com.google.android.exoplayer2.trackselection.e.a), (Comparator)com.google.android.exoplayer2.trackselection.e.a).j();
        }
        
        public static ImmutableList<f> k(final int n, final TrackGroup trackGroup, final Parameters parameters, final int[] array, final int n2) {
            final int u = DefaultTrackSelector.u(trackGroup, parameters.i, parameters.j, parameters.p);
            final ImmutableList$Builder builder = ImmutableList.builder();
            for (int i = 0; i < trackGroup.a; ++i) {
                final int f = trackGroup.c(i).f();
                builder.i((Object)new f(n, trackGroup, i, parameters, array[i], n2, u == Integer.MAX_VALUE || (f != -1 && f <= u)));
            }
            return (ImmutableList<f>)builder.l();
        }
        
        private int l(int n, final int n2) {
            if ((super.d.e & 0x4000) != 0x0) {
                return 0;
            }
            if (!DefaultTrackSelector.L(n, this.f.Y)) {
                return 0;
            }
            if (!this.e && !this.f.O) {
                return 0;
            }
            if (DefaultTrackSelector.L(n, false) && this.g && this.e && super.d.h != -1) {
                final Parameters f = this.f;
                if (!f.I && !f.H && (n & n2) != 0x0) {
                    n = 2;
                    return n;
                }
            }
            n = 1;
            return n;
        }
        
        @Override
        public int a() {
            return this.z;
        }
        
        @Override
        public /* bridge */ boolean c(final TrackInfo trackInfo) {
            return this.m((f)trackInfo);
        }
        
        public boolean m(final f f) {
            return (this.y || Util.c(super.d.w, f.d.w)) && (this.f.R || (this.A == f.A && this.B == f.B));
        }
    }
}
