// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import java.util.Iterator;
import android.text.TextUtils;
import android.content.Intent;
import java.util.Collections;
import com.firebase.ui.auth.util.Preconditions;
import android.os.Parcel;
import java.util.List;
import com.google.firebase.auth.ActionCodeSettings;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.AuthMethodPickerLayout;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class FlowParameters implements Parcelable
{
    public static final Parcelable$Creator<FlowParameters> CREATOR;
    public final boolean alwaysShowProviderChoice;
    public final String appName;
    public final AuthMethodPickerLayout authMethodPickerLayout;
    public final AuthUI.IdpConfig defaultProvider;
    public String emailLink;
    public final boolean enableAnonymousUpgrade;
    public final boolean enableCredentials;
    public final boolean enableHints;
    public final boolean lockOrientation;
    public final int logoId;
    public final ActionCodeSettings passwordResetSettings;
    public final String privacyPolicyUrl;
    public final List<AuthUI.IdpConfig> providers;
    public final String termsOfServiceUrl;
    public final int themeId;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FlowParameters>() {
            public FlowParameters createFromParcel(final Parcel parcel) {
                return new FlowParameters(parcel.readString(), parcel.createTypedArrayList((Parcelable$Creator)AuthUI.IdpConfig.CREATOR), (AuthUI.IdpConfig)parcel.readParcelable(AuthUI.IdpConfig.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), (ActionCodeSettings)parcel.readParcelable(ActionCodeSettings.class.getClassLoader()), (AuthMethodPickerLayout)parcel.readParcelable(AuthMethodPickerLayout.class.getClassLoader()));
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public FlowParameters[] newArray(final int n) {
                return new FlowParameters[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public FlowParameters(final String s, final List<AuthUI.IdpConfig> list, final AuthUI.IdpConfig defaultProvider, final int themeId, final int logoId, final String termsOfServiceUrl, final String privacyPolicyUrl, final boolean enableCredentials, final boolean enableHints, final boolean enableAnonymousUpgrade, final boolean alwaysShowProviderChoice, final boolean lockOrientation, final String emailLink, final ActionCodeSettings passwordResetSettings, final AuthMethodPickerLayout authMethodPickerLayout) {
        this.appName = Preconditions.checkNotNull(s, "appName cannot be null", new Object[0]);
        this.providers = Collections.unmodifiableList((List<? extends AuthUI.IdpConfig>)Preconditions.checkNotNull((List<? extends T>)list, "providers cannot be null", new Object[0]));
        this.defaultProvider = defaultProvider;
        this.themeId = themeId;
        this.logoId = logoId;
        this.termsOfServiceUrl = termsOfServiceUrl;
        this.privacyPolicyUrl = privacyPolicyUrl;
        this.enableCredentials = enableCredentials;
        this.enableHints = enableHints;
        this.enableAnonymousUpgrade = enableAnonymousUpgrade;
        this.alwaysShowProviderChoice = alwaysShowProviderChoice;
        this.lockOrientation = lockOrientation;
        this.emailLink = emailLink;
        this.passwordResetSettings = passwordResetSettings;
        this.authMethodPickerLayout = authMethodPickerLayout;
    }
    
    public static FlowParameters fromIntent(final Intent intent) {
        return (FlowParameters)intent.getParcelableExtra("extra_flow_params");
    }
    
    public int describeContents() {
        return 0;
    }
    
    public AuthUI.IdpConfig getDefaultOrFirstProvider() {
        AuthUI.IdpConfig defaultProvider = this.defaultProvider;
        if (defaultProvider == null) {
            defaultProvider = this.providers.get(0);
        }
        return defaultProvider;
    }
    
    public boolean isAnonymousUpgradeEnabled() {
        return this.enableAnonymousUpgrade;
    }
    
    public boolean isPlayServicesRequired() {
        return this.isProviderEnabled("google.com") || this.enableHints || this.enableCredentials;
    }
    
    public boolean isPrivacyPolicyUrlProvided() {
        return TextUtils.isEmpty((CharSequence)this.privacyPolicyUrl) ^ true;
    }
    
    public boolean isProviderEnabled(final String s) {
        final Iterator<AuthUI.IdpConfig> iterator = this.providers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getProviderId().equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isSingleProviderFlow() {
        final int size = this.providers.size();
        boolean b = true;
        if (size != 1) {
            b = false;
        }
        return b;
    }
    
    public boolean isTermsOfServiceUrlProvided() {
        return TextUtils.isEmpty((CharSequence)this.termsOfServiceUrl) ^ true;
    }
    
    public boolean shouldShowProviderChoice() {
        return this.defaultProvider == null && (!this.isSingleProviderFlow() || this.alwaysShowProviderChoice);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.appName);
        parcel.writeTypedList((List)this.providers);
        parcel.writeParcelable((Parcelable)this.defaultProvider, n);
        parcel.writeInt(this.themeId);
        parcel.writeInt(this.logoId);
        parcel.writeString(this.termsOfServiceUrl);
        parcel.writeString(this.privacyPolicyUrl);
        parcel.writeInt((int)(this.enableCredentials ? 1 : 0));
        parcel.writeInt((int)(this.enableHints ? 1 : 0));
        parcel.writeInt((int)(this.enableAnonymousUpgrade ? 1 : 0));
        parcel.writeInt((int)(this.alwaysShowProviderChoice ? 1 : 0));
        parcel.writeInt((int)(this.lockOrientation ? 1 : 0));
        parcel.writeString(this.emailLink);
        parcel.writeParcelable((Parcelable)this.passwordResetSettings, n);
        parcel.writeParcelable((Parcelable)this.authMethodPickerLayout, n);
    }
}
