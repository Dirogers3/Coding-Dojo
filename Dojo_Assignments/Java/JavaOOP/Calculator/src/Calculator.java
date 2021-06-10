
class Calculator implements java.io.Serializable{
	private Double OperandOne;
	private String Operation;
	private Double OperandTwo;
	private Double Results;
	
	public Double getOperandOne() {
		return OperandOne;
	}

	public void setOperandOne(Double operandOne) {
		OperandOne = operandOne;
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public Double getOperandTwo() {
		return OperandTwo;
	}

	public void setOperandTwo(Double operandTwo) {
		OperandTwo = operandTwo;
	}

	public Double getResults() {
		System.out.println(Results);
		return Results;
	}

	public void setResults(Double results) {
		Results = results;
	}

	public void performOperation() {
		if(this.getOperation() == "+") {
			this.Results = this.OperandOne + this.OperandTwo;
		}
		if (this.getOperation() == "-") {
			this.Results = this.OperandOne - this.OperandTwo;
		}
	}
	

}
