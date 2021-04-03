<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	pageContext.setAttribute("root", basePath);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            竞赛管理系统
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${root}static/css/x-admin.css" media="all">
    </head>
    <body>
       
        <div class="x-body">
            
            <xblock>
            <button class="layui-btn" onclick="delAll()">
            <i class="layui-icon">&#xe605;</i>
            晋级
            </button>
            <span class="x-right" style="line-height:40px">共有数据：${count} 条</span>
            <a class="layui-btn"   href="javascript:location.replace(location.href);">
            <i class="layui-icon" >ဂ</i>
            刷新
            </a>
            </xblock>
            
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            获胜方<!-- <input type="checkbox" name="ids" id="all" > -->
                        </th>
                        <th>
                            队伍
                        </th>
                        <th>
                            比赛名称
                        </th>
                        <th>
                            队员1
                        </th>
                        <th>
                            队员2
                        </th>
                        <th>
                             队员3
                        </th>
                        <th>
                             队员4
                        </th>
                        <th>
                             队员5
                        </th>
                    </tr>
                </thead>    
                <tbody id="tbody-data">     
                    <c:forEach items="${zuduiinfo}" var="zuduiinfo" varStatus="stauts">
                    <input type="hidden" readonly="readonly" value="${zuduiinfo.fabuinfoid}" id="fabuinfoid">
					<tr>
						<td>
							<input type="checkbox" value="${zuduiinfo.id}" name="id">
                        </td>
                        <td>
							第${stauts.count}组
                        </td>
                        
						<td>
							<c:forEach items="${fabuinfo}" var="fabuinfo">
		                    	<c:if test="${zuduiinfo.fabuinfoid==fabuinfo.id }">
		                    		 ${fabuinfo.gamename}
		                    	</c:if>
	                        </c:forEach>
	                    </td>
						<td>
							<c:forEach items="${userinfo}" var="userinfo">
		                    	<c:if test="${zuduiinfo.emailid1==userinfo.emailid}">
		                    		 ${userinfo.name}
		                    	</c:if>
	                        </c:forEach>
	                    </td>
						<td>
							<c:forEach items="${userinfo}" var="userinfo">
		                    	<c:if test="${zuduiinfo.emailid2==userinfo.emailid}">
		                    		 ${userinfo.name}
		                    	</c:if>
	                        </c:forEach>
	                    </td>
						<td>
							<c:forEach items="${userinfo}" var="userinfo">
		                    	<c:if test="${zuduiinfo.emailid3==userinfo.emailid}">
		                    		 ${userinfo.name}
		                    	</c:if>
	                        </c:forEach>
	                    </td>
						<td>
							<c:forEach items="${userinfo}" var="userinfo">
		                    	<c:if test="${zuduiinfo.emailid4==userinfo.emailid}">
		                    		 ${userinfo.name}
		                    	</c:if>
	                        </c:forEach>
	                    </td>
						<td>
							<c:forEach items="${userinfo}" var="userinfo">
		                    	<c:if test="${zuduiinfo.emailid5==userinfo.emailid}">
		                    		 ${userinfo.name}
		                    	</c:if>
	                        </c:forEach>
	                    </td>     
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
        <div id="page"></div>
        <script src="${root}static/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${root}static/js/x-layui.js" charset="utf-8"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
        <script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              laydate = layui.laydate;//日期插件
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

              //以上模块根据需要引入
              /* laypage({
                  cont: 'page'
                  ,pages: 10
                  ,first: 1
                  ,last: 100
                  ,prev: '<em><</em>'
                  ,next: '<em>></em>'
                
            	}); */
              laypage({
                  cont: 'page'
                  ,pages: 10
                  ,first: 1
                  ,last: 100
                  ,prev: '<em><</em>'
                  ,next: '<em>></em>'
                
            	});
            });
            
            //批量晋级提交
             function delAll () {
            	var fabuinfoid=$("#fabuinfoid").val();
                var ids = [];
                // 获取选中的id
                $('tbody input').each(function(index, el) {
                    if($(this).prop('checked')){
                        ids.push($(this).val())
                    }
                });
                if(ids.length==0){
                    	layer.confirm('请选择要晋级的队伍')
                    }
                else{
                	layer.confirm('确认晋级？'/* +ids.toString() */,function(index){
                        //捉到所有被选中的，发异步进行删除
                        $.ajax({
                			   type: "post",
                			   url: "${root}ptyh/jinji.action?ids="+ids+"&fabuinfoid="+fabuinfoid,
                			   success: function(msg){
                		            if(msg.code==1){
                    		           /*  var obj1=JSON.stringify(msg.message.id);
                    		            console.log(obj1); */
                    		            
                    		            var obj=JSON.parse(msg.zd);//zuduiinfoend
                    		            
                    		            var obj1=JSON.parse(msg.fb);//fabuinfo
                    		            var obj2=JSON.parse(msg.us);//userinfo 
                    		            var n=0;
                    		            console.log(obj1);
                    		            let content = "";
                    		            for(var i=0;i<obj.length;i++){
                    		            	console.log(obj[i].fabuinfoid);
                    		            	console.log(obj[i].id);
                    		            	n=n+1;
                    		            	var gamename='';
                    		            	var emailname1='';
                    		            	var emailname2='';
                    		            	var emailname3='';
                    		            	var emailname4='';
                    		            	var emailname5='';
                    		            	
	                						for(var j=0;j<obj1.length;j++){
	                							 if(obj[i].fabuinfoid==obj1[j].id){
	                								 var d=obj1[j].gamename;
	                								 gamename=d;
		                						}
		                					};
		                					
		                					for(var j=0;j<obj2.length;j++){
	                							 if(obj[i].emailid1==obj2[j].emailid){
	                								 var d1=obj2[j].name;
	                								 emailname1=d1;
		                						}
		                					};
		                					
		                					for(var j=0;j<obj2.length;j++){
	                							 if(obj[i].emailid2==obj2[j].emailid){
	                								 var d2=obj2[j].name;
	                								 emailname2=d2;
		                						}
		                					};
		                					
		                					for(var j=0;j<obj2.length;j++){
	                							 if(obj[i].emailid3==obj2[j].emailid){
	                								 var d3=obj2[j].name;
	                								 emailname3=d3;
		                						}
		                					};
		                					
		                					for(var j=0;j<obj2.length;j++){
	                							 if(obj[i].emailid4==obj2[j].emailid){
	                								 var d4=obj2[j].name;
	                								 emailname4=d4;
		                						}
		                					};
		                					
		                					for(var j=0;j<obj2.length;j++){
	                							 if(obj[i].emailid5==obj2[j].emailid){
	                								 var d5=obj2[j].name;
	                								 emailname5=d5;
		                						}
		                					}; 
                    		            	content += "<input type=\"hidden\"  value=\""+obj[i].fabuinfoid+"\" id=\"fabuinfoid\">"+
                        		            	"<tr>"+
			                    							 "<td>"+
			                									"<input type=\"checkbox\" value=\""+obj[i].id+"\" name=\"id\">"+
			                                       			 "</td>"+
			                                       			"<td>"+
		                										"第"+n+"组"+
		                                       			 	"</td>"+
					                						 "<td>"+
					                						 	"<option value=\""+obj[i].id+"\">"+gamename+"</option>"+
					                						 "</td>"+
					                 						 "<td>"+
					                 						 	"<option value=\""+obj[i].emailid1+"\">"+emailname1+"</option>"+
					                 						 "</td>"+
					                 						 "<td>"+
					                 						 	"<option value=\""+obj[i].emailid2+"\">"+emailname2+"</option>"+
					                 						 "</td>"+
					                 						 "<td>"+
					                 							 "<option value=\""+obj[i].emailid3+"\">"+emailname3+"</option>"+
					                 						 "</td>"+
					                 						 "<td>"+
					                 						 	"<option value=\""+obj[i].emailid4+"\">"+emailname4+"</option>"+
					                 						 "</td>"+
					                 						 "<td>"+
					                 						 	"<option value=\""+obj[i].emailid5+"\">"+emailname5+"</option>"+
					                 						 "</td>"+     
					                 						/* "<td>"+obj[i].emailid1+"</td>"+                    
					                 						"<td>"+obj[i].emailid2+"</td>"+                    
					                 						"<td>"+obj[i].emailid3+"</td>"+                    
					                 						"<td>"+obj[i].emailid4+"</td>"+                    
					                 						"<td>"+obj[i].emailid5+"</td>"+   */                  
			                                    	 "</tr>"
					                 		
                    		            }
                    		            $("#tbody-data").html(content);
                    		            	//alert(obj[i]);
                    		            	//$("#").val(obj[i].id)
                        		     }
                		            else{
                		            	alert(msg.message);
                    		            }

                		            	// alert(msg.message);
                		            	 layer.close(layer.index);
                		            	 //window.location.href="${root}/ht/selBuildinfo.action";
                		            }
                			   
                			});
                		//阻止form表单的默认行为，比如刷新了下
                		return false;
                    });
                    }
                
             }
             /*添加*/
            function role_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }

             
            //编辑
            function role_edit (title,url,id,w,h) {
                x_admin_show(title,url,w,h);   
            }
            /*删除*/
            function role_del(obj,id){
			  layer.confirm('确认要删除吗？',function(index){
	                   //发异步删除数据
	                   $(obj).parents("tr").remove();
	                   layer.msg('已删除!',{icon:1,time:1000});
	               });
            }
            </script>
       <!--  <script type="text/javascript">
			//全选
			var oall=document.getElementById("all");
			var oid=document.getElementsByName("id");
			oall.onclick=function(){//勾选全选时
				for(var i=0;i<oid.length;i++){
					//所有的选择框和全选一致
					oid[i].checked=oall.checked;		
				}
			};
		</script> -->
    </body>
</html>