// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import java.util.Iterator;
import java.util.Locale;
import java.util.List;
import java.util.LinkedHashMap;
import com.firebase.ui.auth.R;
import android.content.Context;
import java.util.HashMap;
import android.widget.SectionIndexer;
import com.firebase.ui.auth.data.model.CountryInfo;
import android.widget.ArrayAdapter;

final class CountryListAdapter extends ArrayAdapter<CountryInfo> implements SectionIndexer
{
    private final HashMap<String, Integer> alphaIndex;
    private final HashMap<String, Integer> countryPosition;
    private String[] sections;
    
    public CountryListAdapter(final Context context) {
        super(context, R.layout.fui_dgts_country_row, 16908308);
        this.alphaIndex = new LinkedHashMap<String, Integer>();
        this.countryPosition = new LinkedHashMap<String, Integer>();
    }
    
    public int getCount() {
        return this.countryPosition.size();
    }
    
    public int getPositionForCountry(final String s) {
        final Integer n = this.countryPosition.get(s);
        int intValue;
        if (n == null) {
            intValue = 0;
        }
        else {
            intValue = n;
        }
        return intValue;
    }
    
    public int getPositionForSection(final int n) {
        final String[] sections = this.sections;
        if (sections == null) {
            return 0;
        }
        if (n <= 0) {
            return 0;
        }
        int n2;
        if ((n2 = n) >= sections.length) {
            n2 = sections.length - 1;
        }
        return this.alphaIndex.get(sections[n2]);
    }
    
    public int getSectionForPosition(final int n) {
        if (this.sections == null) {
            return 0;
        }
        for (int i = 0; i < this.sections.length; ++i) {
            if (this.getPositionForSection(i) > n) {
                return i - 1;
            }
        }
        return 0;
    }
    
    public Object[] getSections() {
        return this.sections;
    }
    
    public void setData(final List<CountryInfo> list) {
        final Iterator<CountryInfo> iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final CountryInfo countryInfo = iterator.next();
            final String upperCase = countryInfo.getLocale().getDisplayCountry().substring(0, 1).toUpperCase(Locale.getDefault());
            if (!this.alphaIndex.containsKey(upperCase)) {
                this.alphaIndex.put(upperCase, n);
            }
            this.countryPosition.put(countryInfo.getLocale().getDisplayCountry(), n);
            ++n;
            this.add((Object)countryInfo);
        }
        this.sections = new String[this.alphaIndex.size()];
        this.alphaIndex.keySet().toArray(this.sections);
        this.notifyDataSetChanged();
    }
}
