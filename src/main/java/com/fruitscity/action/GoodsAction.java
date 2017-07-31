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
	
	//定义Goods类型属性，用于封装表单参数
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
	//分页实体类
	private Pager pager;
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	private File doc;                //封装上传文件的属性
	private String docFileName;      //封装上传文件的名称属性
	private String docContentType;   //封装上传文件的类型属性
	
	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;		
	}
	
	//获取指定页码、符合查询条件的餐品列表，再转到餐品显示页show.jsp
	public String toShowGoods() throws Exception {		
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List goodsList=null;		
		if(goods!=null){  
			//goods不为空，表示表单中输入了查询条件，此时将获取指定页码、符合查询条件的餐品列表
			goodsList=goodsBiz.getGoodsByCondition(goods, curPage);
			//统计符合查询条件的餐品数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
			pager=goodsBiz.getPagerOfGoods(goods);
			//将查询条件存入request范围，将作为分页超链接中的参数值
			if((goods.getGoodsseries()!=null) && (goods.getGoodsseries().getSeriesId()!=null))
				request.put("seriesId", new Integer(goods.getGoodsseries().getSeriesId()) );
		    if((goods.getGoodsName()!=null) && !goods.getGoodsName().equals(""))
				request.put("goodsName", goods.getGoodsName());
		}else{    
			//goods为空，表示没有指定查询条件，此时将获取指定页码的餐品列表
			goodsList=goodsBiz.getAllGoods(curPage);
			//获取所有菜品数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
			pager=goodsBiz.getPagerOfGoods();
		}
		
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将查询获得的列表存入request范围
		request.put("goodsList", goodsList);
		//获取菜系列表，存入request范围
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);		
		return "toShowGoods";
	}
	
	public String toShowDetails() throws Exception {		
		Goods aGoods=goodsBiz.getGoodsByGoodsId(goods.getGoodsId());
		request.put("aGoods", aGoods);		
		return "toShowDetails";
	}
	
	//获取菜系列表，再转到添加餐品页addGoods.jsp
	public String toAddGoods() throws Exception {		
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);	
		return "addGoods";
	}
	
	//上传餐品图片、添加餐品信息，再转到toShowGoods
	public String doAddGoods() throws Exception {
		if(docFileName!=null){     //判断是否选择了上传图片
			// 得到当前web工程下的upload目录的在本机的绝对路径，如果没有这个文件夹则会创建        
		    String targetDirectory = ServletActionContext.getServletContext().getRealPath("/goodsimages");          
		    //重命名上传文件         
		    String targetFileName = generateFileName(docFileName);          
		    //在指定目录创建文件          
		    File target = new File(targetDirectory, targetFileName);          
		    //把要上传的文件copy过去         
		    FileUtils.copyFile(doc, target); 		
			goods.setGoodsImage(targetFileName);
			goodsBiz.addGoods(goods);
		}		
		return "toShowGoods";
	}
	
	//重命名上传文件    
    public String generateFileName(String fileName){          
    	String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());          
    	int random = new Random().nextInt(10000);          
    	int position = fileName.lastIndexOf(".");          
    	String extension = fileName.substring(position);           
    	return formatDate + random + extension;      
    }    
    
    
    //获取指定页码、符合查询条件的餐品列表，再转到菜品管理页managegoods.jsp
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
			//获取所有菜品数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
			pager=goodsBiz.getPagerOfGoods();
		}		
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		request.put("goodsList", goodsList);
		//获取菜系列表，存入request范围
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);		
		return "managegoods";
	}
    
    //获取要修改的餐品对象，存入request范围，再转到餐品信息修改页
    public String toUpdateGoods() throws Exception {	
    	//获取要修改的餐品对象，存入request范围
    	Goods updatedGoods=goodsBiz.getGoodsByGoodsId(goods.getGoodsId());
    	request.put("updatedGoods", updatedGoods);		
    	//获取菜系列表，存入request范围
		List goodsSeriesList=goodsSeriesBiz.getGoodsSeries();
		request.put("goodsSeriesList", goodsSeriesList);	
		return "updateGoods";
    }
    
    //执行餐品信息修改，再转到toShowGoods
    public String doUpdateGoods() throws Exception {	
    	if(docFileName!=null){
	    	// 得到当前web工程下的upload目录的在本机的绝对路径，如果没有这个文件夹则会创建        
		    String targetDirectory = ServletActionContext.getServletContext().getRealPath("/goodsimages");          
		    //重命名上传文件         
		    String targetFileName = generateFileName(docFileName);          
		    //在指定目录创建文件          
		    File target = new File(targetDirectory, targetFileName);          
		    //把要上传的文件copy过去         
		    FileUtils.copyFile(doc, target); 		
		    //修改餐品图片
			goods.setGoodsImage(targetFileName);
    	}
		//更新餐品对象
		goodsBiz.updateGoods(goods);
		return "toShowGoods";    	
    } 
    
    //处理删除餐品对象请求，再转到toManageGoods
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
