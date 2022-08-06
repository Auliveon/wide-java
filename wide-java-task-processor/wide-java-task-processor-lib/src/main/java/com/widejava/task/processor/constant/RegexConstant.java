package com.widejava.task.processor.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegexConstant {

    TEST_RESULT("(?<=(Tests )).+(?=s(.+) in org)");

    private final String regex;

    RegexConstant(String regex) {
        this.regex = regex;
    }

    public String getResult(String value) {
        String result = null;
        final Matcher matcher = Pattern.compile(regex).matcher(value);
        if (StringUtils.isNotBlank(value) && matcher.find()) {
            result=  matcher.group();
        }
        return StringUtils.trim(result);
    }
}
