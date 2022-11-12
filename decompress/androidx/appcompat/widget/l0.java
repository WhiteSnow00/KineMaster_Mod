// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.net.Uri$Builder;
import java.util.List;
import android.content.res.Resources;
import d.f;
import android.view.ViewGroup;
import android.view.View;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.ImageView;
import java.io.InputStream;
import java.io.IOException;
import android.content.res.Resources$NotFoundException;
import java.io.FileNotFoundException;
import android.net.Uri;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.content.ComponentName;
import android.text.style.TextAppearanceSpan;
import android.text.SpannableString;
import d.a;
import android.util.TypedValue;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.database.Cursor;
import android.graphics.drawable.Drawable$ConstantState;
import java.util.WeakHashMap;
import android.content.Context;
import android.app.SearchableInfo;
import android.content.res.ColorStateList;
import android.view.View$OnClickListener;
import z.c;

class l0 extends c implements View$OnClickListener
{
    private final int A;
    private boolean B;
    private int C;
    private ColorStateList D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private final SearchView w;
    private final SearchableInfo x;
    private final Context y;
    private final WeakHashMap<String, Drawable$ConstantState> z;
    
    public l0(final Context y, final SearchView w, final SearchableInfo x, final WeakHashMap<String, Drawable$ConstantState> z) {
        super(y, w.getSuggestionRowLayout(), null, true);
        this.B = false;
        this.C = 1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.w = w;
        this.x = x;
        this.A = w.getSuggestionCommitIconResId();
        this.y = y;
        this.z = z;
    }
    
    private void A(final String s, final Drawable drawable) {
        if (drawable != null) {
            this.z.put(s, drawable.getConstantState());
        }
    }
    
    private void B(final Cursor cursor) {
        Bundle extras;
        if (cursor != null) {
            extras = cursor.getExtras();
        }
        else {
            extras = null;
        }
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }
    
    private Drawable k(final String s) {
        final Drawable$ConstantState drawable$ConstantState = this.z.get(s);
        if (drawable$ConstantState == null) {
            return null;
        }
        return drawable$ConstantState.newDrawable();
    }
    
    private CharSequence l(final CharSequence charSequence) {
        if (this.D == null) {
            final TypedValue typedValue = new TypedValue();
            this.y.getTheme().resolveAttribute(d.a.N, typedValue, true);
            this.D = this.y.getResources().getColorStateList(typedValue.resourceId);
        }
        final SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan((Object)new TextAppearanceSpan((String)null, 0, 0, this.D, (ColorStateList)null), 0, charSequence.length(), 33);
        return (CharSequence)spannableString;
    }
    
