// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

import java.util.Iterator;
import android.os.Bundle;
import java.util.HashMap;
import android.os.Parcel;
import java.util.Map;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class AuthMethodPickerLayout implements Parcelable
{
    public static final Parcelable$Creator<AuthMethodPickerLayout> CREATOR;
    private int mainLayout;
    private Map<String, Integer> providersButton;
    private int tosPpView;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<AuthMethodPickerLayout>() {
            public AuthMethodPickerLayout createFromParcel(final Parcel parcel) {
                return new AuthMethodPickerLayout(parcel, null);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public AuthMethodPickerLayout[] newArray(final int n) {
                return new AuthMethodPickerLayout[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private AuthMethodPickerLayout() {
        this.tosPpView = -1;
    }
    
    private AuthMethodPickerLayout(final Parcel parcel) {
        this.tosPpView = -1;
        this.mainLayout = parcel.readInt();
        this.tosPpView = parcel.readInt();
        final Bundle bundle = parcel.readBundle(this.getClass().getClassLoader());
        this.providersButton = new HashMap<String, Integer>();
        for (final String s : bundle.keySet()) {
            this.providersButton.put(s, bundle.getInt(s));
        }
    }
    
    AuthMethodPickerLayout(final Parcel parcel, final AuthMethodPickerLayout$1 parcelable$Creator) {
        this(parcel);
    }
    
    AuthMethodPickerLayout(final AuthMethodPickerLayout$1 parcelable$Creator) {
        this();
    }
    
    static int access$202(final AuthMethodPickerLayout authMethodPickerLayout, final int mainLayout) {
        return authMethodPickerLayout.mainLayout = mainLayout;
    }
    
    static int access$302(final AuthMethodPickerLayout authMethodPickerLayout, final int tosPpView) {
        return authMethodPickerLayout.tosPpView = tosPpView;
    }
    
    static Map access$402(final AuthMethodPickerLayout authMethodPickerLayout, final Map providersButton) {
        return authMethodPickerLayout.providersButton = providersButton;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int getMainLayout() {
        return this.mainLayout;
    }
    
    public Map<String, Integer> getProvidersButton() {
        return this.providersButton;
    }
    
    public int getTosPpView() {
        return this.tosPpView;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.mainLayout);
        parcel.writeInt(this.tosPpView);
        final Bundle bundle = new Bundle();
        for (final String s : this.providersButton.keySet()) {
            bundle.putInt(s, (int)this.providersButton.get(s));
        }
        parcel.writeBundle(bundle);
    }
    
    public static class Builder
    {
        private AuthMethodPickerLayout instance;
        private Map<String, Integer> providersMapping;
        
        public Builder(final int n) {
            AuthMethodPickerLayout.access$202(this.instance = new AuthMethodPickerLayout((AuthMethodPickerLayout$1)null), n);
            this.providersMapping = new HashMap<String, Integer>();
        }
        
        public AuthMethodPickerLayout build() {
            if (!this.providersMapping.isEmpty()) {
                for (final String s : this.providersMapping.keySet()) {
                    if (!AuthUI.SUPPORTED_PROVIDERS.contains(s)) {
                        if (AuthUI.SUPPORTED_OAUTH_PROVIDERS.contains(s)) {
                            continue;
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown provider: ");
                        sb.append(s);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                AuthMethodPickerLayout.access$402(this.instance, this.providersMapping);
                return this.instance;
            }
            throw new IllegalArgumentException("Must configure at least one button.");
        }
        
        public Builder setAnonymousButtonId(final int n) {
            this.providersMapping.put("anonymous", n);
            return this;
        }
        
        public Builder setAppleButtonId(final int n) {
            this.providersMapping.put("apple.com", n);
            return this;
        }
        
        public Builder setEmailButtonId(final int n) {
            this.providersMapping.put("password", n);
            return this;
        }
        
        public Builder setFacebookButtonId(final int n) {
            this.providersMapping.put("facebook.com", n);
            return this;
        }
        
        public Builder setGithubButtonId(final int n) {
            this.providersMapping.put("github.com", n);
            return this;
        }
        
        public Builder setGoogleButtonId(final int n) {
            this.providersMapping.put("google.com", n);
            return this;
        }
        
        public Builder setMicrosoftButtonId(final int n) {
            this.providersMapping.put("microsoft.com", n);
            return this;
        }
        
        public Builder setPhoneButtonId(final int n) {
            this.providersMapping.put("phone", n);
            return this;
        }
        
        public Builder setTosAndPrivacyPolicyId(final int n) {
            AuthMethodPickerLayout.access$302(this.instance, n);
            return this;
        }
        
        public Builder setTwitterButtonId(final int n) {
            this.providersMapping.put("twitter.com", n);
            return this;
        }
        
        public Builder setYahooButtonId(final int n) {
            this.providersMapping.put("yahoo.com", n);
            return this;
        }
    }
}
