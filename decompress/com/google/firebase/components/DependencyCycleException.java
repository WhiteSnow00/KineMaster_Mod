// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

public class DependencyCycleException extends DependencyException
{
    private final List<Component<?>> componentsInCycle;
    
    public DependencyCycleException(final List<Component<?>> componentsInCycle) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Dependency cycle detected: ");
        sb.append(Arrays.toString(componentsInCycle.toArray()));
        super(sb.toString());
        this.componentsInCycle = componentsInCycle;
    }
    
    public List<Component<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
