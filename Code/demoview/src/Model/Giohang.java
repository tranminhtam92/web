package Model;

import java.util.HashMap;
import java.util.Map;

public class Giohang {
	HashMap<String, Monhang> listitem;

	public Giohang() {
		listitem = new HashMap<>();
	}

	public HashMap<String, Monhang> getListitem() {
		return listitem;
	}

	public void setListitem(HashMap<String, Monhang> listitem) {
		this.listitem = listitem;
	}
	public void insertgiohang(String key,Monhang item){
		boolean bln = listitem.containsKey(key);
	       if (bln) {
	            int quantity_old = listitem.get(key).getSoluong();
	            item.setSoluong(quantity_old+item.getSoluong());
	            listitem.put(key, item);
	       } else {
	    	   listitem.put(key, item);
	       }
	}
	public void removegiohang(String key){
		//boolean bln = listitem.containsKey(key);
	      // if (bln) {
	           listitem.remove(key);
	       //}
	}
	public void changequantity(String key,int quantity){
	           listitem.get(key).setSoluong(quantity);
	       
	    
	}
	public int countitem(){
		return listitem.size();
	}
	public int totalprice(){
		int money=0;
		 for (Map.Entry<String, Monhang> list : listitem.entrySet()) {
	          
	           money+=list.getValue().getSoluong()*(list.getValue().getGia()-((list.getValue().getGia()*list.getValue().getKhuyenmai())/100));
	        }
		return money;
	}
	public static void main(String[] args){
		Giohang gh= new Giohang();
		gh.insertgiohang("ca", new Monhang("ca","ca cang",100,"aaaa",2,0));
		gh.insertgiohang("muc", new Monhang("muc","ca cang",100,"aaaa",5,0));
		gh.removegiohang("caa");
		  for (Map.Entry<String, Monhang> list : gh.getListitem().entrySet()) {
	          
	            System.out.println(list.getValue().getMasp());
	            System.out.println(list.getValue().getTensp());
	            System.out.println(list.getValue().getAnh());
	            System.out.println(list.getValue().getSoluong());
	        }
	}
	
}
