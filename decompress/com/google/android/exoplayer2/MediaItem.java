// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.AbstractCollection;
import android.os.Parcelable;
import com.google.common.collect.ImmutableList$Builder;
import java.util.Arrays;
import com.google.common.collect.ImmutableMap;
import java.util.UUID;
import java.util.Collection;
import java.util.Collections;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Bundle;

public final class MediaItem implements Bundleable
{
    public static final MediaItem i;
    public static final Creator<MediaItem> j;
    public final String a;
    public final LocalConfiguration b;
    @Deprecated
    public final PlaybackProperties c;
    public final LiveConfiguration d;
    public final MediaMetadata e;
    public final ClippingConfiguration f;
    @Deprecated
    public final ClippingProperties g;
    public final RequestMetadata h;
    
    static {
        i = new Builder().a();
        j = z0.a;
    }
    
    private MediaItem(final String a, final ClippingProperties clippingProperties, final PlaybackProperties playbackProperties, final LiveConfiguration d, final MediaMetadata e, final RequestMetadata h) {
        this.a = a;
        this.b = (LocalConfiguration)playbackProperties;
        this.c = playbackProperties;
        this.d = d;
        this.e = e;
        this.f = (ClippingConfiguration)clippingProperties;
        this.g = clippingProperties;
        this.h = h;
    }
    
    MediaItem(final String s, final ClippingProperties clippingProperties, final PlaybackProperties playbackProperties, final LiveConfiguration liveConfiguration, final MediaMetadata mediaMetadata, final RequestMetadata requestMetadata, final MediaItem$a object) {
        this(s, clippingProperties, playbackProperties, liveConfiguration, mediaMetadata, requestMetadata);
    }
    
    public static MediaItem a(final Bundle bundle) {
        return c(bundle);
    }
    
    private static MediaItem c(Bundle bundle) {
        final String s = Assertions.e(bundle.getString(f(0), ""));
        final Bundle bundle2 = bundle.getBundle(f(1));
        LiveConfiguration f;
        if (bundle2 == null) {
            f = LiveConfiguration.f;
        }
        else {
            f = LiveConfiguration.g.a(bundle2);
        }
        final Bundle bundle3 = bundle.getBundle(f(2));
        MediaMetadata r;
        if (bundle3 == null) {
            r = MediaMetadata.R;
        }
        else {
            r = MediaMetadata.S.a(bundle3);
        }
        final Bundle bundle4 = bundle.getBundle(f(3));
        ClippingProperties h;
        if (bundle4 == null) {
            h = ClippingProperties.h;
        }
        else {
            h = (ClippingProperties)ClippingConfiguration.g.a(bundle4);
        }
        bundle = bundle.getBundle(f(4));
        RequestMetadata d;
        if (bundle == null) {
            d = RequestMetadata.d;
        }
        else {
            d = RequestMetadata.e.a(bundle);
        }
        return new MediaItem(s, h, null, f, r, d);
    }
    
    public static MediaItem d(final Uri uri) {
        return new Builder().i(uri).a();
    }
    
    public static MediaItem e(final String s) {
        return new Builder().j(s).a();
    }
    
    private static String f(final int n) {
        return Integer.toString(n, 36);
    }
    
