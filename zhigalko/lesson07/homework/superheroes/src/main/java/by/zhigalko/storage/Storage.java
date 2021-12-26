package by.zhigalko.storage;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Storage {
    public final AtomicLong id = new AtomicLong(0);

    public Storage() {}

    public AtomicLong getId() {
        return id;
    }
}
