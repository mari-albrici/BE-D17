package entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Table {

	private int tableNum;
	private int places;
	private TableStatus tableStatus;

}
