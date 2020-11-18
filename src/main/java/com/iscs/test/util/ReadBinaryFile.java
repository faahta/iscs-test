package com.iscs.test.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by Fassil on 17/11/20.
 */
public class ReadBinaryFile {
    public static String[][] read(Path path) throws IOException  {
        Objects.requireNonNull(path);

        try (Stream<String> lines = Files.lines(path).skip(1))  {
            return lines
                    .map(String::trim) //Rimuovi gli spazi vuoti iniziali e finali.
                    .filter(line -> !line.isEmpty()) // Ignora le righe vuote.
                    .map(line -> line.split("\\s+")) // Linea divisa da spazi vuoti.

                    .toArray(String[][]::new);
        } catch (UncheckedIOException e) {
            throw e.getCause();
        }
    }
}
