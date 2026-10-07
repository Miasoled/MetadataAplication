package org.example.actividad_torres.Controller;

import org.example.actividad_torres.Config.AppInfoProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.matchesPattern;

@WebMvcTest(InfoController.class)
public class InfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AppInfoProperties appInfoProperties;

    @Test
    void shouldReturnAppInfo() throws Exception {
        AppInfoProperties.Developer developer =
                new AppInfoProperties.Developer();

        developer.setName("Lisseth");
        developer.setEmail("jltorres15@espe.edu.ec");
        when(appInfoProperties.getName()).thenReturn("Gestor de Inventario");
        when(appInfoProperties.getVersion()).thenReturn("0.0.1-SNAPSHOT");
        when(appInfoProperties.getEnvironment()).thenReturn("test");
        when(appInfoProperties.getDeveloper()).thenReturn(developer);

        mockMvc.perform(get("/api/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Gestor de Inventario"))
                .andExpect(jsonPath("$.version").value("0.0.1-SNAPSHOT"))
                .andExpect(jsonPath("$.environment").value("test"))
                .andExpect(jsonPath("$.developerName").value("Lisseth"))
                .andExpect(jsonPath("$.developerEmail")
                        .value(matchesPattern("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")));
    }

}