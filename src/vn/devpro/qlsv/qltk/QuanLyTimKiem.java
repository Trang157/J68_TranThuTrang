package vn.devpro.qlsv.qltk;

import java.util.Scanner;

import vn.devpro.qlsv.capnhat.Diem;
import vn.devpro.qlsv.capnhat.MonHoc;
import vn.devpro.qlsv.capnhat.QuanLyDiem;
import vn.devpro.qlsv.capnhat.QuanLyMonHoc;
import vn.devpro.qlsv.capnhat.QuanLySinhVien;
import vn.devpro.qlsv.capnhat.SinhVien;

public class QuanLyTimKiem {
	static Scanner sc = new Scanner(System.in);
	public static void thuThi() {
		// TODO Auto-generated method stub
		do {
			System.out.println("\n----------------HIEN THI BANG DIEM------------------");
			System.out.println("\t1. Tim kiem theo ma sinh vien");
			System.out.println("\t2. Tim kiem theo ma mon hoc");
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
	private static void theoMH() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ma mon hoc can tim: ");
		int mamh = Integer.parseInt(sc.nextLine());
		int index = QuanLySinhVien.indexOf(mamh);
		if(index != -1 ) {
			int dem =0;
			MonHoc sv = QuanLyMonHoc.getList().get(index);
			System.out.println("Ma MH: "+ sv.getMa()+"\t\tTen MH: "+ sv.getTen());
			System.out.println("\tDANH SACH CAC SINH VIEN CUA MON HOC");
			System.out.printf("%-10s %-20s %4s\n","Ma SV", "Ho va ten", "Diem");
			for(Diem x: QuanLyDiem.getList()) {
				if(x.getMaSV() == mamh) {
					System.out.printf("%-10s %-20s %4.2f\n",x.getMaSV(),QuanLySinhVien.nameOf(x.getMaSV()),
							x.getDiem());
					dem++;
				}
			}
			if(dem == 0) System.out.println("Mon hoc chua co sinh vien  tham gia!");
		}else {
			System.out.println("Khong tim thay ket qua");
			}		
		}
	
	private static void theoSV() {
		// TODO Auto-generated method stub
		System.out.print("Nhap ma sinh vien can tim: ");
		int maSV = Integer.parseInt(sc.nextLine());
		int index = QuanLySinhVien.indexOf(maSV);
		if(index != -1 ) {
			int dem =0;
			SinhVien sv = QuanLySinhVien.getList().get(index);
			System.out.println("Ma SV: "+ sv.getMaSV()+"\t\tTen SV: "+ sv.hoTen());
			System.out.println("\tDANH SACH CAC MON HOC SINH VIEN DA THAM GIA");
			System.out.printf("%-50s %4s %13s\n","Ten mon hoc", "Diem", "Diem tong ket");
			for(Diem x: QuanLyDiem.getList()) {
				if(x.getMaSV() == maSV) {
					System.out.printf("%-50s %4.2f %13.2f\n",QuanLyMonHoc.nameOf(x.getMaMH()), 
							x.getDiem(), Diem.tongKet());
					dem++;
				}
			}
			if(dem == 0) System.out.println("Sinh vien chua tham gia hoc mon nao!");
		}else {
			System.out.println("Khong tim thay ket qua");
			}
		
		}
		
	}
