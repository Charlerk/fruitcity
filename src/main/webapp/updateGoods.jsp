<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�޸���Ʒ</title>
		<link rel="stylesheet" href="/fruitscity/css/styles.css" type="text/css" />
	</head>

	<body>
		<table width="90%" height="170" border="0" cellpadding="0"
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
					style="background-image: url(images/001.gif);" align="center">
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
				<td valign="top" align="center">
					<p>
						<img src="images/left_top.jpg" width="470" height="100" />
						<br>
						<img src="images/003.gif" width="191" height="8">
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="470" height="100" />
					<br />
					<div style="background-image: url(images/004.gif)">
						&nbsp;
					</div>
					<div style="background-color: #FFCC99;" align="center">
						�޸���Ʒ
					</div>
					<br />
					<s:form action="doUpdateGoods" method="post" enctype="multipart/form-data">
						<table align="center">
						    <s:hidden name="goods.goodsId" value="%{#request.updatedGoods.goodsId}" />
							<s:textfield name="goods.goodsName" label="��Ʒ��" value="%{#request.updatedGoods.goodsName}" />
							<s:select name="goods.goodsseries.seriesId" label="��Ʒ����" value="%{#request.updatedGoods.goodsseries.seriesId}" list="#request.goodsSeriesList" listKey="seriesId" listValue="seriesName" />  
							<s:textfield name="goods.goodsSummarize" label="ժҪ" value="%{#request.updatedGoods.goodsSummarize}" />
							<s:textfield name="goods.goodsDescription" label="����" value="%{#request.updatedGoods.goodsDescription}" />
							<s:textfield name="goods.goodsPrice" label="�۸�" value="%{#request.updatedGoods.goodsPrice}"  />
							<s:hidden name="goods.goodsImage" value="%{#request.updatedGoods.goodsImage}" />
							<s:file name="doc" label="ͼƬ" />
							<s:submit value="ȷ��" align="center"/>
						</table>
					</s:form>
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
