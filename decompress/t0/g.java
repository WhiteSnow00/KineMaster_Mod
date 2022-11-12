// 
// Decompiled by Procyon v0.6.0
// 

package t0;

import androidx.room.Index$Order;
import java.util.Locale;
import java.util.Collection;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;
import java.util.HashMap;
import java.util.Collections;
import java.util.Set;
import java.util.Map;

public final class g
{
    public final String a;
    public final Map<String, a> b;
    public final Set<b> c;
    public final Set<d> d;
    
    public g(final String a, final Map<String, a> map, final Set<b> set, final Set<d> set2) {
        this.a = a;
        this.b = Collections.unmodifiableMap((Map<? extends String, ? extends a>)map);
        this.c = Collections.unmodifiableSet((Set<? extends b>)set);
        Set<d> unmodifiableSet;
        if (set2 == null) {
            unmodifiableSet = null;
        }
        else {
            unmodifiableSet = Collections.unmodifiableSet((Set<? extends d>)set2);
        }
        this.d = unmodifiableSet;
    }
    
    public static g a(final v0.g g, final String s) {
        return new g(s, b(g, s), d(g, s), f(g, s));
    }
    
    private static Map<String, a> b(v0.g z0, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA table_info(`");
        sb.append(s);
        sb.append("`)");
        z0 = (v0.g)z0.Z0(sb.toString());
        final HashMap hashMap = new HashMap();
        try {
            if (((Cursor)z0).getColumnCount() > 0) {
                final int columnIndex = ((Cursor)z0).getColumnIndex("name");
                final int columnIndex2 = ((Cursor)z0).getColumnIndex("type");
                final int columnIndex3 = ((Cursor)z0).getColumnIndex("notnull");
                final int columnIndex4 = ((Cursor)z0).getColumnIndex("pk");
                final int columnIndex5 = ((Cursor)z0).getColumnIndex("dflt_value");
                while (((Cursor)z0).moveToNext()) {
                    final String string = ((Cursor)z0).getString(columnIndex);
                    hashMap.put(string, new a(string, ((Cursor)z0).getString(columnIndex2), ((Cursor)z0).getInt(columnIndex3) != 0, ((Cursor)z0).getInt(columnIndex4), ((Cursor)z0).getString(columnIndex5), 2));
                }
            }
            return hashMap;
        }
        finally {
            ((Cursor)z0).close();
        }
    }
    
    private static List<c> c(final Cursor cursor) {
        final int columnIndex = cursor.getColumnIndex("id");
        final int columnIndex2 = cursor.getColumnIndex("seq");
        final int columnIndex3 = cursor.getColumnIndex("from");
        final int columnIndex4 = cursor.getColumnIndex("to");
        final int count = cursor.getCount();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < count; ++i) {
            cursor.moveToPosition(i);
            list.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort((List<Comparable>)list);
        return list;
    }
    
    private static Set<b> d(v0.g z0, final String s) {
        final HashSet set = new HashSet();
        final StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA foreign_key_list(`");
        sb.append(s);
        sb.append("`)");
        z0 = (v0.g)z0.Z0(sb.toString());
        try {
            final int columnIndex = ((Cursor)z0).getColumnIndex("id");
            final int columnIndex2 = ((Cursor)z0).getColumnIndex("seq");
            final int columnIndex3 = ((Cursor)z0).getColumnIndex("table");
            final int columnIndex4 = ((Cursor)z0).getColumnIndex("on_delete");
            final int columnIndex5 = ((Cursor)z0).getColumnIndex("on_update");
            final List<c> c = c((Cursor)z0);
            for (int count = ((Cursor)z0).getCount(), i = 0; i < count; ++i) {
                ((Cursor)z0).moveToPosition(i);
                if (((Cursor)z0).getInt(columnIndex2) == 0) {
                    final int int1 = ((Cursor)z0).getInt(columnIndex);
                    final ArrayList list = new ArrayList();
                    final ArrayList<String> list2 = new ArrayList<String>();
                    for (final c c2 : c) {
                        if (c2.a == int1) {
                            list.add(c2.c);
                            list2.add(c2.d);
                        }
                    }
                    set.add(new b(((Cursor)z0).getString(columnIndex3), ((Cursor)z0).getString(columnIndex4), ((Cursor)z0).getString(columnIndex5), list, list2));
                }
            }
            return set;
        }
        finally {
            ((Cursor)z0).close();
        }
    }
    
