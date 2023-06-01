package entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;  
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tables_chart")
@Getter
@Setter
@AllArgsConstructor
public class Tables {
    
	@Id
	private int tableNum;
	
	private int places;
	private TableStatus tableStatus;

}
