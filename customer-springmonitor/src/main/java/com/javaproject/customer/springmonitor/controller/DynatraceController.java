package com.javaproject.customer.springmonitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;

@RestController
public class DynatraceController {
	/*Inserir no properties

	# Configurações do Dynatrace
	#management.metrics.export.dynatrace.enabled=true
	#management.metrics.export.dynatrace.api-token=YOUR_API_TOKEN
	#management.metrics.export.dynatrace.uri=https://YOUR_TENANT_ID.live.dynatrace.com/api/v2/metrics
	#management.metrics.export.dynatrace.prefix=your-app-name*/
	
    private final Counter contador;

    public DynatraceController(MeterRegistry meterRegistry) {
        this.contador = meterRegistry.counter("requisicoes_total");
    }

//    http://localhost:8080/requisicao
    @GetMapping("/requisicao")
    public String processarRequisicao() {
        contador.increment(); // Incrementa o contador
        return "Requisição processada!";
    }
}
