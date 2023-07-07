package tuto.cucumber.sample.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import tuto.cucumber.sample.model.Account;
import tuto.cucumber.sample.repository.AccountRepository;
import tuto.cucumber.sample.utils.FeatureUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountManagement {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<Account> response;
    private Account mockAccount;

    @Given("an existing account with ID {long}")
    public void anExistingAccountWithID(long id) {
        // use the mock account saved
        this.mockAccount = FeatureUtils.getMockAccount();
        this.accountRepository.save(this.mockAccount);
    }

    @When("the user sends a GET request to {string}")
    public void theUserSendsAGETRequestTo(String path) {
        String url = String.format("%s/%s/%d", FeatureUtils.URL, path, mockAccount.getId());
        response = this.restTemplate.getForEntity(url, Account.class);
    }

    @Then("the response status code of getting an account should be {int}")
    public void theResponseStatusCodeOfGettingAnAccountShouldBe(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("the response body should contain the account details")
    public void theResponseBodyShouldContainTheAccountDetails() {
        Account resAccount = response.getBody();
        assert resAccount != null;
        assertEquals(mockAccount.getId(), resAccount.getId());
        assertEquals(mockAccount.getUsername(), resAccount.getUsername());
        assertEquals(mockAccount.getPassword(), resAccount.getPassword());
        assertEquals(mockAccount.getFullName(), resAccount.getFullName());
    }
}
