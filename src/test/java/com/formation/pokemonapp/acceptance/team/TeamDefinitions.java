package com.formation.pokemonapp.acceptance.team;

import com.formation.pokemonapp.acceptance.tools.AcceptanceTestTools;
import com.formation.pokemonapp.entity.Team;
import com.formation.pokemonapp.repository.TeamRepository;
import com.formation.pokemonapp.tools.LoadJsonFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.HttpClients;
import org.assertj.core.api.Assertions;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class TeamDefinitions {
    private String requestJson;
    private int statusCode;

    private final TeamRepository teamRepository;

    @LocalServerPort
    private int port;

    @Given("Application saves Team from file {string}")
    public void save_team_from_file(String jsonFile) throws IOException {
        requestJson = LoadJsonFile.toString(jsonFile);
    }

    @When("Application wants to call Team with POST (.+)$")
    public void call_team_with_post(String endpoint) {
        ClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = AcceptanceTestTools.getServerUrl(port, endpoint);

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        try {
            statusCode = restTemplate.postForEntity(url, entity, String.class).getStatusCode().value();
        } catch (HttpClientErrorException errorException) {
            statusCode = errorException.getStatusCode().value();
        }
    }

    @Then("Saves {int} Team")
    public void save_team(int number) {
        List<Team> teams = teamRepository.findAll();
        Assertions.assertThat(teams).hasSize(number);
    }

    @Then("Application receives http status code of {int} with Team")
    public void receive_http_status_code_team(int codeNumber) {
        Assertions.assertThat(statusCode).isEqualTo(codeNumber);
    }
}
