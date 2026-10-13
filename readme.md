# Documentación Técnica: Módulo de Cálculo de Compras

## 1. Descripción del problema
El sistema implementa la lógica de cálculo comercial para una tienda en línea. Se encarga de procesar subtotales, validar la viabilidad de los pedidos y aplicar descuentos por volumen de compra. Es vital verificar estos cálculos mediante pruebas unitarias para evitar errores monetarios que perjudiquen al cliente (cobros excesivos) o a la empresa (pérdidas de ingresos).

## 2. Reglas de negocio
* **Cálculo del subtotal:** Multiplica el precio unitario del producto por la cantidad solicitada.
* **Validación de compra:** Una compra se considera válida únicamente si tanto el precio como la cantidad son estrictamente mayores a cero ($> 0$).
* **Descuento:** Se otorga un 10% de descuento sobre el subtotal cuando este es **igual o superior** a $1,000 MXN ($\ge 1000$). Si es menor, el descuento es de $0 MXN.
* **Precio final:** Resulta de restar el monto del descuento correspondiente al subtotal.

## 3. Casos de prueba

| Método a Probar | Datos de Entrada | Resultado Esperado | Resultado Obtenido | Propósito del Caso |
|---|---|---|---|---|
| `calculateSubtotal` | Precio: $100, Cantidad: 3 | 300.0 | 300.0 | Verificar multiplicación correcta con valores estándar. |
| `calculateSubtotal` | Precio: $250.5, Cantidad: 1 | 250.5 | 250.5 | Comprobar comportamiento con cantidad unitaria. |
| `isValidPurchase` | Precio: $150, Cantidad: 2 | `true` | `true` | Validar una compra con parámetros positivos correctos. |
| `isValidPurchase` | Precio: $0, Cantidad: 4 | `false` | `false` | Comprobar rechazo cuando el precio es cero. |
| `calculateDiscount` | Subtotal: $800 | 0.0 | 0.0 | Verificar que no se aplique descuento debajo del umbral. |
| `calculateDiscount` | Subtotal: $1000 | 100.0 | 100.0 | Verificar el comportamiento exacto en el límite del umbral ($\ge$). |
| `calculateFinalPrice` | Subtotal: $1200 | 1080.0 | 1080.0 | Comprobar aplicación correcta del descuento del 10%. |

## 4. Resultados de ejecución
* **Total de pruebas ejecutadas:** 13
* **Pruebas exitosas (Passed):** 13
* **Pruebas fallidas (Failed):** 0

## 5. Errores que se pueden prevenir
1. **Error de operador estricto en límites (`>` en lugar de `>=`):** Previene que un cliente que gasta exactamente $1,000 se quede sin su descuento correspondiente.
2. **Errores de validación por entradas negativas o nulas:** Previene que el sistema acepte transacciones con precios o cantidades en cero o negativas, lo que corrompería los registros financieros.

## 6. Conclusión
Las pruebas unitarias garantizan la robustez del código de comercio electrónico al verificar de forma automatizada cada regla de negocio y caso límite. Contribuyen a la confiabilidad del software asegurando que cualquier cambio futuro en el código mantenga la integridad de los cálculos financieros.
