package es.cic.grupo1.Servejerc12;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.grupo1.Servejerc12.Model.Make;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MakeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllMakes() throws Exception {
        mockMvc.perform(get("/api/makes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testGetMakeById() throws Exception {
        Long id = 1L; // Example ID
        mockMvc.perform(get("/api/makes/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testCreateMake() throws Exception {
        Make make = new Make(); // Set properties as needed
        make.setNombre("Toyota");
        make.setCoches(null);
        String makeJson = objectMapper.writeValueAsString(make);

        mockMvc.perform(post("/api/makes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(makeJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testUpdateMake() throws Exception {
        Long id = 1L; // Example ID
        Make updatedMake = new Make(); // Set properties as needed
        String updatedMakeJson = objectMapper.writeValueAsString(updatedMake);

        mockMvc.perform(put("/api/makes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedMakeJson))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteMake() throws Exception {
        Long id = 1L; // Example ID

        mockMvc.perform(delete("/api/makes/{id}", id))
                .andExpect(status().isOk());
    }
}