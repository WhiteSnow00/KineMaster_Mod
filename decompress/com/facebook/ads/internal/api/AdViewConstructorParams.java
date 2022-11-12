// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;

@Keep
public class AdViewConstructorParams
{
    public static final int CONTEXT = 0;
    public static final int CONTEXT_ATTRS = 1;
    public static final int CONTEXT_ATTRS_STYLE_ATTR = 2;
    public static final int CONTEXT_ATTRS_STYLE_ATTR_STYLE_RES = 3;
    private final AttributeSet mAttributeSet;
    private final Context mContext;
    private final int mDefStyleAttr;
    private final int mDefStyleRes;
    private final int mInitializationType;
    
    public AdViewConstructorParams(final Context mContext) {
        this.mInitializationType = 0;
        this.mContext = mContext;
        this.mAttributeSet = null;
        this.mDefStyleAttr = 0;
        this.mDefStyleRes = 0;
    }
    
    public AdViewConstructorParams(final Context mContext, final AttributeSet mAttributeSet) {
        this.mInitializationType = 1;
        this.mContext = mContext;
        this.mAttributeSet = mAttributeSet;
        this.mDefStyleAttr = 0;
        this.mDefStyleRes = 0;
    }
    
    public AdViewConstructorParams(final Context mContext, final AttributeSet mAttributeSet, final int mDefStyleAttr) {
        this.mInitializationType = 2;
        this.mContext = mContext;
        this.mAttributeSet = mAttributeSet;
        this.mDefStyleAttr = mDefStyleAttr;
        this.mDefStyleRes = 0;
    }
    
    public AdViewConstructorParams(final Context mContext, final AttributeSet mAttributeSet, final int mDefStyleAttr, final int mDefStyleRes) {
        this.mInitializationType = 3;
        this.mContext = mContext;
        this.mAttributeSet = mAttributeSet;
        this.mDefStyleAttr = mDefStyleAttr;
        this.mDefStyleRes = mDefStyleRes;
    }
    
    public AttributeSet getAttributeSet() {
        return this.mAttributeSet;
    }
    
    public Context getContext() {
        return this.mContext;
    }
    
    public int getDefStyleAttr() {
        return this.mDefStyleAttr;
    }
    
    public int getDefStyleRes() {
        return this.mDefStyleRes;
    }
    
    public int getInitializationType() {
        return this.mInitializationType;
    }
}
