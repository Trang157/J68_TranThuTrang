package vn.devpro.qlsv.capnhat;

import java.util.Scanner;

public class SinhVien {
		private int maSV;
		private String hoDem,ten,gTinh;
		private String ngSinh;
		static Scanner sc = new Scanner(System.in);
		public void display() {
			System.out.printf("%-10d %-20s %-9s %10s %n", this.maSV, this.hoTen(), this.gTinh, this.ngSinh );
		}
		public String hoTen() {
			return this.hoDem +" "+ this.ten;
		}

		public SinhVien(int maSV, String hoDem, String ten, String gTinh, String ngSinh) {
			super();
			this.maSV = maSV;
			this.hoDem = hoDem;
			this.ten = ten;
			this.gTinh = gTinh;
			this.ngSinh = ngSinh;
		}
		public SinhVien() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getMaSV() {
			return maSV;
		}
		public void setMaSV(int maSV) {
			this.maSV = maSV;
		}
		public String getHoDem() {
			return hoDem;
		}
		public void setHoDem(String hoDem) {
			this.hoDem = hoDem;
		}
		public String getTen() {
			return ten;
		}
		public void setTen(String ten) {
			this.ten = ten;
		}
		public String getgTinh() {
			return gTinh;
		}
		public void setgTinh(String gTinh) {
			this.gTinh = gTinh;
		}
		public String getNgSinh() {
			return ngSinh;
		}
		public void setNgSinh(String ngSinh) {
			this.ngSinh = ngSinh;
		}
		
}
