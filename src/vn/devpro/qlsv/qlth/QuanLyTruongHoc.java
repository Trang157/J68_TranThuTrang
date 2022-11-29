package vn.devpro.qlsv.qlth;

import java.util.Scanner;

import vn.devpro.qlsv.capnhat.QuanLyCapNhat;
import vn.devpro.qlsv.capnhat.QuanLyDiem;
import vn.devpro.qlsv.capnhat.QuanLyMonHoc;
import vn.devpro.qlsv.capnhat.QuanLySinhVien;
import vn.devpro.qlsv.qlht.HienThiBangDiem;
import vn.devpro.qlsv.qltk.QuanLyTimKiem;

public class QuanLyTruongHoc {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			QuanLySinhVien.init();
			QuanLyMonHoc.init();
			QuanLyDiem.init();
			do {
				System.out.println("\n===========CHUONG TRINH QUAN LY TRUONG HOC============");
				System.out.println("Moi ban lua chon mot chuc nang quan ly");
				System.out.println("\t1. Cap nhat thong tin");
				System.out.println("\t2. Hien thi bang diem");
				System.out.println("\t3. Tim kiem thong tin");
				System.out.println("\t0. Dong ung dung");
				
				System.out.print("Lua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: QuanLyCapNhat.thucThi(); break;
				case 2: HienThiBangDiem.thucThi(); break;
				case 3: QuanLyTimKiem.thuThi(); break;
				case 0: System.exit(0);
				default: System.out.println("Lua chon khong hop le");
				}
			}while (true);

		}
	}
