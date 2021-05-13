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
    <title>荣耀电子竞技管理系统</title>
    <script type="text/javascript" src="${root}static/js/jquery.js"></script>
    <script type="text/javascript" src="${root}static/js/echarts.min.js"></script>
    <script type="text/javascript" src="${root}static/js/jquery.liMarquee.js"></script>
    <script type="text/javascript" src="${root}static/js/jquery.cxselect.min.js"></script>
	<link rel="stylesheet" href="${root}static/css/comon0.css">
	<link type="text/css" rel="stylesheet" href="${root}static/css/style1.css" />
	<script type="text/javascript" src="${root}static/js/jquery-1.8.2.min.js"></script>
	
<style type="text/css">
 .evrday{
	    width:14%;     
		 float:left;
		 color:#fff;
		 }
 button{
	 width:25%;
	 height:40px;
	 float:left;
 }
  #calendar div{
	 margin-top:10px;
	 margin-bottom:5px;
	 text-align:center;
 }
#month{
width:50%;
float:left;
color:#fff;
}

</style>
</head>
<body onLoad="showday()" style="background:#000d4a;">
    <div style="background:#000d4a url(${root}static/images/bg.jpg) center top;background-size:100% 100%;">
        <%-- <div class="loading">
            <div class="loadbox"> <img src="${root}static/images/loading.gif"> 页面加载中... </div>
        </div> --%>
        <div class="back"></div>
        <div class="head">
            <div class="weather"><span id="showTime"></span></div>
            <h1>荣耀电子竞技管理系统</h1>
        </div>
        <script>
            var t = null;
            t = setTimeout(time, 1000);/*開始运行*/
            function time() {
                clearTimeout(t);/*清除定时器*/
                dt = new Date();
                var y = dt.getFullYear();
                var mt = dt.getMonth() + 1;
                var day = dt.getDate();
                var h = dt.getHours();
                var m = dt.getMinutes();
                var s = dt.getSeconds();
                document.getElementById("showTime").innerHTML = y + "年" + mt + "月" + day + "日" + h + "时" + m + "分" + s + "秒";
                t = setTimeout(time, 1000); 
            }

        </script>
        <div class="mainbox">
            <ul class="clearfix">
                <li>
                    <!-- <div class="boxall" style="height:400px;">
                        <div class="alltitle">个人数据堆叠图</div>
                        <div class="navboxall" id="echart5"></div>
                    </div> -->
                    <!-- 导入jsp -->
                    <%-- <div class="boxall" style="height:400px;">
                    	<jsp:include page="register.jsp"></jsp:include>
                    </div> --%>
                    
                    <form id="login">
                    <div  class="loginBox" style="height:400px;">
					  <h1>欢迎登陆</h1>
					  <div class="item">
					   <div class="icon"><img src="${root}static/images/icon4.png" /></div>
                          <select id="quanxian" name="quanxian" class="sel">
                              <option value="普通用户"><span>普通用户</span></option>                                    
                              <option value="投资商"><span>投资商</span></option>
                              <option value="管理员"><span>管理员</span></option>
                           </select>
					  </div>
					  <div class="item">
					    <div class="icon"><img src="${root}static/images/icon1.png" /></div>
					    <div class="txt"><input id="email" name="email" required="required"  type="text" placeholder="请输入您的邮箱"/></div>
					  </div>
					  <div class="item">
					    <div class="icon"><img src="${root}static/images/icon2.png" /></div>
					    <div class="txt"><input id="password" name="password" required="required" type="password" placeholder="请输入您的密码"/></div>
					    
					  </div>
					  <!-- <div class="item_2">
					    <input name="" type="checkbox" value="" />
					    <span>记住密码</span>
					    <a href="psd.html">忘记密码？</a>
					  </div>  -->
					  <div class="yz">
						 <input class="sryzm" type="text"  id="code_input" value="" placeholder="请输入验证码"/>
						 <div class="yzimg" id="v_container"></div>
						 <!-- <button id="my_button">验证</button> -->
					  </div>
					  <div class="item_3">
					    <input name="" id="my_button" type="submit" value="安全登录" class="btn"/>
					  </div>
					  <div class="item_4">
					    还没有账号？<a href="${root}qt/toregister.action">立即注册&nbsp;&nbsp;&nbsp;&nbsp;</a>
					    忘记密码？<a href="${root}qt/toupdate.action">找回密码</a>
					  </div>
					</div>
                    </form>             
                    
                    
