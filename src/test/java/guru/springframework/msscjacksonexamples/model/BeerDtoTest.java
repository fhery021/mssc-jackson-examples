package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
public class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto dto = getDto();
        String json = objectMapper.writeValueAsString(dto);
        System.out.println(json);
    }


    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"38a2c765-a830-4fba-a800-abad4b6aa54d\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-04-30T17:46:12.459198+02:00\",\"lastUpdatedDate\":\"2020-04-30T17:46:12.4611983+02:00\"}\n";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);

    }
}
