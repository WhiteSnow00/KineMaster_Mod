// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import java.io.IOException;
import com.google.firebase.database.util.JsonMapper;
import java.util.HashMap;
import com.google.firebase.database.core.view.filter.RangedFilter;
import com.google.firebase.database.core.view.filter.LimitedFilter;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.LongNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.Map;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;

public final class QueryParams
{
    public static final QueryParams i;
    private Integer a;
    private ViewFrom b;
    private Node c;
    private ChildKey d;
    private Node e;
    private ChildKey f;
    private Index g;
    private String h;
    
    static {
        i = new QueryParams();
    }
    
    public QueryParams() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = PriorityIndex.j();
        this.h = null;
    }
    
    public static QueryParams a(final Map<String, Object> map) {
        final QueryParams queryParams = new QueryParams();
        queryParams.a = map.get("l");
        if (map.containsKey("sp")) {
            queryParams.c = p(NodeUtilities.a(map.get("sp")));
            final String s = (String)map.get("sn");
            if (s != null) {
                queryParams.d = ChildKey.f(s);
            }
        }
        if (map.containsKey("ep")) {
            queryParams.e = p(NodeUtilities.a(map.get("ep")));
            final String s2 = (String)map.get("en");
            if (s2 != null) {
                queryParams.f = ChildKey.f(s2);
            }
        }
        final String s3 = (String)map.get("vf");
        if (s3 != null) {
            ViewFrom b;
            if (s3.equals("l")) {
                b = ViewFrom.LEFT;
            }
            else {
                b = ViewFrom.RIGHT;
            }
            queryParams.b = b;
        }
        final String s4 = (String)map.get("i");
        if (s4 != null) {
            queryParams.g = Index.b(s4);
        }
        return queryParams;
    }
    
    private static Node p(final Node node) {
        if (node instanceof StringNode || node instanceof BooleanNode || node instanceof DoubleNode || node instanceof EmptyNode) {
            return node;
        }
        if (node instanceof LongNode) {
            return new DoubleNode((double)node.getValue(), PriorityUtilities.a());
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected value passed to normalizeValue: ");
        sb.append(node.getValue());
        throw new IllegalStateException(sb.toString());
    }
    
    public Index b() {
        return this.g;
    }
    
    public ChildKey c() {
        if (!this.j()) {
            throw new IllegalArgumentException("Cannot get index end name if start has not been set");
        }
        final ChildKey f = this.f;
        if (f != null) {
            return f;
        }
        return ChildKey.g();
    }
    
    public Node d() {
        if (this.j()) {
            return this.e;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }
    
    public ChildKey e() {
        if (!this.l()) {
            throw new IllegalArgumentException("Cannot get index start name if start has not been set");
        }
        final ChildKey d = this.d;
        if (d != null) {
            return d;
        }
        return ChildKey.h();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && QueryParams.class == o.getClass()) {
            final QueryParams queryParams = (QueryParams)o;
            final Integer a = this.a;
            Label_0060: {
                if (a != null) {
                    if (a.equals(queryParams.a)) {
                        break Label_0060;
                    }
                }
                else if (queryParams.a == null) {
                    break Label_0060;
                }
                return false;
            }
            final Index g = this.g;
            Label_0092: {
                if (g != null) {
                    if (g.equals(queryParams.g)) {
                        break Label_0092;
                    }
                }
                else if (queryParams.g == null) {
                    break Label_0092;
                }
                return false;
            }
            final ChildKey f = this.f;
            Label_0124: {
                if (f != null) {
                    if (f.equals(queryParams.f)) {
                        break Label_0124;
                    }
                }
                else if (queryParams.f == null) {
                    break Label_0124;
                }
                return false;
            }
            final Node e = this.e;
            Label_0156: {
                if (e != null) {
                    if (e.equals(queryParams.e)) {
                        break Label_0156;
                    }
                }
                else if (queryParams.e == null) {
                    break Label_0156;
                }
                return false;
            }
            final ChildKey d = this.d;
            Label_0188: {
                if (d != null) {
                    if (d.equals(queryParams.d)) {
                        break Label_0188;
                    }
                }
                else if (queryParams.d == null) {
                    break Label_0188;
                }
                return false;
            }
            final Node c = this.c;
            if (c != null) {
                if (c.equals(queryParams.c)) {
                    return this.n() == queryParams.n();
                }
            }
            else if (queryParams.c == null) {
                return this.n() == queryParams.n();
            }
            return false;
        }
        return false;
    }
    
    public Node f() {
        if (this.l()) {
            return this.c;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }
    
    public int g() {
        if (this.k()) {
            return this.a;
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }
    
    public NodeFilter h() {
        if (this.o()) {
            return new IndexedFilter(this.b());
        }
        if (this.k()) {
            return new LimitedFilter(this);
        }
        return new RangedFilter(this);
    }
    
    @Override
    public int hashCode() {
        final Integer a = this.a;
        int hashCode = 0;
        int intValue;
        if (a != null) {
            intValue = a;
        }
        else {
            intValue = 0;
        }
        int n;
        if (this.n()) {
            n = 1231;
        }
        else {
            n = 1237;
        }
        final Node c = this.c;
        int hashCode2;
        if (c != null) {
            hashCode2 = c.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final ChildKey d = this.d;
        int hashCode3;
        if (d != null) {
            hashCode3 = d.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final Node e = this.e;
        int hashCode4;
        if (e != null) {
            hashCode4 = e.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final ChildKey f = this.f;
        int hashCode5;
        if (f != null) {
            hashCode5 = f.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final Index g = this.g;
        if (g != null) {
            hashCode = g.hashCode();
        }
        return (((((intValue * 31 + n) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    public Map<String, Object> i() {
        final HashMap hashMap = new HashMap();
        if (this.l()) {
            hashMap.put("sp", this.c.getValue());
            final ChildKey d = this.d;
            if (d != null) {
                hashMap.put("sn", d.c());
            }
        }
        if (this.j()) {
            hashMap.put("ep", this.e.getValue());
            final ChildKey f = this.f;
            if (f != null) {
                hashMap.put("en", f.c());
            }
        }
        final Integer a = this.a;
        if (a != null) {
            hashMap.put("l", a);
            ViewFrom viewFrom;
            if ((viewFrom = this.b) == null) {
                if (this.l()) {
                    viewFrom = ViewFrom.LEFT;
                }
                else {
                    viewFrom = ViewFrom.RIGHT;
                }
            }
            final int n = QueryParams$a.a[viewFrom.ordinal()];
            if (n != 1) {
                if (n == 2) {
                    hashMap.put("vf", "r");
                }
            }
            else {
                hashMap.put("vf", "l");
            }
        }
        if (!this.g.equals(PriorityIndex.j())) {
            hashMap.put("i", this.g.c());
        }
        return hashMap;
    }
    
    public boolean j() {
        return this.e != null;
    }
    
    public boolean k() {
        return this.a != null;
    }
    
    public boolean l() {
        return this.c != null;
    }
    
    public boolean m() {
        return this.o() && this.g.equals(PriorityIndex.j());
    }
    
    public boolean n() {
        final ViewFrom b = this.b;
        boolean l;
        if (b != null) {
            l = (b == ViewFrom.LEFT);
        }
        else {
            l = this.l();
        }
        return l;
    }
    
    public boolean o() {
        return !this.l() && !this.j() && !this.k();
    }
    
    public String q() {
        if (this.h == null) {
            try {
                this.h = JsonMapper.c(this.i());
            }
            catch (final IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return this.h;
    }
    
    @Override
    public String toString() {
        return this.i().toString();
    }
    
    private enum ViewFrom
    {
        private static final ViewFrom[] $VALUES;
        
        LEFT, 
        RIGHT;
    }
}
