package com.universidad.tienda.adapter;

public class PayPalAPI {
    public String executePayment(double amount, String currency) {
        if (amount <= 0) return "ERROR: monto invalido";
        System.out.println("PayPal: procesando " + amount + " " + currency);
        return "PP_" + System.currentTimeMillis();
    }
}