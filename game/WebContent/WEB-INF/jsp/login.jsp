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
</head>
<body style="background:#000d4a;">
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
					  </div> -->
					  <div class="yz">
						 <input class="sryzm" type="text"  id="code_input" value="" placeholder="请输入验证码"/>
						 <div class="yzimg" id="v_container"></div>
						 <!-- <button id="my_button">验证</button> -->
					  </div>
					  <div class="item_3">
					    <input name="" id="my_button" type="submit" value="安全登录" class="btn"/>
					  </div>
					  <div class="item_4">
					    还没有账号？<a href="${root}qt/toregister.action">立即注册</a>
					  </div>
					</div>
                    </form>
                    
                    <div class="boxall" style="height:260px;">
                        <div class="alltitle">英雄数据轮播图</div>
                        <div class="navboxall">
                            <div class="wraptit">
                                <span>英雄名称</span><span>场数</span><span>Pick率</span><span>胜率</span>
                            </div>
                            <div class="wrap">
                                <ul id="heropick">

                                </ul>
                            </div>

                        </div>
                    </div>
                    <div class="boxall" style="height:260px;">
                        <div class="alltitle">夺冠种子战队</div>

                        <div class="navboxall" id="echart1"></div>
                    </div>
                </li>
                <li>

                    <div class="boxall" style="height:230px">
                        <div class="clearfix navboxall" style="height: 100%">
<!--                            <div class="pulll_left num">-->
<!--                                <div class="numbt">总体情况<span>(单位：元)</span></div>-->
<!--                                <div class="numtxt">19382721 </div>-->
<!--                            </div>-->
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
                        <div class="alltitle"></div>
                        <div class="navboxall" id="echart4"></div>

                    </div>
                    <div class="boxall" style="height:340px">
                        <div class="alltitle"></div>
                        <div class="navboxall" id="echart3"></div>
                    </div>
                </li>
                <li>
                    <div class="boxall" style="height:300px">
                        <div class="alltitle"></div>
                        <div class="navboxall">
                            <table class="table1" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody id="wingstop5">
                                    <tr>
                                        <th scope="col" class="toptop">排名</th>
                                        <th scope="col">战队</th>
                                        <th scope="col">出场次数</th>
                                        <th scope="col">胜率</th>
                                    </tr>
                                    <tr>
                                        <td><span>1</span></td>
                                        <td></td>
                                        <td><br></td>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td><span>2</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td><span>3</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>4</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>5</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="boxall" style="height: 300px">
                        <div class="alltitle">个人排行榜</div>
                        <div class="navboxall">
                            <table class="table1" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody id="membertop5">
                                    <tr>
                                        <th scope="col" class="toptop">排名</th>
                                        <th scope="col">队员</th>
                                        <th scope="col">位置</th>
                                        <th scope="col">总击杀</th>
                                    </tr>
                                    <tr>
                                        <td><span>1</span></td>
                                        <td></td>
                                        <td><br></td>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td><span>2</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

                                    <tr>
                                        <td><span>3</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>4</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span>5</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="boxall" style="height:320px">
                        <div class="alltitle">MVP种子选手</div>
                        <div class="navboxall" id="echart2"></div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <%-- <script type="text/javascript" src="${root}/static/js/js.js"></script> --%>
   <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script type="text/javascript">

    $(window).load(function(){  
        $(".loading").fadeOut()
       })  

    </script> 
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
                console.log(v_code);
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
        		console.log(params);
        		$.ajax({
        			   type: "POST",
        			   url: "${root}qt/login.action",
        			   data: params,
        			   success: function(msg){
        				   if(msg.code==1){
        					   $("#code_input").val("");
        					   $("#password").val("");
        					   window.location.href="${root}ht/toindex.action";
        					   }
        				   else if(msg.code==2){
        					   $("#code_input").val("");
        					   $("#password").val("");
        					   window.location.href="${root}putonuser/toindex.action";
        					   }
        				   else if(msg.code==3){
        					   $("#code_input").val("");
        					   $("#password").val("");
        					   window.location.href="${root}touzishang/toindex.action";
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
    
    

</body>
</html>
