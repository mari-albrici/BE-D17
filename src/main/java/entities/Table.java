package entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Table {

	private int tableNum;
	private int places;
	private TableStatus tableStatus;

}
