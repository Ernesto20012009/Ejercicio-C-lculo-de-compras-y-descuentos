import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseCalculatorTest {

    private final PurchaseCalculator calculator = new PurchaseCalculator();

    @Test
    @DisplayName("Cálculo de subtotal: Precio normal y cantidad múltiple")
    void testCalculateSubtotalStandard() {
        double subtotal = calculator.calculateSubtotal(100.0, 3);
        assertEquals(300.0, subtotal, 0.001);
    }

    @Test
    @DisplayName("Cálculo de subtotal: Cantidad igual a uno")
    void testCalculateSubtotalSingleQuantity() {
        double subtotal = calculator.calculateSubtotal(250.5, 1);
        assertEquals(250.5, subtotal, 0.001);
    }

    @Test
    @DisplayName("Cálculo de subtotal: Precio igual a cero")
    void testCalculateSubtotalZeroPrice() {
        double subtotal = calculator.calculateSubtotal(0.0, 5);
        assertEquals(0.0, subtotal, 0.001);
    }

    @Test
    @DisplayName("Validación de compra: Precio y cantidad positivos válidos")
    void testIsValidPurchaseSuccess() {
        assertTrue(calculator.isValidPurchase(150.0, 2));
    }

    @Test
    @DisplayName("Validación de compra: Precio igual a cero (Inválido)")
    void testIsValidPurchaseZeroPrice() {
        assertFalse(calculator.isValidPurchase(0.0, 4));
    }

    @Test
    @DisplayName("Validación de compra: Cantidad igual a cero (Inválida)")
    void testIsValidPurchaseZeroQuantity() {
        assertFalse(calculator.isValidPurchase(200.0, 0));
    }

    @Test
    @DisplayName("Validación de compra: Precio negativo (Inválido)")
    void testIsValidPurchaseNegativePrice() {
        assertFalse(calculator.isValidPurchase(-50.0, 2));
    }

    @Test
    @DisplayName("Cálculo de descuento: Subtotal inferior a $1,000 (Sin descuento)")
    void testCalculateDiscountBelowLimit() {
        double discount = calculator.calculateDiscount(800.0);
        assertEquals(0.0, discount, 0.001);
    }

    @Test
    @DisplayName("Cálculo de descuento: Subtotal exactamente igual a $1,000 (Límite aplicado)")
    void testCalculateDiscountExactLimit() {
        double discount = calculator.calculateDiscount(1000.0);
        assertEquals(100.0, discount, 0.001);
    }

    @Test
    @DisplayName("Cálculo de descuento: Subtotal superior a $1,000 (Con descuento)")
    void testCalculateDiscountAboveLimit() {
        double discount = calculator.calculateDiscount(1500.0);
        assertEquals(150.0, discount, 0.001);
    }

    @Test
    @DisplayName("Cálculo de precio final: Compra sin descuento")
    void testCalculateFinalPriceWithoutDiscount() {
        double finalPrice = calculator.calculateFinalPrice(500.0);
        assertEquals(500.0, finalPrice, 0.001);
    }

    @Test
    @DisplayName("Cálculo de precio final: Compra con descuento")
    void testCalculateFinalPriceWithDiscount() {
        double finalPrice = calculator.calculateFinalPrice(1200.0);
        assertEquals(1080.0, finalPrice, 0.001); // 1200 - 120
    }

    @Test
    @DisplayName("Cálculo de precio final: Compra exactamente en el límite de $1,000")
    void testCalculateFinalPriceExactLimit() {
        double finalPrice = calculator.calculateFinalPrice(1000.0);
        assertEquals(900.0, finalPrice, 0.001); // 1000 - 100
    }
}