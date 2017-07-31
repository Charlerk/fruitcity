package com.fruitscity.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.fruitscity.biz.GoodsBiz;
import com.fruitscity.biz.GoodsSeriesBiz;
import com.fruitscity.entity.Goods;
import com.fruitscity.entity.Pager;
import org.apache.commons.io.FileUtils;

public class GoodsAction extends ActionSupport implements RequestAware {
	
	//����Goods�������ԣ����ڷ�װ������
	private Goods goods;	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	GoodsBiz goodsBiz;
	public void setGoodsBiz(GoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
	}
	GoodsSeriesBiz goodsSeriesBiz;	
	public void setGoodsSeriesBiz(GoodsSeriesBiz goodsSeriesBiz) {
		this.goodsSeriesBiz = goodsSeriesBiz;
	}
	//��ҳʵ����
	private Pager pager;
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	private File doc;                //��װ�ϴ��ļ�������
	private String docFileName;      //��װ�ϴ��ļ�����������
	private String docContentType;   //��װ�ϴ��ļ�����������
	
	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;		
	}
	
	//��ȡָ��ҳ�롢���ϲ�ѯ�����Ĳ�Ʒ�б���ת����Ʒ��ʾҳshow.jsp
	public String toShowGoods() throws Exception {		
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List goodsList=null;		
		if(goods!=null){  
			//goods��Ϊ�գ���ʾ���������˲�ѯ��������ʱ����ȡָ��ҳ�롢���ϲ�ѯ�����Ĳ�Ʒ�б�
			goodsList=goodsBiz.getGoodsByCondition(goods, curPage);
			//ͳ�Ʒ��ϲ�ѯ�����Ĳ�Ʒ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
			pager=goodsBiz.getPagerOfGoods(goods);
			//����ѯ��������request��Χ������Ϊ��ҳ�������еĲ���ֵ
			if((goods.getGoodsseries()!=null) && (goods.getGoodsseries().getSeriesId()!=null))
				request.put("seriesId", new Integer(goods.getGoodsseries().getSeriesId()) );
		    if((goods.getGoodsName()!=null) && !goods.getGoodsName().equals(""))
				request.put("goodsName", goods.getGoodsName());
		}else{    
			//goodsΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��Ĳ�Ʒ�б�
			goodsList=goodsBiz.getAllGoods(curPage);
			//��ȡ���в�Ʒ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
			pager=goodsBiz.getPagerOfGoods();
		}
		
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
		request.put("goodsList", goodsList);
		//��ȡ��ϵ�б�����request��Χ
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);		
		return "toShowGoods";
	}
	
	public String toShowDetails() throws Exception {		
		Goods aGoods=goodsBiz.getGoodsByGoodsId(goods.getGoodsId());
		request.put("aGoods", aGoods);		
		return "toShowDetails";
	}
	
	//��ȡ��ϵ�б���ת����Ӳ�ƷҳaddGoods.jsp
	public String toAddGoods() throws Exception {		
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);	
		return "addGoods";
	}
	
	//�ϴ���ƷͼƬ����Ӳ�Ʒ��Ϣ����ת��toShowGoods
	public String doAddGoods() throws Exception {
		if(docFileName!=null){     //�ж��Ƿ�ѡ�����ϴ�ͼƬ
			// �õ���ǰweb�����µ�uploadĿ¼���ڱ����ľ���·�������û������ļ�����ᴴ��        
		    String targetDirectory = ServletActionContext.getServletContext().getRealPath("/goodsimages");          
		    //�������ϴ��ļ�         
		    String targetFileName = generateFileName(docFileName);          
		    //��ָ��Ŀ¼�����ļ�          
		    File target = new File(targetDirectory, targetFileName);          
		    //��Ҫ�ϴ����ļ�copy��ȥ         
		    FileUtils.copyFile(doc, target); 		
			goods.setGoodsImage(targetFileName);
			goodsBiz.addGoods(goods);
		}		
		return "toShowGoods";
	}
	
	//�������ϴ��ļ�    
    public String generateFileName(String fileName){          
    	String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());          
    	int random = new Random().nextInt(10000);          
    	int position = fileName.lastIndexOf(".");          
    	String extension = fileName.substring(position);           
    	return formatDate + random + extension;      
    }    
    
    
    //��ȡָ��ҳ�롢���ϲ�ѯ�����Ĳ�Ʒ�б���ת����Ʒ����ҳmanagegoods.jsp
    public String toManageGoods() throws Exception {		
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List goodsList=null;		
		if(goods!=null){
			goodsList=goodsBiz.getGoodsByCondition(goods, curPage);
			pager=goodsBiz.getPagerOfGoods(goods);
			if((goods.getGoodsseries()!=null) && (goods.getGoodsseries().getSeriesId()!=null))
				request.put("seriesId", new Integer(goods.getGoodsseries().getSeriesId()) );
		    if((goods.getGoodsName()!=null) && !goods.getGoodsName().equals(""))
				request.put("goodsName", goods.getGoodsName());
		}else{
			goodsList=goodsBiz.getAllGoods(curPage);
			//��ȡ���в�Ʒ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
			pager=goodsBiz.getPagerOfGoods();
		}		
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		request.put("goodsList", goodsList);
		//��ȡ��ϵ�б�����request��Χ
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);		
		return "managegoods";
	}
    
    //��ȡҪ�޸ĵĲ�Ʒ���󣬴���request��Χ����ת����Ʒ��Ϣ�޸�ҳ
    public String toUpdateGoods() throws Exception {	
    	//��ȡҪ�޸ĵĲ�Ʒ���󣬴���request��Χ
    	Goods updatedGoods=goodsBiz.getGoodsByGoodsId(goods.getGoodsId());
    	request.put("updatedGoods", updatedGoods);		
    	//��ȡ��ϵ�б�����request��Χ
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);	
		return "updateGoods";
    }
    
    //ִ�в�Ʒ��Ϣ�޸ģ���ת��toShowGoods
    public String doUpdateGoods() throws Exception {	
    	if(docFileName!=null){
	    	// �õ���ǰweb�����µ�uploadĿ¼���ڱ����ľ���·�������û������ļ�����ᴴ��        
		    String targetDirectory = ServletActionContext.getServletContext().getRealPath("/goodsimages");          
		    //�������ϴ��ļ�         
		    String targetFileName = generateFileName(docFileName);          
		    //��ָ��Ŀ¼�����ļ�          
		    File target = new File(targetDirectory, targetFileName);          
		    //��Ҫ�ϴ����ļ�copy��ȥ         
		    FileUtils.copyFile(doc, target); 		
		    //�޸Ĳ�ƷͼƬ
			goods.setGoodsImage(targetFileName);
    	}
		//���²�Ʒ����
		goodsBiz.updateGoods(goods);
		return "toShowGoods";    	
    } 
    
    //����ɾ����Ʒ����������ת��toManageGoods
    public String deleteGoods() throws Exception {	
    	goodsBiz.deleteGoods(goods.getGoodsId());
    	return "toManageGoods";
    }
	
	
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public String getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	public String getDocContentType() {
		return docContentType;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}

}
