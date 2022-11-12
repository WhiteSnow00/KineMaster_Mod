// 
// Decompiled by Procyon v0.6.0
// 

package z;

import android.widget.Filter$FilterResults;
import android.database.Cursor;
import android.widget.Filter;

class b extends Filter
{
    a a;
    
    b(final a a) {
        this.a = a;
    }
    
    public CharSequence convertResultToString(final Object o) {
        return this.a.b((Cursor)o);
    }
    
    protected Filter$FilterResults performFiltering(final CharSequence charSequence) {
        final Cursor c = this.a.c(charSequence);
        final Filter$FilterResults filter$FilterResults = new Filter$FilterResults();
        if (c != null) {
            filter$FilterResults.count = c.getCount();
            filter$FilterResults.values = c;
        }
        else {
            filter$FilterResults.count = 0;
            filter$FilterResults.values = null;
        }
        return filter$FilterResults;
    }
    
    protected void publishResults(final CharSequence charSequence, final Filter$FilterResults filter$FilterResults) {
        final Cursor d = this.a.d();
        final Object values = filter$FilterResults.values;
        if (values != null && values != d) {
            this.a.a((Cursor)values);
        }
    }
    
    interface a
    {
        void a(final Cursor p0);
        
        CharSequence b(final Cursor p0);
        
        Cursor c(final CharSequence p0);
        
        Cursor d();
    }
}
