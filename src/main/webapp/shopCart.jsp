<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri='/struts-tags' prefix='s' %>

<html>
	<head>
		<title>���ﳵҳ��</title>
		<link rel="stylesheet" href="/fruitscity/css/styles.css" type="text/css" />		
	</head>

	<body>
		<table width="90%" height="629" border="0" cellpadding="0"
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
					<a href="/fruitscity/toAddGoods">�����Ʒ</a> |
					<a href="/fruitscity/toManageGoods">������Ʒ</a> |
					<a href="/fruitscity/toManageOrders">��������</a> |
					<a href="/fruitscity/logOut?type=adminlogout">ע��</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">��ӭ����${sessionScope.admin.loginName }</font>
					</s:if>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center" >
					<p>
						<img src="images/left_top.jpg" width="470" height="100" />
						<br>
						<img src="images/003.gif" width="191" height="8">
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="470" height="100" />
					<br />					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>
					
					<br />
					<img src="images/zdkf.jpg" align="top" />
					���Ĺ��ﳵ����������Ʒ
					<br />
					<hr />					
					<table align="center" width="95%" cellspacing="0" cellpadding="3"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>���</td>
							<td>��Ʒ����</td>
							<td>����</td>
							<td>����</td>
							<td>���</td>
							<td>ɾ��</td>
						</tr>				
						<s:set var="sumPrice" value="0"  />								
						<s:iterator id="cartItem" value="#session.cart">
						<tr style="background-color:#FFFFFF;">						  
							<td>								
								<s:property value="value.goods.goodsId"/>
							</td>
							<td>
								<s:property value="value.goods.goodsName"/>
							</td>
							<td>
								��<s:property value="value.goods.goodsPrice"/>
							</td>
							<td>								
								<input type="text"  value="${value.quantity}" size="10" 
								onchange="window.location='updateSelectedQuantity?goodsId=${value.goods.goodsId}&quantity='+this.value;">
							</td>
							<td>
								��<s:property value="value.quantity*value.goods.goodsPrice"/>
							</td>
							<td>
								<a href="deleteSelectedOrders?goodsId=${value.goods.goodsId}">ɾ��</a>							
							</td>
						</tr>	
						    <s:set var="sumPrice" value="#sumPrice+value.quantity*value.goods.goodsPrice" />						    			
						</s:iterator>				
						<tr style="background-color:#CCCCFF;">
							<td>
								�ϼ�
							</td>
							<td>
								-
							</td>
							<td>
								-
							</td>
							<td>
								-
							</td>
							<td>
								����<s:property value="#sumPrice"  /> 
								<s:set var="sumPrice" value="#sumPrice" scope="session" />
							</td>
							<td>
								-
							</td>
						</tr>					
					</table>
					
					<br />
					<table width="300" cellspacing="0" cellpadding="4" align="center"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>
								<a href="/fruitscity/clearCart">��չ��ﳵ</a>
							</td>
							<td>
								<a href="/fruitscity/toShowGoods">��������</a>
							</td>
							<td>
								<a href="/fruitscity/addOrders">���ɶ���</a>
							</td>
						</tr>
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
