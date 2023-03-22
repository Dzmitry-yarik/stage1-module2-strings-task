package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<>(List.of());
        String source2 = source;

        for ( String p : delimiters) {
            for (int i = 0; i < delimiters.size()-1; i++) {
                char c = p.charAt(0);
                source2 = source2.replace(c, ' ');
            }
        }

        String[] string = source2.split(" ");
        for (int i = 0; i < string.length; i++) {
            result.add(string[i]);
        }

        return result;
    }
}
