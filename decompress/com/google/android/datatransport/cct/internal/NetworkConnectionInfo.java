// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import com.google.auto.value.AutoValue$Builder;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class NetworkConnectionInfo
{
    public static Builder a() {
        return (Builder)new g.b();
    }
    
    public abstract MobileSubtype b();
    
    public abstract NetworkType c();
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract NetworkConnectionInfo a();
        
        public abstract Builder b(final MobileSubtype p0);
        
        public abstract Builder c(final NetworkType p0);
    }
    
    public enum MobileSubtype
    {
        private static final MobileSubtype[] $VALUES;
        
        CDMA(4), 
        COMBINED(100), 
        EDGE(2), 
        EHRPD(14), 
        EVDO_0(5), 
        EVDO_A(6), 
        EVDO_B(12), 
        GPRS(1), 
        GSM(16), 
        HSDPA(8), 
        HSPA(10), 
        HSPAP(15), 
        HSUPA(9), 
        IDEN(11), 
        IWLAN(18), 
        LTE(13), 
        LTE_CA(19), 
        RTT(7), 
        TD_SCDMA(17), 
        UMTS(3), 
        UNKNOWN_MOBILE_SUBTYPE(0);
        
        private static final SparseArray<MobileSubtype> valueMap;
        private final int value;
        
        static {
            final SparseArray valueMap2 = new SparseArray();
            final MobileSubtype mobileSubtype;
            (valueMap = valueMap2).put(0, (Object)mobileSubtype);
            final MobileSubtype mobileSubtype2;
            valueMap2.put(1, (Object)mobileSubtype2);
            final MobileSubtype mobileSubtype3;
            valueMap2.put(2, (Object)mobileSubtype3);
            final MobileSubtype mobileSubtype4;
            valueMap2.put(3, (Object)mobileSubtype4);
            final MobileSubtype mobileSubtype5;
            valueMap2.put(4, (Object)mobileSubtype5);
            final MobileSubtype mobileSubtype6;
            valueMap2.put(5, (Object)mobileSubtype6);
            final MobileSubtype mobileSubtype7;
            valueMap2.put(6, (Object)mobileSubtype7);
            final MobileSubtype mobileSubtype8;
            valueMap2.put(7, (Object)mobileSubtype8);
            final MobileSubtype mobileSubtype9;
            valueMap2.put(8, (Object)mobileSubtype9);
            final MobileSubtype mobileSubtype10;
            valueMap2.put(9, (Object)mobileSubtype10);
            final MobileSubtype mobileSubtype11;
            valueMap2.put(10, (Object)mobileSubtype11);
            final MobileSubtype mobileSubtype12;
            valueMap2.put(11, (Object)mobileSubtype12);
            final MobileSubtype mobileSubtype13;
            valueMap2.put(12, (Object)mobileSubtype13);
            final MobileSubtype mobileSubtype14;
            valueMap2.put(13, (Object)mobileSubtype14);
            final MobileSubtype mobileSubtype15;
            valueMap2.put(14, (Object)mobileSubtype15);
            final MobileSubtype mobileSubtype16;
            valueMap2.put(15, (Object)mobileSubtype16);
            final MobileSubtype mobileSubtype17;
            valueMap2.put(16, (Object)mobileSubtype17);
            final MobileSubtype mobileSubtype18;
            valueMap2.put(17, (Object)mobileSubtype18);
            final MobileSubtype mobileSubtype19;
            valueMap2.put(18, (Object)mobileSubtype19);
            final MobileSubtype mobileSubtype20;
            valueMap2.put(19, (Object)mobileSubtype20);
        }
        
        private MobileSubtype(final int value) {
            this.value = value;
        }
        
        public static MobileSubtype forNumber(final int n) {
            return (MobileSubtype)MobileSubtype.valueMap.get(n);
        }
        
        public int getValue() {
            return this.value;
        }
    }
    
    public enum NetworkType
    {
        private static final NetworkType[] $VALUES;
        
        BLUETOOTH(7), 
        DUMMY(8), 
        ETHERNET(9), 
        MOBILE(0), 
        MOBILE_CBS(12), 
        MOBILE_DUN(4), 
        MOBILE_EMERGENCY(15), 
        MOBILE_FOTA(10), 
        MOBILE_HIPRI(5), 
        MOBILE_IA(14), 
        MOBILE_IMS(11), 
        MOBILE_MMS(2), 
        MOBILE_SUPL(3), 
        NONE(-1), 
        PROXY(16), 
        VPN(17), 
        WIFI(1), 
        WIFI_P2P(13), 
        WIMAX(6);
        
        private static final SparseArray<NetworkType> valueMap;
        private final int value;
        
        static {
            final NetworkType networkType;
            final NetworkType networkType2;
            final NetworkType networkType3;
            final NetworkType networkType4;
            final NetworkType networkType5;
            final NetworkType networkType6;
            final NetworkType networkType7;
            final NetworkType networkType8;
            final NetworkType networkType9;
            final NetworkType networkType10;
            final NetworkType networkType11;
            final NetworkType networkType12;
            final NetworkType networkType13;
            final NetworkType networkType14;
            final NetworkType networkType15;
            final NetworkType networkType16;
            final NetworkType networkType17;
            final NetworkType networkType18;
            final NetworkType networkType19;
            $VALUES = new NetworkType[] { networkType, networkType2, networkType3, networkType4, networkType5, networkType6, networkType7, networkType8, networkType9, networkType10, networkType11, networkType12, networkType13, networkType14, networkType15, networkType16, networkType17, networkType18, networkType19 };
            final SparseArray valueMap2 = new SparseArray();
            (valueMap = valueMap2).put(0, (Object)networkType);
            valueMap2.put(1, (Object)networkType2);
            valueMap2.put(2, (Object)networkType3);
            valueMap2.put(3, (Object)networkType4);
            valueMap2.put(4, (Object)networkType5);
            valueMap2.put(5, (Object)networkType6);
            valueMap2.put(6, (Object)networkType7);
            valueMap2.put(7, (Object)networkType8);
            valueMap2.put(8, (Object)networkType9);
            valueMap2.put(9, (Object)networkType10);
            valueMap2.put(10, (Object)networkType11);
            valueMap2.put(11, (Object)networkType12);
            valueMap2.put(12, (Object)networkType13);
            valueMap2.put(13, (Object)networkType14);
            valueMap2.put(14, (Object)networkType15);
            valueMap2.put(15, (Object)networkType16);
            valueMap2.put(16, (Object)networkType17);
            valueMap2.put(17, (Object)networkType18);
            valueMap2.put(-1, (Object)networkType19);
        }
        
        private NetworkType(final int value) {
            this.value = value;
        }
        
        public static NetworkType forNumber(final int n) {
            return (NetworkType)NetworkType.valueMap.get(n);
        }
        
        public int getValue() {
            return this.value;
        }
    }
}
