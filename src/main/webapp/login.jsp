<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<html>
	<head>
		<title>��¼ҳ��</title>		
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
					<a href="/fruitscity/toAddGoods">�����Ʒ��</a> |
					<a href="/fruitscity/toManageGoods">������Ʒ��</a> |
					<a href="/fruitscity/toManageOrders">��������</a> |
					<a href="/fruitscity/logOut?type=adminlogout">ע��</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">��ӭ����${sessionScope.admin.loginName }</font>
					</s:if>
				</td>
			</tr>
			<tr>
				<td valign="top" >
					<p>
					  
						<img src="images/left_top.jpg" width="600" height="100" border="0"  />	
									
				</td>
				<td valign="top" width="100%">
				  
					<img src="images/001.jpg" width="600" height="100" style="width "/>
					
					<br />
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>
					<div style="background-color:#FFCC99;" align="center">
						ˮ����ϵͳ�û���ֱ�ӵ�¼
					</div>
					<br>
					<br />
					
					<s:if test="#parameters.role[0]=='user'">
					<form action="validateLogin?type=userlogin" method="post" name="ufrm">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td width="74">
									�û�����
								</td>
								<td width="189">
									<input type="text" name="loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									��  �룺
								</td>
								<td>
									<input type="password" name="loginPwd" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									<input type="submit" name="login" value="�� ¼" />
								</td>
							</tr>
						</table>
					</form>
					</s:if>
					
				
					<s:if test="#parameters.role[0]=='admin'"> 
					<form action="validateLogin?type=adminlogin" method="post" name="afrm">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td width="74">
									��¼����
								</td>
								<td width="189">
									<input type="text" name="loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									��  �룺
								</td>
								<td>
									<input type="password" name="loginPwd" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									<input type="submit" name="login" value="�� ¼" />
								</td>
							</tr>
							
							<tr>
								<td colspan="2">
									
								</td>
							</tr>
							
						</table>
					</form>					
					</s:if>					
				</td>
				
				
					
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>					
					<br>
					<br>
				</td>
				
					
			</tr>
		</table>
	</body>
</html>
