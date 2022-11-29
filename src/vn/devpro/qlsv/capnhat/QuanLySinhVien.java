package vn.devpro.qlsv.capnhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class QuanLySinhVien {
	private static int autoNumber = 100;	
	private static ArrayList<SinhVien> list = new ArrayList<>();
	public static ArrayList<SinhVien> getList() {
		return list;
	}
	public static void setList(ArrayList<SinhVien> list) {
		QuanLySinhVien.list = list;
	}
	public static void init() {
		list.add(new SinhVien(autoNumber++, "Tran", "Trang","Nu", "12/07/2001"));
		list.add(new SinhVien(autoNumber++, "Ngo", "Tra","Nam", "15/04/2001"));
		list.add(new SinhVien(autoNumber++, "Nguyen Thu", "Huong","Nu", "12/10/2002"));
	}
	
	static Scanner sc = new Scanner(System.in);
	
	public static void thucThi() {
		do {
			System.out.println("\n===========CAP NHAT THONG TIN SINH VIEN============");
			System.out.println("Moi ban lua chon mot yeu cau cap nhat");
			System.out.println("\t1. Them moi sinh vien");
			System.out.println("\t2. Sua thong tin sinh vien");
			System.out.println("\t3. Xoa sinh vien");
			System.out.println("\t4. Hien thi danh sach sinh vien");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: them(); break;
			case 2: sua(); break;
			case 3: xoa(); break;
			case 4: hienThi(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		}while (true);
	}

	private static void them() {
		// TODO Auto-generated method stub
		System.out.println("\n----------THEM MOI MOT SINH VIEN VAO DANH SACH---------");
		System.out.print("Nhap Ho dem: ");
		String hoDem = sc.nextLine();
		if (hoDem.trim().length() == 0) {
			System.out.println("Ho dem sinh vien khong duoc de trong");
			return;
		}
		System.out.print("Nhap ten: ");
		String ten = sc.nextLine();
		if (ten.trim().length() == 0) {
			System.out.println("Ten sinh vien khong duoc de trong");
			return;
		}
		System.out.print("Nhap gioi tinh: ");
		String gTinh = sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		String ngSinh = sc.nextLine();
		SinhVien sv = new SinhVien(autoNumber++, hoDem, ten, gTinh, ngSinh);
		list.add(sv);
		System.out.println("Them moi thanh cong, chon 4 de xem lai danh sach!");
	}
	private static void sua() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------SUA THONG TIN SINH VIEN-------------");
		
		System.out.print("\tNhap ma (id) sinh vien can sua: ");
		int ma = Integer.parseInt(sc.nextLine());
		int index = indexOf(ma);
		if (index == -1) {
			System.out.println("\tSinh vien khong co trong danh sach");
			return;
		}
		System.out.println("\tNhap lai thong tin can sua: ");
		System.out.print("Nhap Ho dem: ");
		String hoDem = sc.nextLine();
		System.out.print("Nhap ten: ");
		String ten = sc.nextLine();
		System.out.print("Nhap gioi tinh: ");
		String gTinh = sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		String ngSinh = sc.nextLine();
		if (hoDem.trim().length() != 0) {
			list.get(index).setHoDem(hoDem);
		}
		if (ten.trim().length() != 0) {
			list.get(index).setTen(ten);
		}
		if (gTinh.trim().length() != 0) {
			list.get(index).setgTinh(gTinh);
		}
		if (hoDem.trim().length() != 0) {
			list.get(index).setNgSinh(ngSinh);
		}
		
		System.out.println("\tSua thong tin sinh vien thanh cong!");
	}
	private static void xoa() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------XOA SINH VIEN-------------");
		
		System.out.print("\tNhap ma (id) sinh vien can xoa: ");
		int ma = Integer.parseInt(sc.nextLine());
		
		//Can ham tim id trong dssv
		int index = indexOf(ma);
		if (index == -1) {
			System.out.println("\tSinh vien khong co trong danh sach");
			return;
		}
		// kiểm tra list diem
		if (QuanLyDiem.indexOfSV(ma) != -1 ) {
			System.out.println("\nKhong the xoa sinh vien nay!");
			return;
		}
		
		list.remove(index);
		System.out.println("\tXoa sinh vien thanh cong!");
	}
	
	
	
	private static void hienThi() {
		// TODO Auto-generated method stub
		sapXep();
		System.out.println("\n----------------------DANH SACH SINH VIEN-------------------------");
		System.out.printf("%3s %-10s %-20s %-9s %10s %n","STT", "Ma SV","Ho va Ten","Gioi Tinh","Ngay Sinh" );
		int stt = 1;
		for (SinhVien x : list) {
			System.out.printf("%-3d ", stt++);
			x.display();
		}
	}
	//Hàm sắp xếp tên theo thứ tự
	public static void sapXep() {
		Collections.sort(list, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.hoTen().trim().compareToIgnoreCase(o2.hoTen().trim());
			}
		});
	}
	
	
	//Ham tim sinh vien trong ds theo id va tra ve index (-1 neu khong co)
		public static int indexOf(int ma) {
			for (int index = 0; index < list.size(); index++) 
				if (list.get(index).getMaSV() == ma)
					return index;
			return -1;
		}
		
		//Ham nhan id va tra ve ho ten sinh vien, khong co tra ve xau rong
			public static String nameOf(int ma) {
				for (SinhVien x : list) 
					if (x.getMaSV() == ma)
						return x.hoTen();
				return null;
			}
}
