package com.purplerat.jpin;

import java.io.Serializable;
import java.util.Objects;

public final class Pin implements Serializable {
    private final PinMeta meta;
    private final StreamingData streamingData;

    public Pin(PinMeta meta, StreamingData streamingData) {
        this.meta = meta;
        this.streamingData = streamingData;
    }

    public PinMeta meta() {
        return meta;
    }

    public StreamingData streamingData() {
        return streamingData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pin pin = (Pin) o;
        return Objects.equals(meta, pin.meta) && Objects.equals(streamingData, pin.streamingData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meta, streamingData);
    }

    @Override
    public String toString() {
        return "Pin{" +
                "meta=" + meta +
                ", streamingData=" + streamingData +
                '}';
    }
}
