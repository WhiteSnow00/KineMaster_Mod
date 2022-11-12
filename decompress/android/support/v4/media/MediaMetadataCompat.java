// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import java.util.Iterator;
import java.util.Set;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.graphics.Bitmap;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.Parcel;
import android.media.MediaMetadata;
import android.os.Bundle;
import androidx.collection.a;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaMetadataCompat implements Parcelable
{
    public static final Parcelable$Creator<MediaMetadataCompat> CREATOR;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final a<String, Integer> d;
    private static final String[] e;
    private static final String[] f;
    private static final String[] g;
    final Bundle a;
    private MediaMetadata b;
    private MediaDescriptionCompat c;
    
    static {
        final a<String, Integer> a = d = new a<String, Integer>();
        final Integer value = 1;
        a.put("android.media.metadata.TITLE", value);
        a.put("android.media.metadata.ARTIST", value);
        final Integer value2 = 0;
        a.put("android.media.metadata.DURATION", value2);
        a.put("android.media.metadata.ALBUM", value);
        a.put("android.media.metadata.AUTHOR", value);
        a.put("android.media.metadata.WRITER", value);
        a.put("android.media.metadata.COMPOSER", value);
        a.put("android.media.metadata.COMPILATION", value);
        a.put("android.media.metadata.DATE", value);
        a.put("android.media.metadata.YEAR", value2);
        a.put("android.media.metadata.GENRE", value);
        a.put("android.media.metadata.TRACK_NUMBER", value2);
        a.put("android.media.metadata.NUM_TRACKS", value2);
        a.put("android.media.metadata.DISC_NUMBER", value2);
        a.put("android.media.metadata.ALBUM_ARTIST", value);
        final Integer value3 = 2;
        a.put("android.media.metadata.ART", value3);
        a.put("android.media.metadata.ART_URI", value);
        a.put("android.media.metadata.ALBUM_ART", value3);
        a.put("android.media.metadata.ALBUM_ART_URI", value);
        final Integer value4 = 3;
        a.put("android.media.metadata.USER_RATING", value4);
        a.put("android.media.metadata.RATING", value4);
        a.put("android.media.metadata.DISPLAY_TITLE", value);
        a.put("android.media.metadata.DISPLAY_SUBTITLE", value);
        a.put("android.media.metadata.DISPLAY_DESCRIPTION", value);
        a.put("android.media.metadata.DISPLAY_ICON", value3);
        a.put("android.media.metadata.DISPLAY_ICON_URI", value);
        a.put("android.media.metadata.MEDIA_ID", value);
        a.put("android.media.metadata.BT_FOLDER_TYPE", value2);
        a.put("android.media.metadata.MEDIA_URI", value);
        a.put("android.media.metadata.ADVERTISEMENT", value2);
        a.put("android.media.metadata.DOWNLOAD_STATUS", value2);
        e = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
        f = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
        g = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<MediaMetadataCompat>() {
            public MediaMetadataCompat createFromParcel(final Parcel parcel) {
                return new MediaMetadataCompat(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public MediaMetadataCompat[] newArray(final int n) {
                return new MediaMetadataCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    MediaMetadataCompat(Bundle a) {
        a = new Bundle(a);
        MediaSessionCompat.ensureClassLoader(this.a = a);
    }
    
    MediaMetadataCompat(final Parcel parcel) {
        this.a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
    
    public static MediaMetadataCompat fromMediaMetadata(final Object o) {
        if (o != null) {
            final Parcel obtain = Parcel.obtain();
            final MediaMetadata b = (MediaMetadata)o;
            b.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            final MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            mediaMetadataCompat.b = b;
            return mediaMetadataCompat;
        }
        return null;
    }
    
    public boolean containsKey(final String s) {
        return this.a.containsKey(s);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Bitmap getBitmap(final String s) {
        Bitmap bitmap;
        try {
            bitmap = (Bitmap)this.a.getParcelable(s);
        }
        catch (final Exception ex) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", (Throwable)ex);
            bitmap = null;
        }
        return bitmap;
    }
    
    public Bundle getBundle() {
        return new Bundle(this.a);
    }
    
    public MediaDescriptionCompat getDescription() {
        final MediaDescriptionCompat c = this.c;
        if (c != null) {
            return c;
        }
        final String string = this.getString("android.media.metadata.MEDIA_ID");
        final CharSequence[] array = new CharSequence[3];
        final CharSequence text = this.getText("android.media.metadata.DISPLAY_TITLE");
        if (!TextUtils.isEmpty(text)) {
            array[0] = text;
            array[1] = this.getText("android.media.metadata.DISPLAY_SUBTITLE");
            array[2] = this.getText("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        else {
            int i = 0;
            int n = 0;
            while (i < 3) {
                final String[] e = MediaMetadataCompat.e;
                if (n >= e.length) {
                    break;
                }
                final CharSequence text2 = this.getText(e[n]);
                int n2 = i;
                if (!TextUtils.isEmpty(text2)) {
                    array[i] = text2;
                    n2 = i + 1;
                }
                ++n;
                i = n2;
            }
        }
        int n3 = 0;
        Uri parse;
        Bitmap bitmap;
        while (true) {
            final String[] f = MediaMetadataCompat.f;
            final int length = f.length;
            parse = null;
            if (n3 >= length) {
                bitmap = null;
                break;
            }
            bitmap = this.getBitmap(f[n3]);
            if (bitmap != null) {
                break;
            }
            ++n3;
        }
        int n4 = 0;
        Uri parse2;
        while (true) {
            final String[] g = MediaMetadataCompat.g;
            if (n4 >= g.length) {
                parse2 = null;
                break;
            }
            final String string2 = this.getString(g[n4]);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                parse2 = Uri.parse(string2);
                break;
            }
            ++n4;
        }
        final String string3 = this.getString("android.media.metadata.MEDIA_URI");
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            parse = Uri.parse(string3);
        }
        final MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(array[0]);
        builder.setSubtitle(array[1]);
        builder.setDescription(array[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(parse2);
        builder.setMediaUri(parse);
        final Bundle extras = new Bundle();
        if (this.a.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
            extras.putLong("android.media.extra.BT_FOLDER_TYPE", this.getLong("android.media.metadata.BT_FOLDER_TYPE"));
        }
        if (this.a.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
            extras.putLong("android.media.extra.DOWNLOAD_STATUS", this.getLong("android.media.metadata.DOWNLOAD_STATUS"));
        }
        if (!extras.isEmpty()) {
            builder.setExtras(extras);
        }
        return this.c = builder.build();
    }
    
    public long getLong(final String s) {
        return this.a.getLong(s, 0L);
    }
    
    public Object getMediaMetadata() {
        if (this.b == null) {
            final Parcel obtain = Parcel.obtain();
            this.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.b = (MediaMetadata)MediaMetadata.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.b;
    }
    
    public RatingCompat getRating(final String s) {
        RatingCompat fromRating;
        try {
            fromRating = RatingCompat.fromRating(this.a.getParcelable(s));
        }
        catch (final Exception ex) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", (Throwable)ex);
            fromRating = null;
        }
        return fromRating;
    }
    
    public String getString(final String s) {
        final CharSequence charSequence = this.a.getCharSequence(s);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }
    
    public CharSequence getText(final String s) {
        return this.a.getCharSequence(s);
    }
    
    public Set<String> keySet() {
        return this.a.keySet();
    }
    
    public int size() {
        return this.a.size();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeBundle(this.a);
    }
    
    public static final class Builder
    {
        private final Bundle a;
        
        public Builder() {
            this.a = new Bundle();
        }
        
        public Builder(final MediaMetadataCompat mediaMetadataCompat) {
            MediaSessionCompat.ensureClassLoader(this.a = new Bundle(mediaMetadataCompat.a));
        }
        
        public Builder(final MediaMetadataCompat mediaMetadataCompat, final int n) {
            this(mediaMetadataCompat);
            for (final String s : this.a.keySet()) {
                final Object value = this.a.get(s);
                if (value instanceof Bitmap) {
                    final Bitmap bitmap = (Bitmap)value;
                    if (bitmap.getHeight() <= n && bitmap.getWidth() <= n) {
                        continue;
                    }
                    this.putBitmap(s, this.a(bitmap, n));
                }
            }
        }
        
        private Bitmap a(final Bitmap bitmap, int n) {
            final float n2 = (float)n;
            final float min = Math.min(n2 / bitmap.getWidth(), n2 / bitmap.getHeight());
            n = (int)(bitmap.getHeight() * min);
            return Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * min), n, true);
        }
        
        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.a);
        }
        
        public Builder putBitmap(final String s, final Bitmap bitmap) {
            final a<String, Integer> d = MediaMetadataCompat.d;
            if (d.containsKey(s) && (int)d.get(s) != 2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("The ");
                sb.append(s);
                sb.append(" key cannot be used to put a Bitmap");
                throw new IllegalArgumentException(sb.toString());
            }
            this.a.putParcelable(s, (Parcelable)bitmap);
            return this;
        }
        
        public Builder putLong(final String s, final long n) {
            final a<String, Integer> d = MediaMetadataCompat.d;
            if (d.containsKey(s) && (int)d.get(s) != 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("The ");
                sb.append(s);
                sb.append(" key cannot be used to put a long");
                throw new IllegalArgumentException(sb.toString());
            }
            this.a.putLong(s, n);
            return this;
        }
        
        public Builder putRating(final String s, final RatingCompat ratingCompat) {
            final a<String, Integer> d = MediaMetadataCompat.d;
            if (d.containsKey(s) && (int)d.get(s) != 3) {
                final StringBuilder sb = new StringBuilder();
                sb.append("The ");
                sb.append(s);
                sb.append(" key cannot be used to put a Rating");
                throw new IllegalArgumentException(sb.toString());
            }
            this.a.putParcelable(s, (Parcelable)ratingCompat.getRating());
            return this;
        }
        
        public Builder putString(final String s, final String s2) {
            final a<String, Integer> d = MediaMetadataCompat.d;
            if (d.containsKey(s) && (int)d.get(s) != 1) {
                final StringBuilder sb = new StringBuilder();
                sb.append("The ");
                sb.append(s);
                sb.append(" key cannot be used to put a String");
                throw new IllegalArgumentException(sb.toString());
            }
            this.a.putCharSequence(s, (CharSequence)s2);
            return this;
        }
        
        public Builder putText(final String s, final CharSequence charSequence) {
            final a<String, Integer> d = MediaMetadataCompat.d;
            if (d.containsKey(s) && (int)d.get(s) != 1) {
                final StringBuilder sb = new StringBuilder();
                sb.append("The ");
                sb.append(s);
                sb.append(" key cannot be used to put a CharSequence");
                throw new IllegalArgumentException(sb.toString());
            }
            this.a.putCharSequence(s, charSequence);
            return this;
        }
    }
}
