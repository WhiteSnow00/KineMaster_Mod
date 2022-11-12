// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import android.util.Log;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable
{
    public static final Parcelable$Creator<RatingCompat> CREATOR;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private final int a;
    private final float b;
    private Object c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<RatingCompat>() {
            public RatingCompat createFromParcel(final Parcel parcel) {
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public RatingCompat[] newArray(final int n) {
                return new RatingCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    RatingCompat(final int a, final float b) {
        this.a = a;
        this.b = b;
    }
    
    public static RatingCompat fromRating(final Object c) {
        RatingCompat ratingCompat = null;
        if (c != null) {
            final Rating rating = (Rating)c;
            final int b = Api19Impl.b(rating);
            if (Api19Impl.e(rating)) {
                switch (b) {
                    default: {
                        return null;
                    }
                    case 6: {
                        ratingCompat = newPercentageRating(Api19Impl.a(rating));
                        break;
                    }
                    case 3:
                    case 4:
                    case 5: {
                        ratingCompat = newStarRating(b, Api19Impl.c(rating));
                        break;
                    }
                    case 2: {
                        ratingCompat = newThumbRating(Api19Impl.f(rating));
                        break;
                    }
                    case 1: {
                        ratingCompat = newHeartRating(Api19Impl.d(rating));
                        break;
                    }
                }
            }
            else {
                ratingCompat = newUnratedRating(b);
            }
            ratingCompat.c = c;
        }
        return ratingCompat;
    }
    
    public static RatingCompat newHeartRating(final boolean b) {
        float n;
        if (b) {
            n = 1.0f;
        }
        else {
            n = 0.0f;
        }
        return new RatingCompat(1, n);
    }
    
    public static RatingCompat newPercentageRating(final float n) {
        if (n >= 0.0f && n <= 100.0f) {
            return new RatingCompat(6, n);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }
    
    public static RatingCompat newStarRating(final int n, final float n2) {
        float n3;
        if (n != 3) {
            if (n != 4) {
                if (n != 5) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid rating style (");
                    sb.append(n);
                    sb.append(") for a star rating");
                    Log.e("Rating", sb.toString());
                    return null;
                }
                n3 = 5.0f;
            }
            else {
                n3 = 4.0f;
            }
        }
        else {
            n3 = 3.0f;
        }
        if (n2 >= 0.0f && n2 <= n3) {
            return new RatingCompat(n, n2);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }
    
    public static RatingCompat newThumbRating(final boolean b) {
        float n;
        if (b) {
            n = 1.0f;
        }
        else {
            n = 0.0f;
        }
        return new RatingCompat(2, n);
    }
    
    public static RatingCompat newUnratedRating(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                return new RatingCompat(n, -1.0f);
            }
        }
    }
    
    public int describeContents() {
        return this.a;
    }
    
    public float getPercentRating() {
        if (this.a == 6 && this.isRated()) {
            return this.b;
        }
        return -1.0f;
    }
    
    public Object getRating() {
        if (this.c == null) {
            if (this.isRated()) {
                final int a = this.a;
                switch (a) {
                    default: {
                        return null;
                    }
                    case 6: {
                        this.c = Api19Impl.h(this.getPercentRating());
                        break;
                    }
                    case 3:
                    case 4:
                    case 5: {
                        this.c = Api19Impl.i(a, this.getStarRating());
                        break;
                    }
                    case 2: {
                        this.c = Api19Impl.j(this.isThumbUp());
                        break;
                    }
                    case 1: {
                        this.c = Api19Impl.g(this.hasHeart());
                        break;
                    }
                }
            }
            else {
                this.c = Api19Impl.k(this.a);
            }
        }
        return this.c;
    }
    
    public int getRatingStyle() {
        return this.a;
    }
    
    public float getStarRating() {
        final int a = this.a;
        if (a == 3 || a == 4 || a == 5) {
            if (this.isRated()) {
                return this.b;
            }
        }
        return -1.0f;
    }
    
    public boolean hasHeart() {
        final int a = this.a;
        boolean b = false;
        if (a != 1) {
            return false;
        }
        if (this.b == 1.0f) {
            b = true;
        }
        return b;
    }
    
    public boolean isRated() {
        return this.b >= 0.0f;
    }
    
    public boolean isThumbUp() {
        final int a = this.a;
        boolean b = false;
        if (a != 2) {
            return false;
        }
        if (this.b == 1.0f) {
            b = true;
        }
        return b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.a);
        sb.append(" rating=");
        final float b = this.b;
        String value;
        if (b < 0.0f) {
            value = "unrated";
        }
        else {
            value = String.valueOf(b);
        }
        sb.append(value);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
    
    private static class Api19Impl
    {
        static float a(final Rating rating) {
            return rating.getPercentRating();
        }
        
        static int b(final Rating rating) {
            return rating.getRatingStyle();
        }
        
        static float c(final Rating rating) {
            return rating.getStarRating();
        }
        
        static boolean d(final Rating rating) {
            return rating.hasHeart();
        }
        
        static boolean e(final Rating rating) {
            return rating.isRated();
        }
        
        static boolean f(final Rating rating) {
            return rating.isThumbUp();
        }
        
        static Rating g(final boolean b) {
            return Rating.newHeartRating(b);
        }
        
        static Rating h(final float n) {
            return Rating.newPercentageRating(n);
        }
        
        static Rating i(final int n, final float n2) {
            return Rating.newStarRating(n, n2);
        }
        
        static Rating j(final boolean b) {
            return Rating.newThumbRating(b);
        }
        
        static Rating k(final int n) {
            return Rating.newUnratedRating(n);
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }
}
