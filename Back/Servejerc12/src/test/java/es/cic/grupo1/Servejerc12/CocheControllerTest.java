package es.cic.grupo1.Servejerc12;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.grupo1.Servejerc12.Model.Coche;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CocheControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testGetAllCoches() throws Exception {
        mockMvc.perform(get("/coches"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testGetCocheById() throws Exception {
        mockMvc.perform(get("/coches/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testCreateCoche() throws Exception {
        Coche coche = new Coche();
        coche.setMake("Toyota");
        coche.setModel("Corolla");
        coche.setYear(2020);

        mockMvc.perform(post("/coches")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(coche)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void testUpdateCoche() throws Exception {
        Coche coche = new Coche();
        coche.setId(1L);
        coche.setMake("Honda");
        coche.setModel("Civic");
        coche.setYear(2021);
        
        mockMvc.perform(put("/coches/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(coche)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteCoche() throws Exception {
        mockMvc.perform(delete("/coches/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}