    private Drawable m(final ComponentName componentName) {
        final PackageManager packageManager = this.y.getPackageManager();
        try {
            final ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            final int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            final Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid icon resource ");
                sb.append(iconResource);
                sb.append(" for ");
                sb.append(componentName.flattenToShortString());
                Log.w("SuggestionsAdapter", sb.toString());
                return null;
            }
            return drawable;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            Log.w("SuggestionsAdapter", ex.toString());
            return null;
        }
    }
    
    private Drawable n(final ComponentName componentName) {
        final String flattenToShortString = componentName.flattenToShortString();
        final boolean containsKey = this.z.containsKey(flattenToShortString);
        final Drawable$ConstantState drawable$ConstantState = null;
        final Drawable drawable = null;
        if (containsKey) {
            final Drawable$ConstantState drawable$ConstantState2 = this.z.get(flattenToShortString);
            Drawable drawable2;
            if (drawable$ConstantState2 == null) {
                drawable2 = drawable;
            }
            else {
                drawable2 = drawable$ConstantState2.newDrawable(this.y.getResources());
            }
            return drawable2;
        }
        final Drawable m = this.m(componentName);
        Drawable$ConstantState constantState;
        if (m == null) {
            constantState = drawable$ConstantState;
        }
        else {
            constantState = m.getConstantState();
        }
        this.z.put(flattenToShortString, constantState);
        return m;
    }
    
    public static String o(final Cursor cursor, final String s) {
        return w(cursor, cursor.getColumnIndex(s));
    }
    
    private Drawable p() {
        final Drawable n = this.n(this.x.getSearchActivity());
        if (n != null) {
            return n;
        }
        return this.y.getPackageManager().getDefaultActivityIcon();
    }
    
    private Drawable q(final Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return this.r(uri);
                }
                catch (final Resources$NotFoundException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Resource does not exist: ");
                    sb.append(uri);
                    throw new FileNotFoundException(sb.toString());
                }
            }
            final InputStream openInputStream = this.y.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                try {
                    return Drawable.createFromStream(openInputStream, (String)null);
                }
                finally {
                    try {
                        openInputStream.close();
                    }
                    catch (final IOException ex2) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error closing icon stream for ");
                        sb2.append(uri);
                        Log.e("SuggestionsAdapter", sb2.toString(), (Throwable)ex2);
                    }
                }
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to open ");
            sb3.append(uri);
            throw new FileNotFoundException(sb3.toString());
        }
        catch (final FileNotFoundException ex3) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Icon not found: ");
            sb4.append(uri);
            sb4.append(", ");
            sb4.append(ex3.getMessage());
            Log.w("SuggestionsAdapter", sb4.toString());
            return null;
        }
    }
    
    private Drawable s(final String s) {
        Drawable q;
        final Drawable drawable = q = null;
        if (s != null) {
            q = drawable;
            if (!s.isEmpty()) {
                if ("0".equals(s)) {
                    q = drawable;
                }
                else {
                    try {
                        final int int1 = Integer.parseInt(s);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("android.resource://");
                        sb.append(this.y.getPackageName());
                        sb.append("/");
                        sb.append(int1);
                        final String string = sb.toString();
                        final Drawable k = this.k(string);
                        if (k != null) {
                            return k;
                        }
                        final Drawable drawable2 = androidx.core.content.a.getDrawable(this.y, int1);
                        this.A(string, drawable2);
                        return drawable2;
                    }
                    catch (final Resources$NotFoundException ex) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Icon resource not found: ");
                        sb2.append(s);
                        Log.w("SuggestionsAdapter", sb2.toString());
                        return null;
                    }
                    catch (final NumberFormatException ex2) {
                        final Drawable i = this.k(s);
                        if (i != null) {
                            return i;
                        }
                        q = this.q(Uri.parse(s));
                        this.A(s, q);
                    }
                }
            }
        }
        return q;
    }
    
    private Drawable t(final Cursor cursor) {
        final int h = this.H;
        if (h == -1) {
            return null;
        }
        final Drawable s = this.s(cursor.getString(h));
        if (s != null) {
            return s;
        }
        return this.p();
    }
    
    private Drawable u(final Cursor cursor) {
        final int i = this.I;
        if (i == -1) {
            return null;
        }
        return this.s(cursor.getString(i));
    }
    
    private static String w(final Cursor cursor, final int n) {
        if (n == -1) {
            return null;
        }
        try {
            return cursor.getString(n);
        }
        catch (final Exception ex) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)ex);
            return null;
        }
    }
    
    private void y(final ImageView imageView, final Drawable imageDrawable, final int visibility) {
        imageView.setImageDrawable(imageDrawable);
        if (imageDrawable == null) {
            imageView.setVisibility(visibility);
        }
        else {
            imageView.setVisibility(0);
            imageDrawable.setVisible(false, false);
            imageDrawable.setVisible(true, false);
        }
    }
    
    private void z(final TextView textView, final CharSequence text) {
        textView.setText(text);
        if (TextUtils.isEmpty(text)) {
            textView.setVisibility(8);
        }
        else {
            textView.setVisibility(0);
        }
    }
    
    public void a(final Cursor cursor) {
        if (this.B) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.E = cursor.getColumnIndex("suggest_text_1");
                this.F = cursor.getColumnIndex("suggest_text_2");
                this.G = cursor.getColumnIndex("suggest_text_2_url");
                this.H = cursor.getColumnIndex("suggest_icon_1");
                this.I = cursor.getColumnIndex("suggest_icon_2");
                this.J = cursor.getColumnIndex("suggest_flags");
            }
        }
        catch (final Exception ex) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", (Throwable)ex);
        }
    }
    
    public CharSequence b(final Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        final String o = o(cursor, "suggest_intent_query");
        if (o != null) {
            return o;
        }
        if (this.x.shouldRewriteQueryFromData()) {
            final String o2 = o(cursor, "suggest_intent_data");
            if (o2 != null) {
                return o2;
            }
        }
        if (this.x.shouldRewriteQueryFromText()) {
            final String o3 = o(cursor, "suggest_text_1");
            if (o3 != null) {
                return o3;
            }
        }
        return null;
    }
    
    public Cursor c(final CharSequence charSequence) {
        String string;
        if (charSequence == null) {
            string = "";
        }
        else {
            string = charSequence.toString();
        }
        if (this.w.getVisibility() == 0) {
            if (this.w.getWindowVisibility() == 0) {
                try {
                    final Cursor v = this.v(this.x, string, 50);
                    if (v != null) {
                        v.getCount();
                        return v;
                    }
                }
                catch (final RuntimeException ex) {
                    Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", (Throwable)ex);
                }
            }
        }
        return null;
    }
    
    public void e(final View view, final Context context, final Cursor cursor) {
        final a a = (a)view.getTag();
        final int j = this.J;
        int int1;
        if (j != -1) {
            int1 = cursor.getInt(j);
        }
        else {
            int1 = 0;
        }
        if (a.a != null) {
            this.z(a.a, w(cursor, this.E));
        }
        if (a.b != null) {
            final String w = w(cursor, this.G);
            CharSequence charSequence;
            if (w != null) {
                charSequence = this.l(w);
            }
            else {
                charSequence = w(cursor, this.F);
            }
            if (TextUtils.isEmpty(charSequence)) {
                final TextView a2 = a.a;
                if (a2 != null) {
                    a2.setSingleLine(false);
                    a.a.setMaxLines(2);
                }
            }
            else {
                final TextView a3 = a.a;
                if (a3 != null) {
                    a3.setSingleLine(true);
                    a.a.setMaxLines(1);
                }
            }
            this.z(a.b, charSequence);
        }
        final ImageView c = a.c;
        if (c != null) {
            this.y(c, this.t(cursor), 4);
        }
        final ImageView d = a.d;
        if (d != null) {
            this.y(d, this.u(cursor), 8);
        }
        final int c2 = this.C;
        if (c2 != 2 && (c2 != 1 || (int1 & 0x1) == 0x0)) {
            a.e.setVisibility(8);
        }
        else {
            a.e.setVisibility(0);
            a.e.setTag((Object)a.a.getText());
            a.e.setOnClickListener((View$OnClickListener)this);
        }
    }
    
    public View getDropDownView(final int n, View dropDownView, final ViewGroup viewGroup) {
        try {
            dropDownView = super.getDropDownView(n, dropDownView, viewGroup);
            return dropDownView;
        }
        catch (final RuntimeException ex) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", (Throwable)ex);
            final View g = this.g(this.y, this.d(), viewGroup);
            if (g != null) {
                ((a)g.getTag()).a.setText((CharSequence)ex.toString());
            }
            return g;
        }
    }
    
    public View getView(final int n, View view, final ViewGroup viewGroup) {
        try {
            view = super.getView(n, view, viewGroup);
            return view;
        }
        catch (final RuntimeException ex) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", (Throwable)ex);
            final View h = this.h(this.y, this.d(), viewGroup);
            if (h != null) {
                ((a)h.getTag()).a.setText((CharSequence)ex.toString());
            }
            return h;
        }
    }
    
    @Override
    public View h(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        final View h = super.h(context, cursor, viewGroup);
        h.setTag((Object)new a(h));
        ((ImageView)h.findViewById(d.f.q)).setImageResource(this.A);
        return h;
    }
    
    public boolean hasStableIds() {
        return false;
    }
    
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.B(this.d());
    }
    
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.B(this.d());
    }
    
    public void onClick(final View view) {
        final Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.w.U((CharSequence)tag);
        }
    }
    
    Drawable r(final Uri uri) throws FileNotFoundException {
        final String authority = uri.getAuthority();
        if (!TextUtils.isEmpty((CharSequence)authority)) {
            try {
                final Resources resourcesForApplication = this.y.getPackageManager().getResourcesForApplication(authority);
                final List pathSegments = uri.getPathSegments();
                if (pathSegments == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("No path: ");
                    sb.append(uri);
                    throw new FileNotFoundException(sb.toString());
                }
                final int size = pathSegments.size();
                int n = 0;
                Label_0138: {
                    if (size == 1) {
                        try {
                            n = Integer.parseInt(pathSegments.get(0));
                            break Label_0138;
                        }
                        catch (final NumberFormatException ex) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Single path segment is not a resource ID: ");
                            sb2.append(uri);
                            throw new FileNotFoundException(sb2.toString());
                        }
                    }
                    if (size != 2) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("More than two path segments: ");
                        sb3.append(uri);
                        throw new FileNotFoundException(sb3.toString());
                    }
                    n = resourcesForApplication.getIdentifier((String)pathSegments.get(1), (String)pathSegments.get(0), authority);
                }
                if (n != 0) {
                    return resourcesForApplication.getDrawable(n);
                }
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("No resource found for: ");
                sb4.append(uri);
                throw new FileNotFoundException(sb4.toString());
            }
            catch (final PackageManager$NameNotFoundException ex2) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("No package found for authority: ");
                sb5.append(uri);
                throw new FileNotFoundException(sb5.toString());
            }
        }
        final StringBuilder sb6 = new StringBuilder();
        sb6.append("No authority: ");
        sb6.append(uri);
        throw new FileNotFoundException(sb6.toString());
    }
    
    Cursor v(final SearchableInfo searchableInfo, final String s, final int n) {
        final String[] array = null;
        if (searchableInfo == null) {
            return null;
        }
        final String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        final Uri$Builder fragment = new Uri$Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        final String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        final String suggestSelection = searchableInfo.getSuggestSelection();
        String[] array2;
        if (suggestSelection != null) {
            array2 = new String[] { s };
        }
        else {
            fragment.appendPath(s);
            array2 = array;
        }
        if (n > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(n));
        }
        return this.y.getContentResolver().query(fragment.build(), (String[])null, suggestSelection, array2, (String)null);
    }
    
    public void x(final int c) {
        this.C = c;
    }
    
    private static final class a
    {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;
        
        public a(final View view) {
            this.a = (TextView)view.findViewById(16908308);
            this.b = (TextView)view.findViewById(16908309);
            this.c = (ImageView)view.findViewById(16908295);
            this.d = (ImageView)view.findViewById(16908296);
            this.e = (ImageView)view.findViewById(f.q);
        }
    }
}
