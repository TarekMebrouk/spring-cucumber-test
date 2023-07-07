package tuto.cucumber.sample.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import tuto.cucumber.sample.model.Account;
import java.io.IOException;

public class FeatureUtils {
    public static String URL = "http://localhost:9001";
    public static Account getMockAccount() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("Account.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Account.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
