package es.cic.grupo1.Servejerc12;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.grupo1.Servejerc12.Model.Coche;
import es.cic.grupo1.Servejerc12.Model.Fabricante;

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
        mockMvc.perform(get("/api/coches"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testGetCocheById() throws Exception {
        mockMvc.perform(get("/api/coches/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testCreateCoche() throws Exception {
        Coche coche = new Coche();
        coche.setFabricante(new Fabricante(3l,"Honda",null));
        coche.setModelo("Corolla");
        coche.setanio(2020);

        mockMvc.perform(post("/api/coches")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(coche)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void testUpdateCoche() throws Exception {
        Coche coche = new Coche();
        coche.setId(1L);
        coche.setFabricante(new Fabricante(3l,"Honda",null));
        coche.setModelo("Civic");
        coche.setanio(2021);
        
        mockMvc.perform(put("/api/coches/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(coche)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteCoche() throws Exception {
        mockMvc.perform(delete("/api/coches/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}