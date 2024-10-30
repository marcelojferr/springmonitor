package com.javaproject.customer.springmonitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.HTTPServer;

@RestController
public class GrafanaController {
    // Contador de requisições
    static final Gauge requests = Gauge.build()
            .name("meu_projeto_grafana_requisicoes_total")
            .help("Total de requisições.")
            .register();

    public GrafanaController(MeterRegistry meterRegistry) throws Exception {
    	// Inicia o servidor HTTP do Prometheus na porta 8080
        HTTPServer server = new HTTPServer(8081); // O Prometheus estará escutando nesta porta
    }

    //  http://localhost:8080/requisicao
    @GetMapping("/requisicao")
    public String processarRequisicao() {
    	requests.inc(); // Incrementa o contador
        return "Requisição processada!";
    }
}
