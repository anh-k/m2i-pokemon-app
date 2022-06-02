package com.formation.pokemonapp.acceptance.tools;

public class AcceptanceTestTools {
    private static final String PROTOCOL = "http";
    private static final String SERVER_IP = "localhost";

    public static String getServerUrl(int port, String resourcePath) {
        return PROTOCOL + "://" + SERVER_IP + ":" + port + resourcePath;
    }
}
