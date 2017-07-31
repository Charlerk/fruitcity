<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri='/struts-tags' prefix='s' %>

<html>
	<head>
		<title>��������</title>       
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
				<td valign="top" align="center">
					<p>
						<img src="images/left_top.jpg" width="470" height="100" />
						<br>
						<img src="images/003.gif" width="191" height="8">
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="470" height="100" />
					<br />
					<div align="left">
				      <s:form theme="simple" method="post" action="toManageOrders">
		                <s:label value="�����ţ�" />
		        	    <s:textfield name="orders.oid" />
						<s:label value="����״̬��" />
		        	    <s:select list="#{'ȫ��':'ȫ��','δ����':'δ����','�Ѵ���':'�Ѵ���'}" name="orders.orderState" listKey="key" listValue="value" />
		        	    <s:submit value="��ѯ" />						
					  </s:form>
					</div>
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>					
					<br />
					<img src="images/icon_order.gif" align="top" />
					�����б�
					<br />
					<hr />
					<table align="center" width="95%" cellspacing="0" cellpadding="3"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>�������</td>
							<td>����ʱ��</td>
							<td>����״̬</td>
							<td>�ܶ�</td>
							<td>����</td>
						</tr>				
						<s:set var="total" value="0" />								
						<s:iterator id="orders" value="#request.ordersList">
						<tr style="background-color:#FFFFFF;">						  
							<td>								
								<s:property value="oid"/>
							</td>
							<td>								
								<s:date name="orderTime" format="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<s:property value="orderState"/>
							</td>
							<td>
								<s:property value="orderPrice"/>
							</td>							
							<td>
							    <s:if test="#orders.orderState=='δ����'">
								  <a href="/fruitscity/handleOrders?oid=${oid}"><img src="images/handle.gif"
								width="12" height="12" /></a>
								</s:if>
							</td>
						</tr>										    			
						</s:iterator>
						
						<!-- ��ҳ�����ӿ�ʼ -->
						<table align="right">
	  <tr>
		<td width="130"></td>
		<td width="80">
			<s:if test="pager.curPage>1">
				<A href='/fruitscity/toManageOrders?pager.curPage=1&orders.oid=${requestScope.oid}&orders.orderState=${requestScope.orderState}'>��ҳ</A>&nbsp;&nbsp;
				<A href='/fruitscity/toManageOrders?pager.curPage=${pager.curPage-1 }&orders.oid=${requestScope.oid}&orders.orderState=${requestScope.orderState}'>��һҳ</A>
			</s:if>
		</td>
		<td width="80">
			<s:if test="pager.curPage < pager.pageCount">
				<A href='/fruitscity/toManageOrders?pager.curPage=${pager.curPage+1}&orders.oid=${requestScope.oid}&orders.orderState=${requestScope.orderState}'>��һҳ</A>&nbsp;&nbsp;
				<A href='/fruitscity/toManageOrders?pager.curPage=${pager.pageCount }&orders.oid=${requestScope.oid}&orders.orderState=${requestScope.orderState}'>βҳ</A>
			</s:if>
		</td>
		<td>��${pager.rowCount}��¼����${pager.curPage}/${pager.pageCount}ҳ&nbsp;&nbsp;
		
		</td>
	  </tr>
	</table>
						
						<!-- ��ҳ�����ӽ���-->
						
					</table>
					<br />
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>	
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