<!-- ======================================================================================== -->
                    
                    <div class="boxall" style="height:260px;">
                        <div class="alltitle">英雄数据轮播图</div>
                        <div class="navboxall">
                            <div class="wraptit">
                                <span>用户名称</span><span>报名数</span><span>获胜数</span><span>获得奖金</span>
                            </div>
                            <div class="wrap">
                                <ul id="heropick">
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="boxall" style="height:260px;">
                        <div class="alltitle">夺冠种子选手</div>

                        <div class="navboxall" id="echart1"></div>
                    </div>
                </li>
                <li>
					<!-- 中间块 -->
                    <div class="boxall" style="height:230px">
                        <div class="clearfix navboxall" style="height: 100%">
                            
                            <div class="pulll_left zhibiao">
                                <div class="zb1"><span id="winratetop"></span><div id="zb1"></div></div>
                                <div class="zb2"><span id="killtop"></span><div id="zb2"></div></div>
                                <div class="zb3"><span id="ineyetop"></span><div id="zb3"></div></div>
                            </div>
                            <div class="pulll_right zhibiao " >
                                <div class="zb4"><span id="memberkilltop"></span><div id="zb4"></div></div>
                                <div class="zb5"><span id="memberdietop"></span><div id="zb5"></div></div>
                                <div class="zb6"><span id="memberkdatop"></span><div id="zb6"></div></div>
                            </div>
                        </div>
                    </div>
                    <div class="boxall" style="height:350px">
                        <div class="alltitle">用户参赛获胜总次数</div>
                        <div class="navboxall" id="echart4"></div>

                    </div>
                    <div class="boxall" style="height:340px">
                        <div class="alltitle">商家发布赛事数量</div>
                        <div class="navboxall" id="echart3" ></div>
                    </div>
                </li>
                <li>
                    <div class="boxall" style="height:300px">
                        <div class="alltitle">商家举办竞赛次数排行</div>
                        <div class="navboxall">
                            <table class="table1" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody id="wingstop5">
                                    <tr>
                                        <th scope="col" class="toptop">排名</th>
                                        <th scope="col">店铺名</th>
                                        <th scope="col">举办总次数</th>
                                    </tr>
                                    <tr>
                                        <td><span>1</span></td>
                                        <td></td>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td><span>2</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td><span>3</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>4</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>5</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="boxall" style="height: 300px">
                        <div class="alltitle">个人总获胜场次排行榜</div>
                        <div class="navboxall">
                            <table class="table1" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody id="membertop5">
                                    <tr>
                                        <th scope="col" class="toptop">排名</th>
                                        <th scope="col">队员</th>
                                        <!-- <th scope="col">位置</th> -->
                                        <th scope="col">总获胜场次</th>
                                    </tr>
                                    <tr>
                                        <td><span>1</span></td>
                                        <td></td>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td><span>2</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td><span>3</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>4</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>5</span></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="calendar" class="boxall" style="height:320px">
                        <!-- <div class="alltitle">MVP种子选手</div>
                        <div class="navboxall" id="echart2"></div> -->
                    	<div>
			       			<button onClick="shang()">上个月</button>
		         		<div id="month"></div>
			       			<button onClick="next()" id="nav">下个月</button>
				   		</div>
				   		<div>
						      <div class="evrday">日</div>
						      <div class="evrday">一</div>
						      <div class="evrday">二</div>
						      <div class="evrday">三</div>
						      <div class="evrday">四</div>
						      <div class="evrday">五</div>
						      <div class="evrday">六</div>
				   		</div>
				   
				   <div id="day" style="color:#0FF"></div>

                    </div>
                </li>
            </ul>
        </div>
    </div>
   
   <script src="${root}static/js/jquery.min.js"></script>
   <script src="${root}static/js/echarts.min.js" charset="utf-8"></script>
   <script src="${root}static/js/echarts-liquidfill.js"></script>
   <script src="${root}static/js/jquery.liMarquee.js"></script>
   <%-- <script type="text/javascript" src="${root}/static/js/js.js"></script> --%>
   <script type="text/javascript">

     $(window).load(function(){  

    	 $(function () {
    			wingstop4();
    		 	wingstop5();
    		    echarts_1();
    		    echarts_2();
    			echarts_3();
    			echarts_4();	
    			heropick60(); 
   /* =======================================轮播=================================================== */ 			
    			function heropick60() {
    			    $.ajax({
    			        url:'${root}keshihua/lunbo.action',
    			        data: {},
    			        type: 'POST',
    			        async: false,
    			        dataType:'json',
    			        success:function (data) {
    			        	 var name= [];
    			        	 var csnum= [];
    			        	 var winnum= [];
    			        	 var moneynum= [];
    			        	 //console.log(data.length);
    			        	 for(var i=0;i<data.length;i++){
    			        		 name[i]=data[i].name;
    			        		 csnum[i]=data[i].csnum;
    			        		 winnum[i]=data[i].winnum;
    			        		 moneynum[i]=data[i].moneynum;
    				        	 }
        			        console.log(data);


    			            $.each(name,function (i,item) {
    			                $("#heropick").append("<li><p><span>"+ item +"</span><span>"+csnum[i]+"</span><span>"+winnum[i]+"</span><span>"+moneynum[i]+"</span></p></li>");
    			            });
    			            $('.wrap,.adduser').liMarquee({
    			                direction: 'up',/*身上滚动*/
    			                runshort: false,/*内容不足时不滚动*/
    			                scrollamount: 20/*速度*/
    			            });
    			        },

    			    })
    			}
    			
    			
    			
/* ===========================================商家举办赛事数量排行============================================ */
    			function wingstop4() {
    			    $.ajax({
    			        url:'${root}keshihua/jubancishupaihang.action',
    			        type: 'POST',
    			        dataType:'json',
    			        success:function (data) {
    			            $("#wingstop5").children('tr').each(function (index,dom) {
    			                if (index != 0){
    			                    $(dom).children('td').eq(1).text(data[index-1].email);
    			                    $(dom).children('td').eq(2).text(data[index-1].count);
    			                }
    			            })
    			        },
    			        
    			    })
    			}

/*=========================================用户获胜场次总数量排行===================================================== */
    			function wingstop5() {
    			    $.ajax({
    			        url:'${root}keshihua/huoshengcishupaihang.action',
    			        type: 'POST',
    			        dataType:'json',
    			        success:function (data) {
    			            $("#membertop5").children('tr').each(function (index,dom) {
    			                if (index != 0){
    			                    $(dom).children('td').eq(1).text(data[index-1].email);
    			                    $(dom).children('td').eq(2).text(data[index-1].count);
    			                }
    			            })
    			        },
    			        
    			    })
    			}
    			
    	    
  /* =======================================用户参赛获胜次数最大================================================= */  			
		function echarts_1() {
	    	var myChart = echarts.init(document.getElementById('zb1'));
	    	$.ajax({  
		          url: '${root}keshihua/cansaiwinnummax.action' ,  
		          type: 'POST',  
		          dataType : 'json',
		          success: function(data){
		        	 var data1= [];
		        	 var data2= [];
		        	 //console.log(data.length);
		        	 for(var i=0;i<data.length;i++){
			        	 data1[i]=data[i].email;
			        	 data2[i]=data[i].count;
			        	 }
		        	  /* console.log(data1);
		        	  console.log(data2);
		        	  console.log(data); */
		        	  $("#winratetop").append(data1[0]+"<br>胜场最高");
		              $("#killtop").append(data1[1]+"<br>参赛最多");
		              $("#ineyetop").append(data1[2]+"<br>用户数量");
		              $("#memberkdatop").append(data1[3]+"<br>发布赛事最多");
		              $("#memberdietop").append(data1[4]+"<br>发布奖金最多");
		              $("#memberkilltop").append(data1[5]+"<br>总赛事数量");

		              round('zb1',0,data2[0],'#37A2DA','胜利场数','胜利场数','胜利场数');
		  	          round('zb2',0,data2[1],'#32C5E9','参赛数量','参赛数量','参赛数量');
		  	          round('zb3',0,data2[2],'#67E0E3','用户数量','用户数量','用户数量');
		  	          round('zb6',0,data2[3],'#FFDB5C','发布数量','发布数量','发布数量');
		              round('zb5',0,data2[4],'#9FE6B8','奖金总额','奖金总额','奖金总额');
		              round('zb4',0,data2[5],'#FB7293','赛事数量','赛事数量','赛事数量');
		              
				  }
		     });  
	    	
	    	//myChart.setOption(option);
    	}

    			function round(elm,data1,data2,clolr,str1,str2,str3) {
    		        // 基于准备好的dom，初始化echarts实例
    		        var myChart = echarts.init(document.getElementById(elm));
    			    var v2=data2//胜利
    				var v1=data1//战败
    				var v3=v1+v2//总消费 
    		        option = {
    		            tooltip: {
    		                trigger: 'item',
    		            },
    		            series: [{
    				
    		                type: 'pie',
    		                radius: ['60%', '70%'],
    		                color:clolr,
    		                label: {
    		                    normal: {
    		                    position: 'center'
    		                    }
    		                },
    		            data: [{
    		                value: v2,
    		                name: str1,
    		                label: {
    		                    normal: {
    		                        formatter: v2 +'',
    		                        textStyle: {
    		                            fontSize: 20,
    		                            color:'#fff',
    		                        }
    		                    }
    		                }
    		            }, {
    		                /* value: v1,
    		                name: str2, */
    		                label: {
    		                    normal: {
    		                        formatter : function (params){
    		                            return str3
    		                        },
    		                        textStyle: {
    		                            color: '#aaa',
    		                            fontSize: 12
    		                        }
    		                    }
    		                },
    		                itemStyle: {
    		                    normal: {
    		                        color: 'rgba(255,255,255,.2)'
    		                    },
    		                    emphasis: {
    		                        color: '#fff'
    		                    }
    		                },
    		            }]
    		            }]
    		        };
    		        myChart.setOption(option);
    		        window.addEventListener("resize",function(){
    		        myChart.resize();
    		        });
    		    }
    		
/* ===================================做下脚环状块图（夺冠种子选手）========================================== */
function echarts_2() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart1'));
        $.ajax({
	        url:'${root}keshihua/huoshengcishupaihang.action',
	        type: 'POST',
	        dataType:'json',
	        success:function (data) {
	        	var data1= [];
	        	 var data2= [];

	        	 //console.log(data.length);
	        	 for(var i=0;i<data.length;i++){
		        	 data1[i]=data[i].email;
		        	 data2[i]=data[i].count;
		        	 }

	        	 var obj = {};
	     		for(var i in data) {
	     			obj = {
	     				"value": data[i]['count'],
	     				"name": data[i]['email'],
	     			}
	     			data[i] = obj;
	     		}
	        	option = {
	                    tooltip : {
	                        trigger: 'item',
	                        formatter: "{b} : {c} ({d}%)"
	                    },
	                    legend: {
	                        right:0,
	                        top:30,
	                        height:160,
	                        itemWidth:10,
	                        itemHeight:10,
	                        itemGap:10,
	                        textStyle:{
	                            color: 'rgba(255,255,255,.6)',
	                            fontSize:12
	                        },
	                        orient:'vertical',
	                        data:data1
	                    },
	                   calculable : true,
	                    series : [
	                        {
	                            name:' ',
								color: ['#62c98d', '#2f89cf', '#4cb9cf', '#53b666', '#62c98d', '#205acf', '#c9c862', '#c98b62', '#c962b9', '#7562c9','#c96262','#c25775','#00b7be'],	
	                            type:'pie',
	                            radius : [30, 70],
	                            center : ['35%', '50%'],
	                            roseType : 'radius',
	                            label: {
	                                normal: {
	                                    show: true
	                                },
	                                emphasis: {
	                                    show: true
	                                }
	                            },

	                            lableLine: {
	                                normal: {
	                                    show: true
	                                },
	                                emphasis: {
	                                    show: true
	                                }
	                            },

	                            data:data
		                           
	                        },
	                    ]
	                };

	        myChart.setOption(option);
	        },
	        
	    })
        
    }

/* ===================================发布次数统计图================================================== */
    	    	
    	function echarts_3() {
    	var myChart = echarts.init(document.getElementById('echart3'));
        $.ajax({  
	          url: '${root}keshihua/fabucishu.action' ,  
	          type: 'POST',  
	          dataType : 'json',
	          success: function(data){
	        	 var data1= [];
	        	 var data2= [];
	        	 //console.log(data.length);
	        	 for(var i=0;i<data.length;i++){
		        	 data1[i]=data[i].email;
		        	 data2[i]=data[i].count;
		        	 }
	              option = {
					    xAxis: {
					    	axisLabel: {
					    	       show: true,
					    	        textStyle: {
					    	          color: '#46f4c1',  //更改坐标轴文字颜色
					    	          fontSize : 8      //更改坐标轴文字大小
					    	        },
					    	     },
				    	     axisLine:{
						         lineStyle:{
						            color:'#f3f7ff' //更改坐标轴颜色
						         }
						   },
					        type: 'category',
					        data: data1
					    },
					    yAxis: {
					    	splitLine: {
					            show: true,
					            lineStyle:{
					               color: ['#8fa3ec'],
					               width: 1,
					               type: 'solid'
					          }
					    　　},
					    	axisLabel: {
					    	       show: true,
					    	        textStyle: {
					    	          color: '#46f4c1',  //更改坐标轴文字颜色
					    	          fontSize : 10      //更改坐标轴文字大小
				    	        },
				    	     },
				    	     axisLine:{
						         lineStyle:{
						            color:'#f3f7ff' //更改坐标轴颜色
						         }
							   },
					        type: 'value'
					    },
					    series: [{
					        data: data2,
				            itemStyle: {
				              //渐变
				              normal: {
				                
				                // @ts-ignore
				                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
				                  { offset: 0, color: 'rgba(215,59,255,1)' },
				                  { offset: 0.6, color: 'rgba(66,70,175,1)' },
				                ]),
				              },
				            },
				            type: 'bar',
					        //color:'#4883c8',
					    }]
					};
	             
	      		myChart.setOption(option);
			  }
	     });  
    	}
  /* ======================================所有用户参赛获胜次数饼图============================================== */  	
    	function echarts_4() {
    		var myChart = echarts.init(document.getElementById('echart4'));
    		$.ajax({  
  	          url: '${root}keshihua/cansaiwinnum.action' ,  
  	          type: 'POST',  
  	          dataType : 'json',
  	          success: function(data){

  	        	var data = genData(data,data.length);

  	        	option = {
  	        	    title: {
  	        	    	 textStyle: {
  	        	              fontWeight: "normal",
  	        	              color: "#57c5d9", 
  	        	              fontSize: 20
  	        	            },
  	        	        //text: '用户参赛获胜总次数',
  	        	        //subtext: '',
  	        	        //left: 'center',
  	  	        	    
  	        	    },
  	        	    tooltip: {
  	        	        trigger: 'item',
  	        	        formatter: '{a} <br/>{b} : {c} ({d}%)'
  	        	    },
  	        	    legend: {
  	        	    	 textStyle: {
  	        	              fontWeight: "normal",
  	        	              color: "#e79d5c", 
  	        	              fontSize: 14
  	        	            },
  	        	        type: 'scroll',
  	        	        orient: 'vertical',
  	        	        right: 10,
  	        	        top: 20,
  	        	        bottom: 20,
  	        	        data: data.legendData,
  	        	        selected: data.selected
  	        	    },
  	        	    series: [
  	        	        {
  	        	            name: '邮箱',
  	        	            type: 'pie',
  	        	            radius: '50%',
  	        	            center: ['30%', '60%'],
  	        	            data: data.seriesData,
  	        	            emphasis: {
  	        	                itemStyle: {
  	        	                    shadowBlur: 10,
  	        	                    shadowOffsetX: 0,
  	        	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
  	        	                }
  	        	            }
  	        	        }
  	        	    ]
  	        	};
  	        	function genData(data,count) {
  	  	        	
  	        	    var legendData = [];
  	        	    var seriesData = [];
  	        	    for (var i = 0; i < count; i++) {
  	        	        var name = data[i].email;
  	        	        legendData.push(name);
  	        	        seriesData.push({
  	        	            name: name,
  	        	            value: data[i].count,
  	        	        });
  	        	    }

  	        	    return {
  	        	        legendData: legendData,
  	        	        seriesData: seriesData
  	        	    };
  	        	}
  	        	
  	        	/* ======================= */
  	      		myChart.setOption(option);
  			  }
  	     }); 
        }
    	
       });
         
     });
    </script>
    <!-- ================================================================================================= -->
    <!-- 验证码 -->
    <script>
    !(function(window, document) {
        function GVerify(options) { //创建一个图形验证码对象，接收options对象为参数
            this.options = { //默认options参数值
                id: "", //容器Id
                canvasId: "verifyCanvas", //canvas的ID
                width: "100%", //默认canvas宽度
                height: "30", //默认canvas高度
                type: "blend", //图形验证码默认类型blend:数字字母混合类型、number:纯数字、letter:纯字母
                code: ""
            }

            if(Object.prototype.toString.call(options) == "[object Object]"){//判断传入参数类型
                for(var i in options) { //根据传入的参数，修改默认参数值
                    this.options[i] = options[i];
                }
            }else{
                this.options.id = options;
            }

            this.options.numArr = "0,1,2,3,4,5,6,7,8,9".split(",");
            this.options.letterArr = getAllLetter();

            this._init();
            this.refresh();
        }

        GVerify.prototype = {
            /**版本号**/
            version: '1.0.0',

            /**初始化方法**/
            _init: function() {
                var con = document.getElementById(this.options.id);
                var canvas = document.createElement("canvas");
                this.options.width = con.offsetWidth > 0 ? con.offsetWidth : "100";
                this.options.height = con.offsetHeight > 0 ? con.offsetHeight : "30";
                canvas.id = this.options.canvasId;
                canvas.width = this.options.width;
                canvas.height = this.options.height;
                canvas.style.cursor = "pointer";
                canvas.innerHTML = "您的浏览器版本不支持canvas";
                con.appendChild(canvas);
                var parent = this;
                canvas.onclick = function(){
                    parent.refresh();
                }
            },

            /**生成验证码**/
            refresh: function() {
                this.options.code = "";
                var canvas = document.getElementById(this.options.canvasId);
                if(canvas.getContext) {
                    var ctx = canvas.getContext('2d');
                }else{
                    return;
                }

                ctx.textBaseline = "middle";

                ctx.fillStyle = randomColor(180, 240);
                ctx.fillRect(0, 0, this.options.width, this.options.height);

                if(this.options.type == "blend") { //判断验证码类型
                    var txtArr = this.options.numArr.concat(this.options.letterArr);
                } else if(this.options.type == "number") {
                    var txtArr = this.options.numArr;
                } else {
                    var txtArr = this.options.letterArr;
                }

                for(var i = 1; i <= 4; i++) {
                    var txt = txtArr[randomNum(0, txtArr.length)];
                    this.options.code += txt;
                    ctx.font = randomNum(this.options.height, this.options.height) + 'px SimHei'; //随机生成字体大小
                    ctx.fillStyle = randomColor(50, 160); //随机生成字体颜色
                    ctx.shadowOffsetX = randomNum(-3, 3);
                    ctx.shadowOffsetY = randomNum(-3, 3);
                    ctx.shadowBlur = randomNum(-3, 3);
                    ctx.shadowColor = "rgba(0, 0, 0, 0.3)";
                    var x = this.options.width / 5 * i;
                    var y = this.options.height / 2;
                    var deg = randomNum(-30, 30);
                    /**设置旋转角度和坐标原点**/
                    ctx.translate(x, y);
                    ctx.rotate(deg * Math.PI / 180);
                    ctx.fillText(txt, 0, 0);
                    /**恢复旋转角度和坐标原点**/
                    ctx.rotate(-deg * Math.PI / 180);
                    ctx.translate(-x, -y);
                }
                /**绘制干扰线**/
                for(var i = 0; i < 4; i++) {
                    ctx.strokeStyle = randomColor(40, 180);
                    ctx.beginPath();
                    ctx.moveTo(randomNum(0, this.options.width), randomNum(0, this.options.height));
                    ctx.lineTo(randomNum(0, this.options.width), randomNum(0, this.options.height));
                    ctx.stroke();
                }
                /**绘制干扰点**/
                for(var i = 0; i < this.options.width/4; i++) {
                    ctx.fillStyle = randomColor(0, 255);
                    ctx.beginPath();
                    ctx.arc(randomNum(0, this.options.width), randomNum(0, this.options.height), 1, 0, 2 * Math.PI);
                    ctx.fill();
                }
            },

            /**验证验证码**/
            validate: function(code){
                var code = code.toLowerCase();
                var v_code = this.options.code.toLowerCase();
                //console.log(v_code);
                if(code == v_code){
                    return true;
                }else{
                    this.refresh();
                    return false;
                }
            }
        }
        /**生成字母数组**/
        function getAllLetter() {
            var letterStr = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
            return letterStr.split(",");
        }
        /**生成一个随机数**/
        function randomNum(min, max) {
            return Math.floor(Math.random() * (max - min) + min);
        }
        /**生成一个随机色**/
        function randomColor(min, max) {
            var r = randomNum(min, max);
            var g = randomNum(min, max);
            var b = randomNum(min, max);
            return "rgb(" + r + "," + g + "," + b + ")";
        }
        window.GVerify = GVerify;
    })(window, document);
