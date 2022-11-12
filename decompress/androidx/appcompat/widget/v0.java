// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.os.Bundle;
import android.content.res.AssetFileDescriptor;
import java.io.InputStream;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.graphics.Movie;
import android.content.res.Resources$Theme;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.content.res.Configuration;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.content.res.XmlResourceParser;
import android.content.res.Resources;
import android.content.Context;
import java.lang.ref.WeakReference;

public class v0 extends i0
{
    private static boolean c = false;
    private final WeakReference<Context> b;
    
    public v0(final Context context, final Resources resources) {
        super(resources);
        this.b = new WeakReference<Context>(context);
    }
    
    public static boolean b() {
        return v0.c;
    }
    
    public static void c(final boolean c) {
        v0.c = c;
    }
    
    public static boolean d() {
        b();
        return false;
    }
    
    @Override
    public /* bridge */ XmlResourceParser getAnimation(final int n) throws Resources$NotFoundException {
        return super.getAnimation(n);
    }
    
    @Override
    public /* bridge */ boolean getBoolean(final int n) throws Resources$NotFoundException {
        return super.getBoolean(n);
    }
    
    @Override
    public /* bridge */ int getColor(final int n) throws Resources$NotFoundException {
        return super.getColor(n);
    }
    
    @Override
    public /* bridge */ ColorStateList getColorStateList(final int n) throws Resources$NotFoundException {
        return super.getColorStateList(n);
    }
    
    @Override
    public /* bridge */ Configuration getConfiguration() {
        return super.getConfiguration();
    }
    
    @Override
    public /* bridge */ float getDimension(final int n) throws Resources$NotFoundException {
        return super.getDimension(n);
    }
    
    @Override
    public /* bridge */ int getDimensionPixelOffset(final int n) throws Resources$NotFoundException {
        return super.getDimensionPixelOffset(n);
    }
    
    @Override
    public /* bridge */ int getDimensionPixelSize(final int n) throws Resources$NotFoundException {
        return super.getDimensionPixelSize(n);
    }
    
