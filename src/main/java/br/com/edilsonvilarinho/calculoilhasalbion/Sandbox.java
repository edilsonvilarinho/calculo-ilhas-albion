package br.com.edilsonvilarinho.calculoilhasalbion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sandbox {
    public static void main(String[] args) {
        calcularData();
    }

    private static void calcularData() {
        Date dataAtual = new Date();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String stringDate= simpleDateFormat.format(dataAtual);
        System.out.println(stringDate);

        System.out.println(dataAtual);

    }
}
