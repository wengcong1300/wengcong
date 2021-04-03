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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title>
        后台管理系统
    </title>
    <meta name="renderer" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="format-detection" content="telephone=no" />
    <link rel="stylesheet" href="${root}static/css/x-admin.css" media="all" />
    <link rel="stylesheet" href="${root}static/lib/bootstrap/css/bootstrap.css" media="all" />
</head>
<body>
<style type="text/css">
    legend { display: block; width:100px; border-bottom:0px; font-family: "Microsoft YaHei","Helvetica Neue";}
    legend a{ color:#666;} legend a:hover{ text-decoration:none;}
    .layui-table{ font-family: "Microsoft YaHei","Helvetica Neue";}
</style>
<div class="x-body">
    <blockquote class="layui-elem-quote">
        <sapn>${user.email }</sapn>欢迎使用荣耀电子竞技管理系统！
        &nbsp;&nbsp; 登陆时间：
        <span style="color: #FF5722; font-family: 'yjsz';font-size: 2rem">${shijian}</span>
    </blockquote>
    <div class="row">
        <div class="col-xs-6 col-sm-4 col-md-2">
            <section class="panel bgys">
                <div class="symbol bgcolor-blue ">
                    <i class="fa iconfont"></i>

                </div>
                <div class="value tab-menu" bind="1">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="学生总数"><i class="iconfont " data-icon=""></i> <h1>${countuser }</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="学生总数"> <i class="iconfont " data-icon=""></i><span>学生总数</span></a>
                </div>
            </section>


        </div>
        <div class="col-xs-6 col-sm-4 col-md-2 ">
            <section class="panel bgys">
                <div class="symbol bgcolor-commred">
                    <i class="fa fa-graduation-cap"></i>
                </div>
                <div class="value tab-menu" bind="1">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="学院总数"> <i class="iconfont " data-icon=""></i> <h1>${countcolleges}</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="学院总数"> <i class="iconfont " data-icon=""></i><span>学院总数</span></a>
                </div>
            </section>

        </div>
        <div class="col-xs-6 col-sm-4 col-md-2 ">
            <section class="panel bgys">
                <div class="symbol bgcolor-dark-green">
                    <i class="fa  fa-map-o"></i>
                </div>

                <div class="value tab-menu" bind="1">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="专业总数"> <i class="iconfont " data-icon=""></i> <h1>${countmajors}</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="专业总数"> <i class="iconfont " data-icon=""></i><span>专业总数</span></a>
                </div>

            </section>
        </div>
        <div class="col-xs-6 col-sm-4 col-md-2 ">
            <section class="panel bgys">
                <div class="symbol bgcolor-yellow-green">
                    <i class="fa fa-bar-chart"></i>
                </div>
                <div class="value tab-menu" bind="1">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="竞赛总数"> <i class="iconfont " data-icon=""></i> <h1>${countsetting}</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="竞赛总数"> <i class="iconfont " data-icon=""></i><span>竞赛总数</span></a>
                </div>
            </section>
        </div>

    </div>
    <fieldset class="layui-elem-field layui-field-title site-title">
        <legend><a name="default">数据统计</a></legend>
    </fieldset>
    <!--相关统计-->
    <div class="row">
        <!-- <div class="col-sm-4">
            <section class="panel">
                <div class="panel-heading">
                    一周统计
                </div>
                <div class="panel-body">
                    <div class="echarts" id="main" style="height:300px; height:350px"></div>
                    <div class="col-sm-6"></div>
                    <div class="col-sm-6"><div class="echarts" id="years" style="height:300px; height:350px"></div></div>
                </div>
            </section>
        </div>
        <div class="col-sm-4">
            <section class="panel">
                <div class="panel-heading">
                    文章类型统计
                </div>
                <div class="panel-body">
                    <div class="echarts" id="area" style="height:300px; height:350px"></div>
                </div>
            </section>
        </div>
        <div class="col-sm-4">
            <section class="panel">
                <div class="panel-heading">
                    文章年度统计
                </div>
                <div class="panel-body">
                    <div class="echarts" id="years" style="height:300px; height:350px"></div>
                </div>
            </section>
        </div> -->
        <div class="col-sm-12">
            <section class="panel">
                <div class="panel-heading">
                    服务器信息
                </div>
                <div class="panel-body">
                    <!--<div class="echarts" id="product" style="height:300px; height:350px"></div>-->
                    <table class="table table-border table-bordered table-bg mt-20">
                        <thead>
                        <tr>
                            <th colspan="4" scope="col">服务器信息</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>服务器计算机名</th>
                            <td><span id="lbServerName">http://127.0.0.1/</span></td>
                            <td>服务器IP地址</td>
                            <td>192.168.1.1</td>
                        </tr>
                        <tr>
                            <td>服务器域名</td>
                            <td>www.xxx.net</td>
                            <td>服务器端口 </td>
                            <td>80</td>
                        </tr>
                        <tr>
                            <td>服务器IIS版本 </td>
                            <td>Microsoft-IIS/6.0</td>
                            <td>本文件所在文件夹 </td>
                            <td>D:\WebSite\</td>
                        </tr>
                        <tr>
                            <td>服务器操作系统 </td>
                            <td>Microsoft Windows NT 5.2.3790 Service Pack 2</td>
                            <td>系统所在文件夹 </td>
                            <td>C:\WINDOWS\system32</td>
                        </tr>
                        <tr>
                            <td>服务器脚本超时时间 </td>
                            <td>30000秒</td>
                            <td>服务器的语言种类 </td>
                            <td>Chinese (People's Republic of China)</td>
                        </tr>
                        <tr>
                            <td>.NET Framework 版本 </td>
                            <td>2.050727.3655</td>
                            <td>服务器当前时间 </td>
                            <td>2019-6-14 12:06:23</td>
                        </tr>
                        <tr>
                            <td>服务器IE版本 </td>
                            <td>6.0000</td>
                            <td>服务器上次启动到现在已运行 </td>
                            <td>7210分钟</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </section>

            <div class="layui-footer footer footer-demo">
                <div class="layui-main">
                    
                </div>
            </div>

        </div>
    </div>
</div>

<script src="${root}static/lib/layui/layui.js" charset="utf-8"></script>
<script src="${root}static/js/echarts.min.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['资讯','图片','说说','管理员登陆记录']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        color: ['#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',

            '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',

            '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'],
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            //boundaryGap: false,
            data:["2018-02-26","2018-02-27","2018-02-28","2018-03-01","2018-03-02","2018-03-03","2018-03-04"]
        },
        yAxis: {
            type: 'value',
            //boundaryGap: false,
            //data:['1','2','3','4','5','6','7']
        },

        series: [
            {
                name:'资讯',
                type:'line',
                stack: '总量',

                data:[5,3,6,8,3,2,4]                },
            {
                name:'图片',
                type:'line',
                stack: '总量',
                data:[2,4,6,5,6,7,8]                },
            {
                name:'说说',
                type:'line',
                stack: '总量',
                data:[3,5,8,2,4,9,10]                },
            {
                name:'管理员登陆记录',
                type:'line',
                stack: '总量',
                data:[5,6,8,7,9,10,1]                }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 指定图表的配置项和数据
    var myChart = echarts.init(document.getElementById('area'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '分类文章数据统计',
            subtext: '文章总数',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        itemStyle: {

            normal: {

                //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，

                color: function(params) {

                    // build a color map as your need.

                    var colorList = [

                        '#f36f8a','#B5C334','#FCCE10','#E87C25','#27727B',

                        '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',

                        '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'

                    ];

                    return colorList[params.dataIndex]

                },

                //以下为是否显示，显示位置和显示格式的设置了

                label: {

                    show: true,

                    position: 'top',

//                             formatter: '{c}'

                    formatter: '{b}\n{c}'

                }

            }

        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['PHP', 'JavaScript', 'MySQL', 'jQuery', 'CSS', 'MUI', ]
        },
        series: [{

            name: '文章总数',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [

                {value: 19, name: 'PHP'} ,
                {value: 5, name: 'JavaScript'} ,
                {value: 6, name: 'MySQL'} ,
                {value: 10, name: 'jQuery'} ,
                {value: 8, name: 'CSS'} ,
                {value: 2, name: 'MUI'} ,

            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('years'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '文章年度统计',
            subtext: '纯属虚构',
            x: 'center'
        },
        //color: ['#3398DB'],

        tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
                type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            axisTick: {
                alignWithLabel: true
            }
        }],
        yAxis: [{
            type: 'value'
        }],
        series: [{
            name: '发布量',
            itemStyle: {

                normal: {

                    //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，

                    color: function(params) {

                        // build a color map as your need.

                        var colorList = [

                            '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',

                            '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',

                            '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'

                        ];

                        return colorList[params.dataIndex]

                    },

                    //以下为是否显示，显示位置和显示格式的设置了

                    label: {

                        show: true,

                        position: 'top',

//                             formatter: '{c}'

                        formatter: '{c}\n{b}'

                    }

                }

            },
            type: 'bar',
            barWidth: '60%',
            data: [10, 8, 12, 14, 10, 6, 8, 7, 15, 9, 5, 6]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>