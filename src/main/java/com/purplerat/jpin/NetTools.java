package com.purplerat.jpin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

final class NetTools {
    static Document getPage(String url) throws IOException {
        assert url!=null;
        return Jsoup.connect(url).followRedirects(true).get();
    }
}
