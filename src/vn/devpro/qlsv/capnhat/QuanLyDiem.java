package vn.devpro.qlsv.capnhat;

import java.util.ArrayList;
import java.util.Scanner;


public class QuanLyDiem {
	private static ArrayList<Diem> list = new ArrayList<Diem>();
	
	public static ArrayList<Diem> getList() {
		return list;
	}

	public static void setList(ArrayList<Diem> list) {
		QuanLyDiem.list = list;
	}
	public static void init() {
		// TODO Auto-generated method stub
		list.add( new Diem(QuanLySinhVien.getList().get(1).getMaSV(), 
				QuanLyMonHoc.getList().get(1).getMa(), 5.3));
		
		list.add( new Diem(QuanLySinhVien.getList().get(0).getMaSV(), 
				QuanLyMonHoc.getList().get(1).getMa(), 8.3));
		
		list.add( new Diem(QuanLySinhVien.getList().get(1).getMaSV(), 
				QuanLyMonHoc.getList().get(1).getMa(), 7.3));
		
		list.add( new Diem(QuanLySinhVien.getList().get(1).getMaSV(), 
				QuanLyMonHoc.getList().get(3).getMa(), 8.3));
		
	}
	private static Scanner sc = new Scanner(System.in); 
	public static void thucThi() {
		// TODO Auto-generated method stub
		do {
			System.out.println("\n===========CAP NHAT THONG TIN DIEM============");
			System.out.println("Moi ban lua chon mot yeu cau cap nhat");
			System.out.println("\t1. Them diem");
			System.out.println("\t2. Sua diem");
			System.out.println("\t3. Xoa mon hoc cua sinh vien");
			System.out.println("\t4. Xem");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: them(); break;
			case 2: sua(); break;
			case 3: xoa(); break;
			case 4: xem(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		}while (true);
	}

	private static void xem() {
		// TODO Auto-generated method stub
		for(Diem x: list) {
			x.display();	
		}
	}

	private static void them() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------THEM DIEM----------------");
		
		System.out.print("\tNhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		if (QuanLySinhVien.indexOf(maSV) == -1) {
			System.out.println("\tKhong tim thay thong tin sinh vien da nhap!");
			return;
		}
		System.out.print("\tNhap ma mon hoc: ");
		int maMH = Integer.parseInt(sc.nextLine());
		if (QuanLyMonHoc.indexOf(maMH) == -1) {
			System.out.println("\tKhong tim thay thong tin mon hoc da nhap!");
			return;
		}
		/*sv học 1 lần 1 môn >> ko nhập lại nếu đã có điểm 
		 * thêm cho sv có trong ds sv
		 * thêm cho mon học có trong danh sách môn học 
		 */
		if(pointOf(maSV, maMH) > 0 ){
			System.out.println("\tSinh vien da co diem cua mon hoc nay");
			return;
		}
		double diem;
		do {
		System.out.print("\tNhap diem: ");
		diem = Double.parseDouble(sc.nextLine()) ;
		}while (diem < 0 || diem > 10);
		Diem d = new Diem(maSV, maMH, diem);
		list.add(d);
		System.out.println("\tThem diem thanh cong!");
	}
	//không sửa mã chỉ sửa điểm
	private static void sua() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------SUA DIEM----------------");
		
		System.out.print("\tNhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		if (QuanLySinhVien.indexOf(maSV) == -1) {
			System.out.println("\tKhong tim thay thong tin sinh vien da nhap!");
			return;
		}
		System.out.print("\tNhap ma mon hoc: ");
		int maMH = Integer.parseInt(sc.nextLine());
		if (QuanLyMonHoc.indexOf(maMH) == -1) {
			System.out.println("\tKhong tim thay thong tin mon hoc da nhap!");
			return;
		}
		int index = indexOf(maSV, maMH);
		if(pointOf(maSV, maMH) == -1 ){
			System.out.println("\tSinh vien chua hoc mon hoc nay!");
		}
		double diem;
		do {
		System.out.print("\tNhap diem: ");
		diem = Double.parseDouble(sc.nextLine()) ;
		}while (diem < 0 || diem > 10);
		list.get(index).setDiem(diem);
		System.out.println("Sua diem thanh cong!");
	}

	private static void xoa() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------XOA DIEM----------------");
		
		System.out.print("\tNhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		if (QuanLySinhVien.indexOf(maSV) == -1) {
			System.out.println("\tKhong tim thay thong tin sinh vien da nhap!");
			return;
		}
		System.out.print("\tNhap ma mon hoc: ");
		int maMH = Integer.parseInt(sc.nextLine());
		if (QuanLyMonHoc.indexOf(maMH) == -1) {
			System.out.println("\tKhong tim thay thong tin mon hoc da nhap!");
			return;
		}
		int index = indexOf(maSV, maMH);
		if(list.get(index).getDiem() == -1 ){
			System.out.println("\tSinh vien chua hoc mon hoc nay!");
			return;
		}
		list.remove(index);
	}
	//hàm tìm chỉ số mảng từ masv va mamh 
	public static int indexOf(int maSV, int maMH) {
		// TODO Auto-generated method stub
		for(int index = 0; index < list.size(); index++) 
				if (list.get(index).getMaSV() == maSV && list.get(index).getMaMH() == maMH)
					return index;
			return -1;
	}
	public static double pointOf(int maSV, int maMH) {
		// TODO Auto-generated method stub
		for(Diem x: list) 
				if (x.getMaSV() == maSV &&  x.getMaMH() == maMH)
					return x.getDiem();
			return -1;
	}
	//hàm tìm chỉ số của mã sv xuất hiện đầu tiên
	public static int indexOfSV(int maSV) {
		// TODO Auto-generated method stub
		for(int index = 0; index < list.size(); index++) 
				if (list.get(index).getMaSV() == maSV)
					return index;
			return -1;
	}
	
	//hàm tìm chỉ số của mã mh xuất hiện đầu tiên
	public static int indexOfMH(int maMH) {
		// TODO Auto-generated method stub
		for(int index = 0; index < list.size(); index++) 
				if (list.get(index).getMaMH() == maMH)
					return index;
			return -1;
	}
	
	public static double tongKet(int mamh, int masv) {
		int index = QuanLyMonHoc.indexOf(mamh);
		double diem = pointOf(masv, mamh);
		return QuanLyMonHoc.getList().get(index).getHeSo() * diem;
		
	}
	
	//tính điểm trung bình chung của môn học 
	public static double tBC(int ma) {
		double tong = 0;
		int dem = 0;
		for (Diem x: list) {
			if(x.getMaMH() == ma){
				tong += tongKet(x.getMaMH(),x.getMaSV());
				dem++;
			}
		}
		if(dem == 0)
			return 0;
		return tong/dem;
	}
	
}
