package jp.ken.emp.model;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeModel {

	@NotEmpty(message = "ああああ")
	private String name;

	private String kana;
	private String gender;
	private String bYear;
	private String bMonth;
	private String bDay;
	//@NotBlank(message = "郵便番号は必須入力です。")
	//@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$",
	//groups = Group1.class,message = "郵便番号ではありません。")
	private String zip;
	//@NotBlank(message = "住所は必須入力です。")
	private String address;

	//@NotBlank(message = "携帯番号は必須入力です。")
	//@Pattern(regexp = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$",
	//groups = Group1.class,message = "携帯番号ではありません。")
	private String phone;

	//@NotBlank(message = "メールアドレスは必須入力です。")
	//@Email(message = "メールアドレスではありません。")
	private String mail;

	private String eYear;
	private String eMonth = "4";
	private String eDay;
	private String post;
	//@NotBlank(message = "上司名は必須入力です。")
	private String superior;

	//@NotBlank(message = "最寄り駅は必須入力です。")
	private String station;

	private String rank = "B";
	private String[] capacities;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getbYear() {
		return bYear;
	}
	public void setbYear(String bYear) {
		this.bYear = bYear;
	}
	public String getbMonth() {
		return bMonth;
	}
	public void setbMonth(String bMonth) {
		this.bMonth = bMonth;
	}
	public String getbDay() {
		return bDay;
	}
	public void setbDay(String bDay) {
		this.bDay = bDay;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String geteYear() {
		return eYear;
	}
	public void seteYear(String eYear) {
		this.eYear = eYear;
	}
	public String geteMonth() {
		return eMonth;
	}
	public void seteMonth(String eMonth) {
		this.eMonth = eMonth;
	}
	public String geteDay() {
		return eDay;
	}
	public void seteDay(String eDay) {
		this.eDay = eDay;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String superior) {
		this.superior = superior;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String[] getCapacities() {
		return capacities;
	}
	public void setCapacities(String[] capacities) {
		this.capacities = capacities;
	}
	
}
