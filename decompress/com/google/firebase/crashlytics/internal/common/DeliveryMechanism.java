// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

public enum DeliveryMechanism
{
    private static final DeliveryMechanism[] $VALUES;
    
    APP_STORE(4), 
    DEVELOPER(1), 
    TEST_DISTRIBUTION(3), 
    USER_SIDELOAD(2);
    
    private final int id;
    
    private DeliveryMechanism(final int id) {
        this.id = id;
    }
    
    public static DeliveryMechanism determineFrom(final String s) {
        DeliveryMechanism deliveryMechanism;
        if (s != null) {
            deliveryMechanism = DeliveryMechanism.APP_STORE;
        }
        else {
            deliveryMechanism = DeliveryMechanism.DEVELOPER;
        }
        return deliveryMechanism;
    }
    
    public int getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.id);
    }
}
