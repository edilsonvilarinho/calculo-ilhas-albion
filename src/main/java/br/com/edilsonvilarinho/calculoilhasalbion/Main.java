package br.com.edilsonvilarinho.calculoilhasalbion;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.albion-online-data.com/api/v2/stats/Prices/T1_FARM_CARROT_SEED.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            if (connection.getResponseCode() == 200) {
                InputStream responseStream = connection.getInputStream();
                ObjectMapper mapper = new ObjectMapper();
                var sementesCenouras = mapper.readValue(responseStream, DataPrice[].class);
                float valorMedioMinimoSementeCenoura = 0;
                int contadorCidadesPrecoMaiorZero = 0;
                float precoMinimoCaerlonSementeCenoura = 0;
                final int quantidadeDeIlhas = 13;
                final int quantidadeSementes = 45 * quantidadeDeIlhas;
                final int quantidadeSlotesIlha = 5 * quantidadeDeIlhas;
                final int valorMedioDiasNoMes = 30;
                final float pedidoDeVenda = 363;
                for (DataPrice preco : sementesCenouras) {
                    if ((preco.getCity().equalsIgnoreCase("Bridgewatch") || preco.getCity().equalsIgnoreCase("Caerleon") || preco.getCity().equalsIgnoreCase("Fort Sterling") || preco.getCity().equalsIgnoreCase("Lymhurst") || preco.getCity().equalsIgnoreCase("Martlock") || preco.getCity().equalsIgnoreCase("Thetford")) && preco.getBuy_price_min() > 0) {
                        valorMedioMinimoSementeCenoura = valorMedioMinimoSementeCenoura + preco.getBuy_price_min();
                        contadorCidadesPrecoMaiorZero++;
                        if (preco.getCity().equalsIgnoreCase("Caerleon")) {
                            precoMinimoCaerlonSementeCenoura = preco.getSell_price_min();
                        }
                    }
                }
                if (contadorCidadesPrecoMaiorZero > 0) {
                    //Float custoPlantarSementeCenouraInicial = (valorMedioMinimoSementeCenoura / contadorCidadesPrecoMaiorZero) * quantidadeSementes;
                    System.out.println("Valores para " + quantidadeDeIlhas + " Ilhas ");
                    //System.out.println("Custo medio minimo para plantar cenoura as 6 cidades principais do jogo  = " + custoPlantarSementeCenouraInicial);
                    System.out.println("Preco minimo em caerlon " + precoMinimoCaerlonSementeCenoura);
                    float custoInicialPlantarSementesCenoura = precoMinimoCaerlonSementeCenoura * quantidadeSementes;
                    System.out.println("Custo minimo para plantar cenoura caerlon = " + custoInicialPlantarSementesCenoura);
                    url = new URL("https://www.albion-online-data.com/api/v2/stats/Prices/T1_CARROT.json");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("accept", "application/json");

                    if (connection.getResponseCode() == 200) {
                        responseStream = connection.getInputStream();
                        mapper = new ObjectMapper();
                        var cenouras = mapper.readValue(responseStream, DataPrice[].class);
                        float valorMedioMinimoCenouraVenda = 0;
                        contadorCidadesPrecoMaiorZero = 0;
                        float precoMinimoCaerlonCenoura = 0;
                        final int quantidadeMediaRetornoDeCenourasPorSemente = 9;
                        for (DataPrice preco : cenouras) {
                            if ((preco.getCity().equalsIgnoreCase("Bridgewatch") || preco.getCity().equalsIgnoreCase("Caerleon") || preco.getCity().equalsIgnoreCase("Fort Sterling") || preco.getCity().equalsIgnoreCase("Lymhurst") || preco.getCity().equalsIgnoreCase("Martlock") || preco.getCity().equalsIgnoreCase("Thetford")) && preco.getSell_price_min() > 0) {
                                valorMedioMinimoCenouraVenda = valorMedioMinimoCenouraVenda + preco.getSell_price_min();
                                contadorCidadesPrecoMaiorZero++;
                                if (preco.getCity().equalsIgnoreCase("Caerleon")) {
                                    precoMinimoCaerlonCenoura = preco.getSell_price_min();
                                }
                            }
                        }
                        if (contadorCidadesPrecoMaiorZero > 0) {
                            //Float precoMedioMinimoVendaCenoura = (valorMedioMinimoCenouraVenda / contadorCidadesPrecoMaiorZero) * quantidadeMediaRetornoCenouras;
                            //System.out.println("Preco medio minimo de venda da cenoura as 6 cidades principais do jogo  = " + precoMedioMinimoVendaCenoura);
                            System.out.println("Pedido de venda em caerlon cenoura " + pedidoDeVenda);
                            System.out.println("Preco minimo venda  em caerlon cenoura " + precoMinimoCaerlonCenoura);
                            float valorRetornoEsperadoPelaVendaCenoura = ((quantidadeSlotesIlha * (quantidadeMediaRetornoDeCenourasPorSemente * 9)) * precoMinimoCaerlonCenoura);
                            System.out.println("Valor de retorno esperado minimo pela venda da cenoura em caerlon = " + valorRetornoEsperadoPelaVendaCenoura);
                            float valorRetornoEsperadoPelaVendaCenouraPedidoDeVenda = ((quantidadeSlotesIlha * (quantidadeMediaRetornoDeCenourasPorSemente * 9)) * pedidoDeVenda);
                            System.out.println("Valor de retorno esperado minimo por pedido de venda da cenoura em caerlon = " + valorRetornoEsperadoPelaVendaCenouraPedidoDeVenda);
                            float lucroOuPrejuizo = valorRetornoEsperadoPelaVendaCenoura - custoInicialPlantarSementesCenoura;
                            System.out.println("Lucro/Prejuizo de retorno esperado minimo pela venda da cenoura em caerlon = " + lucroOuPrejuizo);
                            float lucroOuPrejuizoPedidoDeVenda = valorRetornoEsperadoPelaVendaCenouraPedidoDeVenda - custoInicialPlantarSementesCenoura;
                            System.out.println("Lucro/Prejuizo de retorno esperado minimo por pedido de venda da cenoura em caerlon = " + lucroOuPrejuizoPedidoDeVenda);
                            System.out.println("Retorno em 1 mes = " + (new BigDecimal(lucroOuPrejuizo).multiply(new BigDecimal(valorMedioDiasNoMes))));
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("args = " + e.getLocalizedMessage());
        }
    }
}
