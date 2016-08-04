package com.mnblog;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Milan.Nikic on 8/4/2016.
 */
public class WordsWithB implements StreamProcessor {

    final Charset charset = Charset.defaultCharset();

    @Override
    public void processStream(Stream<String> strings, String outputFile) {
        List<String> words = strings.parallel()
                .filter(word -> word.contains("b"))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        try {
            Files.write(Paths.get(outputFile), words, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Wrote %s words to %s.%n", words.size(), outputFile);
    }
}
