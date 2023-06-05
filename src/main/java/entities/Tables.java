package entities;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
