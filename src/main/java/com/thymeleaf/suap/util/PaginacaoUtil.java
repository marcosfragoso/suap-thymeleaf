package com.thymeleaf.suap.util;

import java.util.List;

public class PaginacaoUtil<T> {
    private int tamanho;
    private int pagina;
    private long totalDePaginas;
    private List<T> registros;

    public PaginacaoUtil(int tamanho, int pagina, long totalDePaginas, List<T> registros) {
        super();
        this.tamanho = tamanho;
        this.pagina = pagina;
        this.totalDePaginas = totalDePaginas;
        this.registros = registros;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPagina() {
        return pagina;
    }

    public long getTotalDePaginas() {
        return totalDePaginas;
    }

    public List<T> getRegistros() {
        return registros;
    }
}