</script>
<script>
	var verifyCode = new GVerify("v_container");
    $("#login").submit(function(){
    	var quanxian=$("#quanxian").val();
    	var email=$("#email").val();
		var password=$("#password").val();
		var params="quanxian="+quanxian+"&"+"email="+email+"&"+"password="+password; 
    	/* document.getElementById("my_button").onclick = function(){ */
        var res = verifyCode.validate(document.getElementById("code_input").value);
        if(res){
        		/* var shijian=$("#shijian").val();
        		var zhiwei=$('input[type=radio][name=zhiwei]:checked').val() */
        		//console.log(params);
        		$.ajax({
        			   type: "POST",
        			   url: "${root}qt/login.action",
        			   data: params,
        			   success: function(msg){
        				   if(msg.code==1){
        					   $("#code_input").val("");
        					   $("#password").val("");
        					   window.location.href="${root}gly/toindex.action";
        					   }
        				   else if(msg.code==2){
        					   $("#code_input").val("");
        					   $("#password").val("");
        					   window.location.href="${root}ptyh/toindex.action";
        					   }
        				   else if(msg.code==3){
        					   $("#code_input").val("");
        					   $("#password").val("");
        					   window.location.href="${root}tzs/toindex.action";
        					   }
        				   else if(msg.code==-1){
        					   $("#code_input").val("");
        					   $("#password").val("");
        					   alert(msg.message);
        					   }
        				   else{
        					   $("#email").val("");
        					   $("#password").val("");
        					   alert(msg.message);
        					   verifyCode = new GVerify("v_container");
        					   }
        			   }
        			}); 		
        		
        		
        }else{
        	$("#code_input").val("");
            alert("验证码错误");
        }
    return false;
	});
