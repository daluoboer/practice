package com.radish.easyCoding.unit7;

import org.omg.IOP.TransactionService;

public class LazyInitDemo {
    private static TransactionService service = null;
    public static TransactionService getService() {
        if (service == null) {
            synchronized (new Object()) {
                if (service == null) {
                    service = new TransactionService() {
                        @Override
                        public int hashCode() {
                            return super.hashCode();
                        }
                    };
                }
            }
        }
        return service;
    }
}
