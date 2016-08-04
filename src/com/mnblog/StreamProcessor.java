package com.mnblog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Milan.Nikic on 8/4/2016.
 */

@FunctionalInterface
public interface StreamProcessor {

    void processStream(Stream<String> strings, String outputFile);

    static void processFile(String inputFile, String outputFile, StreamProcessor processor) {
        try (Stream<String> lines = Files.lines(Paths.get(inputFile))) {
            processor.processStream(lines, outputFile);
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe);
        }
    }
}
