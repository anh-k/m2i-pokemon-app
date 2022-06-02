package com.formation.pokemonapp.acceptance;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("acceptance")
public class PokemonConfigurationAcceptanceTest {
}
