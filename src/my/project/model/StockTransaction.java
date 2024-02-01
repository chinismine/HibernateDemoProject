package my.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name="stockTransaction")
public class StockTransaction {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stocktransid;
	
	private int tradevolume;
	
	@Column(name="STOCKID", insertable = false, updatable = false)
	private int stockid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STOCKID")
	private Stock stock;
	
	public StockTransaction() {
		
	}
	

	public StockTransaction(int tradevolume) {
		this.tradevolume = tradevolume;
	}


	public int getStocktransid() {
		return stocktransid;
	}

	public void setStocktransid(int stocktransid) {
		this.stocktransid = stocktransid;
	}

	public int getTradevolume() {
		return tradevolume;
	}

	public void setTradevolume(int tradevolume) {
		this.tradevolume = tradevolume;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
}
