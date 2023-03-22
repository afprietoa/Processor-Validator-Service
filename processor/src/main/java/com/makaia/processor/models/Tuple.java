package com.makaia.processor.models;

public class Tuple {
    private int validTupleCount;
    private int invalidTupleCount;

    public Tuple(int validTupleCount, int invalidTupleCount) {
        this.validTupleCount = validTupleCount;
        this.invalidTupleCount = invalidTupleCount;
    }

    public int getValidTupleCount() {
        return validTupleCount;
    }

    public int getNoValidTupleCount() {
        return invalidTupleCount;
    }
}
