package my.project.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Stock")
public class Stock {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockid;
	
	private String stockname;
	
	private String stockcode;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "stock", cascade = CascadeType.ALL)
	private Set<StockTransaction> stockTransactions= new HashSet<StockTransaction>();
	
	public Stock() {
		
	}

	public Stock(String stockname, String stockcode) {
		this.stockname = stockname;
		this.stockcode = stockcode;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	public Set<StockTransaction> getStockTransactions() {
		return stockTransactions;
	}

	public void setStockTransactions(Set<StockTransaction> stockTransactions) {
		this.stockTransactions = stockTransactions;
	}
	
	

	



	
	
}
