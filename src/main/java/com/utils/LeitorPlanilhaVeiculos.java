package com.utils;

import java.util.ArrayList;
import java.util.List;

import org.odftoolkit.odfdom.doc.*;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.doc.table.OdfTableRow;

import com.models.Veiculo;

public class LeitorPlanilhaVeiculos {
    String caminhoArquivo;

    public LeitorPlanilhaVeiculos(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public List<Veiculo> lerPlanilha() throws Exception {
        OdfDocument odt = OdfDocument.loadDocument(this.caminhoArquivo);
        OdfTable tbl = odt.getTableList().get(0);
        
        List<Veiculo> veiculos = this.obtemVeiculosPlanilha(tbl);

        return veiculos;
    }

    public List<String> obtemIpsPlanilha(OdfTable tbl) {
        int colunaIndex = -1;
        OdfTableRow primeiraLinha = tbl.getRowList().get(0);
        
        for (int i = 0; i < primeiraLinha.getCellCount(); i++) {
            if (primeiraLinha.getCellByIndex(i).getStringValue().equals("marca")) {
                colunaIndex = i;
                break;
            }
        }

        if (colunaIndex != -1) {
            List<String> ips = new ArrayList<>();

            System.out.println("\n\n");
            System.out.println(tbl.getRowCount());
            System.out.println("\n\n");

            for (int i = 1; i < tbl.getRowCount(); i++) {
                ips.add(tbl.getRowList().get(i).getCellByIndex(colunaIndex).getStringValue());
            }

            return ips;
        }
        
        return null;
    }

    public List<Veiculo> obtemVeiculosPlanilha(OdfTable tbl) {
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 1; i < tbl.getRowCount(); i++) {
            Veiculo veiculo = new Veiculo(
                tbl.getRowList().get(i).getCellByIndex(0).getStringValue(),
                tbl.getRowList().get(i).getCellByIndex(1).getStringValue(),
                tbl.getRowList().get(i).getCellByIndex(2).getDoubleValue()
            );

            veiculos.add(veiculo);
        }

        return veiculos;
    }

}
