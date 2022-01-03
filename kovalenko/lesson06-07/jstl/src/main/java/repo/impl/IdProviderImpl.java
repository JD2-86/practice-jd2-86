package repo.impl;

import repo.IdProvider;

import java.util.concurrent.atomic.AtomicLong;

public class IdProviderImpl implements IdProvider {
    private static final IdProvider INSTANCE = new IdProviderImpl();
    private final AtomicLong atomicLong = new AtomicLong();

    public long addId(){
        return atomicLong.getAndIncrement();
    }

    private IdProviderImpl(){}

    public static IdProvider getInstance(){
        return INSTANCE;
    }
}
