// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import android.media.MediaDescription$Builder;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.Parcel;
import android.media.MediaDescription;
import android.os.Bundle;
import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaDescriptionCompat implements Parcelable
{
    public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
    public static final long BT_FOLDER_TYPE_GENRES = 4L;
    public static final long BT_FOLDER_TYPE_MIXED = 0L;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
    public static final long BT_FOLDER_TYPE_TITLES = 1L;
    public static final long BT_FOLDER_TYPE_YEARS = 6L;
    public static final Parcelable$Creator<MediaDescriptionCompat> CREATOR;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2L;
    public static final long STATUS_DOWNLOADING = 1L;
    public static final long STATUS_NOT_DOWNLOADED = 0L;
    private final String a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private MediaDescription i;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MediaDescriptionCompat>() {
            public MediaDescriptionCompat createFromParcel(final Parcel parcel) {
                return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel));
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public MediaDescriptionCompat[] newArray(final int n) {
                return new MediaDescriptionCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    MediaDescriptionCompat(final String a, final CharSequence b, final CharSequence c, final CharSequence d, final Bitmap e, final Uri f, final Bundle g, final Uri h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public static MediaDescriptionCompat fromMediaDescription(final Object o) {
        MediaDescriptionCompat build = null;
        final Bundle bundle = null;
        if (o != null) {
            final Builder builder = new Builder();
            final MediaDescription i = (MediaDescription)o;
            builder.setMediaId(Api21Impl.g(i));
            builder.setTitle(Api21Impl.i(i));
            builder.setSubtitle(Api21Impl.h(i));
            builder.setDescription(Api21Impl.c(i));
            builder.setIconBitmap(Api21Impl.e(i));
            builder.setIconUri(Api21Impl.f(i));
            final Bundle d = Api21Impl.d(i);
            Bundle unparcelWithClassLoader;
            if ((unparcelWithClassLoader = d) != null) {
                unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(d);
            }
            Uri mediaUri;
            if (unparcelWithClassLoader != null) {
                mediaUri = (Uri)unparcelWithClassLoader.getParcelable("android.support.v4.media.description.MEDIA_URI");
            }
            else {
                mediaUri = null;
            }
            if (mediaUri != null) {
                if (unparcelWithClassLoader.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && unparcelWithClassLoader.size() == 2) {
                    unparcelWithClassLoader = bundle;
                }
                else {
                    unparcelWithClassLoader.remove("android.support.v4.media.description.MEDIA_URI");
                    unparcelWithClassLoader.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                }
            }
            builder.setExtras(unparcelWithClassLoader);
            if (mediaUri != null) {
                builder.setMediaUri(mediaUri);
            }
            else {
                builder.setMediaUri(Api23Impl.a(i));
            }
            build = builder.build();
            build.i = i;
        }
        return build;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public CharSequence getDescription() {
        return this.d;
    }
    
    public Bundle getExtras() {
        return this.g;
    }
    
    public Bitmap getIconBitmap() {
        return this.e;
    }
    
    public Uri getIconUri() {
        return this.f;
    }
    
    public Object getMediaDescription() {
        MediaDescription i;
        if ((i = this.i) == null) {
            final MediaDescription$Builder b = Api21Impl.b();
            Api21Impl.n(b, this.a);
            Api21Impl.p(b, this.b);
            Api21Impl.o(b, this.c);
            Api21Impl.j(b, this.d);
            Api21Impl.l(b, this.e);
            Api21Impl.m(b, this.f);
            Api21Impl.k(b, this.g);
            Api23Impl.b(b, this.h);
            i = Api21Impl.a(b);
            this.i = i;
        }
        return i;
    }
    
    public String getMediaId() {
        return this.a;
    }
    
    public Uri getMediaUri() {
        return this.h;
    }
    
    public CharSequence getSubtitle() {
        return this.c;
    }
    
    public CharSequence getTitle() {
        return this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append((Object)this.b);
        sb.append(", ");
        sb.append((Object)this.c);
        sb.append(", ");
        sb.append((Object)this.d);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((MediaDescription)this.getMediaDescription()).writeToParcel(parcel, n);
    }
    
    private static class Api21Impl
    {
        static MediaDescription a(final MediaDescription$Builder mediaDescription$Builder) {
            return mediaDescription$Builder.build();
        }
        
        static MediaDescription$Builder b() {
            return new MediaDescription$Builder();
        }
        
        static CharSequence c(final MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }
        
        static Bundle d(final MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }
        
        static Bitmap e(final MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }
        
        static Uri f(final MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }
        
        static String g(final MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }
        
        static CharSequence h(final MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }
        
        static CharSequence i(final MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }
        
        static void j(final MediaDescription$Builder mediaDescription$Builder, final CharSequence description) {
            mediaDescription$Builder.setDescription(description);
        }
        
        static void k(final MediaDescription$Builder mediaDescription$Builder, final Bundle extras) {
            mediaDescription$Builder.setExtras(extras);
        }
        
        static void l(final MediaDescription$Builder mediaDescription$Builder, final Bitmap iconBitmap) {
            mediaDescription$Builder.setIconBitmap(iconBitmap);
        }
        
        static void m(final MediaDescription$Builder mediaDescription$Builder, final Uri iconUri) {
            mediaDescription$Builder.setIconUri(iconUri);
        }
        
        static void n(final MediaDescription$Builder mediaDescription$Builder, final String mediaId) {
            mediaDescription$Builder.setMediaId(mediaId);
        }
        
        static void o(final MediaDescription$Builder mediaDescription$Builder, final CharSequence subtitle) {
            mediaDescription$Builder.setSubtitle(subtitle);
        }
        
        static void p(final MediaDescription$Builder mediaDescription$Builder, final CharSequence title) {
            mediaDescription$Builder.setTitle(title);
        }
    }
    
    private static class Api23Impl
    {
        static Uri a(final MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }
        
        static void b(final MediaDescription$Builder mediaDescription$Builder, final Uri mediaUri) {
            mediaDescription$Builder.setMediaUri(mediaUri);
        }
    }
    
    public static final class Builder
    {
        private String a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;
        
        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        
        public Builder setDescription(final CharSequence d) {
            this.d = d;
            return this;
        }
        
        public Builder setExtras(final Bundle g) {
            this.g = g;
            return this;
        }
        
        public Builder setIconBitmap(final Bitmap e) {
            this.e = e;
            return this;
        }
        
        public Builder setIconUri(final Uri f) {
            this.f = f;
            return this;
        }
        
        public Builder setMediaId(final String a) {
            this.a = a;
            return this;
        }
        
        public Builder setMediaUri(final Uri h) {
            this.h = h;
            return this;
        }
        
        public Builder setSubtitle(final CharSequence c) {
            this.c = c;
            return this;
        }
        
        public Builder setTitle(final CharSequence b) {
            this.b = b;
            return this;
        }
    }
}
