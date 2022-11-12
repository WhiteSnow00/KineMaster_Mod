// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import android.view.KeyEvent$DispatcherState;
import android.util.TypedValue;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;
import android.view.View$MeasureSpec;
import android.view.TouchDelegate;
import android.content.ActivityNotFoundException;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import d.d;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.SpannableStringBuilder;
import android.content.res.Resources;
import android.content.ComponentName;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.util.Log;
import android.net.Uri;
import android.view.View$OnLayoutChangeListener;
import d.h;
import d.f;
import android.view.ViewGroup;
import d.g;
import android.view.LayoutInflater;
import androidx.core.view.b0;
import d.j;
import android.text.Editable;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.KeyEvent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.TextView$OnEditorActionListener;
import android.view.View$OnKeyListener;
import android.graphics.drawable.Drawable$ConstantState;
import java.util.WeakHashMap;
import android.os.Bundle;
import android.app.SearchableInfo;
import z.a;
import android.view.View$OnClickListener;
import android.view.View$OnFocusChangeListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.widget.ImageView;
import android.view.View;
import android.text.TextWatcher;
import androidx.appcompat.view.c;

public class SearchView extends LinearLayoutCompat implements c
{
    static final o B0;
    final SearchAutoComplete A;
    private TextWatcher A0;
    private final View B;
    private final View C;
    private final View D;
    final ImageView E;
    final ImageView F;
    final ImageView G;
    final ImageView H;
    private final View I;
    private p J;
    private Rect K;
    private Rect L;
    private int[] M;
    private int[] N;
    private final ImageView O;
    private final Drawable P;
    private final int Q;
    private final int R;
    private final Intent S;
    private final Intent T;
    private final CharSequence U;
    private m V;
    private l W;
    View$OnFocusChangeListener a0;
    private n b0;
    private View$OnClickListener c0;
    private boolean d0;
    private boolean e0;
    z.a f0;
    private boolean g0;
    private CharSequence h0;
    private boolean i0;
    private boolean j0;
    private int k0;
    private boolean l0;
    private CharSequence m0;
    private CharSequence n0;
    private boolean o0;
    private int p0;
    SearchableInfo q0;
    private Bundle r0;
    private final Runnable s0;
    private Runnable t0;
    private final WeakHashMap<String, Drawable$ConstantState> u0;
    private final View$OnClickListener v0;
    View$OnKeyListener w0;
    private final TextView$OnEditorActionListener x0;
    private final AdapterView$OnItemClickListener y0;
    private final AdapterView$OnItemSelectedListener z0;
    
    static {
        o b0;
        if (Build$VERSION.SDK_INT < 29) {
            b0 = new o();
        }
        else {
            b0 = null;
        }
        B0 = b0;
    }
    
    public SearchView(final Context context) {
        this(context, null);
    }
    
    public SearchView(final Context context, final AttributeSet set) {
        this(context, set, d.a.J);
    }
    
