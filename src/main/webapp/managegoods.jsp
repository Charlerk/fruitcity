<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri='/struts-tags' prefix='s' %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>������Ʒ��</title>
		<link rel="stylesheet" href="/fruitscity/css/styles.css" type="text/css" />
	</head>

	<body>
		<table width="95%" height="170" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td width="200" height="101">
					<img src="images/jb_logo.jpg" width="64" height="32" />
					<strong><span
						style="font-size: 20px;">ˮ����ϵͳ</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|
					<a href="/fruitscity/toShowGoods">��վ��ҳ</a> |
					<s:if test="(#session.admin==null) && (#session.user==null)">					
					<a href="register.jsp">�û�ע��</a> |
					<a href="login.jsp?role=user">�û���¼</a> |
					<a href="login.jsp?role=admin">����Ա��¼</a> |
					</s:if>
					<s:if test="#session.user!=null">
					<a href="modifyMyInfo.jsp">�޸ĸ�����Ϣ</a> |
					<a href="shopCart.jsp">�ҵĹ��ﳵ</a> |
					<a href="/fruitscity/toMyOrders">�ҵĶ���</a> |
					<a href="/fruitscity/logOut?type=userlogout">ע��</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">��ӭ����${sessionScope.user.trueName }</font>					
					</s:if>
					<s:if test="#session.admin!=null">
					<a href="/fruitscity/toAddGoods">�����Ʒ��</a> |
					<a href="/fruitscity/toManageGoods">������Ʒ��</a> |
					<a href="/fruitscity/toManageOrders">��������</a> |
					<a href="/fruitscity/logOut?type=adminlogout">ע��</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">��ӭ����${sessionScope.admin.loginName }</font>
					</s:if>
					
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
					<p>
						<img src="images/left_top.jpg" width="470" height="100" />
						<br>
						<img src="images/003.gif" width="191" height="8">
						<!-- ��Ʒ����ѭ����ʼ -->
					    <s:iterator id="goodsSeries" value="#request.goodsSeriesList">
						<br>
						<a href="/fruitscity/toManageGoods?goods.goodsseries.seriesId=${goodsSeries.seriesId}">${goodsSeries.seriesName }</a>
						<br>
						</s:iterator>
						<!-- ��Ʒ����ѭ������ -->
						
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="470" height="100" />
					<br />
					<div align="left">
				      <s:form theme="simple" method="post" action="toManageGoods">
				                <s:label value="������Ʒ����" />
				        	    <s:textfield name="goods.goodsName" />
								<s:hidden name="goods.goodsseries.seriesId" value="%{#request.seriesId}"  />
								<s:submit value="��ѯ" />
						
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
								��Ʒ����
							</td>
							<td>
								��Ʒ��
							</td>
							<td>
								ժҪ
							</td>
							<td>
								�۸�
							</td>	
							<td>
								�޸�
							</td>		
							<td>
								ɾ��
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
							    <a href="/fruitscity/toUpdateGoods?goods.goodsId=${goodsItem.goodsId}">�޸�</a>								
							</td>	
							<td>
								<a href="/fruitscity/deleteGoods?goods.goodsId=${goodsItem.goodsId}">ɾ��</a>
							</td>				
						</tr>						
						</s:iterator>
						
						<!-- ��ҳ�����ӿ�ʼ -->
						<table align="right">
	  <tr>
		<td width="130"></td>
		<td width="80">
			<s:if test="pager.curPage>1">
				<A href='/fruitscity/toManageGoods?pager.curPage=1&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>��ҳ</A>&nbsp;&nbsp;
				<A href='/fruitscity/toManageGoods?pager.curPage=${pager.curPage-1 }&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>��һҳ</A>
			</s:if>
		</td>
		<td width="80">
			<s:if test="pager.curPage < pager.pageCount">
				<A href='/fruitscity/toManageGoods?pager.curPage=${pager.curPage+1}&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>��һҳ</A>&nbsp;&nbsp;
				<A href='/fruitscity/toManageGoods?pager.curPage=${pager.pageCount }&goods.goodsseries.seriesId=${requestScope.seriesId}&goods.goodsName=${requestScope.goodsName}'>βҳ</A>
			</s:if>
		</td>
		<td>��${pager.rowCount}��¼����${pager.curPage}/${pager.pageCount}ҳ&nbsp;&nbsp;
		
		</td>
	  </tr>
	</table>
						
						<!-- ��ҳ�����ӽ���-->
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
