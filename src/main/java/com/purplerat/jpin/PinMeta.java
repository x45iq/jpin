package com.purplerat.jpin;

import java.util.Objects;

public final class PinMeta {
    private final String name;
    private final String description;
    private final String thumbnail;
    private final String url;

    public PinMeta(String name, String description, String thumbnail,String url) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.url = url;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String thumbnail() {
        return thumbnail;
    }
    public String url() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinMeta pinMeta = (PinMeta) o;
        return Objects.equals(name, pinMeta.name) && Objects.equals(description, pinMeta.description) && Objects.equals(thumbnail, pinMeta.thumbnail) && Objects.equals(url, pinMeta.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, thumbnail, url);
    }

    @Override
    public String toString() {
        return "PinMeta{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
