package vn.devpro.qlsv.capnhat;

import java.util.Scanner;


public class QuanLyCapNhat {
	static Scanner sc = new Scanner(System.in);
	public static void thucThi() {
		do {
			System.out.println("\n===========CAP NHAT THONG TIN HE THONG============");
			System.out.println("Moi ban lua chon mot chuc nang cap nhat");
			System.out.println("\t1. Cap nhat thong tin sinh vien");
			System.out.println("\t2. Cap nhat thong tin mon hoc");
			System.out.println("\t3. Cap nhat diem");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: QuanLySinhVien.thucThi(); break;
			case 2: QuanLyMonHoc.thucThi(); break;
			case 3: QuanLyDiem.thucThi(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		}while (true);
	}
}
