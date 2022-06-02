package com.formation.pokemonapp.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class LoadJsonFile {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ClassLoader CLASS_LOADER = LoadJsonFile.class.getClassLoader();

    public static String toString(String file) throws IOException {
        return MAPPER.writeValueAsString(MAPPER.readValue(new File(load(file).getAbsolutePath()), Object.class));
    }

    private static File load(String file) {
        return new File(((URL) Objects.requireNonNull(CLASS_LOADER.getResource(file))).getFile());
    }

    private LoadJsonFile() {

    }
}
