package org.example.actividad_torres.Controller;

import org.example.actividad_torres.Config.AppInfoProperties;
import org.example.actividad_torres.Dto.InfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InfoController {

    private final AppInfoProperties appInfoProperties;

    public InfoController(AppInfoProperties appInfoProperties) {
        this.appInfoProperties = appInfoProperties;
    }

    @GetMapping("/info")
    public InfoResponse getInfo() {

        return new InfoResponse(
                appInfoProperties.getName(),
                appInfoProperties.getVersion(),
                appInfoProperties.getEnvironment(),
                appInfoProperties.getDeveloper().getName(),
                appInfoProperties.getDeveloper().getEmail()
        );
    }
}