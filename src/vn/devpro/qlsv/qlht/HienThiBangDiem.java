package vn.devpro.qlsv.qlht;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.qlsv.capnhat.Diem;
import vn.devpro.qlsv.capnhat.MonHoc;
import vn.devpro.qlsv.capnhat.QuanLyDiem;
import vn.devpro.qlsv.capnhat.QuanLyMonHoc;
import vn.devpro.qlsv.capnhat.QuanLySinhVien;
import vn.devpro.qlsv.capnhat.SinhVien;


public class HienThiBangDiem {
	//Hiển thị theo mã môn học
	// Hiển thị theo mã sinh viên
	
	static Scanner sc = new Scanner(System.in);
	public static void thucThi() {
		// TODO Auto-generated method stub
		do {
			System.out.println("\n----------------HIEN THI BANG DIEM------------------");
			System.out.println("\t1. Hien thi theo tung sinh vien");
			System.out.println("\t2. Hien thi theo tung mon hoc");
			System.out.println("\t0.	Quay lai");
			System.out.print("Nhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1: theoSV();
			case 2: theoMH();
			case 0: return;
			default:	System.out.println("\nLua chon cua ban khong hop le!");
			}
		}while (true);
	}
	
	private static void theoSV() {
		// TODO Auto-generated method stub
		//QuanLySinhVien.sapXep();
		ArrayList<SinhVien> listSV = QuanLySinhVien.getList();
		ArrayList<Diem> listD = QuanLyDiem.getList() ; 
		for(SinhVien x: listSV) {
			
			int dem = 0;
			System.out.println("Ma SV: "+ x.getMaSV()+"\t\tTen SV: "+ x.hoTen());
			System.out.println("\t\t\tDANH SACH CAC MON HOC");
			System.out.printf("%-50s %4s %13s\n","Ten mon hoc", "Diem", "Diem tong ket");
			for(Diem y: listD) {
				if (x.getMaSV() == y.getMaSV()) {
					System.out.printf("%-50s %4.2f %13.2f\n",QuanLyMonHoc.nameOf(y.getMaMH()), y.getDiem(),
							QuanLyDiem.tongKet(y.getMaMH(),y.getMaSV()));	
					dem++;
				}
			}
			if(dem == 0) System.out.println("Sinh vien chua tham gia hoc mon nao!");
			System.out.println("\n-------------------------------------------------------");
		}
	}
	private static void theoMH() {
		// TODO Auto-generated method stub
		ArrayList<MonHoc> listMH = QuanLyMonHoc.getList();
		ArrayList<Diem> listD = QuanLyDiem.getList() ; 
		for(MonHoc x: listMH) {
			double tbc =  QuanLyDiem.tBC(x.getMa()) ;
			System.out.println("Ma MH: "+ x.getMa()+"\t\tTen MH: "+ x.getTen() );
			if(tbc == 0) {
				System.out.println("\nKhong co sinh vien tham gia mon hoc nay!");
				System.out.println("\n-------------------------------------------------------");
				continue; }
			System.out.println("\t\tDiem trung binh chung: "+ tbc);
			System.out.println("\t\tDANH SACH CAC SINH VIEN");
			System.out.printf("%-10s %-20s %4s\n","Ma SV", "Ho va ten", "Diem");
			for(Diem y: listD) {
				if (x.getMa() == y.getMaMH()) {
					System.out.printf("%-10s %-20s %4.2f\n",y.getMaSV(),
							QuanLySinhVien.nameOf(y.getMaSV()), y.getDiem());
				}
			}
			System.out.println("\n-------------------------------------------------------");
		}
	}

}
