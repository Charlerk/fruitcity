package com.fruitscity.action;

import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.fruitscity.biz.GoodsBiz;
import com.fruitscity.biz.GoodsSeriesBiz;
import com.fruitscity.entity.CartItemBean;
import com.fruitscity.entity.Goods;

public class CartAction extends ActionSupport implements SessionAware {	
	//��װ���������Ĳ�Ʒ���goodsId����ֵ
	private Integer goodsId;
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}	
	public Integer getGoodsId() {
		return goodsId;
	}
	//��װ���������Ĳ�Ʒ����quantity����ֵ
	int quantity;	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	GoodsBiz goodsBiz;
	public void setGoodsBiz(GoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
	}
	GoodsSeriesBiz goodsSeriesBiz;	
	public void setGoodsSeriesBiz(GoodsSeriesBiz goodsSeriesBiz) {
		this.goodsSeriesBiz = goodsSeriesBiz;
	}
	Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	//����Ʒ��ӵ����ﳵ
	public String addtoshopcart() throws Exception {
		//��session��ȡ�����ﳵ������Map����cart��
		Map cart=(Map)session.get("cart");
		//��ȡ��ǰҪ��ӵ����ﳵ�Ĳ�Ʒ
		Goods goods=goodsBiz.getGoodsByGoodsId(goodsId);
		//������ﳵ�����ڣ��򴴽����ﳵ(ʵ����HashMap��)��������session��
		if(cart==null){
			cart=new HashMap();
			session.put("cart", cart);
		}
		//������ڹ��ﳵ�����жϲ�Ʒ�Ƿ��ڹ��ﳵ��
		CartItemBean cartItem=(CartItemBean)cart.get(goods.getGoodsId());
		if(cartItem!=null){
		    //�����Ʒ�ڹ��ﳵ�У�����������
			cartItem.setQuantity(cartItem.getQuantity()+1);
		}else{
			//���򣬴���һ����Ŀ��Map��
			cart.put(goods.getGoodsId(),new CartItemBean(goods,1));
		}
		//ҳ��ת��shopCart.jsp����ʾ���ﳵ
		return "shopCart";
	}	
	
	//��������
	public String updateSelectedQuantity() throws Exception {
		//��session��ȡ�����ﳵ������Map����cart��
	    Map cart=(Map)session.get("cart");
	    CartItemBean cartItem=(CartItemBean)cart.get(goodsId);
	    cartItem.setQuantity(quantity);
	    return "shopCart";
	}
	
	//�ӹ��ﳵ���Ƴ�ָ����Ŷ���
	public String deleteSelectedOrders() throws Exception {
		//��session��ȡ�����ﳵ������Map����cart��
	    Map cart=(Map)session.get("cart");
	    cart.remove(goodsId);
	    return "shopCart";
	}	
	
	//��չ��ﳵ
	public String clearCart() throws Exception {
		//��session��ȡ�����ﳵ������Map����cart��
	    Map cart=(Map)session.get("cart");
	    cart.clear();
	    return "shopCart";
	}	
	
}
