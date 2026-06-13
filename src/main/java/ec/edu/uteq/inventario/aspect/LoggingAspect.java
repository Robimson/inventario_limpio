package ec.edu.uteq.inventario.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    // Esto se ejecuta AUTOMÁTICAMENTE antes de cualquier método en ProductService
    @Before("execution(* ec.edu.uteq.inventario.service.ProductService.*(..))")
    public void logAntesDeMetodos(JoinPoint joinPoint) {
        String metodo = joinPoint.getSignature().getName();
        System.out.println("[AOP LOG] Ejecutando: " + metodo + " - Fecha: " + new Date());
    }
}