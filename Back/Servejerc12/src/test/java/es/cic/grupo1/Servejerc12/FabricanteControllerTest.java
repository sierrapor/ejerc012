package es.cic.grupo1.Servejerc12;

import es.cic.grupo1.Servejerc12.Model.Fabricante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class FabricanteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Fabricante fabricante;

    @BeforeEach
    void setUp() {
        fabricante = new Fabricante();
        fabricante.setId(1L);
        fabricante.setNombre("Toyota");
    }

    @Test
    public void testCreateFabricante() throws Exception {
        mockMvc.perform(post("/api/fabricantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fabricante)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void testUpdateFabricante() throws Exception {
        fabricante.setNombre("Honda");

        mockMvc.perform(put("/api/fabricantes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fabricante)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteFabricante() throws Exception {
        mockMvc.perform(delete("/api/fabricantes/1"))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    public void testGetFabricanteById() throws Exception {
        mockMvc.perform(get("/api/fabricantes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Toyota"))
                .andDo(print());
    }

    @Test
    public void testGetAllFabricantes() throws Exception {
        mockMvc.perform(get("/api/fabricantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}