    public SearchView(final Context context, final AttributeSet set, int inputType) {
        super(context, set, inputType);
        this.K = new Rect();
        this.L = new Rect();
        this.M = new int[2];
        this.N = new int[2];
        this.s0 = new Runnable() {
            final SearchView a;
            
            @Override
            public void run() {
                this.a.f0();
            }
        };
        this.t0 = new Runnable() {
            final SearchView a;
            
            @Override
            public void run() {
                final z.a f0 = this.a.f0;
                if (f0 instanceof l0) {
                    f0.a(null);
                }
            }
        };
        this.u0 = new WeakHashMap<String, Drawable$ConstantState>();
        final View$OnClickListener view$OnClickListener = (View$OnClickListener)new View$OnClickListener() {
            final SearchView a;
            
            public void onClick(final View view) {
                final SearchView a = this.a;
                if (view == a.E) {
                    a.V();
                }
                else if (view == a.G) {
                    a.R();
                }
                else if (view == a.F) {
                    a.W();
                }
                else if (view == a.H) {
                    a.a0();
                }
                else if (view == a.A) {
                    a.H();
                }
            }
        };
        this.v0 = (View$OnClickListener)view$OnClickListener;
        this.w0 = (View$OnKeyListener)new View$OnKeyListener() {
            final SearchView a;
            
            public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                final SearchView a = this.a;
                if (a.q0 == null) {
                    return false;
                }
                if (a.A.isPopupShowing() && this.a.A.getListSelection() != -1) {
                    return this.a.X(view, n, keyEvent);
                }
                if (!this.a.A.c() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && n == 66) {
                    view.cancelLongPress();
                    final SearchView a2 = this.a;
                    a2.P(0, null, a2.A.getText().toString());
                    return true;
                }
                return false;
            }
        };
        final TextView$OnEditorActionListener textView$OnEditorActionListener = (TextView$OnEditorActionListener)new TextView$OnEditorActionListener() {
            final SearchView a;
            
            public boolean onEditorAction(final TextView textView, final int n, final KeyEvent keyEvent) {
                this.a.W();
                return true;
            }
        };
        this.x0 = (TextView$OnEditorActionListener)textView$OnEditorActionListener;
        final AdapterView$OnItemClickListener adapterView$OnItemClickListener = (AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
            final SearchView a;
            
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                this.a.S(n, 0, null);
            }
        };
        this.y0 = (AdapterView$OnItemClickListener)adapterView$OnItemClickListener;
        final AdapterView$OnItemSelectedListener adapterView$OnItemSelectedListener = (AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener() {
            final SearchView a;
            
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                this.a.T(n);
            }
            
            public void onNothingSelected(final AdapterView<?> adapterView) {
            }
        };
        this.z0 = (AdapterView$OnItemSelectedListener)adapterView$OnItemSelectedListener;
        this.A0 = (TextWatcher)new TextWatcher() {
            final SearchView a;
            
            public void afterTextChanged(final Editable editable) {
            }
            
            public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
            }
            
            public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
                this.a.Y(charSequence);
            }
        };
        final int[] f2 = d.j.f2;
        final r0 v = androidx.appcompat.widget.r0.v(context, set, f2, inputType, 0);
        androidx.core.view.b0.n0((View)this, context, f2, set, v.r(), inputType, 0);
        LayoutInflater.from(context).inflate(v.n(d.j.p2, d.g.r), (ViewGroup)this, true);
        final SearchAutoComplete a = (SearchAutoComplete)this.findViewById(d.f.C);
        (this.A = a).setSearchView(this);
        this.B = this.findViewById(d.f.y);
        final View viewById = this.findViewById(d.f.B);
        this.C = viewById;
        final View viewById2 = this.findViewById(d.f.I);
        this.D = viewById2;
        final ImageView e = (ImageView)this.findViewById(d.f.w);
        this.E = e;
        final ImageView f3 = (ImageView)this.findViewById(d.f.z);
        this.F = f3;
        final ImageView g = (ImageView)this.findViewById(d.f.x);
        this.G = g;
        final ImageView h = (ImageView)this.findViewById(d.f.D);
        this.H = h;
        final ImageView o = (ImageView)this.findViewById(d.f.A);
        this.O = o;
        androidx.core.view.b0.t0(viewById, v.g(d.j.q2));
        androidx.core.view.b0.t0(viewById2, v.g(d.j.u2));
        inputType = d.j.t2;
        e.setImageDrawable(v.g(inputType));
        f3.setImageDrawable(v.g(d.j.n2));
        g.setImageDrawable(v.g(d.j.k2));
        h.setImageDrawable(v.g(d.j.w2));
        o.setImageDrawable(v.g(inputType));
        this.P = v.g(d.j.s2);
        androidx.appcompat.widget.u0.a((View)e, this.getResources().getString(d.h.n));
        this.Q = v.n(d.j.v2, d.g.q);
        this.R = v.n(d.j.l2, 0);
        e.setOnClickListener((View$OnClickListener)view$OnClickListener);
        g.setOnClickListener((View$OnClickListener)view$OnClickListener);
        f3.setOnClickListener((View$OnClickListener)view$OnClickListener);
        h.setOnClickListener((View$OnClickListener)view$OnClickListener);
        a.setOnClickListener((View$OnClickListener)view$OnClickListener);
        a.addTextChangedListener(this.A0);
        a.setOnEditorActionListener((TextView$OnEditorActionListener)textView$OnEditorActionListener);
        a.setOnItemClickListener((AdapterView$OnItemClickListener)adapterView$OnItemClickListener);
        a.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)adapterView$OnItemSelectedListener);
        a.setOnKeyListener(this.w0);
        a.setOnFocusChangeListener((View$OnFocusChangeListener)new View$OnFocusChangeListener(this) {
            final SearchView a;
            
            public void onFocusChange(final View view, final boolean b) {
                final SearchView a = this.a;
                final View$OnFocusChangeListener a2 = a.a0;
                if (a2 != null) {
                    a2.onFocusChange((View)a, b);
                }
            }
        });
        this.setIconifiedByDefault(v.a(d.j.o2, true));
        inputType = v.f(d.j.h2, -1);
        if (inputType != -1) {
            this.setMaxWidth(inputType);
        }
        this.U = v.p(d.j.m2);
        this.h0 = v.p(d.j.r2);
        inputType = v.k(d.j.j2, -1);
        if (inputType != -1) {
            this.setImeOptions(inputType);
        }
        inputType = v.k(d.j.i2, -1);
        if (inputType != -1) {
            this.setInputType(inputType);
        }
        this.setFocusable(v.a(d.j.g2, true));
        v.w();
        final Intent s = new Intent("android.speech.action.WEB_SEARCH");
        (this.S = s).addFlags(268435456);
        s.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        (this.T = new Intent("android.speech.action.RECOGNIZE_SPEECH")).addFlags(268435456);
        final View viewById3 = this.findViewById(a.getDropDownAnchor());
        if ((this.I = viewById3) != null) {
            viewById3.addOnLayoutChangeListener((View$OnLayoutChangeListener)new View$OnLayoutChangeListener(this) {
                final SearchView a;
                
                public void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
                    this.a.B();
                }
            });
        }
        this.k0(this.d0);
        this.g0();
    }
    
    private Intent C(final String s, final Uri data, final String s2, final String s3, final int n, final String s4) {
        final Intent intent = new Intent(s);
        intent.addFlags(268435456);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", this.n0);
        if (s3 != null) {
            intent.putExtra("query", s3);
        }
        if (s2 != null) {
            intent.putExtra("intent_extra_data_key", s2);
        }
        final Bundle r0 = this.r0;
        if (r0 != null) {
            intent.putExtra("app_data", r0);
        }
        if (n != 0) {
            intent.putExtra("action_key", n);
            intent.putExtra("action_msg", s4);
        }
        intent.setComponent(this.q0.getSearchActivity());
        return intent;
    }
    
    private Intent D(final Cursor cursor, int position, final String ex) {
        try {
            String s;
            if ((s = androidx.appcompat.widget.l0.o(cursor, "suggest_intent_action")) == null) {
                s = this.q0.getSuggestIntentAction();
            }
            String s2;
            if ((s2 = s) == null) {
                s2 = "android.intent.action.SEARCH";
            }
            String s3;
            if ((s3 = androidx.appcompat.widget.l0.o(cursor, "suggest_intent_data")) == null) {
                s3 = this.q0.getSuggestIntentData();
            }
            String string;
            if ((string = s3) != null) {
                final String o = androidx.appcompat.widget.l0.o(cursor, "suggest_intent_data_id");
                string = s3;
                if (o != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s3);
                    sb.append("/");
                    sb.append(Uri.encode(o));
                    string = sb.toString();
                }
            }
            Uri parse;
            if (string == null) {
                parse = null;
            }
            else {
                parse = Uri.parse(string);
            }
            return this.C(s2, parse, androidx.appcompat.widget.l0.o(cursor, "suggest_intent_extra_data"), androidx.appcompat.widget.l0.o(cursor, "suggest_intent_query"), position, (String)ex);
        }
        catch (final RuntimeException ex) {
            try {
                position = cursor.getPosition();
            }
            catch (final RuntimeException ex2) {
                position = -1;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Search suggestions cursor at row ");
            sb2.append(position);
            sb2.append(" returned exception.");
            Log.w("SearchView", sb2.toString(), (Throwable)ex);
            return null;
        }
    }
    
    private Intent E(final Intent intent, final SearchableInfo searchableInfo) {
        final ComponentName searchActivity = searchableInfo.getSearchActivity();
        final Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        final PendingIntent activity = PendingIntent.getActivity(this.getContext(), 0, intent2, 1107296256);
        final Bundle bundle = new Bundle();
        final Bundle r0 = this.r0;
        if (r0 != null) {
            bundle.putParcelable("app_data", (Parcelable)r0);
        }
        final Intent intent3 = new Intent(intent);
        int voiceMaxResults = 1;
        final Resources resources = this.getResources();
        String string;
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            string = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        else {
            string = "free_form";
        }
        final int voicePromptTextId = searchableInfo.getVoicePromptTextId();
        final String s = null;
        String string2;
        if (voicePromptTextId != 0) {
            string2 = resources.getString(searchableInfo.getVoicePromptTextId());
        }
        else {
            string2 = null;
        }
        String string3;
        if (searchableInfo.getVoiceLanguageId() != 0) {
            string3 = resources.getString(searchableInfo.getVoiceLanguageId());
        }
        else {
            string3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            voiceMaxResults = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        String flattenToShortString;
        if (searchActivity == null) {
            flattenToShortString = s;
        }
        else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", flattenToShortString);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", (Parcelable)activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }
    
    private Intent F(final Intent intent, final SearchableInfo searchableInfo) {
        final Intent intent2 = new Intent(intent);
        final ComponentName searchActivity = searchableInfo.getSearchActivity();
        String flattenToShortString;
        if (searchActivity == null) {
            flattenToShortString = null;
        }
        else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", flattenToShortString);
        return intent2;
    }
    
    private void G() {
        this.A.dismissDropDown();
    }
    
    private void I(final View view, final Rect rect) {
        view.getLocationInWindow(this.M);
        this.getLocationInWindow(this.N);
        final int[] m = this.M;
        final int n = m[1];
        final int[] n2 = this.N;
        final int n3 = n - n2[1];
        final int n4 = m[0] - n2[0];
        rect.set(n4, n3, view.getWidth() + n4, view.getHeight() + n3);
    }
    
    private CharSequence J(final CharSequence charSequence) {
        if (this.d0 && this.P != null) {
            final int n = (int)(this.A.getTextSize() * 1.25);
            this.P.setBounds(0, 0, n, n);
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)"   ");
            spannableStringBuilder.setSpan((Object)new ImageSpan(this.P), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return (CharSequence)spannableStringBuilder;
        }
        return charSequence;
    }
    
    private boolean K() {
        final SearchableInfo q0 = this.q0;
        boolean b2;
        final boolean b = b2 = false;
        if (q0 != null) {
            b2 = b;
            if (q0.getVoiceSearchEnabled()) {
                Intent intent = null;
                if (this.q0.getVoiceSearchLaunchWebSearch()) {
                    intent = this.S;
                }
                else if (this.q0.getVoiceSearchLaunchRecognizer()) {
                    intent = this.T;
                }
                b2 = b;
                if (intent != null) {
                    b2 = b;
                    if (this.getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    static boolean M(final Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
    
    private boolean N() {
        return (this.g0 || this.l0) && !this.L();
    }
    
    private void O(final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            this.getContext().startActivity(intent);
        }
        catch (final RuntimeException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed launch activity: ");
            sb.append(intent);
            Log.e("SearchView", sb.toString(), (Throwable)ex);
        }
    }
    
    private boolean Q(final int n, final int n2, final String s) {
        final Cursor d = this.f0.d();
        if (d != null && d.moveToPosition(n)) {
            this.O(this.D(d, n2, s));
            return true;
        }
        return false;
    }
    
    private void b0() {
        this.post(this.s0);
    }
    
    private void c0(final int n) {
        final Editable text = this.A.getText();
        final Cursor d = this.f0.d();
        if (d == null) {
            return;
        }
        if (d.moveToPosition(n)) {
            final CharSequence b = this.f0.b(d);
            if (b != null) {
                this.setQuery(b);
            }
            else {
                this.setQuery((CharSequence)text);
            }
        }
        else {
            this.setQuery((CharSequence)text);
        }
    }
    
    private void e0() {
        final boolean empty = TextUtils.isEmpty((CharSequence)this.A.getText());
        final boolean b = true;
        final boolean b2 = empty ^ true;
        final int n = 0;
        int n2 = b ? 1 : 0;
        if (!b2) {
            if (this.d0 && !this.o0) {
                n2 = (b ? 1 : 0);
            }
            else {
                n2 = 0;
            }
        }
        final ImageView g = this.G;
        int visibility;
        if (n2 != 0) {
            visibility = n;
        }
        else {
            visibility = 8;
        }
        g.setVisibility(visibility);
        final Drawable drawable = this.G.getDrawable();
        if (drawable != null) {
            int[] state;
            if (b2) {
                state = ViewGroup.ENABLED_STATE_SET;
            }
            else {
                state = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(state);
        }
    }
    
    private void g0() {
        final CharSequence queryHint = this.getQueryHint();
        final SearchAutoComplete a = this.A;
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        a.setHint(this.J(charSequence));
    }
    
    private int getPreferredHeight() {
        return this.getContext().getResources().getDimensionPixelSize(d.d.g);
    }
    
    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(d.d.h);
    }
    
    private void h0() {
        this.A.setThreshold(this.q0.getSuggestThreshold());
        this.A.setImeOptions(this.q0.getImeOptions());
        final int inputType = this.q0.getInputType();
        final int n = 1;
        int inputType2 = inputType;
        if ((inputType & 0xF) == 0x1) {
            inputType2 = (inputType & 0xFFFEFFFF);
            if (this.q0.getSuggestAuthority() != null) {
                inputType2 = (inputType2 | 0x10000 | 0x80000);
            }
        }
        this.A.setInputType(inputType2);
        final z.a f0 = this.f0;
        if (f0 != null) {
            f0.a(null);
        }
        if (this.q0.getSuggestAuthority() != null) {
            final l0 l0 = new l0(this.getContext(), this, this.q0, this.u0);
            this.f0 = l0;
            this.A.setAdapter((ListAdapter)l0);
            final l0 l2 = (l0)this.f0;
            int n2 = n;
            if (this.i0) {
                n2 = 2;
            }
            l2.x(n2);
        }
    }
    
    private void i0() {
        int visibility;
        if (this.N() && (this.F.getVisibility() == 0 || this.H.getVisibility() == 0)) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.D.setVisibility(visibility);
    }
    
    private void j0(final boolean b) {
        int visibility;
        if (this.g0 && this.N() && this.hasFocus() && (b || !this.l0)) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.F.setVisibility(visibility);
    }
    
    private void k0(final boolean e0) {
        this.e0 = e0;
        final int n = 0;
        int visibility;
        if (e0) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        final boolean b = TextUtils.isEmpty((CharSequence)this.A.getText()) ^ true;
        this.E.setVisibility(visibility);
        this.j0(b);
        final View b2 = this.B;
        int visibility2;
        if (e0) {
            visibility2 = 8;
        }
        else {
            visibility2 = 0;
        }
        b2.setVisibility(visibility2);
        int visibility3 = 0;
        Label_0093: {
            if (this.O.getDrawable() != null) {
                visibility3 = n;
                if (!this.d0) {
                    break Label_0093;
                }
            }
            visibility3 = 8;
        }
        this.O.setVisibility(visibility3);
        this.e0();
        this.l0(b ^ true);
        this.i0();
    }
    
    private void l0(final boolean b) {
        final boolean l0 = this.l0;
        int visibility;
        final int n = visibility = 8;
        if (l0) {
            visibility = n;
            if (!this.L()) {
                visibility = n;
                if (b) {
                    this.F.setVisibility(8);
                    visibility = 0;
                }
            }
        }
        this.H.setVisibility(visibility);
    }
    
    private void setQuery(final CharSequence text) {
        this.A.setText(text);
        final SearchAutoComplete a = this.A;
        int length;
        if (TextUtils.isEmpty(text)) {
            length = 0;
        }
        else {
            length = text.length();
        }
        a.setSelection(length);
    }
    
    void B() {
        if (this.I.getWidth() > 1) {
            final Resources resources = this.getContext().getResources();
            final int paddingLeft = this.C.getPaddingLeft();
            final Rect rect = new Rect();
            final boolean b = androidx.appcompat.widget.w0.b((View)this);
            int n;
            if (this.d0) {
                n = resources.getDimensionPixelSize(d.d.e) + resources.getDimensionPixelSize(d.d.f);
            }
            else {
                n = 0;
            }
            this.A.getDropDownBackground().getPadding(rect);
            int dropDownHorizontalOffset;
            if (b) {
                dropDownHorizontalOffset = -rect.left;
            }
            else {
                dropDownHorizontalOffset = paddingLeft - (rect.left + n);
            }
            this.A.setDropDownHorizontalOffset(dropDownHorizontalOffset);
            this.A.setDropDownWidth(this.I.getWidth() + rect.left + rect.right + n - paddingLeft);
        }
    }
    
    void H() {
        if (Build$VERSION.SDK_INT >= 29) {
            k.a(this.A);
        }
        else {
            final o b0 = SearchView.B0;
            b0.b(this.A);
            b0.a(this.A);
        }
    }
    
    public boolean L() {
        return this.e0;
    }
    
    void P(final int n, final String s, final String s2) {
        this.getContext().startActivity(this.C("android.intent.action.SEARCH", null, null, s2, n, s));
    }
    
    void R() {
        if (TextUtils.isEmpty((CharSequence)this.A.getText())) {
            if (this.d0) {
                final l w = this.W;
                if (w == null || !w.c()) {
                    this.clearFocus();
                    this.k0(true);
                }
            }
        }
        else {
            this.A.setText((CharSequence)"");
            this.A.requestFocus();
            this.A.setImeVisibility(true);
        }
    }
    
    boolean S(final int n, final int n2, final String s) {
        final n b0 = this.b0;
        if (b0 != null && b0.b(n)) {
            return false;
        }
        this.Q(n, 0, null);
        this.A.setImeVisibility(false);
        this.G();
        return true;
    }
    
    boolean T(final int n) {
        final n b0 = this.b0;
        if (b0 != null && b0.a(n)) {
            return false;
        }
        this.c0(n);
        return true;
    }
    
    protected void U(final CharSequence query) {
        this.setQuery(query);
    }
    
    void V() {
        this.k0(false);
        this.A.requestFocus();
        this.A.setImeVisibility(true);
        final View$OnClickListener c0 = this.c0;
        if (c0 != null) {
            c0.onClick((View)this);
        }
    }
    
    void W() {
        final Editable text = this.A.getText();
        if (text != null && TextUtils.getTrimmedLength((CharSequence)text) > 0) {
            final m v = this.V;
            if (v == null || !v.onQueryTextSubmit(((CharSequence)text).toString())) {
                if (this.q0 != null) {
                    this.P(0, null, ((CharSequence)text).toString());
                }
                this.A.setImeVisibility(false);
                this.G();
            }
        }
    }
    
    boolean X(final View view, int length, final KeyEvent keyEvent) {
        if (this.q0 == null) {
            return false;
        }
        if (this.f0 == null) {
            return false;
        }
        if (keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (length == 66 || length == 84 || length == 61) {
                return this.S(this.A.getListSelection(), 0, null);
            }
            if (length == 21 || length == 22) {
                if (length == 21) {
                    length = 0;
                }
                else {
                    length = this.A.length();
                }
                this.A.setSelection(length);
                this.A.setListSelection(0);
                this.A.clearListSelection();
                this.A.b();
                return true;
            }
            if (length == 19) {
                this.A.getListSelection();
                return false;
            }
        }
        return false;
    }
    
    void Y(final CharSequence charSequence) {
        final Editable text = this.A.getText();
        this.n0 = (CharSequence)text;
        final boolean b = TextUtils.isEmpty((CharSequence)text) ^ true;
        this.j0(b);
        this.l0(b ^ true);
        this.e0();
        this.i0();
        if (this.V != null && !TextUtils.equals(charSequence, this.m0)) {
            this.V.onQueryTextChange(charSequence.toString());
        }
        this.m0 = charSequence.toString();
    }
    
    void Z() {
        this.k0(this.L());
        this.b0();
        if (this.A.hasFocus()) {
            this.H();
        }
    }
    
    void a0() {
        final SearchableInfo q0 = this.q0;
        if (q0 == null) {
            return;
        }
        try {
            if (q0.getVoiceSearchLaunchWebSearch()) {
                this.getContext().startActivity(this.F(this.S, q0));
            }
            else if (q0.getVoiceSearchLaunchRecognizer()) {
                this.getContext().startActivity(this.E(this.T, q0));
            }
        }
        catch (final ActivityNotFoundException ex) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }
    
    @Override
    public void b() {
        if (this.o0) {
            return;
        }
        this.o0 = true;
        final int imeOptions = this.A.getImeOptions();
        this.p0 = imeOptions;
        this.A.setImeOptions(imeOptions | 0x2000000);
        this.A.setText((CharSequence)"");
        this.setIconified(false);
    }
    
    public void clearFocus() {
        this.j0 = true;
        super.clearFocus();
        this.A.clearFocus();
        this.A.setImeVisibility(false);
        this.j0 = false;
    }
    
    public void d0(final CharSequence charSequence, final boolean b) {
        this.A.setText(charSequence);
        if (charSequence != null) {
            final SearchAutoComplete a = this.A;
            a.setSelection(a.length());
            this.n0 = charSequence;
        }
        if (b && !TextUtils.isEmpty(charSequence)) {
            this.W();
        }
    }
    
    @Override
    public void f() {
        this.d0("", false);
        this.clearFocus();
        this.k0(true);
        this.A.setImeOptions(this.p0);
        this.o0 = false;
    }
    
    void f0() {
        int[] array;
        if (this.A.hasFocus()) {
            array = ViewGroup.FOCUSED_STATE_SET;
        }
        else {
            array = ViewGroup.EMPTY_STATE_SET;
        }
        final Drawable background = this.C.getBackground();
        if (background != null) {
            background.setState(array);
        }
        final Drawable background2 = this.D.getBackground();
        if (background2 != null) {
            background2.setState(array);
        }
        this.invalidate();
    }
    
    public int getImeOptions() {
        return this.A.getImeOptions();
    }
    
    public int getInputType() {
        return this.A.getInputType();
    }
    
    public int getMaxWidth() {
        return this.k0;
    }
    
    public CharSequence getQuery() {
        return (CharSequence)this.A.getText();
    }
    
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.h0;
        if (charSequence == null) {
            final SearchableInfo q0 = this.q0;
            if (q0 != null && q0.getHintId() != 0) {
                charSequence = this.getContext().getText(this.q0.getHintId());
            }
            else {
                charSequence = this.U;
            }
        }
        return charSequence;
    }
    
    int getSuggestionCommitIconResId() {
        return this.R;
    }
    
    int getSuggestionRowLayout() {
        return this.Q;
    }
    
    public z.a getSuggestionsAdapter() {
        return this.f0;
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.s0);
        this.post(this.t0);
        super.onDetachedFromWindow();
    }
    
    @Override
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (b) {
            this.I((View)this.A, this.K);
            final Rect l = this.L;
            final Rect k = this.K;
            l.set(k.left, 0, k.right, n4 - n2);
            final p j = this.J;
            if (j == null) {
                this.setTouchDelegate((TouchDelegate)(this.J = new p(this.L, this.K, (View)this.A)));
            }
            else {
                j.a(this.L, this.K);
            }
        }
    }
    
    @Override
    protected void onMeasure(int n, int n2) {
        if (this.L()) {
            super.onMeasure(n, n2);
            return;
        }
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    n = size;
                }
                else {
                    final int k0 = this.k0;
                    n = size;
                    if (k0 > 0) {
                        n = Math.min(k0, size);
                    }
                }
            }
            else {
                n = this.k0;
                if (n <= 0) {
                    n = this.getPreferredWidth();
                }
            }
        }
        else {
            n = this.k0;
            if (n > 0) {
                n = Math.min(n, size);
            }
            else {
                n = Math.min(this.getPreferredWidth(), size);
            }
        }
        final int mode2 = View$MeasureSpec.getMode(n2);
        n2 = View$MeasureSpec.getSize(n2);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                n2 = this.getPreferredHeight();
            }
        }
        else {
            n2 = Math.min(this.getPreferredHeight(), n2);
        }
        super.onMeasure(View$MeasureSpec.makeMeasureSpec(n, 1073741824), View$MeasureSpec.makeMeasureSpec(n2, 1073741824));
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.k0(savedState.c);
        this.requestLayout();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.L();
        return (Parcelable)savedState;
    }
    
    public void onWindowFocusChanged(final boolean b) {
        super.onWindowFocusChanged(b);
        this.b0();
    }
    
    public boolean requestFocus(final int n, final Rect rect) {
        if (this.j0) {
            return false;
        }
        if (!this.isFocusable()) {
            return false;
        }
        if (!this.L()) {
            final boolean requestFocus = this.A.requestFocus(n, rect);
            if (requestFocus) {
                this.k0(false);
            }
            return requestFocus;
        }
        return super.requestFocus(n, rect);
    }
    
    public void setAppSearchData(final Bundle r0) {
        this.r0 = r0;
    }
    
    public void setIconified(final boolean b) {
        if (b) {
            this.R();
        }
        else {
            this.V();
        }
    }
    
    public void setIconifiedByDefault(final boolean d0) {
        if (this.d0 == d0) {
            return;
        }
        this.k0(this.d0 = d0);
        this.g0();
    }
    
    public void setImeOptions(final int imeOptions) {
        this.A.setImeOptions(imeOptions);
    }
    
    public void setInputType(final int inputType) {
        this.A.setInputType(inputType);
    }
    
    public void setMaxWidth(final int k0) {
        this.k0 = k0;
        this.requestLayout();
    }
    
    public void setOnCloseListener(final l w) {
        this.W = w;
    }
    
    public void setOnQueryTextFocusChangeListener(final View$OnFocusChangeListener a0) {
        this.a0 = a0;
    }
    
    public void setOnQueryTextListener(final m v) {
        this.V = v;
    }
    
    public void setOnSearchClickListener(final View$OnClickListener c0) {
        this.c0 = c0;
    }
    
    public void setOnSuggestionListener(final n b0) {
        this.b0 = b0;
    }
    
    public void setQueryHint(final CharSequence h0) {
        this.h0 = h0;
        this.g0();
    }
    
    public void setQueryRefinementEnabled(final boolean i0) {
        this.i0 = i0;
        final z.a f0 = this.f0;
        if (f0 instanceof l0) {
            final l0 l0 = (l0)f0;
            int n;
            if (i0) {
                n = 2;
            }
            else {
                n = 1;
            }
            l0.x(n);
        }
    }
    
    public void setSearchableInfo(final SearchableInfo q0) {
        this.q0 = q0;
        if (q0 != null) {
            this.h0();
            this.g0();
        }
        final boolean k = this.K();
        this.l0 = k;
        if (k) {
            this.A.setPrivateImeOptions("nm");
        }
        this.k0(this.L());
    }
    
    public void setSubmitButtonEnabled(final boolean g0) {
        this.g0 = g0;
        this.k0(this.L());
    }
    
    public void setSuggestionsAdapter(final z.a a) {
        this.f0 = a;
        this.A.setAdapter((ListAdapter)a);
    }
    
    static class SavedState extends AbsSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        boolean c;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel, null);
                }
                
                public SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
                
                public SavedState[] c(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                    return this.b(parcel, classLoader);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.c(n);
                }
            };
        }
        
        public SavedState(final Parcel parcel, final ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = (boolean)parcel.readValue((ClassLoader)null);
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("SearchView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" isIconified=");
            sb.append(this.c);
            sb.append("}");
            return sb.toString();
        }
        
        @Override
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeValue((Object)this.c);
        }
    }
    
    public static class SearchAutoComplete extends c
    {
        private int e;
        private SearchView f;
        private boolean g;
        final Runnable h;
        
        public SearchAutoComplete(final Context context, final AttributeSet set) {
            this(context, set, d.a.p);
        }
        
        public SearchAutoComplete(final Context context, final AttributeSet set, final int n) {
            super(context, set, n);
            this.h = new Runnable() {
                final SearchAutoComplete a;
                
                @Override
                public void run() {
                    this.a.d();
                }
            };
            this.e = this.getThreshold();
        }
        
        private int getSearchViewTextMinWidthDp() {
            final Configuration configuration = this.getResources().getConfiguration();
            final int screenWidthDp = configuration.screenWidthDp;
            final int screenHeightDp = configuration.screenHeightDp;
            if (screenWidthDp >= 960 && screenHeightDp >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (screenWidthDp < 600 && (screenWidthDp < 640 || screenHeightDp < 480)) {
                return 160;
            }
            return 192;
        }
        
        void b() {
            if (Build$VERSION.SDK_INT >= 29) {
                k.b(this, 1);
                if (this.enoughToFilter()) {
                    this.showDropDown();
                }
            }
            else {
                SearchView.B0.c(this);
            }
        }
        
        boolean c() {
            return TextUtils.getTrimmedLength((CharSequence)this.getText()) == 0;
        }
        
        void d() {
            if (this.g) {
                ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
                this.g = false;
            }
        }
        
        public boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }
        
        @Override
        public InputConnection onCreateInputConnection(final EditorInfo editorInfo) {
            final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.g) {
                this.removeCallbacks(this.h);
                this.post(this.h);
            }
            return onCreateInputConnection;
        }
        
        protected void onFinishInflate() {
            super.onFinishInflate();
            this.setMinWidth((int)TypedValue.applyDimension(1, (float)this.getSearchViewTextMinWidthDp(), this.getResources().getDisplayMetrics()));
        }
        
        protected void onFocusChanged(final boolean b, final int n, final Rect rect) {
            super.onFocusChanged(b, n, rect);
            this.f.Z();
        }
        
        public boolean onKeyPreIme(final int n, final KeyEvent keyEvent) {
            if (n == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    final KeyEvent$DispatcherState keyDispatcherState = this.getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, (Object)this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    final KeyEvent$DispatcherState keyDispatcherState2 = this.getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f.clearFocus();
                        this.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(n, keyEvent);
        }
        
        public void onWindowFocusChanged(final boolean b) {
            super.onWindowFocusChanged(b);
            if (b && this.f.hasFocus() && this.getVisibility() == 0) {
                this.g = true;
                if (SearchView.M(this.getContext())) {
                    this.b();
                }
            }
        }
        
        public void performCompletion() {
        }
        
        protected void replaceText(final CharSequence charSequence) {
        }
        
        void setImeVisibility(final boolean b) {
            final InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
            if (!b) {
                this.g = false;
                this.removeCallbacks(this.h);
                inputMethodManager.hideSoftInputFromWindow(this.getWindowToken(), 0);
                return;
            }
            if (inputMethodManager.isActive((View)this)) {
                this.g = false;
                this.removeCallbacks(this.h);
                inputMethodManager.showSoftInput((View)this, 0);
                return;
            }
            this.g = true;
        }
        
        void setSearchView(final SearchView f) {
            this.f = f;
        }
        
        public void setThreshold(final int n) {
            super.setThreshold(n);
            this.e = n;
        }
    }
    
    static class k
    {
        static void a(final AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }
        
        static void b(final SearchAutoComplete searchAutoComplete, final int inputMethodMode) {
            searchAutoComplete.setInputMethodMode(inputMethodMode);
        }
    }
    
    public interface l
    {
        boolean c();
    }
    
    public interface m
    {
        boolean onQueryTextChange(final String p0);
        
        boolean onQueryTextSubmit(final String p0);
    }
    
    public interface n
    {
        boolean a(final int p0);
        
        boolean b(final int p0);
    }
    
    private static class o
    {
        private Method a;
        private Method b;
        private Method c;
        
        o() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     4: aload_0        
            //     5: aconst_null    
            //     6: putfield        androidx/appcompat/widget/SearchView$o.a:Ljava/lang/reflect/Method;
            //     9: aload_0        
            //    10: aconst_null    
            //    11: putfield        androidx/appcompat/widget/SearchView$o.b:Ljava/lang/reflect/Method;
            //    14: aload_0        
            //    15: aconst_null    
            //    16: putfield        androidx/appcompat/widget/SearchView$o.c:Ljava/lang/reflect/Method;
            //    19: invokestatic    androidx/appcompat/widget/SearchView$o.d:()V
            //    22: ldc             Landroid/widget/AutoCompleteTextView;.class
            //    24: ldc             "doBeforeTextChanged"
            //    26: iconst_0       
            //    27: anewarray       Ljava/lang/Class;
            //    30: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
            //    33: astore_1       
            //    34: aload_0        
            //    35: aload_1        
            //    36: putfield        androidx/appcompat/widget/SearchView$o.a:Ljava/lang/reflect/Method;
            //    39: aload_1        
            //    40: iconst_1       
            //    41: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
            //    44: ldc             Landroid/widget/AutoCompleteTextView;.class
            //    46: ldc             "doAfterTextChanged"
            //    48: iconst_0       
            //    49: anewarray       Ljava/lang/Class;
            //    52: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
            //    55: astore_1       
            //    56: aload_0        
            //    57: aload_1        
            //    58: putfield        androidx/appcompat/widget/SearchView$o.b:Ljava/lang/reflect/Method;
            //    61: aload_1        
            //    62: iconst_1       
            //    63: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
            //    66: ldc             Landroid/widget/AutoCompleteTextView;.class
            //    68: ldc             "ensureImeVisible"
            //    70: iconst_1       
            //    71: anewarray       Ljava/lang/Class;
            //    74: dup            
            //    75: iconst_0       
            //    76: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
            //    79: aastore        
            //    80: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
            //    83: astore_1       
            //    84: aload_0        
            //    85: aload_1        
            //    86: putfield        androidx/appcompat/widget/SearchView$o.c:Ljava/lang/reflect/Method;
            //    89: aload_1        
            //    90: iconst_1       
            //    91: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
            //    94: return         
            //    95: astore_1       
            //    96: goto            44
            //    99: astore_1       
            //   100: goto            66
            //   103: astore_1       
            //   104: goto            94
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                             
            //  -----  -----  -----  -----  ---------------------------------
            //  22     44     95     99     Ljava/lang/NoSuchMethodException;
            //  44     66     99     103    Ljava/lang/NoSuchMethodException;
            //  66     94     103    107    Ljava/lang/NoSuchMethodException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index: 59, Size: 59
            //     at java.util.ArrayList.rangeCheck(Unknown Source)
            //     at java.util.ArrayList.get(Unknown Source)
            //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:799)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:635)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        private static void d() {
            if (Build$VERSION.SDK_INT < 29) {
                return;
            }
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
        
        void a(final AutoCompleteTextView autoCompleteTextView) {
            d();
            final Method b = this.b;
            if (b == null) {
                return;
            }
            try {
                b.invoke(autoCompleteTextView, new Object[0]);
            }
            catch (final Exception ex) {}
        }
        
        void b(final AutoCompleteTextView autoCompleteTextView) {
            d();
            final Method a = this.a;
            if (a == null) {
                return;
            }
            try {
                a.invoke(autoCompleteTextView, new Object[0]);
            }
            catch (final Exception ex) {}
        }
        
        void c(final AutoCompleteTextView autoCompleteTextView) {
            d();
            final Method c = this.c;
            if (c == null) {
                return;
            }
            try {
                c.invoke(autoCompleteTextView, Boolean.TRUE);
            }
            catch (final Exception ex) {}
        }
    }
    
    private static class p extends TouchDelegate
    {
        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;
        
        public p(final Rect rect, final Rect rect2, final View a) {
            super(rect, a);
            this.e = ViewConfiguration.get(a.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            this.a(rect, rect2);
            this.a = a;
        }
        
        public void a(Rect d, final Rect rect) {
            this.b.set(d);
            this.d.set(d);
            d = this.d;
            final int e = this.e;
            d.inset(-e, -e);
            this.c.set(rect);
        }
        
        public boolean onTouchEvent(final MotionEvent motionEvent) {
            final int n = (int)motionEvent.getX();
            final int n2 = (int)motionEvent.getY();
            final int action = motionEvent.getAction();
            int f = 1;
            final boolean b = false;
            boolean b2 = false;
            Label_0134: {
                Label_0129: {
                    if (action != 0) {
                        if (action != 1 && action != 2) {
                            if (action != 3) {
                                break Label_0129;
                            }
                            f = (this.f ? 1 : 0);
                            this.f = false;
                        }
                        else {
                            final boolean f2 = this.f;
                            if ((f = (f2 ? 1 : 0)) != 0) {
                                f = (f2 ? 1 : 0);
                                if (!this.d.contains(n, n2)) {
                                    f = (f2 ? 1 : 0);
                                    b2 = false;
                                    break Label_0134;
                                }
                            }
                        }
                        b2 = true;
                        break Label_0134;
                    }
                    if (this.b.contains(n, n2)) {
                        this.f = true;
                        b2 = true;
                        break Label_0134;
                    }
                }
                b2 = true;
                f = 0;
            }
            boolean dispatchTouchEvent = b;
            if (f != 0) {
                if (b2 && !this.c.contains(n, n2)) {
                    motionEvent.setLocation((float)(this.a.getWidth() / 2), (float)(this.a.getHeight() / 2));
                }
                else {
                    final Rect c = this.c;
                    motionEvent.setLocation((float)(n - c.left), (float)(n2 - c.top));
                }
                dispatchTouchEvent = this.a.dispatchTouchEvent(motionEvent);
            }
            return dispatchTouchEvent;
        }
    }
}
