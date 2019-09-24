<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<title>主页</title>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link href="${pageContext.request.contextPath}/static/jquery.mobile-1.4.5/jquery.mobile-1.4.5.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery.mobile-1.4.5/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>
<script src="${pageContext.request.contextPath}/static/jquery/echarts-2.2.7/build/dist/echarts.js"></script>
<title>主页</title>
<script type="text/javascript">
	
	var myChart;////！！！！！！！这里一定要全局变量 ，因为在后面的refresh中用到了
	// 路径配置
	require.config({
	    paths: {
	        echarts: '${pageContext.request.contextPath}/static/jquery/echarts-2.2.7/build/dist'
	    }
	});
	// 使用
	require(
	    [
	        'echarts',
	        'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
	    ],
	    function (ec) {
	        // 基于准备好的dom，初始化echarts图表
	        myChart = ec.init(document.getElementById('first')); 
	        
	        var option = {
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
					orient : 'vertical',
					x : 'left',
					data:['计划产量','实际产量']
				},
				toolbox: {
					show : true,
					feature : {
						mark : {show: false},
						dataView : {show: true, readOnly: false},
						magicType : {
							show: false, 
							type: ['pie'],
							option: {
								funnel: {
									x: '10%',
									width: '20%',
									funnelAlign: 'center',
									max: 1000
								}
							}
						},
						restore : {show: false},
						saveAsImage : {show: false}
					}
				},
				calculable : true,
				series : [
					{
						name:'访问来源-数据库',
						type:'pie',
						radius : ['50%', '60%'],
						itemStyle : {
							normal : {
								label : {
									show : true
								},
								labelLine : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true,
									position : 'center',
									textStyle : {
										fontSize : '18',
										fontWeight : 'bold'
									}
								}
							}
						},
						data:[
								{name:"计划产量",value:'${addOrderList[0].number}'},
							    {name:"实际产量",value:'${addOrderList[0].finishNumber}'}
							 ]
						      
					}
				]
			};
	        // 为echarts对象加载数据 
	        myChart.setOption(option); 
	    }
	);
/*	//图标刷新
	function refresh(){			
		var arr=[];   
		///ajax获取数据
		$.ajax({
			type:"POST",
			url:"NumberOfProductServlet",
			async : false, //同步执行                	            		
			data:"action=play",//给服务器传数据
			dataType:"json",//返回数据形式为json
			success:function(result){          	
				if(result.success){            	     	            	            	            	            				
	    				arr.push({													
							name:"日计划产量",
							value:result.getresult[0].PlayOutput
						});
	    				arr.push({													
							name:"日实际产量",
							value:result.getresult[0].InfactOutput
						});
	    				           	 	            	            				
					}else{
						alert(result.errorMsg);
					}	
			},
			error:function(errorMsg){
				if(alert_count>2){
					return ;
				}
				alert_count++;
				alert("不好意思,图表请求数据失败啦!");
				return false;
				myChart.hideLoading();
			}
		});
		//更新数据       
		var option = myChart.getOption();            	
	    option.series[0].data =arr ;   
	    myChart.setOption(option); 
	} 
	////////////////函数60秒执行一次
	function autoRefresh()
	{
		refresh();
	}
	setInterval('autoRefresh()',60000);	
*/
</script>
<style type="text/css">
	#pie{
		box-shadow:-5px 5px 5px white;
	}
    #Equipment-HouseKeeper-images{
   		border-radius:8px 8px 8px 8px;
    }
</style>
</head>
<body>
	<div data-role="page">
		  <div data-role="header">
		    <a href="${pageContext.request.contextPath}/user/MaunfacturingStatistics.do" rel="external" data-role="button" data-icon="arrow-l" data-iconpos="notext"></a>
    			<h1>生产统计详情</h1>
    		<a href="#" data-role="button" data-icon="grid" data-iconpos="notext"></a>
		  </div>
		  
		  <div data-role="content" align="center">
		  		<table  width="100%" height="500" align="center" border="0" cellpadding="0" cellspacing="2" style="border-radius:0px;">
					<tr>
						<td bgcolor="#F6F6F6" align="center" >
							<div  style="height:320px; border:solid 1px black; width:380px;border-radius:8px 8px 8px 8px; background-color:white;">	
								<div style="height:20px;">
									<div style="float:left; padding-left:15px;"><img src="${pageContext.request.contextPath}/static/images/15.png"></div>	
									<div style="font-size:16px;font-weight:bold;float:left;margin-top:3px;">生产详情</div>	
								</div><hr style="border:solid 1px #F6F6F6">
								<div id="first" style="height:300px; width:380px; margin-top:5px;" >
									
								</div>			
							</div>
						</td>	
					</tr>
				
					<tr  style="height:40px;">
						<td align="center">
							<div  style="height:30px; border:solid 1px white; width:380px;border-radius:4px 4px 4px 4px; background-color:white;">	
								<label id="label1" value="开始时间" style="float:left; font-size:16px;">开始时间</label>	
								<label id="label2" value="开始时间" style="float:right;font-size:16px;">${addOrderList[0].dispatchingTime}</label>	
							</div>
						</td>
					</tr>
					
					<tr  style="height:40px;">
						<td align="center">
							<div  style="height:30px; border:solid 1px white; width:380px;border-radius:4px 4px 4px 4px; background-color:white;">	
								<label id="label1" value="开始时间" style="float:left; font-size:16px;">机器编号</label>	
								<label id="label2" value="开始时间" style="float:right;font-size:16px;">${addOrderList[0].macNum}</label>	
							</div>
						</td>
					</tr>
					
					<tr style="height:40px;">
						<td align="center">
							<div  style="height:30px; border:solid 1px white; width:380px;border-radius:4px 4px 4px 4pxs; background-color:white;">	
								<label id="label3" value="完成率" style="float:left; font-size:16px;">完成率</label>	
								<label id="label4" value="完成率" style="float:right;font-size:16px;">${addOrderList[0].finishNumber}/${addOrderList[0].number}</label>			
							</div>
						</td>
					</tr>
					
					<tr style="height:40px;">
						<td align="center">
							<div  style="height:30px; border:solid 1px white; width:380px;border-radius:4px 4px 4px 4pxs; background-color:white;">	
								<label id="label3" value="次品率" style="float:left; font-size:16px;">次品数/总数</label>	
								<label id="label4" value="次品率" style="float:right;font-size:16px;">${addOrderList[0].xDefectiveNum+addOrderList[0].zDefectiveNum+addOrderList[0].yDefectiveNum}/${addOrderList[0].finishNumber}</label>			
							</div>
						</td>
					</tr>
					
					
							
				</table>
				
		  </div>
		
		  <div data-role="footer" data-position="fixed">
		    	<div data-role="navbar">
				   <ul>
				       <li><a href="zhuye.jsp" rel="external" data-icon="home" data-mini="true">首页</a></li>
				       <li><a href="#" data-icon="search" data-mini="true">搜索</a></li>
				       <li><a href="#" data-icon="info" data-mini="true">消息</a></li>
				   </ul>
			  </div>
		  </div>
	</div>	
	
</body>


</html>