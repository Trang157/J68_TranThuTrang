package vn.devpro.qlsv.capnhat;

public class Diem {
		private   int maSV;
		private  int maMH;
		private  double diem;
		
		public  void display() {
			System.out.printf("%10d %10d %5.2f%n", maSV, maMH,diem);
		}
		
		
		public Diem(int maSV, int maMH, double diem) {
			super();
			this.maSV = maSV;
			this.maMH = maMH;
			this.diem = diem;
		}
		public int getMaSV() {
			return maSV;
		}
		public void setMaSV(int maSV) {
			this.maSV = maSV;
		}
		public int getMaMH() {
			return maMH;
		}
		public void setMaMH(int maMH) {
			this.maMH = maMH;
		}
		public double getDiem() {
			return diem;
		}
		public void setDiem(double diem) {
			this.diem = diem;
		}
		
		
}