</script>

<!--========================================================日历============================================  -->
<script>
      var today=new Date();//获取当前时间
	  var year=today.getFullYear();//获取当前的年份
	  var month=today.getMonth()+1;//获取当前月
	  var day=today.getDate();//获取当前月
	  var allday=0;
	  function showmonth(){
		  var year_month=year+"年"+month+"月";
		  document.getElementById("month").innerHTML=year_month;//显示当前的年月日
	  }
	
	  function count(){
		  if(month!=2)
		  {
		  if(month==4||month==6||month==9||month==11)//判断是否是相同天数的几个月，二月除外
		     allday=30;
			 else
			 allday=31;
		  }
		  else
		  {
			  if((year%4==0&&year%100!=0)||(year%400==0))//判断是否是闰年，进行相应的改变
			  allday=29;
			  else 
			  allday=28;}
	  }
	  //显示相应月份的天数
	  function showday(){	  
         showmonth()
		    count();
		  var fistdate=new Date(year,month-1,1);
		  var xinqi=fistdate.getDay();
		  var daterow=document.getElementById("day");
		  for(var i=0;i<xinqi;i++)//循环输出天数
		  {
			  var dayElement=document.createElement("div");
			    dayElement.className="evrday";
			 daterow.appendChild(dayElement);
		  }
		  
		  for(var j=1;j<=allday;j++)
		  {	
			  var dayElement=document.createElement("div");
			   dayElement.innerHTML=j;
			    dayElement.className="evrday";
				if(j==day)//当前日，标红
				 dayElement.style.color="red";
				daterow.appendChild(dayElement);
		  }
	  }
	   //点击下个月
	    function next(){
           document.getElementById('day').innerHTML ="";
          if(month<12)
		    {  month=month+1;
		    }
		      else
		       {  month=1;
		         year=year+1; 
		     }
		        document.getElementById('div').innerHTML =showday();    
		}
        //点击上个月
		function shang(){
           document.getElementById('day').innerHTML ="";
          if(month>1)
		      {month=month-1;
		      }
		      else
		      {
		         month=12;
		         year=year-1; 
		     }
		        document.getElementById('div').innerHTML =showday();    
		}

	 
	  </script>

    
    

</body>
</html>
