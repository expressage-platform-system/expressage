window.onload = function() {
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

    option = {
        title : {
            text: '订单完成量和完成金额',
            x: 'center'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['完成数量','完成金额'],
            x:'left'
        },
        toolbox: {
            show : true,
            feature : {
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'完成数量',
                type:'bar',
                data:[700, 600, 700, 850, 950, 650 , 835, 622, 326, 200, 624, 963],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            },
            {
                name:'完成金额',
                type:'bar',
                data:[2600.21, 3200.5, 2950, 2653.4, 2885.7, 3883.7, 1756.3, 1822.5, 4878.3, 2855.8, 6005.2, 2300],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            }
        ]
    };


// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);


//饼图：
{
    // 基于准备好的dom，初始化echarts实例
    let myChart = echarts.init(document.getElementById('main2'));

// 指定图表的配置项和数据
    let option = {
        title : {
            text: '最佳员工',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['王文楷','范闯','罗铭','其他']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'工时',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:30, name:'范闯'},
                    {value:30, name:'王文楷'},
                    {value:30, name:'罗铭'},
                    {value:10, name:'其他'},
                ]
            }
        ]
    };
// 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

};

