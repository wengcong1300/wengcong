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
            荣耀电子竞技管理系统
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${root}static/css/x-admin.css" media="all">
        <style type="text/css">
        	#files{
			    position: absolute;
			    margin-top:60px;
			    left:38px;
			    opacity: 0; 
			}
			#btn{
				position: absolute;
				margin-top:60px;
				background: #FFF;
				left:38px;
			}
        </style>
    </head>
    
    <body>
        <div class="x-body">
        <form  id="insert">
           <input type="hidden"  name="id" value="${user.id}" class="id">
            <blockquote class="layui-elem-quote" style="height:80px">
                <img src="${dpinfo.touxiang}"  class="layui-circle" id="show"  style="width:50px;height:50px;float:left;border: 2px solid #A9B7B7;">
                 	 <label for="files">
					      <input type="button" id="btn"  value="选择头像"><span id="text"></span>
					      <input type="file" id="files" name="file"  onchange="changepic(this)">
					 </label>
                
                <dl style="margin-left:80px; color:#019688">
                <dd>个性签名：</dd>
                <dd style="margin-left:0"><input type="text" required="required"  name="jieshao" id="jieshao" value="${dpinfo.jieshao}"  class="layui-input"></dd>
              </dl>
            </blockquote>
            <div class="pd-20">
            
              <table  class="layui-table" lay-skin="line">
                <tbody>
                
                  <tr>
                    <th>用户名：</th>
                    <td><input type="text" readonly="readonly" required="required"  name="email" value="${user.email}" id="address" class="layui-input"></td>
                  </tr>
                  <tr>
                    <th  width="80">店铺名：</th>
                    <td><input type="text"  name="dpname" required="required" value="${dpinfo.dpname}" id="dpname" class="layui-input" ></td>
                  </tr>
                  
                  <tr>
                    <th  width="80">店铺地址：</th>
                    <td>
	                    <select id="d1"  class="layui-input" name="dpdizhi1">
						    <option  value=""></option>
			    		</select>
			    		<select id="d2"  class="layui-input" name="dpdizhi2">
						    <option value="" selected></option>
			    		</select>
			    		<select  id="d3"  class="layui-input" name="dpdizhi3">
					    	<option value="" selected></option>
			    		</select>
		    		</td>
                  </tr>
                 
                  <tr>
                    <th>手机号：</th>
                    <td><input type="text"  name="phone" required="required" value="${dpinfo.phone}" id="phone"  class="layui-input"></td>
                  </tr>
                  
                </tbody>
              </table>
              <div class="layui-form-item">
               <input type="submit" value="上传"  />  
                  <!-- <button class="layui-btn" type="submit" onclick="doUpload()">
                      修改
                  </button> -->
              </div>
              
            </div>
            </form>
        </div>
        <script src="${root}static/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${root}static/js/x-layui.js" charset="utf-8">
        </script>
        <script src="${root}static/js/jquery.min.js"></script>
		<script type="text/javascript">
		$("#insert").submit(function(){ 
		     var formData = new FormData($("#insert")[0]);  
		     var touxiang = formData.get("touxiang"); // 获取名字 */
		     $.ajax({  
		          url: '${root}tzs/sjxx/xiugaidpxinxi.action' ,  
		          type: 'POST',  
		          data: formData,  
		          async: false,  
		          cache: false,  
		          contentType: false,  
		          processData: false,  
		          success: function(msg){
					   if(msg.code==1){
						   alert(msg.message);
						   parent.$("#tou").load(window.parent.location.href+" #tou");
						   window.location.href="${root}tzs/sjxx/seldpxinxi.action";
						   }
					   else if(msg.code==-1){
						   alert(msg.message);
						   }
					   else{
						   alert(msg.message);
						   x_admin_close();
						   parent.$("#tou").load(window.parent.location.href+" #tou");
						   //parent.location.href=parent.location.href;
						   }
				   }
		     });  
		     return false;
		}) 

		</script>
		
        <script>
        $("#d1").focus(function(){ 
        	$.ajax({  
		          url: '${root}tzs/sjxx/todizhi1.action' ,  
		          type: 'POST',   
		          success: function(data){
		        	  var content = "";
		        	  console.log(data.length);
		        	  for(var i=0;i<data.length;i++){
		        		  content += 
			        		  "<option value='"+data[i].name+"'>"+data[i].name+"</option>";
			            }
		        	  //$("#d1").length=1;
		        	   $("#d1").empty().append(content);
		        	    var html=$("#d1"); 
		        	   

			           // $("#d1").html(content);
				   }
		     });  
        })
        
        $("#d2").focus(function(){ 
        	var d1=$("#d1").val();
        	if(d1!=0){
        		var params="d1="+d1;
	        	$.ajax({  
	        		  type: "POST",
	 			   	  url: "${root}tzs/sjxx/todizhi2.action",
	 			      data: params,  
			          success: function(data){
				          console.log(data);
				          console.log(data.length);
			        	  var content = "";
			        	  
			        	  for(var i=0;i<data.length;i++){
			        		  content += "<option value='"+data[i].name+"'>"+data[i].name+"</option>";
				            }
			        	  //$("#d2").length=1;
			        	  //$("#d2").empty();
			        	  $("#d2").empty().append(content);
			        	    var html=$("#d2");
			        	    		            
				           // $("#d1").html(content);
					   }
			     });  
	        }else{
	        	alert("请先选择前面地址");
			}
        })
        
        $("#d3").focus(function(){ 
        	var d1=$("#d1").val();
        	var d2=$("#d2").val();
        	var params="d2="+d2;
        	if(d1!=0&&d2!=0){
        		$.ajax({  
			          url: '${root}tzs/sjxx/todizhi3.action' ,  
			          type: 'POST',  
			          data: params, 
			          success: function(data){
			        	  var content = "";
			        	  console.log(data.length);
			        	  for(var i=0;i<data.length;i++){
			        		  content += "<option value='"+data[i].name+"'>"+data[i].name+"</option>";
				            }
			        	  //$("#d3").length=1;
			        	  //$("#d3").empty();
			        	  $("#d3").empty().append(content);
			        	    var html=$("#d3");
			        					            
				           // $("#d1").html(content);
					   }
			     });  
        	}else{
	        	alert("请先选择前面地址");
			}
        })
	        /* function dizhi1() {
	        	
	        	$.ajax({  
			          url: '${root}tzs/sjxx/todizhi1.action' ,  
			          type: 'POST',   
			          success: function(data){
			        	  var content = "";
			        	  console.log(data.length);
			        	  for(var i=0;i<data.length;i++){
			        		  content += 
				        		  "<option value='"+data[i].name+"'>"+data[i].name+"</option>";
				            }
			        	  $("#d1").length=1;
			        	   $("#d1").append(content);
			        	    var html=$("#d1"); 
			        	   
   
				           // $("#d1").html(content);
					   }
			     });  
	        } 
	        function dizhi2() {
	        	var d1=$("#d1").val();
	        	if(d1!=0){
	        		var params="d1="+d1;
		        	$.ajax({  
		        		  type: "POST",
		 			   	  url: "${root}tzs/sjxx/todizhi2.action",
		 			      data: params,  
				          success: function(data){
					          console.log(data);
					          console.log(data.length);
				        	  var content = "";
				        	  
				        	  for(var i=0;i<data.length;i++){
				        		  content += "<option value='"+data[i].name+"'>"+data[i].name+"</option>";
					            }
				        	  $("#d2").length=1;
				        	  //$("#d2").empty();
				        	  $("#d2").append(content);
				        	    var html=$("#d2");
				        	    		            
					           // $("#d1").html(content);
						   }
				     });  
		        }else{
		        	alert("请先选择前面地址");
				}
	        	
	        }

	        function dizhi3() {
	        	var d1=$("#d1").val();
	        	var d2=$("#d2").val();
	        	var params="d2="+d2;
	        	if(d1!=0&&d2!=0){
	        		$.ajax({  
				          url: '${root}tzs/sjxx/todizhi3.action' ,  
				          type: 'POST',  
				          data: params, 
				          success: function(data){
				        	  var content = "";
				        	  console.log(data.length);
				        	  for(var i=0;i<data.length;i++){
				        		  content += "<option value='"+data[i].name+"'>"+data[i].name+"</option>";
					            }
				        	  $("#d3").length=1;
				        	  //$("#d3").empty();
				        	  $("#d3").append(content);
				        	    var html=$("#d3");
				        					            
					           // $("#d1").html(content);
						   }
				     });  
	        	}else{
		        	alert("请先选择前面地址");
				}
	        }*/
        
        
	        function changepic(obj) {
	            //console.log(obj.files[0]);//这里可以获取上传文件的name
	            var newsrc=getObjectURL(obj.files[0]);
	            document.getElementById('show').src=newsrc;
	        }

	      //建立一個可存取到該file的url
	        function getObjectURL(file) {
	            var url = null ;
	            // 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已
	            if (window.createObjectURL!=undefined) { // basic
	                url = window.createObjectURL(file) ;
	            } else if (window.URL!=undefined) { // mozilla(firefox)
	                url = window.URL.createObjectURL(file) ;
	            } else if (window.webkitURL!=undefined) { // webkit or chrome
	                url = window.webkitURL.createObjectURL(file) ;
	            }
	            return url ;
	        }
        </script>
        
        
    </body>

</html>