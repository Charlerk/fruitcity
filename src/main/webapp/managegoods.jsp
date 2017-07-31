<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri='/struts-tags' prefix='s' %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>管理商品名</title>
		<link rel="stylesheet" href="/fruitscity/css/styles.css" type="text/css" />
	</head>

	<body>
		<table width="95%" height="170" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td width="200" height="101">
					<img src="images/jb_logo.jpg" width="64" height="32" />
					<strong><span
						style="font-size: 20px;">水果城系统</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|
					<a href="/fruitscity/toShowGoods">网站首页</a> |
					<s:if test="(#session.admin==null) && (#session.user==null)">					
					<a href="register.jsp">用户注册</a> |
					<a href="login.jsp?role=user">用户登录</a> |
					<a href="login.jsp?role=admin">管理员登录</a> |
					</s:if>
					<s:if test="#session.user!=null">
					<a href="modifyMyInfo.jsp">修改个人信息</a> |
					<a href="shopCart.jsp">我的购物车</a> |
					<a href="/fruitscity/toMyOrders">我的订单</a> |
					<a href="/fruitscity/logOut?type=userlogout">注销</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">欢迎您：${sessionScope.user.trueName }</font>					
					</s:if>
					<s:if test="#session.admin!=null">
					<a href="/fruitscity/toAddGoods">添加商品名</a> |
					<a href="/fruitscity/toManageGoods">管理商品名</a> |
					<a href="/fruitscity/toManageOrders">订单处理</a> |
					<a href="/fruitscity/logOut?type=adminlogout">注销</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">欢迎您：${sessionScope.admin.loginName }</font>
					</s:if>
					
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
					<p>
						<img src="images/left_top.jpg" width="470" height="100" />
						<br>
						<img src="images/003.gif" width="191" height="8">
						<!-- 商品分类循环开始 -->
					    <s:iterator id="goodsSeries" value="#request.goodsSeriesList">
						<br>
						<a href="/fruitscity/toManageGoods?goods.goodsseries.seriesId=${goodsSeries.seriesId}">${goodsSeries.seriesName }</a>
						<br>
						</s:iterator>
						<!-- 商品分类循环结束 -->
						
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="470" height="100" />
					<br />
					<div align="left">
				      <s:form theme="simple" method="post" action="toManageGoods">
				                <s:label value="输入商品名：" />
				        	    <s:textfield name="goods.goodsName" />
								<s:hidden name="goods.goodsseries.seriesId" value="%{#request.seriesId}"  />
								<s:submit value="查询" />
						
					  </s:form>
					</div>
					<br />
					<div style="background-image: url(images/004.gif)">
						&nbsp;
					</div>
					<br><br>
					<table width="75%" cellspacing="0" cellpadding="4" align="center"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>
								商品分类
							</td>
							<td>
								商品名
							</td>
							<td>
								摘要
							</td>
							<td>
								价格
							</td>	
							<td>
								修改
							</td>		
							<td>
								删除
							</td>					
						</tr>						
						<s:iterator id="goodsItem" value="#request.goodsList" status="st">
						<tr>							
							<td>
								<s:property value="goodsseries.seriesName"/>
							</td>
							<td>
								<s:property value="goodsName"/>
							</td>
							<td>
								<s:property value="goodsSummarize"/>
							</td>
							<td>
								<s:property value="goodsPrice"/>
							</td>	
							<td>
							    <a href="/fruitscity/toUpdateGoods?goods.goodsId=${goodsItem.goodsId}">修改</a>								
							</td>	
							<td>
								<a href="/fruitscity/deleteGoods?goods.goodsId=${goodsItem.goodsId}">删除</a>
							</td>				
						</tr>						
						</s:iterator>
						
						<!-- 分页超链接开始 -->
						<table align="right">
	  <tr>
		<td width="130"></td>
		<td width="80">
			<s:if test="pager.curPage>1">
				<A href='/fruitscity/toManageGoods?pager.curPage=1&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>首页</A>&nbsp;&nbsp;
				<A href='/fruitscity/toManageGoods?pager.curPage=${pager.curPage-1 }&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>上一页</A>
			</s:if>
		</td>
		<td width="80">
			<s:if test="pager.curPage < pager.pageCount">
				<A href='/fruitscity/toManageGoods?pager.curPage=${pager.curPage+1}&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>下一页</A>&nbsp;&nbsp;
				<A href='/fruitscity/toManageGoods?pager.curPage=${pager.pageCount }&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>尾页</A>
			</s:if>
		</td>
		<td>共${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;
		
		</td>
	  </tr>
	</table>
						
						<!-- 分页超链接结束-->
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
