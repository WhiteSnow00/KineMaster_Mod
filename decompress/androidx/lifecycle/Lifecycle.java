// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle
{
    AtomicReference<Object> a;
    
    public Lifecycle() {
        this.a = new AtomicReference<Object>();
    }
    
    public abstract void a(final q p0);
    
    public abstract State b();
    
    public abstract void c(final q p0);
    
    public enum Event
    {
        private static final Event[] $VALUES;
        
        ON_ANY, 
        ON_CREATE, 
        ON_DESTROY, 
        ON_PAUSE, 
        ON_RESUME, 
        ON_START, 
        ON_STOP;
        
        public static Event downFrom(final State state) {
            final int n = Lifecycle$a.a[state.ordinal()];
            if (n == 1) {
                return Event.ON_DESTROY;
            }
            if (n == 2) {
                return Event.ON_STOP;
            }
            if (n != 3) {
                return null;
            }
            return Event.ON_PAUSE;
        }
        
        public static Event downTo(final State state) {
            final int n = Lifecycle$a.a[state.ordinal()];
            if (n == 1) {
                return Event.ON_STOP;
            }
            if (n == 2) {
                return Event.ON_PAUSE;
            }
            if (n != 4) {
                return null;
            }
            return Event.ON_DESTROY;
        }
        
        public static Event upFrom(final State state) {
            final int n = Lifecycle$a.a[state.ordinal()];
            if (n == 1) {
                return Event.ON_START;
            }
            if (n == 2) {
                return Event.ON_RESUME;
            }
            if (n != 5) {
                return null;
            }
            return Event.ON_CREATE;
        }
        
        public static Event upTo(final State state) {
            final int n = Lifecycle$a.a[state.ordinal()];
            if (n == 1) {
                return Event.ON_CREATE;
            }
            if (n == 2) {
                return Event.ON_START;
            }
            if (n != 3) {
                return null;
            }
            return Event.ON_RESUME;
        }
        
        public State getTargetState() {
            switch (Lifecycle$a.b[this.ordinal()]) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this);
                    sb.append(" has no target state");
                    throw new IllegalArgumentException(sb.toString());
                }
                case 6: {
                    return State.DESTROYED;
                }
                case 5: {
                    return State.RESUMED;
                }
                case 3:
                case 4: {
                    return State.STARTED;
                }
                case 1:
                case 2: {
                    return State.CREATED;
                }
            }
        }
    }
    
    public enum State
    {
        private static final State[] $VALUES;
        
        CREATED, 
        DESTROYED, 
        INITIALIZED, 
        RESUMED, 
        STARTED;
        
        public boolean isAtLeast(final State state) {
            return this.compareTo(state) >= 0;
        }
    }
}
