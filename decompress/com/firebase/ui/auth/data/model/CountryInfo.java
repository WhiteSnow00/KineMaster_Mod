// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import java.io.Serializable;
import android.os.Parcel;
import java.util.Locale;
import java.text.Collator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class CountryInfo implements Comparable<CountryInfo>, Parcelable
{
    public static final Parcelable$Creator<CountryInfo> CREATOR;
    private final Collator mCollator;
    private final int mCountryCode;
    private final Locale mLocale;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<CountryInfo>() {
            public CountryInfo createFromParcel(final Parcel parcel) {
                return new CountryInfo(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public CountryInfo[] newArray(final int n) {
                return new CountryInfo[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    protected CountryInfo(final Parcel parcel) {
        (this.mCollator = Collator.getInstance(Locale.getDefault())).setStrength(0);
        this.mLocale = (Locale)parcel.readSerializable();
        this.mCountryCode = parcel.readInt();
    }
    
    public CountryInfo(final Locale mLocale, final int mCountryCode) {
        (this.mCollator = Collator.getInstance(Locale.getDefault())).setStrength(0);
        this.mLocale = mLocale;
        this.mCountryCode = mCountryCode;
    }
    
    public static String localeToEmoji(final Locale locale) {
        final String country = locale.getCountry();
        final int codePoint = Character.codePointAt(country, 0);
        final int codePoint2 = Character.codePointAt(country, 1);
        final StringBuilder sb = new StringBuilder();
        sb.append(new String(Character.toChars(codePoint - 65 + 127462)));
        sb.append(new String(Character.toChars(codePoint2 - 65 + 127462)));
        return sb.toString();
    }
    
    @Override
    public int compareTo(final CountryInfo countryInfo) {
        return this.mCollator.compare(this.mLocale.getDisplayCountry(), countryInfo.mLocale.getDisplayCountry());
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.compareTo((CountryInfo)o);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && CountryInfo.class == o.getClass()) {
            final CountryInfo countryInfo = (CountryInfo)o;
            if (this.mCountryCode == countryInfo.mCountryCode) {
                final Locale mLocale = this.mLocale;
                if (mLocale != null) {
                    if (mLocale.equals(countryInfo.mLocale)) {
                        return b;
                    }
                }
                else if (countryInfo.mLocale == null) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    public int getCountryCode() {
        return this.mCountryCode;
    }
    
    public Locale getLocale() {
        return this.mLocale;
    }
    
    @Override
    public int hashCode() {
        final Locale mLocale = this.mLocale;
        int hashCode;
        if (mLocale != null) {
            hashCode = mLocale.hashCode();
        }
        else {
            hashCode = 0;
        }
        return hashCode * 31 + this.mCountryCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(localeToEmoji(this.mLocale));
        sb.append(" ");
        sb.append(this.mLocale.getDisplayCountry());
        sb.append(" +");
        sb.append(this.mCountryCode);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeSerializable((Serializable)this.mLocale);
        parcel.writeInt(this.mCountryCode);
    }
}
