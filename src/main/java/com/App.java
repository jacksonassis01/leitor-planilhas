package com;

import java.util.List;

import com.models.Veiculo;
import com.utils.LeitorPlanilhaVeiculos;

public class App {

    public static void main(String[] args) {
        LeitorPlanilhaVeiculos lpv = new LeitorPlanilhaVeiculos(System.getProperty("user.dir") + "/lavajato/veiculos.ods");

        try {
            List<Veiculo> veiculos = lpv.lerPlanilha();
            System.out.println(veiculos);
        } catch (Exception e) {
            System.out.println("nao foi possivel ler a planilha...");
        }        
    }
}
