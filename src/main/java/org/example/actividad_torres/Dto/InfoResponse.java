package org.example.actividad_torres.Dto;

public record InfoResponse(
        String name,
        String version,
        String environment,
        String developerName,
        String developerEmail
) {
}