// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import com.google.firebase.database.snapshot.Node;

public class Transaction
{
    public static Result a() {
        return new Result(false, null, null);
    }
    
    public interface Handler
    {
        Result a(final MutableData p0);
        
        void b(final DatabaseError p0, final boolean p1, final DataSnapshot p2);
    }
    
    public static class Result
    {
        private boolean a;
        private Node b;
        
        private Result(final boolean a, final Node b) {
            this.a = a;
            this.b = b;
        }
        
        Result(final boolean b, final Node node, final Transaction$a object) {
            this(b, node);
        }
        
        public Node a() {
            return this.b;
        }
        
        public boolean b() {
            return this.a;
        }
    }
}
