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
            后台管理系统
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
    <div id="main" style="width: 600px;height:400px;"></div>
        <div class="x-body">
			  <div class="layui-form-item">
                  <button class="layui-btn"  onclick="doUpload()">
                      修改
                  </button> 
              </div>
        </div>
        <script src="${root}static/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${root}static/js/x-layui.js" charset="utf-8">
        </script>
        <script src="${root}static/js/echarts.min.js" charset="utf-8">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
		<script type="text/javascript">
		var myChart = echarts.init(document.getElementById('main'));
		
		function doUpload(){
			$.ajax({  
		          url: '${root}test.action' ,  
		          type: 'POST',  
		          //data: formData,  
		          dataType : 'json',
		          success: function(data){
		        	  //alert(jQuery.parseJSON(data).replies);
		        	 var data1= Object.keys(data);
		        	 var data2= Object.values(data);
		        	 
		        	  //alert(data1);
		        	  console.log(JSON.stringify(data));
		        	  let a = JSON.parse(JSON.stringify(data));
		              //alert(a.number);
		              option = {
		      			    xAxis: {
		      			        type: 'category',
		      			        data: data1
		      			    },
		      			    yAxis: {
		      			        type: 'value'
		      			    },
		      			    series: [{
		      			        data: data2,
		      			        type: 'bar',
		      			        showBackground: true,
		      			        backgroundStyle: {
		      			            color: 'rgba(180, 180, 180, 0.2)'
		      			        }
		      			    }]
		      			};
		      		myChart.setOption(option);
				  }
		     });  
		     return false;
		}
		</script>
		

        
        
    </body>

</html>