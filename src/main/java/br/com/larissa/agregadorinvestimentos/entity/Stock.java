package br.com.larissa.agregadorinvestimentos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_stocks")
public class Stock {

    @Id
    @Column(name = "stock_id")
    private String StockId;

    @Column(name = "description")
    private String description;

    public Stock() {

    }

    public Stock(String stockId, String description) {
        this.StockId = stockId;
        this.description = description;
    }

    public String getStockId() {
        return StockId;
    }

    public void setStockId(String stockId) {
        StockId = stockId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
