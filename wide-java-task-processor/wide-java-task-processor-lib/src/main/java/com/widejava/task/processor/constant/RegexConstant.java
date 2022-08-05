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

    public Map<String, String> getResult(String value) {
        final Map<String, String> result = new HashMap<>();
        final Matcher matcher = Pattern.compile(regex).matcher(value);
        if (StringUtils.isNotBlank(value) && matcher.find()) {
            Arrays.stream(matcher.group().split(",")).map(line -> line.split(":")).forEach(array -> result.put(
                    StringUtils.trim(array[0]), StringUtils.trim(array[1])));
        }
        return result;
    }
}
