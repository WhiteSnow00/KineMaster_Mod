// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import android.os.Bundle;
import android.content.Intent;
import android.os.Parcel;
import android.net.Uri;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class User implements Parcelable
{
    public static final Parcelable$Creator<User> CREATOR;
    private final String mEmail;
    private final String mName;
    private final String mPhoneNumber;
    private final Uri mPhotoUri;
    private final String mProviderId;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<User>() {
            public User createFromParcel(final Parcel parcel) {
                return new User(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Uri)parcel.readParcelable(Uri.class.getClassLoader()), null);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public User[] newArray(final int n) {
                return new User[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private User(final String mProviderId, final String mEmail, final String mPhoneNumber, final String mName, final Uri mPhotoUri) {
        this.mProviderId = mProviderId;
        this.mEmail = mEmail;
        this.mPhoneNumber = mPhoneNumber;
        this.mName = mName;
        this.mPhotoUri = mPhotoUri;
    }
    
    User(final String s, final String s2, final String s3, final String s4, final Uri uri, final User$1 parcelable$Creator) {
        this(s, s2, s3, s4, uri);
    }
    
    public static User getUser(final Intent intent) {
        return (User)intent.getParcelableExtra("extra_user");
    }
    
    public static User getUser(final Bundle bundle) {
        return (User)bundle.getParcelable("extra_user");
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
        if (o != null && this.getClass() == o.getClass()) {
            final User user = (User)o;
            if (this.mProviderId.equals(user.mProviderId)) {
                final String mEmail = this.mEmail;
                if (mEmail == null) {
                    if (user.mEmail != null) {
                        return false;
                    }
                }
                else if (!mEmail.equals(user.mEmail)) {
                    return false;
                }
                final String mPhoneNumber = this.mPhoneNumber;
                if (mPhoneNumber == null) {
                    if (user.mPhoneNumber != null) {
                        return false;
                    }
                }
                else if (!mPhoneNumber.equals(user.mPhoneNumber)) {
                    return false;
                }
                final String mName = this.mName;
                if (mName == null) {
                    if (user.mName != null) {
                        return false;
                    }
                }
                else if (!mName.equals(user.mName)) {
                    return false;
                }
                final Uri mPhotoUri = this.mPhotoUri;
                final Uri mPhotoUri2 = user.mPhotoUri;
                if (mPhotoUri == null) {
                    if (mPhotoUri2 == null) {
                        return b;
                    }
                }
                else if (mPhotoUri.equals((Object)mPhotoUri2)) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    public String getEmail() {
        return this.mEmail;
    }
    
    public String getName() {
        return this.mName;
    }
    
    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }
    
    public Uri getPhotoUri() {
        return this.mPhotoUri;
    }
    
    public String getProviderId() {
        return this.mProviderId;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.mProviderId.hashCode();
        final String mEmail = this.mEmail;
        int hashCode2 = 0;
        int hashCode3;
        if (mEmail == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = mEmail.hashCode();
        }
        final String mPhoneNumber = this.mPhoneNumber;
        int hashCode4;
        if (mPhoneNumber == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = mPhoneNumber.hashCode();
        }
        final String mName = this.mName;
        int hashCode5;
        if (mName == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = mName.hashCode();
        }
        final Uri mPhotoUri = this.mPhotoUri;
        if (mPhotoUri != null) {
            hashCode2 = mPhotoUri.hashCode();
        }
        return (((hashCode * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode2;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User{mProviderId='");
        sb.append(this.mProviderId);
        sb.append('\'');
        sb.append(", mEmail='");
        sb.append(this.mEmail);
        sb.append('\'');
        sb.append(", mPhoneNumber='");
        sb.append(this.mPhoneNumber);
        sb.append('\'');
        sb.append(", mName='");
        sb.append(this.mName);
        sb.append('\'');
        sb.append(", mPhotoUri=");
        sb.append(this.mPhotoUri);
        sb.append('}');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.mProviderId);
        parcel.writeString(this.mEmail);
        parcel.writeString(this.mPhoneNumber);
        parcel.writeString(this.mName);
        parcel.writeParcelable((Parcelable)this.mPhotoUri, n);
    }
    
    public static class Builder
    {
        private String mEmail;
        private String mName;
        private String mPhoneNumber;
        private Uri mPhotoUri;
        private String mProviderId;
        
        public Builder(final String mProviderId, final String mEmail) {
            this.mProviderId = mProviderId;
            this.mEmail = mEmail;
        }
        
        public User build() {
            return new User(this.mProviderId, this.mEmail, this.mPhoneNumber, this.mName, this.mPhotoUri, null);
        }
        
        public Builder setName(final String mName) {
            this.mName = mName;
            return this;
        }
        
        public Builder setPhoneNumber(final String mPhoneNumber) {
            this.mPhoneNumber = mPhoneNumber;
            return this;
        }
        
        public Builder setPhotoUri(final Uri mPhotoUri) {
            this.mPhotoUri = mPhotoUri;
            return this;
        }
    }
}
