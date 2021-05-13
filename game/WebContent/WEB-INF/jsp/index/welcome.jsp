<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
/*   String path=request.getContextPath(); */
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath() + "/";
pageContext.setAttribute("root", basePath);
%>

<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${root}static/welcome/css/default.css"/> 
<link rel="stylesheet" type="text/css" href="${root}static/welcome/css/mobile.css"/>
<link rel='stylesheet' href='${root}static/welcome/css/jquery-ui.css'>
<script type="text/javascript" src="${root}static/welcome/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${root}static/welcome/js/common.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=no">
<title>荣耀电子竞技管理系统  </title>
</head>
<body>
    <div id="wrapper">
        <h1>荣耀电子竞技管理系统  </h1>
        <h2><strong>重点关注</strong><b class="logoline"></b><b class="logoline1"></b><b class="logoline2"></b><b class="logoline3"></b><b class="logoline4"></b></h2>
        <!--时间区-->
        <div class="date-timer">
           <p>
               <strong id="H"></strong>
               <strong>:</strong>
               <strong id="M"></strong>
               <strong id="S" class="hide"></strong>
           </p>
           <em id="D"></em>
            <ul>
                <li id="Y"></li>
                <li id="MH"></li>
                <li id="TD"></li>
            </ul>
        </div>
        <div class="big-index-1">
            <ul>
                <li>
                    <b class="animation-1"></b><b class="animation-2"></b><b class="animation-3"></b>
                    <p></p>
                    <strong></strong>
                </li>
                <li>
                    <b class="animation-1"></b><b class="animation-2"></b><b class="animation-3"></b>
                    <p></p>
                    <strong></strong>
                </li>
                <li>
                    <b class="animation-1"></b><b class="animation-2"></b><b class="animation-3"></b>
                    <p></p>
                    <strong></strong>
                </li>
                <li>
                    <b class="animation-1"></b><b class="animation-2"></b><b class="animation-3"></b>
                    <p></p>
                    <strong></strong>
                </li>
                <li>
                    <b class="animation-1"></b><b class="animation-2"></b><b class="animation-3"></b>
                    <p></p>
                    <strong></strong>
                </li>
                <li>
                    <b class="animation-1"></b><b class="animation-2"></b><b class="animation-3"></b>
                    <p></p>
                    <strong></strong>
                </li>
            </ul>
        </div>
        <div class="submenu">
            <ul>
                <li><a href="#this"><b>0</b><span><em></em></span></a> </li>
                <li><a href="#this"><b>0</b><span><em></em></span></a> </li>
                <li><a href="#this"><b>0</b><span><em></em></span></a> </li>
                <li><a href="#this"><b>0</b><span><em></em></span></a> </li>
            </ul>
        </div>
        <div class="center-area">
            <div class="pandect-area">
                <h3>
                    <p><sub></sub></p>
                    <strong>屏幕</strong>
                    <em></em>
                </h3>
                <span class="pandect-area-left">
                    <b></b>
                </span>
                <div class="pandect-area-center">
                    <h2 style="font-size: 32px;width:90%;height:30%;line-height:400%;text-align: center;color:#ed6741">欢迎使用荣耀电子竞技管理系统</h2>
                </div>
                <span class="pandect-area-right">
                    <b></b>
                </span>
            </div>
            <div class="details1-area">
                <span class="detailsl-area-left"></span>
                <div class="details1-area-center">
                <h3></h3>
                <dl>
                    <dt></dt>
                    <dd>
                        <ul>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li class="red"></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                        </ul>
                        
                    </dd>
                    <dt></dt>
                    <dd>
                        <ul>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="yellow"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                        </ul>
                        
                    </dd>
                    <dt> </dt>
                    <dd>
                        <ul>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li class="red"></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                        </ul>
                        
                    </dd>
                </dl>
                <b></b>
                </div>
                <span class="detailsl-area-right"></span>

            </div>
            <div class="details2-area">
                <span class="details2-area-left"></span>
                <div class="details2-area-center">
                    <h3></h3>
                    <dl>
                        <dt></dt>
                        <dd>
                            <ul>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li class="red"></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                            </ul>
                            
                        </dd>
                        <dt></dt>
                        <dd>
                            <ul>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="yellow"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                            </ul>
                            
                        </dd>
                        <dt> </dt>
                        <dd>
                            <ul>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li class="red"></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <li></li>
                            </ul>
                            
                        </dd>
                    </dl>
                    <b></b>
                </div>
                <span class="details2-area-right"></span>
            </div>
        </div>
        <div class="right-area">
            <h3> <b></b></h3>
            <div class="area-inbox-1">
                
                <div class="round-1"><div class="round-1" style="width:50px;height:50px"></div></div>
                <div class="round-2"></div>
                <div class="round-3">30%</div>
                <div class="round-4"></div>
            </div>
            <div class="area-inbox-2">
                    <ul>
                        <li><strong>12</strong>100%<b></b><em></em></li>
                        <li><strong>16</strong>100%<b></b><em></em></li>
                        <li><strong>18</strong>100%<b></b><em></em></li>
                    </ul>
                    <div class="area-text">
                        <b class="animation-line1"></b>
                        <h4>系统说明：</h4>
                        <p class="text_container">
                            <script>var s = '欢迎使用荣耀电子竞技管理系统，商家可以建立赛事，用户可以报名参赛'; var con = $('.text_container'); var index = 0; var length = s.length; var tId = null; function start(){ con.text(''); tId=setInterval(function(){ con.append(s.charAt(index)); if(index++ === length){ clearInterval(tId); index = 0; start() } },200); } start();</script>
                        </p>
                        <b class="animation-line2"></b>
                    </div>
            </div>
        </div>
        <div class="time-base-outer">
            <b class="line1"></b>
            <div class="time-base">
                 <div class="slider2"></div>
                <script src="${root}static/welcome/js/jquery_and_jqueryui.js"></script>
                <script src="${root}static/welcome/js/index.js"></script>
            </div>
            <b class="line2"></b>
        </div>
    </div>
</body>
</html>
