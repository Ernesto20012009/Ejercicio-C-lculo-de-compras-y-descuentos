public class PurchaseCalculator {

    // SOLO FUNCIONES O METODOS
    public double calculateSubtotal(double price, int quantity){ // INICIO calculateSubtotal(double price, int quantity)
    return price * quantity; // devuelve precio de un producto multiplicado por la cantidad solicitada
    }// FIN calculateSubtotal(double price, int quantity)

    public boolean isValidPurchase(double price, int quantity){ // INICIO isValidPurchase
    if (price > 0 && quantity > 0){
        return  true;
    }// fin if
        return false;
    }// fin isValidPurchase(double price, int quantity)

    public double calculateDiscount(double subtotal) { // INICIO calculateDiscount(double subtotal)
        // devuelve el 10% del subtotal cuando este sea igual o superior a 1000. Si es menor devuelve 0
        if (subtotal >= 1000) {
            return subtotal * .10;
        } else {
            return 0;
        }// fin else
    } // FIN calculateDiscount(double subtotal)


    public double calculateFinalPrice(double subtotal){ // INICIO calculateFinalPrice(double subtotal)
    return subtotal - calculateDiscount(subtotal);
    } // FIN calculateFinalPrice(double subtotal)

}// fin PurchaseCalculator
