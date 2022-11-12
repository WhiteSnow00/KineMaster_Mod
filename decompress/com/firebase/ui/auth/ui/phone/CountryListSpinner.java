// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import android.widget.ListView;
import android.widget.ListAdapter;
import android.app.AlertDialog$Builder;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.DialogInterface$OnClickListener;
import android.text.TextUtils;
import android.os.Parcelable;
import android.view.inputmethod.InputMethodManager;
import java.util.Map;
import java.util.Collections;
import java.util.Locale;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.Collection;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import java.util.List;
import java.util.HashSet;
import android.util.AttributeSet;
import android.content.Context;
import com.firebase.ui.auth.data.model.CountryInfo;
import java.util.Set;
import android.view.View$OnClickListener;
import androidx.appcompat.widget.AppCompatEditText;

public final class CountryListSpinner extends AppCompatEditText implements View$OnClickListener
{
    private static final String KEY_COUNTRY_INFO = "KEY_COUNTRY_INFO";
    private static final String KEY_SUPER_STATE = "KEY_SUPER_STATE";
    private Set<String> mAllowedCountryIsos;
    private Set<String> mBlockedCountryIsos;
    private final CountryListAdapter mCountryListAdapter;
    private final DialogPopup mDialogPopup;
    private View$OnClickListener mListener;
    private CountryInfo mSelectedCountryInfo;
    private String mSelectedCountryName;
    private final String mTextFormat;
    
    public CountryListSpinner(final Context context) {
        this(context, null, 16842881);
    }
    
    public CountryListSpinner(final Context context, final AttributeSet set) {
        this(context, set, 16842881);
    }
    
    public CountryListSpinner(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mAllowedCountryIsos = new HashSet<String>();
        this.mBlockedCountryIsos = new HashSet<String>();
        super.setOnClickListener((View$OnClickListener)this);
        final CountryListAdapter mCountryListAdapter = new CountryListAdapter(this.getContext());
        this.mCountryListAdapter = mCountryListAdapter;
        this.mDialogPopup = new DialogPopup(mCountryListAdapter);
        this.mTextFormat = "%1$s  +%2$d";
        this.mSelectedCountryName = "";
    }
    
    static String access$002(final CountryListSpinner countryListSpinner, final String mSelectedCountryName) {
        return countryListSpinner.mSelectedCountryName = mSelectedCountryName;
    }
    
    private Set<String> convertCodesToIsos(final List<String> list) {
        final HashSet set = new HashSet();
        for (final String s : list) {
            if (PhoneNumberUtils.isValid(s)) {
                set.addAll(PhoneNumberUtils.getCountryIsosFromCountryCode(s));
            }
            else {
                set.add(s);
            }
        }
        return set;
    }
    
    private void executeUserClickListener(final View view) {
        final View$OnClickListener mListener = this.mListener;
        if (mListener != null) {
            mListener.onClick(view);
        }
    }
    
    private List<CountryInfo> getCountriesToDisplayInSpinner(final Bundle bundle) {
        this.initCountrySpinnerIsosFromParams(bundle);
        final Map<String, Integer> immutableCountryIsoMap = PhoneNumberUtils.getImmutableCountryIsoMap();
        if (this.mAllowedCountryIsos.isEmpty() && this.mBlockedCountryIsos.isEmpty()) {
            this.mAllowedCountryIsos = new HashSet<String>(immutableCountryIsoMap.keySet());
        }
        final ArrayList list = new ArrayList();
        final HashSet set = new HashSet();
        if (!this.mBlockedCountryIsos.isEmpty()) {
            set.addAll(this.mBlockedCountryIsos);
        }
        else {
            set.addAll(immutableCountryIsoMap.keySet());
            set.removeAll(this.mAllowedCountryIsos);
        }
        for (final String s : immutableCountryIsoMap.keySet()) {
            if (!set.contains(s)) {
                list.add(new CountryInfo(new Locale("", s), immutableCountryIsoMap.get(s)));
            }
        }
        Collections.sort((List<Comparable>)list);
        return list;
    }
    
