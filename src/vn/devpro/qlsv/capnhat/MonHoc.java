package vn.devpro.qlsv.capnhat;

import java.util.Scanner;

public class MonHoc {
	private int  ma;
	private String ten;
	private double heSo;
	static Scanner sc = new Scanner(System.in);
	public void display() {
		System.out.printf("%-10d %-50s %5.2f%n",this.ma, this.ten, this.heSo);
	}
	
	
	public MonHoc(int ma, String ten, double heSo) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.heSo = heSo;
	}
	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getHeSo() {
		return heSo;
	}
	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
}