    public Builder b() {
        return new Builder(this, null);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof MediaItem)) {
            return false;
        }
        final MediaItem mediaItem = (MediaItem)o;
        if (!Util.c(this.a, mediaItem.a) || !this.f.equals(mediaItem.f) || !Util.c(this.b, mediaItem.b) || !Util.c(this.d, mediaItem.d) || !Util.c(this.e, mediaItem.e) || !Util.c(this.h, mediaItem.h)) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final LocalConfiguration b = this.b;
        int hashCode2;
        if (b != null) {
            hashCode2 = b.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        return ((((hashCode * 31 + hashCode2) * 31 + this.d.hashCode()) * 31 + this.f.hashCode()) * 31 + this.e.hashCode()) * 31 + this.h.hashCode();
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putString(f(0), this.a);
        bundle.putBundle(f(1), this.d.toBundle());
        bundle.putBundle(f(2), this.e.toBundle());
        bundle.putBundle(f(3), this.f.toBundle());
        bundle.putBundle(f(4), this.h.toBundle());
        return bundle;
    }
    
    public static final class AdsConfiguration
    {
        public final Uri a;
        public final Object b;
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof AdsConfiguration)) {
                return false;
            }
            final AdsConfiguration adsConfiguration = (AdsConfiguration)o;
            if (!this.a.equals((Object)adsConfiguration.a) || !Util.c(this.b, adsConfiguration.b)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final Object b = this.b;
            int hashCode2;
            if (b != null) {
                hashCode2 = b.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            return hashCode * 31 + hashCode2;
        }
        
        public static final class Builder
        {
        }
    }
    
    public static final class Builder
    {
        private String a;
        private Uri b;
        private String c;
        private ClippingConfiguration.Builder d;
        private DrmConfiguration.Builder e;
        private List<StreamKey> f;
        private String g;
        private ImmutableList<SubtitleConfiguration> h;
        private AdsConfiguration i;
        private Object j;
        private MediaMetadata k;
        private LiveConfiguration.Builder l;
        private RequestMetadata m;
        
        public Builder() {
            this.d = new ClippingConfiguration.Builder();
            this.e = new DrmConfiguration.Builder((MediaItem$a)null);
            this.f = Collections.emptyList();
            this.h = (ImmutableList<SubtitleConfiguration>)ImmutableList.of();
            this.l = new LiveConfiguration.Builder();
            this.m = RequestMetadata.d;
        }
        
        private Builder(final MediaItem mediaItem) {
            this();
            this.d = mediaItem.f.b();
            this.a = mediaItem.a;
            this.k = mediaItem.e;
            this.l = mediaItem.d.b();
            this.m = mediaItem.h;
            final LocalConfiguration b = mediaItem.b;
            if (b != null) {
                this.g = b.f;
                this.c = b.b;
                this.b = b.a;
                this.f = b.e;
                this.h = b.g;
                this.j = b.i;
                final DrmConfiguration c = b.c;
                Object b2;
                if (c != null) {
                    b2 = c.b();
                }
                else {
                    b2 = new DrmConfiguration.Builder((MediaItem$a)null);
                }
                this.e = (DrmConfiguration.Builder)b2;
                this.i = b.d;
            }
        }
        
        Builder(final MediaItem mediaItem, final MediaItem$a object) {
            this(mediaItem);
        }
        
        public MediaItem a() {
            Assertions.g(DrmConfiguration.Builder.e(this.e) == null || DrmConfiguration.Builder.f(this.e) != null);
            final Uri b = this.b;
            Object i = null;
            PlaybackProperties playbackProperties;
            if (b != null) {
                final String c = this.c;
                if (DrmConfiguration.Builder.f(this.e) != null) {
                    i = this.e.i();
                }
                playbackProperties = new PlaybackProperties(b, c, (DrmConfiguration)i, this.i, this.f, this.g, this.h, this.j, null);
            }
            else {
                playbackProperties = null;
            }
            String a = this.a;
            if (a == null) {
                a = "";
            }
            final ClippingProperties g = this.d.g();
            final LiveConfiguration f = this.l.f();
            MediaMetadata mediaMetadata = this.k;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.R;
            }
            return new MediaItem(a, g, playbackProperties, f, mediaMetadata, this.m, null);
        }
        
        public Builder b(final String g) {
            this.g = g;
            return this;
        }
        
        public Builder c(final DrmConfiguration drmConfiguration) {
            Object b;
            if (drmConfiguration != null) {
                b = drmConfiguration.b();
            }
            else {
                b = new DrmConfiguration.Builder((MediaItem$a)null);
            }
            this.e = (DrmConfiguration.Builder)b;
            return this;
        }
        
        public Builder d(final LiveConfiguration liveConfiguration) {
            this.l = liveConfiguration.b();
            return this;
        }
        
        public Builder e(final String s) {
            this.a = Assertions.e(s);
            return this;
        }
        
        public Builder f(final String c) {
            this.c = c;
            return this;
        }
        
        public Builder g(final List<SubtitleConfiguration> list) {
            this.h = (ImmutableList<SubtitleConfiguration>)ImmutableList.copyOf((Collection)list);
            return this;
        }
        
        public Builder h(final Object j) {
            this.j = j;
            return this;
        }
        
        public Builder i(final Uri b) {
            this.b = b;
            return this;
        }
        
        public Builder j(final String s) {
            Uri parse;
            if (s == null) {
                parse = null;
            }
            else {
                parse = Uri.parse(s);
            }
            return this.i(parse);
        }
    }
    
    public static class ClippingConfiguration implements Bundleable
    {
        public static final ClippingConfiguration f;
        public static final Creator<ClippingProperties> g;
        public final long a;
        public final long b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        
        static {
            f = new Builder().f();
            g = a1.a;
        }
        
        private ClippingConfiguration(final Builder builder) {
            this.a = Builder.a(builder);
            this.b = Builder.b(builder);
            this.c = Builder.c(builder);
            this.d = Builder.d(builder);
            this.e = Builder.e(builder);
        }
        
        ClippingConfiguration(final Builder builder, final MediaItem$a object) {
            this(builder);
        }
        
        public static ClippingProperties a(final Bundle bundle) {
            return d(bundle);
        }
        
        private static String c(final int n) {
            return Integer.toString(n, 36);
        }
        
        private static ClippingProperties d(final Bundle bundle) {
            return new Builder().k(bundle.getLong(c(0), 0L)).h(bundle.getLong(c(1), Long.MIN_VALUE)).j(bundle.getBoolean(c(2), false)).i(bundle.getBoolean(c(3), false)).l(bundle.getBoolean(c(4), false)).g();
        }
        
        public Builder b() {
            return new Builder(this, null);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof ClippingConfiguration)) {
                return false;
            }
            final ClippingConfiguration clippingConfiguration = (ClippingConfiguration)o;
            if (this.a != clippingConfiguration.a || this.b != clippingConfiguration.b || this.c != clippingConfiguration.c || this.d != clippingConfiguration.d || this.e != clippingConfiguration.e) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final long a = this.a;
            final int n = (int)(a ^ a >>> 32);
            final long b = this.b;
            return (((n * 31 + (int)(b >>> 32 ^ b)) * 31 + (this.c ? 1 : 0)) * 31 + (this.d ? 1 : 0)) * 31 + (this.e ? 1 : 0);
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.a);
            bundle.putLong(c(1), this.b);
            bundle.putBoolean(c(2), this.c);
            bundle.putBoolean(c(3), this.d);
            bundle.putBoolean(c(4), this.e);
            return bundle;
        }
        
        public static final class Builder
        {
            private long a;
            private long b;
            private boolean c;
            private boolean d;
            private boolean e;
            
            public Builder() {
                this.b = Long.MIN_VALUE;
            }
            
            private Builder(final ClippingConfiguration clippingConfiguration) {
                this.a = clippingConfiguration.a;
                this.b = clippingConfiguration.b;
                this.c = clippingConfiguration.c;
                this.d = clippingConfiguration.d;
                this.e = clippingConfiguration.e;
            }
            
            Builder(final ClippingConfiguration clippingConfiguration, final MediaItem$a object) {
                this(clippingConfiguration);
            }
            
            static long a(final Builder builder) {
                return builder.a;
            }
            
            static long b(final Builder builder) {
                return builder.b;
            }
            
            static boolean c(final Builder builder) {
                return builder.c;
            }
            
            static boolean d(final Builder builder) {
                return builder.d;
            }
            
            static boolean e(final Builder builder) {
                return builder.e;
            }
            
            public ClippingConfiguration f() {
                return (ClippingConfiguration)this.g();
            }
            
            @Deprecated
            public ClippingProperties g() {
                return new ClippingProperties(this, null);
            }
            
            public Builder h(final long b) {
                Assertions.a(b == Long.MIN_VALUE || b >= 0L);
                this.b = b;
                return this;
            }
            
            public Builder i(final boolean d) {
                this.d = d;
                return this;
            }
            
            public Builder j(final boolean c) {
                this.c = c;
                return this;
            }
            
            public Builder k(final long a) {
                Assertions.a(a >= 0L);
                this.a = a;
                return this;
            }
            
            public Builder l(final boolean e) {
                this.e = e;
                return this;
            }
        }
    }
    
    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration
    {
        public static final ClippingProperties h;
        
        static {
            h = new ClippingConfiguration.Builder().g();
        }
        
        private ClippingProperties(final ClippingConfiguration.Builder builder) {
            super(builder, null);
        }
        
        ClippingProperties(final ClippingConfiguration.Builder builder, final MediaItem$a object) {
            this(builder);
        }
    }
    
    public static final class DrmConfiguration
    {
        public final UUID a;
        @Deprecated
        public final UUID b;
        public final Uri c;
        @Deprecated
        public final ImmutableMap<String, String> d;
        public final ImmutableMap<String, String> e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        @Deprecated
        public final ImmutableList<Integer> i;
        public final ImmutableList<Integer> j;
        private final byte[] k;
        
        private DrmConfiguration(final Builder builder) {
            Assertions.g(!Builder.g(builder) || Builder.e(builder) != null);
            final UUID uuid = Assertions.e(Builder.f(builder));
            this.a = uuid;
            this.b = uuid;
            this.c = Builder.e(builder);
            this.d = (ImmutableMap<String, String>)Builder.h(builder);
            this.e = (ImmutableMap<String, String>)Builder.h(builder);
            this.f = Builder.a(builder);
            this.h = Builder.g(builder);
            this.g = Builder.b(builder);
            this.i = (ImmutableList<Integer>)Builder.c(builder);
            this.j = (ImmutableList<Integer>)Builder.c(builder);
            byte[] copy;
            if (Builder.d(builder) != null) {
                copy = Arrays.copyOf(Builder.d(builder), Builder.d(builder).length);
            }
            else {
                copy = null;
            }
            this.k = copy;
        }
        
        DrmConfiguration(final Builder builder, final MediaItem$a object) {
            this(builder);
        }
        
        static byte[] a(final DrmConfiguration drmConfiguration) {
            return drmConfiguration.k;
        }
        
        public Builder b() {
            return new Builder(this, null);
        }
        
        public byte[] c() {
            final byte[] k = this.k;
            byte[] copy;
            if (k != null) {
                copy = Arrays.copyOf(k, k.length);
            }
            else {
                copy = null;
            }
            return copy;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof DrmConfiguration)) {
                return false;
            }
            final DrmConfiguration drmConfiguration = (DrmConfiguration)o;
            if (!this.a.equals(drmConfiguration.a) || !Util.c(this.c, drmConfiguration.c) || !Util.c(this.e, drmConfiguration.e) || this.f != drmConfiguration.f || this.h != drmConfiguration.h || this.g != drmConfiguration.g || !this.j.equals((Object)drmConfiguration.j) || !Arrays.equals(this.k, drmConfiguration.k)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final Uri c = this.c;
            int hashCode2;
            if (c != null) {
                hashCode2 = c.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            return ((((((hashCode * 31 + hashCode2) * 31 + this.e.hashCode()) * 31 + (this.f ? 1 : 0)) * 31 + (this.h ? 1 : 0)) * 31 + (this.g ? 1 : 0)) * 31 + this.j.hashCode()) * 31 + Arrays.hashCode(this.k);
        }
        
        public static final class Builder
        {
            private UUID a;
            private Uri b;
            private ImmutableMap<String, String> c;
            private boolean d;
            private boolean e;
            private boolean f;
            private ImmutableList<Integer> g;
            private byte[] h;
            
            @Deprecated
            private Builder() {
                this.c = (ImmutableMap<String, String>)ImmutableMap.of();
                this.g = (ImmutableList<Integer>)ImmutableList.of();
            }
            
            private Builder(final DrmConfiguration drmConfiguration) {
                this.a = drmConfiguration.a;
                this.b = drmConfiguration.c;
                this.c = drmConfiguration.e;
                this.d = drmConfiguration.f;
                this.e = drmConfiguration.g;
                this.f = drmConfiguration.h;
                this.g = drmConfiguration.j;
                this.h = DrmConfiguration.a(drmConfiguration);
            }
            
            Builder(final DrmConfiguration drmConfiguration, final MediaItem$a object) {
                this(drmConfiguration);
            }
            
            Builder(final MediaItem$a object) {
                this();
            }
            
            static boolean a(final Builder builder) {
                return builder.d;
            }
            
            static boolean b(final Builder builder) {
                return builder.e;
            }
            
            static ImmutableList c(final Builder builder) {
                return builder.g;
            }
            
            static byte[] d(final Builder builder) {
                return builder.h;
            }
            
            static Uri e(final Builder builder) {
                return builder.b;
            }
            
            static UUID f(final Builder builder) {
                return builder.a;
            }
            
            static boolean g(final Builder builder) {
                return builder.f;
            }
            
            static ImmutableMap h(final Builder builder) {
                return builder.c;
            }
            
            public DrmConfiguration i() {
                return new DrmConfiguration(this, null);
            }
        }
    }
    
    public static final class LiveConfiguration implements Bundleable
    {
        public static final LiveConfiguration f;
        public static final Creator<LiveConfiguration> g;
        public final long a;
        public final long b;
        public final long c;
        public final float d;
        public final float e;
        
        static {
            f = new Builder().f();
            g = b1.a;
        }
        
        @Deprecated
        public LiveConfiguration(final long a, final long b, final long c, final float d, final float e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        private LiveConfiguration(final Builder builder) {
            this(Builder.a(builder), Builder.b(builder), Builder.c(builder), Builder.d(builder), Builder.e(builder));
        }
        
        LiveConfiguration(final Builder builder, final MediaItem$a object) {
            this(builder);
        }
        
        public static LiveConfiguration a(final Bundle bundle) {
            return d(bundle);
        }
        
        private static String c(final int n) {
            return Integer.toString(n, 36);
        }
        
        private static LiveConfiguration d(final Bundle bundle) {
            return new LiveConfiguration(bundle.getLong(c(0), -9223372036854775807L), bundle.getLong(c(1), -9223372036854775807L), bundle.getLong(c(2), -9223372036854775807L), bundle.getFloat(c(3), -3.4028235E38f), bundle.getFloat(c(4), -3.4028235E38f));
        }
        
        public Builder b() {
            return new Builder(this, null);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof LiveConfiguration)) {
                return false;
            }
            final LiveConfiguration liveConfiguration = (LiveConfiguration)o;
            if (this.a != liveConfiguration.a || this.b != liveConfiguration.b || this.c != liveConfiguration.c || this.d != liveConfiguration.d || this.e != liveConfiguration.e) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final long a = this.a;
            final int n = (int)(a ^ a >>> 32);
            final long b = this.b;
            final int n2 = (int)(b ^ b >>> 32);
            final long c = this.c;
            final int n3 = (int)(c >>> 32 ^ c);
            final float d = this.d;
            int floatToIntBits = 0;
            int floatToIntBits2;
            if (d != 0.0f) {
                floatToIntBits2 = Float.floatToIntBits(d);
            }
            else {
                floatToIntBits2 = 0;
            }
            final float e = this.e;
            if (e != 0.0f) {
                floatToIntBits = Float.floatToIntBits(e);
            }
            return (((n * 31 + n2) * 31 + n3) * 31 + floatToIntBits2) * 31 + floatToIntBits;
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.a);
            bundle.putLong(c(1), this.b);
            bundle.putLong(c(2), this.c);
            bundle.putFloat(c(3), this.d);
            bundle.putFloat(c(4), this.e);
            return bundle;
        }
        
        public static final class Builder
        {
            private long a;
            private long b;
            private long c;
            private float d;
            private float e;
            
            public Builder() {
                this.a = -9223372036854775807L;
                this.b = -9223372036854775807L;
                this.c = -9223372036854775807L;
                this.d = -3.4028235E38f;
                this.e = -3.4028235E38f;
            }
            
            private Builder(final LiveConfiguration liveConfiguration) {
                this.a = liveConfiguration.a;
                this.b = liveConfiguration.b;
                this.c = liveConfiguration.c;
                this.d = liveConfiguration.d;
                this.e = liveConfiguration.e;
            }
            
            Builder(final LiveConfiguration liveConfiguration, final MediaItem$a object) {
                this(liveConfiguration);
            }
            
            static long a(final Builder builder) {
                return builder.a;
            }
            
            static long b(final Builder builder) {
                return builder.b;
            }
            
            static long c(final Builder builder) {
                return builder.c;
            }
            
            static float d(final Builder builder) {
                return builder.d;
            }
            
            static float e(final Builder builder) {
                return builder.e;
            }
            
            public LiveConfiguration f() {
                return new LiveConfiguration(this, null);
            }
            
            public Builder g(final long c) {
                this.c = c;
                return this;
            }
            
            public Builder h(final float e) {
                this.e = e;
                return this;
            }
            
            public Builder i(final long b) {
                this.b = b;
                return this;
            }
            
            public Builder j(final float d) {
                this.d = d;
                return this;
            }
            
            public Builder k(final long a) {
                this.a = a;
                return this;
            }
        }
    }
    
    public static class LocalConfiguration
    {
        public final Uri a;
        public final String b;
        public final DrmConfiguration c;
        public final AdsConfiguration d;
        public final List<StreamKey> e;
        public final String f;
        public final ImmutableList<SubtitleConfiguration> g;
        @Deprecated
        public final List<Subtitle> h;
        public final Object i;
        
        private LocalConfiguration(final Uri a, final String b, final DrmConfiguration c, final AdsConfiguration d, final List<StreamKey> e, final String f, final ImmutableList<SubtitleConfiguration> g, final Object i) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            final ImmutableList$Builder builder = ImmutableList.builder();
            for (int j = 0; j < ((AbstractCollection)g).size(); ++j) {
                builder.i((Object)SubtitleConfiguration.Builder.a(((SubtitleConfiguration)((List<SubtitleConfiguration>)g).get(j)).a()));
            }
            this.h = (List<Subtitle>)builder.l();
            this.i = i;
        }
        
        LocalConfiguration(final Uri uri, final String s, final DrmConfiguration drmConfiguration, final AdsConfiguration adsConfiguration, final List list, final String s2, final ImmutableList list2, final Object o, final MediaItem$a object) {
            this(uri, s, drmConfiguration, adsConfiguration, list, s2, (ImmutableList<SubtitleConfiguration>)list2, o);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof LocalConfiguration)) {
                return false;
            }
            final LocalConfiguration localConfiguration = (LocalConfiguration)o;
            if (!this.a.equals((Object)localConfiguration.a) || !Util.c(this.b, localConfiguration.b) || !Util.c(this.c, localConfiguration.c) || !Util.c(this.d, localConfiguration.d) || !this.e.equals(localConfiguration.e) || !Util.c(this.f, localConfiguration.f) || !this.g.equals((Object)localConfiguration.g) || !Util.c(this.i, localConfiguration.i)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final String b = this.b;
            int hashCode2 = 0;
            int hashCode3;
            if (b == null) {
                hashCode3 = 0;
            }
            else {
                hashCode3 = b.hashCode();
            }
            final DrmConfiguration c = this.c;
            int hashCode4;
            if (c == null) {
                hashCode4 = 0;
            }
            else {
                hashCode4 = c.hashCode();
            }
            final AdsConfiguration d = this.d;
            int hashCode5;
            if (d == null) {
                hashCode5 = 0;
            }
            else {
                hashCode5 = d.hashCode();
            }
            final int hashCode6 = this.e.hashCode();
            final String f = this.f;
            int hashCode7;
            if (f == null) {
                hashCode7 = 0;
            }
            else {
                hashCode7 = f.hashCode();
            }
            final int hashCode8 = this.g.hashCode();
            final Object i = this.i;
            if (i != null) {
                hashCode2 = i.hashCode();
            }
            return ((((((hashCode * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode2;
        }
    }
    
    @Deprecated
    public static final class PlaybackProperties extends LocalConfiguration
    {
        private PlaybackProperties(final Uri uri, final String s, final DrmConfiguration drmConfiguration, final AdsConfiguration adsConfiguration, final List<StreamKey> list, final String s2, final ImmutableList<SubtitleConfiguration> list2, final Object o) {
            super(uri, s, drmConfiguration, adsConfiguration, list, s2, list2, o, null);
        }
        
        PlaybackProperties(final Uri uri, final String s, final DrmConfiguration drmConfiguration, final AdsConfiguration adsConfiguration, final List list, final String s2, final ImmutableList list2, final Object o, final MediaItem$a object) {
            this(uri, s, drmConfiguration, adsConfiguration, list, s2, (ImmutableList<SubtitleConfiguration>)list2, o);
        }
    }
    
    public static final class RequestMetadata implements Bundleable
    {
        public static final RequestMetadata d;
        public static final Creator<RequestMetadata> e;
        public final Uri a;
        public final String b;
        public final Bundle c;
        
        static {
            d = new Builder().d();
            e = c1.a;
        }
        
        private RequestMetadata(final Builder builder) {
            this.a = Builder.a(builder);
            this.b = Builder.b(builder);
            this.c = Builder.c(builder);
        }
        
        RequestMetadata(final Builder builder, final MediaItem$a object) {
            this(builder);
        }
        
        public static RequestMetadata a(final Bundle bundle) {
            return c(bundle);
        }
        
        private static String b(final int n) {
            return Integer.toString(n, 36);
        }
        
        private static RequestMetadata c(final Bundle bundle) {
            return new Builder().f((Uri)bundle.getParcelable(b(0))).g(bundle.getString(b(1))).e(bundle.getBundle(b(2))).d();
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof RequestMetadata)) {
                return false;
            }
            final RequestMetadata requestMetadata = (RequestMetadata)o;
            if (!Util.c(this.a, requestMetadata.a) || !Util.c(this.b, requestMetadata.b)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final Uri a = this.a;
            int hashCode = 0;
            int hashCode2;
            if (a == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = a.hashCode();
            }
            final String b = this.b;
            if (b != null) {
                hashCode = b.hashCode();
            }
            return hashCode2 * 31 + hashCode;
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            if (this.a != null) {
                bundle.putParcelable(b(0), (Parcelable)this.a);
            }
            if (this.b != null) {
                bundle.putString(b(1), this.b);
            }
            if (this.c != null) {
                bundle.putBundle(b(2), this.c);
            }
            return bundle;
        }
        
        public static final class Builder
        {
            private Uri a;
            private String b;
            private Bundle c;
            
            static Uri a(final Builder builder) {
                return builder.a;
            }
            
            static String b(final Builder builder) {
                return builder.b;
            }
            
            static Bundle c(final Builder builder) {
                return builder.c;
            }
            
            public RequestMetadata d() {
                return new RequestMetadata(this, null);
            }
            
            public Builder e(final Bundle c) {
                this.c = c;
                return this;
            }
            
            public Builder f(final Uri a) {
                this.a = a;
                return this;
            }
            
            public Builder g(final String b) {
                this.b = b;
                return this;
            }
        }
    }
    
    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration
    {
        private Subtitle(final SubtitleConfiguration.Builder builder) {
            super(builder, null);
        }
        
        Subtitle(final SubtitleConfiguration.Builder builder, final MediaItem$a object) {
            this(builder);
        }
    }
    
    public static class SubtitleConfiguration
    {
        public final Uri a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;
        public final String f;
        public final String g;
        
        private SubtitleConfiguration(final Builder builder) {
            this.a = Builder.b(builder);
            this.b = Builder.c(builder);
            this.c = Builder.d(builder);
            this.d = Builder.e(builder);
            this.e = Builder.f(builder);
            this.f = Builder.g(builder);
            this.g = Builder.h(builder);
        }
        
        SubtitleConfiguration(final Builder builder, final MediaItem$a object) {
            this(builder);
        }
        
        public Builder a() {
            return new Builder(this, null);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof SubtitleConfiguration)) {
                return false;
            }
            final SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration)o;
            if (!this.a.equals((Object)subtitleConfiguration.a) || !Util.c(this.b, subtitleConfiguration.b) || !Util.c(this.c, subtitleConfiguration.c) || this.d != subtitleConfiguration.d || this.e != subtitleConfiguration.e || !Util.c(this.f, subtitleConfiguration.f) || !Util.c(this.g, subtitleConfiguration.g)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final String b = this.b;
            int hashCode2 = 0;
            int hashCode3;
            if (b == null) {
                hashCode3 = 0;
            }
            else {
                hashCode3 = b.hashCode();
            }
            final String c = this.c;
            int hashCode4;
            if (c == null) {
                hashCode4 = 0;
            }
            else {
                hashCode4 = c.hashCode();
            }
            final int d = this.d;
            final int e = this.e;
            final String f = this.f;
            int hashCode5;
            if (f == null) {
                hashCode5 = 0;
            }
            else {
                hashCode5 = f.hashCode();
            }
            final String g = this.g;
            if (g != null) {
                hashCode2 = g.hashCode();
            }
            return (((((hashCode * 31 + hashCode3) * 31 + hashCode4) * 31 + d) * 31 + e) * 31 + hashCode5) * 31 + hashCode2;
        }
        
        public static final class Builder
        {
            private Uri a;
            private String b;
            private String c;
            private int d;
            private int e;
            private String f;
            private String g;
            
            private Builder(final SubtitleConfiguration subtitleConfiguration) {
                this.a = subtitleConfiguration.a;
                this.b = subtitleConfiguration.b;
                this.c = subtitleConfiguration.c;
                this.d = subtitleConfiguration.d;
                this.e = subtitleConfiguration.e;
                this.f = subtitleConfiguration.f;
                this.g = subtitleConfiguration.g;
            }
            
            Builder(final SubtitleConfiguration subtitleConfiguration, final MediaItem$a object) {
                this(subtitleConfiguration);
            }
            
            static Subtitle a(final Builder builder) {
                return builder.i();
            }
            
            static Uri b(final Builder builder) {
                return builder.a;
            }
            
            static String c(final Builder builder) {
                return builder.b;
            }
            
            static String d(final Builder builder) {
                return builder.c;
            }
            
            static int e(final Builder builder) {
                return builder.d;
            }
            
            static int f(final Builder builder) {
                return builder.e;
            }
            
            static String g(final Builder builder) {
                return builder.f;
            }
            
            static String h(final Builder builder) {
                return builder.g;
            }
            
            private Subtitle i() {
                return new Subtitle(this, null);
            }
        }
    }
}