    private static void hideKeyboard(final Context context, final View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    
    private void initCountrySpinnerIsosFromParams(final Bundle bundle) {
        final ArrayList stringArrayList = bundle.getStringArrayList("allowlisted_countries");
        final ArrayList stringArrayList2 = bundle.getStringArrayList("blocklisted_countries");
        if (stringArrayList != null) {
            this.mAllowedCountryIsos = this.convertCodesToIsos(stringArrayList);
        }
        if (stringArrayList2 != null) {
            this.mBlockedCountryIsos = this.convertCodesToIsos(stringArrayList2);
        }
    }
    
    private void setDefaultCountryForSpinner(final List<CountryInfo> list) {
        final CountryInfo currentCountryInfo = PhoneNumberUtils.getCurrentCountryInfo(this.getContext());
        if (this.isValidIso(currentCountryInfo.getLocale().getCountry())) {
            this.setSelectedForCountry(currentCountryInfo.getCountryCode(), currentCountryInfo.getLocale());
        }
        else if (list.iterator().hasNext()) {
            final CountryInfo countryInfo = list.iterator().next();
            this.setSelectedForCountry(countryInfo.getCountryCode(), countryInfo.getLocale());
        }
    }
    
    public CountryInfo getSelectedCountryInfo() {
        return this.mSelectedCountryInfo;
    }
    
    public void init(final Bundle bundle) {
        if (bundle != null) {
            final List<CountryInfo> countriesToDisplayInSpinner = this.getCountriesToDisplayInSpinner(bundle);
            this.setCountriesToDisplay(countriesToDisplayInSpinner);
            this.setDefaultCountryForSpinner(countriesToDisplayInSpinner);
        }
    }
    
    public boolean isValidIso(String upperCase) {
        upperCase = upperCase.toUpperCase(Locale.getDefault());
        final boolean empty = this.mAllowedCountryIsos.isEmpty();
        final boolean b = false;
        boolean b2 = empty || this.mAllowedCountryIsos.contains(upperCase);
        if (!this.mBlockedCountryIsos.isEmpty()) {
            b2 = b;
            if (b2) {
                b2 = b;
                if (!this.mBlockedCountryIsos.contains(upperCase)) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public void onClick(final View view) {
        this.mDialogPopup.show(this.mCountryListAdapter.getPositionForCountry(this.mSelectedCountryName));
        hideKeyboard(this.getContext(), (View)this);
        this.executeUserClickListener(view);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mDialogPopup.isShowing()) {
            this.mDialogPopup.dismiss();
        }
    }
    
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final Bundle bundle = (Bundle)parcelable;
        parcelable = bundle.getParcelable("KEY_SUPER_STATE");
        this.mSelectedCountryInfo = (CountryInfo)bundle.getParcelable("KEY_COUNTRY_INFO");
        super.onRestoreInstanceState(parcelable);
    }
    
    public Parcelable onSaveInstanceState() {
        final Parcelable onSaveInstanceState = super.onSaveInstanceState();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SUPER_STATE", onSaveInstanceState);
        bundle.putParcelable("KEY_COUNTRY_INFO", (Parcelable)this.mSelectedCountryInfo);
        return (Parcelable)bundle;
    }
    
    public void setCountriesToDisplay(final List<CountryInfo> data) {
        this.mCountryListAdapter.setData(data);
    }
    
    public void setOnClickListener(final View$OnClickListener mListener) {
        this.mListener = mListener;
    }
    
    public void setSelectedForCountry(final int n, final Locale locale) {
        this.setText((CharSequence)String.format(this.mTextFormat, CountryInfo.localeToEmoji(locale), n));
        this.mSelectedCountryInfo = new CountryInfo(locale, n);
    }
    
    public void setSelectedForCountry(final Locale locale, final String s) {
        if (this.isValidIso(locale.getCountry())) {
            final String displayName = locale.getDisplayName();
            if (!TextUtils.isEmpty((CharSequence)displayName) && !TextUtils.isEmpty((CharSequence)s)) {
                this.mSelectedCountryName = displayName;
                this.setSelectedForCountry(Integer.parseInt(s), locale);
            }
        }
    }
    
    public class DialogPopup implements DialogInterface$OnClickListener
    {
        private static final long DELAY_MILLIS = 10L;
        private AlertDialog dialog;
        private final CountryListAdapter listAdapter;
        final CountryListSpinner this$0;
        
        DialogPopup(final CountryListSpinner this$0, final CountryListAdapter listAdapter) {
            this.this$0 = this$0;
            this.listAdapter = listAdapter;
        }
        
        public void dismiss() {
            final AlertDialog dialog = this.dialog;
            if (dialog != null) {
                dialog.dismiss();
                this.dialog = null;
            }
        }
        
        public boolean isShowing() {
            final AlertDialog dialog = this.dialog;
            return dialog != null && dialog.isShowing();
        }
        
        public void onClick(final DialogInterface dialogInterface, final int n) {
            final CountryInfo countryInfo = (CountryInfo)this.listAdapter.getItem(n);
            CountryListSpinner.access$002(this.this$0, countryInfo.getLocale().getDisplayCountry());
            this.this$0.setSelectedForCountry(countryInfo.getCountryCode(), countryInfo.getLocale());
            this.dismiss();
        }
        
        public void show(final int n) {
            if (this.listAdapter == null) {
                return;
            }
            (this.dialog = new AlertDialog$Builder(this.this$0.getContext()).setSingleChoiceItems((ListAdapter)this.listAdapter, 0, (DialogInterface$OnClickListener)this).create()).setCanceledOnTouchOutside(true);
            final ListView listView = this.dialog.getListView();
            listView.setFastScrollEnabled(true);
            listView.setScrollbarFadingEnabled(false);
            listView.postDelayed((Runnable)new Runnable(this, listView, n) {
                final DialogPopup this$1;
                final ListView val$listView;
                final int val$selected;
                
                @Override
                public void run() {
                    this.val$listView.setSelection(this.val$selected);
                }
            }, 10L);
            this.dialog.show();
        }
    }
}
