package com.arh.pojo;

public class Operation {

	private String name;

	private int number;

	private int tempNumber;

	/**
	 * 
	 * @param name
	 *            The name of the operation
	 * @param number
	 *            The number of times the operation is executed
	 */
	public Operation(String name, int number) {
		super();
		this.name = name;
		this.number = number;
		this.tempNumber = number;
	}

	public void initTempNumber() {
		this.tempNumber = this.number;
	}

	public void reduceTempNumber() {
		this.tempNumber--;
	}

	public void increaseTempNumber() {
		this.tempNumber++;
	}

	public boolean isAliveByTempNumber() {
		return this.tempNumber > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTempNumber() {
		return tempNumber;
	}

	public void setTempNumber(int tempNumber) {
		this.tempNumber = tempNumber;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Operation [name=" + name + "]";
	}

}
