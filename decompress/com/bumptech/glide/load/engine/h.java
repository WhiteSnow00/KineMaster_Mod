// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.DataSource;

public abstract class h
{
    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    
    static {
        a = new h() {
            @Override
            public boolean a() {
                return true;
            }
            
            @Override
            public boolean b() {
                return true;
            }
            
            @Override
            public boolean c(final DataSource dataSource) {
                return dataSource == DataSource.REMOTE;
            }
            
            @Override
            public boolean d(final boolean b, final DataSource dataSource, final EncodeStrategy encodeStrategy) {
                return dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE;
            }
        };
        b = new h() {
            @Override
            public boolean a() {
                return false;
            }
            
            @Override
            public boolean b() {
                return false;
            }
            
            @Override
            public boolean c(final DataSource dataSource) {
                return false;
            }
            
            @Override
            public boolean d(final boolean b, final DataSource dataSource, final EncodeStrategy encodeStrategy) {
                return false;
            }
        };
        c = new h() {
            @Override
            public boolean a() {
                return true;
            }
            
            @Override
            public boolean b() {
                return false;
            }
            
            @Override
            public boolean c(final DataSource dataSource) {
                return dataSource != DataSource.DATA_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE;
            }
            
            @Override
            public boolean d(final boolean b, final DataSource dataSource, final EncodeStrategy encodeStrategy) {
                return false;
            }
        };
        d = new h() {
            @Override
            public boolean a() {
                return false;
            }
            
            @Override
            public boolean b() {
                return true;
            }
            
            @Override
            public boolean c(final DataSource dataSource) {
                return false;
            }
            
            @Override
            public boolean d(final boolean b, final DataSource dataSource, final EncodeStrategy encodeStrategy) {
                return dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE;
            }
        };
        e = new h() {
            @Override
            public boolean a() {
                return true;
            }
            
            @Override
            public boolean b() {
                return true;
            }
            
            @Override
            public boolean c(final DataSource dataSource) {
                return dataSource == DataSource.REMOTE;
            }
            
            @Override
            public boolean d(final boolean b, final DataSource dataSource, final EncodeStrategy encodeStrategy) {
                return ((b && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
            }
        };
    }
    
    public abstract boolean a();
    
    public abstract boolean b();
    
    public abstract boolean c(final DataSource p0);
    
    public abstract boolean d(final boolean p0, final DataSource p1, final EncodeStrategy p2);
}