    private static d e(final v0.g g, final String s, final boolean b) {
        final StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA index_xinfo(`");
        sb.append(s);
        sb.append("`)");
        final Cursor z0 = g.Z0(sb.toString());
        try {
            final int columnIndex = z0.getColumnIndex("seqno");
            final int columnIndex2 = z0.getColumnIndex("cid");
            final int columnIndex3 = z0.getColumnIndex("name");
            final int columnIndex4 = z0.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                final TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
                final TreeMap treeMap2 = new TreeMap();
                while (z0.moveToNext()) {
                    if (z0.getInt(columnIndex2) < 0) {
                        continue;
                    }
                    final int int1 = z0.getInt(columnIndex);
                    final String string = z0.getString(columnIndex3);
                    String s2;
                    if (z0.getInt(columnIndex4) > 0) {
                        s2 = "DESC";
                    }
                    else {
                        s2 = "ASC";
                    }
                    treeMap.put(int1, string);
                    treeMap2.put(int1, s2);
                }
                final ArrayList list = new ArrayList(treeMap.size());
                list.addAll((Collection)treeMap.values());
                final ArrayList list2 = new ArrayList<String>(treeMap2.size());
                list2.addAll((Collection<?>)treeMap2.values());
                return new d(s, b, (List<String>)list, (List<String>)list2);
            }
            return null;
        }
        finally {
            z0.close();
        }
    }
    
    private static Set<d> f(final v0.g g, String z0) {
        final StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA index_list(`");
        sb.append(z0);
        sb.append("`)");
        z0 = (String)g.Z0(sb.toString());
        try {
            final int columnIndex = ((Cursor)z0).getColumnIndex("name");
            final int columnIndex2 = ((Cursor)z0).getColumnIndex("origin");
            final int columnIndex3 = ((Cursor)z0).getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                final HashSet<d> set = new HashSet<d>();
                while (((Cursor)z0).moveToNext()) {
                    if (!"c".equals(((Cursor)z0).getString(columnIndex2))) {
                        continue;
                    }
                    final String string = ((Cursor)z0).getString(columnIndex);
                    final int int1 = ((Cursor)z0).getInt(columnIndex3);
                    boolean b = true;
                    if (int1 != 1) {
                        b = false;
                    }
                    final d e = e(g, string, b);
                    if (e == null) {
                        return null;
                    }
                    set.add(e);
                }
                return set;
            }
            return null;
        }
        finally {
            ((Cursor)z0).close();
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof g)) {
            return false;
        }
        final g g = (g)o;
        final String a = this.a;
        Label_0053: {
            if (a != null) {
                if (a.equals(g.a)) {
                    break Label_0053;
                }
            }
            else if (g.a == null) {
                break Label_0053;
            }
            return false;
        }
        final Map<String, a> b = this.b;
        Label_0087: {
            if (b != null) {
                if (b.equals(g.b)) {
                    break Label_0087;
                }
            }
            else if (g.b == null) {
                break Label_0087;
            }
            return false;
        }
        final Set<b> c = this.c;
        Label_0121: {
            if (c != null) {
                if (c.equals(g.c)) {
                    break Label_0121;
                }
            }
            else if (g.c == null) {
                break Label_0121;
            }
            return false;
        }
        final Set<d> d = this.d;
        if (d != null) {
            final Set<d> d2 = g.d;
            if (d2 != null) {
                return d.equals(d2);
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final String a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a != null) {
            hashCode2 = a.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final Map<String, a> b = this.b;
        int hashCode3;
        if (b != null) {
            hashCode3 = b.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final Set<b> c = this.c;
        if (c != null) {
            hashCode = c.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TableInfo{name='");
        sb.append(this.a);
        sb.append('\'');
        sb.append(", columns=");
        sb.append(this.b);
        sb.append(", foreignKeys=");
        sb.append(this.c);
        sb.append(", indices=");
        sb.append(this.d);
        sb.append('}');
        return sb.toString();
    }
    
    public static final class a
    {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        private final int g;
        
        public a(final String a, final String b, final boolean d, final int e, final String f, final int g) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.e = e;
            this.c = c(b);
            this.f = f;
            this.g = g;
        }
        
        private static boolean a(final String s) {
            final int length = s.length();
            boolean b = false;
            if (length == 0) {
                return false;
            }
            int i = 0;
            int n = 0;
            while (i < s.length()) {
                final char char1 = s.charAt(i);
                if (i == 0 && char1 != '(') {
                    return false;
                }
                int n2;
                if (char1 == '(') {
                    n2 = n + 1;
                }
                else {
                    n2 = n;
                    if (char1 == ')') {
                        n2 = --n;
                        if (n == 0) {
                            n2 = n;
                            if (i != s.length() - 1) {
                                return false;
                            }
                        }
                    }
                }
                ++i;
                n = n2;
            }
            if (n == 0) {
                b = true;
            }
            return b;
        }
        
        public static boolean b(final String s, final String s2) {
            return s2 != null && (s.equals(s2) || (a(s) && s.substring(1, s.length() - 1).trim().equals(s2)));
        }
        
        private static int c(String upperCase) {
            if (upperCase == null) {
                return 5;
            }
            upperCase = upperCase.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            if (!upperCase.contains("REAL") && !upperCase.contains("FLOA") && !upperCase.contains("DOUB")) {
                return 1;
            }
            return 4;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            final a a = (a)o;
            if (this.e != a.e) {
                return false;
            }
            if (!this.a.equals(a.a)) {
                return false;
            }
            if (this.d != a.d) {
                return false;
            }
            if (this.g == 1 && a.g == 2) {
                final String f = this.f;
                if (f != null && !b(f, a.f)) {
                    return false;
                }
            }
            if (this.g == 2 && a.g == 1) {
                final String f2 = a.f;
                if (f2 != null && !b(f2, this.f)) {
                    return false;
                }
            }
            final int g = this.g;
            Label_0199: {
                if (g != 0 && g == a.g) {
                    final String f3 = this.f;
                    if (f3 != null) {
                        if (b(f3, a.f)) {
                            break Label_0199;
                        }
                    }
                    else if (a.f == null) {
                        break Label_0199;
                    }
                    return false;
                }
            }
            if (this.c != a.c) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final int c = this.c;
            int n;
            if (this.d) {
                n = 1231;
            }
            else {
                n = 1237;
            }
            return ((hashCode * 31 + c) * 31 + n) * 31 + this.e;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.a);
            sb.append('\'');
            sb.append(", type='");
            sb.append(this.b);
            sb.append('\'');
            sb.append(", affinity='");
            sb.append(this.c);
            sb.append('\'');
            sb.append(", notNull=");
            sb.append(this.d);
            sb.append(", primaryKeyPosition=");
            sb.append(this.e);
            sb.append(", defaultValue='");
            sb.append(this.f);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    
    public static final class b
    {
        public final String a;
        public final String b;
        public final String c;
        public final List<String> d;
        public final List<String> e;
        
        public b(final String a, final String b, final String c, final List<String> list, final List<String> list2) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = Collections.unmodifiableList((List<? extends String>)list);
            this.e = Collections.unmodifiableList((List<? extends String>)list2);
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            final b b = (b)o;
            return this.a.equals(b.a) && this.b.equals(b.b) && this.c.equals(b.c) && this.d.equals(b.d) && this.e.equals(b.e);
        }
        
        @Override
        public int hashCode() {
            return (((this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode()) * 31 + this.e.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("ForeignKey{referenceTable='");
            sb.append(this.a);
            sb.append('\'');
            sb.append(", onDelete='");
            sb.append(this.b);
            sb.append('\'');
            sb.append(", onUpdate='");
            sb.append(this.c);
            sb.append('\'');
            sb.append(", columnNames=");
            sb.append(this.d);
            sb.append(", referenceColumnNames=");
            sb.append(this.e);
            sb.append('}');
            return sb.toString();
        }
    }
    
    static class c implements Comparable<c>
    {
        final int a;
        final int b;
        final String c;
        final String d;
        
        c(final int a, final int b, final String c, final String d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public int a(final c c) {
            int n;
            if ((n = this.a - c.a) == 0) {
                n = this.b - c.b;
            }
            return n;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((c)o);
        }
    }
    
    public static final class d
    {
        public final String a;
        public final boolean b;
        public final List<String> c;
        public final List<String> d;
        
        public d(final String s, final boolean b, final List<String> list) {
            this(s, b, list, null);
        }
        
        public d(final String a, final boolean b, final List<String> c, final List<String> list) {
            this.a = a;
            this.b = b;
            this.c = c;
            List<String> nCopies = null;
            Label_0053: {
                if (list != null) {
                    nCopies = list;
                    if (list.size() != 0) {
                        break Label_0053;
                    }
                }
                nCopies = Collections.nCopies(c.size(), Index$Order.ASC.name());
            }
            this.d = nCopies;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof d)) {
                return false;
            }
            final d d = (d)o;
            if (this.b != d.b) {
                return false;
            }
            if (!this.c.equals(d.c)) {
                return false;
            }
            if (!this.d.equals(d.d)) {
                return false;
            }
            if (this.a.startsWith("index_")) {
                return d.a.startsWith("index_");
            }
            return this.a.equals(d.a);
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            if (this.a.startsWith("index_")) {
                hashCode = -1184239155;
            }
            else {
                hashCode = this.a.hashCode();
            }
            return ((hashCode * 31 + (this.b ? 1 : 0)) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Index{name='");
            sb.append(this.a);
            sb.append('\'');
            sb.append(", unique=");
            sb.append(this.b);
            sb.append(", columns=");
            sb.append(this.c);
            sb.append(", orders=");
            sb.append(this.d);
            sb.append('}');
            return sb.toString();
        }
    }
}