    @Override
    public /* bridge */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }
    
    public Drawable getDrawable(final int n) throws Resources$NotFoundException {
        final Context context = this.b.get();
        if (context != null) {
            return h0.g().s(context, this, n);
        }
        return this.a(n);
    }
    
    @Override
    public /* bridge */ Drawable getDrawable(final int n, final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        return super.getDrawable(n, resources$Theme);
    }
    
    @Override
    public /* bridge */ Drawable getDrawableForDensity(final int n, final int n2) throws Resources$NotFoundException {
        return super.getDrawableForDensity(n, n2);
    }
    
    @Override
    public /* bridge */ Drawable getDrawableForDensity(final int n, final int n2, final Resources$Theme resources$Theme) {
        return super.getDrawableForDensity(n, n2, resources$Theme);
    }
    
    @Override
    public /* bridge */ float getFraction(final int n, final int n2, final int n3) {
        return super.getFraction(n, n2, n3);
    }
    
    @Override
    public /* bridge */ int getIdentifier(final String s, final String s2, final String s3) {
        return super.getIdentifier(s, s2, s3);
    }
    
    @Override
    public /* bridge */ int[] getIntArray(final int n) throws Resources$NotFoundException {
        return super.getIntArray(n);
    }
    
    @Override
    public /* bridge */ int getInteger(final int n) throws Resources$NotFoundException {
        return super.getInteger(n);
    }
    
    @Override
    public /* bridge */ XmlResourceParser getLayout(final int n) throws Resources$NotFoundException {
        return super.getLayout(n);
    }
    
    @Override
    public /* bridge */ Movie getMovie(final int n) throws Resources$NotFoundException {
        return super.getMovie(n);
    }
    
    @Override
    public /* bridge */ String getQuantityString(final int n, final int n2) throws Resources$NotFoundException {
        return super.getQuantityString(n, n2);
    }
    
    @Override
    public /* bridge */ String getQuantityString(final int n, final int n2, final Object[] array) throws Resources$NotFoundException {
        return super.getQuantityString(n, n2, array);
    }
    
    @Override
    public /* bridge */ CharSequence getQuantityText(final int n, final int n2) throws Resources$NotFoundException {
        return super.getQuantityText(n, n2);
    }
    
    @Override
    public /* bridge */ String getResourceEntryName(final int n) throws Resources$NotFoundException {
        return super.getResourceEntryName(n);
    }
    
    @Override
    public /* bridge */ String getResourceName(final int n) throws Resources$NotFoundException {
        return super.getResourceName(n);
    }
    
    @Override
    public /* bridge */ String getResourcePackageName(final int n) throws Resources$NotFoundException {
        return super.getResourcePackageName(n);
    }
    
    @Override
    public /* bridge */ String getResourceTypeName(final int n) throws Resources$NotFoundException {
        return super.getResourceTypeName(n);
    }
    
    @Override
    public /* bridge */ String getString(final int n) throws Resources$NotFoundException {
        return super.getString(n);
    }
    
    @Override
    public /* bridge */ String getString(final int n, final Object[] array) throws Resources$NotFoundException {
        return super.getString(n, array);
    }
    
    @Override
    public /* bridge */ String[] getStringArray(final int n) throws Resources$NotFoundException {
        return super.getStringArray(n);
    }
    
    @Override
    public /* bridge */ CharSequence getText(final int n) throws Resources$NotFoundException {
        return super.getText(n);
    }
    
    @Override
    public /* bridge */ CharSequence getText(final int n, final CharSequence charSequence) {
        return super.getText(n, charSequence);
    }
    
    @Override
    public /* bridge */ CharSequence[] getTextArray(final int n) throws Resources$NotFoundException {
        return super.getTextArray(n);
    }
    
    @Override
    public /* bridge */ void getValue(final int n, final TypedValue typedValue, final boolean b) throws Resources$NotFoundException {
        super.getValue(n, typedValue, b);
    }
    
    @Override
    public /* bridge */ void getValue(final String s, final TypedValue typedValue, final boolean b) throws Resources$NotFoundException {
        super.getValue(s, typedValue, b);
    }
    
    @Override
    public /* bridge */ void getValueForDensity(final int n, final int n2, final TypedValue typedValue, final boolean b) throws Resources$NotFoundException {
        super.getValueForDensity(n, n2, typedValue, b);
    }
    
    @Override
    public /* bridge */ XmlResourceParser getXml(final int n) throws Resources$NotFoundException {
        return super.getXml(n);
    }
    
    @Override
    public /* bridge */ TypedArray obtainAttributes(final AttributeSet set, final int[] array) {
        return super.obtainAttributes(set, array);
    }
    
    @Override
    public /* bridge */ TypedArray obtainTypedArray(final int n) throws Resources$NotFoundException {
        return super.obtainTypedArray(n);
    }
    
    @Override
    public /* bridge */ InputStream openRawResource(final int n) throws Resources$NotFoundException {
        return super.openRawResource(n);
    }
    
    @Override
    public /* bridge */ InputStream openRawResource(final int n, final TypedValue typedValue) throws Resources$NotFoundException {
        return super.openRawResource(n, typedValue);
    }
    
    @Override
    public /* bridge */ AssetFileDescriptor openRawResourceFd(final int n) throws Resources$NotFoundException {
        return super.openRawResourceFd(n);
    }
    
    @Override
    public /* bridge */ void parseBundleExtra(final String s, final AttributeSet set, final Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(s, set, bundle);
    }
    
    @Override
    public /* bridge */ void parseBundleExtras(final XmlResourceParser xmlResourceParser, final Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }
    
    @Override
    public /* bridge */ void updateConfiguration(final Configuration configuration, final DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }
}
