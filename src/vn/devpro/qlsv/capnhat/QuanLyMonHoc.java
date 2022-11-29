package vn.devpro.qlsv.capnhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyMonHoc {
	private static int autoId = 200;	
	private static ArrayList<MonHoc> list = new ArrayList<>();
	
	public static ArrayList<MonHoc> getList() {
		return list;
	}
	
	public static void setList(ArrayList<MonHoc> list) {
		QuanLyMonHoc.list = list;
	}
	public static void init() {
		// TODO Auto-generated method stub
		list.add(new MonHoc( autoId++ , "Quan ly du an", 1.3));
		list.add(new MonHoc( autoId++ , "Lap trinh Java", 1.4));
		list.add(new MonHoc( autoId++ , "Lap trinh NET", 2));
		list.add(new MonHoc( autoId++ , "Nhap mon cong nghe phan mem",  2.3));
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void thucThi() {
		// TODO Auto-generated method stub
		do {
			System.out.println("\n===========CAP NHAT THONG TIN MON HOC============");
			System.out.println("Moi ban lua chon mot yeu cau cap nhat");
			System.out.println("\t1. Them moi mon hoc");
			System.out.println("\t2. Sua thong tin mon hoc");
			System.out.println("\t3. Xoa mon hoc");
			System.out.println("\t4. Hien thi danh sach mon hoc");
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
		System.out.println("\n----------THEM MOI MOT MON HOC VAO DANH SACH---------");
		System.out.print("Nhap ten: ");
		String ten = sc.nextLine();
		if (ten.trim().length() == 0) {
			System.out.println("Ten mon hoc khong duoc de trong");
			return;
		}
		System.out.print("Nhap he so mon hoc: ");
		double heSo = Double.parseDouble(sc.nextLine()) ;
		//Khai bao mon hoc moi
		MonHoc mh = new MonHoc(autoId++, ten, heSo);
		// them mh vao list
		list.add(mh);
		System.out.println("Them moi thanh cong, chon 4 de xem lai danh sach!");
	}

	private static void sua() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------SUA THONG TIN MON HOC-------------");
		
		System.out.print("\tNhap ma (id) mon hoc can sua(20n): ");
		int ma = Integer.parseInt(sc.nextLine());
		int index = indexOf(ma);
		if (index == -1) {
			System.out.println("\tMon hoc khong co trong danh sach");
			return;
		}
		System.out.println("\tNhap lai thong tin can sua: ");
		System.out.print("Nhap ten: ");
		String ten = sc.nextLine();
		System.out.print("Nhap he so mon hoc: ");
		double heSo = Double.parseDouble(sc.nextLine()) ;
		if (ten.trim().length() != 0) {
			list.get(index).setTen(ten);
		}
		if (heSo >= 0) {
			list.get(index).setHeSo(heSo);
		}
		
		System.out.println("\tSua thong tin mon hoc thanh cong!");
	}

	
	private static void xoa() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------XOA MON HOC-------------");
		
		System.out.print("\tNhap ma (id) mon hoc can xoa: ");
		int ma = Integer.parseInt(sc.nextLine());
		
		//Can ham tim id trong dssv
		int index = indexOf(ma);
		if (index == -1) {
			System.out.println("\tmon hoc khong co trong danh sach");
			return;
		}
		// kiểm tra list diem
		if (QuanLyDiem.indexOfMH(ma) != -1 ) {
			System.out.println("\nKhong the xoa mon hoc nay!");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa mon hoc thanh cong!");
	}

	private static void hienThi() {
		// TODO Auto-generated method stub
		sapXep();
		int stt = 1;
		System.out.printf("%3s %-10s %-50s %5s%n","STT","Ma MH", "Ten MH", "He so" );
		for(MonHoc x: list) {
			System.out.printf("%-3d ",stt++);
			x.display();
		}
		
	}
	public static void sapXep() {
		Collections.sort(list, new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				// TODO Auto-generated method stub
				return o1.getTen().trim().compareToIgnoreCase(o2.getTen().trim());
			}
		});
	}
	
	// từ id trả về chỉ số của phần tử 
	public static int indexOf(int ma) {
		// TODO Auto-generated method stub
		for(int index = 0; index < list.size(); index++) 
				if (list.get(index).getMa() == ma)
					return index;
			return -1;
	}

	public static String nameOf(int ma) {
		for(MonHoc x: list) {
			if(x.getMa() == ma) return x.getTen();
		}
		return null;
	}
}
