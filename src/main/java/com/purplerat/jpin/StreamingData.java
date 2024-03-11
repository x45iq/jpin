package com.purplerat.jpin;

import java.util.Objects;

public final class StreamingData {
    private final int width;
    private final int height;
    private final String url;

    public StreamingData(int width, int height, String url) {
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    public String url() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamingData that = (StreamingData) o;
        return width == that.width && height == that.height && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, url);
    }

    @Override
    public String toString() {
        return "StreamingData{" +
                "width=" + width +
                ", height=" + height +
                ", url='" + url + '\'' +
                '}';
    }
}
