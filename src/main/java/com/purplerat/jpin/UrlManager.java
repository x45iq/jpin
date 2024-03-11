package com.purplerat.jpin;

import java.util.regex.Pattern;

class UrlManager {
    static final Pattern SHORT_LINK_REGEX = Pattern.compile("https://pin\\.it/([0-9a-zA-Z_\\-]{7})");
    static final Pattern FULL_LINK_REGEX = Pattern.compile("https://www.pinterest.com/pin/([0-9]*)");
    static boolean isUrlSupported(String url){
        assert url != null;
        return SHORT_LINK_REGEX.matcher(url).find() || FULL_LINK_REGEX.matcher(url).find();
    }
}
