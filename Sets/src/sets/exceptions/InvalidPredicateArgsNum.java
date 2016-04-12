package sets.exceptions;

public class InvalidPredicateArgsNum extends Exception {
	int expected;
	int received;
	
	public InvalidPredicateArgsNum(int expected, int received){
		this.expected = expected;
		this.received = received;
	}
}
